package com.animaconnected.secondo.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopFadeScrollView.kt */
/* loaded from: classes3.dex */
public final class TopFadeScrollView extends ScrollView {
    public static final int $stable = 8;
    private boolean enableScrolling;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TopFadeScrollView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.widget.ScrollView, android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    public final boolean getEnableScrolling() {
        return this.enableScrolling;
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.enableScrolling) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getAction() == 0 && !this.enableScrolling) {
            return false;
        }
        return super.onTouchEvent(ev);
    }

    public final void setEnableScrolling(boolean z) {
        this.enableScrolling = z;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TopFadeScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopFadeScrollView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFadeScrollView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        Intrinsics.checkNotNullParameter(context, "context");
        setFadingEdgeLength(getResources().getDimensionPixelSize(R.dimen.verticalScrollFade));
        setVerticalFadingEdgeEnabled(true);
        if (Build.VERSION.SDK_INT < 31) {
            setOverScrollMode(2);
        }
        this.enableScrolling = true;
    }
}
