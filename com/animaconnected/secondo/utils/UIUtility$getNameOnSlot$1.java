package com.animaconnected.secondo.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UIUtility.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.UIUtility", f = "UIUtility.kt", l = {68}, m = "getNameOnSlot")
/* loaded from: classes3.dex */
public final class UIUtility$getNameOnSlot$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UIUtility this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UIUtility$getNameOnSlot$1(UIUtility uIUtility, Continuation<? super UIUtility$getNameOnSlot$1> continuation) {
        super(continuation);
        this.this$0 = uIUtility;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object nameOnSlot;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        nameOnSlot = this.this$0.getNameOnSlot(null, this);
        return nameOnSlot;
    }
}
