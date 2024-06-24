package com.amazonaws.services.s3.internal.crypto;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;

@Deprecated
/* loaded from: classes.dex */
class S3CryptoModuleAEStrict extends S3CryptoModuleAE {
    public S3CryptoModuleAEStrict(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        super(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
        if (cryptoConfiguration.getCryptoMode() == CryptoMode.StrictAuthenticatedEncryption) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleAE
    public final boolean isStrict() {
        return true;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public void securityCheck(ContentCryptoMaterial contentCryptoMaterial, S3ObjectWrapper s3ObjectWrapper) {
        if (ContentCryptoScheme.AES_GCM.equals(contentCryptoMaterial.getContentCryptoScheme())) {
            return;
        }
        StringBuilder sb = new StringBuilder("S3 object [bucket: ");
        sb.append(s3ObjectWrapper.getBucketName());
        sb.append(", key: ");
        throw new SecurityException(ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, s3ObjectWrapper.getKey(), "] not encrypted using authenticated encryption"));
    }
}
