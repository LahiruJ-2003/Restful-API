/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.entity;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

public class Billing {
    private int id;
    private String patientName;
    private double amount;
    private boolean paid;

    public Billing() {
        // Default constructor required for deserialization
    }

    public Billing(int id, String patientName, double amount, boolean paid) {
        this.id = id;
        this.patientName = patientName;
        this.amount = amount;
        this.paid = paid;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
