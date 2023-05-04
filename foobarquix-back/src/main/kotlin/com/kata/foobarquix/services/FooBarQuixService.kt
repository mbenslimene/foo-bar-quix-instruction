package com.kata.foobarquix.services

import org.springframework.stereotype.Component

@Component
class FooBarQuixService {

    fun convertNumber(inputNumber: Int): String {
        val divisibleBy3 = inputNumber % 3 == 0
        val divisibleBy5 = inputNumber % 5 == 0

        val sb = StringBuilder()

        if (divisibleBy3 ) sb.append("Foo")
        if (divisibleBy5 ) sb.append("Bar")

        val digits = inputNumber.toString().toCharArray()
        digits.forEach { digit ->
            when (digit) {
                '3' -> sb.append("Foo")
                '5' -> sb.append("Bar")
                '7' -> sb.append("Quix")
            }
        }

        if (sb.isEmpty()) return inputNumber.toString()
        return sb.toString()
    }

}