package com.amplifyframework.kotlin.geo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: KotlinGeoFacade.kt */
@DebugMetadata(c = "com.amplifyframework.kotlin.geo.KotlinGeoFacade", f = "KotlinGeoFacade.kt", l = {68}, m = "searchByCoordinates")
/* loaded from: classes.dex */
public final class KotlinGeoFacade$searchByCoordinates$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ KotlinGeoFacade this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinGeoFacade$searchByCoordinates$1(KotlinGeoFacade kotlinGeoFacade, Continuation<? super KotlinGeoFacade$searchByCoordinates$1> continuation) {
        super(continuation);
        this.this$0 = kotlinGeoFacade;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.searchByCoordinates(null, null, this);
    }
}
