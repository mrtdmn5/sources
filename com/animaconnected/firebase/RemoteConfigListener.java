package com.animaconnected.firebase;

/* compiled from: RemoteConfigListener.kt */
/* loaded from: classes.dex */
public interface RemoteConfigListener {
    void onConfigFetched();

    void onConfigFetchedFailed(String str);
}
