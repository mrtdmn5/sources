package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class SharedPrefKeysetReader {
    public final String keysetName;
    public final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String keysetName, String prefFilename) throws IOException {
        this.keysetName = keysetName;
        Context applicationContext = context.getApplicationContext();
        if (prefFilename == null) {
            this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);
        } else {
            this.sharedPreferences = applicationContext.getSharedPreferences(prefFilename, 0);
        }
    }

    public final byte[] readPref() throws IOException {
        String str = this.keysetName;
        try {
            String string = this.sharedPreferences.getString(str, null);
            if (string != null) {
                return Hex.decode(string);
            }
            throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", str));
        } catch (ClassCastException | IllegalArgumentException unused) {
            throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", str));
        }
    }
}
