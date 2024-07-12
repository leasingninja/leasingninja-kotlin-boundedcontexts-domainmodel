package io.leasingninja.sales.domain

import org.jmolecules.ddd.annotation.ValueObject

@ValueObject
data class Customer(val customer: String) {
    init {
        require(isValid(customer))
    }

    companion object {
        fun isValid(nameString: String): Boolean {
            return nameString.matches(Regex("^\\p{L}+(\\s\\p{L}+)*$"));
        }
    }
}
