package kotlinx.coroutines.flow;

import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* compiled from: SharingStarted.kt */
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {R.styleable.AppTheme_topPusherDropZoneSelected, 180, 182, 183, 185}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    public /* synthetic */ int I$0;
    public /* synthetic */ FlowCollector L$0;
    public int label;
    public final /* synthetic */ StartedWhileSubscribed this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StartedWhileSubscribed$command$1(StartedWhileSubscribed startedWhileSubscribed, Continuation<? super StartedWhileSubscribed$command$1> continuation) {
        super(3, continuation);
        this.this$0 = startedWhileSubscribed;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(FlowCollector<? super SharingCommand> flowCollector, Integer num, Continuation<? super Unit> continuation) {
        int intValue = num.intValue();
        StartedWhileSubscribed$command$1 startedWhileSubscribed$command$1 = new StartedWhileSubscribed$command$1(this.this$0, continuation);
        startedWhileSubscribed$command$1.L$0 = flowCollector;
        startedWhileSubscribed$command$1.I$0 = intValue;
        return startedWhileSubscribed$command$1.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
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
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            kotlinx.coroutines.flow.StartedWhileSubscribed r7 = r10.this$0
            if (r1 == 0) goto L36
            if (r1 == r6) goto L32
            if (r1 == r5) goto L2c
            if (r1 == r4) goto L26
            if (r1 == r3) goto L20
            if (r1 != r2) goto L18
            goto L32
        L18:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L20:
            kotlinx.coroutines.flow.FlowCollector r1 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L7a
        L26:
            kotlinx.coroutines.flow.FlowCollector r1 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L6d
        L2c:
            kotlinx.coroutines.flow.FlowCollector r1 = r10.L$0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L58
        L32:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L88
        L36:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.flow.FlowCollector r11 = r10.L$0
            int r1 = r10.I$0
            if (r1 <= 0) goto L4a
            kotlinx.coroutines.flow.SharingCommand r1 = kotlinx.coroutines.flow.SharingCommand.START
            r10.label = r6
            java.lang.Object r11 = r11.emit(r1, r10)
            if (r11 != r0) goto L88
            return r0
        L4a:
            long r8 = r7.stopTimeout
            r10.L$0 = r11
            r10.label = r5
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r8, r10)
            if (r1 != r0) goto L57
            return r0
        L57:
            r1 = r11
        L58:
            long r5 = r7.replayExpiration
            r8 = 0
            int r11 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r11 <= 0) goto L7a
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP
            r10.L$0 = r1
            r10.label = r4
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L6d
            return r0
        L6d:
            long r4 = r7.replayExpiration
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r4, r10)
            if (r11 != r0) goto L7a
            return r0
        L7a:
            kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingCommand.STOP_AND_RESET_REPLAY_CACHE
            r3 = 0
            r10.L$0 = r3
            r10.label = r2
            java.lang.Object r11 = r1.emit(r11, r10)
            if (r11 != r0) goto L88
            return r0
        L88:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StartedWhileSubscribed$command$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
