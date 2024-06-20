/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Prescription_DAO;
import com.mycompany.hospital.entity.Prescription;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/prescriptions")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Prescription_Resource {
    private static final Logger logger = Logger.getLogger(Prescription_Resource.class.getName());
    private Prescription_DAO prescriptionDAO = new Prescription_DAO();

    @GET
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving all prescriptions", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getPrescriptionById(@PathParam("id") int id) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(id);
            if (prescription != null) {
                return Response.ok(prescription).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            return Response.status(Response.Status.CREATED).entity("Prescription added").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while adding a prescription", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription) {
        try {
            Prescription existingPrescription = prescriptionDAO.getPrescriptionById(id);
            if (existingPrescription != null) {
                updatedPrescription.setId(id); // Set the ID of the updated prescription
                prescriptionDAO.updatePrescription(id, updatedPrescription);
                return Response.ok().entity("Prescription updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while updating prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            prescriptionDAO.deletePrescription(id);
            return Response.ok().entity("Prescription deleted").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting prescription with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }
}
