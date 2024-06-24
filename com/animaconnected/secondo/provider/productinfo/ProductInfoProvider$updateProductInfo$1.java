package com.animaconnected.secondo.provider.productinfo;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProductInfoProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.ProductInfoProvider", f = "ProductInfoProvider.kt", l = {83, 104}, m = "updateProductInfo")
/* loaded from: classes3.dex */
public final class ProductInfoProvider$updateProductInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductInfoProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductInfoProvider$updateProductInfo$1(ProductInfoProvider productInfoProvider, Continuation<? super ProductInfoProvider$updateProductInfo$1> continuation) {
        super(continuation);
        this.this$0 = productInfoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateProductInfo(false, this);
    }
}
