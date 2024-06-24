package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignOutEvent;

/* compiled from: SignOutActions.kt */
/* loaded from: classes.dex */
public interface SignOutActions {
    Action buildRevokeTokenErrorAction(SignOutEvent.EventType.SignOutGloballyError signOutGloballyError);

    Action globalSignOutAction(SignOutEvent.EventType.SignOutGlobally signOutGlobally);

    Action hostedUISignOutAction(SignOutEvent.EventType.InvokeHostedUISignOut invokeHostedUISignOut);

    Action localSignOutAction(SignOutEvent.EventType.SignOutLocally signOutLocally);

    Action revokeTokenAction(SignOutEvent.EventType.RevokeToken revokeToken);

    Action userCancelledAction(SignOutEvent.EventType.UserCancelled userCancelled);
}
