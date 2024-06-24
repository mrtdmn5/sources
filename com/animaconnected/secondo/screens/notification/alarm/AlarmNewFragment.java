package com.animaconnected.secondo.screens.notification.alarm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$Top$1;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.behaviour.alarms.AlarmsApp;
import com.animaconnected.watch.behaviour.alarms.AlarmsViewModel;
import com.animaconnected.watch.provider.WeekDayFormatter;
import com.animaconnected.widget.ScreenTitleKt;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlarmNewFragment.kt */
/* loaded from: classes3.dex */
public final class AlarmNewFragment extends BaseDetailsFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final WeekDayFormatter weekDayFormatter = new WeekDayFormatter();
    private final AlarmsViewModel viewModel = new AlarmsViewModel();

    /* compiled from: AlarmNewFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AlarmNewFragment newInstance(Slot slot) {
            AlarmNewFragment alarmNewFragment = new AlarmNewFragment();
            Bundle bundle = new Bundle();
            String slot2 = alarmNewFragment.getSLOT();
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type java.io.Serializable");
            bundle.putSerializable(slot2, slot);
            bundle.putString(alarmNewFragment.getTYPE(), AlarmsApp.TYPE);
            alarmNewFragment.setArguments(bundle);
            return alarmNewFragment;
        }

        private Companion() {
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.notification.alarm.AlarmNewFragment$onCreateView$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public ComposeView onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(requireContext, null, 6);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(379056348, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmNewFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.notification.alarm.AlarmNewFragment$onCreateView$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r3) {
                if ((r3 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final AlarmNewFragment alarmNewFragment = AlarmNewFragment.this;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 1803658411, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmNewFragment$onCreateView$1$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r23) {
                        AlarmsViewModel alarmsViewModel;
                        WeekDayFormatter weekDayFormatter;
                        if ((r23 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        Modifier height = IntrinsicKt.height(SizeKt.fillMaxWidth(companion, 1.0f), IntrinsicSize.Max);
                        AlarmNewFragment alarmNewFragment2 = AlarmNewFragment.this;
                        composer2.startReplaceableGroup(-483455358);
                        Arrangement$Top$1 arrangement$Top$1 = Arrangement.Top;
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement$Top$1, horizontal, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(height);
                        if (composer2.getApplier() instanceof Applier) {
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                composer2.useNode();
                            }
                            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
                            Updater.m228setimpl(composer2, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
                            Updater.m228setimpl(composer2, currentCompositionLocalMap, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                            String string = alarmNewFragment2.getString(R.string.alarm_app_title);
                            float f = 24;
                            Modifier m74paddingqDBjuR0 = PaddingKt.m74paddingqDBjuR0(companion, f, f, f, 40);
                            Intrinsics.checkNotNull(string);
                            ScreenTitleKt.ScreenImageTitle(m74paddingqDBjuR0, string, R.drawable.ic_alarm, composer2, 384, 0);
                            Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 8, 0.0f, f, 0.0f, 10);
                            composer2.startReplaceableGroup(-483455358);
                            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement$Top$1, Alignment.Companion.Start, composer2);
                            composer2.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                            PersistentCompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
                            if (composer2.getApplier() instanceof Applier) {
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    composer2.useNode();
                                }
                                Updater.m228setimpl(composer2, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                                Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                                if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                                }
                                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                                composer2.startReplaceableGroup(2058660585);
                                alarmsViewModel = alarmNewFragment2.viewModel;
                                weekDayFormatter = alarmNewFragment2.weekDayFormatter;
                                AlarmViewsKt.AlarmsList(alarmsViewModel, alarmNewFragment2, weekDayFormatter, composer2, 584);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 48), composer2, 6);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                return;
                            }
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                }), composer, 6);
            }
        }, true));
        return composeView;
    }
}
