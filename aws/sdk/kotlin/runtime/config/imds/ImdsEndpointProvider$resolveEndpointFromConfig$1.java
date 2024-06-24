package aws.sdk.kotlin.runtime.config.imds;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImdsEndpointProvider.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.ImdsEndpointProvider", f = "ImdsEndpointProvider.kt", l = {36, 42}, m = "resolveEndpointFromConfig")
/* loaded from: classes.dex */
public final class ImdsEndpointProvider$resolveEndpointFromConfig$1 extends ContinuationImpl {
    public ImdsEndpointProvider L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ImdsEndpointProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsEndpointProvider$resolveEndpointFromConfig$1(ImdsEndpointProvider imdsEndpointProvider, Continuation<? super ImdsEndpointProvider$resolveEndpointFromConfig$1> continuation) {
        super(continuation);
        this.this$0 = imdsEndpointProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.resolveEndpointFromConfig(this);
    }
}
