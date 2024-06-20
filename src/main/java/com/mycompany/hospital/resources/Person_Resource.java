/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Doctor_DAO;
import com.mycompany.hospital.dao.Patient_DAO;
import com.mycompany.hospital.entity.Doctor;
import com.mycompany.hospital.entity.Patient;
import com.mycompany.hospital.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Person_Resource {
    private final Patient_DAO patientDAO = new Patient_DAO();
    private final Doctor_DAO doctorDAO = new Doctor_DAO();
    private static final Logger logger = LoggerFactory.getLogger(Person_Resource.class);

    /**
     * Endpoint to retrieve all persons (patients and doctors).
     * @return List of all persons
     */
    @GET
    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList<>();
        
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            allPersons.addAll(patients);
            
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            allPersons.addAll(doctors);
        } catch (Exception e) {
            logger.error("Error occurred while retrieving all persons: {}", e.getMessage());
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }

        return allPersons;
    }

    /**
     * Endpoint to retrieve a person by ID.
     * @param id ID of the person to retrieve
     * @return Response containing the person object or 404 if not found
     */
    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") int id) {
        try {
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                return Response.ok(patient).build();
            }

            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                return Response.ok(doctor).build();
            }
        } catch (Exception e) {
            logger.error("Error occurred while retrieving person with ID {}: {}", id, e.getMessage());
            throw new WebApplicationException("Internal Server Error", Response.Status.INTERNAL_SERVER_ERROR);
        }

        logger.warn("Person not found with ID: {}", id);
        return Response.status(Response.Status.NOT_FOUND).entity("Person not found with ID: " + id).build();
    }
}
