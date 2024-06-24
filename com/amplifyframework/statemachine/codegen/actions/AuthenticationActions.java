package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;

/* compiled from: AuthenticationActions.kt */
/* loaded from: classes.dex */
public interface AuthenticationActions {
    Action configureAuthenticationAction(AuthenticationEvent.EventType.Configure configure);

    Action initiateSignInAction(AuthenticationEvent.EventType.SignInRequested signInRequested);

    Action initiateSignOutAction(AuthenticationEvent.EventType.SignOutRequested signOutRequested, SignedInData signedInData);
}
