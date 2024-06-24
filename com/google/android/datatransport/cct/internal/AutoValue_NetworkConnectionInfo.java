package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* loaded from: classes3.dex */
public final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {
    public final NetworkConnectionInfo.MobileSubtype mobileSubtype;
    public final NetworkConnectionInfo.NetworkType networkType;

    public AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.networkType = networkType;
        this.mobileSubtype = mobileSubtype;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetworkConnectionInfo)) {
            return false;
        }
        NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        if (networkType != null ? networkType.equals(networkConnectionInfo.getNetworkType()) : networkConnectionInfo.getNetworkType() == null) {
            NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
            if (mobileSubtype == null) {
                if (networkConnectionInfo.getMobileSubtype() == null) {
                    return true;
                }
            } else if (mobileSubtype.equals(networkConnectionInfo.getMobileSubtype())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public final NetworkConnectionInfo.MobileSubtype getMobileSubtype() {
        return this.mobileSubtype;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public final NetworkConnectionInfo.NetworkType getNetworkType() {
        return this.networkType;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        NetworkConnectionInfo.NetworkType networkType = this.networkType;
        if (networkType == null) {
            hashCode = 0;
        } else {
            hashCode = networkType.hashCode();
        }
        int r1 = (hashCode ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.mobileSubtype;
        if (mobileSubtype != null) {
            r0 = mobileSubtype.hashCode();
        }
        return r0 ^ r1;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.networkType + ", mobileSubtype=" + this.mobileSubtype + "}";
    }
}
