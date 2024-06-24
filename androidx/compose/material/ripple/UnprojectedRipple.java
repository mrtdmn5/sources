package androidx.compose.material.ripple;

import android.graphics.Rect;
import android.graphics.drawable.RippleDrawable;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RippleHostView.android.kt */
/* loaded from: classes.dex */
public final class UnprojectedRipple extends RippleDrawable {
    public final boolean bounded;
    public boolean projected;
    public Color rippleColor;
    public Integer rippleRadius;

    /* compiled from: RippleHostView.android.kt */
    /* loaded from: classes.dex */
    public static final class MRadiusHelper {
        public static final MRadiusHelper INSTANCE = new MRadiusHelper();

        public final void setRadius(RippleDrawable ripple, int r3) {
            Intrinsics.checkNotNullParameter(ripple, "ripple");
            ripple.setRadius(r3);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public UnprojectedRipple(boolean r5) {
        /*
            r4 = this;
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            android.content.res.ColorStateList r0 = android.content.res.ColorStateList.valueOf(r0)
            r1 = 0
            if (r5 == 0) goto L10
            android.graphics.drawable.ColorDrawable r2 = new android.graphics.drawable.ColorDrawable
            r3 = -1
            r2.<init>(r3)
            goto L11
        L10:
            r2 = r1
        L11:
            r4.<init>(r0, r1, r2)
            r4.bounded = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.UnprojectedRipple.<init>(boolean):void");
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        if (!this.bounded) {
            this.projected = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        Intrinsics.checkNotNullExpressionValue(dirtyBounds, "super.getDirtyBounds()");
        this.projected = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public final boolean isProjected() {
        return this.projected;
    }
}
