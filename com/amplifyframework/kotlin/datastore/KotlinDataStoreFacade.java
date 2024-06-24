package com.amplifyframework.kotlin.datastore;

import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.query.ObserveQueryOptions;
import com.amplifyframework.core.model.query.QueryOptions;
import com.amplifyframework.core.model.query.predicate.QueryPredicate;
import com.amplifyframework.datastore.DataStoreCategoryBehavior;
import com.amplifyframework.datastore.DataStoreException;
import com.amplifyframework.datastore.DataStoreItemChange;
import com.amplifyframework.datastore.DataStoreQuerySnapshot;
import com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: KotlinDataStoreFacade.kt */
/* loaded from: classes.dex */
public final class KotlinDataStoreFacade implements DataStore {
    private final DataStoreCategoryBehavior delegate;

    /* compiled from: KotlinDataStoreFacade.kt */
    /* loaded from: classes.dex */
    public static final class Observation<T> {
        private final MutableSharedFlow<T> changes;
        private final MutableSharedFlow<Unit> completions;
        private final MutableSharedFlow<DataStoreException> failures;
        private final MutableSharedFlow<Cancelable> starts;

        public Observation() {
            this(null, null, null, null, 15, null);
        }

        public final MutableSharedFlow<T> getChanges$core_kotlin_release() {
            return this.changes;
        }

        public final MutableSharedFlow<Unit> getCompletions$core_kotlin_release() {
            return this.completions;
        }

        public final MutableSharedFlow<DataStoreException> getFailures$core_kotlin_release() {
            return this.failures;
        }

        public final MutableSharedFlow<Cancelable> getStarts$core_kotlin_release() {
            return this.starts;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object waitForStart$core_kotlin_release(kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends T>> r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$1
                if (r0 == 0) goto L13
                r0 = r7
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$1 r0 = (com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$1 r0 = new com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$1
                r0.<init>(r6, r7)
            L18:
                java.lang.Object r7 = r0.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 2
                r4 = 0
                r5 = 1
                if (r2 == 0) goto L35
                if (r2 != r5) goto L2d
                java.lang.Object r0 = r0.L$0
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation r0 = (com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade.Observation) r0
                kotlin.ResultKt.throwOnFailure(r7)
                goto L5c
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L35:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.flow.MutableSharedFlow[] r7 = new kotlinx.coroutines.flow.MutableSharedFlow[r3]
                kotlinx.coroutines.flow.MutableSharedFlow<com.amplifyframework.core.async.Cancelable> r2 = r6.starts
                r7[r4] = r2
                kotlinx.coroutines.flow.MutableSharedFlow<com.amplifyframework.datastore.DataStoreException> r2 = r6.failures
                r7[r5] = r2
                kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r2 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1
                r2.<init>(r7)
                kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.flattenMerge$default(r2)
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$$inlined$map$1 r2 = new com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$$inlined$map$1
                r2.<init>()
                r0.L$0 = r6
                r0.label = r5
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r2, r0)
                if (r7 != r1) goto L5b
                return r1
            L5b:
                r0 = r6
            L5c:
                com.amplifyframework.core.async.Cancelable r7 = (com.amplifyframework.core.async.Cancelable) r7
                r1 = 3
                kotlinx.coroutines.flow.MutableSharedFlow[] r1 = new kotlinx.coroutines.flow.MutableSharedFlow[r1]
                kotlinx.coroutines.flow.MutableSharedFlow<T> r2 = r0.changes
                r1[r4] = r2
                kotlinx.coroutines.flow.MutableSharedFlow<com.amplifyframework.datastore.DataStoreException> r2 = r0.failures
                r1[r5] = r2
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r0 = r0.completions
                r1[r3] = r0
                kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1
                r0.<init>(r1)
                kotlinx.coroutines.flow.Flow r0 = kotlinx.coroutines.flow.FlowKt.flattenMerge$default(r0)
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$2 r1 = new com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$2
                r2 = 0
                r1.<init>(r2)
                kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 r3 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1
                r3.<init>(r1, r0)
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$$inlined$map$2 r0 = new com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$$inlined$map$2
                r0.<init>()
                com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$4 r1 = new com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$Observation$waitForStart$4
                r1.<init>(r7, r2)
                kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r7 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
                r7.<init>(r0, r1)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade.Observation.waitForStart$core_kotlin_release(kotlin.coroutines.Continuation):java.lang.Object");
        }

        public Observation(MutableSharedFlow<Cancelable> starts, MutableSharedFlow<T> changes, MutableSharedFlow<DataStoreException> failures, MutableSharedFlow<Unit> completions) {
            Intrinsics.checkNotNullParameter(starts, "starts");
            Intrinsics.checkNotNullParameter(changes, "changes");
            Intrinsics.checkNotNullParameter(failures, "failures");
            Intrinsics.checkNotNullParameter(completions, "completions");
            this.starts = starts;
            this.changes = changes;
            this.failures = failures;
            this.completions = completions;
        }

        public /* synthetic */ Observation(MutableSharedFlow mutableSharedFlow, MutableSharedFlow mutableSharedFlow2, MutableSharedFlow mutableSharedFlow3, MutableSharedFlow mutableSharedFlow4, int r9, DefaultConstructorMarker defaultConstructorMarker) {
            this((r9 & 1) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow, (r9 & 2) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow2, (r9 & 4) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow3, (r9 & 8) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow4);
        }
    }

