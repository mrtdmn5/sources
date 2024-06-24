package io.ktor.client.plugins.logging;

import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: ObservingUtils.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.ObservingUtilsKt$toReadChannel$1", f = "ObservingUtils.kt", l = {40}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ObservingUtilsKt$toReadChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ OutgoingContent.WriteChannelContent $this_toReadChannel;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservingUtilsKt$toReadChannel$1(OutgoingContent.WriteChannelContent writeChannelContent, Continuation<? super ObservingUtilsKt$toReadChannel$1> continuation) {
        super(2, continuation);
        this.$this_toReadChannel = writeChannelContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ObservingUtilsKt$toReadChannel$1 observingUtilsKt$toReadChannel$1 = new ObservingUtilsKt$toReadChannel$1(this.$this_toReadChannel, continuation);
        observingUtilsKt$toReadChannel$1.L$0 = obj;
        return observingUtilsKt$toReadChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ObservingUtilsKt$toReadChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            ByteChannel channel$1 = ((WriterScope) this.L$0).getChannel$1();
            this.label = 1;
            if (this.$this_toReadChannel.writeTo(channel$1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
