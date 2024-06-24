package io.ktor.client.plugins.api;

import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: ClientPluginInstance.kt */
/* loaded from: classes3.dex */
public final class ClientPluginInstance<PluginConfig> implements Closeable {
    public final Function1<ClientPluginBuilder<PluginConfig>, Unit> body;
    public final PluginConfig config;
    public final String name;
    public Lambda onClose;

    /* JADX WARN: Multi-variable type inference failed */
    public ClientPluginInstance(PluginConfig config, String name, Function1<? super ClientPluginBuilder<PluginConfig>, Unit> body) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        this.config = config;
        this.name = name;
        this.body = body;
        this.onClose = new Function0<Unit>() { // from class: io.ktor.client.plugins.api.ClientPluginInstance$onClose$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.functions.Function0, kotlin.jvm.internal.Lambda] */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.onClose.invoke();
    }
}
