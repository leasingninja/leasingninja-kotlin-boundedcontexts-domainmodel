package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class ContractTest : AnnotationSpec() {

    @Test
    fun givenANewContract_whenSign_thenContractIsSigned() {
        // given
        var contract = Contract(ContractNumber("4711"),
            Customer("John Buyer"),
            Car("Mercedes Benz C-Class"),
            Amount(20_000.00, Currency.EUR))

        // when
        contract.calculateInstallmentFor(LeaseTerm.ofMonths(48), Interest(3.7));

        // then
        contract.isCalculated shouldBe true
	//	contract.leaseTerm shouldBe LeaseTerm.ofMonths(48)
	//	contract.interest shouldBe Interest(3.7)
	//	contract.installment shouldBe Amount(897.80, Currency.EUR)
    }

}
