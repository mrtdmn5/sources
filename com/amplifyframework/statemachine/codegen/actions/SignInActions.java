package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;

/* compiled from: SignInActions.kt */
/* loaded from: classes.dex */
public interface SignInActions {
    Action confirmDevice(SignInEvent.EventType.ConfirmDevice confirmDevice);

    Action initResolveChallenge(SignInEvent.EventType.ReceivedChallenge receivedChallenge);

    Action startCustomAuthAction(SignInEvent.EventType.InitiateSignInWithCustom initiateSignInWithCustom);

    Action startCustomAuthWithSRPAction(SignInEvent.EventType.InitiateCustomSignInWithSRP initiateCustomSignInWithSRP);

    Action startDeviceSRPAuthAction(SignInEvent.EventType.InitiateSignInWithDeviceSRP initiateSignInWithDeviceSRP);

    Action startHostedUIAuthAction(SignInEvent.EventType.InitiateHostedUISignIn initiateHostedUISignIn);

    Action startMigrationAuthAction(SignInEvent.EventType.InitiateMigrateAuth initiateMigrateAuth);

    Action startSRPAuthAction(SignInEvent.EventType.InitiateSignInWithSRP initiateSignInWithSRP);
}
