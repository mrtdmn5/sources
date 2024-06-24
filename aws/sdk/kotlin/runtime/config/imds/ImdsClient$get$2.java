package aws.sdk.kotlin.runtime.config.imds;

import aws.smithy.kotlin.runtime.http.operation.OperationRequest;
import aws.smithy.kotlin.runtime.http.request.HttpRequestBuilder;
import aws.smithy.kotlin.runtime.io.Handler;
import aws.smithy.kotlin.runtime.net.UrlBuilder;
import com.animaconnected.secondo.R;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImdsClient.kt */
@DebugMetadata(c = "aws.sdk.kotlin.runtime.config.imds.ImdsClient$get$2", f = "ImdsClient.kt", l = {R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ImdsClient$get$2 extends SuspendLambda implements Function3<OperationRequest<HttpRequestBuilder>, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends String>, Continuation<? super String>, Object> {
    public final /* synthetic */ String $path;
    public /* synthetic */ OperationRequest L$0;
    public /* synthetic */ Handler L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImdsClient$get$2(String str, Continuation<? super ImdsClient$get$2> continuation) {
        super(3, continuation);
        this.$path = str;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(OperationRequest<HttpRequestBuilder> operationRequest, Handler<? super OperationRequest<HttpRequestBuilder>, ? extends String> handler, Continuation<? super String> continuation) {
        ImdsClient$get$2 imdsClient$get$2 = new ImdsClient$get$2(this.$path, continuation);
        imdsClient$get$2.L$0 = operationRequest;
        imdsClient$get$2.L$1 = handler;
        return imdsClient$get$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
            OperationRequest operationRequest = this.L$0;
            Handler handler = this.L$1;
            UrlBuilder urlBuilder = ((HttpRequestBuilder) operationRequest.subject).url;
            urlBuilder.getClass();
            String str = this.$path;
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            urlBuilder.path = str;
            this.L$0 = null;
            this.label = 1;
            obj = handler.call(operationRequest, this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
