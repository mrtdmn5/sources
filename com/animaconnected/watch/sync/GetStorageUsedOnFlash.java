package com.animaconnected.watch.sync;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetStorageUsedOnFlash.kt */
/* loaded from: classes3.dex */
public final class GetStorageUsedOnFlash {
    private final Integer SUM;

    public GetStorageUsedOnFlash(Integer num) {
        this.SUM = num;
    }

    public static /* synthetic */ GetStorageUsedOnFlash copy$default(GetStorageUsedOnFlash getStorageUsedOnFlash, Integer num, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            num = getStorageUsedOnFlash.SUM;
        }
        return getStorageUsedOnFlash.copy(num);
    }

    public final Integer component1() {
        return this.SUM;
    }

    public final GetStorageUsedOnFlash copy(Integer num) {
        return new GetStorageUsedOnFlash(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetStorageUsedOnFlash) && Intrinsics.areEqual(this.SUM, ((GetStorageUsedOnFlash) obj).SUM)) {
            return true;
        }
        return false;
    }

    public final Integer getSUM() {
        return this.SUM;
    }

    public int hashCode() {
        Integer num = this.SUM;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    public String toString() {
        return NoProxyHost$$ExternalSyntheticOutline0.m(new StringBuilder("GetStorageUsedOnFlash(SUM="), this.SUM, ')');
    }
}
