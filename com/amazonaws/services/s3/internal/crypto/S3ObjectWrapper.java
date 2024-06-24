package com.amazonaws.services.s3.internal.crypto;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AbstractAWSSigner$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectId;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.StringUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

@Deprecated
/* loaded from: classes.dex */
class S3ObjectWrapper implements Closeable {
    private final S3ObjectId id;
    private final S3Object s3obj;

    public S3ObjectWrapper(S3Object s3Object, S3ObjectId s3ObjectId) {
        if (s3Object != null) {
            this.s3obj = s3Object;
            this.id = s3ObjectId;
            return;
        }
        throw new IllegalArgumentException();
    }

    private static String from(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringUtils.UTF8));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    inputStream.close();
                    return sb.toString();
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.s3obj.close();
    }

    public ContentCryptoScheme encryptionSchemeOf(Map<String, String> map) {
        if (map != null) {
            return ContentCryptoScheme.fromCEKAlgo(map.get(Headers.CRYPTO_CEK_ALGORITHM));
        }
        return ContentCryptoScheme.fromCEKAlgo(this.s3obj.getObjectMetadata().getUserMetadata().get(Headers.CRYPTO_CEK_ALGORITHM));
    }

    public String getBucketName() {
        return this.s3obj.getBucketName();
    }

    public String getKey() {
        return this.s3obj.getKey();
    }

    public S3ObjectInputStream getObjectContent() {
        return this.s3obj.getObjectContent();
    }

    public ObjectMetadata getObjectMetadata() {
        return this.s3obj.getObjectMetadata();
    }

    public String getRedirectLocation() {
        return this.s3obj.getRedirectLocation();
    }

    public S3Object getS3Object() {
        return this.s3obj;
    }

    public S3ObjectId getS3ObjectId() {
        return this.id;
    }

    public final boolean hasEncryptionInfo() {
        Map<String, String> userMetadata = this.s3obj.getObjectMetadata().getUserMetadata();
        if (userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_IV) && (userMetadata.containsKey(Headers.CRYPTO_KEY_V2) || userMetadata.containsKey(Headers.CRYPTO_KEY))) {
            return true;
        }
        return false;
    }

    public final boolean isInstructionFile() {
        Map<String, String> userMetadata = this.s3obj.getObjectMetadata().getUserMetadata();
        if (userMetadata != null && userMetadata.containsKey(Headers.CRYPTO_INSTRUCTION_FILE)) {
            return true;
        }
        return false;
    }

    public void setBucketName(String str) {
        this.s3obj.setBucketName(str);
    }

    public void setKey(String str) {
        this.s3obj.setKey(str);
    }

    public void setObjectContent(S3ObjectInputStream s3ObjectInputStream) {
        this.s3obj.setObjectContent(s3ObjectInputStream);
    }

    public void setObjectMetadata(ObjectMetadata objectMetadata) {
        this.s3obj.setObjectMetadata(objectMetadata);
    }

    public void setRedirectLocation(String str) {
        this.s3obj.setRedirectLocation(str);
    }

    public String toJsonString() {
        try {
            return from(this.s3obj.getObjectContent());
        } catch (Exception e) {
            throw new AmazonClientException(AbstractAWSSigner$$ExternalSyntheticOutline0.m(e, new StringBuilder("Error parsing JSON: ")));
        }
    }

    public String toString() {
        return this.s3obj.toString();
    }

    public void setObjectContent(InputStream inputStream) {
        this.s3obj.setObjectContent(inputStream);
    }
}
