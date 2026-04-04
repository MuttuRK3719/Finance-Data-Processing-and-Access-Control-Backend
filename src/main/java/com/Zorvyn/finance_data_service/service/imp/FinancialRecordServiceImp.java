package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.dtoConversion.FinancialRecordsDTOConversion;
import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import com.Zorvyn.finance_data_service.entities.User;
import com.Zorvyn.finance_data_service.enums.TransactionType;
import com.Zorvyn.finance_data_service.exceptions.NoRecordExists;
import com.Zorvyn.finance_data_service.exceptions.UserNotFound;
import com.Zorvyn.finance_data_service.repository.FinancialRecordRepository;
import com.Zorvyn.finance_data_service.repository.UserRepository;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FinancialRecordServiceImp implements FinancialRecordService {
    @Value("${record.not.found}")
    String recordNotFound;
    private final UserRepository userRepository;
    private final FinancialRecordsDTOConversion recordMapper;
    private final FinancialRecordRepository financialRecordRepository;

    @Override
    public RecordResponse createRecord(CreateRecordRequest request, String requestedByEmail) {
        if (!userRepository.existsByEmail(requestedByEmail))
            throw new UserNotFound(String.format("No such user exists with email : %s", requestedByEmail));
        Optional<User> user = userRepository.findByEmail(requestedByEmail);
        FinancialRecord record = recordMapper.mapCreateRecordRequestToFinancialRecord(request);
        record.setUser(user.get());
        Optional<FinancialRecord> respondedRecord = Optional.of(financialRecordRepository.save(record));
        return recordMapper.mapFinancialRecordToRecordResponse(respondedRecord.get());
    }

    @Override
    public RecordResponse getRecordById(Long id) {
        FinancialRecord record=financialRecordRepository.
                findById(id).
                orElseThrow(()->new NoRecordExists(String.format(recordNotFound,id)));

        return recordMapper.mapFinancialRecordToRecordResponse(record);
    }

    public List<RecordResponse> getAllRecords(TransactionType type,
                                              String category,
                                              LocalDate startDate,
                                              LocalDate endDate) {

        Specification<FinancialRecord> spec = Specification
                .where(FinancialRecordSpecification.hasType(type))
                .and(FinancialRecordSpecification.hasCategory(category))
                .and(FinancialRecordSpecification.dateBetween(startDate, endDate));

        List<FinancialRecord> records = financialRecordRepository.findAll(spec);

        return records.stream()
                .map(recordMapper::mapFinancialRecordToRecordResponse)
                .toList();
    }


    @Override
    public RecordResponse updateRecord(Long id, UpdateRecordRequest request) {
        FinancialRecord record=financialRecordRepository.
                findById(id).
                orElseThrow(()->new NoRecordExists(String.format(recordNotFound,id)));
        FinancialRecord updatedRecord= recordMapper.mapUpdateRecordRequestToFinancialRecord(request,record);
        financialRecordRepository.save(updatedRecord);
        return  recordMapper.mapFinancialRecordToRecordResponse(updatedRecord);
    }

    @Override
    public void deleteRecord(Long id, String requestedByEmail) {
        FinancialRecord record=financialRecordRepository.
                findById(id).
                orElseThrow(()->new NoRecordExists(String.format(recordNotFound,id)));
        financialRecordRepository.deleteById(id);
    }
}
