package aws.smithy.kotlin.runtime.io;

import aws.smithy.kotlin.runtime.io.internal.OkioSdkSink;
import aws.smithy.kotlin.runtime.io.internal.OkioSink;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okio.Okio;
import okio.Sink;

/* compiled from: SdkByteReadChannel.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt$readAll$2", f = "SdkByteReadChannel.kt", l = {111}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SdkByteReadChannelKt$readAll$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    public final /* synthetic */ SdkSink $sink;
    public long J$0;
    public SdkBufferedSink L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkByteReadChannelKt$readAll$2(SdkByteReadChannel sdkByteReadChannel, SdkSink sdkSink, Continuation continuation) {
        super(2, continuation);
        this.$sink = sdkSink;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SdkByteReadChannelKt$readAll$2(null, this.$sink, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Long> continuation) {
        return ((SdkByteReadChannelKt$readAll$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SdkBufferedSink sdkBufferedSink;
        long j;
        Sink okioSink;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r0 = this.label;
        if (r0 != 0) {
            if (r0 == 1) {
                long j2 = this.J$0;
                sdkBufferedSink = this.L$0;
                ResultKt.throwOnFailure(obj);
                long longValue = ((Number) obj).longValue();
                if (longValue == -1) {
                    sdkBufferedSink.emit();
                    return new Long(j2);
                }
                j = j2 + longValue;
                sdkBufferedSink.emit();
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            SdkSink sdkSink = this.$sink;
            Intrinsics.checkNotNullParameter(sdkSink, "<this>");
            if (!(sdkSink instanceof SdkBufferedSink)) {
                if (sdkSink instanceof OkioSdkSink) {
                    okioSink = ((OkioSdkSink) sdkSink).delegate;
                } else {
                    okioSink = new OkioSink(sdkSink);
                }
                sdkBufferedSink = new BufferedSinkAdapter(Okio.buffer(okioSink));
            } else {
                sdkBufferedSink = (SdkBufferedSink) sdkSink;
            }
            j = 0;
        }
        sdkBufferedSink.getBuffer();
        this.L$0 = sdkBufferedSink;
        this.J$0 = j;
        this.label = 1;
        throw null;
    }
}
