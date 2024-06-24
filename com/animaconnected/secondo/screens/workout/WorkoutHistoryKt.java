package com.animaconnected.secondo.screens.workout;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import com.animaconnected.secondo.screens.workout.dashboard.HealthDashboardUtilsKt;
import com.animaconnected.watch.CommonFlow;
import com.animaconnected.watch.fitness.TimePeriod;
import com.animaconnected.watch.workout.ActivitySummary;
import com.animaconnected.watch.workout.SessionListItem;
import com.animaconnected.watch.workout.WorkoutSectionItem;
import com.animaconnected.watch.workout.WorkoutViewModel;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.SessionCardData;
import com.animaconnected.widget.SessionCardKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutHistory.kt */
/* loaded from: classes3.dex */
public final class WorkoutHistoryKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void SessionHistoryScreen(Modifier modifier, final WorkoutViewModel workoutViewModel, final Function0<Unit> function0, final Function2<? super Long, ? super Rect, Unit> function2, Composer composer, final int r23, final int r24) {
        Modifier modifier2;
        Modifier fillMaxWidth;
        boolean z;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1332057914);
        int r1 = r24 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(627462435);
        Object nextSlot = startRestartGroup.nextSlot();
        Object obj = Composer.Companion.Empty;
        if (nextSlot == obj) {
            nextSlot = workoutViewModel.observeWorkoutHistoryGrouped(TimePeriod.Companion.relevant());
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        final MutableState collectAsState = Platform.collectAsState((CommonFlow) nextSlot, EmptyList.INSTANCE, null, startRestartGroup, 2);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r6 = (((((r23 & 14) << 3) & 112) << 9) & 7168) | 6;
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m((r6 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            final Modifier modifier3 = modifier2;
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, function0, URLProtocolKt.stringResource(R.string.health_top_title, startRestartGroup), null, startRestartGroup, (r23 & 896) | 48, 17);
            fillMaxWidth = SizeKt.fillMaxWidth(ModifiersKt.m1615fadingEdgeTop3ABfNKs$default(companion, 0.0f, 1, null), 1.0f);
            startRestartGroup.startReplaceableGroup(1995589788);
            boolean changed = startRestartGroup.changed(collectAsState);
            if ((((r23 & 7168) ^ 3072) > 2048 && startRestartGroup.changedInstance(function2)) || (r23 & 3072) == 2048) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = changed | z;
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z2 || nextSlot2 == obj) {
                nextSlot2 = new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                        invoke2(lazyListScope);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r5v0, types: [com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$1, kotlin.jvm.internal.Lambda] */
                    /* JADX WARN: Type inference failed for: r5v1 */
                    /* JADX WARN: Type inference failed for: r5v3, types: [com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1] */
                    /* JADX WARN: Type inference failed for: r8v0, types: [com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$3, kotlin.jvm.internal.Lambda] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(LazyListScope LazyColumn) {
                        List<WorkoutSectionItem> SessionHistoryScreen$lambda$1;
                        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                        SessionHistoryScreen$lambda$1 = WorkoutHistoryKt.SessionHistoryScreen$lambda$1(collectAsState);
                        final Function2<Long, Rect, Unit> function22 = function2;
                        for (WorkoutSectionItem workoutSectionItem : SessionHistoryScreen$lambda$1) {
                            final ActivitySummary component1 = workoutSectionItem.component1();
                            final List<SessionListItem> component2 = workoutSectionItem.component2();
                            final int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(component2);
                            WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1 workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1 = 0;
                            LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1879303644, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$1
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                                    invoke(lazyItemScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer2, int r5) {
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((r5 & 81) == 16 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    WorkoutHistoryKt.Summary(ActivitySummary.this, PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), 16, 0.0f, 2), composer2, 56, 0);
                                }
                            }, true));
                            final WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$2 workoutHistoryKt$SessionHistoryScreen$1$1$1$1$2 = new Function2<Integer, SessionListItem, Object>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$2
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Integer num, SessionListItem sessionListItem) {
                                    return invoke(num.intValue(), sessionListItem);
                                }

                                public final Object invoke(int r12, SessionListItem session) {
                                    Intrinsics.checkNotNullParameter(session, "session");
                                    return Long.valueOf(session.getTimestamp());
                                }
                            };
                            int size = component2.size();
                            if (workoutHistoryKt$SessionHistoryScreen$1$1$1$1$2 != null) {
                                workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1 = new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                        return invoke(num.intValue());
                                    }

                                    public final Object invoke(int r4) {
                                        return Function2.this.invoke(Integer.valueOf(r4), component2.get(r4));
                                    }
                                };
                            }
                            LazyColumn.items(size, workoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$1, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int r2) {
                                    component2.get(r2);
                                    return null;
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-1091073711, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$invoke$lambda$1$$inlined$itemsIndexed$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope items, int r15, Composer composer2, int r17) {
                                    int r12;
                                    Intrinsics.checkNotNullParameter(items, "$this$items");
                                    if ((r17 & 14) == 0) {
                                        r12 = r17 | (composer2.changed(items) ? 4 : 2);
                                    } else {
                                        r12 = r17;
                                    }
                                    if ((r17 & 112) == 0) {
                                        r12 |= composer2.changed(r15) ? 32 : 16;
                                    }
                                    if ((r12 & 731) == 146 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                                    final SessionListItem sessionListItem = (SessionListItem) component2.get(r15);
                                    Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                                    Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(SizeKt.fillMaxWidth(companion2, 1.0f), 4, 0.0f, 2);
                                    SessionCardData sessionCardData = HealthDashboardUtilsKt.toSessionCardData(sessionListItem);
                                    WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1 workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1 = new WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1(sessionListItem, null);
                                    final Function2 function23 = function22;
                                    SessionCardKt.SessionCard(m73paddingVpY3zN4$default, sessionCardData, workoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$1, new Function1<Rect, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$1$1$1$1$3$2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Rect rect) {
                                            invoke2(rect);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Rect cardRect) {
                                            Intrinsics.checkNotNullParameter(cardRect, "cardRect");
                                            function23.invoke(Long.valueOf(sessionListItem.getTimestamp()), cardRect);
                                        }
                                    }, R.drawable.app_dropped, composer2, (SessionCardData.$stable << 3) | 25094, 0);
                                    if (r15 == lastIndex) {
                                        SizeKt.m83height3ABfNKs(companion2, 32);
                                    }
                                }
                            }, true));
                        }
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            LazyDslKt.LazyColumn(fillMaxWidth, null, null, false, null, null, null, false, (Function1) nextSlot2, startRestartGroup, 0, 254);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SessionHistoryScreen$2
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
                        WorkoutHistoryKt.SessionHistoryScreen(Modifier.this, workoutViewModel, function0, function2, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<WorkoutSectionItem> SessionHistoryScreen$lambda$1(State<? extends List<WorkoutSectionItem>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Summary(final ActivitySummary activitySummary, Modifier modifier, Composer composer, final int r23, final int r24) {
        final Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(667284836);
        int r3 = r24 & 2;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r3 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        String str = URLProtocolKt.stringResource(R.string.health_workouts_activity_type_walk, startRestartGroup) + ' ' + activitySummary.getNbrOfWalks();
        String str2 = URLProtocolKt.stringResource(R.string.health_workouts_activity_type_run, startRestartGroup) + ' ' + activitySummary.getNbrOfRuns();
        String str3 = URLProtocolKt.stringResource(R.string.health_workouts_activity_type_bike, startRestartGroup) + ' ' + activitySummary.getNbrOfBikes();
        String str4 = URLProtocolKt.stringResource(R.string.health_workouts_activity_type_other, startRestartGroup) + ' ' + activitySummary.getNbrOfOthers();
        BiasAlignment.Horizontal horizontal = Alignment.Companion.End;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r5 = (((((((r23 >> 3) & 14) | 384) << 3) & 112) << 9) & 7168) | 6;
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
            modifierMaterializerOf.invoke(new SkippableUpdater(startRestartGroup), startRestartGroup, Integer.valueOf((r5 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            float f = 16;
            SummaryTitle(activitySummary.getMonth(), PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f, 0.0f, 0.0f, 13), startRestartGroup, 48, 0);
            float f2 = 8;
            SummaryBody(str, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f2, 0.0f, 0.0f, 13), startRestartGroup, 48, 0);
            SummaryBody(str2, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f2, 0.0f, 0.0f, 13), startRestartGroup, 48, 0);
            SummaryBody(str3, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f2, 0.0f, 0.0f, 13), startRestartGroup, 48, 0);
            SummaryBody(str4, PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, f2, 0.0f, f, 5), startRestartGroup, 48, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$Summary$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r52) {
                        WorkoutHistoryKt.Summary(ActivitySummary.this, modifier2, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SummaryBody(final java.lang.String r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            r1 = r27
            r0 = r30
            r15 = r31
            r2 = 283428348(0x10e4c5fc, float:9.0235186E-29)
            r3 = r29
            androidx.compose.runtime.ComposerImpl r13 = r3.startRestartGroup(r2)
            r2 = r15 & 1
            if (r2 == 0) goto L16
            r2 = r0 | 6
            goto L26
        L16:
            r2 = r0 & 14
            if (r2 != 0) goto L25
            boolean r2 = r13.changed(r1)
            if (r2 == 0) goto L22
            r2 = 4
            goto L23
        L22:
            r2 = 2
        L23:
            r2 = r2 | r0
            goto L26
        L25:
            r2 = r0
        L26:
            r3 = r15 & 2
            if (r3 == 0) goto L2d
            r2 = r2 | 48
            goto L40
        L2d:
            r4 = r0 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L40
            r4 = r28
            boolean r5 = r13.changed(r4)
            if (r5 == 0) goto L3c
            r5 = 32
            goto L3e
        L3c:
            r5 = 16
        L3e:
            r2 = r2 | r5
            goto L42
        L40:
            r4 = r28
        L42:
            r21 = r2
            r2 = r21 & 91
            r5 = 18
            if (r2 != r5) goto L57
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L51
            goto L57
        L51:
            r13.skipToGroupEnd()
            r26 = r13
            goto La9
        L57:
            if (r3 == 0) goto L5e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r25 = r2
            goto L60
        L5e:
            r25 = r4
        L60:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r2 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            androidx.compose.runtime.StaticProvidableCompositionLocal r2 = androidx.compose.material.ColorsKt.LocalColors
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.material.Colors r2 = (androidx.compose.material.Colors) r2
            long r2 = r2.m166getOnBackground0d7_KjU()
            androidx.compose.runtime.StaticProvidableCompositionLocal r4 = androidx.compose.material.TypographyKt.LocalTypography
            java.lang.Object r4 = r13.consume(r4)
            androidx.compose.material.Typography r4 = (androidx.compose.material.Typography) r4
            androidx.compose.ui.text.TextStyle r4 = r4.h4
            r20 = r4
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r26 = r13
            r13 = r16
            r17 = 0
            r16 = r17
            r15 = r17
            r18 = 0
            r19 = 0
            r22 = r21 & 14
            r21 = r21 & 112(0x70, float:1.57E-43)
            r22 = r22 | r21
            r23 = 0
            r24 = 65528(0xfff8, float:9.1824E-41)
            r0 = r27
            r1 = r25
            r21 = r26
            androidx.compose.material.TextKt.m216Text4IGK_g(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r4 = r25
        La9:
            androidx.compose.runtime.RecomposeScopeImpl r0 = r26.endRestartGroup()
            if (r0 == 0) goto Lbc
            com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SummaryBody$1 r1 = new com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SummaryBody$1
            r2 = r27
            r3 = r30
            r5 = r31
            r1.<init>()
            r0.block = r1
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt.SummaryBody(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void SummaryTitle(final java.lang.String r27, androidx.compose.ui.Modifier r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            r1 = r27
            r0 = r30
            r15 = r31
            r2 = 1496457526(0x59322136, float:3.1336914E15)
            r3 = r29
            androidx.compose.runtime.ComposerImpl r13 = r3.startRestartGroup(r2)
            r2 = r15 & 1
            if (r2 == 0) goto L16
            r2 = r0 | 6
            goto L26
        L16:
            r2 = r0 & 14
            if (r2 != 0) goto L25
            boolean r2 = r13.changed(r1)
            if (r2 == 0) goto L22
            r2 = 4
            goto L23
        L22:
            r2 = 2
        L23:
            r2 = r2 | r0
            goto L26
        L25:
            r2 = r0
        L26:
            r3 = r15 & 2
            if (r3 == 0) goto L2d
            r2 = r2 | 48
            goto L40
        L2d:
            r4 = r0 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L40
            r4 = r28
            boolean r5 = r13.changed(r4)
            if (r5 == 0) goto L3c
            r5 = 32
            goto L3e
        L3c:
            r5 = 16
        L3e:
            r2 = r2 | r5
            goto L42
        L40:
            r4 = r28
        L42:
            r21 = r2
            r2 = r21 & 91
            r5 = 18
            if (r2 != r5) goto L57
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L51
            goto L57
        L51:
            r13.skipToGroupEnd()
            r26 = r13
            goto La9
        L57:
            if (r3 == 0) goto L5e
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r25 = r2
            goto L60
        L5e:
            r25 = r4
        L60:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r2 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            androidx.compose.runtime.StaticProvidableCompositionLocal r2 = androidx.compose.material.ColorsKt.LocalColors
            java.lang.Object r2 = r13.consume(r2)
            androidx.compose.material.Colors r2 = (androidx.compose.material.Colors) r2
            long r2 = r2.m166getOnBackground0d7_KjU()
            androidx.compose.runtime.StaticProvidableCompositionLocal r4 = androidx.compose.material.TypographyKt.LocalTypography
            java.lang.Object r4 = r13.consume(r4)
            androidx.compose.material.Typography r4 = (androidx.compose.material.Typography) r4
            androidx.compose.ui.text.TextStyle r4 = r4.h2
            r20 = r4
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r26 = r13
            r13 = r16
            r17 = 0
            r16 = r17
            r15 = r17
            r18 = 0
            r19 = 0
            r22 = r21 & 14
            r21 = r21 & 112(0x70, float:1.57E-43)
            r22 = r22 | r21
            r23 = 0
            r24 = 65528(0xfff8, float:9.1824E-41)
            r0 = r27
            r1 = r25
            r21 = r26
            androidx.compose.material.TextKt.m216Text4IGK_g(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r4 = r25
        La9:
            androidx.compose.runtime.RecomposeScopeImpl r0 = r26.endRestartGroup()
            if (r0 == 0) goto Lbc
            com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SummaryTitle$1 r1 = new com.animaconnected.secondo.screens.workout.WorkoutHistoryKt$SummaryTitle$1
            r2 = r27
            r3 = r30
            r5 = r31
            r1.<init>()
            r0.block = r1
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.WorkoutHistoryKt.SummaryTitle(java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
