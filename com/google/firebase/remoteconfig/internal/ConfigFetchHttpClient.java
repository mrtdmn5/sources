package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.content.pm.PackageInfoCompat$Api28Impl;
import com.amazonaws.util.DateUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import j$.util.DesugarTimeZone;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigFetchHttpClient {
    public static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    public final String apiKey;
    public final String appId;
    public final long connectTimeoutInSeconds;
    public final Context context;
    public final String namespace;
    public final String projectNumber;
    public final long readTimeoutInSeconds;

    public ConfigFetchHttpClient(Context context, String str, String str2, long j, long j2) {
        String str3;
        this.context = context;
        this.appId = str;
        this.apiKey = str2;
        Matcher matcher = GMP_APP_ID_PATTERN.matcher(str);
        if (matcher.matches()) {
            str3 = matcher.group(1);
        } else {
            str3 = null;
        }
        this.projectNumber = str3;
        this.namespace = "firebase";
        this.connectTimeoutInSeconds = j;
        this.readTimeoutInSeconds = j2;
    }

    public static JSONObject getFetchResponseBody(URLConnection uRLConnection) throws IOException, JSONException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream(), "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read();
            if (read != -1) {
                sb.append((char) read);
            } else {
                return new JSONObject(sb.toString());
            }
        }
    }

    public static void setFetchRequestBody(HttpURLConnection httpURLConnection, byte[] bArr) throws IOException {
        httpURLConnection.setFixedLengthStreamingMode(bArr.length);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
        bufferedOutputStream.write(bArr);
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
    }

    public final JSONObject createFetchRequestBody(String str, String str2, Map<String, String> map, Long l) throws FirebaseRemoteConfigClientException {
        long j;
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("appInstanceId", str);
            hashMap.put("appInstanceIdToken", str2);
            hashMap.put("appId", this.appId);
            Context context = this.context;
            Locale locale = context.getResources().getConfiguration().locale;
            hashMap.put("countryCode", locale.getCountry());
            int r1 = Build.VERSION.SDK_INT;
            hashMap.put("languageCode", locale.toLanguageTag());
            hashMap.put("platformVersion", Integer.toString(r1));
            hashMap.put("timeZone", TimeZone.getDefault().getID());
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                if (packageInfo != null) {
                    hashMap.put("appVersion", packageInfo.versionName);
                    if (r1 >= 28) {
                        j = PackageInfoCompat$Api28Impl.getLongVersionCode(packageInfo);
                    } else {
                        j = packageInfo.versionCode;
                    }
                    hashMap.put("appBuild", Long.toString(j));
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            hashMap.put("packageName", context.getPackageName());
            hashMap.put("sdkVersion", "21.2.1");
            hashMap.put("analyticsUserProperties", new JSONObject(map));
            if (l != null) {
                long longValue = l.longValue();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateUtils.ISO8601_DATE_PATTERN, Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                hashMap.put("firstOpenTime", simpleDateFormat.format(Long.valueOf(longValue)));
            }
            return new JSONObject(hashMap);
        }
        throw new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x009b A[LOOP:0: B:8:0x0095->B:11:0x009b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cd A[Catch: IOException | JSONException -> 0x0164, IOException -> 0x0166, all -> 0x016f, TRY_LEAVE, TryCatch #6 {all -> 0x016f, blocks: (B:13:0x00b1, B:15:0x00cd, B:69:0x015a, B:70:0x0163, B:72:0x0167, B:73:0x016e), top: B:9:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015a A[Catch: IOException | JSONException -> 0x0164, IOException -> 0x0166, all -> 0x016f, TRY_ENTER, TryCatch #6 {all -> 0x016f, blocks: (B:13:0x00b1, B:15:0x00cd, B:69:0x015a, B:70:0x0163, B:72:0x0167, B:73:0x016e), top: B:9:0x0099 }] */
    @androidx.annotation.Keep
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.firebase.remoteconfig.internal.ConfigFetchHandler.FetchResponse fetch(java.net.HttpURLConnection r7, java.lang.String r8, java.lang.String r9, java.util.Map<java.lang.String, java.lang.String> r10, java.lang.String r11, java.util.Map<java.lang.String, java.lang.String> r12, java.lang.Long r13, java.util.Date r14) throws com.google.firebase.remoteconfig.FirebaseRemoteConfigException {
        /*
            Method dump skipped, instructions count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient.fetch(java.net.HttpURLConnection, java.lang.String, java.lang.String, java.util.Map, java.lang.String, java.util.Map, java.lang.Long, java.util.Date):com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse");
    }
}
