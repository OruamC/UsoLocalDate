package com.exercicioparcelas;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Scanner;

public class Parcelamento {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int quantidadeDeParcelas = 0;
        Double valorDivida = 0.0;
        Double valorParcela;

        LocalDate data = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat df = new DecimalFormat("#,###.00");

        while (valorDivida <= 0) {
            System.out.print("Digite o valor: ");
            valorDivida = scanner.nextDouble();
        }

        while (quantidadeDeParcelas < 1 || quantidadeDeParcelas > 12) {
            System.out.print("Digite quantas parcelas deseja fazer: ");
            quantidadeDeParcelas = scanner.nextInt();
        }

        for (int i = 0; i < quantidadeDeParcelas; i++) {
            if (i == (quantidadeDeParcelas -1)) {
                valorParcela = (valorDivida / quantidadeDeParcelas) + (valorDivida % quantidadeDeParcelas);
                data = data.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
                System.out.println("Parcela [" + (i + 1) + "]: R$ " + df.format(valorParcela) +
                        ", com vencimento para " + formatador.format(data));
            } else if (i == 0){
                valorParcela = valorDivida / quantidadeDeParcelas;
                System.out.println("Parcela [" + (i + 1) + "]: R$ " + df.format(valorParcela) +
                        ", com vencimento para " + formatador.format(data));
            } else {
                valorParcela = valorDivida / quantidadeDeParcelas;
                data = data.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
                System.out.println("Parcela [" + (i + 1) + "]: R$ " + df.format(valorParcela) +
                        ", com vencimento para " + formatador.format(data));
            }
        }
        scanner.close();
    }
}
