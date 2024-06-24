package com.google.crypto.tink;

import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.OutputPrefixType;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class KeysetManager {
    public final Keyset.Builder keysetBuilder;

    public KeysetManager(Keyset.Builder val) {
        this.keysetBuilder = val;
    }

    public static int randPositiveInt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int r3 = 0;
        while (r3 == 0) {
            secureRandom.nextBytes(bArr);
            r3 = ((bArr[0] & Byte.MAX_VALUE) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        }
        return r3;
    }

    public final synchronized KeysetHandle getKeysetHandle() throws GeneralSecurityException {
        Keyset build;
        build = this.keysetBuilder.build();
        if (build.getKeyCount() > 0) {
        } else {
            throw new GeneralSecurityException("empty keyset");
        }
        return new KeysetHandle(build);
    }

    public final synchronized boolean keyIdExists(int keyId) {
        Iterator it = Collections.unmodifiableList(((Keyset) this.keysetBuilder.instance).getKeyList()).iterator();
        while (it.hasNext()) {
            if (((Keyset.Key) it.next()).getKeyId() == keyId) {
                return true;
            }
        }
        return false;
    }

    public final synchronized Keyset.Key newKey(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        KeyData newKeyData;
        int randPositiveInt;
        newKeyData = Registry.newKeyData(keyTemplate);
        synchronized (this) {
            randPositiveInt = randPositiveInt();
            while (keyIdExists(randPositiveInt)) {
                randPositiveInt = randPositiveInt();
            }
        }
        return r2.build();
        OutputPrefixType outputPrefixType = keyTemplate.getOutputPrefixType();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            outputPrefixType = OutputPrefixType.TINK;
        }
        Keyset.Key.Builder newBuilder = Keyset.Key.newBuilder();
        newBuilder.copyOnWrite();
        Keyset.Key.access$100((Keyset.Key) newBuilder.instance, newKeyData);
        newBuilder.copyOnWrite();
        ((Keyset.Key) newBuilder.instance).keyId_ = randPositiveInt;
        KeyStatusType keyStatusType = KeyStatusType.ENABLED;
        newBuilder.copyOnWrite();
        Keyset.Key.access$500((Keyset.Key) newBuilder.instance, keyStatusType);
        newBuilder.copyOnWrite();
        Keyset.Key.access$1000((Keyset.Key) newBuilder.instance, outputPrefixType);
        return newBuilder.build();
    }
}
