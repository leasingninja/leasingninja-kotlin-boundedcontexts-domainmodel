package io.leasingninja.sales.application;

//import org.jmolecules.architecture.layered.ApplicationLayer;
import org.jmolecules.ddd.annotation.Service;

import io.leasingninja.sales.domain.Amount;
import io.leasingninja.sales.domain.Car;
import io.leasingninja.sales.domain.Contract;
import io.leasingninja.sales.domain.ContractNumber;
import io.leasingninja.sales.domain.Contracts;
import io.leasingninja.sales.domain.Customer;

//@ApplicationLayer
@Service
public class FilloutContract(private val contracts: Contracts) {

	public fun with(number: ContractNumber, customer: Customer, car: Car, price: Amount) {
		contracts.save(Contract(
				number,
				customer,
				car,
				price))
	}

}
