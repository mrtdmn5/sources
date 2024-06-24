package com.animaconnected.secondo.behaviour.music;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import com.animaconnected.bluetooth.profile.InputDeviceConnector;
import com.animaconnected.bluetooth.util.Connection;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.ButtonAction;
import com.animaconnected.watch.device.DeviceConnectionListener;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MusicProvider.kt */
/* loaded from: classes3.dex */
public final class MusicProvider implements DeviceConnectionListener {
    public static final int $stable;
    public static final MusicProvider INSTANCE;
    private static final long START_DELAY_BETWEEN_VOLUME_UPDATE = 1000;
    private static final String TAG;
    private static final long TIMEOUT_ON_VOLUME_UPDATE = 20000;
    private static final Context appContext;
    private static final AudioManager audioManager;
    private static final Runnable controlVolumeRunnable;
    private static final Runnable controlVolumeTimeOutRunnable;
    private static boolean controllingVolume;
    private static long delayVolume;
    private static final Handler handler;
    private static boolean hasTestedHidSolution;
    private static final int maxStreamVolume;
    private static int streamVolume;
    private static VolumeDirection volumeDirection;

    @SuppressLint({"StaticFieldLeak"})
    private static final WatchProvider watch;

    /* compiled from: MusicProvider.kt */
    /* loaded from: classes3.dex */
    public static final class VolumeDirection extends Enum<VolumeDirection> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ VolumeDirection[] $VALUES;
        public static final VolumeDirection RAISE = new VolumeDirection("RAISE", 0);
        public static final VolumeDirection LOWER = new VolumeDirection("LOWER", 1);

        private static final /* synthetic */ VolumeDirection[] $values() {
            return new VolumeDirection[]{RAISE, LOWER};
        }

