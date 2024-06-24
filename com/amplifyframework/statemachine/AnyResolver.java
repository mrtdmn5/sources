package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineResolver;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateMachineResolver.kt */
/* loaded from: classes.dex */
public final class AnyResolver<StateType extends State, ResolverType extends StateMachineResolver<StateType>> implements StateMachineResolver<StateType> {
    private StateType defaultState;
    private final ResolverType resolver;

    public AnyResolver(ResolverType resolver) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        this.resolver = resolver;
        this.defaultState = (StateType) resolver.getDefaultState();
    }

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public AnyResolver<StateType, ?> eraseToAnyResolver() {
        return StateMachineResolver.DefaultImpls.eraseToAnyResolver(this);
    }

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public StateType getDefaultState() {
        return this.defaultState;
    }

    public final ResolverType getResolver() {
        return this.resolver;
    }

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public LoggingStateMachineResolver<StateType, StateMachineResolver<StateType>> logging(Logger logger, Level level) {
        return StateMachineResolver.DefaultImpls.logging(this, logger, level);
    }

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public StateResolution<StateType> resolve(StateType oldState, StateMachineEvent event) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(event, "event");
        return this.resolver.resolve(oldState, event);
    }

    public void setDefaultState(StateType statetype) {
        Intrinsics.checkNotNullParameter(statetype, "<set-?>");
        this.defaultState = statetype;
    }
}
