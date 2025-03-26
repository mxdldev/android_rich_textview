package com.richtextview.example;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daquexian.flexiblerichtextview.Attachment;
import com.daquexian.flexiblerichtextview.FlexibleRichTextView;
import com.daquexian.flexiblerichtextview.Tokenizer;

import org.scilab.forge.jlatexmath.core.AjLatexMath;

import java.util.ArrayList;
import java.util.List;

import io.github.kbiakov.codeview.classifier.CodeProcessor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AjLatexMath.getInstance(this)
                .setLatexChineseColor("#000000")
                .setLatexLetterColor("#ff0000")
                .setTextColor("#ff0000")
                .setTextSize(20).
                setLineSpace(1.5f).
                setTypeface(Typeface.createFromAsset(getAssets(), "fonts/FZLanTYK.TTF"));

        CodeProcessor.init(this);

        List<Attachment> attachments = new ArrayList<>();
        attachments.add(new ExampleAttachment("Android Image", "53ce1", true, "https://profile-avatar.csdnimg.cn/bd33db313f104e30b25b5f994cea4865_geduo_83.jpg!1"));
        attachments.add(new ExampleAttachment("Here is a link", "bc41a", false, "https://google.com"));

        FlexibleRichTextView flexibleRichTextView = findViewById(R.id.txt_title);
        Tokenizer.setCenterStartLabels("<center>");
        Tokenizer.setCenterEndLabels("</center>");
        Tokenizer.setTitleStartLabels("<h>");
        Tokenizer.setTitleEndLabels("</h>");

        flexibleRichTextView.setText("<h><center>hi!</center></h>" +
                        "[quote]This is quote\n" +
                        "second line\n" +
                        "third line\n" +
                        "fourth line[/quote]" +
                        "Here is an attachment:[attachment:53ce1]" +
                        "[code]print(\"Hello FlexibleRichTextView!\")[/code]" +
                        "Hello FlexibleRichTextView!\n" +
                        "This is LaTeX:\n" +
                        "$e^{\\pi i} + 1 = 0$\n",
                attachments);
        //flexibleRichTextView.setText("[b]你好[/b]");
    }
}