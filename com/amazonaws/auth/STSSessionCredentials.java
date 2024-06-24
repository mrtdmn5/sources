package com.amazonaws.auth;

import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;

@Deprecated
/* loaded from: classes.dex */
public class STSSessionCredentials implements AWSRefreshableSessionCredentials {
    public static final int DEFAULT_DURATION_SECONDS = 3600;
    private final AWSSecurityTokenService securityTokenService;
    private Credentials sessionCredentials;
    private final int sessionDurationSeconds;

    public STSSessionCredentials(AWSCredentials aWSCredentials) {
        this(aWSCredentials, 3600);
    }

    private synchronized Credentials getSessionCredentials() {
        if (needsNewSession()) {
            refreshCredentials();
        }
        return this.sessionCredentials;
    }

    private boolean needsNewSession() {
        Credentials credentials = this.sessionCredentials;
        if (credentials == null || credentials.getExpiration().getTime() - System.currentTimeMillis() < 60000) {
            return true;
        }
        return false;
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public synchronized String getAWSAccessKeyId() {
        return getSessionCredentials().getAccessKeyId();
    }

    @Override // com.amazonaws.auth.AWSCredentials
    public synchronized String getAWSSecretKey() {
        return getSessionCredentials().getSecretAccessKey();
    }

    public synchronized AWSSessionCredentials getImmutableCredentials() {
        Credentials sessionCredentials;
        sessionCredentials = getSessionCredentials();
        return new BasicSessionCredentials(sessionCredentials.getAccessKeyId(), sessionCredentials.getSecretAccessKey(), sessionCredentials.getSessionToken());
    }

    @Override // com.amazonaws.auth.AWSSessionCredentials
    public synchronized String getSessionToken() {
        return getSessionCredentials().getSessionToken();
    }

    @Override // com.amazonaws.auth.AWSRefreshableSessionCredentials
    public synchronized void refreshCredentials() {
        this.sessionCredentials = this.securityTokenService.getSessionToken(new GetSessionTokenRequest().withDurationSeconds(Integer.valueOf(this.sessionDurationSeconds))).getCredentials();
    }

    public STSSessionCredentials(AWSCredentials aWSCredentials, int r3) {
        this.securityTokenService = new AWSSecurityTokenServiceClient(aWSCredentials);
        this.sessionDurationSeconds = r3;
    }

    public STSSessionCredentials(AWSSecurityTokenService aWSSecurityTokenService) {
        this(aWSSecurityTokenService, 3600);
    }

    public STSSessionCredentials(AWSSecurityTokenService aWSSecurityTokenService, int r2) {
        this.securityTokenService = aWSSecurityTokenService;
        this.sessionDurationSeconds = r2;
    }
}
