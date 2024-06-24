package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpSend;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientPlugin.kt */
/* loaded from: classes3.dex */
public final class HttpClientPluginKt {
    public static final AttributeKey<Attributes> PLUGIN_INSTALLED_LIST = new AttributeKey<>("ApplicationPluginRegistry");

    public static final Object plugin(HttpClient httpClient) {
        HttpSend.Plugin plugin = HttpSend.Plugin;
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Object pluginOrNull = pluginOrNull(httpClient, plugin);
        if (pluginOrNull != null) {
            return pluginOrNull;
        }
        throw new IllegalStateException("Plugin " + plugin + " is not installed. Consider using `install(" + HttpSend.key + ")` in client config first.");
    }

    public static final <B, F> F pluginOrNull(HttpClient httpClient, HttpClientPlugin<? extends B, F> plugin) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Attributes attributes = (Attributes) httpClient.attributes.getOrNull(PLUGIN_INSTALLED_LIST);
        if (attributes != null) {
            return (F) attributes.getOrNull(plugin.getKey());
        }
        return null;
    }
}
