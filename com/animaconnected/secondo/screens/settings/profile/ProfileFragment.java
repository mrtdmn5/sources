package com.animaconnected.secondo.screens.settings.profile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.databinding.FragmentSettingsProfileBinding;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.login.LoginViewModel;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.account.profile.ProfileState;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.provider.demo.DemoModeProvider;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: ProfileFragment.kt */
/* loaded from: classes3.dex */
public final class ProfileFragment extends BaseFragment {
    private FragmentSettingsProfileBinding binding;
    private LoginViewModel loginViewModel;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final FitnessProvider fitnessProvider = ProviderFactory.getWatch().fitness();
    private final DemoModeProvider demoModeProvider = ProviderFactory.getWatch().getWatchManager().getDemoModeProvider();
    private final Lazy profileViewModel$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ProfileViewModel>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileFragment$profileViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ProfileViewModel invoke() {
            String bestDateTimePattern = DateFormat.getBestDateTimePattern(ProviderFactory.createConfigProvider().getTranslationCompatibleLocale(), "MMM d, yyyy");
            Intrinsics.checkNotNullExpressionValue(bestDateTimePattern, "getBestDateTimePattern(...)");
            return new ProfileViewModel(ProviderFactory.getWatch().fitness().getProfile(), new AndroidDateFormatter(bestDateTimePattern, null, 2, null));
        }
    });

    /* compiled from: ProfileFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileFragment newInstance() {
            return new ProfileFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateLogin(boolean z) {
        if (z) {
            FragmentSettingsProfileBinding fragmentSettingsProfileBinding = this.binding;
            if (fragmentSettingsProfileBinding != null) {
                BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ProfileFragment$invalidateLogin$1$1(this, null), 3);
                LinearLayout layoutAccSettings = fragmentSettingsProfileBinding.layoutAccSettings;
                Intrinsics.checkNotNullExpressionValue(layoutAccSettings, "layoutAccSettings");
                ViewKt.visible(layoutAccSettings);
                LinearLayout layoutSignIn = fragmentSettingsProfileBinding.layoutSignIn;
                Intrinsics.checkNotNullExpressionValue(layoutSignIn, "layoutSignIn");
                ViewKt.gone(layoutSignIn);
                fragmentSettingsProfileBinding.tvAccountTitle.setText(getString(R.string.settings_account_my_account_title));
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        FragmentSettingsProfileBinding fragmentSettingsProfileBinding2 = this.binding;
        if (fragmentSettingsProfileBinding2 != null) {
            BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new ProfileFragment$invalidateLogin$2$1(this, null), 3);
            LinearLayout layoutSignIn2 = fragmentSettingsProfileBinding2.layoutSignIn;
            Intrinsics.checkNotNullExpressionValue(layoutSignIn2, "layoutSignIn");
            ViewKt.visible(layoutSignIn2);
            LinearLayout layoutAccSettings2 = fragmentSettingsProfileBinding2.layoutAccSettings;
            Intrinsics.checkNotNullExpressionValue(layoutAccSettings2, "layoutAccSettings");
            ViewKt.gone(layoutAccSettings2);
            fragmentSettingsProfileBinding2.tvAccountTitle.setText(getString(R.string.settings_account_no_account_title));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateProfile(ProfileState profileState) {
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

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    public final void checkAndUpdateUiState() {
        LoginViewModel loginViewModel = this.loginViewModel;
        if (loginViewModel != null) {
            loginViewModel.loadStoredState();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "ProfileFragment";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        LoginViewModel createLoginViewModel = ProviderFactory.createLoginViewModel();
        createLoginViewModel.loadStoredState();
        this.loginViewModel = createLoginViewModel;
        FragmentSettingsProfileBinding inflate = FragmentSettingsProfileBinding.inflate(inflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        LinearLayout profileBirthContainer = inflate.profileBirthContainer;
        Intrinsics.checkNotNullExpressionValue(profileBirthContainer, "profileBirthContainer");
        onClick(profileBirthContainer, new ProfileFragment$onCreateView$2$1(this, null));
        LinearLayout profileGenderContainer = inflate.profileGenderContainer;
        Intrinsics.checkNotNullExpressionValue(profileGenderContainer, "profileGenderContainer");
        onClick(profileGenderContainer, new ProfileFragment$onCreateView$2$2(this, null));
        LinearLayout profileHeightContainer = inflate.profileHeightContainer;
        Intrinsics.checkNotNullExpressionValue(profileHeightContainer, "profileHeightContainer");
        onClick(profileHeightContainer, new ProfileFragment$onCreateView$2$3(this, null));
        LinearLayout profileWeightContainer = inflate.profileWeightContainer;
        Intrinsics.checkNotNullExpressionValue(profileWeightContainer, "profileWeightContainer");
        onClick(profileWeightContainer, new ProfileFragment$onCreateView$2$4(this, null));
        LinearLayout unitsTemperatureContainer = inflate.unitsTemperatureContainer;
        Intrinsics.checkNotNullExpressionValue(unitsTemperatureContainer, "unitsTemperatureContainer");
        onClick(unitsTemperatureContainer, new ProfileFragment$onCreateView$2$5(this, null));
        LinearLayout unitsMeasurementsContainer = inflate.unitsMeasurementsContainer;
        Intrinsics.checkNotNullExpressionValue(unitsMeasurementsContainer, "unitsMeasurementsContainer");
        onClick(unitsMeasurementsContainer, new ProfileFragment$onCreateView$2$6(this, null));
        this.binding = inflate;
        RelativeLayout root = inflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FragmentSettingsProfileBinding fragmentSettingsProfileBinding = this.binding;
        if (fragmentSettingsProfileBinding != null) {
            Button btnCreateAccount = fragmentSettingsProfileBinding.btnCreateAccount;
            Intrinsics.checkNotNullExpressionValue(btnCreateAccount, "btnCreateAccount");
            onClick(btnCreateAccount, new ProfileFragment$onViewCreated$1(this, null));
            FragmentSettingsProfileBinding fragmentSettingsProfileBinding2 = this.binding;
            if (fragmentSettingsProfileBinding2 != null) {
                Button btnLogIn = fragmentSettingsProfileBinding2.btnLogIn;
                Intrinsics.checkNotNullExpressionValue(btnLogIn, "btnLogIn");
                onClick(btnLogIn, new ProfileFragment$onViewCreated$2(this, null));
                FragmentSettingsProfileBinding fragmentSettingsProfileBinding3 = this.binding;
                if (fragmentSettingsProfileBinding3 != null) {
                    LinearLayout layoutAccSettings = fragmentSettingsProfileBinding3.layoutAccSettings;
                    Intrinsics.checkNotNullExpressionValue(layoutAccSettings, "layoutAccSettings");
                    onClick(layoutAccSettings, new ProfileFragment$onViewCreated$3(this, null));
                    FragmentSettingsProfileBinding fragmentSettingsProfileBinding4 = this.binding;
                    if (fragmentSettingsProfileBinding4 != null) {
                        fragmentSettingsProfileBinding4.tvDateOfBirth.setText(getString(R.string.profile_date_of_birth_title) + ':');
                        fragmentSettingsProfileBinding4.tvSex.setText(getString(R.string.profile_sex_title) + ':');
                        fragmentSettingsProfileBinding4.tvHeight.setText(getString(R.string.profile_height_title) + ':');
                        fragmentSettingsProfileBinding4.tvWeight.setText(getString(R.string.profile_weight_title) + ':');
                        fragmentSettingsProfileBinding4.tvMeasurement.setText(getString(R.string.profile_mesaurements_title) + ':');
                        fragmentSettingsProfileBinding4.tvTemperature.setText(getString(R.string.profile_temperature_title) + ':');
                        LoginViewModel loginViewModel = this.loginViewModel;
                        if (loginViewModel != null) {
                            FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new ProfileFragment$onViewCreated$5(this, null), loginViewModel.getLoginState()), Hashing.getLifecycleScope(this));
                            FlowKt.launchIn(new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new ProfileFragment$onViewCreated$6(this, null), getProfileViewModel().observeState()), new ProfileFragment$onViewCreated$7(this, null)), Hashing.getLifecycleScope(this));
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("loginViewModel");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        throw null;
    }
}
