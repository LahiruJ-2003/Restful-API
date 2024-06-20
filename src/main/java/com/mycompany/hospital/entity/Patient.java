/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.entity;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Person;

public class Patient extends Person {
    private String medicalHistory;
    private String healthStatus;

    public Patient() {
        // Default constructor required for deserialization
    }

    public Patient(int id, String name, String contactInfo, String address, String medicalHistory, String healthStatus) {
        super(id, name, contactInfo, address);
        this.medicalHistory = medicalHistory;
        this.healthStatus = healthStatus;
    }

    // Getters and Setters
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
