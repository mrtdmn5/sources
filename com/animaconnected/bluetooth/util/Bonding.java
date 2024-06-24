package com.animaconnected.bluetooth.util;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@SuppressLint({"MissingPermission"})
/* loaded from: classes.dex */
public class Bonding {
    private static Bonding sInstance;
    private final Set<BondingListener> mBondingListeners = new CopyOnWriteArraySet();

    /* loaded from: classes.dex */
    public interface BondingListener {
        void onBondCreated(boolean z);

        void onBondRemoved(boolean z);
    }

    private Bonding() {
    }

    public static Bonding getInstance() {
        if (sInstance == null) {
            sInstance = new Bonding();
        }
        return sInstance;
    }

    private void notifyBondCreated(boolean z) {
        Iterator<BondingListener> it = this.mBondingListeners.iterator();
        while (it.hasNext()) {
            it.next().onBondCreated(z);
        }
    }

    private void notifyBondRemoved(boolean z) {
        Iterator<BondingListener> it = this.mBondingListeners.iterator();
        while (it.hasNext()) {
            it.next().onBondRemoved(z);
        }
    }

    public boolean createBondToDevice(BluetoothDevice bluetoothDevice) {
        boolean createBond = bluetoothDevice.createBond();
        notifyBondCreated(createBond);
        return createBond;
    }

    public boolean isDeviceBonded(String str) {
        if (str != null) {
            if (str.startsWith("EMULATOR")) {
                return true;
            }
            for (BluetoothDevice bluetoothDevice : ConnectionFactory.getConnection().getDevices()) {
                if (bluetoothDevice != null && str.equals(bluetoothDevice.getAddress())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void registerBondingListener(BondingListener bondingListener) {
        this.mBondingListeners.add(bondingListener);
    }

    public void removeBondFromDevice(String str) throws Exception {
        removeBondFromDevice(ConnectionFactory.getConnection().device(str));
    }

    public void unregisterBondingListener(BondingListener bondingListener) {
        this.mBondingListeners.remove(bondingListener);
    }

    public void removeBondFromDevice(BluetoothDevice bluetoothDevice) throws Exception {
        if (bluetoothDevice == null || bluetoothDevice.getBondState() == 10) {
            return;
        }
        boolean booleanValue = ((Boolean) BluetoothDevice.class.getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
        notifyBondRemoved(booleanValue);
        if (!booleanValue) {
            throw new RuntimeException("Failed to remove bond");
        }
    }
}
