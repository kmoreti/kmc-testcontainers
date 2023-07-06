package com.moreti.kmctestcontainers

import com.moreti.kmctestcontainers.models.Customer
import com.moreti.kmctestcontainers.repositories.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController(private val repo: CustomerRepository) {

    @GetMapping("/api/customers")
    fun getAllCustomers(): List<Customer> = repo.findAll()
}