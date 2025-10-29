package com.example.demo.service;

import com.example.demo.model.Bill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BillService {
    private final List<Bill> bills = new ArrayList<>();

    public List<Bill> getAll() {
        return bills;
    }

    public void addBill(Bill bill) {
        bills.add(bill);
    }
}
