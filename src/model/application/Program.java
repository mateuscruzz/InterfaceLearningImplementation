package model.application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			System.out.println("Dados do contrato: ");
			System.out.print("Numero: ");
			int number = sc.nextInt();
			System.out.print("Data(dd/MM/yyyy): ");
			LocalDate date = LocalDate.parse(sc.next(),fmt);
			System.out.print("Valor do contrato: ");
			double totalValue = sc.nextDouble();
			
			Contract c = new Contract(number,date,totalValue);

			System.out.print("Entre com o numero de parcelas: ");
			int months = sc.nextInt();

			ContractService contractService = new ContractService(new PaypalService());
			
			contractService.processContract(c, months);
			
			System.out.println("Parcelas:");
			
			for (Installment parcela : c.getInstallments()) {
				System.out.println(parcela);
			}
			
		} finally {
			sc.close();
		}
	}

}
