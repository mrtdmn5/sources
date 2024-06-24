package androidx.compose.foundation;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.runtime.NeverEqualPolicy;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: AndroidOverscroll.kt */
/* loaded from: classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public final List<EdgeEffect> allEffects;
    public final EdgeEffect bottomEffect;
    public final EdgeEffect bottomEffectNegation;
    public long containerSize;
    public final Modifier effectModifier;
    public final boolean invalidationEnabled;
    public final EdgeEffect leftEffect;
    public final EdgeEffect leftEffectNegation;
    public final OverscrollConfiguration overscrollConfig;
    public PointerId pointerId;
    public Offset pointerPosition;
    public final ParcelableSnapshotMutableState redrawSignal;
    public final EdgeEffect rightEffect;
    public final EdgeEffect rightEffectNegation;
    public boolean scrollCycleInProgress;
    public final EdgeEffect topEffect;
    public final EdgeEffect topEffectNegation;

    public AndroidEdgeEffectOverscrollEffect(Context context, OverscrollConfiguration overscrollConfiguration) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.overscrollConfig = overscrollConfiguration;
        EdgeEffect create = EdgeEffectCompat.create(context);
        this.topEffect = create;
        EdgeEffect create2 = EdgeEffectCompat.create(context);
        this.bottomEffect = create2;
        EdgeEffect create3 = EdgeEffectCompat.create(context);
        this.leftEffect = create3;
        EdgeEffect create4 = EdgeEffectCompat.create(context);
        this.rightEffect = create4;
        List<EdgeEffect> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new EdgeEffect[]{create3, create, create4, create2});
        this.allEffects = listOf;
        this.topEffectNegation = EdgeEffectCompat.create(context);
        this.bottomEffectNegation = EdgeEffectCompat.create(context);
        this.leftEffectNegation = EdgeEffectCompat.create(context);
        this.rightEffectNegation = EdgeEffectCompat.create(context);
        int size = listOf.size();
        for (int r4 = 0; r4 < size; r4++) {
            listOf.get(r4).setColor(ColorKt.m327toArgb8_81llA(this.overscrollConfig.glowColor));
        }
        Unit unit = Unit.INSTANCE;
        this.redrawSignal = Platform.mutableStateOf(unit, NeverEqualPolicy.INSTANCE);
        this.invalidationEnabled = true;
        this.containerSize = Size.Zero;
        Function1<IntSize, Unit> function1 = new Function1<IntSize, Unit>() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$onNewSize$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(IntSize intSize) {
                long j = intSize.packedValue;
                long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(j);
                AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = AndroidEdgeEffectOverscrollEffect.this;
                boolean z = !Size.m273equalsimpl0(m595toSizeozmzZPI, androidEdgeEffectOverscrollEffect.containerSize);
                androidEdgeEffectOverscrollEffect.containerSize = IntSizeKt.m595toSizeozmzZPI(j);
                if (z) {
                    int r3 = (int) (j >> 32);
                    androidEdgeEffectOverscrollEffect.topEffect.setSize(r3, IntSize.m593getHeightimpl(j));
                    androidEdgeEffectOverscrollEffect.bottomEffect.setSize(r3, IntSize.m593getHeightimpl(j));
                    androidEdgeEffectOverscrollEffect.leftEffect.setSize(IntSize.m593getHeightimpl(j), r3);
                    androidEdgeEffectOverscrollEffect.rightEffect.setSize(IntSize.m593getHeightimpl(j), r3);
                    androidEdgeEffectOverscrollEffect.topEffectNegation.setSize(r3, IntSize.m593getHeightimpl(j));
                    androidEdgeEffectOverscrollEffect.bottomEffectNegation.setSize(r3, IntSize.m593getHeightimpl(j));
                    androidEdgeEffectOverscrollEffect.leftEffectNegation.setSize(IntSize.m593getHeightimpl(j), r3);
                    androidEdgeEffectOverscrollEffect.rightEffectNegation.setSize(IntSize.m593getHeightimpl(j), r3);
                }
                if (z) {
                    androidEdgeEffectOverscrollEffect.invalidateOverscroll();
                    androidEdgeEffectOverscrollEffect.animateToRelease();
                }
                return Unit.INSTANCE;
            }
        };
        Modifier other = AndroidOverscrollKt.StretchOverscrollNonClippingLayer;
        Intrinsics.checkNotNullParameter(other, "other");
        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(SuspendingPointerInputFilterKt.pointerInput(other, unit, new AndroidEdgeEffectOverscrollEffect$effectModifier$1(this, null)), function1);
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        this.effectModifier = onSizeChanged.then(new DrawOverscrollModifier(this));
    }

    public final void animateToRelease() {
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        boolean z = false;
        for (int r3 = 0; r3 < size; r3++) {
            EdgeEffect edgeEffect = list.get(r3);
            edgeEffect.onRelease();
            if (!edgeEffect.isFinished() && !z) {
                z = false;
            } else {
                z = true;
            }
        }
        if (z) {
            invalidateOverscroll();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0185 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x016a  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object mo15applyToFlingBMRW4eQ(long r19, androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1 r21, kotlin.coroutines.Continuation r22) {
        /*
            Method dump skipped, instructions count: 576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo15applyToFlingBMRW4eQ(long, androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0289 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0196 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e8  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long mo16applyToScrollRhakbz0(long r21, int r23, androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1 r24) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect.mo16applyToScrollRhakbz0(long, int, androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1):long");
    }

    public final boolean drawBottom(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(180.0f);
        canvas.translate(-Size.m276getWidthimpl(this.containerSize), (-Size.m274getHeightimpl(this.containerSize)) + drawScope.mo49toPx0680j_4(this.overscrollConfig.drawPadding.mo76calculateBottomPaddingD9Ej5fM()));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    public final boolean drawLeft(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(270.0f);
        canvas.translate(-Size.m274getHeightimpl(this.containerSize), drawScope.mo49toPx0680j_4(this.overscrollConfig.drawPadding.mo77calculateLeftPaddingu2uoSUM(drawScope.getLayoutDirection())));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    public final boolean drawRight(DrawScope drawScope, EdgeEffect edgeEffect, Canvas canvas) {
        int save = canvas.save();
        int roundToInt = MathKt__MathJVMKt.roundToInt(Size.m276getWidthimpl(this.containerSize));
        float mo78calculateRightPaddingu2uoSUM = this.overscrollConfig.drawPadding.mo78calculateRightPaddingu2uoSUM(drawScope.getLayoutDirection());
        canvas.rotate(90.0f);
        canvas.translate(0.0f, drawScope.mo49toPx0680j_4(mo78calculateRightPaddingu2uoSUM) + (-roundToInt));
        boolean draw = edgeEffect.draw(canvas);
        canvas.restoreToCount(save);
        return draw;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final Modifier getEffectModifier() {
        return this.effectModifier;
    }

    public final void invalidateOverscroll() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public final boolean isInProgress() {
        float f;
        boolean z;
        List<EdgeEffect> list = this.allEffects;
        int size = list.size();
        for (int r3 = 0; r3 < size; r3++) {
            EdgeEffect edgeEffect = list.get(r3);
            Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
            if (Build.VERSION.SDK_INT >= 31) {
                f = Api31Impl.INSTANCE.getDistance(edgeEffect);
            } else {
                f = 0.0f;
            }
            if (f == 0.0f) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: pullBottom-0a9Yr6o, reason: not valid java name */
    public final float m17pullBottom0a9Yr6o(long j, long j2) {
        float f;
        float m259getXimpl = Offset.m259getXimpl(j2) / Size.m276getWidthimpl(this.containerSize);
        float f2 = -(Offset.m260getYimpl(j) / Size.m274getHeightimpl(this.containerSize));
        boolean z = true;
        float f3 = 1 - m259getXimpl;
        EdgeEffect edgeEffect = this.bottomEffect;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        int r3 = Build.VERSION.SDK_INT;
        Api31Impl api31Impl = Api31Impl.INSTANCE;
        if (r3 >= 31) {
            f2 = api31Impl.onPullDistance(edgeEffect, f2, f3);
        } else {
            edgeEffect.onPull(f2, f3);
        }
        float m274getHeightimpl = Size.m274getHeightimpl(this.containerSize) * (-f2);
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            f = api31Impl.getDistance(edgeEffect);
        } else {
            f = 0.0f;
        }
        if (f != 0.0f) {
            z = false;
        }
        if (!z) {
            return Offset.m260getYimpl(j);
        }
        return m274getHeightimpl;
    }

    /* renamed from: pullLeft-0a9Yr6o, reason: not valid java name */
    public final float m18pullLeft0a9Yr6o(long j, long j2) {
        float f;
        float m260getYimpl = Offset.m260getYimpl(j2) / Size.m274getHeightimpl(this.containerSize);
        float m259getXimpl = Offset.m259getXimpl(j) / Size.m276getWidthimpl(this.containerSize);
        boolean z = true;
        float f2 = 1 - m260getYimpl;
        EdgeEffect edgeEffect = this.leftEffect;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        int r3 = Build.VERSION.SDK_INT;
        Api31Impl api31Impl = Api31Impl.INSTANCE;
        if (r3 >= 31) {
            m259getXimpl = api31Impl.onPullDistance(edgeEffect, m259getXimpl, f2);
        } else {
            edgeEffect.onPull(m259getXimpl, f2);
        }
        float m276getWidthimpl = Size.m276getWidthimpl(this.containerSize) * m259getXimpl;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            f = api31Impl.getDistance(edgeEffect);
        } else {
            f = 0.0f;
        }
        if (f != 0.0f) {
            z = false;
        }
        if (!z) {
            return Offset.m259getXimpl(j);
        }
        return m276getWidthimpl;
    }

    /* renamed from: pullRight-0a9Yr6o, reason: not valid java name */
    public final float m19pullRight0a9Yr6o(long j, long j2) {
        float f;
        boolean z;
        float m260getYimpl = Offset.m260getYimpl(j2) / Size.m274getHeightimpl(this.containerSize);
        float f2 = -(Offset.m259getXimpl(j) / Size.m276getWidthimpl(this.containerSize));
        EdgeEffect edgeEffect = this.rightEffect;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        int r2 = Build.VERSION.SDK_INT;
        Api31Impl api31Impl = Api31Impl.INSTANCE;
        if (r2 >= 31) {
            f2 = api31Impl.onPullDistance(edgeEffect, f2, m260getYimpl);
        } else {
            edgeEffect.onPull(f2, m260getYimpl);
        }
        float m276getWidthimpl = Size.m276getWidthimpl(this.containerSize) * (-f2);
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            f = api31Impl.getDistance(edgeEffect);
        } else {
            f = 0.0f;
        }
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return Offset.m259getXimpl(j);
        }
        return m276getWidthimpl;
    }

    /* renamed from: pullTop-0a9Yr6o, reason: not valid java name */
    public final float m20pullTop0a9Yr6o(long j, long j2) {
        float f;
        boolean z;
        float m259getXimpl = Offset.m259getXimpl(j2) / Size.m276getWidthimpl(this.containerSize);
        float m260getYimpl = Offset.m260getYimpl(j) / Size.m274getHeightimpl(this.containerSize);
        EdgeEffect edgeEffect = this.topEffect;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        int r2 = Build.VERSION.SDK_INT;
        Api31Impl api31Impl = Api31Impl.INSTANCE;
        if (r2 >= 31) {
            m260getYimpl = api31Impl.onPullDistance(edgeEffect, m260getYimpl, m259getXimpl);
        } else {
            edgeEffect.onPull(m260getYimpl, m259getXimpl);
        }
        float m274getHeightimpl = Size.m274getHeightimpl(this.containerSize) * m260getYimpl;
        Intrinsics.checkNotNullParameter(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            f = api31Impl.getDistance(edgeEffect);
        } else {
            f = 0.0f;
        }
        if (f == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return Offset.m260getYimpl(j);
        }
        return m274getHeightimpl;
    }
}
