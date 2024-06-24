package com.animaconnected.secondo.screens.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.devmenu.DevMenuFileIssueFragment$$ExternalSyntheticLambda0;
import com.amplifyframework.devmenu.DevMenuLogsFragment$$ExternalSyntheticLambda0;
import com.animaconnected.info.DeviceType;
import com.animaconnected.info.UserCategoryKt;
import com.animaconnected.secondo.app.RemoteConfigController;
import com.animaconnected.secondo.behaviour.counter.CounterFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.login.LoginState;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageType;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.apps.WatchAppFragment$$ExternalSyntheticLambda0;
import com.animaconnected.secondo.screens.debugsettings.DebugSettingsFragment;
import com.animaconnected.secondo.screens.labs.LabsFragment;
import com.animaconnected.secondo.screens.labs.LabsMoreNumbersFragment;
import com.animaconnected.secondo.screens.onboarding.OnboardingStorage;
import com.animaconnected.secondo.screens.settings.SettingsPresenter;
import com.animaconnected.secondo.screens.settings.displaynotifications.AppsNotificationsFragment;
import com.animaconnected.secondo.screens.settings.displaynotifications.CallsFragment;
import com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksPascalFragment;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.animaconnected.secondo.screens.watch.imageprovider.WatchImageModelFactory;
import com.animaconnected.secondo.utils.AmplifyApiKt;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.LayoutState;
import com.animaconnected.secondo.widget.SectionLayout;
import com.animaconnected.watch.HybridWatch;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SettingsFragment.kt */
/* loaded from: classes3.dex */
public final class SettingsFragment extends BaseFragment implements SettingsPresenter.SettingsView, WatchViewLayouter {
    private final Lazy hasDisplay$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$hasDisplay$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(ProviderFactory.getWatch().getWatch().getWatchType() == DeviceType.PASCAL);
        }
    });
    private final String name = "Settings";
    private RemoteConfigController remoteConfigController;
    private SettingsPresenter settingsPresenter;
    private TextView watchesTitle;
    private LinearLayout watchesView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SettingsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance() {
            return new SettingsFragment();
        }

        private Companion() {
        }
    }

    public static final /* synthetic */ SettingsPresenter access$getSettingsPresenter$p(SettingsFragment settingsFragment) {
        return settingsFragment.settingsPresenter;
    }

    private final boolean getHasDisplay() {
        return ((Boolean) this.hasDisplay$delegate.getValue()).booleanValue();
    }

    public static final BaseFragment newInstance() {
        return Companion.newInstance();
    }

    private final void onTipsAndTricksClicked() {
        BaseFragment newInstance;
        MainController mainController = getMainController();
        if (getHasDisplay()) {
            newInstance = TipsAndTricksPascalFragment.Companion.newInstance();
        } else {
            newInstance = TipsAndTricksFragment.Companion.newInstance();
        }
        mainController.gotoNextFragment(newInstance);
    }

    private final void setupAboutSection(View view) {
        view.findViewById(R.id.licence).setOnClickListener(new WatchAppFragment$$ExternalSyntheticLambda0(this, 1));
    }

    public static final void setupAboutSection$lambda$1(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(OpenSourceLicenses.Companion.newInstance());
    }

    private final void setupAccountSection(View view) {
        if (AmplifyApiKt.isSignInUiEnabled()) {
            SectionLayout sectionLayout = (SectionLayout) view.findViewById(R.id.settings_account_layout);
            Intrinsics.checkNotNull(sectionLayout);
            onClick(sectionLayout, new SettingsFragment$setupAccountSection$accountLayout$1$1(this, null));
            View findViewById = view.findViewById(R.id.settings_account);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            ViewKt.visible(findViewById);
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (Intrinsics.areEqual(new SigninStorage(requireContext).getState(), LoginState.SignedIn.INSTANCE)) {
                sectionLayout.setTitleText(getString(R.string.settings_account_my_account_title));
                sectionLayout.setDescriptionText(null);
            }
        }
    }

    private final void setupFilterNotificationSection(View view) {
        int r0;
        SectionLayout sectionLayout = (SectionLayout) view.findViewById(R.id.settings_labs_more_numbers);
        RemoteConfigController remoteConfigController = this.remoteConfigController;
        if (remoteConfigController != null) {
            if (remoteConfigController.isMoreNumbersEvaluationEnabled() && ProviderFactory.getLabsProvider().hasJoinedLabs() && ProviderFactory.getWatch().getCapabilities().getHasSixAlerts()) {
                r0 = 0;
            } else {
                r0 = 8;
            }
            sectionLayout.setVisibility(r0);
            sectionLayout.setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda1(0, this));
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("remoteConfigController");
        throw null;
    }

    public static final void setupFilterNotificationSection$lambda$18$lambda$17(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(LabsMoreNumbersFragment.Companion.newInstance());
    }

    private final void setupHelpSection(View view) {
        int r1 = 0;
        if (getResources().getBoolean(R.bool.app_feature_tips_and_tricks_enable)) {
            View findViewById = view.findViewById(R.id.tips_and_tricks_button);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new CounterFragment$$ExternalSyntheticLambda0(this, 1));
        }
        if (ProviderFactory.getWatch().getWatch() instanceof HybridWatch) {
            View findViewById2 = view.findViewById(R.id.settings_open_faq);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda7(this, r1));
        }
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            if (settingsPresenter.hasHowToVideos() && !getHasDisplay()) {
                View findViewById3 = view.findViewById(R.id.settings_how_to_videos);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                findViewById3.setVisibility(0);
                findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        SettingsFragment.setupHelpSection$lambda$9(SettingsFragment.this, view2);
                    }
                });
            }
            View findViewById4 = view.findViewById(R.id.settings_contact_support);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
            onClick(findViewById4, new SettingsFragment$setupHelpSection$4(this, null));
            RemoteConfigController remoteConfigController = this.remoteConfigController;
            if (remoteConfigController != null) {
                if (remoteConfigController.getDebuggingEnabled() || UserCategoryKt.useDogfoodingLogger(ProviderFactory.getWatch().getUserCategory())) {
                    View findViewById5 = view.findViewById(R.id.settings_debugging);
                    Intrinsics.checkNotNull(findViewById5);
                    ViewKt.visible(findViewById5);
                    onClick(findViewById5, new SettingsFragment$setupHelpSection$5$1(this, null));
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("remoteConfigController");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        throw null;
    }

    public static final void setupHelpSection$lambda$7(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onTipsAndTricksClicked();
    }

    public static final void setupHelpSection$lambda$8(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onFAQButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    public static final void setupHelpSection$lambda$9(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onHowToVideosButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    private final void setupLabsSection(View view) {
        int r1 = 0;
        view.findViewById(R.id.settings_labs_layout).setVisibility(0);
        View findViewById = view.findViewById(R.id.settings_labs_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        SectionLayout sectionLayout = (SectionLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.settings_labs_contact_button);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        SectionLayout sectionLayout2 = (SectionLayout) findViewById2;
        if (ProviderFactory.getLabsProvider().hasJoinedLabs()) {
            sectionLayout.setTitleText(requireContext().getString(R.string.settings_labs_about_button));
            if (getResources().getBoolean(R.bool.app_feature_aws_feedback_system)) {
                sectionLayout2.setTitleText(getString(R.string.labs_feedback));
            }
            sectionLayout2.setVisibility(0);
            sectionLayout2.setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda9(this, r1));
        } else {
            sectionLayout.setTitleText(requireContext().getString(R.string.settings_labs_join_button));
            sectionLayout2.setVisibility(8);
        }
        sectionLayout.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.setupLabsSection$lambda$16(SettingsFragment.this, view2);
            }
        });
    }

    public static final void setupLabsSection$lambda$15(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onContactLabs();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    public static final void setupLabsSection$lambda$16(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(LabsFragment.Companion.newInstance());
    }

    private final void setupLegalSection(View view) {
        view.findViewById(R.id.settings_terms_of_use_button).setOnClickListener(new DevMenuFileIssueFragment$$ExternalSyntheticLambda0(this, 2));
        view.findViewById(R.id.settings_privacy_policy_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.setupLegalSection$lambda$20(SettingsFragment.this, view2);
            }
        });
    }

    public static final void setupLegalSection$lambda$19(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onTermsOfUseButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    public static final void setupLegalSection$lambda$20(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onPrivacyPolicyButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    private final void setupNotificationSection(View view) {
        Integer num;
        Integer num2;
        boolean z = false;
        view.findViewById(R.id.settings_notifications_layout).setVisibility(0);
        SectionLayout sectionLayout = (SectionLayout) view.findViewById(R.id.settings_notifications_calls);
        Intrinsics.checkNotNull(sectionLayout);
        onClick(sectionLayout, new SettingsFragment$setupNotificationSection$1$1(this, null));
        if (CallsFragment.Companion.isBadgeVisible() || TextsFragment.Companion.isBadgeVisible()) {
            z = true;
        }
        if (z) {
            num = Integer.valueOf(R.drawable.breadcrumb_shadow_headsup);
        } else {
            num = null;
        }
        sectionLayout.setTitleIcon(num);
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            sectionLayout.setDescriptionText(settingsPresenter.getDescriptionTextForTextsAndCalls());
            SectionLayout sectionLayout2 = (SectionLayout) view.findViewById(R.id.display_app_details_title);
            Intrinsics.checkNotNull(sectionLayout2);
            onClick(sectionLayout2, new SettingsFragment$setupNotificationSection$2$1(this, null));
            if (AppsNotificationsFragment.Companion.isBadgeVisible()) {
                num2 = Integer.valueOf(R.drawable.breadcrumb_shadow_headsup);
            } else {
                num2 = null;
            }
            sectionLayout2.setTitleIcon(num2);
            SettingsPresenter settingsPresenter2 = this.settingsPresenter;
            if (settingsPresenter2 != null) {
                sectionLayout2.setDescriptionText(settingsPresenter2.getDescriptionTextForApps());
                View view2 = (SectionLayout) view.findViewById(R.id.settings_notifications_quiet_hours);
                SettingsPresenter settingsPresenter3 = this.settingsPresenter;
                if (settingsPresenter3 != null) {
                    view2.setSelected(settingsPresenter3.isQuiteHoursEnabled());
                    onClick(view2, new SettingsFragment$setupNotificationSection$3$1(this, null));
                    BuildersKt.launch$default(Hashing.getLifecycleScope(this), Dispatchers.IO, null, new SettingsFragment$setupNotificationSection$4(ProviderFactory.getImportantAppsProvider(), null), 2);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        throw null;
    }

    private final void setupOpenDebugMenuSection(View view) {
        view.findViewById(R.id.settings_debug_layout).setVisibility(0);
        view.findViewById(R.id.debug_settings_button).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.setupOpenDebugMenuSection$lambda$21(SettingsFragment.this, view2);
            }
        });
    }

    public static final void setupOpenDebugMenuSection$lambda$21(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMainController().gotoNextFragment(DebugSettingsFragment.Companion.newInstance());
    }

    private final void setupRateUsSection(View view) {
        view.findViewById(R.id.settings_rate_us_layout).setVisibility(0);
        View findViewById = view.findViewById(R.id.settings_rate_us_button);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        findViewById.setOnClickListener(new DevMenuLogsFragment$$ExternalSyntheticLambda0(this, 1));
    }

    public static final void setupRateUsSection$lambda$14(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onRateUsButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    private final void setupSocialMediaSection(View view) {
        boolean z;
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            boolean z2 = true;
            if (settingsPresenter.hasFacebookLink()) {
                View findViewById = view.findViewById(R.id.settings_facebook);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                findViewById.setVisibility(0);
                findViewById.setOnClickListener(new SettingsFragment$$ExternalSyntheticLambda2(0, this));
                z = true;
            } else {
                z = false;
            }
            SettingsPresenter settingsPresenter2 = this.settingsPresenter;
            if (settingsPresenter2 != null) {
                if (settingsPresenter2.hasInstagramLink()) {
                    View findViewById2 = view.findViewById(R.id.settings_instagram);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                    findViewById2.setVisibility(0);
                    findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            SettingsFragment.setupSocialMediaSection$lambda$6(SettingsFragment.this, view2);
                        }
                    });
                } else {
                    z2 = z;
                }
                if (z2) {
                    view.findViewById(R.id.settings_social_media_layout).setVisibility(0);
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        throw null;
    }

    public static final void setupSocialMediaSection$lambda$5(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onFacebookButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    public static final void setupSocialMediaSection$lambda$6(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SettingsPresenter settingsPresenter = this$0.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onInstagramButtonClicked();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    private final void setupViewElements(View view) {
        setupAccountSection(view);
        setupWatchesSection(view);
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            if (settingsPresenter.hasDisplay()) {
                setupNotificationSection(view);
            }
            setupAboutSection(view);
            if (getResources().getBoolean(R.bool.app_feature_labs_enable) && !getHasDisplay()) {
                setupLabsSection(view);
                setupFilterNotificationSection(view);
            }
            setupSocialMediaSection(view);
            SettingsPresenter settingsPresenter2 = this.settingsPresenter;
            if (settingsPresenter2 != null) {
                if (settingsPresenter2.hasRateUs()) {
                    setupRateUsSection(view);
                }
                setupHelpSection(view);
                setupAboutSection(view);
                setupLegalSection(view);
                RemoteConfigController remoteConfigController = this.remoteConfigController;
                if (remoteConfigController != null) {
                    if (!remoteConfigController.getAppDebugMenuEnable()) {
                        SettingsPresenter settingsPresenter3 = this.settingsPresenter;
                        if (settingsPresenter3 != null) {
                            if (!settingsPresenter3.userCategoryDebugMenuEnabled()) {
                                return;
                            }
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
                            throw null;
                        }
                    }
                    setupOpenDebugMenuSection(view);
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("remoteConfigController");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
        throw null;
    }

    @SuppressLint({"SetTextI18n"})
    private final void setupWatchesSection(View view) {
        View findViewById = view.findViewById(R.id.settings_watches);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.watchesView = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.settings_watches_title);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.watchesTitle = (TextView) findViewById2;
        Button button = (Button) view.findViewById(R.id.add_watch);
        button.setText("+ " + getString(R.string.watch_button_add_new));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsFragment.setupWatchesSection$lambda$4(SettingsFragment.this, view2);
            }
        });
    }

    public static final void setupWatchesSection$lambda$4(SettingsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ProviderFactory.getAppAnalytics().sendAction("add_watch");
        ProviderFactory.getWatch().deactivateCurrentDevice();
        ProductInfoProvider.clearCurrentSku();
        ProviderFactory.getWatchDfuProvider().clear();
        ProviderFactory.getWatchFotaProvider().clear();
        ProviderFactory.getWatchUpdateProvider().clear();
        ProviderFactory.getWatchAppUpdateProvider().clear();
        OnboardingStorage onboardingStorage = OnboardingStorage.INSTANCE;
        Context requireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        onboardingStorage.setHasShowedWhatIsNewAnimation(requireContext, false);
        this$0.getMainController().gotoOnboarding();
    }

    public static final void updateWatches$lambda$29$lambda$22(SettingsFragment this$0, SettingsPresenter.WatchModel watch, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(watch, "$watch");
        this$0.getMainController().gotoNextFragment(WatchSettingsFragment.Companion.newInstance(watch.getAddress()));
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
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
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return 1;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RemoteConfigController.Companion companion = RemoteConfigController.Companion;
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.remoteConfigController = companion.getInstance(applicationContext);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        this.settingsPresenter = new SettingsPresenter(requireContext, this, getMainController());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_settings, viewGroup, false);
        Intrinsics.checkNotNull(inflate);
        setupViewElements(inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onPause();
            super.onPause();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SettingsPresenter settingsPresenter = this.settingsPresenter;
        if (settingsPresenter != null) {
            settingsPresenter.onResume();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("settingsPresenter");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.settings.SettingsPresenter.SettingsView
    public void updateWatches(List<SettingsPresenter.WatchModel> watches) {
        int r2;
        Intrinsics.checkNotNullParameter(watches, "watches");
        TextView textView = this.watchesTitle;
        if (textView != null) {
            if (watches.size() >= 2) {
                r2 = R.string.watch_title_plural;
            } else {
                r2 = R.string.watch_title_singular;
            }
            textView.setText(getString(r2));
            LinearLayout linearLayout = this.watchesView;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
                int r3 = 0;
                for (Object obj : watches) {
                    int r5 = r3 + 1;
                    if (r3 >= 0) {
                        final SettingsPresenter.WatchModel watchModel = (SettingsPresenter.WatchModel) obj;
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        SectionLayout sectionLayout = new SectionLayout(requireContext, null, 2132083526);
                        sectionLayout.setTitleText(watchModel.getName());
                        sectionLayout.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.settings.SettingsFragment$$ExternalSyntheticLambda6
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                SettingsFragment.updateWatches$lambda$29$lambda$22(SettingsFragment.this, watchModel, view);
                            }
                        });
                        if (r3 != 0) {
                            sectionLayout.showTopLine(false);
                        }
                        ProductInfoProvider productInfoProvider = ProductInfoProvider.INSTANCE;
                        WatchImageType watchImageType = WatchImageType.THUMBNAIL;
                        Bitmap image = productInfoProvider.getImage(watchImageType, watchModel.getSku());
                        if (image != null) {
                            sectionLayout.setIconBitmap(image);
                        } else {
                            Bitmap bitmap = WatchImageModelFactory.getDefaultSketch(getContext(), watchModel.getType(), watchModel.getVariant()).get(watchImageType);
                            if (bitmap != null) {
                                sectionLayout.setIconBitmap(bitmap);
                            }
                        }
                        if (!watchModel.getCurrent()) {
                            sectionLayout.setDescriptionText(getString(R.string.watch_status_inactive));
                            sectionLayout.setLayoutState(LayoutState.DisabledButtonEnabled);
                        } else if (watchModel.getInDfuMode()) {
                            sectionLayout.setLayoutState(LayoutState.WarningEnabled);
                            sectionLayout.setDescriptionText(getString(R.string.dashboard_dfu_required_title));
                            sectionLayout.setTitleIcon(Integer.valueOf(R.drawable.breadcrumb_shadow_headsup));
                        } else if (watchModel.isUpdateAvailable()) {
                            sectionLayout.setLayoutState(LayoutState.Enabled);
                            sectionLayout.setDescriptionText(getString(R.string.watch_status_connected));
                            sectionLayout.setTitleIcon(Integer.valueOf(R.drawable.breadcrumb_shadow_headsup));
                        } else if (watchModel.getConnected()) {
                            sectionLayout.setLayoutState(LayoutState.Enabled);
                            sectionLayout.setDescriptionText(getString(R.string.watch_status_connected));
                        } else {
                            sectionLayout.setLayoutState(LayoutState.DisabledButtonEnabled);
                            sectionLayout.setDescriptionText(getString(R.string.watch_status_disconnected));
                        }
                        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.padding_double);
                        sectionLayout.setTopAndBottomPadding(dimensionPixelOffset, dimensionPixelOffset);
                        LinearLayout linearLayout2 = this.watchesView;
                        if (linearLayout2 != null) {
                            linearLayout2.addView(sectionLayout);
                            r3 = r5;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("watchesView");
                            throw null;
                        }
                    } else {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                        throw null;
                    }
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("watchesView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchesTitle");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r1, int r2, int r3, int r4, int r5) {
        return new int[0];
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r1) {
    }
}
