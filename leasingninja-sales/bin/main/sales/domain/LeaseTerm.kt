package io.leasingninja.sales.domain

import org.jmolecules.ddd.annotation.ValueObject

@ValueObject
data class LeaseTerm private constructor(
    val noOfMonths: Int
) {
    companion object {
        fun ofMonths(noOfMonths: Int) = LeaseTerm(noOfMonths)
        fun ofYears(noOfYears: Int) = LeaseTerm(noOfYears * 12)
    }
}
