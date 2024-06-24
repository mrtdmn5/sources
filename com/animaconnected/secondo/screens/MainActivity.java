package com.animaconnected.secondo.screens;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.Promise;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.info.DateTimeUtilsKt;
import com.animaconnected.info.DeviceType;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.animation.WatchHandsAnimation;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.DashboardConfigurationHelper;
import com.animaconnected.secondo.provider.FastModeProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.ThemeProvider;
import com.animaconnected.secondo.provider.analytics.AnalyticsTrackingProvider;
import com.animaconnected.secondo.provider.campaign.CampaignProvider;
import com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider;
import com.animaconnected.secondo.provider.productinfo.ProductInfoProvider;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.provider.status.StatusProvider;
import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import com.animaconnected.secondo.screens.behaviourconfiguration.FeatureIssue;
import com.animaconnected.secondo.screens.campaigns.CampaignFragment;
import com.animaconnected.secondo.screens.campaigns.DashboardMarbleView;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import com.animaconnected.secondo.screens.demo.DisableDemoModeBottomDialogKt;
import com.animaconnected.secondo.screens.demo.EnableDemoModeBottomDialogKt;
import com.animaconnected.secondo.screens.details.Dismissible;
import com.animaconnected.secondo.screens.details.DummyDetailsFragment;
import com.animaconnected.secondo.screens.helpcenter.HelpCenterGuideDialog;
import com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener;
import com.animaconnected.secondo.screens.onboarding.OnboardingActivity;
import com.animaconnected.secondo.screens.onboarding.OnboardingStorage;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.secondo.screens.status.DummyStatusFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.secondo.screens.watch.item.WatchItem;
import com.animaconnected.secondo.screens.watch.item.WatchItemChangeListener;
import com.animaconnected.secondo.screens.watchupdate.BaseWatchUpdateFragment;
import com.animaconnected.secondo.screens.watchupdate.GradientViewController;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateCompletedFragment;
import com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardFragment;
import com.animaconnected.secondo.screens.workout.utils.BaseFragmentUtilsKt;
import com.animaconnected.secondo.utils.ClickThrottle;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.DebugLogUtils;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.secondo.utils.ScreenLocationHelper;
import com.animaconnected.secondo.widget.WatchLayout;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.behaviour.Behaviour;
import com.animaconnected.watch.behaviour.Behaviours;
import com.animaconnected.watch.behaviour.WatchFaceBehavior;
import com.animaconnected.watch.behaviour.WatchFaceVisible;
import com.animaconnected.watch.behaviour.types.FindPhone;
import com.animaconnected.watch.provider.demo.DemoMode;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: MainActivity.kt */
/* loaded from: classes3.dex */
public final class MainActivity extends BaseActivity implements MainController, CalibrationProgress, StatusChangeListener, FragmentManager.OnBackStackChangedListener, WatchItemChangeListener, ViewLayouter, HelpCenterStateChangedListener {
    private static final int GRADIENT_ANIMATION_DURATION = 1000;
    private boolean animatedGradient;
    private final Behaviours behaviours;
    private ClickThrottle clickThrottle;
    private String[] currentPermissions;
    private StatusModel currentStatus;
    private WatchItem currentWatchItem;
    private DashboardMarbleView dashboardMarbleView;
    private GradientViewController gradientViewController;
    private final Handler handler;
    private final HelpCenterProvider helpCenterProvider;
    private ImageView imageViewGradientBottom;
    private ImageView imageViewGradientTop;
    private ImageView imageViewWatchShadow;
    private boolean isAnimatingWhatIsNew;
    private boolean isListeningForDemoModeChanges;
    private boolean isRefreshing;
    private final ActivityResultLauncher<String[]> permissionLauncher;
    private boolean reportTouchEventToDemoProvider;
    private final StatusProvider statusProvider;
    private SubComplicationHandModel subComplicationHandModel1;
    private SubComplicationHandModel subComplicationHandModel2;
    private int viewYOffset;
    private View watchLayer;
    private WatchLayout watchLayout;
    private ViewGroup watchLayoutParent;
    private WatchProvider watchProvider;
    private final BaseWatchProviderListener watchProviderListener;
    private float watchShadowAlphaValue;
    public WatchViewController watchViewController;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MainActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void onFragmentReplaced(BaseFragment baseFragment) {
            if (baseFragment != null) {
                ProviderFactory.getAppAnalytics().sendPageCreated(baseFragment.getName());
            }
        }

