package model.application;

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
			
			Contract
			
		} catch (ParseException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}

}
