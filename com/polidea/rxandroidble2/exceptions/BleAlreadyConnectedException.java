package com.polidea.rxandroidble2.exceptions;

import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public class BleAlreadyConnectedException extends BleException {
    public BleAlreadyConnectedException(String str) {
        super(ConstraintSet$$ExternalSyntheticOutline0.m("Already connected to device with MAC address ", str));
    }
}
