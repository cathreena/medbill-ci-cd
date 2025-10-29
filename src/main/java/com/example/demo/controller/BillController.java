package com.example.demo.controller;

import com.example.demo.model.Bill;
import com.example.demo.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping
    public List<Bill> getAll() {
        return billService.getAll();
    }

    @PostMapping
    public String addBill(@RequestBody Bill bill) {
        billService.addBill(bill);
        return "Bill added successfully for patient: " + bill.getPatientName();
    }
}
