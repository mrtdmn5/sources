package io.ktor.util;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ByteChannels.kt */
@DebugMetadata(c = "io.ktor.util.ByteChannelsKt$split$1$1$2", f = "ByteChannels.kt", l = {27}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ByteChannelsKt$split$1$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ByteReadPacket $chunk;
    public final /* synthetic */ ByteChannel $second;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelsKt$split$1$1$2(ByteChannel byteChannel, ByteReadPacket byteReadPacket, Continuation<? super ByteChannelsKt$split$1$1$2> continuation) {
        super(2, continuation);
        this.$second = byteChannel;
        this.$chunk = byteReadPacket;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ByteChannelsKt$split$1$1$2(this.$second, this.$chunk, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelsKt$split$1$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            ByteReadPacket copy = this.$chunk.copy();
            this.label = 1;
            if (this.$second.writePacket(copy, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
