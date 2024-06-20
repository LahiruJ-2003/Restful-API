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
import com.mycompany.hospital.entity.Doctor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/doctors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Doctor_Resource {
    private static final Logger logger = Logger.getLogger(Doctor_Resource.class.getName());
    private Doctor_DAO doctorDAO = new Doctor_DAO();

    // Method to retrieve all doctors
    @GET
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            return Response.ok(doctors).build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving all doctors", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Method to retrieve a doctor by ID
    @GET
    @Path("/{id}")
    public Response getDoctorById(@PathParam("id") int id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                return Response.ok(doctor).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Method to add a new doctor
    @POST
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDAO.addDoctor(doctor);
            return Response.status(Response.Status.CREATED).entity("Doctor added").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while adding a doctor", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Method to update an existing doctor
    @PUT
    @Path("/{id}")
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        try {
            Doctor existingDoctor = doctorDAO.getDoctorById(id);
            if (existingDoctor != null) {
                updatedDoctor.setId(id); // Set the ID of the updated doctor
                doctorDAO.updateDoctor(id, updatedDoctor); // Update the doctor
                return Response.ok().entity("Doctor updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while updating doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    // Method to delete a doctor
    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            doctorDAO.deleteDoctor(id);
            return Response.ok().entity("Doctor deleted").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting doctor with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }
}
