package com.kiandashopping.kiandashopping.cardutils;

import android.content.Context;
import com.apptube.ecommerce.R;
import com.kiandashopping.kiandashopping.cardutils.CreditCardEditText;
import java.util.ArrayList;
import java.util.List;

public class CreditCardPatterns implements CreditCardEditText.CreditCartEditTextInterface {
    public static final String AMERICAN_EXPRESS = "^3[47][0-9]{13}$";
    public static final String DINERS_CLUB = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$";
    public static final String DISCOVER = "^6(?:011|5[0-9]{2})[0-9]{12}$";
    public static final String JCB = "^(?:2131|1800|35d{3})d{11}$";
    public static final String MASTERCARD = "^5[1-5][0-9]{14}$";
    public static final String VISA = "^4[0-9]{12}(?:[0-9]{3})?$";
    private Context mContext;

    public CreditCardPatterns(Context context) {
        this.mContext = context;
    }

    public List<CreditCardEditText.CreditCard> mapOfRegexStringAndImageResourceForCreditCardEditText(CreditCardEditText creditCardEditText) {
        ArrayList arrayList = new ArrayList();
        CreditCardEditText.CreditCard creditCard = new CreditCardEditText.CreditCard(VISA, this.mContext.getResources().getDrawable(R.drawable.visa), CreditCardTypeEnum.VISA.cartType);
        CreditCardEditText.CreditCard creditCard2 = new CreditCardEditText.CreditCard(MASTERCARD, this.mContext.getResources().getDrawable(R.drawable.mastercard), CreditCardTypeEnum.MASTER_CARD.cartType);
        CreditCardEditText.CreditCard creditCard3 = new CreditCardEditText.CreditCard(AMERICAN_EXPRESS, this.mContext.getResources().getDrawable(R.drawable.amex), CreditCardTypeEnum.AMERICAN_EXPRESS.cartType);
        CreditCardEditText.CreditCard creditCard4 = new CreditCardEditText.CreditCard(DISCOVER, this.mContext.getResources().getDrawable(R.drawable.ds), CreditCardTypeEnum.DISCOVER.cartType);
        CreditCardEditText.CreditCard creditCard5 = new CreditCardEditText.CreditCard(JCB, this.mContext.getResources().getDrawable(R.drawable.jcb), CreditCardTypeEnum.JCB.cartType);
        CreditCardEditText.CreditCard creditCard6 = new CreditCardEditText.CreditCard(DINERS_CLUB, this.mContext.getResources().getDrawable(R.drawable.dc), CreditCardTypeEnum.DINERS_CLUB.cartType);
        arrayList.add(creditCard);
        arrayList.add(creditCard2);
        arrayList.add(creditCard3);
        arrayList.add(creditCard4);
        arrayList.add(creditCard5);
        arrayList.add(creditCard6);
        return arrayList;
    }
}
