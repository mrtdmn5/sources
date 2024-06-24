package androidx.compose.foundation.gestures;

import androidx.compose.foundation.FocusedBoundsKt;
import androidx.compose.foundation.relocation.BringIntoViewResponder;
import androidx.compose.foundation.relocation.BringIntoViewResponderKt;
import androidx.compose.foundation.relocation.BringIntoViewResponderNode$bringChildIntoView$2;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.concurrent.CancellationException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt__CharKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: ContentInViewModifier.kt */
/* loaded from: classes.dex */
public final class ContentInViewModifier implements BringIntoViewResponder, OnRemeasuredModifier, OnPlacedModifier {
    public final UpdatableAnimationState animationState;
    public final BringIntoViewRequestPriorityQueue bringIntoViewRequests;
    public LayoutCoordinates coordinates;
    public LayoutCoordinates focusedChild;
    public Rect focusedChildBoundsFromPreviousRemeasure;
    public boolean isAnimationRunning;
    public final Modifier modifier;
    public final Orientation orientation;
    public final boolean reverseDirection;
    public final CoroutineScope scope;
    public final ScrollableState scrollState;
    public boolean trackingFocusedChild;
    public long viewportSize;

    /* compiled from: ContentInViewModifier.kt */
    /* loaded from: classes.dex */
    public static final class Request {
        public final CancellableContinuation<Unit> continuation;
        public final Function0<Rect> currentBounds;

        public Request(BringIntoViewResponderNode$bringChildIntoView$2.AnonymousClass1.C00111 c00111, CancellableContinuationImpl cancellableContinuationImpl) {
            this.currentBounds = c00111;
            this.continuation = cancellableContinuationImpl;
        }

        public final String toString() {
            String str;
            String str2;
            CancellableContinuation<Unit> cancellableContinuation = this.continuation;
            CoroutineName coroutineName = (CoroutineName) cancellableContinuation.getContext().get(CoroutineName.Key);
            if (coroutineName != null) {
                str = coroutineName.name;
            } else {
                str = null;
            }
            StringBuilder sb = new StringBuilder("Request@");
            int hashCode = hashCode();
            CharsKt__CharKt.checkRadix(16);
            String num = Integer.toString(hashCode, 16);
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            sb.append(num);
            if (str == null || (str2 = zzav$$ExternalSyntheticOutline0.m("[", str, "](")) == null) {
                str2 = "(";
            }
            sb.append(str2);
            sb.append("currentBounds()=");
            sb.append(this.currentBounds.invoke());
            sb.append(", continuation=");
            sb.append(cancellableContinuation);
            sb.append(')');
            return sb.toString();
        }
    }

