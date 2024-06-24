package com.animaconnected.secondo.screens.onboarding;

import android.graphics.PointF;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Center$1;
import androidx.compose.foundation.layout.Arrangement$SpaceAround$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Crop$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.text.style.TextAlign;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieAnimationKt;
import com.airbnb.lottie.compose.LottieAnimationState;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import com.airbnb.lottie.compose.LottieCompositionResultImpl;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.compose.RememberLottieCompositionKt;
import com.airbnb.lottie.utils.MiscUtils;
import com.animaconnected.secondo.provider.lottie.LottieFile;
import com.animaconnected.secondo.provider.lottie.LottieKt;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.ButtonFilledKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: OnboardingDisplayWatchTutorial.kt */
/* loaded from: classes3.dex */
public final class OnboardingDisplayWatchTutorial extends ComposeOnboardingFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "OnboardingDisplayWatchTutorial";
    private final LottieClipSpec.Frame primeFrames = new LottieClipSpec.Frame((Integer) 1, (Integer) 7, 4);
    private LottieClipSpec.Frame scrollFrames = new LottieClipSpec.Frame((Integer) 8, (Integer) 228, 4);
    private final LottieClipSpec.Frame selectFrames = new LottieClipSpec.Frame((Integer) 229, (Integer) 528, 4);
    private final LottieClipSpec.Frame backFrames = new LottieClipSpec.Frame((Integer) 529, (Integer) 799, 4);

    /* compiled from: OnboardingDisplayWatchTutorial.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OnboardingDisplayWatchTutorial newInstance() {
            OnboardingDisplayWatchTutorial onboardingDisplayWatchTutorial = new OnboardingDisplayWatchTutorial();
            onboardingDisplayWatchTutorial.setBackAllowed(false);
            return onboardingDisplayWatchTutorial;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: OnboardingDisplayWatchTutorial.kt */
    /* loaded from: classes3.dex */
    public static final class State {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ State[] $VALUES;
        public static final State Prime = new State("Prime", 0);
        public static final State Scroll = new State("Scroll", 1);
        public static final State Select = new State("Select", 2);
        public static final State Back = new State("Back", 3);

        private static final /* synthetic */ State[] $values() {
            return new State[]{Prime, Scroll, Select, Back};
        }

        static {
            State[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private State(String str, int r2) {
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String str) {
            return (State) Enum.valueOf(State.class, str);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    /* compiled from: OnboardingDisplayWatchTutorial.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[State.values().length];
            try {
                r0[State.Prime.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[State.Scroll.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[State.Select.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[State.Back.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$2, kotlin.jvm.internal.Lambda] */
    public final void Buttons(Modifier modifier, final State state, final Function1<? super State, Unit> function1, Composer composer, final int r23, final int r24) {
        final Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-41346425);
        if ((r24 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        AnimatedContentKt.AnimatedContent(state, modifier2, new Function1<AnimatedContentTransitionScope<State>, ContentTransform>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ContentTransform invoke(AnimatedContentTransitionScope<OnboardingDisplayWatchTutorial.State> AnimatedContent) {
                ContentTransform buttonTransitions;
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                buttonTransitions = OnboardingDisplayWatchTutorial.this.buttonTransitions(AnimatedContent);
                return buttonTransitions;
            }
        }, null, "buttons", null, ComposableLambdaKt.composableLambda(startRestartGroup, 1344612915, new Function4<AnimatedContentScope, State, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$2

            /* compiled from: OnboardingDisplayWatchTutorial.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[OnboardingDisplayWatchTutorial.State.values().length];
                    try {
                        r0[OnboardingDisplayWatchTutorial.State.Prime.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, OnboardingDisplayWatchTutorial.State state2, Composer composer2, Integer num) {
                invoke(animatedContentScope, state2, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedContentScope AnimatedContent, OnboardingDisplayWatchTutorial.State targetState, Composer composer2, int r20) {
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                Intrinsics.checkNotNullParameter(targetState, "targetState");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
                final Function1<OnboardingDisplayWatchTutorial.State, Unit> function12 = function1;
                final OnboardingDisplayWatchTutorial onboardingDisplayWatchTutorial = this;
                OnboardingDisplayWatchTutorial.State state2 = state;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    int r1 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
                    Object obj = Composer.Companion.Empty;
                    if (r1 == 1) {
                        composer2.startReplaceableGroup(-167223255);
                        String stringResource = URLProtocolKt.stringResource(R.string.button_get_started, composer2);
                        composer2.startReplaceableGroup(-167223085);
                        boolean changedInstance = composer2.changedInstance(function12);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == obj) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$2$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    function12.invoke(OnboardingDisplayWatchTutorial.State.Scroll);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        ButtonFilledKt.ButtonFilled(null, stringResource, false, (Function0) rememberedValue, composer2, 0, 5);
                        ButtonBorderlessKt.ButtonBorderless(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 8, 0.0f, 0.0f, 13), URLProtocolKt.stringResource(R.string.button_not_now, composer2), false, false, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$2$1$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                OnboardingDisplayWatchTutorial.this.finishTutorial();
                            }
                        }, composer2, 6, 12);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-167222679);
                        composer2.startReplaceableGroup(-167222588);
                        boolean changedInstance2 = composer2.changedInstance(function12);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changedInstance2 || rememberedValue2 == obj) {
                            rememberedValue2 = new Function1<OnboardingDisplayWatchTutorial.State, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$2$1$3$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(OnboardingDisplayWatchTutorial.State state3) {
                                    invoke2(state3);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(OnboardingDisplayWatchTutorial.State state3) {
                                    Intrinsics.checkNotNullParameter(state3, "state");
                                    function12.invoke(state3);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        onboardingDisplayWatchTutorial.PageButtons(state2, (Function1) rememberedValue2, composer2, DfuBaseService.ERROR_REMOTE_TYPE_SECURE);
                        composer2.endReplaceableGroup();
                    }
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r23 >> 3) & 14) | 1597440 | ((r23 << 3) & 112), 40);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Buttons$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    OnboardingDisplayWatchTutorial.this.Buttons(modifier2, state, function1, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                }
            };
        }
    }

    private static final State ComposeContent$lambda$1(MutableState<State> mutableState) {
        return mutableState.getValue();
    }

    private static final LottieComposition ComposeContent$lambda$3(LottieCompositionResult lottieCompositionResult) {
        return lottieCompositionResult.getValue();
    }

    private static final float ComposeContent$lambda$4(androidx.compose.runtime.State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void DotsIndicator(Modifier modifier, final int r19, Composer composer, final int r21, final int r22) {
        Modifier modifier2;
        int r5;
        int r52;
        int r6;
        Modifier modifier3;
        final Modifier modifier4;
        long j;
        Modifier m21backgroundbw27NRU;
        int r9;
        int r62;
        Modifier.Companion companion;
        ComposerImpl startRestartGroup = composer.startRestartGroup(215460026);
        int r1 = r22 & 1;
        if (r1 != 0) {
            r5 = r21 | 6;
            modifier2 = modifier;
        } else if ((r21 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r21 | r52;
        } else {
            modifier2 = modifier;
            r5 = r21;
        }
        if ((r22 & 2) != 0) {
            r5 |= 48;
        } else if ((r21 & 112) == 0) {
            if (startRestartGroup.changed(r19)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r5 |= r6;
        }
        if ((r5 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier4 = modifier2;
        } else {
            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
            if (r1 != 0) {
                modifier3 = companion2;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            int r4 = r5 & 14;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
            int r14 = 3;
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier3);
            int r13 = 6;
            int r42 = ((((r4 << 3) & 112) << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedContentKt$$ExternalSyntheticOutline1.m((r42 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -2088932060);
                int r53 = 0;
                while (r53 < r14) {
                    startRestartGroup.startReplaceableGroup(674931830);
                    if (r53 == r19) {
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        j = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
                    } else {
                        j = Color.DarkGray;
                    }
                    startRestartGroup.end(false);
                    m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(ClipKt.clip(SizeKt.m91size3ABfNKs(companion2, 5), RoundedCornerShapeKt.CircleShape), j, RectangleShapeKt.RectangleShape);
                    BoxKt.Box(m21backgroundbw27NRU, startRestartGroup, 0);
                    startRestartGroup.startReplaceableGroup(674932126);
                    if (r53 < 2) {
                        r9 = r13;
                        r62 = r14;
                        companion = companion2;
                        SpacerKt.Spacer(PaddingKt.m75paddingqDBjuR0$default(companion2, 4, 0.0f, 0.0f, 0.0f, 14), startRestartGroup, r9);
                    } else {
                        r9 = r13;
                        r62 = r14;
                        companion = companion2;
                    }
                    startRestartGroup.end(false);
                    r53++;
                    r14 = r62;
                    companion2 = companion;
                    r13 = r9;
                }
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                startRestartGroup.end(false);
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                modifier4 = modifier3;
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$DotsIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    OnboardingDisplayWatchTutorial.this.DotsIndicator(modifier4, r19, composer2, Strings.updateChangedFlags(r21 | 1), r22);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Lottie$2, kotlin.jvm.internal.Lambda] */
    public final void Lottie(Modifier modifier, final State state, final LottieComposition lottieComposition, final LottieAnimationState lottieAnimationState, Composer composer, final int r21, final int r22) {
        Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-773364029);
        if ((r22 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        AnimatedContentKt.AnimatedContent(state, modifier2, new Function1<AnimatedContentTransitionScope<State>, ContentTransform>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Lottie$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ContentTransform invoke(AnimatedContentTransitionScope<OnboardingDisplayWatchTutorial.State> AnimatedContent) {
                ContentTransform lottieTransitions;
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                lottieTransitions = OnboardingDisplayWatchTutorial.this.lottieTransitions(AnimatedContent);
                return lottieTransitions;
            }
        }, null, "lottie", null, ComposableLambdaKt.composableLambda(startRestartGroup, -762020753, new Function4<AnimatedContentScope, State, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Lottie$2

            /* compiled from: OnboardingDisplayWatchTutorial.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[OnboardingDisplayWatchTutorial.State.values().length];
                    try {
                        r0[OnboardingDisplayWatchTutorial.State.Prime.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        r0[OnboardingDisplayWatchTutorial.State.Scroll.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        r0[OnboardingDisplayWatchTutorial.State.Select.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        r0[OnboardingDisplayWatchTutorial.State.Back.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, OnboardingDisplayWatchTutorial.State state2, Composer composer2, Integer num) {
                invoke(animatedContentScope, state2, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedContentScope AnimatedContent, OnboardingDisplayWatchTutorial.State targetState, Composer composer2, int r32) {
                Composer composer3;
                String str;
                Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
                Intrinsics.checkNotNullParameter(targetState, "targetState");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
                LottieComposition lottieComposition2 = LottieComposition.this;
                final LottieAnimationState lottieAnimationState2 = lottieAnimationState;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, horizontal, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    ContentScale$Companion$Crop$1 contentScale$Companion$Crop$1 = ContentScale.Companion.Crop;
                    composer2.startReplaceableGroup(-294298051);
                    boolean changed = composer2.changed(lottieAnimationState2);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function0<Float>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Lottie$2$1$1$1
                            {
                                super(0);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function0
                            public final Float invoke() {
                                return Float.valueOf(LottieAnimationState.this.getProgress());
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    LottieAnimationKt.LottieAnimation(lottieComposition2, (Function0) rememberedValue, null, false, false, false, null, false, null, null, contentScale$Companion$Crop$1, false, composer2, 8, 6, 3068);
                    int r1 = WhenMappings.$EnumSwitchMapping$0[targetState.ordinal()];
                    if (r1 == 1) {
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-533301021);
                        composer2.endReplaceableGroup();
                        str = "";
                    } else if (r1 == 2) {
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-294297886);
                        str = URLProtocolKt.stringResource(R.string.watch_tutorial_substep_scroll, composer3);
                        composer2.endReplaceableGroup();
                    } else if (r1 == 3) {
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-294297797);
                        str = URLProtocolKt.stringResource(R.string.watch_tutorial_substep_select, composer3);
                        composer2.endReplaceableGroup();
                    } else {
                        if (r1 != 4) {
                            composer2.startReplaceableGroup(-294303989);
                            composer2.endReplaceableGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer3 = composer2;
                        composer3.startReplaceableGroup(-294297710);
                        str = URLProtocolKt.stringResource(R.string.watch_tutorial_substep_back, composer3);
                        composer2.endReplaceableGroup();
                    }
                    TextKt.m216Text4IGK_g(str, null, ((Colors) composer3.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer3.consume(TypographyKt.LocalTypography)).h2, composer2, 0, 0, 65530);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r21 >> 3) & 14) | 1597440 | ((r21 << 3) & 112), 40);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$Lottie$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r10) {
                    OnboardingDisplayWatchTutorial.this.Lottie(modifier3, state, lottieComposition, lottieAnimationState, composer2, Strings.updateChangedFlags(r21 | 1), r22);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void PageButtons(final com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial.State r19, final kotlin.jvm.functions.Function1<? super com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial.State, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial.PageButtons(com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$State, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewButtons$1, kotlin.jvm.internal.Lambda] */
    public final void PreviewButtons(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-309798948);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, 229151948, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewButtons$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r9) {
                if ((r9 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 8);
                OnboardingDisplayWatchTutorial onboardingDisplayWatchTutorial = OnboardingDisplayWatchTutorial.this;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    onboardingDisplayWatchTutorial.Buttons(null, OnboardingDisplayWatchTutorial.State.Prime, new Function1<OnboardingDisplayWatchTutorial.State, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewButtons$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(OnboardingDisplayWatchTutorial.State it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(OnboardingDisplayWatchTutorial.State state) {
                            invoke2(state);
                            return Unit.INSTANCE;
                        }
                    }, composer2, 4528, 1);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewButtons$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r4) {
                    OnboardingDisplayWatchTutorial.this.PreviewButtons(composeThemeProvider, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewDotsIndicator$1, kotlin.jvm.internal.Lambda] */
    public final void PreviewDotsIndicator(final ComposeThemeProvider composeThemeProvider, Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(432917696);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(composeThemeProvider, ComposableLambdaKt.composableLambda(startRestartGroup, 302519728, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewDotsIndicator$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r13) {
                if ((r13 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                float f = 8;
                Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, f);
                OnboardingDisplayWatchTutorial onboardingDisplayWatchTutorial = OnboardingDisplayWatchTutorial.this;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
                if (composer2.getApplier() instanceof Applier) {
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        composer2.useNode();
                    }
                    Updater.m228setimpl(composer2, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                    onboardingDisplayWatchTutorial.PageButtons(OnboardingDisplayWatchTutorial.State.Prime, new Function1<OnboardingDisplayWatchTutorial.State, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewDotsIndicator$1$1$1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(OnboardingDisplayWatchTutorial.State it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(OnboardingDisplayWatchTutorial.State state) {
                            invoke2(state);
                            return Unit.INSTANCE;
                        }
                    }, composer2, 566);
                    onboardingDisplayWatchTutorial.DotsIndicator(null, 0, composer2, 560, 1);
                    SpacerKt.Spacer(SizeKt.m91size3ABfNKs(companion, f), composer2, 6);
                    onboardingDisplayWatchTutorial.DotsIndicator(null, 1, composer2, 560, 1);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$PreviewDotsIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r4) {
                    OnboardingDisplayWatchTutorial.this.PreviewDotsIndicator(composeThemeProvider, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void TitleDescription(Modifier modifier, final float f, Composer composer, final int r33, final int r34) {
        final Modifier modifier2;
        int r4;
        int r42;
        int r5;
        ComposerImpl startRestartGroup = composer.startRestartGroup(2001120680);
        int r1 = r34 & 1;
        if (r1 != 0) {
            r4 = r33 | 6;
            modifier2 = modifier;
        } else if ((r33 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r42 = 4;
            } else {
                r42 = 2;
            }
            r4 = r33 | r42;
        } else {
            modifier2 = modifier;
            r4 = r33;
        }
        if ((r34 & 2) != 0) {
            r4 |= 48;
        } else if ((r33 & 112) == 0) {
            if (startRestartGroup.changed(f)) {
                r5 = 32;
            } else {
                r5 = 16;
            }
            r4 |= r5;
        }
        if ((r4 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r1 != 0) {
                modifier2 = companion;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Arrangement$Center$1 arrangement$Center$1 = Arrangement.Center;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Center$1, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
            int r52 = ((((((r4 & 14) | 48) << 3) & 112) << 9) & 7168) | 6;
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r52 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                boolean z = true;
                ScreenTitleKt.ScreenTitle(null, URLProtocolKt.stringResource(R.string.watch_tutorial_title, startRestartGroup), startRestartGroup, 0, 1);
                String stringResource = URLProtocolKt.stringResource(R.string.watch_tutorial_body, startRestartGroup);
                Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 32, 0.0f, 0.0f, 13);
                startRestartGroup.startReplaceableGroup(-1743269163);
                if ((r4 & 112) != 32) {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                if (z || nextSlot == Composer.Companion.Empty) {
                    nextSlot = new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$TitleDescription$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                            invoke2(graphicsLayerScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(GraphicsLayerScope graphicsLayer) {
                            Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                            graphicsLayer.setAlpha(f);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                TextKt.m216Text4IGK_g(stringResource, GraphicsLayerModifierKt.graphicsLayer(m75paddingqDBjuR0$default, (Function1) nextSlot), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, new TextAlign(3), 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, 0, 0, 65016);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$TitleDescription$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r8) {
                    OnboardingDisplayWatchTutorial.this.TitleDescription(modifier2, f, composer2, Strings.updateChangedFlags(r33 | 1), r34);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentTransform buttonTransitions(AnimatedContentTransitionScope<State> animatedContentTransitionScope) {
        if (animatedContentTransitionScope.getTargetState() == State.Scroll && animatedContentTransitionScope.getInitialState() == State.Prime) {
            return new ContentTransform(EnterExitTransitionKt.fadeIn$default(new TweenSpec(200, 200, null, 4), 2), EnterExitTransitionKt.fadeOut$default(new TweenSpec(200, 0, null, 6), 2));
        }
        return new ContentTransform(EnterTransition.None, ExitTransition.None);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishTutorial() {
        Onboarding.setHandled$default(getOnboarding(), Onboarding.State.DISPLAY_WATCH_TUTORIAL, false, 2, null);
        getOnboarding().updateState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ContentTransform lottieTransitions(AnimatedContentTransitionScope<State> animatedContentTransitionScope) {
        if (animatedContentTransitionScope.getInitialState() == State.Prime && animatedContentTransitionScope.getTargetState() == State.Scroll) {
            return new ContentTransform(EnterTransition.None, ExitTransition.None);
        }
        final int r0 = 100;
        if (animatedContentTransitionScope.getTargetState().ordinal() > animatedContentTransitionScope.getInitialState().ordinal()) {
            return new ContentTransform(EnterExitTransitionKt.slideInHorizontally(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 200, null, 4), new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$lottieTransitions$slideIn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Integer invoke(int r1) {
                    return Integer.valueOf(r0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 200, null, 4), 2)), EnterExitTransitionKt.slideOutHorizontally(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 0, null, 6), new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$lottieTransitions$slideOut$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Integer invoke(int r1) {
                    return Integer.valueOf(-r0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }).plus(EnterExitTransitionKt.fadeOut$default(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 0, null, 6), 2)));
        }
        if (animatedContentTransitionScope.getTargetState().ordinal() < animatedContentTransitionScope.getInitialState().ordinal()) {
            return new ContentTransform(EnterExitTransitionKt.slideInHorizontally(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 200, null, 4), new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$lottieTransitions$slideIn$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Integer invoke(int r1) {
                    return Integer.valueOf(-r0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }).plus(EnterExitTransitionKt.fadeIn$default(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 200, null, 4), 2)), EnterExitTransitionKt.slideOutHorizontally(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 0, null, 6), new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$lottieTransitions$slideOut$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Integer invoke(int r1) {
                    return Integer.valueOf(r0);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
                    return invoke(num.intValue());
                }
            }).plus(EnterExitTransitionKt.fadeOut$default(new TweenSpec(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 0, null, 6), 2)));
        }
        return new ContentTransform(EnterTransition.None, ExitTransition.None);
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r20) {
        LottieClipSpec.Frame frame;
        float f;
        Modifier m21backgroundbw27NRU;
        float f2;
        boolean z;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1757956562);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-1898728175);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(State.Prime);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        LottieCompositionResultImpl rememberLottieComposition = RememberLottieCompositionKt.rememberLottieComposition(new LottieCompositionSpec.Asset(LottieKt.asSpec(LottieFile.PascalInteractionGuideFull)), startRestartGroup);
        LottieComposition ComposeContent$lambda$3 = ComposeContent$lambda$3(rememberLottieComposition);
        int r1 = WhenMappings.$EnumSwitchMapping$0[ComposeContent$lambda$1(mutableState).ordinal()];
        if (r1 != 1) {
            if (r1 != 2) {
                if (r1 != 3) {
                    if (r1 == 4) {
                        frame = this.backFrames;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    frame = this.selectFrames;
                }
            } else {
                frame = this.scrollFrames;
            }
        } else {
            frame = this.primeFrames;
        }
        LottieAnimatable animateLottieCompositionAsState = AnimateLottieCompositionAsStateKt.animateLottieCompositionAsState(ComposeContent$lambda$3, false, false, frame, 0.0f, Integer.MAX_VALUE, startRestartGroup, 214);
        if (ComposeContent$lambda$1(mutableState) == State.Scroll) {
            LottieComposition ComposeContent$lambda$32 = ComposeContent$lambda$3(rememberLottieComposition);
            if (ComposeContent$lambda$32 != null) {
                float progress = animateLottieCompositionAsState.getProgress();
                float f3 = ComposeContent$lambda$32.startFrame;
                float f4 = ComposeContent$lambda$32.endFrame;
                PointF pointF = MiscUtils.pathFromDataCurrentPoint;
                f2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f4, f3, progress, f3);
            } else {
                f2 = 0.0f;
            }
            if (f2 >= 35.0f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LottieClipSpec.Frame frame2 = this.scrollFrames;
                this.scrollFrames = new LottieClipSpec.Frame((Integer) 35, frame2.max, frame2.maxInclusive);
            }
        }
        if (ComposeContent$lambda$1(mutableState) == State.Prime) {
            f = 1.0f;
        } else {
            f = 0.0f;
        }
        androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, new TweenSpec(0, 0, null, 7), "TitleDescriptionAlpha", null, startRestartGroup, 3120, 20);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxSize$default(companion), 40, 0.0f, 2), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
        Arrangement$SpaceAround$1 arrangement$SpaceAround$1 = Arrangement.SpaceAround;
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$SpaceAround$1, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TitleDescription(columnScopeInstance.weight(companion, 1.0f, true), ComposeContent$lambda$4(animateFloatAsState), startRestartGroup, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 0);
            Lottie(null, ComposeContent$lambda$1(mutableState), ComposeContent$lambda$3(rememberLottieComposition), animateLottieCompositionAsState, startRestartGroup, 33280, 1);
            Modifier weight = columnScopeInstance.weight(companion, 1.0f, true);
            State ComposeContent$lambda$1 = ComposeContent$lambda$1(mutableState);
            startRestartGroup.startReplaceableGroup(1992997828);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function1<State, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$ComposeContent$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(OnboardingDisplayWatchTutorial.State state) {
                        invoke2(state);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(OnboardingDisplayWatchTutorial.State it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        mutableState.setValue(it);
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            Buttons(weight, ComposeContent$lambda$1, (Function1) nextSlot2, startRestartGroup, 4480, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingDisplayWatchTutorial$ComposeContent$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r3) {
                        OnboardingDisplayWatchTutorial.this.ComposeContent(composer2, Strings.updateChangedFlags(r20 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.DISPLAY_WATCH_TUTORIAL) {
            return true;
        }
        return false;
    }
}
