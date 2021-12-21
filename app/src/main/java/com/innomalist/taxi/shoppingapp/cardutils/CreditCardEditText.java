package com.kiandashopping.kiandashopping.cardutils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.kiandashopping.kiandashopping.C1418R;
import com.kiandashopping.kiandashopping.cardutils.CreditCardTextWatcher;
import java.util.Iterator;
import java.util.List;

public class CreditCardEditText extends AppCompatEditText implements CreditCardTextWatcher.TextWatcherListener {
    private static int DEFAULT_NO_MATCH_FOUND_DRAWABLE = 2131230893;
    private static final int MAXIMUM_CREDIT_CARD_LENGTH = 16;
    private static final int MINIMUM_CREDIT_CARD_LENGTH = 13;
    private static final String SEPARATOR = "-";
    private CreditCardTypeListener creditCardTypeListener;
    private CreditCartEditTextInterface mCreditCardEditTextInterface;
    private CreditCard mCurrentCreditCardMatch;
    private List<CreditCard> mListOfCreditCardChecks;
    private int mMaximumCreditCardLength;
    private int mMinimumCreditCardLength;
    private Drawable mNoMatchFoundDrawable;
    private String mPreviousText;
    private String mSeparator;
    private CreditCardTextWatcher mTextWatcher;
    private StripeCardTypeListener stripeCardTypeListener;

    public interface CreditCardTypeListener {
        void onShowCreditCardType(String str);
    }

    public interface CreditCartEditTextInterface {
        List<CreditCard> mapOfRegexStringAndImageResourceForCreditCardEditText(CreditCardEditText creditCardEditText);
    }

    public interface StripeCardTypeListener {
        void onShowStripeCardType(String str);
    }

    public CreditCardEditText(Context context) {
        super(context);
        init();
        this.mSeparator = "-";
    }

