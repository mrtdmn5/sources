package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* loaded from: classes3.dex */
public final class SharedPrefKeysetWriter {
    public final SharedPreferences.Editor editor;
    public final String keysetName;

    public SharedPrefKeysetWriter(Context context, String keysetName, String prefFileName) {
        this.keysetName = keysetName;
        Context applicationContext = context.getApplicationContext();
        if (prefFileName == null) {
            this.editor = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        } else {
            this.editor = applicationContext.getSharedPreferences(prefFileName, 0).edit();
        }
    }
}
