package com.animaconnected.secondo.screens.settings.health;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.DpCornerSize;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.Shapes;
import androidx.compose.material.ShapesKt;
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
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.animaconnected.secondo.screens.demo.DisabledFunctionalityDescriptionBottomDialogKt;
import com.animaconnected.secondo.widget.compose.DialogKt;
import com.animaconnected.watch.HealthSettingsViewModel;
import com.animaconnected.watch.HealthSettingsViewModelKt;
import com.animaconnected.watch.account.HttpUtilsKt;
import com.animaconnected.watch.display.PascalDisplay;
import com.animaconnected.watch.fitness.Bedtime;
import com.animaconnected.watch.fitness.FitnessDataKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.widget.BackgroundCardKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
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
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: HealthSettings.kt */
/* loaded from: classes3.dex */
public final class HealthSettingsKt {
    private static final float paddingEdge;
    private static final float paddingSectionTitle;

    static {
        float f = 16;
        paddingEdge = f;
        paddingSectionTitle = BackgroundCardKt.getWhiteSpaceBackgroundCard() + f + f;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BaseRow(androidx.compose.ui.Modifier r56, final java.lang.String r57, final java.lang.String r58, final kotlin.jvm.functions.Function0<kotlin.Unit> r59, androidx.compose.runtime.Composer r60, final int r61, final int r62) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt.BaseRow(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$1, kotlin.jvm.internal.Lambda] */
    public static final void DailyGoalSection(Modifier modifier, final HealthGoals healthGoals, final Function1<? super BottomSheetType, Unit> function1, Composer composer, final int r14, final int r15) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-408846511);
        if ((r15 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(R.drawable.app_dropped, modifier, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -558786455, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$1
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

            public final void invoke(Composer composer2, int r17) {
                Modifier cardPadding;
                if ((r17 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                cardPadding = HealthSettingsKt.cardPadding(Modifier.Companion.$$INSTANCE);
                HealthGoals healthGoals2 = HealthGoals.this;
                final Function1<BottomSheetType, Unit> function12 = function1;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(cardPadding);
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
                    String stringResource = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_steps_title, composer2);
                    String str = healthGoals2.getSteps() + ' ' + URLProtocolKt.stringResource(R.string.health_settings_daily_goals_steps_display_unit_title, composer2);
                    composer2.startReplaceableGroup(-121059612);
                    boolean changedInstance = composer2.changedInstance(function12);
                    Object rememberedValue = composer2.rememberedValue();
                    Object obj = Composer.Companion.Empty;
                    if (changedInstance || rememberedValue == obj) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$1$1$1$1
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
                                function12.invoke(BottomSheetType.Walk);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.BaseRow(null, stringResource, str, (Function0) rememberedValue, composer2, 0, 1);
                    DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer2, 0, 15);
                    String stringResource2 = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_stand_title, composer2);
                    String str2 = healthGoals2.getStand() + ' ' + URLProtocolKt.stringResource(R.string.health_settings_daily_goals_stand_display_unit_title, composer2);
                    composer2.startReplaceableGroup(-121059296);
                    boolean changedInstance2 = composer2.changedInstance(function12);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == obj) {
                        rememberedValue2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$1$1$2$1
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
                                function12.invoke(BottomSheetType.Stand);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.BaseRow(null, stringResource2, str2, (Function0) rememberedValue2, composer2, 0, 1);
                    DividerKt.m180DivideroMI9zvI(null, 0L, 0.0f, 0.0f, composer2, 0, 15);
                    String stringResource3 = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_exercise_title, composer2);
                    String str3 = healthGoals2.getExercise() + ' ' + URLProtocolKt.stringResource(R.string.health_settings_daily_goals_exercise_display_unit_title, composer2);
                    composer2.startReplaceableGroup(-121058970);
                    boolean changedInstance3 = composer2.changedInstance(function12);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == obj) {
                        rememberedValue3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$1$1$3$1
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
                                function12.invoke(BottomSheetType.Exercise);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.BaseRow(null, stringResource3, str3, (Function0) rememberedValue3, composer2, 0, 1);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r14 << 3) & 112) | 196614, 28);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$DailyGoalSection$2
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

                public final void invoke(Composer composer2, int r8) {
                    HealthSettingsKt.DailyGoalSection(Modifier.this, healthGoals, function1, composer2, Strings.updateChangedFlags(r14 | 1), r15);
                }
            };
        }
    }

    public static final void GoalPicker(final String str, final List<Integer> list, final int r16, final Function1<? super Integer, Unit> function1, Composer composer, final int r19) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-772041090);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
        startRestartGroup.startReplaceableGroup(733328855);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
        if (startRestartGroup.applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            AndroidView_androidKt.AndroidView(new HealthSettingsKt$GoalPicker$1$1(str, list, r16, ref$IntRef, function1), SizeKt.fillMaxWidth(companion, 1.0f), null, startRestartGroup, 48, 4);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalPicker$2
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

                    public final void invoke(Composer composer2, int r8) {
                        HealthSettingsKt.GoalPicker(str, list, r16, function1, composer2, Strings.updateChangedFlags(r19 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    public static final void GoalSheet(final String str, final List<Integer> list, final int r10, final Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer composer, final int r14) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1600859293);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        GoalPicker(str, list, r10, new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalSheet$1

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalSheet$1$1", f = "HealthSettings.kt", l = {PascalDisplay.right, 371}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalSheet$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $goal;
                final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onConfirmGoalClick;
                final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onHideSheet;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, int r3, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onHideSheet = function1;
                    this.$onConfirmGoalClick = function2;
                    this.$goal = r3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onHideSheet, this.$onConfirmGoalClick, this.$goal, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 != 1) {
                            if (r1 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Function1<Continuation<? super Unit>, Object> function1 = this.$onHideSheet;
                        this.label = 1;
                        if (function1.invoke(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    Function2<Integer, Continuation<? super Unit>, Object> function2 = this.$onConfirmGoalClick;
                    Integer num = new Integer(this.$goal);
                    this.label = 2;
                    if (function2.invoke(num, this) == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r6) {
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(function1, function2, r6, null), 3);
            }
        }, startRestartGroup, (r14 & 14) | 64 | (r14 & 896));
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$GoalSheet$2
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
                    HealthSettingsKt.GoalSheet(str, list, r10, function2, function1, composer2, Strings.updateChangedFlags(r14 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1, kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2, kotlin.jvm.internal.Lambda] */
    public static final void HealthSettingsScreen(final HealthSettingsViewModel healthSettingsViewModel, final ModalBottomSheetState modalBottomSheetState, final GoogleFitUIState googleFitUIState, final StravaUIState stravaUIState, final Function1<? super BottomSheetType, Unit> function1, final Function0<Unit> function0, final Function0<Unit> function02, final BottomSheetType bottomSheetType, Composer composer, final int r37) {
        CornerBasedShape copy;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-379950572);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        long j = Color.Transparent;
        float f = 0;
        copy = r1.copy(r1.topStart, ((Shapes) startRestartGroup.consume(ShapesKt.LocalShapes)).large.topEnd, new DpCornerSize(f), new DpCornerSize(f));
        ModalBottomSheetKt.m191ModalBottomSheetLayoutGs3lGvM(ComposableLambdaKt.composableLambda(startRestartGroup, 1196332326, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$10", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryHintColorActivity}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$10, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass10 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
                final /* synthetic */ GoogleFitUIState $googleFitUIState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass10(GoogleFitUIState googleFitUIState, Continuation<? super AnonymousClass10> continuation) {
                    super(1, continuation);
                    this.$googleFitUIState = googleFitUIState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass10(this.$googleFitUIState, continuation);
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
                        GoogleFitUIState googleFitUIState = this.$googleFitUIState;
                        this.label = 1;
                        obj = googleFitUIState.onDisconnect(this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return obj;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Boolean> continuation) {
                    return ((AnonymousClass10) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$11", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryHintColorDetail}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$11, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass11 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass11(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass11> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass11(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass11) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$12, reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass12 extends AdaptedFunctionReference implements Function0<Unit> {
                final /* synthetic */ CoroutineScope $hideSheetScope;
                final /* synthetic */ ModalBottomSheetState $sheetState;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass12(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
                    super(0, Intrinsics.Kotlin.class, "hideSheet", "HealthSettingsScreen$hideSheet(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/material/ModalBottomSheetState;)Lkotlinx/coroutines/Job;", 8);
                    this.$hideSheetScope = coroutineScope;
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HealthSettingsKt.HealthSettingsScreen$hideSheet(this.$hideSheetScope, this.$sheetState);
                }
            }

            /* compiled from: HealthSettings.kt */
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$13, reason: invalid class name */
            /* loaded from: classes3.dex */
            public /* synthetic */ class AnonymousClass13 extends AdaptedFunctionReference implements Function0<Unit> {
                final /* synthetic */ CoroutineScope $hideSheetScope;
                final /* synthetic */ ModalBottomSheetState $sheetState;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass13(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
                    super(0, Intrinsics.Kotlin.class, "hideSheet", "HealthSettingsScreen$hideSheet(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/material/ModalBottomSheetState;)Lkotlinx/coroutines/Job;", 8);
                    this.$hideSheetScope = coroutineScope;
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HealthSettingsKt.HealthSettingsScreen$hideSheet(this.$hideSheetScope, this.$sheetState);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$15", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_tabTextFont}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$15, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass15 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass15(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass15> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass15(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass15) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$16", f = "HealthSettings.kt", l = {170}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$16, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass16 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
                final /* synthetic */ StravaUIState $stravaUIState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass16(StravaUIState stravaUIState, Continuation<? super AnonymousClass16> continuation) {
                    super(1, continuation);
                    this.$stravaUIState = stravaUIState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass16(this.$stravaUIState, continuation);
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
                        StravaUIState stravaUIState = this.$stravaUIState;
                        this.label = 1;
                        obj = stravaUIState.onDisconnect(this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return obj;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Boolean> continuation) {
                    return ((AnonymousClass16) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$17", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_themeBackgroundResource}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$17, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass17 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass17(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass17> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass17(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass17) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$18", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_themeShadowOpacity}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$18, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass18 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass18(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass18> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass18(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass18) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$2", f = "HealthSettings.kt", l = {126}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$2, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
                final /* synthetic */ HealthSettingsViewModel $viewModel;
                /* synthetic */ int I$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(HealthSettingsViewModel healthSettingsViewModel, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$viewModel = healthSettingsViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$viewModel, continuation);
                    anonymousClass2.I$0 = ((Number) obj).intValue();
                    return anonymousClass2;
                }

                public final Object invoke(int r1, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(Integer.valueOf(r1), continuation)).invokeSuspend(Unit.INSTANCE);
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
                        int r4 = this.I$0;
                        HealthSettingsViewModel healthSettingsViewModel = this.$viewModel;
                        this.label = 1;
                        if (healthSettingsViewModel.setWalkGoal(r4, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                    return invoke(num.intValue(), continuation);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$3", f = "HealthSettings.kt", l = {125}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$3, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass3(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass3> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass3(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$5", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryBaseLineColorDetail}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$5, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass5 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
                final /* synthetic */ HealthSettingsViewModel $viewModel;
                /* synthetic */ int I$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass5(HealthSettingsViewModel healthSettingsViewModel, Continuation<? super AnonymousClass5> continuation) {
                    super(2, continuation);
                    this.$viewModel = healthSettingsViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass5 anonymousClass5 = new AnonymousClass5(this.$viewModel, continuation);
                    anonymousClass5.I$0 = ((Number) obj).intValue();
                    return anonymousClass5;
                }

                public final Object invoke(int r1, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass5) create(Integer.valueOf(r1), continuation)).invokeSuspend(Unit.INSTANCE);
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
                        int r4 = this.I$0;
                        HealthSettingsViewModel healthSettingsViewModel = this.$viewModel;
                        this.label = 1;
                        if (healthSettingsViewModel.setStandGoal(r4, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                    return invoke(num.intValue(), continuation);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$6", f = "HealthSettings.kt", l = {133}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$6, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass6(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass6> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass6(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass6) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$8", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLegendColorDetail}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$8, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass8 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
                final /* synthetic */ HealthSettingsViewModel $viewModel;
                /* synthetic */ int I$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass8(HealthSettingsViewModel healthSettingsViewModel, Continuation<? super AnonymousClass8> continuation) {
                    super(2, continuation);
                    this.$viewModel = healthSettingsViewModel;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass8 anonymousClass8 = new AnonymousClass8(this.$viewModel, continuation);
                    anonymousClass8.I$0 = ((Number) obj).intValue();
                    return anonymousClass8;
                }

                public final Object invoke(int r1, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass8) create(Integer.valueOf(r1), continuation)).invokeSuspend(Unit.INSTANCE);
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
                        int r4 = this.I$0;
                        HealthSettingsViewModel healthSettingsViewModel = this.$viewModel;
                        this.label = 1;
                        if (healthSettingsViewModel.setExerciseGoal(r4, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
                    return invoke(num.intValue(), continuation);
                }
            }

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$9", f = "HealthSettings.kt", l = {com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryGoalLegendColorActivity}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1$9, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass9(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass9> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass9(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass9) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* compiled from: HealthSettings.kt */
            /* loaded from: classes3.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[BottomSheetType.values().length];
                    try {
                        r0[BottomSheetType.Walk.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        r0[BottomSheetType.Stand.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        r0[BottomSheetType.Exercise.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        r0[BottomSheetType.GoogleFitDisconnect.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        r0[BottomSheetType.GoogleFitDisabledInDemo.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        r0[BottomSheetType.StravaDisabledInDemo.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        r0[BottomSheetType.StravaConnect.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        r0[BottomSheetType.StravaDisconnect.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        r0[BottomSheetType.NoInternet.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope ModalBottomSheetLayout, Composer composer2, int r14) {
                Intrinsics.checkNotNullParameter(ModalBottomSheetLayout, "$this$ModalBottomSheetLayout");
                if ((r14 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                int r12 = WhenMappings.$EnumSwitchMapping$0[BottomSheetType.this.ordinal()];
                Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                switch (r12) {
                    case 1:
                        composer2.startReplaceableGroup(1056130754);
                        String stringResource = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_steps_alert_title, composer2);
                        composer2.startReplaceableGroup(1056130903);
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == composer$Companion$Empty$1) {
                            rememberedValue = HealthSettingsViewModel.Companion.getSteps();
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        HealthSettingsKt.GoalSheet(stringResource, (List) rememberedValue, healthSettingsViewModel.getGoals().getSteps(), new AnonymousClass2(healthSettingsViewModel, null), new AnonymousClass3(modalBottomSheetState, null), composer2, 36928);
                        composer2.endReplaceableGroup();
                        return;
                    case 2:
                        composer2.startReplaceableGroup(1056131191);
                        String stringResource2 = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_stand_alert_title, composer2);
                        composer2.startReplaceableGroup(1056131340);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == composer$Companion$Empty$1) {
                            rememberedValue2 = HealthSettingsViewModel.Companion.getStand();
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        HealthSettingsKt.GoalSheet(stringResource2, (List) rememberedValue2, healthSettingsViewModel.getGoals().getStand(), new AnonymousClass5(healthSettingsViewModel, null), new AnonymousClass6(modalBottomSheetState, null), composer2, 36928);
                        composer2.endReplaceableGroup();
                        return;
                    case 3:
                        composer2.startReplaceableGroup(1056131632);
                        String stringResource3 = URLProtocolKt.stringResource(R.string.health_settings_daily_goals_exercise_alert_title, composer2);
                        composer2.startReplaceableGroup(1056131784);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (rememberedValue3 == composer$Companion$Empty$1) {
                            rememberedValue3 = HealthSettingsViewModel.Companion.getExercise();
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        HealthSettingsKt.GoalSheet(stringResource3, (List) rememberedValue3, healthSettingsViewModel.getGoals().getExercise(), new AnonymousClass8(healthSettingsViewModel, null), new AnonymousClass9(modalBottomSheetState, null), composer2, 36928);
                        composer2.endReplaceableGroup();
                        return;
                    case 4:
                        composer2.startReplaceableGroup(1056132096);
                        HealthSettingsKt.ThirdPartyDisconnectSheet(URLProtocolKt.stringResource(R.string.google_fit_disconnect_question, composer2), new AnonymousClass10(googleFitUIState, null), new AnonymousClass11(modalBottomSheetState, null), composer2, 576);
                        composer2.endReplaceableGroup();
                        return;
                    case 5:
                        composer2.startReplaceableGroup(1056132398);
                        DisabledFunctionalityDescriptionBottomDialogKt.DisabledFunctionalityDialogContent(URLProtocolKt.stringResource(R.string.google_fit_connect, composer2), URLProtocolKt.stringResource(R.string.demo_this_is_not_available_in_demo_mode, composer2), new AnonymousClass12(coroutineScope, modalBottomSheetState), composer2, 0);
                        composer2.endReplaceableGroup();
                        return;
                    case 6:
                        composer2.startReplaceableGroup(1056132724);
                        DisabledFunctionalityDescriptionBottomDialogKt.DisabledFunctionalityDialogContent(URLProtocolKt.stringResource(R.string.health_settings_strava_connect_title, composer2), URLProtocolKt.stringResource(R.string.demo_this_is_not_available_in_demo_mode, composer2), new AnonymousClass13(coroutineScope, modalBottomSheetState), composer2, 0);
                        composer2.endReplaceableGroup();
                        return;
                    case 7:
                        composer2.startReplaceableGroup(1056133061);
                        final StravaUIState stravaUIState2 = stravaUIState;
                        HealthSettingsKt.StravaConnectDialog(null, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$1.14
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
                                StravaUIState.this.authorize();
                            }
                        }, new AnonymousClass15(modalBottomSheetState, null), composer2, DfuBaseService.ERROR_REMOTE_TYPE_SECURE, 1);
                        composer2.endReplaceableGroup();
                        return;
                    case 8:
                        composer2.startReplaceableGroup(1056133261);
                        HealthSettingsKt.ThirdPartyDisconnectSheet(URLProtocolKt.stringResource(R.string.health_settings_strava_disconnect_body, composer2), new AnonymousClass16(stravaUIState, null), new AnonymousClass17(modalBottomSheetState, null), composer2, 576);
                        composer2.endReplaceableGroup();
                        return;
                    case 9:
                        composer2.startReplaceableGroup(1056133560);
                        HealthSettingsKt.NoInternetSheet(new AnonymousClass18(modalBottomSheetState, null), composer2, 8);
                        composer2.endReplaceableGroup();
                        return;
                    default:
                        composer2.startReplaceableGroup(1056133626);
                        composer2.endReplaceableGroup();
                        return;
                }
            }
        }), null, modalBottomSheetState, false, copy, 0.0f, Color.White, 0L, j, ComposableLambdaKt.composableLambda(startRestartGroup, 249239053, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2
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

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(Composer composer2, int r23) {
                float f2;
                float f3;
                float f4;
                float f5;
                float f6;
                float f7;
                float f8;
                float f9;
                float f10;
                if ((r23 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                Modifier verticalScroll$default = ScrollKt.verticalScroll$default(companion, ScrollKt.rememberScrollState(composer2), false, 14);
                final Function0<Unit> function03 = function0;
                HealthSettingsViewModel healthSettingsViewModel2 = healthSettingsViewModel;
                final Function1<BottomSheetType, Unit> function12 = function1;
                final Function0<Unit> function04 = function02;
                final GoogleFitUIState googleFitUIState2 = googleFitUIState;
                final StravaUIState stravaUIState2 = stravaUIState;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(verticalScroll$default);
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
                    String stringResource = URLProtocolKt.stringResource(R.string.health_top_title, composer2);
                    composer2.startReplaceableGroup(-280512184);
                    boolean changedInstance = composer2.changedInstance(function03);
                    Object rememberedValue = composer2.rememberedValue();
                    Object obj = Composer.Companion.Empty;
                    if (changedInstance || rememberedValue == obj) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                function03.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) rememberedValue, stringResource, null, composer2, 48, 17);
                    f2 = HealthSettingsKt.paddingEdge;
                    f3 = HealthSettingsKt.paddingEdge;
                    f4 = HealthSettingsKt.paddingEdge;
                    ScreenTitleKt.ScreenTitle(PaddingKt.m74paddingqDBjuR0(companion, f2, f3, f4, 40), URLProtocolKt.stringResource(R.string.health_settings_title, composer2), composer2, 6, 0);
                    f5 = HealthSettingsKt.paddingSectionTitle;
                    HealthSettingsKt.SectionTitle(PaddingKt.m73paddingVpY3zN4$default(companion, f5, 0.0f, 2), URLProtocolKt.stringResource(R.string.health_settings_daily_goals_title, composer2), composer2, 6, 0);
                    f6 = HealthSettingsKt.paddingEdge;
                    f7 = HealthSettingsKt.paddingEdge;
                    float f11 = 64;
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, f6, 0.0f, f7, f11, 2);
                    HealthGoals healthGoals = (HealthGoals) Platform.collectAsState(healthSettingsViewModel2.getGoalsFlow(), FitnessDataKt.m1223default(HealthGoals.Companion), null, composer2, 2).getValue();
                    composer2.startReplaceableGroup(-280511301);
                    boolean changedInstance2 = composer2.changedInstance(function12);
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changedInstance2 || rememberedValue2 == obj) {
                        rememberedValue2 = new Function1<BottomSheetType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(BottomSheetType bottomSheetType2) {
                                invoke2(bottomSheetType2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(BottomSheetType it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                function12.invoke(it);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.DailyGoalSection(m75paddingqDBjuR0$default, healthGoals, (Function1) rememberedValue2, composer2, 70, 0);
                    f8 = HealthSettingsKt.paddingSectionTitle;
                    HealthSettingsKt.SectionTitle(PaddingKt.m73paddingVpY3zN4$default(companion, f8, 0.0f, 2), URLProtocolKt.stringResource(R.string.sleep_schedule_title, composer2), composer2, 6, 0);
                    f9 = HealthSettingsKt.paddingEdge;
                    f10 = HealthSettingsKt.paddingEdge;
                    Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(companion, f9, 0.0f, f10, f11, 2);
                    String displayValue = HealthSettingsViewModelKt.displayValue((Bedtime) Platform.collectAsState(healthSettingsViewModel2.getBedtimeFlow(), new Bedtime(0, 0, 3, (DefaultConstructorMarker) null), null, composer2, 2).getValue());
                    composer2.startReplaceableGroup(-280510799);
                    boolean changedInstance3 = composer2.changedInstance(function04);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance3 || rememberedValue3 == obj) {
                        rememberedValue3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2$1$3$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                function04.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.SleepSection(m75paddingqDBjuR0$default2, displayValue, (Function0) rememberedValue3, composer2, 6, 0);
                    HealthSettingsKt.ThirdPartySection(ClickableKt.m26clickableXHw0xAI$default(companion, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2$1$4
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
                            GoogleFitUIState.this.onClick();
                        }
                    }), URLProtocolKt.stringResource(R.string.google_fit, composer2), R.drawable.ic_google_fit, googleFitUIState2.getState(composer2, 8).isConnected(), googleFitUIState2.getState(composer2, 8).getShowBadge(), composer2, 384, 0);
                    HealthSettingsKt.ThirdPartySection(ClickableKt.m26clickableXHw0xAI$default(companion, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$2$1$5
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
                            StravaUIState.this.onClick();
                        }
                    }), "Strava", R.drawable.ic_strava_badge, stravaUIState2.isConnected(composer2, 8), stravaUIState2.getShowBadge(), composer2, 432, 0);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r37 << 3) & 896) | 907543046, 170);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$HealthSettingsScreen$3
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

                public final void invoke(Composer composer2, int r12) {
                    HealthSettingsKt.HealthSettingsScreen(HealthSettingsViewModel.this, modalBottomSheetState, googleFitUIState, stravaUIState, function1, function0, function02, bottomSheetType, composer2, Strings.updateChangedFlags(r37 | 1));
                }
            };
        }
    }

    public static final Job HealthSettingsScreen$hideSheet(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        return BuildersKt.launch$default(coroutineScope, null, null, new HealthSettingsKt$HealthSettingsScreen$hideSheet$1(modalBottomSheetState, null), 3);
    }

    public static final void NoInternetSheet(final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer composer, final int r13) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-2133439751);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        DialogKt.GenericDialog(null, URLProtocolKt.stringResource(R.string.onboarding_internet_access_enable_title, startRestartGroup), URLProtocolKt.stringResource(R.string.body_connect_to_internet, startRestartGroup), URLProtocolKt.stringResource(R.string.activity_ok, startRestartGroup), null, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$NoInternetSheet$1

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$NoInternetSheet$1$1", f = "HealthSettings.kt", l = {384}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$NoInternetSheet$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onHideSheet;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onHideSheet = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onHideSheet, continuation);
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
                        Function1<Continuation<? super Unit>, Object> function1 = this.$onHideSheet;
                        this.label = 1;
                        if (function1.invoke(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

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
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(function1, null), 3);
            }
        }, null, startRestartGroup, 0, 81);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$NoInternetSheet$2
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

                public final void invoke(Composer composer2, int r3) {
                    HealthSettingsKt.NoInternetSheet(function1, composer2, Strings.updateChangedFlags(r13 | 1));
                }
            };
        }
    }

    public static final void SectionTitle(Modifier modifier, final String str, Composer composer, final int r30, final int r31) {
        final Modifier modifier2;
        int r3;
        int r32;
        int r4;
        Modifier modifier3;
        Modifier fillMaxWidth;
        ComposerImpl composerImpl;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-383347217);
        int r1 = r31 & 1;
        if (r1 != 0) {
            r3 = r30 | 6;
            modifier2 = modifier;
        } else if ((r30 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r30;
        } else {
            modifier2 = modifier;
            r3 = r30;
        }
        if ((r31 & 2) != 0) {
            r3 |= 48;
        } else if ((r30 & 112) == 0) {
            if (startRestartGroup.changed(str)) {
                r4 = 32;
            } else {
                r4 = 16;
            }
            r3 |= r4;
        }
        int r21 = r3;
        if ((r21 & 91) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            composerImpl = startRestartGroup;
            TextKt.m216Text4IGK_g(str, fillMaxWidth, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, (r21 >> 3) & 14, 0, 65528);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$SectionTitle$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    HealthSettingsKt.SectionTitle(Modifier.this, str, composer2, Strings.updateChangedFlags(r30 | 1), r31);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$SleepSection$1, kotlin.jvm.internal.Lambda] */
    public static final void SleepSection(Modifier modifier, final String str, final Function0<Unit> function0, Composer composer, final int r18, final int r19) {
        Modifier modifier2;
        int r6;
        int r62;
        int r7;
        int r72;
        final Modifier modifier3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1000849688);
        int r1 = r19 & 1;
        if (r1 != 0) {
            r6 = r18 | 6;
            modifier2 = modifier;
        } else if ((r18 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r18;
        } else {
            modifier2 = modifier;
            r6 = r18;
        }
        if ((r19 & 2) != 0) {
            r6 |= 48;
        } else if ((r18 & 112) == 0) {
            if (startRestartGroup.changed(str)) {
                r7 = 32;
            } else {
                r7 = 16;
            }
            r6 |= r7;
        }
        if ((r19 & 4) != 0) {
            r6 |= 384;
        } else if ((r18 & 896) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r72 = 256;
            } else {
                r72 = 128;
            }
            r6 |= r72;
        }
        if ((r6 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            int r12 = ((r6 << 3) & 112) | 196614;
            BackgroundCardKt.m1587BackgroundCardNinePatchY3c_0f4(R.drawable.app_dropped, modifier3, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -859108656, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$SleepSection$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r9) {
                    Modifier cardPadding;
                    if ((r9 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    cardPadding = HealthSettingsKt.cardPadding(Modifier.Companion.$$INSTANCE);
                    String stringResource = URLProtocolKt.stringResource(R.string.bedtime_title, composer2);
                    String str2 = str;
                    composer2.startReplaceableGroup(574726615);
                    boolean changedInstance = composer2.changedInstance(function0);
                    final Function0<Unit> function02 = function0;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$SleepSection$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                function02.invoke();
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    HealthSettingsKt.BaseRow(cardPadding, stringResource, str2, (Function0) rememberedValue, composer2, 0, 0);
                }
            }), startRestartGroup, r12, 28);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$SleepSection$2
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
                    HealthSettingsKt.SleepSection(Modifier.this, str, function0, composer2, Strings.updateChangedFlags(r18 | 1), r19);
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a8, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0.nextSlot(), java.lang.Integer.valueOf(r6)) == false) goto L63;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void StravaConnectDialog(androidx.compose.ui.Modifier r64, final kotlin.jvm.functions.Function0<kotlin.Unit> r65, final kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r66, androidx.compose.runtime.Composer r67, final int r68, final int r69) {
        /*
            Method dump skipped, instructions count: 603
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt.StravaConnectDialog(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void ThirdPartyDisconnectSheet(final String str, final Function1<? super Continuation<? super Boolean>, ? extends Object> function1, final Function1<? super Continuation<? super Unit>, ? extends Object> function12, Composer composer, final int r15) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(754630283);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        DialogKt.GenericDialog(null, URLProtocolKt.stringResource(R.string.disconnect, startRestartGroup), str, URLProtocolKt.stringResource(R.string.disconnect, startRestartGroup), URLProtocolKt.stringResource(R.string.button_cancel, startRestartGroup), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$1

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$1$1", f = "HealthSettings.kt", l = {400, 400}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super Boolean>, Object> $onDisconnect;
                final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onHideSheet;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Function1<? super Continuation<? super Unit>, ? extends Object> function12, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onDisconnect = function1;
                    this.$onHideSheet = function12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onDisconnect, this.$onHideSheet, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r1 = this.label;
                    if (r1 != 0) {
                        if (r1 != 1) {
                            if (r1 == 2) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    } else {
                        ResultKt.throwOnFailure(obj);
                        Function1<Continuation<? super Boolean>, Object> function1 = this.$onDisconnect;
                        this.label = 1;
                        obj = function1.invoke(this);
                        if (obj == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    if (((Boolean) obj).booleanValue()) {
                        Function1<Continuation<? super Unit>, Object> function12 = this.$onHideSheet;
                        this.label = 2;
                        if (function12.invoke(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

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
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(function1, function12, null), 3);
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$2

            /* compiled from: HealthSettings.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$2$1", f = "HealthSettings.kt", l = {HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$2$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onHideSheet;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onHideSheet = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onHideSheet, continuation);
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
                        Function1<Continuation<? super Unit>, Object> function1 = this.$onHideSheet;
                        this.label = 1;
                        if (function1.invoke(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

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
                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(function12, null), 3);
            }
        }, startRestartGroup, (r15 << 6) & 896, 1);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt$ThirdPartyDisconnectSheet$3
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

                public final void invoke(Composer composer2, int r5) {
                    HealthSettingsKt.ThirdPartyDisconnectSheet(str, function1, function12, composer2, Strings.updateChangedFlags(r15 | 1));
                }
            };
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x011b, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r0.nextSlot(), java.lang.Integer.valueOf(r8)) == false) goto L212;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ThirdPartySection(androidx.compose.ui.Modifier r48, final java.lang.String r49, final int r50, final boolean r51, final boolean r52, androidx.compose.runtime.Composer r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1121
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.settings.health.HealthSettingsKt.ThirdPartySection(androidx.compose.ui.Modifier, java.lang.String, int, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final /* synthetic */ void access$HealthSettingsScreen(HealthSettingsViewModel healthSettingsViewModel, ModalBottomSheetState modalBottomSheetState, GoogleFitUIState googleFitUIState, StravaUIState stravaUIState, Function1 function1, Function0 function0, Function0 function02, BottomSheetType bottomSheetType, Composer composer, int r9) {
        HealthSettingsScreen(healthSettingsViewModel, modalBottomSheetState, googleFitUIState, stravaUIState, function1, function0, function02, bottomSheetType, composer, r9);
    }

    public static final Modifier cardPadding(Modifier modifier) {
        int r0 = Modifier.$r8$clinit;
        float f = 24;
        float f2 = 16;
        return modifier.then(PaddingKt.m74paddingqDBjuR0(Modifier.Companion.$$INSTANCE, f, f2, f, f2));
    }
}
