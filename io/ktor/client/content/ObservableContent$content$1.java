package io.ktor.client.content;

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

/* compiled from: ObservableContent.kt */
@DebugMetadata(c = "io.ktor.client.content.ObservableContent$content$1", f = "ObservableContent.kt", l = {36}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ObservableContent$content$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ OutgoingContent $delegate;
    public /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ObservableContent$content$1(OutgoingContent outgoingContent, Continuation<? super ObservableContent$content$1> continuation) {
        super(2, continuation);
        this.$delegate = outgoingContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ObservableContent$content$1 observableContent$content$1 = new ObservableContent$content$1(this.$delegate, continuation);
        observableContent$content$1.L$0 = obj;
        return observableContent$content$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ObservableContent$content$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            WriterScope writerScope = (WriterScope) this.L$0;
            OutgoingContent.WriteChannelContent writeChannelContent = (OutgoingContent.WriteChannelContent) this.$delegate;
            ByteChannel channel$1 = writerScope.getChannel$1();
            this.label = 1;
            if (writeChannelContent.writeTo(channel$1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return Unit.INSTANCE;
    }
}
