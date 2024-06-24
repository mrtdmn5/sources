package kotlinx.coroutines;

import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.internal.measurement.zzah;
import com.google.android.gms.internal.measurement.zzai;
import com.google.android.gms.internal.measurement.zzao;
import com.google.android.gms.internal.measurement.zzap;
import com.google.android.gms.internal.measurement.zzg;
import com.google.android.gms.internal.measurement.zzh;
import com.google.gson.internal.ObjectConstructor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* compiled from: Supervisor.kt */
/* loaded from: classes4.dex */
public final class SupervisorKt implements ObjectConstructor {
    public static SupervisorJobImpl SupervisorJob$default() {
        return new SupervisorJobImpl(null);
    }

    public static SQLException create(String str, Throwable th) {
        SQLException sQLException;
        if (th instanceof SQLException) {
            sQLException = new SQLException(str, ((SQLException) th).getSQLState());
        } else {
            sQLException = new SQLException(str);
        }
        sQLException.initCause(th);
        return sQLException;
    }

    public static zzae zzb(zzae zzaeVar, zzg zzgVar, zzao zzaoVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator zzk = zzaeVar.zzk();
        while (zzk.hasNext()) {
            int intValue = ((Integer) zzk.next()).intValue();
            if (zzaeVar.zzs(intValue)) {
                zzap zza = zzaoVar.zza(zzgVar, Arrays.asList(zzaeVar.zze(intValue), new zzah(Double.valueOf(intValue)), zzaeVar));
                if (zza.zzg().equals(bool)) {
                    return zzaeVar2;
                }
                if (bool2 == null || zza.zzg().equals(bool2)) {
                    zzaeVar2.zzq(intValue, zza);
                }
            }
        }
        return zzaeVar2;
    }

    public static zzap zzc(zzae zzaeVar, zzg zzgVar, ArrayList arrayList, boolean z) {
        zzap zzapVar;
        int r5;
        int r4;
        zzh.zzi("reduce", 1, arrayList);
        zzh.zzj("reduce", 2, arrayList);
        zzap zzb = zzgVar.zzb((zzap) arrayList.get(0));
        if (zzb instanceof zzai) {
            if (arrayList.size() == 2) {
                zzapVar = zzgVar.zzb((zzap) arrayList.get(1));
                if (zzapVar instanceof zzag) {
                    throw new IllegalArgumentException("Failed to parse initial value");
                }
            } else if (zzaeVar.zzc() != 0) {
                zzapVar = null;
            } else {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzai zzaiVar = (zzai) zzb;
            int zzc = zzaeVar.zzc();
            if (z) {
                r5 = 0;
            } else {
                r5 = zzc - 1;
            }
            int r6 = -1;
            if (z) {
                r4 = zzc - 1;
            } else {
                r4 = 0;
            }
            if (true == z) {
                r6 = 1;
            }
            if (zzapVar == null) {
                zzapVar = zzaeVar.zze(r5);
                r5 += r6;
            }
            while ((r4 - r5) * r6 >= 0) {
                if (zzaeVar.zzs(r5)) {
                    zzapVar = zzaiVar.zza(zzgVar, Arrays.asList(zzapVar, zzaeVar.zze(r5), new zzah(Double.valueOf(r5)), zzaeVar));
                    if (zzapVar instanceof zzag) {
                        throw new IllegalStateException("Reduce operation failed");
                    }
                    r5 += r6;
                } else {
                    r5 += r6;
                }
            }
            return zzapVar;
        }
        throw new IllegalArgumentException("Callback should be a method");
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return new LinkedHashSet();
    }
}
