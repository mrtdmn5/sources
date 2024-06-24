package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import java.util.Date;

/* loaded from: classes.dex */
public class WebIdentityFederationSessionCredentialsProvider implements AWSCredentialsProvider {
    public static final int DEFAULT_DURATION_SECONDS = 3600;
    public static final int DEFAULT_THRESHOLD_SECONDS = 500;
    private int refreshThreshold;
    private final String roleArn;
    private final AWSSecurityTokenService securityTokenService;
    private AWSSessionCredentials sessionCredentials;
    private Date sessionCredentialsExpiration;
    private int sessionDuration;
    private String subjectFromWIF;
    private final String wifProvider;
    private final String wifToken;

    public WebIdentityFederationSessionCredentialsProvider(String str, String str2, String str3) {
        this(str, str2, str3, new ClientConfiguration());
    }

    private boolean needsNewSession() {
        if (this.sessionCredentials == null || this.sessionCredentialsExpiration.getTime() - System.currentTimeMillis() < this.refreshThreshold * 1000) {
            return true;
        }
        return false;
    }

    private void startSession() {
        AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentity = this.securityTokenService.assumeRoleWithWebIdentity(new AssumeRoleWithWebIdentityRequest().withWebIdentityToken(this.wifToken).withProviderId(this.wifProvider).withRoleArn(this.roleArn).withRoleSessionName("ProviderSession").withDurationSeconds(Integer.valueOf(this.sessionDuration)));
        Credentials credentials = assumeRoleWithWebIdentity.getCredentials();
        this.subjectFromWIF = assumeRoleWithWebIdentity.getSubjectFromWebIdentityToken();
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

    public int getRefreshThreshold() {
        return this.refreshThreshold;
    }

    public int getSessionDuration() {
        return this.sessionDuration;
    }

    public String getSubjectFromWIF() {
        return this.subjectFromWIF;
    }

    @Override // com.amazonaws.auth.AWSCredentialsProvider
    public void refresh() {
        startSession();
    }

    public void setRefreshThreshold(int r1) {
        this.refreshThreshold = r1;
    }

    public void setSessionDuration(int r1) {
        this.sessionDuration = r1;
    }

    public WebIdentityFederationSessionCredentialsProvider withRefreshThreshold(int r1) {
        setRefreshThreshold(r1);
        return this;
    }

    public WebIdentityFederationSessionCredentialsProvider withSessionDuration(int r1) {
        setSessionDuration(r1);
        return this;
    }

    public WebIdentityFederationSessionCredentialsProvider(String str, String str2, String str3, ClientConfiguration clientConfiguration) {
        this(str, str2, str3, new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), clientConfiguration));
    }

    public WebIdentityFederationSessionCredentialsProvider(String str, String str2, String str3, AWSSecurityTokenService aWSSecurityTokenService) {
        this.securityTokenService = aWSSecurityTokenService;
        this.wifProvider = str2;
        this.wifToken = str;
        this.roleArn = str3;
        this.sessionDuration = 3600;
        this.refreshThreshold = 500;
    }
}
