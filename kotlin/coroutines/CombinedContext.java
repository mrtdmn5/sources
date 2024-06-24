package kotlin.coroutines;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CoroutineContextImpl.kt */
/* loaded from: classes.dex */
public final class CombinedContext implements CoroutineContext, Serializable {
    public final CoroutineContext.Element element;
    public final CoroutineContext left;

    public CombinedContext(CoroutineContext.Element element, CoroutineContext left) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(element, "element");
        this.left = left;
        this.element = element;
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (!(obj instanceof CombinedContext)) {
                return false;
            }
            CombinedContext combinedContext = (CombinedContext) obj;
            combinedContext.getClass();
            int r0 = 2;
            CombinedContext combinedContext2 = combinedContext;
            int r3 = 2;
            while (true) {
                CoroutineContext coroutineContext = combinedContext2.left;
                if (coroutineContext instanceof CombinedContext) {
                    combinedContext2 = (CombinedContext) coroutineContext;
                } else {
                    combinedContext2 = null;
                }
                if (combinedContext2 == null) {
                    break;
                }
                r3++;
            }
            CombinedContext combinedContext3 = this;
            while (true) {
                CoroutineContext coroutineContext2 = combinedContext3.left;
                if (coroutineContext2 instanceof CombinedContext) {
                    combinedContext3 = (CombinedContext) coroutineContext2;
                } else {
                    combinedContext3 = null;
                }
                if (combinedContext3 == null) {
                    break;
                }
                r0++;
            }
            if (r3 != r0) {
                return false;
            }
            CombinedContext combinedContext4 = this;
            while (true) {
                CoroutineContext.Element element = combinedContext4.element;
                if (!Intrinsics.areEqual(combinedContext.get(element.getKey()), element)) {
                    z = false;
                    break;
                }
                CoroutineContext coroutineContext3 = combinedContext4.left;
                if (coroutineContext3 instanceof CombinedContext) {
                    combinedContext4 = (CombinedContext) coroutineContext3;
                } else {
                    Intrinsics.checkNotNull(coroutineContext3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                    CoroutineContext.Element element2 = (CoroutineContext.Element) coroutineContext3;
                    z = Intrinsics.areEqual(combinedContext.get(element2.getKey()), element2);
                    break;
                }
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return operation.invoke((Object) this.left.fold(r, operation), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e = (E) combinedContext.element.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext.left;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                return (E) coroutineContext.get(key);
            }
        }
    }

    public final int hashCode() {
        return this.element.hashCode() + this.left.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        CoroutineContext.Element element = this.element;
        CoroutineContext.Element element2 = element.get(key);
        CoroutineContext coroutineContext = this.left;
        if (element2 != null) {
            return coroutineContext;
        }
        CoroutineContext minusKey = coroutineContext.minusKey(key);
        if (minusKey == coroutineContext) {
            return this;
        }
        if (minusKey != EmptyCoroutineContext.INSTANCE) {
            return new CombinedContext(element, minusKey);
        }
        return element;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public final CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.plus(this, coroutineContext);
    }

    public final String toString() {
        return OpaqueKey$$ExternalSyntheticOutline0.m(new StringBuilder("["), (String) fold("", new Function2<String, CoroutineContext.Element, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, CoroutineContext.Element element) {
                boolean z;
                String acc = str;
                CoroutineContext.Element element2 = element;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element2, "element");
                if (acc.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    return element2.toString();
                }
                return acc + ", " + element2;
            }
        }), ']');
    }
}
