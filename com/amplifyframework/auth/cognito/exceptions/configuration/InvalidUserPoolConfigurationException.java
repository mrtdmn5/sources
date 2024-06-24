package com.amplifyframework.auth.cognito.exceptions.configuration;

import com.amplifyframework.auth.exceptions.ConfigurationException;

/* compiled from: InvalidUserPoolConfigurationException.kt */
/* loaded from: classes.dex */
public final class InvalidUserPoolConfigurationException extends ConfigurationException {
    public InvalidUserPoolConfigurationException() {
        super("The user pool configuration is missing or invalid.", "Please check the user pool configuration in your amplifyconfiguration.json file.", null, 4, null);
    }
}
