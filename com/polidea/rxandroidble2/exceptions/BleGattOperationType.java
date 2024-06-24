package com.polidea.rxandroidble2.exceptions;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class BleGattOperationType {
    public final String description;
    public static final BleGattOperationType CONNECTION_STATE = new BleGattOperationType("CONNECTION_STATE");
    public static final BleGattOperationType SERVICE_DISCOVERY = new BleGattOperationType("SERVICE_DISCOVERY");
    public static final BleGattOperationType CHARACTERISTIC_READ = new BleGattOperationType("CHARACTERISTIC_READ");
    public static final BleGattOperationType CHARACTERISTIC_WRITE = new BleGattOperationType("CHARACTERISTIC_WRITE");
    public static final BleGattOperationType DESCRIPTOR_READ = new BleGattOperationType("DESCRIPTOR_READ");
    public static final BleGattOperationType DESCRIPTOR_WRITE = new BleGattOperationType("DESCRIPTOR_WRITE");
    public static final BleGattOperationType READ_RSSI = new BleGattOperationType("READ_RSSI");
    public static final BleGattOperationType ON_MTU_CHANGED = new BleGattOperationType("ON_MTU_CHANGED");
    public static final BleGattOperationType CONNECTION_PRIORITY_CHANGE = new BleGattOperationType("CONNECTION_PRIORITY_CHANGE");

    public BleGattOperationType(String str) {
        this.description = str;
    }

    public final String toString() {
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("BleGattOperation{description='"), this.description, "'}");
    }
}
