package com.Zorvyn.finance_data_service.controller;

import com.Zorvyn.finance_data_service.dto.response.DashboardResponse;
import com.Zorvyn.finance_data_service.dto.response.RecordResponse;
import com.Zorvyn.finance_data_service.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dashboard/v1")
@RequiredArgsConstructor
public class DashboardController {
    private final DashboardService dashboardService;

    @GetMapping("/totalIncome")
    public ResponseEntity<BigDecimal> getTotalIncome() {
        return ResponseEntity.ok().body(dashboardService.getTotalIncome());
    }

    @GetMapping("/totalExpense")
    public ResponseEntity<BigDecimal> getTotalExpense() {
        return ResponseEntity.ok().body(dashboardService.getTotalExpense());
    }

    @GetMapping("/getNetBalance")
    public ResponseEntity<BigDecimal> getNetBalance() {
        return ResponseEntity.ok().body(dashboardService.getNetBalance());
    }

    @GetMapping("/getCategoryWiseTotals")
    public ResponseEntity<Map<String, Double>> getCategoryWiseTotals() {
        Map<String, Double> categoryWiseTotals = dashboardService.getCategoryWiseTotals();
        return ResponseEntity.ok().body(categoryWiseTotals);
    }

    @GetMapping("/getRecentActivity")
    public ResponseEntity<List<RecordResponse>> getRecentActivity() {
        List<RecordResponse> recentActivity = dashboardService.getRecentActivity();
        return ResponseEntity.ok().body(recentActivity);
    }

    @GetMapping("/getFullSummary")
    public ResponseEntity<DashboardResponse> getFullSummary() {
        return ResponseEntity.ok().body(dashboardService.getFullSummary());
    }
}
