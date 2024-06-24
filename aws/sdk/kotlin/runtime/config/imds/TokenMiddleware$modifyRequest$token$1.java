package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.time.Clock;
import aws.smithy.kotlin.runtime.util.ExpiringValue;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: TokenMiddleware.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.TokenMiddleware$modifyRequest$token$1", f = "TokenMiddleware.kt", l = {45}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class TokenMiddleware$modifyRequest$token$1 extends SuspendLambda implements Function1<Continuation<? super ExpiringValue<Token>>, Object> {
    public final /* synthetic */ OperationRequest<HttpRequestBuilder> $req;
    public int label;
    public final /* synthetic */ TokenMiddleware this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenMiddleware$modifyRequest$token$1(TokenMiddleware tokenMiddleware, OperationRequest<HttpRequestBuilder> operationRequest, Continuation<? super TokenMiddleware$modifyRequest$token$1> continuation) {
        super(1, continuation);
        this.this$0 = tokenMiddleware;
        this.$req = operationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new TokenMiddleware$modifyRequest$token$1(this.this$0, this.$req, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super ExpiringValue<Token>> continuation) {
        return ((TokenMiddleware$modifyRequest$token$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
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
            TokenMiddleware tokenMiddleware = this.this$0;
            Clock clock = tokenMiddleware.clock;
            this.label = 1;
            obj = TokenMiddleware.access$getToken(tokenMiddleware, clock, this.$req, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        Token token = (Token) obj;
        return new ExpiringValue(token, token.expires);
    }
}
