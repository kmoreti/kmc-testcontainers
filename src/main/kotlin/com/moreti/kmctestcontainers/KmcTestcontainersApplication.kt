package com.moreti.kmctestcontainers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KmcTestcontainersApplication

fun main(args: Array<String>) {
	runApplication<KmcTestcontainersApplication>(*args)
}
