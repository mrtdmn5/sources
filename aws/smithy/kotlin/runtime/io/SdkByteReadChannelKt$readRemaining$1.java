package aws.smithy.kotlin.runtime.io;

import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: SdkByteReadChannel.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.io.SdkByteReadChannelKt", f = "SdkByteReadChannel.kt", l = {88}, m = "readRemaining")
/* loaded from: classes.dex */
public final class SdkByteReadChannelKt$readRemaining$1 extends ContinuationImpl {
    public SdkBuffer L$1;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return SdkByteReadChannelKt.readRemaining(null, null, this);
    }
}
