package io.leasingninja.sales.infrastructure

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

import io.leasingninja.sales.domain.Amount
import io.leasingninja.sales.domain.Car
import io.leasingninja.sales.domain.Contract
import io.leasingninja.sales.domain.ContractNumber
import io.leasingninja.sales.domain.Currency
import io.leasingninja.sales.domain.Customer

class ContractsMemImplTest : AnnotationSpec() {

	private lateinit var repoUnderTest: ContractsMemImpl

	@Test
	fun test() {
		// given
		repoUnderTest = ContractsMemImpl()

		// when
		repoUnderTest.save(Contract(
				ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Mercedes Benz C class"),
				Amount(20_000.0, Currency.EUR)))
		var contract = repoUnderTest.with(ContractNumber("4711"))

		// then
//		contract shouldBeEqualToComparingFields
//				Contract(
//						ContractNumber("4711"),
//						Customer("John Buyer"),
//						Car("Mercedes Benz C class"),
//						Amount(20_000.0, Currency.EUR))
contract?.number shouldBe ContractNumber("4711")
		contract?.lessee shouldBe Customer("John Buyer")
		contract?.car shouldBe Car("Mercedes Benz C class")
		contract?.price shouldBe Amount(20_000.0, Currency.EUR)
	}

}
