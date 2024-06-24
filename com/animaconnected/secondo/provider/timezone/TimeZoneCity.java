package com.animaconnected.secondo.provider.timezone;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class TimeZoneCity {
    private final String mGmtRawOffsetString;
    private final String mId;
    private final int mIndex;
    private final String mIndexString;
    private final String mName;
    private String mNameUpperCase;
    private String mNameUpperCaseNoSpecialCharacters;
    private final String mPhoneticName;
    private final TimeZone mTimeZone;

    /* loaded from: classes3.dex */
    public static final class NameComparator implements Comparator<TimeZoneCity> {
        private final Comparator<TimeZoneCity> mDelegate = new NameIndexComparator();
        private final Collator mNameCollator = Collator.getInstance();

        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            int compare = this.mDelegate.compare(timeZoneCity, timeZoneCity2);
            return compare == 0 ? this.mNameCollator.compare(timeZoneCity.getPhoneticName(), timeZoneCity2.getPhoneticName()) : compare;
        }
    }

    /* loaded from: classes3.dex */
    public static final class NameIndexComparator implements Comparator<TimeZoneCity> {
        private final Collator mNameCollator = Collator.getInstance();

        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            int compare = Integer.compare(timeZoneCity.getIndex(), timeZoneCity2.getIndex());
            return compare == 0 ? this.mNameCollator.compare(timeZoneCity.getIndexString(), timeZoneCity2.getIndexString()) : compare;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UtcOffsetComparator implements Comparator<TimeZoneCity> {
        private final Comparator<TimeZoneCity> mDelegate1 = new UtcOffsetIndexComparator();
        private final Comparator<TimeZoneCity> mDelegate2 = new NameComparator();

        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            int compare = this.mDelegate1.compare(timeZoneCity, timeZoneCity2);
            return compare == 0 ? this.mDelegate2.compare(timeZoneCity, timeZoneCity2) : compare;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UtcOffsetIndexComparator implements Comparator<TimeZoneCity> {
        private final long now = System.currentTimeMillis();

        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            return Integer.compare(timeZoneCity.getTimeZone().getOffset(this.now), timeZoneCity2.getTimeZone().getOffset(this.now));
        }
    }

    /* loaded from: classes3.dex */
    public static final class UtcRawOffsetComparator implements Comparator<TimeZoneCity> {
        private final Comparator<TimeZoneCity> mDelegate1 = new UtcRawOffsetIndexComparator();
        private final Comparator<TimeZoneCity> mDelegate2 = new NameComparator();

        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            int compare = this.mDelegate1.compare(timeZoneCity, timeZoneCity2);
            return compare == 0 ? this.mDelegate2.compare(timeZoneCity, timeZoneCity2) : compare;
        }
    }

    /* loaded from: classes3.dex */
    public static final class UtcRawOffsetIndexComparator implements Comparator<TimeZoneCity> {
        @Override // java.util.Comparator
        public int compare(TimeZoneCity timeZoneCity, TimeZoneCity timeZoneCity2) {
            return Integer.compare(timeZoneCity.getTimeZone().getRawOffset(), timeZoneCity2.getTimeZone().getRawOffset());
        }
    }

    public TimeZoneCity(String str, int r2, String str2, String str3, String str4, TimeZone timeZone, String str5) {
        if (str != null && str2 != null && str3 != null && str4 != null && timeZone != null && str5 != null) {
            this.mId = str;
            this.mIndex = r2;
            this.mIndexString = str2;
            this.mName = str3;
            this.mPhoneticName = str4;
            this.mTimeZone = timeZone;
            this.mGmtRawOffsetString = str5;
            return;
        }
        throw new IllegalArgumentException();
    }

    private String getNameUpperCaseNoSpecialCharacters() {
        if (this.mNameUpperCaseNoSpecialCharacters == null) {
            this.mNameUpperCaseNoSpecialCharacters = removeSpecialCharacters(getNameUpperCase());
        }
        return this.mNameUpperCaseNoSpecialCharacters;
    }

    public static String removeSpecialCharacters(String str) {
        return str.replaceAll("[ -.']", "");
    }

    public String getGmtRawOffsetString() {
        return this.mGmtRawOffsetString;
    }

    public String getId() {
        return this.mId;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getIndexString() {
        return this.mIndexString;
    }

    public String getName() {
        return this.mName;
    }

    public String getNameUpperCase() {
        if (this.mNameUpperCase == null) {
            this.mNameUpperCase = this.mName.toUpperCase(Locale.getDefault());
        }
        return this.mNameUpperCase;
    }

    public String getPhoneticName() {
        return this.mPhoneticName;
    }

    public TimeZone getTimeZone() {
        return this.mTimeZone;
    }

    public boolean matches(String str) {
        return getNameUpperCaseNoSpecialCharacters().startsWith(str);
    }

    public String toString() {
        return String.format(Locale.US, "TimeZoneCity {id=%s, index=%d, indexString=%s, name=%s, phonetic=%s, tz=%s}", this.mId, Integer.valueOf(this.mIndex), this.mIndexString, this.mName, this.mPhoneticName, this.mTimeZone.getID());
    }
}
