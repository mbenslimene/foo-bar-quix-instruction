package com.kata.foobarquix

import com.kata.foobarquix.services.FooBarQuixService
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
class FooBarQuixApplicationTests {

	@Autowired
	private lateinit var fooBarQuixService: FooBarQuixService

	@Test
	fun testConvertProvidedExamples() {
		assertThat(fooBarQuixService.convertNumber(1)).isEqualTo("1")
		assertThat(fooBarQuixService.convertNumber(3)).isEqualTo("FooFoo")
		assertThat(fooBarQuixService.convertNumber(5)).isEqualTo("BarBar")
		assertThat(fooBarQuixService.convertNumber(7)).isEqualTo("Quix")
		assertThat(fooBarQuixService.convertNumber(9)).isEqualTo("Foo")
		assertThat(fooBarQuixService.convertNumber(51)).isEqualTo("FooBar")
		assertThat(fooBarQuixService.convertNumber(53)).isEqualTo("BarFoo")
		assertThat(fooBarQuixService.convertNumber(33)).isEqualTo("FooFooFoo")
		assertThat(fooBarQuixService.convertNumber(27)).isEqualTo("FooQuix")
		assertThat(fooBarQuixService.convertNumber(15)).isEqualTo("FooBarBar")
	}

}
