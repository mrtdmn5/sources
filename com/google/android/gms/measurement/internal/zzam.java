package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.animaconnected.firebase.AnalyticsConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.measurement.zznt;
import com.google.android.gms.internal.measurement.zznu;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzam extends zzkh {
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    public static final String[] zzc = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;"};
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    public final zzal zzj;
    public final zzkd zzk;

    public zzam(zzkt zzktVar) {
        super(zzktVar);
        this.zzk = new zzkd(this.zzt.zzr);
        this.zzt.getClass();
        this.zzj = new zzal(this, this.zzt.zze);
    }

    public static final void zzV(ContentValues contentValues, Object obj) {
        Preconditions.checkNotEmpty("value");
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put("value", (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    public final void zzA(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzfr zzfrVar = this.zzt;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzd("Error deleting user property. appId", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
        }
    }

    public final void zzC() {
        zzW();
        zzh().setTransactionSuccessful();
    }

    public final void zzD(zzh zzhVar) {
        zzg();
        zzW();
        String zzt = zzhVar.zzt();
        Preconditions.checkNotNull(zzt);
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, zzt);
        contentValues.put("app_instance_id", zzhVar.zzu());
        contentValues.put("gmp_app_id", zzhVar.zzy());
        zzfr zzfrVar = zzhVar.zza;
        zzfo zzfoVar = zzfrVar.zzn;
        zzfr.zzR(zzfoVar);
        zzfoVar.zzg();
        contentValues.put("resettable_device_id_hash", zzhVar.zze);
        zzfo zzfoVar2 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar2);
        zzfoVar2.zzg();
        contentValues.put("last_bundle_index", Long.valueOf(zzhVar.zzg));
        zzfo zzfoVar3 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar3);
        zzfoVar3.zzg();
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzhVar.zzh));
        zzfo zzfoVar4 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar4);
        zzfoVar4.zzg();
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzhVar.zzi));
        contentValues.put("app_version", zzhVar.zzw());
        zzfo zzfoVar5 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar5);
        zzfoVar5.zzg();
        contentValues.put("app_store", zzhVar.zzl);
        zzfo zzfoVar6 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar6);
        zzfoVar6.zzg();
        contentValues.put("gmp_version", Long.valueOf(zzhVar.zzm));
        zzfo zzfoVar7 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar7);
        zzfoVar7.zzg();
        contentValues.put("dev_cert_hash", Long.valueOf(zzhVar.zzn));
        zzfo zzfoVar8 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar8);
        zzfoVar8.zzg();
        contentValues.put("measurement_enabled", Boolean.valueOf(zzhVar.zzo));
        zzfo zzfoVar9 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar9);
        zzfoVar9.zzg();
        contentValues.put("day", Long.valueOf(zzhVar.zzv));
        zzfo zzfoVar10 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_public_events_count", Long.valueOf(zzhVar.zzw));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_events_count", Long.valueOf(zzhVar.zzx));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_conversions_count", Long.valueOf(zzhVar.zzy));
        zzfo zzfoVar11 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar11);
        zzfoVar11.zzg();
        contentValues.put("config_fetched_time", Long.valueOf(zzhVar.zzD));
        zzfo zzfoVar12 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar12);
        zzfoVar12.zzg();
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzhVar.zzE));
        contentValues.put("app_version_int", Long.valueOf(zzhVar.zzb()));
        contentValues.put("firebase_instance_id", zzhVar.zzx());
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_error_events_count", Long.valueOf(zzhVar.zzz));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzhVar.zzA));
        zzfr.zzR(zzfoVar10);
        zzfoVar10.zzg();
        contentValues.put("health_monitor_sample", zzhVar.zzB);
        zzfo zzfoVar13 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar13);
        zzfoVar13.zzg();
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzhVar.zzah()));
        contentValues.put("admob_app_id", zzhVar.zzr());
        contentValues.put("dynamite_version", Long.valueOf(zzhVar.zzk()));
        zzfo zzfoVar14 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar14);
        zzfoVar14.zzg();
        contentValues.put("session_stitching_token", zzhVar.zzu);
        zzfo zzfoVar15 = zzfrVar.zzn;
        zzfr.zzR(zzfoVar15);
        zzfoVar15.zzg();
        ArrayList arrayList = zzhVar.zzt;
        zzfr zzfrVar2 = this.zzt;
        if (arrayList != null) {
            if (arrayList.isEmpty()) {
                zzeh zzehVar = zzfrVar2.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(zzt, "Safelisted events should not be an empty list. appId");
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", arrayList));
            }
        }
        ((zznu) zznt.zza.zzb.zza()).zza();
        zzag zzagVar = zzfrVar2.zzk;
        zzeh zzehVar2 = zzfrVar2.zzm;
        if (zzagVar.zzs(null, zzdu.zzai) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase zzh2 = zzh();
            if (zzh2.update("apps", contentValues, "app_id = ?", new String[]{zzt}) == 0 && zzh2.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(zzeh.zzn(zzt), "Failed to insert/update app (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(zzt), e, "Error storing app. appId");
        }
    }

    public final void zzE(zzas zzasVar) {
        Long l;
        zzfr zzfrVar = this.zzt;
        Preconditions.checkNotNull(zzasVar);
        zzg();
        zzW();
        ContentValues contentValues = new ContentValues();
        String str = zzasVar.zza;
        contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
        contentValues.put("name", zzasVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzasVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzasVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzasVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzasVar.zzg));
        contentValues.put("last_bundled_day", zzasVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzasVar.zzi);
        contentValues.put("last_sampling_rate", zzasVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzasVar.zze));
        Boolean bool = zzasVar.zzk;
        if (bool != null && bool.booleanValue()) {
            l = 1L;
        } else {
            l = null;
        }
        contentValues.put("last_exempt_from_sampling", l);
        try {
            if (zzh().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update event aggregates (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), e, "Error storing event aggregates. appId");
        }
    }

    public final boolean zzI() {
        zzfr zzfrVar = this.zzt;
        Context context = zzfrVar.zze;
        zzfrVar.getClass();
        return context.getDatabasePath("google_app_measurement.db").exists();
    }

    public final void zzJ(String str, Long l, long j, com.google.android.gms.internal.measurement.zzft zzftVar) {
        zzg();
        zzW();
        Preconditions.checkNotNull(zzftVar);
        Preconditions.checkNotEmpty(str);
        byte[] zzbu = zzftVar.zzbu();
        zzfr zzfrVar = this.zzt;
        zzeh zzehVar = zzfrVar.zzm;
        zzeh zzehVar2 = zzfrVar.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzl.zzc(zzfrVar.zzq.zzd(str), Integer.valueOf(zzbu.length), "Saving complex main event, appId, data size");
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbu);
        try {
            if (zzh().insertWithOnConflict("main_event_params", null, contentValues, 5) == -1) {
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(zzeh.zzn(str), "Failed to insert complex main event (got -1). appId");
            }
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), e, "Error storing complex main event. appId");
        }
    }

    public final boolean zzK(zzac zzacVar) {
        zzg();
        zzW();
        String str = zzacVar.zza;
        Preconditions.checkNotNull(str);
        zzky zzp = zzp(str, zzacVar.zzc.zzb);
        zzfr zzfrVar = this.zzt;
        if (zzp == null) {
            long zzZ = zzZ("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            zzfrVar.getClass();
            if (zzZ >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
        contentValues.put("origin", zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zzb);
        Object zza2 = zzacVar.zzc.zza();
        Preconditions.checkNotNull(zza2);
        zzV(contentValues, zza2);
        contentValues.put("active", Boolean.valueOf(zzacVar.zze));
        contentValues.put("trigger_event_name", zzacVar.zzf);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.zzh));
        zzlb zzlbVar = zzfrVar.zzp;
        zzeh zzehVar = zzfrVar.zzm;
        zzfr.zzP(zzlbVar);
        zzlbVar.getClass();
        contentValues.put("timed_out_event", zzlb.zzan(zzacVar.zzg));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.zzd));
        zzlb zzlbVar2 = zzfrVar.zzp;
        zzfr.zzP(zzlbVar2);
        zzaw zzawVar = zzacVar.zzi;
        zzlbVar2.getClass();
        contentValues.put("triggered_event", zzlb.zzan(zzawVar));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.zzc.zzc));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.zzj));
        zzfr.zzP(zzlbVar2);
        zzlbVar2.getClass();
        contentValues.put("expired_event", zzlb.zzan(zzacVar.zzk));
        try {
            if (zzh().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update conditional user property (got -1)");
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzc(zzeh.zzn(str), e, "Error storing conditional user property");
            return true;
        }
    }

    public final boolean zzL(zzky zzkyVar) {
        zzg();
        zzW();
        String str = zzkyVar.zza;
        String str2 = zzkyVar.zzc;
        zzky zzp = zzp(str, str2);
        zzfr zzfrVar = this.zzt;
        String str3 = zzkyVar.zzb;
        if (zzp == null) {
            if (zzlb.zzai(str2)) {
                if (zzZ("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{str}) >= Math.max(Math.min(zzfrVar.zzk.zze(str, zzdu.zzF), 100), 25)) {
                    return false;
                }
            } else if (!"_npa".equals(str2)) {
                long zzZ = zzZ("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{str, str3});
                zzfrVar.getClass();
                if (zzZ >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
        contentValues.put("origin", str3);
        contentValues.put("name", str2);
        contentValues.put("set_timestamp", Long.valueOf(zzkyVar.zzd));
        zzV(contentValues, zzkyVar.zze);
        try {
            if (zzh().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzb(zzeh.zzn(str), "Failed to insert/update user property (got -1). appId");
                return true;
            }
            return true;
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzc(zzeh.zzn(str), e, "Error storing user property. appId");
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0213  */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzU(long r23, long r25, com.google.android.gms.measurement.internal.zzkq r27) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzU(long, long, com.google.android.gms.measurement.internal.zzkq):void");
    }

    public final long zzZ(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor rawQuery = zzh().rawQuery(str, strArr);
                if (rawQuery.moveToFirst()) {
                    long j = rawQuery.getLong(0);
                    rawQuery.close();
                    return j;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e) {
                zzeh zzehVar = this.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzc(str, e, "Database error");
                throw e;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final void zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzg();
        zzW();
        try {
            zzh().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzfr zzfrVar = this.zzt;
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzd("Error deleting conditional property", zzeh.zzn(str), zzfrVar.zzq.zzf(str2), e);
        }
    }

    public final long zzaa(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            try {
                cursor = zzh().rawQuery(str, strArr);
                if (cursor.moveToFirst()) {
                    long j2 = cursor.getLong(0);
                    cursor.close();
                    return j2;
                }
                cursor.close();
                return j;
            } catch (SQLiteException e) {
                zzeh zzehVar = this.zzt.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzd.zzc(str, e, "Database error");
                throw e;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zzc(String str) {
        zzfr zzfrVar = this.zzt;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty("first_open_count");
        zzg();
        zzW();
        SQLiteDatabase zzh2 = zzh();
        zzh2.beginTransaction();
        long j = 0;
        try {
            try {
                long zzaa = zzaa("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (zzaa == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (zzh2.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzd.zzc(zzeh.zzn(str), "first_open_count", "Failed to insert column (got -1). appId");
                        return -1L;
                    }
                    zzaa = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put(AnalyticsConstants.USER_PROPERTY_APP_ID, str);
                    contentValues2.put("first_open_count", Long.valueOf(1 + zzaa));
                    if (zzh2.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zzc(zzeh.zzn(str), "first_open_count", "Failed to update column (got 0). appId");
                        return -1L;
                    }
                    zzh2.setTransactionSuccessful();
                    return zzaa;
                } catch (SQLiteException e) {
                    e = e;
                    j = zzaa;
                    zzeh zzehVar3 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar3);
                    zzehVar3.zzd.zzd("Error inserting column. appId", zzeh.zzn(str), "first_open_count", e);
                    zzh2.endTransaction();
                    return j;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } finally {
            zzh2.endTransaction();
        }
    }

    public final long zzf(String str) {
        Preconditions.checkNotEmpty(str);
        return zzaa("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase zzh() {
        zzg();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzg.zzb(e, "Error opening database");
            throw e;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x02ae: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:687), block:B:62:0x02ae */
    /* JADX WARN: Removed duplicated region for block: B:18:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0227 A[Catch: SQLiteException -> 0x026d, all -> 0x02ad, TryCatch #2 {all -> 0x02ad, blocks: (B:5:0x00e1, B:10:0x00eb, B:12:0x014c, B:16:0x0156, B:19:0x019f, B:22:0x01b5, B:24:0x01e4, B:28:0x01ee, B:31:0x01ff, B:34:0x021c, B:36:0x0227, B:37:0x0239, B:39:0x0246, B:41:0x0250, B:42:0x026f, B:44:0x027f, B:48:0x0218, B:51:0x01b0, B:56:0x0297), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0246 A[Catch: SQLiteException -> 0x026d, all -> 0x02ad, TryCatch #2 {all -> 0x02ad, blocks: (B:5:0x00e1, B:10:0x00eb, B:12:0x014c, B:16:0x0156, B:19:0x019f, B:22:0x01b5, B:24:0x01e4, B:28:0x01ee, B:31:0x01ff, B:34:0x021c, B:36:0x0227, B:37:0x0239, B:39:0x0246, B:41:0x0250, B:42:0x026f, B:44:0x027f, B:48:0x0218, B:51:0x01b0, B:56:0x0297), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x027f A[Catch: SQLiteException -> 0x026d, all -> 0x02ad, TRY_LEAVE, TryCatch #2 {all -> 0x02ad, blocks: (B:5:0x00e1, B:10:0x00eb, B:12:0x014c, B:16:0x0156, B:19:0x019f, B:22:0x01b5, B:24:0x01e4, B:28:0x01ee, B:31:0x01ff, B:34:0x021c, B:36:0x0227, B:37:0x0239, B:39:0x0246, B:41:0x0250, B:42:0x026f, B:44:0x027f, B:48:0x0218, B:51:0x01b0, B:56:0x0297), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0218 A[Catch: SQLiteException -> 0x026d, all -> 0x02ad, TryCatch #2 {all -> 0x02ad, blocks: (B:5:0x00e1, B:10:0x00eb, B:12:0x014c, B:16:0x0156, B:19:0x019f, B:22:0x01b5, B:24:0x01e4, B:28:0x01ee, B:31:0x01ff, B:34:0x021c, B:36:0x0227, B:37:0x0239, B:39:0x0246, B:41:0x0250, B:42:0x026f, B:44:0x027f, B:48:0x0218, B:51:0x01b0, B:56:0x0297), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b0 A[Catch: SQLiteException -> 0x026d, all -> 0x02ad, TryCatch #2 {all -> 0x02ad, blocks: (B:5:0x00e1, B:10:0x00eb, B:12:0x014c, B:16:0x0156, B:19:0x019f, B:22:0x01b5, B:24:0x01e4, B:28:0x01ee, B:31:0x01ff, B:34:0x021c, B:36:0x0227, B:37:0x0239, B:39:0x0246, B:41:0x0250, B:42:0x026f, B:44:0x027f, B:48:0x0218, B:51:0x01b0, B:56:0x0297), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzh zzj(java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzj(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0143: MOVE (r10 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:324), block:B:32:0x0143 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzac zzk(java.lang.String r37, java.lang.String r38) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzk(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    public final zzak zzl(long j, String str, boolean z, boolean z2) {
        return zzm(j, str, 1L, false, false, z, false, z2);
    }

    public final zzak zzm(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        zzfr zzfrVar = this.zzt;
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        String[] strArr = {str};
        zzak zzakVar = new zzak();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase zzh2 = zzh();
                Cursor query = zzh2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                try {
                    if (!query.moveToFirst()) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzg.zzb(zzeh.zzn(str), "Not updating daily counts, app is not known. appId");
                        query.close();
                        return zzakVar;
                    }
                    if (query.getLong(0) == j) {
                        zzakVar.zzb = query.getLong(1);
                        zzakVar.zza = query.getLong(2);
                        zzakVar.zzc = query.getLong(3);
                        zzakVar.zzd = query.getLong(4);
                        zzakVar.zze = query.getLong(5);
                    }
                    if (z) {
                        zzakVar.zzb += j2;
                    }
                    if (z2) {
                        zzakVar.zza += j2;
                    }
                    if (z3) {
                        zzakVar.zzc += j2;
                    }
                    if (z4) {
                        zzakVar.zzd += j2;
                    }
                    if (z5) {
                        zzakVar.zze += j2;
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("day", Long.valueOf(j));
                    contentValues.put("daily_public_events_count", Long.valueOf(zzakVar.zza));
                    contentValues.put("daily_events_count", Long.valueOf(zzakVar.zzb));
                    contentValues.put("daily_conversions_count", Long.valueOf(zzakVar.zzc));
                    contentValues.put("daily_error_events_count", Long.valueOf(zzakVar.zzd));
                    contentValues.put("daily_realtime_events_count", Long.valueOf(zzakVar.zze));
                    zzh2.update("apps", contentValues, "app_id=?", strArr);
                    query.close();
                    return zzakVar;
                } catch (SQLiteException e) {
                    e = e;
                    cursor = query;
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzc(zzeh.zzn(str), e, "Error updating daily counts. appId");
                    if (cursor != null) {
                        cursor.close();
                    }
                    return zzakVar;
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzas zzn(java.lang.String r31, java.lang.String r32) {
        /*
            Method dump skipped, instructions count: 303
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzn(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzas");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.measurement.internal.zzky zzp(java.lang.String r16, java.lang.String r17) {
        /*
            r15 = this;
            r1 = r15
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r16)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r17)
            r15.zzg()
            r15.zzW()
            r3 = 0
            android.database.sqlite.SQLiteDatabase r4 = r15.zzh()     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            r0 = 3
            java.lang.String[] r6 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r0 = "set_timestamp"
            r12 = 0
            r6[r12] = r0     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r0 = "value"
            r13 = 1
            r6[r13] = r0     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r0 = "origin"
            r14 = 2
            r6[r14] = r0     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String[] r8 = new java.lang.String[]{r16, r17}     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            java.lang.String r5 = "user_attributes"
            java.lang.String r7 = "app_id=? and name=?"
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r4 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L77 android.database.sqlite.SQLiteException -> L79
            boolean r0 = r4.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            if (r0 != 0) goto L3f
            r4.close()
            return r3
        L3f:
            long r9 = r4.getLong(r12)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            java.lang.Object r11 = r15.zzq(r4, r13)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            if (r11 != 0) goto L4d
            r4.close()
            return r3
        L4d:
            java.lang.String r7 = r4.getString(r14)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzky r0 = new com.google.android.gms.measurement.internal.zzky     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            r5 = r0
            r6 = r16
            r8 = r17
            r5.<init>(r6, r7, r8, r9, r11)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            boolean r5 = r4.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            if (r5 == 0) goto L71
            com.google.android.gms.measurement.internal.zzeh r5 = r2.zzm     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzfr.zzR(r5)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            java.lang.String r6 = "Got multiple records for user property, expected one. appId"
            com.google.android.gms.measurement.internal.zzeg r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r16)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
            r5.zzb(r7, r6)     // Catch: android.database.sqlite.SQLiteException -> L75 java.lang.Throwable -> L99
        L71:
            r4.close()
            return r0
        L75:
            r0 = move-exception
            goto L7b
        L77:
            r0 = move-exception
            goto L9b
        L79:
            r0 = move-exception
            r4 = r3
        L7b:
            com.google.android.gms.measurement.internal.zzeh r5 = r2.zzm     // Catch: java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzfr.zzR(r5)     // Catch: java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd     // Catch: java.lang.Throwable -> L99
            java.lang.String r6 = "Error querying user property. appId"
            com.google.android.gms.measurement.internal.zzeg r7 = com.google.android.gms.measurement.internal.zzeh.zzn(r16)     // Catch: java.lang.Throwable -> L99
            com.google.android.gms.measurement.internal.zzec r2 = r2.zzq     // Catch: java.lang.Throwable -> L99
            r8 = r17
            java.lang.String r2 = r2.zzf(r8)     // Catch: java.lang.Throwable -> L99
            r5.zzd(r6, r7, r2, r0)     // Catch: java.lang.Throwable -> L99
            if (r4 == 0) goto L98
            r4.close()
        L98:
            return r3
        L99:
            r0 = move-exception
            r3 = r4
        L9b:
            if (r3 == 0) goto La0
            r3.close()
        La0:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzp(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzky");
    }

    public final Object zzq(Cursor cursor, int r6) {
        int type = cursor.getType(r6);
        zzfr zzfrVar = this.zzt;
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type != 4) {
                            zzeh zzehVar = zzfrVar.zzm;
                            zzfr.zzR(zzehVar);
                            zzehVar.zzd.zzb(Integer.valueOf(type), "Loaded invalid unknown value type, ignoring it");
                            return null;
                        }
                        zzeh zzehVar2 = zzfrVar.zzm;
                        zzfr.zzR(zzehVar2);
                        zzehVar2.zzd.zza("Loaded invalid blob type value, ignoring it");
                        return null;
                    }
                    return cursor.getString(r6);
                }
                return Double.valueOf(cursor.getDouble(r6));
            }
            return Long.valueOf(cursor.getLong(r6));
        }
        zzeh zzehVar3 = zzfrVar.zzm;
        zzfr.zzR(zzehVar3);
        zzehVar3.zzd.zza("Loaded invalid null value from database");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String zzr() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.zzh()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L22
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L39
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L39
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L25
        L20:
            r0 = move-exception
            goto L3d
        L22:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L25:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzt     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.measurement.internal.zzeh r3 = r3.zzm     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.measurement.internal.zzfr.zzR(r3)     // Catch: java.lang.Throwable -> L39
            com.google.android.gms.measurement.internal.zzef r3 = r3.zzd     // Catch: java.lang.Throwable -> L39
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzb(r2, r4)     // Catch: java.lang.Throwable -> L39
            if (r0 == 0) goto L38
            r0.close()
        L38:
            return r1
        L39:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L3d:
            if (r1 == 0) goto L42
            r1.close()
        L42:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzr():java.lang.String");
    }

    public final List zzs(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzg();
        zzW();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzt(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:            r0 = r2.zzm;        com.google.android.gms.measurement.internal.zzfr.zzR(r0);        r0.zzd.zzb(1000, "Read more than the max allowed conditional properties, ignoring extra");     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x017c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzt(java.lang.String r44, java.lang.String[] r45) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzt(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzu(java.lang.String r18) {
        /*
            r17 = this;
            r1 = r17
            com.google.android.gms.measurement.internal.zzfr r2 = r1.zzt
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r18)
            r17.zzg()
            r17.zzW()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r11 = "1000"
            android.database.sqlite.SQLiteDatabase r3 = r17.zzh()     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r4 = "user_attributes"
            r5 = 4
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r6 = "name"
            r13 = 0
            r5[r13] = r6     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r6 = "origin"
            r14 = 1
            r5[r14] = r6     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r6 = "set_timestamp"
            r15 = 2
            r5[r15] = r6     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r6 = "value"
            r10 = 3
            r5[r10] = r6     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r6 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[]{r18}     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            java.lang.String r16 = "rowid"
            r2.getClass()     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            r8 = 0
            r9 = 0
            r12 = r10
            r10 = r16
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L92 android.database.sqlite.SQLiteException -> L95
            boolean r4 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            if (r4 == 0) goto L88
        L4b:
            java.lang.String r8 = r3.getString(r13)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            java.lang.String r4 = r3.getString(r14)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            if (r4 != 0) goto L57
            java.lang.String r4 = ""
        L57:
            r7 = r4
            long r9 = r3.getLong(r15)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            java.lang.Object r11 = r1.zzq(r3, r12)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            if (r11 != 0) goto L73
            com.google.android.gms.measurement.internal.zzeh r4 = r2.zzm     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            com.google.android.gms.measurement.internal.zzfr.zzR(r4)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            com.google.android.gms.measurement.internal.zzef r4 = r4.zzd     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            java.lang.String r5 = "Read invalid user property value, ignoring it. appId"
            com.google.android.gms.measurement.internal.zzeg r6 = com.google.android.gms.measurement.internal.zzeh.zzn(r18)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            r4.zzb(r6, r5)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            goto L7e
        L73:
            com.google.android.gms.measurement.internal.zzky r4 = new com.google.android.gms.measurement.internal.zzky     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            r5 = r4
            r6 = r18
            r5.<init>(r6, r7, r8, r9, r11)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            r0.add(r4)     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
        L7e:
            boolean r4 = r3.moveToNext()     // Catch: java.lang.Throwable -> L8c android.database.sqlite.SQLiteException -> L8f
            if (r4 != 0) goto L4b
            r3.close()
            return r0
        L88:
            r3.close()
            return r0
        L8c:
            r0 = move-exception
            r12 = r3
            goto Lb2
        L8f:
            r0 = move-exception
            r12 = r3
            goto L97
        L92:
            r0 = move-exception
            r12 = 0
            goto Lb2
        L95:
            r0 = move-exception
            r12 = 0
        L97:
            com.google.android.gms.measurement.internal.zzeh r2 = r2.zzm     // Catch: java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzfr.zzR(r2)     // Catch: java.lang.Throwable -> Lb1
            com.google.android.gms.measurement.internal.zzef r2 = r2.zzd     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r3 = "Error querying user properties. appId"
            com.google.android.gms.measurement.internal.zzeg r4 = com.google.android.gms.measurement.internal.zzeh.zzn(r18)     // Catch: java.lang.Throwable -> Lb1
            r2.zzc(r4, r0, r3)     // Catch: java.lang.Throwable -> Lb1
            java.util.List r0 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> Lb1
            if (r12 == 0) goto Lb0
            r12.close()
        Lb0:
            return r0
        Lb1:
            r0 = move-exception
        Lb2:
            if (r12 == 0) goto Lb7
            r12.close()
        Lb7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzu(java.lang.String):java.util.List");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:            com.google.android.gms.measurement.internal.zzfr.zzR(r7);        r7.zzd.zzb(1000, "Read more than the max allowed user properties, ignoring excess");     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zzv(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzam.zzv(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final void zzw() {
        zzW();
        zzh().beginTransaction();
    }

    public final void zzx() {
        zzW();
        zzh().endTransaction();
    }

    public final void zzy(List list) {
        zzg();
        zzW();
        if (list.size() != 0) {
            if (!zzI()) {
                return;
            }
            String m = zzav$$ExternalSyntheticOutline0.m("(", TextUtils.join(",", list), ")");
            long zzZ = zzZ("SELECT COUNT(1) FROM queue WHERE rowid IN " + m + " AND retry_count =  2147483647 LIMIT 1", null);
            zzfr zzfrVar = this.zzt;
            if (zzZ > 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                zzh().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + m + " AND (retry_count IS NULL OR retry_count < 2147483647)");
                return;
            } catch (SQLiteException e) {
                zzeh zzehVar2 = zzfrVar.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb(e, "Error incrementing retry count. error");
                return;
            }
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public final void zzz() {
        zzg();
        zzW();
        if (zzI()) {
            zzkt zzktVar = this.zzf;
            long zza2 = zzktVar.zzk.zza.zza();
            zzfr zzfrVar = this.zzt;
            zzfrVar.zzr.getClass();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > ((Long) zzdu.zzx.zza(null)).longValue()) {
                zzktVar.zzk.zza.zzb(elapsedRealtime);
                zzg();
                zzW();
                if (zzI()) {
                    SQLiteDatabase zzh2 = zzh();
                    zzfrVar.zzr.getClass();
                    int delete = zzh2.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(System.currentTimeMillis()), String.valueOf(((Long) zzdu.zzC.zza(null)).longValue())});
                    if (delete > 0) {
                        zzeh zzehVar = zzfrVar.zzm;
                        zzfr.zzR(zzehVar);
                        zzehVar.zzl.zzb(Integer.valueOf(delete), "Deleted stale rows. rowsDeleted");
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
