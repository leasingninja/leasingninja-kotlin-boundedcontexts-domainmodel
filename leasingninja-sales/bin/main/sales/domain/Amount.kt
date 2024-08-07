package io.leasingninja.sales.domain

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
enum class Currency{ EUR, GBP, USD }

@ValueObject
data class Amount private constructor(
    val amountInCents: Long,
    val currency: Currency
) {
    companion object {
        fun ofCents(amountInCents: Long, currency: Currency)
            = Amount(amountInCents, currency)
    }

    constructor(amount: Double, currency: Currency)
        : this(Math.round(amount * 100), currency)

    val amount get() = amountInCents / 100.0

    operator fun plus(addend: Amount): Amount {
        require(currency == addend.currency)
        return Amount(amountInCents + addend.amountInCents, currency)
    }

    operator fun minus(addend: Amount): Amount {
        require(currency == addend.currency)
        return Amount(amountInCents - addend.amountInCents, currency)
    }

	override fun toString() = currency.toString() + " " + amount
}
