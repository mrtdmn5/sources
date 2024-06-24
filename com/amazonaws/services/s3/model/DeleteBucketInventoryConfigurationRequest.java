package com.amazonaws.services.s3.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DeleteBucketInventoryConfigurationRequest extends AmazonWebServiceRequest implements Serializable {
    private String bucketName;
    private String id;

    public DeleteBucketInventoryConfigurationRequest() {
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getId() {
        return this.id;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public DeleteBucketInventoryConfigurationRequest withBucketName(String str) {
        setBucketName(str);
        return this;
    }

    public DeleteBucketInventoryConfigurationRequest withId(String str) {
        setId(str);
        return this;
    }

    public DeleteBucketInventoryConfigurationRequest(String str, String str2) {
        this.bucketName = str;
        this.id = str2;
    }
}
