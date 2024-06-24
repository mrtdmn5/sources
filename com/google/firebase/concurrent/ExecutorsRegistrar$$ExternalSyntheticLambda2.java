package com.google.firebase.concurrent;

import android.os.StrictMode;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda2 implements Provider {
    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Lazy<ScheduledExecutorService> lazy = ExecutorsRegistrar.BG_EXECUTOR;
        return new DelegatingScheduledExecutorService(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new CustomThreadFactory("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), ExecutorsRegistrar.SCHEDULER.get());
    }
}
