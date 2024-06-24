package com.animaconnected.watch;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: BtDevice.kt */
@DebugMetadata(c = "com.animaconnected.watch.BtDevice", f = "BtDevice.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_themeBackgroundGradientBottom, com.animaconnected.secondo.R.styleable.AppTheme_themeGradientOpacity, 202}, m = "establishConnection")
/* loaded from: classes3.dex */
public final class BtDevice$establishConnection$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BtDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BtDevice$establishConnection$1(BtDevice btDevice, Continuation<? super BtDevice$establishConnection$1> continuation) {
        super(continuation);
        this.this$0 = btDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object establishConnection;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        establishConnection = this.this$0.establishConnection(false, this);
        return establishConnection;
    }
}
