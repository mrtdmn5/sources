package com.animaconnected.secondo.provider.productinfo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProductInfoProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.ProductInfoProvider", f = "ProductInfoProvider.kt", l = {114, 119}, m = "fetchProductInfo")
/* loaded from: classes3.dex */
public final class ProductInfoProvider$fetchProductInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductInfoProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductInfoProvider$fetchProductInfo$1(ProductInfoProvider productInfoProvider, Continuation<? super ProductInfoProvider$fetchProductInfo$1> continuation) {
        super(continuation);
        this.this$0 = productInfoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object fetchProductInfo;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        fetchProductInfo = this.this$0.fetchProductInfo(this);
        return fetchProductInfo;
    }
}
