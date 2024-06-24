package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* loaded from: classes3.dex */
public final class AutoValue_ClientInfo extends ClientInfo {
    public final AndroidClientInfo androidClientInfo;
    public final ClientInfo.ClientType clientType;

    public AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.clientType = clientType;
        this.androidClientInfo = androidClientInfo;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientInfo)) {
            return false;
        }
        ClientInfo clientInfo = (ClientInfo) obj;
        ClientInfo.ClientType clientType = this.clientType;
        if (clientType != null ? clientType.equals(clientInfo.getClientType()) : clientInfo.getClientType() == null) {
            AndroidClientInfo androidClientInfo = this.androidClientInfo;
            if (androidClientInfo == null) {
                if (clientInfo.getAndroidClientInfo() == null) {
                    return true;
                }
            } else if (androidClientInfo.equals(clientInfo.getAndroidClientInfo())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public final AndroidClientInfo getAndroidClientInfo() {
        return this.androidClientInfo;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public final ClientInfo.ClientType getClientType() {
        return this.clientType;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        ClientInfo.ClientType clientType = this.clientType;
        if (clientType == null) {
            hashCode = 0;
        } else {
            hashCode = clientType.hashCode();
        }
        int r1 = (hashCode ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.androidClientInfo;
        if (androidClientInfo != null) {
            r0 = androidClientInfo.hashCode();
        }
        return r0 ^ r1;
    }

    public final String toString() {
        return "ClientInfo{clientType=" + this.clientType + ", androidClientInfo=" + this.androidClientInfo + "}";
    }
}
