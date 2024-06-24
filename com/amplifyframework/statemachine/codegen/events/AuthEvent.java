package com.amplifyframework.statemachine.codegen.events;

import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthEvent.kt */
/* loaded from: classes.dex */
public final class AuthEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: AuthEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class CachedCredentialsFailed extends EventType {
            public static final CachedCredentialsFailed INSTANCE = new CachedCredentialsFailed();

            private CachedCredentialsFailed() {
                super(null);
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfigureAuth extends EventType {
            private final AuthConfiguration configuration;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfigureAuth(AuthConfiguration configuration) {
                super(null);
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                this.configuration = configuration;
            }

            public static /* synthetic */ ConfigureAuth copy$default(ConfigureAuth configureAuth, AuthConfiguration authConfiguration, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    authConfiguration = configureAuth.configuration;
                }
                return configureAuth.copy(authConfiguration);
            }

            public final AuthConfiguration component1() {
                return this.configuration;
            }

            public final ConfigureAuth copy(AuthConfiguration configuration) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                return new ConfigureAuth(configuration);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ConfigureAuth) && Intrinsics.areEqual(this.configuration, ((ConfigureAuth) obj).configuration)) {
                    return true;
                }
                return false;
            }

            public final AuthConfiguration getConfiguration() {
                return this.configuration;
            }

            public int hashCode() {
                return this.configuration.hashCode();
            }

            public String toString() {
                return "ConfigureAuth(configuration=" + this.configuration + ')';
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfigureAuthentication extends EventType {
            private final AuthConfiguration configuration;
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfigureAuthentication(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.configuration = configuration;
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ ConfigureAuthentication copy$default(ConfigureAuthentication configureAuthentication, AuthConfiguration authConfiguration, AmplifyCredential amplifyCredential, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    authConfiguration = configureAuthentication.configuration;
                }
                if ((r3 & 2) != 0) {
                    amplifyCredential = configureAuthentication.storedCredentials;
                }
                return configureAuthentication.copy(authConfiguration, amplifyCredential);
            }

            public final AuthConfiguration component1() {
                return this.configuration;
            }

            public final AmplifyCredential component2() {
                return this.storedCredentials;
            }

            public final ConfigureAuthentication copy(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new ConfigureAuthentication(configuration, storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConfigureAuthentication)) {
                    return false;
                }
                ConfigureAuthentication configureAuthentication = (ConfigureAuthentication) obj;
                if (Intrinsics.areEqual(this.configuration, configureAuthentication.configuration) && Intrinsics.areEqual(this.storedCredentials, configureAuthentication.storedCredentials)) {
                    return true;
                }
                return false;
            }

            public final AuthConfiguration getConfiguration() {
                return this.configuration;
            }

            public final AmplifyCredential getStoredCredentials() {
                return this.storedCredentials;
            }

            public int hashCode() {
                return this.storedCredentials.hashCode() + (this.configuration.hashCode() * 31);
            }

            public String toString() {
                return "ConfigureAuthentication(configuration=" + this.configuration + ", storedCredentials=" + this.storedCredentials + ')';
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfigureAuthorization extends EventType {
            private final AuthConfiguration configuration;
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfigureAuthorization(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.configuration = configuration;
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ ConfigureAuthorization copy$default(ConfigureAuthorization configureAuthorization, AuthConfiguration authConfiguration, AmplifyCredential amplifyCredential, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    authConfiguration = configureAuthorization.configuration;
                }
                if ((r3 & 2) != 0) {
                    amplifyCredential = configureAuthorization.storedCredentials;
                }
                return configureAuthorization.copy(authConfiguration, amplifyCredential);
            }

            public final AuthConfiguration component1() {
                return this.configuration;
            }

            public final AmplifyCredential component2() {
                return this.storedCredentials;
            }

            public final ConfigureAuthorization copy(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new ConfigureAuthorization(configuration, storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConfigureAuthorization)) {
                    return false;
                }
                ConfigureAuthorization configureAuthorization = (ConfigureAuthorization) obj;
                if (Intrinsics.areEqual(this.configuration, configureAuthorization.configuration) && Intrinsics.areEqual(this.storedCredentials, configureAuthorization.storedCredentials)) {
                    return true;
                }
                return false;
            }

            public final AuthConfiguration getConfiguration() {
                return this.configuration;
            }

            public final AmplifyCredential getStoredCredentials() {
                return this.storedCredentials;
            }

            public int hashCode() {
                return this.storedCredentials.hashCode() + (this.configuration.hashCode() * 31);
            }

            public String toString() {
                return "ConfigureAuthorization(configuration=" + this.configuration + ", storedCredentials=" + this.storedCredentials + ')';
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfiguredAuthentication extends EventType {
            private final AuthConfiguration configuration;
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ConfiguredAuthentication(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.configuration = configuration;
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ ConfiguredAuthentication copy$default(ConfiguredAuthentication configuredAuthentication, AuthConfiguration authConfiguration, AmplifyCredential amplifyCredential, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    authConfiguration = configuredAuthentication.configuration;
                }
                if ((r3 & 2) != 0) {
                    amplifyCredential = configuredAuthentication.storedCredentials;
                }
                return configuredAuthentication.copy(authConfiguration, amplifyCredential);
            }

            public final AuthConfiguration component1() {
                return this.configuration;
            }

            public final AmplifyCredential component2() {
                return this.storedCredentials;
            }

            public final ConfiguredAuthentication copy(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new ConfiguredAuthentication(configuration, storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ConfiguredAuthentication)) {
                    return false;
                }
                ConfiguredAuthentication configuredAuthentication = (ConfiguredAuthentication) obj;
                if (Intrinsics.areEqual(this.configuration, configuredAuthentication.configuration) && Intrinsics.areEqual(this.storedCredentials, configuredAuthentication.storedCredentials)) {
                    return true;
                }
                return false;
            }

            public final AuthConfiguration getConfiguration() {
                return this.configuration;
            }

            public final AmplifyCredential getStoredCredentials() {
                return this.storedCredentials;
            }

            public int hashCode() {
                return this.storedCredentials.hashCode() + (this.configuration.hashCode() * 31);
            }

            public String toString() {
                return "ConfiguredAuthentication(configuration=" + this.configuration + ", storedCredentials=" + this.storedCredentials + ')';
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ConfiguredAuthorization extends EventType {
            public static final ConfiguredAuthorization INSTANCE = new ConfiguredAuthorization();

            private ConfiguredAuthorization() {
                super(null);
            }
        }

        /* compiled from: AuthEvent.kt */
        /* loaded from: classes.dex */
        public static final class ReceivedCachedCredentials extends EventType {
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReceivedCachedCredentials(AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ ReceivedCachedCredentials copy$default(ReceivedCachedCredentials receivedCachedCredentials, AmplifyCredential amplifyCredential, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    amplifyCredential = receivedCachedCredentials.storedCredentials;
                }
                return receivedCachedCredentials.copy(amplifyCredential);
            }

            public final AmplifyCredential component1() {
                return this.storedCredentials;
            }

            public final ReceivedCachedCredentials copy(AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new ReceivedCachedCredentials(storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ReceivedCachedCredentials) && Intrinsics.areEqual(this.storedCredentials, ((ReceivedCachedCredentials) obj).storedCredentials)) {
                    return true;
                }
                return false;
            }

            public final AmplifyCredential getStoredCredentials() {
                return this.storedCredentials;
            }

            public int hashCode() {
                return this.storedCredentials.hashCode();
            }

            public String toString() {
                return "ReceivedCachedCredentials(storedCredentials=" + this.storedCredentials + ')';
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public AuthEvent(EventType eventType, Date date) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.time = date;
        this.type = eventType.getClass().getSimpleName();
    }

    public final EventType getEventType() {
        return this.eventType;
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public String getId() {
        return StateMachineEvent.DefaultImpls.getId(this);
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public Date getTime() {
        return this.time;
    }

    @Override // com.amplifyframework.statemachine.StateMachineEvent
    public String getType() {
        return this.type;
    }

    public /* synthetic */ AuthEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
