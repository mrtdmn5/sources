package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzy {
    public final String zzb;
    public final int zzc;
    public Boolean zzd;
    public Boolean zze;
    public Long zzf;
    public Long zzg;

    public zzy(String str, int r2) {
        this.zzb = str;
        this.zzc = r2;
    }

    public static Boolean zze(BigDecimal bigDecimal, com.google.android.gms.internal.measurement.zzer zzerVar, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzerVar);
        if (zzerVar.zzg()) {
            boolean z = true;
            if (zzerVar.zzm() != 1) {
                if (zzerVar.zzm() == 5) {
                    if (!zzerVar.zzk() || !zzerVar.zzj()) {
                        return null;
                    }
                } else if (!zzerVar.zzh()) {
                    return null;
                }
                int zzm = zzerVar.zzm();
                if (zzerVar.zzm() == 5) {
                    if (zzkv.zzx(zzerVar.zze()) && zzkv.zzx(zzerVar.zzd())) {
                        try {
                            BigDecimal bigDecimal5 = new BigDecimal(zzerVar.zze());
                            bigDecimal4 = new BigDecimal(zzerVar.zzd());
                            bigDecimal3 = bigDecimal5;
                            bigDecimal2 = null;
                        } catch (NumberFormatException unused) {
                        }
                    }
                    return null;
                }
                if (!zzkv.zzx(zzerVar.zzc())) {
                    return null;
                }
                try {
                    bigDecimal2 = new BigDecimal(zzerVar.zzc());
                    bigDecimal3 = null;
                    bigDecimal4 = null;
                } catch (NumberFormatException unused2) {
                }
                if (zzm == 5) {
                    if (bigDecimal3 == null) {
                        return null;
                    }
                } else if (bigDecimal2 == null) {
                    return null;
                }
                int r0 = zzm - 1;
                if (r0 != 1) {
                    if (r0 != 2) {
                        if (r0 != 3) {
                            if (r0 != 4 || bigDecimal3 == null) {
                                return null;
                            }
                            if (bigDecimal.compareTo(bigDecimal3) < 0 || bigDecimal.compareTo(bigDecimal4) > 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal2 == null) {
                            return null;
                        }
                        if (d != 0.0d) {
                            if (bigDecimal.compareTo(bigDecimal2.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) <= 0 || bigDecimal.compareTo(bigDecimal2.add(new BigDecimal(d).multiply(new BigDecimal(2)))) >= 0) {
                                z = false;
                            }
                            return Boolean.valueOf(z);
                        }
                        if (bigDecimal.compareTo(bigDecimal2) != 0) {
                            z = false;
                        }
                        return Boolean.valueOf(z);
                    }
                    if (bigDecimal2 == null) {
                        return null;
                    }
                    if (bigDecimal.compareTo(bigDecimal2) <= 0) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
                if (bigDecimal2 == null) {
                    return null;
                }
                if (bigDecimal.compareTo(bigDecimal2) >= 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    public static Boolean zzf(String str, com.google.android.gms.internal.measurement.zzey zzeyVar, zzeh zzehVar) {
        String zzd;
        List zze;
        String str2;
        int r11;
        Preconditions.checkNotNull(zzeyVar);
        if (str == null || !zzeyVar.zzi() || zzeyVar.zzj() == 1) {
            return null;
        }
        if (zzeyVar.zzj() == 7) {
            if (zzeyVar.zza() == 0) {
                return null;
            }
        } else if (!zzeyVar.zzh()) {
            return null;
        }
        int zzj = zzeyVar.zzj();
        boolean zzf = zzeyVar.zzf();
        if (!zzf && zzj != 2 && zzj != 7) {
            zzd = zzeyVar.zzd().toUpperCase(Locale.ENGLISH);
        } else {
            zzd = zzeyVar.zzd();
        }
        if (zzeyVar.zza() == 0) {
            zze = null;
        } else {
            zze = zzeyVar.zze();
            if (!zzf) {
                ArrayList arrayList = new ArrayList(zze.size());
                Iterator it = zze.iterator();
                while (it.hasNext()) {
                    arrayList.add(((String) it.next()).toUpperCase(Locale.ENGLISH));
                }
                zze = Collections.unmodifiableList(arrayList);
            }
        }
        if (zzj == 2) {
            str2 = zzd;
        } else {
            str2 = null;
        }
        if (zzj == 7) {
            if (zze == null || zze.isEmpty()) {
                return null;
            }
        } else if (zzd == null) {
            return null;
        }
        if (!zzf && zzj != 2) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzj - 1) {
            case 1:
                if (str2 == null) {
                    return null;
                }
                if (true != zzf) {
                    r11 = 66;
                } else {
                    r11 = 0;
                }
                try {
                    return Boolean.valueOf(Pattern.compile(str2, r11).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzehVar.zzg.zzb(str2, "Invalid regular expression in REGEXP audience filter. expression");
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(zzd));
            case 3:
                return Boolean.valueOf(str.endsWith(zzd));
            case 4:
                return Boolean.valueOf(str.contains(zzd));
            case 5:
                return Boolean.valueOf(str.equals(zzd));
            case 6:
                if (zze == null) {
                    return null;
                }
                return Boolean.valueOf(zze.contains(str));
            default:
                return null;
        }
    }

    public static Boolean zzj(Boolean bool, boolean z) {
        boolean z2;
        if (bool == null) {
            return null;
        }
        if (bool.booleanValue() != z) {
            z2 = true;
        } else {
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }

    public abstract int zza();

    public abstract boolean zzb();

    public abstract boolean zzc();
}
