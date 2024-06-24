package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext foldCopies(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z) {
        Boolean bool = Boolean.FALSE;
        CoroutineContextKt$hasCopyableElements$1 coroutineContextKt$hasCopyableElements$1 = CoroutineContextKt$hasCopyableElements$1.INSTANCE;
        boolean booleanValue = ((Boolean) coroutineContext.fold(bool, coroutineContextKt$hasCopyableElements$1)).booleanValue();
        boolean booleanValue2 = ((Boolean) coroutineContext2.fold(bool, coroutineContextKt$hasCopyableElements$1)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r1v5, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // kotlin.jvm.functions.Function2
            public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                CoroutineContext coroutineContext5 = coroutineContext4;
                CoroutineContext.Element element2 = element;
                if (!(element2 instanceof CopyableThreadContextElement)) {
                    return coroutineContext5.plus(element2);
                }
                Ref$ObjectRef<CoroutineContext> ref$ObjectRef2 = ref$ObjectRef;
                if (ref$ObjectRef2.element.get(element2.getKey()) == null) {
                    CopyableThreadContextElement copyableThreadContextElement = (CopyableThreadContextElement) element2;
                    if (z) {
                        copyableThreadContextElement = copyableThreadContextElement.copyForChild();
                    }
                    return coroutineContext5.plus(copyableThreadContextElement);
                }
                ref$ObjectRef2.element = ref$ObjectRef2.element.minusKey(element2.getKey());
                return coroutineContext5.plus(((CopyableThreadContextElement) element2).mergeForChild());
            }
        });
        if (booleanValue2) {
            ref$ObjectRef.element = ((CoroutineContext) ref$ObjectRef.element).fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // kotlin.jvm.functions.Function2
                public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                    CoroutineContext coroutineContext5 = coroutineContext4;
                    CoroutineContext.Element element2 = element;
                    if (element2 instanceof CopyableThreadContextElement) {
                        return coroutineContext5.plus(((CopyableThreadContextElement) element2).copyForChild());
                    }
                    return coroutineContext5.plus(element2);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) ref$ObjectRef.element);
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope coroutineScope, CoroutineContext coroutineContext) {
        CoroutineContext foldCopies = foldCopies(coroutineScope.getCoroutineContext(), coroutineContext, true);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        if (foldCopies != defaultScheduler && foldCopies.get(ContinuationInterceptor.Key.$$INSTANCE) == null) {
            return foldCopies.plus(defaultScheduler);
        }
        return foldCopies;
    }

    public static final UndispatchedCoroutine<?> updateUndispatchedCompletion(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        boolean z;
        UndispatchedCoroutine<?> undispatchedCoroutine = null;
        if (!(continuation instanceof CoroutineStackFrame)) {
            return null;
        }
        if (coroutineContext.get(UndispatchedMarker.INSTANCE) != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return null;
        }
        CoroutineStackFrame coroutineStackFrame = (CoroutineStackFrame) continuation;
        while (true) {
            if ((coroutineStackFrame instanceof DispatchedCoroutine) || (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) == null) {
                break;
            }
            if (coroutineStackFrame instanceof UndispatchedCoroutine) {
                undispatchedCoroutine = (UndispatchedCoroutine) coroutineStackFrame;
                break;
            }
        }
        if (undispatchedCoroutine != null) {
            undispatchedCoroutine.saveThreadContext(coroutineContext, obj);
        }
        return undispatchedCoroutine;
    }
}
