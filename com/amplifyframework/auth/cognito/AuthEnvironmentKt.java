package com.amplifyframework.auth.cognito;

import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.DeleteUserEvent;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthEnvironment.kt */
/* loaded from: classes.dex */
public final class AuthEnvironmentKt {
    public static final AuthEvent.EventType isAuthEvent(StateMachineEvent stateMachineEvent) {
        AuthEvent authEvent;
        Intrinsics.checkNotNullParameter(stateMachineEvent, "<this>");
        if (stateMachineEvent instanceof AuthEvent) {
            authEvent = (AuthEvent) stateMachineEvent;
        } else {
            authEvent = null;
        }
        if (authEvent == null) {
            return null;
        }
        return authEvent.getEventType();
    }

    public static final AuthenticationEvent.EventType isAuthenticationEvent(StateMachineEvent stateMachineEvent) {
        AuthenticationEvent authenticationEvent;
        Intrinsics.checkNotNullParameter(stateMachineEvent, "<this>");
        if (stateMachineEvent instanceof AuthenticationEvent) {
            authenticationEvent = (AuthenticationEvent) stateMachineEvent;
        } else {
            authenticationEvent = null;
        }
        if (authenticationEvent == null) {
            return null;
        }
        return authenticationEvent.getEventType();
    }

    public static final AuthorizationEvent.EventType isAuthorizationEvent(StateMachineEvent stateMachineEvent) {
        AuthorizationEvent authorizationEvent;
        Intrinsics.checkNotNullParameter(stateMachineEvent, "<this>");
        if (stateMachineEvent instanceof AuthorizationEvent) {
            authorizationEvent = (AuthorizationEvent) stateMachineEvent;
        } else {
            authorizationEvent = null;
        }
        if (authorizationEvent == null) {
            return null;
        }
        return authorizationEvent.getEventType();
    }

    public static final DeleteUserEvent.EventType isDeleteUserEvent(StateMachineEvent stateMachineEvent) {
        DeleteUserEvent deleteUserEvent;
        Intrinsics.checkNotNullParameter(stateMachineEvent, "<this>");
        if (stateMachineEvent instanceof DeleteUserEvent) {
            deleteUserEvent = (DeleteUserEvent) stateMachineEvent;
        } else {
            deleteUserEvent = null;
        }
        if (deleteUserEvent == null) {
            return null;
        }
        return deleteUserEvent.getEventType();
    }

    public static final SignOutEvent.EventType isSignOutEvent(StateMachineEvent stateMachineEvent) {
        SignOutEvent signOutEvent;
        Intrinsics.checkNotNullParameter(stateMachineEvent, "<this>");
        if (stateMachineEvent instanceof SignOutEvent) {
            signOutEvent = (SignOutEvent) stateMachineEvent;
        } else {
            signOutEvent = null;
        }
        if (signOutEvent == null) {
            return null;
        }
        return signOutEvent.getEventType();
    }
}
