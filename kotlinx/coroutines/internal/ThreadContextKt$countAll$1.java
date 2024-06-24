package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.ThreadContextElement;

/* compiled from: ThreadContext.kt */
/* loaded from: classes4.dex */
public final class ThreadContextKt$countAll$1 extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {
    public static final ThreadContextKt$countAll$1 INSTANCE = new ThreadContextKt$countAll$1();

    public ThreadContextKt$countAll$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, CoroutineContext.Element element) {
        Integer num;
        int r2;
        CoroutineContext.Element element2 = element;
        if (element2 instanceof ThreadContextElement) {
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                r2 = num.intValue();
            } else {
                r2 = 1;
            }
            if (r2 == 0) {
                return element2;
            }
            return Integer.valueOf(r2 + 1);
        }
        return obj;
    }
}
