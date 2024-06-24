package com.amplifyframework.auth.cognito.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.actions.CustomSignInActions;
import com.amplifyframework.statemachine.codegen.events.CustomSignInEvent;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInCustomCognitoActions.kt */
/* loaded from: classes.dex */
public final class SignInCustomCognitoActions implements CustomSignInActions {
    public static final SignInCustomCognitoActions INSTANCE = new SignInCustomCognitoActions();
    private static final String KEY_DEVICE_KEY = "DEVICE_KEY";
    private static final String KEY_SECRET_HASH = "SECRET_HASH";
    private static final String KEY_USERNAME = "USERNAME";

    private SignInCustomCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.CustomSignInActions
    public Action initiateCustomSignInAuthAction(CustomSignInEvent.EventType.InitiateCustomSignIn event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new SignInCustomCognitoActions$initiateCustomSignInAuthAction$$inlined$invoke$1("InitCustomAuth", event);
    }
}
