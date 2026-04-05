package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.dto.response.DashboardResponse;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.dtoConversion.FinancialRecordsDTOConversion;
import com.Zorvyn.finance_data_service.enums.RecordType;
import com.Zorvyn.finance_data_service.repository.FinancialRecordRepository;
import com.Zorvyn.finance_data_service.repository.UserRepository;
import com.Zorvyn.finance_data_service.service.DashboardService;
import com.Zorvyn.finance_data_service.service.FinancialRecordService;
import com.Zorvyn.finance_data_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class DashBoardServiceImp implements DashboardService {
    UserService userService;
    FinancialRecordService financialRecordService;
    private final FinancialRecordRepository financialRecordRepository;
    UserRepository userRepository;
    final FinancialRecordsDTOConversion mappers;

    @Override
    public BigDecimal getTotalIncome() {
        return  financialRecordRepository.sumByTransactionType(RecordType.INCOME);
    }

    @Override
    public BigDecimal getTotalExpense() {
        return  financialRecordRepository.sumByTransactionType(RecordType.EXPENSE);
    }

    @Override
    public BigDecimal getNetBalance() {
        return getTotalIncome().subtract(getTotalExpense());
    }

    @Override
    public Map<String, Double> getCategoryWiseTotals() {

        return financialRecordRepository.
                groupByCategoryRaw().
                stream().
                collect(Collectors.toMap(
                        result->(String)result[0],
                        result-> (double)result[1]
                ));
    }

    @Override
    public List<RecordResponse> getRecentActivity() {

        return financialRecordRepository
                .findByDateAfter(
                        LocalDate.now().minusMonths(2))
                .stream()
                .map(mappers::mapFinancialRecordToRecordResponse).toList();
    }

    @Override
    public DashboardResponse getFullSummary() {
        DashboardResponse dashboardResponse=new DashboardResponse();
        dashboardResponse.setNetBalance(getNetBalance());
        dashboardResponse.setTotalIncome(getTotalIncome());
        dashboardResponse.setTotalExpense(getTotalExpense());
        dashboardResponse.setRecentActivity(getRecentActivity());
        dashboardResponse.setCategoryWiseTotals(getCategoryWiseTotals());
        return null;
    }
}
