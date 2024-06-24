package com.animaconnected.bluetooth.util;

import android.bluetooth.BluetoothDevice;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmulatorConnection.kt */
/* loaded from: classes.dex */
public final class EmulatorConnection implements Connection {
    private final boolean isEnabled;

    public EmulatorConnection(boolean z) {
        this.isEnabled = z;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void addConnectionListener(ConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public BluetoothDevice device(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        throw new RuntimeException("Emulator can't handle 'device'");
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public Set<BluetoothDevice> getDevices() {
        return EmptySet.INSTANCE;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void removeConnectionListener(ConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void waitForToggle(Function0<Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void enable() {
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void toggle() {
    }
}