    public KotlinDataStoreFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-10, reason: not valid java name */
    public static final void m658observe$lambda10(Observation observation) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        observation.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-11, reason: not valid java name */
    public static final void m659observe$lambda11(Observation observation, Cancelable it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getStarts$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-12, reason: not valid java name */
    public static final void m660observe$lambda12(Observation observation, DataStoreItemChange it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getChanges$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-13, reason: not valid java name */
    public static final void m661observe$lambda13(Observation observation, DataStoreException it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-14, reason: not valid java name */
    public static final void m662observe$lambda14(Observation observation) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        observation.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-3, reason: not valid java name */
    public static final void m663observe$lambda3(Observation observation, Cancelable it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getStarts$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-4, reason: not valid java name */
    public static final void m664observe$lambda4(Observation observation, DataStoreItemChange it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getChanges$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-5, reason: not valid java name */
    public static final void m665observe$lambda5(Observation observation, DataStoreException it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-6, reason: not valid java name */
    public static final void m666observe$lambda6(Observation observation) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        observation.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-7, reason: not valid java name */
    public static final void m667observe$lambda7(Observation observation, Cancelable it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getStarts$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-8, reason: not valid java name */
    public static final void m668observe$lambda8(Observation observation, DataStoreItemChange it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getChanges$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observe$lambda-9, reason: not valid java name */
    public static final void m669observe$lambda9(Observation observation, DataStoreException it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeQuery$lambda-15, reason: not valid java name */
    public static final void m670observeQuery$lambda15(Observation observation, Cancelable it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getStarts$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeQuery$lambda-16, reason: not valid java name */
    public static final void m671observeQuery$lambda16(Observation observation, DataStoreQuerySnapshot it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getChanges$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeQuery$lambda-17, reason: not valid java name */
    public static final void m672observeQuery$lambda17(Observation observation, DataStoreException it) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        Intrinsics.checkNotNullParameter(it, "it");
        observation.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: observeQuery$lambda-18, reason: not valid java name */
    public static final void m673observeQuery$lambda18(Observation observation) {
        Intrinsics.checkNotNullParameter(observation, "$observation");
        observation.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public Object clear(Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.clear(new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$clear$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$clear$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object delete(T t, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.delete((DataStoreCategoryBehavior) t, queryPredicate, (Consumer<DataStoreItemChange<DataStoreCategoryBehavior>>) new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$delete$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreItemChange<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$delete$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public Object observe(Continuation<? super Flow<? extends DataStoreItemChange<? extends Model>>> continuation) throws DataStoreException {
        final Observation observation = new Observation(null, null, null, null, 15, null);
        this.delegate.observe(new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda4
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m663observe$lambda3(KotlinDataStoreFacade.Observation.this, (Cancelable) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda5
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m664observe$lambda4(KotlinDataStoreFacade.Observation.this, (DataStoreItemChange) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda6
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m665observe$lambda5(KotlinDataStoreFacade.Observation.this, (DataStoreException) obj);
            }
        }, new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda7
            @Override // com.amplifyframework.core.Action
            public final void call() {
                KotlinDataStoreFacade.m666observe$lambda6(KotlinDataStoreFacade.Observation.this);
            }
        });
        return observation.waitForStart$core_kotlin_release(continuation);
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object observeQuery(KClass<T> kClass, ObserveQueryOptions observeQueryOptions, Continuation<? super Flow<? extends DataStoreQuerySnapshot<T>>> continuation) {
        final Observation observation = new Observation(null, null, null, null, 15, null);
        this.delegate.observeQuery(JvmClassMappingKt.getJavaClass(kClass), observeQueryOptions, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda0
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m670observeQuery$lambda15(KotlinDataStoreFacade.Observation.this, (Cancelable) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m671observeQuery$lambda16(KotlinDataStoreFacade.Observation.this, (DataStoreQuerySnapshot) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m672observeQuery$lambda17(KotlinDataStoreFacade.Observation.this, (DataStoreException) obj);
            }
        }, new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda3
            @Override // com.amplifyframework.core.Action
            public final void call() {
                KotlinDataStoreFacade.m673observeQuery$lambda18(KotlinDataStoreFacade.Observation.this);
            }
        });
        return observation.waitForStart$core_kotlin_release(continuation);
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Flow<T> query(KClass<T> itemClass, QueryOptions options) throws DataStoreException {
        Intrinsics.checkNotNullParameter(itemClass, "itemClass");
        Intrinsics.checkNotNullParameter(options, "options");
        return FlowKt.callbackFlow(new KotlinDataStoreFacade$query$1(this, itemClass, options, null));
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object save(T t, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.save(t, queryPredicate, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$save$2$1
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreItemChange<T> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$save$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public Object start(Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.start(new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$start$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$start$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public Object stop(Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.stop(new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$stop$2$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$stop$2$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return orThrow;
        }
        return Unit.INSTANCE;
    }

    public KotlinDataStoreFacade(DataStoreCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinDataStoreFacade(com.amplifyframework.datastore.DataStoreCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.datastore.DataStoreCategory r1 = com.amplifyframework.core.Amplify.DataStore
            java.lang.String r2 = "DataStore"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade.<init>(com.amplifyframework.datastore.DataStoreCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object observe(KClass<T> kClass, String str, Continuation<? super Flow<DataStoreItemChange<T>>> continuation) throws DataStoreException {
        final Observation observation = new Observation(null, null, null, null, 15, null);
        this.delegate.observe(JvmClassMappingKt.getJavaClass(kClass), str, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda12
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m667observe$lambda7(KotlinDataStoreFacade.Observation.this, (Cancelable) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda13
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m668observe$lambda8(KotlinDataStoreFacade.Observation.this, (DataStoreItemChange) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda14
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m669observe$lambda9(KotlinDataStoreFacade.Observation.this, (DataStoreException) obj);
            }
        }, new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda15
            @Override // com.amplifyframework.core.Action
            public final void call() {
                KotlinDataStoreFacade.m658observe$lambda10(KotlinDataStoreFacade.Observation.this);
            }
        });
        return observation.waitForStart$core_kotlin_release(continuation);
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object delete(KClass<T> kClass, QueryPredicate queryPredicate, Continuation<? super Unit> continuation) throws DataStoreException {
        final SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        this.delegate.delete(JvmClassMappingKt.getJavaClass(kClass), queryPredicate, new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$delete$4$1
            @Override // com.amplifyframework.core.Action
            public final void call() {
                safeContinuation.resumeWith(Unit.INSTANCE);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$delete$4$2
            @Override // com.amplifyframework.core.Consumer
            public final void accept(DataStoreException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                safeContinuation.resumeWith(ResultKt.createFailure(it));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        return orThrow == CoroutineSingletons.COROUTINE_SUSPENDED ? orThrow : Unit.INSTANCE;
    }

    @Override // com.amplifyframework.kotlin.datastore.DataStore
    public <T extends Model> Object observe(KClass<T> kClass, QueryPredicate queryPredicate, Continuation<? super Flow<DataStoreItemChange<T>>> continuation) throws DataStoreException {
        final Observation observation = new Observation(null, null, null, null, 15, null);
        this.delegate.observe(JvmClassMappingKt.getJavaClass(kClass), queryPredicate, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda8
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m659observe$lambda11(KotlinDataStoreFacade.Observation.this, (Cancelable) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda9
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m660observe$lambda12(KotlinDataStoreFacade.Observation.this, (DataStoreItemChange) obj);
            }
        }, new Consumer() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda10
            @Override // com.amplifyframework.core.Consumer
            public final void accept(Object obj) {
                KotlinDataStoreFacade.m661observe$lambda13(KotlinDataStoreFacade.Observation.this, (DataStoreException) obj);
            }
        }, new Action() { // from class: com.amplifyframework.kotlin.datastore.KotlinDataStoreFacade$$ExternalSyntheticLambda11
            @Override // com.amplifyframework.core.Action
            public final void call() {
                KotlinDataStoreFacade.m662observe$lambda14(KotlinDataStoreFacade.Observation.this);
            }
        });
        return observation.waitForStart$core_kotlin_release(continuation);
    }
}
