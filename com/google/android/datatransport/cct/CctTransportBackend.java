package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.constraintlayout.widget.ConstraintSet$$ExternalSyntheticOutline0;
import com.google.android.datatransport.cct.internal.AutoBatchedLogRequestEncoder;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public final class CctTransportBackend implements TransportBackend {
    public final Context applicationContext;
    public final ConnectivityManager connectivityManager;
    public final JsonDataEncoderBuilder.AnonymousClass1 dataEncoder;
    public final URL endPoint;
    public final int readTimeout;
    public final Clock uptimeClock;
    public final Clock wallTimeClock;

    /* loaded from: classes3.dex */
    public static final class HttpRequest {
        public final String apiKey;
        public final BatchedLogRequest requestBody;
        public final URL url;

        public HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.url = url;
            this.requestBody = batchedLogRequest;
            this.apiKey = str;
        }
    }

    /* loaded from: classes3.dex */
    public static final class HttpResponse {
        public final int code;
        public final long nextRequestMillis;
        public final URL redirectUrl;

        public HttpResponse(int r1, URL url, long j) {
            this.code = r1;
            this.redirectUrl = url;
            this.nextRequestMillis = j;
        }
    }

    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        JsonDataEncoderBuilder jsonDataEncoderBuilder = new JsonDataEncoderBuilder();
        AutoBatchedLogRequestEncoder.CONFIG.configure(jsonDataEncoderBuilder);
        jsonDataEncoderBuilder.ignoreNullValues = true;
        this.dataEncoder = new JsonDataEncoderBuilder.AnonymousClass1();
        this.applicationContext = context;
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String str = CCTDestination.DEFAULT_END_POINT;
        try {
            this.endPoint = new URL(str);
            this.uptimeClock = clock2;
            this.wallTimeClock = clock;
            this.readTimeout = 130000;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(ConstraintSet$$ExternalSyntheticOutline0.m("Invalid url: ", str), e);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public final AutoValue_EventInternal decorate(EventInternal eventInternal) {
        int type;
        int subtype;
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        AutoValue_EventInternal.Builder builder = eventInternal.toBuilder();
        int r1 = Build.VERSION.SDK_INT;
        Map<String, String> map = builder.autoMetadata;
        if (map != null) {
            map.put("sdk-version", String.valueOf(r1));
            builder.addMetadata("model", Build.MODEL);
            builder.addMetadata("hardware", Build.HARDWARE);
            builder.addMetadata("device", Build.DEVICE);
            builder.addMetadata("product", Build.PRODUCT);
            builder.addMetadata("os-uild", Build.ID);
            builder.addMetadata("manufacturer", Build.MANUFACTURER);
            builder.addMetadata("fingerprint", Build.FINGERPRINT);
            Calendar.getInstance();
            long offset = TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
            Map<String, String> map2 = builder.autoMetadata;
            if (map2 != null) {
                map2.put("tz-offset", String.valueOf(offset));
                if (activeNetworkInfo == null) {
                    type = NetworkConnectionInfo.NetworkType.NONE.getValue();
                } else {
                    type = activeNetworkInfo.getType();
                }
                Map<String, String> map3 = builder.autoMetadata;
                if (map3 != null) {
                    map3.put("net-type", String.valueOf(type));
                    int r2 = -1;
                    if (activeNetworkInfo == null) {
                        subtype = NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
                    } else {
                        subtype = activeNetworkInfo.getSubtype();
                        if (subtype == -1) {
                            subtype = NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
                        } else if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) == null) {
                            subtype = 0;
                        }
                    }
                    Map<String, String> map4 = builder.autoMetadata;
                    if (map4 != null) {
                        map4.put("mobile-subtype", String.valueOf(subtype));
                        builder.addMetadata("country", Locale.getDefault().getCountry());
                        builder.addMetadata("locale", Locale.getDefault().getLanguage());
                        Context context = this.applicationContext;
                        builder.addMetadata("mcc_mnc", ((TelephonyManager) context.getSystemService("phone")).getSimOperator());
                        try {
                            r2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                        } catch (PackageManager.NameNotFoundException e) {
                            Logging.e("CctTransportBackend", "Unable to find version code for package", e);
                        }
                        builder.addMetadata("application_build", Integer.toString(r2));
                        return builder.build();
                    }
                    throw new IllegalStateException("Property \"autoMetadata\" has not been set");
                }
                throw new IllegalStateException("Property \"autoMetadata\" has not been set");
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        throw new IllegalStateException("Property \"autoMetadata\" has not been set");
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x0428 A[Catch: IOException -> 0x047b, TryCatch #14 {IOException -> 0x047b, blocks: (B:81:0x029b, B:84:0x02a9, B:87:0x02bb, B:88:0x02c8, B:90:0x030c, B:100:0x0331, B:102:0x0343, B:103:0x0350, B:112:0x0373, B:114:0x0424, B:116:0x0428, B:119:0x0437, B:124:0x0440, B:126:0x0446, B:135:0x045d, B:137:0x0467, B:139:0x0471, B:142:0x037d, B:152:0x03af, B:179:0x03ce, B:178:0x03cb, B:181:0x03cf, B:207:0x0400, B:209:0x0414, B:144:0x0381, B:146:0x038b, B:150:0x03aa, B:165:0x03c0, B:164:0x03bd, B:148:0x0392, B:159:0x03b7, B:173:0x03c5), top: B:80:0x029b, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0437 A[Catch: IOException -> 0x047b, TryCatch #14 {IOException -> 0x047b, blocks: (B:81:0x029b, B:84:0x02a9, B:87:0x02bb, B:88:0x02c8, B:90:0x030c, B:100:0x0331, B:102:0x0343, B:103:0x0350, B:112:0x0373, B:114:0x0424, B:116:0x0428, B:119:0x0437, B:124:0x0440, B:126:0x0446, B:135:0x045d, B:137:0x0467, B:139:0x0471, B:142:0x037d, B:152:0x03af, B:179:0x03ce, B:178:0x03cb, B:181:0x03cf, B:207:0x0400, B:209:0x0414, B:144:0x0381, B:146:0x038b, B:150:0x03aa, B:165:0x03c0, B:164:0x03bd, B:148:0x0392, B:159:0x03b7, B:173:0x03c5), top: B:80:0x029b, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0446 A[Catch: IOException -> 0x047b, TryCatch #14 {IOException -> 0x047b, blocks: (B:81:0x029b, B:84:0x02a9, B:87:0x02bb, B:88:0x02c8, B:90:0x030c, B:100:0x0331, B:102:0x0343, B:103:0x0350, B:112:0x0373, B:114:0x0424, B:116:0x0428, B:119:0x0437, B:124:0x0440, B:126:0x0446, B:135:0x045d, B:137:0x0467, B:139:0x0471, B:142:0x037d, B:152:0x03af, B:179:0x03ce, B:178:0x03cb, B:181:0x03cf, B:207:0x0400, B:209:0x0414, B:144:0x0381, B:146:0x038b, B:150:0x03aa, B:165:0x03c0, B:164:0x03bd, B:148:0x0392, B:159:0x03b7, B:173:0x03c5), top: B:80:0x029b, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0440 A[ADDED_TO_REGION, EDGE_INSN: B:141:0x0440->B:124:0x0440 BREAK  A[LOOP:3: B:83:0x02a7->B:121:0x043d], SYNTHETIC] */
    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse send(com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest r31) {
        /*
            Method dump skipped, instructions count: 1163
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.cct.CctTransportBackend.send(com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest):com.google.android.datatransport.runtime.backends.AutoValue_BackendResponse");
    }
}
