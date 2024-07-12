package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class InterestTest : AnnotationSpec() {

    @Test
    fun givenAnInterest_whenPerMonth_thenCorrectValue() {
        // given
        val interest = Interest(3.6)

        // when
        val perMonth = interest.perMonth

        // then
        perMonth shouldBe 0.3
    }

}
