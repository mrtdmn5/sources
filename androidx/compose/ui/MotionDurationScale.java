package androidx.compose.ui;

import kotlin.coroutines.CoroutineContext;

/* compiled from: MotionDurationScale.kt */
/* loaded from: classes.dex */
public interface MotionDurationScale extends CoroutineContext.Element {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* compiled from: MotionDurationScale.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<MotionDurationScale> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    default CoroutineContext.Key<?> getKey() {
        return Key.$$INSTANCE;
    }

    float getScaleFactor();
}
