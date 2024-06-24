package com.animaconnected.secondo.behaviour.distress;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DistressPlugin.kt */
@DebugMetadata(c = "com.animaconnected.secondo.behaviour.distress.DistressPlugin$startDistress$2", f = "DistressPlugin.kt", l = {182}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DistressPlugin$startDistress$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DistressPlugin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DistressPlugin$startDistress$2(DistressPlugin distressPlugin, Continuation<? super DistressPlugin$startDistress$2> continuation) {
        super(2, continuation);
        this.this$0 = distressPlugin;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DistressPlugin$startDistress$2 distressPlugin$startDistress$2 = new DistressPlugin$startDistress$2(this.this$0, continuation);
        distressPlugin$startDistress$2.L$0 = obj;
        return distressPlugin$startDistress$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ea  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.behaviour.distress.DistressPlugin$startDistress$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DistressPlugin$startDistress$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
