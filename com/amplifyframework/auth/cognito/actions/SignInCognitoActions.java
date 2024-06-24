package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.SignInActions;
import com.amplifyframework.statemachine.codegen.events.CustomSignInEvent;
import com.amplifyframework.statemachine.codegen.events.DeviceSRPSignInEvent;
import com.amplifyframework.statemachine.codegen.events.HostedUIEvent;
import com.amplifyframework.statemachine.codegen.events.SRPEvent;
import com.amplifyframework.statemachine.codegen.events.SignInChallengeEvent;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInCognitoActions.kt */
/* loaded from: classes.dex */
public final class SignInCognitoActions implements SignInActions {
    public static final SignInCognitoActions INSTANCE = new SignInCognitoActions();

    private SignInCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action confirmDevice(SignInEvent.EventType.ConfirmDevice event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        return new SignInCognitoActions$confirmDevice$$inlined$invoke$1("ConfirmDevice", event);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action initResolveChallenge(final SignInEvent.EventType.ReceivedChallenge event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitResolveChallenge";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$initResolveChallenge$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.ReceivedChallenge $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                SignInChallengeEvent signInChallengeEvent = new SignInChallengeEvent(new SignInChallengeEvent.EventType.WaitForAnswer(this.$event$inlined.getChallenge()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(signInChallengeEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(signInChallengeEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startCustomAuthAction(final SignInEvent.EventType.InitiateSignInWithCustom event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartCustomAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startCustomAuthAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateSignInWithCustom $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                CustomSignInEvent customSignInEvent = new CustomSignInEvent(new CustomSignInEvent.EventType.InitiateCustomSignIn(this.$event$inlined.getUsername(), this.$event$inlined.getMetadata()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(customSignInEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(customSignInEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startCustomAuthWithSRPAction(final SignInEvent.EventType.InitiateCustomSignInWithSRP event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartCustomSRPAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startCustomAuthWithSRPAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateCustomSignInWithSRP $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                SRPEvent sRPEvent = new SRPEvent(new SRPEvent.EventType.InitiateSRPWithCustom(this.$event$inlined.getUsername(), this.$event$inlined.getPassword(), this.$event$inlined.getMetadata()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(sRPEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(sRPEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startDeviceSRPAuthAction(final SignInEvent.EventType.InitiateSignInWithDeviceSRP event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartDeviceSRPAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startDeviceSRPAuthAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateSignInWithDeviceSRP $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                DeviceSRPSignInEvent deviceSRPSignInEvent = new DeviceSRPSignInEvent(new DeviceSRPSignInEvent.EventType.RespondDeviceSRPChallenge(this.$event$inlined.getUsername(), this.$event$inlined.getMetadata()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(deviceSRPSignInEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(deviceSRPSignInEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startHostedUIAuthAction(final SignInEvent.EventType.InitiateHostedUISignIn event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartHostedUIAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startHostedUIAuthAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateHostedUISignIn $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                HostedUIEvent hostedUIEvent = new HostedUIEvent(new HostedUIEvent.EventType.ShowHostedUI(this.$event$inlined.getHostedUISignInData()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(hostedUIEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(hostedUIEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startMigrationAuthAction(final SignInEvent.EventType.InitiateMigrateAuth event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartMigrationAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startMigrationAuthAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateMigrateAuth $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                SignInEvent signInEvent = new SignInEvent(new SignInEvent.EventType.InitiateMigrateAuth(this.$event$inlined.getUsername(), this.$event$inlined.getPassword(), this.$event$inlined.getMetadata()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(signInEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(signInEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.SignInActions
    public Action startSRPAuthAction(final SignInEvent.EventType.InitiateSignInWithSRP event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "StartSRPAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.SignInCognitoActions$startSRPAuthAction$$inlined$invoke$1
            final /* synthetic */ SignInEvent.EventType.InitiateSignInWithSRP $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                SRPEvent sRPEvent = new SRPEvent(new SRPEvent.EventType.InitiateSRP(this.$event$inlined.getUsername(), this.$event$inlined.getPassword(), this.$event$inlined.getMetadata()), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(sRPEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(sRPEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }
}
