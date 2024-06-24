package app.cash.sqldelight.async.coroutines;

import app.cash.sqldelight.ExecutableQuery;
import app.cash.sqldelight.Query;
import app.cash.sqldelight.db.QueryResult;
import app.cash.sqldelight.db.SqlCursor;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: QueryExtensions.kt */
/* loaded from: classes.dex */
public final class QueryExtensionsKt$awaitAsOneOrNull$2 extends Lambda implements Function1<SqlCursor, QueryResult<Object>> {
    public final /* synthetic */ ExecutableQuery<Object> $this_awaitAsOneOrNull;

    /* compiled from: QueryExtensions.kt */
    @DebugMetadata(c = "app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2$1", f = "QueryExtensions.kt", l = {40, 42}, m = "invokeSuspend")
    /* renamed from: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<Object>, Object> {
        public final /* synthetic */ SqlCursor $cursor;
        public final /* synthetic */ QueryResult<Boolean> $next;
        public final /* synthetic */ ExecutableQuery<Object> $this_awaitAsOneOrNull;
        public Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(QueryResult<Boolean> queryResult, ExecutableQuery<Object> executableQuery, SqlCursor sqlCursor, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$next = queryResult;
            this.$this_awaitAsOneOrNull = executableQuery;
            this.$cursor = sqlCursor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.$next, this.$this_awaitAsOneOrNull, this.$cursor, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<Object> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x005a A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
                int r1 = r5.label
                app.cash.sqldelight.ExecutableQuery<java.lang.Object> r2 = r5.$this_awaitAsOneOrNull
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                java.lang.Object r0 = r5.L$0
                kotlin.ResultKt.throwOnFailure(r6)
                goto L51
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L2e
            L20:
                kotlin.ResultKt.throwOnFailure(r6)
                r5.label = r4
                app.cash.sqldelight.db.QueryResult<java.lang.Boolean> r6 = r5.$next
                java.lang.Object r6 = r6.await(r5)
                if (r6 != r0) goto L2e
                return r0
            L2e:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L38
                r6 = 0
                return r6
            L38:
                kotlin.jvm.functions.Function1 r6 = r2.getMapper()
                app.cash.sqldelight.db.SqlCursor r1 = r5.$cursor
                java.lang.Object r6 = r6.invoke(r1)
                app.cash.sqldelight.db.QueryResult$Value r1 = r1.next()
                r5.L$0 = r6
                r5.label = r3
                T r1 = r1.value
                if (r1 != r0) goto L4f
                return r0
            L4f:
                r0 = r6
                r6 = r1
            L51:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                r6 = r6 ^ r4
                if (r6 == 0) goto L5b
                return r0
            L5b:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r0 = "ResultSet returned more than 1 row for "
                r6.<init>(r0)
                r6.append(r2)
                java.lang.String r6 = r6.toString()
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r6 = r6.toString()
                r0.<init>(r6)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryExtensionsKt$awaitAsOneOrNull$2(Query query) {
        super(1);
        this.$this_awaitAsOneOrNull = query;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public final QueryResult<Object> invoke(SqlCursor sqlCursor) {
        SqlCursor cursor = sqlCursor;
        Intrinsics.checkNotNullParameter(cursor, "cursor");
        QueryResult.Value next = cursor.next();
        boolean z = next instanceof QueryResult.AsyncValue;
        ExecutableQuery<Object> executableQuery = this.$this_awaitAsOneOrNull;
        if (z) {
            return new QueryResult.AsyncValue(new AnonymousClass1(next, executableQuery, cursor, null));
        }
        if (next instanceof QueryResult.Value) {
            if (!((Boolean) next.value).booleanValue()) {
                return new QueryResult.Value(null);
            }
            Object invoke = executableQuery.getMapper().invoke(cursor);
            if (!((Boolean) cursor.next().value).booleanValue()) {
                return new QueryResult.Value(invoke);
            }
            throw new IllegalStateException(("ResultSet returned more than 1 row for " + executableQuery).toString());
        }
        throw new NoWhenBranchMatchedException();
    }
}
