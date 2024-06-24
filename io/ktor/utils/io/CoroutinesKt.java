package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.StandaloneCoroutine;

/* compiled from: Coroutines.kt */
/* loaded from: classes3.dex */
public final class CoroutinesKt {
    public static final ChannelJob launchChannel(CoroutineScope coroutineScope, CoroutineContext coroutineContext, final ByteBufferChannel byteBufferChannel, boolean z, Function2 function2) {
        StandaloneCoroutine launch$default = BuildersKt.launch$default(coroutineScope, coroutineContext, null, new CoroutinesKt$launchChannel$job$1(z, byteBufferChannel, function2, (CoroutineDispatcher) coroutineScope.getCoroutineContext().get(CoroutineDispatcher.Key), null), 2);
        launch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.utils.io.CoroutinesKt$launchChannel$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                byteBufferChannel.close(th);
                return Unit.INSTANCE;
            }
        });
        return new ChannelJob(launch$default, byteBufferChannel);
    }

    public static final ChannelJob writer(CoroutineScope coroutineScope, CoroutineContext coroutineContext, boolean z, Function2 function2) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        return launchChannel(coroutineScope, coroutineContext, new ByteBufferChannel(z), true, function2);
    }
}
