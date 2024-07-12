package io.leasingninja.sales.domain;

import org.jmolecules.ddd.annotation.Service;

/**
 * Simulates the infamous HP12c calculator that is widely used in the leasing industry.
 */
//@Service
    /**
     * @param n number of periods
     * @param iInPercent percentage interest rate per period
     * @param pv present value
     * @param fv future value
     * @param s
     * @return payment per period
     */
    public fun pmt(n: Double, iInPercent: Double, pv: Double, fv: Double, s: Double): Double {
    	val i = iInPercent / 100.0

        return pmtWithDecimalInterestRate(n, i, pv, fv, s)
	}

    /**
     * @param n number of periods
     * @param i decimal interest rate per period
     * @param pv present value
     * @param fv future value
     * @param s
     * @return payment per period
     */
    private fun pmtWithDecimalInterestRate(n: Double, i: Double, pv: Double, fv: Double, s: Double): Double {
        if (i == 0.0) {
            return (-1.0 * pv - fv) / n;
        }

		return (i * (fv + pv * Math.pow(1.0 + i, n))) / ((1.0 + i * s) * (1.0 - Math.pow(1.0 + i, n)));
    }
