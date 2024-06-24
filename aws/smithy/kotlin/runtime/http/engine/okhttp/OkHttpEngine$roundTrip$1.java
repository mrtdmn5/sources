package aws.smithy.kotlin.runtime.http.engine.okhttp;

import aws.smithy.kotlin.runtime.http.request.HttpRequest;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: OkHttpEngine.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.http.engine.okhttp.OkHttpEngine", f = "OkHttpEngine.kt", l = {38, 42}, m = "roundTrip")
/* loaded from: classes.dex */
public final class OkHttpEngine$roundTrip$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public HttpRequest L$2;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ OkHttpEngine this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine$roundTrip$1(OkHttpEngine okHttpEngine, Continuation<? super OkHttpEngine$roundTrip$1> continuation) {
        super(continuation);
        this.this$0 = okHttpEngine;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.roundTrip(null, null, this);
    }
}
