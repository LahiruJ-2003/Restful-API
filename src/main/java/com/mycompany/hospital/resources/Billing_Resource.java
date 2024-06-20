/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hospital.resources;
/*
Student Name: Lahiru Rajakaruna Jayasinghe
Student Id: 20221791
*/

import com.mycompany.hospital.dao.Billing_DAO;
import com.mycompany.hospital.entity.Billing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bills")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Billing_Resource {
    private static final Logger logger = LoggerFactory.getLogger(Billing_Resource.class);
    private Billing_DAO billingDAO = new Billing_DAO();

    /**
     * Retrieves all billing records.
     */
    @GET
    public Response getAllBills() {
        try {
            List<Billing> bills = billingDAO.getAllBills();
            return Response.ok(bills).build();
        } catch (Exception e) {
            logger.error("Error while retrieving all bills: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while retrieving all bills").build();
        }
    }

    /**
     * Retrieves a billing record by its ID.
     */
    @GET
    @Path("/{id}")
    public Response getBillById(@PathParam("id") int id) {
        try {
            Billing bill = billingDAO.getBillById(id);
            if (bill != null) {
                return Response.ok(bill).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Bill not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.error("Error while retrieving bill with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while retrieving bill with ID " + id).build();
        }
    }

    /**
     * Adds a new billing record.
     */
    @POST
    public Response addBill(Billing bill) {
        try {
            billingDAO.addBill(bill);
            return Response.status(Response.Status.CREATED).entity("Bill added").build();
        } catch (Exception e) {
            logger.error("Error while adding bill: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while adding bill").build();
        }
    }

    /**
     * Updates an existing billing record.
     */
    @PUT
    @Path("/{id}")
    public Response updateBill(@PathParam("id") int id, Billing updatedBill) {
        try {
            Billing existingBill = billingDAO.getBillById(id);
            if (existingBill != null) {
                updatedBill.setId(id); // Set the ID of the updated bill
                billingDAO.updateBill(id, updatedBill);
                return Response.ok().entity("Bill updated").build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Bill not found with ID: " + id).build();
            }
        } catch (Exception e) {
            logger.error("Error while updating bill with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while updating bill with ID " + id).build();
        }
    }

    /**
     * Deletes a billing record by its ID.
     */
    @DELETE
    @Path("/{id}")
    public Response deleteBill(@PathParam("id") int id) {
        try {
            billingDAO.deleteBill(id);
            return Response.ok().entity("Bill deleted").build();
        } catch (Exception e) {
            logger.error("Error while deleting bill with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while deleting bill with ID " + id).build();
        }
    }

    /**
     * Marks a billing record as paid by its ID.
     */
    @PUT
    @Path("/pay/{id}")
    public Response markBillAsPaid(@PathParam("id") int id) {
        try {
            billingDAO.markBillAsPaid(id);
            return Response.ok().entity("Bill marked as paid").build();
        } catch (Exception e) {
            logger.error("Error while marking bill as paid with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while marking bill as paid with ID " + id).build();
        }
    }

    /**
     * Marks a billing record as unpaid by its ID.
     */
    @PUT
    @Path("/unpay/{id}")
    public Response markBillAsUnpaid(@PathParam("id") int id) {
        try {
            billingDAO.markBillAsUnpaid(id);
            return Response.ok().entity("Bill marked as unpaid").build();
        } catch (Exception e) {
            logger.error("Error while marking bill as unpaid with ID {}: {}", id, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error while marking bill as unpaid with ID " + id).build();
        }
    }
}
