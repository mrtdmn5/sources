package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
/* loaded from: classes3.dex */
public final class zzd extends zza implements zzf {
    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final String zzc() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        obtain = Parcel.obtain();
        try {
            this.zza.transact(1, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            return obtain.readString();
        } catch (RuntimeException e) {
            throw e;
        } finally {
            obtain.recycle();
        }
    }

    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zze() throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        int r1 = zzc.$r8$clinit;
        boolean z = true;
        obtain.writeInt(1);
        obtain = Parcel.obtain();
        try {
            this.zza.transact(2, obtain, obtain, 0);
            obtain.readException();
            obtain.recycle();
            if (obtain.readInt() == 0) {
                z = false;
            }
            return z;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            obtain.recycle();
        }
    }
}
