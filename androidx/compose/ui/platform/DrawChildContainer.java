package androidx.compose.ui.platform;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewLayerContainer.android.kt */
/* loaded from: classes.dex */
public class DrawChildContainer extends ViewGroup {
    public boolean isDrawing;

    public DrawChildContainer(Context context) {
        super(context);
        setClipChildren(false);
        setTag(R.id.hide_in_inspector_tag, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        boolean z;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int childCount = super.getChildCount();
        int r2 = 0;
        while (true) {
            if (r2 < childCount) {
                View childAt = getChildAt(r2);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ViewLayer");
                if (((ViewLayer) childAt).isInvalidated) {
                    z = true;
                    break;
                }
                r2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            this.isDrawing = true;
            try {
                super.dispatchDraw(canvas);
            } finally {
                this.isDrawing = false;
            }
        }
    }

    public final void drawChild$ui_release(androidx.compose.ui.graphics.Canvas canvas, View view, long j) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(view, "view");
        Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
        super.drawChild(((AndroidCanvas) canvas).internalCanvas, view, j);
    }

    @Override // android.view.ViewGroup
    public int getChildCount() {
        if (this.isDrawing) {
            return super.getChildCount();
        }
        return 0;
    }

    @Override // android.view.View
    public final void onMeasure(int r1, int r2) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
    }
}
