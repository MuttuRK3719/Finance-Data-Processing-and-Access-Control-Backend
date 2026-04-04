package com.Zorvyn.finance_data_service.service;

import com.Zorvyn.finance_data_service.dto.response.DashboardResponse;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface DashboardService {
    BigDecimal getTotalIncome();
    BigDecimal getTotalExpense();
    BigDecimal getNetBalance();
    Map<String, BigDecimal> getCategoryWiseTotals();
    List<RecordResponse> getRecentActivity();
    DashboardResponse getFullSummary();

}
