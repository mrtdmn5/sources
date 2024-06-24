package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.State;
import com.amplifyframework.statemachine.StateMachineResolver;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggingStateMachineResolver.kt */
/* loaded from: classes.dex */
public final class LoggingStateMachineResolver<StateType extends State, ResolverType extends StateMachineResolver<StateType>> implements StateMachineResolver<StateType> {
    public static final Companion Companion = new Companion(null);
    private final StateType defaultState;
    private final Level level;
    private Logger logger;
    private final ResolverType resolver;

    /* compiled from: LoggingStateMachineResolver.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger makeDefaultLogger() {
            Logger logger = Logger.getLogger(toString());
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.ALL);
            logger.setLevel(Level.ALL);
            logger.addHandler(consoleHandler);
            logger.setUseParentHandlers(false);
            return logger;
        }

        private Companion() {
        }
    }

    public LoggingStateMachineResolver(ResolverType resolver, Logger logger, Level level) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(level, "level");
        this.resolver = resolver;
        this.level = level;
        this.logger = logger == null ? Companion.makeDefaultLogger() : logger;
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

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public LoggingStateMachineResolver<StateType, StateMachineResolver<StateType>> logging(Logger logger, Level level) {
        return StateMachineResolver.DefaultImpls.logging(this, logger, level);
    }

    @Override // com.amplifyframework.statemachine.StateMachineResolver
    public StateResolution<StateType> resolve(StateType oldState, StateMachineEvent event) {
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(event, "event");
        StateResolution<StateType> resolve = this.resolver.resolve(oldState, event);
        this.logger.log(this.level, oldState.toString());
        this.logger.log(this.level, event.getType());
        this.logger.log(this.level, resolve.getNewState().toString());
        return resolve;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ LoggingStateMachineResolver(com.amplifyframework.statemachine.StateMachineResolver r1, java.util.logging.Logger r2, java.util.logging.Level r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L5
            r2 = 0
        L5:
            r4 = r4 & 4
            if (r4 == 0) goto L10
            java.util.logging.Level r3 = java.util.logging.Level.INFO
            java.lang.String r4 = "INFO"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L10:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.statemachine.LoggingStateMachineResolver.<init>(com.amplifyframework.statemachine.StateMachineResolver, java.util.logging.Logger, java.util.logging.Level, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
