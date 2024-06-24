package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.zacr;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zat;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class SignInClientImpl extends GmsClient<zaf> implements com.google.android.gms.signin.zae {
    public final boolean zab;
    public final ClientSettings zac;
    public final Bundle zad;
    public final Integer zae;

    public SignInClientImpl(Context context, Looper looper, ClientSettings clientSettings, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(44, context, looper, connectionCallbacks, onConnectionFailedListener, clientSettings);
        this.zab = true;
        this.zac = clientSettings;
        this.zad = bundle;
        this.zae = clientSettings.zaj;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zaf) {
            return (zaf) queryLocalInterface;
        }
        return new zaf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        ClientSettings clientSettings = this.zac;
        boolean equals = this.zzl.getPackageName().equals(clientSettings.zag);
        Bundle bundle = this.zad;
        if (!equals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", clientSettings.zag);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return this.zab;
    }

    @Override // com.google.android.gms.signin.zae
    public final void zab() {
        connect(new BaseGmsClient.LegacyClientCallbackAdapter());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.signin.zae
    public final void zad(zae zaeVar) {
        GoogleSignInAccount googleSignInAccount;
        if (zaeVar != 0) {
            try {
                Account account = this.zac.zaa;
                if (account == null) {
                    account = new Account("<<default account>>", "com.google");
                }
                if ("<<default account>>".equals(account.name)) {
                    googleSignInAccount = Storage.getInstance(this.zzl).getSavedDefaultGoogleSignInAccount();
                } else {
                    googleSignInAccount = null;
                }
                Integer num = this.zae;
                Preconditions.checkNotNull(num);
                zat zatVar = new zat(2, account, num.intValue(), googleSignInAccount);
                zaf zafVar = (zaf) getService();
                zai zaiVar = new zai(1, zatVar);
                Parcel obtain = Parcel.obtain();
                obtain.writeInterfaceToken(zafVar.zab);
                int r5 = com.google.android.gms.internal.base.zac.$r8$clinit;
                obtain.writeInt(1);
                zaiVar.writeToParcel(obtain, 0);
                obtain.writeStrongBinder((com.google.android.gms.internal.base.zab) zaeVar);
                Parcel obtain2 = Parcel.obtain();
                try {
                    zafVar.zaa.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return;
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            } catch (RemoteException e) {
                Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
                try {
                    zact zactVar = (zact) zaeVar;
                    zactVar.zac.post(new zacr(zactVar, new zak(1, new ConnectionResult(8, null), null)));
                    return;
                } catch (RemoteException unused) {
                    Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
                    return;
                }
            }
        }
        throw new NullPointerException("Expecting a valid ISignInCallbacks");
    }
}
