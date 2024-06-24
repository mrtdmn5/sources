package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.kronaby.watch.app.R;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class StringResourceValueReader {
    public final Resources zza;
    public final String zzb;

    public StringResourceValueReader(Context context) {
        Preconditions.checkNotNull(context);
        Resources resources = context.getResources();
        this.zza = resources;
        this.zzb = resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    }

    public final String getString(String str) {
        Resources resources = this.zza;
        int identifier = resources.getIdentifier(str, "string", this.zzb);
        if (identifier == 0) {
            return null;
        }
        return resources.getString(identifier);
    }
}
