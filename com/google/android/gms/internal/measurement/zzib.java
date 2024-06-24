package com.google.android.gms.internal.measurement;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzib {
    public static final Object zzd = new Object();
    public static volatile zzhc zze;
    public static final AtomicInteger zzi;
    public final zzhy zza;
    public final String zzb;
    public final Object zzj;
    public volatile int zzk = -1;
    public volatile Object zzl;

    static {
        new AtomicReference();
        zzi = new AtomicInteger();
    }

    public /* synthetic */ zzib(zzhy zzhyVar, String str, Object obj) {
        if (zzhyVar.zzb != null) {
            this.zza = zzhyVar;
            this.zzb = str;
            this.zzj = obj;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public abstract Object zza(String str);

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5 A[Catch: all -> 0x005c, TryCatch #0 {all -> 0x005c, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0015, B:11:0x001f, B:13:0x002b, B:15:0x0044, B:17:0x0057, B:20:0x00a7, B:22:0x00b5, B:24:0x00c6, B:27:0x00d5, B:29:0x00e8, B:30:0x00eb, B:31:0x00ef, B:32:0x0063, B:34:0x0069, B:35:0x006d, B:46:0x008a, B:49:0x0094, B:51:0x009a, B:53:0x00a5, B:54:0x0092, B:58:0x00a1, B:63:0x00f4, B:64:0x00fb, B:65:0x00fc, B:66:0x0101, B:67:0x0102, B:37:0x006e, B:39:0x0072, B:41:0x007a, B:42:0x0085, B:43:0x0080, B:44:0x0087, B:45:0x0089), top: B:4:0x000b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[Catch: all -> 0x005c, TryCatch #0 {all -> 0x005c, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0015, B:11:0x001f, B:13:0x002b, B:15:0x0044, B:17:0x0057, B:20:0x00a7, B:22:0x00b5, B:24:0x00c6, B:27:0x00d5, B:29:0x00e8, B:30:0x00eb, B:31:0x00ef, B:32:0x0063, B:34:0x0069, B:35:0x006d, B:46:0x008a, B:49:0x0094, B:51:0x009a, B:53:0x00a5, B:54:0x0092, B:58:0x00a1, B:63:0x00f4, B:64:0x00fb, B:65:0x00fc, B:66:0x0101, B:67:0x0102, B:37:0x006e, B:39:0x0072, B:41:0x007a, B:42:0x0085, B:43:0x0080, B:44:0x0087, B:45:0x0089), top: B:4:0x000b, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a5 A[Catch: all -> 0x005c, TryCatch #0 {all -> 0x005c, blocks: (B:5:0x000b, B:7:0x000f, B:9:0x0015, B:11:0x001f, B:13:0x002b, B:15:0x0044, B:17:0x0057, B:20:0x00a7, B:22:0x00b5, B:24:0x00c6, B:27:0x00d5, B:29:0x00e8, B:30:0x00eb, B:31:0x00ef, B:32:0x0063, B:34:0x0069, B:35:0x006d, B:46:0x008a, B:49:0x0094, B:51:0x009a, B:53:0x00a5, B:54:0x0092, B:58:0x00a1, B:63:0x00f4, B:64:0x00fb, B:65:0x00fc, B:66:0x0101, B:67:0x0102, B:37:0x006e, B:39:0x0072, B:41:0x007a, B:42:0x0085, B:43:0x0080, B:44:0x0087, B:45:0x0089), top: B:4:0x000b, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb() {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzib.zzb():java.lang.Object");
    }
}
