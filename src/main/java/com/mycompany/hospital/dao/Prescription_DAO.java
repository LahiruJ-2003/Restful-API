/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Prescription;

import java.util.ArrayList;
import java.util.List;

public class Prescription_DAO {
    // List to store mock prescription data
    private static List<Prescription> prescriptions = new ArrayList<>();

    // Add some mock data
    static {
        prescriptions.add(new Prescription(1, "Paracetamol", "Take one tablet twice a day", "John Doe"));
        prescriptions.add(new Prescription(2, "Amoxicillin", "Take one capsule three times a day", "Jane Smith"));
    }

    // Method to get all prescriptions
    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    // Method to get a prescription by ID
    public Prescription getPrescriptionById(int id) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getId() == id) {
                return prescription;
            }
        }
        return null; // Return null if prescription not found
    }

    // Method to add a new prescription
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Method to update an existing prescription
    public void updatePrescription(int id, Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            if (prescriptions.get(i).getId() == id) {
                updatedPrescription.setId(id); // Set the ID of the updated prescription
                prescriptions.set(i, updatedPrescription);
                return; // Exit loop once prescription is updated
            }
        }
    }

    // Method to delete a prescription by ID
    public void deletePrescription(int id) {
        prescriptions.removeIf(prescription -> prescription.getId() == id);
    }
}
