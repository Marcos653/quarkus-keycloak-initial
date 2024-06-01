package org.acme.controller;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.acme.entity.Customer;
import org.acme.service.CustomerService;

import java.util.List;

@Path("/api/customer")
@ApplicationScoped
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET
    @RolesAllowed("manager")
    public List<Customer> retrieveCustomers() {
        return customerService.findAllCustomers();
    }

    @POST
    @Transactional
    @RolesAllowed("manager")
    public void addCustomer(Customer customer) {
        customerService.addCustomer(customer);
    }
}
