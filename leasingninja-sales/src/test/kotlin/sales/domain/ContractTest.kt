package io.leasingninja.sales.domain

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ContractTest {

    @Test
    fun givenANewContract_whenSign_thenContractIsSigned() {
        // given
        var contract = Contract(ContractNumber("4711"),
            Customer("John Buyer"),
            Car("Mercedes Benz C-Class"),
            Amount(20_000.00, Currency.EUR))
        var vierGewinntRahmenUnderTest: VierGewinntRahmen = VierGewinntRahmen()

        // when

        // then

    }

}
