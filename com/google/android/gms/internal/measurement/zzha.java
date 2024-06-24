package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzha {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Pattern zzc;
    public static final Pattern zzd;
    public static HashMap zze;
    public static final HashMap zzf;
    public static final HashMap zzg;
    public static final HashMap zzh;
    public static final HashMap zzi;
    public static final String[] zzj;
    public static final AtomicBoolean zzk;
    public static Object zzl;

    static {
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
        zzk = new AtomicBoolean();
        zzf = new HashMap();
        zzg = new HashMap();
        zzh = new HashMap();
        zzi = new HashMap();
        zzj = new String[0];
    }
}
