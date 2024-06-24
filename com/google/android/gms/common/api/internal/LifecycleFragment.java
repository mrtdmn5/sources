package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public interface LifecycleFragment {
    Activity getLifecycleActivity();

    void startActivityForResult(Intent intent, int r2);
}
