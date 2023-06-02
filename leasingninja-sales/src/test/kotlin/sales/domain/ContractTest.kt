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

        // then

    }

}
