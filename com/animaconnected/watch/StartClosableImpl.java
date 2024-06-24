package com.animaconnected.watch;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes3.dex */
public final class StartClosableImpl<T> implements StartClosable {
    private final Function1<T, Unit> block;
    private final CommonFlow<T> flow;
    private Job job;

    /* JADX WARN: Multi-variable type inference failed */
    public StartClosableImpl(CommonFlow<T> flow, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(block, "block");
        this.flow = flow;
        this.block = block;
        start();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Job job = this.job;
        if (job != null) {
            job.cancel(null);
        }
        this.job = null;
    }

    @Override // com.animaconnected.watch.StartClosable
    public void start() {
        Job job = this.job;
        if (job != null) {
            job.cancel(null);
        }
        this.job = FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new StartClosableImpl$start$1(this, null), this.flow), CoroutineScopeKt.CoroutineScope(DispatchersKt.mainDispatcher()));
    }
}
