package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/* loaded from: classes.dex */
public class PropertiesCredentials implements AWSCredentials {
    private final String accessKey;
    private final String secretAccessKey;

    public PropertiesCredentials(File file) throws IOException {
        if (file.exists()) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                Properties properties = new Properties();
                properties.load(fileInputStream);
                if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                    this.accessKey = properties.getProperty("accessKey");
                    this.secretAccessKey = properties.getProperty("secretKey");
                    try {
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                } else {
                    throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") doesn't contain the expected properties 'accessKey' and 'secretKey'.");
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
        throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSAccessKeyId() {
        return this.accessKey;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public String getAWSSecretKey() {
        return this.secretAccessKey;
    }

    public PropertiesCredentials(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") != null && properties.getProperty("secretKey") != null) {
                this.accessKey = properties.getProperty("accessKey");
                this.secretAccessKey = properties.getProperty("secretKey");
                return;
            }
            throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
        } finally {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
