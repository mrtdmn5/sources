package com.amplifyframework.kotlin.geo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinGeoFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.geo.KotlinGeoFacade", f = "KotlinGeoFacade.kt", l = {37}, m = "getDefaultMap")
/* loaded from: classes.dex */
public final class KotlinGeoFacade$getDefaultMap$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinGeoFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinGeoFacade$getDefaultMap$1(KotlinGeoFacade kotlinGeoFacade, Continuation<? super KotlinGeoFacade$getDefaultMap$1> continuation) {
        super(continuation);
        this.this$0 = kotlinGeoFacade;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDefaultMap(this);
    }
}
