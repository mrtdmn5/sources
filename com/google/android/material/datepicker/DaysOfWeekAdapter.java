package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kronaby.watch.app.R;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class DaysOfWeekAdapter extends BaseAdapter {
    public static final int CALENDAR_DAY_STYLE;
    public final Calendar calendar;
    public final int daysInWeek;
    public final int firstDayOfWeek;

    static {
        int r0;
        if (Build.VERSION.SDK_INT >= 26) {
            r0 = 4;
        } else {
            r0 = 1;
        }
        CALENDAR_DAY_STYLE = r0;
    }

    public DaysOfWeekAdapter() {
        Calendar utcCalendarOf = UtcDates.getUtcCalendarOf(null);
        this.calendar = utcCalendarOf;
        this.daysInWeek = utcCalendarOf.getMaximum(7);
        this.firstDayOfWeek = utcCalendarOf.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.daysInWeek;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r3) {
        int r0 = this.daysInWeek;
        if (r3 >= r0) {
            return null;
        }
        int r32 = r3 + this.firstDayOfWeek;
        if (r32 > r0) {
            r32 -= r0;
        }
        return Integer.valueOf(r32);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public final View getView(int r4, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int r42 = r4 + this.firstDayOfWeek;
        int r5 = this.daysInWeek;
        if (r42 > r5) {
            r42 -= r5;
        }
        Calendar calendar = this.calendar;
        calendar.set(7, r42);
        textView.setText(calendar.getDisplayName(7, CALENDAR_DAY_STYLE, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
