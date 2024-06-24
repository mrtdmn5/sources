package com.animaconnected.secondo.utils;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.screens.settings.FormUiState;
import com.google.android.material.textfield.TextInputLayout;
import com.kronaby.watch.app.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountUtils.kt */
@DebugMetadata(c = "com.animaconnected.secondo.utils.AccountUtilsKt$initEmailField$2", f = "AccountUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountUtilsKt$initEmailField$2 extends SuspendLambda implements Function2<FormUiState, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextInputLayout $this_initEmailField;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountUtilsKt$initEmailField$2(TextInputLayout textInputLayout, Continuation<? super AccountUtilsKt$initEmailField$2> continuation) {
        super(2, continuation);
        this.$this_initEmailField = textInputLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountUtilsKt$initEmailField$2 accountUtilsKt$initEmailField$2 = new AccountUtilsKt$initEmailField$2(this.$this_initEmailField, continuation);
        accountUtilsKt$initEmailField$2.L$0 = obj;
        return accountUtilsKt$initEmailField$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FormUiState formUiState, Continuation<? super Unit> continuation) {
        return ((AccountUtilsKt$initEmailField$2) create(formUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FormUiState formUiState = (FormUiState) this.L$0;
            if (formUiState.isEmailValid()) {
                AccountUtilsKt.clearHelperAndError(this.$this_initEmailField);
            } else if (!formUiState.getHasEmailFocus() && !formUiState.isEmailEmpty()) {
                TextInputLayout textInputLayout = this.$this_initEmailField;
                String string = KronabyApplication.Companion.getContext().getString(R.string.account_error_email_invalid);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                AccountUtilsKt.showError(textInputLayout, string);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
