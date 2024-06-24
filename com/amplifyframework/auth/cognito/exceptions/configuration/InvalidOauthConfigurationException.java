package com.amplifyframework.auth.cognito.exceptions.configuration;

import com.amplifyframework.auth.exceptions.ConfigurationException;

/* compiled from: InvalidOauthConfigurationException.kt */
/* loaded from: classes.dex */
public final class InvalidOauthConfigurationException extends ConfigurationException {
    public InvalidOauthConfigurationException() {
        super("The Oauth configuration is missing or invalid.", "HostedUI Oauth section not configured or unable to parse from amplifyconfiguration.json file.", null, 4, null);
    }
}
