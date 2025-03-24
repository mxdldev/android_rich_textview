package org.scilab.forge.jlatexmath.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;

public class AjLatexMath {

    private static Context mContext;
    private static Paint st;
    private static int latexLetterColor; // LaTex公式字符的颜色
    private static int latexChineseColor; // LaTex公式文字的颜色
    private static int textSize; // 字体的大小
    private static int textColor; // 字体颜色
    private static Typeface typeface; // 字体
    private static float lineSpace; // 行间距

    private static class SingletonHolder {
        private static final AjLatexMath INSTANCE = new AjLatexMath();
    }

    private AjLatexMath() {
        latexLetterColor = Color.parseColor("#3F2E26");
        latexChineseColor = Color.parseColor("#7a7a7a");
        textSize = 18;

        st = new Paint();
        st.setStyle(Style.FILL_AND_STROKE);
        st.setColor(latexLetterColor);
        st.setStrokeWidth(0);
    }

    public static AjLatexMath getInstance(Context context) {
        AjLatexMath instance = SingletonHolder.INSTANCE;
        instance.mContext = context;
        TeXFormula.getPartialTeXFormula("{x^{2}+ x-1= 0 }").setDEBUG(false);
        return instance;
    }

    public static AssetManager getAssetManager() {
        if (mContext == null) {
            throw new IllegalStateException("Context is not initialized.");
        }
        return mContext.getAssets();
    }

    public static Context getContext() {
        return mContext;
    }

    public static Paint getPaint() {
        return st;
    }

    public static float getLeading(float textSize) {
        st.setTextSize(textSize);
        return st.getFontSpacing();
    }

    public AjLatexMath setLatexChineseColor(String textColor) {
        try {
            this.latexChineseColor = Color.parseColor(textColor);
        } catch (IllegalArgumentException e) {
            // 处理颜色解析异常
            e.printStackTrace();
        }
        return this;
    }

    public AjLatexMath setLatexLetterColor(String latexColor) {
        try {
            this.latexLetterColor = Color.parseColor(latexColor);
            st.setColor(this.latexLetterColor);
        } catch (IllegalArgumentException e) {
            // 处理颜色解析异常
            e.printStackTrace();
        }
        return this;
    }

    public AjLatexMath setTextSize(int size) {
        this.textSize = size;
        return this;
    }
    public AjLatexMath setTextColor(String textColor) {
        try {
            this.textColor = Color.parseColor(textColor);
        } catch (Exception e) {
        }
        return this;
    }

    public AjLatexMath setTypeface(Typeface typeface) {
        this.typeface = typeface;
        return this;
    }

    public AjLatexMath setLineSpace(float lineSpace) {
        this.lineSpace = lineSpace;
        return this;
    }

    public static int getLatexChineseColor() {
        return latexChineseColor;
    }

    public static int getLatexLetterColor() {
        return latexLetterColor;
    }

    public static int getTextSize() {
        return textSize;
    }

    public static Typeface getTypeface() {
        return typeface;
    }

    public static float getLineSpace() {
        return lineSpace;
    }

    public static int getTextColor() {
        return textColor;
    }
}