package com.moreti.kmctestcontainers

import org.junit.jupiter.api.extension.AfterAllCallback
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.Extension
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.testcontainers.containers.PostgreSQLContainer


class PostgresExtension: Extension, BeforeAllCallback, AfterAllCallback {

    @Autowired
    private lateinit var environment: Environment

    companion object {
        private val postgres = PostgreSQLContainer("postgres:14-alpine")
            .withUsername("my-user")
            .withPassword("my-password")
            .withDatabaseName("customer-db")
    }

    override fun beforeAll(context: ExtensionContext?) {
        postgres.start()

        System.setProperty("spring.datasource.url", postgres.jdbcUrl)
        System.setProperty("spring.datasource.username", postgres.username)
        System.setProperty("spring.datasource.password", postgres.password)

    }

    override fun afterAll(context: ExtensionContext?) {
//        postgres.stop()
    }
}