package com.google.firebase.concurrent;

import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda1 implements Provider {
    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Lazy<ScheduledExecutorService> lazy = ExecutorsRegistrar.BG_EXECUTOR;
        StrictMode.ThreadPolicy.Builder detectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
        int r1 = Build.VERSION.SDK_INT;
        detectNetwork.detectResourceMismatches();
        if (r1 >= 26) {
            detectNetwork.detectUnbufferedIo();
        }
        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(4, new CustomThreadFactory("Firebase Background", 10, detectNetwork.penaltyLog().build())), ExecutorsRegistrar.SCHEDULER.get());
    }
}
