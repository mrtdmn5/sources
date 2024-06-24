package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.kms.AWSKMSClient;
import com.amazonaws.services.s3.internal.S3Direct;
import com.amazonaws.services.s3.model.CryptoConfiguration;
import com.amazonaws.services.s3.model.CryptoMode;
import com.amazonaws.services.s3.model.EncryptionMaterialsProvider;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
class S3CryptoModuleEO extends S3CryptoModuleBase<MultipartUploadCbcContext> {
    public S3CryptoModuleEO(AWSKMSClient aWSKMSClient, S3Direct s3Direct, AWSCredentialsProvider aWSCredentialsProvider, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        super(aWSKMSClient, s3Direct, aWSCredentialsProvider, encryptionMaterialsProvider, cryptoConfiguration);
        if (cryptoConfiguration.getCryptoMode() != CryptoMode.EncryptionOnly) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final long ciphertextLength(long j) {
        long blockSizeInBytes = this.contentCryptoScheme.getBlockSizeInBytes();
        return (blockSizeInBytes - (j % blockSizeInBytes)) + j;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final long computeLastPartSize(UploadPartRequest uploadPartRequest) {
        long partSize;
        if (uploadPartRequest.getFile() != null) {
            if (uploadPartRequest.getPartSize() > 0) {
                partSize = uploadPartRequest.getPartSize();
            } else {
                partSize = uploadPartRequest.getFile().length();
            }
        } else if (uploadPartRequest.getInputStream() != null) {
            partSize = uploadPartRequest.getPartSize();
        } else {
            return -1L;
        }
        long blockSizeInBytes = this.contentCryptoScheme.getBlockSizeInBytes();
        return (blockSizeInBytes - (partSize % blockSizeInBytes)) + partSize;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public S3Object getObjectSecurely(GetObjectRequest getObjectRequest) {
        throw new IllegalStateException();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final CipherLite cipherLiteForNextPart(MultipartUploadCbcContext multipartUploadCbcContext) {
        return multipartUploadCbcContext.getCipherLite().createUsingIV(multipartUploadCbcContext.getNextInitializationVector());
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModule
    public ObjectMetadata getObjectSecurely(GetObjectRequest getObjectRequest, File file) {
        throw new IllegalStateException();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final MultipartUploadCbcContext newUploadContext(InitiateMultipartUploadRequest initiateMultipartUploadRequest, ContentCryptoMaterial contentCryptoMaterial) {
        MultipartUploadCbcContext multipartUploadCbcContext = new MultipartUploadCbcContext(initiateMultipartUploadRequest.getBucketName(), initiateMultipartUploadRequest.getKey(), contentCryptoMaterial);
        multipartUploadCbcContext.setNextInitializationVector(contentCryptoMaterial.getCipherLite().getIV());
        return multipartUploadCbcContext;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final void updateUploadContext(MultipartUploadCbcContext multipartUploadCbcContext, SdkFilterInputStream sdkFilterInputStream) {
        multipartUploadCbcContext.setNextInitializationVector(((ByteRangeCapturingInputStream) sdkFilterInputStream).getBlock());
    }

    @Override // com.amazonaws.services.s3.internal.crypto.S3CryptoModuleBase
    public final ByteRangeCapturingInputStream wrapForMultipart(CipherLiteInputStream cipherLiteInputStream, long j) {
        return new ByteRangeCapturingInputStream(cipherLiteInputStream, j - this.contentCryptoScheme.getBlockSizeInBytes(), j);
    }

    public S3CryptoModuleEO(S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(null, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }

    public S3CryptoModuleEO(AWSKMSClient aWSKMSClient, S3Direct s3Direct, EncryptionMaterialsProvider encryptionMaterialsProvider, CryptoConfiguration cryptoConfiguration) {
        this(aWSKMSClient, s3Direct, new DefaultAWSCredentialsProviderChain(), encryptionMaterialsProvider, cryptoConfiguration);
    }
}
