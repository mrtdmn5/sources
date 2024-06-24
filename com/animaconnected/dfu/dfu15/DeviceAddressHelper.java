package com.animaconnected.dfu.dfu15;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
class DeviceAddressHelper {
    private static final int ADDRESS_DIFF = 1;

    public static String getSoftAdressFromBootAdress(String str) {
        return ComposableInvoker$$ExternalSyntheticOutline0.m(str.substring(0, 15), String.format("%02X", Integer.valueOf((Integer.valueOf(str.substring(15), 16).intValue() - 1) & 255)));
    }
}
