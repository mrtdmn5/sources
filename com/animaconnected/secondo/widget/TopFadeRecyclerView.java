package com.animaconnected.secondo.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopFadeRecyclerView.kt */
/* loaded from: classes3.dex */
public final class TopFadeRecyclerView extends RecyclerView {
    public static final int $stable = 0;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TopFadeRecyclerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        return 0.0f;
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public TopFadeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TopFadeRecyclerView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopFadeRecyclerView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        Intrinsics.checkNotNullParameter(context, "context");
        setFadingEdgeLength(getResources().getDimensionPixelSize(R.dimen.verticalScrollFade));
        setVerticalFadingEdgeEnabled(true);
        if (Build.VERSION.SDK_INT < 31) {
            setOverScrollMode(2);
        }
    }
}
