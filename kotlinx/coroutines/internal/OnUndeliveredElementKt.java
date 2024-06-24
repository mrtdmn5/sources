package kotlinx.coroutines.internal;

import kotlin.ExceptionsKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* compiled from: OnUndeliveredElement.kt */
/* loaded from: classes4.dex */
public final class OnUndeliveredElementKt {
    public static final <E> void callUndeliveredElement(Function1<? super E, Unit> function1, E e, CoroutineContext coroutineContext) {
        UndeliveredElementException callUndeliveredElementCatchingException = callUndeliveredElementCatchingException(function1, e, null);
        if (callUndeliveredElementCatchingException != null) {
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, callUndeliveredElementCatchingException);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> UndeliveredElementException callUndeliveredElementCatchingException(Function1<? super E, Unit> function1, E e, UndeliveredElementException undeliveredElementException) {
        try {
            function1.invoke(e);
        } catch (Throwable th) {
            if (undeliveredElementException != null && undeliveredElementException.getCause() != th) {
                ExceptionsKt.addSuppressed(undeliveredElementException, th);
            } else {
                return new UndeliveredElementException("Exception in undelivered element handler for " + e, th);
            }
        }
        return undeliveredElementException;
    }
}
