package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;

/* loaded from: classes3.dex */
public final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new AnonymousClass1();
    public final int daysInMonth;
    public final int daysInWeek;
    public final Calendar firstOfMonth;
    public String longName;
    public final int month;
    public final long timeInMillis;
    public final int year;

    /* renamed from: com.google.android.material.datepicker.Month$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        public final Month createFromParcel(Parcel parcel) {
            return Month.create(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Month[] newArray(int r1) {
            return new Month[r1];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar dayCopy = UtcDates.getDayCopy(calendar);
        this.firstOfMonth = dayCopy;
        this.month = dayCopy.get(2);
        this.year = dayCopy.get(1);
        this.daysInWeek = dayCopy.getMaximum(7);
        this.daysInMonth = dayCopy.getActualMaximum(5);
        this.timeInMillis = dayCopy.getTimeInMillis();
    }

    public static Month create(int r2, int r3) {
        Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
        utcCalendarOf.set(1, r2);
        utcCalendarOf.set(2, r3);
        return new Month(utcCalendarOf);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.firstOfMonth.compareTo(month.firstOfMonth);
    }

    public final int daysFromStartOfWeekToFirstOfMonth() {
        Calendar calendar = this.firstOfMonth;
        int firstDayOfWeek = calendar.get(7) - calendar.getFirstDayOfWeek();
        if (firstDayOfWeek < 0) {
            return firstDayOfWeek + this.daysInWeek;
        }
        return firstDayOfWeek;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        if (this.month == month.month && this.year == month.year) {
            return true;
        }
        return false;
    }

    public final String getLongName() {
        if (this.longName == null) {
            this.longName = DateUtils.formatDateTime(null, this.firstOfMonth.getTimeInMillis(), 8228);
        }
        return this.longName;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.month), Integer.valueOf(this.year)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        parcel.writeInt(this.year);
        parcel.writeInt(this.month);
    }

    public static Month create(long j) {
        Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
        utcCalendarOf.setTimeInMillis(j);
        return new Month(utcCalendarOf);
    }
}
