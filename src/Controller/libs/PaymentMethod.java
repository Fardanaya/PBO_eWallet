package Controller.libs;

import Model.Data.*;
import Node.Bank;

public class PaymentMethod {

    ModelBank modelBank = new ModelBank();

    public PaymentMethod() {
        init();
    }

    private void init() {
        modelBank.addBank(new Bank("BCA", "014"));
        modelBank.addBank(new Bank("BRI (Bank Rakyat Indonesia)", "002"));
        modelBank.addBank(new Bank("BNI (Bank Negara Indonesia)", "009"));
        modelBank.addBank(new Bank("BTN (Bank Tabungan Negara)", "200"));
        modelBank.addBank(new Bank("Mega", "426"));
        modelBank.addBank(new Bank("Mandiri", "008"));
    }

    public ModelBank getModelBank() {
        return modelBank;
    }
}
