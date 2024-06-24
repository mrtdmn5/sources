package com.animaconnected.watch.account.profile;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProfileHttpClient.kt */
@DebugMetadata(c = "com.animaconnected.watch.account.profile.ProfileHttpClient", f = "ProfileHttpClient.kt", l = {126, 75}, m = "putFitnessConfig")
/* loaded from: classes3.dex */
public final class ProfileHttpClient$putFitnessConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileHttpClient this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileHttpClient$putFitnessConfig$1(ProfileHttpClient profileHttpClient, Continuation<? super ProfileHttpClient$putFitnessConfig$1> continuation) {
        super(continuation);
        this.this$0 = profileHttpClient;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.putFitnessConfig(null, null, this);
    }
}
