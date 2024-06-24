package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;

/* compiled from: AuthActions.kt */
/* loaded from: classes.dex */
public interface AuthActions {
    Action initializeAuthConfigurationAction(AuthEvent.EventType.ConfigureAuth configureAuth);

    Action initializeAuthenticationConfigurationAction(AuthEvent.EventType.ConfigureAuthentication configureAuthentication);

    Action initializeAuthorizationConfigurationAction(AuthEvent.EventType eventType);
}
