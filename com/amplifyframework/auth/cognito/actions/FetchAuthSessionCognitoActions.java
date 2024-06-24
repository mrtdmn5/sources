package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions;
import com.amplifyframework.statemachine.codegen.data.AWSCredentials;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.LoginsMapProvider;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.AuthorizationEvent;
import com.amplifyframework.statemachine.codegen.events.FetchAuthSessionEvent;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FetchAuthSessionCognitoActions.kt */
/* loaded from: classes.dex */
public final class FetchAuthSessionCognitoActions implements FetchAuthSessionActions {
    public static final FetchAuthSessionCognitoActions INSTANCE = new FetchAuthSessionCognitoActions();
    private static final String KEY_DEVICE_KEY = "DEVICE_KEY";
    private static final String KEY_REFRESH_TOKEN = "REFRESH_TOKEN";
    private static final String KEY_SECRET_HASH = "SECRET_HASH";

    private FetchAuthSessionCognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action fetchAWSCredentialsAction(String identityId, LoginsMapProvider loginsMap) {
        Intrinsics.checkNotNullParameter(identityId, "identityId");
        Intrinsics.checkNotNullParameter(loginsMap, "loginsMap");
        Action.Companion companion = Action.Companion;
        return new FetchAuthSessionCognitoActions$fetchAWSCredentialsAction$$inlined$invoke$1("FetchAWSCredentials", identityId, loginsMap);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action fetchIdentityAction(LoginsMapProvider loginsMap) {
        Intrinsics.checkNotNullParameter(loginsMap, "loginsMap");
        Action.Companion companion = Action.Companion;
        return new FetchAuthSessionCognitoActions$fetchIdentityAction$$inlined$invoke$1("FetchIdentity", loginsMap);
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action notifySessionEstablishedAction(final String identityId, final AWSCredentials awsCredentials) {
        Intrinsics.checkNotNullParameter(identityId, "identityId");
        Intrinsics.checkNotNullParameter(awsCredentials, "awsCredentials");
        Action.Companion companion = Action.Companion;
        final String str = "NotifySessionEstablished";
        return new Action(str, identityId, awsCredentials) { // from class: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$notifySessionEstablishedAction$$inlined$invoke$1
            final /* synthetic */ AWSCredentials $awsCredentials$inlined;
            final /* synthetic */ String $identityId$inlined;
            private final String id;

            {
                this.$identityId$inlined = identityId;
                this.$awsCredentials$inlined = awsCredentials;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                AuthorizationEvent authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.Fetched(this.$identityId$inlined, this.$awsCredentials$inlined), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authorizationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authorizationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action notifySessionRefreshedAction(final AmplifyCredential amplifyCredential) {
        Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
        Action.Companion companion = Action.Companion;
        final String str = "NotifySessionRefreshed";
        return new Action(str, amplifyCredential) { // from class: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$notifySessionRefreshedAction$$inlined$invoke$1
            final /* synthetic */ AmplifyCredential $amplifyCredential$inlined;
            private final String id;

            {
                this.$amplifyCredential$inlined = amplifyCredential;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                AuthorizationEvent authorizationEvent = new AuthorizationEvent(new AuthorizationEvent.EventType.Refreshed(this.$amplifyCredential$inlined), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(authorizationEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(authorizationEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action refreshAuthSessionAction(final LoginsMapProvider logins) {
        Intrinsics.checkNotNullParameter(logins, "logins");
        Action.Companion companion = Action.Companion;
        final String str = "RefreshAuthSession";
        return new Action(str, logins) { // from class: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshAuthSessionAction$$inlined$invoke$1
            final /* synthetic */ LoginsMapProvider $logins$inlined;
            private final String id;

            {
                this.$logins$inlined = logins;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                authEnvironment.getLogger().verbose(id + " Starting execution");
                FetchAuthSessionEvent fetchAuthSessionEvent = new FetchAuthSessionEvent(new FetchAuthSessionEvent.EventType.FetchIdentity(this.$logins$inlined), null, 2, null);
                Logger logger = authEnvironment.getLogger();
                StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                m.append(fetchAuthSessionEvent.getType());
                logger.verbose(m.toString());
                eventDispatcher.send(fetchAuthSessionEvent);
                return Unit.INSTANCE;
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action refreshHostedUIUserPoolTokensAction(final SignedInData signedInData) {
        Intrinsics.checkNotNullParameter(signedInData, "signedInData");
        Action.Companion companion = Action.Companion;
        final String str = "RefreshHostedUITokens";
        return new Action(str, signedInData) { // from class: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshHostedUIUserPoolTokensAction$$inlined$invoke$1
            final /* synthetic */ SignedInData $signedInData$inlined;
            private final String id;

            {
                this.$signedInData$inlined = signedInData;
                this.id = str == null ? Action.DefaultImpls.getId(this) : str;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x009d A[Catch: Exception -> 0x00ed, NotAuthorizedException -> 0x00f9, TryCatch #2 {NotAuthorizedException -> 0x00f9, Exception -> 0x00ed, blocks: (B:3:0x001b, B:6:0x0033, B:8:0x0061, B:10:0x006f, B:12:0x0077, B:16:0x0085, B:18:0x009d, B:20:0x00a9, B:21:0x00af, B:23:0x00b9, B:24:0x00bf, B:30:0x00d4, B:32:0x0069, B:33:0x00df, B:34:0x00e6, B:35:0x00e7, B:36:0x00ec), top: B:2:0x001b }] */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00d4 A[Catch: Exception -> 0x00ed, NotAuthorizedException -> 0x00f9, TryCatch #2 {NotAuthorizedException -> 0x00f9, Exception -> 0x00ed, blocks: (B:3:0x001b, B:6:0x0033, B:8:0x0061, B:10:0x006f, B:12:0x0077, B:16:0x0085, B:18:0x009d, B:20:0x00a9, B:21:0x00af, B:23:0x00b9, B:24:0x00bf, B:30:0x00d4, B:32:0x0069, B:33:0x00df, B:34:0x00e6, B:35:0x00e7, B:36:0x00ec), top: B:2:0x001b }] */
            @Override // com.amplifyframework.statemachine.Action
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.Object execute(com.amplifyframework.statemachine.EventDispatcher r24, com.amplifyframework.statemachine.Environment r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
                /*
                    Method dump skipped, instructions count: 303
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.auth.cognito.actions.FetchAuthSessionCognitoActions$refreshHostedUIUserPoolTokensAction$$inlined$invoke$1.execute(com.amplifyframework.statemachine.EventDispatcher, com.amplifyframework.statemachine.Environment, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.FetchAuthSessionActions
    public Action refreshUserPoolTokensAction(SignedInData signedInData) {
        Intrinsics.checkNotNullParameter(signedInData, "signedInData");
        Action.Companion companion = Action.Companion;
        return new FetchAuthSessionCognitoActions$refreshUserPoolTokensAction$$inlined$invoke$1("RefreshUserPoolTokens", signedInData);
    }
}
