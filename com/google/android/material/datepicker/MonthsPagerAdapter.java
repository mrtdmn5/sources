package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.kronaby.watch.app.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final CalendarConstraints calendarConstraints;
    public final DateSelector<?> dateSelector;
    public final int itemHeight;
    public final MaterialCalendar.OnDayClickListener onDayClickListener;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            new ViewCompat.AnonymousClass4().set(textView, Boolean.TRUE);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (!z) {
                textView.setVisibility(8);
            }
        }
    }

    public MonthsPagerAdapter(ContextThemeWrapper contextThemeWrapper, DateSelector dateSelector, CalendarConstraints calendarConstraints, MaterialCalendar.AnonymousClass3 anonymousClass3) {
        int r4;
        Calendar calendar = calendarConstraints.start.firstOfMonth;
        Month month = calendarConstraints.openAt;
        if (calendar.compareTo(month.firstOfMonth) <= 0) {
            if (month.firstOfMonth.compareTo(calendarConstraints.end.firstOfMonth) <= 0) {
                int r0 = MonthAdapter.MAXIMUM_WEEKS;
                int r1 = MaterialCalendar.$r8$clinit;
                int dimensionPixelSize = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * r0;
                if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
                    r4 = contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
                } else {
                    r4 = 0;
                }
                this.itemHeight = dimensionPixelSize + r4;
                this.calendarConstraints = calendarConstraints;
                this.dateSelector = dateSelector;
                this.onDayClickListener = anonymousClass3;
                setHasStableIds(true);
                return;
            }
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        throw new IllegalArgumentException("firstPage cannot be after currentPage");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.calendarConstraints.monthSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r3) {
        Calendar dayCopy = UtcDates.getDayCopy(this.calendarConstraints.start.firstOfMonth);
        dayCopy.add(2, r3);
        return new Month(dayCopy).firstOfMonth.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(ViewHolder viewHolder, int r6) {
        ViewHolder viewHolder2 = viewHolder;
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        Calendar dayCopy = UtcDates.getDayCopy(calendarConstraints.start.firstOfMonth);
        dayCopy.add(2, r6);
        Month month = new Month(dayCopy);
        viewHolder2.monthTitle.setText(month.getLongName());
        final MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() != null && month.equals(materialCalendarGridView.getAdapter().month)) {
            materialCalendarGridView.invalidate();
            MonthAdapter adapter = materialCalendarGridView.getAdapter();
            Iterator<Long> it = adapter.previouslySelectedDates.iterator();
            while (it.hasNext()) {
                adapter.updateSelectedStateForDate(materialCalendarGridView, it.next().longValue());
            }
            DateSelector<?> dateSelector = adapter.dateSelector;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    adapter.updateSelectedStateForDate(materialCalendarGridView, it2.next().longValue());
                }
                adapter.previouslySelectedDates = dateSelector.getSelectedDays();
            }
        } else {
            MonthAdapter monthAdapter = new MonthAdapter(month, this.dateSelector, calendarConstraints);
            materialCalendarGridView.setNumColumns(month.daysInWeek);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        }
        materialCalendarGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.datepicker.MonthsPagerAdapter.1
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
            @Override // android.widget.AdapterView.OnItemClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.google.android.material.datepicker.MaterialCalendarGridView r1 = r2
                    com.google.android.material.datepicker.MonthAdapter r2 = r1.getAdapter()
                    int r4 = r2.firstPositionInMonth()
                    if (r3 < r4) goto L1b
                    com.google.android.material.datepicker.Month r2 = r2.month
                    int r4 = r2.daysFromStartOfWeekToFirstOfMonth()
                    int r2 = r2.daysInMonth
                    int r4 = r4 + r2
                    int r4 = r4 + (-1)
                    if (r3 > r4) goto L1b
                    r2 = 1
                    goto L1c
                L1b:
                    r2 = 0
                L1c:
                    if (r2 == 0) goto L71
                    com.google.android.material.datepicker.MonthsPagerAdapter r2 = com.google.android.material.datepicker.MonthsPagerAdapter.this
                    com.google.android.material.datepicker.MaterialCalendar$OnDayClickListener r2 = r2.onDayClickListener
                    com.google.android.material.datepicker.MonthAdapter r1 = r1.getAdapter()
                    java.lang.Long r1 = r1.getItem(r3)
                    long r3 = r1.longValue()
                    com.google.android.material.datepicker.MaterialCalendar$3 r2 = (com.google.android.material.datepicker.MaterialCalendar.AnonymousClass3) r2
                    com.google.android.material.datepicker.MaterialCalendar r1 = com.google.android.material.datepicker.MaterialCalendar.this
                    com.google.android.material.datepicker.CalendarConstraints r2 = r1.calendarConstraints
                    com.google.android.material.datepicker.CalendarConstraints$DateValidator r2 = r2.validator
                    boolean r2 = r2.isValid(r3)
                    if (r2 == 0) goto L71
                    com.google.android.material.datepicker.DateSelector<S> r2 = r1.dateSelector
                    r2.select()
                    java.util.LinkedHashSet<com.google.android.material.datepicker.OnSelectionChangedListener<S>> r2 = r1.onSelectionChangedListeners
                    java.util.Iterator r2 = r2.iterator()
                L47:
                    boolean r3 = r2.hasNext()
                    if (r3 == 0) goto L5d
                    java.lang.Object r3 = r2.next()
                    com.google.android.material.datepicker.OnSelectionChangedListener r3 = (com.google.android.material.datepicker.OnSelectionChangedListener) r3
                    com.google.android.material.datepicker.DateSelector<S> r4 = r1.dateSelector
                    java.lang.Object r4 = r4.getSelection()
                    r3.onSelectionChanged(r4)
                    goto L47
                L5d:
                    androidx.recyclerview.widget.RecyclerView r2 = r1.recyclerView
                    androidx.recyclerview.widget.RecyclerView$Adapter r2 = r2.getAdapter()
                    r2.notifyDataSetChanged()
                    androidx.recyclerview.widget.RecyclerView r1 = r1.yearSelector
                    if (r1 == 0) goto L71
                    androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.getAdapter()
                    r1.notifyDataSetChanged()
                L71:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.MonthsPagerAdapter.AnonymousClass1.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r4) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
            return new ViewHolder(linearLayout, true);
        }
        return new ViewHolder(linearLayout, false);
    }
}
