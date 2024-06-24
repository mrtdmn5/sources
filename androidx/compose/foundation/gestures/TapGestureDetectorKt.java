package androidx.compose.foundation.gestures;

import androidx.compose.material.SliderKt$sliderTapModifier$2;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: TapGestureDetector.kt */
/* loaded from: classes.dex */
public final class TapGestureDetectorKt {
    public static final TapGestureDetectorKt$NoPressGesture$1 NoPressGesture = new TapGestureDetectorKt$NoPressGesture$1(null);

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004b A[LOOP:0: B:11:0x0049->B:12:0x004b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006f A[EDGE_INSN: B:28:0x006f->B:21:0x006f BREAK  A[LOOP:1: B:15:0x005e->B:18:0x006c], SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x003c -> B:10:0x003f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L3f
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.ResultKt.throwOnFailure(r9)
        L34:
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.awaitPointerEvent$default(r8, r0)
            if (r9 != r1) goto L3f
            goto L73
        L3f:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r9.changes
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L49:
            if (r6 >= r4) goto L57
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.consume()
            int r6 = r6 + 1
            goto L49
        L57:
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r9 = r9.changes
            int r2 = r9.size()
            r4 = r5
        L5e:
            if (r4 >= r2) goto L6f
            java.lang.Object r6 = r9.get(r4)
            androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
            boolean r6 = r6.pressed
            if (r6 == 0) goto L6c
            r5 = r3
            goto L6f
        L6c:
            int r4 = r4 + 1
            goto L5e
        L6f:
            if (r5 != 0) goto L34
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L73:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.access$consumeUntilUp(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0048 -> B:10:0x004b). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope r10, boolean r11, androidx.compose.ui.input.pointer.PointerEventPass r12, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r13) {
        /*
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            boolean r10 = r0.Z$0
            androidx.compose.ui.input.pointer.PointerEventPass r11 = r0.L$1
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r12 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r13)
            r9 = r11
            r11 = r10
            r10 = r12
            r12 = r9
            goto L4b
        L31:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L39:
            kotlin.ResultKt.throwOnFailure(r13)
        L3c:
            r0.L$0 = r10
            r0.L$1 = r12
            r0.Z$0 = r11
            r0.label = r3
            java.lang.Object r13 = r10.awaitPointerEvent(r12, r0)
            if (r13 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.PointerEvent r13 = (androidx.compose.ui.input.pointer.PointerEvent) r13
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r2 = r13.changes
            int r4 = r2.size()
            r5 = 0
            r6 = r5
        L55:
            if (r6 >= r4) goto L81
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            if (r11 == 0) goto L76
            java.lang.String r8 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r8)
            boolean r8 = r7.isConsumed()
            if (r8 != 0) goto L74
            boolean r8 = r7.previousPressed
            if (r8 != 0) goto L74
            boolean r7 = r7.pressed
            if (r7 == 0) goto L74
            r7 = r3
            goto L7a
        L74:
            r7 = r5
            goto L7a
        L76:
            boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r7)
        L7a:
            if (r7 != 0) goto L7e
            r2 = r5
            goto L82
        L7e:
            int r6 = r6 + 1
            goto L55
        L81:
            r2 = r3
        L82:
            if (r2 == 0) goto L3c
            java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r10 = r13.changes
            java.lang.Object r10 = r10.get(r5)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object awaitFirstDown$default(AwaitPointerEventScope awaitPointerEventScope, Continuation continuation, int r3) {
        boolean z;
        PointerEventPass pointerEventPass;
        if ((r3 & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        if ((r3 & 2) != 0) {
            pointerEventPass = PointerEventPass.Main;
        } else {
            pointerEventPass = null;
        }
        return awaitFirstDown(awaitPointerEventScope, z, pointerEventPass, continuation);
    }

    public static Object detectTapGestures$default(PointerInputScope pointerInputScope, Function1 function1, SliderKt$sliderTapModifier$2.AnonymousClass1.C00241 c00241, Function1 function12, Continuation continuation, int r12) {
        Function1 function13;
        Function1 function14;
        if ((r12 & 2) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        Function3 function3 = c00241;
        if ((r12 & 4) != 0) {
            function3 = NoPressGesture;
        }
        Function3 function32 = function3;
        if ((r12 & 8) != 0) {
            function14 = null;
        } else {
            function14 = function12;
        }
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new TapGestureDetectorKt$detectTapGestures$2(pointerInputScope, null, function13, null, function14, function32), continuation);
        if (coroutineScope != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return coroutineScope;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ee A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00cc -> B:11:0x0031). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope r18, androidx.compose.ui.input.pointer.PointerEventPass r19, kotlin.coroutines.Continuation<? super androidx.compose.ui.input.pointer.PointerInputChange> r20) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.waitForUpOrCancellation(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
