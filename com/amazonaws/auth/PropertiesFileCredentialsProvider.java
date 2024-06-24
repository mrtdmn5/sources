package com.amazonaws.auth;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class PropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    private final String credentialsFilePath;

    public PropertiesFileCredentialsProvider(String str) {
        if (str != null) {
            this.credentialsFilePath = str;
            return;
        }
        throw new IllegalArgumentException("Credentials file path cannot be null");
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        try {
            return new PropertiesCredentials(new File(this.credentialsFilePath));
        } catch (IOException e) {
            throw new AmazonClientException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Unable to load AWS credentials from the "), this.credentialsFilePath, " file"), e);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.credentialsFilePath, ")");
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
    }
}
