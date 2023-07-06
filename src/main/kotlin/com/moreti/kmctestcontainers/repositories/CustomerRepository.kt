package com.moreti.kmctestcontainers.repositories

import com.moreti.kmctestcontainers.models.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository: JpaRepository<Customer, Long> {}