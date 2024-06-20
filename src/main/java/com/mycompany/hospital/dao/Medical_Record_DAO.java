/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Medical_Record;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Medical_Record_DAO {
    private static final Logger LOGGER = Logger.getLogger(Medical_Record_DAO.class.getName());
    // List to store mock medical record data
    private static List<Medical_Record> medicalRecords = new ArrayList<>();

    // Add some mock data
    static {
        medicalRecords.add(new Medical_Record(1, "John Doe", "Heart condition", "High blood pressure"));
        medicalRecords.add(new Medical_Record(2, "Jane Smith", "Asthma", "Allergy to penicillin"));
    }

    // Method to get all medical records
    public List<Medical_Record> getAllMedicalRecords() {
        return medicalRecords;
    }

    // Method to get a medical record by ID
    public Medical_Record getMedicalRecordById(int id) {
        for (Medical_Record medicalRecord : medicalRecords) {
            if (medicalRecord.getId() == id) {
                return medicalRecord;
            }
        }
        return null; // Return null if medical record not found
    }

    // Method to add a new medical record
    public void addMedicalRecord(Medical_Record medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    // Method to update an existing medical record
    public void updateMedicalRecord(int id, Medical_Record updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getId() == id) {
                updatedMedicalRecord.setId(id); // Set the ID of the updated medical record
                medicalRecords.set(i, updatedMedicalRecord);
                return; // Exit loop once medical record is updated
            }
        }
    }

    // Method to delete a medical record by ID
    public void deleteMedicalRecord(int id) {
        medicalRecords.removeIf(medicalRecord -> medicalRecord.getId() == id);
    }
}
