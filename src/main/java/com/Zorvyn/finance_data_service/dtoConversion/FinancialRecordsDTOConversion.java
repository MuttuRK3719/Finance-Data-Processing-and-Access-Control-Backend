package com.Zorvyn.finance_data_service.dtoConversion;

import com.Zorvyn.finance_data_service.dto.request.CreateRecordRequest;
import com.Zorvyn.finance_data_service.dto.request.UpdateRecordRequest;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.entities.FinancialRecord;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface FinancialRecordsDTOConversion {

    RecordResponse mapFinancialRecordToRecordResponse(FinancialRecord record);

    FinancialRecord mapCreateRecordRequestToFinancialRecord(CreateRecordRequest request);

    FinancialRecord mapUpdateRecordRequestToFinancialRecord(UpdateRecordRequest updateRecordRequest,
                                                            @MappingTarget  FinancialRecord financialRecord);
}