        private Companion() {
        }
    }

    /* compiled from: MainActivity.kt */
    /* loaded from: classes3.dex */
    public static final class SubComplicationHandModel implements WatchHandsAnimation.WatchHandModel {
        private WatchFaceVisible subComplicationBehaviour;

        @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
        public float getHoursInDegrees() {
            WatchFaceVisible watchFaceVisible = this.subComplicationBehaviour;
            if (watchFaceVisible != null) {
                return watchFaceVisible.getHoursInDegrees();
            }
            return 0.0f;
        }

        @Override // com.animaconnected.secondo.app.animation.WatchHandsAnimation.WatchHandModel
        public float getMinutesInDegrees() {
            WatchFaceVisible watchFaceVisible = this.subComplicationBehaviour;
            if (watchFaceVisible != null) {
                return watchFaceVisible.getMinutesInDegrees();
            }
            return 0.0f;
        }

        public final void setCurrentSubComplicationBehaviour(Behaviour behaviour) {
            WatchFaceVisible watchFaceVisible;
            if (behaviour != null) {
                if (behaviour instanceof WatchFaceBehavior) {
                    watchFaceVisible = (WatchFaceVisible) behaviour;
                } else {
                    watchFaceVisible = null;
                }
                this.subComplicationBehaviour = watchFaceVisible;
            }
        }
    }

    /* compiled from: MainActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FeatureIssue.values().length];
            try {
                r0[FeatureIssue.LocationPermission.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FeatureIssue.BackgroundLocationPermission.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[FeatureIssue.GeneralPermissions.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[FeatureIssue.GeneralPermission.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[FeatureIssue.LocationDisabled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[FeatureIssue.NotificationAccess.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public MainActivity() {
        WatchProvider watch = ProviderFactory.getWatch();
        this.watchProvider = watch;
        this.behaviours = watch.getWatchManager().getBehaviours();
        this.helpCenterProvider = ProviderFactory.getHelpCenterProvider();
        this.statusProvider = ProviderFactory.getStatusProvider();
        ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback(this) { // from class: com.animaconnected.secondo.screens.MainActivity$special$$inlined$registerMultiplePermissions$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                String[] strArr;
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                boolean z = true;
                if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
                    Iterator<T> it = entrySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    strArr = MainActivity.this.currentPermissions;
                    if (strArr == null) {
                        return;
                    }
                    FeatureIssue.Companion companion = FeatureIssue.Companion;
                    Context applicationContext = MainActivity.this.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    FeatureIssue calculateIssue = companion.calculateIssue(strArr, applicationContext);
                    if (calculateIssue != FeatureIssue.None) {
                        MainActivity.this.showFeatureDialog(calculateIssue, strArr);
                        return;
                    } else {
                        MainActivity.this.currentPermissions = null;
                        return;
                    }
                }
                MainActivity.this.currentPermissions = null;
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        this.permissionLauncher = registerForActivityResult;
        this.clickThrottle = new ClickThrottle(Hashing.getLifecycleScope(this));
        this.watchProviderListener = new BaseWatchProviderListener() { // from class: com.animaconnected.secondo.screens.MainActivity$watchProviderListener$1
            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onBehaviourSet(Slot slot, Behaviour behaviour) {
                Intrinsics.checkNotNullParameter(slot, "slot");
                BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new MainActivity$watchProviderListener$1$onBehaviourSet$1(MainActivity.this, slot, null));
            }

            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onConnectionChanged(boolean z) {
                BaseFragment currentFragment;
                currentFragment = MainActivity.this.getCurrentFragment();
                if (!currentFragment.accessEvenIfDisconnected() && !z && ProviderFactory.createBluetoothOnboardingProvider().isOnboardingFinished()) {
                    MainActivity.this.popUntilFragment(DashboardFragment.name);
                }
                MainActivity.this.shouldGoToWatchUpdateCompleted(z);
            }
        };
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final Future<Void> animate(View view, int r4) {
        final Promise promise = new Promise();
        Animation loadAnimation = AnimationUtils.loadAnimation(getApplicationContext(), r4);
        if (view != null) {
            view.startAnimation(loadAnimation);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.animaconnected.secondo.screens.MainActivity$animate$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                promise.resolve(null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        Future<Void> future = promise.getFuture();
        Intrinsics.checkNotNullExpressionValue(future, "getFuture(...)");
        return future;
    }

    private final void animateBackGradient() {
        GradientViewController gradientViewController = this.gradientViewController;
        if (gradientViewController != null) {
            gradientViewController.animateGradient(0, 0, GRADIENT_ANIMATION_DURATION);
            this.animatedGradient = false;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("gradientViewController");
            throw null;
        }
    }

    private final void animateWhatIsNew(DashboardFragment dashboardFragment) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_white_for_what_is_new);
        imageView.setVisibility(0);
        this.isAnimatingWhatIsNew = true;
        this.statusProvider.muteStatus(true);
        this.handler.postDelayed(new MainActivity$$ExternalSyntheticLambda1(0, dashboardFragment, this, imageView), 750L);
    }

    public static final void animateWhatIsNew$lambda$15(DashboardFragment dashboardFragment, MainActivity this$0, ImageView imageView) {
        Intrinsics.checkNotNullParameter(dashboardFragment, "$dashboardFragment");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dashboardFragment.animateDashboardRevealAnimation();
        this$0.animate(imageView, R.anim.dashboard_fade_in);
        ImageView imageView2 = this$0.imageViewWatchShadow;
        if (imageView2 != null) {
            this$0.animate(imageView2, R.anim.watch_shadow_fade_in);
            WatchLayout watchLayout = this$0.watchLayout;
            if (watchLayout != null) {
                this$0.animate(watchLayout, R.anim.watch_move_slow).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda5
                    @Override // com.animaconnected.future.FlatMapCallback
                    public final Future onResult(Object obj) {
                        Future animateWhatIsNew$lambda$15$lambda$13;
                        animateWhatIsNew$lambda$15$lambda$13 = MainActivity.animateWhatIsNew$lambda$15$lambda$13(MainActivity.this, (Void) obj);
                        return animateWhatIsNew$lambda$15$lambda$13;
                    }
                }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda6
                    @Override // com.animaconnected.future.SuccessCallback
                    public final void onSuccess(Object obj) {
                        MainActivity.animateWhatIsNew$lambda$15$lambda$14(MainActivity.this, (Void) obj);
                    }
                });
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("watchLayout");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewWatchShadow");
        throw null;
    }

    public static final Future animateWhatIsNew$lambda$15$lambda$13(MainActivity this$0, Void r2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WatchLayout watchLayout = this$0.watchLayout;
        if (watchLayout != null) {
            return this$0.animate(watchLayout, R.anim.watch_scale_and_move);
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchLayout");
        throw null;
    }

    public static final void animateWhatIsNew$lambda$15$lambda$14(MainActivity this$0, Void r2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isAnimatingWhatIsNew = false;
        this$0.statusProvider.muteStatus(false);
        this$0.onStatusChanged();
        if (CampaignProvider.INSTANCE.isInterested()) {
            DashboardMarbleView dashboardMarbleView = this$0.dashboardMarbleView;
            if (dashboardMarbleView != null) {
                dashboardMarbleView.show();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
                throw null;
            }
        }
    }

    private final void applyTheme(ThemeProvider themeProvider) {
        int backgroundColor = themeProvider.getBackgroundColor();
        if (backgroundColor != 0) {
            getWindow().getDecorView().setBackgroundColor(backgroundColor);
        } else {
            getWindow().getDecorView().setBackgroundResource(themeProvider.getBackgroundResource());
        }
        int gradientBackgroundColor = themeProvider.getGradientBackgroundColor();
        ImageView imageView = this.imageViewGradientTop;
        if (imageView != null) {
            imageView.setColorFilter(gradientBackgroundColor, PorterDuff.Mode.SRC_ATOP);
            ImageView imageView2 = this.imageViewGradientBottom;
            if (imageView2 != null) {
                imageView2.setColorFilter(gradientBackgroundColor, PorterDuff.Mode.SRC_ATOP);
                float backgroundGradientOpacity = themeProvider.getBackgroundGradientOpacity();
                ImageView imageView3 = this.imageViewGradientTop;
                if (imageView3 != null) {
                    imageView3.setAlpha(backgroundGradientOpacity);
                    ImageView imageView4 = this.imageViewGradientBottom;
                    if (imageView4 != null) {
                        imageView4.setAlpha(backgroundGradientOpacity);
                        float watchShadowOpacity = themeProvider.getWatchShadowOpacity();
                        this.watchShadowAlphaValue = watchShadowOpacity;
                        ImageView imageView5 = this.imageViewWatchShadow;
                        if (imageView5 != null) {
                            imageView5.setAlpha(watchShadowOpacity);
                            return;
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("imageViewWatchShadow");
                            throw null;
                        }
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientBottom");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientTop");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientBottom");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientTop");
        throw null;
    }

    private final void checkIfWhatIsNewAnimationShouldStart(BaseFragment baseFragment) {
        OnboardingStorage onboardingStorage = OnboardingStorage.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        if (!onboardingStorage.getHasShowedWhatIsNewAnimation(applicationContext) && (baseFragment instanceof DashboardFragment)) {
            Context applicationContext2 = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext(...)");
            onboardingStorage.setHasShowedWhatIsNewAnimation(applicationContext2, true);
            animateWhatIsNew((DashboardFragment) baseFragment);
        }
    }

    private final void clearStatusBoard() {
        final Fragment statusFragment = getStatusFragment();
        if (statusFragment != null) {
            LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.MainActivity$clearStatusBoard$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Removing status fragment: ".concat(Fragment.this.getClass().getSimpleName());
                }
            }, 7, (Object) null);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
            m.setCustomAnimations(R.anim.none, R.anim.status_card_out, 0, 0);
            m.replace(R.id.status_container, new DummyStatusFragment(), null);
            m.commit();
            return;
        }
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.MainActivity$clearStatusBoard$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "clearStatusBoard: no last status to clear!";
            }
        }, 7, (Object) null);
    }

    private final View.OnClickListener clickCounterFilter(final int r4, final View.OnClickListener onClickListener) {
        final long[] jArr = new long[r4];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        return new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.clickCounterFilter$lambda$11(jArr, ref$IntRef, r4, onClickListener, view);
            }
        };
    }

    public static final void clickCounterFilter$lambda$11(long[] clickTimestamps, Ref$IntRef idx, int r6, View.OnClickListener filteredListener, View view) {
        Intrinsics.checkNotNullParameter(clickTimestamps, "$clickTimestamps");
        Intrinsics.checkNotNullParameter(idx, "$idx");
        Intrinsics.checkNotNullParameter(filteredListener, "$filteredListener");
        clickTimestamps[idx.element] = DateTimeUtilsKt.currentTimeMillis();
        idx.element = (idx.element + 1) % r6;
        if (DateTimeUtilsKt.currentTimeMillis() - clickTimestamps[idx.element] < (r6 - 1) * TipsAndTricksConstants.REJECT_CALL_PRIORITY) {
            Arrays.fill(clickTimestamps, 0, clickTimestamps.length, 0L);
            filteredListener.onClick(view);
        }
    }

    public final BaseFragment getCurrentFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.content);
        Intrinsics.checkNotNull(findFragmentById, "null cannot be cast to non-null type com.animaconnected.secondo.screens.BaseFragment");
        return (BaseFragment) findFragmentById;
    }

    public final BaseFragment getCurrentRevealedFragment() {
        BaseFragment baseFragment = (BaseFragment) getSupportFragmentManager().findFragmentById(R.id.revealed_fragment_container);
        if (baseFragment instanceof DummyDetailsFragment) {
            return null;
        }
        return baseFragment;
    }

    private final int getLayoutForFeatureIssue(FeatureIssue featureIssue) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[featureIssue.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 != 4) {
                        return -1;
                    }
                    return R.layout.dialog_needs_general_singular_permission;
                }
                return R.layout.dialog_needs_general_plural_permission;
            }
            return R.layout.dialog_needs_background_location_permission;
        }
        return R.layout.dialog_needs_location_permission;
    }

    private final Fragment getStatusFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.status_container);
    }

    private final void handleIntent(final Intent intent) {
        String str;
        String queryParameter;
        Uri data;
        String queryParameter2;
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.MainActivity$handleIntent$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                String intentToString = DebugLogUtils.intentToString(intent);
                Intrinsics.checkNotNullExpressionValue(intentToString, "intentToString(...)");
                return intentToString;
            }
        }, 7, (Object) null);
        if (!this.watchProvider.isOnboardingFinished()) {
            finish();
        }
        if (intent.hasExtra(NotificationUtils.EXTRA_KEY_POWER_OPTIMIZATION)) {
            PowerOptimizationStatusController powerOptimizationController = ProviderFactory.getStatusProvider().getPowerOptimizationController();
            if (powerOptimizationController != null && !powerOptimizationController.isIgnoringBatteryOptimizations()) {
                powerOptimizationController.requestIgnorePowerOptimizations();
            }
            intent.removeExtra(NotificationUtils.EXTRA_KEY_POWER_OPTIMIZATION);
        }
        Uri data2 = intent.getData();
        if (data2 != null) {
            str = data2.getScheme();
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "festina-strava-auth")) {
            Uri data3 = intent.getData();
            if (data3 != null && (queryParameter = data3.getQueryParameter(AnalyticsConstants.KEY_CODE)) != null && (data = intent.getData()) != null && (queryParameter2 = data.getQueryParameter("scope")) != null) {
                BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new MainActivity$handleIntent$2(this.watchProvider.getWatchManager().getStravaClient(), queryParameter, queryParameter2, null), 3);
            } else {
                return;
            }
        }
        if (intent.hasExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE)) {
            FeatureIssue featureIssue = (FeatureIssue) intent.getSerializableExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE);
            String[] stringArrayExtra = intent.getStringArrayExtra(NotificationUtils.EXTRA_KEY_PERMISSIONS);
            if (featureIssue != null && stringArrayExtra != null) {
                this.currentPermissions = stringArrayExtra;
                showFeatureDialog(featureIssue, stringArrayExtra);
                intent.removeExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE);
                intent.removeExtra(NotificationUtils.EXTRA_KEY_PERMISSIONS);
            }
        }
        setIntent(intent);
    }

    private final void listenForDemoModeChanges() {
        if (this.isListeningForDemoModeChanges) {
            return;
        }
        this.isListeningForDemoModeChanges = true;
        BaseFragmentUtilsKt.launchOnStarted(this, new MainActivity$listenForDemoModeChanges$1(this.watchProvider.getWatchManager().getDemoModeProvider(), this, null));
    }

    public static final void onBackPressed$lambda$6(MainActivity this$0, BaseFragment baseFragment) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager supportFragmentManager = this$0.getSupportFragmentManager();
        supportFragmentManager.getClass();
        BackStackRecord backStackRecord = new BackStackRecord(supportFragmentManager);
        backStackRecord.remove(baseFragment);
        backStackRecord.commitAllowingStateLoss();
        FragmentManager supportFragmentManager2 = this$0.getSupportFragmentManager();
        supportFragmentManager2.getClass();
        supportFragmentManager2.enqueueAction(new FragmentManager.PopBackStackState(null, -1, 0), false);
    }

    public static final void onCreate$lambda$3(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DashboardMarbleView dashboardMarbleView = this$0.dashboardMarbleView;
        if (dashboardMarbleView != null) {
            Point viewCenterOnScreen = ScreenLocationHelper.getViewCenterOnScreen(dashboardMarbleView);
            Size screenSize = ScreenLocationHelper.getScreenSize(this$0.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(screenSize, "getScreenSize(...)");
            this$0.gotoRevealedFragment(CampaignFragment.Companion.newInstance(viewCenterOnScreen.x, viewCenterOnScreen.y, screenSize.getWidth(), screenSize.getHeight()));
            ProviderFactory.getAppAnalytics().giftTapped();
            return;
        }
        Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
        throw null;
    }

    private final void retryFailedStravaUploads() {
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), Dispatchers.IO, null, new MainActivity$retryFailedStravaUploads$1(this.watchProvider.getWatchManager().getStravaClient(), null), 2);
    }

    private final void setCurrentStatus(StatusModel statusModel, boolean z) {
        final BaseStatusFragment createFragment = statusModel.createFragment();
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.MainActivity$setCurrentStatus$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Setting new status fragment: ".concat(BaseStatusFragment.this.getClass().getSimpleName());
            }
        }, 7, (Object) null);
        if (!z) {
            if (getStatusFragment() == null) {
                FragmentManager supportFragmentManager = getSupportFragmentManager();
                BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
                m.setCustomAnimations(R.anim.status_card_in, R.anim.none, 0, 0);
                m.doAddOp(R.id.status_container, createFragment, statusModel.getClass().getSimpleName(), 1);
                m.commit();
                return;
            }
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            BackStackRecord m2 = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager2, supportFragmentManager2);
            m2.setCustomAnimations(R.anim.status_card_in, R.anim.status_card_out, 0, 0);
            m2.replace(R.id.status_container, createFragment, statusModel.getClass().getSimpleName());
            m2.commit();
            return;
        }
        FragmentManager supportFragmentManager3 = getSupportFragmentManager();
        BackStackRecord m3 = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager3, supportFragmentManager3);
        m3.doAddOp(R.id.status_container, createFragment, statusModel.getClass().getSimpleName(), 1);
        m3.commit();
    }

    public final View setDemoModeButtonEnabled(boolean z) {
        int r1;
        View findViewById = findViewById(R.id.global_demo_mode_button);
        if (z) {
            r1 = 0;
        } else {
            r1 = 8;
        }
        findViewById.setVisibility(r1);
        if (!z) {
            findViewById.setOnClickListener(null);
        } else {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MainActivity.setDemoModeButtonEnabled$lambda$10$lambda$9(MainActivity.this, view);
                }
            });
        }
        return findViewById;
    }

    public static final void setDemoModeButtonEnabled$lambda$10$lambda$9(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.popUntilFragment(DashboardFragment.name);
    }

    private final void setupDemoModeHandling() {
        DeviceType deviceType = this.watchProvider.getDeviceType();
        boolean z = false;
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        }
        if (!z) {
            return;
        }
        if (!(this.watchProvider.getWatchManager().getDemoModeProvider().getCurrentDemoMode() instanceof DemoMode.Disabled)) {
            listenForDemoModeChanges();
        }
        findViewById(R.id.watch_parent_container).setOnClickListener(clickCounterFilter(7, new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.setupDemoModeHandling$lambda$8$lambda$7(MainActivity.this, view);
            }
        }));
    }

    public static final void setupDemoModeHandling$lambda$8$lambda$7(MainActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenForDemoModeChanges();
        if (!this$0.watchProvider.getWatchManager().getDemoModeProvider().isCurrentlyEnabled()) {
            EnableDemoModeBottomDialogKt.showEnableDemoModeBottomDialog(this$0);
        } else {
            DisableDemoModeBottomDialogKt.showDisableDemoModeBottomDialog(this$0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setupWatchLayout(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity.setupWatchLayout(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void setupWatchLayout$lambda$12(MainActivity this$0) {
        boolean z;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new MainActivity$setupWatchLayout$2$1(this$0, null));
        this$0.shouldGoToWatchUpdateCompleted(this$0.watchProvider.isConnected());
        if (this$0.watchProvider.getWatch().getCommandCenter().hasDisplay() && this$0.getIntent().hasExtra(NotificationUtils.EXTRA_KEY_WORKOUT_COMPLETE)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this$0.gotoNextFragment(HealthDashboardFragment.Companion.newInstance());
        }
    }

    public final void shouldGoToWatchUpdateCompleted(boolean z) {
        if (z && ProviderFactory.getWatchUpdateProvider().hasUpdateCompletedInfo() && !Intrinsics.areEqual(getCurrentFragment().getName(), WatchUpdateCompletedFragment.NAME) && !Intrinsics.areEqual(getCurrentFragment().getName(), BaseWatchUpdateFragment.NAME)) {
            gotoNextFragment(WatchUpdateCompletedFragment.Companion.newInstance());
        }
    }

    public final void showFeatureDialog(FeatureIssue featureIssue, final String[] strArr) {
        boolean z;
        final PermissionCompat.PermissionWrapperActivity create = PermissionCompat.create(this);
        switch (WhenMappings.$EnumSwitchMapping$0[featureIssue.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                if (strArr.length == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((!z) && create.arePermissionsNotApproved(strArr)) {
                    BottomSheetKt.showBottomDialog(this, getLayoutForFeatureIssue(featureIssue), new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.MainActivity$showFeatureDialog$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            if (z2) {
                                PermissionCompat.PermissionHelper permissionHelper = PermissionCompat.PermissionHelper.this;
                                String[] strArr2 = strArr;
                                final MainActivity mainActivity = this;
                                permissionHelper.requestPermissionOrGoToSettings(strArr2, new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.MainActivity$showFeatureDialog$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(String[] strArr3) {
                                        invoke2(strArr3);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(String[] allowedRequests) {
                                        ActivityResultLauncher activityResultLauncher;
                                        Intrinsics.checkNotNullParameter(allowedRequests, "allowedRequests");
                                        activityResultLauncher = MainActivity.this.permissionLauncher;
                                        activityResultLauncher.launch(allowedRequests);
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                return;
            case 5:
                BottomSheetKt.showBottomDialog(this, R.layout.dialog_needs_location_disabled, new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.MainActivity$showFeatureDialog$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z2) {
                        if (z2) {
                            CustomActivityResult.launch$default(MainActivity.this.getActivityLauncher(), new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), null, 2, null);
                        }
                    }
                });
                return;
            case 6:
                NotificationUtil.showNeedsReadNotificationsPermissionDialog(this, null);
                return;
            default:
                return;
        }
    }

    private final void startRefreshing() {
        WatchItem watchItem = this.currentWatchItem;
        if (watchItem != null && !this.isRefreshing) {
            watchItem.startRefreshing();
            watchItem.registerWatchItemChangedListener(this);
            this.isRefreshing = true;
        }
    }

    private final void stopRefreshing() {
        WatchItem watchItem = this.currentWatchItem;
        if (watchItem != null && this.isRefreshing) {
            watchItem.stopRefreshing();
            watchItem.unregisterWatchItemChangedListener(this);
            this.isRefreshing = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateSubComplicationBehaviourIfNeeded(com.animaconnected.watch.Slot r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.animaconnected.secondo.screens.MainActivity$updateSubComplicationBehaviourIfNeeded$1
            if (r0 == 0) goto L13
            r0 = r8
            com.animaconnected.secondo.screens.MainActivity$updateSubComplicationBehaviourIfNeeded$1 r0 = (com.animaconnected.secondo.screens.MainActivity$updateSubComplicationBehaviourIfNeeded$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.MainActivity$updateSubComplicationBehaviourIfNeeded$1 r0 = new com.animaconnected.secondo.screens.MainActivity$updateSubComplicationBehaviourIfNeeded$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r7 = r0.L$2
            com.animaconnected.secondo.screens.watch.item.WatchItem r7 = (com.animaconnected.secondo.screens.watch.item.WatchItem) r7
            java.lang.Object r1 = r0.L$1
            com.animaconnected.secondo.screens.watch.item.WatchItem r1 = (com.animaconnected.secondo.screens.watch.item.WatchItem) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.MainActivity r0 = (com.animaconnected.secondo.screens.MainActivity) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L95
        L36:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3e:
            java.lang.Object r7 = r0.L$2
            com.animaconnected.secondo.screens.watch.item.WatchItem r7 = (com.animaconnected.secondo.screens.watch.item.WatchItem) r7
            java.lang.Object r1 = r0.L$1
            com.animaconnected.secondo.screens.watch.item.WatchItem r1 = (com.animaconnected.secondo.screens.watch.item.WatchItem) r1
            java.lang.Object r0 = r0.L$0
            com.animaconnected.secondo.screens.MainActivity r0 = (com.animaconnected.secondo.screens.MainActivity) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L7a
        L4e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.animaconnected.secondo.screens.watch.item.WatchItem r8 = r6.currentWatchItem
            if (r8 != 0) goto L58
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L58:
            com.animaconnected.watch.Slot r2 = com.animaconnected.watch.Slot.SubComplication1
            if (r7 == r2) goto L60
            com.animaconnected.watch.Slot r5 = com.animaconnected.watch.Slot.SubComplication2
            if (r7 != r5) goto La0
        L60:
            r6.stopRefreshing()
            if (r7 != r2) goto L80
            com.animaconnected.watch.behaviour.Behaviours r2 = r6.behaviours
            r0.L$0 = r6
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r7 = r2.getBehaviour(r7, r0)
            if (r7 != r1) goto L76
            return r1
        L76:
            r0 = r6
            r1 = r8
            r8 = r7
            r7 = r1
        L7a:
            com.animaconnected.watch.behaviour.Behaviour r8 = (com.animaconnected.watch.behaviour.Behaviour) r8
            r7.setSubComplicationBehaviour1(r8)
            goto L9a
        L80:
            com.animaconnected.watch.behaviour.Behaviours r2 = r6.behaviours
            r0.L$0 = r6
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r7 = r2.getBehaviour(r7, r0)
            if (r7 != r1) goto L91
            return r1
        L91:
            r0 = r6
            r1 = r8
            r8 = r7
            r7 = r1
        L95:
            com.animaconnected.watch.behaviour.Behaviour r8 = (com.animaconnected.watch.behaviour.Behaviour) r8
            r7.setSubComplicationBehaviour2(r8)
        L9a:
            r0.updateWatchLayout(r1, r4)
            r0.startRefreshing()
        La0:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity.updateSubComplicationBehaviourIfNeeded(com.animaconnected.watch.Slot, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void updateWatchLayout(WatchItem watchItem, boolean z) {
        Behaviour subComplicationBehaviour1 = watchItem.getSubComplicationBehaviour1();
        Behaviour subComplicationBehaviour2 = watchItem.getSubComplicationBehaviour2();
        SubComplicationHandModel subComplicationHandModel = this.subComplicationHandModel1;
        if (subComplicationHandModel != null) {
            subComplicationHandModel.setCurrentSubComplicationBehaviour(subComplicationBehaviour1);
        }
        SubComplicationHandModel subComplicationHandModel2 = this.subComplicationHandModel2;
        if (subComplicationHandModel2 != null) {
            subComplicationHandModel2.setCurrentSubComplicationBehaviour(subComplicationBehaviour2);
        }
        WatchLayout watchLayout = this.watchLayout;
        if (watchLayout != null) {
            watchLayout.updateHands(z);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("watchLayout");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.CalibrationProgress
    public void calibrationFinished() {
        goBack();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.reportTouchEventToDemoProvider) {
            boolean z = false;
            if (motionEvent != null && motionEvent.getAction() == 0) {
                z = true;
            }
            if (z) {
                this.watchProvider.getWatchManager().getDemoModeProvider().updateAppInteractionTime();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.animaconnected.secondo.screens.ViewLayouter
    public int getViewHeight() {
        return this.viewYOffset;
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public int getWatchLayoutWidth() {
        WatchLayout watchLayout = this.watchLayout;
        if (watchLayout != null) {
            return watchLayout.getWidth();
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchLayout");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public WatchViewController getWatchViewController() {
        WatchViewController watchViewController = this.watchViewController;
        if (watchViewController != null) {
            return watchViewController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchViewController");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void goBack() {
        onBackPressed();
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragment(BaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (this.isAnimatingWhatIsNew) {
            return;
        }
        gotoNextFragment(fragment, false);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragmentWithAnimations(BaseFragment fragment, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseFragment currentFragment = getCurrentFragment();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
        m.setCustomAnimations(r4, r5, r6, r7);
        m.replace(R.id.content, fragment, null);
        m.addToBackStack(currentFragment.getName());
        m.commitAllowingStateLoss();
        if (!(fragment instanceof DashboardFragment)) {
            clearStatusBoard();
        }
        Companion.onFragmentReplaced(fragment);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextRevealedFragmentWithAnimations(BaseFragment fragment, int r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseFragment currentRevealedFragment = getCurrentRevealedFragment();
        if (currentRevealedFragment == null) {
            currentRevealedFragment = getCurrentFragment();
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
        m.setCustomAnimations(r4, r5, r6, r7);
        m.replace(R.id.revealed_fragment_container, fragment, null);
        m.addToBackStack(currentRevealedFragment.getName());
        m.commitAllowingStateLoss();
        Companion.onFragmentReplaced(fragment);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoOnboarding() {
        this.watchProvider.setOnboardingFinished(false);
        this.watchProvider.setWroteOnboardingDeviceSettings(false);
        Intent intent = new Intent(this, (Class<?>) OnboardingActivity.class);
        finish();
        startActivity(intent);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoRevealedFragment(final BaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.clickThrottle.handle(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.MainActivity$gotoRevealedFragment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BaseFragment currentRevealedFragment;
                BaseFragment currentFragment;
                currentRevealedFragment = MainActivity.this.getCurrentRevealedFragment();
                if (currentRevealedFragment == null) {
                    currentRevealedFragment = MainActivity.this.getCurrentFragment();
                }
                currentFragment = MainActivity.this.getCurrentFragment();
                currentFragment.onRevealedFragmentOpened();
                FragmentManager supportFragmentManager = MainActivity.this.getSupportFragmentManager();
                BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
                m.replace(R.id.revealed_fragment_container, fragment, null);
                m.addToBackStack(currentRevealedFragment.getName());
                m.commitAllowingStateLoss();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BaseFragment currentFragment = getCurrentFragment();
        BaseFragment currentRevealedFragment = getCurrentRevealedFragment();
        if (currentRevealedFragment != 0) {
            currentFragment.onRevealedFragmentClosed();
            if (currentRevealedFragment instanceof Dismissible) {
                ((Dismissible) currentRevealedFragment).dismiss(new MainActivity$$ExternalSyntheticLambda0(this, currentRevealedFragment));
                return;
            }
            String parentFragmentName = currentRevealedFragment.getParentFragmentName();
            if (parentFragmentName != null) {
                popUntilFragment(parentFragmentName);
                return;
            } else {
                if (currentRevealedFragment.onBack()) {
                    super.onBackPressed();
                    return;
                }
                return;
            }
        }
        String parentFragmentName2 = currentFragment.getParentFragmentName();
        if (parentFragmentName2 != null) {
            popUntilFragment(parentFragmentName2);
        } else if (currentFragment.onBack()) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        BaseFragment currentFragment = getCurrentFragment();
        onStatusChanged();
        BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new MainActivity$onBackStackChanged$1(this, currentFragment, null));
        if (Intrinsics.areEqual(currentFragment.getName(), DashboardFragment.name) && CampaignProvider.INSTANCE.isInterested()) {
            DashboardMarbleView dashboardMarbleView = this.dashboardMarbleView;
            if (dashboardMarbleView != null) {
                dashboardMarbleView.show();
                if (this.animatedGradient) {
                    animateBackGradient();
                    return;
                }
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
            throw null;
        }
        DashboardMarbleView dashboardMarbleView2 = this.dashboardMarbleView;
        if (dashboardMarbleView2 != null) {
            dashboardMarbleView2.hide();
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
            throw null;
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            handleIntent(intent);
        }
        ThemeProvider themeProvider = new ThemeProvider(ProductInfoProvider.getCurrentSkuData(), this);
        setTheme(themeProvider.getThemeFromAssetVersion());
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        View findViewById = findViewById(R.id.watch_layer);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.watchLayer = findViewById;
        View findViewById2 = findViewById(R.id.watch_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.watchLayoutParent = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.image_view_watch_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.imageViewWatchShadow = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.image_view_background_gradient_top);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.imageViewGradientTop = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.image_view_background_gradient_bottom);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.imageViewGradientBottom = (ImageView) findViewById5;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        DashboardMarbleView dashboardMarbleView = new DashboardMarbleView(applicationContext, null, 0, 6, null);
        this.dashboardMarbleView = dashboardMarbleView;
        ViewGroup viewGroup = this.watchLayoutParent;
        if (viewGroup != null) {
            viewGroup.addView(dashboardMarbleView);
            applyTheme(themeProvider);
            DashboardMarbleView dashboardMarbleView2 = this.dashboardMarbleView;
            if (dashboardMarbleView2 != null) {
                dashboardMarbleView2.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.MainActivity$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MainActivity.onCreate$lambda$3(MainActivity.this, view);
                    }
                });
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DashboardConfigurationHelper.getDashboardButtonsHeightPx(getResources()));
                ImageView imageView = this.imageViewGradientBottom;
                if (imageView != null) {
                    imageView.setLayoutParams(layoutParams);
                    findViewById(R.id.watch_button_placeholder).setLayoutParams(layoutParams);
                    BuildersKt.runBlocking(EmptyCoroutineContext.INSTANCE, new MainActivity$onCreate$3(this, null));
                    ImageView imageView2 = this.imageViewGradientTop;
                    if (imageView2 != null) {
                        ImageView imageView3 = this.imageViewGradientBottom;
                        if (imageView3 != null) {
                            this.gradientViewController = new GradientViewController(imageView2, imageView3);
                            this.watchProvider.getCapabilities();
                            this.behaviours.setBehaviourForMagicKey(FindPhone.TYPE);
                            ProviderFactory.getKronabyFirebaseInstanceIdService().refreshTokenIfNeeded();
                            FragmentManager supportFragmentManager = getSupportFragmentManager();
                            if (supportFragmentManager.mBackStackChangeListeners == null) {
                                supportFragmentManager.mBackStackChangeListeners = new ArrayList<>();
                            }
                            supportFragmentManager.mBackStackChangeListeners.add(this);
                            if (bundle == null) {
                                DashboardFragment newInstance = DashboardFragment.Companion.newInstance();
                                FragmentManager supportFragmentManager2 = getSupportFragmentManager();
                                BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager2, supportFragmentManager2);
                                m.doAddOp(R.id.content, newInstance, null, 1);
                                m.commit();
                            }
                            setupDemoModeHandling();
                            return;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientBottom");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientTop");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientBottom");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("watchLayoutParent");
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnalyticsTrackingProvider.getInstance().stopTrackingFragment();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.getItemId() == 16908332) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.watchProvider.unregisterListener(this.watchProviderListener);
        FastModeProvider.getInstance(this.watchProvider).onPause();
        AnalyticsTrackingProvider.getInstance().pauseTrackingFragment();
        ProviderFactory.getWatchFotaProvider().onPause();
        stopRefreshing();
        this.helpCenterProvider.unregisterHelpCenterListener(this);
        this.helpCenterProvider.onPause();
        this.currentStatus = this.statusProvider.getCurrent();
        this.statusProvider.unregisterListener(this);
    }

    @Override // com.animaconnected.secondo.screens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.watchProvider.registerListener(this.watchProviderListener);
        this.watchProvider.onResume();
        WatchItem watchItem = this.currentWatchItem;
        boolean z = false;
        if (watchItem != null) {
            updateWatchLayout(watchItem, false);
        }
        FastModeProvider.getInstance(this.watchProvider).onResume();
        AnalyticsTrackingProvider.getInstance().resumeTrackingFragment();
        ProviderFactory.getWatchFotaProvider().onResume();
        startRefreshing();
        BaseFragment currentFragment = getCurrentFragment();
        checkIfWhatIsNewAnimationShouldStart(currentFragment);
        this.helpCenterProvider.registerHelpCenterListener(this);
        this.helpCenterProvider.onResume();
        if (!this.isAnimatingWhatIsNew && Intrinsics.areEqual(currentFragment.getName(), DashboardFragment.name)) {
            CampaignProvider campaignProvider = CampaignProvider.INSTANCE;
            if (campaignProvider.isInterested()) {
                campaignProvider.showNotificationIfNotShown();
                DashboardMarbleView dashboardMarbleView = this.dashboardMarbleView;
                if (dashboardMarbleView != null) {
                    dashboardMarbleView.show();
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("dashboardMarbleView");
                    throw null;
                }
            }
        }
        this.statusProvider.registerListener(this);
        for (StatusController statusController : this.statusProvider.getControllers()) {
            statusController.update();
        }
        onStatusChanged();
        DeviceType deviceType = this.watchProvider.getDeviceType();
        if (deviceType != null && deviceType.getHasDisplay()) {
            z = true;
        }
        if (z) {
            retryFailedStravaUploads();
        }
    }

    @Override // com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener
    public void onStateChanged(HelpCenterProvider.HelpState oldState, HelpCenterProvider.HelpState newState) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        if (newState == HelpCenterProvider.HelpState.GUIDE_INSTRUCTIONS) {
            HelpCenterGuideDialog newInstance = HelpCenterGuideDialog.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "newInstance(...)");
            newInstance.show(getSupportFragmentManager(), (String) null);
        }
    }

    @Override // com.animaconnected.secondo.provider.status.StatusChangeListener
    public void onStatusChanged() {
        final StatusModel current = this.statusProvider.getCurrent();
        LogKt.debug$default((Object) this, (String) null, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.MainActivity$onStatusChanged$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "onStatusChanged: " + StatusModel.this;
            }
        }, 7, (Object) null);
        if (current != null && (getCurrentFragment() instanceof DashboardFragment)) {
            setCurrentStatus(current, Intrinsics.areEqual(this.currentStatus, current));
        } else {
            clearStatusBoard();
        }
    }

    @Override // com.animaconnected.secondo.screens.ViewLayouter
    public void onViewLayouted(int r4) {
        ImageView imageView = this.imageViewGradientBottom;
        if (imageView != null) {
            int height = imageView.getHeight() - r4;
            this.viewYOffset = height;
            GradientViewController gradientViewController = this.gradientViewController;
            if (gradientViewController != null) {
                gradientViewController.animateGradient(0, height, GRADIENT_ANIMATION_DURATION);
                this.animatedGradient = true;
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("gradientViewController");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewGradientBottom");
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.watch.item.WatchItemChangeListener
    public void onWatchItemChanged(WatchItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        updateWatchLayout(data, true);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void popUntilFragment(String fragmentName) {
        Intrinsics.checkNotNullParameter(fragmentName, "fragmentName");
        getSupportFragmentManager().popBackStack(fragmentName);
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void setWatchLayerAboveContent(boolean z) {
        int r2;
        Resources resources = getResources();
        if (z) {
            r2 = R.dimen.watch_layout_elevation_above_content;
        } else {
            r2 = R.dimen.watch_layout_elevation_below_content;
        }
        float dimension = resources.getDimension(r2);
        View view = this.watchLayer;
        if (view != null) {
            view.setElevation(dimension);
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("watchLayer");
            throw null;
        }
    }

    public void setWatchViewController(WatchViewController watchViewController) {
        Intrinsics.checkNotNullParameter(watchViewController, "<set-?>");
        this.watchViewController = watchViewController;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.animaconnected.secondo.screens.MainController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object updateWatchAreaViews(int r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.animaconnected.secondo.screens.MainActivity$updateWatchAreaViews$2
            if (r0 == 0) goto L13
            r0 = r14
            com.animaconnected.secondo.screens.MainActivity$updateWatchAreaViews$2 r0 = (com.animaconnected.secondo.screens.MainActivity$updateWatchAreaViews$2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.MainActivity$updateWatchAreaViews$2 r0 = new com.animaconnected.secondo.screens.MainActivity$updateWatchAreaViews$2
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r14)
            goto Laf
        L2c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L34:
            java.lang.Object r13 = r0.L$0
            com.animaconnected.secondo.screens.MainActivity r13 = (com.animaconnected.secondo.screens.MainActivity) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto La2
        L3c:
            kotlin.ResultKt.throwOnFailure(r14)
            com.animaconnected.secondo.screens.BaseFragment r14 = r12.getCurrentFragment()
            boolean r2 = r14 instanceof com.animaconnected.secondo.screens.watch.WatchViewLayouter
            if (r2 == 0) goto Lc2
            com.animaconnected.secondo.screens.watch.WatchViewLayouter r14 = (com.animaconnected.secondo.screens.watch.WatchViewLayouter) r14
            android.content.res.Resources r2 = r12.getResources()
            r6 = 2131492925(0x7f0c003d, float:1.8609316E38)
            int r2 = r2.getInteger(r6)
            com.animaconnected.secondo.widget.WatchLayout r6 = r12.watchLayout
            java.lang.String r7 = "watchLayout"
            if (r6 == 0) goto Lbe
            int r8 = r6.getWidth()
            com.animaconnected.secondo.widget.WatchLayout r6 = r12.watchLayout
            if (r6 == 0) goto Lba
            int r9 = r6.getHeight()
            android.view.ViewGroup r6 = r12.watchLayoutParent
            java.lang.String r7 = "watchLayoutParent"
            if (r6 == 0) goto Lb6
            int r10 = r6.getWidth()
            android.view.ViewGroup r6 = r12.watchLayoutParent
            if (r6 == 0) goto Lb2
            int r11 = r6.getHeight()
            r6 = r14
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r13
            int[] r6 = r6.getWatchOffset(r7, r8, r9, r10, r11)
            com.animaconnected.secondo.screens.WatchViewController r7 = r12.getWatchViewController()
            r8 = 0
            r8 = r6[r8]
            r6 = r6[r4]
            r7.updateWatchLocation(r8, r6, r2)
            r14.onWatchViewLayouted()
            r14.onWatchViewUpdated(r13)
            com.animaconnected.watch.Slot r13 = com.animaconnected.watch.Slot.SubComplication1
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = r12.updateSubComplicationBehaviourIfNeeded(r13, r0)
            if (r13 != r1) goto La1
            return r1
        La1:
            r13 = r12
        La2:
            com.animaconnected.watch.Slot r14 = com.animaconnected.watch.Slot.SubComplication2
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r13 = r13.updateSubComplicationBehaviourIfNeeded(r14, r0)
            if (r13 != r1) goto Laf
            return r1
        Laf:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        Lb2:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r5
        Lb6:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r5
        Lba:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r5
        Lbe:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            throw r5
        Lc2:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity.updateWatchAreaViews(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.MainController
    public void gotoNextFragment(final BaseFragment fragment, final boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.clickThrottle.handle(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.MainActivity$gotoNextFragment$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                BaseFragment currentRevealedFragment;
                currentRevealedFragment = MainActivity.this.getCurrentRevealedFragment();
                if (currentRevealedFragment != null) {
                    if (!z) {
                        MainActivity.this.gotoNextRevealedFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                        return;
                    } else {
                        MainActivity.this.gotoNextRevealedFragmentWithAnimations(new DummyDetailsFragment(), R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                        MainActivity.this.gotoNextFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                        return;
                    }
                }
                MainActivity.this.gotoNextFragmentWithAnimations(fragment, R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0109 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateWatchAreaViews(com.animaconnected.secondo.screens.BaseFragment r18, boolean r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.MainActivity.updateWatchAreaViews(com.animaconnected.secondo.screens.BaseFragment, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.animaconnected.secondo.screens.CalibrationProgress
    public void calibrationPageSelected(int r1) {
    }
}
