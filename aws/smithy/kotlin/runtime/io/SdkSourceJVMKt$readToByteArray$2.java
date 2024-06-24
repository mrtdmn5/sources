package aws.smithy.kotlin.runtime.io;

import aws.smithy.kotlin.runtime.io.internal.OkioSdkSource;
import aws.smithy.kotlin.runtime.io.internal.OkioSource;
import kotlin.ExceptionsKt;
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
import okio.Source;

/* compiled from: SdkSourceJVM.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.io.SdkSourceJVMKt$readToByteArray$2", f = "SdkSourceJVM.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SdkSourceJVMKt$readToByteArray$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    public final /* synthetic */ SdkSource $this_readToByteArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SdkSourceJVMKt$readToByteArray$2(SdkSource sdkSource, Continuation<? super SdkSourceJVMKt$readToByteArray$2> continuation) {
        super(2, continuation);
        this.$this_readToByteArray = sdkSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SdkSourceJVMKt$readToByteArray$2(this.$this_readToByteArray, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((SdkSourceJVMKt$readToByteArray$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SdkBufferedSource bufferedSourceAdapter;
        Source okioSource;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        SdkSource sdkSource = this.$this_readToByteArray;
        try {
            Intrinsics.checkNotNullParameter(sdkSource, "<this>");
            if (sdkSource instanceof SdkBufferedSource) {
                bufferedSourceAdapter = (SdkBufferedSource) sdkSource;
            } else {
                if (sdkSource instanceof OkioSdkSource) {
                    okioSource = ((OkioSdkSource) sdkSource).delegate;
                } else {
                    okioSource = new OkioSource(sdkSource);
                }
                bufferedSourceAdapter = new BufferedSourceAdapter(Okio.buffer(okioSource));
            }
            byte[] readByteArray = bufferedSourceAdapter.readByteArray();
            sdkSource.close();
            return readByteArray;
        } catch (Throwable th) {
            try {
                sdkSource.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
            throw th;
        }
    }
}
