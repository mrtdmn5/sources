package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public abstract class zai {
    public final int zac;

    public zai(int r1) {
        this.zac = r1;
    }

    public static /* bridge */ /* synthetic */ Status zah(RemoteException remoteException) {
        return new Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    public abstract void zad(Status status);

    public abstract void zae(RuntimeException runtimeException);

    public abstract void zaf(zabq zabqVar) throws DeadObjectException;

    public abstract void zag(zaad zaadVar, boolean z);
}
