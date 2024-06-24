package com.animaconnected.secondo.screens.notification.alarm.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.format.DateFormat;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.kronaby.watch.app.R;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class TextTimeFormat {
    private final boolean areAmPmStringsLong;
    private final Locale mLocale;
    private final Resources mResources;

    public TextTimeFormat(Context context, Locale locale) {
        this.mResources = context.getResources();
        this.mLocale = locale;
        this.areAmPmStringsLong = areAmPmStringsLong(locale);
    }

    private static boolean areAmPmStringsLong(Locale locale) {
        for (String str : new DateFormatSymbols(locale).getAmPmStrings()) {
            if (str.replace(InstructionFileId.DOT, "").length() > 3) {
                return true;
            }
        }
        return false;
    }

    private Date getTime(int r3, int r4) {
        Calendar calendar = Calendar.getInstance(this.mLocale);
        calendar.set(11, r3);
        calendar.set(12, r4);
        return calendar.getTime();
    }

    public CharSequence formatTime12h(int r7, int r8) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.getBestDateTimePattern(this.mLocale, "hma").replaceAll(" ", "\u200a"), this.mLocale);
        FieldPosition fieldPosition = new FieldPosition(DateFormat.Field.AM_PM);
        SpannableString spannableString = new SpannableString(simpleDateFormat.format(getTime(r7, r8), new StringBuffer(), fieldPosition));
        spannableString.setSpan(new RelativeSizeSpan(this.mResources.getFraction(R.fraction.ampm_font_size_scale, 1, 1)), fieldPosition.getBeginIndex(), fieldPosition.getEndIndex(), 33);
        spannableString.setSpan(new StyleSpan(0), fieldPosition.getBeginIndex(), fieldPosition.getEndIndex(), 33);
        spannableString.setSpan(new TypefaceSpan("sans-serif"), fieldPosition.getBeginIndex(), fieldPosition.getEndIndex(), 33);
        if (this.areAmPmStringsLong) {
            spannableString.setSpan(new RelativeSizeSpan(this.mResources.getFraction(R.fraction.reduced_clock_font_size_scale, 1, 1)), 0, spannableString.length(), 33);
        }
        return spannableString;
    }

    public CharSequence formatTime24h(int r4, int r5) {
        return new SpannableString(new SimpleDateFormat(android.text.format.DateFormat.getBestDateTimePattern(this.mLocale, "Hm"), this.mLocale).format(getTime(r4, r5)));
    }
}
