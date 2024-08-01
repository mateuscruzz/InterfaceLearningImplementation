package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}

	public void processContract(Contract c, int months) {
		double bQ = c.getTotalValue()/months;
		for (int i = 1; i <= months; i++) {
			LocalDate dueDate = c.getDate().plusMonths(i);
			double interest = onlinePaymentService.interest(bQ, i);
            double fee = onlinePaymentService.paymentFee(bQ + interest);
            double q = bQ + interest + fee;
            c.getInstallments().add(new Installment(dueDate, q));
		}
	}
}
