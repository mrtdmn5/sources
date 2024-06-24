package com.animaconnected.secondo.app;

import android.content.Context;
import android.util.Log;
import com.animaconnected.watch.DeviceAvailableListener;
import com.animaconnected.watch.WatchProvider;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceManager.kt */
/* loaded from: classes.dex */
public final class DeviceManager implements DeviceAvailableListener {
    public static final int $stable = 8;
    private final Context context;
    private final String tag;

    public DeviceManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.tag = "DeviceManager";
    }

    public final void listenTo(WatchProvider watchProvider) {
        Intrinsics.checkNotNullParameter(watchProvider, "watchProvider");
        watchProvider.registerDeviceAvailableListener(this);
        if (watchProvider.hasDevice()) {
            onDeviceAdded();
        }
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceAdded() {
        Log.d(this.tag, "Device added. Starting device service.");
        DeviceService.Companion.start(this.context);
    }

    @Override // com.animaconnected.watch.DeviceAvailableListener
    public void onDeviceRemoved() {
        Log.d(this.tag, "Device removed. Stopping device service.");
        DeviceService.Companion.stop(this.context);
    }
}
