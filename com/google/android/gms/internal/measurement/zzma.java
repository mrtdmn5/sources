package com.google.android.gms.internal.measurement;

import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzma extends zzmk {
    @Override // com.google.android.gms.internal.measurement.zzmk
    public final void zza() {
        Iterable<Map.Entry> entrySet;
        if (!this.zzd) {
            for (int r0 = 0; r0 < zzb(); r0++) {
                Map.Entry entry = (Map.Entry) this.zzb.get(r0);
                if (((zzjv) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
            if (this.zzc.isEmpty()) {
                entrySet = KtorSimpleLoggerJvmKt.zzb;
            } else {
                entrySet = this.zzc.entrySet();
            }
            for (Map.Entry entry2 : entrySet) {
                if (((zzjv) entry2.getKey()).zzc()) {
                    entry2.setValue(Collections.unmodifiableList((List) entry2.getValue()));
                }
            }
        }
        super.zza();
    }
}
