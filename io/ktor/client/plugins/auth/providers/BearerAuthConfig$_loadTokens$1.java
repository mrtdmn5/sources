package io.ktor.client.plugins.auth.providers;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* compiled from: BearerAuthProvider.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.BearerAuthConfig$_loadTokens$1", f = "BearerAuthProvider.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BearerAuthConfig$_loadTokens$1 extends SuspendLambda implements Function1<Continuation, Object> {
    public BearerAuthConfig$_loadTokens$1(Continuation<? super BearerAuthConfig$_loadTokens$1> continuation) {
        super(1, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new BearerAuthConfig$_loadTokens$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        new BearerAuthConfig$_loadTokens$1(continuation).invokeSuspend(Unit.INSTANCE);
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return null;
    }
}
