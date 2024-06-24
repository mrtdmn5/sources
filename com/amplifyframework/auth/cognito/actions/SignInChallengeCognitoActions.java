package com.amplifyframework.auth.cognito.actions;

import aws.sdk.kotlin.services.cognitoidentityprovider.model.ChallengeNameType;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.SignInChallengeActions;
import com.amplifyframework.statemachine.codegen.data.AuthChallenge;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInChallengeCognitoActions.kt */
/* loaded from: classes.dex */
public final class SignInChallengeCognitoActions implements SignInChallengeActions {
    public static final SignInChallengeCognitoActions INSTANCE = new SignInChallengeCognitoActions();
    private static final String KEY_SECRET_HASH = "SECRET_HASH";
    private static final String KEY_USERNAME = "USERNAME";

    private SignInChallengeCognitoActions() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getChallengeResponseKey(String str) {
        ChallengeNameType fromValue = ChallengeNameType.Companion.fromValue(str);
        if (fromValue instanceof ChallengeNameType.SmsMfa) {
            return "SMS_MFA_CODE";
        }
        if (fromValue instanceof ChallengeNameType.NewPasswordRequired) {
            return "NEW_PASSWORD";
        }
        if (fromValue instanceof ChallengeNameType.CustomChallenge) {
            return "ANSWER";
        }
        return null;
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInChallengeActions
    public Action resetToWaitingForAnswer(SignInChallengeEvent.EventType.ThrowError event, final AuthChallenge challenge) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Action.Companion companion = Action.Companion;
        final String str = "ResetToWaitingForAnswer";
        return new Action(str, challenge) { // from class: com.amplifyframework.auth.cognito.actions.SignInChallengeCognitoActions$resetToWaitingForAnswer$$inlined$invoke$1
            final /* synthetic */ AuthChallenge $challenge$inlined;
            private final String id;

            {
                this.$challenge$inlined = challenge;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                ((AuthEnvironment) environment).getLogger().verbose(id + " Starting execution");
                eventDispatcher.send(new SignInChallengeEvent(new SignInChallengeEvent.EventType.WaitForAnswer(this.$challenge$inlined), null, 2, null));
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInChallengeActions
    public Action verifyChallengeAuthAction(SignInChallengeEvent.EventType.VerifyChallengeAnswer event, AuthChallenge challenge) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(challenge, "challenge");
        Action.Companion companion = Action.Companion;
        return new SignInChallengeCognitoActions$verifyChallengeAuthAction$$inlined$invoke$1("VerifySignInChallenge", challenge, event);
    }
}
