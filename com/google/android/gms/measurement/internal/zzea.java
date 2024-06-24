package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzea extends zzf {
    public final zzdz zza;
    public boolean zzb;

    public zzea(zzfr zzfrVar) {
        super(zzfrVar);
        this.zza = new zzdz(this, this.zzt.zze);
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    public final boolean zzf() {
        return false;
    }

    public final SQLiteDatabase zzh() throws SQLiteException {
        if (this.zzb) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zza.getWritableDatabase();
        if (writableDatabase == null) {
            this.zzb = true;
            return null;
        }
        return writableDatabase;
    }

    public final void zzj() {
        int delete;
        zzfr zzfrVar = this.zzt;
        zzg();
        try {
            SQLiteDatabase zzh = zzh();
            if (zzh != null && (delete = zzh.delete("messages", null, null)) > 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzl.zzb(Integer.valueOf(delete), "Reset local analytics data. records");
            }
        } catch (SQLiteException e) {
            zzeh zzehVar2 = zzfrVar.zzm;
            zzfr.zzR(zzehVar2);
            zzehVar2.zzd.zzb(e, "Error resetting local analytics data. error");
        }
    }

    public final void zzm() {
        zzg();
        if (this.zzb) {
            return;
        }
        zzfr zzfrVar = this.zzt;
        if (zzfrVar.zze.getDatabasePath("google_app_measurement_local.db").exists()) {
            int r5 = 5;
            for (int r4 = 0; r4 < 5; r4++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase zzh = zzh();
                    if (zzh == null) {
                        this.zzb = true;
                        return;
                    }
                    zzh.beginTransaction();
                    zzh.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                    zzh.setTransactionSuccessful();
                    zzh.endTransaction();
                    zzh.close();
                    return;
                } catch (SQLiteDatabaseLockedException unused) {
                    SystemClock.sleep(r5);
                    r5 += 20;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                } catch (SQLiteFullException e) {
                    zzeh zzehVar = zzfrVar.zzm;
                    zzfr.zzR(zzehVar);
                    zzehVar.zzd.zzb(e, "Error deleting app launch break from local database");
                    this.zzb = true;
                    if (0 == 0) {
                    }
                    sQLiteDatabase.close();
                } catch (SQLiteException e2) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzd.zzb(e2, "Error deleting app launch break from local database");
                    this.zzb = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            zzeh zzehVar3 = zzfrVar.zzm;
            zzfr.zzR(zzehVar3);
            zzehVar3.zzg.zza("Error deleting app launch break from local database in reasonable time");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005e A[Catch: all -> 0x004d, SQLiteException -> 0x004f, SQLiteFullException -> 0x0051, SQLiteDatabaseLockedException -> 0x00b2, TRY_ENTER, TryCatch #9 {SQLiteDatabaseLockedException -> 0x00b2, SQLiteFullException -> 0x0051, SQLiteException -> 0x004f, all -> 0x004d, blocks: (B:94:0x0042, B:96:0x0048, B:74:0x005e, B:76:0x007f, B:78:0x0099), top: B:93:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0098  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzq(int r18, byte[] r19) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzea.zzq(int, byte[]):boolean");
    }
}
