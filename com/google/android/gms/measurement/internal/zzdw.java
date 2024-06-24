package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.2.0 */
/* loaded from: classes3.dex */
public abstract class zzdw extends com.google.android.gms.internal.measurement.zzbn implements zzdx {
    public zzdw() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbn
    public final boolean zza(int r9, Parcel parcel, Parcel parcel2) throws RemoteException {
        ArrayList arrayList;
        boolean z = false;
        switch (r9) {
            case 1:
                zzaw zzawVar = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                zzq zzqVar = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzk(zzawVar, zzqVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzkw zzkwVar = (zzkw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzkw.CREATOR);
                zzq zzqVar2 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzt(zzkwVar, zzqVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            default:
                return false;
            case 4:
                zzq zzqVar3 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzj(zzqVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzaw zzawVar2 = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                String readString = parcel.readString();
                parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzgj zzgjVar = (zzgj) this;
                Preconditions.checkNotNull(zzawVar2);
                Preconditions.checkNotEmpty(readString);
                zzgjVar.zzz(readString, true);
                zzgjVar.zzx(new zzgd(zzgjVar, zzawVar2, readString));
                parcel2.writeNoException();
                return true;
            case 6:
                zzq zzqVar4 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzs(zzqVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzq zzqVar5 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                if (parcel.readInt() != 0) {
                    z = true;
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzgj zzgjVar2 = (zzgj) this;
                zzgjVar2.zzy(zzqVar5);
                String str = zzqVar5.zza;
                Preconditions.checkNotNull(str);
                zzkt zzktVar = zzgjVar2.zza;
                try {
                    List<zzky> list = (List) zzktVar.zzaz().zzh(new zzgg(zzgjVar2, str)).get();
                    arrayList = new ArrayList(list.size());
                    for (zzky zzkyVar : list) {
                        if (z || !zzlb.zzah(zzkyVar.zzc)) {
                            arrayList.add(new zzkw(zzkyVar));
                        }
                    }
                } catch (InterruptedException | ExecutionException e) {
                    zzktVar.zzay().zzd.zzc(zzeh.zzn(str), e, "Failed to get user properties. appId");
                    arrayList = null;
                }
                parcel2.writeNoException();
                parcel2.writeTypedList(arrayList);
                return true;
            case 9:
                zzaw zzawVar3 = (zzaw) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzaw.CREATOR);
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                byte[] zzu = ((zzgj) this).zzu(zzawVar3, readString2);
                parcel2.writeNoException();
                parcel2.writeByteArray(zzu);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzq(readLong, readString3, readString4, readString5);
                parcel2.writeNoException();
                return true;
            case 11:
                zzq zzqVar6 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                String zzd = ((zzgj) this).zzd(zzqVar6);
                parcel2.writeNoException();
                parcel2.writeString(zzd);
                return true;
            case 12:
                zzac zzacVar = (zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR);
                zzq zzqVar7 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzn(zzacVar, zzqVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzac zzacVar2 = (zzac) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzac.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                zzgj zzgjVar3 = (zzgj) this;
                Preconditions.checkNotNull(zzacVar2);
                Preconditions.checkNotNull(zzacVar2.zzc);
                Preconditions.checkNotEmpty(zzacVar2.zza);
                zzgjVar3.zzz(zzacVar2.zza, true);
                zzgjVar3.zzx(new zzfu(zzgjVar3, new zzac(zzacVar2)));
                parcel2.writeNoException();
                return true;
            case 14:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                ClassLoader classLoader = com.google.android.gms.internal.measurement.zzbo.zza;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                zzq zzqVar8 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzh = ((zzgj) this).zzh(readString6, readString7, z, zzqVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzh);
                return true;
            case 15:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                ClassLoader classLoader2 = com.google.android.gms.internal.measurement.zzbo.zza;
                if (parcel.readInt() != 0) {
                    z = true;
                }
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzi = ((zzgj) this).zzi(readString8, readString9, readString10, z);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzi);
                return true;
            case 16:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                zzq zzqVar9 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzf = ((zzgj) this).zzf(readString11, readString12, zzqVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzf);
                return true;
            case 17:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                List zzg = ((zzgj) this).zzg(readString13, readString14, readString15);
                parcel2.writeNoException();
                parcel2.writeTypedList(zzg);
                return true;
            case 18:
                zzq zzqVar10 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzm(zzqVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbo.zza(parcel, Bundle.CREATOR);
                zzq zzqVar11 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzr(bundle, zzqVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzq zzqVar12 = (zzq) com.google.android.gms.internal.measurement.zzbo.zza(parcel, zzq.CREATOR);
                com.google.android.gms.internal.measurement.zzbo.zzc(parcel);
                ((zzgj) this).zzp(zzqVar12);
                parcel2.writeNoException();
                return true;
        }
    }
}
