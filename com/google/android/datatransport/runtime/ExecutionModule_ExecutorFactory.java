package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public final class ExecutionModule_ExecutorFactory implements Factory<Executor> {

    /* loaded from: classes3.dex */
    public static final class InstanceHolder {
        public static final ExecutionModule_ExecutorFactory INSTANCE = new ExecutionModule_ExecutorFactory();
    }

    @Override // javax.inject.Provider
    public final Object get() {
        return new SafeLoggingExecutor(Executors.newSingleThreadExecutor());
    }
}
