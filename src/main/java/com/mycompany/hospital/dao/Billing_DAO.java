/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Billing;

import java.util.ArrayList;
import java.util.List;

public class Billing_DAO {
    // List to store mock billing data
    private static List<Billing> bills = new ArrayList<>();

    // Add some mock data
    static {
        bills.add(new Billing(1, "John Doe", 100.0, true));
        bills.add(new Billing(2, "Jane Smith", 150.0, false));
    }

    // Method to get all bills
    public List<Billing> getAllBills() {
        return bills;
    }

    // Method to get a bill by ID
    public Billing getBillById(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                return bill;
            }
        }
        return null; // Return null if bill not found
    }

    // Method to add a new bill
    public void addBill(Billing bill) {
        bills.add(bill);
    }

    // Method to update an existing bill
    public void updateBill(int id, Billing updatedBill) {
        for (int i = 0; i < bills.size(); i++) {
            if (bills.get(i).getId() == id) {
                updatedBill.setId(id); // Set the ID of the updated bill
                bills.set(i, updatedBill);
                return; // Exit loop once bill is updated
            }
        }
    }

    // Method to delete a bill by ID
    public void deleteBill(int id) {
        bills.removeIf(bill -> bill.getId() == id);
    }

    // Method to mark a bill as paid
    public void markBillAsPaid(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                bill.setPaid(true);
                return;
            }
        }
    }

    // Method to mark a bill as unpaid
    public void markBillAsUnpaid(int id) {
        for (Billing bill : bills) {
            if (bill.getId() == id) {
                bill.setPaid(false);
                return;
            }
        }
    }
}
