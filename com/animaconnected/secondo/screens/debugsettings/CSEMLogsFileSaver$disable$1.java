package com.animaconnected.secondo.screens.debugsettings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: CSEMLogsFileSaver.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.CSEMLogsFileSaver", f = "CSEMLogsFileSaver.kt", l = {39, 41}, m = "disable")
/* loaded from: classes3.dex */
public final class CSEMLogsFileSaver$disable$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CSEMLogsFileSaver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CSEMLogsFileSaver$disable$1(CSEMLogsFileSaver cSEMLogsFileSaver, Continuation<? super CSEMLogsFileSaver$disable$1> continuation) {
        super(continuation);
        this.this$0 = cSEMLogsFileSaver;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.disable(null, this);
    }
}
