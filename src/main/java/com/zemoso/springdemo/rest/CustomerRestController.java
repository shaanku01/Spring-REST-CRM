package com.zemoso.springdemo.rest;

import com.zemoso.springdemo.entity.Customer;
import com.zemoso.springdemo.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        //customerService = new CustomerServiceImpl();
        System.out.println("Entered Rest controller "+ customerService);
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer == null){
            throw  new CustomerNotFoundException("Customer id is not FOund" + customerId);
        }

        return customer;

    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        // set to 0 because , if id is 0 then DAO will insert new customer.
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }


    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);

        if(customer==null){
            throw new CustomerNotFoundException("Customer Id not found  "+customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted the Customer-"+ customerId;

    }


    @GetMapping("/hello")
    public String getMess(){
        return "Hello World";
    }



}
