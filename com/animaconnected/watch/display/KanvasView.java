package com.animaconnected.watch.display;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KanvasView.kt */
/* loaded from: classes3.dex */
public final class KanvasView extends View {
    private AndroidKanvas kanvas;
    private Scrapbook scrapbook;

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public KanvasView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final AndroidKanvas getKanvas() {
        return this.kanvas;
    }

    public final Scrapbook getScrapbook() {
        return this.scrapbook;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.kanvas.setNativeCanvas(canvas);
        Scrapbook scrapbook = this.scrapbook;
        if (scrapbook != null) {
            scrapbook.drawStuff();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        Scrapbook scrapbook = this.scrapbook;
        if (scrapbook != null) {
            scrapbook.setSize(DpUtilsKt.toDpInt(getWidth()), DpUtilsKt.toDpInt(getHeight()));
        }
    }

    public final void setKanvas(AndroidKanvas androidKanvas) {
        Intrinsics.checkNotNullParameter(androidKanvas, "<set-?>");
        this.kanvas = androidKanvas;
    }

    public final void setScrapbook(Scrapbook scrapbook) {
        this.scrapbook = scrapbook;
        invalidate();
    }

    /* JADX WARN: 'thıs' call moved to the top of the method (can break code semantics) */
    public KanvasView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ KanvasView(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KanvasView(Context context, AttributeSet attributeSet, int r4) {
        super(context, attributeSet, r4);
        Intrinsics.checkNotNullParameter(context, "context");
        this.kanvas = new AndroidKanvas(context);
    }
}
