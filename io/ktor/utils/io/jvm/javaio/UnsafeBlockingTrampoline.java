package io.ktor.utils.io.jvm.javaio;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: Blocking.kt */
/* loaded from: classes3.dex */
public final class UnsafeBlockingTrampoline extends CoroutineDispatcher {
    public static final UnsafeBlockingTrampoline INSTANCE = new UnsafeBlockingTrampoline();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext context, Runnable block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        block.run();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return true;
    }
}
