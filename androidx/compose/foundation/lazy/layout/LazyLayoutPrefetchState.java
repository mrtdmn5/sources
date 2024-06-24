package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher;

/* compiled from: LazyLayoutPrefetchState.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPrefetchState {
    public Prefetcher prefetcher;

    /* compiled from: LazyLayoutPrefetchState.kt */
    /* loaded from: classes.dex */
    public interface PrefetchHandle {
        void cancel();
    }

    /* compiled from: LazyLayoutPrefetchState.kt */
    /* loaded from: classes.dex */
    public interface Prefetcher {
        /* renamed from: schedulePrefetch-0kLqBqw, reason: not valid java name */
        LazyLayoutPrefetcher.PrefetchRequest mo103schedulePrefetch0kLqBqw(int r1, long j);
    }
}
