package com.animaconnected.secondo.screens.onboarding;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.DialogFragment$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.analytics.AnalyticsTrackingProvider;
import com.animaconnected.secondo.screens.BaseActivity;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.CalibrationProgress;
import com.animaconnected.secondo.screens.MainActivity;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.permissions.CallsPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.permissions.LocationPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragment;
import com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateCompletedFragment;
import com.animaconnected.secondo.screens.watchupdate.WatchUpdateFragmentFactory;
import com.animaconnected.secondo.utils.NotificationUtils;
import com.animaconnected.watch.HybridWatch;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* compiled from: OnboardingActivity.kt */
/* loaded from: classes3.dex */
public final class OnboardingActivity extends BaseActivity implements Onboarding.OnboardingChangeListener, OnboardingViewController, CalibrationProgress, ResetWatchDialogFragmentCallback {
    private static final int NR_OF_FAILED_CONNECTIONS_UNTIL_SHOW_RESET_WATCH = 2;
    private int backStackStartLevel;
    private CantConnectDialogFragment cantConnectDialogFragment;
    private EnableBluetoothDialogFragment enableBluetoothDialogFragment;
    private EnableInternetAccessDialogFragment enableInternetAccessDialogFragment;
    private boolean hasShowedResetWatch;
    private boolean isResuming;
    private int nrOfFailedConnections;
    public Onboarding onboarding;
    private ResetWatchDialogFragment resetWatchDialogFragment;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "OnboardingActivity";
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ConnectionListener connectionListener = new ConnectionListener() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingActivity$$ExternalSyntheticLambda1
        @Override // com.animaconnected.bluetooth.util.ConnectionListener
        public final void onChanged(boolean z) {
            OnboardingActivity.connectionListener$lambda$1(OnboardingActivity.this, z);
        }
    };
    private final int associationRequestCode = 20230423;

    /* compiled from: OnboardingActivity.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: OnboardingActivity.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Onboarding.State.values().length];
            try {
                r0[Onboarding.State.TERMS_OF_USE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Onboarding.State.SPLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Onboarding.State.SMARTIME_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Onboarding.State.WELCOME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Onboarding.State.SCANNING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Onboarding.State.CONNECTING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[Onboarding.State.CONNECTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                r0[Onboarding.State.BLUETOOTH_ENABLING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                r0[Onboarding.State.LOCATION_ENABLING.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                r0[Onboarding.State.LOCATION_PERMISSION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                r0[Onboarding.State.SIGNIN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                r0[Onboarding.State.CALIBRATION.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                r0[Onboarding.State.BACKGROUND_LOCATION_PERMISSION.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                r0[Onboarding.State.SYSTEM_NOTIFICATION_PERMISSION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                r0[Onboarding.State.UPDATE_REQUIRED.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                r0[Onboarding.State.UPDATE_COMPLETED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                r0[Onboarding.State.CALL_PERMISSION.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                r0[Onboarding.State.SMS_PERMISSION.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                r0[Onboarding.State.PROFILE_SETUP.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                r0[Onboarding.State.DISPLAY_WATCH_TUTORIAL.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                r0[Onboarding.State.WHATSNEW.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                r0[Onboarding.State.WAITING_PRODUCT_INFO.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                r0[Onboarding.State.FINISHED.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListener$lambda$1(final OnboardingActivity this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handler.post(new Runnable() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                OnboardingActivity.connectionListener$lambda$1$lambda$0(OnboardingActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectionListener$lambda$1$lambda$0(OnboardingActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getOnboarding().updateState();
    }

    private final void displayNextFragment() {
        switch (WhenMappings.$EnumSwitchMapping$0[getOnboarding().getState().ordinal()]) {
            case 1:
                gotoNextFragment(new OnboardingTermsOfUseFragment());
                return;
            case 2:
                gotoNextFragment(new OnboardingSplashFragment());
                return;
            case 3:
                gotoNextFragment(new OnboardingSmarTimeFragment());
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                gotoNextFragment(OnboardingWatchFragment.Companion.newInstance());
                return;
            case 8:
                EnableBluetoothDialogFragment enableBluetoothDialogFragment = this.enableBluetoothDialogFragment;
                if (enableBluetoothDialogFragment != null) {
                    enableBluetoothDialogFragment.dismiss();
                }
                EnableBluetoothDialogFragment enableBluetoothDialogFragment2 = new EnableBluetoothDialogFragment();
                enableBluetoothDialogFragment2.show(getSupportFragmentManager(), (String) null);
                this.enableBluetoothDialogFragment = enableBluetoothDialogFragment2;
                return;
            case 9:
                gotoNextFragment(new LocationEnableFragment());
                return;
            case 10:
                gotoNextFragment(LocationPermissionFragment.Companion.newInstance());
                return;
            case 11:
                gotoNextFragment(OnboardingLoginFragment.Companion.newInstance());
                return;
            case 12:
                if (ProviderFactory.getWatch().getDeviceType() != null) {
                    gotoNextFragment(OnboardingCalibrationInitiationFragment.Companion.newInstance());
                    return;
                }
                return;
            case 13:
                gotoNextFragment(BackgroundLocationPermissionFragment.Companion.newInstance());
                return;
            case 14:
                gotoNextFragment(SystemNotificationPermissionFragment.Companion.newInstance());
                return;
            case 15:
                gotoNextFragment(WatchUpdateFragmentFactory.INSTANCE.getWatchUpdateFragment$secondo_kronabyRelease(ProviderFactory.getWatch().getFirmwareUpdate()));
                return;
            case 16:
                gotoNextFragment(WatchUpdateCompletedFragment.Companion.newInstance());
                return;
            case 17:
                gotoNextFragment(CallsPermissionFragment.Companion.newInstance());
                return;
            case 18:
                gotoNextFragment(SmsPermissionFragment.Companion.newInstance());
                return;
            case 19:
                gotoNextFragment(new OnboardingProfile());
                return;
            case 20:
                gotoNextFragment(OnboardingDisplayWatchTutorial.Companion.newInstance());
                return;
            case 21:
                gotoNextFragment(OnboardingWhatsNewFragment.Companion.newInstance());
                return;
            case 22:
                gotoNextFragment(OnboardingWaitingProductInfo.Companion.newInstance());
                return;
            case 23:
                onboardingFinished();
                return;
            default:
                Log.w(TAG, "Weird state in onboarding " + getOnboarding().getState());
                return;
        }
    }

    private final BaseOnboardingFragment getCurrentDisplayedBaseOnboardingFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.contentOnboarding);
        if (findFragmentById instanceof BaseOnboardingFragment) {
            return (BaseOnboardingFragment) findFragmentById;
        }
        return null;
    }

    private final boolean getHasTriedToConnectToPreviousTriedDevice() {
        return Intrinsics.areEqual(getOnboarding().getPreviousTriedDevice(), ProviderFactory.getWatch().getAddress());
    }

    private final void gotoNextFragment(BaseFragment baseFragment) {
        gotoNextFragment(baseFragment, false);
        if (getOnboarding().getState() != Onboarding.State.SPLASH) {
            AnalyticsTrackingProvider.getInstance().startTrackingFragment(baseFragment.getClass().getSimpleName());
        }
    }

    private final void onboardingFinished() {
        ProviderFactory.getBackgroundUpdateChecker().refreshNow();
        startMainActivity();
    }

    private final void startMainActivity() {
        Serializable serializableExtra;
        Intent intent = new Intent(getApplicationContext(), (Class<?>) MainActivity.class);
        intent.setFlags(65536);
        if (getIntent().hasExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE)) {
            Intent intent2 = getIntent();
            Intrinsics.checkNotNullExpressionValue(intent2, "getIntent(...)");
            if (Build.VERSION.SDK_INT >= 33) {
                serializableExtra = intent2.getSerializableExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE, Serializable.class);
            } else {
                serializableExtra = intent2.getSerializableExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE);
            }
            intent.putExtra(NotificationUtils.EXTRA_KEY_FEATURE_ISSUE, serializableExtra);
        }
        if (getIntent().hasExtra(NotificationUtils.EXTRA_KEY_PERMISSIONS)) {
            intent.putExtra(NotificationUtils.EXTRA_KEY_PERMISSIONS, getIntent().getStringArrayExtra(NotificationUtils.EXTRA_KEY_PERMISSIONS));
        }
        if (getIntent().hasExtra(NotificationUtils.EXTRA_KEY_WORKOUT_COMPLETE)) {
            intent.putExtra(NotificationUtils.EXTRA_KEY_WORKOUT_COMPLETE, getIntent().getBooleanExtra(NotificationUtils.EXTRA_KEY_WORKOUT_COMPLETE, true));
        }
        startActivity(intent);
        overridePendingTransition(0, R.anim.fadeout);
        finish();
    }

    private final void updateOrReplaceCurrentFragment() {
        BaseOnboardingFragment currentDisplayedBaseOnboardingFragment = getCurrentDisplayedBaseOnboardingFragment();
        if (currentDisplayedBaseOnboardingFragment != null && currentDisplayedBaseOnboardingFragment.handlesState(getOnboarding().getState())) {
            currentDisplayedBaseOnboardingFragment.updateUI();
        } else {
            displayNextFragment();
        }
    }

    @Override // com.animaconnected.secondo.screens.CalibrationProgress
    public void calibrationFinished() {
        clearBackStack();
        getOnboarding().setCalibrationDone();
    }

    @Override // com.animaconnected.secondo.screens.CalibrationProgress
    public void calibrationPageSelected(int r4) {
        AnalyticsTrackingProvider.getInstance().startTrackingFragment("CalibrationFragment-Page" + r4);
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingViewController
    public void clearBackStack() {
        int r0;
        ArrayList<BackStackRecord> arrayList = getSupportFragmentManager().mBackStack;
        if (arrayList != null) {
            r0 = arrayList.size();
        } else {
            r0 = 0;
        }
        if (r0 > 0) {
            this.backStackStartLevel = r0;
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.Onboarding.OnboardingChangeListener
    public void foundOneDeviceWhenScanning() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.contentOnboarding);
        if (findFragmentById instanceof BaseOnboardingFragment) {
            ((BaseOnboardingFragment) findFragmentById).foundOneDeviceWhenScanning();
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingViewController
    public Onboarding getOnboarding() {
        Onboarding onboarding = this.onboarding;
        if (onboarding != null) {
            return onboarding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("onboarding");
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int r2, int r3, Intent intent) {
        if (r2 == this.associationRequestCode) {
            if (r3 == -1) {
                getOnboarding().associationResult(intent);
                return;
            }
            return;
        }
        super.onActivityResult(r2, r3, intent);
    }

    @Override // com.animaconnected.secondo.screens.onboarding.Onboarding.OnboardingChangeListener
    public void onAssociationRequest(IntentSender intentSender) {
        Intrinsics.checkNotNullParameter(intentSender, "intentSender");
        startIntentSenderForResult(intentSender, this.associationRequestCode, null, 0, 0, 0);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int r1;
        BaseOnboardingFragment currentDisplayedBaseOnboardingFragment = getCurrentDisplayedBaseOnboardingFragment();
        if (this.backStackStartLevel > 0) {
            ArrayList<BackStackRecord> arrayList = getSupportFragmentManager().mBackStack;
            if (arrayList != null) {
                r1 = arrayList.size();
            } else {
                r1 = 0;
            }
            if (r1 <= this.backStackStartLevel) {
                finish();
                return;
            }
        }
        if (currentDisplayedBaseOnboardingFragment == null || currentDisplayedBaseOnboardingFragment.isBackAllowed()) {
            super.onBackPressed();
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KronabyApplication.Companion companion = KronabyApplication.Companion;
        companion.initialize();
        this.backStackStartLevel = 0;
        setContentView(R.layout.activity_onboarding);
        setOnboarding(new Onboarding(ProviderFactory.createBluetoothOnboardingProvider(), ProviderFactory.createSigninProvider(), companion.getContext()));
        getWindow().addFlags(128);
        BuildersKt.launch$default(Hashing.getLifecycleScope(this), null, null, new OnboardingActivity$onCreate$1(null), 3);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnalyticsTrackingProvider.getInstance().stopTrackingFragment();
        super.onDestroy();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.Onboarding.OnboardingChangeListener
    public void onFailedToConnectToDevice() {
        if (getOnboarding().getPreviousTriedDevice() != null && !getHasTriedToConnectToPreviousTriedDevice()) {
            this.nrOfFailedConnections = 0;
            return;
        }
        int r0 = this.nrOfFailedConnections + 1;
        this.nrOfFailedConnections = r0;
        if (r0 == 2 && !this.hasShowedResetWatch && (ProviderFactory.getWatch().getWatch() instanceof HybridWatch)) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingActivity$onFailedToConnectToDevice$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Tried same device twice! It probably have bonding that has not been removed";
                }
            }, 6, (Object) null);
            this.nrOfFailedConnections = 0;
            CantConnectDialogFragment cantConnectDialogFragment = this.cantConnectDialogFragment;
            if (cantConnectDialogFragment != null) {
                cantConnectDialogFragment.dismiss();
            }
            this.hasShowedResetWatch = true;
            if (this.resetWatchDialogFragment == null) {
                ResetWatchDialogFragment resetWatchDialogFragment = new ResetWatchDialogFragment();
                resetWatchDialogFragment.show(getSupportFragmentManager(), (String) null);
                this.resetWatchDialogFragment = resetWatchDialogFragment;
                return;
            }
            return;
        }
        if (this.nrOfFailedConnections == 2 && (ProviderFactory.getWatch().getWatch() instanceof HybridWatch)) {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LogKt.debug$default((Object) this, TAG3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingActivity$onFailedToConnectToDevice$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Cant connect, show FAQ";
                }
            }, 6, (Object) null);
            this.nrOfFailedConnections = 0;
            ResetWatchDialogFragment resetWatchDialogFragment2 = this.resetWatchDialogFragment;
            if (resetWatchDialogFragment2 != null) {
                resetWatchDialogFragment2.dismiss();
            }
            if (this.cantConnectDialogFragment == null) {
                CantConnectDialogFragment cantConnectDialogFragment2 = new CantConnectDialogFragment();
                cantConnectDialogFragment2.show(getSupportFragmentManager(), (String) null);
                this.cantConnectDialogFragment = cantConnectDialogFragment2;
            }
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.Onboarding.OnboardingChangeListener
    public void onInternetConnectivityChanged(boolean z, boolean z2) {
        if (!z2 && z) {
            if (this.enableInternetAccessDialogFragment == null) {
                EnableInternetAccessDialogFragment enableInternetAccessDialogFragment = new EnableInternetAccessDialogFragment();
                enableInternetAccessDialogFragment.show(getSupportFragmentManager(), (String) null);
                this.enableInternetAccessDialogFragment = enableInternetAccessDialogFragment;
                return;
            }
            return;
        }
        EnableInternetAccessDialogFragment enableInternetAccessDialogFragment2 = this.enableInternetAccessDialogFragment;
        if (enableInternetAccessDialogFragment2 != null) {
            enableInternetAccessDialogFragment2.dismiss();
        }
        this.enableInternetAccessDialogFragment = null;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.Onboarding.OnboardingChangeListener
    public void onOnboardingStateChanged() {
        EnableBluetoothDialogFragment enableBluetoothDialogFragment = this.enableBluetoothDialogFragment;
        if (enableBluetoothDialogFragment != null) {
            enableBluetoothDialogFragment.dismiss();
        }
        if (getOnboarding().getState() != Onboarding.State.CONNECTING && getOnboarding().getState() != Onboarding.State.SCANNING) {
            ResetWatchDialogFragment resetWatchDialogFragment = this.resetWatchDialogFragment;
            if (resetWatchDialogFragment != null) {
                resetWatchDialogFragment.dismiss();
            }
            CantConnectDialogFragment cantConnectDialogFragment = this.cantConnectDialogFragment;
            if (cantConnectDialogFragment != null) {
                cantConnectDialogFragment.dismiss();
            }
            this.hasShowedResetWatch = false;
        }
        updateOrReplaceCurrentFragment();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        EnableBluetoothDialogFragment enableBluetoothDialogFragment = this.enableBluetoothDialogFragment;
        if (enableBluetoothDialogFragment != null) {
            enableBluetoothDialogFragment.dismiss();
        }
        ConnectionFactory.getConnection().removeConnectionListener(this.connectionListener);
        getOnboarding().setListener(null);
        getOnboarding().pause();
        AnalyticsTrackingProvider.getInstance().pauseTrackingFragment();
        super.onPause();
    }

    @Override // com.animaconnected.secondo.screens.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.isResuming = true;
        super.onResume();
        ConnectionFactory.getConnection().addConnectionListener(this.connectionListener);
        getOnboarding().setListener(this);
        getOnboarding().resume();
        updateOrReplaceCurrentFragment();
        getOnboarding().updateInternetConnectivityEnabled(true);
        this.isResuming = false;
        AnalyticsTrackingProvider.getInstance().resumeTrackingFragment();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ResetWatchDialogFragmentCallback
    public void resetWatchDialogDismissed() {
        ResetWatchDialogFragment resetWatchDialogFragment = this.resetWatchDialogFragment;
        if (resetWatchDialogFragment != null) {
            if (resetWatchDialogFragment != null) {
                resetWatchDialogFragment.dismiss();
            }
            this.resetWatchDialogFragment = null;
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingViewController
    public void setOnboarding(Onboarding onboarding) {
        Intrinsics.checkNotNullParameter(onboarding, "<set-?>");
        this.onboarding = onboarding;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.OnboardingViewController
    public void gotoNextFragment(BaseFragment fragment, boolean z) {
        int r2;
        int r1;
        int r3;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        BaseOnboardingFragment currentDisplayedBaseOnboardingFragment = getCurrentDisplayedBaseOnboardingFragment();
        int exitAnimRes = currentDisplayedBaseOnboardingFragment != null ? currentDisplayedBaseOnboardingFragment.getExitAnimRes(getOnboarding().getState(), this.isResuming) : R.anim.exit_to_left;
        if (fragment instanceof BaseOnboardingFragment) {
            BaseOnboardingFragment baseOnboardingFragment = (BaseOnboardingFragment) fragment;
            r2 = baseOnboardingFragment.getEnterAnimRes(getOnboarding().getPreviousState());
            r3 = baseOnboardingFragment.getPopExitAnimRes();
            r1 = baseOnboardingFragment.getPopEnterAnimRes();
        } else {
            r2 = R.anim.enter_from_right;
            r1 = R.anim.enter_from_left;
            r3 = R.anim.exit_to_right;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        BackStackRecord m = DialogFragment$$ExternalSyntheticOutline0.m(supportFragmentManager, supportFragmentManager);
        m.setCustomAnimations(r2, exitAnimRes, r1, r3);
        m.replace(R.id.contentOnboarding, fragment, null);
        if (z) {
            m.addToBackStack(fragment.getName());
        }
        m.commit();
    }
}
