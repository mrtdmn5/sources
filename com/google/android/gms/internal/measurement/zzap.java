package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public interface zzap {
    public static final zzau zzf = new zzau();
    public static final zzan zzg = new zzan();
    public static final zzag zzh = new zzag("continue");
    public static final zzag zzi = new zzag("break");
    public static final zzag zzj = new zzag("return");
    public static final zzaf zzk = new zzaf(Boolean.TRUE);
    public static final zzaf zzl = new zzaf(Boolean.FALSE);
    public static final zzat zzm = new zzat("");

    zzap zzbR(String str, zzg zzgVar, ArrayList arrayList);

    zzap zzd();

    Boolean zzg();

    Double zzh();

    String zzi();

    Iterator zzl();
}
