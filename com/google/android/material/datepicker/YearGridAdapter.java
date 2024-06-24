package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialCalendar;
import com.kronaby.watch.app.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> materialCalendar;

    /* loaded from: classes3.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.materialCalendar.calendarConstraints.yearSpan;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(ViewHolder viewHolder, int r9) {
        CalendarItemStyle calendarItemStyle;
        ViewHolder viewHolder2 = viewHolder;
        MaterialCalendar<?> materialCalendar = this.materialCalendar;
        final int r1 = materialCalendar.calendarConstraints.start.year + r9;
        String string = viewHolder2.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        String format = String.format(Locale.getDefault(), "%d", Integer.valueOf(r1));
        TextView textView = viewHolder2.textView;
        textView.setText(format);
        textView.setContentDescription(String.format(string, Integer.valueOf(r1)));
        CalendarStyle calendarStyle = materialCalendar.calendarStyle;
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        if (todayCalendar.get(1) == r1) {
            calendarItemStyle = calendarStyle.todayYear;
        } else {
            calendarItemStyle = calendarStyle.year;
        }
        Iterator<Long> it = materialCalendar.dateSelector.getSelectedDays().iterator();
        while (it.hasNext()) {
            todayCalendar.setTimeInMillis(it.next().longValue());
            if (todayCalendar.get(1) == r1) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(textView);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YearGridAdapter yearGridAdapter = YearGridAdapter.this;
                Month create = Month.create(r1, yearGridAdapter.materialCalendar.current.month);
                MaterialCalendar<?> materialCalendar2 = yearGridAdapter.materialCalendar;
                CalendarConstraints calendarConstraints = materialCalendar2.calendarConstraints;
                Month month = calendarConstraints.start;
                Calendar calendar = month.firstOfMonth;
                Calendar calendar2 = create.firstOfMonth;
                if (calendar2.compareTo(calendar) < 0) {
                    create = month;
                } else {
                    Month month2 = calendarConstraints.end;
                    if (calendar2.compareTo(month2.firstOfMonth) > 0) {
                        create = month2;
                    }
                }
                materialCalendar2.setCurrentMonth(create);
                materialCalendar2.setSelector(MaterialCalendar.CalendarSelector.DAY);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int r4) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
