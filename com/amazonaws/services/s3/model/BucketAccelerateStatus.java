package com.amazonaws.services.s3.model;

import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public enum BucketAccelerateStatus {
    Enabled("Enabled"),
    Suspended(BucketVersioningConfiguration.SUSPENDED);

    private final String accelerateStatus;

    BucketAccelerateStatus(String str) {
        this.accelerateStatus = str;
    }

    public static BucketAccelerateStatus fromValue(String str) throws IllegalArgumentException {
        for (BucketAccelerateStatus bucketAccelerateStatus : values()) {
            if (bucketAccelerateStatus.toString().equals(str)) {
                return bucketAccelerateStatus;
            }
        }
        throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("Cannot create enum from ", str, " value!"));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.accelerateStatus;
    }
}
