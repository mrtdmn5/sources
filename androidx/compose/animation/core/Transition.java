package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.ActualAndroid_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableLongState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import com.google.android.gms.common.zzw;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class Transition<S> {
    public final SnapshotStateList<Transition<S>.TransitionAnimationState<?, ?>> _animations;
    public final SnapshotStateList<Transition<?>> _transitions;
    public final ParcelableSnapshotMutableState isSeeking$delegate;
    public final String label;
    public long lastSeekedTimeNanos;
    public final ParcelableSnapshotMutableLongState playTimeNanos$delegate;
    public final ParcelableSnapshotMutableState segment$delegate;
    public final ParcelableSnapshotMutableLongState startTimeNanos$delegate;
    public final ParcelableSnapshotMutableState targetState$delegate;
    public final DerivedSnapshotState totalDurationNanos$delegate;
    public final MutableTransitionState<S> transitionState;
    public final ParcelableSnapshotMutableState updateChildrenNeeded$delegate;

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public final class DeferredAnimation<T, V extends AnimationVector> {
        public final ParcelableSnapshotMutableState data$delegate;
        public final String label;
        public final /* synthetic */ Transition<S> this$0;
        public final TwoWayConverter<T, V> typeConverter;

        /* compiled from: Transition.kt */
        /* loaded from: classes.dex */
        public final class DeferredAnimationData<T, V extends AnimationVector> implements State<T> {
            public final Transition<S>.TransitionAnimationState<T, V> animation;
            public Function1<? super S, ? extends T> targetValueByState;
            public final /* synthetic */ Transition<S>.DeferredAnimation<T, V> this$0;
            public Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec;

            public DeferredAnimationData(DeferredAnimation deferredAnimation, Transition<S>.TransitionAnimationState<T, V> transitionAnimationState, Function1<? super Segment<S>, ? extends FiniteAnimationSpec<T>> transitionSpec, Function1<? super S, ? extends T> function1) {
                Intrinsics.checkNotNullParameter(transitionSpec, "transitionSpec");
                this.this$0 = deferredAnimation;
                this.animation = transitionAnimationState;
                this.transitionSpec = transitionSpec;
                this.targetValueByState = function1;
            }

            @Override // androidx.compose.runtime.State
            public final T getValue() {
                updateAnimationStates(this.this$0.this$0.getSegment());
                return this.animation.getValue();
            }

            public final void updateAnimationStates(Segment<S> segment) {
                Intrinsics.checkNotNullParameter(segment, "segment");
                T invoke = this.targetValueByState.invoke(segment.getTargetState());
                boolean isSeeking = this.this$0.this$0.isSeeking();
                Transition<S>.TransitionAnimationState<T, V> transitionAnimationState = this.animation;
                if (isSeeking) {
                    transitionAnimationState.updateInitialAndTargetValue$animation_core_release(this.targetValueByState.invoke(segment.getInitialState()), invoke, this.transitionSpec.invoke(segment));
                } else {
                    transitionAnimationState.updateTargetValue$animation_core_release(invoke, this.transitionSpec.invoke(segment));
                }
            }
        }

        public DeferredAnimation(Transition transition, TwoWayConverterImpl typeConverter, String label) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            this.label = label;
            this.data$delegate = Platform.mutableStateOf$default(null);
        }

        public final DeferredAnimationData animate(Function1 transitionSpec, Function1 function1) {
            Intrinsics.checkNotNullParameter(transitionSpec, "transitionSpec");
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.data$delegate;
            DeferredAnimationData deferredAnimationData = (DeferredAnimationData) parcelableSnapshotMutableState.getValue();
            Transition<S> transition = this.this$0;
            if (deferredAnimationData == null) {
                deferredAnimationData = new DeferredAnimationData(this, new TransitionAnimationState(transition, function1.invoke(transition.getCurrentState()), zzw.createZeroVectorFrom(this.typeConverter, function1.invoke(transition.getCurrentState())), this.typeConverter, this.label), transitionSpec, function1);
                parcelableSnapshotMutableState.setValue(deferredAnimationData);
                Transition<S>.TransitionAnimationState<T, V> animation = deferredAnimationData.animation;
                Intrinsics.checkNotNullParameter(animation, "animation");
                transition._animations.add(animation);
            }
            deferredAnimationData.targetValueByState = function1;
            deferredAnimationData.transitionSpec = transitionSpec;
            deferredAnimationData.updateAnimationStates(transition.getSegment());
            return deferredAnimationData;
        }
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public interface Segment<S> {
        S getInitialState();

        S getTargetState();

        default boolean isTransitioningTo(S s, S s2) {
            if (Intrinsics.areEqual(s, getInitialState()) && Intrinsics.areEqual(s2, getTargetState())) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public static final class SegmentImpl<S> implements Segment<S> {
        public final S initialState;
        public final S targetState;

        public SegmentImpl(S s, S s2) {
            this.initialState = s;
            this.targetState = s2;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Segment) {
                Segment segment = (Segment) obj;
                if (Intrinsics.areEqual(this.initialState, segment.getInitialState())) {
                    if (Intrinsics.areEqual(this.targetState, segment.getTargetState())) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public final S getInitialState() {
            return this.initialState;
        }

        @Override // androidx.compose.animation.core.Transition.Segment
        public final S getTargetState() {
            return this.targetState;
        }

        public final int hashCode() {
            int r1;
            int r0 = 0;
            S s = this.initialState;
            if (s != null) {
                r1 = s.hashCode();
            } else {
                r1 = 0;
            }
            int r12 = r1 * 31;
            S s2 = this.targetState;
            if (s2 != null) {
                r0 = s2.hashCode();
            }
            return r12 + r0;
        }
    }

    /* compiled from: Transition.kt */
    /* loaded from: classes.dex */
    public final class TransitionAnimationState<T, V extends AnimationVector> implements State<T> {
        public final ParcelableSnapshotMutableState animation$delegate;
        public final ParcelableSnapshotMutableState animationSpec$delegate;
        public final SpringSpec interruptionSpec;
        public final ParcelableSnapshotMutableState isFinished$delegate;
        public final ParcelableSnapshotMutableState needsReset$delegate;
        public final ParcelableSnapshotMutableLongState offsetTimeNanos$delegate;
        public final ParcelableSnapshotMutableState targetValue$delegate;
        public final /* synthetic */ Transition<S> this$0;
        public final TwoWayConverter<T, V> typeConverter;
        public final ParcelableSnapshotMutableState value$delegate;
        public V velocityVector;

        public TransitionAnimationState(Transition transition, T t, V v, TwoWayConverter<T, V> typeConverter, String label) {
            Intrinsics.checkNotNullParameter(typeConverter, "typeConverter");
            Intrinsics.checkNotNullParameter(label, "label");
            this.this$0 = transition;
            this.typeConverter = typeConverter;
            ParcelableSnapshotMutableState mutableStateOf$default = Platform.mutableStateOf$default(t);
            this.targetValue$delegate = mutableStateOf$default;
            T t2 = null;
            this.animationSpec$delegate = Platform.mutableStateOf$default(AnimationSpecKt.spring$default(0.0f, null, 7));
            this.animation$delegate = Platform.mutableStateOf$default(new TargetBasedAnimation(getAnimationSpec(), typeConverter, t, mutableStateOf$default.getValue(), v));
            this.isFinished$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
            int r9 = ActualAndroid_androidKt.$r8$clinit;
            this.offsetTimeNanos$delegate = new ParcelableSnapshotMutableLongState(0L);
            this.needsReset$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
            this.value$delegate = Platform.mutableStateOf$default(t);
            this.velocityVector = v;
            Float f = VisibilityThresholdsKt.visibilityThresholdMap.get(typeConverter);
            if (f != null) {
                float floatValue = f.floatValue();
                V invoke = typeConverter.getConvertToVector().invoke(t);
                int size$animation_core_release = invoke.getSize$animation_core_release();
                for (int r12 = 0; r12 < size$animation_core_release; r12++) {
                    invoke.set$animation_core_release(floatValue, r12);
                }
                t2 = this.typeConverter.getConvertFromVector().invoke(invoke);
            }
            this.interruptionSpec = AnimationSpecKt.spring$default(0.0f, t2, 3);
        }

        public static void updateAnimation$default(TransitionAnimationState transitionAnimationState, Object obj, boolean z, int r9) {
            FiniteAnimationSpec<T> animationSpec;
            if ((r9 & 1) != 0) {
                obj = transitionAnimationState.getValue();
            }
            Object obj2 = obj;
            if ((r9 & 2) != 0) {
                z = false;
            }
            if (z) {
                if (transitionAnimationState.getAnimationSpec() instanceof SpringSpec) {
                    animationSpec = transitionAnimationState.getAnimationSpec();
                } else {
                    animationSpec = transitionAnimationState.interruptionSpec;
                }
            } else {
                animationSpec = transitionAnimationState.getAnimationSpec();
            }
            transitionAnimationState.animation$delegate.setValue(new TargetBasedAnimation(animationSpec, transitionAnimationState.typeConverter, obj2, transitionAnimationState.targetValue$delegate.getValue(), transitionAnimationState.velocityVector));
            Transition<S> transition = transitionAnimationState.this$0;
            transition.updateChildrenNeeded$delegate.setValue(Boolean.TRUE);
            if (transition.isSeeking()) {
                ListIterator<Transition<S>.TransitionAnimationState<?, ?>> listIterator = transition._animations.listIterator();
                long j = 0;
                while (true) {
                    StateListIterator stateListIterator = (StateListIterator) listIterator;
                    if (stateListIterator.hasNext()) {
                        TransitionAnimationState transitionAnimationState2 = (TransitionAnimationState) stateListIterator.next();
                        j = Math.max(j, transitionAnimationState2.getAnimation().durationNanos);
                        long j2 = transition.lastSeekedTimeNanos;
                        transitionAnimationState2.value$delegate.setValue(transitionAnimationState2.getAnimation().getValueFromNanos(j2));
                        transitionAnimationState2.velocityVector = transitionAnimationState2.getAnimation().getVelocityVectorFromNanos(j2);
                    } else {
                        transition.updateChildrenNeeded$delegate.setValue(Boolean.FALSE);
                        return;
                    }
                }
            }
        }

        public final TargetBasedAnimation<T, V> getAnimation() {
            return (TargetBasedAnimation) this.animation$delegate.getValue();
        }

        public final FiniteAnimationSpec<T> getAnimationSpec() {
            return (FiniteAnimationSpec) this.animationSpec$delegate.getValue();
        }

        @Override // androidx.compose.runtime.State
        public final T getValue() {
            return this.value$delegate.getValue();
        }

        public final void updateInitialAndTargetValue$animation_core_release(T t, T t2, FiniteAnimationSpec<T> animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            this.targetValue$delegate.setValue(t2);
            this.animationSpec$delegate.setValue(animationSpec);
            if (Intrinsics.areEqual(getAnimation().initialValue, t) && Intrinsics.areEqual(getAnimation().targetValue, t2)) {
                return;
            }
            updateAnimation$default(this, t, false, 2);
        }

        public final void updateTargetValue$animation_core_release(T t, FiniteAnimationSpec<T> animationSpec) {
            Intrinsics.checkNotNullParameter(animationSpec, "animationSpec");
            ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.targetValue$delegate;
            boolean areEqual = Intrinsics.areEqual(parcelableSnapshotMutableState.getValue(), t);
            ParcelableSnapshotMutableState parcelableSnapshotMutableState2 = this.needsReset$delegate;
            if (!areEqual || ((Boolean) parcelableSnapshotMutableState2.getValue()).booleanValue()) {
                parcelableSnapshotMutableState.setValue(t);
                this.animationSpec$delegate.setValue(animationSpec);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState3 = this.isFinished$delegate;
                updateAnimation$default(this, null, !((Boolean) parcelableSnapshotMutableState3.getValue()).booleanValue(), 1);
                Boolean bool = Boolean.FALSE;
                parcelableSnapshotMutableState3.setValue(bool);
                this.offsetTimeNanos$delegate.setLongValue(this.this$0.playTimeNanos$delegate.getLongValue());
                parcelableSnapshotMutableState2.setValue(bool);
            }
        }
    }

    public Transition() {
        throw null;
    }

    public Transition(MutableTransitionState<S> transitionState, String str) {
        Intrinsics.checkNotNullParameter(transitionState, "transitionState");
        this.transitionState = transitionState;
        this.label = str;
        this.targetState$delegate = Platform.mutableStateOf$default(getCurrentState());
        this.segment$delegate = Platform.mutableStateOf$default(new SegmentImpl(getCurrentState(), getCurrentState()));
        int r3 = ActualAndroid_androidKt.$r8$clinit;
        this.playTimeNanos$delegate = new ParcelableSnapshotMutableLongState(0L);
        this.startTimeNanos$delegate = new ParcelableSnapshotMutableLongState(Long.MIN_VALUE);
        this.updateChildrenNeeded$delegate = Platform.mutableStateOf$default(Boolean.TRUE);
        this._animations = new SnapshotStateList<>();
        this._transitions = new SnapshotStateList<>();
        this.isSeeking$delegate = Platform.mutableStateOf$default(Boolean.FALSE);
        this.totalDurationNanos$delegate = Platform.derivedStateOf(new Function0<Long>(this) { // from class: androidx.compose.animation.core.Transition$totalDurationNanos$2
            public final /* synthetic */ Transition<S> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Long invoke() {
                Transition<S> transition = this.this$0;
                ListIterator<Transition<S>.TransitionAnimationState<?, ?>> listIterator = transition._animations.listIterator();
                long j = 0;
                while (true) {
                    StateListIterator stateListIterator = (StateListIterator) listIterator;
                    if (!stateListIterator.hasNext()) {
                        break;
                    }
                    j = Math.max(j, ((Transition.TransitionAnimationState) stateListIterator.next()).getAnimation().durationNanos);
                }
                ListIterator<Transition<?>> listIterator2 = transition._transitions.listIterator();
                while (true) {
                    StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
                    if (stateListIterator2.hasNext()) {
                        j = Math.max(j, ((Number) ((Transition) stateListIterator2.next()).totalDurationNanos$delegate.getValue()).longValue());
                    } else {
                        return Long.valueOf(j);
                    }
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:            if (((java.lang.Boolean) r6.updateChildrenNeeded$delegate.getValue()).booleanValue() == false) goto L86;     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void animateTo$animation_core_release(final S r7, androidx.compose.runtime.Composer r8, final int r9) {
        /*
            r6 = this;
            r0 = -1493585151(0xffffffffa6f9b301, float:-1.7326365E-15)
            androidx.compose.runtime.ComposerImpl r8 = r8.startRestartGroup(r0)
            r0 = r9 & 14
            if (r0 != 0) goto L16
            boolean r0 = r8.changed(r7)
            if (r0 == 0) goto L13
            r0 = 4
            goto L14
        L13:
            r0 = 2
        L14:
            r0 = r0 | r9
            goto L17
        L16:
            r0 = r9
        L17:
            r1 = r9 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L27
            boolean r1 = r8.changed(r6)
            if (r1 == 0) goto L24
            r1 = 32
            goto L26
        L24:
            r1 = 16
        L26:
            r0 = r0 | r1
        L27:
            r1 = r0 & 91
            r2 = 18
            if (r1 != r2) goto L38
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L34
            goto L38
        L34:
            r8.skipToGroupEnd()
            goto L97
        L38:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r1 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            boolean r1 = r6.isSeeking()
            if (r1 != 0) goto L97
            r1 = r0 & 14
            r0 = r0 & 112(0x70, float:1.57E-43)
            r0 = r0 | r1
            r6.updateTarget$animation_core_release(r7, r8, r0)
            java.lang.Object r0 = r6.getCurrentState()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r7, r0)
            r1 = 0
            if (r0 == 0) goto L72
            androidx.compose.runtime.ParcelableSnapshotMutableLongState r0 = r6.startTimeNanos$delegate
            long r2 = r0.getLongValue()
            r4 = -9223372036854775808
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = r1
        L62:
            if (r0 != 0) goto L72
            androidx.compose.runtime.ParcelableSnapshotMutableState r0 = r6.updateChildrenNeeded$delegate
            java.lang.Object r0 = r0.getValue()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L97
        L72:
            r0 = 1157296644(0x44faf204, float:2007.563)
            r8.startReplaceableGroup(r0)
            boolean r0 = r8.changed(r6)
            java.lang.Object r2 = r8.nextSlot()
            if (r0 != 0) goto L86
            androidx.compose.runtime.Composer$Companion$Empty$1 r0 = androidx.compose.runtime.Composer.Companion.Empty
            if (r2 != r0) goto L8f
        L86:
            androidx.compose.animation.core.Transition$animateTo$1$1 r2 = new androidx.compose.animation.core.Transition$animateTo$1$1
            r0 = 0
            r2.<init>(r6, r0)
            r8.updateValue(r2)
        L8f:
            r8.end(r1)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r6, r2, r8)
        L97:
            androidx.compose.runtime.RecomposeScopeImpl r8 = r8.endRestartGroup()
            if (r8 != 0) goto L9e
            goto La5
        L9e:
            androidx.compose.animation.core.Transition$animateTo$2 r0 = new androidx.compose.animation.core.Transition$animateTo$2
            r0.<init>(r6)
            r8.block = r0
        La5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.Transition.animateTo$animation_core_release(java.lang.Object, androidx.compose.runtime.Composer, int):void");
    }

    public final S getCurrentState() {
        return (S) this.transitionState.currentState$delegate.getValue();
    }

    public final Segment<S> getSegment() {
        return (Segment) this.segment$delegate.getValue();
    }

    public final S getTargetState() {
        return (S) this.targetState$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSeeking() {
        return ((Boolean) this.isSeeking$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [androidx.compose.animation.core.AnimationVector, V extends androidx.compose.animation.core.AnimationVector] */
    public final void onFrame$animation_core_release(float f, long j) {
        long j2;
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = this.startTimeNanos$delegate;
        if (parcelableSnapshotMutableLongState.getLongValue() == Long.MIN_VALUE) {
            parcelableSnapshotMutableLongState.setLongValue(j);
            this.transitionState.isRunning$delegate.setValue(Boolean.TRUE);
        }
        this.updateChildrenNeeded$delegate.setValue(Boolean.FALSE);
        long longValue = j - parcelableSnapshotMutableLongState.getLongValue();
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState2 = this.playTimeNanos$delegate;
        parcelableSnapshotMutableLongState2.setLongValue(longValue);
        ListIterator<Transition<S>.TransitionAnimationState<?, ?>> listIterator = this._animations.listIterator();
        boolean z = true;
        while (true) {
            StateListIterator stateListIterator = (StateListIterator) listIterator;
            if (stateListIterator.hasNext()) {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) stateListIterator.next();
                boolean booleanValue = ((Boolean) transitionAnimationState.isFinished$delegate.getValue()).booleanValue();
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = transitionAnimationState.isFinished$delegate;
                if (!booleanValue) {
                    long longValue2 = parcelableSnapshotMutableLongState2.getLongValue();
                    ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState3 = transitionAnimationState.offsetTimeNanos$delegate;
                    if (f > 0.0f) {
                        float longValue3 = ((float) (longValue2 - parcelableSnapshotMutableLongState3.getLongValue())) / f;
                        if (!Float.isNaN(longValue3)) {
                            j2 = longValue3;
                        } else {
                            throw new IllegalStateException(("Duration scale adjusted time is NaN. Duration scale: " + f + ",playTimeNanos: " + longValue2 + ", offsetTimeNanos: " + parcelableSnapshotMutableLongState3.getLongValue()).toString());
                        }
                    } else {
                        j2 = transitionAnimationState.getAnimation().durationNanos;
                    }
                    transitionAnimationState.value$delegate.setValue(transitionAnimationState.getAnimation().getValueFromNanos(j2));
                    transitionAnimationState.velocityVector = transitionAnimationState.getAnimation().getVelocityVectorFromNanos(j2);
                    if (transitionAnimationState.getAnimation().isFinishedFromNanos(j2)) {
                        parcelableSnapshotMutableState.setValue(Boolean.TRUE);
                        parcelableSnapshotMutableLongState3.setLongValue(0L);
                    }
                }
                if (!((Boolean) parcelableSnapshotMutableState.getValue()).booleanValue()) {
                    z = false;
                }
            } else {
                ListIterator<Transition<?>> listIterator2 = this._transitions.listIterator();
                while (true) {
                    StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
                    if (!stateListIterator2.hasNext()) {
                        break;
                    }
                    Transition transition = (Transition) stateListIterator2.next();
                    if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                        transition.onFrame$animation_core_release(f, parcelableSnapshotMutableLongState2.getLongValue());
                    }
                    if (!Intrinsics.areEqual(transition.getTargetState(), transition.getCurrentState())) {
                        z = false;
                    }
                }
                if (z) {
                    onTransitionEnd$animation_core_release();
                    return;
                }
                return;
            }
        }
    }

    public final void onTransitionEnd$animation_core_release() {
        this.startTimeNanos$delegate.setLongValue(Long.MIN_VALUE);
        S targetState = getTargetState();
        MutableTransitionState<S> mutableTransitionState = this.transitionState;
        mutableTransitionState.currentState$delegate.setValue(targetState);
        this.playTimeNanos$delegate.setLongValue(0L);
        mutableTransitionState.isRunning$delegate.setValue(Boolean.FALSE);
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [androidx.compose.animation.core.AnimationVector, V extends androidx.compose.animation.core.AnimationVector] */
    public final void seek(long j, Object obj, Object obj2) {
        this.startTimeNanos$delegate.setLongValue(Long.MIN_VALUE);
        MutableTransitionState<S> mutableTransitionState = this.transitionState;
        mutableTransitionState.isRunning$delegate.setValue(Boolean.FALSE);
        if (!isSeeking() || !Intrinsics.areEqual(getCurrentState(), obj) || !Intrinsics.areEqual(getTargetState(), obj2)) {
            mutableTransitionState.currentState$delegate.setValue(obj);
            this.targetState$delegate.setValue(obj2);
            this.isSeeking$delegate.setValue(Boolean.TRUE);
            this.segment$delegate.setValue(new SegmentImpl(obj, obj2));
        }
        ListIterator<Transition<?>> listIterator = this._transitions.listIterator();
        while (true) {
            StateListIterator stateListIterator = (StateListIterator) listIterator;
            if (!stateListIterator.hasNext()) {
                break;
            }
            Transition transition = (Transition) stateListIterator.next();
            Intrinsics.checkNotNull(transition, "null cannot be cast to non-null type androidx.compose.animation.core.Transition<kotlin.Any>");
            if (transition.isSeeking()) {
                transition.seek(j, transition.getCurrentState(), transition.getTargetState());
            }
        }
        ListIterator<Transition<S>.TransitionAnimationState<?, ?>> listIterator2 = this._animations.listIterator();
        while (true) {
            StateListIterator stateListIterator2 = (StateListIterator) listIterator2;
            if (stateListIterator2.hasNext()) {
                TransitionAnimationState transitionAnimationState = (TransitionAnimationState) stateListIterator2.next();
                transitionAnimationState.value$delegate.setValue(transitionAnimationState.getAnimation().getValueFromNanos(j));
                transitionAnimationState.velocityVector = transitionAnimationState.getAnimation().getVelocityVectorFromNanos(j);
            } else {
                this.lastSeekedTimeNanos = j;
                return;
            }
        }
    }

    public final void updateTarget$animation_core_release(final S s, Composer composer, final int r7) {
        int r0;
        boolean z;
        int r1;
        int r02;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-583974681);
        if ((r7 & 14) == 0) {
            if (startRestartGroup.changed(s)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r7;
        } else {
            r0 = r7;
        }
        if ((r7 & 112) == 0) {
            if (startRestartGroup.changed(this)) {
                r1 = 32;
            } else {
                r1 = 16;
            }
            r0 |= r1;
        }
        if ((r0 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            if (!isSeeking() && !Intrinsics.areEqual(getTargetState(), s)) {
                this.segment$delegate.setValue(new SegmentImpl(getTargetState(), s));
                this.transitionState.currentState$delegate.setValue(getTargetState());
                this.targetState$delegate.setValue(s);
                if (this.startTimeNanos$delegate.getLongValue() != Long.MIN_VALUE) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    this.updateChildrenNeeded$delegate.setValue(Boolean.TRUE);
                }
                ListIterator<Transition<S>.TransitionAnimationState<?, ?>> listIterator = this._animations.listIterator();
                while (true) {
                    StateListIterator stateListIterator = (StateListIterator) listIterator;
                    if (!stateListIterator.hasNext()) {
                        break;
                    } else {
                        ((TransitionAnimationState) stateListIterator.next()).needsReset$delegate.setValue(Boolean.TRUE);
                    }
                }
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>(this) { // from class: androidx.compose.animation.core.Transition$updateTarget$2
                public final /* synthetic */ Transition<S> $tmp0_rcvr;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$tmp0_rcvr = this;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r7 | 1);
                    this.$tmp0_rcvr.updateTarget$animation_core_release(s, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }
}
