package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ThrowingIllegalOperationHandler_Factory implements Provider {
    public final Provider<IllegalOperationMessageCreator> messageCreatorProvider;

    public ThrowingIllegalOperationHandler_Factory(IllegalOperationMessageCreator_Factory illegalOperationMessageCreator_Factory) {
        this.messageCreatorProvider = illegalOperationMessageCreator_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new ThrowingIllegalOperationHandler(this.messageCreatorProvider.get());
    }
}
