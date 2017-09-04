package com.gmg.icalc.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.RadioGroup;

import com.gmg.icalc.FontCache;
import com.gmg.icalc.R;

/**
 * Created by Kevin Murvie on 4/10/2017. Fas
 */

public class CustomFontRadioButton extends AppCompatRadioButton {

    private boolean uncheckable;

    public CustomFontRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
        uncheckableCheck(context, attrs);
    }

    public CustomFontRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
        uncheckableCheck(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontRadioButton);
        String fontFace = a.getString(R.styleable.CustomFontRadioButton_rbFontFace);

        try {
            if (fontFace != null) {
                Typeface customFont = FontCache.getTypeface(fontFace, context);
                setTypeface(customFont);
            }
        } finally {
            a.recycle();
        }

    }

    private void uncheckableCheck(Context context, AttributeSet attrs){
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontRadioButton);
        uncheckable = a.getBoolean(R.styleable.CustomFontRadioButton_rbUncheckable, false);
        a.recycle();
    }

    @Override
    public void toggle() {
        if (uncheckable){
            if(isChecked()) {
                if(getParent() instanceof RadioGroup) {
                    ((RadioGroup)getParent()).clearCheck();
                }
            } else {
                setChecked(true);
            }
        } else {
            setChecked(true);
        }
    }
}
