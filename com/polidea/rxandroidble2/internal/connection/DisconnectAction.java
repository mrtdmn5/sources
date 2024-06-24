package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.internal.operations.DisconnectOperation;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import io.reactivex.Observable;
import io.reactivex.internal.functions.Functions;

/* loaded from: classes3.dex */
public final class DisconnectAction implements ConnectionSubscriptionWatcher {
    public final ClientOperationQueue clientOperationQueue;
    public final DisconnectOperation operationDisconnect;

    public DisconnectAction(ClientOperationQueue clientOperationQueue, DisconnectOperation disconnectOperation) {
        this.clientOperationQueue = clientOperationQueue;
        this.operationDisconnect = disconnectOperation;
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionUnsubscribed() {
        Observable queue = this.clientOperationQueue.queue(this.operationDisconnect);
        Functions.EmptyConsumer emptyConsumer = Functions.EMPTY_CONSUMER;
        queue.subscribe(emptyConsumer, emptyConsumer);
    }

    @Override // com.polidea.rxandroidble2.internal.connection.ConnectionSubscriptionWatcher
    public final void onConnectionSubscribed() {
    }
}
