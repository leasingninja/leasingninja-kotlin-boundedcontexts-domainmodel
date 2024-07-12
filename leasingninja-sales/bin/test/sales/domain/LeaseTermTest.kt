package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class LeaseTermTest : AnnotationSpec() {
    @Test
    fun given_whenALeaseTermIsCreatedOfYears_thenNoOfMonthsIsCorrect() {
        // given

        // when
        val leaseTerm = LeaseTerm.ofYears(4)

        // then
        leaseTerm.noOfMonths shouldBe 48
    }
}
