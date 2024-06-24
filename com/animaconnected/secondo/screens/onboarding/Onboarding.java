package com.animaconnected.secondo.screens.onboarding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.animaconnected.bluetooth.device.scanner.BrandFilter;
import com.animaconnected.bluetooth.device.scanner.HybridDevice;
import com.animaconnected.bluetooth.device.scanner.ScannedDevice;
import com.animaconnected.bluetooth.device.scanner.SmarTimeBrand;
import com.animaconnected.bluetooth.device.scanner.SmarTimeDevice;
import com.animaconnected.bluetooth.device.scanner.WatchScanner;
import com.animaconnected.bluetooth.gatt.OnboardingConnectionListener;
import com.animaconnected.bluetooth.util.Bonding;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.info.EmulatorInfo;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.BluetoothOnboardingProvider;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.SigninProvider;
import com.animaconnected.secondo.provider.SigninStorage;
import com.animaconnected.secondo.provider.analytics.AnalyticsTrackingProvider;
import com.animaconnected.secondo.provider.analytics.WatchProviderAnalytics;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.permissions.BackgroundLocationPermissionFragmentKt;
import com.animaconnected.secondo.screens.onboarding.permissions.CallsPermissionFragmentKt;
import com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt;
import com.animaconnected.secondo.screens.onboarding.permissions.SystemNotificationPermissionFragmentKt;
import com.animaconnected.secondo.utils.AmplifyApiKt;
import com.animaconnected.secondo.utils.BrandUtils;
import com.animaconnected.secondo.utils.CompanionDeviceUtils;
import com.animaconnected.secondo.utils.Internet;
import com.animaconnected.secondo.utils.ThreadUtils;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.BaseWatchProviderListener;
import com.animaconnected.watch.account.profile.ProfileViewModel;
import com.animaconnected.watch.device.DeviceConnectionListener;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: Onboarding.kt */
/* loaded from: classes3.dex */
public final class Onboarding implements WatchScanner.WatchScannerListener, DeviceConnectionListener, OnboardingConnectionListener {
    private static final int CONNECTING_TIMEOUT_MS = 60000;
    private static final String PREFS_KEY_PREVIOUS_ONBOARDED_DEVICE = "previous_onboarded_device";
    private static final String SHARED_PREFS_NAME = "onboarding_shared_prefs";
    private static final int WAITING_PRODUCT_INFO_TIMEOUT_MS = 4000;
    private static final int WELCOME_DURATION_MS = 2500;
    private boolean canceled;
    private final BroadcastReceiver connectivityChangedReceiver;
    private final Context context;
    private boolean expectingForegroundDialogs;
    private SmarTimeDevice foundSmarTimeDevice;
    private Set<State> handledStates;
    private final Handler handler;
    private boolean isPaused;
    private boolean isUpdating;
    private boolean lastKnownInternetAvailable;
    private OnboardingChangeListener listener;
    private Function1<? super Intent, Unit> onIntentResultSuccess;
    private State previousState;
    private final Lazy profileViewModel$delegate;
    private final BluetoothOnboardingProvider provider;
    private final SigninProvider signInProvider;
    private State state;
    private final Runnable timerRunnable;
    private boolean updateProductInfoStarted;
    private final BaseWatchProviderListener watchProviderListener;
    private final WatchScanner watchScanner;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final String TAG = "Onboarding";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Onboarding.kt */
    /* loaded from: classes3.dex */
    public static final class BondingDialogState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BondingDialogState[] $VALUES;
        public static final BondingDialogState IDLE = new BondingDialogState("IDLE", 0);
        public static final BondingDialogState MIGHT_SHOW = new BondingDialogState("MIGHT_SHOW", 1);
        public static final BondingDialogState SHOWED = new BondingDialogState("SHOWED", 2);

        private static final /* synthetic */ BondingDialogState[] $values() {
            return new BondingDialogState[]{IDLE, MIGHT_SHOW, SHOWED};
        }

        static {
            BondingDialogState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private BondingDialogState(String str, int r2) {
        }

        public static EnumEntries<BondingDialogState> getEntries() {
            return $ENTRIES;
        }

        public static BondingDialogState valueOf(String str) {
            return (BondingDialogState) Enum.valueOf(BondingDialogState.class, str);
        }

        public static BondingDialogState[] values() {
            return (BondingDialogState[]) $VALUES.clone();
        }
    }

