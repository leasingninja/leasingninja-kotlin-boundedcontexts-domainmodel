package io.leasingninja.sales.domain

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

}
