package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.kronaby.watch.app.R;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* loaded from: classes3.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    public static final /* synthetic */ int $r8$clinit = 0;
    public CalendarConstraints calendarConstraints;
    public CalendarSelector calendarSelector;
    public CalendarStyle calendarStyle;
    public Month current;
    public DateSelector<S> dateSelector;
    public View dayFrame;
    public RecyclerView recyclerView;
    public int themeResId;
    public View yearFrame;
    public RecyclerView yearSelector;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements OnDayClickListener {
        public AnonymousClass3() {
        }
    }

    /* loaded from: classes3.dex */
    public enum CalendarSelector {
        DAY,
        YEAR
    }

    /* loaded from: classes3.dex */
    public interface OnDayClickListener {
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public final boolean addOnSelectionChangedListener(MaterialDatePicker.AnonymousClass4 anonymousClass4) {
        return super.addOnSelectionChangedListener(anonymousClass4);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.themeResId = bundle.getInt("THEME_RES_ID_KEY");
        this.dateSelector = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.current = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int r1;
        final int r4;
        PagerSnapHelper pagerSnapHelper;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.themeResId);
        this.calendarStyle = new CalendarStyle(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month month = this.calendarConstraints.start;
        if (MaterialDatePicker.isFullscreen(contextThemeWrapper)) {
            r1 = R.layout.mtrl_calendar_vertical;
            r4 = 1;
        } else {
            r1 = R.layout.mtrl_calendar_horizontal;
            r4 = 0;
        }
        View inflate = cloneInContext.inflate(r1, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        int r6 = MonthAdapter.MAXIMUM_WEEKS;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding) * (r6 - 1)) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * r6) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AnonymousClass1());
        gridView.setAdapter((ListAdapter) new DaysOfWeekAdapter());
        gridView.setNumColumns(month.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.recyclerView.setLayoutManager(new SmoothCalendarLayoutManager(getContext(), r4) { // from class: com.google.android.material.datepicker.MaterialCalendar.2
            @Override // androidx.recyclerview.widget.LinearLayoutManager
            public final void calculateExtraLayoutSpace(RecyclerView.State state, int[] r5) {
                int r42 = r4;
                MaterialCalendar materialCalendar = MaterialCalendar.this;
                if (r42 == 0) {
                    r5[0] = materialCalendar.recyclerView.getWidth();
                    r5[1] = materialCalendar.recyclerView.getWidth();
                } else {
                    r5[0] = materialCalendar.recyclerView.getHeight();
                    r5[1] = materialCalendar.recyclerView.getHeight();
                }
            }
        });
        this.recyclerView.setTag("MONTHS_VIEW_GROUP_TAG");
        final MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(contextThemeWrapper, this.dateSelector, this.calendarConstraints, new AnonymousClass3());
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.yearSelector = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            this.yearSelector.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.google.android.material.datepicker.MaterialCalendar.4
                public final Calendar startItem = UtcDates.getUtcCalendarOf(null);
                public final Calendar endItem = UtcDates.getUtcCalendarOf(null);

                @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
                public final void onDraw(Canvas canvas, RecyclerView recyclerView4) {
                    Long l;
                    int r13;
                    int width;
                    if ((recyclerView4.getAdapter() instanceof YearGridAdapter) && (recyclerView4.getLayoutManager() instanceof GridLayoutManager)) {
                        YearGridAdapter yearGridAdapter = (YearGridAdapter) recyclerView4.getAdapter();
                        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView4.getLayoutManager();
                        MaterialCalendar materialCalendar = MaterialCalendar.this;
                        for (Pair<Long, Long> pair : materialCalendar.dateSelector.getSelectedRanges()) {
                            Long l2 = pair.first;
                            if (l2 != null && (l = pair.second) != null) {
                                long longValue = l2.longValue();
                                Calendar calendar = this.startItem;
                                calendar.setTimeInMillis(longValue);
                                long longValue2 = l.longValue();
                                Calendar calendar2 = this.endItem;
                                calendar2.setTimeInMillis(longValue2);
                                int r62 = calendar.get(1) - yearGridAdapter.materialCalendar.calendarConstraints.start.year;
                                int r5 = calendar2.get(1) - yearGridAdapter.materialCalendar.calendarConstraints.start.year;
                                View findViewByPosition = gridLayoutManager.findViewByPosition(r62);
                                View findViewByPosition2 = gridLayoutManager.findViewByPosition(r5);
                                int spanCount = r62 / gridLayoutManager.getSpanCount();
                                int spanCount2 = r5 / gridLayoutManager.getSpanCount();
                                for (int r9 = spanCount; r9 <= spanCount2; r9++) {
                                    View findViewByPosition3 = gridLayoutManager.findViewByPosition(gridLayoutManager.getSpanCount() * r9);
                                    if (findViewByPosition3 != null) {
                                        int top = findViewByPosition3.getTop() + materialCalendar.calendarStyle.year.insets.top;
                                        int bottom = findViewByPosition3.getBottom() - materialCalendar.calendarStyle.year.insets.bottom;
                                        if (r9 == spanCount) {
                                            r13 = (findViewByPosition.getWidth() / 2) + findViewByPosition.getLeft();
                                        } else {
                                            r13 = 0;
                                        }
                                        if (r9 == spanCount2) {
                                            width = (findViewByPosition2.getWidth() / 2) + findViewByPosition2.getLeft();
                                        } else {
                                            width = recyclerView4.getWidth();
                                        }
                                        canvas.drawRect(r13, top, width, bottom, materialCalendar.calendarStyle.rangeFill);
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            final MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.month_navigation_fragment_toggle);
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            ViewCompat.setAccessibilityDelegate(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.datepicker.MaterialCalendar.5
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    String string;
                    this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    if (materialCalendar.dayFrame.getVisibility() == 0) {
                        string = materialCalendar.getString(R.string.mtrl_picker_toggle_to_year_selection);
                    } else {
                        string = materialCalendar.getString(R.string.mtrl_picker_toggle_to_day_selection);
                    }
                    accessibilityNodeInfoCompat.setHintText(string);
                }
            });
            MaterialButton materialButton2 = (MaterialButton) inflate.findViewById(R.id.month_navigation_previous);
            materialButton2.setTag("NAVIGATION_PREV_TAG");
            MaterialButton materialButton3 = (MaterialButton) inflate.findViewById(R.id.month_navigation_next);
            materialButton3.setTag("NAVIGATION_NEXT_TAG");
            this.yearFrame = inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
            this.dayFrame = inflate.findViewById(R.id.mtrl_calendar_day_selector_frame);
            setSelector(CalendarSelector.DAY);
            materialButton.setText(this.current.getLongName());
            this.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.6
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView recyclerView4, int r2) {
                    if (r2 == 0) {
                        recyclerView4.announceForAccessibility(materialButton.getText());
                    }
                }

                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrolled(RecyclerView recyclerView4, int r5, int r62) {
                    int findLastVisibleItemPosition;
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    if (r5 < 0) {
                        findLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                    } else {
                        findLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findLastVisibleItemPosition();
                    }
                    MonthsPagerAdapter monthsPagerAdapter2 = monthsPagerAdapter;
                    Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter2.calendarConstraints.start.firstOfMonth);
                    dayCopy.add(2, findLastVisibleItemPosition);
                    materialCalendar.current = new Month(dayCopy);
                    Calendar dayCopy2 = UtcDates.getDayCopy(monthsPagerAdapter2.calendarConstraints.start.firstOfMonth);
                    dayCopy2.add(2, findLastVisibleItemPosition);
                    dayCopy2.set(5, 1);
                    Calendar dayCopy3 = UtcDates.getDayCopy(dayCopy2);
                    dayCopy3.get(2);
                    dayCopy3.get(1);
                    dayCopy3.getMaximum(7);
                    dayCopy3.getActualMaximum(5);
                    dayCopy3.getTimeInMillis();
                    materialButton.setText(DateUtils.formatDateTime(null, dayCopy3.getTimeInMillis(), 8228));
                }
            });
            materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    CalendarSelector calendarSelector = materialCalendar.calendarSelector;
                    CalendarSelector calendarSelector2 = CalendarSelector.YEAR;
                    if (calendarSelector == calendarSelector2) {
                        materialCalendar.setSelector(CalendarSelector.DAY);
                    } else if (calendarSelector == CalendarSelector.DAY) {
                        materialCalendar.setSelector(calendarSelector2);
                    }
                }
            });
            materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findFirstVisibleItemPosition() + 1;
                    if (findFirstVisibleItemPosition < materialCalendar.recyclerView.getAdapter().getItemCount()) {
                        Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                        dayCopy.add(2, findFirstVisibleItemPosition);
                        materialCalendar.setCurrentMonth(new Month(dayCopy));
                    }
                }
            });
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCalendar materialCalendar = MaterialCalendar.this;
                    int findLastVisibleItemPosition = ((LinearLayoutManager) materialCalendar.recyclerView.getLayoutManager()).findLastVisibleItemPosition() - 1;
                    if (findLastVisibleItemPosition >= 0) {
                        Calendar dayCopy = UtcDates.getDayCopy(monthsPagerAdapter.calendarConstraints.start.firstOfMonth);
                        dayCopy.add(2, findLastVisibleItemPosition);
                        materialCalendar.setCurrentMonth(new Month(dayCopy));
                    }
                }
            });
        }
        if (!MaterialDatePicker.isFullscreen(contextThemeWrapper) && (recyclerView2 = (pagerSnapHelper = new PagerSnapHelper()).mRecyclerView) != (recyclerView = this.recyclerView)) {
            SnapHelper.AnonymousClass1 anonymousClass1 = pagerSnapHelper.mScrollListener;
            if (recyclerView2 != null) {
                recyclerView2.removeOnScrollListener(anonymousClass1);
                pagerSnapHelper.mRecyclerView.setOnFlingListener(null);
            }
            pagerSnapHelper.mRecyclerView = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    pagerSnapHelper.mRecyclerView.addOnScrollListener(anonymousClass1);
                    pagerSnapHelper.mRecyclerView.setOnFlingListener(pagerSnapHelper);
                    new Scroller(pagerSnapHelper.mRecyclerView.getContext(), new DecelerateInterpolator());
                    pagerSnapHelper.snapToTargetExistingView();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        RecyclerView recyclerView4 = this.recyclerView;
        Month month2 = this.current;
        Month month3 = monthsPagerAdapter.calendarConstraints.start;
        if (month3.firstOfMonth instanceof GregorianCalendar) {
            recyclerView4.scrollToPosition((month2.month - month3.month) + ((month2.year - month3.year) * 12));
            return inflate;
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.themeResId);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.current);
    }

    public final void setCurrentMonth(Month month) {
        boolean z;
        Month month2 = ((MonthsPagerAdapter) this.recyclerView.getAdapter()).calendarConstraints.start;
        Calendar calendar = month2.firstOfMonth;
        if (calendar instanceof GregorianCalendar) {
            int r2 = month.year;
            int r4 = month2.year;
            int r5 = month.month;
            int r0 = month2.month;
            final int r52 = (r5 - r0) + ((r2 - r4) * 12);
            Month month3 = this.current;
            if (calendar instanceof GregorianCalendar) {
                int r02 = r52 - ((month3.month - r0) + ((month3.year - r4) * 12));
                boolean z2 = true;
                if (Math.abs(r02) > 3) {
                    z = true;
                } else {
                    z = false;
                }
                if (r02 <= 0) {
                    z2 = false;
                }
                this.current = month;
                if (z && z2) {
                    this.recyclerView.scrollToPosition(r52 - 3);
                    this.recyclerView.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                        @Override // java.lang.Runnable
                        public final void run() {
                            MaterialCalendar.this.recyclerView.smoothScrollToPosition(r52);
                        }
                    });
                    return;
                } else if (z) {
                    this.recyclerView.scrollToPosition(r52 + 3);
                    this.recyclerView.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                        @Override // java.lang.Runnable
                        public final void run() {
                            MaterialCalendar.this.recyclerView.smoothScrollToPosition(r52);
                        }
                    });
                    return;
                } else {
                    this.recyclerView.post(new Runnable() { // from class: com.google.android.material.datepicker.MaterialCalendar.10
                        @Override // java.lang.Runnable
                        public final void run() {
                            MaterialCalendar.this.recyclerView.smoothScrollToPosition(r52);
                        }
                    });
                    return;
                }
            }
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    public final void setSelector(CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(this.current.year - ((YearGridAdapter) this.yearSelector.getAdapter()).materialCalendar.calendarConstraints.start.year);
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }
}
