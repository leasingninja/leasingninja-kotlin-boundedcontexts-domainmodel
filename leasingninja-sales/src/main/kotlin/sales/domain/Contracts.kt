package io.leasingninja.sales.domain;

import org.jmolecules.ddd.annotation.Repository;

@Repository
public interface Contracts {

	fun with(number: ContractNumber): Contract

	fun save(contract: Contract)

}
