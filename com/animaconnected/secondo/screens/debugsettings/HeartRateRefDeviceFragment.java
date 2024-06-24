package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
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
import androidx.compose.runtime.StaticProvidableCompositionLocal;
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
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.heartrate.HeartRateDevice;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.dfu.dfu.utils.DfuConstants;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.io.File;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: HeartRateRefDeviceFragment.kt */
/* loaded from: classes3.dex */
public final class HeartRateRefDeviceFragment extends ComposeFragment {
    private final HeartRateRefFileSaver logger = new HeartRateRefFileSaver(ProviderFactory.getWatch().getWatchManager().getFitnessProvider());
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: HeartRateRefDeviceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final HeartRateRefDeviceFragment newInstance() {
            return new HeartRateRefDeviceFragment();
        }

        private Companion() {
        }
    }

    private static final boolean ComposeContent$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public final void DeviceList(final List<BluetoothDevice> list, final Function1<? super BluetoothDevice, Unit> function1, Composer composer, final int r19) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(431243737);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyDslKt.LazyColumn(null, null, null, false, Arrangement.m60spacedBy0680j_4(4), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1
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

            /* JADX WARN: Type inference failed for: r2v1, types: [com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<BluetoothDevice> list2 = list;
                final Function1<BluetoothDevice, Unit> function12 = function1;
                final HeartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$1 heartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(BluetoothDevice bluetoothDevice) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((BluetoothDevice) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final Object invoke(int r3) {
                        return Function1.this.invoke(list2.get(r3));
                    }
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r28, Composer composer2, int r30) {
                        int r1;
                        Modifier fillMaxWidth;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r30 & 14) == 0) {
                            r1 = r30 | (composer2.changed(items) ? 4 : 2);
                        } else {
                            r1 = r30;
                        }
                        if ((r30 & 112) == 0) {
                            r1 |= composer2.changed(r28) ? 32 : 16;
                        }
                        if ((r1 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        final BluetoothDevice bluetoothDevice = (BluetoothDevice) list2.get(r28);
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) composer2.consume(staticProvidableCompositionLocal)).m164getBackground0d7_KjU(), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(8));
                        final Function1 function13 = function12;
                        fillMaxWidth = SizeKt.fillMaxWidth(PaddingKt.m71padding3ABfNKs(ClickableKt.m26clickableXHw0xAI$default(m21backgroundbw27NRU, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$1$1$1
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
                                function13.invoke(bluetoothDevice);
                            }
                        }), 4), 1.0f);
                        composer2.startReplaceableGroup(-483455358);
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth);
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
                            modifierMaterializerOf.invoke((Object) new SkippableUpdater(composer2), (Object) composer2, (Object) 0);
                            composer2.startReplaceableGroup(2058660585);
                            String name = bluetoothDevice.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            TextKt.m216Text4IGK_g(name, null, ((Colors) composer2.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131066);
                            DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                }, true));
            }
        }, startRestartGroup, 24576, 239);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$DeviceList$2
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
                    HeartRateRefDeviceFragment.this.DeviceList(list, function1, composer2, Strings.updateChangedFlags(r19 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void exportCsv() {
        File zip = this.logger.zip();
        if (zip == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(DfuBaseService.MIME_TYPE_ZIP);
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(requireContext(), zip));
        Context context = getContext();
        if (context != null) {
            context.startActivity(Intent.createChooser(intent, "Share CSV"));
        }
    }

    public static final HeartRateRefDeviceFragment newInstance() {
        return Companion.newInstance();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    @SuppressLint({"MissingPermission"})
    public void ComposeContent(Composer composer, final int r83) {
        boolean z;
        ComposerImpl composerImpl;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-824426501);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-1397682618);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        HeartRateDevice heartRateDevice = HeartRateDevice.INSTANCE;
        String str = null;
        MutableState collectAsState = Platform.collectAsState(heartRateDevice.getStateFlow(), HeartRateDevice.State.Inactive, null, startRestartGroup, 2);
        MutableState collectAsState2 = Platform.collectAsState(heartRateDevice.getHeartrateFlow(), 0, null, startRestartGroup, 2);
        MutableState collectAsState3 = Platform.collectAsState(heartRateDevice.getDeviceFlow(), null, null, startRestartGroup, 2);
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        float f = 16;
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(SizeKt.fillMaxWidth(companion, 1.0f), f);
        Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(f);
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
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            if (collectAsState3.getValue() == 0) {
                startRestartGroup.startReplaceableGroup(-110735794);
                Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                Function0<Unit> function0 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$1

                    /* compiled from: HeartRateRefDeviceFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$1$1", f = "HeartRateRefDeviceFragment.kt", l = {}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$1$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ HeartRateRefDeviceFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(HeartRateRefDeviceFragment heartRateRefDeviceFragment, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = heartRateRefDeviceFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.this$0.exportCsv();
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

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
                        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(HeartRateRefDeviceFragment.this);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        BuildersKt.launch$default(lifecycleScope, MainDispatcherLoader.dispatcher, null, new AnonymousClass1(HeartRateRefDeviceFragment.this, null), 2);
                    }
                };
                ComposableSingletons$HeartRateRefDeviceFragmentKt composableSingletons$HeartRateRefDeviceFragmentKt = ComposableSingletons$HeartRateRefDeviceFragmentKt.INSTANCE;
                ButtonKt.Button(function0, fillMaxWidth, false, null, null, null, null, null, null, composableSingletons$HeartRateRefDeviceFragmentKt.m874getLambda1$secondo_kronabyRelease(), startRestartGroup, 805306416, 508);
                ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$2

                    /* compiled from: HeartRateRefDeviceFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$2$1", f = "HeartRateRefDeviceFragment.kt", l = {}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$2$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        int label;
                        final /* synthetic */ HeartRateRefDeviceFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(HeartRateRefDeviceFragment heartRateRefDeviceFragment, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = heartRateRefDeviceFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                            if (this.label == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.this$0.getLogger().clear();
                                ViewKt.toast$default((Fragment) this.this$0, "Cleared!", false, 2, (Object) null);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }
                    }

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
                        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(HeartRateRefDeviceFragment.this);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        BuildersKt.launch$default(lifecycleScope, MainDispatcherLoader.dispatcher, null, new AnonymousClass1(HeartRateRefDeviceFragment.this, null), 2);
                    }
                }, SizeKt.fillMaxWidth(companion, 1.0f), false, null, null, null, null, null, null, composableSingletons$HeartRateRefDeviceFragmentKt.m875getLambda2$secondo_kronabyRelease(), startRestartGroup, 805306416, 508);
                DeviceList(CollectionsKt___CollectionsKt.toList(ConnectionFactory.getConnection().getDevices()), new Function1<BluetoothDevice, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(BluetoothDevice bluetoothDevice) {
                        invoke2(bluetoothDevice);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(BluetoothDevice it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        HeartRateDevice.INSTANCE.setHearRateReferenceDevice(it, HeartRateRefDeviceFragment.this.getLogger());
                        HeartRateRefDeviceFragment.this.getLogger().start();
                    }
                }, startRestartGroup, DfuConstants.UNKNOWN_DFU_15_ERROR);
                z = false;
                startRestartGroup.end(false);
                composerImpl = startRestartGroup;
            } else {
                startRestartGroup.startReplaceableGroup(-110734825);
                StringBuilder sb = new StringBuilder("Device: ");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) collectAsState3.getValue();
                if (bluetoothDevice != null) {
                    str = bluetoothDevice.getName();
                }
                sb.append(str);
                TextKt.m216Text4IGK_g(sb.toString(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
                TextKt.m216Text4IGK_g("State: " + collectAsState.getValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
                TextKt.m216Text4IGK_g("Heart Rate: " + ((Number) collectAsState2.getValue()).intValue(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, startRestartGroup, 0, 0, 131070);
                ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$4

                    /* compiled from: HeartRateRefDeviceFragment.kt */
                    @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$4$1", f = "HeartRateRefDeviceFragment.kt", l = {85}, m = "invokeSuspend")
                    /* renamed from: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$1$4$1, reason: invalid class name */
                    /* loaded from: classes3.dex */
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ MutableState<Boolean> $saveing$delegate;
                        int label;
                        final /* synthetic */ HeartRateRefDeviceFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(HeartRateRefDeviceFragment heartRateRefDeviceFragment, MutableState<Boolean> mutableState, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.this$0 = heartRateRefDeviceFragment;
                            this.$saveing$delegate = mutableState;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.this$0, this.$saveing$delegate, continuation);
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
                                HeartRateRefDeviceFragment.ComposeContent$lambda$2(this.$saveing$delegate, true);
                                HeartRateRefFileSaver logger = this.this$0.getLogger();
                                this.label = 1;
                                if (logger.stop(this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            }
                            HeartRateRefDeviceFragment.ComposeContent$lambda$2(this.$saveing$delegate, false);
                            HeartRateDevice.INSTANCE.inactivate();
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
                        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(HeartRateRefDeviceFragment.this);
                        DefaultScheduler defaultScheduler = Dispatchers.Default;
                        BuildersKt.launch$default(lifecycleScope, MainDispatcherLoader.dispatcher, null, new AnonymousClass1(HeartRateRefDeviceFragment.this, mutableState, null), 2);
                    }
                }, SizeKt.fillMaxWidth(companion, 1.0f), false, null, null, null, null, null, null, ComposableSingletons$HeartRateRefDeviceFragmentKt.INSTANCE.m876getLambda3$secondo_kronabyRelease(), startRestartGroup, 805306416, 508);
                if (ComposeContent$lambda$1(mutableState)) {
                    ProgressIndicatorKt.m195CircularProgressIndicatorLxG7B9w(0.0f, 0, 48, 29, Color.Green, 0L, startRestartGroup, null);
                }
                z = false;
                composerImpl = startRestartGroup;
                composerImpl.end(false);
            }
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(composerImpl, z, true, z, z);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.HeartRateRefDeviceFragment$ComposeContent$2
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
                        HeartRateRefDeviceFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r83 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
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

    public final HeartRateRefFileSaver getLogger() {
        return this.logger;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "HeartRateRefDevice";
    }
}
