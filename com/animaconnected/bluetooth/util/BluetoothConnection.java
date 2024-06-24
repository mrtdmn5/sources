package com.animaconnected.bluetooth.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothConnection.kt */
@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public final class BluetoothConnection implements Connection {
    private final BluetoothAdapter adapter;
    private final CopyOnWriteArrayList<ConnectionListener> listeners;
    private final List<Function0<Unit>> toggleListeners;
    private boolean toggleStarted;
    private boolean turnOnWhenOff;

    public BluetoothConnection(Context context, BluetoothAdapter adapter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        this.toggleListeners = new ArrayList();
        this.listeners = new CopyOnWriteArrayList<>();
        context.registerReceiver(new BroadcastReceiver() { // from class: com.animaconnected.bluetooth.util.BluetoothConnection$receiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                Intrinsics.checkNotNullParameter(intent, "intent");
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
                if (intExtra == 10 && BluetoothConnection.this.getTurnOnWhenOff()) {
                    BluetoothConnection.this.enable();
                    BluetoothConnection.this.setTurnOnWhenOff(false);
                } else if (intExtra == 12 && BluetoothConnection.this.getToggleStarted()) {
                    BluetoothConnection.this.setToggleStarted(false);
                    Iterator<T> it = BluetoothConnection.this.getToggleListeners().iterator();
                    while (it.hasNext()) {
                        ((Function0) it.next()).invoke();
                    }
                    BluetoothConnection.this.getToggleListeners().clear();
                }
                if (intExtra != intExtra2 && intExtra2 == 12) {
                    Iterator<T> it2 = BluetoothConnection.this.getListeners().iterator();
                    while (it2.hasNext()) {
                        ((ConnectionListener) it2.next()).onChanged(false);
                    }
                } else if (intExtra != intExtra2 && intExtra == 12) {
                    Iterator<T> it3 = BluetoothConnection.this.getListeners().iterator();
                    while (it3.hasNext()) {
                        ((ConnectionListener) it3.next()).onChanged(true);
                    }
                }
            }
        }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void addConnectionListener(ConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public BluetoothDevice device(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BluetoothDevice remoteDevice = this.adapter.getRemoteDevice(address);
        Intrinsics.checkNotNullExpressionValue(remoteDevice, "getRemoteDevice(...)");
        return remoteDevice;
    }

    public final void disable() {
        this.adapter.disable();
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void enable() {
        this.adapter.enable();
    }

    public final BluetoothAdapter getAdapter() {
        return this.adapter;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public Set<BluetoothDevice> getDevices() {
        Set<BluetoothDevice> bondedDevices = this.adapter.getBondedDevices();
        Intrinsics.checkNotNullExpressionValue(bondedDevices, "getBondedDevices(...)");
        return bondedDevices;
    }

    public final CopyOnWriteArrayList<ConnectionListener> getListeners() {
        return this.listeners;
    }

    public final List<Function0<Unit>> getToggleListeners() {
        return this.toggleListeners;
    }

    public final boolean getToggleStarted() {
        return this.toggleStarted;
    }

    public final boolean getTurnOnWhenOff() {
        return this.turnOnWhenOff;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public boolean isEnabled() {
        return this.adapter.isEnabled();
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void removeConnectionListener(ConnectionListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }

    public final void setToggleStarted(boolean z) {
        this.toggleStarted = z;
    }

    public final void setTurnOnWhenOff(boolean z) {
        this.turnOnWhenOff = z;
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void toggle() {
        int state = this.adapter.getState();
        if (state != 10) {
            if (state != 12) {
                if (state == 13) {
                    this.turnOnWhenOff = true;
                    return;
                }
                return;
            } else {
                disable();
                this.turnOnWhenOff = true;
                return;
            }
        }
        enable();
    }

    @Override // com.animaconnected.bluetooth.util.Connection
    public void waitForToggle(Function0<Unit> onCompleted) {
        Intrinsics.checkNotNullParameter(onCompleted, "onCompleted");
        this.toggleStarted = true;
        this.toggleListeners.add(onCompleted);
    }
}
