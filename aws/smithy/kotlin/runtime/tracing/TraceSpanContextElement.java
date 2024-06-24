package aws.smithy.kotlin.runtime.tracing;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextUtils.kt */
/* loaded from: classes.dex */
public final class TraceSpanContextElement implements CoroutineContext.Element {
    public static final Companion Companion = new Companion();
    public final TraceSpan traceSpan;

    /* compiled from: CoroutineContextUtils.kt */
    /* loaded from: classes.dex */
    public static final class Companion implements CoroutineContext.Key<TraceSpanContextElement> {
    }

    public TraceSpanContextElement(TraceSpan traceSpan) {
        Intrinsics.checkNotNullParameter(traceSpan, "traceSpan");
        this.traceSpan = traceSpan;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke(r, this);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return (E) CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Companion;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CoroutineContext.DefaultImpls.plus(this, context);
    }
}
