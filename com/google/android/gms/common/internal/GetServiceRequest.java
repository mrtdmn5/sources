package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzm();
    public static final Scope[] zza = new Scope[0];
    public static final Feature[] zzb = new Feature[0];
    public final int zzc;
    public final int zzd;
    public final int zze;
    public String zzf;
    public IBinder zzg;
    public Scope[] zzh;
    public Bundle zzi;
    public Account zzj;
    public Feature[] zzk;
    public Feature[] zzl;
    public final boolean zzm;
    public final int zzn;
    public boolean zzo;
    public final String zzp;

    public GetServiceRequest(int r2, int r3, int r4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int r13, boolean z2, String str2) {
        IAccountAccessor zzvVar;
        scopeArr = scopeArr == null ? zza : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = zzb;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.zzc = r2;
        this.zzd = r3;
        this.zze = r4;
        if ("com.google.android.gms".equals(str)) {
            this.zzf = "com.google.android.gms";
        } else {
            this.zzf = str;
        }
        if (r2 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int r32 = IAccountAccessor.Stub.$r8$clinit;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                if (queryLocalInterface instanceof IAccountAccessor) {
                    zzvVar = (IAccountAccessor) queryLocalInterface;
                } else {
                    zzvVar = new zzv(iBinder);
                }
                int r42 = AccountAccessor.$r8$clinit;
                if (zzvVar != null) {
                    long clearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            account2 = zzvVar.zzb();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                    } finally {
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                }
            }
            this.zzj = account2;
        } else {
            this.zzg = iBinder;
            this.zzj = account;
        }
        this.zzh = scopeArr;
        this.zzi = bundle;
        this.zzk = featureArr;
        this.zzl = featureArr2;
        this.zzm = z;
        this.zzn = r13;
        this.zzo = z2;
        this.zzp = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int r2) {
        zzm.zza(this, parcel, r2);
    }
}
