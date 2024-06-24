package kotlin.coroutines;

import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes.dex */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static CoroutineContext plus(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (context != EmptyCoroutineContext.INSTANCE) {
                return (CoroutineContext) context.fold(coroutineContext, new Function2<CoroutineContext, Element, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext$plus$1
                    @Override // kotlin.jvm.functions.Function2
                    public final CoroutineContext invoke(CoroutineContext coroutineContext2, CoroutineContext.Element element) {
                        CombinedContext combinedContext;
                        CoroutineContext acc = coroutineContext2;
                        CoroutineContext.Element element2 = element;
                        Intrinsics.checkNotNullParameter(acc, "acc");
                        Intrinsics.checkNotNullParameter(element2, "element");
                        CoroutineContext minusKey = acc.minusKey(element2.getKey());
                        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                        if (minusKey != emptyCoroutineContext) {
                            int r1 = ContinuationInterceptor.$r8$clinit;
                            ContinuationInterceptor.Key key = ContinuationInterceptor.Key.$$INSTANCE;
                            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) minusKey.get(key);
                            if (continuationInterceptor == null) {
                                combinedContext = new CombinedContext(element2, minusKey);
                            } else {
                                CoroutineContext minusKey2 = minusKey.minusKey(key);
                                if (minusKey2 == emptyCoroutineContext) {
                                    return new CombinedContext(continuationInterceptor, element2);
                                }
                                combinedContext = new CombinedContext(continuationInterceptor, new CombinedContext(element2, minusKey2));
                            }
                            return combinedContext;
                        }
                        return element2;
                    }
                });
            }
            return coroutineContext;
        }
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes.dex */
    public interface Element extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        /* loaded from: classes.dex */
        public static final class DefaultImpls {
            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E get(Element element, Key<E> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (!Intrinsics.areEqual(element.getKey(), key)) {
                    return null;
                }
                return element;
            }

            public static CoroutineContext minusKey(Element element, Key<?> key) {
                Intrinsics.checkNotNullParameter(key, "key");
                if (Intrinsics.areEqual(element.getKey(), key)) {
                    return EmptyCoroutineContext.INSTANCE;
                }
                return element;
            }
        }

        Key<?> getKey();
    }

    /* compiled from: CoroutineContext.kt */
    /* loaded from: classes.dex */
    public interface Key<E extends Element> {
    }

    <R> R fold(R r, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
