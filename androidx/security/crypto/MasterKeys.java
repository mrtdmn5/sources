package androidx.security.crypto;

import android.security.keystore.KeyGenParameterSpec;

/* loaded from: classes.dex */
public final class MasterKeys {
    public static final KeyGenParameterSpec AES256_GCM_SPEC = new KeyGenParameterSpec.Builder("_androidx_security_master_key_", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build();
}
