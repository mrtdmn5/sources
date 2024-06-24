package androidx.compose.material;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.GestureCancellationException;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.base.Objects;
import com.google.common.collect.Platform;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.ranges.ClosedFloatRange;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.YieldKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: Slider.kt */
/* loaded from: classes.dex */
public final class SliderKt$Slider$3 extends Lambda implements Function3<BoxWithConstraintsScope, Composer, Integer, Unit> {
    public final /* synthetic */ int $$dirty;
    public final /* synthetic */ SliderColors $colors;
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ MutableInteractionSource $interactionSource;
    public final /* synthetic */ Function0<Unit> $onValueChangeFinished;
    public final /* synthetic */ State<Function1<Float, Unit>> $onValueChangeState;
    public final /* synthetic */ List<Float> $tickFractions;
    public final /* synthetic */ float $value;
    public final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

    /* compiled from: Slider.kt */
    /* renamed from: androidx.compose.material.SliderKt$Slider$3$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Float, Float> {
        public final /* synthetic */ Ref$FloatRef $maxPx;
        public final /* synthetic */ Ref$FloatRef $minPx;
        public final /* synthetic */ ClosedFloatingPointRange<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ClosedFloatingPointRange<Float> closedFloatingPointRange, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2) {
            super(1, Intrinsics.Kotlin.class, "scaleToOffset", "invoke$scaleToOffset(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$FloatRef;F)F", 0);
            this.$valueRange = closedFloatingPointRange;
            this.$minPx = ref$FloatRef;
            this.$maxPx = ref$FloatRef2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(Float f) {
            return Float.valueOf(SliderKt$Slider$3.access$invoke$scaleToOffset(f.floatValue(), this.$minPx, this.$maxPx, this.$valueRange));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SliderKt$Slider$3(ClosedFloatingPointRange closedFloatingPointRange, int r2, float f, MutableInteractionSource mutableInteractionSource, boolean z, List list, SliderColors sliderColors, MutableState mutableState, Function0 function0) {
        super(3);
        this.$valueRange = closedFloatingPointRange;
        this.$$dirty = r2;
        this.$value = f;
        this.$interactionSource = mutableInteractionSource;
        this.$enabled = z;
        this.$tickFractions = list;
        this.$colors = sliderColors;
        this.$onValueChangeState = mutableState;
        this.$onValueChangeFinished = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float access$invoke$scaleToOffset(float f, Ref$FloatRef ref$FloatRef, Ref$FloatRef ref$FloatRef2, ClosedFloatingPointRange closedFloatingPointRange) {
        boolean z;
        float f2;
        float floatValue = ((Number) closedFloatingPointRange.getStart()).floatValue();
        float floatValue2 = ((Number) closedFloatingPointRange.getEndInclusive()).floatValue();
        float f3 = ref$FloatRef.element;
        float f4 = ref$FloatRef2.element;
        float f5 = SliderKt.ThumbRadius;
        float f6 = floatValue2 - floatValue;
        if (f6 == 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            f2 = 0.0f;
        } else {
            f2 = (f - floatValue) / f6;
        }
        return YieldKt.lerp(f3, f4, RangesKt___RangesKt.coerceIn(f2, 0.0f, 1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v20, types: [androidx.compose.material.SliderKt$Slider$3$draggableState$1$1] */
    @Override // kotlin.jvm.functions.Function3
    public final Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, Integer num) {
        boolean z;
        float f;
        ClosedFloatingPointRange<Float> closedFloatingPointRange;
        float f2;
        CoroutineScope coroutineScope;
        boolean z2;
        float f3;
        int r3;
        BoxWithConstraintsScope BoxWithConstraints = boxWithConstraintsScope;
        Composer composer2 = composer;
        int intValue = num.intValue();
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((intValue & 14) == 0) {
            if (composer2.changed(BoxWithConstraints)) {
                r3 = 4;
            } else {
                r3 = 2;
            }
            intValue |= r3;
        }
        if ((intValue & 91) == 18 && composer2.getSkipping()) {
            composer2.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            if (composer2.consume(CompositionLocalsKt.LocalLayoutDirection) == LayoutDirection.Rtl) {
                z = true;
            } else {
                z = false;
            }
            float m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(BoxWithConstraints.mo66getConstraintsmsEJaDk());
            final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            Density density = (Density) composer2.consume(CompositionLocalsKt.LocalDensity);
            float f4 = SliderKt.ThumbRadius;
            ref$FloatRef.element = Math.max(m565getMaxWidthimpl - density.mo49toPx0680j_4(f4), 0.0f);
            ref$FloatRef2.element = Math.min(density.mo49toPx0680j_4(f4), ref$FloatRef.element);
            composer2.startReplaceableGroup(773894976);
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer2.rememberedValue();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (rememberedValue == composer$Companion$Empty$1) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer2));
                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer2.endReplaceableGroup();
            CoroutineScope coroutineScope2 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
            composer2.endReplaceableGroup();
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue2 = composer2.rememberedValue();
            float f5 = this.$value;
            ClosedFloatingPointRange<Float> closedFloatingPointRange2 = this.$valueRange;
            if (rememberedValue2 == composer$Companion$Empty$1) {
                rememberedValue2 = Objects.mutableFloatStateOf(access$invoke$scaleToOffset(f5, ref$FloatRef2, ref$FloatRef, closedFloatingPointRange2));
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceableGroup();
            final MutableFloatState mutableFloatState = (MutableFloatState) rememberedValue2;
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue3 = composer2.rememberedValue();
            if (rememberedValue3 == composer$Companion$Empty$1) {
                rememberedValue3 = Objects.mutableFloatStateOf(0.0f);
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceableGroup();
            final MutableFloatState mutableFloatState2 = (MutableFloatState) rememberedValue3;
            Float valueOf = Float.valueOf(ref$FloatRef2.element);
            Float valueOf2 = Float.valueOf(ref$FloatRef.element);
            final ClosedFloatingPointRange<Float> closedFloatingPointRange3 = this.$valueRange;
            final State<Function1<Float, Unit>> state = this.$onValueChangeState;
            composer2.startReplaceableGroup(1618982084);
            boolean changed = composer2.changed(valueOf) | composer2.changed(valueOf2) | composer2.changed(closedFloatingPointRange3);
            Object rememberedValue4 = composer2.rememberedValue();
            if (!changed && rememberedValue4 != composer$Companion$Empty$1) {
                f2 = f5;
                coroutineScope = coroutineScope2;
                f = m565getMaxWidthimpl;
                closedFloatingPointRange = closedFloatingPointRange2;
            } else {
                f = m565getMaxWidthimpl;
                closedFloatingPointRange = closedFloatingPointRange2;
                f2 = f5;
                coroutineScope = coroutineScope2;
                SliderDraggableState sliderDraggableState = new SliderDraggableState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$draggableState$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Float f6) {
                        boolean z3;
                        float f7;
                        float floatValue = f6.floatValue();
                        MutableFloatState mutableFloatState3 = MutableFloatState.this;
                        float floatValue2 = mutableFloatState3.getFloatValue() + floatValue;
                        MutableFloatState mutableFloatState4 = mutableFloatState2;
                        mutableFloatState3.setFloatValue(mutableFloatState4.getFloatValue() + floatValue2);
                        mutableFloatState4.setFloatValue(0.0f);
                        float floatValue3 = mutableFloatState3.getFloatValue();
                        Ref$FloatRef ref$FloatRef3 = ref$FloatRef2;
                        float f8 = ref$FloatRef3.element;
                        Ref$FloatRef ref$FloatRef4 = ref$FloatRef;
                        float coerceIn = RangesKt___RangesKt.coerceIn(floatValue3, f8, ref$FloatRef4.element);
                        Function1<Float, Unit> value = state.getValue();
                        float f9 = ref$FloatRef3.element;
                        float f10 = ref$FloatRef4.element;
                        ClosedFloatingPointRange<Float> closedFloatingPointRange4 = closedFloatingPointRange3;
                        float floatValue4 = closedFloatingPointRange4.getStart().floatValue();
                        float floatValue5 = closedFloatingPointRange4.getEndInclusive().floatValue();
                        float f11 = SliderKt.ThumbRadius;
                        float f12 = f10 - f9;
                        if (f12 == 0.0f) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            f7 = 0.0f;
                        } else {
                            f7 = (coerceIn - f9) / f12;
                        }
                        value.invoke(Float.valueOf(YieldKt.lerp(floatValue4, floatValue5, RangesKt___RangesKt.coerceIn(f7, 0.0f, 1.0f))));
                        return Unit.INSTANCE;
                    }
                });
                composer2.updateRememberedValue(sliderDraggableState);
                rememberedValue4 = sliderDraggableState;
            }
            composer2.endReplaceableGroup();
            final SliderDraggableState sliderDraggableState2 = (SliderDraggableState) rememberedValue4;
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(closedFloatingPointRange, ref$FloatRef2, ref$FloatRef);
            ClosedFloatingPointRange<Float> closedFloatingPointRange4 = this.$valueRange;
            ClosedFloatRange closedFloatRange = new ClosedFloatRange(ref$FloatRef2.element, ref$FloatRef.element);
            float f6 = this.$value;
            int r11 = this.$$dirty;
            int r23 = r11 >> 9;
            SliderKt.access$CorrectValueSideEffect(anonymousClass2, closedFloatingPointRange4, closedFloatRange, mutableFloatState, f6, composer2, (r23 & 112) | 3072 | ((r11 << 12) & 57344));
            final List<Float> list = this.$tickFractions;
            final Function0<Unit> function0 = this.$onValueChangeFinished;
            final CoroutineScope coroutineScope3 = coroutineScope;
            final MutableState rememberUpdatedState = Platform.rememberUpdatedState(new Function1<Float, Unit>() { // from class: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1

                /* compiled from: Slider.kt */
                @DebugMetadata(c = "androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1", f = "Slider.kt", l = {213}, m = "invokeSuspend")
                /* renamed from: androidx.compose.material.SliderKt$Slider$3$gestureEndAction$1$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    public final /* synthetic */ float $current;
                    public final /* synthetic */ SliderDraggableState $draggableState;
                    public final /* synthetic */ Function0<Unit> $onValueChangeFinished;
                    public final /* synthetic */ float $target;
                    public final /* synthetic */ float $velocity;
                    public int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(SliderDraggableState sliderDraggableState, float f, float f2, float f3, Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$draggableState = sliderDraggableState;
                        this.$current = f;
                        this.$target = f2;
                        this.$velocity = f3;
                        this.$onValueChangeFinished = function0;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$draggableState, this.$current, this.$target, this.$velocity, this.$onValueChangeFinished, continuation);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object drag;
                        Object obj2 = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            this.label = 1;
                            float f = SliderKt.ThumbRadius;
                            drag = this.$draggableState.drag(MutatePriority.Default, new SliderKt$animateToTarget$2(this.$current, this.$target, this.$velocity, null), this);
                            if (drag != obj2) {
                                drag = Unit.INSTANCE;
                            }
                            if (drag == obj2) {
                                return obj2;
                            }
                        }
                        Function0<Unit> function0 = this.$onValueChangeFinished;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Float f7) {
                    Object next;
                    float f8;
                    boolean z3;
                    Function0<Unit> function02;
                    float floatValue = f7.floatValue();
                    float floatValue2 = MutableFloatState.this.getFloatValue();
                    float f9 = ref$FloatRef2.element;
                    float f10 = ref$FloatRef.element;
                    float f11 = SliderKt.ThumbRadius;
                    Iterator<T> it = list.iterator();
                    if (!it.hasNext()) {
                        next = null;
                    } else {
                        next = it.next();
                        if (it.hasNext()) {
                            float abs = Math.abs(YieldKt.lerp(f9, f10, ((Number) next).floatValue()) - floatValue2);
                            do {
                                Object next2 = it.next();
                                float abs2 = Math.abs(YieldKt.lerp(f9, f10, ((Number) next2).floatValue()) - floatValue2);
                                if (Float.compare(abs, abs2) > 0) {
                                    next = next2;
                                    abs = abs2;
                                }
                            } while (it.hasNext());
                        }
                    }
                    Float f12 = (Float) next;
                    if (f12 != null) {
                        f8 = YieldKt.lerp(f9, f10, f12.floatValue());
                    } else {
                        f8 = floatValue2;
                    }
                    if (floatValue2 == f8) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        BuildersKt.launch$default(coroutineScope3, null, null, new AnonymousClass1(sliderDraggableState2, floatValue2, f8, floatValue, function0, null), 3);
                    } else if (!((Boolean) sliderDraggableState2.isDragging$delegate.getValue()).booleanValue() && (function02 = function0) != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }, composer2);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            final MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            final boolean z3 = this.$enabled;
            ClosedFloatingPointRange<Float> closedFloatingPointRange5 = closedFloatingPointRange;
            final float f7 = f;
            final boolean z4 = z;
            Modifier composed = ComposedModifierKt.composed(companion, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material.SliderKt$sliderTapModifier$2

                /* compiled from: Slider.kt */
                @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", l = {910}, m = "invokeSuspend")
                /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1, reason: invalid class name */
                /* loaded from: classes.dex */
                public final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                    public final /* synthetic */ DraggableState $draggableState;
                    public final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                    public final /* synthetic */ boolean $isRtl;
                    public final /* synthetic */ float $maxPx;
                    public final /* synthetic */ MutableState<Float> $pressOffset;
                    public final /* synthetic */ State<Float> $rawOffset;
                    public final /* synthetic */ CoroutineScope $scope;
                    public /* synthetic */ Object L$0;
                    public int label;

                    /* compiled from: Slider.kt */
                    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$1", f = "Slider.kt", l = {915}, m = "invokeSuspend")
                    /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$1, reason: invalid class name and collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static final class C00241 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
                        public final /* synthetic */ boolean $isRtl;
                        public final /* synthetic */ float $maxPx;
                        public final /* synthetic */ MutableState<Float> $pressOffset;
                        public final /* synthetic */ State<Float> $rawOffset;
                        public /* synthetic */ long J$0;
                        public /* synthetic */ PressGestureScope L$0;
                        public int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C00241(boolean z, float f, MutableState<Float> mutableState, State<Float> state, Continuation<? super C00241> continuation) {
                            super(3, continuation);
                            this.$isRtl = z;
                            this.$maxPx = f;
                            this.$pressOffset = mutableState;
                            this.$rawOffset = state;
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(PressGestureScope pressGestureScope, Offset offset, Continuation<? super Unit> continuation) {
                            long j = offset.packedValue;
                            C00241 c00241 = new C00241(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, continuation);
                            c00241.L$0 = pressGestureScope;
                            c00241.J$0 = j;
                            return c00241.invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            float m259getXimpl;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r1 = this.label;
                            MutableState<Float> mutableState = this.$pressOffset;
                            try {
                                if (r1 != 0) {
                                    if (r1 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    PressGestureScope pressGestureScope = this.L$0;
                                    long j = this.J$0;
                                    if (this.$isRtl) {
                                        m259getXimpl = this.$maxPx - Offset.m259getXimpl(j);
                                    } else {
                                        m259getXimpl = Offset.m259getXimpl(j);
                                    }
                                    mutableState.setValue(new Float(m259getXimpl - this.$rawOffset.getValue().floatValue()));
                                    this.label = 1;
                                    if (pressGestureScope.awaitRelease(this) == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                }
                            } catch (GestureCancellationException unused) {
                                mutableState.setValue(new Float(0.0f));
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public AnonymousClass1(boolean z, float f, MutableState<Float> mutableState, State<Float> state, CoroutineScope coroutineScope, DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state2, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$isRtl = z;
                        this.$maxPx = f;
                        this.$pressOffset = mutableState;
                        this.$rawOffset = state;
                        this.$scope = coroutineScope;
                        this.$draggableState = draggableState;
                        this.$gestureEndAction = state2;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, this.$scope, this.$draggableState, this.$gestureEndAction, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                        int r1 = this.label;
                        if (r1 != 0) {
                            if (r1 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                            C00241 c00241 = new C00241(this.$isRtl, this.$maxPx, this.$pressOffset, this.$rawOffset, null);
                            final State<Function1<Float, Unit>> state = this.$gestureEndAction;
                            final CoroutineScope coroutineScope = this.$scope;
                            final DraggableState draggableState = this.$draggableState;
                            Function1<Offset, Unit> function1 = new Function1<Offset, Unit>() { // from class: androidx.compose.material.SliderKt.sliderTapModifier.2.1.2

                                /* compiled from: Slider.kt */
                                @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1", f = "Slider.kt", l = {922}, m = "invokeSuspend")
                                /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes.dex */
                                public final class C00251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    public final /* synthetic */ DraggableState $draggableState;
                                    public final /* synthetic */ State<Function1<Float, Unit>> $gestureEndAction;
                                    public int label;

                                    /* compiled from: Slider.kt */
                                    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1", f = "Slider.kt", l = {}, m = "invokeSuspend")
                                    /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                    /* loaded from: classes.dex */
                                    public static final class C00261 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {
                                        public /* synthetic */ Object L$0;

                                        public C00261(Continuation<? super C00261> continuation) {
                                            super(2, continuation);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                            C00261 c00261 = new C00261(continuation);
                                            c00261.L$0 = obj;
                                            return c00261;
                                        }

                                        @Override // kotlin.jvm.functions.Function2
                                        public final Object invoke(DragScope dragScope, Continuation<? super Unit> continuation) {
                                            return ((C00261) create(dragScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                        }

                                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                        public final Object invokeSuspend(Object obj) {
                                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                            ResultKt.throwOnFailure(obj);
                                            ((DragScope) this.L$0).dragBy(0.0f);
                                            return Unit.INSTANCE;
                                        }
                                    }

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    public C00251(DraggableState draggableState, State<? extends Function1<? super Float, Unit>> state, Continuation<? super C00251> continuation) {
                                        super(2, continuation);
                                        this.$draggableState = draggableState;
                                        this.$gestureEndAction = state;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00251(this.$draggableState, this.$gestureEndAction, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        int r1 = this.label;
                                        if (r1 != 0) {
                                            if (r1 == 1) {
                                                ResultKt.throwOnFailure(obj);
                                            } else {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                        } else {
                                            ResultKt.throwOnFailure(obj);
                                            MutatePriority mutatePriority = MutatePriority.UserInput;
                                            C00261 c00261 = new C00261(null);
                                            this.label = 1;
                                            if (this.$draggableState.drag(mutatePriority, c00261, this) == coroutineSingletons) {
                                                return coroutineSingletons;
                                            }
                                        }
                                        this.$gestureEndAction.getValue().invoke(new Float(0.0f));
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Offset offset) {
                                    long j = offset.packedValue;
                                    BuildersKt.launch$default(CoroutineScope.this, null, null, new C00251(draggableState, state, null), 3);
                                    return Unit.INSTANCE;
                                }
                            };
                            this.label = 1;
                            if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, c00241, function1, this, 3) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Modifier invoke(Modifier modifier, Composer composer3, Integer num2) {
                    Modifier modifier2 = modifier;
                    Composer composer4 = composer3;
                    EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num2, modifier2, "$this$composed", composer4, 1945228890);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    if (z3) {
                        composer4.startReplaceableGroup(773894976);
                        composer4.startReplaceableGroup(-492369756);
                        Object rememberedValue5 = composer4.rememberedValue();
                        if (rememberedValue5 == Composer.Companion.Empty) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer4));
                            composer4.updateRememberedValue(compositionScopedCoroutineScopeCanceller2);
                            rememberedValue5 = compositionScopedCoroutineScopeCanceller2;
                        }
                        composer4.endReplaceableGroup();
                        CoroutineScope coroutineScope4 = ((CompositionScopedCoroutineScopeCanceller) rememberedValue5).coroutineScope;
                        composer4.endReplaceableGroup();
                        Float valueOf3 = Float.valueOf(f7);
                        Boolean valueOf4 = Boolean.valueOf(z4);
                        DraggableState draggableState = sliderDraggableState2;
                        Object[] objArr = {draggableState, mutableInteractionSource, valueOf3, valueOf4};
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(z4, f7, mutableFloatState2, mutableFloatState, coroutineScope4, draggableState, rememberUpdatedState, null);
                        PointerEvent pointerEvent = SuspendingPointerInputFilterKt.EmptyPointerEvent;
                        modifier2 = modifier2.then(new SuspendPointerInputElement(null, objArr, anonymousClass1, 3));
                    }
                    composer4.endReplaceableGroup();
                    return modifier2;
                }
            });
            Orientation orientation = Orientation.Horizontal;
            boolean booleanValue = ((Boolean) sliderDraggableState2.isDragging$delegate.getValue()).booleanValue();
            boolean z5 = this.$enabled;
            MutableInteractionSource mutableInteractionSource2 = this.$interactionSource;
            composer2.startReplaceableGroup(1157296644);
            boolean changed2 = composer2.changed(rememberUpdatedState);
            Object rememberedValue5 = composer2.rememberedValue();
            if (changed2 || rememberedValue5 == composer$Companion$Empty$1) {
                rememberedValue5 = new SliderKt$Slider$3$drag$1$1(rememberUpdatedState, null);
                composer2.updateRememberedValue(rememberedValue5);
            }
            composer2.endReplaceableGroup();
            Modifier draggable$default = DraggableKt.draggable$default(companion, sliderDraggableState2, orientation, z5, mutableInteractionSource2, booleanValue, (Function3) rememberedValue5, z);
            float coerceIn = RangesKt___RangesKt.coerceIn(f2, closedFloatingPointRange5.getStart().floatValue(), closedFloatingPointRange5.getEndInclusive().floatValue());
            float floatValue = closedFloatingPointRange5.getStart().floatValue();
            float floatValue2 = closedFloatingPointRange5.getEndInclusive().floatValue() - floatValue;
            if (floatValue2 == 0.0f) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                f3 = 0.0f;
            } else {
                f3 = (coerceIn - floatValue) / floatValue2;
            }
            SliderKt.access$SliderImpl(this.$enabled, RangesKt___RangesKt.coerceIn(f3, 0.0f, 1.0f), this.$tickFractions, this.$colors, ref$FloatRef.element - ref$FloatRef2.element, this.$interactionSource, composed.then(draggable$default), composer2, ((r11 >> 6) & 458752) | (r23 & 14) | DfuBaseService.ERROR_REMOTE_TYPE_SECURE | ((r11 >> 15) & 7168));
        }
        return Unit.INSTANCE;
    }
}
