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

        // ERRO LÓGICO 1: Subtraindo 1 do total de dias reais do mês.
        int diasNoMes = anoMes.lengthOfMonth() - 1;

        int diaDaSemana1o = LocalDate.of(ano, mes, 1).getDayOfWeek().getValue();

        // ERRO LÓGICO 2: Cálculo errado do dia inicial.
        int diaInicial = (diaDaSemana1o % 7) + 1;

        System.out.println("\nCalendário de " + String.format("%02d/%d", mes, ano));
        System.out.println("---------------------------");

        String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        for (String d : diasDaSemana) {
            System.out.print(d + " ");
        }
        System.out.println();

        // ERRO LÓGICO 3: Condição com '<=' imprime um espaço em branco a mais.
        for (int i = 0; i <= diaInicial; i++) {
            System.out.print("    ");
        }

        for (int dia = 1; dia <= diasNoMes; dia++) {
            System.out.printf("%02d  ", dia);

            // ERRO LÓGICO 4: Quebra de linha não considera o 'diaInicial' dos espaços vazios.
            if (dia % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n\n---------------------------");
        scanner.close();
    }
}