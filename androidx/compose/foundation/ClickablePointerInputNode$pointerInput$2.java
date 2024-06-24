package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.ui.geometry.Offset;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: Clickable.kt */
@DebugMetadata(c = "androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2", f = "Clickable.kt", l = {892}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ClickablePointerInputNode$pointerInput$2 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
    public /* synthetic */ long J$0;
    public /* synthetic */ PressGestureScope L$0;
    public int label;
    public final /* synthetic */ ClickablePointerInputNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClickablePointerInputNode$pointerInput$2(ClickablePointerInputNode clickablePointerInputNode, Continuation<? super ClickablePointerInputNode$pointerInput$2> continuation) {
        super(3, continuation);
        this.this$0 = clickablePointerInputNode;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
        long j = offset.packedValue;
        ClickablePointerInputNode$pointerInput$2 clickablePointerInputNode$pointerInput$2 = new ClickablePointerInputNode$pointerInput$2(this.this$0, continuation);
        clickablePointerInputNode$pointerInput$2.L$0 = pressGestureScope;
        clickablePointerInputNode$pointerInput$2.J$0 = j;
        return clickablePointerInputNode$pointerInput$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:            if (r11 == r0) goto L19;     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L15
            if (r1 != r2) goto Ld
            kotlin.ResultKt.throwOnFailure(r11)
            goto L45
        Ld:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L15:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.foundation.gestures.PressGestureScope r11 = r10.L$0
            long r3 = r10.J$0
            androidx.compose.foundation.ClickablePointerInputNode r1 = r10.this$0
            boolean r5 = r1.enabled
            if (r5 == 0) goto L45
            r10.label = r2
            androidx.compose.foundation.interaction.MutableInteractionSource r5 = r1.interactionSource
            if (r5 == 0) goto L40
            androidx.compose.foundation.AbstractClickableNode$InteractionData r6 = r1.interactionData
            androidx.compose.foundation.AbstractClickablePointerInputNode$delayPressInteraction$1 r7 = r1.delayPressInteraction
            androidx.compose.foundation.ClickableKt$handlePressInteraction$2 r9 = new androidx.compose.foundation.ClickableKt$handlePressInteraction$2
            r8 = 0
            r1 = r9
            r2 = r11
            r1.<init>(r2, r3, r5, r6, r7, r8)
            java.lang.Object r11 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r9, r10)
            if (r11 != r0) goto L3b
            goto L3d
        L3b:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L3d:
            if (r11 != r0) goto L40
            goto L42
        L40:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
        L42:
            if (r11 != r0) goto L45
            return r0
        L45:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.ClickablePointerInputNode$pointerInput$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
