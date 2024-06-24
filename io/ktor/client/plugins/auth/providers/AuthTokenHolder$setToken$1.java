package io.ktor.client.plugins.auth.providers;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: AuthTokenHolder.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.AuthTokenHolder", f = "AuthTokenHolder.kt", l = {60, 68}, m = "setToken$ktor_client_auth")
/* loaded from: classes3.dex */
public final class AuthTokenHolder$setToken$1 extends ContinuationImpl {
    public AuthTokenHolder L$0;
    public CompletableDeferred L$1;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AuthTokenHolder<Object> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthTokenHolder$setToken$1(AuthTokenHolder<Object> authTokenHolder, Continuation<? super AuthTokenHolder$setToken$1> continuation) {
        super(continuation);
        this.this$0 = authTokenHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setToken$ktor_client_auth(null, this);
    }
}
