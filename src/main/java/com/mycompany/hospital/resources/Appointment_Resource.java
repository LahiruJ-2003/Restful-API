/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Appointment_DAO;
import com.mycompany.hospital.entity.Appointment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/appointments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Appointment_Resource {
    private static final Logger logger = Logger.getLogger(Appointment_Resource.class.getName());
    private final Appointment_DAO appointmentDAO = new Appointment_DAO();

    @GET
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            return Response.ok(appointments).build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving all appointments", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @GET
    @Path("/{id}")
    public Response getAppointmentById(@PathParam("id") int id) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            if (appointment != null) {
                return Response.ok(appointment).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while retrieving appointment with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @POST
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            return Response.status(Response.Status.CREATED).entity("Appointment added").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while adding appointment", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateAppointment(@PathParam("id") int id, Appointment updatedAppointment) {
        try {
            Appointment existingAppointment = appointmentDAO.getAppointmentById(id);
            if (existingAppointment != null) {
                updatedAppointment.setId(id); // Set the ID of the updated appointment
                appointmentDAO.updateAppointment(id, updatedAppointment);
                return Response.ok().entity("Appointment updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while updating appointment with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        try {
            appointmentDAO.deleteAppointment(id);
            return Response.ok().entity("Appointment deleted").build();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error occurred while deleting appointment with ID: " + id, e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Internal server error").build();
        }
    }
}

