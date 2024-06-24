package com.google.android.gms.common;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zaa implements SuccessContinuation {
    public static final /* synthetic */ zaa zaa = new zaa();

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task then(Object obj) {
        Object obj2 = GoogleApiAvailability.zaa;
        return Tasks.forResult(null);
    }
}
