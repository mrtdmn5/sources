package com.animaconnected.watch.provider.preferences;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PreferenceProvider.kt */
@DebugMetadata(c = "com.animaconnected.watch.provider.preferences.PreferenceProvider", f = "PreferenceProvider.kt", l = {180}, m = "initPreferenceDefinition")
/* loaded from: classes3.dex */
public final class PreferenceProvider$initPreferenceDefinition$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PreferenceProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreferenceProvider$initPreferenceDefinition$1(PreferenceProvider preferenceProvider, Continuation<? super PreferenceProvider$initPreferenceDefinition$1> continuation) {
        super(continuation);
        this.this$0 = preferenceProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initPreferenceDefinition(null, null, null, this);
    }
}
