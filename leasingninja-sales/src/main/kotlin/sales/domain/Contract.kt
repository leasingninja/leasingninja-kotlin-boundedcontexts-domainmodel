package io.leasingninja.sales.domain

import java.time.LocalDate

import org.jmolecules.ddd.annotation.Service
import org.jmolecules.ddd.annotation.Entity
import org.jmolecules.ddd.annotation.Identity

@Entity
class Contract(
    @Identity
    val number: ContractNumber,
    val lessee: Customer,
    val car: Car,
    val price: Amount
) {
    data class Calculation(var leaseTerm: LeaseTerm, var interest: Interest, var installment: Amount)
    var calculation: Calculation? = null
    var signDate: LocalDate? = null

    fun calculateInstallmentFor(leaseTerm: LeaseTerm, interest: Interest) {
        check(!isSigned)

        val inAdvance = 0.0
        val residualValue = 0.0

        val pmt = /*FinancialCalculator.*/pmt(
            leaseTerm.noOfMonths.toDouble(),
            interest.perMonth,
            -1.0 * price.amount,
            residualValue,
            inAdvance)

        calculation = Calculation(leaseTerm, interest, Amount(pmt, price.currency))

        assert(isCalculated)
    }

    val isCalculated get() = calculation != null

    val leaseTerm get(): LeaseTerm {
        check(isCalculated)
        return calculation!!.leaseTerm
    }

    val interest get(): Interest {
        check(isCalculated)
        return calculation!!.interest
    }

    val installment get(): Amount {
        check(isCalculated)
        return calculation!!.installment
    }

	fun sign(date: LocalDate) {
        check(isCalculated)
		check(!isSigned)

		this.signDate = date

		assert(isSigned)
	}

    val isSigned get() = signDate != null

    // TODO:("equals(), hashCode(), toString() ??")
}
