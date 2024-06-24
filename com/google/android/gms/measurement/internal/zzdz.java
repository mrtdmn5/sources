package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzdz extends SQLiteOpenHelper {
    public final /* synthetic */ zzea zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdz(zzea zzeaVar, Context context) {
        super(context, "google_app_measurement_local.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzeaVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e) {
            throw e;
        } catch (SQLiteException unused) {
            zzea zzeaVar = this.zza;
            zzeh zzehVar = zzeaVar.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Opening the local database failed, dropping and recreating it");
            zzeaVar.zzt.getClass();
            if (!zzeaVar.zzt.zze.getDatabasePath("google_app_measurement_local.db").delete()) {
                zzeh zzehVar2 = zzeaVar.zzt.zzm;
                zzfr.zzR(zzehVar2);
                zzehVar2.zzd.zzb("google_app_measurement_local.db", "Failed to delete corrupted local db file");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e2) {
                zzeh zzehVar3 = zzeaVar.zzt.zzm;
                zzfr.zzR(zzehVar3);
                zzehVar3.zzd.zzb(e2, "Failed to open local database. Events will bypass local storage");
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzeh zzehVar = this.zza.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzan.zzb(zzehVar, sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzeh zzehVar = this.zza.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzan.zza(zzehVar, sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int r2, int r3) {
    }
}
