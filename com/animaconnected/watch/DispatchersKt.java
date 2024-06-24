package com.animaconnected.watch;

import android.os.Looper;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: Dispatchers.kt */
/* loaded from: classes3.dex */
public final class DispatchersKt {
    public static final String currentThreadName() {
        return Thread.currentThread().getName();
    }

    public static final CoroutineDispatcher ioDispatcher() {
        return Dispatchers.IO;
    }

    public static final boolean isCurrentThreadMain() {
        if (Looper.getMainLooper() != null && Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
            return false;
        }
        return true;
    }

    public static final CoroutineDispatcher mainDispatcher() {
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return MainDispatcherLoader.dispatcher;
    }
}
