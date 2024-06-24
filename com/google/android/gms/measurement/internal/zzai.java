package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzai {
    public static final zzai zza = new zzai(null, null);
    public final EnumMap zzb;

    public zzai(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzah.class);
        this.zzb = enumMap;
        enumMap.put((EnumMap) zzah.AD_STORAGE, (zzah) bool);
        enumMap.put((EnumMap) zzah.ANALYTICS_STORAGE, (zzah) bool2);
    }

    public static zzai zza(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            String string = bundle.getString(zzahVar.zzd);
            Boolean bool = null;
            if (string != null) {
                if (string.equals("granted")) {
                    bool = Boolean.TRUE;
                } else if (string.equals("denied")) {
                    bool = Boolean.FALSE;
                }
            }
            enumMap.put((EnumMap) zzahVar, (zzah) bool);
        }
        return new zzai(enumMap);
    }

    public static zzai zzb(String str) {
        EnumMap enumMap = new EnumMap(zzah.class);
        if (str != null) {
            int r1 = 0;
            while (true) {
                zzah[] zzahVarArr = zzah.zzc;
                int length = zzahVarArr.length;
                if (r1 >= 2) {
                    break;
                }
                zzah zzahVar = zzahVarArr[r1];
                int r3 = r1 + 2;
                if (r3 < str.length()) {
                    char charAt = str.charAt(r3);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt != '0') {
                            if (charAt == '1') {
                                bool = Boolean.TRUE;
                            }
                        } else {
                            bool = Boolean.FALSE;
                        }
                    }
                    enumMap.put((EnumMap) zzahVar, (zzah) bool);
                }
                r1++;
            }
        }
        return new zzai(enumMap);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzaiVar = (zzai) obj;
        zzah[] values = zzah.values();
        int length = values.length;
        int r3 = 0;
        while (true) {
            boolean z2 = true;
            if (r3 >= length) {
                return true;
            }
            zzah zzahVar = values[r3];
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                z = false;
            } else if (bool.booleanValue()) {
                z = true;
            } else {
                z = 2;
            }
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (bool2 == null) {
                z2 = false;
            } else if (!bool2.booleanValue()) {
                z2 = 2;
            }
            if (z != z2) {
                return false;
            }
            r3++;
        }
    }

    public final int hashCode() {
        int r2;
        int r1 = 17;
        for (Boolean bool : this.zzb.values()) {
            int r12 = r1 * 31;
            if (bool == null) {
                r2 = 0;
            } else if (bool.booleanValue()) {
                r2 = 1;
            } else {
                r2 = 2;
            }
            r1 = r12 + r2;
        }
        return r1;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("settings: ");
        zzah[] values = zzah.values();
        int length = values.length;
        for (int r3 = 0; r3 < length; r3++) {
            zzah zzahVar = values[r3];
            if (r3 != 0) {
                sb.append(", ");
            }
            sb.append(zzahVar.name());
            sb.append("=");
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                if (true != bool.booleanValue()) {
                    str = "denied";
                } else {
                    str = "granted";
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public final zzai zzc(zzai zzaiVar) {
        boolean z;
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                if (bool.booleanValue() && bool2.booleanValue()) {
                    z = true;
                } else {
                    z = false;
                }
                bool = Boolean.valueOf(z);
            }
            enumMap.put((EnumMap) zzahVar, (zzah) bool);
        }
        return new zzai(enumMap);
    }

    public final zzai zzd(zzai zzaiVar) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzahVar : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            if (bool == null) {
                bool = (Boolean) zzaiVar.zzb.get(zzahVar);
            }
            enumMap.put((EnumMap) zzahVar, (zzah) bool);
        }
        return new zzai(enumMap);
    }

    public final String zzh() {
        char c;
        StringBuilder sb = new StringBuilder("G1");
        zzah[] zzahVarArr = zzah.zzc;
        int length = zzahVarArr.length;
        for (int r2 = 0; r2 < 2; r2++) {
            Boolean bool = (Boolean) this.zzb.get(zzahVarArr[r2]);
            if (bool == null) {
                c = '-';
            } else if (bool.booleanValue()) {
                c = '1';
            } else {
                c = '0';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final boolean zzi(zzah zzahVar) {
        Boolean bool = (Boolean) this.zzb.get(zzahVar);
        if (bool != null && !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzl(zzai zzaiVar, zzah... zzahVarArr) {
        for (zzah zzahVar : zzahVarArr) {
            Boolean bool = (Boolean) this.zzb.get(zzahVar);
            Boolean bool2 = (Boolean) zzaiVar.zzb.get(zzahVar);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public zzai(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzah.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
