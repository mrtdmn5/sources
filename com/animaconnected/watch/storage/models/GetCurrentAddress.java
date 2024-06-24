package com.animaconnected.watch.storage.models;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetCurrentAddress.kt */
/* loaded from: classes3.dex */
public final class GetCurrentAddress {
    private final String current_address;

    public GetCurrentAddress(String str) {
        this.current_address = str;
    }

    public static /* synthetic */ GetCurrentAddress copy$default(GetCurrentAddress getCurrentAddress, String str, int r2, Object obj) {
        if ((r2 & 1) != 0) {
            str = getCurrentAddress.current_address;
        }
        return getCurrentAddress.copy(str);
    }

    public final String component1() {
        return this.current_address;
    }

    public final GetCurrentAddress copy(String str) {
        return new GetCurrentAddress(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof GetCurrentAddress) && Intrinsics.areEqual(this.current_address, ((GetCurrentAddress) obj).current_address)) {
            return true;
        }
        return false;
    }

    public final String getCurrent_address() {
        return this.current_address;
    }

    public int hashCode() {
        String str = this.current_address;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("GetCurrentAddress(current_address="), this.current_address, ')');
    }
}
