package androidx.compose.foundation.pager;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.DummyHandle;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableFloatState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.StructuralEqualityPolicy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.google.common.base.Objects;
import com.google.common.collect.Platform;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.UStringsKt;

/* compiled from: PagerState.kt */
/* loaded from: classes.dex */
public abstract class PagerState implements ScrollableState {
    public final ParcelableSnapshotMutableIntState animationTargetPage$delegate;
    public final AwaitFirstLayoutModifier awaitLayoutModifier;
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public final ParcelableSnapshotMutableState canScrollBackward$delegate;
    public final ParcelableSnapshotMutableState canScrollForward$delegate;
    public final DerivedSnapshotState currentPageOffsetFraction$delegate;
    public LazyLayoutPrefetchState.PrefetchHandle currentPrefetchHandle;
    public Density density;
    public int indexToPrefetch;
    public final float initialPageOffsetFraction;
    public final MutableInteractionSourceImpl internalInteractionSource;
    public final ParcelableSnapshotMutableState pagerLayoutInfoState;
    public final LazyLayoutPinnedItemList pinnedPages;
    public final LazyLayoutPrefetchState prefetchState;
    public final boolean prefetchingEnabled;
    public long premeasureConstraints;
    public final ParcelableSnapshotMutableState remeasurement$delegate;
    public final PagerState$remeasurementModifier$1 remeasurementModifier;
    public final PagerScrollPosition scrollPosition;
    public float scrollToBeConsumed;
    public final DefaultScrollableState scrollableState;
    public final DerivedSnapshotState settledPage$delegate;
    public final ParcelableSnapshotMutableIntState settledPageState$delegate;
    public final ParcelableSnapshotMutableFloatState snapRemainingScrollOffset$delegate;
    public final DerivedSnapshotState targetPage$delegate;
    public final ParcelableSnapshotMutableState upDownDifference$delegate;
    public boolean wasScrollingForward;

