package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.BeyondBoundsLayout;
import androidx.compose.ui.layout.BeyondBoundsLayoutKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
/* loaded from: classes.dex */
public final class LazyLayoutBeyondBoundsModifierLocal implements ModifierLocalProvider<BeyondBoundsLayout>, BeyondBoundsLayout {
    public static final LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1 emptyBeyondBoundsScope = new LazyLayoutBeyondBoundsModifierLocal$Companion$emptyBeyondBoundsScope$1();
    public final LazyLayoutBeyondBoundsInfo beyondBoundsInfo;
    public final LayoutDirection layoutDirection;
    public final Orientation orientation;
    public final boolean reverseLayout;
    public final LazyLayoutBeyondBoundsState state;

    /* compiled from: LazyLayoutBeyondBoundsModifierLocal.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[LayoutDirection.values().length];
            try {
                r0[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public LazyLayoutBeyondBoundsModifierLocal(LazyLayoutBeyondBoundsState state, LazyLayoutBeyondBoundsInfo beyondBoundsInfo, boolean z, LayoutDirection layoutDirection, Orientation orientation) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(beyondBoundsInfo, "beyondBoundsInfo");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.state = state;
        this.beyondBoundsInfo = beyondBoundsInfo;
        this.reverseLayout = z;
        this.layoutDirection = layoutDirection;
        this.orientation = orientation;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final ProvidableModifierLocal<BeyondBoundsLayout> getKey() {
        return BeyondBoundsLayoutKt.ModifierLocalBeyondBoundsLayout;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:            if (r3 == androidx.compose.foundation.gestures.Orientation.Horizontal) goto L30;     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002f, code lost:            r0 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x002d, code lost:            if (r3 == androidx.compose.foundation.gestures.Orientation.Vertical) goto L30;     */
    /* renamed from: hasMoreContent-FR3nfPY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m98hasMoreContentFR3nfPY(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo.Interval r5, int r6) {
        /*
            r4 = this;
            r0 = 5
            r1 = 1
            r2 = 0
            if (r6 != r0) goto L7
            r0 = r1
            goto L8
        L7:
            r0 = r2
        L8:
            if (r0 == 0) goto Lb
            goto Le
        Lb:
            r0 = 6
            if (r6 != r0) goto L10
        Le:
            r0 = r1
            goto L11
        L10:
            r0 = r2
        L11:
            androidx.compose.foundation.gestures.Orientation r3 = r4.orientation
            if (r0 == 0) goto L1a
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Horizontal
            if (r3 != r0) goto L41
            goto L2f
        L1a:
            r0 = 3
            if (r6 != r0) goto L1f
            r0 = r1
            goto L20
        L1f:
            r0 = r2
        L20:
            if (r0 == 0) goto L23
            goto L26
        L23:
            r0 = 4
            if (r6 != r0) goto L28
        L26:
            r0 = r1
            goto L29
        L28:
            r0 = r2
        L29:
            if (r0 == 0) goto L31
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r3 != r0) goto L41
        L2f:
            r0 = r1
            goto L42
        L31:
            if (r6 != r1) goto L35
            r0 = r1
            goto L36
        L35:
            r0 = r2
        L36:
            if (r0 == 0) goto L39
            goto L3c
        L39:
            r0 = 2
            if (r6 != r0) goto L3e
        L3c:
            r0 = r1
            goto L3f
        L3e:
            r0 = r2
        L3f:
            if (r0 == 0) goto L5e
        L41:
            r0 = r2
        L42:
            if (r0 == 0) goto L45
            return r2
        L45:
            boolean r6 = r4.m99isForward4vf7U8o(r6)
            if (r6 == 0) goto L57
            int r5 = r5.end
            androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState r6 = r4.state
            int r6 = r6.getItemCount()
            int r6 = r6 - r1
            if (r5 >= r6) goto L5c
            goto L5d
        L57:
            int r5 = r5.start
            if (r5 <= 0) goto L5c
            goto L5d
        L5c:
            r1 = r2
        L5d:
            return r1
        L5e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Lazy list does not support beyond bounds layout for the specified direction"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal.m98hasMoreContentFR3nfPY(androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo$Interval, int):boolean");
    }

    /* renamed from: isForward-4vf7U8o, reason: not valid java name */
    public final boolean m99isForward4vf7U8o(int r7) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (r7 == 1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        if (r7 == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            if (r7 == 5) {
                z3 = true;
            } else {
                z3 = false;
            }
            boolean z7 = this.reverseLayout;
            if (!z3) {
                if (r7 == 6) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (z4) {
                    if (z7) {
                        return false;
                    }
                } else {
                    if (r7 == 3) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    LayoutDirection layoutDirection = this.layoutDirection;
                    if (z5) {
                        int r72 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
                        if (r72 != 1) {
                            if (r72 == 2) {
                                if (z7) {
                                    return false;
                                }
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                        }
                    } else {
                        if (r7 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        if (z6) {
                            int r73 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
                            if (r73 != 1) {
                                if (r73 != 2) {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else if (z7) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException("Lazy list does not support beyond bounds layout for the specified direction".toString());
                        }
                    }
                }
            }
            return z7;
        }
        return true;
    }

    @Override // androidx.compose.ui.layout.BeyondBoundsLayout
    /* renamed from: layout-o7g1Pn8, reason: not valid java name */
    public final <T> T mo100layouto7g1Pn8(final int r9, Function1<? super BeyondBoundsLayout.BeyondBoundsScope, ? extends T> function1) {
        int firstPlacedIndex;
        MutableVector<LazyLayoutBeyondBoundsInfo.Interval> mutableVector;
        LazyLayoutBeyondBoundsState lazyLayoutBeyondBoundsState = this.state;
        if (lazyLayoutBeyondBoundsState.getItemCount() > 0 && lazyLayoutBeyondBoundsState.getHasVisibleItems()) {
            if (m99isForward4vf7U8o(r9)) {
                firstPlacedIndex = lazyLayoutBeyondBoundsState.getLastPlacedIndex();
            } else {
                firstPlacedIndex = lazyLayoutBeyondBoundsState.getFirstPlacedIndex();
            }
            final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            LazyLayoutBeyondBoundsInfo lazyLayoutBeyondBoundsInfo = this.beyondBoundsInfo;
            lazyLayoutBeyondBoundsInfo.getClass();
            T t = (T) new LazyLayoutBeyondBoundsInfo.Interval(firstPlacedIndex, firstPlacedIndex);
            lazyLayoutBeyondBoundsInfo.beyondBoundsItems.add(t);
            ref$ObjectRef.element = t;
            T t2 = null;
            while (true) {
                mutableVector = lazyLayoutBeyondBoundsInfo.beyondBoundsItems;
                if (t2 != null || !m98hasMoreContentFR3nfPY((LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element, r9)) {
                    break;
                }
                LazyLayoutBeyondBoundsInfo.Interval interval = (LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element;
                int r6 = interval.start;
                boolean m99isForward4vf7U8o = m99isForward4vf7U8o(r9);
                int r1 = interval.end;
                if (m99isForward4vf7U8o) {
                    r1++;
                } else {
                    r6--;
                }
                T t3 = (T) new LazyLayoutBeyondBoundsInfo.Interval(r6, r1);
                mutableVector.add(t3);
                LazyLayoutBeyondBoundsInfo.Interval interval2 = (LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element;
                Intrinsics.checkNotNullParameter(interval2, "interval");
                mutableVector.remove(interval2);
                ref$ObjectRef.element = t3;
                lazyLayoutBeyondBoundsState.remeasure();
                t2 = function1.invoke(new BeyondBoundsLayout.BeyondBoundsScope() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsModifierLocal$layout$2
                    @Override // androidx.compose.ui.layout.BeyondBoundsLayout.BeyondBoundsScope
                    public final boolean getHasMoreContent() {
                        return LazyLayoutBeyondBoundsModifierLocal.this.m98hasMoreContentFR3nfPY(ref$ObjectRef.element, r9);
                    }
                });
            }
            LazyLayoutBeyondBoundsInfo.Interval interval3 = (LazyLayoutBeyondBoundsInfo.Interval) ref$ObjectRef.element;
            Intrinsics.checkNotNullParameter(interval3, "interval");
            mutableVector.remove(interval3);
            lazyLayoutBeyondBoundsState.remeasure();
            return t2;
        }
        return function1.invoke(emptyBeyondBoundsScope);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    public final BeyondBoundsLayout getValue() {
        return this;
    }
}
