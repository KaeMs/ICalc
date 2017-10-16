package com.gmg.icalc.CustomViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

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

    @Override
    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        final InputConnection ic = super.onCreateInputConnection(outAttrs);
        if (ic != null && outAttrs.hintText == null) {
            // If we don't have a hint and our parent is a TextInputLayout, use it's hint for the
            // EditorInfo. This allows us to display a hint in 'extract mode'.
            ViewParent parent = getParent();
            while (parent instanceof View) {
                if (parent instanceof TextInputLayout) {
                    outAttrs.hintText = ((TextInputLayout) parent).getHint();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return ic;
    }
}
