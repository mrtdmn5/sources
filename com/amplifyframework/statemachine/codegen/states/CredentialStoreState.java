package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.CredentialStoreActions;
import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import com.amplifyframework.statemachine.codegen.errors.CredentialStoreError;
import com.amplifyframework.statemachine.codegen.events.CredentialStoreEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreState.kt */
/* loaded from: classes.dex */
public abstract class CredentialStoreState implements State {
    private final String type;

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class ClearingCredentials extends CredentialStoreState {
        private final String id;

        public ClearingCredentials() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ClearingCredentials copy$default(ClearingCredentials clearingCredentials, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = clearingCredentials.id;
            }
            return clearingCredentials.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final ClearingCredentials copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new ClearingCredentials(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ClearingCredentials) && Intrinsics.areEqual(this.id, ((ClearingCredentials) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ClearingCredentials(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ClearingCredentials(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ ClearingCredentials(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends CredentialStoreState {
        private final CredentialStoreError error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(CredentialStoreError error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        public static /* synthetic */ Error copy$default(Error error, CredentialStoreError credentialStoreError, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                credentialStoreError = error.error;
            }
            return error.copy(credentialStoreError);
        }

        public final CredentialStoreError component1() {
            return this.error;
        }

        public final Error copy(CredentialStoreError error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Error(error);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Error) && Intrinsics.areEqual(this.error, ((Error) obj).error)) {
                return true;
            }
            return false;
        }

        public final CredentialStoreError getError() {
            return this.error;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.error.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "Error(error=" + this.error + ')';
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class Idle extends CredentialStoreState {
        private final String id;

        public Idle() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Idle copy$default(Idle idle, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = idle.id;
            }
            return idle.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Idle copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Idle(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Idle) && Intrinsics.areEqual(this.id, ((Idle) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Idle(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Idle(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Idle(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class LoadingStoredCredentials extends CredentialStoreState {
        private final String id;

        public LoadingStoredCredentials() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ LoadingStoredCredentials copy$default(LoadingStoredCredentials loadingStoredCredentials, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = loadingStoredCredentials.id;
            }
            return loadingStoredCredentials.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final LoadingStoredCredentials copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new LoadingStoredCredentials(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof LoadingStoredCredentials) && Intrinsics.areEqual(this.id, ((LoadingStoredCredentials) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("LoadingStoredCredentials(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingStoredCredentials(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ LoadingStoredCredentials(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class MigratingLegacyStore extends CredentialStoreState {
        private final String id;

        public MigratingLegacyStore() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ MigratingLegacyStore copy$default(MigratingLegacyStore migratingLegacyStore, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = migratingLegacyStore.id;
            }
            return migratingLegacyStore.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final MigratingLegacyStore copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new MigratingLegacyStore(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof MigratingLegacyStore) && Intrinsics.areEqual(this.id, ((MigratingLegacyStore) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("MigratingLegacyStore(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MigratingLegacyStore(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ MigratingLegacyStore(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class NotConfigured extends CredentialStoreState {
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

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<CredentialStoreState> {
        private final CredentialStoreActions credentialStoreActions;
        private final NotConfigured defaultState;

        public Resolver(CredentialStoreActions credentialStoreActions) {
            Intrinsics.checkNotNullParameter(credentialStoreActions, "credentialStoreActions");
            this.credentialStoreActions = credentialStoreActions;
            this.defaultState = new NotConfigured(null, 1, 0 == true ? 1 : 0);
        }

        private final CredentialStoreEvent.EventType asCredentialStoreEvent(StateMachineEvent stateMachineEvent) {
            CredentialStoreEvent credentialStoreEvent;
            if (stateMachineEvent instanceof CredentialStoreEvent) {
                credentialStoreEvent = (CredentialStoreEvent) stateMachineEvent;
            } else {
                credentialStoreEvent = null;
            }
            if (credentialStoreEvent == null) {
                return null;
            }
            return credentialStoreEvent.getEventType();
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<CredentialStoreState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<CredentialStoreState, StateMachineResolver<CredentialStoreState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public CredentialStoreState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<CredentialStoreState> resolve(CredentialStoreState oldState, StateMachineEvent event) {
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
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
            byte b10 = 0;
            byte b11 = 0;
            StateResolution<CredentialStoreState> stateResolution = new StateResolution<>(oldState, null, 2, null);
            CredentialStoreEvent.EventType asCredentialStoreEvent = asCredentialStoreEvent(event);
            int r4 = 1;
            if (oldState instanceof NotConfigured) {
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.MigrateLegacyCredentialStore ? true : asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.LoadCredentialStore) {
                    return new StateResolution<>(new MigratingLegacyStore(str, r4, b11 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.migrateLegacyCredentialStoreAction()));
                }
                return stateResolution;
            }
            if (oldState instanceof MigratingLegacyStore) {
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.LoadCredentialStore) {
                    return new StateResolution<>(new LoadingStoredCredentials(b10 == true ? 1 : 0, r4, b9 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.loadCredentialStoreAction(((CredentialStoreEvent.EventType.LoadCredentialStore) asCredentialStoreEvent).getCredentialType())));
                }
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((CredentialStoreEvent.EventType.ThrowError) asCredentialStoreEvent).getError()), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.moveToIdleStateAction()));
                }
                return stateResolution;
            }
            if (oldState instanceof LoadingStoredCredentials ? true : oldState instanceof StoringCredentials ? true : oldState instanceof ClearingCredentials) {
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.CompletedOperation) {
                    return new StateResolution<>(new Success(((CredentialStoreEvent.EventType.CompletedOperation) asCredentialStoreEvent).getStoredCredentials()), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.moveToIdleStateAction()));
                }
                return asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.ThrowError ? new StateResolution<>(new Error(((CredentialStoreEvent.EventType.ThrowError) asCredentialStoreEvent).getError()), null, 2, null) : stateResolution;
            }
            if (oldState instanceof Idle) {
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.ClearCredentialStore) {
                    return new StateResolution<>(new ClearingCredentials(b8 == true ? 1 : 0, r4, b7 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.clearCredentialStoreAction(((CredentialStoreEvent.EventType.ClearCredentialStore) asCredentialStoreEvent).getCredentialType())));
                }
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.LoadCredentialStore) {
                    return new StateResolution<>(new LoadingStoredCredentials(b6 == true ? 1 : 0, r4, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.loadCredentialStoreAction(((CredentialStoreEvent.EventType.LoadCredentialStore) asCredentialStoreEvent).getCredentialType())));
                }
                if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.StoreCredentials) {
                    CredentialStoreEvent.EventType.StoreCredentials storeCredentials = (CredentialStoreEvent.EventType.StoreCredentials) asCredentialStoreEvent;
                    return new StateResolution<>(new StoringCredentials(b4 == true ? 1 : 0, r4, b3 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.credentialStoreActions.storeCredentialsAction(storeCredentials.getCredentialType(), storeCredentials.getCredentials())));
                }
                return new StateResolution<>(oldState, null, 2, null);
            }
            if (!(oldState instanceof Success ? true : oldState instanceof Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (asCredentialStoreEvent instanceof CredentialStoreEvent.EventType.MoveToIdleState) {
                return new StateResolution<>(new Idle(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), EmptyList.INSTANCE);
            }
            return new StateResolution<>(oldState, null, 2, null);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class StoringCredentials extends CredentialStoreState {
        private final String id;

        public StoringCredentials() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StoringCredentials copy$default(StoringCredentials storingCredentials, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = storingCredentials.id;
            }
            return storingCredentials.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final StoringCredentials copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new StoringCredentials(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof StoringCredentials) && Intrinsics.areEqual(this.id, ((StoringCredentials) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("StoringCredentials(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StoringCredentials(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ StoringCredentials(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: CredentialStoreState.kt */
    /* loaded from: classes.dex */
    public static final class Success extends CredentialStoreState {
        private final AmplifyCredential storedCredentials;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(AmplifyCredential storedCredentials) {
            super(null);
            Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
            this.storedCredentials = storedCredentials;
        }

        public static /* synthetic */ Success copy$default(Success success, AmplifyCredential amplifyCredential, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                amplifyCredential = success.storedCredentials;
            }
            return success.copy(amplifyCredential);
        }

        public final AmplifyCredential component1() {
            return this.storedCredentials;
        }

        public final Success copy(AmplifyCredential storedCredentials) {
            Intrinsics.checkNotNullParameter(storedCredentials, "storedCredentials");
            return new Success(storedCredentials);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Success) && Intrinsics.areEqual(this.storedCredentials, ((Success) obj).storedCredentials)) {
                return true;
            }
            return false;
        }

        public final AmplifyCredential getStoredCredentials() {
            return this.storedCredentials;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            return this.storedCredentials.hashCode();
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "Success(storedCredentials=" + this.storedCredentials + ')';
        }
    }

    public /* synthetic */ CredentialStoreState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return this.type;
    }

    private CredentialStoreState() {
        this.type = toString();
    }
}
