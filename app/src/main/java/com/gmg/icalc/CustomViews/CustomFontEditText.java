package com.gmg.icalc.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.gmg.icalc.FontCache;
import com.gmg.icalc.R;

/**
 * Created by Kevin Murvie on 8/18/2017. IC
 */

public class CustomFontEditText extends android.support.v7.widget.AppCompatEditText {

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFontTextView);
        String fontFace;
        Typeface customFont;

        try {
            fontFace = a.getString(R.styleable.CustomFontTextView_fontFace);
        } finally {
            a.recycle();
        }

        if (fontFace != null) {
            customFont = FontCache.getTypeface(fontFace, context);
            setTypeface(customFont);
        }
    }
}
