package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordBinding;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.onboarding.ResetPasswordConfirm;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPassword.kt */
/* loaded from: classes3.dex */
public final class ResetPassword extends BaseFragment {
    private FragmentOnboardingResetPasswordBinding binding;
    private String email = "";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingResetPassword.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResetPassword newInstance(String email) {
            Intrinsics.checkNotNullParameter(email, "email");
            ResetPassword resetPassword = new ResetPassword();
            Bundle bundle = new Bundle();
            bundle.putString("key-email", email);
            resetPassword.setArguments(bundle);
            return resetPassword;
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
        return "ResetPassword";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("key-email", "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this.email = string;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingResetPasswordBinding inflate = FragmentOnboardingResetPasswordBinding.inflate(inflater, viewGroup, false);
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
        FragmentOnboardingResetPasswordBinding fragmentOnboardingResetPasswordBinding = this.binding;
        if (fragmentOnboardingResetPasswordBinding != null) {
            OnboardingResetPasswordKt.setup(this, fragmentOnboardingResetPasswordBinding, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ResetPassword$onViewCreated$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String newPassword) {
                    String str;
                    Intrinsics.checkNotNullParameter(newPassword, "newPassword");
                    MainController mainController = ResetPassword.this.getMainController();
                    ResetPasswordConfirm.Companion companion = ResetPasswordConfirm.Companion;
                    str = ResetPassword.this.email;
                    mainController.gotoNextFragment(companion.newInstance(newPassword, str), true);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }
}
