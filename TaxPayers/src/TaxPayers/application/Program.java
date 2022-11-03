package TaxPayers.application;

import TaxPayers.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.ENGLISH);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();

        System.out.print("Quantos contribuintes você vai digitar: ");
        int n = sc.nextInt();

        System.out.println();

        for (int i = 1; i <= n ; i++) {
            sc.nextLine();
            System.out.printf("Digite os dados do %d° contribuintes:\n", i);
            System.out.print("Renda anual com salario: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = sc.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Gastos medicos: ");
            double healthSpending = sc.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = sc.nextDouble();

            taxPayers.add(new TaxPayer(salaryIncome,servicesIncome,capitalIncome,healthSpending,educationSpending));

            System.out.println();
        }

        int cont = 1;
        for (TaxPayer taxPayer : taxPayers) {
            System.out.printf("Resumo do %d° contribuinte\n", cont);
            cont++;
            System.out.println(taxPayer);
        }

    }
}
