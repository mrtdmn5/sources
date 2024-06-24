package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function2;

/* compiled from: ForEachGesture.kt */
/* loaded from: classes.dex */
public final class ForEachGestureKt {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:            if (r8 == false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:            r8 = androidx.compose.ui.input.pointer.PointerEventPass.Final;        r0.L$0 = r7;        r0.label = 1;        r8 = r7.awaitPointerEvent(r8, r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:            if (r8 != r1) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:            return r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:            return kotlin.Unit.INSTANCE;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:            if ((!r8) == false) goto L23;     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0064 -> B:10:0x0067). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = (androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3 r0 = new androidx.compose.foundation.gestures.ForEachGestureKt$awaitAllPointersUp$3
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L32
            if (r2 != r4) goto L2a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L67
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            androidx.compose.ui.input.pointer.PointerEvent r8 = r7.getCurrentEvent()
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r8 = r8.changes
            int r2 = r8.size()
            r5 = r3
        L45:
            if (r5 >= r2) goto L56
            java.lang.Object r6 = r8.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.pressed
            if (r6 == 0) goto L53
            r8 = r4
            goto L57
        L53:
            int r5 = r5 + 1
            goto L45
        L56:
            r8 = r3
        L57:
            r8 = r8 ^ r4
            if (r8 != 0) goto L84
        L5a:
            androidx.compose.ui.input.pointer.PointerEventPass r8 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r8 = r7.awaitPointerEvent(r8, r0)
            if (r8 != r1) goto L67
            return r1
        L67:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r8 = r8.changes
            int r2 = r8.size()
            r5 = r3
        L70:
            if (r5 >= r2) goto L81
            java.lang.Object r6 = r8.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.pressed
            if (r6 == 0) goto L7e
            r8 = r4
            goto L82
        L7e:
            int r5 = r5 + 1
            goto L70
        L81:
            r8 = r3
        L82:
            if (r8 != 0) goto L5a
        L84:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ForEachGestureKt.awaitAllPointersUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object awaitEachGesture(PointerInputScope pointerInputScope, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object awaitPointerEventScope = pointerInputScope.awaitPointerEventScope(new ForEachGestureKt$awaitEachGesture$2(continuation.getContext(), function2, null), continuation);
        if (awaitPointerEventScope == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return awaitPointerEventScope;
        }
        return Unit.INSTANCE;
    }
}
