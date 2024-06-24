package androidx.compose.ui.platform;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ ScrollObservationScope $scrollObservationScope;
    public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, ScrollObservationScope scrollObservationScope) {
        super(0);
        this.$scrollObservationScope = scrollObservationScope;
        this.this$0 = androidComposeViewAccessibilityDelegateCompat;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:            if (r7 == false) goto L20;     */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit invoke() {
        /*
            r10 = this;
            androidx.compose.ui.platform.ScrollObservationScope r0 = r10.$scrollObservationScope
            androidx.compose.ui.semantics.ScrollAxisRange r1 = r0.horizontalScrollAxisRange
            androidx.compose.ui.semantics.ScrollAxisRange r2 = r0.verticalScrollAxisRange
            java.lang.Float r3 = r0.oldXValue
            java.lang.Float r4 = r0.oldYValue
            r5 = 0
            if (r1 == 0) goto L21
            if (r3 == 0) goto L21
            kotlin.jvm.functions.Function0<java.lang.Float> r6 = r1.value
            java.lang.Object r6 = r6.invoke()
            java.lang.Number r6 = (java.lang.Number) r6
            float r6 = r6.floatValue()
            float r3 = r3.floatValue()
            float r6 = r6 - r3
            goto L22
        L21:
            r6 = r5
        L22:
            if (r2 == 0) goto L38
            if (r4 == 0) goto L38
            kotlin.jvm.functions.Function0<java.lang.Float> r3 = r2.value
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            float r4 = r4.floatValue()
            float r3 = r3 - r4
            goto L39
        L38:
            r3 = r5
        L39:
            int r4 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            r7 = 0
            r8 = 1
            if (r4 != 0) goto L41
            r4 = r8
            goto L42
        L41:
            r4 = r7
        L42:
            if (r4 == 0) goto L4b
            int r4 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r4 != 0) goto L49
            r7 = r8
        L49:
            if (r7 != 0) goto Lb6
        L4b:
            int r4 = r0.semanticsNodeId
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r5 = r10.this$0
            int r4 = r5.semanticsNodeIdToAccessibilityVirtualNodeId(r4)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r8 = 8
            r9 = 2048(0x800, float:2.87E-42)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView$default(r5, r4, r9, r7, r8)
            r7 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r4 = r5.createEvent$ui_release(r4, r7)
            if (r1 == 0) goto L86
            kotlin.jvm.functions.Function0<java.lang.Float> r7 = r1.value
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            int r7 = (int) r7
            r4.setScrollX(r7)
            kotlin.jvm.functions.Function0<java.lang.Float> r7 = r1.maxValue
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            int r7 = (int) r7
            r4.setMaxScrollX(r7)
        L86:
            if (r2 == 0) goto La8
            kotlin.jvm.functions.Function0<java.lang.Float> r7 = r2.value
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            int r7 = (int) r7
            r4.setScrollY(r7)
            kotlin.jvm.functions.Function0<java.lang.Float> r7 = r2.maxValue
            java.lang.Object r7 = r7.invoke()
            java.lang.Number r7 = (java.lang.Number) r7
            float r7 = r7.floatValue()
            int r7 = (int) r7
            r4.setMaxScrollY(r7)
        La8:
            int r7 = android.os.Build.VERSION.SDK_INT
            r8 = 28
            if (r7 < r8) goto Lb3
            int r6 = (int) r6
            int r3 = (int) r3
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Api28Impl.setScrollEventDelta(r4, r6, r3)
        Lb3:
            r5.sendEvent(r4)
        Lb6:
            if (r1 == 0) goto Lc2
            kotlin.jvm.functions.Function0<java.lang.Float> r1 = r1.value
            java.lang.Object r1 = r1.invoke()
            java.lang.Float r1 = (java.lang.Float) r1
            r0.oldXValue = r1
        Lc2:
            if (r2 == 0) goto Lce
            kotlin.jvm.functions.Function0<java.lang.Float> r1 = r2.value
            java.lang.Object r1 = r1.invoke()
            java.lang.Float r1 = (java.lang.Float) r1
            r0.oldYValue = r1
        Lce:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1.invoke():java.lang.Object");
    }
}
