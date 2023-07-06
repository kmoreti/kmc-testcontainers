package com.moreti.kmctestcontainers

import com.moreti.kmctestcontainers.models.Customer
import com.moreti.kmctestcontainers.repositories.CustomerRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@ExtendWith(PostgresExtension::class)
class KmcTestcontainersApplicationTests (
	@Autowired val customerRepository: CustomerRepository
) {

	@Test
	fun contextLoads() {
		val customer = Customer(null, "Kleber Moreti", "kleber.moreti.camargo@gmail.com")
		customerRepository.save(customer)
		val customers = customerRepository.findAll()
		assertEquals(1, customers.size)
	}

}
