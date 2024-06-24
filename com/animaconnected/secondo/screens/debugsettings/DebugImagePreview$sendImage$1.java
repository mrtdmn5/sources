package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: DebugImagePreview.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview", f = "DebugImagePreview.kt", l = {180}, m = "sendImage")
/* loaded from: classes3.dex */
public final class DebugImagePreview$sendImage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebugImagePreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugImagePreview$sendImage$1(DebugImagePreview debugImagePreview, Continuation<? super DebugImagePreview$sendImage$1> continuation) {
        super(continuation);
        this.this$0 = debugImagePreview;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object sendImage;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        sendImage = this.this$0.sendImage(null, this);
        return sendImage;
    }
}
