package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.internal.ViewUtils;
import com.kronaby.watch.app.R;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class MaterialCalendarGridView extends GridView {
    public final Calendar dayCompute;
    public final boolean nestedScrollable;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendarGridView$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public final class AnonymousClass1 extends AccessibilityDelegateCompat {
        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.mInfo);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.dayCompute = UtcDates.getUtcCalendarOf(null);
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.readMaterialCalendarStyleBoolean(getContext(), R.attr.nestedScrollable);
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1());
    }

    public final View getChildAtPosition(int r2) {
        return getChildAt(r2 - getFirstVisiblePosition());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        MonthAdapter monthAdapter;
        Iterator<Pair<Long, Long>> it;
        int r15;
        Month month;
        boolean z;
        int firstPositionInMonth;
        int width;
        int firstPositionInMonth2;
        int width2;
        int r1;
        int r5;
        int r52;
        int r12;
        boolean z2;
        boolean z3;
        int left;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), getFirstVisiblePosition());
        Month month2 = adapter.month;
        int min = Math.min((month2.daysFromStartOfWeekToFirstOfMonth() + month2.daysInMonth) - 1, getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        Iterator<Pair<Long, Long>> it2 = dateSelector.getSelectedRanges().iterator();
        while (it2.hasNext()) {
            Pair<Long, Long> next = it2.next();
            Long l = next.first;
            if (l != null) {
                Long l2 = next.second;
                if (l2 != null) {
                    long longValue = l.longValue();
                    long longValue2 = l2.longValue();
                    Long valueOf = Long.valueOf(longValue);
                    Long valueOf2 = Long.valueOf(longValue2);
                    if (item != null && item2 != null && valueOf != null && valueOf2 != null && valueOf.longValue() <= item2.longValue() && valueOf2.longValue() >= item.longValue()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                        long longValue3 = item.longValue();
                        Calendar calendar = materialCalendarGridView.dayCompute;
                        if (longValue < longValue3) {
                            if (max % month2.daysInWeek == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                left = 0;
                            } else if (!isLayoutRtl) {
                                left = materialCalendarGridView.getChildAtPosition(max - 1).getRight();
                            } else {
                                left = materialCalendarGridView.getChildAtPosition(max - 1).getLeft();
                            }
                            width = left;
                            firstPositionInMonth = max;
                        } else {
                            calendar.setTimeInMillis(longValue);
                            firstPositionInMonth = adapter.firstPositionInMonth() + (calendar.get(5) - 1);
                            View childAtPosition = materialCalendarGridView.getChildAtPosition(firstPositionInMonth);
                            width = (childAtPosition.getWidth() / 2) + childAtPosition.getLeft();
                        }
                        if (longValue2 > item2.longValue()) {
                            if ((min + 1) % month2.daysInWeek == 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                width2 = getWidth();
                            } else if (!isLayoutRtl) {
                                width2 = materialCalendarGridView.getChildAtPosition(min).getRight();
                            } else {
                                width2 = materialCalendarGridView.getChildAtPosition(min).getLeft();
                            }
                            firstPositionInMonth2 = min;
                        } else {
                            calendar.setTimeInMillis(longValue2);
                            firstPositionInMonth2 = adapter.firstPositionInMonth() + (calendar.get(5) - 1);
                            View childAtPosition2 = materialCalendarGridView.getChildAtPosition(firstPositionInMonth2);
                            width2 = (childAtPosition2.getWidth() / 2) + childAtPosition2.getLeft();
                        }
                        int itemId = (int) adapter.getItemId(firstPositionInMonth);
                        r15 = max;
                        month = month2;
                        int itemId2 = (int) adapter.getItemId(firstPositionInMonth2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            MonthAdapter monthAdapter2 = adapter;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAtPosition3 = materialCalendarGridView.getChildAtPosition(numColumns);
                            int top = childAtPosition3.getTop() + calendarStyle.day.insets.top;
                            Iterator<Pair<Long, Long>> it3 = it2;
                            int bottom = childAtPosition3.getBottom() - calendarStyle.day.insets.bottom;
                            if (!isLayoutRtl) {
                                if (numColumns > firstPositionInMonth) {
                                    r52 = 0;
                                } else {
                                    r52 = width;
                                }
                                if (firstPositionInMonth2 > numColumns2) {
                                    r12 = getWidth();
                                } else {
                                    r12 = width2;
                                }
                            } else {
                                if (firstPositionInMonth2 > numColumns2) {
                                    r1 = 0;
                                } else {
                                    r1 = width2;
                                }
                                if (numColumns > firstPositionInMonth) {
                                    r5 = getWidth();
                                } else {
                                    r5 = width;
                                }
                                int r27 = r5;
                                r52 = r1;
                                r12 = r27;
                            }
                            canvas.drawRect(r52, top, r12, bottom, calendarStyle.rangeFill);
                            itemId++;
                            materialCalendarGridView = this;
                            itemId2 = itemId2;
                            adapter = monthAdapter2;
                            it2 = it3;
                        }
                        monthAdapter = adapter;
                        it = it2;
                    }
                }
            } else {
                monthAdapter = adapter;
                it = it2;
                r15 = max;
                month = month2;
            }
            materialCalendarGridView = this;
            max = r15;
            month2 = month;
            adapter = monthAdapter;
            it2 = it;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onFocusChanged(boolean z, int r2, Rect rect) {
        if (z) {
            if (r2 == 33) {
                Month month = getAdapter().month;
                setSelection((month.daysFromStartOfWeekToFirstOfMonth() + month.daysInMonth) - 1);
                return;
            } else if (r2 == 130) {
                setSelection(getAdapter().firstPositionInMonth());
                return;
            } else {
                super.onFocusChanged(true, r2, rect);
                return;
            }
        }
        super.onFocusChanged(false, r2, rect);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r4, KeyEvent keyEvent) {
        if (!super.onKeyDown(r4, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().firstPositionInMonth()) {
            return true;
        }
        if (19 != r4) {
            return false;
        }
        setSelection(getAdapter().firstPositionInMonth());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public final void onMeasure(int r2, int r3) {
        if (this.nestedScrollable) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(r2, r3);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final void setSelection(int r2) {
        if (r2 < getAdapter().firstPositionInMonth()) {
            super.setSelection(getAdapter().firstPositionInMonth());
        } else {
            super.setSelection(r2);
        }
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof MonthAdapter) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public final ListAdapter getAdapter2() {
        return (MonthAdapter) super.getAdapter();
    }
}
