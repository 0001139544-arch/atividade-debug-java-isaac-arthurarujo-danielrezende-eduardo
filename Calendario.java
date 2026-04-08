package org.example;

import java.util.Scanner;
import java.time.YearMonth;
import java.time.LocalDate;

public class Calendario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ano (ex: 2024): ");
        int ano = scanner.nextInt();

        System.out.print("Digite o mês (1 a 12): ");
        int mes = scanner.nextInt();

        YearMonth anoMes = YearMonth.of(ano, mes);

        int diasNoMes = anoMes.lengthOfMonth();

        int diaDaSemana = LocalDate.of(ano, mes, 1)
                .getDayOfWeek()
                .getValue();

        int diaInicial = diaDaSemana % 7;

        System.out.printf("\n     %02d/%d\n", mes, ano);
        System.out.println("-----------------------------");

        String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};

        for (String d : diasDaSemana) {
            System.out.printf("%s ", d);
        }

        System.out.println();

        for (int i = 0; i < diaInicial; i++) {
            System.out.print("    ");
        }

        for (int dia = 1; dia <= diasNoMes; dia++) {
            System.out.printf("%4d", dia);

            if ((dia + diaInicial) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n-----------------------------");

        scanner.close();
    }
}