package com.animaconnected.watch.sync;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetStorageUsedInRam.kt */
/* loaded from: classes3.dex */
public final class GetStorageUsedInRam {
    private final Integer SUM;

    public GetStorageUsedInRam(Integer num) {
        this.SUM = num;
    }

    public static /* synthetic */ GetStorageUsedInRam copy$default(GetStorageUsedInRam getStorageUsedInRam, Integer num, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            num = getStorageUsedInRam.SUM;
        }
        return getStorageUsedInRam.copy(num);
    }

    public final Integer component1() {
        return this.SUM;
    }

    public final GetStorageUsedInRam copy(Integer num) {
        return new GetStorageUsedInRam(num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetStorageUsedInRam) && Intrinsics.areEqual(this.SUM, ((GetStorageUsedInRam) obj).SUM)) {
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
        return NoProxyHost$$ExternalSyntheticOutline0.m(new StringBuilder("GetStorageUsedInRam(SUM="), this.SUM, ')');
    }
}
