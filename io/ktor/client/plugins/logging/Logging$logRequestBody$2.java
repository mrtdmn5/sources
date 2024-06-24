package io.ktor.client.plugins.logging;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Logging.kt */
@DebugMetadata(c = "io.ktor.client.plugins.logging.Logging$logRequestBody$2", f = "Logging.kt", l = {268}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class Logging$logRequestBody$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ByteChannel $channel;
    public final /* synthetic */ Charset $charset;
    public final /* synthetic */ StringBuilder $requestLog;
    public Charset L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Logging$logRequestBody$2(ByteChannel byteChannel, Charset charset, StringBuilder sb, Continuation<? super Logging$logRequestBody$2> continuation) {
        super(2, continuation);
        this.$channel = byteChannel;
        this.$charset = charset;
        this.$requestLog = sb;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Logging$logRequestBody$2(this.$channel, this.$charset, this.$requestLog, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((Logging$logRequestBody$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        Charset charset;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        try {
            if (r1 != 0) {
                if (r1 == 1) {
                    charset = this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                ByteChannel byteChannel = this.$channel;
                Charset charset2 = this.$charset;
                this.L$0 = charset2;
                this.label = 1;
                obj = byteChannel.readRemaining(Long.MAX_VALUE, this);
                if (obj == coroutineSingletons) {
                    return coroutineSingletons;
                }
                charset = charset2;
            }
            str = StringsKt.readText$default((Input) obj, charset);
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            str = "[request body omitted]";
        }
        StringBuilder sb = this.$requestLog;
        sb.append("BODY START");
        sb.append('\n');
        sb.append(str);
        sb.append('\n');
        sb.append("BODY END");
        return Unit.INSTANCE;
    }
}
