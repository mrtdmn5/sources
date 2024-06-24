package com.amazonaws.mobileconnectors.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.Base64;
import com.amazonaws.util.StringUtils;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ClientContext {
    private static final Log LOGGER = LogFactory.getLog((Class<?>) ClientContext.class);
    static final String SHARED_PREFERENCES = "com.amazonaws.common";
    private String base64String;
    private final JSONObject json;

    public ClientContext(Context context) {
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            this.json = jSONObject;
            try {
                jSONObject.put("client", getClientInfo(context)).put(AnalyticsConstants.KEY_ENVIRONMENT, getDeviceInfo(context));
                return;
            } catch (JSONException e) {
                throw new AmazonClientException("Failed to build client context", e);
            }
        }
        throw new IllegalArgumentException("Context can't be null");
    }

    public static JSONObject getClientInfo(Context context) throws JSONException {
        String charSequence;
        JSONObject jSONObject = new JSONObject();
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            jSONObject.put("installation_id", getInstallationId(context)).put("app_version_name", packageInfo.versionName).put("app_version_code", String.valueOf(packageInfo.versionCode)).put("app_package_name", packageInfo.packageName);
            CharSequence applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            if (applicationLabel == null) {
                charSequence = "Unknown";
            } else {
                charSequence = applicationLabel.toString();
            }
            jSONObject.put("app_title", charSequence);
        } catch (PackageManager.NameNotFoundException e) {
            LOGGER.warn("Failed to load package info: " + context.getPackageName(), e);
        }
        return jSONObject;
    }

    public static JSONObject getDeviceInfo(Context context) throws JSONException {
        return new JSONObject().put("platform", "Android").put("model", Build.MODEL).put("make", Build.MANUFACTURER).put("platform_version", Build.VERSION.RELEASE).put("locale", Locale.getDefault().toString());
    }

    public static String getInstallationId(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, 0);
        String string = sharedPreferences.getString("installation_id", null);
        if (string == null) {
            String str = UUID.randomUUID().toString();
            sharedPreferences.edit().putString("installation_id", str).commit();
            return str;
        }
        return string;
    }

    public JSONObject getJson() {
        return this.json;
    }

    public void putCustomContext(Map<String, String> map) {
        this.base64String = null;
        try {
            this.json.put("custom", new JSONObject(map));
        } catch (JSONException e) {
            throw new AmazonClientException("Failed to add user defined context", e);
        }
    }

    public void putServiceContext(String str, Map<String, String> map) {
        this.base64String = null;
        try {
            if (!this.json.has("services")) {
                this.json.put("services", new JSONObject());
            }
            this.json.getJSONObject("services").put(str, new JSONObject(map));
        } catch (JSONException e) {
            throw new AmazonClientException("Failed to add service context", e);
        }
    }

    public String toBase64String() {
        if (this.base64String == null) {
            synchronized (this) {
                if (this.base64String == null) {
                    this.base64String = Base64.encodeAsString(this.json.toString().getBytes(StringUtils.UTF8));
                }
            }
        }
        return this.base64String;
    }
}
