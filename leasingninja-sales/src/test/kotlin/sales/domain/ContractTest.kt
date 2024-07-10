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
        contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(3.7));

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
				Car("Mercedes Benz C-Class"),
				Amount(20_000.0, Currency.EUR));
        contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(3.7));

		// when
		contract.sign(LocalDate.of(2018, 12, 24));

		// then
		contract.isSigned shouldBe true
		contract.signDate shouldBe LocalDate.of(2018, 12, 24)
		// check that event ContractSigned is fired
	}

}