        static {
            VolumeDirection[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private VolumeDirection(String str, int r2) {
            super(str, r2);
        }

        public static EnumEntries<VolumeDirection> getEntries() {
            return $ENTRIES;
        }

        public static VolumeDirection valueOf(String str) {
            return (VolumeDirection) Enum.valueOf(VolumeDirection.class, str);
        }

        public static VolumeDirection[] values() {
            return (VolumeDirection[]) $VALUES.clone();
        }
    }

    /* compiled from: MusicProvider.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ButtonAction.values().length];
            try {
                r0[ButtonAction.Press.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ButtonAction.DoublePress.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ButtonAction.TriplePress.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[ButtonAction.DoubleLongPress.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[ButtonAction.TripleLongPress.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[ButtonAction.LongPressRelease.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        MusicProvider musicProvider = new MusicProvider();
        INSTANCE = musicProvider;
        TAG = "MusicProvider";
        Context context = KronabyApplication.Companion.getContext();
        appContext = context;
        Object systemService = context.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        AudioManager audioManager2 = (AudioManager) systemService;
        audioManager = audioManager2;
        WatchProvider watch2 = ProviderFactory.getWatch();
        watch = watch2;
        watch2.registerDeviceConnectionListener(musicProvider);
        handler = new Handler(Looper.getMainLooper());
        maxStreamVolume = audioManager2.getStreamMaxVolume(3);
        delayVolume = START_DELAY_BETWEEN_VOLUME_UPDATE;
        controlVolumeRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.music.MusicProvider$controlVolumeRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                Handler handler2;
                long j;
                MusicProvider.INSTANCE.adjustVolume();
                handler2 = MusicProvider.handler;
                j = MusicProvider.delayVolume;
                handler2.postDelayed(this, j);
            }
        };
        controlVolumeTimeOutRunnable = new Runnable() { // from class: com.animaconnected.secondo.behaviour.music.MusicProvider$controlVolumeTimeOutRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                String str;
                Handler handler2;
                str = MusicProvider.TAG;
                Log.d(str, "Timeout triggered");
                MusicProvider.INSTANCE.stopVolumeControl();
                handler2 = MusicProvider.handler;
                handler2.postDelayed(this, 20000L);
            }
        };
        $stable = 8;
    }

    private MusicProvider() {
    }

    public final void adjustVolume() {
        if (volumeDirection == VolumeDirection.RAISE) {
            int r0 = streamVolume;
            if (r0 < maxStreamVolume) {
                streamVolume = r0 + 1;
            }
        } else {
            int r02 = streamVolume;
            if (r02 > 0) {
                streamVolume = r02 - 1;
            }
        }
        Log.d(TAG, "New volume: " + streamVolume);
        audioManager.setStreamVolume(3, streamVolume, 0);
    }

    public static final boolean shouldShowVolumeControlDescription() {
        if (!INSTANCE.hasButtonActionLongPressReleaseNotify()) {
            WatchProvider watchProvider = watch;
            if (!watchProvider.getUseHidForMusic() || !watchProvider.getCapabilities().getHasVolumeUpDownViaHid()) {
                return false;
            }
        }
        return true;
    }

    private final void startVolumeControl(VolumeDirection volumeDirection2) {
        long j;
        if (!controllingVolume) {
            controllingVolume = true;
            volumeDirection = volumeDirection2;
            streamVolume = audioManager.getStreamVolume(3);
            Log.d(TAG, "Start volume control: " + volumeDirection2);
            adjustVolume();
            if (volumeDirection == VolumeDirection.LOWER) {
                if (streamVolume >= maxStreamVolume * 0.7d) {
                    j = 333;
                } else {
                    j = 1000;
                }
                delayVolume = j;
            }
            Handler handler2 = handler;
            handler2.postDelayed(controlVolumeRunnable, delayVolume);
            handler2.postDelayed(controlVolumeTimeOutRunnable, TIMEOUT_ON_VOLUME_UPDATE);
            if (delayVolume >= START_DELAY_BETWEEN_VOLUME_UPDATE) {
                delayVolume = 500L;
            }
        }
    }

    public final void checkIfHIDSolutionWorks() {
        String str;
        if (!hasTestedHidSolution) {
            Connection connection = ConnectionFactory.getConnection();
            String address = ProviderFactory.getWatch().getAddress();
            Intrinsics.checkNotNull(address);
            BluetoothDevice device = connection.device(address);
            if (device == null) {
                return;
            }
            boolean isHIDConnected = InputDeviceConnector.getInstance().isHIDConnected(device);
            AppEvents appAnalytics = ProviderFactory.getAppAnalytics();
            if (isHIDConnected) {
                str = "music_fallback_off";
            } else {
                str = "music_fallback_on";
            }
            appAnalytics.sendAction(str);
            watch.setUseHidForMusic(isHIDConnected);
            hasTestedHidSolution = true;
        }
    }

    public final boolean hasButtonActionLongPressReleaseNotify() {
        return watch.getCapabilities().hasButtonActionLongPressReleaseNotify();
    }

    public final boolean isNonHIDMusicControllerActive() {
        if (!hasButtonActionLongPressReleaseNotify() && watch.getUseHidForMusic()) {
            return false;
        }
        return true;
    }

    public final void nonHIDMusicController(ButtonAction action) {
        int r1;
        Intrinsics.checkNotNullParameter(action, "action");
        int[] r0 = WhenMappings.$EnumSwitchMapping$0;
        int r12 = r0[action.ordinal()];
        if (r12 != 1) {
            if (r12 != 2) {
                if (r12 != 3) {
                    r1 = -1;
                } else {
                    r1 = 88;
                }
            } else {
                r1 = 87;
            }
        } else {
            r1 = 85;
        }
        if (hasButtonActionLongPressReleaseNotify()) {
            int r6 = r0[action.ordinal()];
            if (r6 != 4) {
                if (r6 != 5) {
                    if (r6 == 6) {
                        stopVolumeControl();
                    }
                } else {
                    startVolumeControl(VolumeDirection.LOWER);
                }
            } else {
                startVolumeControl(VolumeDirection.RAISE);
            }
        }
        if (r1 != -1) {
            stopVolumeControl();
            KeyEvent keyEvent = new KeyEvent(0, r1);
            AudioManager audioManager2 = audioManager;
            audioManager2.dispatchMediaKeyEvent(keyEvent);
            audioManager2.dispatchMediaKeyEvent(new KeyEvent(1, r1));
        }
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        hasTestedHidSolution = false;
        stopVolumeControl();
    }

    public final void revertSettings() {
        hasTestedHidSolution = false;
        watch.setUseHidForMusic(false);
    }

    public final void stopVolumeControl() {
        if (controllingVolume) {
            controllingVolume = false;
            Log.d(TAG, "Stop volume control: " + volumeDirection);
            delayVolume = START_DELAY_BETWEEN_VOLUME_UPDATE;
            Handler handler2 = handler;
            handler2.removeCallbacks(controlVolumeRunnable);
            handler2.removeCallbacks(controlVolumeTimeOutRunnable);
        }
    }
}
