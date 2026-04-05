package com.Zorvyn.finance_data_service.dtoConversion;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FinancialRecordsDTOConversion {

    @Mapping(source = "user.name", target = "createdByName")
    RecordResponse mapFinancialRecordToRecordResponse(FinancialRecord record);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    FinancialRecord mapCreateRecordRequestToFinancialRecord(CreateRecordRequest request);

    // 🔥 FIX HERE
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    FinancialRecord mapUpdateRecordRequestToFinancialRecord(
            UpdateRecordRequest updateRecordRequest,
            @MappingTarget FinancialRecord financialRecord);
}
