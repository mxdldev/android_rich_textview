package com.richtextview.example;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daquexian.flexiblerichtextview.FlexibleRichTextView;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AjLatexMath.getInstance(this)
                .setTextColor("#FF0000")
                .setLatexColor("#FF0000")
                .setTextSize(20).
                setLineSpace(1.5f).
                setTypeface(Typeface.createFromAsset(getAssets(), "fonts/FZLanTYK.TTF"));
        CodeProcessor.init(this);
        FlexibleRichTextView flexibleRichTextView = findViewById(R.id.txt_title);
        //flexibleRichTextView.setText("二次函数:$$y=x^2+2$$的曲线图");
        //flexibleRichTextView.setText("$$F_{\\text {浮 }}=G-F_{\\text {拉 }}$$");
        flexibleRichTextView.setText("能应用同一直线上二力的二次函数:$y=x^2+2$的曲线图,合成和二力平衡的知识推理得出弹簧测力计测量浮力大小的原理$$F_{\\text {浮 }}=G-F_{\\text {拉 }}$$，通过实验观察和演绎推理认识浮力产");
        //flexibleRichTextView.setText("牛顿第二定律：$F = ma$，积分公式：$\\int_{a}^{b} x^2 \\, dx$");
    }
}