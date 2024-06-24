package com.amazonaws.auth;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.amazonaws.AmazonClientException;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
/* loaded from: classes.dex */
public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    private static String defaultPropertiesFile = "AwsCredentials.properties";
    private final String credentialsFilePath;

    public ClasspathPropertiesFileCredentialsProvider() {
        this(defaultPropertiesFile);
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.credentialsFilePath);
        if (resourceAsStream != null) {
            try {
                return new PropertiesCredentials(resourceAsStream);
            } catch (IOException e) {
                throw new AmazonClientException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Unable to load AWS credentials from the "), this.credentialsFilePath, " file on the classpath"), e);
            }
        }
        throw new AmazonClientException(ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder("Unable to load AWS credentials from the "), this.credentialsFilePath, " file on the classpath"));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("(");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.credentialsFilePath, ")");
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str != null) {
            if (!str.startsWith("/")) {
                this.credentialsFilePath = "/".concat(str);
                return;
            } else {
                this.credentialsFilePath = str;
                return;
            }
        }
        throw new IllegalArgumentException("Credentials file path cannot be null");
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
    }
}
