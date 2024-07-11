package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class CustomerTest : AnnotationSpec() {

    @Test
    fun givenAStringWithOnlyLetters_whenIsValid_thenTrue() {
        // given
        val nameString = "John"

        // when
        val isValid = Customer.isValid(nameString)

        // then
        isValid shouldBe true
    }

    @Test
    fun givenAStringWithNonStandardLatinCharacter_whenIsValid_thenTrue() {
        // given
        val nameString = "Björn"

        // when
        val isValid = Customer.isValid(nameString)

        // then
        isValid shouldBe true
    }

    @Test
    fun givenAStringWithOnlyLettersAndSpace_whenIsValid_thenTrue() {
        // given
        val nameString = "John Buyer"

        // when
        val isValid = Customer.isValid(nameString)

        // then
        isValid shouldBe true
    }

    @Test
    fun givenAStringWithNonStandardLatinCharacterAndSpace_whenIsValid_thenTrue() {
        // given
        val nameString = "John le Carré"

        // when
        val isValid = Customer.isValid(nameString)

        // then
        isValid shouldBe true
    }

    @Test
    fun givenAStringWithNumbers_whenIsValid_thenFalse() {
        // given
        val nameString = "John42"

        // when
        val isValid = Customer.isValid(nameString)

        // then
        isValid shouldBe false
    }

}
