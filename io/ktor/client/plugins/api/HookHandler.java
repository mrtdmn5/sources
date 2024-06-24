package io.ktor.client.plugins.api;

import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: ClientHook.kt */
/* loaded from: classes3.dex */
public final class HookHandler<T> {
    public final T handler;
    public final ClientHook<T> hook;

    /* JADX WARN: Multi-variable type inference failed */
    public HookHandler(ClientHook clientHook, SuspendLambda suspendLambda) {
        this.hook = clientHook;
        this.handler = suspendLambda;
    }
}
