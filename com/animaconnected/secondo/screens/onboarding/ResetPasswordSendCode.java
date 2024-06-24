package com.animaconnected.secondo.screens.onboarding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentOnboardingResetPasswordSendCodeBinding;
import com.animaconnected.secondo.screens.BaseFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPasswordSendCode.kt */
/* loaded from: classes3.dex */
public final class ResetPasswordSendCode extends BaseFragment {
    private FragmentOnboardingResetPasswordSendCodeBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingResetPasswordSendCode.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ResetPasswordSendCode newInstance() {
            return new ResetPasswordSendCode();
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
        return "ResetPasswordSendCode";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentOnboardingResetPasswordSendCodeBinding inflate = FragmentOnboardingResetPasswordSendCodeBinding.inflate(inflater, viewGroup, false);
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
        FragmentOnboardingResetPasswordSendCodeBinding fragmentOnboardingResetPasswordSendCodeBinding = this.binding;
        if (fragmentOnboardingResetPasswordSendCodeBinding != null) {
            OnboardingResetPasswordSendCodeKt.setup(this, fragmentOnboardingResetPasswordSendCodeBinding, new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.ResetPasswordSendCode$onViewCreated$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String email) {
                    Intrinsics.checkNotNullParameter(email, "email");
                    ResetPasswordSendCode.this.getMainController().gotoNextFragment(ResetPassword.Companion.newInstance(email), true);
                }
            });
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
    }
}
