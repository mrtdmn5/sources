package com.google.firebase.crashlytics.internal.network;

import android.util.Log;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.notification.model.Contact;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes3.dex */
public final class HttpGetRequest {
    public final HashMap headers = new HashMap();
    public final Map<String, String> queryParams;
    public final String url;

    public HttpGetRequest(String str, HashMap hashMap) {
        this.url = str;
        this.queryParams = hashMap;
    }

    public static String createUrlWithParams(String str, Map map) throws UnsupportedEncodingException {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        Iterator it = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        if (entry.getValue() == null) {
            str2 = "";
        } else {
            str2 = URLEncoder.encode((String) entry.getValue(), Constants.DEFAULT_ENCODING);
        }
        sb.append(str2);
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append(Contact.PHONE_NUMBERS_DELIMITER);
            sb.append((String) entry2.getKey());
            sb.append("=");
            if (entry2.getValue() == null) {
                str3 = "";
            } else {
                str3 = URLEncoder.encode((String) entry2.getValue(), Constants.DEFAULT_ENCODING);
            }
            sb.append(str3);
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith(Contact.PHONE_NUMBERS_DELIMITER)) {
                sb2 = Contact.PHONE_NUMBERS_DELIMITER.concat(sb2);
            }
            return ComposableInvoker$$ExternalSyntheticOutline0.m(str, sb2);
        }
        return AbstractResolvableFuture$$ExternalSyntheticOutline0.m(str, "?", sb2);
    }

    public final HttpResponse execute() throws IOException {
        Throwable th;
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream = null;
        String sb = null;
        inputStream = null;
        try {
            String createUrlWithParams = createUrlWithParams(this.url, this.queryParams);
            String str = "GET Request URL: " + createUrlWithParams;
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", str, null);
            }
            httpsURLConnection = (HttpsURLConnection) new URL(createUrlWithParams).openConnection();
            try {
                httpsURLConnection.setReadTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
                httpsURLConnection.setConnectTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry entry : this.headers.entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, Constants.DEFAULT_ENCODING));
                        char[] cArr = new char[DfuBaseService.ERROR_REMOTE_MASK];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            sb2.append(cArr, 0, read);
                        }
                        sb = sb2.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, sb);
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            httpsURLConnection = null;
        }
    }
}
