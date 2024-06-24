package com.animaconnected.secondo.screens.notification.alarm;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.ExitTransitionImpl;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSourceImpl;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.Arrangement$SpaceBetween$1;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.HorizontalAlignElement;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.IconKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
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
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ContentScale$Companion$Inside$1;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.fragment.app.Fragment;
import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.notification.alarm.utils.WeekDayFormatterKt;
import com.animaconnected.secondo.screens.pickerdialog.TimePickerShower;
import com.animaconnected.watch.behaviour.alarms.AlarmsViewModel;
import com.animaconnected.watch.provider.AlarmDay;
import com.animaconnected.watch.provider.WatchAlarm;
import com.animaconnected.watch.provider.WeekDayFormatter;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.ButtonOutlinedKt;
import com.animaconnected.widget.ModifiersKt;
import com.animaconnected.widget.Switch2Kt;
import com.animaconnected.widget.theme.TypographyKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AlarmViews.kt */
/* loaded from: classes3.dex */
public final class AlarmViewsKt {
    public static final void AlarmOverview(final WatchAlarm alarm, final AlarmsViewModel viewModel, final Fragment fragment, final WeekDayFormatter weekDayFormatter, Composer composer, final int r48) {
        float f;
        long Color;
        int r5;
        long j;
        ColorFilter porterDuffColorFilter;
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(weekDayFormatter, "weekDayFormatter");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-336200447);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        long id = alarm.getId();
        startRestartGroup.startReplaceableGroup(18091389);
        boolean changed = startRestartGroup.changed(id);
        Object nextSlot = startRestartGroup.nextSlot();
        Object obj = Composer.Companion.Empty;
        if (changed || nextSlot == obj) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        if (AlarmOverview$lambda$3(mutableState)) {
            f = 180.0f;
        } else {
            f = 0.0f;
        }
        final State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, null, "chevron animation", null, startRestartGroup, 3072, 22);
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == obj) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        DeviceType deviceType = ProviderFactory.getWatch().getDeviceType();
        boolean z = true;
        if (deviceType == null || !deviceType.getHasDisplay()) {
            z = false;
        }
        if (alarm.getEnabled()) {
            startRestartGroup.startReplaceableGroup(18091697);
            Color = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU();
            startRestartGroup.end(false);
        } else {
            startRestartGroup.startReplaceableGroup(18091752);
            Color = ColorKt.Color(Color.m322getRedimpl(r5), Color.m321getGreenimpl(r5), Color.m319getBlueimpl(r5), 0.5f, Color.m320getColorSpaceimpl(((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU()));
            startRestartGroup.end(false);
        }
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, 32, 7);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
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
            long j2 = Color;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
            IntrinsicSize intrinsicSize = IntrinsicSize.Max;
            Modifier height = IntrinsicKt.height(fillMaxWidth, intrinsicSize);
            Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(height);
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
                Modifier fillMaxHeight = SizeKt.fillMaxHeight(companion, 1.0f);
                startRestartGroup.startReplaceableGroup(693286680);
                MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(fillMaxHeight);
                if (applier instanceof Applier) {
                    startRestartGroup.startReusableNode();
                    if (startRestartGroup.inserting) {
                        startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                    } else {
                        startRestartGroup.useNode();
                    }
                    Updater.m228setimpl(startRestartGroup, rowMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                    Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                    if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                        AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                    }
                    AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                    Modifier m75paddingqDBjuR0$default2 = PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 0.0f, 8, 0.0f, 11);
                    ContentScale$Companion$Inside$1 contentScale$Companion$Inside$1 = ContentScale.Companion.Inside;
                    if (alarm.getEnabled()) {
                        startRestartGroup.startReplaceableGroup(-405843544);
                        r5 = R.drawable.ic_active_alarm;
                    } else {
                        startRestartGroup.startReplaceableGroup(-405843495);
                        r5 = R.drawable.ic_inactive_alarm;
                    }
                    Painter painterResource = PainterResources_androidKt.painterResource(r5, startRestartGroup);
                    startRestartGroup.end(false);
                    if (alarm.getEnabled() && z) {
                        startRestartGroup.startReplaceableGroup(-405843232);
                        j = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
                        startRestartGroup.end(false);
                    } else if (alarm.getEnabled()) {
                        startRestartGroup.startReplaceableGroup(-405843156);
                        j = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m170getPrimary0d7_KjU();
                        startRestartGroup.end(false);
                    } else {
                        startRestartGroup.startReplaceableGroup(-405843112);
                        startRestartGroup.end(false);
                        j = j2;
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(j, 5);
                    } else {
                        porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(j), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                    }
                    ImageKt.Image(painterResource, "Alarm icon", m75paddingqDBjuR0$default2, null, contentScale$Companion$Inside$1, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), startRestartGroup, 25016, 40);
                    TypographyKt.m1636BigTextZHfKjFs(ClickableKt.m26clickableXHw0xAI$default(SizeKt.fillMaxHeight(companion, 1.0f), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$1$1$1
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
                            AlarmViewsKt.showTimeEditDialog(WatchAlarm.this, coroutineScope, viewModel, fragment);
                        }
                    }), viewModel.getTimeString(alarm), j2, null, 0, 0, false, startRestartGroup, 0, 120);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    Switch2Kt.Switch2(alarm.getEnabled(), new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$1$2

                        /* compiled from: AlarmViews.kt */
                        @DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$1$2$1", f = "AlarmViews.kt", l = {109}, m = "invokeSuspend")
                        /* renamed from: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$1$2$1, reason: invalid class name */
                        /* loaded from: classes3.dex */
                        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ WatchAlarm $alarm;
                            final /* synthetic */ boolean $isChecked;
                            final /* synthetic */ AlarmsViewModel $viewModel;
                            int label;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            public AnonymousClass1(AlarmsViewModel alarmsViewModel, WatchAlarm watchAlarm, boolean z, Continuation<? super AnonymousClass1> continuation) {
                                super(2, continuation);
                                this.$viewModel = alarmsViewModel;
                                this.$alarm = watchAlarm;
                                this.$isChecked = z;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                return new AnonymousClass1(this.$viewModel, this.$alarm, this.$isChecked, continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                                int r2 = this.label;
                                if (r2 != 0) {
                                    if (r2 == 1) {
                                        ResultKt.throwOnFailure(obj);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                } else {
                                    ResultKt.throwOnFailure(obj);
                                    AlarmsViewModel alarmsViewModel = this.$viewModel;
                                    WatchAlarm copy$default = WatchAlarm.copy$default(this.$alarm, 0L, 0, 0, null, this.$isChecked, false, 0L, 111, null);
                                    this.label = 1;
                                    if (alarmsViewModel.updateAlarm(copy$default, this) == coroutineSingletons) {
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
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z2) {
                            BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(viewModel, alarm, z2, null), 3);
                        }
                    }, null, false, null, null, startRestartGroup, 0, 60);
                    AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                    Modifier height2 = IntrinsicKt.height(SizeKt.fillMaxWidth(companion, 1.0f), intrinsicSize);
                    startRestartGroup.startReplaceableGroup(-1212421400);
                    boolean changed2 = startRestartGroup.changed(mutableState);
                    Object nextSlot2 = startRestartGroup.nextSlot();
                    if (changed2 || nextSlot2 == obj) {
                        nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$2$1
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
                                boolean AlarmOverview$lambda$3;
                                MutableState<Boolean> mutableState2 = mutableState;
                                AlarmOverview$lambda$3 = AlarmViewsKt.AlarmOverview$lambda$3(mutableState2);
                                AlarmViewsKt.AlarmOverview$lambda$4(mutableState2, !AlarmOverview$lambda$3);
                            }
                        };
                        startRestartGroup.updateValue(nextSlot2);
                    }
                    startRestartGroup.end(false);
                    Modifier noRippleClickable = ModifiersKt.noRippleClickable(height2, (Function0) nextSlot2);
                    startRestartGroup.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, vertical, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope4 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(noRippleClickable);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, rowMeasurePolicy3, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope4, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash4))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash4, startRestartGroup, currentCompositeKeyHash4, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf4, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                        Modifier m75paddingqDBjuR0$default3 = PaddingKt.m75paddingqDBjuR0$default(companion, 40, 0.0f, 0.0f, 0.0f, 14);
                        Context requireContext = fragment.requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                        String alarmDescription = WeekDayFormatterKt.getAlarmDescription(weekDayFormatter, requireContext, alarm.getDaysEnabled());
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        TextKt.m216Text4IGK_g(alarmDescription, m75paddingqDBjuR0$default3, j2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(androidx.compose.material.TypographyKt.LocalTypography)).h4, startRestartGroup, 48, 0, 65528);
                        Painter painterResource2 = PainterResources_androidKt.painterResource(R.drawable.ic_chevron_down, startRestartGroup);
                        startRestartGroup.startReplaceableGroup(-332818411);
                        boolean changed3 = startRestartGroup.changed(animateFloatAsState);
                        Object nextSlot3 = startRestartGroup.nextSlot();
                        if (changed3 || nextSlot3 == obj) {
                            nextSlot3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$1$3$1$1
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
                                    graphicsLayer.setRotationZ(animateFloatAsState.getValue().floatValue());
                                }
                            };
                            startRestartGroup.updateValue(nextSlot3);
                        }
                        startRestartGroup.end(false);
                        IconKt.m187Iconww6aTOc(painterResource2, "Expandable Arrow", GraphicsLayerModifierKt.graphicsLayer(companion, (Function1) nextSlot3), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), startRestartGroup, 56, 0);
                        AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                        ExpandableInfo(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 16, 0.0f, 0.0f, 13), AlarmOverview$lambda$3(mutableState), alarm, viewModel, weekDayFormatter, startRestartGroup, 37382, 0);
                        RecomposeScopeImpl m2 = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                        if (m2 != null) {
                            m2.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmOverview$2
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
                                    AlarmViewsKt.AlarmOverview(WatchAlarm.this, viewModel, fragment, weekDayFormatter, composer2, Strings.updateChangedFlags(r48 | 1));
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
            ComposablesKt.invalidApplier();
            throw null;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean AlarmOverview$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AlarmOverview$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public static final void AlarmsList(final AlarmsViewModel viewModel, final Fragment fragment, final WeekDayFormatter weekDayFormatter, Composer composer, final int r15) {
        boolean z;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(weekDayFormatter, "weekDayFormatter");
        ComposerImpl startRestartGroup = composer.startRestartGroup(77952037);
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
            AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 773894976);
            startRestartGroup.startReplaceableGroup(-492369756);
            Object nextSlot = startRestartGroup.nextSlot();
            if (nextSlot == Composer.Companion.Empty) {
                nextSlot = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
            }
            startRestartGroup.end(false);
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) nextSlot).coroutineScope;
            startRestartGroup.end(false);
            MutableState collectAsState = Platform.collectAsState(viewModel.getAlarmsFlow(), EmptyList.INSTANCE, null, startRestartGroup, 2);
            startRestartGroup.startReplaceableGroup(-1685385448);
            Iterator it = ((Iterable) collectAsState.getValue()).iterator();
            while (it.hasNext()) {
                AlarmOverview((WatchAlarm) it.next(), viewModel, fragment, weekDayFormatter, startRestartGroup, 4680);
            }
            startRestartGroup.end(false);
            if (((List) collectAsState.getValue()).size() < viewModel.getMaxAlarmAmount()) {
                z = true;
            } else {
                z = false;
            }
            ButtonOutlinedKt.ButtonOutlined(new HorizontalAlignElement(Alignment.Companion.CenterHorizontally), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmsList$1$2

                /* compiled from: AlarmViews.kt */
                @DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmsList$1$2$1", f = "AlarmViews.kt", l = {53}, m = "invokeSuspend")
                /* renamed from: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmsList$1$2$1, reason: invalid class name */
                /* loaded from: classes3.dex */
                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ AlarmsViewModel $viewModel;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public AnonymousClass1(AlarmsViewModel alarmsViewModel, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$viewModel = alarmsViewModel;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new AnonymousClass1(this.$viewModel, continuation);
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
                            AlarmsViewModel alarmsViewModel = this.$viewModel;
                            this.label = 1;
                            if (alarmsViewModel.addAlarm(this) == coroutineSingletons) {
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
                    BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(viewModel, null), 3);
                }
            }, z, false, ComposableSingletons$AlarmViewsKt.INSTANCE.m940getLambda1$secondo_kronabyRelease(), startRestartGroup, 24576, 8);
            AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
            RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$AlarmsList$2
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
                        AlarmViewsKt.AlarmsList(AlarmsViewModel.this, fragment, weekDayFormatter, composer2, Strings.updateChangedFlags(r15 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1, kotlin.jvm.internal.Lambda] */
    public static final void ExpandableInfo(Modifier modifier, final boolean z, final WatchAlarm alarm, final AlarmsViewModel viewModel, final WeekDayFormatter weekDayFormatter, Composer composer, final int r26, final int r27) {
        Modifier modifier2;
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(weekDayFormatter, "weekDayFormatter");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-833354720);
        if ((r27 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == Composer.Companion.Empty) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        ExitTransitionImpl plus = EnterExitTransitionKt.shrinkVertically$default().plus(EnterExitTransitionKt.fadeOut$default(null, 3));
        final Modifier modifier3 = modifier2;
        AnimatedVisibilityKt.AnimatedVisibility(z, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 3).plus(EnterExitTransitionKt.expandVertically$default()), plus, (String) null, ComposableLambdaKt.composableLambda(startRestartGroup, -347617032, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer2, Integer num) {
                invoke(animatedVisibilityScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int r25) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                Modifier modifier4 = Modifier.this;
                BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
                final WatchAlarm watchAlarm = alarm;
                WeekDayFormatter weekDayFormatter2 = weekDayFormatter;
                final CoroutineScope coroutineScope2 = coroutineScope;
                final AlarmsViewModel alarmsViewModel = viewModel;
                composer2.startReplaceableGroup(-483455358);
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, composer2);
                composer2.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                ComposeUiNode.Companion.getClass();
                LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier4);
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
                    Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 40, 0.0f, 8, 0.0f, 10);
                    Arrangement$SpaceBetween$1 arrangement$SpaceBetween$1 = Arrangement.SpaceBetween;
                    composer2.startReplaceableGroup(693286680);
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement$SpaceBetween$1, Alignment.Companion.Top, composer2);
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
                        Updater.m228setimpl(composer2, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, composer2, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        modifierMaterializerOf2.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(1793671948);
                        for (final AlarmDay alarmDay : AlarmDay.Companion.getAll()) {
                            final boolean contains = watchAlarm.getDaysEnabled().contains(alarmDay);
                            AlarmViewsKt.WeekDayChip(SizeKt.m91size3ABfNKs(companion, 32), weekDayFormatter2.getShortWeekday(alarmDay), contains, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$1$1$1

                                /* compiled from: AlarmViews.kt */
                                @DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$1$1$1$1", f = "AlarmViews.kt", l = {180}, m = "invokeSuspend")
                                /* renamed from: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$1$1$1$1, reason: invalid class name */
                                /* loaded from: classes3.dex */
                                public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    final /* synthetic */ WatchAlarm $alarm;
                                    final /* synthetic */ AlarmDay $alarmDay;
                                    final /* synthetic */ boolean $isSelected;
                                    final /* synthetic */ AlarmsViewModel $viewModel;
                                    int label;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    public AnonymousClass1(AlarmsViewModel alarmsViewModel, boolean z, AlarmDay alarmDay, WatchAlarm watchAlarm, Continuation<? super AnonymousClass1> continuation) {
                                        super(2, continuation);
                                        this.$viewModel = alarmsViewModel;
                                        this.$isSelected = z;
                                        this.$alarmDay = alarmDay;
                                        this.$alarm = watchAlarm;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new AnonymousClass1(this.$viewModel, this.$isSelected, this.$alarmDay, this.$alarm, continuation);
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
                                            AlarmsViewModel alarmsViewModel = this.$viewModel;
                                            boolean z = this.$isSelected;
                                            AlarmDay alarmDay = this.$alarmDay;
                                            WatchAlarm watchAlarm = this.$alarm;
                                            this.label = 1;
                                            if (alarmsViewModel.toggleAlarm(z, alarmDay, watchAlarm, this) == coroutineSingletons) {
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
                                    BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(alarmsViewModel, contains, alarmDay, watchAlarm, null), 3);
                                }
                            }, composer2, 6, 0);
                        }
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        ButtonBorderlessKt.ButtonBorderless(PaddingKt.m75paddingqDBjuR0$default(companion, 0.0f, 24, 0.0f, 0.0f, 13), URLProtocolKt.stringResource(R.string.alarm_app_delete_alarm_button_title, composer2), false, false, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$2

                            /* compiled from: AlarmViews.kt */
                            @DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$2$1", f = "AlarmViews.kt", l = {187}, m = "invokeSuspend")
                            /* renamed from: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$1$1$2$1, reason: invalid class name */
                            /* loaded from: classes3.dex */
                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ WatchAlarm $alarm;
                                final /* synthetic */ AlarmsViewModel $viewModel;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public AnonymousClass1(AlarmsViewModel alarmsViewModel, WatchAlarm watchAlarm, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$viewModel = alarmsViewModel;
                                    this.$alarm = watchAlarm;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$viewModel, this.$alarm, continuation);
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
                                        AlarmsViewModel alarmsViewModel = this.$viewModel;
                                        WatchAlarm watchAlarm = this.$alarm;
                                        this.label = 1;
                                        if (alarmsViewModel.deleteAlarm(watchAlarm, this) == coroutineSingletons) {
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
                                BuildersKt.launch$default(CoroutineScope.this, null, null, new AnonymousClass1(alarmsViewModel, watchAlarm, null), 3);
                            }
                        }, composer2, 6, 12);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
                ComposablesKt.invalidApplier();
                throw null;
            }
        }), startRestartGroup, ((r26 >> 3) & 14) | 200064, 18);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$ExpandableInfo$2
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
                    AlarmViewsKt.ExpandableInfo(Modifier.this, z, alarm, viewModel, weekDayFormatter, composer2, Strings.updateChangedFlags(r26 | 1), r27);
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r8v21, types: [kotlin.jvm.internal.Lambda, com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$WeekDayChip$2] */
    public static final void WeekDayChip(Modifier modifier, final String weekDay, final boolean z, final Function0<Unit> onToggle, Composer composer, final int r23, final int r24) {
        Modifier modifier2;
        int r7;
        int r72;
        int r8;
        int r82;
        int r83;
        final Modifier modifier3;
        boolean z2;
        long m174getSurface0d7_KjU;
        Intrinsics.checkNotNullParameter(weekDay, "weekDay");
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        ComposerImpl startRestartGroup = composer.startRestartGroup(1674413783);
        int r1 = r24 & 1;
        if (r1 != 0) {
            r7 = r23 | 6;
            modifier2 = modifier;
        } else if ((r23 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r72 = 4;
            } else {
                r72 = 2;
            }
            r7 = r72 | r23;
        } else {
            modifier2 = modifier;
            r7 = r23;
        }
        if ((r24 & 2) != 0) {
            r7 |= 48;
        } else if ((r23 & 112) == 0) {
            if (startRestartGroup.changed(weekDay)) {
                r8 = 32;
            } else {
                r8 = 16;
            }
            r7 |= r8;
        }
        if ((r24 & 4) != 0) {
            r7 |= 384;
        } else if ((r23 & 896) == 0) {
            if (startRestartGroup.changed(z)) {
                r82 = 256;
            } else {
                r82 = 128;
            }
            r7 |= r82;
        }
        if ((r24 & 8) != 0) {
            r7 |= 3072;
        } else if ((r23 & 7168) == 0) {
            if (startRestartGroup.changedInstance(onToggle)) {
                r83 = 2048;
            } else {
                r83 = 1024;
            }
            r7 |= r83;
        }
        if ((r7 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (r1 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier toggleable = ClipKt.clip(modifier3, RoundedCornerShapeKt.CircleShape);
            startRestartGroup.startReplaceableGroup(-717913427);
            final boolean z3 = true;
            if ((r7 & 7168) == 2048) {
                z2 = true;
            } else {
                z2 = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z2 || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$WeekDayChip$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z4) {
                        onToggle.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            final Function1 onValueChange = (Function1) nextSlot;
            startRestartGroup.end(false);
            Intrinsics.checkNotNullParameter(toggleable, "$this$toggleable");
            Intrinsics.checkNotNullParameter(onValueChange, "onValueChange");
            final Role role = null;
            Modifier composed = ComposedModifierKt.composed(toggleable, InspectableValueKt.NoInspectorInfo, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public final Modifier invoke(Modifier modifier4, Composer composer2, Integer num) {
                    Composer composer3 = composer2;
                    EnterExitTransitionKt$shrinkExpand$1$$ExternalSyntheticOutline0.m(num, modifier4, "$this$composed", composer3, 290332169);
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    boolean z4 = z;
                    composer3.startReplaceableGroup(-492369756);
                    Object rememberedValue = composer3.rememberedValue();
                    if (rememberedValue == Composer.Companion.Empty) {
                        rememberedValue = new MutableInteractionSourceImpl();
                        composer3.updateRememberedValue(rememberedValue);
                    }
                    composer3.endReplaceableGroup();
                    Modifier m108toggleableO2vRcR0 = ToggleableKt.m108toggleableO2vRcR0(z4, (MutableInteractionSource) rememberedValue, (Indication) composer3.consume(IndicationKt.LocalIndication), z3, role, onValueChange);
                    composer3.endReplaceableGroup();
                    return m108toggleableO2vRcR0;
                }
            });
            float f = 8;
            if (z) {
                startRestartGroup.startReplaceableGroup(-717913318);
                m174getSurface0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m172getSecondary0d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(-717913282);
                m174getSurface0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
            }
            startRestartGroup.end(false);
            SurfaceKt.m205SurfaceFjzlyU(composed, null, m174getSurface0d7_KjU, 0L, null, f, ComposableLambdaKt.composableLambda(startRestartGroup, 124767251, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$WeekDayChip$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r30) {
                    long m169getOnSurface0d7_KjU;
                    if ((r30 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion.$$INSTANCE);
                    BiasAlignment biasAlignment = Alignment.Companion.Center;
                    String str = weekDay;
                    boolean z4 = z;
                    composer2.startReplaceableGroup(733328855);
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, composer2);
                    composer2.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                    PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    ComposeUiNode.Companion.getClass();
                    LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                    ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxSize$default);
                    if (composer2.getApplier() instanceof Applier) {
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            composer2.useNode();
                        }
                        Updater.m228setimpl(composer2, rememberBoxMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                        Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                        if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                        if (z4) {
                            composer2.startReplaceableGroup(-1403305737);
                            m169getOnSurface0d7_KjU = ((Colors) composer2.consume(ColorsKt.LocalColors)).m174getSurface0d7_KjU();
                        } else {
                            composer2.startReplaceableGroup(-1403305703);
                            m169getOnSurface0d7_KjU = ((Colors) composer2.consume(ColorsKt.LocalColors)).m169getOnSurface0d7_KjU();
                        }
                        composer2.endReplaceableGroup();
                        TextKt.m216Text4IGK_g(str, null, m169getOnSurface0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) composer2.consume(androidx.compose.material.TypographyKt.LocalTypography)).h5, composer2, 0, 0, 65530);
                        DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                        return;
                    }
                    ComposablesKt.invalidApplier();
                    throw null;
                }
            }), startRestartGroup, 1769472, 26);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$WeekDayChip$3
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
                    AlarmViewsKt.WeekDayChip(Modifier.this, weekDay, z, onToggle, composer2, Strings.updateChangedFlags(r23 | 1), r24);
                }
            };
        }
    }

    public static final void showTimeEditDialog(final WatchAlarm alarm, final CoroutineScope scope, final AlarmsViewModel viewModel, Fragment fragment) {
        Intrinsics.checkNotNullParameter(alarm, "alarm");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        TimePickerShower.showTimeEditDialog(fragment, alarm.getHour(), alarm.getMinute(), new Function2<Integer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$showTimeEditDialog$1

            /* compiled from: AlarmViews.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$showTimeEditDialog$1$1", f = "AlarmViews.kt", l = {230}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.notification.alarm.AlarmViewsKt$showTimeEditDialog$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ WatchAlarm $newAlarm;
                final /* synthetic */ AlarmsViewModel $viewModel;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(AlarmsViewModel alarmsViewModel, WatchAlarm watchAlarm, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$viewModel = alarmsViewModel;
                    this.$newAlarm = watchAlarm;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$viewModel, this.$newAlarm, continuation);
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
                        AlarmsViewModel alarmsViewModel = this.$viewModel;
                        WatchAlarm watchAlarm = this.$newAlarm;
                        this.label = 1;
                        if (alarmsViewModel.updateAlarm(watchAlarm, this) == coroutineSingletons) {
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
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
                invoke(num.intValue(), num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int r13, int r14) {
                BuildersKt.launch$default(scope, null, null, new AnonymousClass1(viewModel, WatchAlarm.copy$default(WatchAlarm.this, 0L, r13, r14, null, false, false, 0L, 121, null), null), 3);
            }
        });
    }
}
