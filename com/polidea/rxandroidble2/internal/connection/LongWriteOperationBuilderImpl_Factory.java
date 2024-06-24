package com.polidea.rxandroidble2.internal.connection;

import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;

/* loaded from: classes3.dex */
public final class LongWriteOperationBuilderImpl_Factory implements Provider {
    public final Provider<MtuBasedPayloadSizeLimit> defaultMaxBatchSizeProvider;
    public final Provider<ConnectionOperationQueue> operationQueueProvider;
    public final Provider<OperationsProvider> operationsProvider;
    public final Provider<RxBleConnection> rxBleConnectionProvider;

    public LongWriteOperationBuilderImpl_Factory(Provider<ConnectionOperationQueue> provider, Provider<MtuBasedPayloadSizeLimit> provider2, Provider<RxBleConnection> provider3, Provider<OperationsProvider> provider4) {
        this.operationQueueProvider = provider;
        this.defaultMaxBatchSizeProvider = provider2;
        this.rxBleConnectionProvider = provider3;
        this.operationsProvider = provider4;
    }

    @Override // bleshadow.javax.inject.Provider
    public final Object get() {
        ConnectionOperationQueue connectionOperationQueue = this.operationQueueProvider.get();
        this.defaultMaxBatchSizeProvider.get();
        return new LongWriteOperationBuilderImpl(connectionOperationQueue, this.rxBleConnectionProvider.get(), this.operationsProvider.get());
    }
}
