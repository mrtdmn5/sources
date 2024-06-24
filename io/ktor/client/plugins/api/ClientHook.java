package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;

/* compiled from: ClientHook.kt */
/* loaded from: classes3.dex */
public interface ClientHook<HookHandler> {
    void install(HttpClient httpClient, HookHandler hookhandler);
}
