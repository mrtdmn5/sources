package com.amplifyframework.core.plugin;

import android.content.Context;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.core.category.CategoryTypeable;
import org.json.JSONObject;

/* loaded from: classes.dex */
public interface Plugin<E> extends CategoryTypeable {
    void configure(JSONObject jSONObject, Context context) throws AmplifyException;

    E getEscapeHatch();

    String getPluginKey();

    String getVersion();

    void initialize(Context context) throws AmplifyException;
}
