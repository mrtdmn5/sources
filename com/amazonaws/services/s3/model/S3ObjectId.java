package com.amazonaws.services.s3.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.io.Serializable;

/* loaded from: classes.dex */
public class S3ObjectId implements Serializable {
    private final String bucket;
    private final String key;
    private final String versionId;

    public S3ObjectId(String str, String str2) {
        this(str, str2, null);
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public InstructionFileId instructionFileId() {
        return instructionFileId(null);
    }

    public String toString() {
        return "bucket: " + this.bucket + ", key: " + this.key + ", versionId: " + this.versionId;
    }

    public S3ObjectId(String str, String str2, String str3) {
        if (str != null && str2 != null) {
            this.bucket = str;
            this.key = str2;
            this.versionId = str3;
            return;
        }
        throw new IllegalArgumentException("bucket and key must be specified");
    }

    public InstructionFileId instructionFileId(String str) {
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.key, InstructionFileId.DOT));
        if (str == null || str.trim().length() == 0) {
            str = "instruction";
        }
        m.append(str);
        return new InstructionFileId(this.bucket, m.toString(), this.versionId);
    }

    public S3ObjectId(S3ObjectIdBuilder s3ObjectIdBuilder) {
        this.bucket = s3ObjectIdBuilder.getBucket();
        this.key = s3ObjectIdBuilder.getKey();
        this.versionId = s3ObjectIdBuilder.getVersionId();
    }
}
