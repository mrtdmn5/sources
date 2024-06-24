package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;

/* loaded from: classes3.dex */
public final class LongWriteOperationBuilderImpl {
    public final ConnectionOperationQueue operationQueue;
    public final OperationsProvider operationsProvider;
    public final RxBleConnection rxBleConnection;

    public LongWriteOperationBuilderImpl(ConnectionOperationQueue connectionOperationQueue, RxBleConnection rxBleConnection, OperationsProvider operationsProvider) {
        this.operationQueue = connectionOperationQueue;
        this.rxBleConnection = rxBleConnection;
        this.operationsProvider = operationsProvider;
    }
}
