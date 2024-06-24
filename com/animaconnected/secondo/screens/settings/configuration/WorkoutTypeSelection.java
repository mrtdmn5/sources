package com.animaconnected.secondo.screens.settings.configuration;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutTypeSelection.kt */
/* loaded from: classes3.dex */
public final class WorkoutTypeSelection extends ComposeFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "ConfigurableMetrics";

    /* compiled from: WorkoutTypeSelection.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WorkoutTypeSelection newInstance() {
            return new WorkoutTypeSelection();
        }

        private Companion() {
        }
    }

    /* compiled from: WorkoutTypeSelection.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<SessionType> entries$0 = EnumEntriesKt.enumEntries(SessionType.values());
    }

    /* compiled from: WorkoutTypeSelection.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    private final List<WorkoutType> getWorkoutTypes() {
        String appString;
        EnumEntries<SessionType> enumEntries = EntriesMappings.entries$0;
        ArrayList arrayList = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(enumEntries, 10));
        for (SessionType sessionType : enumEntries) {
            int r3 = WhenMappings.$EnumSwitchMapping$0[sessionType.ordinal()];
            if (r3 != 1) {
                if (r3 != 2) {
                    if (r3 != 3) {
                        if (r3 == 4) {
                            appString = StringsExtensionsKt.getAppString(Key.workout_type_other);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    } else {
                        appString = StringsExtensionsKt.getAppString(Key.workout_type_bike);
                    }
                } else {
                    appString = StringsExtensionsKt.getAppString(Key.workout_type_walk);
                }
            } else {
                appString = StringsExtensionsKt.getAppString(Key.workout_type_run);
            }
            arrayList.add(new WorkoutType(appString, sessionType, new Function1<SessionType, Unit>() { // from class: com.animaconnected.secondo.screens.settings.configuration.WorkoutTypeSelection$getWorkoutTypes$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SessionType sessionType2) {
                    invoke2(sessionType2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SessionType it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    WorkoutTypeSelection.this.getMainController().gotoNextFragment(WorkoutMetricsConfiguration.Companion.newInstance(it));
                }
            }));
        }
        return arrayList;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r19) {
        int r10;
        boolean z;
        int r3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1764186276);
        if ((r19 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r3 = 4;
            } else {
                r3 = 2;
            }
            r10 = r3 | r19;
        } else {
            r10 = r19;
        }
        if ((r10 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -646529274);
                if ((r10 & 14) == 4) {
                    z = true;
                } else {
                    z = false;
                }
                Object nextSlot = startRestartGroup.nextSlot();
                if (z || nextSlot == Composer.Companion.Empty) {
                    nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.configuration.WorkoutTypeSelection$ComposeContent$1$1$1
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
                            WorkoutTypeSelection.this.getMainController().goBack();
                        }
                    };
                    startRestartGroup.updateValue(nextSlot);
                }
                startRestartGroup.end(false);
                TopbarKt.TopBar(null, R.drawable.ic_chevron_left, (Function0) nextSlot, "", null, startRestartGroup, 3120, 17);
                ScreenTitleKt.ScreenTitle(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 56, 7), "Workouts", startRestartGroup, 54, 0);
                WorkoutTypeSelectionKt.WorkoutTypes(null, getWorkoutTypes(), startRestartGroup, 64, 1);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.configuration.WorkoutTypeSelection$ComposeContent$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r32) {
                    WorkoutTypeSelection.this.ComposeContent(composer2, Strings.updateChangedFlags(r19 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }
}
