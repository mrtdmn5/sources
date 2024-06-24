package com.animaconnected.watch;

import com.animaconnected.watch.device.WatchIO;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.WatchProvider$incomingCall$1", f = "WatchProvider.kt", l = {1060, 1069}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchProvider$incomingCall$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $alert;
    final /* synthetic */ WatchIO $io;
    final /* synthetic */ boolean $isRinging;
    final /* synthetic */ int $number;
    private /* synthetic */ Object L$0;
    boolean Z$0;
    int label;
    final /* synthetic */ WatchProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchProvider$incomingCall$1(WatchProvider watchProvider, boolean z, Integer num, WatchIO watchIO, int r5, Continuation<? super WatchProvider$incomingCall$1> continuation) {
        super(2, continuation);
        this.this$0 = watchProvider;
        this.$isRinging = z;
        this.$alert = num;
        this.$io = watchIO;
        this.$number = r5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WatchProvider$incomingCall$1 watchProvider$incomingCall$1 = new WatchProvider$incomingCall$1(this.this$0, this.$isRinging, this.$alert, this.$io, this.$number, continuation);
        watchProvider$incomingCall$1.L$0 = obj;
        return watchProvider$incomingCall$1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(1:(1:(6:5|6|7|(2:9|(1:14)(1:13))|15|16)(2:21|22))(3:23|24|25))(3:44|(5:47|(3:49|(1:53)|(1:55))|56|57|(1:59))|63)|27|28|(1:30)(1:38)|(2:32|33)(2:34|(1:36)(4:37|(0)|15|16))|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ee, code lost:            r12 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ef, code lost:            r7 = r12;        r4 = r3;     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac A[Catch: Exception -> 0x00ee, TryCatch #2 {Exception -> 0x00ee, blocks: (B:28:0x009e, B:30:0x00ac, B:32:0x00b2, B:34:0x00b5), top: B:27:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2 A[Catch: Exception -> 0x00ee, TryCatch #2 {Exception -> 0x00ee, blocks: (B:28:0x009e, B:30:0x00ac, B:32:0x00b2, B:34:0x00b5), top: B:27:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b5 A[Catch: Exception -> 0x00ee, TRY_LEAVE, TryCatch #2 {Exception -> 0x00ee, blocks: (B:28:0x009e, B:30:0x00ac, B:32:0x00b2, B:34:0x00b5), top: B:27:0x009e }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00cc A[Catch: Exception -> 0x0017, TRY_ENTER, TryCatch #3 {Exception -> 0x0017, blocks: (B:7:0x0012, B:9:0x00cc, B:11:0x00d0, B:13:0x00d4, B:14:0x00e4), top: B:6:0x0012 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.WatchProvider$incomingCall$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WatchProvider$incomingCall$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
