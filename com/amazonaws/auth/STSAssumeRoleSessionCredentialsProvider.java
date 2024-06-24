package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.Credentials;
import java.util.Date;

/* loaded from: classes.dex */
public class STSAssumeRoleSessionCredentialsProvider implements AWSCredentialsProvider {
    public static final int DEFAULT_DURATION_SECONDS = 900;
    private static final int EXPIRY_TIME_MILLIS = 60000;
    private String roleArn;
    private String roleSessionName;
    private final AWSSecurityTokenService securityTokenService;
    private AWSSessionCredentials sessionCredentials;
    private Date sessionCredentialsExpiration;

    public STSAssumeRoleSessionCredentialsProvider(String str, String str2) {
        this.roleArn = str;
        this.roleSessionName = str2;
        this.securityTokenService = new AWSSecurityTokenServiceClient();
    }

    private boolean needsNewSession() {
        if (this.sessionCredentials == null || this.sessionCredentialsExpiration.getTime() - System.currentTimeMillis() < 60000) {
            return true;
        }
        return false;
    }

    private void startSession() {
        Credentials credentials = this.securityTokenService.assumeRole(new AssumeRoleRequest().withRoleArn(this.roleArn).withDurationSeconds(Integer.valueOf(DEFAULT_DURATION_SECONDS)).withRoleSessionName(this.roleSessionName)).getCredentials();
        this.sessionCredentials = new BasicSessionCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken());
        this.sessionCredentialsExpiration = credentials.getExpiration();
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public AWSCredentials getCredentials() {
        if (needsNewSession()) {
            startSession();
        }
        return this.sessionCredentials;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        startSession();
    }

    public void setSTSClientEndpoint(String str) {
        this.securityTokenService.setEndpoint(str);
        this.sessionCredentials = null;
    }

    public STSAssumeRoleSessionCredentialsProvider(AWSCredentials aWSCredentials, String str, String str2) {
        this(aWSCredentials, str, str2, new ClientConfiguration());
    }

    public STSAssumeRoleSessionCredentialsProvider(AWSCredentials aWSCredentials, String str, String str2, ClientConfiguration clientConfiguration) {
        this.roleArn = str;
        this.roleSessionName = str2;
        this.securityTokenService = new AWSSecurityTokenServiceClient(aWSCredentials, clientConfiguration);
    }

    public STSAssumeRoleSessionCredentialsProvider(AWSCredentialsProvider aWSCredentialsProvider, String str, String str2) {
        this.roleArn = str;
        this.roleSessionName = str2;
        this.securityTokenService = new AWSSecurityTokenServiceClient(aWSCredentialsProvider);
    }

    public STSAssumeRoleSessionCredentialsProvider(AWSCredentialsProvider aWSCredentialsProvider, String str, String str2, ClientConfiguration clientConfiguration) {
        this.roleArn = str;
        this.roleSessionName = str2;
        this.securityTokenService = new AWSSecurityTokenServiceClient(aWSCredentialsProvider, clientConfiguration);
    }
}
