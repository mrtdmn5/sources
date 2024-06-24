package io.ktor.client.plugins.auth.providers;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: AuthTokenHolder.kt */
@DebugMetadata(c = "io.ktor.client.plugins.auth.providers.AuthTokenHolder", f = "AuthTokenHolder.kt", l = {35, 38}, m = "loadToken$ktor_client_auth")
/* loaded from: classes3.dex */
public final class AuthTokenHolder$loadToken$1 extends ContinuationImpl {
    public CompletableDeferred L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ AuthTokenHolder<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthTokenHolder$loadToken$1(AuthTokenHolder<T> authTokenHolder, Continuation<? super AuthTokenHolder$loadToken$1> continuation) {
        super(continuation);
        this.this$0 = authTokenHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadToken$ktor_client_auth(this);
    }
}
