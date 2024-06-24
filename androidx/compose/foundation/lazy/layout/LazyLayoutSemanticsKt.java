package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.widget.SuggestionsAdapter$$ExternalSyntheticOutline0;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutSemantics.kt */
/* loaded from: classes.dex */
public final class LazyLayoutSemanticsKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1] */
    /* JADX WARN: Type inference failed for: r14v0, types: [androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1] */
    /* JADX WARN: Type inference failed for: r6v3, types: [androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1] */
    public static final Modifier lazyLayoutSemantics(Modifier modifier, final KProperty0 itemProviderLambda, final LazyLayoutSemanticState state, Orientation orientation, boolean z, boolean z2, Composer composer) {
        final boolean z3;
        final LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(itemProviderLambda, "itemProviderLambda");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        composer.startReplaceableGroup(1070136913);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(773894976);
        composer.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (rememberedValue == composer$Companion$Empty$1) {
            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            rememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).coroutineScope;
        composer.endReplaceableGroup();
        Object[] objArr = {itemProviderLambda, state, orientation, Boolean.valueOf(z)};
        composer.startReplaceableGroup(-568225417);
        boolean z4 = false;
        for (int r9 = 0; r9 < 4; r9++) {
            z4 |= composer.changed(objArr[r9]);
        }
        Object rememberedValue2 = composer.rememberedValue();
        if (z4 || rememberedValue2 == composer$Companion$Empty$1) {
            if (orientation == Orientation.Vertical) {
                z3 = true;
            } else {
                z3 = false;
            }
            final ?? r10 = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$indexForKeyMapping$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(Object needle) {
                    Intrinsics.checkNotNullParameter(needle, "needle");
                    LazyLayoutItemProvider invoke = itemProviderLambda.invoke();
                    int itemCount = invoke.getItemCount();
                    int r2 = 0;
                    while (true) {
                        if (r2 < itemCount) {
                            if (Intrinsics.areEqual(invoke.getKey(r2), needle)) {
                                break;
                            }
                            r2++;
                        } else {
                            r2 = -1;
                            break;
                        }
                    }
                    return Integer.valueOf(r2);
                }
            };
            final ScrollAxisRange scrollAxisRange = new ScrollAxisRange(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(LazyLayoutSemanticState.this.getCurrentPosition());
                }
            }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$accessibilityScrollState$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    float currentPosition;
                    LazyLayoutItemProvider invoke = itemProviderLambda.invoke();
                    LazyLayoutSemanticState lazyLayoutSemanticState = state;
                    if (lazyLayoutSemanticState.getCanScrollForward()) {
                        currentPosition = invoke.getItemCount() + 1.0f;
                    } else {
                        currentPosition = lazyLayoutSemanticState.getCurrentPosition();
                    }
                    return Float.valueOf(currentPosition);
                }
            }, z2);
            Function1<Integer, Boolean> function1 = null;
            if (z) {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 = new Function2<Float, Float, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1

                    /* compiled from: LazyLayoutSemantics.kt */
                    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1", f = "LazyLayoutSemantics.kt", l = {99}, m = "invokeSuspend")
                    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1$1, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        public final /* synthetic */ float $delta;
                        public final /* synthetic */ LazyLayoutSemanticState $state;
                        public int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(LazyLayoutSemanticState lazyLayoutSemanticState, float f, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$state = lazyLayoutSemanticState;
                            this.$delta = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$state, this.$delta, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                this.label = 1;
                                if (this.$state.animateScrollBy(this.$delta, this) == coroutineSingletons) {
                                    return coroutineSingletons;
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
                        float floatValue2 = f2.floatValue();
                        if (z3) {
                            floatValue = floatValue2;
                        }
                        BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(state, floatValue, null), 3);
                        return Boolean.TRUE;
                    }
                };
            } else {
                lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1 = null;
            }
            if (z) {
                function1 = new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1

                    /* compiled from: LazyLayoutSemantics.kt */
                    @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2", f = "LazyLayoutSemantics.kt", l = {116}, m = "invokeSuspend")
                    /* renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollToIndexAction$1$2, reason: invalid class name */
                    /* loaded from: classes.dex */
                    public final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        public final /* synthetic */ int $index;
                        public final /* synthetic */ LazyLayoutSemanticState $state;
                        public int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass2(LazyLayoutSemanticState lazyLayoutSemanticState, int r2, Continuation<? super AnonymousClass2> continuation) {
                            super(2, continuation);
                            this.$state = lazyLayoutSemanticState;
                            this.$index = r2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass2(this.$state, this.$index, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                                this.label = 1;
                                if (this.$state.scrollToItem(this.$index, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(Integer num) {
                        boolean z5;
                        int intValue = num.intValue();
                        LazyLayoutItemProvider invoke = itemProviderLambda.invoke();
                        if (intValue >= 0 && intValue < invoke.getItemCount()) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (z5) {
                            BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass2(state, intValue, null), 3);
                            return Boolean.TRUE;
                        }
                        StringBuilder m = SuggestionsAdapter$$ExternalSyntheticOutline0.m("Can't scroll to index ", intValue, ", it is out of bounds [0, ");
                        m.append(invoke.getItemCount());
                        m.append(')');
                        throw new IllegalArgumentException(m.toString().toString());
                    }
                };
            }
            final ?? r14 = function1;
            final CollectionInfo collectionInfo = state.collectionInfo();
            rememberedValue2 = SemanticsModifierKt.semantics(Modifier.Companion.$$INSTANCE, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsKt$lazyLayoutSemantics$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertyReceiver semantics = semanticsPropertyReceiver;
                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                    KProperty<Object>[] kPropertyArr = SemanticsPropertiesKt.$$delegatedProperties;
                    SemanticsPropertyKey<Boolean> semanticsPropertyKey = SemanticsProperties.IsTraversalGroup;
                    KProperty<?>[] kPropertyArr2 = SemanticsPropertiesKt.$$delegatedProperties;
                    semanticsPropertyKey.setValue(semantics, kPropertyArr2[6], Boolean.TRUE);
                    Function1<Object, Integer> mapping = r10;
                    Intrinsics.checkNotNullParameter(mapping, "mapping");
                    semantics.set(SemanticsProperties.IndexForKey, mapping);
                    boolean z5 = z3;
                    ScrollAxisRange scrollAxisRange2 = scrollAxisRange;
                    if (z5) {
                        Intrinsics.checkNotNullParameter(scrollAxisRange2, "<set-?>");
                        SemanticsProperties.VerticalScrollAxisRange.setValue(semantics, kPropertyArr2[9], scrollAxisRange2);
                    } else {
                        Intrinsics.checkNotNullParameter(scrollAxisRange2, "<set-?>");
                        SemanticsProperties.HorizontalScrollAxisRange.setValue(semantics, kPropertyArr2[8], scrollAxisRange2);
                    }
                    Function2<Float, Float, Boolean> function2 = lazyLayoutSemanticsKt$lazyLayoutSemantics$1$scrollByAction$1;
                    if (function2 != null) {
                        semantics.set(SemanticsActions.ScrollBy, new AccessibilityAction(null, function2));
                    }
                    Function1<Integer, Boolean> function12 = r14;
                    if (function12 != null) {
                        semantics.set(SemanticsActions.ScrollToIndex, new AccessibilityAction(null, function12));
                    }
                    CollectionInfo collectionInfo2 = collectionInfo;
                    Intrinsics.checkNotNullParameter(collectionInfo2, "<set-?>");
                    SemanticsProperties.CollectionInfo.setValue(semantics, kPropertyArr2[16], collectionInfo2);
                    return Unit.INSTANCE;
                }
            });
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        Modifier then = modifier.then((Modifier) rememberedValue2);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        composer.endReplaceableGroup();
        return then;
    }
}
