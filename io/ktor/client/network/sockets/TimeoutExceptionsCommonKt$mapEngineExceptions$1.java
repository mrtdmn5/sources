package io.ktor.client.network.sockets;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.WriterScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: TimeoutExceptionsCommon.kt */
@DebugMetadata(c = "io.ktor.client.network.sockets.TimeoutExceptionsCommonKt$mapEngineExceptions$1", f = "TimeoutExceptionsCommon.kt", l = {38}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class TimeoutExceptionsCommonKt$mapEngineExceptions$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ByteReadChannel $input;
    public final /* synthetic */ ByteChannel $replacementChannel;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeoutExceptionsCommonKt$mapEngineExceptions$1(ByteReadChannel byteReadChannel, ByteChannel byteChannel, Continuation<? super TimeoutExceptionsCommonKt$mapEngineExceptions$1> continuation) {
        super(2, continuation);
        this.$input = byteReadChannel;
        this.$replacementChannel = byteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TimeoutExceptionsCommonKt$mapEngineExceptions$1(this.$input, this.$replacementChannel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((TimeoutExceptionsCommonKt$mapEngineExceptions$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        ByteReadChannel byteReadChannel = this.$input;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ByteChannel byteChannel = this.$replacementChannel;
                this.label = 1;
                if (ByteReadChannelKt.copyAndClose(byteReadChannel, byteChannel, Long.MAX_VALUE, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        } catch (Throwable th) {
            byteReadChannel.cancel(th);
        }
        return Unit.INSTANCE;
    }
}
