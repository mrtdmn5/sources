package com.animaconnected.secondo.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import com.animaconnected.logger.LogKt;
import com.animaconnected.secondo.app.NotificationHandler;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.status.internal.app.PowerOptimizationStatusController;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForegroundServiceUtils.kt */
/* loaded from: classes3.dex */
public final class ForegroundServiceUtils {
    public static final int $stable = 0;
    public static final ForegroundServiceUtils INSTANCE = new ForegroundServiceUtils();

    private ForegroundServiceUtils() {
    }

    private final Boolean isCurrentDeviceAssociated(Context context) {
        return CompanionDeviceUtils.INSTANCE.isDeviceAssociated(context, ProviderFactory.getWatch().getWatch().getIdentifier());
    }

    private final Boolean isIgnoringBatteryOptimizations(Context context) {
        PowerManager powerManager;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        Object systemService = context.getSystemService("power");
        if (systemService instanceof PowerManager) {
            powerManager = (PowerManager) systemService;
        } else {
            powerManager = null;
        }
        if (powerManager == null) {
            return null;
        }
        return Boolean.valueOf(powerManager.isIgnoringBatteryOptimizations(context.getPackageName()));
    }

    public static /* synthetic */ void sendForegroundStartAnalytics$default(ForegroundServiceUtils foregroundServiceUtils, Context context, String str, boolean z, String str2, int r5, Object obj) {
        if ((r5 & 8) != 0) {
            str2 = null;
        }
        foregroundServiceUtils.sendForegroundStartAnalytics(context, str, z, str2);
    }

    public final void handleStartForegroundServiceException(String tag, Exception e, Context context) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(context, "context");
        if (Build.VERSION.SDK_INT < 31) {
            return;
        }
        if (!(e instanceof SecurityException) && !ForegroundServiceUtils$$ExternalSyntheticApiModelOutline0.m(e)) {
            return;
        }
        LogKt.debug$default((Object) this, tag, (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.ForegroundServiceUtils$handleStartForegroundServiceException$1
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Can't start from background";
            }
        }, 6, (Object) null);
        PowerOptimizationStatusController powerOptimizationController = ProviderFactory.getStatusProvider().getPowerOptimizationController();
        if (powerOptimizationController == null) {
            LogKt.debug$default((Object) this, tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.ForegroundServiceUtils$handleStartForegroundServiceException$2
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "No controller, can't fix";
                }
            }, 2, (Object) null);
            return;
        }
        powerOptimizationController.setHasFailedForegroundService(true);
        if (!powerOptimizationController.isIgnoringBatteryOptimizations()) {
            LogKt.info$default((Object) this, tag, (Throwable) null, true, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.utils.ForegroundServiceUtils$handleStartForegroundServiceException$3
                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Battery optimisations still on, ask to ignore";
                }
            }, 2, (Object) null);
            NotificationHandler.showPowerNotification(context);
        }
    }

    public final void sendForegroundStartAnalytics(Context context, String service, boolean z, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        try {
            ProviderFactory.getAppAnalytics().sendForegroundStart(service, z, isCurrentDeviceAssociated(context), isIgnoringBatteryOptimizations(context), str);
        } catch (Exception e) {
            LogKt.err$default((Object) this, "Failed to send ForegroundServiceAnalytics", (String) null, (Throwable) e, true, 2, (Object) null);
        }
    }
}
