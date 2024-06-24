package com.amplifyframework.core.category;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class CategoryConfiguration implements CategoryTypeable {
    private static final String PLUGINS_KEY = "plugins";
    private final Map<String, JSONObject> pluginConfigs = new ConcurrentHashMap();

    public final JSONObject getPluginConfig(String str) {
        return this.pluginConfigs.get(str);
    }

    public void populateFromJSON(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(PLUGINS_KEY)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(PLUGINS_KEY);
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.pluginConfigs.put(next, jSONObject2.getJSONObject(next));
            }
        }
    }
}
