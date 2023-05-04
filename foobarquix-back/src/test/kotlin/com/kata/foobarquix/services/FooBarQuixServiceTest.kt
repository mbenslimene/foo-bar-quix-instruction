package com.kata.foobarquix.services

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FooBarQuixServiceTest {

    @Autowired
    private lateinit var fooBarQuixService: FooBarQuixService

    @Test
    fun `should return input number as string when no match found`() {
        val input = 2
        val expectedOutput = "2"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 3 with Foo`() {
        val input = 3
        val expectedOutput = "FooFoo"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 5 with Bar`() {
        val input = 5
        val expectedOutput = "BarBar"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 7 with Quix`() {
        val input = 7
        val expectedOutput = "Quix"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 3 with Foo and 5 with Bar`() {
        val input = 51
        val expectedOutput = "FooBar"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 5 with Bar and 3 with Foo`() {
        val input = 53
        val expectedOutput = "BarFoo"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 3 with Foo three times`() {
        val input = 33
        val expectedOutput = "FooFooFoo"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 3 with Foo and 7 with Quix`() {
        val input = 27
        val expectedOutput = "FooQuix"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }

    @Test
    fun `should replace 3 with Foo and 5 with Bar twice`() {
        val input = 15
        val expectedOutput = "FooBarBar"
        assertThat(fooBarQuixService.convertNumber(input)).isEqualTo(expectedOutput)
    }
}