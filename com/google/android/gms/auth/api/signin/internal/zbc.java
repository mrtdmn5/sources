package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import java.util.Set;
import java.util.concurrent.Semaphore;

/* compiled from: com.google.android.gms:play-services-auth@@20.4.0 */
/* loaded from: classes3.dex */
public final class zbc extends AsyncTaskLoader {
    public final Semaphore zba;
    public final Set zbb;

    public zbc(Context context, Set set) {
        super(context);
        this.zba = new Semaphore(0);
        this.zbb = set;
    }
}
