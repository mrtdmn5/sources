package com.animaconnected.secondo.screens;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class CustomToolbar extends LinearLayout {
    public CustomToolbar(Context context) {
        super(context);
        init(context, null);
    }

    public void init(Context context, AttributeSet attributeSet) {
        AnimatedToolbar animatedToolbar = (AnimatedToolbar) View.inflate(context, R.layout.custom_toolbar, this).findViewById(R.id.animated_toolbar);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, com.animaconnected.secondo.R.styleable.CustomToolbar, 0, 0);
            try {
                int color = obtainStyledAttributes.getColor(0, 0);
                int color2 = obtainStyledAttributes.getColor(2, 0);
                Drawable drawable = obtainStyledAttributes.getDrawable(1);
                obtainStyledAttributes.recycle();
                animatedToolbar.setBackgroundColor(color);
                animatedToolbar.setTintColor(color2);
                if (drawable != null) {
                    animatedToolbar.setHelpActionDrawable(drawable);
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
    }

    public CustomToolbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CustomToolbar(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        init(context, attributeSet);
    }

    public CustomToolbar(Context context, AttributeSet attributeSet, int r3, int r4) {
        super(context, attributeSet, r3, r4);
        init(context, attributeSet);
    }
}
