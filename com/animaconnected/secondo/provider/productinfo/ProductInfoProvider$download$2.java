package com.animaconnected.secondo.provider.productinfo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.net.URL;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProductInfoProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$download$2", f = "ProductInfoProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ProductInfoProvider$download$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ String $this_download;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductInfoProvider$download$2(String str, Continuation<? super ProductInfoProvider$download$2> continuation) {
        super(2, continuation);
        this.$this_download = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProductInfoProvider$download$2(this.$this_download, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return BitmapFactory.decodeStream(new URL(this.$this_download).openStream());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Bitmap> continuation) {
        return ((ProductInfoProvider$download$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
