/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Medical_Record_DAO;
import com.mycompany.hospital.entity.Medical_Record;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/medical-records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Medical_Record_Resource {
    private static final Logger LOGGER = Logger.getLogger(Medical_Record_Resource.class.getName());
    private final Medical_Record_DAO medicalRecordDAO = new Medical_Record_DAO();

    // Get all medical records
    @GET
    public Response getAllMedicalRecords() {
        try {
            List<Medical_Record> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            return Response.ok(medicalRecords).build();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving medical records", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Get medical record by ID
    @GET
    @Path("/{id}")
    public Response getMedicalRecordById(@PathParam("id") int id) {
        try {
            Medical_Record medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecord != null) {
                return Response.ok(medicalRecord).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found with ID: " + id).build();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while retrieving medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Add a new medical record
    @POST
    public Response addMedicalRecord(Medical_Record medicalRecord) {
        try {
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            return Response.status(Response.Status.CREATED).entity("Medical record added").build();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while adding medical record", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Update an existing medical record
    @PUT
    @Path("/{id}")
    public Response updateMedicalRecord(@PathParam("id") int id, Medical_Record updatedMedicalRecord) {
        try {
            Medical_Record existingMedicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            if (existingMedicalRecord != null) {
                updatedMedicalRecord.setId(id); // Set the ID of the updated medical record
                medicalRecordDAO.updateMedicalRecord(id, updatedMedicalRecord);
                return Response.ok().entity("Medical record updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found with ID: " + id).build();
            }
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while updating medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Delete a medical record by ID
    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") int id) {
        try {
            medicalRecordDAO.deleteMedicalRecord(id);
            return Response.ok().entity("Medical record deleted").build();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error occurred while deleting medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }
}
