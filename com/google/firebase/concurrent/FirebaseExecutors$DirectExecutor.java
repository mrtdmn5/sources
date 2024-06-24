package com.google.firebase.concurrent;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public enum FirebaseExecutors$DirectExecutor implements Executor {
    INSTANCE;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
