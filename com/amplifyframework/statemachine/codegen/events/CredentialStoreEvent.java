package com.amplifyframework.statemachine.codegen.events;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.data.CredentialType;
import com.amplifyframework.statemachine.codegen.errors.CredentialStoreError;
import java.util.Date;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreEvent.kt */
/* loaded from: classes.dex */
public final class CredentialStoreEvent implements StateMachineEvent {
    private final EventType eventType;
    private final Date time;
    private final String type;

    /* compiled from: CredentialStoreEvent.kt */
    /* loaded from: classes.dex */
    public static abstract class EventType {

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class ClearCredentialStore extends EventType {
            private final CredentialType credentialType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ClearCredentialStore(CredentialType credentialType) {
                super(null);
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                this.credentialType = credentialType;
            }

            public static /* synthetic */ ClearCredentialStore copy$default(ClearCredentialStore clearCredentialStore, CredentialType credentialType, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    credentialType = clearCredentialStore.credentialType;
                }
                return clearCredentialStore.copy(credentialType);
            }

            public final CredentialType component1() {
                return this.credentialType;
            }

            public final ClearCredentialStore copy(CredentialType credentialType) {
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                return new ClearCredentialStore(credentialType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ClearCredentialStore) && Intrinsics.areEqual(this.credentialType, ((ClearCredentialStore) obj).credentialType)) {
                    return true;
                }
                return false;
            }

            public final CredentialType getCredentialType() {
                return this.credentialType;
            }

            public int hashCode() {
                return this.credentialType.hashCode();
            }

            public String toString() {
                return "ClearCredentialStore(credentialType=" + this.credentialType + ')';
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class CompletedOperation extends EventType {
            private final AmplifyCredential storedCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CompletedOperation(AmplifyCredential storedCredentials) {
                super(null);
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                this.storedCredentials = storedCredentials;
            }

            public static /* synthetic */ CompletedOperation copy$default(CompletedOperation completedOperation, AmplifyCredential amplifyCredential, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    amplifyCredential = completedOperation.storedCredentials;
                }
                return completedOperation.copy(amplifyCredential);
            }

            public final AmplifyCredential component1() {
                return this.storedCredentials;
            }

            public final CompletedOperation copy(AmplifyCredential storedCredentials) {
                Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
                return new CompletedOperation(storedCredentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof CompletedOperation) && Intrinsics.areEqual(this.storedCredentials, ((CompletedOperation) obj).storedCredentials)) {
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
                return "CompletedOperation(storedCredentials=" + this.storedCredentials + ')';
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class LoadCredentialStore extends EventType {
            private final CredentialType credentialType;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadCredentialStore(CredentialType credentialType) {
                super(null);
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                this.credentialType = credentialType;
            }

            public static /* synthetic */ LoadCredentialStore copy$default(LoadCredentialStore loadCredentialStore, CredentialType credentialType, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    credentialType = loadCredentialStore.credentialType;
                }
                return loadCredentialStore.copy(credentialType);
            }

            public final CredentialType component1() {
                return this.credentialType;
            }

            public final LoadCredentialStore copy(CredentialType credentialType) {
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                return new LoadCredentialStore(credentialType);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof LoadCredentialStore) && Intrinsics.areEqual(this.credentialType, ((LoadCredentialStore) obj).credentialType)) {
                    return true;
                }
                return false;
            }

            public final CredentialType getCredentialType() {
                return this.credentialType;
            }

            public int hashCode() {
                return this.credentialType.hashCode();
            }

