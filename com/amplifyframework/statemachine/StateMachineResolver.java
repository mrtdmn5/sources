package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.State;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StateMachineResolver.kt */
/* loaded from: classes.dex */
public interface StateMachineResolver<StateType extends State> {

    /* compiled from: StateMachineResolver.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static <StateType extends State> AnyResolver<StateType, ?> eraseToAnyResolver(StateMachineResolver<StateType> stateMachineResolver) {
            AnyResolver<StateType, ?> anyResolver;
            if (stateMachineResolver instanceof AnyResolver) {
                anyResolver = (AnyResolver) stateMachineResolver;
            } else {
                anyResolver = null;
            }
            if (anyResolver == null) {
                return new AnyResolver<>(stateMachineResolver);
            }
            return anyResolver;
        }

        public static <StateType extends State> LoggingStateMachineResolver<StateType, StateMachineResolver<StateType>> logging(StateMachineResolver<StateType> stateMachineResolver, Logger logger, Level level) {
            Intrinsics.checkNotNullParameter(level, "level");
            return new LoggingStateMachineResolver<>(stateMachineResolver, logger, level);
        }

        public static /* synthetic */ LoggingStateMachineResolver logging$default(StateMachineResolver stateMachineResolver, Logger logger, Level FINE, int r3, Object obj) {
            if (obj == null) {
                if ((r3 & 1) != 0) {
                    logger = null;
                }
                if ((r3 & 2) != 0) {
                    FINE = Level.FINE;
                    Intrinsics.checkNotNullExpressionValue(FINE, "FINE");
                }
                return stateMachineResolver.logging(logger, FINE);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logging");
        }
    }

    AnyResolver<StateType, ?> eraseToAnyResolver();

    StateType getDefaultState();

    LoggingStateMachineResolver<StateType, StateMachineResolver<StateType>> logging(Logger logger, Level level);

    StateResolution<StateType> resolve(StateType statetype, StateMachineEvent stateMachineEvent);
}
