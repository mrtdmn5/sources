package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Watch.kt */
@DebugMetadata(c = "com.animaconnected.watch.Watch$handleCrash$2", f = "Watch.kt", l = {575, 578, 584, 586, 588, 597}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Watch$handleCrash$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $hwReason;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ Watch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Watch$handleCrash$2(Watch watch, Integer num, Continuation<? super Watch$handleCrash$2> continuation) {
        super(2, continuation);
        this.this$0 = watch;
        this.$hwReason = num;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Watch$handleCrash$2 watch$handleCrash$2 = new Watch$handleCrash$2(this.this$0, this.$hwReason, continuation);
        watch$handleCrash$2.L$0 = obj;
        return watch$handleCrash$2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:16:0x019f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0170 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0149 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[Catch: Exception -> 0x0071, TryCatch #2 {Exception -> 0x0071, blocks: (B:8:0x0019, B:9:0x01a2, B:22:0x014d, B:30:0x0126, B:39:0x006c, B:40:0x00f2, B:45:0x00ba, B:47:0x00c2, B:49:0x00ce, B:53:0x00f8, B:57:0x01a6, B:60:0x00a8), top: B:2:0x0006 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.Watch$handleCrash$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Watch$handleCrash$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
