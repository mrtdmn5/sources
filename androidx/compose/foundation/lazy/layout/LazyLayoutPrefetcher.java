package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.View;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.SubcomposeLayoutState;

/* compiled from: LazyLayoutPrefetcher.android.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPrefetcher implements RememberObserver, LazyLayoutPrefetchState.Prefetcher, Runnable, Choreographer.FrameCallback {
    public static long frameIntervalNs;
    public long averagePrecomposeTimeNs;
    public long averagePremeasureTimeNs;
    public final Choreographer choreographer;
    public boolean isActive;
    public final LazyLayoutItemContentFactory itemContentFactory;
    public final MutableVector<PrefetchRequest> prefetchRequests;
    public boolean prefetchScheduled;
    public final LazyLayoutPrefetchState prefetchState;
    public final SubcomposeLayoutState subcomposeLayoutState;
    public final View view;

    /* compiled from: LazyLayoutPrefetcher.android.kt */
    /* loaded from: classes.dex */
    public static final class PrefetchRequest implements LazyLayoutPrefetchState.PrefetchHandle {
        public boolean canceled;
        public final long constraints;
        public final int index;
        public SubcomposeLayoutState.PrecomposedSlotHandle precomposeHandle;

        public PrefetchRequest(int r1, long j) {
            this.index = r1;
            this.constraints = j;
        }

        @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.PrefetchHandle
        public final void cancel() {
            if (!this.canceled) {
                this.canceled = true;
                SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = this.precomposeHandle;
                if (precomposedSlotHandle != null) {
                    precomposedSlotHandle.dispose();
                }
                this.precomposeHandle = null;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x004e, code lost:            if (r3 >= 30.0f) goto L25;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LazyLayoutPrefetcher(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r3, androidx.compose.ui.layout.SubcomposeLayoutState r4, androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory r5, android.view.View r6) {
        /*
            r2 = this;
            java.lang.String r0 = "prefetchState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "subcomposeLayoutState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "itemContentFactory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r2.<init>()
            r2.prefetchState = r3
            r2.subcomposeLayoutState = r4
            r2.itemContentFactory = r5
            r2.view = r6
            androidx.compose.runtime.collection.MutableVector r3 = new androidx.compose.runtime.collection.MutableVector
            r4 = 16
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher$PrefetchRequest[] r4 = new androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.PrefetchRequest[r4]
            r3.<init>(r4)
            r2.prefetchRequests = r3
            android.view.Choreographer r3 = android.view.Choreographer.getInstance()
            r2.choreographer = r3
            long r3 = androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.frameIntervalNs
            r0 = 0
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 != 0) goto L5b
            android.view.Display r3 = r6.getDisplay()
            boolean r4 = r6.isInEditMode()
            if (r4 != 0) goto L51
            if (r3 == 0) goto L51
            float r3 = r3.getRefreshRate()
            r4 = 1106247680(0x41f00000, float:30.0)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 < 0) goto L51
            goto L53
        L51:
            r3 = 1114636288(0x42700000, float:60.0)
        L53:
            r4 = 1000000000(0x3b9aca00, float:0.0047237873)
            float r4 = (float) r4
            float r4 = r4 / r3
            long r3 = (long) r4
            androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.frameIntervalNs = r3
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.<init>(androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState, androidx.compose.ui.layout.SubcomposeLayoutState, androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory, android.view.View):void");
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.isActive) {
            this.view.post(this);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onForgotten() {
        this.isActive = false;
        this.prefetchState.prefetcher = null;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onRemembered() {
        this.prefetchState.prefetcher = this;
        this.isActive = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007a A[Catch: all -> 0x00af, TryCatch #1 {all -> 0x00af, blocks: (B:29:0x0064, B:31:0x006e, B:36:0x007a, B:39:0x00a3, B:40:0x00a7, B:44:0x009b), top: B:28:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ce A[Catch: all -> 0x0111, TryCatch #0 {all -> 0x0111, blocks: (B:54:0x00b9, B:56:0x00c3, B:61:0x00ce, B:63:0x00da, B:65:0x00e7, B:68:0x00fd, B:70:0x00f5, B:71:0x0104), top: B:53:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104 A[Catch: all -> 0x0111, TRY_LEAVE, TryCatch #0 {all -> 0x0111, blocks: (B:54:0x00b9, B:56:0x00c3, B:61:0x00ce, B:63:0x00da, B:65:0x00e7, B:68:0x00fd, B:70:0x00f5, B:71:0x0104), top: B:53:0x00b9 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher.run():void");
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState.Prefetcher
    /* renamed from: schedulePrefetch-0kLqBqw */
    public final PrefetchRequest mo103schedulePrefetch0kLqBqw(int r2, long j) {
        PrefetchRequest prefetchRequest = new PrefetchRequest(r2, j);
        this.prefetchRequests.add(prefetchRequest);
        if (!this.prefetchScheduled) {
            this.prefetchScheduled = true;
            this.view.post(this);
        }
        return prefetchRequest;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final void onAbandoned() {
    }
}
