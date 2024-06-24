package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordConfirmBinding;
import com.animaconnected.secondo.provider.login.DialogInfo;
import com.animaconnected.secondo.provider.login.DialogMessage;
import com.animaconnected.secondo.provider.login.DialogMessageKt;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPasswordConfirm.kt */
/* loaded from: classes3.dex */
public final class ResetPasswordConfirm extends BaseFragment {
    private FragmentOnboardingResetPasswordConfirmBinding binding;
    private String email = "";
    private String newPassword = "";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingResetPasswordConfirm.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResetPasswordConfirm newInstance(String newPassword, String email) {
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            Intrinsics.checkNotNullParameter(email, "email");
            ResetPasswordConfirm resetPasswordConfirm = new ResetPasswordConfirm();
            Bundle bundle = new Bundle();
            bundle.putString("key-new-password", newPassword);
            bundle.putString("key-email", email);
            resetPasswordConfirm.setArguments(bundle);
            return resetPasswordConfirm;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "ResetPasswordConfirm";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key-email", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.email = string;
            String string2 = arguments.getString("key-new-password", "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this.newPassword = string2;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingResetPasswordConfirmBinding inflate = FragmentOnboardingResetPasswordConfirmBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        LinearLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentOnboardingResetPasswordConfirmBinding fragmentOnboardingResetPasswordConfirmBinding = this.binding;
        if (fragmentOnboardingResetPasswordConfirmBinding != null) {
            OnboardingResetPasswordConfirmKt.setup(this, fragmentOnboardingResetPasswordConfirmBinding, this.email, this.newPassword, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ResetPasswordConfirm$onViewCreated$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Context requireContext = ResetPasswordConfirm.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    DialogInfo dialogInfo = DialogMessageKt.getDialogInfo(DialogMessage.ResetPasswordSuccess.INSTANCE);
                    final ResetPasswordConfirm resetPasswordConfirm = ResetPasswordConfirm.this;
                    AccountUtilsKt.showDialogInfo(requireContext, dialogInfo, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ResetPasswordConfirm$onViewCreated$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            FragmentManager supportFragmentManager;
                            FragmentActivity activity = ResetPasswordConfirm.this.getActivity();
                            if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                                return;
                            }
                            supportFragmentManager.popBackStack("ProfileFragment");
                        }
                    });
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }
}
