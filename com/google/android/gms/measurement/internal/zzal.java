package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzal extends SQLiteOpenHelper {
    public final /* synthetic */ zzam zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzal(zzam zzamVar, Context context) {
        super(context, "google_app_measurement.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzamVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007e  */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.database.sqlite.SQLiteDatabase getWritableDatabase() {
        /*
            r9 = this;
            com.google.android.gms.measurement.internal.zzam r0 = r9.zza
            com.google.android.gms.measurement.internal.zzkd r1 = r0.zzk
            com.google.android.gms.measurement.internal.zzfr r2 = r0.zzt
            r2.getClass()
            long r3 = r1.zzb
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 != 0) goto L12
            goto L27
        L12:
            com.google.android.gms.common.util.Clock r3 = r1.zza
            okhttp3.Dns$Companion$DnsSystem r3 = (okhttp3.Dns$Companion$DnsSystem) r3
            r3.getClass()
            long r3 = android.os.SystemClock.elapsedRealtime()
            long r7 = r1.zzb
            long r3 = r3 - r7
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L29
        L27:
            r1 = 1
            goto L2a
        L29:
            r1 = 0
        L2a:
            if (r1 == 0) goto L7e
            android.database.sqlite.SQLiteDatabase r0 = super.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L31
            return r0
        L31:
            com.google.android.gms.measurement.internal.zzkd r0 = r0.zzk
            com.google.android.gms.common.util.Clock r1 = r0.zza
            okhttp3.Dns$Companion$DnsSystem r1 = (okhttp3.Dns$Companion$DnsSystem) r1
            r1.getClass()
            long r3 = android.os.SystemClock.elapsedRealtime()
            r0.zzb = r3
            com.google.android.gms.measurement.internal.zzeh r1 = r2.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            java.lang.String r3 = "Opening the database failed, dropping and recreating it"
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzd
            r1.zza(r3)
            r2.getClass()
            android.content.Context r1 = r2.zze
            java.lang.String r3 = "google_app_measurement.db"
            java.io.File r1 = r1.getDatabasePath(r3)
            boolean r1 = r1.delete()
            if (r1 != 0) goto L69
            com.google.android.gms.measurement.internal.zzeh r1 = r2.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            java.lang.String r4 = "Failed to delete corrupted db file"
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzd
            r1.zzb(r3, r4)
        L69:
            android.database.sqlite.SQLiteDatabase r1 = super.getWritableDatabase()     // Catch: android.database.sqlite.SQLiteException -> L70
            r0.zzb = r5     // Catch: android.database.sqlite.SQLiteException -> L70
            return r1
        L70:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzeh r1 = r2.zzm
            com.google.android.gms.measurement.internal.zzfr.zzR(r1)
            java.lang.String r2 = "Failed to open freshly created database"
            com.google.android.gms.measurement.internal.zzef r1 = r1.zzd
            r1.zzb(r0, r2)
            throw r0
        L7e:
            android.database.sqlite.SQLiteException r0 = new android.database.sqlite.SQLiteException
            java.lang.String r1 = "Database open failed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.getWritableDatabase():android.database.sqlite.SQLiteDatabase");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzeh zzehVar = this.zza.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzan.zzb(zzehVar, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzam zzamVar = this.zza;
        zzeh zzehVar = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzan.zza(zzehVar, sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", zzam.zza);
        zzeh zzehVar2 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar2);
        zzan.zza(zzehVar2, sQLiteDatabase, "conditional_properties", "CREATE TABLE IF NOT EXISTS conditional_properties ( app_id TEXT NOT NULL, origin TEXT NOT NULL, name TEXT NOT NULL, value BLOB NOT NULL, creation_timestamp INTEGER NOT NULL, active INTEGER NOT NULL, trigger_event_name TEXT, trigger_timeout INTEGER NOT NULL, timed_out_event BLOB,triggered_event BLOB, triggered_timestamp INTEGER NOT NULL, time_to_live INTEGER NOT NULL, expired_event BLOB, PRIMARY KEY (app_id, name)) ;", "app_id,origin,name,value,active,trigger_event_name,trigger_timeout,creation_timestamp,timed_out_event,triggered_event,triggered_timestamp,time_to_live,expired_event", null);
        zzeh zzehVar3 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar3);
        zzan.zza(zzehVar3, sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", zzam.zzb);
        zzeh zzehVar4 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar4);
        zzan.zza(zzehVar4, sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zzam.zzc);
        zzeh zzehVar5 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar5);
        zzan.zza(zzehVar5, sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zzam.zze);
        zzeh zzehVar6 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar6);
        zzan.zza(zzehVar6, sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", null);
        zzeh zzehVar7 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar7);
        zzan.zza(zzehVar7, sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zzam.zzd);
        zzeh zzehVar8 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar8);
        zzan.zza(zzehVar8, sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", zzam.zzg);
        zzeh zzehVar9 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar9);
        zzan.zza(zzehVar9, sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", zzam.zzh);
        zzeh zzehVar10 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar10);
        zzan.zza(zzehVar10, sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", null);
        zzeh zzehVar11 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar11);
        zzan.zza(zzehVar11, sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", zzam.zzi);
        zzeh zzehVar12 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar12);
        zzan.zza(zzehVar12, sQLiteDatabase, "main_event_params", "CREATE TABLE IF NOT EXISTS main_event_params ( app_id TEXT NOT NULL, event_id TEXT NOT NULL, children_to_process INTEGER NOT NULL, main_event BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,event_id,children_to_process,main_event", null);
        zzeh zzehVar13 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar13);
        zzan.zza(zzehVar13, sQLiteDatabase, "default_event_params", "CREATE TABLE IF NOT EXISTS default_event_params ( app_id TEXT NOT NULL, parameters BLOB NOT NULL, PRIMARY KEY (app_id));", "app_id,parameters", null);
        zzeh zzehVar14 = zzamVar.zzt.zzm;
        zzfr.zzR(zzehVar14);
        zzan.zza(zzehVar14, sQLiteDatabase, "consent_settings", "CREATE TABLE IF NOT EXISTS consent_settings ( app_id TEXT NOT NULL, consent_state TEXT NOT NULL, PRIMARY KEY (app_id));", "app_id,consent_state", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
    }
}
