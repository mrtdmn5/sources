package com.animaconnected.bluetooth.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;

/* compiled from: ConnectionFactory.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes.dex */
public final class ConnectionFactory {
    public static final ConnectionFactory INSTANCE = new ConnectionFactory();
    private static final Lazy connection$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Connection>() { // from class: com.animaconnected.bluetooth.util.ConnectionFactory$connection$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Connection invoke() {
            if (EmulatorKt.isEmulator()) {
                return new EmulatorConnection(true);
            }
            Context context2 = ConnectionFactory.getContext();
            if (context2 != null) {
                Object systemService = context2.getSystemService("bluetooth");
                BluetoothManager bluetoothManager = systemService instanceof BluetoothManager ? (BluetoothManager) systemService : null;
                BluetoothAdapter adapter = bluetoothManager != null ? bluetoothManager.getAdapter() : null;
                return adapter == null ? new EmulatorConnection(false) : new BluetoothConnection(context2, adapter);
            }
            throw new RuntimeException("Context must be set");
        }
    });
    private static Context context;

    private ConnectionFactory() {
    }

    public static final Connection getConnection() {
        return (Connection) connection$delegate.getValue();
    }

    public static final Context getContext() {
        return context;
    }

    public static final void setContext(Context context2) {
        context = context2;
    }

    public static /* synthetic */ void getConnection$annotations() {
    }

    public static /* synthetic */ void getContext$annotations() {
    }
}
