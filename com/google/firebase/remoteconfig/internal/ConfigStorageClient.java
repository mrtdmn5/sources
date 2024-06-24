package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class ConfigStorageClient {
    public static final HashMap clientInstances = new HashMap();
    public final Context context;
    public final String fileName;

    public ConfigStorageClient(Context context, String str) {
        this.context = context;
        this.fileName = str;
    }
}
