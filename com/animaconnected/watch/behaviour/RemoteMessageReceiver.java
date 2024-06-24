package com.animaconnected.watch.behaviour;

import java.util.Map;

/* compiled from: RemoteMessageReceiver.kt */
/* loaded from: classes3.dex */
public interface RemoteMessageReceiver {
    String getServiceName();

    void onMessageReceived(Map<String, String> map);
}
