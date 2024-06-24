package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;

/* loaded from: classes3.dex */
public final class DescriptorWriter_Factory implements Provider {
    public final Provider<ConnectionOperationQueue> operationQueueProvider;
    public final Provider<OperationsProvider> operationsProvider;

    public DescriptorWriter_Factory(Provider<ConnectionOperationQueue> provider, Provider<OperationsProvider> provider2) {
        this.operationQueueProvider = provider;
        this.operationsProvider = provider2;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        return new DescriptorWriter(this.operationQueueProvider.get(), this.operationsProvider.get());
    }
}
