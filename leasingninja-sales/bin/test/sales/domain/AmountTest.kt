package io.leasingninja.sales.domain

import io.kotest.matchers.*
import io.kotest.core.spec.style.AnnotationSpec

class AmountTest : AnnotationSpec(){
    @Test
    fun givenTwoAmountsWithRoundingAfterThePoint_whenEquals_thenAreEqual() {
        // given
        val amount1 = Amount(100.45, Currency.EUR)
        val amount2 = Amount(100.447123, Currency.EUR)

        // when
        val areEqual = amount1.equals(amount2)

        // then
        areEqual shouldBe true
    }

    @Test
    fun givenAnAmountsWithCents_whenToString_thenAfterThePointIsCorrectlyPrinted() {
        // given
        val amount = Amount(100.45, Currency.EUR)

        // when
        val amountString = amount.toString()

        // then
        amountString shouldBe "EUR 100.45"
    }

    @Test
    fun givenTwoAmountsOfEurosAndCents_whenEquals_thenAreEqual() {
        // given
        val amount1 = Amount(100.45, Currency.EUR)
        val amount2 = Amount.ofCents(10045, Currency.EUR)

        // when
        val areEqual = amount1.equals(amount2)

        // then
        areEqual shouldBe true
    }

    @Test
    fun givenTwoAmounts_whenOperatorPlus_thenSumIsCorrect() {
        // given
        val amount1 = Amount(100.0, Currency.EUR)
        val amount2 = Amount(200.0, Currency.EUR)

        // when
        val sum = amount1 + amount2

        // then
        sum shouldBe Amount(300.0, Currency.EUR)
    }

    @Test
    fun givenTwoAmounts_whenOperatorMinus_thenDifferenceIsCorrect() {
        // given
        var amount1 = Amount(300.0, Currency.EUR);
        var amount2 = Amount(200.0, Currency.EUR);

        // when
        var sum = amount1 - amount2

        // then
        sum shouldBe Amount(100.0, Currency.EUR)
    }
}
