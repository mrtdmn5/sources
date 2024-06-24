package io.ktor.client.plugins.auth.providers;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: BearerAuthProvider.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.BearerAuthConfig$_refreshTokens$1", f = "BearerAuthProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BearerAuthConfig$_refreshTokens$1 extends SuspendLambda implements Function2<RefreshTokensParams, Continuation, Object> {
    public BearerAuthConfig$_refreshTokens$1(Continuation<? super BearerAuthConfig$_refreshTokens$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BearerAuthConfig$_refreshTokens$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(RefreshTokensParams refreshTokensParams, Continuation continuation) {
        new BearerAuthConfig$_refreshTokens$1(continuation).invokeSuspend(Unit.INSTANCE);
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return null;
    }
}
