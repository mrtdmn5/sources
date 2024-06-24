package com.animaconnected.bluetooth.heartrate;

import com.animaconnected.bluetooth.heartrate.HeartRateDevice;

/* compiled from: HeartRateDevice.kt */
/* loaded from: classes.dex */
public interface ReferenceDeviceListener {
    void onData(HeartRateDevice.HRValue hRValue);
}
