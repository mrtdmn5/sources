package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzan {
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002e, code lost:            if (r0 == false) goto L17;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00df  */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r15v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void zza(com.google.android.gms.measurement.internal.zzeh r17, android.database.sqlite.SQLiteDatabase r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String[] r22) throws android.database.sqlite.SQLiteException {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(com.google.android.gms.measurement.internal.zzeh, android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    public static void zzb(zzeh zzehVar, SQLiteDatabase sQLiteDatabase) {
        File file = new File(sQLiteDatabase.getPath());
        boolean readable = file.setReadable(false, false);
        zzef zzefVar = zzehVar.zzg;
        if (!readable) {
            zzefVar.zza("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzefVar.zza("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzefVar.zza("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzefVar.zza("Failed to turn on database write permission for owner");
        }
    }
}
