package com.animaconnected.secondo.provider.googlefit;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: GoogleFitApi.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadStepsInChunks$2", f = "GoogleFitApi.kt", l = {63}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class GoogleFitApi$uploadStepsInChunks$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ GoogleFitApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleFitApi$uploadStepsInChunks$2(GoogleFitApi googleFitApi, Continuation<? super GoogleFitApi$uploadStepsInChunks$2> continuation) {
        super(2, continuation);
        this.this$0 = googleFitApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleFitApi$uploadStepsInChunks$2(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0162  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0158 -> B:5:0x015d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.googlefit.GoogleFitApi$uploadStepsInChunks$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleFitApi$uploadStepsInChunks$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
