package io.leasingninja.sales.application

import io.kotest.core.spec.style.AnnotationSpec
import org.junit.jupiter.api.extension.ExtendWith

import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.junit5.MockKExtension


import io.leasingninja.sales.domain.Amount
import io.leasingninja.sales.domain.Car
import io.leasingninja.sales.domain.Contract
import io.leasingninja.sales.domain.ContractNumber
import io.leasingninja.sales.domain.Contracts
import io.leasingninja.sales.domain.Currency
import io.leasingninja.sales.domain.Customer

//@ExtendWith(MockKExtension::class)
class FilloutContractTest : AnnotationSpec() {

	//@MockK
	lateinit var contractsMock: Contracts

	//@InjectMockKs
	lateinit var filloutContractUnderTest: FilloutContract

    @BeforeEach
    fun setUp() {
        contractsMock = mockk(relaxed = true)
        filloutContractUnderTest = FilloutContract(contractsMock)
    }

	@Test
	fun givenEmptyContract_WhenFillout_ThenSave() {
		// Given

		// When
		filloutContractUnderTest.with(
				ContractNumber("4711"),
				Customer("Bob Smith"),
				Car("Mercedes Benz E-Class"),
				Amount(10_000.0, Currency.EUR))

		// Then
        //TODO: eq() does only a shallow equals, but we want to compare every field here
        verify { contractsMock.save(eq(Contract(
            ContractNumber("4711"),
            Customer("Bob Smith"),
            Car("Mercedes Benz E-Class"),
            Amount(10_000.0,  Currency.EUR)))) }
	}

}