    /* compiled from: Onboarding.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* compiled from: Onboarding.kt */
    /* loaded from: classes3.dex */
    public interface OnboardingChangeListener {
        void foundOneDeviceWhenScanning();

        void onAssociationRequest(IntentSender intentSender);

        void onFailedToConnectToDevice();

        void onInternetConnectivityChanged(boolean z, boolean z2);

        void onOnboardingStateChanged();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: Onboarding.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State BACKGROUND_LOCATION_PERMISSION;
        public static final State BLUETOOTH_ENABLING;
        public static final State CALIBRATION;
        public static final State CALL_PERMISSION;
        public static final State CONNECTED;
        public static final State CONNECTING;
        public static final State DISPLAY_WATCH_TUTORIAL;
        public static final State FINISHED;
        public static final State LOCATION_ENABLING;
        public static final State LOCATION_PERMISSION;
        public static final State PROFILE_SETUP;
        public static final State SCANNING;
        public static final State SIGNIN;
        public static final State SMARTIME_FOUND;
        public static final State SMS_PERMISSION;
        public static final State SPLASH;
        public static final State SYSTEM_NOTIFICATION_PERMISSION;
        public static final State UPDATE_COMPLETED;
        public static final State UPDATE_REQUIRED;
        public static final State WAITING_PRODUCT_INFO;
        public static final State WELCOME;
        public static final State WHATSNEW;
        private final boolean isRequiringInternet;
        public static final State TERMS_OF_USE = new State("TERMS_OF_USE", 0, false, 1, null);
        public static final State PAUSED = new State("PAUSED", 23, false, 1, null);

        private static final /* synthetic */ State[] $values() {
            return new State[]{TERMS_OF_USE, SPLASH, WELCOME, BLUETOOTH_ENABLING, LOCATION_ENABLING, LOCATION_PERMISSION, SCANNING, SMARTIME_FOUND, CONNECTING, UPDATE_REQUIRED, UPDATE_COMPLETED, CONNECTED, CALIBRATION, SYSTEM_NOTIFICATION_PERMISSION, BACKGROUND_LOCATION_PERMISSION, CALL_PERMISSION, SMS_PERMISSION, SIGNIN, PROFILE_SETUP, DISPLAY_WATCH_TUTORIAL, WHATSNEW, WAITING_PRODUCT_INFO, FINISHED, PAUSED};
        }

        static {
            boolean z = false;
            int r11 = 1;
            DefaultConstructorMarker defaultConstructorMarker = null;
            SPLASH = new State("SPLASH", 1, z, r11, defaultConstructorMarker);
            boolean z2 = false;
            int r17 = 1;
            DefaultConstructorMarker defaultConstructorMarker2 = null;
            WELCOME = new State("WELCOME", 2, z2, r17, defaultConstructorMarker2);
            boolean z3 = false;
            int r23 = 1;
            DefaultConstructorMarker defaultConstructorMarker3 = null;
            BLUETOOTH_ENABLING = new State("BLUETOOTH_ENABLING", 3, z3, r23, defaultConstructorMarker3);
            LOCATION_ENABLING = new State("LOCATION_ENABLING", 4, z2, r17, defaultConstructorMarker2);
            LOCATION_PERMISSION = new State("LOCATION_PERMISSION", 5, z3, r23, defaultConstructorMarker3);
            SCANNING = new State("SCANNING", 6, z2, r17, defaultConstructorMarker2);
            SMARTIME_FOUND = new State("SMARTIME_FOUND", 7, z3, r23, defaultConstructorMarker3);
            CONNECTING = new State("CONNECTING", 8, z2, r17, defaultConstructorMarker2);
            UPDATE_REQUIRED = new State("UPDATE_REQUIRED", 9, z3, r23, defaultConstructorMarker3);
            UPDATE_COMPLETED = new State("UPDATE_COMPLETED", 10, z2, r17, defaultConstructorMarker2);
            CONNECTED = new State("CONNECTED", 11, z3, r23, defaultConstructorMarker3);
            CALIBRATION = new State("CALIBRATION", 12, z2, r17, defaultConstructorMarker2);
            SYSTEM_NOTIFICATION_PERMISSION = new State("SYSTEM_NOTIFICATION_PERMISSION", 13, z3, r23, defaultConstructorMarker3);
            BACKGROUND_LOCATION_PERMISSION = new State("BACKGROUND_LOCATION_PERMISSION", 14, z2, r17, defaultConstructorMarker2);
            CALL_PERMISSION = new State("CALL_PERMISSION", 15, z3, r23, defaultConstructorMarker3);
            SMS_PERMISSION = new State("SMS_PERMISSION", 16, z2, r17, defaultConstructorMarker2);
            SIGNIN = new State("SIGNIN", 17, z3, r23, defaultConstructorMarker3);
            PROFILE_SETUP = new State("PROFILE_SETUP", 18, z2, r17, defaultConstructorMarker2);
            DISPLAY_WATCH_TUTORIAL = new State("DISPLAY_WATCH_TUTORIAL", 19, z3, r23, defaultConstructorMarker3);
            WHATSNEW = new State("WHATSNEW", 20, z2, r17, defaultConstructorMarker2);
            WAITING_PRODUCT_INFO = new State("WAITING_PRODUCT_INFO", 21, z3, r23, defaultConstructorMarker3);
            FINISHED = new State("FINISHED", 22, z, r11, defaultConstructorMarker);
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2, boolean z) {
            this.isRequiringInternet = z;
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public final boolean isRequiringInternet() {
            return this.isRequiringInternet;
        }

        public /* synthetic */ State(String str, int r2, boolean z, int r4, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, r2, (r4 & 1) != 0 ? false : z);
        }
    }

