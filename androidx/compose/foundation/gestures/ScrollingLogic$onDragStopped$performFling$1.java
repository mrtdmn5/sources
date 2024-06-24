package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Scrollable.kt */
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", l = {464, 466, 468}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    public /* synthetic */ long J$0;
    public long J$1;
    public int label;
    public final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).packedValue;
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(new Velocity(velocity.packedValue), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0080 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0081  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r6 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r0 = r11.label
            r1 = 3
            r2 = 2
            r3 = 1
            androidx.compose.foundation.gestures.ScrollingLogic r4 = r11.this$0
            if (r0 == 0) goto L33
            if (r0 == r3) goto L2c
            if (r0 == r2) goto L23
            if (r0 != r1) goto L1b
            long r0 = r11.J$1
            long r2 = r11.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r0
            r0 = r12
            goto L82
        L1b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L23:
            long r2 = r11.J$1
            long r7 = r11.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            r0 = r12
            goto L61
        L2c:
            long r7 = r11.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            r0 = r12
            goto L4b
        L33:
            kotlin.ResultKt.throwOnFailure(r12)
            long r7 = r11.J$0
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r0 = r4.nestedScrollDispatcher
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r0
            r11.J$0 = r7
            r11.label = r3
            java.lang.Object r0 = r0.m405dispatchPreFlingQWom1Mo(r7, r11)
            if (r0 != r6) goto L4b
            return r6
        L4b:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r9 = r0.packedValue
            long r9 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r7, r9)
            r11.J$0 = r7
            r11.J$1 = r9
            r11.label = r2
            java.lang.Object r0 = r4.m55doFlingAnimationQWom1Mo(r9, r11)
            if (r0 != r6) goto L60
            return r6
        L60:
            r2 = r9
        L61:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r9 = r0.packedValue
            androidx.compose.runtime.State<androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher> r0 = r4.nestedScrollDispatcher
            java.lang.Object r0 = r0.getValue()
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher) r0
            long r2 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r2, r9)
            r11.J$0 = r7
            r11.J$1 = r9
            r11.label = r1
            r1 = r2
            r3 = r9
            r5 = r11
            java.lang.Object r0 = r0.m403dispatchPostFlingRZ2iAVY(r1, r3, r5)
            if (r0 != r6) goto L81
            return r6
        L81:
            r2 = r7
        L82:
            androidx.compose.ui.unit.Velocity r0 = (androidx.compose.ui.unit.Velocity) r0
            long r0 = r0.packedValue
            long r0 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r9, r0)
            long r0 = androidx.compose.ui.unit.Velocity.m606minusAH228Gc(r2, r0)
            androidx.compose.ui.unit.Velocity r2 = new androidx.compose.ui.unit.Velocity
            r2.<init>(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
