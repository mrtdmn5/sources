package com.google.firebase.concurrent;

import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: R8$$SyntheticClass */
/* loaded from: classes3.dex */
public final /* synthetic */ class ExecutorsRegistrar$$ExternalSyntheticLambda4 implements Provider {
    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        Lazy<ScheduledExecutorService> lazy = ExecutorsRegistrar.BG_EXECUTOR;
        return Executors.newSingleThreadScheduledExecutor(new CustomThreadFactory("Firebase Scheduler", 0, null));
    }
}
