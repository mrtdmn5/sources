package com.animaconnected.secondo.provider.status.internal.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.PowerManager;
import com.animaconnected.secondo.provider.status.PowerOptimizationStatus;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.secondo.provider.status.StatusModel;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PowerOptimizationStatusController.kt */
/* loaded from: classes3.dex */
public final class PowerOptimizationStatusController extends StatusController {
    public static final int $stable = 8;
    private final Context context;
    private final String failedForegroundKey;
    private final SharedPreferences prefs;

    public PowerOptimizationStatusController(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.failedForegroundKey = "hasFailedForegroundService";
        this.prefs = context.getSharedPreferences("PowerOptimizationStorage", 0);
    }

    private final StatusModel createStatus() {
        if (getHasFailedForegroundService() && !isIgnoringBatteryOptimizations()) {
            return PowerOptimizationStatus.INSTANCE;
        }
        if (getHasFailedForegroundService()) {
            setHasFailedForegroundService(false);
        }
        return null;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getHasFailedForegroundService() {
        return this.prefs.getBoolean(this.failedForegroundKey, false);
    }

    public final boolean isIgnoringBatteryOptimizations() {
        PowerManager powerManager;
        Object systemService = this.context.getSystemService("power");
        if (systemService instanceof PowerManager) {
            powerManager = (PowerManager) systemService;
        } else {
            powerManager = null;
        }
        if (powerManager == null) {
            return true;
        }
        return powerManager.isIgnoringBatteryOptimizations(this.context.getPackageName());
    }

    public final void requestIgnorePowerOptimizations() {
        Context context = this.context;
        Intent intent = new Intent();
        intent.setAction("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
        intent.setData(Uri.parse("package:" + this.context.getPackageName()));
        intent.setFlags(intent.getFlags() | 268435456);
        context.startActivity(intent);
    }

    public final void setHasFailedForegroundService(boolean z) {
        this.prefs.edit().putBoolean(this.failedForegroundKey, z).apply();
        update();
    }

    @Override // com.animaconnected.secondo.provider.status.StatusController
    public void update() {
        setCurrentStatusModel(createStatus());
        StatusChangeListener statusChangeListener = getStatusChangeListener();
        if (statusChangeListener != null) {
            statusChangeListener.onStatusChanged();
        }
    }
}