    public CreditCardEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
        initPropertiesFromAttributes(context, attributeSet);
    }

    public CreditCardEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
        initPropertiesFromAttributes(context, attributeSet);
    }

    public Drawable getNoMatchFoundDrawable() {
        return this.mNoMatchFoundDrawable;
    }

    public void setNoMatchFoundDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mNoMatchFoundDrawable = drawable;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mNoMatchFoundDrawable.getIntrinsicHeight());
            showRightDrawable((Drawable) null);
        }
    }

    public void setCreditCardEditTextListener(CreditCartEditTextInterface creditCartEditTextInterface) {
        this.mCreditCardEditTextInterface = creditCartEditTextInterface;
        if (creditCartEditTextInterface != null) {
            this.mListOfCreditCardChecks = creditCartEditTextInterface.mapOfRegexStringAndImageResourceForCreditCardEditText(this);
        }
    }

    public String getTypeOfSelectedCreditCard() {
        CreditCard creditCard = this.mCurrentCreditCardMatch;
        if (creditCard != null) {
            return creditCard.getType();
        }
        return null;
    }

    public void setCreditCardTypeListener(CreditCardTypeListener creditCardTypeListener2) {
        this.creditCardTypeListener = creditCardTypeListener2;
    }

    public void setStripeCardTypeListener(StripeCardTypeListener stripeCardTypeListener2) {
        this.stripeCardTypeListener = stripeCardTypeListener2;
    }

    public int getMaximumCreditCardLength() {
        return this.mMaximumCreditCardLength;
    }

    public void setMaximumCreditCardLength(int i) {
        this.mMaximumCreditCardLength = i;
    }

    public int getMinimumCreditCardLength() {
        return this.mMinimumCreditCardLength;
    }

    public void setMinimumCreditCardLength(int i) {
        this.mMinimumCreditCardLength = i;
    }

    public String getCreditCardNumber() {
        String replace = getText().toString().replace(this.mSeparator, "");
        if (replace.length() < this.mMinimumCreditCardLength || replace.length() > this.mMaximumCreditCardLength) {
            return "";
        }
        return replace;
    }

    public boolean isValid() {
        if (!getCreditCardNumber().matches(CreditCardPatterns.VISA) && !getCreditCardNumber().matches(CreditCardPatterns.MASTERCARD) && !getCreditCardNumber().matches(CreditCardPatterns.AMERICAN_EXPRESS) && !getCreditCardNumber().matches(CreditCardPatterns.DISCOVER) && !getCreditCardNumber().matches(CreditCardPatterns.DINERS_CLUB) && !getCreditCardNumber().matches(CreditCardPatterns.JCB)) {
            return false;
        }
        return true;
    }

    public void onTextChanged(EditText editText, String str) {
        matchRegexPatternsWithText(str.replace(this.mSeparator, ""));
        if (this.mPreviousText != null && str.length() > this.mPreviousText.length() && !StringUtil.difference(str, this.mPreviousText).equals(this.mSeparator)) {
            addSeparatorToText();
        }
        this.mPreviousText = str;
    }

    public static class CreditCard {
        private Drawable mDrawable;
        private String mRegexPattern;
        private String mType;

        public CreditCard(String str, Drawable drawable, String str2) {
            if (str == null || drawable == null || str2 == null) {
                throw new IllegalArgumentException();
            }
            this.mRegexPattern = str;
            this.mDrawable = drawable;
            this.mType = str2;
        }

        public String getRegexPattern() {
            return this.mRegexPattern;
        }

        public Drawable getDrawable() {
            return this.mDrawable;
        }

        public String getType() {
            return this.mType;
        }
    }

    private void initPropertiesFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1418R.styleable.CreditCardEditText);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(0);
            this.mSeparator = string;
            if (string == null) {
                this.mSeparator = "-";
            }
            obtainStyledAttributes.recycle();
        }
    }

    private void init() {
        this.mMinimumCreditCardLength = 13;
        this.mMaximumCreditCardLength = 16;
        Drawable drawable = getResources().getDrawable(DEFAULT_NO_MATCH_FOUND_DRAWABLE);
        this.mNoMatchFoundDrawable = drawable;
        drawable.setBounds(0, 0, 100, 60);
        setInputType(2);
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mNoMatchFoundDrawable, getCompoundDrawables()[3]);
        CreditCartEditTextInterface creditCartEditTextInterface = this.mCreditCardEditTextInterface;
        if (creditCartEditTextInterface != null) {
            this.mListOfCreditCardChecks = creditCartEditTextInterface.mapOfRegexStringAndImageResourceForCreditCardEditText(this);
        }
        CreditCardTextWatcher creditCardTextWatcher = new CreditCardTextWatcher(this, this);
        this.mTextWatcher = creditCardTextWatcher;
        addTextChangedListener(creditCardTextWatcher);
        setCreditCardEditTextListener(new CreditCardPatterns(getContext()));
    }

    private void addSeparatorToText() {
        String replace = getText().toString().replace(this.mSeparator, "");
        if (replace.length() < 16) {
            int i = 0;
            char charAt = this.mSeparator.charAt(0);
            StringBuilder sb = new StringBuilder(replace);
            while (i < replace.length() / 4) {
                int i2 = i + 1;
                sb.insert((i2 * 4) + i, charAt);
                i = i2;
            }
            removeTextChangedListener(this.mTextWatcher);
            setText(sb.toString());
            setSelection(getText().length());
            addTextChangedListener(this.mTextWatcher);
        }
    }

    private void matchRegexPatternsWithText(String str) {
        List<CreditCard> list = this.mListOfCreditCardChecks;
        if (list != null && list.size() > 0) {
            Drawable drawable = null;
            Iterator<CreditCard> it = this.mListOfCreditCardChecks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CreditCard next = it.next();
                if (str.matches(next.getRegexPattern())) {
                    this.mCurrentCreditCardMatch = next;
                    drawable = next.getDrawable();
                    CreditCardTypeListener creditCardTypeListener2 = this.creditCardTypeListener;
                    if (creditCardTypeListener2 != null) {
                        creditCardTypeListener2.onShowCreditCardType(next.getType());
                    }
                    StripeCardTypeListener stripeCardTypeListener2 = this.stripeCardTypeListener;
                    if (stripeCardTypeListener2 != null) {
                        stripeCardTypeListener2.onShowStripeCardType(next.getType());
                    }
                }
            }
            showRightDrawable(drawable);
        }
    }

    private void showRightDrawable(Drawable drawable) {
        if (drawable != null) {
            drawable.setBounds(0, 0, 100, 60);
            setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
            return;
        }
        this.mCurrentCreditCardMatch = null;
        setCompoundDrawables(getCompoundDrawables()[0], getCompoundDrawables()[1], this.mNoMatchFoundDrawable, getCompoundDrawables()[3]);
    }
}
