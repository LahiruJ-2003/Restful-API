/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.entity;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

public class Doctor extends Person {
    private String specialization;

    public Doctor() {
        // Default constructor required for deserialization
    }

    public Doctor(int id, String name, String contactInfo, String address, String specialization) {
        super(id, name, contactInfo, address);
        this.specialization = specialization;
    }

    // Getters and Setters
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
