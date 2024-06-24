package com.animaconnected.secondo.screens.onboarding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentSettingsProfileBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.account.profile.ProfileState;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: OnboardingProfile.kt */
/* loaded from: classes3.dex */
public final class OnboardingProfile extends BaseOnboardingFragment {
    public static final int $stable = 8;
    private FragmentSettingsProfileBinding binding;
    private LoginViewModel loginViewModel;
    private final String name = "OnboardingProfile";
    private final FitnessProvider fitnessProvider = ProviderFactory.getWatch().fitness();
    private final Lazy profileViewModel$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ProfileViewModel>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingProfile$profileViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProfileViewModel invoke() {
            String bestDateTimePattern = DateFormat.getBestDateTimePattern(ProviderFactory.createConfigProvider().getTranslationCompatibleLocale(), "MMM d, yyyy");
            Intrinsics.checkNotNullExpressionValue(bestDateTimePattern, "getBestDateTimePattern(...)");
            return new ProfileViewModel(ProviderFactory.getWatch().fitness().getProfile(), new AndroidDateFormatter(bestDateTimePattern, null, 2, null));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(OnboardingProfile this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void renderProfileState(ProfileState profileState) {
        if (profileState instanceof ProfileState.Content) {
            FragmentSettingsProfileBinding fragmentSettingsProfileBinding = this.binding;
            if (fragmentSettingsProfileBinding != null) {
                setProfileLoading(false);
                ProfileState.Content content = (ProfileState.Content) profileState;
                fragmentSettingsProfileBinding.profileBirthValue.setText(content.getAttributes().getDateOfBirth());
                fragmentSettingsProfileBinding.profileGenderValue.setText(content.getAttributes().getGender());
                fragmentSettingsProfileBinding.profileHeightValue.setText(content.getAttributes().getHeight());
                fragmentSettingsProfileBinding.profileWeightValue.setText(content.getAttributes().getWeight());
                fragmentSettingsProfileBinding.unitsMeasurementsValue.setText(content.getAttributes().getMeasurement());
                fragmentSettingsProfileBinding.unitsTemperatureValue.setText(content.getAttributes().getTemperature());
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        if (profileState instanceof ProfileState.Loading) {
            setProfileLoading(true);
        } else {
            if (profileState instanceof ProfileState.Error) {
                setProfileLoading(false);
                return;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void setProfileLoading(boolean z) {
        FragmentSettingsProfileBinding fragmentSettingsProfileBinding = this.binding;
        if (fragmentSettingsProfileBinding != null) {
            if (z) {
                fragmentSettingsProfileBinding.scrollView.setAlpha(0.5f);
                ProgressBar progressBar = fragmentSettingsProfileBinding.progressBar;
                Intrinsics.checkNotNullExpressionValue(progressBar, "progressBar");
                ViewKt.visible(progressBar);
                return;
            }
            fragmentSettingsProfileBinding.scrollView.setAlpha(1.0f);
            ProgressBar progressBar2 = fragmentSettingsProfileBinding.progressBar;
            Intrinsics.checkNotNullExpressionValue(progressBar2, "progressBar");
            ViewKt.gone(progressBar2);
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
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
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.loginViewModel = ProviderFactory.createLoginViewModel();
        FragmentSettingsProfileBinding inflate = FragmentSettingsProfileBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        LinearLayout profileBirthContainer = inflate.profileBirthContainer;
        Intrinsics.checkNotNullExpressionValue(profileBirthContainer, "profileBirthContainer");
        onClick(profileBirthContainer, new OnboardingProfile$onCreateView$1$1(this, null));
        LinearLayout profileGenderContainer = inflate.profileGenderContainer;
        Intrinsics.checkNotNullExpressionValue(profileGenderContainer, "profileGenderContainer");
        onClick(profileGenderContainer, new OnboardingProfile$onCreateView$1$2(this, null));
        LinearLayout profileHeightContainer = inflate.profileHeightContainer;
        Intrinsics.checkNotNullExpressionValue(profileHeightContainer, "profileHeightContainer");
        onClick(profileHeightContainer, new OnboardingProfile$onCreateView$1$3(this, null));
        LinearLayout profileWeightContainer = inflate.profileWeightContainer;
        Intrinsics.checkNotNullExpressionValue(profileWeightContainer, "profileWeightContainer");
        onClick(profileWeightContainer, new OnboardingProfile$onCreateView$1$4(this, null));
        LinearLayout unitsTemperatureContainer = inflate.unitsTemperatureContainer;
        Intrinsics.checkNotNullExpressionValue(unitsTemperatureContainer, "unitsTemperatureContainer");
        onClick(unitsTemperatureContainer, new OnboardingProfile$onCreateView$1$5(this, null));
        LinearLayout unitsMeasurementsContainer = inflate.unitsMeasurementsContainer;
        Intrinsics.checkNotNullExpressionValue(unitsMeasurementsContainer, "unitsMeasurementsContainer");
        onClick(unitsMeasurementsContainer, new OnboardingProfile$onCreateView$1$6(this, null));
        inflate.tvDateOfBirth.setText(getString(R.string.profile_date_of_birth_title) + ':');
        inflate.tvSex.setText(getString(R.string.profile_sex_title) + ':');
        inflate.tvHeight.setText(getString(R.string.profile_height_title) + ':');
        inflate.tvWeight.setText(getString(R.string.profile_weight_title) + ':');
        inflate.tvMeasurement.setText(getString(R.string.profile_mesaurements_title) + ':');
        inflate.tvTemperature.setText(getString(R.string.profile_temperature_title) + ':');
        this.binding = inflate;
        RelativeLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        String string;
        int r0;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentSettingsProfileBinding fragmentSettingsProfileBinding = this.binding;
        if (fragmentSettingsProfileBinding != null) {
            Button button = fragmentSettingsProfileBinding.btnCreateAccount;
            button.setText(getString(R.string.onboarding_continue));
            onClick(button, new OnboardingProfile$onViewCreated$1$1$1(this, null));
            Button btnLogIn = fragmentSettingsProfileBinding.btnLogIn;
            Intrinsics.checkNotNullExpressionValue(btnLogIn, "btnLogIn");
            ViewKt.gone(btnLogIn);
            LinearLayout layoutAccSettings = fragmentSettingsProfileBinding.layoutAccSettings;
            Intrinsics.checkNotNullExpressionValue(layoutAccSettings, "layoutAccSettings");
            ViewKt.gone(layoutAccSettings);
            TextView textView = fragmentSettingsProfileBinding.tvAccountTitle;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (Intrinsics.areEqual(new SigninStorage(requireContext).getState(), LoginState.SignedIn.INSTANCE)) {
                string = getString(R.string.settings_account_my_account_title);
            } else {
                string = getString(R.string.settings_account_no_account_title);
            }
            textView.setText(string);
            if (isOnboarding()) {
                fragmentSettingsProfileBinding.tvAccountTitle.setText(getString(R.string.profile_onboarding_about_you));
            }
            TextView tvAboutYouDescription = fragmentSettingsProfileBinding.tvAboutYouDescription;
            Intrinsics.checkNotNullExpressionValue(tvAboutYouDescription, "tvAboutYouDescription");
            if (isOnboarding()) {
                r0 = 0;
            } else {
                r0 = 8;
            }
            tvAboutYouDescription.setVisibility(r0);
            FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new OnboardingProfile$onViewCreated$2(this, null), getProfileViewModel().observeState()), new OnboardingProfile$onViewCreated$3(this, null)), Hashing.getLifecycleScope(this));
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new OnboardingProfile$onViewCreated$4(this, null), 3);
            if (!isOnboarding()) {
                AnimatedToolbar toolbar = getToolbar();
                if (toolbar != null) {
                    toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingProfile$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            OnboardingProfile.onViewCreated$lambda$3(OnboardingProfile.this, view2);
                        }
                    });
                    return;
                }
                return;
            }
            AnimatedToolbar toolbar2 = getToolbar();
            if (toolbar2 != null) {
                toolbar2.setNavigationIcon((Drawable) null);
                return;
            }
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
