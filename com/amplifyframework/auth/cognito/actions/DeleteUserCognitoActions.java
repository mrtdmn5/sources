package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.DeleteUserActions;
import com.amplifyframework.statemachine.codegen.data.SignOutData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteUserCognitoActions.kt */
/* loaded from: classes.dex */
public final class DeleteUserCognitoActions implements DeleteUserActions {
    public static final DeleteUserCognitoActions INSTANCE = new DeleteUserCognitoActions();

    private DeleteUserCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.DeleteUserActions
    public Action initDeleteUserAction(String accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Action.Companion companion = Action.Companion;
        return new DeleteUserCognitoActions$initDeleteUserAction$$inlined$invoke$1("DeleteUser", accessToken);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.DeleteUserActions
    public Action initiateSignOut() {
        Action.Companion companion = Action.Companion;
        final String str = "Sign Out Deleted User";
        return new Action(str) { // from class: com.amplifyframework.auth.cognito.actions.DeleteUserCognitoActions$initiateSignOut$$inlined$invoke$1
            private final String id;

            {
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                AuthorizationEvent authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.UserDeleted(null, 1, 0 == true ? 1 : 0), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
                AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignOutRequested(new SignOutData(true, null, true, 2, null)), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authorizationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authorizationEvent);
                Logger logger2 = authEnvironment.getLogger();
                StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m2.append(authenticationEvent.getType());
                logger2.verbose(m2.toString());
                eventDispatcher.send(authenticationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }
}
