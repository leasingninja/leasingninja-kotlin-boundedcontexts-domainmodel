package io.leasingninja.sales.infrastructure

import java.util.HashMap
import kotlin.collections.MutableMap

import io.leasingninja.sales.domain.Contract
import io.leasingninja.sales.domain.ContractNumber
import io.leasingninja.sales.domain.Contracts

public class ContractsMemImpl : Contracts {

	private val repo = mutableMapOf<ContractNumber, Contract>();

	public override fun save(contract: Contract) {
		repo.put(contract.number, contract)
	}

	public override fun with(number: ContractNumber): Contract? {
		return repo.get(number)
	}

}
