/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.dao;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing Person entities.
 * Provides methods to perform CRUD operations on Person entities.
 */
public class Person_DAO {
    // List to store mock person data
    private static List<Person> persons = new ArrayList<>();

    // Add some mock data
    static {
        persons.add(new Person(1, "John Doe", "123-456-7890", "123 Main St"));
        persons.add(new Person(2, "Jane Smith", "456-789-0123", "456 Oak St"));
    }

    /**
     * Retrieves all persons.
     * @return List of all persons
     */
    public List<Person> getAllPersons() {
        return persons;
    }

    /**
     * Retrieves a person by ID.
     * @param id The ID of the person to retrieve
     * @return The person with the specified ID, or null if not found
     */
    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null; // Return null if person not found
    }

    /**
     * Adds a new person.
     * @param person The person to add
     */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /**
     * Updates an existing person.
     * @param id The ID of the person to update
     * @param updatedPerson The updated person object
     */
    public void updatePerson(int id, Person updatedPerson) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getId() == id) {
                updatedPerson.setId(id); // Set the ID of the updated person
                persons.set(i, updatedPerson);
                return; // Exit loop once person is updated
            }
        }
    }

    /**
     * Deletes a person by ID.
     * @param id The ID of the person to delete
     */
    public void deletePerson(int id) {
        persons.removeIf(person -> person.getId() == id);
    }
}
