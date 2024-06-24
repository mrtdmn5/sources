package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import com.airbnb.lottie.L;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListState.kt */
/* loaded from: classes.dex */
public final class LazyListState implements ScrollableState {
    public static final SaverKt$Saver$1 Saver = L.listSaver(new Function2<SaverScope, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final List<? extends Integer> invoke(SaverScope saverScope, LazyListState lazyListState) {
            SaverScope listSaver = saverScope;
            LazyListState it = lazyListState;
            Intrinsics.checkNotNullParameter(listSaver, "$this$listSaver");
            Intrinsics.checkNotNullParameter(it, "it");
            return CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(it.getFirstVisibleItemIndex()), Integer.valueOf(it.getFirstVisibleItemScrollOffset())});
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final LazyListState invoke(List<? extends Integer> list) {
            List<? extends Integer> it = list;
            Intrinsics.checkNotNullParameter(it, "it");
            return new LazyListState(it.get(0).intValue(), it.get(1).intValue());
        }
    });
    public final LazyListAnimateScrollScope animateScrollScope;
    public final AwaitFirstLayoutModifier awaitLayoutModifier;
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    public Density density;
    public int indexToPrefetch;
    public final MutableInteractionSourceImpl internalInteractionSource;
    public final ParcelableSnapshotMutableState layoutInfoState;
    public final LazyLayoutPinnedItemList pinnedItems;
    public final LazyListItemPlacementAnimator placementAnimator;
    public final LazyLayoutPrefetchState prefetchState;
    public final boolean prefetchingEnabled;
    public long premeasureConstraints;
    public Remeasurement remeasurement;
    public final LazyListState$remeasurementModifier$1 remeasurementModifier;
    public final LazyListScrollPosition scrollPosition;
    public float scrollToBeConsumed;
    public final DefaultScrollableState scrollableState;
    public boolean wasScrollingForward;

    /* JADX WARN: Type inference failed for: r2v9, types: [androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1] */
    public LazyListState(int r2, int r3) {
        this.scrollPosition = new LazyListScrollPosition(r2, r3);
        this.animateScrollScope = new LazyListAnimateScrollScope(this);
        this.layoutInfoState = Platform.mutableStateOf$default(EmptyLazyListLayoutInfo.INSTANCE);
        this.internalInteractionSource = new MutableInteractionSourceImpl();
        this.density = new DensityImpl(1.0f, 1.0f);
        this.scrollableState = new DefaultScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.LazyListState$scrollableState$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Float invoke(Float f) {
                boolean z;
                boolean z2;
                int index;
                LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
                LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
                float f2 = -f.floatValue();
                LazyListState lazyListState = LazyListState.this;
                if ((f2 < 0.0f && !lazyListState.getCanScrollForward()) || (f2 > 0.0f && !lazyListState.getCanScrollBackward())) {
                    f2 = 0.0f;
                } else {
                    boolean z3 = true;
                    if (Math.abs(lazyListState.scrollToBeConsumed) <= 0.5f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        float f3 = lazyListState.scrollToBeConsumed + f2;
                        lazyListState.scrollToBeConsumed = f3;
                        if (Math.abs(f3) > 0.5f) {
                            float f4 = lazyListState.scrollToBeConsumed;
                            Remeasurement remeasurement = lazyListState.remeasurement;
                            if (remeasurement != null) {
                                remeasurement.forceRemeasure();
                            }
                            boolean z4 = lazyListState.prefetchingEnabled;
                            if (z4) {
                                float f5 = f4 - lazyListState.scrollToBeConsumed;
                                if (z4) {
                                    LazyListLayoutInfo layoutInfo = lazyListState.getLayoutInfo();
                                    if (!layoutInfo.getVisibleItemsInfo().isEmpty()) {
                                        if (f5 < 0.0f) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        if (z2) {
                                            index = ((LazyListItemInfo) CollectionsKt___CollectionsKt.last(layoutInfo.getVisibleItemsInfo())).getIndex() + 1;
                                        } else {
                                            index = ((LazyListItemInfo) CollectionsKt___CollectionsKt.first((List) layoutInfo.getVisibleItemsInfo())).getIndex() - 1;
                                        }
                                        if (index != lazyListState.indexToPrefetch) {
                                            if (index < 0 || index >= layoutInfo.getTotalItemsCount()) {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                if (lazyListState.wasScrollingForward != z2 && (prefetchHandle2 = lazyListState.currentPrefetchHandle) != null) {
                                                    prefetchHandle2.cancel();
                                                }
                                                lazyListState.wasScrollingForward = z2;
                                                lazyListState.indexToPrefetch = index;
                                                long j = lazyListState.premeasureConstraints;
                                                LazyLayoutPrefetchState.Prefetcher prefetcher = lazyListState.prefetchState.prefetcher;
                                                if (prefetcher == null || (prefetchHandle = prefetcher.mo103schedulePrefetch0kLqBqw(index, j)) == null) {
                                                    prefetchHandle = DummyHandle.INSTANCE;
                                                }
                                                lazyListState.currentPrefetchHandle = prefetchHandle;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (Math.abs(lazyListState.scrollToBeConsumed) > 0.5f) {
                            f2 -= lazyListState.scrollToBeConsumed;
                            lazyListState.scrollToBeConsumed = 0.0f;
                        }
                    } else {
                        throw new IllegalStateException(("entered drag with non-zero pending scroll: " + lazyListState.scrollToBeConsumed).toString());
                    }
                }
                return Float.valueOf(-f2);
            }
        });
        this.prefetchingEnabled = true;
        this.indexToPrefetch = -1;
        this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public final void onRemeasurementAvailable(LayoutNode remeasurement) {
                Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
                LazyListState.this.remeasurement = remeasurement;
            }
        };
        this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
        this.placementAnimator = new LazyListItemPlacementAnimator();
        this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
        this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 15);
        this.pinnedItems = new LazyLayoutPinnedItemList();
        Boolean bool = Boolean.FALSE;
        this.canScrollForward$delegate = Platform.mutableStateOf$default(bool);
        this.canScrollBackward$delegate = Platform.mutableStateOf$default(bool);
        this.prefetchState = new LazyLayoutPrefetchState();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getFirstVisibleItemIndex() {
        return this.scrollPosition.index$delegate.getIntValue();
    }

    public final int getFirstVisibleItemScrollOffset() {
        return this.scrollPosition.scrollOffset$delegate.getIntValue();
    }

    public final LazyListLayoutInfo getLayoutInfo() {
        return (LazyListLayoutInfo) this.layoutInfoState.getValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0062 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object scroll(androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L63
        L2a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L32:
            kotlin.jvm.functions.Function2 r7 = r0.L$2
            androidx.compose.foundation.MutatePriority r6 = r0.L$1
            androidx.compose.foundation.lazy.LazyListState r2 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L51
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L50
            return r1
        L50:
            r2 = r5
        L51:
            androidx.compose.foundation.gestures.DefaultScrollableState r8 = r2.scrollableState
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.L$2 = r2
            r0.label = r3
            java.lang.Object r6 = r8.scroll(r6, r7, r0)
            if (r6 != r1) goto L63
            return r1
        L63:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.scroll(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public LazyListState() {
        this(0, 0);
    }
}
