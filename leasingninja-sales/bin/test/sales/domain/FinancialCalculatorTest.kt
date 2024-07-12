package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class FinancialCalculatorTest : AnnotationSpec() {

    @Test
	fun pmt() {
		// given

		// when
		val pmt = pmt(48.0, 3.7 / 12, -40_000.0, 0.0, 0.0)

		// then
		pmt shouldBe 897.8022814470006
	}

}
