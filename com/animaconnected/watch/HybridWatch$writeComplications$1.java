package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HybridWatch.kt */
@DebugMetadata(c = "com.animaconnected.watch.HybridWatch", f = "HybridWatch.kt", l = {126, com.animaconnected.secondo.R.styleable.AppTheme_statusTextH5, 128, com.animaconnected.secondo.R.styleable.AppTheme_statusTopStripeImportant, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryHintColorDetail, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryLineColorDetail, com.animaconnected.secondo.R.styleable.AppTheme_themeBackgroundResource, com.animaconnected.secondo.R.styleable.AppTheme_topPusherDropZoneSelected, 202, 208, 215}, m = "writeComplications")
/* loaded from: classes3.dex */
public final class HybridWatch$writeComplications$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HybridWatch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HybridWatch$writeComplications$1(HybridWatch hybridWatch, Continuation<? super HybridWatch$writeComplications$1> continuation) {
        super(continuation);
        this.this$0 = hybridWatch;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object writeComplications;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        writeComplications = this.this$0.writeComplications(null, this);
        return writeComplications;
    }
}
