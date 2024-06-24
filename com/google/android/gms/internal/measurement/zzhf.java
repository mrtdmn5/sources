package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzhf {
    public final ContentResolver zzc;
    public final Uri zzd;
    public final Runnable zze;
    public final zzhe zzf;
    public final Object zzg;
    public volatile Map zzh;
    public final ArrayList zzi;
    public static final ArrayMap zzb = new ArrayMap();
    public static final String[] zza = {TransferTable.COLUMN_KEY, "value"};

    public zzhf(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhe zzheVar = new zzhe(this);
        this.zzf = zzheVar;
        this.zzg = new Object();
        this.zzi = new ArrayList();
        contentResolver.getClass();
        uri.getClass();
        this.zzc = contentResolver;
        this.zzd = uri;
        this.zze = runnable;
        contentResolver.registerContentObserver(uri, false, zzheVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzhf zza(ContentResolver contentResolver, Uri uri, Runnable runnable) {
        zzhf zzhfVar;
        synchronized (zzhf.class) {
            ArrayMap arrayMap = zzb;
            zzhfVar = (zzhf) arrayMap.getOrDefault(uri, null);
            if (zzhfVar == null) {
                try {
                    zzhf zzhfVar2 = new zzhf(contentResolver, uri, runnable);
                    try {
                        arrayMap.put(uri, zzhfVar2);
                    } catch (SecurityException unused) {
                    }
                    zzhfVar = zzhfVar2;
                } catch (SecurityException unused2) {
                }
            }
        }
        return zzhfVar;
    }

    public static synchronized void zze() {
        synchronized (zzhf.class) {
            Iterator it = ((MapCollections.ValuesCollection) zzb.values()).iterator();
            while (it.hasNext()) {
                zzhf zzhfVar = (zzhf) it.next();
                zzhfVar.zzc.unregisterContentObserver(zzhfVar.zzf);
            }
            zzb.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.StrictMode$ThreadPolicy, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.google.android.gms.internal.measurement.zzhd] */
    public final Map zzc() {
        Map map;
        Map map2;
        Object zza2;
        Map map3 = this.zzh;
        Map map4 = map3;
        if (map3 == null) {
            synchronized (this.zzg) {
                ?? r0 = this.zzh;
                map2 = r0;
                if (r0 == 0) {
                    try {
                        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            ?? r2 = new Object() { // from class: com.google.android.gms.internal.measurement.zzhd
                                public final Object zza() {
                                    Map hashMap;
                                    zzhf zzhfVar = zzhf.this;
                                    Cursor query = zzhfVar.zzc.query(zzhfVar.zzd, zzhf.zza, null, null, null);
                                    if (query == null) {
                                        return Collections.emptyMap();
                                    }
                                    try {
                                        int count = query.getCount();
                                        if (count == 0) {
                                            return Collections.emptyMap();
                                        }
                                        if (count <= 256) {
                                            hashMap = new ArrayMap(count);
                                        } else {
                                            hashMap = new HashMap(count, 1.0f);
                                        }
                                        while (query.moveToNext()) {
                                            hashMap.put(query.getString(0), query.getString(1));
                                        }
                                        query.close();
                                        return hashMap;
                                    } finally {
                                        query.close();
                                    }
                                }
                            };
                            try {
                                zza2 = r2.zza();
                            } catch (SecurityException unused) {
                                long clearCallingIdentity = Binder.clearCallingIdentity();
                                try {
                                    zza2 = r2.zza();
                                } finally {
                                    Binder.restoreCallingIdentity(clearCallingIdentity);
                                }
                            }
                            map = (Map) zza2;
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                        } catch (SQLiteException | IllegalStateException | SecurityException unused2) {
                            Log.e("ConfigurationContentLdr", "PhenotypeFlag unable to load ContentProvider, using default values");
                            StrictMode.setThreadPolicy(allowThreadDiskReads);
                            map = null;
                        }
                        this.zzh = map;
                        map2 = map;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(r0);
                        throw th;
                    }
                }
            }
            map4 = map2;
        }
        if (map4 != null) {
            return map4;
        }
        return Collections.emptyMap();
    }
}
