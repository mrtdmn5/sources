package com.animaconnected.watch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallHelper.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class CallHelper {
    public static final int $stable;
    private static final String MUTE_PREFIX = "mute_call_";
    private static final String NOT_SUPPORTED = "Reject call not supported by platform";
    private static final String REJECT_PREFIX = "reject_call_";
    private static final String SHOULD_MUTE = "should_mute";
    private static final Context context;
    private static boolean hasMutedCall;
    private static final SharedPreferences prefs;
    private static int ringerMode;
    private static int ringerVolume;
    public static final CallHelper INSTANCE = new CallHelper();
    private static final AppEvents analytics = ProviderFactory.getAppAnalytics();

    static {
        Context context2 = KronabyApplication.Companion.getContext();
        context = context2;
        prefs = context2.getSharedPreferences("call_preferences", 0);
        $stable = 8;
    }

    private CallHelper() {
    }

    private final boolean endCall() {
        boolean endCall;
        Object systemService = KronabyApplication.Companion.getContext().getSystemService("telecom");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        TelecomManager telecomManager = (TelecomManager) systemService;
        if (canEndCalls()) {
            endCall = telecomManager.endCall();
            return endCall;
        }
        return false;
    }

    private final boolean endCallFallback() {
        try {
            LogKt.debug$default((Object) this, "Reject call", (String) null, (Throwable) null, false, 14, (Object) null);
            Object systemService = context.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getITelephony", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke((TelephonyManager) systemService, new Object[0]);
            invoke.getClass().getDeclaredMethod("endCall", new Class[0]).invoke(invoke, new Object[0]);
            analytics.sendAction("reject_call_success");
            return true;
        } catch (Exception e) {
            LogKt.err$default((Object) this, NOT_SUPPORTED, (String) null, (Throwable) e, false, 10, (Object) null);
            analytics.sendAction("reject_call_failed");
            return false;
        }
    }

    private final void muteCall() {
        hasMutedCall = true;
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            analytics.sendAction("mute_call_failed - no audio manager");
            return;
        }
        ringerVolume = audioManager.getStreamVolume(2);
        ringerMode = audioManager.getRingerMode();
        try {
            audioManager.setStreamVolume(2, 0, 0);
            audioManager.adjustStreamVolume(2, -100, 0);
            audioManager.setRingerMode(0);
            analytics.sendAction("mute_call_success");
            LogKt.debug$default((Object) this, "Mute call", (String) null, (Throwable) null, false, 14, (Object) null);
        } catch (SecurityException unused) {
            analytics.sendAction("mute_call_failed - permission missing");
        }
    }

    public static final boolean shouldMuteCalls() {
        boolean z;
        SharedPreferences sharedPreferences = prefs;
        if (Build.VERSION.SDK_INT > 28) {
            z = true;
        } else {
            z = false;
        }
        return sharedPreferences.getBoolean(SHOULD_MUTE, z);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean answerCall() {
        Object systemService = KronabyApplication.Companion.getContext().getSystemService("telecom");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telecom.TelecomManager");
        TelecomManager telecomManager = (TelecomManager) systemService;
        if (PermissionCompat.INSTANCE.isPermissionGranted("android.permission.ANSWER_PHONE_CALLS")) {
            telecomManager.acceptRingingCall();
            return true;
        }
        return false;
    }

    public final boolean canAnswerCalls() {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        return PermissionCompat.INSTANCE.isPermissionGranted("android.permission.ANSWER_PHONE_CALLS");
    }

    public final boolean canEndCalls() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        return PermissionCompat.INSTANCE.isPermissionGranted("android.permission.ANSWER_PHONE_CALLS");
    }

    public final void dismissCall() {
        if (endCall()) {
            LogKt.debug$default((Object) this, "Call successfully ended", (String) null, (Throwable) null, false, 14, (Object) null);
            return;
        }
        if (shouldMuteCalls()) {
            muteCall();
            return;
        }
        if (endCallFallback()) {
            LogKt.debug$default((Object) this, "Call successfully rejected", (String) null, (Throwable) null, false, 14, (Object) null);
            return;
        }
        SharedPreferences prefs2 = prefs;
        Intrinsics.checkNotNullExpressionValue(prefs2, "prefs");
        SharedPreferences.Editor edit = prefs2.edit();
        edit.putBoolean(SHOULD_MUTE, true);
        edit.apply();
        muteCall();
    }

    public final void revertMuteIfNeeded() {
        AudioManager audioManager;
        if (!hasMutedCall) {
            return;
        }
        hasMutedCall = false;
        try {
            audioManager = (AudioManager) context.getSystemService("audio");
        } catch (SecurityException unused) {
            LogKt.debug$default((Object) this, "No volume handling, missing permission", (String) null, (Throwable) null, false, 14, (Object) null);
        }
        if (audioManager == null) {
            return;
        }
        audioManager.adjustStreamVolume(2, 100, 0);
        audioManager.setStreamVolume(2, ringerVolume, 0);
        audioManager.setRingerMode(ringerMode);
        LogKt.debug$default((Object) this, "Call ended, revert to previous settings", (String) null, (Throwable) null, false, 14, (Object) null);
    }
}
