package aws.smithy.kotlin.runtime.http.engine;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineUtils.kt */
/* loaded from: classes.dex */
public final class SdkRequestContextElement implements CoroutineContext.Element {
    public static final Companion Companion = new Companion();
    public final CoroutineContext callContext;

    /* compiled from: CoroutineUtils.kt */
    /* loaded from: classes.dex */
    public static final class Companion implements CoroutineContext.Key<SdkRequestContextElement> {
    }

    public SdkRequestContextElement(CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.callContext = callContext;
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
