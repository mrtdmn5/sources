package com.google.android.gms.internal.measurement;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlinx.coroutines.SupervisorKt;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.slf4j.helpers.NormalizedParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzae implements Iterable, zzap, zzal {
    public final TreeMap zza;
    public final TreeMap zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (zzc() != zzaeVar.zzc()) {
            return false;
        }
        TreeMap treeMap = this.zza;
        if (treeMap.isEmpty()) {
            return zzaeVar.zza.isEmpty();
        }
        for (int intValue = ((Integer) treeMap.firstKey()).intValue(); intValue <= ((Integer) treeMap.lastKey()).intValue(); intValue++) {
            if (!zze(intValue).equals(zzaeVar.zze(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzj(",");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:104:0x0211. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v102, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r0v123, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r0v125, types: [com.google.android.gms.internal.measurement.zzat] */
    /* JADX WARN: Type inference failed for: r0v126 */
    /* JADX WARN: Type inference failed for: r0v128, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v34, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v43, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v47, types: [com.google.android.gms.internal.measurement.zzat] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.google.android.gms.internal.measurement.zzat] */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v58, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v59, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v70, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r0v71, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r0v76, types: [com.google.android.gms.internal.measurement.zzah] */
    /* JADX WARN: Type inference failed for: r0v79, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r0v81, types: [com.google.android.gms.internal.measurement.zzap] */
    /* JADX WARN: Type inference failed for: r0v95, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r28v0, types: [java.lang.Object, java.lang.String] */
    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, ArrayList arrayList) {
        String str2;
        String str3;
        String str4;
        String str5;
        Object obj;
        Object obj2;
        String str6;
        String str7;
        String str8;
        zzap zzapVar;
        zzap zzapVar2;
        zzap zzapVar3;
        double min;
        zzai zzaiVar;
        char c;
        String str9 = "toString";
        if ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str)) {
            str2 = "unshift";
            str3 = "filter";
            str4 = "join";
            str5 = "sort";
            obj = "splice";
            obj2 = "reduce";
            str6 = "some";
        } else if ("some".equals(str)) {
            str4 = "join";
            str5 = "sort";
            obj = "splice";
            obj2 = "reduce";
            str6 = "some";
            str2 = "unshift";
            str3 = "filter";
        } else {
            str5 = "sort";
            if (str5.equals(str)) {
                obj = "splice";
                obj2 = "reduce";
                str6 = "some";
                str2 = "unshift";
                str3 = "filter";
                str4 = "join";
            } else if ("splice".equals(str)) {
                obj2 = "reduce";
                str6 = "some";
                str2 = "unshift";
                str3 = "filter";
                str4 = "join";
                obj = "splice";
                str5 = str5;
            } else {
                if (!str9.equals(str)) {
                    str9 = str9;
                    str2 = "unshift";
                    if (!str2.equals(str)) {
                        return NormalizedParameters.zza(this, new zzat(str), zzgVar, arrayList);
                    }
                } else {
                    str9 = str9;
                    str2 = "unshift";
                }
                str3 = "filter";
                str4 = "join";
                obj = "splice";
                str5 = str5;
                obj2 = "reduce";
                str6 = "some";
            }
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1776922004:
                str7 = str3;
                str8 = str9;
                if (str.equals(str8)) {
                    c2 = 18;
                    break;
                }
                break;
            case -1354795244:
                str7 = str3;
                if (str.equals("concat")) {
                    c2 = 0;
                }
                str8 = str9;
                break;
            case -1274492040:
                str7 = str3;
                if (str.equals(str7)) {
                    c2 = 2;
                }
                str8 = str9;
                break;
            case -934873754:
                if (str.equals(obj2)) {
                    c = '\n';
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case -895859076:
                if (str.equals(obj)) {
                    c = 17;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c2 = 3;
                }
                str7 = str3;
                str8 = str9;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case -277637751:
                if (str.equals(str2)) {
                    c = 19;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = 7;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\b';
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 3267882:
                if (str.equals(str4)) {
                    c = 5;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = '\t';
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 3536116:
                if (str.equals(str6)) {
                    c = 15;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 3536286:
                if (str.equals(str5)) {
                    c = 16;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 96891675:
                if (str.equals("every")) {
                    c2 = 1;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = '\r';
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 14;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 11;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = '\f';
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 4;
                    c2 = c;
                }
                str7 = str3;
                str8 = str9;
                break;
            default:
                str7 = str3;
                str8 = str9;
                break;
        }
        zzau zzauVar = zzap.zzf;
        String str10 = ",";
        TreeMap treeMap = this.zza;
        zzaf zzafVar = zzap.zzl;
        zzaf zzafVar2 = zzap.zzk;
        String str11 = str7;
        String str12 = str4;
        double d = 0.0d;
        switch (c2) {
            case 0:
                zzap zzd = zzd();
                if (!arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        zzap zzb = zzgVar.zzb((zzap) it.next());
                        if (!(zzb instanceof zzag)) {
                            zzae zzaeVar = (zzae) zzd;
                            int zzc = zzaeVar.zzc();
                            if (zzb instanceof zzae) {
                                zzae zzaeVar2 = (zzae) zzb;
                                Iterator zzk = zzaeVar2.zzk();
                                while (zzk.hasNext()) {
                                    Integer num = (Integer) zzk.next();
                                    zzaeVar.zzq(num.intValue() + zzc, zzaeVar2.zze(num.intValue()));
                                }
                            } else {
                                zzaeVar.zzq(zzc, zzb);
                            }
                        } else {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                    }
                }
                zzapVar = zzd;
                return zzapVar;
            case 1:
                zzh.zzh("every", 1, arrayList);
                zzap zzb2 = zzgVar.zzb((zzap) arrayList.get(0));
                if (zzb2 instanceof zzao) {
                    if (zzc() == 0 || SupervisorKt.zzb(this, zzgVar, (zzao) zzb2, Boolean.FALSE, Boolean.TRUE).zzc() == zzc()) {
                        return zzafVar2;
                    }
                    return zzafVar;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 2:
                zzh.zzh(str11, 1, arrayList);
                zzap zzb3 = zzgVar.zzb((zzap) arrayList.get(0));
                if (zzb3 instanceof zzao) {
                    if (treeMap.size() == 0) {
                        zzapVar = new zzae();
                        return zzapVar;
                    }
                    zzap zzd2 = zzd();
                    zzae zzb4 = SupervisorKt.zzb(this, zzgVar, (zzao) zzb3, null, Boolean.TRUE);
                    zzae zzaeVar3 = new zzae();
                    Iterator zzk2 = zzb4.zzk();
                    while (zzk2.hasNext()) {
                        zzaeVar3.zzq(zzaeVar3.zzc(), ((zzae) zzd2).zze(((Integer) zzk2.next()).intValue()));
                    }
                    return zzaeVar3;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 3:
                zzh.zzh("forEach", 1, arrayList);
                zzap zzb5 = zzgVar.zzb((zzap) arrayList.get(0));
                if (zzb5 instanceof zzao) {
                    if (treeMap.size() != 0) {
                        SupervisorKt.zzb(this, zzgVar, (zzao) zzb5, null, null);
                    }
                    return zzauVar;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 4:
                zzh.zzj("indexOf", 2, arrayList);
                if (!arrayList.isEmpty()) {
                    zzapVar2 = zzgVar.zzb((zzap) arrayList.get(0));
                } else {
                    zzapVar2 = zzauVar;
                }
                if (arrayList.size() > 1) {
                    double zza = zzh.zza(zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue());
                    if (zza >= zzc()) {
                        zzapVar = new zzah(Double.valueOf(-1.0d));
                        return zzapVar;
                    }
                    if (zza < 0.0d) {
                        d = zzc() + zza;
                    } else {
                        d = zza;
                    }
                }
                Iterator zzk3 = zzk();
                while (true) {
                    if (zzk3.hasNext()) {
                        int intValue = ((Integer) zzk3.next()).intValue();
                        double d2 = intValue;
                        if (d2 >= d && zzh.zzl(zze(intValue), zzapVar2)) {
                            zzapVar = new zzah(Double.valueOf(d2));
                        }
                    } else {
                        zzapVar = new zzah(Double.valueOf(-1.0d));
                    }
                }
                return zzapVar;
            case 5:
                zzh.zzj(str12, 1, arrayList);
                if (zzc() == 0) {
                    zzapVar = zzap.zzm;
                } else {
                    if (!arrayList.isEmpty()) {
                        zzap zzb6 = zzgVar.zzb((zzap) arrayList.get(0));
                        if (!(zzb6 instanceof zzan) && !(zzb6 instanceof zzau)) {
                            str10 = zzb6.zzi();
                        } else {
                            str10 = "";
                        }
                    }
                    zzapVar = new zzat(zzj(str10));
                }
                return zzapVar;
            case 6:
                zzh.zzj("lastIndexOf", 2, arrayList);
                if (!arrayList.isEmpty()) {
                    zzapVar3 = zzgVar.zzb((zzap) arrayList.get(0));
                } else {
                    zzapVar3 = zzauVar;
                }
                double zzc2 = zzc() - 1;
                if (arrayList.size() > 1) {
                    zzap zzb7 = zzgVar.zzb((zzap) arrayList.get(1));
                    zzc2 = Double.isNaN(zzb7.zzh().doubleValue()) ? zzc() - 1 : zzh.zza(zzb7.zzh().doubleValue());
                    if (zzc2 < 0.0d) {
                        zzc2 += zzc();
                    }
                }
                if (zzc2 < 0.0d) {
                    zzapVar = new zzah(Double.valueOf(-1.0d));
                } else {
                    int min2 = (int) Math.min(zzc(), zzc2);
                    while (true) {
                        if (min2 >= 0) {
                            if (zzs(min2) && zzh.zzl(zze(min2), zzapVar3)) {
                                zzapVar = new zzah(Double.valueOf(min2));
                            } else {
                                min2--;
                            }
                        } else {
                            zzapVar = new zzah(Double.valueOf(-1.0d));
                        }
                    }
                }
                return zzapVar;
            case 7:
                zzh.zzh("map", 1, arrayList);
                zzap zzb8 = zzgVar.zzb((zzap) arrayList.get(0));
                if (zzb8 instanceof zzao) {
                    if (zzc() == 0) {
                        zzapVar = new zzae();
                    } else {
                        zzapVar = SupervisorKt.zzb(this, zzgVar, (zzao) zzb8, null, null);
                    }
                    return zzapVar;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\b':
                zzh.zzh("pop", 0, arrayList);
                int zzc3 = zzc();
                if (zzc3 != 0) {
                    int r0 = zzc3 - 1;
                    zzap zze = zze(r0);
                    zzp(r0);
                    return zze;
                }
                return zzauVar;
            case '\t':
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        zzq(zzc(), zzgVar.zzb((zzap) it2.next()));
                    }
                }
                zzapVar = new zzah(Double.valueOf(zzc()));
                return zzapVar;
            case '\n':
                zzapVar = SupervisorKt.zzc(this, zzgVar, arrayList, true);
                return zzapVar;
            case 11:
                zzapVar = SupervisorKt.zzc(this, zzgVar, arrayList, false);
                return zzapVar;
            case '\f':
                zzh.zzh("reverse", 0, arrayList);
                int zzc4 = zzc();
                if (zzc4 != 0) {
                    for (int r2 = 0; r2 < zzc4 / 2; r2++) {
                        if (zzs(r2)) {
                            zzap zze2 = zze(r2);
                            zzq(r2, null);
                            int r4 = (zzc4 - 1) - r2;
                            if (zzs(r4)) {
                                zzq(r2, zze(r4));
                            }
                            zzq(r4, zze2);
                        }
                    }
                }
                return this;
            case '\r':
                zzh.zzh("shift", 0, arrayList);
                if (zzc() != 0) {
                    zzap zze3 = zze(0);
                    zzp(0);
                    return zze3;
                }
                return zzauVar;
            case 14:
                zzh.zzj("slice", 2, arrayList);
                if (arrayList.isEmpty()) {
                    zzapVar = zzd();
                } else {
                    double zzc5 = zzc();
                    double zza2 = zzh.zza(zzgVar.zzb((zzap) arrayList.get(0)).zzh().doubleValue());
                    if (zza2 < 0.0d) {
                        min = Math.max(zza2 + zzc5, 0.0d);
                    } else {
                        min = Math.min(zza2, zzc5);
                    }
                    if (arrayList.size() == 2) {
                        double zza3 = zzh.zza(zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue());
                        if (zza3 < 0.0d) {
                            zzc5 = Math.max(zzc5 + zza3, 0.0d);
                        } else {
                            zzc5 = Math.min(zzc5, zza3);
                        }
                    }
                    zzapVar = new zzae();
                    for (int r22 = (int) min; r22 < zzc5; r22++) {
                        zzapVar.zzq(zzapVar.zzc(), zze(r22));
                    }
                }
                return zzapVar;
            case 15:
                zzh.zzh(str6, 1, arrayList);
                zzap zzb9 = zzgVar.zzb((zzap) arrayList.get(0));
                if (zzb9 instanceof zzai) {
                    if (zzc() != 0) {
                        zzai zzaiVar2 = (zzai) zzb9;
                        Iterator zzk4 = zzk();
                        while (true) {
                            if (zzk4.hasNext()) {
                                int intValue2 = ((Integer) zzk4.next()).intValue();
                                if (zzs(intValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zze(intValue2), new zzah(Double.valueOf(intValue2)), this)).zzg().booleanValue()) {
                                    zzafVar = zzafVar2;
                                }
                            }
                        }
                    }
                    return zzafVar;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 16:
                zzh.zzj(str5, 1, arrayList);
                if (zzc() >= 2) {
                    ArrayList zzm = zzm();
                    if (!arrayList.isEmpty()) {
                        zzap zzb10 = zzgVar.zzb((zzap) arrayList.get(0));
                        if (zzb10 instanceof zzai) {
                            zzaiVar = (zzai) zzb10;
                        } else {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                    } else {
                        zzaiVar = null;
                    }
                    Collections.sort(zzm, new zzba(zzaiVar, zzgVar));
                    treeMap.clear();
                    Iterator it3 = zzm.iterator();
                    int r23 = 0;
                    while (it3.hasNext()) {
                        zzq(r23, (zzap) it3.next());
                        r23++;
                    }
                }
                return this;
            case 17:
                if (arrayList.isEmpty()) {
                    zzapVar = new zzae();
                    return zzapVar;
                }
                int zza4 = (int) zzh.zza(zzgVar.zzb((zzap) arrayList.get(0)).zzh().doubleValue());
                if (zza4 < 0) {
                    zza4 = Math.max(0, zzc() + zza4);
                } else if (zza4 > zzc()) {
                    zza4 = zzc();
                }
                int zzc6 = zzc();
                zzae zzaeVar4 = new zzae();
                if (arrayList.size() > 1) {
                    int max = Math.max(0, (int) zzh.zza(zzgVar.zzb((zzap) arrayList.get(1)).zzh().doubleValue()));
                    if (max > 0) {
                        for (int r7 = zza4; r7 < Math.min(zzc6, zza4 + max); r7++) {
                            zzaeVar4.zzq(zzaeVar4.zzc(), zze(zza4));
                            zzp(zza4);
                        }
                    }
                    if (arrayList.size() > 2) {
                        for (int r02 = 2; r02 < arrayList.size(); r02++) {
                            zzap zzb11 = zzgVar.zzb((zzap) arrayList.get(r02));
                            if (!(zzb11 instanceof zzag)) {
                                int r72 = (zza4 + r02) - 2;
                                if (r72 >= 0) {
                                    if (r72 >= zzc()) {
                                        zzq(r72, zzb11);
                                    } else {
                                        for (int intValue3 = ((Integer) treeMap.lastKey()).intValue(); intValue3 >= r72; intValue3--) {
                                            Integer valueOf = Integer.valueOf(intValue3);
                                            zzap zzapVar4 = (zzap) treeMap.get(valueOf);
                                            if (zzapVar4 != null) {
                                                zzq(intValue3 + 1, zzapVar4);
                                                treeMap.remove(valueOf);
                                            }
                                        }
                                        zzq(r72, zzb11);
                                    }
                                } else {
                                    throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Invalid value index: ", r72));
                                }
                            } else {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                        }
                    }
                } else {
                    while (zza4 < zzc6) {
                        zzaeVar4.zzq(zzaeVar4.zzc(), zze(zza4));
                        zzq(zza4, null);
                        zza4++;
                    }
                }
                return zzaeVar4;
            case 18:
                zzh.zzh(str8, 0, arrayList);
                zzapVar = new zzat(zzj(","));
                return zzapVar;
            case 19:
                if (!arrayList.isEmpty()) {
                    zzae zzaeVar5 = new zzae();
                    Iterator it4 = arrayList.iterator();
                    while (it4.hasNext()) {
                        zzap zzb12 = zzgVar.zzb((zzap) it4.next());
                        if (!(zzb12 instanceof zzag)) {
                            zzaeVar5.zzq(zzaeVar5.zzc(), zzb12);
                        } else {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                    }
                    int zzc7 = zzaeVar5.zzc();
                    Iterator zzk5 = zzk();
                    while (zzk5.hasNext()) {
                        Integer num2 = (Integer) zzk5.next();
                        zzaeVar5.zzq(num2.intValue() + zzc7, zze(num2.intValue()));
                    }
                    treeMap.clear();
                    Iterator zzk6 = zzaeVar5.zzk();
                    while (zzk6.hasNext()) {
                        Integer num3 = (Integer) zzk6.next();
                        zzq(num3.intValue(), zzaeVar5.zze(num3.intValue()));
                    }
                }
                zzapVar = new zzah(Double.valueOf(zzc()));
                return zzapVar;
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    public final int zzc() {
        TreeMap treeMap = this.zza;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            boolean z = entry.getValue() instanceof zzal;
            TreeMap treeMap = zzaeVar.zza;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (zzap) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((zzap) entry.getValue()).zzd());
            }
        }
        return zzaeVar;
    }

    public final zzap zze(int r2) {
        zzap zzapVar;
        if (r2 < zzc()) {
            if (zzs(r2) && (zzapVar = (zzap) this.zza.get(Integer.valueOf(r2))) != null) {
                return zzapVar;
            }
            return zzap.zzf;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final zzap zzf(String str) {
        zzap zzapVar;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf(zzc()));
        }
        if (zzt(str) && (zzapVar = (zzap) this.zzb.get(str)) != null) {
            return zzapVar;
        }
        return zzap.zzf;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        TreeMap treeMap = this.zza;
        if (treeMap.size() == 1) {
            return zze(0).zzh();
        }
        if (treeMap.size() <= 0) {
            return Double.valueOf(0.0d);
        }
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return zzj(",");
    }

    public final String zzj(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            for (int r2 = 0; r2 < zzc(); r2++) {
                zzap zze = zze(r2);
                sb.append(str);
                if (!(zze instanceof zzau) && !(zze instanceof zzan)) {
                    sb.append(zze.zzi());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final Iterator zzk() {
        return this.zza.keySet().iterator();
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzac(this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final ArrayList zzm() {
        ArrayList arrayList = new ArrayList(zzc());
        for (int r1 = 0; r1 < zzc(); r1++) {
            arrayList.add(zze(r1));
        }
        return arrayList;
    }

    public final void zzp(int r5) {
        TreeMap treeMap = this.zza;
        int intValue = ((Integer) treeMap.lastKey()).intValue();
        if (r5 <= intValue && r5 >= 0) {
            treeMap.remove(Integer.valueOf(r5));
            if (r5 == intValue) {
                int r52 = r5 - 1;
                Integer valueOf = Integer.valueOf(r52);
                if (!treeMap.containsKey(valueOf) && r52 >= 0) {
                    treeMap.put(valueOf, zzap.zzf);
                    return;
                }
                return;
            }
            while (true) {
                r5++;
                if (r5 <= ((Integer) treeMap.lastKey()).intValue()) {
                    Integer valueOf2 = Integer.valueOf(r5);
                    zzap zzapVar = (zzap) treeMap.get(valueOf2);
                    if (zzapVar != null) {
                        treeMap.put(Integer.valueOf(r5 - 1), zzapVar);
                        treeMap.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    @RequiresNonNull({"elements"})
    public final void zzq(int r2, zzap zzapVar) {
        if (r2 <= 32468) {
            if (r2 >= 0) {
                TreeMap treeMap = this.zza;
                if (zzapVar == null) {
                    treeMap.remove(Integer.valueOf(r2));
                    return;
                } else {
                    treeMap.put(Integer.valueOf(r2), zzapVar);
                    return;
                }
            }
            throw new IndexOutOfBoundsException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Out of bounds index: ", r2));
        }
        throw new IllegalStateException("Array too large");
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final void zzr(String str, zzap zzapVar) {
        TreeMap treeMap = this.zzb;
        if (zzapVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, zzapVar);
        }
    }

    public final boolean zzs(int r3) {
        if (r3 >= 0) {
            TreeMap treeMap = this.zza;
            if (r3 <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(r3));
            }
        }
        throw new IndexOutOfBoundsException(SubMenuBuilder$$ExternalSyntheticOutline0.m("Out of bounds index: ", r3));
    }

    @Override // com.google.android.gms.internal.measurement.zzal
    public final boolean zzt(String str) {
        if (!"length".equals(str) && !this.zzb.containsKey(str)) {
            return false;
        }
        return true;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int r0 = 0; r0 < list.size(); r0++) {
                zzq(r0, (zzap) list.get(r0));
            }
        }
    }
}
