package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zacr implements Runnable {
    public final /* synthetic */ zak zaa;
    public final /* synthetic */ zact zab;

    public zacr(zact zactVar, zak zakVar) {
        this.zab = zactVar;
        this.zaa = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAccountAccessor zzvVar;
        IAccountAccessor iAccountAccessor;
        Set<Scope> set;
        zak zakVar = this.zaa;
        ConnectionResult connectionResult = zakVar.zab;
        boolean isSuccess = connectionResult.isSuccess();
        zact zactVar = this.zab;
        if (isSuccess) {
            zav zavVar = zakVar.zac;
            Preconditions.checkNotNull(zavVar);
            ConnectionResult connectionResult2 = zavVar.zac;
            if (!connectionResult2.isSuccess()) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult2)), new Exception());
                ((zabu) zactVar.zah).zae(connectionResult2);
                zactVar.zag.disconnect();
                return;
            }
            zacs zacsVar = zactVar.zah;
            IBinder iBinder = zavVar.zab;
            if (iBinder == null) {
                iAccountAccessor = null;
            } else {
                int r2 = IAccountAccessor.Stub.$r8$clinit;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                if (queryLocalInterface instanceof IAccountAccessor) {
                    zzvVar = (IAccountAccessor) queryLocalInterface;
                } else {
                    zzvVar = new zzv(iBinder);
                }
                iAccountAccessor = zzvVar;
            }
            zabu zabuVar = (zabu) zacsVar;
            zabuVar.getClass();
            if (iAccountAccessor != null && (set = zactVar.zae) != null) {
                zabuVar.zad = iAccountAccessor;
                zabuVar.zae = set;
                if (zabuVar.zaf) {
                    zabuVar.zab.getRemoteService(iAccountAccessor, set);
                }
            } else {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zabuVar.zae(new ConnectionResult(4));
            }
        } else {
            ((zabu) zactVar.zah).zae(connectionResult);
        }
        zactVar.zag.disconnect();
    }
}