            public String toString() {
                return "LoadCredentialStore(credentialType=" + this.credentialType + ')';
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class MigrateLegacyCredentialStore extends EventType {
            private final String id;

            public MigrateLegacyCredentialStore() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ MigrateLegacyCredentialStore copy$default(MigrateLegacyCredentialStore migrateLegacyCredentialStore, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = migrateLegacyCredentialStore.id;
                }
                return migrateLegacyCredentialStore.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final MigrateLegacyCredentialStore copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new MigrateLegacyCredentialStore(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof MigrateLegacyCredentialStore) && Intrinsics.areEqual(this.id, ((MigrateLegacyCredentialStore) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("MigrateLegacyCredentialStore(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MigrateLegacyCredentialStore(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ MigrateLegacyCredentialStore(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class MoveToIdleState extends EventType {
            private final String id;

            public MoveToIdleState() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public static /* synthetic */ MoveToIdleState copy$default(MoveToIdleState moveToIdleState, String str, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    str = moveToIdleState.id;
                }
                return moveToIdleState.copy(str);
            }

            public final String component1() {
                return this.id;
            }

            public final MoveToIdleState copy(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                return new MoveToIdleState(id);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof MoveToIdleState) && Intrinsics.areEqual(this.id, ((MoveToIdleState) obj).id)) {
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
                return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("MoveToIdleState(id="), this.id, ')');
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MoveToIdleState(String id) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
            }

            public /* synthetic */ MoveToIdleState(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
                this((r2 & 1) != 0 ? "" : str);
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class StoreCredentials extends EventType {
            private final CredentialType credentialType;
            private final AmplifyCredential credentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public StoreCredentials(CredentialType credentialType, AmplifyCredential credentials) {
                super(null);
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                Intrinsics.checkNotNullParameter(credentials, "credentials");
                this.credentialType = credentialType;
                this.credentials = credentials;
            }

            public static /* synthetic */ StoreCredentials copy$default(StoreCredentials storeCredentials, CredentialType credentialType, AmplifyCredential amplifyCredential, int r3, Object obj) {
                if ((r3 & 1) != 0) {
                    credentialType = storeCredentials.credentialType;
                }
                if ((r3 & 2) != 0) {
                    amplifyCredential = storeCredentials.credentials;
                }
                return storeCredentials.copy(credentialType, amplifyCredential);
            }

            public final CredentialType component1() {
                return this.credentialType;
            }

            public final AmplifyCredential component2() {
                return this.credentials;
            }

            public final StoreCredentials copy(CredentialType credentialType, AmplifyCredential credentials) {
                Intrinsics.checkNotNullParameter(credentialType, "credentialType");
                Intrinsics.checkNotNullParameter(credentials, "credentials");
                return new StoreCredentials(credentialType, credentials);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof StoreCredentials)) {
                    return false;
                }
                StoreCredentials storeCredentials = (StoreCredentials) obj;
                if (Intrinsics.areEqual(this.credentialType, storeCredentials.credentialType) && Intrinsics.areEqual(this.credentials, storeCredentials.credentials)) {
                    return true;
                }
                return false;
            }

            public final CredentialType getCredentialType() {
                return this.credentialType;
            }

            public final AmplifyCredential getCredentials() {
                return this.credentials;
            }

            public int hashCode() {
                return this.credentials.hashCode() + (this.credentialType.hashCode() * 31);
            }

            public String toString() {
                return "StoreCredentials(credentialType=" + this.credentialType + ", credentials=" + this.credentials + ')';
            }
        }

        /* compiled from: CredentialStoreEvent.kt */
        /* loaded from: classes.dex */
        public static final class ThrowError extends EventType {
            private final CredentialStoreError error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThrowError(CredentialStoreError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public static /* synthetic */ ThrowError copy$default(ThrowError throwError, CredentialStoreError credentialStoreError, int r2, Object obj) {
                if ((r2 & 1) != 0) {
                    credentialStoreError = throwError.error;
                }
                return throwError.copy(credentialStoreError);
            }

            public final CredentialStoreError component1() {
                return this.error;
            }

            public final ThrowError copy(CredentialStoreError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new ThrowError(error);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if ((obj instanceof ThrowError) && Intrinsics.areEqual(this.error, ((ThrowError) obj).error)) {
                    return true;
                }
                return false;
            }

            public final CredentialStoreError getError() {
                return this.error;
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "ThrowError(error=" + this.error + ')';
            }
        }

        public /* synthetic */ EventType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private EventType() {
        }
    }

    public CredentialStoreEvent(EventType eventType, Date date) {
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

    public /* synthetic */ CredentialStoreEvent(EventType eventType, Date date, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(eventType, (r3 & 2) != 0 ? null : date);
    }
}
