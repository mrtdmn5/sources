package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.CustomSignInEvent;

/* compiled from: CustomSignInActions.kt */
/* loaded from: classes.dex */
public interface CustomSignInActions {
    Action initiateCustomSignInAuthAction(CustomSignInEvent.EventType.InitiateCustomSignIn initiateCustomSignIn);
}