    /* compiled from: ContentInViewModifier.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Orientation.values().length];
            try {
                r0[Orientation.Vertical.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Orientation.Horizontal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1] */
    public ContentInViewModifier(CoroutineScope scope, Orientation orientation, ScrollableState scrollState, boolean z) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(scrollState, "scrollState");
        this.scope = scope;
        this.orientation = orientation;
        this.scrollState = scrollState;
        this.reverseDirection = z;
        this.bringIntoViewRequests = new BringIntoViewRequestPriorityQueue();
        this.viewportSize = 0L;
        this.animationState = new UpdatableAnimationState();
        this.modifier = BringIntoViewResponderKt.bringIntoViewResponder(FocusedBoundsKt.onFocusedBoundsChanged(this, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewModifier$modifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(LayoutCoordinates layoutCoordinates) {
                ContentInViewModifier.this.focusedChild = layoutCoordinates;
                return Unit.INSTANCE;
            }
        }), this);
    }

    public static final float access$calculateScrollDelta(ContentInViewModifier contentInViewModifier) {
        Rect rect;
        int compare;
        if (!IntSize.m592equalsimpl0(contentInViewModifier.viewportSize, 0L)) {
            MutableVector<Request> mutableVector = contentInViewModifier.bringIntoViewRequests.requests;
            int r1 = mutableVector.size;
            Orientation orientation = contentInViewModifier.orientation;
            Rect rect2 = null;
            if (r1 > 0) {
                int r12 = r1 - 1;
                Request[] requestArr = mutableVector.content;
                rect = null;
                do {
                    Rect invoke = requestArr[r12].currentBounds.invoke();
                    if (invoke != null) {
                        long Size = SizeKt.Size(invoke.right - invoke.left, invoke.bottom - invoke.top);
                        long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(contentInViewModifier.viewportSize);
                        int r122 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
                        if (r122 != 1) {
                            if (r122 == 2) {
                                compare = Float.compare(Size.m276getWidthimpl(Size), Size.m276getWidthimpl(m595toSizeozmzZPI));
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        } else {
                            compare = Float.compare(Size.m274getHeightimpl(Size), Size.m274getHeightimpl(m595toSizeozmzZPI));
                        }
                        if (compare > 0) {
                            break;
                        }
                        rect = invoke;
                    }
                    r12--;
                } while (r12 >= 0);
            } else {
                rect = null;
            }
            if (rect == null) {
                if (contentInViewModifier.trackingFocusedChild) {
                    rect2 = contentInViewModifier.getFocusedChildBounds();
                }
                if (rect2 != null) {
                    rect = rect2;
                }
            }
            long m595toSizeozmzZPI2 = IntSizeKt.m595toSizeozmzZPI(contentInViewModifier.viewportSize);
            int r14 = WhenMappings.$EnumSwitchMapping$0[orientation.ordinal()];
            if (r14 != 1) {
                if (r14 == 2) {
                    return relocationDistance(rect.left, rect.right, Size.m276getWidthimpl(m595toSizeozmzZPI2));
                }
                throw new NoWhenBranchMatchedException();
            }
            return relocationDistance(rect.top, rect.bottom, Size.m274getHeightimpl(m595toSizeozmzZPI2));
        }
        return 0.0f;
    }

    public static float relocationDistance(float f, float f2, float f3) {
        if ((f >= 0.0f && f2 <= f3) || (f < 0.0f && f2 > f3)) {
            return 0.0f;
        }
        float f4 = f2 - f3;
        if (Math.abs(f) >= Math.abs(f4)) {
            return f4;
        }
        return f;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public final Object bringChildIntoView(BringIntoViewResponderNode$bringChildIntoView$2.AnonymousClass1.C00111 c00111, Continuation continuation) {
        boolean z;
        Rect rect = (Rect) c00111.invoke();
        boolean z2 = false;
        if (rect != null && !Offset.m257equalsimpl0(m34relocationOffsetBMxPBkI(this.viewportSize, rect), Offset.Zero)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(1, IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        cancellableContinuationImpl.initCancellability();
        final Request request = new Request(c00111, cancellableContinuationImpl);
        final BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = this.bringIntoViewRequests;
        bringIntoViewRequestPriorityQueue.getClass();
        Rect invoke = c00111.invoke();
        if (invoke == null) {
            cancellableContinuationImpl.resumeWith(Unit.INSTANCE);
        } else {
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.foundation.gestures.BringIntoViewRequestPriorityQueue$enqueue$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Throwable th) {
                    BringIntoViewRequestPriorityQueue.this.requests.remove(request);
                    return Unit.INSTANCE;
                }
            });
            MutableVector<Request> mutableVector = bringIntoViewRequestPriorityQueue.requests;
            int r4 = new IntRange(0, mutableVector.size - 1).last;
            if (r4 >= 0) {
                while (true) {
                    Rect invoke2 = mutableVector.content[r4].currentBounds.invoke();
                    if (invoke2 != null) {
                        Rect intersect = invoke.intersect(invoke2);
                        if (Intrinsics.areEqual(intersect, invoke)) {
                            mutableVector.add(r4 + 1, request);
                            break;
                        }
                        if (!Intrinsics.areEqual(intersect, invoke2)) {
                            CancellationException cancellationException = new CancellationException("bringIntoView call interrupted by a newer, non-overlapping call");
                            int r6 = mutableVector.size - 1;
                            if (r6 <= r4) {
                                while (true) {
                                    mutableVector.content[r4].continuation.cancel(cancellationException);
                                    if (r6 == r4) {
                                        break;
                                    }
                                    r6++;
                                }
                            }
                        }
                    }
                    if (r4 == 0) {
                        break;
                    }
                    r4--;
                }
            }
            mutableVector.add(0, request);
            z2 = true;
        }
        if (z2 && !this.isAnimationRunning) {
            launchAnimation();
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return result;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.relocation.BringIntoViewResponder
    public final Rect calculateRectForParent(Rect rect) {
        if (!IntSize.m592equalsimpl0(this.viewportSize, 0L)) {
            long m34relocationOffsetBMxPBkI = m34relocationOffsetBMxPBkI(this.viewportSize, rect);
            return rect.m270translatek4lQ0M(OffsetKt.Offset(-Offset.m259getXimpl(m34relocationOffsetBMxPBkI), -Offset.m260getYimpl(m34relocationOffsetBMxPBkI)));
        }
        throw new IllegalStateException("Expected BringIntoViewRequester to not be used before parents are placed.".toString());
    }

    public final Rect getFocusedChildBounds() {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.coordinates;
        if (layoutCoordinates2 != null) {
            if (!layoutCoordinates2.isAttached()) {
                layoutCoordinates2 = null;
            }
            if (layoutCoordinates2 != null && (layoutCoordinates = this.focusedChild) != null) {
                if (!layoutCoordinates.isAttached()) {
                    layoutCoordinates = null;
                }
                if (layoutCoordinates != null) {
                    return layoutCoordinates2.localBoundingBoxOf(layoutCoordinates, false);
                }
            }
        }
        return null;
    }

    public final void launchAnimation() {
        if (!this.isAnimationRunning) {
            BuildersKt.launch$default(this.scope, null, CoroutineStart.UNDISPATCHED, new ContentInViewModifier$launchAnimation$1(this, null), 1);
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.ui.layout.OnPlacedModifier
    public final void onPlaced(NodeCoordinator coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.coordinates = coordinates;
    }

    @Override // androidx.compose.ui.layout.OnRemeasuredModifier
    /* renamed from: onRemeasured-ozmzZPI */
    public final void mo33onRemeasuredozmzZPI(long j) {
        int compare;
        Rect focusedChildBounds;
        long j2 = this.viewportSize;
        this.viewportSize = j;
        int r2 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                compare = Intrinsics.compare((int) (j >> 32), (int) (j2 >> 32));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            compare = Intrinsics.compare(IntSize.m593getHeightimpl(j), IntSize.m593getHeightimpl(j2));
        }
        if (compare < 0 && (focusedChildBounds = getFocusedChildBounds()) != null) {
            Rect rect = this.focusedChildBoundsFromPreviousRemeasure;
            if (rect == null) {
                rect = focusedChildBounds;
            }
            if (!this.isAnimationRunning && !this.trackingFocusedChild) {
                long m34relocationOffsetBMxPBkI = m34relocationOffsetBMxPBkI(j2, rect);
                long j3 = Offset.Zero;
                if (Offset.m257equalsimpl0(m34relocationOffsetBMxPBkI, j3) && !Offset.m257equalsimpl0(m34relocationOffsetBMxPBkI(j, focusedChildBounds), j3)) {
                    this.trackingFocusedChild = true;
                    launchAnimation();
                }
            }
            this.focusedChildBoundsFromPreviousRemeasure = focusedChildBounds;
        }
    }

    /* renamed from: relocationOffset-BMxPBkI */
    public final long m34relocationOffsetBMxPBkI(long j, Rect rect) {
        long m595toSizeozmzZPI = IntSizeKt.m595toSizeozmzZPI(j);
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.orientation.ordinal()];
        if (r0 != 1) {
            if (r0 == 2) {
                float m276getWidthimpl = Size.m276getWidthimpl(m595toSizeozmzZPI);
                return OffsetKt.Offset(relocationDistance(rect.left, rect.right, m276getWidthimpl), 0.0f);
            }
            throw new NoWhenBranchMatchedException();
        }
        float m274getHeightimpl = Size.m274getHeightimpl(m595toSizeozmzZPI);
        return OffsetKt.Offset(0.0f, relocationDistance(rect.top, rect.bottom, m274getHeightimpl));
    }
}
