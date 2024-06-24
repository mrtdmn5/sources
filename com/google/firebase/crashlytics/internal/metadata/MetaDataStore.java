package com.google.firebase.crashlytics.internal.metadata;

import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class MetaDataStore {
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);
    public final FileStore fileStore;

    public MetaDataStore(FileStore fileStore) {
        this.fileStore = fileStore;
    }

    public static HashMap jsonToKeysData(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            String str2 = null;
            if (!jSONObject.isNull(next)) {
                str2 = jSONObject.optString(next, null);
            }
            hashMap.put(next, str2);
        }
        return hashMap;
    }

    public static void safeDeleteCorruptFile(File file) {
        if (file.exists() && file.delete()) {
            Log.i("FirebaseCrashlytics", "Deleted corrupt file: " + file.getAbsolutePath(), null);
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [long] */
    public final Map<String, String> readKeyData(String str, boolean z) {
        File sessionFile;
        FileInputStream fileInputStream;
        Exception e;
        FileStore fileStore = this.fileStore;
        if (z) {
            sessionFile = fileStore.getSessionFile(str, "internal-keys");
        } else {
            sessionFile = fileStore.getSessionFile(str, "keys");
        }
        if (sessionFile.exists()) {
            ?? length = sessionFile.length();
            if (length != 0) {
                Closeable closeable = null;
                try {
                    try {
                        fileInputStream = new FileInputStream(sessionFile);
                    } catch (Exception e2) {
                        fileInputStream = null;
                        e = e2;
                    } catch (Throwable th) {
                        th = th;
                        CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                    try {
                        HashMap jsonToKeysData = jsonToKeysData(CommonUtils.streamToString(fileInputStream));
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return jsonToKeysData;
                    } catch (Exception e3) {
                        e = e3;
                        Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                        safeDeleteCorruptFile(sessionFile);
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return Collections.emptyMap();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    closeable = length;
                    CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                    throw th;
                }
            }
        }
        safeDeleteCorruptFile(sessionFile);
        return Collections.emptyMap();
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    public final String readUserId(String str) {
        FileInputStream fileInputStream;
        String str2;
        File sessionFile = this.fileStore.getSessionFile(str, "user-data");
        Closeable closeable = null;
        if (sessionFile.exists()) {
            ?? r3 = (sessionFile.length() > 0L ? 1 : (sessionFile.length() == 0L ? 0 : -1));
            try {
                if (r3 != 0) {
                    try {
                        fileInputStream = new FileInputStream(sessionFile);
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        CommonUtils.closeOrLog(closeable, "Failed to close user metadata file.");
                        throw th;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject(CommonUtils.streamToString(fileInputStream));
                        if (!jSONObject.isNull("userId")) {
                            str2 = jSONObject.optString("userId", null);
                        } else {
                            str2 = null;
                        }
                        String str3 = "Loaded userId " + str2 + " for session " + str;
                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                            Log.d("FirebaseCrashlytics", str3, null);
                        }
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return str2;
                    } catch (Exception e2) {
                        e = e2;
                        Log.w("FirebaseCrashlytics", "Error deserializing user metadata.", e);
                        safeDeleteCorruptFile(sessionFile);
                        CommonUtils.closeOrLog(fileInputStream, "Failed to close user metadata file.");
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = r3;
            }
        }
        String m = ConstraintSet$$ExternalSyntheticOutline0.m("No userId set for session ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", m, null);
        }
        safeDeleteCorruptFile(sessionFile);
        return null;
    }
}
