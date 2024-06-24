package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class IllegalOperationChecker_Factory implements Provider {
    public final Provider<IllegalOperationHandler> resultHandlerProvider;

    public IllegalOperationChecker_Factory(ConnectionModule_ProvideIllegalOperationHandlerFactory connectionModule_ProvideIllegalOperationHandlerFactory) {
        this.resultHandlerProvider = connectionModule_ProvideIllegalOperationHandlerFactory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new IllegalOperationChecker(this.resultHandlerProvider.get());
    }
}
