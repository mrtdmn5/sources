package com.animaconnected.secondo.screens.workout.dashboard;

import android.content.res.Configuration;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.Shapes;
import androidx.compose.material.ShapesKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.animaconnected.watch.fitness.HealthGoals;
import com.animaconnected.watch.graphs.BarEntry;
import com.animaconnected.watch.theme.ChartTheme;
import com.animaconnected.watch.workout.MetricListItem;
import com.animaconnected.widget.BackgroundCardKt;
import com.animaconnected.widget.SessionCardData;
import com.animaconnected.widget.SessionCardKt;
import com.animaconnected.widget.VerticalGridKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class HealthOnboardingKt {
    /* JADX WARN: Type inference failed for: r0v5, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1, kotlin.jvm.internal.Lambda] */
    public static final void HealthOnboardingDailyGoal(Modifier modifier, final boolean z, final ChartTheme chartTheme, final Function0<Unit> onClick, Composer composer, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(chartTheme, "chartTheme");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1004940181);
        if ((r14 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        OnboardingCard(modifier, z, ComposableLambdaKt.composableLambda(startRestartGroup, -101479727, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r17) {
                if ((r17 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                ChartTheme chartTheme2 = ChartTheme.this;
                Function0<Unit> function0 = onClick;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
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
                    HealthDashboardScreenKt.DailyGoalsCard(null, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1$1$1
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final BarEntry invoke() {
                            return new BarEntry(7, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                        }
                    }, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1$1$2
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final BarEntry invoke() {
                            return new BarEntry(6, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                        }
                    }, new Function0<BarEntry>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1$1$3
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final BarEntry invoke() {
                            return new BarEntry(5, (String) null, 0L, (String) null, (String) null, false, 62, (DefaultConstructorMarker) null);
                        }
                    }, new HealthGoals(10, 8, 10), chartTheme2, new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$1$1$4
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Rect it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                            invoke2(rect);
                            return Unit.INSTANCE;
                        }
                    }, composer2, 1871280, 1);
                    float f = 8;
                    HealthOnboardingKt.OnboardingInfo(PaddingKt.m74paddingqDBjuR0(companion, f, f, f, 24), URLProtocolKt.stringResource(R.string.health_onboarding_daily_goals_title, composer2), URLProtocolKt.stringResource(R.string.health_onboarding_daily_goals_body, composer2), URLProtocolKt.stringResource(R.string.onboarding_continue_button, composer2), R.drawable.ic_lightbulb, function0, composer2, 24582, 0);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, (r13 & 14) | 384 | (r13 & 112), 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingDailyGoal$2
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
                    HealthOnboardingKt.HealthOnboardingDailyGoal(Modifier.this, z, chartTheme, onClick, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0048  */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingLastCard$1, kotlin.jvm.internal.Lambda] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void HealthOnboardingLastCard(final kotlin.jvm.functions.Function0<kotlin.Unit> r12, final boolean r13, androidx.compose.ui.Modifier r14, androidx.compose.runtime.Composer r15, final int r16, final int r17) {
        /*
            r1 = r12
            r4 = r16
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 516520302(0x1ec9796e, float:2.1331925E-20)
            r2 = r15
            androidx.compose.runtime.ComposerImpl r0 = r15.startRestartGroup(r0)
            r2 = r17 & 1
            if (r2 == 0) goto L17
            r2 = r4 | 6
            goto L27
        L17:
            r2 = r4 & 14
            if (r2 != 0) goto L26
            boolean r2 = r0.changedInstance(r12)
            if (r2 == 0) goto L23
            r2 = 4
            goto L24
        L23:
            r2 = 2
        L24:
            r2 = r2 | r4
            goto L27
        L26:
            r2 = r4
        L27:
            r3 = r17 & 2
            if (r3 == 0) goto L2e
            r2 = r2 | 48
            goto L40
        L2e:
            r3 = r4 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L40
            r3 = r13
            boolean r5 = r0.changed(r13)
            if (r5 == 0) goto L3c
            r5 = 32
            goto L3e
        L3c:
            r5 = 16
        L3e:
            r2 = r2 | r5
            goto L41
        L40:
            r3 = r13
        L41:
            r5 = r17 & 4
            if (r5 == 0) goto L48
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L5a
        L48:
            r6 = r4 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L5a
            r6 = r14
            boolean r7 = r0.changed(r14)
            if (r7 == 0) goto L56
            r7 = 256(0x100, float:3.59E-43)
            goto L58
        L56:
            r7 = 128(0x80, float:1.8E-43)
        L58:
            r2 = r2 | r7
            goto L5b
        L5a:
            r6 = r14
        L5b:
            r7 = r2 & 731(0x2db, float:1.024E-42)
            r8 = 146(0x92, float:2.05E-43)
            if (r7 != r8) goto L6d
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L68
            goto L6d
        L68:
            r0.skipToGroupEnd()
            r11 = r6
            goto L93
        L6d:
            if (r5 == 0) goto L73
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r11 = r5
            goto L74
        L73:
            r11 = r6
        L74:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r5 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingLastCard$1 r5 = new com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingLastCard$1
            r5.<init>()
            r6 = -1142613804(0xffffffffbbe518d4, float:-0.006991485)
            androidx.compose.runtime.internal.ComposableLambdaImpl r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r6, r5)
            int r5 = r2 >> 6
            r5 = r5 & 14
            r5 = r5 | 384(0x180, float:5.38E-43)
            r2 = r2 & 112(0x70, float:1.57E-43)
            r9 = r5 | r2
            r10 = 0
            r5 = r11
            r6 = r13
            r8 = r0
            OnboardingCard(r5, r6, r7, r8, r9, r10)
        L93:
            androidx.compose.runtime.RecomposeScopeImpl r6 = r0.endRestartGroup()
            if (r6 == 0) goto La8
            com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingLastCard$2 r7 = new com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingLastCard$2
            r0 = r7
            r1 = r12
            r2 = r13
            r3 = r11
            r4 = r16
            r5 = r17
            r0.<init>()
            r6.block = r7
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt.HealthOnboardingLastCard(kotlin.jvm.functions.Function0, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingMetrics$1, kotlin.jvm.internal.Lambda] */
    public static final void HealthOnboardingMetrics(Modifier modifier, final List<? extends MetricListItem<?>> metrics, final boolean z, final Function0<Unit> onClick, Composer composer, final int r13, final int r14) {
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1652134423);
        if ((r14 & 1) != 0) {
            modifier = Modifier.Companion.$$INSTANCE;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        OnboardingCard(modifier, z, ComposableLambdaKt.composableLambda(startRestartGroup, -78124465, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingMetrics$1
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
                if ((r12 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Function0<Unit> function0 = onClick;
                List<MetricListItem<?>> list = metrics;
                composer2.startReplaceableGroup(-483455358);
                Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
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
                    float f = 8;
                    HealthOnboardingKt.OnboardingInfo(PaddingKt.m74paddingqDBjuR0(companion, f, 16, f, 24), URLProtocolKt.stringResource(R.string.health_onboarding_metrics_title, composer2), URLProtocolKt.stringResource(R.string.health_onboarding_metrics_body, composer2), URLProtocolKt.stringResource(R.string.onboarding_continue_button, composer2), R.drawable.ic_lightbulb, function0, composer2, 24582, 0);
                    VerticalGridKt.m1635VerticalGrid1yyLQnY(null, list, 0.0f, 0.0f, 0, ComposableSingletons$HealthOnboardingKt.INSTANCE.m1017getLambda1$secondo_kronabyRelease(), composer2, 196672, 29);
                    DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                    return;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, (r13 & 14) | 384 | ((r13 >> 3) & 112), 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier2 = modifier;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingMetrics$2
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
                    HealthOnboardingKt.HealthOnboardingMetrics(Modifier.this, metrics, z, onClick, composer2, Strings.updateChangedFlags(r13 | 1), r14);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingWorkout$1, kotlin.jvm.internal.Lambda] */
    public static final void HealthOnboardingWorkout(Modifier modifier, final SessionCardData session, final boolean z, final Function0<Unit> onClick, Composer composer, final int r18, final int r19) {
        Modifier modifier2;
        int r6;
        int r62;
        int r7;
        int r72;
        int r73;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1220737095);
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
            if (startRestartGroup.changed(session)) {
                r7 = 32;
            } else {
                r7 = 16;
            }
            r6 |= r7;
        }
        if ((r19 & 4) != 0) {
            r6 |= 384;
        } else if ((r18 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r72 = 256;
            } else {
                r72 = 128;
            }
            r6 |= r72;
        }
        if ((r19 & 8) != 0) {
            r6 |= 3072;
        } else if ((r18 & 7168) == 0) {
            if (startRestartGroup.changedInstance(onClick)) {
                r73 = 2048;
            } else {
                r73 = 1024;
            }
            r6 |= r73;
        }
        if ((r6 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            OnboardingCard(modifier3, z, ComposableLambdaKt.composableLambda(startRestartGroup, -348921823, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingWorkout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r14) {
                    if ((r14 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    SessionCardData sessionCardData = SessionCardData.this;
                    Function0<Unit> function0 = onClick;
                    composer2.startReplaceableGroup(-483455358);
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
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
                        SessionCardKt.SessionCard(PaddingKt.m73paddingVpY3zN4$default(companion, 4, 0.0f, 2), sessionCardData, new HealthOnboardingKt$HealthOnboardingWorkout$1$1$1(sessionCardData, null), new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingWorkout$1$1$2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Rect it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                                invoke2(rect);
                                return Unit.INSTANCE;
                            }
                        }, R.drawable.app_dropped, composer2, (SessionCardData.$stable << 3) | 28166, 0);
                        float f = 8;
                        HealthOnboardingKt.OnboardingInfo(PaddingKt.m74paddingqDBjuR0(companion, f, f, f, 24), URLProtocolKt.stringResource(R.string.health_onboarding_workouts_title, composer2), URLProtocolKt.stringResource(R.string.health_onboarding_workouts_body, composer2), URLProtocolKt.stringResource(R.string.onboarding_continue_button, composer2), R.drawable.ic_lightbulb, function0, composer2, 24582, 0);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, (r6 & 14) | 384 | ((r6 >> 3) & 112), 0);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$HealthOnboardingWorkout$2
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
                    HealthOnboardingKt.HealthOnboardingWorkout(Modifier.this, session, z, onClick, composer2, Strings.updateChangedFlags(r18 | 1), r19);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void OnboardingCard(Modifier modifier, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int r23, final int r24) {
        Modifier modifier2;
        int r6;
        int r62;
        int r7;
        int r72;
        final Modifier modifier3;
        float f;
        Modifier fillMaxWidth;
        long Color;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-574921556);
        int r1 = r24 & 1;
        if (r1 != 0) {
            r6 = r23 | 6;
            modifier2 = modifier;
        } else if ((r23 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r23;
        } else {
            modifier2 = modifier;
            r6 = r23;
        }
        if ((r24 & 2) != 0) {
            r6 |= 48;
        } else if ((r23 & 112) == 0) {
            if (startRestartGroup.changed(z)) {
                r7 = 32;
            } else {
                r7 = 16;
            }
            r6 |= r7;
        }
        if ((r24 & 4) != 0) {
            r6 |= 384;
        } else if ((r23 & 896) == 0) {
            if (startRestartGroup.changedInstance(function2)) {
                r72 = 256;
            } else {
                r72 = 128;
            }
            r6 |= r72;
        }
        int r15 = r6;
        if ((r15 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            if (z) {
                f = 1.0f;
            } else {
                f = 0.4f;
            }
            State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, HealthOnboardingAnimations.INSTANCE.alphaTweenSpec(true), "alpha", null, startRestartGroup, 3072, 20);
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            Modifier m331graphicsLayerAp8cVGQ$default = GraphicsLayerModifierKt.m331graphicsLayerAp8cVGQ$default(fillMaxWidth, 0.0f, 0.0f, OnboardingCard$lambda$0(animateFloatAsState), null, false, 1, 65531);
            startRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.TopStart, false, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m331graphicsLayerAp8cVGQ$default);
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
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                Modifier matchParentSize = BoxScopeInstance.INSTANCE.matchParentSize();
                CornerBasedShape cornerBasedShape = ((Shapes) startRestartGroup.consume(ShapesKt.LocalShapes)).large;
                Color = ColorKt.Color(Color.m322getRedimpl(r8), Color.m321getGreenimpl(r8), Color.m319getBlueimpl(r8), 0.5f, Color.m320getColorSpaceimpl(Color.Black));
                BackgroundCardKt.m1586BackgroundCardUalQlp0(matchParentSize, null, cornerBasedShape, null, Color, 0, false, null, startRestartGroup, 1794048, com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryColumnTodayColorDetail);
                function2.invoke(startRestartGroup, Integer.valueOf((r15 >> 6) & 14));
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt$OnboardingCard$2
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
                    HealthOnboardingKt.OnboardingCard(Modifier.this, z, function2, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                }
            };
        }
    }

    private static final float OnboardingCard$lambda$0(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:103:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void OnboardingInfo(androidx.compose.ui.Modifier r64, final java.lang.String r65, final java.lang.String r66, final java.lang.String r67, final int r68, final kotlin.jvm.functions.Function0<kotlin.Unit> r69, androidx.compose.runtime.Composer r70, final int r71, final int r72) {
        /*
            Method dump skipped, instructions count: 917
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.dashboard.HealthOnboardingKt.OnboardingInfo(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final HealthOnboardingUIState rememberHealthOnboardingUIState(SessionCardData mockedSession, List<? extends MetricListItem<?>> mockedMetrics, ScrollState scrollState, int r3, Composer composer, int r5, int r6) {
        Intrinsics.checkNotNullParameter(mockedSession, "mockedSession");
        Intrinsics.checkNotNullParameter(mockedMetrics, "mockedMetrics");
        composer.startReplaceableGroup(1622651420);
        if ((r6 & 4) != 0) {
            scrollState = ScrollKt.rememberScrollState(composer);
        }
        if ((r6 & 8) != 0) {
            r3 = ((Configuration) composer.consume(AndroidCompositionLocals_androidKt.LocalConfiguration)).screenHeightDp;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        composer.startReplaceableGroup(-535335430);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.Companion.Empty) {
            rememberedValue = new HealthOnboardingUIState(scrollState, r3, mockedSession, mockedMetrics);
            composer.updateRememberedValue(rememberedValue);
        }
        HealthOnboardingUIState healthOnboardingUIState = (HealthOnboardingUIState) rememberedValue;
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        return healthOnboardingUIState;
    }
}
