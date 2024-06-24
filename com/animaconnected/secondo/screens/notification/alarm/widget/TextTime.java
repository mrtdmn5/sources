package com.animaconnected.secondo.screens.notification.alarm.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import java.util.Locale;

/* loaded from: classes3.dex */
public class TextTime extends AppCompatTextView {
    private boolean mAttached;
    private TextTimeFormat mFormat;
    private final ContentObserver mFormatChangeObserver;
    private int mHour;
    private int mMinute;
    private boolean mUse24HourFormat;

    public TextTime(Context context) {
        this(context, null);
    }

    private void registerObserver() {
        getContext().getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.mFormatChangeObserver);
    }

    private void unregisterObserver() {
        getContext().getContentResolver().unregisterContentObserver(this.mFormatChangeObserver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTime() {
        CharSequence formatTime12h;
        TextTimeFormat textTimeFormat = this.mFormat;
        if (textTimeFormat == null) {
            return;
        }
        if (this.mUse24HourFormat) {
            formatTime12h = textTimeFormat.formatTime24h(this.mHour, this.mMinute);
        } else {
            formatTime12h = textTimeFormat.formatTime12h(this.mHour, this.mMinute);
        }
        setText(formatTime12h);
        setContentDescription(formatTime12h);
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.mAttached) {
            this.mAttached = true;
            registerObserver();
            updateTime();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAttached) {
            unregisterObserver();
            this.mAttached = false;
        }
    }

    public void setFormatOpts(Locale locale, boolean z) {
        this.mFormat = new TextTimeFormat(getContext(), locale);
        this.mUse24HourFormat = z;
    }

    public void setTime(int r1, int r2) {
        this.mHour = r1;
        this.mMinute = r2;
        updateTime();
    }

    public TextTime(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextTime(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.mFormatChangeObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.animaconnected.secondo.screens.notification.alarm.widget.TextTime.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z) {
                TextTime.this.updateTime();
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                TextTime.this.updateTime();
            }
        };
    }
}
