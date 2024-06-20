/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.entity;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

public class Prescription {
    private int id;
    private String patientName;
    private String medication;
    private String dosage;

    public Prescription() {
        // Default constructor required for deserialization
    }

    public Prescription(int id, String medication, String dosage, String patientName) {
        this.id = id;
        this.patientName = patientName;
        this.medication = medication;
        this.dosage = dosage;
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

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }
}
