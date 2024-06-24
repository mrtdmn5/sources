package com.animaconnected.secondo.screens.workout.dashboard;

import com.amazonaws.services.s3.internal.Constants;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HealthOnboarding.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingUIState", f = "HealthOnboarding.kt", l = {Constants.BUCKET_REDIRECT_STATUS_CODE, 303}, m = "scrollToTop")
/* loaded from: classes3.dex */
public final class HealthOnboardingUIState$scrollToTop$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HealthOnboardingUIState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthOnboardingUIState$scrollToTop$1(HealthOnboardingUIState healthOnboardingUIState, Continuation<? super HealthOnboardingUIState$scrollToTop$1> continuation) {
        super(continuation);
        this.this$0 = healthOnboardingUIState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.scrollToTop(this);
    }
}
