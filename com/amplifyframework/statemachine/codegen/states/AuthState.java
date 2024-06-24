package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.auth.cognito.AuthEnvironmentKt;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.AuthActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.AuthEvent;
import com.amplifyframework.statemachine.codegen.states.AuthenticationState;
import com.amplifyframework.statemachine.codegen.states.AuthorizationState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthState.kt */
/* loaded from: classes.dex */
public abstract class AuthState implements State {
    private AuthenticationState authNState;
    private AuthorizationState authZState;

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class Builder implements com.amplifyframework.statemachine.Builder<AuthState> {
        private AuthenticationState authNState;
        private final AuthState authState;
        private AuthorizationState authZState;

        public Builder(AuthState authState) {
            Intrinsics.checkNotNullParameter(authState, "authState");
            this.authState = authState;
        }

        public final AuthenticationState getAuthNState() {
            return this.authNState;
        }

        public final AuthorizationState getAuthZState() {
            return this.authZState;
        }

        public final void setAuthNState(AuthenticationState authenticationState) {
            this.authNState = authenticationState;
        }

        public final void setAuthZState(AuthorizationState authorizationState) {
            this.authZState = authorizationState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.statemachine.Builder
        public AuthState build() {
            AuthState authState = this.authState;
            return authState instanceof ConfiguringAuthentication ? new ConfiguringAuthentication(this.authNState) : authState instanceof ConfiguringAuthorization ? new ConfiguringAuthorization(this.authNState, this.authZState) : authState instanceof Configured ? new Configured(this.authNState, this.authZState) : authState;
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class Configured extends AuthState {
        private AuthenticationState authNState;
        private AuthorizationState authZState;

        public Configured(AuthenticationState authenticationState, AuthorizationState authorizationState) {
            super(null);
            this.authNState = authenticationState;
            this.authZState = authorizationState;
        }

        public static /* synthetic */ Configured copy$default(Configured configured, AuthenticationState authenticationState, AuthorizationState authorizationState, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                authenticationState = configured.getAuthNState();
            }
            if ((r3 & 2) != 0) {
                authorizationState = configured.getAuthZState();
            }
            return configured.copy(authenticationState, authorizationState);
        }

        public final AuthenticationState component1() {
            return getAuthNState();
        }

        public final AuthorizationState component2() {
            return getAuthZState();
        }

        public final Configured copy(AuthenticationState authenticationState, AuthorizationState authorizationState) {
            return new Configured(authenticationState, authorizationState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configured)) {
                return false;
            }
            Configured configured = (Configured) obj;
            if (Intrinsics.areEqual(getAuthNState(), configured.getAuthNState()) && Intrinsics.areEqual(getAuthZState(), configured.getAuthZState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public AuthenticationState getAuthNState() {
            return this.authNState;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public AuthorizationState getAuthZState() {
            return this.authZState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            int hashCode;
            int r1 = 0;
            if (getAuthNState() == null) {
                hashCode = 0;
            } else {
                hashCode = getAuthNState().hashCode();
            }
            int r0 = hashCode * 31;
            if (getAuthZState() != null) {
                r1 = getAuthZState().hashCode();
            }
            return r0 + r1;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public void setAuthNState(AuthenticationState authenticationState) {
            this.authNState = authenticationState;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public void setAuthZState(AuthorizationState authorizationState) {
            this.authZState = authorizationState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "Configured(authNState=" + getAuthNState() + ", authZState=" + getAuthZState() + ')';
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class ConfiguringAuth extends AuthState {
        private final String id;

        public ConfiguringAuth() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ConfiguringAuth copy$default(ConfiguringAuth configuringAuth, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = configuringAuth.id;
            }
            return configuringAuth.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final ConfiguringAuth copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new ConfiguringAuth(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ConfiguringAuth) && Intrinsics.areEqual(this.id, ((ConfiguringAuth) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ConfiguringAuth(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfiguringAuth(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ ConfiguringAuth(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class ConfiguringAuthentication extends AuthState {
        private AuthenticationState authNState;

        public ConfiguringAuthentication(AuthenticationState authenticationState) {
            super(null);
            this.authNState = authenticationState;
        }

        public static /* synthetic */ ConfiguringAuthentication copy$default(ConfiguringAuthentication configuringAuthentication, AuthenticationState authenticationState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                authenticationState = configuringAuthentication.getAuthNState();
            }
            return configuringAuthentication.copy(authenticationState);
        }

        public final AuthenticationState component1() {
            return getAuthNState();
        }

        public final ConfiguringAuthentication copy(AuthenticationState authenticationState) {
            return new ConfiguringAuthentication(authenticationState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ConfiguringAuthentication) && Intrinsics.areEqual(getAuthNState(), ((ConfiguringAuthentication) obj).getAuthNState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public AuthenticationState getAuthNState() {
            return this.authNState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getAuthNState() == null) {
                return 0;
            }
            return getAuthNState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public void setAuthNState(AuthenticationState authenticationState) {
            this.authNState = authenticationState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "ConfiguringAuthentication(authNState=" + getAuthNState() + ')';
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class ConfiguringAuthorization extends AuthState {
        private AuthenticationState authNState;
        private AuthorizationState authZState;

        public ConfiguringAuthorization(AuthenticationState authenticationState, AuthorizationState authorizationState) {
            super(null);
            this.authNState = authenticationState;
            this.authZState = authorizationState;
        }

        public static /* synthetic */ ConfiguringAuthorization copy$default(ConfiguringAuthorization configuringAuthorization, AuthenticationState authenticationState, AuthorizationState authorizationState, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                authenticationState = configuringAuthorization.getAuthNState();
            }
            if ((r3 & 2) != 0) {
                authorizationState = configuringAuthorization.getAuthZState();
            }
            return configuringAuthorization.copy(authenticationState, authorizationState);
        }

        public final AuthenticationState component1() {
            return getAuthNState();
        }

        public final AuthorizationState component2() {
            return getAuthZState();
        }

        public final ConfiguringAuthorization copy(AuthenticationState authenticationState, AuthorizationState authorizationState) {
            return new ConfiguringAuthorization(authenticationState, authorizationState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConfiguringAuthorization)) {
                return false;
            }
            ConfiguringAuthorization configuringAuthorization = (ConfiguringAuthorization) obj;
            if (Intrinsics.areEqual(getAuthNState(), configuringAuthorization.getAuthNState()) && Intrinsics.areEqual(getAuthZState(), configuringAuthorization.getAuthZState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public AuthenticationState getAuthNState() {
            return this.authNState;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public AuthorizationState getAuthZState() {
            return this.authZState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            int hashCode;
            int r1 = 0;
            if (getAuthNState() == null) {
                hashCode = 0;
            } else {
                hashCode = getAuthNState().hashCode();
            }
            int r0 = hashCode * 31;
            if (getAuthZState() != null) {
                r1 = getAuthZState().hashCode();
            }
            return r0 + r1;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public void setAuthNState(AuthenticationState authenticationState) {
            this.authNState = authenticationState;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.AuthState
        public void setAuthZState(AuthorizationState authorizationState) {
            this.authZState = authorizationState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "ConfiguringAuthorization(authNState=" + getAuthNState() + ", authZState=" + getAuthZState() + ')';
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends AuthState {
        private final Exception exception;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Exception exception) {
            super(null);
            Intrinsics.checkNotNullParameter(exception, "exception");
            this.exception = exception;
        }

        public static /* synthetic */ Error copy$default(Error error, Exception exc, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                exc = error.exception;
            }
            return error.copy(exc);
        }

        public final Exception component1() {
            return this.exception;
        }

        public final Error copy(Exception exception) {
            Intrinsics.checkNotNullParameter(exception, "exception");
            return new Error(exception);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Error) && Intrinsics.areEqual(this.exception, ((Error) obj).exception)) {
                return true;
            }
            return false;
        }

        public final Exception getException() {
            return this.exception;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.exception.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("Error(exception="), this.exception, ')');
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class NotConfigured extends AuthState {
        private final String id;

        public NotConfigured() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NotConfigured copy$default(NotConfigured notConfigured, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = notConfigured.id;
            }
            return notConfigured.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final NotConfigured copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new NotConfigured(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof NotConfigured) && Intrinsics.areEqual(this.id, ((NotConfigured) obj).id)) {
                return true;
            }
            return false;
        }

        public final String getId() {
            return this.id;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.id.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("NotConfigured(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotConfigured(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ NotConfigured(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: AuthState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<AuthState> {
        private final AuthActions authActions;
        private final StateMachineResolver<AuthenticationState> authNResolver;
        private final StateMachineResolver<AuthorizationState> authZResolver;
        private final NotConfigured defaultState;

        public Resolver(StateMachineResolver<AuthenticationState> authNResolver, StateMachineResolver<AuthorizationState> authZResolver, AuthActions authActions) {
            Intrinsics.checkNotNullParameter(authNResolver, "authNResolver");
            Intrinsics.checkNotNullParameter(authZResolver, "authZResolver");
            Intrinsics.checkNotNullParameter(authActions, "authActions");
            this.authNResolver = authNResolver;
            this.authZResolver = authZResolver;
            this.authActions = authActions;
            this.defaultState = new NotConfigured(null, 1, 0 == true ? 1 : 0);
        }

        private final StateResolution<AuthState> resolveAuthEvent(AuthState authState, StateMachineEvent stateMachineEvent) {
            AuthEvent.EventType isAuthEvent = AuthEnvironmentKt.isAuthEvent(stateMachineEvent);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            byte b7 = 0;
            byte b8 = 0;
            byte b9 = 0;
            StateResolution<AuthState> stateResolution = new StateResolution<>(authState, null, 2, null);
            int r4 = 1;
            if (authState instanceof NotConfigured) {
                if (isAuthEvent instanceof AuthEvent.EventType.ConfigureAuth) {
                    return new StateResolution<>(new ConfiguringAuth(str, r4, b9 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.authActions.initializeAuthConfigurationAction((AuthEvent.EventType.ConfigureAuth) isAuthEvent)));
                }
                return stateResolution;
            }
            if (authState instanceof ConfiguringAuth) {
                if (isAuthEvent instanceof AuthEvent.EventType.ConfigureAuthentication) {
                    return new StateResolution<>(new ConfiguringAuthentication(new AuthenticationState.NotConfigured(b8 == true ? 1 : 0, r4, b7 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authActions.initializeAuthenticationConfigurationAction((AuthEvent.EventType.ConfigureAuthentication) isAuthEvent)));
                }
                if (isAuthEvent instanceof AuthEvent.EventType.ConfigureAuthorization) {
                    return new StateResolution<>(new ConfiguringAuthorization(new AuthenticationState.NotConfigured(b6 == true ? 1 : 0, r4, b5 == true ? 1 : 0), new AuthorizationState.NotConfigured(b4 == true ? 1 : 0, r4, b3 == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authActions.initializeAuthorizationConfigurationAction(isAuthEvent)));
                }
                return stateResolution;
            }
            if (authState instanceof ConfiguringAuthentication) {
                if (isAuthEvent instanceof AuthEvent.EventType.ConfiguredAuthentication) {
                    return new StateResolution<>(new ConfiguringAuthorization(authState.getAuthNState(), new AuthorizationState.NotConfigured(b2 == true ? 1 : 0, r4, b == true ? 1 : 0)), CollectionsKt__CollectionsKt.listOf(this.authActions.initializeAuthorizationConfigurationAction(isAuthEvent)));
                }
                return stateResolution;
            }
            if ((authState instanceof ConfiguringAuthorization) && (isAuthEvent instanceof AuthEvent.EventType.ConfiguredAuthorization)) {
                return new StateResolution<>(new Configured(authState.getAuthNState(), authState.getAuthZState()), null, 2, null);
            }
            return stateResolution;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<AuthState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<AuthState, StateMachineResolver<AuthState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AuthState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<AuthState> resolve(AuthState oldState, StateMachineEvent event) {
            StateResolution<AuthorizationState> resolve;
            StateResolution<AuthenticationState> resolve2;
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            StateResolution<AuthState> resolveAuthEvent = resolveAuthEvent(oldState, event);
            ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) resolveAuthEvent.getActions());
            Builder builder = new Builder(resolveAuthEvent.getNewState());
            AuthenticationState authNState = oldState.getAuthNState();
            if (authNState != null && (resolve2 = this.authNResolver.resolve(authNState, event)) != null) {
                builder.setAuthNState(resolve2.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve2.getActions(), mutableList);
            }
            AuthorizationState authZState = oldState.getAuthZState();
            if (authZState != null && (resolve = this.authZResolver.resolve(authZState, event)) != null) {
                builder.setAuthZState(resolve.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve.getActions(), mutableList);
            }
            return new StateResolution<>(builder.build(), mutableList);
        }
    }

    public /* synthetic */ AuthState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public AuthenticationState getAuthNState() {
        return this.authNState;
    }

    public AuthorizationState getAuthZState() {
        return this.authZState;
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    public void setAuthNState(AuthenticationState authenticationState) {
        this.authNState = authenticationState;
    }

    public void setAuthZState(AuthorizationState authorizationState) {
        this.authZState = authorizationState;
    }

    private AuthState() {
        int r2 = 1;
        this.authNState = new AuthenticationState.NotConfigured(null, r2, 0 == true ? 1 : 0);
        this.authZState = new AuthorizationState.NotConfigured(0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);
    }
}
