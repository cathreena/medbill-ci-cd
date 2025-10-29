package com.example.demo.model;

public class Bill {
    private int id;
    private String patientName;
    private String treatment;
    private double amount;

    public Bill() {}

    public Bill(int id, String patientName, String treatment, double amount) {
        this.id = id;
        this.patientName = patientName;
        this.treatment = treatment;
        this.amount = amount;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}
