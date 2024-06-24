package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.compose.runtime.collection.IntMap;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzia implements Runnable {
    public final /* synthetic */ zzib zza;
    public final URL zzb;
    public final IntMap zzd;

    public zzia(zzib zzibVar, String str, URL url, IntMap intMap) {
        this.zza = zzibVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = url;
        this.zzd = intMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0090  */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r10 = this;
            com.google.android.gms.measurement.internal.zzib r0 = r10.zza
            com.google.android.gms.measurement.internal.zzfr r1 = r0.zzt
            com.google.android.gms.measurement.internal.zzfo r1 = r1.zzn
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            r1.zzax()
            com.google.android.gms.measurement.internal.zzfr r0 = r0.zzt
            r1 = 0
            r2 = 0
            java.net.URL r3 = r10.zzb     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            java.net.URLConnection r3 = r3.openConnection()     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            boolean r4 = r3 instanceof java.net.HttpURLConnection     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            if (r4 == 0) goto L83
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r3.setDefaultUseCaches(r1)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r0.getClass()     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r4 = 60000(0xea60, float:8.4078E-41)
            r3.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r0.getClass()     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r0 = 61000(0xee48, float:8.5479E-41)
            r3.setReadTimeout(r0)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r3.setInstanceFollowRedirects(r1)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            r0 = 1
            r3.setDoInput(r0)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            int r0 = r3.getResponseCode()     // Catch: java.lang.Throwable -> L7f java.io.IOException -> L81
            java.util.Map r4 = r3.getHeaderFields()     // Catch: java.lang.Throwable -> L73 java.io.IOException -> L79
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L67
            r5.<init>()     // Catch: java.lang.Throwable -> L67
            java.io.InputStream r6 = r3.getInputStream()     // Catch: java.lang.Throwable -> L67
            r7 = 1024(0x400, float:1.435E-42)
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L65
        L4d:
            int r8 = r6.read(r7)     // Catch: java.lang.Throwable -> L65
            if (r8 <= 0) goto L57
            r5.write(r7, r1, r8)     // Catch: java.lang.Throwable -> L65
            goto L4d
        L57:
            byte[] r1 = r5.toByteArray()     // Catch: java.lang.Throwable -> L65
            r6.close()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L71
            r3.disconnect()
            r10.zzb(r0, r2, r1, r4)
            return
        L65:
            r1 = move-exception
            goto L69
        L67:
            r1 = move-exception
            r6 = r2
        L69:
            if (r6 == 0) goto L6e
            r6.close()     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L71
        L6e:
            throw r1     // Catch: java.lang.Throwable -> L6f java.io.IOException -> L71
        L6f:
            r1 = move-exception
            goto L75
        L71:
            r1 = move-exception
            goto L7b
        L73:
            r1 = move-exception
            r4 = r2
        L75:
            r9 = r1
            r1 = r0
            r0 = r9
            goto L8e
        L79:
            r1 = move-exception
            r4 = r2
        L7b:
            r9 = r1
            r1 = r0
            r0 = r9
            goto L9a
        L7f:
            r0 = move-exception
            goto L8d
        L81:
            r0 = move-exception
            goto L99
        L83:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            java.lang.String r3 = "Failed to obtain HTTP connection"
            r0.<init>(r3)     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
            throw r0     // Catch: java.lang.Throwable -> L8b java.io.IOException -> L97
        L8b:
            r0 = move-exception
            r3 = r2
        L8d:
            r4 = r2
        L8e:
            if (r3 == 0) goto L93
            r3.disconnect()
        L93:
            r10.zzb(r1, r2, r2, r4)
            throw r0
        L97:
            r0 = move-exception
            r3 = r2
        L99:
            r4 = r2
        L9a:
            if (r3 == 0) goto L9f
            r3.disconnect()
        L9f:
            r10.zzb(r1, r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzia.run():void");
    }

    public final void zzb(final int r9, final IOException iOException, final byte[] bArr, final Map map) {
        zzfo zzfoVar = this.zza.zzt.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzp(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzhz
            @Override // java.lang.Runnable
            public final void run() {
                zzfr zzfrVar = (zzfr) zzia.this.zzd.sparseArray;
                zzlb zzlbVar = zzfrVar.zzp;
                int r6 = r9;
                Exception exc = iOException;
                zzeh zzehVar = zzfrVar.zzm;
                if (r6 != 200 && r6 != 204) {
                    if (r6 == 304) {
                        r6 = 304;
                    }
                    zzfr.zzR(zzehVar);
                    zzehVar.zzg.zzc(Integer.valueOf(r6), exc, "Network Request for Deferred Deep Link failed. response, exception");
                }
                if (exc == null) {
                    zzew zzewVar = zzfrVar.zzl;
                    zzfr.zzP(zzewVar);
                    zzewVar.zzn.zza(true);
                    byte[] bArr2 = bArr;
                    if (bArr2 != null && bArr2.length != 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(new String(bArr2));
                            String optString = jSONObject.optString("deeplink", "");
                            String optString2 = jSONObject.optString("gclid", "");
                            double optDouble = jSONObject.optDouble(AnalyticsConstants.KEY_TIMESTAMP, 0.0d);
                            if (TextUtils.isEmpty(optString)) {
                                zzfr.zzR(zzehVar);
                                zzehVar.zzk.zza("Deferred Deep Link is empty.");
                            } else {
                                zzfr.zzP(zzlbVar);
                                zzfr zzfrVar2 = zzlbVar.zzt;
                                if (!TextUtils.isEmpty(optString)) {
                                    Context context = zzfrVar2.zze;
                                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0);
                                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("gclid", optString2);
                                        bundle.putString("_cis", "ddp");
                                        zzfrVar.zzt.zzG("auto", "_cmp", bundle);
                                        if (!TextUtils.isEmpty(optString)) {
                                            try {
                                                SharedPreferences.Editor edit = context.getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
                                                edit.putString("deeplink", optString);
                                                edit.putLong(AnalyticsConstants.KEY_TIMESTAMP, Double.doubleToRawLongBits(optDouble));
                                                if (edit.commit()) {
                                                    context.sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                                                }
                                            } catch (RuntimeException e) {
                                                zzeh zzehVar2 = zzfrVar2.zzm;
                                                zzfr.zzR(zzehVar2);
                                                zzehVar2.zzd.zzb(e, "Failed to persist Deferred Deep Link. exception");
                                            }
                                        }
                                    }
                                }
                                zzfr.zzR(zzehVar);
                                zzehVar.zzg.zzc(optString2, optString, "Deferred Deep Link validation failed. gclid, deep link");
                            }
                            return;
                        } catch (JSONException e2) {
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(e2, "Failed to parse the Deferred Deep Link response. exception");
                            return;
                        }
                    }
                    zzfr.zzR(zzehVar);
                    zzehVar.zzk.zza("Deferred Deep Link response empty.");
                    return;
                }
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzc(Integer.valueOf(r6), exc, "Network Request for Deferred Deep Link failed. response, exception");
            }
        });
    }
}
