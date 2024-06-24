package com.animaconnected.secondo.provider.status.internal.connection;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.bluetooth.util.ConnectionListener;
import com.animaconnected.secondo.provider.status.BluetoothDisabledStatus;
import com.animaconnected.secondo.provider.status.DisconnectedStatus;
import com.animaconnected.secondo.provider.status.StatusChangeListener;
import com.animaconnected.secondo.provider.status.StatusController;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceConnectionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectionStatusController.kt */
/* loaded from: classes3.dex */
public final class ConnectionStatusController extends StatusController implements DeviceConnectionListener {
    public static final int $stable = 8;
    private final List<String> bluetoothPermissions;
    private final Context context;
    private final Handler handler;
    private final WatchProvider watch;

    public ConnectionStatusController(WatchProvider watch, Context context) {
        List<String> list;
        Intrinsics.checkNotNullParameter(watch, "watch");
        Intrinsics.checkNotNullParameter(context, "context");
        this.watch = watch;
        this.context = context;
        this.handler = new Handler(Looper.getMainLooper());
        if (Build.VERSION.SDK_INT >= 31) {
            list = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN"});
        } else {
            list = EmptyList.INSTANCE;
        }
        this.bluetoothPermissions = list;
        watch.registerDeviceConnectionListener(this);
        ConnectionFactory.getConnection().addConnectionListener(new ConnectionListener() { // from class: com.animaconnected.secondo.provider.status.internal.connection.ConnectionStatusController$$ExternalSyntheticLambda0
            @Override // com.animaconnected.bluetooth.util.ConnectionListener
            public final void onChanged(boolean z) {
                ConnectionStatusController._init_$lambda$1(ConnectionStatusController.this, z);
            }
        });
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(final ConnectionStatusController this$0, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handler.post(new Runnable() { // from class: com.animaconnected.secondo.provider.status.internal.connection.ConnectionStatusController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ConnectionStatusController.lambda$1$lambda$0(ConnectionStatusController.this);
            }
        });
    }

    private final StatusModel createStatus() {
        List<String> list = this.bluetoothPermissions;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (ContextCompat.checkSelfPermission(this.context, (String) next) == 0) {
                z = false;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        if (ConnectionFactory.getConnection().isEnabled() && !(!arrayList.isEmpty())) {
            if (!this.watch.isConnected() && !this.watch.isInDfuMode()) {
                return DisconnectedStatus.INSTANCE;
            }
            return null;
        }
        return new BluetoothDisabledStatus(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(ConnectionStatusController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.update();
    }

    public final Context getContext() {
        return this.context;
    }

    public final WatchProvider getWatch() {
        return this.watch;
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onConnected() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onDisconnected() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterDfuMode() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onEnterUpdateRequired() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveDfuMode() {
        update();
    }

    @Override // com.animaconnected.watch.device.DeviceConnectionListener
    public void onLeaveUpdateRequired() {
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
