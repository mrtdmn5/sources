package androidx.compose.material.ripple;

import android.content.Context;
import androidx.compose.foundation.interaction.PressInteraction$Press;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import com.google.common.collect.Platform;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Ripple.android.kt */
/* loaded from: classes.dex */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    public final boolean bounded;
    public final State<Color> color;
    public final ParcelableSnapshotMutableState invalidateTick$delegate;
    public final AndroidRippleIndicationInstance$onInvalidateRipple$1 onInvalidateRipple;
    public final float radius;
    public final State<RippleAlpha> rippleAlpha;
    public final RippleContainer rippleContainer;
    public final ParcelableSnapshotMutableState rippleHostView$delegate;
    public int rippleRadius;
    public long rippleSize;

    public AndroidRippleIndicationInstance() {
        throw null;
    }

    public AndroidRippleIndicationInstance(boolean z, float f, MutableState mutableState, MutableState mutableState2, RippleContainer rippleContainer) {
        super(mutableState2, z);
        this.bounded = z;
        this.radius = f;
        this.color = mutableState;
        this.rippleAlpha = mutableState2;
        this.rippleContainer = rippleContainer;
        this.rippleHostView$delegate = Platform.mutableStateOf$default(null);
        this.invalidateTick$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
        this.rippleSize = Size.Zero;
        this.rippleRadius = -1;
        this.onInvalidateRipple = new Function0<Unit>() { // from class: androidx.compose.material.ripple.AndroidRippleIndicationInstance$onInvalidateRipple$1
            public AndroidRippleIndicationInstance$onInvalidateRipple$1() {
                super(0);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                AndroidRippleIndicationInstance.this.invalidateTick$delegate.setValue(Boolean.valueOf(!((Boolean) r0.invalidateTick$delegate.getValue()).booleanValue()));
                return Unit.INSTANCE;
            }
        };
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public final void addRipple(PressInteraction$Press interaction, CoroutineScope scope) {
        Object remove;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(scope, "scope");
        RippleContainer rippleContainer = this.rippleContainer;
        rippleContainer.getClass();
        RippleHostMap rippleHostMap = rippleContainer.rippleHostMap;
        rippleHostMap.getClass();
        RippleHostView rippleHostView = (RippleHostView) rippleHostMap.indicationToHostMap.get(this);
        if (rippleHostView == null) {
            ArrayList arrayList = rippleContainer.unusedRippleHosts;
            Intrinsics.checkNotNullParameter(arrayList, "<this>");
            if (arrayList.isEmpty()) {
                remove = null;
            } else {
                remove = arrayList.remove(0);
            }
            rippleHostView = (RippleHostView) remove;
            LinkedHashMap linkedHashMap = rippleHostMap.hostToIndicationMap;
            if (rippleHostView == null) {
                int r1 = rippleContainer.nextHostIndex;
                ArrayList arrayList2 = rippleContainer.rippleHosts;
                if (r1 > CollectionsKt__CollectionsKt.getLastIndex(arrayList2)) {
                    Context context = rippleContainer.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    rippleHostView = new RippleHostView(context);
                    rippleContainer.addView(rippleHostView);
                    arrayList2.add(rippleHostView);
                } else {
                    rippleHostView = (RippleHostView) arrayList2.get(rippleContainer.nextHostIndex);
                    Intrinsics.checkNotNullParameter(rippleHostView, "rippleHostView");
                    AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) linkedHashMap.get(rippleHostView);
                    if (androidRippleIndicationInstance != null) {
                        androidRippleIndicationInstance.rippleHostView$delegate.setValue(null);
                        rippleHostMap.remove(androidRippleIndicationInstance);
                        rippleHostView.disposeRipple();
                    }
                }
                int r3 = rippleContainer.nextHostIndex;
                if (r3 < rippleContainer.MaxRippleHosts - 1) {
                    rippleContainer.nextHostIndex = r3 + 1;
                } else {
                    rippleContainer.nextHostIndex = 0;
                }
            }
            rippleHostMap.indicationToHostMap.put(this, rippleHostView);
            linkedHashMap.put(rippleHostView, this);
        }
        rippleHostView.m223addRippleKOepWvA(interaction, this.bounded, this.rippleSize, this.rippleRadius, this.color.getValue().value, this.rippleAlpha.getValue().pressedAlpha, this.onInvalidateRipple);
        this.rippleHostView$delegate.setValue(rippleHostView);
    }

    public final void dispose() {
        RippleContainer rippleContainer = this.rippleContainer;
        rippleContainer.getClass();
        this.rippleHostView$delegate.setValue(null);
        RippleHostMap rippleHostMap = rippleContainer.rippleHostMap;
        rippleHostMap.getClass();
        RippleHostView rippleHostView = (RippleHostView) rippleHostMap.indicationToHostMap.get(this);
        if (rippleHostView != null) {
            rippleHostView.disposeRipple();
            rippleHostMap.remove(this);
            rippleContainer.unusedRippleHosts.add(rippleHostView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.IndicationInstance
    public final void drawIndication(ContentDrawScope contentDrawScope) {
        int mo44roundToPx0680j_4;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        this.rippleSize = contentDrawScope.mo391getSizeNHjbRc();
        float f = this.radius;
        if (Float.isNaN(f)) {
            mo44roundToPx0680j_4 = MathKt__MathJVMKt.roundToInt(RippleAnimationKt.m221getRippleEndRadiuscSwnlzA(contentDrawScope, this.bounded, contentDrawScope.mo391getSizeNHjbRc()));
        } else {
            mo44roundToPx0680j_4 = contentDrawScope.mo44roundToPx0680j_4(f);
        }
        this.rippleRadius = mo44roundToPx0680j_4;
        long j = this.color.getValue().value;
        float f2 = this.rippleAlpha.getValue().pressedAlpha;
        contentDrawScope.drawContent();
        m225drawStateLayerH2RKhps(contentDrawScope, f, j);
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        ((Boolean) this.invalidateTick$delegate.getValue()).booleanValue();
        RippleHostView rippleHostView = (RippleHostView) this.rippleHostView$delegate.getValue();
        if (rippleHostView != null) {
            rippleHostView.m224updateRipplePropertiesbiQXAtU(f2, this.rippleRadius, contentDrawScope.mo391getSizeNHjbRc(), j);
            android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
            Intrinsics.checkNotNullParameter(canvas, "<this>");
            rippleHostView.draw(((AndroidCanvas) canvas).internalCanvas);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
        dispose();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        dispose();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public final void removeRipple(PressInteraction$Press interaction) {
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        RippleHostView rippleHostView = (RippleHostView) this.rippleHostView$delegate.getValue();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
    }
}
