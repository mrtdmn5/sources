package com.polidea.rxandroidble2.internal.serialization;

import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public final class OperationPriorityFifoBlockingQueue {
    public final PriorityBlockingQueue<FIFORunnableEntry> q = new PriorityBlockingQueue<>();
}
