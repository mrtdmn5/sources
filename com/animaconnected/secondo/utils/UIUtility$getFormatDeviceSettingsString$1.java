package com.animaconnected.secondo.utils;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: UIUtility.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.UIUtility", f = "UIUtility.kt", l = {41, 46, 51}, m = "getFormatDeviceSettingsString")
/* loaded from: classes3.dex */
public final class UIUtility$getFormatDeviceSettingsString$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    public UIUtility$getFormatDeviceSettingsString$1(Continuation<? super UIUtility$getFormatDeviceSettingsString$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UIUtility.getFormatDeviceSettingsString(null, false, this);
    }
}
