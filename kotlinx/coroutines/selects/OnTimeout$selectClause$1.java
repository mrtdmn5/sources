package kotlinx.coroutines.selects;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* compiled from: OnTimeout.kt */
/* loaded from: classes4.dex */
public final /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements Function3<OnTimeout, SelectInstance<?>, Object, Unit> {
    public static final OnTimeout$selectClause$1 INSTANCE = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(OnTimeout onTimeout, SelectInstance<?> selectInstance, Object obj) {
        final OnTimeout onTimeout2 = onTimeout;
        final SelectInstance<?> selectInstance2 = selectInstance;
        long j = onTimeout2.timeMillis;
        if (j <= 0) {
            selectInstance2.selectInRegistrationPhase(Unit.INSTANCE);
        } else {
            Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.selects.OnTimeout$register$$inlined$Runnable$1
                @Override // java.lang.Runnable
                public final void run() {
                    SelectInstance.this.trySelect(onTimeout2, Unit.INSTANCE);
                }
            };
            Intrinsics.checkNotNull(selectInstance2, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            CoroutineContext context = selectInstance2.getContext();
            selectInstance2.disposeOnCompletion(DelayKt.getDelay(context).invokeOnTimeout(j, runnable, context));
        }
        return Unit.INSTANCE;
    }
}
