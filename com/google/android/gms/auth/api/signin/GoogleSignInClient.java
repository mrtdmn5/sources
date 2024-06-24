package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.auth.api.signin.internal.zbb;
import com.google.android.gms.auth.api.signin.internal.zbi;
import com.google.android.gms.auth.api.signin.internal.zbk;
import com.google.android.gms.auth.api.signin.internal.zbm;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.zag;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.zzw;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    public static int zba = 1;

    public GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, googleSignInOptions, new GoogleApi.Settings(new ApiExceptionMapper(), Looper.getMainLooper()));
    }

    public final zzw revokeAccess() {
        boolean z;
        BasePendingResult basePendingResult;
        if (zba() == 3) {
            z = true;
        } else {
            z = false;
        }
        zbm.zba.d("Revoking access", new Object[0]);
        Context context = this.zab;
        String zaa = Storage.getInstance(context).zaa("refreshToken");
        zbm.zbh(context);
        if (z) {
            if (zaa == null) {
                Logger logger = zbb.zba;
                Status status = new Status(4, null);
                Preconditions.checkArgument("Status code must not be SUCCESS", !status.isSuccess());
                BasePendingResult zagVar = new zag(status);
                zagVar.setResult((BasePendingResult) status);
                basePendingResult = zagVar;
            } else {
                zbb zbbVar = new zbb(zaa);
                new Thread(zbbVar).start();
                basePendingResult = zbbVar.zbc;
            }
        } else {
            zabv zabvVar = this.zai;
            zbk zbkVar = new zbk(zabvVar);
            zabvVar.zaa.zad(1, zbkVar);
            basePendingResult = zbkVar;
        }
        return PendingResultUtil.toVoidTask(basePendingResult);
    }

    public final zzw signOut() {
        boolean z;
        BasePendingResult basePendingResult;
        if (zba() == 3) {
            z = true;
        } else {
            z = false;
        }
        zbm.zba.d("Signing out", new Object[0]);
        zbm.zbh(this.zab);
        zabv zabvVar = this.zai;
        if (z) {
            Status status = Status.RESULT_SUCCESS;
            Preconditions.checkNotNull(status, "Result must not be null");
            basePendingResult = new StatusPendingResult(zabvVar);
            basePendingResult.setResult((BasePendingResult) status);
        } else {
            zbi zbiVar = new zbi(zabvVar);
            zabvVar.zaa.zad(1, zbiVar);
            basePendingResult = zbiVar;
        }
        return PendingResultUtil.toVoidTask(basePendingResult);
    }

    public final synchronized int zba() {
        int r0;
        r0 = zba;
        if (r0 == 1) {
            Context context = this.zab;
            GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.zab;
            int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context, 12451000);
            if (isGooglePlayServicesAvailable == 0) {
                r0 = 4;
                zba = 4;
            } else if (googleApiAvailability.getErrorResolutionIntent(isGooglePlayServicesAvailable, context, null) == null && DynamiteModule.getLocalVersion(context, "com.google.android.gms.auth.api.fallback") != 0) {
                r0 = 3;
                zba = 3;
            } else {
                r0 = 2;
                zba = 2;
            }
        }
        return r0;
    }
}
