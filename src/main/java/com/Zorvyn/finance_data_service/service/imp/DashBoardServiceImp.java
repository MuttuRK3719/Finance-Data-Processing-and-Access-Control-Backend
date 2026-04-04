package com.Zorvyn.finance_data_service.service.imp;

import com.Zorvyn.finance_data_service.dto.response.DashboardResponse;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.service.DashboardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class DashBoardServiceImp implements DashboardService {
    @Override
    public BigDecimal getTotalIncome() {
        return null;
    }

    @Override
    public BigDecimal getTotalExpense() {
        return null;
    }

    @Override
    public BigDecimal getNetBalance() {
        return null;
    }

    @Override
    public Map<String, BigDecimal> getCategoryWiseTotals() {
        return Map.of();
    }

    @Override
    public List<RecordResponse> getRecentActivity() {
        return List.of();
    }

    @Override
    public DashboardResponse getFullSummary() {
        return null;
    }
}
