package io.ktor.client.plugins.auth.providers;

import com.animaconnected.secondo.R;
import io.ktor.client.HttpClient;
import io.ktor.client.statement.HttpResponse;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: BearerAuthProvider.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$newToken$1", f = "BearerAuthProvider.kt", l = {R.styleable.AppTheme_stepsHistoryFontDetail, R.styleable.AppTheme_stepsHistoryFontDetail}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BearerAuthProvider$refreshToken$newToken$1 extends SuspendLambda implements Function1<Continuation<? super BearerTokens>, Object> {
    public final /* synthetic */ HttpResponse $response;
    public Function2 L$0;
    public HttpClient L$1;
    public HttpResponse L$2;
    public int label;
    public final /* synthetic */ BearerAuthProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BearerAuthProvider$refreshToken$newToken$1(BearerAuthProvider bearerAuthProvider, HttpResponse httpResponse, Continuation<? super BearerAuthProvider$refreshToken$newToken$1> continuation) {
        super(1, continuation);
        this.this$0 = bearerAuthProvider;
        this.$response = httpResponse;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BearerAuthProvider$refreshToken$newToken$1(this.this$0, this.$response, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super BearerTokens> continuation) {
        return ((BearerAuthProvider$refreshToken$newToken$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Function2<RefreshTokensParams, Continuation<? super BearerTokens>, Object> function2;
        HttpResponse httpResponse;
        HttpClient httpClient;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 != 1) {
                if (r1 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            httpResponse = this.L$2;
            httpClient = this.L$1;
            function2 = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            BearerAuthProvider bearerAuthProvider = this.this$0;
            function2 = bearerAuthProvider.refreshTokens;
            httpResponse = this.$response;
            HttpClient httpClient2 = httpResponse.getCall().client;
            this.L$0 = function2;
            this.L$1 = httpClient2;
            this.L$2 = httpResponse;
            this.label = 1;
            obj = bearerAuthProvider.tokensHolder.loadToken$ktor_client_auth(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
            httpClient = httpClient2;
        }
        RefreshTokensParams refreshTokensParams = new RefreshTokensParams(httpClient, httpResponse);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        obj = function2.invoke(refreshTokensParams, this);
        if (obj == coroutineSingletons) {
            return coroutineSingletons;
        }
        return obj;
    }
}
