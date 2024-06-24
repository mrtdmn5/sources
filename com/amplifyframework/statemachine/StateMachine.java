package com.amplifyframework.statemachine;

import com.amplifyframework.statemachine.Environment;
import com.amplifyframework.statemachine.State;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.JobKt;

/* compiled from: StateMachine.kt */
/* loaded from: classes.dex */
public class StateMachine<StateType extends State, EnvironmentType extends Environment> implements EventDispatcher {
    private StateType currentState;
    private final CoroutineDispatcher dispatcherQueue;
    private final EnvironmentType environment;
    private final CoroutineExceptionHandler exceptionHandler;
    private final EffectExecutor executor;
    private final ExecutorCoroutineDispatcher operationQueue;
    private final Set<StateChangeListenerToken> pendingCancellations;
    private final AnyResolver<StateType, ?> resolver;
    private final CoroutineContext stateMachineScope;
    private final Map<StateChangeListenerToken, Function1<StateType, Unit>> subscribers;

    public StateMachine(StateMachineResolver<StateType> resolver, EnvironmentType environment, EffectExecutor effectExecutor, CoroutineDispatcher coroutineDispatcher, StateType statetype) {
        Intrinsics.checkNotNullParameter(resolver, "resolver");
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        this.resolver = resolver.eraseToAnyResolver();
        this.currentState = statetype == null ? resolver.getDefaultState() : statetype;
        final AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorCoroutineDispatcherImpl executorCoroutineDispatcherImpl = new ExecutorCoroutineDispatcherImpl(Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: kotlinx.coroutines.ThreadPoolDispatcherKt__ThreadPoolDispatcherKt$$ExternalSyntheticLambda0
            public final /* synthetic */ int f$0 = 1;
            public final /* synthetic */ String f$1 = "Single threaded dispatcher";

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                int r1 = this.f$0;
                String str = this.f$1;
                if (r1 != 1) {
                    str = str + '-' + atomicInteger.incrementAndGet();
                }
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(true);
                return thread;
            }
        }));
        this.operationQueue = executorCoroutineDispatcherImpl;
        this.exceptionHandler = new StateMachine$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE);
        this.stateMachineScope = CoroutineContext.DefaultImpls.plus(JobKt.Job$default(), executorCoroutineDispatcherImpl);
        coroutineDispatcher = coroutineDispatcher == null ? Dispatchers.Default : coroutineDispatcher;
        this.dispatcherQueue = coroutineDispatcher;
        this.executor = effectExecutor == null ? new ConcurrentEffectExecutor(coroutineDispatcher) : effectExecutor;
        this.subscribers = new LinkedHashMap();
        this.pendingCancellations = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSubscription(StateChangeListenerToken stateChangeListenerToken, Function1<? super StateType, Unit> function1, Function0<Unit> function0) {
        if (this.pendingCancellations.contains(stateChangeListenerToken)) {
            return;
        }
        StateType statetype = this.currentState;
        this.subscribers.put(stateChangeListenerToken, function1);
        if (function0 != null) {
            function0.invoke();
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.dispatcherQueue, null, new StateMachine$addSubscription$1(function1, statetype, null), 2);
    }

    private final void execute(List<? extends Action> list) {
        this.executor.execute(list, this, this.environment);
    }

    private final boolean notifySubscribers(Map.Entry<StateChangeListenerToken, ? extends Function1<? super StateType, Unit>> entry, StateType statetype) {
        if (this.pendingCancellations.contains(entry.getKey())) {
            return false;
        }
        entry.getValue().invoke(statetype);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void process(StateMachineEvent stateMachineEvent) {
        StateResolution<StateType> resolve = this.resolver.resolve(this.currentState, stateMachineEvent);
        if (!Intrinsics.areEqual(this.currentState, resolve.getNewState())) {
            this.currentState = resolve.getNewState();
            Map<StateChangeListenerToken, Function1<StateType, Unit>> map = this.subscribers;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<StateChangeListenerToken, ? extends Function1<? super StateType, Unit>> entry : map.entrySet()) {
                if (!notifySubscribers(entry, resolve.getNewState())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                this.subscribers.remove(((Map.Entry) it.next()).getKey());
            }
        }
        execute(resolve.getActions());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeSubscription(StateChangeListenerToken stateChangeListenerToken) {
        this.pendingCancellations.remove(stateChangeListenerToken);
        this.subscribers.remove(stateChangeListenerToken);
    }

    public final void cancel(StateChangeListenerToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        this.pendingCancellations.add(token);
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.stateMachineScope, null, new StateMachine$cancel$1(this, token, null), 2);
    }

    public final void getCurrentState(Function1<? super StateType, Unit> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.stateMachineScope, null, new StateMachine$getCurrentState$1(completion, this, null), 2);
    }

    public final EnvironmentType getEnvironment() {
        return this.environment;
    }

    public final void listen(StateChangeListenerToken token, Function1<? super StateType, Unit> listener, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.stateMachineScope, null, new StateMachine$listen$1(this, token, listener, function0, null), 2);
    }

    @Override // com.amplifyframework.statemachine.EventDispatcher
    public void send(StateMachineEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        BuildersKt.launch$default(GlobalScope.INSTANCE, this.stateMachineScope, null, new StateMachine$send$1(this, event, null), 2);
    }

    public /* synthetic */ StateMachine(StateMachineResolver stateMachineResolver, Environment environment, EffectExecutor effectExecutor, CoroutineDispatcher coroutineDispatcher, State state, int r13, DefaultConstructorMarker defaultConstructorMarker) {
        this(stateMachineResolver, environment, (r13 & 4) != 0 ? null : effectExecutor, (r13 & 8) != 0 ? null : coroutineDispatcher, (r13 & 16) != 0 ? null : state);
    }
}
