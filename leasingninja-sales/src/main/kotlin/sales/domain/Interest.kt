package io.leasingninja.sales.domain

import org.jmolecules.ddd.annotation.ValueObject

@ValueObject
data class Interest(val perYear: Double) {
    val perMonth get() = perYear / 12.0
}
