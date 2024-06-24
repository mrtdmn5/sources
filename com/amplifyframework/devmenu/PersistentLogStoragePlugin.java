package com.amplifyframework.devmenu;

import android.content.Context;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.logging.LoggingPlugin;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class PersistentLogStoragePlugin extends LoggingPlugin<Void> {
    private static final String AMPLIFY_NAMESPACE = "amplify";
    private final Map<String, PersistentLogger> loggers = new HashMap();

    @Override // com.amplifyframework.logging.LoggingCategoryBehavior
    public Logger forNamespace(String str) {
        if (str == null) {
            str = AMPLIFY_NAMESPACE;
        }
        PersistentLogger persistentLogger = this.loggers.get(str);
        if (persistentLogger != null) {
            return persistentLogger;
        }
        PersistentLogger persistentLogger2 = new PersistentLogger(str);
        this.loggers.put(str, persistentLogger2);
        return persistentLogger2;
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public Void getEscapeHatch() {
        return null;
    }

    public List<LogEntry> getLogs() {
        ArrayList arrayList = new ArrayList();
        Iterator<PersistentLogger> it = this.loggers.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getLogs());
        }
        Collections.sort(arrayList);
        return Immutable.of(arrayList);
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getPluginKey() {
        return "PersistentLogStoragePlugin";
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public String getVersion() {
        return "2.5.0";
    }

    @Override // com.amplifyframework.core.plugin.Plugin
    public void configure(JSONObject jSONObject, Context context) {
    }
}
