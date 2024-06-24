package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes3.dex */
public final class CommonFlow<T> implements Flow<T> {
    private final Flow<T> origin;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonFlow(Flow<? extends T> origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.origin = origin;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        return this.origin.collect(flowCollector, continuation);
    }

    public final StartClosableImpl<T> collectClosable(Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new StartClosableImpl<>(this, block);
    }

    public final Object firstOrNil(Continuation<? super T> continuation) {
        return FlowKt.firstOrNull(this, continuation);
    }
}
