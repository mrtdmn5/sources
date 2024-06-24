package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zae extends zai {
    public final BaseImplementation$ApiMethodImpl zaa;

    public zae(int r1, BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl) {
        super(r1);
        this.zaa = baseImplementation$ApiMethodImpl;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        try {
            this.zaa.setFailedResult(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(RuntimeException runtimeException) {
        try {
            this.zaa.setFailedResult(new Status(10, AbstractResolvableFuture$$ExternalSyntheticOutline0.m(runtimeException.getClass().getSimpleName(), ": ", runtimeException.getLocalizedMessage())));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        try {
            BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl = this.zaa;
            Api.Client client = zabqVar.zac;
            baseImplementation$ApiMethodImpl.getClass();
            try {
                try {
                    baseImplementation$ApiMethodImpl.doExecute(client);
                } catch (DeadObjectException e) {
                    baseImplementation$ApiMethodImpl.setFailedResult(new Status(1, 8, e.getLocalizedMessage(), null, null));
                    throw e;
                }
            } catch (RemoteException e2) {
                baseImplementation$ApiMethodImpl.setFailedResult(new Status(1, 8, e2.getLocalizedMessage(), null, null));
            }
        } catch (RuntimeException e3) {
            zae(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zaad zaadVar, boolean z) {
        Map map = zaadVar.zaa;
        Boolean valueOf = Boolean.valueOf(z);
        BaseImplementation$ApiMethodImpl baseImplementation$ApiMethodImpl = this.zaa;
        map.put(baseImplementation$ApiMethodImpl, valueOf);
        baseImplementation$ApiMethodImpl.addStatusListener(new zaab(zaadVar, baseImplementation$ApiMethodImpl));
    }
}
