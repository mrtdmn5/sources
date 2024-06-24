package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.AuthConfiguration;
import com.amplifyframework.statemachine.codegen.data.DeviceMetadata;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.data.SignInData;
import com.amplifyframework.statemachine.codegen.data.SignOutData;
import com.amplifyframework.statemachine.codegen.data.SignedInData;
import com.amplifyframework.statemachine.codegen.data.SignedOutData;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthenticationEvent.kt */
/* loaded from: classes.dex */
public final class AuthenticationEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: AuthenticationEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class CancelSignIn extends EventType {
            private final Exception error;

            public CancelSignIn() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ CancelSignIn copy$default(CancelSignIn cancelSignIn, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = cancelSignIn.error;
                }
                return cancelSignIn.copy(exc);
            }

            public final Exception component1() {
                return this.error;
            }

            public final CancelSignIn copy(Exception exc) {
                return new CancelSignIn(exc);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof CancelSignIn) && Intrinsics.areEqual(this.error, ((CancelSignIn) obj).error)) {
                    return true;
                }
                return false;
            }

            public final Exception getError() {
                return this.error;
            }

            public int hashCode() {
                Exception exc = this.error;
                if (exc == null) {
                    return 0;
                }
                return exc.hashCode();
            }

            public String toString() {
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("CancelSignIn(error="), this.error, ')');
            }

            public CancelSignIn(Exception exc) {
                super(null);
                this.error = exc;
            }

            public /* synthetic */ CancelSignIn(Exception exc, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? null : exc);
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class CancelSignOut extends EventType {
            private final DeviceMetadata deviceMetadata;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CancelSignOut(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                this.signedInData = signedInData;
                this.deviceMetadata = deviceMetadata;
            }

            public static /* synthetic */ CancelSignOut copy$default(CancelSignOut cancelSignOut, SignedInData signedInData, DeviceMetadata deviceMetadata, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signedInData = cancelSignOut.signedInData;
                }
                if ((r3 & 2) != 0) {
                    deviceMetadata = cancelSignOut.deviceMetadata;
                }
                return cancelSignOut.copy(signedInData, deviceMetadata);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final DeviceMetadata component2() {
                return this.deviceMetadata;
            }

            public final CancelSignOut copy(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                return new CancelSignOut(signedInData, deviceMetadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CancelSignOut)) {
                    return false;
                }
                CancelSignOut cancelSignOut = (CancelSignOut) obj;
                if (Intrinsics.areEqual(this.signedInData, cancelSignOut.signedInData) && Intrinsics.areEqual(this.deviceMetadata, cancelSignOut.deviceMetadata)) {
                    return true;
                }
                return false;
            }

            public final DeviceMetadata getDeviceMetadata() {
                return this.deviceMetadata;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.deviceMetadata.hashCode() + (this.signedInData.hashCode() * 31);
            }

            public String toString() {
                return "CancelSignOut(signedInData=" + this.signedInData + ", deviceMetadata=" + this.deviceMetadata + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class ClearFederationToIdentityPool extends EventType {
            private final String id;

            public ClearFederationToIdentityPool() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ ClearFederationToIdentityPool copy$default(ClearFederationToIdentityPool clearFederationToIdentityPool, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = clearFederationToIdentityPool.id;
                }
                return clearFederationToIdentityPool.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final ClearFederationToIdentityPool copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new ClearFederationToIdentityPool(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ClearFederationToIdentityPool) && Intrinsics.areEqual(this.id, ((ClearFederationToIdentityPool) obj).id)) {
                    return true;
                }
                return false;
            }

            public final String getId() {
                return this.id;
            }

            public int hashCode() {
                return this.id.hashCode();
            }

            public String toString() {
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ClearFederationToIdentityPool(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ClearFederationToIdentityPool(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ ClearFederationToIdentityPool(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class Configure extends EventType {
            private final AuthConfiguration configuration;
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Configure(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.configuration = configuration;
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ Configure copy$default(Configure configure, AuthConfiguration authConfiguration, AmplifyCredential amplifyCredential, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    authConfiguration = configure.configuration;
                }
                if ((r3 & 2) != 0) {
                    amplifyCredential = configure.storedCredentials;
                }
                return configure.copy(authConfiguration, amplifyCredential);
            }

            public final AuthConfiguration component1() {
                return this.configuration;
            }

            public final AmplifyCredential component2() {
                return this.storedCredentials;
            }

            public final Configure copy(AuthConfiguration configuration, AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new Configure(configuration, storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Configure)) {
                    return false;
                }
                Configure configure = (Configure) obj;
                if (Intrinsics.areEqual(this.configuration, configure.configuration) && Intrinsics.areEqual(this.storedCredentials, configure.storedCredentials)) {
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
                return "Configure(configuration=" + this.configuration + ", storedCredentials=" + this.storedCredentials + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class Configured extends EventType {
            public static final Configured INSTANCE = new Configured();

            private Configured() {
                super(null);
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitializedFederated extends EventType {
            public static final InitializedFederated INSTANCE = new InitializedFederated();

            private InitializedFederated() {
                super(null);
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitializedSignedIn extends EventType {
            private final DeviceMetadata deviceMetadata;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitializedSignedIn(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                this.signedInData = signedInData;
                this.deviceMetadata = deviceMetadata;
            }

            public static /* synthetic */ InitializedSignedIn copy$default(InitializedSignedIn initializedSignedIn, SignedInData signedInData, DeviceMetadata deviceMetadata, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signedInData = initializedSignedIn.signedInData;
                }
                if ((r3 & 2) != 0) {
                    deviceMetadata = initializedSignedIn.deviceMetadata;
                }
                return initializedSignedIn.copy(signedInData, deviceMetadata);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final DeviceMetadata component2() {
                return this.deviceMetadata;
            }

            public final InitializedSignedIn copy(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                return new InitializedSignedIn(signedInData, deviceMetadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof InitializedSignedIn)) {
                    return false;
                }
                InitializedSignedIn initializedSignedIn = (InitializedSignedIn) obj;
                if (Intrinsics.areEqual(this.signedInData, initializedSignedIn.signedInData) && Intrinsics.areEqual(this.deviceMetadata, initializedSignedIn.deviceMetadata)) {
                    return true;
                }
                return false;
            }

            public final DeviceMetadata getDeviceMetadata() {
                return this.deviceMetadata;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.deviceMetadata.hashCode() + (this.signedInData.hashCode() * 31);
            }

            public String toString() {
                return "InitializedSignedIn(signedInData=" + this.signedInData + ", deviceMetadata=" + this.deviceMetadata + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class InitializedSignedOut extends EventType {
            private final SignedOutData signedOutData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitializedSignedOut(SignedOutData signedOutData) {
                super(null);
                Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
                this.signedOutData = signedOutData;
            }

            public static /* synthetic */ InitializedSignedOut copy$default(InitializedSignedOut initializedSignedOut, SignedOutData signedOutData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signedOutData = initializedSignedOut.signedOutData;
                }
                return initializedSignedOut.copy(signedOutData);
            }

            public final SignedOutData component1() {
                return this.signedOutData;
            }

            public final InitializedSignedOut copy(SignedOutData signedOutData) {
                Intrinsics.checkNotNullParameter(signedOutData, "signedOutData");
                return new InitializedSignedOut(signedOutData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof InitializedSignedOut) && Intrinsics.areEqual(this.signedOutData, ((InitializedSignedOut) obj).signedOutData)) {
                    return true;
                }
                return false;
            }

            public final SignedOutData getSignedOutData() {
                return this.signedOutData;
            }

            public int hashCode() {
                return this.signedOutData.hashCode();
            }

            public String toString() {
                return "InitializedSignedOut(signedOutData=" + this.signedOutData + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignInCompleted extends EventType {
            private final DeviceMetadata deviceMetadata;
            private final SignedInData signedInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignInCompleted(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                super(null);
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                this.signedInData = signedInData;
                this.deviceMetadata = deviceMetadata;
            }

            public static /* synthetic */ SignInCompleted copy$default(SignInCompleted signInCompleted, SignedInData signedInData, DeviceMetadata deviceMetadata, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    signedInData = signInCompleted.signedInData;
                }
                if ((r3 & 2) != 0) {
                    deviceMetadata = signInCompleted.deviceMetadata;
                }
                return signInCompleted.copy(signedInData, deviceMetadata);
            }

            public final SignedInData component1() {
                return this.signedInData;
            }

            public final DeviceMetadata component2() {
                return this.deviceMetadata;
            }

            public final SignInCompleted copy(SignedInData signedInData, DeviceMetadata deviceMetadata) {
                Intrinsics.checkNotNullParameter(signedInData, "signedInData");
                Intrinsics.checkNotNullParameter(deviceMetadata, "deviceMetadata");
                return new SignInCompleted(signedInData, deviceMetadata);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof SignInCompleted)) {
                    return false;
                }
                SignInCompleted signInCompleted = (SignInCompleted) obj;
                if (Intrinsics.areEqual(this.signedInData, signInCompleted.signedInData) && Intrinsics.areEqual(this.deviceMetadata, signInCompleted.deviceMetadata)) {
                    return true;
                }
                return false;
            }

            public final DeviceMetadata getDeviceMetadata() {
                return this.deviceMetadata;
            }

            public final SignedInData getSignedInData() {
                return this.signedInData;
            }

            public int hashCode() {
                return this.deviceMetadata.hashCode() + (this.signedInData.hashCode() * 31);
            }

            public String toString() {
                return "SignInCompleted(signedInData=" + this.signedInData + ", deviceMetadata=" + this.deviceMetadata + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignInRequested extends EventType {
            private final SignInData signInData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignInRequested(SignInData signInData) {
                super(null);
                Intrinsics.checkNotNullParameter(signInData, "signInData");
                this.signInData = signInData;
            }

            public static /* synthetic */ SignInRequested copy$default(SignInRequested signInRequested, SignInData signInData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signInData = signInRequested.signInData;
                }
                return signInRequested.copy(signInData);
            }

            public final SignInData component1() {
                return this.signInData;
            }

            public final SignInRequested copy(SignInData signInData) {
                Intrinsics.checkNotNullParameter(signInData, "signInData");
                return new SignInRequested(signInData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof SignInRequested) && Intrinsics.areEqual(this.signInData, ((SignInRequested) obj).signInData)) {
                    return true;
                }
                return false;
            }

            public final SignInData getSignInData() {
                return this.signInData;
            }

            public int hashCode() {
                return this.signInData.hashCode();
            }

            public String toString() {
                return "SignInRequested(signInData=" + this.signInData + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class SignOutRequested extends EventType {
            private final SignOutData signOutData;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SignOutRequested(SignOutData signOutData) {
                super(null);
                Intrinsics.checkNotNullParameter(signOutData, "signOutData");
                this.signOutData = signOutData;
            }

            public static /* synthetic */ SignOutRequested copy$default(SignOutRequested signOutRequested, SignOutData signOutData, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    signOutData = signOutRequested.signOutData;
                }
                return signOutRequested.copy(signOutData);
            }

            public final SignOutData component1() {
                return this.signOutData;
            }

            public final SignOutRequested copy(SignOutData signOutData) {
                Intrinsics.checkNotNullParameter(signOutData, "signOutData");
                return new SignOutRequested(signOutData);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof SignOutRequested) && Intrinsics.areEqual(this.signOutData, ((SignOutRequested) obj).signOutData)) {
                    return true;
                }
                return false;
            }

            public final SignOutData getSignOutData() {
                return this.signOutData;
            }

            public int hashCode() {
                return this.signOutData.hashCode();
            }

            public String toString() {
                return "SignOutRequested(signOutData=" + this.signOutData + ')';
            }
        }

        /* compiled from: AuthenticationEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowError extends EventType {
            private final Exception exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowError(Exception exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public static /* synthetic */ ThrowError copy$default(ThrowError throwError, Exception exc, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    exc = throwError.exception;
                }
                return throwError.copy(exc);
            }

            public final Exception component1() {
                return this.exception;
            }

            public final ThrowError copy(Exception exception) {
                Intrinsics.checkNotNullParameter(exception, "exception");
                return new ThrowError(exception);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowError) && Intrinsics.areEqual(this.exception, ((ThrowError) obj).exception)) {
                    return true;
                }
                return false;
            }

            public final Exception getException() {
                return this.exception;
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(new StringBuilder("ThrowError(exception="), this.exception, ')');
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public AuthenticationEvent(EventType eventType, Date date) {
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

    public /* synthetic */ AuthenticationEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
