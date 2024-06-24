package app.cash.sqldelight.coroutines;

import app.cash.sqldelight.Query;
import app.cash.sqldelight.async.coroutines.QueryExtensionsKt$awaitAsOneOrNull$2;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FlowExtensions.kt */
@DebugMetadata(c = "app.cash.sqldelight.coroutines.FlowQuery$mapToOneOrDefault$1$1", f = "FlowExtensions.kt", l = {68}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class FlowQuery$mapToOneOrDefault$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
    public final /* synthetic */ Object $defaultValue;
    public final /* synthetic */ Query<Object> $it;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowQuery$mapToOneOrDefault$1$1(Query<Object> query, Object obj, Continuation<? super FlowQuery$mapToOneOrDefault$1$1> continuation) {
        super(2, continuation);
        this.$it = query;
        this.$defaultValue = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FlowQuery$mapToOneOrDefault$1$1(this.$it, this.$defaultValue, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((FlowQuery$mapToOneOrDefault$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            Query<Object> query = this.$it;
            obj = query.execute(new QueryExtensionsKt$awaitAsOneOrNull$2(query)).await(this);
            if (obj == coroutineSingletons) {
                return coroutineSingletons;
            }
        }
        if (obj == null) {
            return this.$defaultValue;
        }
        return obj;
    }
}
