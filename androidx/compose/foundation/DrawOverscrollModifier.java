package androidx.compose.foundation;

import android.widget.EdgeEffect;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidOverscroll.kt */
/* loaded from: classes.dex */
public final class DrawOverscrollModifier extends InspectorValueInfo implements DrawModifier {
    public final AndroidEdgeEffectOverscrollEffect overscrollEffect;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DrawOverscrollModifier(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect r3) {
        /*
            r2 = this;
            androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1 r0 = androidx.compose.ui.platform.InspectableValueKt.NoInspectorInfo
            java.lang.String r1 = "overscrollEffect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "inspectorInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r2.<init>(r0)
            r2.overscrollEffect = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.DrawOverscrollModifier.<init>(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect):void");
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public final void draw(ContentDrawScope contentDrawScope) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        contentDrawScope.drawContent();
        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = this.overscrollEffect;
        androidEdgeEffectOverscrollEffect.getClass();
        if (!Size.m277isEmptyimpl(androidEdgeEffectOverscrollEffect.containerSize)) {
            Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
            androidEdgeEffectOverscrollEffect.redrawSignal.getValue();
            android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            Intrinsics.checkNotNullParameter(canvas, "<this>");
            android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
            EdgeEffect edgeEffect = androidEdgeEffectOverscrollEffect.leftEffectNegation;
            boolean z6 = true;
            if (EdgeEffectCompat.getDistanceCompat(edgeEffect) == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                androidEdgeEffectOverscrollEffect.drawRight(contentDrawScope, edgeEffect, canvas3);
                edgeEffect.finish();
            }
            EdgeEffect edgeEffect2 = androidEdgeEffectOverscrollEffect.leftEffect;
            if (!edgeEffect2.isFinished()) {
                z2 = androidEdgeEffectOverscrollEffect.drawLeft(contentDrawScope, edgeEffect2, canvas3);
                EdgeEffectCompat.onPullDistanceCompat(edgeEffect, EdgeEffectCompat.getDistanceCompat(edgeEffect2));
            } else {
                z2 = false;
            }
            EdgeEffect edgeEffect3 = androidEdgeEffectOverscrollEffect.topEffectNegation;
            if (EdgeEffectCompat.getDistanceCompat(edgeEffect3) == 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                androidEdgeEffectOverscrollEffect.drawBottom(contentDrawScope, edgeEffect3, canvas3);
                edgeEffect3.finish();
            }
            EdgeEffect edgeEffect4 = androidEdgeEffectOverscrollEffect.topEffect;
            boolean isFinished = edgeEffect4.isFinished();
            OverscrollConfiguration overscrollConfiguration = androidEdgeEffectOverscrollEffect.overscrollConfig;
            if (!isFinished) {
                int save = canvas3.save();
                canvas3.translate(0.0f, contentDrawScope.mo49toPx0680j_4(overscrollConfiguration.drawPadding.mo79calculateTopPaddingD9Ej5fM()));
                boolean draw = edgeEffect4.draw(canvas3);
                canvas3.restoreToCount(save);
                if (!draw && !z2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                EdgeEffectCompat.onPullDistanceCompat(edgeEffect3, EdgeEffectCompat.getDistanceCompat(edgeEffect4));
            }
            EdgeEffect edgeEffect5 = androidEdgeEffectOverscrollEffect.rightEffectNegation;
            if (EdgeEffectCompat.getDistanceCompat(edgeEffect5) == 0.0f) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z4) {
                androidEdgeEffectOverscrollEffect.drawLeft(contentDrawScope, edgeEffect5, canvas3);
                edgeEffect5.finish();
            }
            EdgeEffect edgeEffect6 = androidEdgeEffectOverscrollEffect.rightEffect;
            if (!edgeEffect6.isFinished()) {
                if (!androidEdgeEffectOverscrollEffect.drawRight(contentDrawScope, edgeEffect6, canvas3) && !z2) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                EdgeEffectCompat.onPullDistanceCompat(edgeEffect5, EdgeEffectCompat.getDistanceCompat(edgeEffect6));
            }
            EdgeEffect edgeEffect7 = androidEdgeEffectOverscrollEffect.bottomEffectNegation;
            if (EdgeEffectCompat.getDistanceCompat(edgeEffect7) == 0.0f) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (!z5) {
                int save2 = canvas3.save();
                canvas3.translate(0.0f, contentDrawScope.mo49toPx0680j_4(overscrollConfiguration.drawPadding.mo79calculateTopPaddingD9Ej5fM()));
                edgeEffect7.draw(canvas3);
                canvas3.restoreToCount(save2);
                edgeEffect7.finish();
            }
            EdgeEffect edgeEffect8 = androidEdgeEffectOverscrollEffect.bottomEffect;
            if (!edgeEffect8.isFinished()) {
                if (!androidEdgeEffectOverscrollEffect.drawBottom(contentDrawScope, edgeEffect8, canvas3) && !z2) {
                    z6 = false;
                }
                EdgeEffectCompat.onPullDistanceCompat(edgeEffect7, EdgeEffectCompat.getDistanceCompat(edgeEffect8));
                z2 = z6;
            }
            if (z2) {
                androidEdgeEffectOverscrollEffect.invalidateOverscroll();
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawOverscrollModifier)) {
            return false;
        }
        return Intrinsics.areEqual(this.overscrollEffect, ((DrawOverscrollModifier) obj).overscrollEffect);
    }

    public final int hashCode() {
        return this.overscrollEffect.hashCode();
    }

    public final String toString() {
        return "DrawOverscrollModifier(overscrollEffect=" + this.overscrollEffect + ')';
    }
}
