package SaqueCaixaEletronico;

import javax.swing.*;

/**
 * PROGRAMA CAIXA ELETRÔNICO:
 *
 * 1- Pedir o valor do saque
 * 2- Código para calcular quantas e quais notas serão sacadas.
 * 3- Mostrar para a pessoa o resultado.
 *
 *
 * Digite o valor do saque: 35
 * ------
 * Você está sacando:
 * 1 nota de 5
 * 1 nota de 10
 * 1 nota de 20
 * 0 nota de 50
 * 0 nota de 100
 */

public class SaqueCaixaEletronico {

    /**
     * Levei em consideração as notas de REAIS existentes
     */
    private final int[] availableBills = {200, 100, 50, 20, 10, 5, 2};

    public static void main(String[] args) {

        SaqueCaixaEletronico app = new SaqueCaixaEletronico();
        app.callWithdrawOperation();


    }

    public void callWithdrawOperation() {

        this.showMsg(
                this.getWithdrawMsg(
                        this.getOutputtedBills(
                                this.getUserInput()
                        )
                )
        );

    }

    private double getUserInput() {

        double withdrawValue;

        do {

            try {

                withdrawValue = Double.parseDouble(this.showInput("Digite o valor a sacar"));

            } catch (Exception e) {

                this.showMsg("O valor digitado é inválido");
                continue;

            }

            if (withdrawValue <= 0) {

                this.showMsg("O valor deve ser maior que zero!");
                continue;

            }

            if (withdrawValue < 5 && withdrawValue % 2 != 0) {

                this.showMsg("Impossivel sacar o valor digitado com as notas disponiveis!");
                continue;

            }

            break;

        } while (true);

        return withdrawValue;

    }

    private int[] getOutputtedBills(double forWhichUserInput) {

        int[] withdrawBills = new int[this.availableBills.length];
        int currentWithdrawValue = (int) forWhichUserInput;
        /*
         * @temporaryValue will be used to detect odd number cases like 11 (one 5 bill and three 2 bills notes) where
         * it still possible to withdraw the given userInput with the current available bills
         */
        int temporaryValue;

        for (int index = 0; index < this.availableBills.length && currentWithdrawValue > 0; index++) {

            temporaryValue = currentWithdrawValue % this.availableBills[index];

            // five is the lowest odd number available
            if (temporaryValue < 5 && temporaryValue % 2 != 0) {

                currentWithdrawValue -= this.availableBills[index];
                temporaryValue = (int) (currentWithdrawValue / this.availableBills[index]);
                currentWithdrawValue %= this.availableBills[index];
                currentWithdrawValue += this.availableBills[index];

            } else {

                temporaryValue = (int) (currentWithdrawValue / this.availableBills[index]);
                currentWithdrawValue %= this.availableBills[index];

            }

            if (temporaryValue != 0) {

                withdrawBills[index] = temporaryValue;

            }

        }

        return withdrawBills;

    }

    private String getWithdrawMsg(int[] forWhichValues) {

        String finalMessage = "";

        for (int index = 0; index < forWhichValues.length; index++) {

            finalMessage += "quantidade de notas de " + this.availableBills[index] + " : " + forWhichValues[index] + "\n";

        }

        return finalMessage;

    }

    private void showMsg(String whichMsg) {

        JOptionPane.showMessageDialog(null, whichMsg);

    }

    private String showInput(String msg) {

        return JOptionPane.showInputDialog(msg);

    }

}
