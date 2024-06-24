package com.animaconnected.secondo.provider.productinfo;

import com.animaconnected.secondo.R;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ProductInfoProvider.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.ProductInfoProvider", f = "ProductInfoProvider.kt", l = {126, R.styleable.AppTheme_statusTextH5, 128, R.styleable.AppTheme_statusTopStripeImportant, R.styleable.AppTheme_statusTopStripeSetup, R.styleable.AppTheme_stepsHistoryBackgroundActivity, R.styleable.AppTheme_stepsHistoryBackgroundDetail, R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "downloadImages")
/* loaded from: classes3.dex */
public final class ProductInfoProvider$downloadImages$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProductInfoProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProductInfoProvider$downloadImages$1(ProductInfoProvider productInfoProvider, Continuation<? super ProductInfoProvider$downloadImages$1> continuation) {
        super(continuation);
        this.this$0 = productInfoProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object downloadImages;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        downloadImages = this.this$0.downloadImages(null, this);
        return downloadImages;
    }
}
