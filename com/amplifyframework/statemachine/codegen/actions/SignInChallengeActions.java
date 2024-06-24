package com.amplifyframework.statemachine.codegen.actions;

import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;

/* compiled from: SignInChallengeActions.kt */
/* loaded from: classes.dex */
public interface SignInChallengeActions {
    Action resetToWaitingForAnswer(SignInChallengeEvent.EventType.ThrowError throwError, AuthChallenge authChallenge);

    Action verifyChallengeAuthAction(SignInChallengeEvent.EventType.VerifyChallengeAnswer verifyChallengeAnswer, AuthChallenge authChallenge);
}
