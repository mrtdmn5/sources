package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes3.dex */
public abstract class ClientInfo {

    /* loaded from: classes3.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);

        private final int value;

        ClientType(int r3) {
            this.value = r3;
        }
    }

    public abstract AndroidClientInfo getAndroidClientInfo();

    public abstract ClientType getClientType();
}
