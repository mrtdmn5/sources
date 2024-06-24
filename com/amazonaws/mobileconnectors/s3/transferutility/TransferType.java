package com.amazonaws.mobileconnectors.s3.transferutility;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public enum TransferType {
    UPLOAD,
    DOWNLOAD,
    ANY;

    public static TransferType getType(String str) {
        TransferType transferType = UPLOAD;
        if (str.equalsIgnoreCase(transferType.toString())) {
            return transferType;
        }
        TransferType transferType2 = DOWNLOAD;
        if (str.equalsIgnoreCase(transferType2.toString())) {
            return transferType2;
        }
        TransferType transferType3 = ANY;
        if (str.equalsIgnoreCase(transferType3.toString())) {
            return transferType3;
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Type ", str, " is not a recognized type"));
    }
}
