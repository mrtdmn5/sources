package com.amplifyframework.auth.cognito.actions;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironment;
import com.amplifyframework.auth.cognito.exceptions.configuration.InvalidOauthConfigurationException;
import com.amplifyframework.auth.cognito.helpers.JWTParser;
import com.amplifyframework.logging.Logger;
import com.amplifyframework.statemachine.Action;
import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.EventDispatcher;
import com.amplifyframework.statemachine.codegen.actions.HostedUIActions;
import com.amplifyframework.statemachine.codegen.data.CognitoUserPoolTokens;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.SignInMethod;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.events.AuthenticationEvent;
import com.amplifyframework.statemachine.codegen.events.HostedUIEvent;
import java.util.Date;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUICognitoActions.kt */
/* loaded from: classes.dex */
public final class HostedUICognitoActions implements HostedUIActions {
    public static final HostedUICognitoActions INSTANCE = new HostedUICognitoActions();

    private HostedUICognitoActions() {
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.HostedUIActions
    public Action fetchHostedUISignInToken(final HostedUIEvent.EventType.FetchToken event, final String str) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str2 = "InitHostedUITokenFetch";
        return new Action(str2, event, str) { // from class: com.amplifyframework.auth.cognito.actions.HostedUICognitoActions$fetchHostedUISignInToken$$inlined$invoke$1
            final /* synthetic */ String $browserPackage$inlined;
            final /* synthetic */ HostedUIEvent.EventType.FetchToken $event$inlined;
            private final String id;

            {
                this.$event$inlined = event;
                this.$browserPackage$inlined = str;
                this.id = str2 == null ? Action.DefaultImpls.getId(this) : str2;
            }

            @Override // com.amplifyframework.statemachine.Action
            public Object execute(EventDispatcher eventDispatcher, Environment environment, Continuation<? super Unit> continuation) {
                AuthenticationEvent authenticationEvent;
                String str3;
                String accessToken;
                String str4;
                String claim;
                String claim2;
                Intrinsics.checkNotNull(environment, "null cannot be cast to non-null type EnvType of com.amplifyframework.statemachine.Action.Companion.invoke");
                String id = getId();
                AuthEnvironment authEnvironment = (AuthEnvironment) environment;
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                int r1 = 2;
                Date date = null;
                byte b = 0;
                byte b2 = 0;
                byte b3 = 0;
                byte b4 = 0;
                byte b5 = 0;
                try {
                } catch (Exception e) {
                    HostedUIEvent hostedUIEvent = new HostedUIEvent(new HostedUIEvent.EventType.ThrowError(e), null, 2, null);
                    Logger logger = authEnvironment.getLogger();
                    StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                    m.append(hostedUIEvent.getType());
                    logger.verbose(m.toString());
                    eventDispatcher.send(hostedUIEvent);
                    authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignIn(b4 == true ? 1 : 0, 1, b3 == true ? 1 : 0), b2 == true ? 1 : 0, r1, b == true ? 1 : 0);
                }
                if (authEnvironment.getHostedUIClient() != null) {
                    CognitoUserPoolTokens fetchToken = authEnvironment.getHostedUIClient().fetchToken(this.$event$inlined.getUri());
                    String accessToken2 = fetchToken.getAccessToken();
                    if (accessToken2 != null && (claim2 = JWTParser.INSTANCE.getClaim(accessToken2, "sub")) != null) {
                        str3 = claim2;
                        accessToken = fetchToken.getAccessToken();
                        if (accessToken != null && (claim = JWTParser.INSTANCE.getClaim(accessToken, "username")) != null) {
                            str4 = claim;
                            SignedInData signedInData = new SignedInData(str3, str4, new Date(), new SignInMethod.HostedUI(this.$browserPackage$inlined), fetchToken);
                            HostedUIEvent hostedUIEvent2 = new HostedUIEvent(HostedUIEvent.EventType.TokenFetched.INSTANCE, null, 2, null);
                            authEnvironment.getLogger().verbose(id + " Sending event " + hostedUIEvent2.getType());
                            eventDispatcher.send(hostedUIEvent2);
                            authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignInCompleted(signedInData, DeviceMetadata.Empty.INSTANCE), date, r1, b5 == true ? 1 : 0);
                            Logger logger2 = authEnvironment.getLogger();
                            StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                            m2.append(authenticationEvent.getType());
                            logger2.verbose(m2.toString());
                            eventDispatcher.send(authenticationEvent);
                            return Unit.INSTANCE;
                        }
                        str4 = "";
                        SignedInData signedInData2 = new SignedInData(str3, str4, new Date(), new SignInMethod.HostedUI(this.$browserPackage$inlined), fetchToken);
                        HostedUIEvent hostedUIEvent22 = new HostedUIEvent(HostedUIEvent.EventType.TokenFetched.INSTANCE, null, 2, null);
                        authEnvironment.getLogger().verbose(id + " Sending event " + hostedUIEvent22.getType());
                        eventDispatcher.send(hostedUIEvent22);
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignInCompleted(signedInData2, DeviceMetadata.Empty.INSTANCE), date, r1, b5 == true ? 1 : 0);
                        Logger logger22 = authEnvironment.getLogger();
                        StringBuilder m22 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                        m22.append(authenticationEvent.getType());
                        logger22.verbose(m22.toString());
                        eventDispatcher.send(authenticationEvent);
                        return Unit.INSTANCE;
                    }
                    str3 = "";
                    accessToken = fetchToken.getAccessToken();
                    if (accessToken != null) {
                        str4 = claim;
                        SignedInData signedInData22 = new SignedInData(str3, str4, new Date(), new SignInMethod.HostedUI(this.$browserPackage$inlined), fetchToken);
                        HostedUIEvent hostedUIEvent222 = new HostedUIEvent(HostedUIEvent.EventType.TokenFetched.INSTANCE, null, 2, null);
                        authEnvironment.getLogger().verbose(id + " Sending event " + hostedUIEvent222.getType());
                        eventDispatcher.send(hostedUIEvent222);
                        authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignInCompleted(signedInData22, DeviceMetadata.Empty.INSTANCE), date, r1, b5 == true ? 1 : 0);
                        Logger logger222 = authEnvironment.getLogger();
                        StringBuilder m222 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                        m222.append(authenticationEvent.getType());
                        logger222.verbose(m222.toString());
                        eventDispatcher.send(authenticationEvent);
                        return Unit.INSTANCE;
                    }
                    str4 = "";
                    SignedInData signedInData222 = new SignedInData(str3, str4, new Date(), new SignInMethod.HostedUI(this.$browserPackage$inlined), fetchToken);
                    HostedUIEvent hostedUIEvent2222 = new HostedUIEvent(HostedUIEvent.EventType.TokenFetched.INSTANCE, null, 2, null);
                    authEnvironment.getLogger().verbose(id + " Sending event " + hostedUIEvent2222.getType());
                    eventDispatcher.send(hostedUIEvent2222);
                    authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.SignInCompleted(signedInData222, DeviceMetadata.Empty.INSTANCE), date, r1, b5 == true ? 1 : 0);
                    Logger logger2222 = authEnvironment.getLogger();
                    StringBuilder m2222 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                    m2222.append(authenticationEvent.getType());
                    logger2222.verbose(m2222.toString());
                    eventDispatcher.send(authenticationEvent);
                    return Unit.INSTANCE;
                }
                throw new InvalidOauthConfigurationException();
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }

    @Override // com.amplifyframework.statemachine.codegen.actions.HostedUIActions
    public Action showHostedUI(final HostedUIEvent.EventType.ShowHostedUI event) {
        Intrinsics.checkNotNullParameter(event, "event");
        Action.Companion companion = Action.Companion;
        final String str = "InitHostedUIAuth";
        return new Action(str, event) { // from class: com.amplifyframework.auth.cognito.actions.HostedUICognitoActions$showHostedUI$$inlined$invoke$1
            final /* synthetic */ HostedUIEvent.EventType.ShowHostedUI $event$inlined;
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
                AuthCognitoActions$initializeAuthorizationConfigurationAction$$inlined$invoke$1$$ExternalSyntheticOutline0.m(id, " Starting execution", authEnvironment.getLogger());
                try {
                } catch (Exception e) {
                    HostedUIEvent hostedUIEvent = new HostedUIEvent(new HostedUIEvent.EventType.ThrowError(e), null, 2, null);
                    Logger logger = authEnvironment.getLogger();
                    StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                    m.append(hostedUIEvent.getType());
                    logger.verbose(m.toString());
                    eventDispatcher.send(hostedUIEvent);
                    AuthenticationEvent authenticationEvent = new AuthenticationEvent(new AuthenticationEvent.EventType.CancelSignIn(null, 1, 0 == true ? 1 : 0), 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
                    Logger logger2 = authEnvironment.getLogger();
                    StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(id, " Sending event ");
                    m2.append(authenticationEvent.getType());
                    logger2.verbose(m2.toString());
                    eventDispatcher.send(authenticationEvent);
                }
                if (authEnvironment.getHostedUIClient() != null) {
                    authEnvironment.getHostedUIClient().launchCustomTabsSignIn(this.$event$inlined.getHostedUISignInData().getHostedUIOptions());
                    return Unit.INSTANCE;
                }
                throw new InvalidOauthConfigurationException();
            }

            @Override // com.amplifyframework.statemachine.Action
            public String getId() {
                return this.id;
            }
        };
    }
}
