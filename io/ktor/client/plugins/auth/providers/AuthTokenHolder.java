package io.ktor.client.plugins.auth.providers;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthTokenHolder.kt */
/* loaded from: classes3.dex */
public final class AuthTokenHolder<T> {
    public final Function1<Continuation<? super T>, Object> loadTokens;
    private volatile /* synthetic */ Object loadTokensDeferred;
    private volatile /* synthetic */ Object refreshTokensDeferred;
    public static final /* synthetic */ AtomicReferenceFieldUpdater refreshTokensDeferred$FU = AtomicReferenceFieldUpdater.newUpdater(AuthTokenHolder.class, Object.class, "refreshTokensDeferred");
    public static final /* synthetic */ AtomicReferenceFieldUpdater loadTokensDeferred$FU = AtomicReferenceFieldUpdater.newUpdater(AuthTokenHolder.class, Object.class, "loadTokensDeferred");

    public AuthTokenHolder(BearerAuthConfig$_loadTokens$1 loadTokens) {
        Intrinsics.checkNotNullParameter(loadTokens, "loadTokens");
        this.loadTokens = loadTokens;
        this.refreshTokensDeferred = null;
        this.loadTokensDeferred = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadToken$ktor_client_auth(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.auth.providers.AuthTokenHolder$loadToken$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.auth.providers.AuthTokenHolder$loadToken$1 r0 = (io.ktor.client.plugins.auth.providers.AuthTokenHolder$loadToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.auth.providers.AuthTokenHolder$loadToken$1 r0 = new io.ktor.client.plugins.auth.providers.AuthTokenHolder$loadToken$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlinx.coroutines.CompletableDeferred r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L74
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L34:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L65
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
        L3b:
            java.lang.Object r8 = r7.loadTokensDeferred
            kotlinx.coroutines.CompletableDeferred r8 = (kotlinx.coroutines.CompletableDeferred) r8
            if (r8 != 0) goto L46
            kotlinx.coroutines.CompletableDeferredImpl r2 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default()
            goto L47
        L46:
            r2 = r8
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.client.plugins.auth.providers.AuthTokenHolder.loadTokensDeferred$FU
        L49:
            boolean r6 = r5.compareAndSet(r7, r8, r2)
            if (r6 == 0) goto L51
            r5 = r4
            goto L58
        L51:
            java.lang.Object r6 = r5.get(r7)
            if (r6 == r8) goto L49
            r5 = 0
        L58:
            if (r5 == 0) goto L3b
            if (r8 == 0) goto L66
            r0.label = r4
            java.lang.Object r8 = r8.await(r0)
            if (r8 != r1) goto L65
            return r1
        L65:
            return r8
        L66:
            kotlin.jvm.functions.Function1<kotlin.coroutines.Continuation<? super T>, java.lang.Object> r8 = r7.loadTokens
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r8 = r8.invoke(r0)
            if (r8 != r1) goto L73
            return r1
        L73:
            r0 = r2
        L74:
            if (r0 == 0) goto L7a
            r0.complete(r8)
            return r8
        L7a:
            java.lang.String r8 = "newDeferred"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = 0
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.providers.AuthTokenHolder.loadToken$ktor_client_auth(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object setToken$ktor_client_auth(io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$newToken$1 r9, kotlin.coroutines.Continuation r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof io.ktor.client.plugins.auth.providers.AuthTokenHolder$setToken$1
            if (r0 == 0) goto L13
            r0 = r10
            io.ktor.client.plugins.auth.providers.AuthTokenHolder$setToken$1 r0 = (io.ktor.client.plugins.auth.providers.AuthTokenHolder$setToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.client.plugins.auth.providers.AuthTokenHolder$setToken$1 r0 = new io.ktor.client.plugins.auth.providers.AuthTokenHolder$setToken$1
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3e
            if (r2 == r5) goto L36
            if (r2 != r4) goto L2e
            io.ktor.client.plugins.auth.providers.AuthTokenHolder r9 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L8d
        L2e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L36:
            kotlinx.coroutines.CompletableDeferred r9 = r0.L$1
            io.ktor.client.plugins.auth.providers.AuthTokenHolder r0 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L72
        L3e:
            kotlin.ResultKt.throwOnFailure(r10)
        L41:
            java.lang.Object r10 = r8.refreshTokensDeferred
            kotlinx.coroutines.CompletableDeferred r10 = (kotlinx.coroutines.CompletableDeferred) r10
            if (r10 != 0) goto L4c
            kotlinx.coroutines.CompletableDeferredImpl r2 = kotlinx.coroutines.CompletableDeferredKt.CompletableDeferred$default()
            goto L4d
        L4c:
            r2 = r10
        L4d:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = io.ktor.client.plugins.auth.providers.AuthTokenHolder.refreshTokensDeferred$FU
        L4f:
            boolean r7 = r6.compareAndSet(r8, r10, r2)
            if (r7 == 0) goto L57
            r6 = r5
            goto L5e
        L57:
            java.lang.Object r7 = r6.get(r8)
            if (r7 == r10) goto L4f
            r6 = 0
        L5e:
            if (r6 == 0) goto L41
            if (r10 != 0) goto L81
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r5
            java.lang.Object r9 = r9.invoke(r0)
            if (r9 != r1) goto L6f
            return r1
        L6f:
            r0 = r8
            r10 = r9
            r9 = r2
        L72:
            if (r9 == 0) goto L7b
            r9.complete(r10)
            r0.refreshTokensDeferred = r3
            r9 = r0
            goto L8d
        L7b:
            java.lang.String r9 = "newDeferred"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            throw r3
        L81:
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r10 = r10.await(r0)
            if (r10 != r1) goto L8c
            return r1
        L8c:
            r9 = r8
        L8d:
            kotlinx.coroutines.CompletableDeferredImpl r0 = new kotlinx.coroutines.CompletableDeferredImpl
            r0.<init>(r3)
            r0.makeCompleting$kotlinx_coroutines_core(r10)
            r9.loadTokensDeferred = r0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.auth.providers.AuthTokenHolder.setToken$ktor_client_auth(io.ktor.client.plugins.auth.providers.BearerAuthProvider$refreshToken$newToken$1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
