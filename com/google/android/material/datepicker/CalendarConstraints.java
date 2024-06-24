package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Arrays;
import java.util.GregorianCalendar;

/* loaded from: classes3.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new AnonymousClass1();
    public final Month end;
    public final int monthSpan;
    public final Month openAt;
    public final Month start;
    public final DateValidator validator;
    public final int yearSpan;

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints[] newArray(int r1) {
            return new CalendarConstraints[r1];
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        public final long end;
        public Long openAt;
        public final long start;
        public final DateValidator validator;
        public static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        public static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);

        public Builder(CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = new DateValidatorPointForward(Long.MIN_VALUE);
            this.start = calendarConstraints.start.timeInMillis;
            this.end = calendarConstraints.end.timeInMillis;
            this.openAt = Long.valueOf(calendarConstraints.openAt.timeInMillis);
            this.validator = calendarConstraints.validator;
        }
    }

    /* loaded from: classes3.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3) {
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.validator = dateValidator;
        if (month3 != null && month.firstOfMonth.compareTo(month3.firstOfMonth) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.firstOfMonth.compareTo(month2.firstOfMonth) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (month.firstOfMonth instanceof GregorianCalendar) {
            int r4 = month2.year;
            int r5 = month.year;
            this.monthSpan = (month2.month - month.month) + ((r4 - r5) * 12) + 1;
            this.yearSpan = (r4 - r5) + 1;
            return;
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        if (this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && ObjectsCompat$Api19Impl.equals(this.openAt, calendarConstraints.openAt) && this.validator.equals(calendarConstraints.validator)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, this.validator});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r3) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
    }
}
