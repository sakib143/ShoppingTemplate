package com.kiandashopping.kiandashopping.cardutils;

import java.util.ArrayList;
import java.util.List;

public enum CreditCardTypeEnum {
    VISA("Visa"),
    MASTER_CARD("MasterCard"),
    AMERICAN_EXPRESS("American Express"),
    DISCOVER("Discover"),
    JCB("Jcb"),
    DINERS_CLUB("dinersclub");
    
    public final String cartType;

    private CreditCardTypeEnum(String str) {
        this.cartType = str;
    }

    public static String[] creditCardTypes() {
        String[] strArr = new String[values().length];
        int i = 0;
        for (CreditCardTypeEnum creditCardTypeEnum : values()) {
            strArr[i] = creditCardTypeEnum.cartType;
            i++;
        }
        return strArr;
    }

    public static List<String> getCards() {
        ArrayList arrayList = new ArrayList();
        for (CreditCardTypeEnum creditCardTypeEnum : values()) {
            arrayList.add(creditCardTypeEnum.cartType);
        }
        return arrayList;
    }
}
