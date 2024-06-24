package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class MonthAdapter extends BaseAdapter {
    public static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendarOf(null).getMaximum(4);
    public final CalendarConstraints calendarConstraints;
    public CalendarStyle calendarStyle;
    public final DateSelector<?> dateSelector;
    public final Month month;
    public Collection<Long> previouslySelectedDates;

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
        this.previouslySelectedDates = dateSelector.getSelectedDays();
    }

    public final int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return firstPositionInMonth() + this.month.daysInMonth;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r3) {
        return r3 / this.month.daysInWeek;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00d9  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r9, android.view.View r10, android.view.ViewGroup r11) {
        /*
            r8 = this;
            android.content.Context r0 = r11.getContext()
            com.google.android.material.datepicker.CalendarStyle r1 = r8.calendarStyle
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.CalendarStyle r1 = new com.google.android.material.datepicker.CalendarStyle
            r1.<init>(r0)
            r8.calendarStyle = r1
        Lf:
            r0 = r10
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r10 != 0) goto L27
            android.content.Context r10 = r11.getContext()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r10)
            r0 = 2131624219(0x7f0e011b, float:1.8875612E38)
            android.view.View r10 = r10.inflate(r0, r11, r1)
            r0 = r10
            android.widget.TextView r0 = (android.widget.TextView) r0
        L27:
            int r10 = r8.firstPositionInMonth()
            int r10 = r9 - r10
            if (r10 < 0) goto Lca
            com.google.android.material.datepicker.Month r11 = r8.month
            int r2 = r11.daysInMonth
            if (r10 < r2) goto L37
            goto Lca
        L37:
            r2 = 1
            int r10 = r10 + r2
            r0.setTag(r11)
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            java.util.Locale r3 = r3.locale
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r5 = "%d"
            java.lang.String r3 = java.lang.String.format(r3, r5, r4)
            r0.setText(r3)
            java.util.Calendar r3 = r11.firstOfMonth
            java.util.Calendar r3 = com.google.android.material.datepicker.UtcDates.getDayCopy(r3)
            r4 = 5
            r3.set(r4, r10)
            long r5 = r3.getTimeInMillis()
            java.util.Calendar r10 = com.google.android.material.datepicker.UtcDates.getTodayCalendar()
            r10.set(r4, r2)
            java.util.Calendar r10 = com.google.android.material.datepicker.UtcDates.getDayCopy(r10)
            r3 = 2
            r10.get(r3)
            int r3 = r10.get(r2)
            r7 = 7
            r10.getMaximum(r7)
            r10.getActualMaximum(r4)
            r10.getTimeInMillis()
            int r10 = r11.year
            java.lang.String r11 = "UTC"
            if (r10 != r3) goto La6
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r3 = "MMMEd"
            android.icu.text.DateFormat r10 = android.icu.text.DateFormat.getInstanceForSkeleton(r3, r10)
            android.icu.util.TimeZone r11 = android.icu.util.TimeZone.getTimeZone(r11)
            r10.setTimeZone(r11)
            java.util.Date r11 = new java.util.Date
            r11.<init>(r5)
            java.lang.String r10 = r10.format(r11)
            r0.setContentDescription(r10)
            goto Lc3
        La6:
            java.util.Locale r10 = java.util.Locale.getDefault()
            java.lang.String r3 = "yMMMEd"
            android.icu.text.DateFormat r10 = android.icu.text.DateFormat.getInstanceForSkeleton(r3, r10)
            android.icu.util.TimeZone r11 = android.icu.util.TimeZone.getTimeZone(r11)
            r10.setTimeZone(r11)
            java.util.Date r11 = new java.util.Date
            r11.<init>(r5)
            java.lang.String r10 = r10.format(r11)
            r0.setContentDescription(r10)
        Lc3:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto Ld2
        Lca:
            r10 = 8
            r0.setVisibility(r10)
            r0.setEnabled(r1)
        Ld2:
            java.lang.Long r9 = r8.getItem(r9)
            if (r9 != 0) goto Ld9
            goto Le0
        Ld9:
            long r9 = r9.longValue()
            r8.updateSelectedState(r0, r9)
        Le0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }

    public final void updateSelectedState(TextView textView, long j) {
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        boolean z = false;
        if (this.calendarConstraints.validator.isValid(j)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                calendarItemStyle = this.calendarStyle.selectedDay;
            } else if (UtcDates.getTodayCalendar().getTimeInMillis() == j) {
                calendarItemStyle = this.calendarStyle.todayDay;
            } else {
                calendarItemStyle = this.calendarStyle.day;
            }
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.calendarStyle.invalidDay;
        }
        calendarItemStyle.styleItem(textView);
    }

    public final void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        Month create = Month.create(j);
        Month month = this.month;
        if (create.equals(month)) {
            Calendar dayCopy = UtcDates.getDayCopy(month.firstOfMonth);
            dayCopy.setTimeInMillis(j);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt((materialCalendarGridView.getAdapter().firstPositionInMonth() + (dayCopy.get(5) - 1)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    @Override // android.widget.Adapter
    public final Long getItem(int r4) {
        Month month = this.month;
        if (r4 < month.daysFromStartOfWeekToFirstOfMonth() || r4 > (month.daysFromStartOfWeekToFirstOfMonth() + month.daysInMonth) - 1) {
            return null;
        }
        int daysFromStartOfWeekToFirstOfMonth = (r4 - month.daysFromStartOfWeekToFirstOfMonth()) + 1;
        Calendar dayCopy = UtcDates.getDayCopy(month.firstOfMonth);
        dayCopy.set(5, daysFromStartOfWeekToFirstOfMonth);
        return Long.valueOf(dayCopy.getTimeInMillis());
    }
}
