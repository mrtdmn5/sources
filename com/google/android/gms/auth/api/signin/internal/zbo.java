package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public abstract class zbo extends com.google.android.gms.internal.p000authapi.zbb {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p000authapi.zbb
    public final boolean zba(int r3, Parcel parcel, Parcel parcel2) throws RemoteException {
        if (r3 != 1) {
            if (r3 != 2) {
                return false;
            }
            zbt zbtVar = (zbt) this;
            zbtVar.zbd$1();
            zbn.zbc(zbtVar.zba).zbd();
        } else {
            zbt zbtVar2 = (zbt) this;
            zbtVar2.zbd$1();
            Context context = zbtVar2.zba;
            Storage storage = Storage.getInstance(context);
            GoogleSignInAccount savedDefaultGoogleSignInAccount = storage.getSavedDefaultGoogleSignInAccount();
            GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
            if (savedDefaultGoogleSignInAccount != null) {
                googleSignInOptions = storage.getSavedDefaultGoogleSignInOptions();
            }
            Preconditions.checkNotNull(googleSignInOptions);
            GoogleSignInClient googleSignInClient = new GoogleSignInClient(context, googleSignInOptions);
            if (savedDefaultGoogleSignInAccount != null) {
                googleSignInClient.revokeAccess();
            } else {
                googleSignInClient.signOut();
            }
        }
        return true;
    }
}
