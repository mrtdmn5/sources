package com.animaconnected.watch;

import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Dispatchers.kt */
/* loaded from: classes3.dex */
public final class DispatchersCommon {
    public static final CoroutineDispatcher watchDispatcher() {
        return Dispatchers.Default.limitedParallelism(1);
    }
}
