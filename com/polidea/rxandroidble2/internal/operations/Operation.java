package com.polidea.rxandroidble2.internal.operations;

import com.polidea.rxandroidble2.internal.Priority;
import com.polidea.rxandroidble2.internal.serialization.QueueSemaphore;
import io.reactivex.internal.operators.observable.ObservableCreate;

/* loaded from: classes3.dex */
public interface Operation<T> extends Comparable<Operation<?>> {
    Priority definedPriority();

    ObservableCreate run(QueueSemaphore queueSemaphore);
}
