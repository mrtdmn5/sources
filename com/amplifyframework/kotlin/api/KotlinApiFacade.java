package com.amplifyframework.kotlin.api;

import com.amplifyframework.api.ApiCategoryBehavior;
import com.amplifyframework.api.ApiException;
import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLOperation;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.rest.RestOperation;
import com.amplifyframework.api.rest.RestOptions;
import com.amplifyframework.api.rest.RestResponse;
import com.amplifyframework.core.Action;
import com.amplifyframework.core.Consumer;
import com.amplifyframework.core.async.Cancelable;
import com.amplifyframework.core.async.NoOpCancelable;
import com.amplifyframework.kotlin.api.KotlinApiFacade;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: KotlinApiFacade.kt */
/* loaded from: classes.dex */
public final class KotlinApiFacade implements Api {
    private final ApiCategoryBehavior delegate;

    /* compiled from: KotlinApiFacade.kt */
    /* loaded from: classes.dex */
    public static final class Subscription<T> {
        private Cancelable cancelable;
        private final MutableSharedFlow<Unit> completions;
        private final MutableSharedFlow<T> data;
        private final MutableSharedFlow<ApiException> failures;
        private final MutableSharedFlow<Unit> starts;

        public Subscription() {
            this(null, null, null, null, null, 31, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object awaitStart$core_kotlin_release(kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends T>> r7) {
            /*
                r6 = this;
                boolean r0 = r7 instanceof com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$1
                if (r0 == 0) goto L13
                r0 = r7
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$1 r0 = (com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$1 r0 = new com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$1
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
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription r0 = (com.amplifyframework.kotlin.api.KotlinApiFacade.Subscription) r0
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
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r2 = r6.starts
                r7[r4] = r2
                kotlinx.coroutines.flow.MutableSharedFlow<com.amplifyframework.api.ApiException> r2 = r6.failures
                r7[r5] = r2
                kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r2 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1
                r2.<init>(r7)
                kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.flattenMerge$default(r2)
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$$inlined$map$1 r2 = new com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$$inlined$map$1
                r2.<init>()
                r0.L$0 = r6
                r0.label = r5
                java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.first(r2, r0)
                if (r7 != r1) goto L5b
                return r1
            L5b:
                r0 = r6
            L5c:
                r7 = 3
                kotlinx.coroutines.flow.MutableSharedFlow[] r7 = new kotlinx.coroutines.flow.MutableSharedFlow[r7]
                kotlinx.coroutines.flow.MutableSharedFlow<T> r1 = r0.data
                r7[r4] = r1
                kotlinx.coroutines.flow.MutableSharedFlow<com.amplifyframework.api.ApiException> r1 = r0.failures
                r7[r5] = r1
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r1 = r0.completions
                r7[r3] = r1
                kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1 r1 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1
                r1.<init>(r7)
                kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.flattenMerge$default(r1)
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$3 r1 = new com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$3
                r2 = 0
                r1.<init>(r2)
                kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1 r3 = new kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1
                r3.<init>(r1, r7)
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$$inlined$map$2 r7 = new com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$$inlined$map$2
                r7.<init>()
                com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$5 r1 = new com.amplifyframework.kotlin.api.KotlinApiFacade$Subscription$awaitStart$5
                r1.<init>(r0, r2)
                kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1
                r0.<init>(r7, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.api.KotlinApiFacade.Subscription.awaitStart$core_kotlin_release(kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final Cancelable getCancelable$core_kotlin_release() {
            return this.cancelable;
        }

        public final MutableSharedFlow<Unit> getCompletions$core_kotlin_release() {
            return this.completions;
        }

        public final MutableSharedFlow<T> getData$core_kotlin_release() {
            return this.data;
        }

        public final MutableSharedFlow<ApiException> getFailures$core_kotlin_release() {
            return this.failures;
        }

        public final MutableSharedFlow<Unit> getStarts$core_kotlin_release() {
            return this.starts;
        }

        public final void setCancelable$core_kotlin_release(Cancelable cancelable) {
            Intrinsics.checkNotNullParameter(cancelable, "<set-?>");
            this.cancelable = cancelable;
        }

        public Subscription(MutableSharedFlow<Unit> starts, MutableSharedFlow<T> data, MutableSharedFlow<ApiException> failures, MutableSharedFlow<Unit> completions, Cancelable cancelable) {
            Intrinsics.checkNotNullParameter(starts, "starts");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(failures, "failures");
            Intrinsics.checkNotNullParameter(completions, "completions");
            Intrinsics.checkNotNullParameter(cancelable, "cancelable");
            this.starts = starts;
            this.data = data;
            this.failures = failures;
            this.completions = completions;
            this.cancelable = cancelable;
        }

        public /* synthetic */ Subscription(MutableSharedFlow mutableSharedFlow, MutableSharedFlow mutableSharedFlow2, MutableSharedFlow mutableSharedFlow3, MutableSharedFlow mutableSharedFlow4, Cancelable cancelable, int r11, DefaultConstructorMarker defaultConstructorMarker) {
            this((r11 & 1) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow, (r11 & 2) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow2, (r11 & 4) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow3, (r11 & 8) != 0 ? SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6) : mutableSharedFlow4, (r11 & 16) != 0 ? new NoOpCancelable() : cancelable);
        }
    }

    public KotlinApiFacade() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-2, reason: not valid java name */
    public static final void m647subscribe$lambda2(Subscription subscription, String it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getStarts$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-3, reason: not valid java name */
    public static final void m648subscribe$lambda3(Subscription subscription, GraphQLResponse it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getData$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-4, reason: not valid java name */
    public static final void m649subscribe$lambda4(Subscription subscription, ApiException it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-5, reason: not valid java name */
    public static final void m650subscribe$lambda5(Subscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        subscription.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-6, reason: not valid java name */
    public static final void m651subscribe$lambda6(Subscription subscription, String it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getStarts$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-7, reason: not valid java name */
    public static final void m652subscribe$lambda7(Subscription subscription, GraphQLResponse it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getData$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-8, reason: not valid java name */
    public static final void m653subscribe$lambda8(Subscription subscription, ApiException it) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        Intrinsics.checkNotNullParameter(it, "it");
        subscription.getFailures$core_kotlin_release().tryEmit(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: subscribe$lambda-9, reason: not valid java name */
    public static final void m654subscribe$lambda9(Subscription subscription) {
        Intrinsics.checkNotNullParameter(subscription, "$subscription");
        subscription.getCompletions$core_kotlin_release().tryEmit(Unit.INSTANCE);
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object delete(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation delete;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            delete = this.delegate.delete(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$delete$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$delete$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            delete = this.delegate.delete(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$delete$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$delete$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$delete$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation = RestOperation.this;
                if (restOperation != null) {
                    restOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object get(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation restOperation;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            restOperation = this.delegate.get(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$get$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$get$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            restOperation = this.delegate.get(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$get$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$get$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$get$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation2 = RestOperation.this;
                if (restOperation2 != null) {
                    restOperation2.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object head(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation head;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            head = this.delegate.head(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$head$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$head$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            head = this.delegate.head(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$head$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$head$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$head$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation = RestOperation.this;
                if (restOperation != null) {
                    restOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.GraphQL
    public <T> Object mutate(GraphQLRequest<T> graphQLRequest, String str, Continuation<? super GraphQLResponse<T>> continuation) throws ApiException {
        final GraphQLOperation<T> mutate;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            mutate = this.delegate.mutate(str, graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$mutate$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(GraphQLResponse<T> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$mutate$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            mutate = this.delegate.mutate(graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$mutate$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(GraphQLResponse<T> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$mutate$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$mutate$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ApiOperation apiOperation = mutate;
                if (apiOperation != null) {
                    apiOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object patch(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation patch;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            patch = this.delegate.patch(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$patch$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$patch$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            patch = this.delegate.patch(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$patch$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$patch$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$patch$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation = RestOperation.this;
                if (restOperation != null) {
                    restOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object post(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation post;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            post = this.delegate.post(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$post$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$post$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            post = this.delegate.post(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$post$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$post$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$post$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation = RestOperation.this;
                if (restOperation != null) {
                    restOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.Rest
    public Object put(RestOptions restOptions, String str, Continuation<? super RestResponse> continuation) throws ApiException {
        final RestOperation put;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            put = this.delegate.put(str, restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$put$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$put$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            put = this.delegate.put(restOptions, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$put$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(RestResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$put$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$put$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                RestOperation restOperation = RestOperation.this;
                if (restOperation != null) {
                    restOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.GraphQL
    public <R> Object query(GraphQLRequest<R> graphQLRequest, String str, Continuation<? super GraphQLResponse<R>> continuation) throws ApiException {
        final GraphQLOperation<R> query;
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        if (str != null) {
            query = this.delegate.query(str, graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$query$2$operation$1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(GraphQLResponse<R> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$query$2$operation$2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        } else {
            query = this.delegate.query(graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$query$2$operation$3
                @Override // com.amplifyframework.core.Consumer
                public final void accept(GraphQLResponse<R> it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(it);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$query$2$operation$4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(ApiException it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    cancellableContinuationImpl.resumeWith(ResultKt.createFailure(it));
                }
            });
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$query$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ApiOperation apiOperation = query;
                if (apiOperation != null) {
                    apiOperation.cancel();
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        return result;
    }

    @Override // com.amplifyframework.kotlin.api.GraphQL
    public <T> Object subscribe(GraphQLRequest<T> graphQLRequest, String str, Continuation<? super Flow<GraphQLResponse<T>>> continuation) {
        GraphQLOperation subscribe;
        final Subscription subscription = new Subscription(null, null, null, null, null, 31, null);
        if (str != null) {
            subscribe = this.delegate.subscribe(str, graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda0
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m647subscribe$lambda2(KotlinApiFacade.Subscription.this, (String) obj);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda1
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m648subscribe$lambda3(KotlinApiFacade.Subscription.this, (GraphQLResponse) obj);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda2
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m649subscribe$lambda4(KotlinApiFacade.Subscription.this, (ApiException) obj);
                }
            }, new Action() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda3
                @Override // com.amplifyframework.core.Action
                public final void call() {
                    KotlinApiFacade.m650subscribe$lambda5(KotlinApiFacade.Subscription.this);
                }
            });
        } else {
            subscribe = this.delegate.subscribe(graphQLRequest, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda4
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m651subscribe$lambda6(KotlinApiFacade.Subscription.this, (String) obj);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda5
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m652subscribe$lambda7(KotlinApiFacade.Subscription.this, (GraphQLResponse) obj);
                }
            }, new Consumer() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda6
                @Override // com.amplifyframework.core.Consumer
                public final void accept(Object obj) {
                    KotlinApiFacade.m653subscribe$lambda8(KotlinApiFacade.Subscription.this, (ApiException) obj);
                }
            }, new Action() { // from class: com.amplifyframework.kotlin.api.KotlinApiFacade$$ExternalSyntheticLambda7
                @Override // com.amplifyframework.core.Action
                public final void call() {
                    KotlinApiFacade.m654subscribe$lambda9(KotlinApiFacade.Subscription.this);
                }
            });
        }
        Intrinsics.checkNotNull(subscribe, "null cannot be cast to non-null type com.amplifyframework.core.async.Cancelable");
        subscription.setCancelable$core_kotlin_release(subscribe);
        return subscription.awaitStart$core_kotlin_release(continuation);
    }

    public KotlinApiFacade(ApiCategoryBehavior delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ KotlinApiFacade(com.amplifyframework.api.ApiCategoryBehavior r1, int r2, kotlin.jvm.internal.DefaultConstructorMarker r3) {
        /*
            r0 = this;
            r2 = r2 & 1
            if (r2 == 0) goto Lb
            com.amplifyframework.api.ApiCategory r1 = com.amplifyframework.core.Amplify.API
            java.lang.String r2 = "API"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
        Lb:
            r0.<init>(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.kotlin.api.KotlinApiFacade.<init>(com.amplifyframework.api.ApiCategoryBehavior, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
