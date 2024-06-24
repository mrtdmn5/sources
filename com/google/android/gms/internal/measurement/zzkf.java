package com.google.android.gms.internal.measurement;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzkf<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzio<MessageType, BuilderType> {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmp zzc = zzmp.zza;

    public static zzlb zzbD(zzkl zzklVar) {
        int r0;
        int size = zzklVar.size();
        if (size == 0) {
            r0 = 10;
        } else {
            r0 = size + size;
        }
        zzlb zzlbVar = (zzlb) zzklVar;
        if (r0 >= zzlbVar.zzc) {
            return new zzlb(Arrays.copyOf(zzlbVar.zzb, r0), zzlbVar.zzc);
        }
        throw new IllegalArgumentException();
    }

    public static zzkm zzbF(zzkm zzkmVar) {
        int r0;
        int size = zzkmVar.size();
        if (size == 0) {
            r0 = 10;
        } else {
            r0 = size + size;
        }
        return zzkmVar.zzd(r0);
    }

    public static Object zzbH(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static void zzbL(Class cls, zzkf zzkfVar) {
        zza.put(cls, zzkfVar);
        zzkfVar.zzbJ();
    }

    public static zzkf zzbz(Class cls) {
        Map map = zza;
        zzkf zzkfVar = (zzkf) map.get(cls);
        if (zzkfVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkfVar = (zzkf) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzkfVar == null) {
            zzkfVar = (zzkf) ((zzkf) zzmy.zze(cls)).zzl(6);
            if (zzkfVar != null) {
                map.put(cls, zzkfVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzkfVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzlu.zza.zzb(getClass()).zzj(this, (zzkf) obj);
    }

    public final int hashCode() {
        if (!zzbO()) {
            int r0 = this.zzb;
            if (r0 == 0) {
                int zzb = zzlu.zza.zzb(getClass()).zzb(this);
                this.zzb = zzb;
                return zzb;
            }
            return r0;
        }
        return zzlu.zza.zzb(getClass()).zzb(this);
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = zzlo.zza;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        zzlo.zzd(this, sb, 0);
        return sb.toString();
    }

    public final int zza(zzlx zzlxVar) {
        if (zzlxVar == null) {
            return zzlu.zza.zzb(getClass()).zza(this);
        }
        return zzlxVar.zza(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final /* synthetic */ zzkb zzbG() {
        return (zzkb) zzl(5);
    }

    public final void zzbJ() {
        zzlu.zza.zzb(getClass()).zzf(this);
        zzbK();
    }

    public final void zzbK() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void zzbM() {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final boolean zzbO() {
        if ((this.zzd & Integer.MIN_VALUE) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final /* synthetic */ zzkf zzbS() {
        return (zzkf) zzl(6);
    }

    @Override // com.google.android.gms.internal.measurement.zzio
    public final int zzbr(zzlx zzlxVar) {
        if (zzbO()) {
            int zza2 = zza(zzlxVar);
            if (zza2 >= 0) {
                return zza2;
            }
            throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("serialized size must be non-negative, was ", zza2));
        }
        int r0 = this.zzd & Integer.MAX_VALUE;
        if (r0 != Integer.MAX_VALUE) {
            return r0;
        }
        int zza3 = zza(zzlxVar);
        if (zza3 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | zza3;
            return zza3;
        }
        throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("serialized size must be non-negative, was ", zza3));
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final int zzbw() {
        int r0;
        if (zzbO()) {
            r0 = zza(null);
            if (r0 < 0) {
                throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("serialized size must be non-negative, was ", r0));
            }
        } else {
            r0 = this.zzd & Integer.MAX_VALUE;
            if (r0 == Integer.MAX_VALUE) {
                r0 = zza(null);
                if (r0 >= 0) {
                    this.zzd = (this.zzd & Integer.MIN_VALUE) | r0;
                } else {
                    throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("serialized size must be non-negative, was ", r0));
                }
            }
        }
        return r0;
    }

    public final zzkb zzbx() {
        return (zzkb) zzl(5);
    }

    public final zzkb zzby() {
        zzkb zzkbVar = (zzkb) zzl(5);
        if (!zzkbVar.zzb.equals(this)) {
            if (!zzkbVar.zza.zzbO()) {
                zzkf zzkfVar = (zzkf) zzkbVar.zzb.zzl(4);
                zzlu.zza.zzb(zzkfVar.getClass()).zzg(zzkfVar, zzkbVar.zza);
                zzkbVar.zza = zzkfVar;
            }
            zzkf zzkfVar2 = zzkbVar.zza;
            zzlu.zza.zzb(zzkfVar2.getClass()).zzg(zzkfVar2, this);
        }
        return zzkbVar;
    }

    public abstract Object zzl(int r1);
}
