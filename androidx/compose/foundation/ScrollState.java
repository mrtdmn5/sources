package androidx.compose.foundation;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.DefaultScrollableState;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.UStringsKt;

/* compiled from: Scroll.kt */
/* loaded from: classes.dex */
public final class ScrollState implements ScrollableState {
    public static final SaverKt$Saver$1 Saver = SaverKt.Saver(new Function2<SaverScope, ScrollState, Integer>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        public final Integer invoke(SaverScope saverScope, ScrollState scrollState) {
            SaverScope Saver2 = saverScope;
            ScrollState it = scrollState;
            Intrinsics.checkNotNullParameter(Saver2, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.getValue());
        }
    }, new Function1<Integer, ScrollState>() { // from class: androidx.compose.foundation.ScrollState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        public final ScrollState invoke(Integer num) {
            return new ScrollState(num.intValue());
        }
    });
    public float accumulator;
    public final ParcelableSnapshotMutableIntState value$delegate;
    public final ParcelableSnapshotMutableIntState viewportSize$delegate = UStringsKt.mutableIntStateOf(0);
    public final MutableInteractionSourceImpl internalInteractionSource = new MutableInteractionSourceImpl();
    public final ParcelableSnapshotMutableIntState _maxValueState = UStringsKt.mutableIntStateOf(Integer.MAX_VALUE);
    public final DefaultScrollableState scrollableState = new DefaultScrollableState(new Function1<Float, Float>() { // from class: androidx.compose.foundation.ScrollState$scrollableState$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(Float f) {
            boolean z;
            float floatValue = f.floatValue();
            ScrollState scrollState = ScrollState.this;
            float value = scrollState.getValue() + floatValue + scrollState.accumulator;
            float coerceIn = RangesKt___RangesKt.coerceIn(value, 0.0f, scrollState._maxValueState.getIntValue());
            if (value == coerceIn) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = !z;
            float value2 = coerceIn - scrollState.getValue();
            int roundToInt = MathKt__MathJVMKt.roundToInt(value2);
            scrollState.value$delegate.setIntValue(scrollState.getValue() + roundToInt);
            scrollState.accumulator = value2 - roundToInt;
            if (z2) {
                floatValue = value2;
            }
            return Float.valueOf(floatValue);
        }
    });
    public final DerivedSnapshotState canScrollForward$delegate = Platform.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollForward$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean z;
            ScrollState scrollState = ScrollState.this;
            if (scrollState.getValue() < scrollState._maxValueState.getIntValue()) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    });
    public final DerivedSnapshotState canScrollBackward$delegate = Platform.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.ScrollState$canScrollBackward$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean z;
            if (ScrollState.this.getValue() > 0) {
                z = true;
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    });

    public ScrollState(int r2) {
        this.value$delegate = UStringsKt.mutableIntStateOf(r2);
    }

    public final Object animateScrollTo(int r2, TweenSpec tweenSpec, Continuation continuation) {
        Object animateScrollBy = ScrollExtensionsKt.animateScrollBy(this, r2 - getValue(), tweenSpec, continuation);
        if (animateScrollBy == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return animateScrollBy;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final float dispatchRawDelta(float f) {
        return this.scrollableState.dispatchRawDelta(f);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollBackward() {
        return ((Boolean) this.canScrollBackward$delegate.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean getCanScrollForward() {
        return ((Boolean) this.canScrollForward$delegate.getValue()).booleanValue();
    }

    public final int getValue() {
        return this.value$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean isScrollInProgress() {
        return this.scrollableState.isScrollInProgress();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final Object scroll(MutatePriority mutatePriority, Function2<? super ScrollScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object scroll = this.scrollableState.scroll(mutatePriority, function2, continuation);
        if (scroll == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return scroll;
        }
        return Unit.INSTANCE;
    }
}
