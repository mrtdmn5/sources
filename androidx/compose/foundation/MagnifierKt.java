package androidx.compose.foundation;

import android.os.Build;
import android.view.View;
import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectableValueKt$NoInspectorInfo$1;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.google.common.collect.Platform;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SafeFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.internal.NopCollector;

/* compiled from: Magnifier.kt */
/* loaded from: classes.dex */
public final class MagnifierKt {
    public static final SemanticsPropertyKey<Function0<Offset>> MagnifierPositionInRoot = new SemanticsPropertyKey<>("MagnifierPositionInRoot", SemanticsPropertyKey.AnonymousClass1.INSTANCE);

    public static Modifier magnifier$default(final Function1 function1, final MagnifierStyle style, final Function1 function12) {
        boolean z;
        Modifier modifier;
        PlatformMagnifierFactory platformMagnifierFactory;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        final float f = Float.NaN;
        final MagnifierKt$magnifier$1 magnifierCenter = new Function1<Density, Offset>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Offset invoke(Density density) {
                Intrinsics.checkNotNullParameter(density, "$this$null");
                return new Offset(Offset.Unspecified);
            }
        };
        Intrinsics.checkNotNullParameter(magnifierCenter, "magnifierCenter");
        Intrinsics.checkNotNullParameter(style, "style");
        InspectableValueKt$NoInspectorInfo$1 inspectableValueKt$NoInspectorInfo$1 = InspectableValueKt.NoInspectorInfo;
        int r1 = Build.VERSION.SDK_INT;
        boolean z2 = true;
        if (r1 >= 28) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r1 < 28) {
                z2 = false;
            }
            if (z2) {
                if (r1 == 28) {
                    platformMagnifierFactory = PlatformMagnifierFactoryApi28Impl.INSTANCE;
                } else {
                    platformMagnifierFactory = PlatformMagnifierFactoryApi29Impl.INSTANCE;
                }
                final PlatformMagnifierFactory platformMagnifierFactory2 = platformMagnifierFactory;
                modifier = ComposedModifierKt.composed(companion, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4

                    /* compiled from: Magnifier.kt */
                    @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", l = {363}, m = "invokeSuspend")
                    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        public final /* synthetic */ MutableState<Offset> $anchorPositionInRoot$delegate;
                        public final /* synthetic */ Density $density;
                        public final /* synthetic */ State<Boolean> $isMagnifierShown$delegate;
                        public final /* synthetic */ MutableSharedFlow<Unit> $onNeedsUpdate;
                        public final /* synthetic */ PlatformMagnifierFactory $platformMagnifierFactory;
                        public final /* synthetic */ State<Offset> $sourceCenterInRoot$delegate;
                        public final /* synthetic */ MagnifierStyle $style;
                        public final /* synthetic */ State<Function1<Density, Offset>> $updatedMagnifierCenter$delegate;
                        public final /* synthetic */ State<Function1<DpSize, Unit>> $updatedOnSizeChanged$delegate;
                        public final /* synthetic */ State<Float> $updatedZoom$delegate;
                        public final /* synthetic */ View $view;
                        public final /* synthetic */ float $zoom;
                        public /* synthetic */ Object L$0;
                        public int label;

                        /* compiled from: Magnifier.kt */
                        @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1$1", f = "Magnifier.kt", l = {}, m = "invokeSuspend")
                        /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1$1, reason: invalid class name and collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static final class C00021 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
                            public final /* synthetic */ PlatformMagnifier $magnifier;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public C00021(PlatformMagnifier platformMagnifier, Continuation<? super C00021> continuation) {
                                super(2, continuation);
                                this.$magnifier = platformMagnifier;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new C00021(this.$magnifier, continuation);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
                                return ((C00021) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                ResultKt.throwOnFailure(obj);
                                this.$magnifier.updateContent();
                                return Unit.INSTANCE;
                            }
                        }

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public AnonymousClass1(PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle, View view, Density density, float f, MutableSharedFlow<Unit> mutableSharedFlow, State<? extends Function1<? super DpSize, Unit>> state, State<Boolean> state2, State<Offset> state3, State<? extends Function1<? super Density, Offset>> state4, MutableState<Offset> mutableState, State<Float> state5, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$platformMagnifierFactory = platformMagnifierFactory;
                            this.$style = magnifierStyle;
                            this.$view = view;
                            this.$density = density;
                            this.$zoom = f;
                            this.$onNeedsUpdate = mutableSharedFlow;
                            this.$updatedOnSizeChanged$delegate = state;
                            this.$isMagnifierShown$delegate = state2;
                            this.$sourceCenterInRoot$delegate = state3;
                            this.$updatedMagnifierCenter$delegate = state4;
                            this.$anchorPositionInRoot$delegate = mutableState;
                            this.$updatedZoom$delegate = state5;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$platformMagnifierFactory, this.$style, this.$view, this.$density, this.$zoom, this.$onNeedsUpdate, this.$updatedOnSizeChanged$delegate, this.$isMagnifierShown$delegate, this.$sourceCenterInRoot$delegate, this.$updatedMagnifierCenter$delegate, this.$anchorPositionInRoot$delegate, this.$updatedZoom$delegate, continuation);
                            anonymousClass1.L$0 = obj;
                            return anonymousClass1;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            PlatformMagnifier platformMagnifier;
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            int r2 = this.label;
                            if (r2 != 0) {
                                if (r2 == 1) {
                                    platformMagnifier = (PlatformMagnifier) this.L$0;
                                    try {
                                        ResultKt.throwOnFailure(obj);
                                    } catch (Throwable th) {
                                        th = th;
                                        platformMagnifier.dismiss();
                                        throw th;
                                    }
                                } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            } else {
                                ResultKt.throwOnFailure(obj);
                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                PlatformMagnifierFactory platformMagnifierFactory = this.$platformMagnifierFactory;
                                MagnifierStyle magnifierStyle = this.$style;
                                View view = this.$view;
                                Density density = this.$density;
                                final PlatformMagnifier create = platformMagnifierFactory.create(magnifierStyle, view, density, this.$zoom);
                                final Ref$LongRef ref$LongRef = new Ref$LongRef();
                                long mo29getSizeYbymL2g = create.mo29getSizeYbymL2g();
                                Function1<DpSize, Unit> value = this.$updatedOnSizeChanged$delegate.getValue();
                                if (value != null) {
                                    value.invoke(new DpSize(density.mo47toDpSizekrfVVM(IntSizeKt.m595toSizeozmzZPI(mo29getSizeYbymL2g))));
                                }
                                ref$LongRef.element = mo29getSizeYbymL2g;
                                FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new C00021(create, null), this.$onNeedsUpdate), coroutineScope);
                                try {
                                    final Density density2 = this.$density;
                                    final State<Boolean> state = this.$isMagnifierShown$delegate;
                                    final State<Offset> state2 = this.$sourceCenterInRoot$delegate;
                                    final State<Function1<Density, Offset>> state3 = this.$updatedMagnifierCenter$delegate;
                                    final MutableState<Offset> mutableState = this.$anchorPositionInRoot$delegate;
                                    final State<Float> state4 = this.$updatedZoom$delegate;
                                    final State<Function1<DpSize, Unit>> state5 = this.$updatedOnSizeChanged$delegate;
                                    SafeFlow snapshotFlow = Platform.snapshotFlow(new Function0<Unit>() { // from class: androidx.compose.foundation.MagnifierKt.magnifier.4.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Unit invoke() {
                                            long j;
                                            boolean booleanValue = state.getValue().booleanValue();
                                            PlatformMagnifier platformMagnifier2 = PlatformMagnifier.this;
                                            if (booleanValue) {
                                                long j2 = state2.getValue().packedValue;
                                                Function1<Density, Offset> value2 = state3.getValue();
                                                Density density3 = density2;
                                                long j3 = value2.invoke(density3).packedValue;
                                                if (OffsetKt.m266isSpecifiedk4lQ0M(j3)) {
                                                    j = Offset.m262plusMKHz9U(mutableState.getValue().packedValue, j3);
                                                } else {
                                                    j = Offset.Unspecified;
                                                }
                                                platformMagnifier2.mo30updateWko1d7g(j2, j, state4.getValue().floatValue());
                                                long mo29getSizeYbymL2g2 = platformMagnifier2.mo29getSizeYbymL2g();
                                                Ref$LongRef ref$LongRef2 = ref$LongRef;
                                                if (!IntSize.m592equalsimpl0(mo29getSizeYbymL2g2, ref$LongRef2.element)) {
                                                    ref$LongRef2.element = mo29getSizeYbymL2g2;
                                                    Function1<DpSize, Unit> value3 = state5.getValue();
                                                    if (value3 != null) {
                                                        value3.invoke(new DpSize(density3.mo47toDpSizekrfVVM(IntSizeKt.m595toSizeozmzZPI(mo29getSizeYbymL2g2))));
                                                    }
                                                }
                                            } else {
                                                platformMagnifier2.dismiss();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    this.L$0 = create;
                                    this.label = 1;
                                    Object collect = snapshotFlow.collect(NopCollector.INSTANCE, this);
                                    if (collect != coroutineSingletons) {
                                        collect = Unit.INSTANCE;
                                    }
                                    if (collect == coroutineSingletons) {
                                        return coroutineSingletons;
                                    }
                                    platformMagnifier = create;
                                } catch (Throwable th2) {
                                    th = th2;
                                    platformMagnifier = create;
                                    platformMagnifier.dismiss();
                                    throw th;
                                }
                            }
                            platformMagnifier.dismiss();
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public final Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                        Modifier modifier3 = modifier2;
                        Composer composer2 = composer;
                        EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier3, "$this$composed", composer2, -454877003);
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                        View view = (View) composer2.consume(AndroidCompositionLocals_androidKt.LocalView);
                        final Density density = (Density) composer2.consume(CompositionLocalsKt.LocalDensity);
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue = composer2.rememberedValue();
                        Object obj = Composer.Companion.Empty;
                        if (rememberedValue == obj) {
                            rememberedValue = Platform.mutableStateOf$default(new Offset(Offset.Unspecified));
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        final MutableState mutableState = (MutableState) rememberedValue;
                        final MutableState rememberUpdatedState = Platform.rememberUpdatedState(function1, composer2);
                        MutableState rememberUpdatedState2 = Platform.rememberUpdatedState(magnifierCenter, composer2);
                        float f2 = f;
                        MutableState rememberUpdatedState3 = Platform.rememberUpdatedState(Float.valueOf(f2), composer2);
                        MutableState rememberUpdatedState4 = Platform.rememberUpdatedState(function12, composer2);
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == obj) {
                            rememberedValue2 = Platform.derivedStateOf(new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$sourceCenterInRoot$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Offset invoke() {
                                    long j;
                                    long j2 = rememberUpdatedState.getValue().invoke(Density.this).packedValue;
                                    MutableState<Offset> mutableState2 = mutableState;
                                    if (OffsetKt.m266isSpecifiedk4lQ0M(mutableState2.getValue().packedValue) && OffsetKt.m266isSpecifiedk4lQ0M(j2)) {
                                        j = Offset.m262plusMKHz9U(mutableState2.getValue().packedValue, j2);
                                    } else {
                                        j = Offset.Unspecified;
                                    }
                                    return new Offset(j);
                                }
                            });
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        final State state = (State) rememberedValue2;
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (rememberedValue3 == obj) {
                            rememberedValue3 = Platform.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$isMagnifierShown$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    return Boolean.valueOf(OffsetKt.m266isSpecifiedk4lQ0M(state.getValue().packedValue));
                                }
                            });
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        State state2 = (State) rememberedValue3;
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue4 = composer2.rememberedValue();
                        if (rememberedValue4 == obj) {
                            rememberedValue4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2);
                            composer2.updateRememberedValue(rememberedValue4);
                        }
                        composer2.endReplaceableGroup();
                        final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) rememberedValue4;
                        if (platformMagnifierFactory2.getCanUpdateZoom()) {
                            f2 = 0.0f;
                        }
                        Float valueOf = Float.valueOf(f2);
                        MagnifierStyle magnifierStyle = MagnifierStyle.TextDefault;
                        MagnifierStyle magnifierStyle2 = style;
                        EffectsKt.LaunchedEffect(new Object[]{view, density, valueOf, magnifierStyle2, Boolean.valueOf(Intrinsics.areEqual(magnifierStyle2, magnifierStyle))}, (Function2) new AnonymousClass1(platformMagnifierFactory2, style, view, density, f, mutableSharedFlow, rememberUpdatedState4, state2, state, rememberUpdatedState2, mutableState, rememberUpdatedState3, null), composer2);
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed = composer2.changed(mutableState);
                        Object rememberedValue5 = composer2.rememberedValue();
                        if (changed || rememberedValue5 == obj) {
                            rememberedValue5 = new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$2$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(LayoutCoordinates layoutCoordinates) {
                                    LayoutCoordinates it = layoutCoordinates;
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    mutableState.setValue(new Offset(LayoutCoordinatesKt.positionInRoot(it)));
                                    return Unit.INSTANCE;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue5);
                        }
                        composer2.endReplaceableGroup();
                        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier3, (Function1) rememberedValue5), new Function1<DrawScope, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(DrawScope drawScope) {
                                DrawScope drawBehind2 = drawScope;
                                Intrinsics.checkNotNullParameter(drawBehind2, "$this$drawBehind");
                                Unit unit = Unit.INSTANCE;
                                mutableSharedFlow.tryEmit(unit);
                                return unit;
                            }
                        });
                        composer2.startReplaceableGroup(1157296644);
                        boolean changed2 = composer2.changed(state);
                        Object rememberedValue6 = composer2.rememberedValue();
                        if (changed2 || rememberedValue6 == obj) {
                            rememberedValue6 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    SemanticsPropertyKey<Function0<Offset>> semanticsPropertyKey = MagnifierKt.MagnifierPositionInRoot;
                                    final State<Offset> state3 = state;
                                    semantics.set(semanticsPropertyKey, new Function0<Offset>() { // from class: androidx.compose.foundation.MagnifierKt$magnifier$4$4$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Offset invoke() {
                                            return new Offset(state3.getValue().packedValue);
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue6);
                        }
                        composer2.endReplaceableGroup();
                        Modifier semantics = SemanticsModifierKt.semantics(drawBehind, false, (Function1) rememberedValue6);
                        composer2.endReplaceableGroup();
                        return semantics;
                    }
                });
            } else {
                throw new UnsupportedOperationException("Magnifier is only supported on API level 28 and higher.");
            }
        } else {
            modifier = companion;
        }
        return InspectableValueKt.inspectableWrapper(companion, inspectableValueKt$NoInspectorInfo$1, modifier);
    }
}
