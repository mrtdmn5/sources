package androidx.compose.ui.platform;

import kotlin.coroutines.CoroutineContext;

/* compiled from: InfiniteAnimationPolicy.kt */
/* loaded from: classes.dex */
public interface InfiniteAnimationPolicy extends CoroutineContext.Element {

    /* compiled from: InfiniteAnimationPolicy.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key<InfiniteAnimationPolicy> {
        public static final /* synthetic */ Key $$INSTANCE = new Key();
    }

    Object onInfiniteOperation();
}
