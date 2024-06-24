package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes4.dex */
public final class CoroutineContextKt$hasCopyableElements$1 extends Lambda implements Function2<Boolean, CoroutineContext.Element, Boolean> {
    public static final CoroutineContextKt$hasCopyableElements$1 INSTANCE = new CoroutineContextKt$hasCopyableElements$1();

    public CoroutineContextKt$hasCopyableElements$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Boolean bool, CoroutineContext.Element element) {
        boolean z;
        CoroutineContext.Element element2 = element;
        if (!bool.booleanValue() && !(element2 instanceof CopyableThreadContextElement)) {
            z = false;
        } else {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
