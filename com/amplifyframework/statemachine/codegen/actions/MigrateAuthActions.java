package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;

/* compiled from: MigrateAuthActions.kt */
/* loaded from: classes.dex */
public interface MigrateAuthActions {
    Action initiateMigrateAuthAction(SignInEvent.EventType.InitiateMigrateAuth initiateMigrateAuth);
}
