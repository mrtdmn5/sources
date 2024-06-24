package com.google.android.gms.fitness.data;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class zzaj {
    public static final double zza;
    public static final double zzb;
    public static final double zzc;
    public static final Set zzd;
    public static final zzaj zze;
    public final Map zzf;
    public final Map zzg;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        zza = 10.0d / timeUnit.toNanos(1L);
        zzb = 2000.0d / TimeUnit.HOURS.toNanos(1L);
        zzc = 100.0d / timeUnit.toNanos(1L);
        zzd = Collections.unmodifiableSet(new HashSet(Arrays.asList("altitude", "duration", "food_item", "meal_type", "repetitions", "resistance", "resistance_type")));
        zze = new zzaj();
    }

    public zzaj() {
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", new zzai(-90.0d, 90.0d));
        hashMap.put("longitude", new zzai(-180.0d, 180.0d));
        hashMap.put("accuracy", new zzai(0.0d, 10000.0d));
        hashMap.put("bpm", new zzai(0.0d, 1000.0d));
        hashMap.put("altitude", new zzai(-100000.0d, 100000.0d));
        hashMap.put("percentage", new zzai(0.0d, 100.0d));
        hashMap.put("confidence", new zzai(0.0d, 100.0d));
        hashMap.put("duration", new zzai(0.0d, 9.223372036854776E18d));
        hashMap.put("height", new zzai(0.0d, 3.0d));
        hashMap.put("weight", new zzai(0.0d, 1000.0d));
        hashMap.put(TransferTable.COLUMN_SPEED, new zzai(0.0d, 11000.0d));
        this.zzg = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        zzai zzaiVar = new zzai(0.0d, zza);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("steps", zzaiVar);
        hashMap2.put("com.google.step_count.delta", hashMap3);
        zzai zzaiVar2 = new zzai(0.0d, zzb);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("calories", zzaiVar2);
        hashMap2.put("com.google.calories.expended", hashMap4);
        zzai zzaiVar3 = new zzai(0.0d, zzc);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("distance", zzaiVar3);
        hashMap2.put("com.google.distance.delta", hashMap5);
        this.zzf = Collections.unmodifiableMap(hashMap2);
    }
}
