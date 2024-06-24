package com.animaconnected.bluetooth.util;

import android.bluetooth.BluetoothDevice;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ConnectionFactory.kt */
/* loaded from: classes.dex */
public interface Connection {
    void addConnectionListener(ConnectionListener connectionListener);

    BluetoothDevice device(String str);

    void enable();

    Set<BluetoothDevice> getDevices();

    boolean isEnabled();

    void removeConnectionListener(ConnectionListener connectionListener);

    void toggle();

    void waitForToggle(Function0<Unit> function0);
}
