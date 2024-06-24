package aws.smithy.kotlin.runtime.io.middleware;

import aws.smithy.kotlin.runtime.io.Handler;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX WARN: Unknown type variable: Request in type: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware<Request, Response> */
/* JADX WARN: Unknown type variable: Response in type: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware<Request, Response> */
/* compiled from: ModifyRequest.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware", f = "ModifyRequest.kt", l = {24, 24}, m = "handle")
/* loaded from: classes.dex */
public final class ModifyRequestMiddleware$handle$1<H extends Handler<? super Request, ? extends Response>> extends ContinuationImpl {
    public Handler L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ModifyRequestMiddleware<Request, Response> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unknown type variable: Request in type: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware<Request, Response> */
    /* JADX WARN: Unknown type variable: Response in type: aws.smithy.kotlin.runtime.io.middleware.ModifyRequestMiddleware<Request, Response> */
    public ModifyRequestMiddleware$handle$1(ModifyRequestMiddleware<Request, Response> modifyRequestMiddleware, Continuation<? super ModifyRequestMiddleware$handle$1> continuation) {
        super(continuation);
        this.this$0 = modifyRequestMiddleware;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle(null, null, this);
    }
}
