package com.google.android.gms.common.api.internal;

import android.app.AlertDialog;
import android.util.Log;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
/* loaded from: classes3.dex */
public final class zan {
    public final Object zaa;
    public final Object zab;

    public zan(zao zaoVar, AlertDialog alertDialog) {
        this.zab = zaoVar;
        this.zaa = alertDialog;
    }

    public final void create() {
        Object obj = this.zaa;
        try {
            FileStore fileStore = (FileStore) this.zab;
            fileStore.getClass();
            new File(fileStore.crashlyticsDir, (String) obj).createNewFile();
        } catch (IOException e) {
            Log.e("FirebaseCrashlytics", "Error creating marker: " + ((String) obj), e);
        }
    }

    public zan(FileStore fileStore, String str) {
        this.zaa = str;
        this.zab = fileStore;
    }
}
