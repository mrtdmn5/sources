package com.google.android.gms.common.internal;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class Objects {

    /* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    /* loaded from: classes3.dex */
    public static final class ToStringHelper {
        public final ArrayList zza;
        public final Object zzb;

        public /* synthetic */ ToStringHelper(Object obj) {
            Preconditions.checkNotNull(obj);
            this.zzb = obj;
            this.zza = new ArrayList();
        }

        public final void add(Object obj, String str) {
            this.zza.add(str + "=" + String.valueOf(obj));
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzb.getClass().getSimpleName());
            sb.append('{');
            ArrayList arrayList = this.zza;
            int size = arrayList.size();
            for (int r3 = 0; r3 < size; r3++) {
                sb.append((String) arrayList.get(r3));
                if (r3 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj != null && obj.equals(obj2)) {
            return true;
        }
        return false;
    }
}