    /* compiled from: Onboarding.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[State.values().length];
            try {
                r0[State.SPLASH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[State.WELCOME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[State.SCANNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[State.CONNECTING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[State.WAITING_PRODUCT_INFO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[State.UPDATE_COMPLETED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                r0[State.FINISHED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public Onboarding(BluetoothOnboardingProvider provider, SigninProvider signInProvider, Context context) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(signInProvider, "signInProvider");
        Intrinsics.checkNotNullParameter(context, "context");
        this.provider = provider;
        this.signInProvider = signInProvider;
        this.context = context;
        State state = State.PAUSED;
        this.state = state;
        this.previousState = state;
        this.handledStates = new LinkedHashSet();
        this.handler = new Handler(Looper.getMainLooper());
        this.timerRunnable = new Runnable() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                Onboarding.timerRunnable$lambda$0(Onboarding.this);
            }
        };
        this.connectivityChangedReceiver = new Onboarding$connectivityChangedReceiver$1(this);
        this.watchProviderListener = new BaseWatchProviderListener() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$watchProviderListener$1
            @Override // com.animaconnected.watch.BaseWatchProviderListener, com.animaconnected.watch.WatchProvider.WatchProviderListener
            public void onWroteDeviceSettings() {
                String str;
                str = Onboarding.TAG;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$cp(...)");
                LogKt.debug$default((Object) this, str, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$watchProviderListener$1$onWroteDeviceSettings$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Device settings written. Updating state.";
                    }
                }, 6, (Object) null);
                Onboarding.this.updateState();
            }
        };
        this.profileViewModel$delegate = LazyKt__LazyJVMKt.lazy(new Function0<ProfileViewModel>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$profileViewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ProfileViewModel invoke() {
                FitnessProvider.Profile profile = ProviderFactory.getWatch().fitness().getProfile();
                String bestDateTimePattern = DateFormat.getBestDateTimePattern(ProviderFactory.createConfigProvider().getTranslationCompatibleLocale(), "MMM d, yyyy");
                Intrinsics.checkNotNullExpressionValue(bestDateTimePattern, "getBestDateTimePattern(...)");
                return new ProfileViewModel(profile, new AndroidDateFormatter(bestDateTimePattern, null, 2, null));
            }
        });
        ThreadUtils.assertIsOnMainThread();
        boolean z = context.getResources().getBoolean(R.bool.app_onboarding_smartime_redirect);
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        BrandFilter brandFilter = BrandUtils.getBrandFilter();
        Intrinsics.checkNotNullExpressionValue(brandFilter, "getBrandFilter(...)");
        this.watchScanner = new WatchScanner(context, scope, brandFilter, new Function0<List<? extends HybridDevice>>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends HybridDevice> invoke() {
                List<HybridDevice> onboardedDevices = Onboarding.this.provider.getOnboardedDevices();
                Intrinsics.checkNotNullExpressionValue(onboardedDevices, "getOnboardedDevices(...)");
                return onboardedDevices;
            }
        }, z);
        initWhatsNew();
        this.onIntentResultSuccess = new Function1<Intent, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onIntentResultSuccess$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Intent intent) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Intent intent) {
                invoke2(intent);
                return Unit.INSTANCE;
            }
        };
    }

    private final State calculateNextState() {
        if (this.isPaused) {
            return State.PAUSED;
        }
        if (this.canceled) {
            return State.FINISHED;
        }
        if (isOnboardingFinished()) {
            State state = State.SPLASH;
            if (isNotHandled(state)) {
                return state;
            }
        }
        setHandled$default(this, State.SPLASH, false, 2, null);
        if (!ProviderFactory.getSettingProvider().getTermsAndPolicyAccepted()) {
            return State.TERMS_OF_USE;
        }
        if (!isOnboardingFinished()) {
            State state2 = State.CALIBRATION;
            if (isNotHandled(state2)) {
                State state3 = State.WELCOME;
                if (isNotHandled(state3)) {
                    return state3;
                }
                if (getHasDisplay()) {
                    if (this.isUpdating) {
                        return State.UPDATE_REQUIRED;
                    }
                    if (ProviderFactory.getWatchUpdateProvider().hasUpdateCompletedInfo()) {
                        return State.UPDATE_COMPLETED;
                    }
                }
                if (!isLocationEnabled()) {
                    return State.LOCATION_ENABLING;
                }
                if (isBluetooth12PermissionGranted() && getHasLocationPermission()) {
                    if (!ConnectionFactory.getConnection().isEnabled() && !this.isUpdating) {
                        return State.BLUETOOTH_ENABLING;
                    }
                    if (!this.provider.hasDevice()) {
                        return State.SCANNING;
                    }
                    if (!this.provider.isInUpdateRequired() && !this.provider.isInDfuMode() && ((!this.provider.isConnected() || !getWroteOnboardingDeviceSettings()) && !this.isUpdating)) {
                        return State.CONNECTING;
                    }
                    State state4 = State.CONNECTED;
                    if (isNotHandled(state4)) {
                        return state4;
                    }
                    if (getHasDisplay() && (ProviderFactory.getWatch().isInUpdateRequired() || ProviderFactory.getWatch().isInDfuMode())) {
                        return State.UPDATE_REQUIRED;
                    }
                    if (ProviderFactory.getWatch().isConnected()) {
                        return state2;
                    }
                } else {
                    return State.LOCATION_PERMISSION;
                }
            }
            State state5 = State.SYSTEM_NOTIFICATION_PERMISSION;
            if (isNotHandled(state5) && !OnboardingPermissionKt.arePermissionsGranted(SystemNotificationPermissionFragmentKt.getSystemNotificationPermission())) {
                return state5;
            }
            if (getHasDisplay()) {
                State state6 = State.BACKGROUND_LOCATION_PERMISSION;
                if (isNotHandled(state6) && !OnboardingPermissionKt.arePermissionsGranted(BackgroundLocationPermissionFragmentKt.getLocationPermissions())) {
                    return state6;
                }
                State state7 = State.CALL_PERMISSION;
                if (isNotHandled(state7) && !OnboardingPermissionKt.arePermissionsGranted(CallsPermissionFragmentKt.getCallPermissions())) {
                    return state7;
                }
                State state8 = State.SMS_PERMISSION;
                if (isNotHandled(state8) && !OnboardingPermissionKt.arePermissionsGranted(SmsPermissionFragmentKt.getSmsPermissions())) {
                    return state8;
                }
                if (!this.signInProvider.isSignedIn() && !new SigninStorage(this.context).getNotNow() && AmplifyApiKt.isSignInUiEnabled()) {
                    return State.SIGNIN;
                }
                State state9 = State.PROFILE_SETUP;
                if (isNotHandled(state9)) {
                    return state9;
                }
                State state10 = State.DISPLAY_WATCH_TUTORIAL;
                if (isNotHandled(state10)) {
                    return state10;
                }
            } else if (!this.signInProvider.isSignedIn() && !new SigninStorage(this.context).getNotNow() && AmplifyApiKt.isSignInUiEnabled()) {
                return State.SIGNIN;
            }
        }
        if (WhatsNewStorage.INSTANCE.showWhatsNew()) {
            return State.WHATSNEW;
        }
        State state11 = State.WAITING_PRODUCT_INFO;
        if (isNotHandled(state11)) {
            return state11;
        }
        return State.FINISHED;
    }

    private final void cleanUpAnyPreviousTriedDevice() {
        String previousTriedDevice = getPreviousTriedDevice();
        if (previousTriedDevice != null) {
            try {
                Bonding.getInstance().removeBondFromDevice(previousTriedDevice);
            } catch (Exception e) {
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$cleanUpAnyPreviousTriedDevice$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return String.valueOf(e.getMessage());
                    }
                }, 6, (Object) null);
            }
            savePreviousTriedDevice(null);
        }
    }

    private final void enterState(State state) {
        switch (WhenMappings.$EnumSwitchMapping$0[state.ordinal()]) {
            case 1:
                updateProductInfo();
                break;
            case 2:
                startTimer(2500);
                break;
            case 3:
                ProviderFactory.getWatch().setOnboardingStarted();
                cleanUpAnyPreviousTriedDevice();
                startScan();
                break;
            case 4:
                startConnecting();
                break;
            case 5:
                startTimer(WAITING_PRODUCT_INFO_TIMEOUT_MS);
                break;
            case 6:
                updateProductInfo();
                break;
            case 7:
                ProviderFactory.getWatch().setOnboardingFinished(true);
                WatchProviderAnalytics.sendDevicesAnalytics(ProviderFactory.getWatch(), this.context);
                AnalyticsTrackingProvider.getInstance().stopTrackingFragment();
                break;
        }
        if (state.isRequiringInternet()) {
            this.context.registerReceiver(this.connectivityChangedReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object forgetCurrentDeviceIfNeeded(Continuation<? super Unit> continuation) {
        if (!this.provider.isConnected() && !this.provider.isInDfuMode() && !isDeviceBonded() && !isDeviceAssociated()) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$forgetCurrentDeviceIfNeeded$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Failed to connect. Forgetting device.";
                }
            }, 6, (Object) null);
            Object forgetDevice = ProviderFactory.getWatch().forgetDevice(true, continuation);
            if (forgetDevice == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return forgetDevice;
            }
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final void forgetCurrentDeviceIfNeededThenUpdateState() {
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Onboarding$forgetCurrentDeviceIfNeededThenUpdateState$1(this, null), 3);
    }

    private final boolean getHasLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }

    private final boolean getWroteOnboardingDeviceSettings() {
        return this.provider.getWroteOnboardingDeviceSettings();
    }

    private final void gotoState(final State state) {
        boolean z;
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$gotoState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Changing state: " + Onboarding.this.getState() + " => " + state;
            }
        }, 6, (Object) null);
        State state2 = this.state;
        if (state2 != state) {
            z = true;
        } else {
            z = false;
        }
        leaveState(state2);
        this.state = state;
        enterState(state);
        if (z) {
            OnboardingChangeListener onboardingChangeListener = this.listener;
            if (onboardingChangeListener != null) {
                onboardingChangeListener.onOnboardingStateChanged();
            }
            this.lastKnownInternetAvailable = Internet.INSTANCE.isAvailable();
            OnboardingChangeListener onboardingChangeListener2 = this.listener;
            if (onboardingChangeListener2 != null) {
                onboardingChangeListener2.onInternetConnectivityChanged(state.isRequiringInternet(), this.lastKnownInternetAvailable);
            }
        }
    }

    private final void initWhatsNew() {
        WhatsNewStorage whatsNewStorage = WhatsNewStorage.INSTANCE;
        if (!whatsNewStorage.isSeenBefore() && !isOnboardingFinished()) {
            whatsNewStorage.setSeenBefore(true);
        }
    }

    private final boolean isBluetooth12PermissionGranted() {
        boolean z;
        if (Build.VERSION.SDK_INT < 31) {
            return true;
        }
        List listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"});
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(ContextCompat.checkSelfPermission(this.context, (String) it.next())));
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (((Number) it2.next()).intValue() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private final boolean isDeviceAssociated() {
        Boolean isDeviceAssociated;
        String address = ProviderFactory.getWatch().getAddress();
        if (address != null && (isDeviceAssociated = CompanionDeviceUtils.INSTANCE.isDeviceAssociated(this.context, address)) != null) {
            return isDeviceAssociated.booleanValue();
        }
        return false;
    }

    private final boolean isDeviceBonded() {
        String address = ProviderFactory.getWatch().getAddress();
        if (address != null) {
            return Bonding.getInstance().isDeviceBonded(address);
        }
        return false;
    }

    private final boolean isNotHandled(State state) {
        return !this.handledStates.contains(state);
    }

    private final boolean isOnboardingFinished() {
        return this.provider.isOnboardingFinished();
    }

    private final void leaveState(State state) {
        this.previousState = state;
        int r0 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (r0 != 2) {
            if (r0 != 3) {
                if (r0 != 4) {
                    if (r0 == 5) {
                        stopTimer();
                    }
                } else {
                    stopConnecting();
                }
            } else {
                stopScan();
            }
        } else {
            stopTimer();
        }
        if (state.isRequiringInternet()) {
            this.context.unregisterReceiver(this.connectivityChangedReceiver);
        }
    }

    private final void onTimer() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.state.ordinal()];
        if (r0 != 2) {
            if (r0 != 4) {
                if (r0 == 5) {
                    String TAG2 = TAG;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onTimer$3
                        @Override // kotlin.jvm.functions.Function0
                        public final String invoke() {
                            return "updateProductInfo timed out.";
                        }
                    }, 6, (Object) null);
                    setHandled$default(this, State.WAITING_PRODUCT_INFO, false, 2, null);
                    updateState();
                    return;
                }
                return;
            }
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LogKt.debug$default((Object) this, TAG3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onTimer$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Connecting timed out";
                }
            }, 6, (Object) null);
            forgetCurrentDeviceIfNeededThenUpdateState();
            return;
        }
        String TAG4 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
        LogKt.debug$default((Object) this, TAG4, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onTimer$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Welcome shown. Updating state.";
            }
        }, 6, (Object) null);
        setHandled$default(this, State.WELCOME, false, 2, null);
        updateState();
    }

    private final void savePreviousTriedDevice(String str) {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SHARED_PREFS_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(PREFS_KEY_PREVIOUS_ONBOARDED_DEVICE, str);
        edit.apply();
    }

    private final void setDevice(HybridDevice hybridDevice) {
        savePreviousTriedDevice(hybridDevice.getAddress());
        this.provider.onboardDevice(hybridDevice);
    }

    public static /* synthetic */ boolean setHandled$default(Onboarding onboarding, State state, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = true;
        }
        return onboarding.setHandled(state, z);
    }

    private final void startConnecting() {
        this.provider.registerDeviceConnectionListener(this);
        ProviderFactory.getWatch().registerListener(this.watchProviderListener);
        ProviderFactory.getWatch().registerOnboardingConnectionListener(this);
        if (this.provider.isConnected() && getWroteOnboardingDeviceSettings() && !this.provider.isInDfuMode()) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$startConnecting$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Already connected. Updating state.";
                }
            }, 6, (Object) null);
            updateState();
        }
        startTimer(CONNECTING_TIMEOUT_MS);
    }

    private final void startScan() {
        this.watchScanner.setListener(this);
        this.watchScanner.startScan();
    }

    private final void startTimer(int r5) {
        this.handler.removeCallbacks(this.timerRunnable);
        this.handler.postDelayed(this.timerRunnable, r5);
    }

    private final void stopConnecting() {
        this.provider.unregisterDeviceConnectionListener(this);
        ProviderFactory.getWatch().unregisterListener(this.watchProviderListener);
        ProviderFactory.getWatch().unRegisterOnboardingConnectionListener(this);
        stopTimer();
        BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Onboarding$stopConnecting$1(this, null), 3);
    }

    private final void stopScan() {
        this.watchScanner.setListener(null);
    }

    private final void stopTimer() {
        this.handler.removeCallbacks(this.timerRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void timerRunnable$lambda$0(Onboarding this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onTimer();
    }

    private final void updateProductInfo() {
        if (!this.updateProductInfoStarted) {
            this.updateProductInfoStarted = true;
            BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Onboarding$updateProductInfo$1(this, null), 3);
        }
    }

    public final void addEmulatedWatch(EmulatorInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        onDeviceFound(new HybridDevice(info.getAddress(), 50, info.getDeviceType(), null, 8, null));
    }

    @Override // com.animaconnected.bluetooth.gatt.OnboardingConnectionListener
    public Object associateDevice(String str, Continuation<? super Boolean> continuation) {
        return CompanionDeviceUtils.INSTANCE.associateDevice(this.context, str, new Function2<IntentSender, Function1<? super Intent, ? extends Unit>, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$associateDevice$2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntentSender intentSender, Function1<? super Intent, ? extends Unit> function1) {
                invoke2(intentSender, (Function1<? super Intent, Unit>) function1);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntentSender intentSender, Function1<? super Intent, Unit> onIntentResultSuccess) {
                Intrinsics.checkNotNullParameter(intentSender, "intentSender");
                Intrinsics.checkNotNullParameter(onIntentResultSuccess, "onIntentResultSuccess");
                Onboarding.this.setOnIntentResultSuccess(onIntentResultSuccess);
                Onboarding.OnboardingChangeListener listener = Onboarding.this.getListener();
                if (listener != null) {
                    listener.onAssociationRequest(intentSender);
                }
            }
        }, continuation);
    }

    public final Unit associationResult(Intent intent) {
        if (intent != null) {
            this.onIntentResultSuccess.invoke(intent);
            return Unit.INSTANCE;
        }
        return null;
    }

    public final void cancelOnboarding() {
        HybridDevice currentOnboardedDevice = this.provider.getCurrentOnboardedDevice();
        if (currentOnboardedDevice == null) {
            return;
        }
        ProviderFactory.getAppAnalytics().sendAction("onboarding_cancel");
        this.provider.onboardDevice(currentOnboardedDevice);
        OnboardingStorage.INSTANCE.setHasShowedWhatIsNewAnimation(this.context, true);
        this.canceled = true;
        updateState();
    }

    public final void cancelSmarTimeRedirect() {
        this.foundSmarTimeDevice = null;
        if (getHasOnboardedDevice()) {
            cancelOnboarding();
            return;
        }
        ProviderFactory.getSettingProvider().setTermsAndPolicyAccepted(false);
        ProviderFactory.createSigninProvider().setSignedIn(false);
        updateState();
    }

    @Override // com.animaconnected.bluetooth.gatt.OnboardingConnectionListener
    public void expectingForegroundDialog(boolean z) {
        this.expectingForegroundDialogs = z;
    }

    public final boolean getHasDisplay() {
        return ProviderFactory.getWatch().getWatch().getHasDisplay();
    }

    public final boolean getHasOnboardedDevice() {
        if (this.provider.getCurrentOnboardedDevice() != null) {
            return true;
        }
        return false;
    }

    public final boolean getHasOneDeviceBeenFound() {
        return this.watchScanner.getOneDeviceFound();
    }

    public final OnboardingChangeListener getListener() {
        return this.listener;
    }

    public final Function1<Intent, Unit> getOnIntentResultSuccess() {
        return this.onIntentResultSuccess;
    }

    public final State getPreviousState() {
        return this.previousState;
    }

    public final String getPreviousTriedDevice() {
        return this.context.getSharedPreferences(SHARED_PREFS_NAME, 0).getString(PREFS_KEY_PREVIOUS_ONBOARDED_DEVICE, null);
    }

    public final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel$delegate.getValue();
    }

    public final State getState() {
        return this.state;
    }

    public final boolean isLocationEnabled() {
        try {
            if (Settings.Secure.getInt(this.context.getContentResolver(), "location_mode") != 0) {
                return true;
            }
            return false;
        } catch (Settings.SettingNotFoundException unused) {
            Log.w(TAG, "Failed to get location settings. Assuming that it's on.");
            return true;
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onConnected$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Connected. Updating state.";
            }
        }, 6, (Object) null);
        updateProductInfo();
        updateState();
    }

    @Override // com.animaconnected.bluetooth.device.scanner.WatchScanner.WatchScannerListener
    public void onDeviceFound(ScannedDevice scannedDevice) {
        if (scannedDevice != null) {
            OnboardingChangeListener onboardingChangeListener = this.listener;
            if (onboardingChangeListener != null) {
                onboardingChangeListener.foundOneDeviceWhenScanning();
            }
            if (scannedDevice instanceof HybridDevice) {
                setDevice((HybridDevice) scannedDevice);
                String TAG2 = TAG;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onDeviceFound$1
                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return "Continuing to next state after setting device";
                    }
                }, 6, (Object) null);
            } else if (scannedDevice instanceof SmarTimeDevice) {
                SmarTimeDevice smarTimeDevice = (SmarTimeDevice) scannedDevice;
                if (smarTimeDevice.getBrand() == SmarTimeBrand.Lotus) {
                    this.foundSmarTimeDevice = smarTimeDevice;
                }
            }
        } else {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LogKt.debug$default((Object) this, TAG3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onDeviceFound$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Scan didn't find any device, scan again";
                }
            }, 6, (Object) null);
        }
        updateState();
    }

    @Override // com.animaconnected.bluetooth.gatt.OnboardingConnectionListener
    public void onDisconnectDuringOnboarding() {
        OnboardingChangeListener onboardingChangeListener = this.listener;
        if (onboardingChangeListener != null) {
            onboardingChangeListener.onFailedToConnectToDevice();
        }
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onDisconnectDuringOnboarding$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Connecting to the device failed. Forget the device and scan again";
            }
        }, 6, (Object) null);
        savePreviousTriedDevice(null);
        stopTimer();
        forgetCurrentDeviceIfNeededThenUpdateState();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onEnterDfuMode$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Connected (DFU mode). Updating state.";
            }
        }, 6, (Object) null);
        updateState();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        updateState();
    }

    public final void onLocationEnabled() {
        String TAG2 = TAG;
        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
        LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$onLocationEnabled$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Location has been enabled. Updating state.";
            }
        }, 6, (Object) null);
        updateState();
    }

    public final void onUpdateCompleted() {
        this.isUpdating = false;
        updateState();
    }

    public final void onUpdateStarted() {
        this.isUpdating = true;
    }

    public final void pause() {
        if (this.expectingForegroundDialogs) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$pause$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dialog is expected to be showing, don't update state";
                }
            }, 6, (Object) null);
        } else {
            this.isPaused = true;
            setHandled(State.CONNECTED, false);
        }
    }

    public final void resume() {
        this.isPaused = false;
        if (this.expectingForegroundDialogs) {
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            LogKt.debug$default((Object) this, TAG2, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$resume$1
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Dialog is expected to be showing, don't update state";
                }
            }, 6, (Object) null);
        } else {
            String TAG3 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            LogKt.debug$default((Object) this, TAG3, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.onboarding.Onboarding$resume$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Resuming. Updating state.";
                }
            }, 6, (Object) null);
            updateState();
        }
    }

    public final Job setCalibrationDone() {
        return BuildersKt.launch$default(KronabyApplication.Companion.getScope(), null, null, new Onboarding$setCalibrationDone$1(this, null), 3);
    }

    public final void setConnectedScreenDone() {
        savePreviousTriedDevice(null);
        setHandled$default(this, State.CONNECTED, false, 2, null);
        updateState();
    }

    public final boolean setHandled(State state, boolean z) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (z) {
            return this.handledStates.add(state);
        }
        return this.handledStates.remove(state);
    }

    public final void setListener(OnboardingChangeListener onboardingChangeListener) {
        this.listener = onboardingChangeListener;
    }

    public final void setOnIntentResultSuccess(Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.onIntentResultSuccess = function1;
    }

    public final void setSplashDone() {
        setHandled$default(this, State.SPLASH, false, 2, null);
        updateState();
    }

    public final void setWhatsNewDone() {
        WhatsNewStorage.INSTANCE.setSeenBefore(true);
        updateState();
    }

    public final void updateInternetConnectivityEnabled(boolean z) {
        boolean isAvailable = Internet.INSTANCE.isAvailable();
        if (isAvailable != this.lastKnownInternetAvailable || z) {
            this.lastKnownInternetAvailable = isAvailable;
            OnboardingChangeListener onboardingChangeListener = this.listener;
            if (onboardingChangeListener != null) {
                onboardingChangeListener.onInternetConnectivityChanged(this.state.isRequiringInternet(), this.lastKnownInternetAvailable);
            }
        }
    }

    public final void updateState() {
        gotoState(calculateNextState());
    }
}
