package androidx.compose.foundation;

import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Scroll.kt */
/* loaded from: classes.dex */
public final class ScrollKt {
    public static final ScrollState rememberScrollState(Composer composer) {
        composer.startReplaceableGroup(-1464256199);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final int r0 = 0;
        Object[] objArr = new Object[0];
        SaverKt$Saver$1 saverKt$Saver$1 = ScrollState.Saver;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) 0);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new Function0<ScrollState>() { // from class: androidx.compose.foundation.ScrollKt$rememberScrollState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final ScrollState invoke() {
                    return new ScrollState(r0);
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ScrollState scrollState = (ScrollState) RememberSaveableKt.rememberSaveable(objArr, saverKt$Saver$1, (Function0) rememberedValue, composer, 4);
        composer.endReplaceableGroup();
        return scrollState;
    }

    public static Modifier verticalScroll$default(Modifier modifier, final ScrollState state, final boolean z, int r6) {
        if ((r6 & 2) != 0) {
            z = true;
        }
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        final FlingBehavior flingBehavior = null;
        final boolean z2 = false;
        return ComposedModifierKt.composed(modifier, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2
            public final /* synthetic */ boolean $isVertical = true;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Modifier invoke(Modifier modifier2, Composer composer, Integer num) {
                Orientation orientation;
                boolean z3;
                Composer composer2 = composer;
                EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier2, "$this$composed", composer2, 1478351300);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                OverscrollEffect overscrollEffect = ScrollableDefaults.overscrollEffect(composer2);
                composer2.startReplaceableGroup(773894976);
                composer2.startReplaceableGroup(-492369756);
                Object rememberedValue = composer2.rememberedValue();
                if (rememberedValue == Composer.Companion.Empty) {
                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer2));
                    composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                }
                composer2.endReplaceableGroup();
                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
                composer2.endReplaceableGroup();
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                final boolean z4 = z2;
                final boolean z5 = this.$isVertical;
                final boolean z6 = z;
                final ScrollState scrollState = state;
                boolean z7 = false;
                Modifier semantics = SemanticsModifierKt.semantics(companion, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertyReceiver semantics2 = semanticsPropertyReceiver;
                        Intrinsics.checkNotNullParameter(semantics2, "$this$semantics");
                        KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                        SemanticsPropertyKey<Boolean> semanticsPropertyKey = SemanticsProperties.IsTraversalGroup;
                        KProperty<?>[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                        semanticsPropertyKey.setValue(semantics2, kPropertyArr2[6], Boolean.TRUE);
                        final ScrollState scrollState2 = scrollState;
                        ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$accessibilityScrollState$1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(ScrollState.this.getValue());
                            }
                        }, new Function0<Float>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$accessibilityScrollState$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(ScrollState.this._maxValueState.getIntValue());
                            }
                        }, z4);
                        final boolean z8 = z5;
                        if (z8) {
                            SemanticsProperties.VerticalScrollAxisRange.setValue(semantics2, kPropertyArr2[9], scrollAxisRange);
                        } else {
                            SemanticsProperties.HorizontalScrollAxisRange.setValue(semantics2, kPropertyArr2[8], scrollAxisRange);
                        }
                        if (z6) {
                            final CoroutineScope coroutineScope2 = coroutineScope;
                            semantics2.set(SemanticsActions.ScrollBy, new AccessibilityAction(null, new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1.1

                                /* compiled from: Scroll.kt */
                                @DebugMetadata(c = "androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1", f = "Scroll.kt", l = {288, 290}, m = "invokeSuspend")
                                /* renamed from: androidx.compose.foundation.ScrollKt$scroll$2$semantics$1$1$1, reason: invalid class name and collision with other inner class name */
                                /* loaded from: classes.dex */
                                public final class C00031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    public final /* synthetic */ boolean $isVertical;
                                    public final /* synthetic */ ScrollState $state;
                                    public final /* synthetic */ float $x;
                                    public final /* synthetic */ float $y;
                                    public int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public C00031(boolean z, ScrollState scrollState, float f, float f2, Continuation<? super C00031> continuation) {
                                        super(2, continuation);
                                        this.$isVertical = z;
                                        this.$state = scrollState;
                                        this.$y = f;
                                        this.$x = f2;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C00031(this.$isVertical, this.$state, this.$y, this.$x, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C00031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        Object animateScrollBy;
                                        Object animateScrollBy2;
                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                        int r1 = this.label;
                                        if (r1 != 0) {
                                            if (r1 != 1 && r1 != 2) {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            ResultKt.throwOnFailure(obj);
                                        } else {
                                            ResultKt.throwOnFailure(obj);
                                            boolean z = this.$isVertical;
                                            ScrollState scrollState = this.$state;
                                            if (z) {
                                                Intrinsics.checkNotNull(scrollState, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                                this.label = 1;
                                                animateScrollBy2 = ScrollExtensionsKt.animateScrollBy(scrollState, this.$y, AnimationSpecKt.spring$default(0.0f, null, 7), this);
                                                if (animateScrollBy2 == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            } else {
                                                Intrinsics.checkNotNull(scrollState, "null cannot be cast to non-null type androidx.compose.foundation.gestures.ScrollableState");
                                                this.label = 2;
                                                animateScrollBy = ScrollExtensionsKt.animateScrollBy(scrollState, this.$x, AnimationSpecKt.spring$default(0.0f, null, 7), this);
                                                if (animateScrollBy == coroutineSingletons) {
                                                    return coroutineSingletons;
                                                }
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Boolean invoke(Float f, Float f2) {
                                    float floatValue = f.floatValue();
                                    BuildersKt.launch$default(CoroutineScope.this, null, null, new C00031(z8, scrollState2, f2.floatValue(), floatValue, null), 3);
                                    return Boolean.TRUE;
                                }
                            }));
                        }
                        return Unit.INSTANCE;
                    }
                });
                boolean z8 = this.$isVertical;
                if (z8) {
                    orientation = Orientation.Vertical;
                } else {
                    orientation = Orientation.Horizontal;
                }
                Orientation orientation2 = orientation;
                LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.LocalLayoutDirection);
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                Intrinsics.checkNotNullParameter(orientation2, "orientation");
                boolean z9 = z2;
                boolean z10 = !z9;
                if (layoutDirection == LayoutDirection.Rtl) {
                    z7 = true;
                }
                if (z7 && orientation2 != Orientation.Vertical) {
                    z3 = !z10;
                } else {
                    z3 = z10;
                }
                ScrollState scrollState2 = state;
                Modifier then = ProgressionUtilKt.overscroll(ClipScrollableContainerKt.clipScrollableContainer(semantics, orientation2), overscrollEffect).then(ScrollableKt.scrollable(companion, scrollState2, orientation2, overscrollEffect, z, z3, flingBehavior, scrollState2.internalInteractionSource)).then(new ScrollingLayoutElement(scrollState2, z9, z8));
                composer2.endReplaceableGroup();
                return then;
            }
        });
    }
}
