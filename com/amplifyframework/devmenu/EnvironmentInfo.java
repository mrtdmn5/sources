package com.amplifyframework.devmenu;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.Resources;
import com.amplifyframework.core.category.Category;
import com.amplifyframework.core.plugin.Plugin;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class EnvironmentInfo {
    private static final String DEV_ENV_INFO_FILE_NAME = "localenvinfo";
    private final Map<String, String> devEnvironmentItems;

    public EnvironmentInfo() {
        HashMap hashMap = new HashMap();
        this.devEnvironmentItems = hashMap;
        hashMap.put("nodejsVersion", "Node.js Version");
        hashMap.put("npmVersion", "NPM Version");
        hashMap.put("amplifyCliVersion", "Amplify CLI Version");
        hashMap.put("androidStudioVersion", "Android Studio Version");
        hashMap.put("osName", "OS");
        hashMap.put("osVersion", "OS Version");
    }

    private String getCategoryPluginVersions(Category<?> category) {
        StringBuilder sb = new StringBuilder();
        Iterator<?> it = category.getPlugins().iterator();
        while (it.hasNext()) {
            Plugin plugin = (Plugin) it.next();
            sb.append(plugin.getPluginKey() + ": " + plugin.getVersion() + "\n");
        }
        return sb.toString();
    }

    public String getDeveloperEnvironmentInfo(Context context) throws AmplifyException {
        Objects.requireNonNull(context);
        try {
            JSONObject readJsonResource = Resources.readJsonResource(context.getApplicationContext(), DEV_ENV_INFO_FILE_NAME);
            StringBuilder sb = new StringBuilder();
            for (String str : this.devEnvironmentItems.keySet()) {
                if (readJsonResource.has(str)) {
                    try {
                        sb.append(this.devEnvironmentItems.get(str) + ": " + readJsonResource.getString(str) + "\n");
                    } catch (JSONException e) {
                        throw new AmplifyException("Error reading the developer environment information.", e, "Check that localenvinfo.json is properly formatted");
                    }
                }
            }
            return sb.toString();
        } catch (Resources.ResourceLoadingException e2) {
            throw new AmplifyException("Failed to find localenvinfo.", e2, "Please ensure it is present in your project.");
        }
    }

    public String getPluginVersions() {
        StringBuilder sb = new StringBuilder();
        Iterator<Category<? extends Plugin<?>>> it = Amplify.getCategoriesMap().values().iterator();
        while (it.hasNext()) {
            sb.append(getCategoryPluginVersions(it.next()));
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            return "No plugins added.";
        }
        return sb2;
    }
}
