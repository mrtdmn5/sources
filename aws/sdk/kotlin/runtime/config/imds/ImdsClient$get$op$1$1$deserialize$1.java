package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.response.HttpResponse;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ImdsClient.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$op$1$1", f = "ImdsClient.kt", l = {112}, m = "deserialize")
/* loaded from: classes.dex */
public final class ImdsClient$get$op$1$1$deserialize$1 extends ContinuationImpl {
    public HttpResponse L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ImdsClient$get$op$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsClient$get$op$1$1$deserialize$1(ImdsClient$get$op$1$1 imdsClient$get$op$1$1, Continuation<? super ImdsClient$get$op$1$1$deserialize$1> continuation) {
        super(continuation);
        this.this$0 = imdsClient$get$op$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.deserialize(null, null, this);
    }
}
