package com.animaconnected.watch.behaviour.types;

import com.animaconnected.secondo.R;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: RememberThisSpot.kt */
@DebugMetadata(c = "com.animaconnected.watch.behaviour.types.RememberThisSpot$fetchLocation$1", f = "RememberThisSpot.kt", l = {108, 110, 113, 114, 118, 119, 123, 124, 128, R.styleable.AppTheme_statusTopStripeImportant}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RememberThisSpot$fetchLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ RememberThisSpot this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberThisSpot$fetchLocation$1(RememberThisSpot rememberThisSpot, Continuation<? super RememberThisSpot$fetchLocation$1> continuation) {
        super(2, continuation);
        this.this$0 = rememberThisSpot;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberThisSpot$fetchLocation$1(this.this$0, continuation);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0004. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x014f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0111 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0068 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.behaviour.types.RememberThisSpot$fetchLocation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberThisSpot$fetchLocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
