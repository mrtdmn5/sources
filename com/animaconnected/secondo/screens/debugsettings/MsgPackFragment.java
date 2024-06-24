package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.debugsettings.MsgPackFragment;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: MsgPackFragment.kt */
/* loaded from: classes3.dex */
public final class MsgPackFragment extends ComposeFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final Lazy prefs$delegate = LazyKt__LazyJVMKt.lazy(new Function0<SharedPreferences>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$prefs$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SharedPreferences invoke() {
            return MsgPackFragment.this.requireContext().getSharedPreferences("Msgpack-cmds", 0);
        }
    });
    private final String commandsKey = "commands";

    /* compiled from: MsgPackFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Command {
        private final String args;
        private final String cmd;

        public Command(String cmd, String args) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(args, "args");
            this.cmd = cmd;
            this.args = args;
        }

        public static /* synthetic */ Command copy$default(Command command, String str, String str2, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = command.cmd;
            }
            if ((r3 & 2) != 0) {
                str2 = command.args;
            }
            return command.copy(str, str2);
        }

        public final String component1() {
            return this.cmd;
        }

        public final String component2() {
            return this.args;
        }

        public final Command copy(String cmd, String args) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
            Intrinsics.checkNotNullParameter(args, "args");
            return new Command(cmd, args);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Command)) {
                return false;
            }
            Command command = (Command) obj;
            if (Intrinsics.areEqual(this.cmd, command.cmd) && Intrinsics.areEqual(this.args, command.args)) {
                return true;
            }
            return false;
        }

        public final String getArgs() {
            return this.args;
        }

        public final String getCmd() {
            return this.cmd;
        }

        public int hashCode() {
            return this.args.hashCode() + (this.cmd.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Command(cmd=");
            sb.append(this.cmd);
            sb.append(", args=");
            return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.args, ')');
        }
    }

    /* compiled from: MsgPackFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MsgPackFragment newInstance() {
            return new MsgPackFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void CommandList(final List<Command> list, final Function1<? super Command, Unit> function1, final Function1<? super Command, Unit> function12, Composer composer, final int r21) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(413825669);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyDslKt.LazyColumn(null, null, null, false, Arrangement.m60spacedBy0680j_4(4), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1
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

            /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<MsgPackFragment.Command> list2 = list;
                final Function1<MsgPackFragment.Command, Unit> function13 = function12;
                final Function1<MsgPackFragment.Command, Unit> function14 = function1;
                final MsgPackFragment$CommandList$1$invoke$$inlined$items$default$1 msgPackFragment$CommandList$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(MsgPackFragment.Command command) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((MsgPackFragment.Command) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$invoke$$inlined$items$default$3
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$1$invoke$$inlined$items$default$4
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
                        int r12 = r1 & 14;
                        MsgPackFragment.Command command = (MsgPackFragment.Command) list2.get(r28);
                        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
                        ProvidableCompositionLocal providableCompositionLocal = ColorsKt.LocalColors;
                        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) composer2.consume(providableCompositionLocal)).m164getBackground0d7_KjU(), RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(8));
                        composer2.startReplaceableGroup(-314074644);
                        boolean changedInstance = ((((r12 & 112) ^ 48) > 32 && composer2.changed(command)) || (r12 & 48) == 32) | composer2.changedInstance(function13) | composer2.changedInstance(function14);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changedInstance || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new MsgPackFragment$CommandList$1$1$1$1(function13, command, function14, null);
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        fillMaxWidth = SizeKt.fillMaxWidth(PaddingKt.m71padding3ABfNKs(SuspendingPointerInputFilterKt.pointerInput(m21backgroundbw27NRU, command, (Function2) rememberedValue), 16), 1.0f);
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
                            TextKt.m216Text4IGK_g(command.getCmd() + ": " + command.getArgs(), null, ((Colors) composer2.consume(providableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131066);
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
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$CommandList$2
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
                    MsgPackFragment.this.CommandList(list, function1, function12, composer2, Strings.updateChangedFlags(r21 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ComposeContent$lambda$1(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ComposeContent$lambda$10(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$11(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ComposeContent$lambda$4(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ComposeContent$lambda$7(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void HelpIcon(Composer composer, final int r18) {
        ColorFilter porterDuffColorFilter;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1202018464);
        if ((r18 & 1) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(1216762997);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
                startRestartGroup.updateValue(nextSlot);
            }
            final MutableState mutableState = (MutableState) nextSlot;
            startRestartGroup.end(false);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_about, startRestartGroup);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            startRestartGroup.startReplaceableGroup(1216763195);
            Object nextSlot2 = startRestartGroup.nextSlot();
            if (nextSlot2 == composer$Companion$Empty$1) {
                nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$HelpIcon$1$1
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
                        MsgPackFragment.HelpIcon$lambda$21(mutableState, true);
                    }
                };
                startRestartGroup.updateValue(nextSlot2);
            }
            startRestartGroup.end(false);
            Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(companion, (Function0) nextSlot2);
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU();
            if (Build.VERSION.SDK_INT >= 29) {
                porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m166getOnBackground0d7_KjU, 5);
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m166getOnBackground0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
            }
            ImageKt.Image(painterResource, "Help", m26clickableXHw0xAI$default, null, null, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), startRestartGroup, 56, 56);
            if (HelpIcon$lambda$20(mutableState)) {
                startRestartGroup.startReplaceableGroup(1216763366);
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$HelpIcon$2$1
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
                            MsgPackFragment.HelpIcon$lambda$21(mutableState, false);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                startRestartGroup.end(false);
                AndroidDialog_androidKt.Dialog((Function0) nextSlot3, null, ComposableSingletons$MsgPackFragmentKt.INSTANCE.m879getLambda3$secondo_kronabyRelease(), startRestartGroup, 390, 2);
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$HelpIcon$3
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
                    MsgPackFragment.this.HelpIcon(composer2, Strings.updateChangedFlags(r18 | 1));
                }
            };
        }
    }

    private static final boolean HelpIcon$lambda$20(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void HelpIcon$lambda$21(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$2, kotlin.jvm.internal.Lambda] */
    public final void TextButton(final RowScope rowScope, final String str, final Function1<? super Continuation<? super Unit>, ? extends Object> function1, Composer composer, final int r23) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1319871828);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ButtonKt.Button(new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$1

            /* compiled from: MsgPackFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$1$1", f = "MsgPackFragment.kt", l = {107}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onClickSuspended;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$onClickSuspended = function1;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$onClickSuspended, continuation);
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
                        Function1<Continuation<? super Unit>, Object> function1 = this.$onClickSuspended;
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
                BuildersKt.launch$default(Hashing.getLifecycleScope(MsgPackFragment.this), null, null, new AnonymousClass1(function1, null), 3);
            }
        }, rowScope.weight(Modifier.Companion.$$INSTANCE, 1.0f, true), false, null, null, null, null, null, null, ComposableLambdaKt.composableLambda(startRestartGroup, -398333628, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope2, Composer composer2, Integer num) {
                invoke(rowScope2, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(RowScope Button, Composer composer2, int r29) {
                Intrinsics.checkNotNullParameter(Button, "$this$Button");
                if ((r29 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    TextKt.m216Text4IGK_g(str, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                }
            }
        }), startRestartGroup, 805306368, 508);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$TextButton$3
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
                    MsgPackFragment.this.TextButton(rowScope, str, function1, composer2, Strings.updateChangedFlags(r23 | 1));
                }
            };
        }
    }

    private final SharedPreferences getPrefs() {
        Object value = this.prefs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    public static final MsgPackFragment newInstance() {
        return Companion.newInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object read(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super java.lang.String> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$read$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$read$1 r0 = (com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$read$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$read$1 r0 = new com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$read$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.throwOnFailure(r7)
            goto L50
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchProvider r7 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.WatchManager r7 = r7.getWatchManager()
            com.animaconnected.watch.Watch r7 = r7.getCurrentWatch()
            com.animaconnected.watch.device.WatchIODebug r7 = r7.getDebugIo()
            if (r7 != 0) goto L47
            java.lang.String r5 = "No debug device"
            return r5
        L47:
            r0.label = r3
            java.lang.Object r7 = r7.readValues(r5, r6, r0)
            if (r7 != r1) goto L50
            return r1
        L50:
            com.animaconnected.watch.utils.WatchLibResult r7 = (com.animaconnected.watch.utils.WatchLibResult) r7
            boolean r5 = r7 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r5 == 0) goto L5f
            com.animaconnected.watch.utils.WatchLibResult$Success r7 = (com.animaconnected.watch.utils.WatchLibResult.Success) r7
            java.lang.Object r5 = r7.getSuccess()
            java.lang.String r5 = (java.lang.String) r5
            goto L74
        L5f:
            boolean r5 = r7 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r5 == 0) goto L75
            com.animaconnected.watch.utils.WatchLibResult$Failure r7 = (com.animaconnected.watch.utils.WatchLibResult.Failure) r7
            java.lang.Throwable r5 = r7.getFailure()
            java.lang.Exception r5 = (java.lang.Exception) r5
            java.lang.String r5 = r5.getLocalizedMessage()
            java.lang.String r6 = "getLocalizedMessage(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
        L74:
            return r5
        L75:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment.read(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"CommitPrefEdits"})
    public final void save(List<Command> list) {
        getPrefs().edit().putString(this.commandsKey, new Gson().toJson(list)).apply();
    }

    private final ArrayList<Command> storedData() {
        ArrayList<Command> arrayList;
        String string = getPrefs().getString(this.commandsKey, "");
        if (string != null) {
            arrayList = (ArrayList) new Gson().fromJson(string, new TypeToken<ArrayList<Command>>() { // from class: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$storedData$1$1
            }.getType());
        } else {
            arrayList = null;
        }
        if (arrayList == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object write(java.lang.String r5, java.lang.String r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$write$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$write$1 r0 = (com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$write$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$write$1 r0 = new com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$write$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r5 = r0.L$0
            com.animaconnected.secondo.screens.debugsettings.MsgPackFragment r5 = (com.animaconnected.secondo.screens.debugsettings.MsgPackFragment) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L57
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchProvider r7 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.watch.WatchManager r7 = r7.getWatchManager()
            com.animaconnected.watch.Watch r7 = r7.getCurrentWatch()
            com.animaconnected.watch.device.WatchIODebug r7 = r7.getDebugIo()
            if (r7 != 0) goto L4b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L4b:
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r7 = r7.writeValues(r5, r6, r0)
            if (r7 != r1) goto L56
            return r1
        L56:
            r5 = r4
        L57:
            com.animaconnected.watch.utils.WatchLibResult r7 = (com.animaconnected.watch.utils.WatchLibResult) r7
            boolean r6 = r7 instanceof com.animaconnected.watch.utils.WatchLibResult.Success
            if (r6 == 0) goto L60
            java.lang.String r6 = "Success"
            goto L7e
        L60:
            boolean r6 = r7 instanceof com.animaconnected.watch.utils.WatchLibResult.Failure
            if (r6 == 0) goto L8c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "Fail: "
            r6.<init>(r0)
            com.animaconnected.watch.utils.WatchLibResult$Failure r7 = (com.animaconnected.watch.utils.WatchLibResult.Failure) r7
            java.lang.Throwable r7 = r7.getFailure()
            java.lang.Exception r7 = (java.lang.Exception) r7
            java.lang.String r7 = r7.getLocalizedMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
        L7e:
            android.content.Context r5 = r5.getContext()
            android.widget.Toast r5 = android.widget.Toast.makeText(r5, r6, r3)
            r5.show()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L8c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment.write(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0101, code lost:            if (kotlin.jvm.internal.Intrinsics.areEqual(r6.nextSlot(), java.lang.Integer.valueOf(r12)) == false) goto L29;     */
    /* JADX WARN: Type inference failed for: r0v35, types: [com.animaconnected.secondo.screens.debugsettings.MsgPackFragment$ComposeContent$1$4, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ComposeContent(androidx.compose.runtime.Composer r42, final int r43) {
        /*
            Method dump skipped, instructions count: 823
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.debugsettings.MsgPackFragment.ComposeContent(androidx.compose.runtime.Composer, int):void");
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
        return "MsgPack";
    }
}
