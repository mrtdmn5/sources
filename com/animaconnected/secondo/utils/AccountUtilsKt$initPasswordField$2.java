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
@DebugMetadata(c = "com.animaconnected.secondo.utils.AccountUtilsKt$initPasswordField$2", f = "AccountUtils.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class AccountUtilsKt$initPasswordField$2 extends SuspendLambda implements Function2<FormUiState, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextInputLayout $this_initPasswordField;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountUtilsKt$initPasswordField$2(TextInputLayout textInputLayout, Continuation<? super AccountUtilsKt$initPasswordField$2> continuation) {
        super(2, continuation);
        this.$this_initPasswordField = textInputLayout;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountUtilsKt$initPasswordField$2 accountUtilsKt$initPasswordField$2 = new AccountUtilsKt$initPasswordField$2(this.$this_initPasswordField, continuation);
        accountUtilsKt$initPasswordField$2.L$0 = obj;
        return accountUtilsKt$initPasswordField$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FormUiState formUiState, Continuation<? super Unit> continuation) {
        return ((AccountUtilsKt$initPasswordField$2) create(formUiState, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FormUiState formUiState = (FormUiState) this.L$0;
            if (formUiState.isPasswordValid()) {
                AccountUtilsKt.clearHelperAndError(this.$this_initPasswordField);
            } else if (formUiState.isPasswordEmpty()) {
                TextInputLayout textInputLayout = this.$this_initPasswordField;
                String string = KronabyApplication.Companion.getContext().getString(R.string.account_validation_password);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                AccountUtilsKt.showHelper(textInputLayout, string);
            } else if (!formUiState.getHasPasswordFocus()) {
                TextInputLayout textInputLayout2 = this.$this_initPasswordField;
                String string2 = KronabyApplication.Companion.getContext().getString(R.string.account_validation_password);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                AccountUtilsKt.showError(textInputLayout2, string2);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
