package io.ktor.util;

import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: ByteChannels.kt */
/* loaded from: classes3.dex */
public final class ByteChannelsKt {
    public static final void copyToBoth(ByteReadChannel byteReadChannel, final ByteBufferChannel first, final ByteBufferChannel byteBufferChannel) {
        Intrinsics.checkNotNullParameter(byteReadChannel, "<this>");
        Intrinsics.checkNotNullParameter(first, "first");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.Unconfined, null, new ByteChannelsKt$copyToBoth$1(byteReadChannel, first, byteBufferChannel, null), 2).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.util.ByteChannelsKt$copyToBoth$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Throwable th) {
                Throwable th2 = th;
                if (th2 != null) {
                    first.close(th2);
                    byteBufferChannel.close(th2);
                }
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Type inference failed for: r4v1, types: [byte[], java.io.Serializable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.io.Serializable toByteArray(io.ktor.utils.io.ByteReadChannel r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof io.ktor.util.ByteChannelsKt$toByteArray$1
            if (r0 == 0) goto L13
            r0 = r5
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = (io.ktor.util.ByteChannelsKt$toByteArray$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.util.ByteChannelsKt$toByteArray$1 r0 = new io.ktor.util.ByteChannelsKt$toByteArray$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r5)
            goto L40
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r5 = r4.readRemaining(r2, r0)
            if (r5 != r1) goto L40
            return r1
        L40:
            io.ktor.utils.io.core.ByteReadPacket r5 = (io.ktor.utils.io.core.ByteReadPacket) r5
            byte[] r4 = io.ktor.utils.io.core.StringsKt.readBytes$default(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.ByteChannelsKt.toByteArray(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.Continuation):java.io.Serializable");
    }
}
