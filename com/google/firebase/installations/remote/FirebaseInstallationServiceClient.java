package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.amazonaws.http.HttpHeader;
import com.amazonaws.services.s3.internal.Constants;
import com.amplifyframework.auth.cognito.data.AWSCognitoLegacyCredentialStore;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.heartbeatinfo.HeartBeatController;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class FirebaseInstallationServiceClient {
    public static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    public static final Charset UTF_8 = Charset.forName(Constants.DEFAULT_ENCODING);
    public final Context context;
    public final Provider<HeartBeatController> heartBeatProvider;
    public final RequestLimiter requestLimiter = new RequestLimiter();

    public FirebaseInstallationServiceClient(Context context, Provider<HeartBeatController> provider) {
        this.context = context;
        this.heartBeatProvider = provider;
    }

    public static URL getFullyQualifiedRequestUri(String str) throws FirebaseInstallationsException {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e) {
            String message = e.getMessage();
            FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.BAD_CONFIG;
            throw new FirebaseInstallationsException(message);
        }
    }

    public static void logFisCommunicationError(HttpURLConnection httpURLConnection, String str, String str2, String str3) {
        String m;
        InputStream errorStream = httpURLConnection.getErrorStream();
        String str4 = null;
        if (errorStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, UTF_8));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append('\n');
                }
                str4 = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            Log.w("Firebase-Installations", str4);
            Object[] objArr = new Object[3];
            objArr[0] = str2;
            objArr[1] = str3;
            if (TextUtils.isEmpty(str)) {
                m = "";
            } else {
                m = ConstraintSet$$ExternalSyntheticOutline0.m(", ", str);
            }
            objArr[2] = m;
            Log.w("Firebase-Installations", String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objArr));
        }
    }

    public static long parseTokenExpirationTimestamp(String str) {
        Preconditions.checkArgument("Invalid Expiration Timestamp.", EXPIRATION_TIMESTAMP_PATTERN.matcher(str).matches());
        if (str != null && str.length() != 0) {
            return Long.parseLong(str.substring(0, str.length() - 1));
        }
        return 0L;
    }

    public static AutoValue_InstallationResponse readCreateResponse(HttpURLConnection httpURLConnection) throws AssertionError, IOException {
        String str;
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        Long l = 0L;
        jsonReader.beginObject();
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        AutoValue_TokenResult autoValue_TokenResult = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                str3 = jsonReader.nextString();
            } else if (nextName.equals("fid")) {
                str4 = jsonReader.nextString();
            } else if (nextName.equals("refreshToken")) {
                str5 = jsonReader.nextString();
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals(AWSCognitoLegacyCredentialStore.TOKEN_KEY)) {
                        str2 = jsonReader.nextString();
                    } else if (nextName2.equals("expiresIn")) {
                        l = Long.valueOf(parseTokenExpirationTimestamp(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                if (l == null) {
                    str = " tokenExpirationTimestamp";
                } else {
                    str = "";
                }
                if (str.isEmpty()) {
                    autoValue_TokenResult = new AutoValue_TokenResult(str2, l.longValue(), null);
                    jsonReader.endObject();
                } else {
                    throw new IllegalStateException("Missing required properties:".concat(str));
                }
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return new AutoValue_InstallationResponse(str3, str4, str5, autoValue_TokenResult, InstallationResponse.ResponseCode.OK);
    }

    public static AutoValue_TokenResult readGenerateAuthTokenResponse(HttpURLConnection httpURLConnection) throws AssertionError, IOException {
        String str;
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, UTF_8));
        Long l = 0L;
        jsonReader.beginObject();
        String str2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals(AWSCognitoLegacyCredentialStore.TOKEN_KEY)) {
                str2 = jsonReader.nextString();
            } else if (nextName.equals("expiresIn")) {
                l = Long.valueOf(parseTokenExpirationTimestamp(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        TokenResult.ResponseCode responseCode = TokenResult.ResponseCode.OK;
        if (l == null) {
            str = " tokenExpirationTimestamp";
        } else {
            str = "";
        }
        if (str.isEmpty()) {
            return new AutoValue_TokenResult(str2, l.longValue(), responseCode);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public static void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:17.1.3");
            writeRequestBodyToOutputStream(httpURLConnection, jSONObject.toString().getBytes(Constants.DEFAULT_ENCODING));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) throws IOException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:17.1.3");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            writeRequestBodyToOutputStream(httpURLConnection, jSONObject2.toString().getBytes(Constants.DEFAULT_ENCODING));
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void writeRequestBodyToOutputStream(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream != null) {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
                try {
                    return;
                } catch (IOException unused) {
                    return;
                }
            } finally {
                try {
                    gZIPOutputStream.close();
                    outputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
    }

    public final HttpURLConnection openHttpURLConnection(URL url, String str) throws FirebaseInstallationsException {
        String str2;
        byte[] packageCertificateHashBytes;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(Constants.MAXIMUM_UPLOAD_PARTS);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty(HttpHeader.ACCEPT, "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            Context context = this.context;
            httpURLConnection.addRequestProperty("X-Android-Package", context.getPackageName());
            HeartBeatController heartBeatController = this.heartBeatProvider.get();
            if (heartBeatController != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) Tasks.await(heartBeatController.getHeartBeatsHeader()));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                } catch (ExecutionException e2) {
                    Log.w("ContentValues", "Failed to get heartbeats header", e2);
                }
            }
            try {
                packageCertificateHashBytes = AndroidUtilsLight.getPackageCertificateHashBytes(context, context.getPackageName());
            } catch (PackageManager.NameNotFoundException e3) {
                Log.e("ContentValues", "No such package: " + context.getPackageName(), e3);
            }
            if (packageCertificateHashBytes == null) {
                Log.e("ContentValues", "Could not get fingerprint hash for package: " + context.getPackageName());
                str2 = null;
                httpURLConnection.addRequestProperty("X-Android-Cert", str2);
                httpURLConnection.addRequestProperty("x-goog-api-key", str);
                return httpURLConnection;
            }
            str2 = Hex.bytesToStringUppercase(packageCertificateHashBytes);
            httpURLConnection.addRequestProperty("X-Android-Cert", str2);
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            FirebaseInstallationsException.Status status = FirebaseInstallationsException.Status.BAD_CONFIG;
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.");
        }
    }
}
