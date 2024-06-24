package com.j256.ormlite.field.types;

import java.text.SimpleDateFormat;

/* loaded from: classes3.dex */
public final class DateStringFormatConfig {
    public final SimpleDateFormat dateFormat;
    public final String dateFormatStr;

    public DateStringFormatConfig(String str) {
        this.dateFormatStr = str;
        this.dateFormat = new SimpleDateFormat(str);
    }

    public final String toString() {
        return this.dateFormatStr;
    }
}
