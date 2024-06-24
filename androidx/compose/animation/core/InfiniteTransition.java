package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InfiniteTransition.kt */
/* loaded from: classes.dex */
public final class InfiniteTransition {
    public final MutableVector<TransitionAnimationState<?, ?>> _animations;
    public final ParcelableSnapshotMutableState isRunning$delegate;
    public final ParcelableSnapshotMutableState refreshChildNeeded$delegate;
    public long startTimeNanos;

    /* compiled from: InfiniteTransition.kt */
    /* loaded from: classes.dex */
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        public TargetBasedAnimation<T, V> animation;
        public AnimationSpec<T> animationSpec;
        public T initialValue;
        public boolean isFinished;
        public long playTimeNanosOffset;
        public boolean startOnTheNextFrame;
        public T targetValue;
        public final /* synthetic */ InfiniteTransition this$0;
        public final TwoWayConverter<T, V> typeConverter;
        public final ParcelableSnapshotMutableState value$delegate;

        /* JADX WARN: Multi-variable type inference failed */
        public TransitionAnimationState(InfiniteTransition infiniteTransition, Number number, Number number2, TwoWayConverterImpl typeConverter, AnimationSpec animationSpec, String label) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = infiniteTransition;
            this.initialValue = number;
            this.targetValue = number2;
            this.typeConverter = typeConverter;
            this.value$delegate = Platform.mutableStateOf$default(number);
            this.animationSpec = animationSpec;
            this.animation = new TargetBasedAnimation<>(animationSpec, typeConverter, this.initialValue, this.targetValue);
        }

        @Override // androidx.compose.runtime.State
        public final T getValue() {
            return this.value$delegate.getValue();
        }
    }

    public InfiniteTransition(String label) {
        Intrinsics.checkNotNullParameter(label, "label");
        this._animations = new MutableVector<>(new TransitionAnimationState[16]);
        this.refreshChildNeeded$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
        this.startTimeNanos = Long.MIN_VALUE;
        this.isRunning$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void run$animation_core_release(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-318043801);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-492369756);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = Platform.mutableStateOf$default(null);
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        MutableState mutableState = (MutableState) nextSlot;
        if (((Boolean) this.isRunning$delegate.getValue()).booleanValue() || ((Boolean) this.refreshChildNeeded$delegate.getValue()).booleanValue()) {
            EffectsKt.LaunchedEffect(this, new InfiniteTransition$run$1(mutableState, this, null), startRestartGroup);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.core.InfiniteTransition$run$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r5 | 1);
                    InfiniteTransition.this.run$animation_core_release(composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
