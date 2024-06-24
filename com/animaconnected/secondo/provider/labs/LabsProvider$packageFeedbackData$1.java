package com.animaconnected.secondo.provider.labs;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LabsProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.labs.LabsProvider", f = "LabsProvider.kt", l = {112}, m = "packageFeedbackData")
/* loaded from: classes3.dex */
public final class LabsProvider$packageFeedbackData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LabsProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LabsProvider$packageFeedbackData$1(LabsProvider labsProvider, Continuation<? super LabsProvider$packageFeedbackData$1> continuation) {
        super(continuation);
        this.this$0 = labsProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object packageFeedbackData;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        packageFeedbackData = this.this$0.packageFeedbackData(null, null, null, this);
        return packageFeedbackData;
    }
}
