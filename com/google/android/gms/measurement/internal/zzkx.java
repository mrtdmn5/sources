package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.coroutines.selects.OnTimeoutKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public final class zzkx implements Parcelable.Creator {
    public static void zza(zzkw zzkwVar, Parcel parcel) {
        int zza = OnTimeoutKt.zza(parcel, 20293);
        OnTimeoutKt.writeInt(parcel, 1, zzkwVar.zza);
        OnTimeoutKt.writeString(parcel, 2, zzkwVar.zzb);
        OnTimeoutKt.writeLong(parcel, 3, zzkwVar.zzc);
        Long l = zzkwVar.zzd;
        if (l != null) {
            parcel.writeInt(524292);
            parcel.writeLong(l.longValue());
        }
        OnTimeoutKt.writeString(parcel, 6, zzkwVar.zze);
        OnTimeoutKt.writeString(parcel, 7, zzkwVar.zzf);
        Double d = zzkwVar.zzg;
        if (d != null) {
            parcel.writeInt(524296);
            parcel.writeDouble(d.doubleValue());
        }
        OnTimeoutKt.zzb(parcel, zza);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0025. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:5:0x001e  */
    @Override // android.os.Parcelable.Creator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createFromParcel(android.os.Parcel r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r17)
            r2 = 0
            r3 = 0
            r4 = 0
            r6 = r3
            r9 = r6
            r10 = r9
            r11 = r10
            r7 = r4
            r4 = r11
            r5 = r4
        L11:
            r12 = r10
            r13 = r11
            r10 = r6
            r11 = r9
            r9 = r5
            r5 = r2
            r2 = r4
        L18:
            int r4 = r17.dataPosition()
            if (r4 >= r1) goto L7a
            int r4 = r17.readInt()
            char r6 = (char) r4
            r14 = 8
            switch(r6) {
                case 1: goto L75;
                case 2: goto L70;
                case 3: goto L64;
                case 4: goto L4f;
                case 5: goto L4a;
                case 6: goto L45;
                case 7: goto L40;
                case 8: goto L2c;
                default: goto L28;
            }
        L28:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r4)
            goto L18
        L2c:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r0, r4)
            if (r4 != 0) goto L34
            r13 = r3
            goto L18
        L34:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.zza(r0, r4, r14)
            double r13 = r17.readDouble()
            java.lang.Double r13 = java.lang.Double.valueOf(r13)
            goto L18
        L40:
            java.lang.String r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r4)
            goto L18
        L45:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r4)
            goto L18
        L4a:
            java.lang.Float r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloatObject(r0, r4)
            goto L18
        L4f:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readSize(r0, r4)
            if (r4 != 0) goto L57
            r9 = r3
            goto L18
        L57:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.zza(r0, r4, r14)
            long r14 = r17.readLong()
            java.lang.Long r4 = java.lang.Long.valueOf(r14)
            r9 = r4
            goto L18
        L64:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r4)
            r4 = r2
            r2 = r5
            r5 = r9
            r6 = r10
            r9 = r11
            r10 = r12
            r11 = r13
            goto L11
        L70:
            java.lang.String r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r4)
            goto L18
        L75:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r4)
            goto L18
        L7a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.measurement.internal.zzkw r0 = new com.google.android.gms.measurement.internal.zzkw
            r4 = r0
            r6 = r2
            r4.<init>(r5, r6, r7, r9, r10, r11, r12, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkx.createFromParcel(android.os.Parcel):java.lang.Object");
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int r1) {
        return new zzkw[r1];
    }
}
