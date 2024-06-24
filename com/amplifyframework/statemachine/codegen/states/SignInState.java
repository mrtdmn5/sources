package com.amplifyframework.statemachine.codegen.states;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.AnyResolver;
import com.amplifyframework.statemachine.LoggingStateMachineResolver;
import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineEvent;
import com.amplifyframework.statemachine.StateMachineResolver;
import com.amplifyframework.statemachine.StateResolution;
import com.amplifyframework.statemachine.codegen.actions.SignInActions;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData$$ExternalSyntheticOutline0;
import com.amplifyframework.statemachine.codegen.events.SignInEvent;
import com.amplifyframework.statemachine.codegen.states.CustomSignInState;
import com.amplifyframework.statemachine.codegen.states.DeviceSRPSignInState;
import com.amplifyframework.statemachine.codegen.states.HostedUISignInState;
import com.amplifyframework.statemachine.codegen.states.MigrateSignInState;
import com.amplifyframework.statemachine.codegen.states.SRPSignInState;
import com.amplifyframework.statemachine.codegen.states.SignInChallengeState;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignInState.kt */
/* loaded from: classes.dex */
public abstract class SignInState implements State {
    private SignInChallengeState challengeState;
    private CustomSignInState customSignInState;
    private DeviceSRPSignInState deviceSRPSignInState;
    private HostedUISignInState hostedUISignInState;
    private MigrateSignInState migrateSignInState;
    private SRPSignInState srpSignInState;

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class Builder implements com.amplifyframework.statemachine.Builder<SignInState> {
        private SignInChallengeState challengeState;
        private CustomSignInState customSignInState;
        private DeviceSRPSignInState deviceSRPSignInState;
        private HostedUISignInState hostedUISignInState;
        private MigrateSignInState migrateSignInState;
        private final SignInState signInState;
        private SRPSignInState srpSignInState;

        public Builder(SignInState signInState) {
            Intrinsics.checkNotNullParameter(signInState, "signInState");
            this.signInState = signInState;
        }

        public final SignInChallengeState getChallengeState() {
            return this.challengeState;
        }

        public final CustomSignInState getCustomSignInState() {
            return this.customSignInState;
        }

        public final DeviceSRPSignInState getDeviceSRPSignInState() {
            return this.deviceSRPSignInState;
        }

        public final HostedUISignInState getHostedUISignInState() {
            return this.hostedUISignInState;
        }

        public final MigrateSignInState getMigrateSignInState() {
            return this.migrateSignInState;
        }

        public final SRPSignInState getSrpSignInState() {
            return this.srpSignInState;
        }

        public final void setChallengeState(SignInChallengeState signInChallengeState) {
            this.challengeState = signInChallengeState;
        }

        public final void setCustomSignInState(CustomSignInState customSignInState) {
            this.customSignInState = customSignInState;
        }

        public final void setDeviceSRPSignInState(DeviceSRPSignInState deviceSRPSignInState) {
            this.deviceSRPSignInState = deviceSRPSignInState;
        }

        public final void setHostedUISignInState(HostedUISignInState hostedUISignInState) {
            this.hostedUISignInState = hostedUISignInState;
        }

        public final void setMigrateSignInState(MigrateSignInState migrateSignInState) {
            this.migrateSignInState = migrateSignInState;
        }

        public final void setSrpSignInState(SRPSignInState sRPSignInState) {
            this.srpSignInState = sRPSignInState;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.amplifyframework.statemachine.Builder
        public SignInState build() {
            SignInState signInState = this.signInState;
            return signInState instanceof SigningInWithSRP ? new SigningInWithSRP(this.srpSignInState) : signInState instanceof ResolvingChallenge ? new ResolvingChallenge(this.challengeState) : signInState instanceof SigningInViaMigrateAuth ? new SigningInViaMigrateAuth(this.migrateSignInState) : signInState instanceof SigningInWithCustom ? new SigningInWithCustom(this.customSignInState) : signInState instanceof SigningInWithHostedUI ? new SigningInWithHostedUI(this.hostedUISignInState) : signInState instanceof SigningInWithSRPCustom ? new SigningInWithSRPCustom(this.srpSignInState) : signInState instanceof ResolvingDeviceSRP ? new ResolvingDeviceSRP(this.deviceSRPSignInState) : signInState;
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class ConfirmingDevice extends SignInState {
        private final String id;

        public ConfirmingDevice() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ ConfirmingDevice copy$default(ConfirmingDevice confirmingDevice, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = confirmingDevice.id;
            }
            return confirmingDevice.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final ConfirmingDevice copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new ConfirmingDevice(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ConfirmingDevice) && Intrinsics.areEqual(this.id, ((ConfirmingDevice) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("ConfirmingDevice(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConfirmingDevice(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ ConfirmingDevice(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class Done extends SignInState {
        private final String id;

        public Done() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Done copy$default(Done done, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = done.id;
            }
            return done.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final Done copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Done(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Done) && Intrinsics.areEqual(this.id, ((Done) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("Done(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Done(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ Done(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class Error extends SignInState {
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

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class NotStarted extends SignInState {
        private final String id;

        public NotStarted() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ NotStarted copy$default(NotStarted notStarted, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = notStarted.id;
            }
            return notStarted.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final NotStarted copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new NotStarted(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof NotStarted) && Intrinsics.areEqual(this.id, ((NotStarted) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("NotStarted(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotStarted(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ NotStarted(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class Resolver implements StateMachineResolver<SignInState> {
        private final StateMachineResolver<SignInChallengeState> challengeResolver;
        private final StateMachineResolver<CustomSignInState> customSignInResolver;
        private final NotStarted defaultState;
        private final StateMachineResolver<DeviceSRPSignInState> deviceSRPSignInResolver;
        private final StateMachineResolver<HostedUISignInState> hostedUISignInResolver;
        private final StateMachineResolver<MigrateSignInState> migrationSignInResolver;
        private final SignInActions signInActions;
        private final StateMachineResolver<SRPSignInState> srpSignInResolver;

        public Resolver(StateMachineResolver<SRPSignInState> srpSignInResolver, StateMachineResolver<CustomSignInState> customSignInResolver, StateMachineResolver<MigrateSignInState> migrationSignInResolver, StateMachineResolver<SignInChallengeState> challengeResolver, StateMachineResolver<HostedUISignInState> hostedUISignInResolver, StateMachineResolver<DeviceSRPSignInState> deviceSRPSignInResolver, SignInActions signInActions) {
            Intrinsics.checkNotNullParameter(srpSignInResolver, "srpSignInResolver");
            Intrinsics.checkNotNullParameter(customSignInResolver, "customSignInResolver");
            Intrinsics.checkNotNullParameter(migrationSignInResolver, "migrationSignInResolver");
            Intrinsics.checkNotNullParameter(challengeResolver, "challengeResolver");
            Intrinsics.checkNotNullParameter(hostedUISignInResolver, "hostedUISignInResolver");
            Intrinsics.checkNotNullParameter(deviceSRPSignInResolver, "deviceSRPSignInResolver");
            Intrinsics.checkNotNullParameter(signInActions, "signInActions");
            this.srpSignInResolver = srpSignInResolver;
            this.customSignInResolver = customSignInResolver;
            this.migrationSignInResolver = migrationSignInResolver;
            this.challengeResolver = challengeResolver;
            this.hostedUISignInResolver = hostedUISignInResolver;
            this.deviceSRPSignInResolver = deviceSRPSignInResolver;
            this.signInActions = signInActions;
            this.defaultState = new NotStarted(null, 1, 0 == true ? 1 : 0);
        }

        private final SignInEvent.EventType asSignInEvent(StateMachineEvent stateMachineEvent) {
            SignInEvent signInEvent;
            if (stateMachineEvent instanceof SignInEvent) {
                signInEvent = (SignInEvent) stateMachineEvent;
            } else {
                signInEvent = null;
            }
            if (signInEvent == null) {
                return null;
            }
            return signInEvent.getEventType();
        }

        private final StateResolution<SignInState> resolveSignInEvent(SignInState signInState, StateMachineEvent stateMachineEvent) {
            boolean z;
            boolean z2;
            boolean z3;
            SignInEvent.EventType asSignInEvent = asSignInEvent(stateMachineEvent);
            String str = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            byte b7 = 0;
            StateResolution<SignInState> stateResolution = new StateResolution<>(signInState, null, 2, null);
            int r4 = 1;
            if (signInState instanceof NotStarted) {
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateSignInWithSRP) {
                    return new StateResolution<>(new SigningInWithSRP(signInState.getSrpSignInState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.startSRPAuthAction((SignInEvent.EventType.InitiateSignInWithSRP) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateSignInWithCustom) {
                    return new StateResolution<>(new SigningInWithCustom(signInState.getCustomSignInState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.startCustomAuthAction((SignInEvent.EventType.InitiateSignInWithCustom) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateHostedUISignIn) {
                    return new StateResolution<>(new SigningInWithHostedUI(new HostedUISignInState.NotStarted(null, 1, null)), CollectionsKt__CollectionsKt.listOf(this.signInActions.startHostedUIAuthAction((SignInEvent.EventType.InitiateHostedUISignIn) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateMigrateAuth) {
                    return new StateResolution<>(new SigningInViaMigrateAuth(new MigrateSignInState.NotStarted(null, 1, null)), CollectionsKt__CollectionsKt.listOf(this.signInActions.startMigrationAuthAction((SignInEvent.EventType.InitiateMigrateAuth) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateCustomSignInWithSRP) {
                    return new StateResolution<>(new SigningInWithSRPCustom(signInState.getSrpSignInState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.startCustomAuthWithSRPAction((SignInEvent.EventType.InitiateCustomSignInWithSRP) asSignInEvent)));
                }
                return stateResolution;
            }
            if (signInState instanceof SigningInWithSRP) {
                z = true;
            } else {
                z = signInState instanceof SigningInWithCustom;
            }
            if (z) {
                z2 = true;
            } else {
                z2 = signInState instanceof SigningInViaMigrateAuth;
            }
            if (z2) {
                z3 = true;
            } else {
                z3 = signInState instanceof SigningInWithSRPCustom;
            }
            if (z3) {
                if (asSignInEvent instanceof SignInEvent.EventType.ReceivedChallenge) {
                    return new StateResolution<>(new ResolvingChallenge(signInState.getChallengeState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.initResolveChallenge((SignInEvent.EventType.ReceivedChallenge) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.InitiateSignInWithDeviceSRP) {
                    return new StateResolution<>(new ResolvingDeviceSRP(new DeviceSRPSignInState.NotStarted(null, 1, null)), CollectionsKt__CollectionsKt.listOf(this.signInActions.startDeviceSRPAuthAction((SignInEvent.EventType.InitiateSignInWithDeviceSRP) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ConfirmDevice) {
                    return new StateResolution<>(new ConfirmingDevice(str, r4, b7 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signInActions.confirmDevice((SignInEvent.EventType.ConfirmDevice) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((SignInEvent.EventType.ThrowError) asSignInEvent).getException()), null, 2, null);
                }
                return stateResolution;
            }
            if (signInState instanceof ResolvingChallenge) {
                if (asSignInEvent instanceof SignInEvent.EventType.ConfirmDevice) {
                    return new StateResolution<>(new ConfirmingDevice(b6 == true ? 1 : 0, r4, b5 == true ? 1 : 0), CollectionsKt__CollectionsKt.listOf(this.signInActions.confirmDevice((SignInEvent.EventType.ConfirmDevice) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ReceivedChallenge) {
                    return new StateResolution<>(new ResolvingChallenge(signInState.getChallengeState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.initResolveChallenge((SignInEvent.EventType.ReceivedChallenge) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((SignInEvent.EventType.ThrowError) asSignInEvent).getException()), null, 2, null);
                }
                return stateResolution;
            }
            if (signInState instanceof ResolvingDeviceSRP) {
                if (asSignInEvent instanceof SignInEvent.EventType.ReceivedChallenge) {
                    return new StateResolution<>(new ResolvingChallenge(signInState.getChallengeState()), CollectionsKt__CollectionsKt.listOf(this.signInActions.initResolveChallenge((SignInEvent.EventType.ReceivedChallenge) asSignInEvent)));
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((SignInEvent.EventType.ThrowError) asSignInEvent).getException()), null, 2, null);
                }
                return stateResolution;
            }
            if (signInState instanceof ConfirmingDevice) {
                if (asSignInEvent instanceof SignInEvent.EventType.FinalizeSignIn) {
                    return new StateResolution<>(new SignedIn(b4 == true ? 1 : 0, r4, b3 == true ? 1 : 0), null, 2, null);
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((SignInEvent.EventType.ThrowError) asSignInEvent).getException()), null, 2, null);
                }
                return stateResolution;
            }
            if (signInState instanceof SigningInWithHostedUI) {
                if (asSignInEvent instanceof SignInEvent.EventType.SignedIn) {
                    return new StateResolution<>(new Done(b2 == true ? 1 : 0, r4, b == true ? 1 : 0), null, 2, null);
                }
                if (asSignInEvent instanceof SignInEvent.EventType.ThrowError) {
                    return new StateResolution<>(new Error(((SignInEvent.EventType.ThrowError) asSignInEvent).getException()), null, 2, null);
                }
                return stateResolution;
            }
            return stateResolution;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public AnyResolver<SignInState, ?> eraseToAnyResolver() {
            return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public LoggingStateMachineResolver<SignInState, StateMachineResolver<SignInState>> logging(Logger logger, Level level) {
            return StateMachineResolver.DefaultImpls.logging(this, logger, level);
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public SignInState getDefaultState() {
            return this.defaultState;
        }

        @Override // com.amplifyframework.statemachine.StateMachineResolver
        public StateResolution<SignInState> resolve(SignInState oldState, StateMachineEvent event) {
            StateResolution<DeviceSRPSignInState> resolve;
            StateResolution<CustomSignInState> resolve2;
            StateResolution<HostedUISignInState> resolve3;
            StateResolution<MigrateSignInState> resolve4;
            StateResolution<SignInChallengeState> resolve5;
            StateResolution<SRPSignInState> resolve6;
            Intrinsics.checkNotNullParameter(oldState, "oldState");
            Intrinsics.checkNotNullParameter(event, "event");
            StateResolution<SignInState> resolveSignInEvent = resolveSignInEvent(oldState, event);
            ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) resolveSignInEvent.getActions());
            Builder builder = new Builder(resolveSignInEvent.getNewState());
            SRPSignInState srpSignInState = oldState.getSrpSignInState();
            if (srpSignInState != null && (resolve6 = this.srpSignInResolver.resolve(srpSignInState, event)) != null) {
                builder.setSrpSignInState(resolve6.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve6.getActions(), mutableList);
            }
            SignInChallengeState challengeState = oldState.getChallengeState();
            if (challengeState != null && (resolve5 = this.challengeResolver.resolve(challengeState, event)) != null) {
                builder.setChallengeState(resolve5.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve5.getActions(), mutableList);
            }
            MigrateSignInState migrateSignInState = oldState.getMigrateSignInState();
            if (migrateSignInState != null && (resolve4 = this.migrationSignInResolver.resolve(migrateSignInState, event)) != null) {
                builder.setMigrateSignInState(resolve4.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve4.getActions(), mutableList);
            }
            HostedUISignInState hostedUISignInState = oldState.getHostedUISignInState();
            if (hostedUISignInState != null && (resolve3 = this.hostedUISignInResolver.resolve(hostedUISignInState, event)) != null) {
                builder.setHostedUISignInState(resolve3.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve3.getActions(), mutableList);
            }
            CustomSignInState customSignInState = oldState.getCustomSignInState();
            if (customSignInState != null && (resolve2 = this.customSignInResolver.resolve(customSignInState, event)) != null) {
                builder.setCustomSignInState(resolve2.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve2.getActions(), mutableList);
            }
            DeviceSRPSignInState deviceSRPSignInState = oldState.getDeviceSRPSignInState();
            if (deviceSRPSignInState != null && (resolve = this.deviceSRPSignInResolver.resolve(deviceSRPSignInState, event)) != null) {
                builder.setDeviceSRPSignInState(resolve.getNewState());
                CollectionsKt__ReversedViewsKt.addAll(resolve.getActions(), mutableList);
            }
            return new StateResolution<>(builder.build(), mutableList);
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class ResolvingChallenge extends SignInState {
        private SignInChallengeState challengeState;

        public ResolvingChallenge(SignInChallengeState signInChallengeState) {
            super(null);
            this.challengeState = signInChallengeState;
        }

        public static /* synthetic */ ResolvingChallenge copy$default(ResolvingChallenge resolvingChallenge, SignInChallengeState signInChallengeState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                signInChallengeState = resolvingChallenge.getChallengeState();
            }
            return resolvingChallenge.copy(signInChallengeState);
        }

        public final SignInChallengeState component1() {
            return getChallengeState();
        }

        public final ResolvingChallenge copy(SignInChallengeState signInChallengeState) {
            return new ResolvingChallenge(signInChallengeState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ResolvingChallenge) && Intrinsics.areEqual(getChallengeState(), ((ResolvingChallenge) obj).getChallengeState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public SignInChallengeState getChallengeState() {
            return this.challengeState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getChallengeState() == null) {
                return 0;
            }
            return getChallengeState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setChallengeState(SignInChallengeState signInChallengeState) {
            this.challengeState = signInChallengeState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "ResolvingChallenge(challengeState=" + getChallengeState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class ResolvingDeviceSRP extends SignInState {
        private DeviceSRPSignInState deviceSRPSignInState;

        public ResolvingDeviceSRP(DeviceSRPSignInState deviceSRPSignInState) {
            super(null);
            this.deviceSRPSignInState = deviceSRPSignInState;
        }

        public static /* synthetic */ ResolvingDeviceSRP copy$default(ResolvingDeviceSRP resolvingDeviceSRP, DeviceSRPSignInState deviceSRPSignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                deviceSRPSignInState = resolvingDeviceSRP.getDeviceSRPSignInState();
            }
            return resolvingDeviceSRP.copy(deviceSRPSignInState);
        }

        public final DeviceSRPSignInState component1() {
            return getDeviceSRPSignInState();
        }

        public final ResolvingDeviceSRP copy(DeviceSRPSignInState deviceSRPSignInState) {
            return new ResolvingDeviceSRP(deviceSRPSignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof ResolvingDeviceSRP) && Intrinsics.areEqual(getDeviceSRPSignInState(), ((ResolvingDeviceSRP) obj).getDeviceSRPSignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public DeviceSRPSignInState getDeviceSRPSignInState() {
            return this.deviceSRPSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getDeviceSRPSignInState() == null) {
                return 0;
            }
            return getDeviceSRPSignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setDeviceSRPSignInState(DeviceSRPSignInState deviceSRPSignInState) {
            this.deviceSRPSignInState = deviceSRPSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "ResolvingDeviceSRP(deviceSRPSignInState=" + getDeviceSRPSignInState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SignedIn extends SignInState {
        private final String id;

        public SignedIn() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ SignedIn copy$default(SignedIn signedIn, String str, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                str = signedIn.id;
            }
            return signedIn.copy(str);
        }

        public final String component1() {
            return this.id;
        }

        public final SignedIn copy(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new SignedIn(id);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SignedIn) && Intrinsics.areEqual(this.id, ((SignedIn) obj).id)) {
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
            return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("SignedIn(id="), this.id, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SignedIn(String id) {
            super(null);
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
        }

        public /* synthetic */ SignedIn(String str, int r2, DefaultConstructorMarker defaultConstructorMarker) {
            this((r2 & 1) != 0 ? "" : str);
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningInViaMigrateAuth extends SignInState {
        private MigrateSignInState migrateSignInState;

        public SigningInViaMigrateAuth(MigrateSignInState migrateSignInState) {
            super(null);
            this.migrateSignInState = migrateSignInState;
        }

        public static /* synthetic */ SigningInViaMigrateAuth copy$default(SigningInViaMigrateAuth signingInViaMigrateAuth, MigrateSignInState migrateSignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                migrateSignInState = signingInViaMigrateAuth.getMigrateSignInState();
            }
            return signingInViaMigrateAuth.copy(migrateSignInState);
        }

        public final MigrateSignInState component1() {
            return getMigrateSignInState();
        }

        public final SigningInViaMigrateAuth copy(MigrateSignInState migrateSignInState) {
            return new SigningInViaMigrateAuth(migrateSignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningInViaMigrateAuth) && Intrinsics.areEqual(getMigrateSignInState(), ((SigningInViaMigrateAuth) obj).getMigrateSignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public MigrateSignInState getMigrateSignInState() {
            return this.migrateSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getMigrateSignInState() == null) {
                return 0;
            }
            return getMigrateSignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setMigrateSignInState(MigrateSignInState migrateSignInState) {
            this.migrateSignInState = migrateSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningInViaMigrateAuth(migrateSignInState=" + getMigrateSignInState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningInWithCustom extends SignInState {
        private CustomSignInState customSignInState;

        public SigningInWithCustom(CustomSignInState customSignInState) {
            super(null);
            this.customSignInState = customSignInState;
        }

        public static /* synthetic */ SigningInWithCustom copy$default(SigningInWithCustom signingInWithCustom, CustomSignInState customSignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                customSignInState = signingInWithCustom.getCustomSignInState();
            }
            return signingInWithCustom.copy(customSignInState);
        }

        public final CustomSignInState component1() {
            return getCustomSignInState();
        }

        public final SigningInWithCustom copy(CustomSignInState customSignInState) {
            return new SigningInWithCustom(customSignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningInWithCustom) && Intrinsics.areEqual(getCustomSignInState(), ((SigningInWithCustom) obj).getCustomSignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public CustomSignInState getCustomSignInState() {
            return this.customSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getCustomSignInState() == null) {
                return 0;
            }
            return getCustomSignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setCustomSignInState(CustomSignInState customSignInState) {
            this.customSignInState = customSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningInWithCustom(customSignInState=" + getCustomSignInState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningInWithHostedUI extends SignInState {
        private HostedUISignInState hostedUISignInState;

        public SigningInWithHostedUI(HostedUISignInState hostedUISignInState) {
            super(null);
            this.hostedUISignInState = hostedUISignInState;
        }

        public static /* synthetic */ SigningInWithHostedUI copy$default(SigningInWithHostedUI signingInWithHostedUI, HostedUISignInState hostedUISignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                hostedUISignInState = signingInWithHostedUI.getHostedUISignInState();
            }
            return signingInWithHostedUI.copy(hostedUISignInState);
        }

        public final HostedUISignInState component1() {
            return getHostedUISignInState();
        }

        public final SigningInWithHostedUI copy(HostedUISignInState hostedUISignInState) {
            return new SigningInWithHostedUI(hostedUISignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningInWithHostedUI) && Intrinsics.areEqual(getHostedUISignInState(), ((SigningInWithHostedUI) obj).getHostedUISignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public HostedUISignInState getHostedUISignInState() {
            return this.hostedUISignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getHostedUISignInState() == null) {
                return 0;
            }
            return getHostedUISignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setHostedUISignInState(HostedUISignInState hostedUISignInState) {
            this.hostedUISignInState = hostedUISignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningInWithHostedUI(hostedUISignInState=" + getHostedUISignInState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningInWithSRP extends SignInState {
        private SRPSignInState srpSignInState;

        public SigningInWithSRP(SRPSignInState sRPSignInState) {
            super(null);
            this.srpSignInState = sRPSignInState;
        }

        public static /* synthetic */ SigningInWithSRP copy$default(SigningInWithSRP signingInWithSRP, SRPSignInState sRPSignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                sRPSignInState = signingInWithSRP.getSrpSignInState();
            }
            return signingInWithSRP.copy(sRPSignInState);
        }

        public final SRPSignInState component1() {
            return getSrpSignInState();
        }

        public final SigningInWithSRP copy(SRPSignInState sRPSignInState) {
            return new SigningInWithSRP(sRPSignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningInWithSRP) && Intrinsics.areEqual(getSrpSignInState(), ((SigningInWithSRP) obj).getSrpSignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public SRPSignInState getSrpSignInState() {
            return this.srpSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getSrpSignInState() == null) {
                return 0;
            }
            return getSrpSignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setSrpSignInState(SRPSignInState sRPSignInState) {
            this.srpSignInState = sRPSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningInWithSRP(srpSignInState=" + getSrpSignInState() + ')';
        }
    }

    /* compiled from: SignInState.kt */
    /* loaded from: classes.dex */
    public static final class SigningInWithSRPCustom extends SignInState {
        private SRPSignInState srpSignInState;

        public SigningInWithSRPCustom(SRPSignInState sRPSignInState) {
            super(null);
            this.srpSignInState = sRPSignInState;
        }

        public static /* synthetic */ SigningInWithSRPCustom copy$default(SigningInWithSRPCustom signingInWithSRPCustom, SRPSignInState sRPSignInState, int r2, Object obj) {
            if ((r2 & 1) != 0) {
                sRPSignInState = signingInWithSRPCustom.getSrpSignInState();
            }
            return signingInWithSRPCustom.copy(sRPSignInState);
        }

        public final SRPSignInState component1() {
            return getSrpSignInState();
        }

        public final SigningInWithSRPCustom copy(SRPSignInState sRPSignInState) {
            return new SigningInWithSRPCustom(sRPSignInState);
        }

        @Override // com.amplifyframework.statemachine.State
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof SigningInWithSRPCustom) && Intrinsics.areEqual(getSrpSignInState(), ((SigningInWithSRPCustom) obj).getSrpSignInState())) {
                return true;
            }
            return false;
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public SRPSignInState getSrpSignInState() {
            return this.srpSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public int hashCode() {
            if (getSrpSignInState() == null) {
                return 0;
            }
            return getSrpSignInState().hashCode();
        }

        @Override // com.amplifyframework.statemachine.codegen.states.SignInState
        public void setSrpSignInState(SRPSignInState sRPSignInState) {
            this.srpSignInState = sRPSignInState;
        }

        @Override // com.amplifyframework.statemachine.State
        public String toString() {
            return "SigningInWithSRPCustom(srpSignInState=" + getSrpSignInState() + ')';
        }
    }

    public /* synthetic */ SignInState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public SignInChallengeState getChallengeState() {
        return this.challengeState;
    }

    public CustomSignInState getCustomSignInState() {
        return this.customSignInState;
    }

    public DeviceSRPSignInState getDeviceSRPSignInState() {
        return this.deviceSRPSignInState;
    }

    public HostedUISignInState getHostedUISignInState() {
        return this.hostedUISignInState;
    }

    public MigrateSignInState getMigrateSignInState() {
        return this.migrateSignInState;
    }

    public SRPSignInState getSrpSignInState() {
        return this.srpSignInState;
    }

    @Override // com.amplifyframework.statemachine.State
    public String getType() {
        return State.DefaultImpls.getType(this);
    }

    public void setChallengeState(SignInChallengeState signInChallengeState) {
        this.challengeState = signInChallengeState;
    }

    public void setCustomSignInState(CustomSignInState customSignInState) {
        this.customSignInState = customSignInState;
    }

    public void setDeviceSRPSignInState(DeviceSRPSignInState deviceSRPSignInState) {
        this.deviceSRPSignInState = deviceSRPSignInState;
    }

    public void setHostedUISignInState(HostedUISignInState hostedUISignInState) {
        this.hostedUISignInState = hostedUISignInState;
    }

    public void setMigrateSignInState(MigrateSignInState migrateSignInState) {
        this.migrateSignInState = migrateSignInState;
    }

    public void setSrpSignInState(SRPSignInState sRPSignInState) {
        this.srpSignInState = sRPSignInState;
    }

    private SignInState() {
        this.srpSignInState = new SRPSignInState.NotStarted(null, 1, null);
        this.challengeState = new SignInChallengeState.NotStarted(null, 1, null);
        this.customSignInState = new CustomSignInState.NotStarted(null, 1, null);
        this.migrateSignInState = new MigrateSignInState.NotStarted(null, 1, null);
        this.hostedUISignInState = new HostedUISignInState.NotStarted(null, 1, null);
        this.deviceSRPSignInState = new DeviceSRPSignInState.NotStarted(null, 1, null);
    }
}
