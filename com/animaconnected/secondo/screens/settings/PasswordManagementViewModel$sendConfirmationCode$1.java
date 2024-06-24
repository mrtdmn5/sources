package com.animaconnected.secondo.screens.settings;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: PasswordManagementViewModel.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.settings.PasswordManagementViewModel", f = "PasswordManagementViewModel.kt", l = {41}, m = "sendConfirmationCode")
/* loaded from: classes3.dex */
public final class PasswordManagementViewModel$sendConfirmationCode$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PasswordManagementViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordManagementViewModel$sendConfirmationCode$1(PasswordManagementViewModel passwordManagementViewModel, Continuation<? super PasswordManagementViewModel$sendConfirmationCode$1> continuation) {
        super(continuation);
        this.this$0 = passwordManagementViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.sendConfirmationCode(null, this);
    }
}
