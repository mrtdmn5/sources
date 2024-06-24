package com.animaconnected.secondo.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.animaconnected.secondo.provider.login.DialogInfo;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.settings.FormValidationViewModel;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: AccountUtils.kt */
/* loaded from: classes3.dex */
public final class AccountUtilsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearHelperAndError(TextInputLayout textInputLayout) {
        textInputLayout.setError("");
        textInputLayout.setHelperText("");
        textInputLayout.setErrorEnabled(false);
        textInputLayout.setHelperTextEnabled(false);
    }

    public static final void initEmailField(TextInputLayout textInputLayout, final FormValidationViewModel vm, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(textInputLayout, "<this>");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(scope, "scope");
        EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$$ExternalSyntheticLambda2
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    AccountUtilsKt.initEmailField$lambda$2$lambda$0(FormValidationViewModel.this, view, z);
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$initEmailField$lambda$2$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    FormValidationViewModel.this.setEmail(String.valueOf(editable));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
        }
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountUtilsKt$initEmailField$2(textInputLayout, null), vm.getState()), new AccountUtilsKt$initEmailField$3(null)), scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initEmailField$lambda$2$lambda$0(FormValidationViewModel vm, View view, boolean z) {
        Intrinsics.checkNotNullParameter(vm, "$vm");
        vm.setEmailHasFocus(z);
    }

    public static final void initPasswordField(TextInputLayout textInputLayout, final FormValidationViewModel vm, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(textInputLayout, "<this>");
        Intrinsics.checkNotNullParameter(vm, "vm");
        Intrinsics.checkNotNullParameter(scope, "scope");
        final EditText editText = textInputLayout.getEditText();
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$$ExternalSyntheticLambda0
                @Override // android.view.View.OnFocusChangeListener
                public final void onFocusChange(View view, boolean z) {
                    AccountUtilsKt.initPasswordField$lambda$6$lambda$3(FormValidationViewModel.this, view, z);
                }
            });
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$$ExternalSyntheticLambda1
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int r3, KeyEvent keyEvent) {
                    boolean initPasswordField$lambda$6$lambda$4;
                    initPasswordField$lambda$6$lambda$4 = AccountUtilsKt.initPasswordField$lambda$6$lambda$4(editText, textView, r3, keyEvent);
                    return initPasswordField$lambda$6$lambda$4;
                }
            });
            editText.addTextChangedListener(new TextWatcher() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$initPasswordField$lambda$6$$inlined$doAfterTextChanged$1
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    FormValidationViewModel.this.setPassword(String.valueOf(editable));
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int r2, int r3, int r4) {
                }
            });
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new AccountUtilsKt$initPasswordField$2(textInputLayout, null), vm.getState()), new AccountUtilsKt$initPasswordField$3(null)), scope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPasswordField$lambda$6$lambda$3(FormValidationViewModel vm, View view, boolean z) {
        Intrinsics.checkNotNullParameter(vm, "$vm");
        vm.setPasswordHasFocus(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initPasswordField$lambda$6$lambda$4(EditText this_apply, TextView textView, int r2, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        if (r2 == 6) {
            this_apply.clearFocus();
            return false;
        }
        return false;
    }

    public static final void showDialogInfo(Context context, DialogInfo info, Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        BottomSheetKt.createBottomDialog(context, new AccountUtilsKt$showDialogInfo$2(info, onClose)).show();
    }

    public static /* synthetic */ void showDialogInfo$default(Context context, DialogInfo dialogInfo, Function0 function0, int r3, Object obj) {
        if ((r3 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.utils.AccountUtilsKt$showDialogInfo$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        showDialogInfo(context, dialogInfo, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showError(TextInputLayout textInputLayout, String str) {
        textInputLayout.setHelperText("");
        textInputLayout.setHelperTextEnabled(false);
        textInputLayout.setErrorEnabled(true);
        textInputLayout.setError(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showHelper(TextInputLayout textInputLayout, String str) {
        textInputLayout.setError("");
        textInputLayout.setErrorEnabled(false);
        textInputLayout.setHelperTextEnabled(true);
        textInputLayout.setHelperText(str);
    }
}
