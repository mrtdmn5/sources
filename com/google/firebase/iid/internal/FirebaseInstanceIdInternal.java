package com.google.firebase.iid.internal;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
/* loaded from: classes3.dex */
public interface FirebaseInstanceIdInternal {
    void addNewTokenListener();

    String getToken();

    Task<String> getTokenTask();
}
