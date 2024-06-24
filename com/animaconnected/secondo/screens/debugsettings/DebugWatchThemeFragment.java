package com.animaconnected.secondo.screens.debugsettings;

import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValuesImpl;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DefaultButtonColors;
import androidx.compose.material.DefaultTextFieldColors;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.ShapesKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
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
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment;
import com.animaconnected.watch.SharedPreferencesCache;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.image.Kolor;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.theme.FestinaComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1;
import kotlin.sequences.SequencesKt___SequencesKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: DebugWatchThemeFragment.kt */
/* loaded from: classes3.dex */
public final class DebugWatchThemeFragment extends ComposeFragment {
    public static final int $stable = 8;
    private final Lazy allThemes$delegate;
    private final Lazy currentTheme$delegate;
    private final MutableState<Integer> currentThemeIndex;
    private final List<WatchTheme> pascalThemes;
    private final String name = "DebugColours";
    private final Lazy storage$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferencesCache>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$storage$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferencesCache invoke() {
            return new SharedPreferencesCache(KronabyApplication.Companion.getContext(), "debug-watch-colors");
        }
    });
    private final List<Kolor> colours = SequencesKt___SequencesKt.toList(new SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1(new DebugWatchThemeFragment$colours$1(null)));

    /* compiled from: DebugWatchThemeFragment.kt */
    /* loaded from: classes3.dex */
    public static final class WatchTheme {
        private final int background;
        private final List<Kolor> colours;
        private final String name;
        private final int primary;
        private final int secondary;

        public WatchTheme(String name, List<Kolor> colours) {
            boolean z;
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(colours, "colours");
            this.name = name;
            this.colours = colours;
            if (colours.size() >= 3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.background = colours.get(0).m1546unboximpl();
                this.primary = colours.get(1).m1546unboximpl();
                this.secondary = colours.get(2).m1546unboximpl();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WatchTheme copy$default(WatchTheme watchTheme, String str, List list, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = watchTheme.name;
            }
            if ((r3 & 2) != 0) {
                list = watchTheme.colours;
            }
            return watchTheme.copy(str, list);
        }

        public final String component1() {
            return this.name;
        }

        public final List<Kolor> component2() {
            return this.colours;
        }

        public final WatchTheme copy(String name, List<Kolor> colours) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(colours, "colours");
            return new WatchTheme(name, colours);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WatchTheme)) {
                return false;
            }
            WatchTheme watchTheme = (WatchTheme) obj;
            if (Intrinsics.areEqual(this.name, watchTheme.name) && Intrinsics.areEqual(this.colours, watchTheme.colours)) {
                return true;
            }
            return false;
        }

        /* renamed from: getBackground-IpmnaRI, reason: not valid java name */
        public final int m896getBackgroundIpmnaRI() {
            return this.background;
        }

        public final List<Kolor> getColours() {
            return this.colours;
        }

        public final String getName() {
            return this.name;
        }

        /* renamed from: getPrimary-IpmnaRI, reason: not valid java name */
        public final int m897getPrimaryIpmnaRI() {
            return this.primary;
        }

        /* renamed from: getSecondary-IpmnaRI, reason: not valid java name */
        public final int m898getSecondaryIpmnaRI() {
            return this.secondary;
        }

        public int hashCode() {
            return this.colours.hashCode() + (this.name.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("WatchTheme(name=");
            sb.append(this.name);
            sb.append(", colours=");
            return LocaleList$$ExternalSyntheticOutline0.m(sb, this.colours, ')');
        }
    }

    public DebugWatchThemeFragment() {
        Kolor.Companion companion = Kolor.Companion;
        this.pascalThemes = CollectionsKt__CollectionsKt.listOf((Object[]) new WatchTheme[]{new WatchTheme("a1107-8292", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#2E3A43")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#476074")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#E82628"))})), new WatchTheme("a1107-8293", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#222222")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#005826")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#F24F00"))})), new WatchTheme("a1107-0001", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#161616")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#293540")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#C52022"))})), new WatchTheme("a1107-0002", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#0C0C0C")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#0D2F1C")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#EB840C"))})), new WatchTheme("a1107-0003", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#0B0D34")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#2E3282")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#A83F29"))})), new WatchTheme("a1107-0004", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#0C0C0C")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#3A3A38")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#A83F29"))})), new WatchTheme("a1107-0005", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#111111")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#004F4F")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#32E7E8"))})), new WatchTheme("a1107-0006", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#000000")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#740A00")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#55B2B2"))})), new WatchTheme("a1107-0007", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#111111")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#712906")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#33A5E9"))})), new WatchTheme("a1107-0008", CollectionsKt__CollectionsKt.listOf((Object[]) new Kolor[]{Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#000000")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#003358")), Kolor.m1536boximpl(companion.m1549fromHexdD1lZlY("#E6D005"))}))});
        this.allThemes$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SnapshotStateList<WatchTheme>>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$allThemes$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SnapshotStateList<DebugWatchThemeFragment.WatchTheme> invoke() {
                List readThemes;
                readThemes = DebugWatchThemeFragment.this.readThemes();
                DebugWatchThemeFragment.WatchTheme[] watchThemeArr = (DebugWatchThemeFragment.WatchTheme[]) readThemes.toArray(new DebugWatchThemeFragment.WatchTheme[0]);
                return Platform.mutableStateListOf(Arrays.copyOf(watchThemeArr, watchThemeArr.length));
            }
        });
        this.currentThemeIndex = Platform.mutableStateOf$default(0);
        this.currentTheme$delegate = LazyKt__LazyJVMKt.lazy(new Function0<MutableState<WatchTheme>>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$currentTheme$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public final MutableState<DebugWatchThemeFragment.WatchTheme> invoke() {
                SnapshotStateList allThemes;
                SnapshotStateList allThemes2;
                MutableState mutableState;
                Object obj;
                List list;
                allThemes = DebugWatchThemeFragment.this.getAllThemes();
                if (allThemes.isEmpty()) {
                    list = DebugWatchThemeFragment.this.pascalThemes;
                    obj = list.get(0);
                } else {
                    allThemes2 = DebugWatchThemeFragment.this.getAllThemes();
                    mutableState = DebugWatchThemeFragment.this.currentThemeIndex;
                    obj = allThemes2.get(((Number) mutableState.getValue()).intValue());
                }
                return Platform.mutableStateOf$default((DebugWatchThemeFragment.WatchTheme) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Palette(Modifier modifier, Function1<? super Kolor, Unit> function1, Composer composer, final int r22, final int r23) {
        Modifier modifier2;
        final Function1<? super Kolor, Unit> function12;
        Modifier m21backgroundbw27NRU;
        boolean z;
        boolean z2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(40316889);
        int r1 = r23 & 1;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        if (r1 != 0) {
            modifier2 = companion;
        } else {
            modifier2 = modifier;
        }
        if ((r23 & 2) != 0) {
            function12 = new Function1<Kolor, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$Palette$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Kolor kolor) {
                    m894invokeukcjflE(kolor.m1546unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-ukcjflE, reason: not valid java name */
                public final void m894invokeukcjflE(int r12) {
                }
            };
        } else {
            function12 = function1;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        int r13 = -1323940314;
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier2);
        int r12 = (((((r22 & 14) << 3) & 112) << 9) & 7168) | 6;
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
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
            AnimatedContentKt$$ExternalSyntheticOutline1.m((r12 >> 3) & 112, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, -765396181);
            Iterator it = CollectionsKt___CollectionsKt.windowed(this.colours, 16, 16, false).iterator();
            while (it.hasNext()) {
                List list = (List) it.next();
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                startRestartGroup.startReplaceableGroup(r13);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(fillMaxWidth);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$12);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                    ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 986863035);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        final int m1546unboximpl = ((Kolor) it2.next()).m1546unboximpl();
                        m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(SizeKt.m83height3ABfNKs(companion, 16), m892getComposeColorgJ2LKyU(m1546unboximpl), RectangleShapeKt.RectangleShape);
                        Intrinsics.checkNotNullParameter(m21backgroundbw27NRU, "<this>");
                        if (1.0f > 0.0d) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            Modifier then = m21backgroundbw27NRU.then(new LayoutWeightElement(1.0f, true));
                            startRestartGroup.startReplaceableGroup(144469017);
                            if ((((r22 & 112) ^ 48) > 32 && startRestartGroup.changedInstance(function12)) || (r22 & 48) == 32) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            boolean changed = z2 | startRestartGroup.changed(m1546unboximpl);
                            Object nextSlot = startRestartGroup.nextSlot();
                            if (changed || nextSlot == Composer.Companion.Empty) {
                                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$Palette$2$1$1$1$1$1
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
                                        function12.invoke(Kolor.m1536boximpl(m1546unboximpl));
                                    }
                                };
                                startRestartGroup.updateValue(nextSlot);
                            }
                            startRestartGroup.end(false);
                            BoxKt.Box(ClickableKt.m26clickableXHw0xAI$default(then, (Function0) nextSlot), startRestartGroup, 0);
                        } else {
                            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                        }
                    }
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
                    startRestartGroup.end(false);
                    r13 = -1323940314;
                } else {
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, false, true, false);
            startRestartGroup.end(false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                final Modifier modifier3 = modifier2;
                final Function1<? super Kolor, Unit> function13 = function12;
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$Palette$3
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
                        DebugWatchThemeFragment.this.Palette(modifier3, function13, composer2, Strings.updateChangedFlags(r22 | 1), r23);
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
    /* JADX WARN: Type inference failed for: r1v4, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1, kotlin.jvm.internal.Lambda] */
    public final void SelectedTheme(final WatchTheme watchTheme, Function1<? super WatchTheme, Unit> function1, Composer composer, final int r62, final int r63) {
        Function1<? super WatchTheme, Unit> function12;
        boolean z;
        long Color;
        Modifier fillMaxHeight;
        final MutableState mutableState;
        long Color2;
        Modifier fillMaxHeight2;
        final MutableState mutableState2;
        long Color3;
        Modifier fillMaxHeight3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1640627543);
        if ((r63 & 2) != 0) {
            function12 = new Function1<WatchTheme, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DebugWatchThemeFragment.WatchTheme it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DebugWatchThemeFragment.WatchTheme watchTheme2) {
                    invoke2(watchTheme2);
                    return Unit.INSTANCE;
                }
            };
        } else {
            function12 = function1;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-1509237927);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(null);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState3 = (MutableState) nextSlot;
        startRestartGroup.end(false);
        startRestartGroup.startReplaceableGroup(-483455358);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            final Integer SelectedTheme$lambda$5 = SelectedTheme$lambda$5(mutableState3);
            if (SelectedTheme$lambda$5 != null) {
                z = true;
            } else {
                z = false;
            }
            Modifier align = columnScopeInstance.align(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 8, 0.0f, 0.0f, 13));
            final Function1<? super WatchTheme, Unit> function13 = function12;
            final Function1<? super WatchTheme, Unit> function14 = function12;
            AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z, align, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -1270118117, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                    invoke(animatedVisibilityScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r0v2, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1$1, kotlin.jvm.internal.Lambda] */
                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int r13) {
                    String m893getRgbHexukcjflE;
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    if (SelectedTheme$lambda$5 == null) {
                        return;
                    }
                    int m1546unboximpl = watchTheme.getColours().get(SelectedTheme$lambda$5.intValue()).m1546unboximpl();
                    composer2.startReplaceableGroup(1470263555);
                    DebugWatchThemeFragment debugWatchThemeFragment = this;
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.Companion.Empty) {
                        m893getRgbHexukcjflE = debugWatchThemeFragment.m893getRgbHexukcjflE(m1546unboximpl);
                        rememberedValue = Platform.mutableStateOf$default(m893getRgbHexukcjflE);
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    final MutableState mutableState4 = (MutableState) rememberedValue;
                    composer2.endReplaceableGroup();
                    final DebugWatchThemeFragment debugWatchThemeFragment2 = this;
                    final DebugWatchThemeFragment.WatchTheme watchTheme2 = watchTheme;
                    final Integer num = SelectedTheme$lambda$5;
                    final Function1<DebugWatchThemeFragment.WatchTheme, Unit> function15 = function13;
                    final MutableState<Integer> mutableState5 = mutableState3;
                    CardKt.m162CardFjzlyU(null, null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -461623400, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num2) {
                            invoke(composer3, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int r34) {
                            if ((r34 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            float f = 8;
                            Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(f);
                            final MutableState<String> mutableState6 = mutableState4;
                            DebugWatchThemeFragment debugWatchThemeFragment3 = debugWatchThemeFragment2;
                            final DebugWatchThemeFragment.WatchTheme watchTheme3 = watchTheme2;
                            final Integer num2 = num;
                            final Function1<DebugWatchThemeFragment.WatchTheme, Unit> function16 = function15;
                            final MutableState<Integer> mutableState7 = mutableState5;
                            composer3.startReplaceableGroup(-483455358);
                            Modifier.Companion companion2 = Modifier.Companion.$$INSTANCE;
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Start, composer3);
                            composer3.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                            PersistentCompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$12 = ComposeUiNode.Companion.Constructor;
                            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(companion2);
                            if (composer3.getApplier() instanceof Applier) {
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(layoutNode$Companion$Constructor$12);
                                } else {
                                    composer3.useNode();
                                }
                                Updater.m228setimpl(composer3, columnMeasurePolicy2, ComposeUiNode.Companion.SetMeasurePolicy);
                                Updater.m228setimpl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$12 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer3, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$12);
                                }
                                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer3), (Object) composer3, (Object) 0);
                                composer3.startReplaceableGroup(2058660585);
                                String value = mutableState6.getValue();
                                KeyboardOptions keyboardOptions = new KeyboardOptions(0, 0, 7, 7);
                                KeyboardActions keyboardActions = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                                        invoke2(keyboardActionScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(KeyboardActionScope $receiver) {
                                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                                        ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) DebugWatchThemeFragment.WatchTheme.this.getColours());
                                        mutableList.set(num2.intValue(), Kolor.m1536boximpl(Kolor.Companion.m1549fromHexdD1lZlY(mutableState6.getValue())));
                                        function16.invoke(DebugWatchThemeFragment.WatchTheme.copy$default(DebugWatchThemeFragment.WatchTheme.this, null, mutableList, 1, null));
                                        mutableState7.setValue(null);
                                    }
                                }, null, 62);
                                composer3.startReplaceableGroup(1561026585);
                                Object rememberedValue2 = composer3.rememberedValue();
                                if (rememberedValue2 == Composer.Companion.Empty) {
                                    rememberedValue2 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1$1$1$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                            invoke2(str);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(String it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            mutableState6.setValue(it);
                                        }
                                    };
                                    composer3.updateRememberedValue(rememberedValue2);
                                }
                                composer3.endReplaceableGroup();
                                OutlinedTextFieldKt.OutlinedTextField(value, (Function1) rememberedValue2, null, false, false, null, ComposableSingletons$DebugWatchThemeFragmentKt.INSTANCE.m868getLambda2$secondo_kronabyRelease(), null, null, null, false, null, keyboardOptions, keyboardActions, true, 0, 0, null, null, null, composer3, 1572912, 24960, 1019836);
                                debugWatchThemeFragment3.Palette(PaddingKt.m71padding3ABfNKs(companion2, f), new Function1<Kolor, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$1$1$1$3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Kolor kolor) {
                                        m895invokeukcjflE(kolor.m1546unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-ukcjflE, reason: not valid java name */
                                    public final void m895invokeukcjflE(int r5) {
                                        ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) DebugWatchThemeFragment.WatchTheme.this.getColours());
                                        mutableList.set(num2.intValue(), Kolor.m1536boximpl(r5));
                                        function16.invoke(DebugWatchThemeFragment.WatchTheme.copy$default(DebugWatchThemeFragment.WatchTheme.this, null, mutableList, 1, null));
                                        mutableState7.setValue(null);
                                    }
                                }, composer3, 518, 0);
                                DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer3);
                                return;
                            }
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                    }), composer2, 1572864, 63);
                }
            }), startRestartGroup, 1572870, 28);
            final FocusManager focusManager = (FocusManager) startRestartGroup.consume(CompositionLocalsKt.LocalFocusManager);
            String name = watchTheme.getName();
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            DefaultTextFieldColors m210textFieldColorsdx8h9Zs = TextFieldDefaults.m210textFieldColorsdx8h9Zs(MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 2097150);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, 0, 7, 7);
            KeyboardActions keyboardActions = new KeyboardActions(new Function1<KeyboardActionScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(KeyboardActionScope keyboardActionScope) {
                    invoke2(keyboardActionScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(KeyboardActionScope $receiver) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    FocusManager.this.clearFocus(false);
                }
            }, null, 62);
            Function1<String, Unit> function15 = new Function1<String, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    function14.invoke(DebugWatchThemeFragment.WatchTheme.copy$default(watchTheme, it, null, 2, null));
                }
            };
            ComposableSingletons$DebugWatchThemeFragmentKt composableSingletons$DebugWatchThemeFragmentKt = ComposableSingletons$DebugWatchThemeFragmentKt.INSTANCE;
            OutlinedTextFieldKt.OutlinedTextField(name, function15, null, false, false, null, composableSingletons$DebugWatchThemeFragmentKt.m869getLambda3$secondo_kronabyRelease(), null, null, null, false, null, keyboardOptions, keyboardActions, false, 0, 0, null, null, m210textFieldColorsdx8h9Zs, startRestartGroup, 1572864, 384, 511932);
            Arrangement$SpaceEvenly$1 arrangement$SpaceEvenly$1 = Arrangement.SpaceEvenly;
            Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(companion, 64);
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceEvenly$1, Alignment.Companion.Top, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m83height3ABfNKs);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                PaddingValuesImpl paddingValuesImpl = ButtonDefaults.ContentPadding;
                long m892getComposeColorgJ2LKyU = m892getComposeColorgJ2LKyU(watchTheme.m896getBackgroundIpmnaRI());
                long m166getOnBackground0d7_KjU = MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU();
                Color = ColorKt.Color(Color.m322getRedimpl(r4), Color.m321getGreenimpl(r4), Color.m319getBlueimpl(r4), 0.5f, Color.m320getColorSpaceimpl(MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU()));
                DefaultButtonColors m160buttonColorsro_MJ88 = ButtonDefaults.m160buttonColorsro_MJ88(m892getComposeColorgJ2LKyU, m166getOnBackground0d7_KjU, 0L, Color, startRestartGroup, 0, 4);
                fillMaxHeight = SizeKt.fillMaxHeight(rowScopeInstance.weight(companion, 1.0f, true), 1.0f);
                startRestartGroup.startReplaceableGroup(1470265997);
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (nextSlot2 == composer$Companion$Empty$1) {
                    mutableState = mutableState3;
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$4$1$1
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
                            mutableState.setValue(0);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                } else {
                    mutableState = mutableState3;
                }
                startRestartGroup.end(false);
                MutableState mutableState4 = mutableState;
                ButtonKt.Button((Function0) nextSlot2, fillMaxHeight, false, null, null, null, null, m160buttonColorsro_MJ88, null, composableSingletons$DebugWatchThemeFragmentKt.m870getLambda4$secondo_kronabyRelease(), startRestartGroup, 805306374, 380);
                long m892getComposeColorgJ2LKyU2 = m892getComposeColorgJ2LKyU(watchTheme.m897getPrimaryIpmnaRI());
                long m166getOnBackground0d7_KjU2 = MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU();
                Color2 = ColorKt.Color(Color.m322getRedimpl(r14), Color.m321getGreenimpl(r14), Color.m319getBlueimpl(r14), 0.5f, Color.m320getColorSpaceimpl(MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU()));
                DefaultButtonColors m160buttonColorsro_MJ882 = ButtonDefaults.m160buttonColorsro_MJ88(m892getComposeColorgJ2LKyU2, m166getOnBackground0d7_KjU2, 0L, Color2, startRestartGroup, 0, 4);
                fillMaxHeight2 = SizeKt.fillMaxHeight(rowScopeInstance.weight(companion, 1.0f, true), 1.0f);
                startRestartGroup.startReplaceableGroup(1470266646);
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (nextSlot3 == composer$Companion$Empty$1) {
                    mutableState2 = mutableState4;
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$4$2$1
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
                            mutableState2.setValue(1);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                } else {
                    mutableState2 = mutableState4;
                }
                startRestartGroup.end(false);
                final MutableState mutableState5 = mutableState2;
                ButtonKt.Button((Function0) nextSlot3, fillMaxHeight2, false, null, null, null, null, m160buttonColorsro_MJ882, null, composableSingletons$DebugWatchThemeFragmentKt.m871getLambda5$secondo_kronabyRelease(), startRestartGroup, 805306374, 380);
                long m892getComposeColorgJ2LKyU3 = m892getComposeColorgJ2LKyU(watchTheme.m898getSecondaryIpmnaRI());
                long m166getOnBackground0d7_KjU3 = MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU();
                Color3 = ColorKt.Color(Color.m322getRedimpl(r14), Color.m321getGreenimpl(r14), Color.m319getBlueimpl(r14), 0.5f, Color.m320getColorSpaceimpl(MaterialTheme.getColors(startRestartGroup).m166getOnBackground0d7_KjU()));
                DefaultButtonColors m160buttonColorsro_MJ883 = ButtonDefaults.m160buttonColorsro_MJ88(m892getComposeColorgJ2LKyU3, m166getOnBackground0d7_KjU3, 0L, Color3, startRestartGroup, 0, 4);
                fillMaxHeight3 = SizeKt.fillMaxHeight(rowScopeInstance.weight(companion, 1.0f, true), 1.0f);
                startRestartGroup.startReplaceableGroup(1470267294);
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$4$3$1
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
                            mutableState5.setValue(2);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                ButtonKt.Button((Function0) nextSlot4, fillMaxHeight3, false, null, null, null, null, m160buttonColorsro_MJ883, null, composableSingletons$DebugWatchThemeFragmentKt.m872getLambda6$secondo_kronabyRelease(), startRestartGroup, 805306374, 380);
                startRestartGroup.end(false);
                startRestartGroup.end(true);
                startRestartGroup.end(false);
                startRestartGroup.end(false);
                ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$2$5
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
                        String m893getRgbHexukcjflE;
                        String m893getRgbHexukcjflE2;
                        String m893getRgbHexukcjflE3;
                        WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
                        m893getRgbHexukcjflE = DebugWatchThemeFragment.this.m893getRgbHexukcjflE(watchTheme.m896getBackgroundIpmnaRI());
                        m893getRgbHexukcjflE2 = DebugWatchThemeFragment.this.m893getRgbHexukcjflE(watchTheme.m897getPrimaryIpmnaRI());
                        m893getRgbHexukcjflE3 = DebugWatchThemeFragment.this.m893getRgbHexukcjflE(watchTheme.m898getSecondaryIpmnaRI());
                        watchManager.setDisplayColors(m893getRgbHexukcjflE, m893getRgbHexukcjflE2, m893getRgbHexukcjflE3);
                    }
                }, SizeKt.fillMaxWidth(companion, 1.0f), false, null, null, null, null, null, null, composableSingletons$DebugWatchThemeFragmentKt.m873getLambda7$secondo_kronabyRelease(), startRestartGroup, 805306416, 508);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$SelectedTheme$3
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
                            DebugWatchThemeFragment.this.SelectedTheme(watchTheme, function14, composer2, Strings.updateChangedFlags(r62 | 1), r63);
                        }
                    };
                    return;
                }
                return;
            }
            ComposablesKt.invalidApplier();
            throw null;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    private static final Integer SelectedTheme$lambda$5(MutableState<Integer> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ThemePicker(final List<WatchTheme> list, Function1<? super Integer, Unit> function1, Function0<Unit> function0, Function1<? super Integer, Unit> function12, Composer composer, final int r27, final int r28) {
        Function1<? super Integer, Unit> function13;
        Function0<Unit> function02;
        Function1<? super Integer, Unit> function14;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-686292035);
        if ((r28 & 2) != 0) {
            function13 = new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$1
                public final void invoke(int r1) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
        } else {
            function13 = function1;
        }
        if ((r28 & 4) != 0) {
            function02 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        } else {
            function02 = function0;
        }
        if ((r28 & 8) != 0) {
            function14 = new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$3
                public final void invoke(int r1) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
        } else {
            function14 = function12;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final Function1<? super Integer, Unit> function15 = function13;
        final Function1<? super Integer, Unit> function16 = function14;
        final Function0<Unit> function03 = function02;
        LazyDslKt.LazyColumn(null, null, null, false, Arrangement.m60spacedBy0680j_4(8), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4
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

            /* JADX WARN: Type inference failed for: r0v4, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4$2, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r6v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4$invoke$$inlined$itemsIndexed$default$3, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<DebugWatchThemeFragment.WatchTheme> list2 = list;
                final DebugWatchThemeFragment debugWatchThemeFragment = this;
                final Function1<Integer, Unit> function17 = function15;
                final Function1<Integer, Unit> function18 = function16;
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4$invoke$$inlined$itemsIndexed$default$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r2) {
                        list2.get(r2);
                        return null;
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-1091073711, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4$invoke$$inlined$itemsIndexed$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r10, Composer composer2, int r12) {
                        int r9;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r12 & 14) == 0) {
                            r9 = (composer2.changed(items) ? 4 : 2) | r12;
                        } else {
                            r9 = r12;
                        }
                        if ((r12 & 112) == 0) {
                            r9 |= composer2.changed(r10) ? 32 : 16;
                        }
                        if ((r9 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        debugWatchThemeFragment.ThemeRow(r10, (DebugWatchThemeFragment.WatchTheme) list2.get(r10), function17, function18, composer2, ((((r9 & 112) | (r9 & 14)) >> 3) & 14) | 32832, 0);
                    }
                }, true));
                final Function0<Unit> function04 = function03;
                LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(-431434327, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                        invoke(lazyItemScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer2, int r11) {
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((r11 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        composer2.startReplaceableGroup(2010623815);
                        boolean changedInstance = composer2.changedInstance(function04);
                        final Function0<Unit> function05 = function04;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$4$2$1$1
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
                                    function05.invoke();
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        ButtonBorderlessKt.ButtonBorderless(null, "Add theme", false, false, (Function0) rememberedValue, composer2, 48, 13);
                    }
                }, true));
            }
        }, startRestartGroup, 24576, 239);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Function1<? super Integer, Unit> function17 = function13;
            final Function0<Unit> function04 = function02;
            final Function1<? super Integer, Unit> function18 = function14;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePicker$5
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

                public final void invoke(Composer composer2, int r10) {
                    DebugWatchThemeFragment.this.ThemePicker(list, function17, function04, function18, composer2, Strings.updateChangedFlags(r27 | 1), r28);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ThemeRow(final int r36, final WatchTheme watchTheme, Function1<? super Integer, Unit> function1, Function1<? super Integer, Unit> function12, Composer composer, final int r41, final int r42) {
        final Function1<? super Integer, Unit> function13;
        final Function1<? super Integer, Unit> function14;
        boolean z;
        boolean z2;
        Modifier m21backgroundbw27NRU;
        Modifier m21backgroundbw27NRU2;
        Modifier m21backgroundbw27NRU3;
        boolean z3;
        boolean z4;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-160866156);
        if ((r42 & 4) != 0) {
            function13 = new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemeRow$1
                public final void invoke(int r1) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
        } else {
            function13 = function1;
        }
        if ((r42 & 8) != 0) {
            function14 = new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemeRow$2
                public final void invoke(int r1) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
        } else {
            function14 = function12;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        startRestartGroup.startReplaceableGroup(1013658401);
        if ((((r41 & 896) ^ 384) > 256 && startRestartGroup.changedInstance(function13)) || (r41 & 384) == 256) {
            z = true;
        } else {
            z = false;
        }
        int r15 = (r41 & 14) ^ 6;
        if ((r15 > 4 && startRestartGroup.changed(r36)) || (r41 & 6) == 4) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z5 = z | z2;
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (z5 || nextSlot == composer$Companion$Empty$1) {
            nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemeRow$3$1
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
                    function13.invoke(Integer.valueOf(r36));
                }
            };
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(companion, (Function0) nextSlot);
        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
        float f = 4;
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(BackgroundKt.m21backgroundbw27NRU(m26clickableXHw0xAI$default, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m164getBackground0d7_KjU(), ((Shapes) startRestartGroup.consume(ShapesKt.LocalShapes)).small), f);
        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
        startRestartGroup.startReplaceableGroup(693286680);
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
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
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m216Text4IGK_g(watchTheme.getName(), PaddingKt.m71padding3ABfNKs(SizeKt.m94width3ABfNKs(companion, 100), f), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 48, 0, 131064);
            float f2 = 24;
            m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(SizeKt.m83height3ABfNKs(companion, f2), m892getComposeColorgJ2LKyU(watchTheme.m896getBackgroundIpmnaRI()), RectangleShapeKt.RectangleShape);
            BoxKt.Box(rowScopeInstance.weight(m21backgroundbw27NRU, 1.0f, true), startRestartGroup, 0);
            m21backgroundbw27NRU2 = BackgroundKt.m21backgroundbw27NRU(SizeKt.m83height3ABfNKs(companion, f2), m892getComposeColorgJ2LKyU(watchTheme.m897getPrimaryIpmnaRI()), RectangleShapeKt.RectangleShape);
            BoxKt.Box(rowScopeInstance.weight(m21backgroundbw27NRU2, 1.0f, true), startRestartGroup, 0);
            m21backgroundbw27NRU3 = BackgroundKt.m21backgroundbw27NRU(SizeKt.m83height3ABfNKs(companion, f2), m892getComposeColorgJ2LKyU(watchTheme.m898getSecondaryIpmnaRI()), RectangleShapeKt.RectangleShape);
            BoxKt.Box(rowScopeInstance.weight(m21backgroundbw27NRU3, 1.0f, true), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1351541627);
            if ((((r41 & 7168) ^ 3072) > 2048 && startRestartGroup.changedInstance(function14)) || (r41 & 3072) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((r15 > 4 && startRestartGroup.changed(r36)) || (r41 & 6) == 4) {
                z4 = true;
            } else {
                z4 = false;
            }
            boolean z6 = z3 | z4;
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (z6 || nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemeRow$4$1$1
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
                        function14.invoke(Integer.valueOf(r36));
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            ButtonKt.Button((Function0) nextSlot2, null, false, null, null, null, null, null, null, ComposableSingletons$DebugWatchThemeFragmentKt.INSTANCE.m867getLambda1$secondo_kronabyRelease(), startRestartGroup, 805306368, 510);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemeRow$5
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

                    public final void invoke(Composer composer2, int r10) {
                        DebugWatchThemeFragment.this.ThemeRow(r36, watchTheme, function13, function14, composer2, Strings.updateChangedFlags(r41 | 1), r42);
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
    public final SnapshotStateList<WatchTheme> getAllThemes() {
        return (SnapshotStateList) this.allThemes$delegate.getValue();
    }

    /* renamed from: getComposeColor-gJ2LKyU, reason: not valid java name */
    private final long m892getComposeColorgJ2LKyU(int r4) {
        return ColorKt.Color(Kolor.m1543getRedimpl(r4), Kolor.m1542getGreenimpl(r4), Kolor.m1541getBlueimpl(r4), Kolor.m1540getAlphaimpl(r4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableState<WatchTheme> getCurrentTheme() {
        return (MutableState) this.currentTheme$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getRgbHex-ukcjflE, reason: not valid java name */
    public final String m893getRgbHexukcjflE(int r3) {
        String format = String.format("#%02X%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(Kolor.m1543getRedimpl(r3)), Integer.valueOf(Kolor.m1542getGreenimpl(r3)), Integer.valueOf(Kolor.m1541getBlueimpl(r3))}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<WatchTheme> readThemes() {
        String string = getStorage().getString("themes");
        if (string == null) {
            return this.pascalThemes;
        }
        Object fromJson = new Gson().fromJson(string, new TypeToken<List<? extends WatchTheme>>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$readThemes$result$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(...)");
        List<WatchTheme> list = (List) fromJson;
        if (list.isEmpty()) {
            list = this.pascalThemes;
        }
        return list;
    }

    private final void saveThemes(List<WatchTheme> list) {
        getStorage().put("themes", new Gson().toJson(list));
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r12) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(2091907629);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16);
        Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(8);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
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
            SelectedTheme(getCurrentTheme().getValue(), new Function1<WatchTheme, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ComposeContent$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DebugWatchThemeFragment.WatchTheme watchTheme) {
                    invoke2(watchTheme);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DebugWatchThemeFragment.WatchTheme it) {
                    SnapshotStateList allThemes;
                    MutableState mutableState;
                    MutableState currentTheme;
                    Intrinsics.checkNotNullParameter(it, "it");
                    allThemes = DebugWatchThemeFragment.this.getAllThemes();
                    mutableState = DebugWatchThemeFragment.this.currentThemeIndex;
                    allThemes.set(((Number) mutableState.getValue()).intValue(), it);
                    currentTheme = DebugWatchThemeFragment.this.getCurrentTheme();
                    currentTheme.setValue(it);
                }
            }, startRestartGroup, DfuConstants.UNKNOWN_DFU_15_ERROR, 0);
            ThemePicker(getAllThemes(), new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ComposeContent$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int r3) {
                    MutableState mutableState;
                    MutableState currentTheme;
                    SnapshotStateList allThemes;
                    mutableState = DebugWatchThemeFragment.this.currentThemeIndex;
                    mutableState.setValue(Integer.valueOf(r3));
                    currentTheme = DebugWatchThemeFragment.this.getCurrentTheme();
                    allThemes = DebugWatchThemeFragment.this.getAllThemes();
                    currentTheme.setValue(allThemes.get(r3));
                }
            }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ComposeContent$1$3
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
                    SnapshotStateList allThemes;
                    List list;
                    allThemes = DebugWatchThemeFragment.this.getAllThemes();
                    list = DebugWatchThemeFragment.this.pascalThemes;
                    allThemes.add(list.get(0));
                }
            }, new Function1<Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ComposeContent$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int r2) {
                    SnapshotStateList allThemes;
                    allThemes = DebugWatchThemeFragment.this.getAllThemes();
                    allThemes.remove(r2);
                }
            }, startRestartGroup, DfuBaseService.ERROR_CONNECTION_STATE_MASK, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ComposeContent$2
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
                        DebugWatchThemeFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r12 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$PreviewThemeRow$1, kotlin.jvm.internal.Lambda] */
    public final void PreviewThemeRow(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1180457769);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableLambdaKt.composableLambda(startRestartGroup, -427317817, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$PreviewThemeRow$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r10) {
                List list;
                if ((r10 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                list = DebugWatchThemeFragment.this.pascalThemes;
                DebugWatchThemeFragment.this.ThemeRow(0, (DebugWatchThemeFragment.WatchTheme) list.get(0), null, null, composer2, 32838, 12);
            }
        }), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$PreviewThemeRow$2
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
                    DebugWatchThemeFragment.this.PreviewThemeRow(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePickerPreview$1, kotlin.jvm.internal.Lambda] */
    public final void ThemePickerPreview(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-336684317);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableLambdaKt.composableLambda(startRestartGroup, -453528589, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePickerPreview$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r10) {
                List list;
                if ((r10 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                DebugWatchThemeFragment debugWatchThemeFragment = DebugWatchThemeFragment.this;
                list = debugWatchThemeFragment.pascalThemes;
                debugWatchThemeFragment.ThemePicker(CollectionsKt__CollectionsKt.listOf(list.get(0)), null, null, null, composer2, 32776, 14);
            }
        }), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePickerPreview$2
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
                    DebugWatchThemeFragment.this.ThemePickerPreview(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePreview$1, kotlin.jvm.internal.Lambda] */
    public final void ThemePreview(Composer composer, final int r5) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1787226507);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(FestinaComposeThemeProvider.INSTANCE, ComposableLambdaKt.composableLambda(startRestartGroup, -313640059, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePreview$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int r8) {
                List list;
                if ((r8 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                DebugWatchThemeFragment debugWatchThemeFragment = DebugWatchThemeFragment.this;
                list = debugWatchThemeFragment.pascalThemes;
                debugWatchThemeFragment.SelectedTheme((DebugWatchThemeFragment.WatchTheme) list.get(0), null, composer2, DfuConstants.UNKNOWN_DFU_15_ERROR, 2);
            }
        }), startRestartGroup, FestinaComposeThemeProvider.$stable | 48);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugWatchThemeFragment$ThemePreview$2
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
                    DebugWatchThemeFragment.this.ThemePreview(composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        String string = getString(R.string.feature_path_settings);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    public final SharedPreferencesCache getStorage() {
        return (SharedPreferencesCache) this.storage$delegate.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        saveThemes(getAllThemes());
    }
}
