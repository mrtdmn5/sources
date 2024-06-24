package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class SmoothCalendarLayoutManager extends LinearLayoutManager {

    /* renamed from: com.google.android.material.datepicker.SmoothCalendarLayoutManager$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public SmoothCalendarLayoutManager(Context context, int r3) {
        super(context, r3, false);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int r3) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(recyclerView.getContext());
        anonymousClass1.setTargetPosition(r3);
        startSmoothScroll(anonymousClass1);
    }
}
