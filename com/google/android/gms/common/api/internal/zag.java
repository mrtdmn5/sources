package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zag extends zac {
    public final TaskApiCall zaa;
    public final TaskCompletionSource zab;
    public final ApiExceptionMapper zad;

    public zag(int r1, zacv zacvVar, TaskCompletionSource taskCompletionSource, ApiExceptionMapper apiExceptionMapper) {
        super(r1);
        this.zab = taskCompletionSource;
        this.zaa = zacvVar;
        this.zad = apiExceptionMapper;
        if (r1 == 2 && zacvVar.zab) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean zaa(zabq zabqVar) {
        return this.zaa.zab;
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] zab(zabq zabqVar) {
        return this.zaa.zaa;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zad(Status status) {
        this.zad.getClass();
        this.zab.trySetException(ApiExceptionUtil.fromStatus(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zae(RuntimeException runtimeException) {
        this.zab.trySetException(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zaf(zabq zabqVar) throws DeadObjectException {
        TaskCompletionSource taskCompletionSource = this.zab;
        try {
            TaskApiCall taskApiCall = this.zaa;
            ((zacv) taskApiCall).zaa.zaa.accept(zabqVar.zac, taskCompletionSource);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            zad(zai.zah(e2));
        } catch (RuntimeException e3) {
            taskCompletionSource.trySetException(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void zag(zaad zaadVar, boolean z) {
        Map map = zaadVar.zab;
        Boolean valueOf = Boolean.valueOf(z);
        TaskCompletionSource taskCompletionSource = this.zab;
        map.put(taskCompletionSource, valueOf);
        taskCompletionSource.zza.addOnCompleteListener(new zaac(zaadVar, taskCompletionSource));
    }
}
