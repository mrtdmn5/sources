package io.reactivex.internal.operators.single;

import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import org.reactivestreams.Publisher;

/* loaded from: classes.dex */
public enum SingleInternalHelper$ToFlowable implements Function<SingleSource, Publisher> {
    INSTANCE;

    @Override // io.reactivex.functions.Function
    public Publisher apply(SingleSource singleSource) {
        return new SingleToFlowable(singleSource);
    }
}
