package com.animaconnected.secondo.provider.googlefit;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onHourly$2", f = "GoogleFitProvider.kt", l = {227, 229, 230, 231}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitProvider$onHourly$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleFitProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitProvider$onHourly$2(GoogleFitProvider googleFitProvider, Continuation<? super GoogleFitProvider$onHourly$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleFitProvider$onHourly$2 googleFitProvider$onHourly$2 = new GoogleFitProvider$onHourly$2(this.this$0, continuation);
        googleFitProvider$onHourly$2.L$0 = obj;
        return googleFitProvider$onHourly$2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0 A[RETURN] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.googlefit.GoogleFitProvider$onHourly$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitProvider$onHourly$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