    /* JADX WARN: Type inference failed for: r8v19, types: [androidx.compose.foundation.pager.PagerState$remeasurementModifier$1] */
    public PagerState(float f, int r9) {
        boolean z;
        this.initialPageOffsetFraction = f;
        double d = f;
        if (-0.5d <= d && d <= 0.5d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.upDownDifference$delegate = Platform.mutableStateOf$default(new Offset(Offset.Zero));
            this.snapRemainingScrollOffset$delegate = Objects.mutableFloatStateOf(0.0f);
            this.scrollPosition = new PagerScrollPosition(r9);
            this.scrollableState = new DefaultScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Float invoke(Float f2) {
                    boolean z2;
                    boolean z3;
                    int index;
                    LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
                    LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
                    float f3 = -f2.floatValue();
                    PagerState pagerState = PagerState.this;
                    if ((f3 < 0.0f && !pagerState.getCanScrollForward()) || (f3 > 0.0f && !pagerState.getCanScrollBackward())) {
                        f3 = 0.0f;
                    } else {
                        boolean z4 = true;
                        if (Math.abs(pagerState.scrollToBeConsumed) <= 0.5f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            float f4 = pagerState.scrollToBeConsumed + f3;
                            pagerState.scrollToBeConsumed = f4;
                            if (Math.abs(f4) > 0.5f) {
                                float f5 = pagerState.scrollToBeConsumed;
                                Remeasurement remeasurement = (Remeasurement) pagerState.remeasurement$delegate.getValue();
                                if (remeasurement != null) {
                                    remeasurement.forceRemeasure();
                                }
                                boolean z5 = pagerState.prefetchingEnabled;
                                if (z5) {
                                    float f6 = f5 - pagerState.scrollToBeConsumed;
                                    if (z5) {
                                        PagerLayoutInfo layoutInfo$foundation_release = pagerState.getLayoutInfo$foundation_release();
                                        if (!layoutInfo$foundation_release.getVisiblePagesInfo().isEmpty()) {
                                            if (f6 < 0.0f) {
                                                z3 = true;
                                            } else {
                                                z3 = false;
                                            }
                                            if (z3) {
                                                index = ((PageInfo) CollectionsKt___CollectionsKt.last(layoutInfo$foundation_release.getVisiblePagesInfo())).getIndex() + 1;
                                            } else {
                                                index = ((PageInfo) CollectionsKt___CollectionsKt.first((List) layoutInfo$foundation_release.getVisiblePagesInfo())).getIndex() - 1;
                                            }
                                            if (index != pagerState.indexToPrefetch) {
                                                if (index < 0 || index >= layoutInfo$foundation_release.getPagesCount()) {
                                                    z4 = false;
                                                }
                                                if (z4) {
                                                    if (pagerState.wasScrollingForward != z3 && (prefetchHandle2 = pagerState.currentPrefetchHandle) != null) {
                                                        prefetchHandle2.cancel();
                                                    }
                                                    pagerState.wasScrollingForward = z3;
                                                    pagerState.indexToPrefetch = index;
                                                    long j = pagerState.premeasureConstraints;
                                                    LazyLayoutPrefetchState.Prefetcher prefetcher = pagerState.prefetchState.prefetcher;
                                                    if (prefetcher == null || (prefetchHandle = prefetcher.mo103schedulePrefetch0kLqBqw(index, j)) == null) {
                                                        prefetchHandle = DummyHandle.INSTANCE;
                                                    }
                                                    pagerState.currentPrefetchHandle = prefetchHandle;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (Math.abs(pagerState.scrollToBeConsumed) > 0.5f) {
                                f3 -= pagerState.scrollToBeConsumed;
                                pagerState.scrollToBeConsumed = 0.0f;
                            }
                        } else {
                            throw new IllegalStateException(("entered drag with non-zero pending scroll: " + pagerState.scrollToBeConsumed).toString());
                        }
                    }
                    return Float.valueOf(-f3);
                }
            });
            this.prefetchingEnabled = true;
            this.indexToPrefetch = -1;
            this.pagerLayoutInfoState = Platform.mutableStateOf$default(PagerStateKt.EmptyLayoutInfo);
            this.density = PagerStateKt.UnitDensity;
            this.internalInteractionSource = new MutableInteractionSourceImpl();
            this.animationTargetPage$delegate = UStringsKt.mutableIntStateOf(-1);
            this.settledPageState$delegate = UStringsKt.mutableIntStateOf(r9);
            StructuralEqualityPolicy structuralEqualityPolicy = StructuralEqualityPolicy.INSTANCE;
            this.settledPage$delegate = Platform.derivedStateOf(structuralEqualityPolicy, new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    int currentPage;
                    PagerState pagerState = PagerState.this;
                    if (pagerState.isScrollInProgress()) {
                        currentPage = pagerState.settledPageState$delegate.getIntValue();
                    } else {
                        currentPage = pagerState.getCurrentPage();
                    }
                    return Integer.valueOf(currentPage);
                }
            });
            this.targetPage$delegate = Platform.derivedStateOf(structuralEqualityPolicy, new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    boolean z2;
                    int currentPage;
                    int roundToInt;
                    int r1;
                    PagerState pagerState = PagerState.this;
                    if (!pagerState.isScrollInProgress()) {
                        r1 = pagerState.getCurrentPage();
                    } else {
                        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = pagerState.animationTargetPage$delegate;
                        if (parcelableSnapshotMutableIntState.getIntValue() != -1) {
                            r1 = parcelableSnapshotMutableIntState.getIntValue();
                        } else {
                            ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = pagerState.snapRemainingScrollOffset$delegate;
                            if (parcelableSnapshotMutableFloatState.getFloatValue() == 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (Math.abs(pagerState.getCurrentPageOffsetFraction()) >= Math.abs(Math.min(pagerState.density.mo49toPx0680j_4(PagerStateKt.DefaultPositionThreshold), pagerState.getPageSize$foundation_release() / 2.0f) / pagerState.getPageSize$foundation_release())) {
                                    roundToInt = pagerState.getCurrentPage();
                                    currentPage = (int) Math.signum(pagerState.getCurrentPageOffsetFraction());
                                } else {
                                    r1 = pagerState.getCurrentPage();
                                }
                            } else {
                                float floatValue = parcelableSnapshotMutableFloatState.getFloatValue() / pagerState.getPageAvailableSpace();
                                currentPage = pagerState.getCurrentPage();
                                roundToInt = MathKt__MathJVMKt.roundToInt(floatValue);
                            }
                            r1 = roundToInt + currentPage;
                        }
                    }
                    return Integer.valueOf(pagerState.coerceInPageRange(r1));
                }
            });
            this.currentPageOffsetFraction$delegate = Platform.derivedStateOf(structuralEqualityPolicy, new Function0<Float>() { // from class: androidx.compose.foundation.pager.PagerState$currentPageOffsetFraction$2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    PageInfo pageInfo;
                    int r1;
                    float coerceIn;
                    boolean z2;
                    PagerState pagerState = PagerState.this;
                    List<PageInfo> visiblePagesInfo = pagerState.getLayoutInfo$foundation_release().getVisiblePagesInfo();
                    int size = visiblePagesInfo.size();
                    boolean z3 = false;
                    int r4 = 0;
                    while (true) {
                        if (r4 < size) {
                            pageInfo = visiblePagesInfo.get(r4);
                            if (pageInfo.getIndex() == pagerState.getCurrentPage()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                break;
                            }
                            r4++;
                        } else {
                            pageInfo = null;
                            break;
                        }
                    }
                    PageInfo pageInfo2 = pageInfo;
                    if (pageInfo2 != null) {
                        r1 = pageInfo2.getOffset();
                    } else {
                        r1 = 0;
                    }
                    float pageAvailableSpace = pagerState.getPageAvailableSpace();
                    if (pageAvailableSpace == 0.0f) {
                        z3 = true;
                    }
                    if (z3) {
                        coerceIn = pagerState.initialPageOffsetFraction;
                    } else {
                        coerceIn = RangesKt___RangesKt.coerceIn((-r1) / pageAvailableSpace, -0.5f, 0.5f);
                    }
                    return Float.valueOf(coerceIn);
                }
            });
            this.prefetchState = new LazyLayoutPrefetchState();
            this.beyondBoundsInfo = new LazyLayoutBeyondBoundsInfo();
            this.awaitLayoutModifier = new AwaitFirstLayoutModifier();
            this.remeasurement$delegate = Platform.mutableStateOf$default(null);
            this.remeasurementModifier = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
                @Override // androidx.compose.ui.layout.RemeasurementModifier
                public final void onRemeasurementAvailable(LayoutNode remeasurement) {
                    Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
                    PagerState.this.remeasurement$delegate.setValue(remeasurement);
                }
            };
            this.premeasureConstraints = ConstraintsKt.Constraints$default(0, 0, 15);
            this.pinnedPages = new LazyLayoutPinnedItemList();
            Boolean bool = Boolean.FALSE;
            this.canScrollForward$delegate = Platform.mutableStateOf$default(bool);
            this.canScrollBackward$delegate = Platform.mutableStateOf$default(bool);
            return;
        }
        throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("initialPageOffsetFraction ", f, " is not within the range -0.5 to 0.5").toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Object scroll$suspendImpl(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2<? super androidx.compose.foundation.gestures.ScrollScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState$scroll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
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
            goto L67
        L2a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L32:
            kotlin.jvm.functions.Function2 r7 = r0.L$2
            androidx.compose.foundation.MutatePriority r6 = r0.L$1
            androidx.compose.foundation.pager.PagerState r5 = r0.L$0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L55
        L3c:
            kotlin.ResultKt.throwOnFailure(r8)
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r7
            r0.label = r4
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.awaitLayoutModifier
            java.lang.Object r8 = r8.waitForFirstLayout(r0)
            if (r8 != r1) goto L50
            goto L52
        L50:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
        L52:
            if (r8 != r1) goto L55
            return r1
        L55:
            androidx.compose.foundation.gestures.DefaultScrollableState r5 = r5.scrollableState
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r5 = r5.scroll(r6, r7, r0)
            if (r5 != r1) goto L67
            return r1
        L67:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.scroll$suspendImpl(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static Object scrollToPage$default(PagerState pagerState, int r4, Continuation continuation) {
        Object scroll;
        pagerState.getClass();
        scroll = pagerState.scroll(MutatePriority.Default, new PagerState$scrollToPage$2(pagerState, 0.0f, r4, null), continuation);
        if (scroll != CoroutineSingletons.COROUTINE_SUSPENDED) {
            return Unit.INSTANCE;
        }
        return scroll;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x018b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object animateScrollToPage(int r20, float r21, androidx.compose.animation.core.AnimationSpec<java.lang.Float> r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.animateScrollToPage(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final int coerceInPageRange(int r3) {
        if (getPageCount() <= 0) {
            return 0;
        }
        return RangesKt___RangesKt.coerceIn(r3, 0, getPageCount() - 1);
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

    public final int getCurrentPage() {
        return this.scrollPosition.currentPage$delegate.getIntValue();
    }

    public final float getCurrentPageOffsetFraction() {
        return ((Number) this.currentPageOffsetFraction$delegate.getValue()).floatValue();
    }

    public final int getFirstVisiblePage$foundation_release() {
        return this.scrollPosition.firstVisiblePage$delegate.getIntValue();
    }

    public final PagerLayoutInfo getLayoutInfo$foundation_release() {
        return (PagerLayoutInfo) this.pagerLayoutInfoState.getValue();
    }

    public final int getPageAvailableSpace() {
        return ((PagerLayoutInfo) this.pagerLayoutInfoState.getValue()).getPageSpacing() + getPageSize$foundation_release();
    }

    public abstract int getPageCount();

    public final int getPageSize$foundation_release() {
        return ((PagerLayoutInfo) this.pagerLayoutInfoState.getValue()).getPageSize();
    }

    public final List<PageInfo> getVisiblePages() {
        return ((PagerLayoutInfo) this.pagerLayoutInfoState.getValue()).getVisiblePagesInfo();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        return scroll$suspendImpl(this, mutatePriority, function2, continuation);
    }
}
