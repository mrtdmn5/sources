package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToList$1$1", f = "FlowExtensions.kt", l = {92}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FlowQuery$mapToList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<Object>>, Object> {
    public final /* synthetic */ Query<Object> $it;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$mapToList$1$1(Query<Object> query, Continuation<? super FlowQuery$mapToList$1$1> continuation) {
        super(2, continuation);
        this.$it = query;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowQuery$mapToList$1$1(this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Object>> continuation) {
        return ((FlowQuery$mapToList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        if (r1 != 0) {
            if (r1 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            final Query<Object> query = this.$it;
            obj = query.execute(new Function1<SqlCursor, QueryResult<List<Object>>>() { // from class: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2

                /* compiled from: QueryExtensions.kt */
                @DebugMetadata(c = "app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2$1", f = "QueryExtensions.kt", l = {14, 15}, m = "invokeSuspend")
                /* renamed from: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super List<Object>>, Object> {
                    public final /* synthetic */ SqlCursor $cursor;
                    public final /* synthetic */ QueryResult<Boolean> $first;
                    public final /* synthetic */ List<Object> $result;
                    public final /* synthetic */ ExecutableQuery<Object> $this_awaitAsList;
                    public int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(QueryResult<Boolean> queryResult, List<Object> list, ExecutableQuery<Object> executableQuery, SqlCursor sqlCursor, Continuation<? super AnonymousClass1> continuation) {
                        super(1, continuation);
                        this.$first = queryResult;
                        this.$result = list;
                        this.$this_awaitAsList = executableQuery;
                        this.$cursor = sqlCursor;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Continuation<?> continuation) {
                        return new AnonymousClass1(this.$first, this.$result, this.$this_awaitAsList, this.$cursor, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Continuation<? super List<Object>> continuation) {
                        return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:11:0x0052 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
                    /* JADX WARN: Removed duplicated region for block: B:14:0x0073 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0061  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0053 -> B:6:0x0057). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                        /*
                            r6 = this;
                            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                            int r1 = r6.label
                            r2 = 2
                            r3 = 1
                            if (r1 == 0) goto L1e
                            if (r1 == r3) goto L1a
                            if (r1 != r2) goto L12
                            kotlin.ResultKt.throwOnFailure(r7)
                            r1 = r0
                            r0 = r6
                            goto L57
                        L12:
                            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                            r7.<init>(r0)
                            throw r7
                        L1a:
                            kotlin.ResultKt.throwOnFailure(r7)
                            goto L2c
                        L1e:
                            kotlin.ResultKt.throwOnFailure(r7)
                            r6.label = r3
                            app.cash.sqldelight.db.QueryResult<java.lang.Boolean> r7 = r6.$first
                            java.lang.Object r7 = r7.await(r6)
                            if (r7 != r0) goto L2c
                            return r0
                        L2c:
                            java.lang.Boolean r7 = (java.lang.Boolean) r7
                            boolean r7 = r7.booleanValue()
                            java.util.List<java.lang.Object> r1 = r6.$result
                            if (r7 == 0) goto L74
                            app.cash.sqldelight.ExecutableQuery<java.lang.Object> r7 = r6.$this_awaitAsList
                            kotlin.jvm.functions.Function1 r7 = r7.getMapper()
                            app.cash.sqldelight.db.SqlCursor r3 = r6.$cursor
                            java.lang.Object r7 = r7.invoke(r3)
                            r1.add(r7)
                            r7 = r6
                        L46:
                            app.cash.sqldelight.db.SqlCursor r1 = r7.$cursor
                            app.cash.sqldelight.db.QueryResult$Value r1 = r1.next()
                            r7.label = r2
                            T r1 = r1.value
                            if (r1 != r0) goto L53
                            return r0
                        L53:
                            r5 = r0
                            r0 = r7
                            r7 = r1
                            r1 = r5
                        L57:
                            java.lang.Boolean r7 = (java.lang.Boolean) r7
                            boolean r7 = r7.booleanValue()
                            java.util.List<java.lang.Object> r3 = r0.$result
                            if (r7 == 0) goto L73
                            app.cash.sqldelight.ExecutableQuery<java.lang.Object> r7 = r0.$this_awaitAsList
                            kotlin.jvm.functions.Function1 r7 = r7.getMapper()
                            app.cash.sqldelight.db.SqlCursor r4 = r0.$cursor
                            java.lang.Object r7 = r7.invoke(r4)
                            r3.add(r7)
                            r7 = r0
                            r0 = r1
                            goto L46
                        L73:
                            return r3
                        L74:
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsList$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final QueryResult<List<Object>> invoke(SqlCursor sqlCursor) {
                    SqlCursor cursor = sqlCursor;
                    Intrinsics.checkNotNullParameter(cursor, "cursor");
                    QueryResult.Value next = cursor.next();
                    ArrayList arrayList = new ArrayList();
                    if (next instanceof QueryResult.AsyncValue) {
                        return new QueryResult.AsyncValue(new AnonymousClass1(next, arrayList, query, cursor, null));
                    }
                    if (next instanceof QueryResult.Value) {
                        if (((Boolean) next.value).booleanValue()) {
                            ExecutableQuery<Object> executableQuery = query;
                            arrayList.add(executableQuery.getMapper().invoke(cursor));
                            while (((Boolean) cursor.next().value).booleanValue()) {
                                arrayList.add(executableQuery.getMapper().invoke(cursor));
                            }
                            return new QueryResult.Value(arrayList);
                        }
                        return new QueryResult.Value(arrayList);
                    }
                    throw new NoWhenBranchMatchedException();
                }
            }).await(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        return obj;
    }
}
