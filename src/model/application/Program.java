package model.application;

import model.entities.Contract;
import model.services.ContractService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Dados do contrato: ");
			System.out.print("Numero: ");
			Integer numero = sc.nextInt();
			System.out.print("Data(dd/MM/yyyy): ");
			Date date = sdf.parse(sc.next());
			System.out.print("Valor do contrato: ");
			Double totalValue = sc.nextDouble();
			
			Contract c = new Contract(numero,date,totalValue);

			System.out.print("Entre com o numero de parcelas: ");
			Integer months = sc.nextInt();

			ContractService contractService = new ContractService(c,months,);


			//c.getInstallments().add(installment);
			
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
