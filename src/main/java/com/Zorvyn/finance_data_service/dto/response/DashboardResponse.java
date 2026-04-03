package com.Zorvyn.finance_data_service.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class DashboardResponse {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;
    private Map<String, Double> categoryWiseTotals;
    private List<RecordResponse> recentActivity;
}
