package com.animaconnected.watch;

import app.cash.sqldelight.Query;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SafeFlow;

/* compiled from: FlowExtensions.kt */
/* loaded from: classes3.dex */
public final class FlowExtensionsKt {
    public static final <T> CommonFlow<T> asCommonFlow(Flow<? extends T> flow) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        return new CommonFlow<>(flow);
    }

    public static final <T> Flow<T> dynamicQueryAsFlow(long j, Function1<? super Long, ? extends Query<? extends T>> query, Function1<? super T, Long> timestampFrom) {
        Intrinsics.checkNotNullParameter(query, "query");
        Intrinsics.checkNotNullParameter(timestampFrom, "timestampFrom");
        return new SafeFlow(new FlowExtensionsKt$dynamicQueryAsFlow$1(j, query, timestampFrom, null));
    }
}
