package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.operations.DisconnectOperation_Factory;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;

/* loaded from: classes3.dex */
public final class DisconnectAction_Factory implements Provider {
    public final Provider<ClientOperationQueue> clientOperationQueueProvider;
    public final Provider<DisconnectOperation> operationDisconnectProvider;

    public DisconnectAction_Factory(Provider provider, DisconnectOperation_Factory disconnectOperation_Factory) {
        this.clientOperationQueueProvider = provider;
        this.operationDisconnectProvider = disconnectOperation_Factory;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new DisconnectAction(this.clientOperationQueueProvider.get(), this.operationDisconnectProvider.get());
    }
}
