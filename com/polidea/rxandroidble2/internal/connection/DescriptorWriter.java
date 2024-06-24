package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.operations.OperationsProvider;
import com.polidea.rxandroidble2.internal.serialization.ConnectionOperationQueue;

/* loaded from: classes3.dex */
public final class DescriptorWriter {
    public final ConnectionOperationQueue operationQueue;
    public final OperationsProvider operationsProvider;

    public DescriptorWriter(ConnectionOperationQueue connectionOperationQueue, OperationsProvider operationsProvider) {
        this.operationQueue = connectionOperationQueue;
        this.operationsProvider = operationsProvider;
    }
}
