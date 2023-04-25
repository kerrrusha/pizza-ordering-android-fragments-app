package com.kerrrusha.lab_2.domain.factory;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kerrrusha.lab_2.domain.model.Vector4;

public class TextViewFactory {

    private static final int DEFAULT_TEXT_SIZE = 18;

    public static TextView create(Activity baseActivity, String text, Vector4<Integer> padding) {
        return create(baseActivity, text, DEFAULT_TEXT_SIZE, padding);
    }

    public static TextView create(Activity baseActivity, String text, int textSize, Vector4<Integer> padding) {
        TextView textView = new TextView(baseActivity);

        textView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setPadding(padding.getFirst(), padding.getSecond(), padding.getThird(), padding.getFourth());

        return textView;
    }

}
