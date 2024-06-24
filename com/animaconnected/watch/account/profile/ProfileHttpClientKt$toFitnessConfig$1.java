package com.animaconnected.watch.account.profile;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileHttpClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.profile.ProfileHttpClientKt", f = "ProfileHttpClient.kt", l = {105}, m = "toFitnessConfig")
/* loaded from: classes3.dex */
public final class ProfileHttpClientKt$toFitnessConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public ProfileHttpClientKt$toFitnessConfig$1(Continuation<? super ProfileHttpClientKt$toFitnessConfig$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fitnessConfig;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fitnessConfig = ProfileHttpClientKt.toFitnessConfig(null, this);
        return fitnessConfig;
    }
}
