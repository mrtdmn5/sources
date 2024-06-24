package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.fitness.data.DataType;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
/* loaded from: classes3.dex */
public final class FitnessOptions {
    public final HashSet zza;

    /* compiled from: com.google.android.gms:play-services-fitness@@21.1.0 */
    /* loaded from: classes3.dex */
    public static final class Builder {
        public final HashSet zza = new HashSet();

        public final void addDataType(DataType dataType) {
            String str = dataType.zzv;
            HashSet hashSet = this.zza;
            String str2 = dataType.zzw;
            if (str2 != null) {
                hashSet.add(new Scope(1, str2));
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessOptions)) {
            return false;
        }
        return this.zza.equals(((FitnessOptions) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }
}
