package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlm {
    protected int zzb = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static void zzbt(Iterable iterable, zzkm zzkmVar) {
        Charset charset = zzkn.zzb;
        iterable.getClass();
        if (iterable instanceof zzku) {
            List zzh = ((zzku) iterable).zzh();
            zzku zzkuVar = (zzku) zzkmVar;
            int size = zzkmVar.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzkuVar.size() - size) + " is null.";
                    int size2 = zzkuVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        } else {
                            zzkuVar.remove(size2);
                        }
                    }
                    throw new NullPointerException(str);
                }
                if (obj instanceof zzje) {
                    zzkuVar.zzi((zzje) obj);
                } else {
                    zzkuVar.add((String) obj);
                }
            }
            return;
        }
        if (!(iterable instanceof zzlt)) {
            if ((zzkmVar instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) zzkmVar).ensureCapacity(((Collection) iterable).size() + zzkmVar.size());
            }
            int size3 = zzkmVar.size();
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    String str2 = "Element at index " + (zzkmVar.size() - size3) + " is null.";
                    int size4 = zzkmVar.size();
                    while (true) {
                        size4--;
                        if (size4 < size3) {
                            break;
                        } else {
                            zzkmVar.remove(size4);
                        }
                    }
                    throw new NullPointerException(str2);
                }
                zzkmVar.add(obj2);
            }
            return;
        }
        zzkmVar.addAll((Collection) iterable);
    }

    public int zzbr(zzlx zzlxVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzlm
    public final zzjb zzbs() {
        try {
            zzkf zzkfVar = (zzkf) this;
            int zzbw = zzkfVar.zzbw();
            zzjb zzjbVar = zzje.zzb;
            byte[] bArr = new byte[zzbw];
            Logger logger = zzjm.zzb;
            zzjj zzjjVar = new zzjj(bArr, zzbw);
            zzlx zzb = zzlu.zza.zzb(zzkfVar.getClass());
            zzjn zzjnVar = zzjjVar.zza;
            if (zzjnVar == null) {
                zzjnVar = new zzjn(zzjjVar);
            }
            zzb.zzi(zzkfVar, zzjnVar);
            if (zzbw - zzjjVar.zzd == 0) {
                return new zzjb(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(zzav$$ExternalSyntheticOutline0.m("Serializing ", getClass().getName(), " to a ByteString threw an IOException (should never happen)."), e);
        }
    }

    public final byte[] zzbu() {
        try {
            zzkf zzkfVar = (zzkf) this;
            int zzbw = zzkfVar.zzbw();
            byte[] bArr = new byte[zzbw];
            Logger logger = zzjm.zzb;
            zzjj zzjjVar = new zzjj(bArr, zzbw);
            zzlx zzb = zzlu.zza.zzb(zzkfVar.getClass());
            zzjn zzjnVar = zzjjVar.zza;
            if (zzjnVar == null) {
                zzjnVar = new zzjn(zzjjVar);
            }
            zzb.zzi(zzkfVar, zzjnVar);
            if (zzbw - zzjjVar.zzd == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(zzav$$ExternalSyntheticOutline0.m("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
        }
    }
}
