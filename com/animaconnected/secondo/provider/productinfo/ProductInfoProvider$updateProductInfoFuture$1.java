package com.animaconnected.secondo.provider.productinfo;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProductInfoProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$updateProductInfoFuture$1", f = "ProductInfoProvider.kt", l = {65}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProductInfoProvider$updateProductInfoFuture$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $forceUpdate;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductInfoProvider$updateProductInfoFuture$1(boolean z, Continuation<? super ProductInfoProvider$updateProductInfoFuture$1> continuation) {
        super(2, continuation);
        this.$forceUpdate = z;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductInfoProvider$updateProductInfoFuture$1(this.$forceUpdate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ProductInfoProvider productInfoProvider = ProductInfoProvider.INSTANCE;
            boolean z = this.$forceUpdate;
            this.label = 1;
            if (productInfoProvider.updateProductInfo(z, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProductInfoProvider$updateProductInfoFuture$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
