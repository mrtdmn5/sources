package com.amplifyframework.logging;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class JavaLoggingPlugin extends LoggingPlugin<Void> {
    private static final String AMPLIFY_NAMESPACE = "amplify";
    private final LogLevel defaultLoggerThreshold;

    public JavaLoggingPlugin() {
        this(LogLevel.INFO);
    }

    @Override // com.amplifyframework.logging.LoggingCategoryBehavior
    public Logger forNamespace(String str) {
        if (str == null) {
            str = AMPLIFY_NAMESPACE;
        }
        return new JavaLogger(str, this.defaultLoggerThreshold);
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public Void getEscapeHatch() {
        return null;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getPluginKey() {
        return "JavaLoggingPlugin";
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getVersion() {
        return "2.5.0";
    }

    public JavaLoggingPlugin(LogLevel logLevel) {
        this.defaultLoggerThreshold = logLevel;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void configure(JSONObject jSONObject, Context context) {
    }
}
