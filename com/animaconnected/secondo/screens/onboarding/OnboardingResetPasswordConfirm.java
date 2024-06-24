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
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.OnboardingLoginWithEmailFragment;
import com.animaconnected.secondo.utils.AccountUtilsKt;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingResetPasswordConfirm.kt */
/* loaded from: classes3.dex */
public final class OnboardingResetPasswordConfirm extends BaseOnboardingFragment {
    private FragmentOnboardingResetPasswordConfirmBinding binding;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private String email = "";
    private String newPassword = "";
    private final String name = "OnboardingResetPasswordSendCode";

    /* compiled from: OnboardingResetPasswordConfirm.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingResetPasswordConfirm newInstance(String newPassword, String email) {
            Intrinsics.checkNotNullParameter(newPassword, "newPassword");
            Intrinsics.checkNotNullParameter(email, "email");
            OnboardingResetPasswordConfirm onboardingResetPasswordConfirm = new OnboardingResetPasswordConfirm();
            Bundle bundle = new Bundle();
            bundle.putString("key-new-password", newPassword);
            bundle.putString("key-email", email);
            onboardingResetPasswordConfirm.setArguments(bundle);
            return onboardingResetPasswordConfirm;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        return R.anim.exit_to_left;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return "";
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopEnterAnimRes() {
        return R.anim.enter_from_left;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopExitAnimRes() {
        return R.anim.exit_to_right;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.SIGNIN) {
            return true;
        }
        return false;
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
            OnboardingResetPasswordConfirmKt.setup(this, fragmentOnboardingResetPasswordConfirmBinding, this.email, this.newPassword, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirm$onViewCreated$1
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
                    String str;
                    String str2;
                    OnboardingLoginWithEmailFragment.Companion companion = OnboardingLoginWithEmailFragment.Companion;
                    str = OnboardingResetPasswordConfirm.this.email;
                    companion.setEmail(str);
                    str2 = OnboardingResetPasswordConfirm.this.newPassword;
                    companion.setPassword(str2);
                    Context requireContext = OnboardingResetPasswordConfirm.this.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                    DialogInfo dialogInfo = DialogMessageKt.getDialogInfo(DialogMessage.ResetPasswordSuccess.INSTANCE);
                    final OnboardingResetPasswordConfirm onboardingResetPasswordConfirm = OnboardingResetPasswordConfirm.this;
                    AccountUtilsKt.showDialogInfo(requireContext, dialogInfo, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingResetPasswordConfirm$onViewCreated$1.1
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
                            FragmentActivity activity = OnboardingResetPasswordConfirm.this.getActivity();
                            if (activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null) {
                                return;
                            }
                            supportFragmentManager.popBackStack("OnboardingResetPasswordSendCode");
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
