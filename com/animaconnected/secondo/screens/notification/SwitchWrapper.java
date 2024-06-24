package com.animaconnected.secondo.screens.notification;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.animaconnected.secondo.R;

/* loaded from: classes3.dex */
public class SwitchWrapper extends FrameLayout {
    private static final float DISABLED_ALPHA = 0.3f;
    private static final float ENABLED_ALPHA = 1.0f;
    private int mLayoutResourceId;
    private SwitchCompat mSwitch;
    private TextView mTitle;

    public SwitchWrapper(Context context) {
        super(context);
        init(null);
    }

    private void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.SwitchWrapper, 0, 0);
            try {
                this.mLayoutResourceId = obtainStyledAttributes.getResourceId(0, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        LayoutInflater.from(getContext()).inflate(this.mLayoutResourceId, this);
        this.mTitle = (TextView) findViewById(com.kronaby.watch.app.R.id.title_text_view);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(com.kronaby.watch.app.R.id.onoff);
        this.mSwitch = switchCompat;
        switchCompat.setId(getId() + com.kronaby.watch.app.R.id.onoff);
        this.mTitle.setVisibility(8);
        this.mSwitch.setVisibility(8);
        setClickable(true);
    }

    public boolean isChecked() {
        return this.mSwitch.isChecked();
    }

    public void setChecked(boolean z) {
        this.mSwitch.setChecked(z);
    }

    public void setSwitchEnabled(boolean z) {
        float f;
        if (z) {
            f = ENABLED_ALPHA;
        } else {
            f = DISABLED_ALPHA;
        }
        setAlpha(f);
        this.mSwitch.setEnabled(z);
    }

    public void setSwitchListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mSwitch.setOnCheckedChangeListener(onCheckedChangeListener);
        if (onCheckedChangeListener != null) {
            this.mSwitch.setVisibility(0);
        } else {
            this.mSwitch.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        if (str != null) {
            this.mTitle.setText(str);
            this.mTitle.setVisibility(0);
        } else {
            this.mTitle.setVisibility(8);
        }
    }

    public SwitchWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public SwitchWrapper(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        init(attributeSet);
    }
}
