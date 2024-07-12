package io.leasingninja.sales.domain

import org.jmolecules.ddd.annotation.ValueObject;

@ValueObject
data class ContractNumber(val number: String)
