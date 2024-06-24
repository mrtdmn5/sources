package com.google.firebase.messaging;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public final class NotificationParams {
    public final Bundle data;

    public NotificationParams(Bundle bundle) {
        this.data = new Bundle(bundle);
    }

    public static boolean isNotification(Bundle bundle) {
        if (!"1".equals(bundle.getString("gcm.n.e")) && !"1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")))) {
            return false;
        }
        return true;
    }

    public static String userFriendlyKey(String str) {
        if (str.startsWith("gcm.n.")) {
            return str.substring(6);
        }
        return str;
    }

    public final boolean getBoolean(String str) {
        String string = getString(str);
        if (!"1".equals(string) && !Boolean.parseBoolean(string)) {
            return false;
        }
        return true;
    }

    public final Integer getInteger(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return Integer.valueOf(Integer.parseInt(string));
            } catch (NumberFormatException unused) {
                Log.w("NotificationParams", "Couldn't parse value of " + userFriendlyKey(str) + "(" + string + ") into an int");
                return null;
            }
        }
        return null;
    }

    public final JSONArray getJSONArray(String str) {
        String string = getString(str);
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONArray(string);
            } catch (JSONException unused) {
                Log.w("NotificationParams", "Malformed JSON for key " + userFriendlyKey(str) + ": " + string + ", falling back to default");
                return null;
            }
        }
        return null;
    }

    public final String getPossiblyLocalizedString(Resources resources, String str, String str2) {
        String[] strArr;
        String string = getString(str2);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String string2 = getString(str2.concat("_loc_key"));
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        int identifier = resources.getIdentifier(string2, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", userFriendlyKey(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        JSONArray jSONArray = getJSONArray(str2.concat("_loc_args"));
        if (jSONArray == null) {
            strArr = null;
        } else {
            int length = jSONArray.length();
            strArr = new String[length];
            for (int r6 = 0; r6 < length; r6++) {
                strArr[r6] = jSONArray.optString(r6);
            }
        }
        if (strArr == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, strArr);
        } catch (MissingFormatArgumentException e) {
            Log.w("NotificationParams", "Missing format argument for " + userFriendlyKey(str2) + ": " + Arrays.toString(strArr) + " Default value will be used.", e);
            return null;
        }
    }

    public final String getString(String str) {
        String replace;
        Bundle bundle = this.data;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            if (!str.startsWith("gcm.n.")) {
                replace = str;
            } else {
                replace = str.replace("gcm.n.", "gcm.notification.");
            }
            if (bundle.containsKey(replace)) {
                str = replace;
            }
        }
        return bundle.getString(str);
    }

    public final Bundle paramsForAnalyticsIntent() {
        boolean z;
        Bundle bundle = this.data;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }
}
