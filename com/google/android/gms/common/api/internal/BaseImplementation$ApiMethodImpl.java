package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class BaseImplementation$ApiMethodImpl<R extends Result, A> extends BasePendingResult<R> implements BaseImplementation$ResultHolder<R> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseImplementation$ApiMethodImpl(Api api, zabv zabvVar) {
        super(zabvVar);
        if (zabvVar != null) {
            if (api != null) {
                return;
            } else {
                throw new NullPointerException("Api must not be null");
            }
        }
        throw new NullPointerException("GoogleApiClient must not be null");
    }

    public abstract void doExecute(Api.Client client) throws RemoteException;

    public final void setFailedResult(Status status) {
        Preconditions.checkArgument("Failed result must not be success", !status.isSuccess());
        setResult((BaseImplementation$ApiMethodImpl<R, A>) createFailedResult(status));
    }
}
