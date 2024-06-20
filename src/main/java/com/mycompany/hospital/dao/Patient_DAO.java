/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Patient;

import java.util.ArrayList;
import java.util.List;

public class Patient_DAO {
    // List to store mock patient data
    private static List<Patient> patients = new ArrayList<>();

    // Add some mock data
    static {
        patients.add(new Patient(1, "John Doe", "john@example.com", "123 Main St", "Allergic to peanuts", "Stable"));
        patients.add(new Patient(2, "Jane Smith", "jane@example.com", "456 Elm St", "No major health issues", "Good"));
    }

    // Method to get all patients
    public List<Patient> getAllPatients() {
        return patients;
    }

    // Method to get a patient by ID
    public Patient getPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null; // Return null if patient not found
    }

    // Method to add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Method to update an existing patient
    public void updatePatient(int id, Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == id) {
                updatedPatient.setId(id); // Set the ID of the updatedPatient
                patients.set(i, updatedPatient);
                return; // Exit loop once patient is updated
            }
        }
    }

    // Method to delete a patient by ID
    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getId() == id);
    }
}
