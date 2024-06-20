/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Patient_DAO;
import com.mycompany.hospital.entity.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Patient_Resource {
    private static final Logger LOGGER = LoggerFactory.getLogger(Patient_Resource.class);
    private Patient_DAO patientDAO = new Patient_DAO();

    // Get all patients
    @GET
    public Response getAllPatients() {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            return Response.ok(patients).build();
        } catch (Exception ex) {
            LOGGER.error("Error occurred while retrieving all patients: {}", ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred while retrieving all patients").build();
        }
    }

    // Get a patient by ID
    @GET
    @Path("/{id}")
    public Response getPatientById(@PathParam("id") int id) {
        try {
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found with ID: " + id).build();
            }
        } catch (Exception ex) {
            LOGGER.error("Error occurred while retrieving patient with ID {}: {}", id, ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred while retrieving patient with ID " + id).build();
        }
    }

    // Add a new patient
    @POST
    public Response addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
            return Response.status(Response.Status.CREATED).entity("Patient added").build();
        } catch (Exception ex) {
            LOGGER.error("Error occurred while adding patient: {}", ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred while adding patient").build();
        }
    }

    // Update an existing patient
    @PUT
    @Path("/{id}")
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        try {
            Patient existingPatient = patientDAO.getPatientById(id);
            if (existingPatient != null) {
                updatedPatient.setId(id); // Set the ID of the updated patient
                patientDAO.updatePatient(id, updatedPatient); // Update the patient
                return Response.ok().entity("Patient updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found with ID: " + id).build();
            }
        } catch (Exception ex) {
            LOGGER.error("Error occurred while updating patient with ID {}: {}", id, ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred while updating patient with ID " + id).build();
        }
    }   

    // Delete a patient by ID
    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try {
            patientDAO.deletePatient(id);
            return Response.ok().entity("Patient deleted").build();
        } catch (Exception ex) {
            LOGGER.error("Error occurred while deleting patient with ID {}: {}", id, ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred while deleting patient with ID " + id).build();
        }
    }
}
