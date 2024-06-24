package io.ktor.client.utils;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannelUtils.kt */
/* loaded from: classes3.dex */
public final class ByteChannelUtilsKt {
    public static final ByteChannel observable(ByteReadChannel byteReadChannel, CoroutineContext context, Long l, Function3 listener) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        return CoroutinesKt.writer(GlobalScope.INSTANCE, context, true, new ByteChannelUtilsKt$observable$1(l, byteReadChannel, listener, null)).channel;
    }
}
