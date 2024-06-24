package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.services.s3.model.CryptoMode;
import java.security.SecureRandom;

@Deprecated
/* loaded from: classes.dex */
final class S3CryptoScheme {
    static final String AES = "AES";
    static final String RSA = "RSA";
    private static final SecureRandom SRAND = new SecureRandom();
    private final ContentCryptoScheme contentCryptoScheme;
    private final S3KeyWrapScheme kwScheme;

    /* renamed from: com.amazonaws.services.s3.internal.crypto.S3CryptoScheme$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$services$s3$model$CryptoMode;

        static {
            int[] r0 = new int[CryptoMode.values().length];
            $SwitchMap$com$amazonaws$services$s3$model$CryptoMode = r0;
            try {
                r0[CryptoMode.EncryptionOnly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$CryptoMode[CryptoMode.AuthenticatedEncryption.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$amazonaws$services$s3$model$CryptoMode[CryptoMode.StrictAuthenticatedEncryption.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public S3CryptoScheme(ContentCryptoScheme contentCryptoScheme) {
        this.contentCryptoScheme = contentCryptoScheme;
        this.kwScheme = new S3KeyWrapScheme();
    }

    public static S3CryptoScheme from(CryptoMode cryptoMode) {
        int r2 = AnonymousClass1.$SwitchMap$com$amazonaws$services$s3$model$CryptoMode[cryptoMode.ordinal()];
        if (r2 != 1) {
            if (r2 != 2 && r2 != 3) {
                throw new IllegalStateException();
            }
            return new S3CryptoScheme(ContentCryptoScheme.AES_GCM, new S3KeyWrapScheme());
        }
        return new S3CryptoScheme(ContentCryptoScheme.AES_CBC, S3KeyWrapScheme.NONE);
    }

    public static boolean isAesGcm(String str) {
        return ContentCryptoScheme.AES_GCM.getCipherAlgorithm().equals(str);
    }

    public ContentCryptoScheme getContentCryptoScheme() {
        return this.contentCryptoScheme;
    }

    public S3KeyWrapScheme getKeyWrapScheme() {
        return this.kwScheme;
    }

    public SecureRandom getSecureRandom() {
        return SRAND;
    }

    private S3CryptoScheme(ContentCryptoScheme contentCryptoScheme, S3KeyWrapScheme s3KeyWrapScheme) {
        this.contentCryptoScheme = contentCryptoScheme;
        this.kwScheme = s3KeyWrapScheme;
    }
}
