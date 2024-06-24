package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClientPluginBuilder.kt */
/* loaded from: classes3.dex */
public final class ClientPluginBuilder<PluginConfig> {
    public final ArrayList hooks;
    public final ClientPluginBuilder$onClose$1 onClose;
    public final PluginConfig pluginConfig;

    public ClientPluginBuilder(AttributeKey<ClientPluginInstance<PluginConfig>> attributeKey, HttpClient client, PluginConfig pluginConfig) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(pluginConfig, "pluginConfig");
        this.pluginConfig = pluginConfig;
        this.hooks = new ArrayList();
        this.onClose = ClientPluginBuilder$onClose$1.INSTANCE;
    }
}
