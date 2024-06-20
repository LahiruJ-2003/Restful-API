/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Doctor;

import java.util.ArrayList;
import java.util.List;

public class Doctor_DAO {
    // List to store mock doctor data
    private static List<Doctor> doctors = new ArrayList<>();

    // Add some mock data
    static {
        doctors.add(new Doctor(3, "Dr. Smith", "smith@example.com", "123 Main St", "Cardiologist"));
        doctors.add(new Doctor(4, "Dr. Johnson", "johnson@example.com", "456 Elm St", "Pediatrician"));
    }

    // Method to retrieve all doctors
    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    // Method to retrieve a doctor by ID
    public Doctor getDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null; // Return null if doctor not found
    }

    // Method to add a new doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Method to update an existing doctor
    public void updateDoctor(int id, Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == id) {
                updatedDoctor.setId(id); // Set the ID of the updated doctor
                doctors.set(i, updatedDoctor); // Update the doctor
                return; // Exit loop once doctor is updated
            }
        }
    }

    // Method to delete a doctor by ID
    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getId() == id);
    }
}

