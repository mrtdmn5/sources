package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.ui.geometry.MutableRectKt;
import com.animaconnected.firebase.AnalyticsConstants;
import com.animaconnected.firebase.RemoteConfigConstants;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzkp;
import com.google.android.gms.internal.measurement.zzpd;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkv extends zzkh {
    public static final com.google.android.gms.internal.measurement.zzfx zzB(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        for (com.google.android.gms.internal.measurement.zzfx zzfxVar : zzftVar.zzi()) {
            if (zzfxVar.zzg().equals(str)) {
                return zzfxVar;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r6v9, types: [android.os.Bundle[], java.io.Serializable] */
    public static final Serializable zzC(com.google.android.gms.internal.measurement.zzft zzftVar, String str) {
        com.google.android.gms.internal.measurement.zzfx zzB = zzB(zzftVar, str);
        if (zzB != null) {
            if (zzB.zzy()) {
                return zzB.zzh();
            }
            if (zzB.zzw()) {
                return Long.valueOf(zzB.zzd());
            }
            if (zzB.zzu()) {
                return Double.valueOf(zzB.zza());
            }
            if (zzB.zzc() > 0) {
                com.google.android.gms.internal.measurement.zzkm<com.google.android.gms.internal.measurement.zzfx> zzi = zzB.zzi();
                ArrayList arrayList = new ArrayList();
                for (com.google.android.gms.internal.measurement.zzfx zzfxVar : zzi) {
                    if (zzfxVar != null) {
                        Bundle bundle = new Bundle();
                        for (com.google.android.gms.internal.measurement.zzfx zzfxVar2 : zzfxVar.zzi()) {
                            if (zzfxVar2.zzy()) {
                                bundle.putString(zzfxVar2.zzg(), zzfxVar2.zzh());
                            } else if (zzfxVar2.zzw()) {
                                bundle.putLong(zzfxVar2.zzg(), zzfxVar2.zzd());
                            } else if (zzfxVar2.zzu()) {
                                bundle.putDouble(zzfxVar2.zzg(), zzfxVar2.zza());
                            }
                        }
                        if (!bundle.isEmpty()) {
                            arrayList.add(bundle);
                        }
                    }
                }
                return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
            }
            return null;
        }
        return null;
    }

    public static final void zzF(int r2, StringBuilder sb) {
        for (int r0 = 0; r0 < r2; r0++) {
            sb.append("  ");
        }
    }

    public static final String zzG(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static final void zzH(StringBuilder sb, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar) {
        Integer num;
        Integer num2;
        Long l;
        if (zzgiVar == null) {
            return;
        }
        zzF(3, sb);
        sb.append(str);
        sb.append(" {\n");
        if (zzgiVar.zzb() != 0) {
            zzF(4, sb);
            sb.append("results: ");
            int r5 = 0;
            for (Long l2 : zzgiVar.zzk()) {
                int r7 = r5 + 1;
                if (r5 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                r5 = r7;
            }
            sb.append('\n');
        }
        if (zzgiVar.zzd() != 0) {
            zzF(4, sb);
            sb.append("status: ");
            int r52 = 0;
            for (Long l3 : zzgiVar.zzn()) {
                int r72 = r52 + 1;
                if (r52 != 0) {
                    sb.append(", ");
                }
                sb.append(l3);
                r52 = r72;
            }
            sb.append('\n');
        }
        if (zzgiVar.zza() != 0) {
            zzF(4, sb);
            sb.append("dynamic_filter_timestamps: {");
            int r6 = 0;
            for (com.google.android.gms.internal.measurement.zzfr zzfrVar : zzgiVar.zzj()) {
                int r8 = r6 + 1;
                if (r6 != 0) {
                    sb.append(", ");
                }
                if (zzfrVar.zzh()) {
                    num2 = Integer.valueOf(zzfrVar.zza());
                } else {
                    num2 = null;
                }
                sb.append(num2);
                sb.append(":");
                if (zzfrVar.zzg()) {
                    l = Long.valueOf(zzfrVar.zzb());
                } else {
                    l = null;
                }
                sb.append(l);
                r6 = r8;
            }
            sb.append("}\n");
        }
        if (zzgiVar.zzc() != 0) {
            zzF(4, sb);
            sb.append("sequence_filter_timestamps: {");
            int r12 = 0;
            for (com.google.android.gms.internal.measurement.zzgk zzgkVar : zzgiVar.zzm()) {
                int r62 = r12 + 1;
                if (r12 != 0) {
                    sb.append(", ");
                }
                if (zzgkVar.zzi()) {
                    num = Integer.valueOf(zzgkVar.zzb());
                } else {
                    num = null;
                }
                sb.append(num);
                sb.append(": [");
                Iterator it = zzgkVar.zzf().iterator();
                int r2 = 0;
                while (it.hasNext()) {
                    long longValue = ((Long) it.next()).longValue();
                    int r9 = r2 + 1;
                    if (r2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    r2 = r9;
                }
                sb.append("]");
                r12 = r62;
            }
            sb.append("}\n");
        }
        zzF(3, sb);
        sb.append("}\n");
    }

    public static final void zzI(StringBuilder sb, int r1, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zzF(r1 + 1, sb);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static final void zzJ(StringBuilder sb, int r2, String str, com.google.android.gms.internal.measurement.zzer zzerVar) {
        String str2;
        if (zzerVar == null) {
            return;
        }
        zzF(r2, sb);
        sb.append(str);
        sb.append(" {\n");
        if (zzerVar.zzg()) {
            int zzm = zzerVar.zzm();
            if (zzm != 1) {
                if (zzm != 2) {
                    if (zzm != 3) {
                        if (zzm != 4) {
                            str2 = "BETWEEN";
                        } else {
                            str2 = "EQUAL";
                        }
                    } else {
                        str2 = "GREATER_THAN";
                    }
                } else {
                    str2 = "LESS_THAN";
                }
            } else {
                str2 = "UNKNOWN_COMPARISON_TYPE";
            }
            zzI(sb, r2, "comparison_type", str2);
        }
        if (zzerVar.zzi()) {
            zzI(sb, r2, "match_as_float", Boolean.valueOf(zzerVar.zzf()));
        }
        if (zzerVar.zzh()) {
            zzI(sb, r2, "comparison_value", zzerVar.zzc());
        }
        if (zzerVar.zzk()) {
            zzI(sb, r2, "min_comparison_value", zzerVar.zze());
        }
        if (zzerVar.zzj()) {
            zzI(sb, r2, "max_comparison_value", zzerVar.zzd());
        }
        zzF(r2, sb);
        sb.append("}\n");
    }

    public static int zza(com.google.android.gms.internal.measurement.zzgc zzgcVar, String str) {
        for (int r0 = 0; r0 < ((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zza).zzg(); r0++) {
            if (str.equals(((com.google.android.gms.internal.measurement.zzgd) zzgcVar.zza).zzv(r0).zzf())) {
                return r0;
            }
        }
        return -1;
    }

    public static Bundle zzf(Map map, boolean z) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof ArrayList) {
                if (z) {
                    ArrayList arrayList = (ArrayList) obj;
                    ArrayList arrayList2 = new ArrayList();
                    int size = arrayList.size();
                    for (int r7 = 0; r7 < size; r7++) {
                        arrayList2.add(zzf((Map) arrayList.get(r7), false));
                    }
                    bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
                }
            } else {
                bundle.putString(str, obj.toString());
            }
        }
        return bundle;
    }

    public static zzaw zzi(com.google.android.gms.internal.measurement.zzaa zzaaVar) {
        String str;
        Object obj;
        Bundle zzf = zzf(zzaaVar.zzc, true);
        if (zzf.containsKey("_o") && (obj = zzf.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = MutableRectKt.zzb(zzaaVar.zza, zzgo.zza, zzgo.zzc);
        if (zzb == null) {
            zzb = zzaaVar.zza;
        }
        return new zzaw(zzb, new zzau(zzf), str2, zzaaVar.zzb);
    }

    public static com.google.android.gms.internal.measurement.zzkb zzl(com.google.android.gms.internal.measurement.zzkb zzkbVar, byte[] bArr) throws zzkp {
        com.google.android.gms.internal.measurement.zzjr zzjrVar;
        com.google.android.gms.internal.measurement.zzjr zzjrVar2 = com.google.android.gms.internal.measurement.zzjr.zzd;
        if (zzjrVar2 == null) {
            synchronized (com.google.android.gms.internal.measurement.zzjr.class) {
                zzjrVar = com.google.android.gms.internal.measurement.zzjr.zzd;
                if (zzjrVar == null) {
                    zzjrVar = com.google.android.gms.internal.measurement.zzjz.zzb();
                    com.google.android.gms.internal.measurement.zzjr.zzd = zzjrVar;
                }
            }
            zzjrVar2 = zzjrVar;
        }
        if (zzjrVar2 != null) {
            zzkbVar.getClass();
            zzkbVar.zzaB(bArr, bArr.length, zzjrVar2);
            return zzkbVar;
        }
        zzkbVar.getClass();
        zzkbVar.zzaB(bArr, bArr.length, com.google.android.gms.internal.measurement.zzjr.zza);
        return zzkbVar;
    }

    public static ArrayList zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int r4 = 0; r4 < length; r4++) {
            long j = 0;
            for (int r7 = 0; r7 < 64; r7++) {
                int r8 = (r4 * 64) + r7;
                if (r8 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(r8)) {
                    j |= 1 << r7;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:            r5 = new java.util.ArrayList();     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:            if (r4 == false) goto L23;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:            r3 = (android.os.Parcelable[]) r3;        r4 = r3.length;        r7 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:            if (r7 >= r4) goto L48;     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:            r8 = r3[r7];     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:            if ((r8 instanceof android.os.Bundle) == false) goto L50;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:            r5.add(zzs((android.os.Bundle) r8, false));     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:            r7 = r7 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:            r0.put(r2, r5);     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:            if ((r3 instanceof java.util.ArrayList) == false) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:            r3 = (java.util.ArrayList) r3;        r4 = r3.size();        r7 = 0;     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:            if (r7 >= r4) goto L51;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:            r8 = r3.get(r7);     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:            if ((r8 instanceof android.os.Bundle) == false) goto L53;     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:            r5.add(zzs((android.os.Bundle) r8, false));     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:            r7 = r7 + 1;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0075, code lost:            if ((r3 instanceof android.os.Bundle) == false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0077, code lost:            r5.add(zzs((android.os.Bundle) r3, false));     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.HashMap zzs(android.os.Bundle r10, boolean r11) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.Set r1 = r10.keySet()
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L84
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r10.get(r2)
            boolean r4 = r3 instanceof android.os.Parcelable[]
            if (r4 != 0) goto L30
            boolean r5 = r3 instanceof java.util.ArrayList
            if (r5 != 0) goto L30
            boolean r5 = r3 instanceof android.os.Bundle
            if (r5 == 0) goto L2a
            goto L30
        L2a:
            if (r3 == 0) goto Ld
            r0.put(r2, r3)
            goto Ld
        L30:
            if (r11 == 0) goto Ld
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = 0
            if (r4 == 0) goto L52
            android.os.Parcelable[] r3 = (android.os.Parcelable[]) r3
            int r4 = r3.length
            r7 = r6
        L3e:
            if (r7 >= r4) goto L80
            r8 = r3[r7]
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L4f
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = zzs(r8, r6)
            r5.add(r8)
        L4f:
            int r7 = r7 + 1
            goto L3e
        L52:
            boolean r4 = r3 instanceof java.util.ArrayList
            if (r4 == 0) goto L73
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r4 = r3.size()
            r7 = r6
        L5d:
            if (r7 >= r4) goto L80
            java.lang.Object r8 = r3.get(r7)
            boolean r9 = r8 instanceof android.os.Bundle
            if (r9 == 0) goto L70
            android.os.Bundle r8 = (android.os.Bundle) r8
            java.util.HashMap r8 = zzs(r8, r6)
            r5.add(r8)
        L70:
            int r7 = r7 + 1
            goto L5d
        L73:
            boolean r4 = r3 instanceof android.os.Bundle
            if (r4 == 0) goto L80
            android.os.Bundle r3 = (android.os.Bundle) r3
            java.util.HashMap r3 = zzs(r3, r6)
            r5.add(r3)
        L80:
            r0.put(r2, r5)
            goto Ld
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.zzs(android.os.Bundle, boolean):java.util.HashMap");
    }

    public static boolean zzv(int r4, com.google.android.gms.internal.measurement.zzkl zzklVar) {
        if (r4 < zzklVar.size() * 64) {
            if (((1 << (r4 % 64)) & ((Long) zzklVar.get(r4 / 64)).longValue()) != 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean zzx(String str) {
        if (str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310) {
            return true;
        }
        return false;
    }

    public static final void zzz(com.google.android.gms.internal.measurement.zzfs zzfsVar, String str, Long l) {
        List zzp = zzfsVar.zzp();
        int r1 = 0;
        while (true) {
            if (r1 < zzp.size()) {
                if (str.equals(((com.google.android.gms.internal.measurement.zzfx) zzp.get(r1)).zzg())) {
                    break;
                } else {
                    r1++;
                }
            } else {
                r1 = -1;
                break;
            }
        }
        com.google.android.gms.internal.measurement.zzfw zze$1 = com.google.android.gms.internal.measurement.zzfx.zze$1();
        zze$1.zzj(str);
        if (l instanceof Long) {
            zze$1.zzi(l.longValue());
        }
        if (r1 >= 0) {
            zzfsVar.zzaG();
            com.google.android.gms.internal.measurement.zzft.zzj((com.google.android.gms.internal.measurement.zzft) zzfsVar.zza, r1, (com.google.android.gms.internal.measurement.zzfx) zze$1.zzaC());
        } else {
            zzfsVar.zze(zze$1);
        }
    }

    public final void zzD(StringBuilder sb, int r7, com.google.android.gms.internal.measurement.zzkm zzkmVar) {
        String str;
        String str2;
        Long l;
        if (zzkmVar == null) {
            return;
        }
        int r72 = r7 + 1;
        Iterator it = zzkmVar.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.measurement.zzfx zzfxVar = (com.google.android.gms.internal.measurement.zzfx) it.next();
            if (zzfxVar != null) {
                zzF(r72, sb);
                sb.append("param {\n");
                Double d = null;
                if (zzfxVar.zzx()) {
                    str = this.zzt.zzq.zze(zzfxVar.zzg());
                } else {
                    str = null;
                }
                zzI(sb, r72, "name", str);
                if (zzfxVar.zzy()) {
                    str2 = zzfxVar.zzh();
                } else {
                    str2 = null;
                }
                zzI(sb, r72, "string_value", str2);
                if (zzfxVar.zzw()) {
                    l = Long.valueOf(zzfxVar.zzd());
                } else {
                    l = null;
                }
                zzI(sb, r72, "int_value", l);
                if (zzfxVar.zzu()) {
                    d = Double.valueOf(zzfxVar.zza());
                }
                zzI(sb, r72, "double_value", d);
                if (zzfxVar.zzc() > 0) {
                    zzD(sb, r72, zzfxVar.zzi());
                }
                zzF(r72, sb);
                sb.append("}\n");
            }
        }
    }

    public final void zzE(StringBuilder sb, int r7, com.google.android.gms.internal.measurement.zzem zzemVar) {
        String str;
        if (zzemVar == null) {
            return;
        }
        zzF(r7, sb);
        sb.append("filter {\n");
        if (zzemVar.zzh()) {
            zzI(sb, r7, "complement", Boolean.valueOf(zzemVar.zzg()));
        }
        if (zzemVar.zzj()) {
            zzI(sb, r7, "param_name", this.zzt.zzq.zze(zzemVar.zze()));
        }
        if (zzemVar.zzk()) {
            int r0 = r7 + 1;
            com.google.android.gms.internal.measurement.zzey zzd = zzemVar.zzd();
            if (zzd != null) {
                zzF(r0, sb);
                sb.append("string_filter {\n");
                if (zzd.zzi()) {
                    switch (zzd.zzj()) {
                        case 1:
                            str = "UNKNOWN_MATCH_TYPE";
                            break;
                        case 2:
                            str = "REGEXP";
                            break;
                        case 3:
                            str = "BEGINS_WITH";
                            break;
                        case 4:
                            str = "ENDS_WITH";
                            break;
                        case 5:
                            str = "PARTIAL";
                            break;
                        case 6:
                            str = "EXACT";
                            break;
                        default:
                            str = "IN_LIST";
                            break;
                    }
                    zzI(sb, r0, "match_type", str);
                }
                if (zzd.zzh()) {
                    zzI(sb, r0, "expression", zzd.zzd());
                }
                if (zzd.zzg()) {
                    zzI(sb, r0, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                }
                if (zzd.zza() > 0) {
                    zzF(r0 + 1, sb);
                    sb.append("expression_list {\n");
                    for (String str2 : zzd.zze()) {
                        zzF(r0 + 2, sb);
                        sb.append(str2);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zzF(r0, sb);
                sb.append("}\n");
            }
        }
        if (zzemVar.zzi()) {
            zzJ(sb, r7 + 1, "number_filter", zzemVar.zzc());
        }
        zzF(r7, sb);
        sb.append("}\n");
    }

    public final long zzd(byte[] bArr) {
        zzfr zzfrVar = this.zzt;
        zzlb zzlbVar = zzfrVar.zzp;
        zzfr.zzP(zzlbVar);
        zzlbVar.zzg();
        MessageDigest zzF = zzlb.zzF();
        if (zzF == null) {
            zzeh zzehVar = zzfrVar.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to get MD5");
            return 0L;
        }
        return zzlb.zzp(zzF.digest(bArr));
    }

    public final Parcelable zzh(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    public final String zzm(com.google.android.gms.internal.measurement.zzgb zzgbVar) {
        Long l;
        Long l2;
        Double d;
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("\nbatch {\n");
        for (com.google.android.gms.internal.measurement.zzgd zzgdVar : zzgbVar.zzd()) {
            if (zzgdVar != null) {
                zzF(1, m);
                m.append("bundle {\n");
                if (zzgdVar.zzbj()) {
                    zzI(m, 1, "protocol_version", Integer.valueOf(zzgdVar.zzd()));
                }
                zzpd.zzc();
                zzfr zzfrVar = this.zzt;
                if (zzfrVar.zzk.zzs(null, zzdu.zzal)) {
                    if (zzfrVar.zzk.zzs(zzgdVar.zzx(), zzdu.zzan) && zzgdVar.zzbm()) {
                        zzI(m, 1, "session_stitching_token", zzgdVar.zzK());
                    }
                }
                zzI(m, 1, "platform", zzgdVar.zzI());
                if (zzgdVar.zzbf()) {
                    zzI(m, 1, "gmp_version", Long.valueOf(zzgdVar.zzm()));
                }
                if (zzgdVar.zzbq()) {
                    zzI(m, 1, "uploading_gmp_version", Long.valueOf(zzgdVar.zzr()));
                }
                if (zzgdVar.zzbd()) {
                    zzI(m, 1, "dynamite_version", Long.valueOf(zzgdVar.zzj()));
                }
                if (zzgdVar.zzba()) {
                    zzI(m, 1, RemoteConfigConstants.CONFIG_VERSION, Long.valueOf(zzgdVar.zzh()));
                }
                zzI(m, 1, "gmp_app_id", zzgdVar.zzF());
                zzI(m, 1, "admob_app_id", zzgdVar.zzw());
                zzI(m, 1, AnalyticsConstants.USER_PROPERTY_APP_ID, zzgdVar.zzx());
                zzI(m, 1, "app_version", zzgdVar.zzA());
                if (zzgdVar.zzaY()) {
                    zzI(m, 1, "app_version_major", Integer.valueOf(zzgdVar.zza()));
                }
                zzI(m, 1, "firebase_instance_id", zzgdVar.zzE());
                if (zzgdVar.zzbc()) {
                    zzI(m, 1, "dev_cert_hash", Long.valueOf(zzgdVar.zzi()));
                }
                zzI(m, 1, "app_store", zzgdVar.zzz());
                if (zzgdVar.zzbp()) {
                    zzI(m, 1, "upload_timestamp_millis", Long.valueOf(zzgdVar.zzq()));
                }
                if (zzgdVar.zzbn()) {
                    zzI(m, 1, "start_timestamp_millis", Long.valueOf(zzgdVar.zzp()));
                }
                if (zzgdVar.zzbe()) {
                    zzI(m, 1, "end_timestamp_millis", Long.valueOf(zzgdVar.zzk()));
                }
                if (zzgdVar.zzbi()) {
                    zzI(m, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgdVar.zzo()));
                }
                if (zzgdVar.zzbh()) {
                    zzI(m, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgdVar.zzn()));
                }
                zzI(m, 1, "app_instance_id", zzgdVar.zzy());
                zzI(m, 1, "resettable_device_id", zzgdVar.zzJ());
                zzI(m, 1, "ds_id", zzgdVar.zzD());
                if (zzgdVar.zzbg()) {
                    zzI(m, 1, "limited_ad_tracking", Boolean.valueOf(zzgdVar.zzaW()));
                }
                zzI(m, 1, "os_version", zzgdVar.zzH());
                zzI(m, 1, "device_model", zzgdVar.zzC());
                zzI(m, 1, "user_default_language", zzgdVar.zzL());
                if (zzgdVar.zzbo()) {
                    zzI(m, 1, "time_zone_offset_minutes", Integer.valueOf(zzgdVar.zzf()));
                }
                if (zzgdVar.zzaZ()) {
                    zzI(m, 1, "bundle_sequential_index", Integer.valueOf(zzgdVar.zzb()));
                }
                if (zzgdVar.zzbl()) {
                    zzI(m, 1, "service_upload", Boolean.valueOf(zzgdVar.zzaX()));
                }
                zzI(m, 1, "health_monitor", zzgdVar.zzG());
                if (zzgdVar.zzbk()) {
                    zzI(m, 1, "retry_counter", Integer.valueOf(zzgdVar.zze()));
                }
                if (zzgdVar.zzbb()) {
                    zzI(m, 1, "consent_signals", zzgdVar.zzB());
                }
                com.google.android.gms.internal.measurement.zzkm<com.google.android.gms.internal.measurement.zzgm> zzO = zzgdVar.zzO();
                zzec zzecVar = zzfrVar.zzq;
                if (zzO != null) {
                    for (com.google.android.gms.internal.measurement.zzgm zzgmVar : zzO) {
                        if (zzgmVar != null) {
                            zzF(2, m);
                            m.append("user_property {\n");
                            if (zzgmVar.zzs()) {
                                l = Long.valueOf(zzgmVar.zzc());
                            } else {
                                l = null;
                            }
                            zzI(m, 2, "set_timestamp_millis", l);
                            zzI(m, 2, "name", zzecVar.zzf(zzgmVar.zzf()));
                            zzI(m, 2, "string_value", zzgmVar.zzg());
                            if (zzgmVar.zzr()) {
                                l2 = Long.valueOf(zzgmVar.zzb());
                            } else {
                                l2 = null;
                            }
                            zzI(m, 2, "int_value", l2);
                            if (zzgmVar.zzq()) {
                                d = Double.valueOf(zzgmVar.zza());
                            } else {
                                d = null;
                            }
                            zzI(m, 2, "double_value", d);
                            zzF(2, m);
                            m.append("}\n");
                        }
                    }
                }
                com.google.android.gms.internal.measurement.zzkm<zzfp> zzM = zzgdVar.zzM();
                if (zzM != null) {
                    for (zzfp zzfpVar : zzM) {
                        if (zzfpVar != null) {
                            zzF(2, m);
                            m.append("audience_membership {\n");
                            if (zzfpVar.zzk()) {
                                zzI(m, 2, "audience_id", Integer.valueOf(zzfpVar.zza()));
                            }
                            if (zzfpVar.zzm()) {
                                zzI(m, 2, "new_audience", Boolean.valueOf(zzfpVar.zzj()));
                            }
                            zzH(m, "current_data", zzfpVar.zzd());
                            if (zzfpVar.zzn()) {
                                zzH(m, "previous_data", zzfpVar.zze());
                            }
                            zzF(2, m);
                            m.append("}\n");
                        }
                    }
                }
                com.google.android.gms.internal.measurement.zzkm<com.google.android.gms.internal.measurement.zzft> zzN = zzgdVar.zzN();
                if (zzN != null) {
                    for (com.google.android.gms.internal.measurement.zzft zzftVar : zzN) {
                        if (zzftVar != null) {
                            zzF(2, m);
                            m.append("event {\n");
                            zzI(m, 2, "name", zzecVar.zzd(zzftVar.zzh()));
                            if (zzftVar.zzu()) {
                                zzI(m, 2, "timestamp_millis", Long.valueOf(zzftVar.zzd()));
                            }
                            if (zzftVar.zzt()) {
                                zzI(m, 2, "previous_timestamp_millis", Long.valueOf(zzftVar.zzc()));
                            }
                            if (zzftVar.zzs()) {
                                zzI(m, 2, "count", Integer.valueOf(zzftVar.zza()));
                            }
                            if (zzftVar.zzb() != 0) {
                                zzD(m, 2, zzftVar.zzi());
                            }
                            zzF(2, m);
                            m.append("}\n");
                        }
                    }
                }
                zzF(1, m);
                m.append("}\n");
            }
        }
        m.append("}\n");
        return m.toString();
    }

    public final String zzp(zzet zzetVar) {
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m("\nproperty_filter {\n");
        if (zzetVar.zzj()) {
            zzI(m, 0, "filter_id", Integer.valueOf(zzetVar.zza()));
        }
        zzI(m, 0, "property_name", this.zzt.zzq.zzf(zzetVar.zze()));
        String zzG = zzG(zzetVar.zzg(), zzetVar.zzh(), zzetVar.zzi());
        if (!zzG.isEmpty()) {
            zzI(m, 0, "filter_type", zzG);
        }
        zzE(m, 1, zzetVar.zzb());
        m.append("}\n");
        return m.toString();
    }

    public final List zzq(com.google.android.gms.internal.measurement.zzkl zzklVar, List list) {
        int r9;
        ArrayList arrayList = new ArrayList(zzklVar);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int intValue = num.intValue();
            zzfr zzfrVar = this.zzt;
            if (intValue < 0) {
                zzeh zzehVar = zzfrVar.zzm;
                zzfr.zzR(zzehVar);
                zzehVar.zzg.zzb(num, "Ignoring negative bit index to be cleared");
            } else {
                int intValue2 = num.intValue() / 64;
                if (intValue2 >= arrayList.size()) {
                    zzeh zzehVar2 = zzfrVar.zzm;
                    zzfr.zzR(zzehVar2);
                    zzehVar2.zzg.zzc(num, Integer.valueOf(arrayList.size()), "Ignoring bit index greater than bitSet size");
                } else {
                    arrayList.set(intValue2, Long.valueOf(((Long) arrayList.get(intValue2)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int r6 = size2;
            r9 = size;
            size = r6;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, r9);
    }

    public final void zzt(com.google.android.gms.internal.measurement.zzfw zzfwVar, Object obj) {
        zzfwVar.zzaG();
        com.google.android.gms.internal.measurement.zzfx.zzm((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza);
        zzfwVar.zzaG();
        com.google.android.gms.internal.measurement.zzfx.zzo((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza);
        zzfwVar.zzaG();
        com.google.android.gms.internal.measurement.zzfx.zzq((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza);
        zzfwVar.zzaG();
        com.google.android.gms.internal.measurement.zzfx.zzt((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza);
        if (obj instanceof String) {
            zzfwVar.zzaG();
            com.google.android.gms.internal.measurement.zzfx.zzk((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza, (String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzfwVar.zzi(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            zzfwVar.zzaG();
            com.google.android.gms.internal.measurement.zzfx.zzp((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza, doubleValue);
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    com.google.android.gms.internal.measurement.zzfw zze$1 = com.google.android.gms.internal.measurement.zzfx.zze$1();
                    for (String str : bundle.keySet()) {
                        com.google.android.gms.internal.measurement.zzfw zze$12 = com.google.android.gms.internal.measurement.zzfx.zze$1();
                        zze$12.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze$12.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze$12.zzaG();
                            com.google.android.gms.internal.measurement.zzfx.zzk((com.google.android.gms.internal.measurement.zzfx) zze$12.zza, (String) obj2);
                        } else if (obj2 instanceof Double) {
                            double doubleValue2 = ((Double) obj2).doubleValue();
                            zze$12.zzaG();
                            com.google.android.gms.internal.measurement.zzfx.zzp((com.google.android.gms.internal.measurement.zzfx) zze$12.zza, doubleValue2);
                        }
                        zze$1.zzaG();
                        com.google.android.gms.internal.measurement.zzfx.zzr((com.google.android.gms.internal.measurement.zzfx) zze$1.zza, (com.google.android.gms.internal.measurement.zzfx) zze$12.zzaC());
                    }
                    if (((com.google.android.gms.internal.measurement.zzfx) zze$1.zza).zzc() > 0) {
                        arrayList.add((com.google.android.gms.internal.measurement.zzfx) zze$1.zzaC());
                    }
                }
            }
            zzfwVar.zzaG();
            com.google.android.gms.internal.measurement.zzfx.zzs((com.google.android.gms.internal.measurement.zzfx) zzfwVar.zza, arrayList);
            return;
        }
        zzeh zzehVar = this.zzt.zzm;
        zzfr.zzR(zzehVar);
        zzehVar.zzd.zzb(obj, "Ignoring invalid (type) event param value");
    }

    public final boolean zzw(long j, long j2) {
        if (j != 0 && j2 > 0) {
            this.zzt.zzr.getClass();
            if (Math.abs(System.currentTimeMillis() - j) <= j2) {
                return false;
            }
            return true;
        }
        return true;
    }

    public final byte[] zzy(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzeh zzehVar = this.zzt.zzm;
            zzfr.zzR(zzehVar);
            zzehVar.zzd.zzb(e, "Failed to gzip content");
            throw e;
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final void zzb() {
    }
}
