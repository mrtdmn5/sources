package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.InstanceFactory;
import bleshadow.javax.inject.Provider;
import kotlin.UnsignedKt;

/* loaded from: classes3.dex */
public final class ConnectionModule_ProvideIllegalOperationHandlerFactory implements Provider {
    public final Provider<LoggingIllegalOperationHandler> loggingIllegalOperationHandlerProvider;
    public final Provider<Boolean> suppressOperationCheckProvider;
    public final Provider<ThrowingIllegalOperationHandler> throwingIllegalOperationHandlerProvider;

    public ConnectionModule_ProvideIllegalOperationHandlerFactory(InstanceFactory instanceFactory, LoggingIllegalOperationHandler_Factory loggingIllegalOperationHandler_Factory, ThrowingIllegalOperationHandler_Factory throwingIllegalOperationHandler_Factory) {
        this.suppressOperationCheckProvider = instanceFactory;
        this.loggingIllegalOperationHandlerProvider = loggingIllegalOperationHandler_Factory;
        this.throwingIllegalOperationHandlerProvider = throwingIllegalOperationHandler_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ThrowingIllegalOperationHandler throwingIllegalOperationHandler;
        if (this.suppressOperationCheckProvider.get().booleanValue()) {
            throwingIllegalOperationHandler = this.loggingIllegalOperationHandlerProvider.get();
        } else {
            throwingIllegalOperationHandler = this.throwingIllegalOperationHandlerProvider.get();
        }
        UnsignedKt.checkNotNullFromProvides(throwingIllegalOperationHandler);
        return throwingIllegalOperationHandler;
    }
}
