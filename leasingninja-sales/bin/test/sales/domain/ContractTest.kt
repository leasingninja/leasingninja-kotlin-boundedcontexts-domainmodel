package io.leasingninja.sales.domain

import java.time.LocalDate

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class ContractTest : AnnotationSpec() {

    @Test
    fun givenAFilledOutContract_whenCalculate_thenInstallmentIsX() {
        // given
        var contract = Contract(ContractNumber("4711"),
            Customer("John Buyer"),
            Car("Volkswagen ID.3"),
            Amount(40_000.00, Currency.EUR))

        // when
        contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(3.7))

        // then
        contract.isCalculated shouldBe true
		contract.leaseTerm shouldBe LeaseTerm.ofMonths(48)
		contract.interest shouldBe Interest(3.7)
		contract.installment shouldBe Amount(897.80, Currency.EUR)
    }

	@Test
	fun givenAFilledOutContractWith0Interest_whenCalculate_thenInstallmentIsX() {
		// given
		var contract = Contract(ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(40_000.0, Currency.EUR))

		// when
		contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(0.0))

		// then
		contract.isCalculated shouldBe true
		contract.installment shouldBe Amount(833.33, Currency.EUR)
	}

	@Test
	fun givenACalculatedContract_whenSign_thenContractIsSigned() {
		// given
		var contract = Contract(ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(20_000.0, Currency.EUR))
        contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(3.7))

		// when
		contract.sign(LocalDate.of(2018, 12, 24))

		// then
		contract.isSigned shouldBe true
		contract.signDate shouldBe LocalDate.of(2018, 12, 24)
		// check that event ContractSigned is fired
	}

	@Test
	fun givenTwoContractsWithSameIdButDifferentFields_whenEquals_thenShouldReturnTrue() {
		// given
		var contract1 = Contract(ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(40_000.0, Currency.EUR))
        var contract2 = Contract(ContractNumber("4711"),
				Customer("Bob Myers"),
				Car("Mercedes Benz EQC"),
				Amount(30_000.0, Currency.EUR))

		// when
		var equal = contract1.equals(contract2)

		// then
		equal shouldBe true
	}

	@Test
	fun givenTwoContractsWithDifferentIdButSameFields_whenEquals_thenShouldReturnFalse() {
		// given
		var contract1 = Contract(ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(40_000.0, Currency.EUR))
        var contract2 = Contract(ContractNumber("4712"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(40_000.0, Currency.EUR))

		// when
		var equal = contract1.equals(contract2)

		// then
		equal shouldBe false
	}

	@Test
	fun givenTwoContractsWithSameId_whenHashcode_thenShouldBeEqual() {
		// given
		var contract1 = Contract(ContractNumber("4711"),
				Customer("John Buyer"),
				Car("Volkswagen ID.3"),
				Amount(40_000.0, Currency.EUR))
        var contract2 = Contract(ContractNumber("4711"),
				Customer("Bob Myers"),
				Car("Mercedes Benz EQC"),
				Amount(30_000.0, Currency.EUR))

		// when
		var hashcode1 = contract1.hashCode()
		var hashcode2 = contract2.hashCode()

		// then
		hashcode1 shouldBe hashcode2
	}

}
