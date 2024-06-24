package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzlg extends LinkedHashMap {
    public static final zzlg zza;
    public boolean zzb;

    static {
        zzlg zzlgVar = new zzlg();
        zza = zzlgVar;
        zzlgVar.zzb = false;
    }

    public zzlg() {
        this.zzb = true;
    }

    public static zzlg zza() {
        return zza;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzg();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        return super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if ((value instanceof byte[]) && (obj2 instanceof byte[])) {
                                equals = Arrays.equals((byte[]) value, (byte[]) obj2);
                            } else {
                                equals = value.equals(obj2);
                            }
                            if (!equals) {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int hashCode;
        int r2 = 0;
        for (Map.Entry entry : entrySet()) {
            Object key = entry.getKey();
            int r6 = 1;
            if (key instanceof byte[]) {
                byte[] bArr = (byte[]) key;
                Charset charset = zzkn.zzb;
                hashCode = bArr.length;
                for (byte b : bArr) {
                    hashCode = (hashCode * 31) + b;
                }
                if (hashCode == 0) {
                    hashCode = 1;
                }
            } else {
                hashCode = key.hashCode();
            }
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr2 = (byte[]) value;
                Charset charset2 = zzkn.zzb;
                int length = bArr2.length;
                for (byte b2 : bArr2) {
                    length = (length * 31) + b2;
                }
                if (length != 0) {
                    r6 = length;
                }
            } else {
                r6 = value.hashCode();
            }
            r2 += r6 ^ hashCode;
        }
        return r2;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        zzg();
        Charset charset = zzkn.zzb;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zzg();
        for (Object obj : map.keySet()) {
            Charset charset = zzkn.zzb;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    public final zzlg zzb() {
        if (isEmpty()) {
            return new zzlg();
        }
        return new zzlg(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final boolean zze() {
        return this.zzb;
    }

    public final void zzg() {
        if (this.zzb) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public zzlg(Map map) {
        super(map);
        this.zzb = true;
    }
}
