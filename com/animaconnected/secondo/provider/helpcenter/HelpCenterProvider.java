package com.animaconnected.secondo.provider.helpcenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.StatusProvider;
import com.animaconnected.secondo.screens.helpcenter.HelpCenterStateChangedListener;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public class HelpCenterProvider {
    private static final String ANALYTICS_BT_TOGGLE_BUTTON_TAPPED = "hc_bt_tapped";
    private static final String ANALYTICS_BT_TOGGLE_TROUGH_SETTINGS = "hc_bt_settings";
    private static final String ANALYTICS_BT_TOGGLE_WORKED = "hc_bt_worked";
    private static final String ANALYTICS_FAQ_HELP_CENTER_TAPPED = "hc_faq_tapped";
    public static final String ANALYTICS_FAQ_ONBOARDING_TAPPED = "onboarding_faq_tapped";
    private static final String ANALYTICS_HELP_CENTER_DISMISSED = "hc_ts_dismissed";
    private static final String ANALYTICS_HELP_CENTER_TAPPED = "hc_ts_tapped";
    private static final String TAG = "HelpCenterProvider";
    private static final int WAIT_UNTIL_SHOW_FAQ_MS = 45000;
    private static final int WAIT_UNTIL_SHOW_GUIDE_MS = 25000;

    @SuppressLint({"StaticFieldLeak"})
    private static HelpCenterProvider sInstance;
    private final AppEvents mAnalytics;
    private final DeviceConnectionListener mDeviceConnectionListener;
    private boolean mHasAlreadyToggledBluetooth;
    private boolean mIsInForeground;
    private HelpState mState;
    private final StatusProvider mStatusProvider;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final Set<HelpCenterStateChangedListener> mListeners = new CopyOnWriteArraySet();
    private final Runnable mShowStartGuideRunnable = new Runnable() { // from class: com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            HelpCenterProvider.this.lambda$new$0();
        }
    };
    private final Runnable mShowFAQInstructionsRunnable = new Runnable() { // from class: com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider$$ExternalSyntheticLambda2
        @Override // java.lang.Runnable
        public final void run() {
            HelpCenterProvider.this.lambda$new$1();
        }
    };

    /* renamed from: com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState;

        static {
            int[] r0 = new int[HelpState.values().length];
            $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState = r0;
            try {
                r0[HelpState.DISCONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.BT_TOGGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.CONNECTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.GUIDE_INSTRUCTIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.BT_TOGGLE_INSTRUCTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.FAQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[HelpState.BT_TOGGLE_WORKED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public enum HelpState {
        CONNECTING,
        CONNECTED,
        DISCONNECTED,
        START_GUIDE,
        GUIDE_INSTRUCTIONS,
        BT_TOGGLE_INSTRUCTIONS,
        BT_TOGGLE,
        FAQ_INSTRUCTIONS,
        FAQ,
        BT_TOGGLE_WORKED
    }

    public HelpCenterProvider(Context context, StatusProvider statusProvider, WatchProvider watchProvider) {
        DeviceConnectionListener deviceConnectionListener = new DeviceConnectionListener() { // from class: com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider.1
            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onConnected() {
                HelpCenterProvider.this.onDeviceConnected();
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onConnecting() {
                if (HelpCenterProvider.this.mState == HelpState.CONNECTED || HelpCenterProvider.this.mState == HelpState.DISCONNECTED) {
                    HelpCenterProvider.this.mHandler.removeCallbacks(HelpCenterProvider.this.mShowStartGuideRunnable);
                    HelpCenterProvider.this.gotoState(HelpState.CONNECTING);
                }
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onDisconnected() {
                if ((HelpCenterProvider.this.mState == HelpState.CONNECTING || HelpCenterProvider.this.mState == HelpState.CONNECTED) && ConnectionFactory.getConnection().isEnabled()) {
                    HelpCenterProvider.this.gotoState(HelpState.DISCONNECTED);
                }
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onEnterDfuMode() {
                HelpCenterProvider.this.onDeviceConnected();
            }

            @Override // com.animaconnected.watch.device.DeviceConnectionListener
            public void onEnterUpdateRequired() {
                HelpCenterProvider.this.onDeviceConnected();
            }
        };
        this.mDeviceConnectionListener = deviceConnectionListener;
        this.mStatusProvider = statusProvider;
        this.mAnalytics = ProviderFactory.getAppAnalytics();
        gotoState(HelpState.DISCONNECTED);
        watchProvider.registerDeviceConnectionListener(deviceConnectionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gotoState(HelpState helpState) {
        Log.d(TAG, "Old: " + this.mState + " -> New: " + helpState);
        HelpState helpState2 = this.mState;
        this.mState = helpState;
        notifyStateChanged(helpState2, helpState);
        switch (AnonymousClass2.$SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[this.mState.ordinal()]) {
            case 1:
                this.mStatusProvider.muteStatus(false);
                if (this.mIsInForeground) {
                    this.mHandler.postDelayed(this.mShowStartGuideRunnable, 25000L);
                    this.mHandler.removeCallbacks(this.mShowFAQInstructionsRunnable);
                    return;
                }
                return;
            case 2:
                if (!this.mHasAlreadyToggledBluetooth) {
                    ConnectionFactory.getConnection().toggle();
                }
                this.mAnalytics.sendAction(ANALYTICS_BT_TOGGLE_BUTTON_TAPPED);
                return;
            case 3:
                this.mStatusProvider.muteStatus(false);
                return;
            case 4:
                this.mAnalytics.sendAction(ANALYTICS_HELP_CENTER_TAPPED);
                this.mStatusProvider.muteStatus(true);
                return;
            case 5:
                this.mHasAlreadyToggledBluetooth = false;
                ConnectionFactory.getConnection().waitForToggle(new Function0() { // from class: com.animaconnected.secondo.provider.helpcenter.HelpCenterProvider$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit lambda$gotoState$2;
                        lambda$gotoState$2 = HelpCenterProvider.this.lambda$gotoState$2();
                        return lambda$gotoState$2;
                    }
                });
                return;
            case 6:
                this.mAnalytics.sendAction(ANALYTICS_FAQ_HELP_CENTER_TAPPED);
                gotoState(HelpState.DISCONNECTED);
                return;
            case 7:
                this.mAnalytics.sendAction(ANALYTICS_BT_TOGGLE_WORKED);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$gotoState$2() {
        if (this.mState == HelpState.BT_TOGGLE_INSTRUCTIONS) {
            this.mHasAlreadyToggledBluetooth = true;
            this.mAnalytics.sendAction(ANALYTICS_BT_TOGGLE_TROUGH_SETTINGS);
            goToNextState();
        }
        this.mHandler.postDelayed(this.mShowFAQInstructionsRunnable, 45000L);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        gotoState(HelpState.START_GUIDE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        gotoState(HelpState.FAQ_INSTRUCTIONS);
    }

    private void notifyStateChanged(HelpState helpState, HelpState helpState2) {
        Iterator<HelpCenterStateChangedListener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(helpState, helpState2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDeviceConnected() {
        this.mHandler.removeCallbacks(this.mShowStartGuideRunnable);
        this.mHandler.removeCallbacks(this.mShowFAQInstructionsRunnable);
        if (this.mState == HelpState.BT_TOGGLE && this.mIsInForeground) {
            gotoState(HelpState.BT_TOGGLE_WORKED);
        } else {
            gotoState(HelpState.CONNECTED);
        }
    }

    public HelpState getCurrentState() {
        return this.mState;
    }

    public void goToNextState() {
        if (this.mState == HelpState.BT_TOGGLE_WORKED) {
            gotoState(HelpState.CONNECTED);
        } else {
            gotoState(HelpState.values()[this.mState.ordinal() + 1]);
        }
    }

    public boolean hasUserConnectedInBackground() {
        if (this.mState == HelpState.CONNECTED) {
            return true;
        }
        return false;
    }

    public void onDialogDismissed() {
        this.mStatusProvider.muteStatus(false);
        this.mAnalytics.sendAction(ANALYTICS_HELP_CENTER_DISMISSED);
        gotoState(HelpState.START_GUIDE);
    }

    public void onPause() {
        if (this.mIsInForeground) {
            this.mHandler.removeCallbacks(this.mShowStartGuideRunnable);
            this.mHandler.removeCallbacks(this.mShowFAQInstructionsRunnable);
        }
        this.mIsInForeground = false;
    }

    public void onResume() {
        if (!this.mIsInForeground) {
            int r0 = AnonymousClass2.$SwitchMap$com$animaconnected$secondo$provider$helpcenter$HelpCenterProvider$HelpState[this.mState.ordinal()];
            if (r0 != 1) {
                if (r0 == 2) {
                    this.mHandler.postDelayed(this.mShowFAQInstructionsRunnable, 12500L);
                }
            } else {
                this.mHandler.postDelayed(this.mShowStartGuideRunnable, 25000L);
            }
        }
        this.mIsInForeground = true;
    }

    public void registerHelpCenterListener(HelpCenterStateChangedListener helpCenterStateChangedListener) {
        this.mListeners.add(helpCenterStateChangedListener);
    }

    public void unregisterHelpCenterListener(HelpCenterStateChangedListener helpCenterStateChangedListener) {
        this.mListeners.remove(helpCenterStateChangedListener);
    }
}
