package kotlinx.coroutines.internal;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes4.dex */
public final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ CoroutineContext $context;
    public final /* synthetic */ Object $element;
    public final /* synthetic */ Function1<Object, Unit> $this_bindCancellationFun;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElementKt$bindCancellationFun$1(Function1<Object, Unit> function1, Object obj, CoroutineContext coroutineContext) {
        super(1);
        this.$this_bindCancellationFun = function1;
        this.$element = obj;
        this.$context = coroutineContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        OnUndeliveredElementKt.callUndeliveredElement(this.$this_bindCancellationFun, this.$element, this.$context);
        return Unit.INSTANCE;
    }
}
