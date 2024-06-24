package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.CallStateListener;
import com.animaconnected.secondo.provider.CallStateReceiver;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.watch.DisplayWatch;
import com.animaconnected.watch.DisplayWatchJvm;
import com.animaconnected.watch.Watch;
import com.animaconnected.watch.device.CallState;
import com.animaconnected.widget.theme.ComposeThemeProvider;
import com.animaconnected.widget.theme.ThemeKt;
import com.google.common.base.Strings;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugCallNotificationsFragment.kt */
/* loaded from: classes3.dex */
public final class DebugCallNotificationsFragment extends ComposeFragment implements CallStateListener {
    public static final int $stable = 8;
    private final String name = "DebugCallNotifications";
    private final Lazy watch$delegate = LazyKt__LazyJVMKt.lazy(new Function0<DisplayWatch>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$watch$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DisplayWatch invoke() {
            Watch watch = ProviderFactory.getWatch().getWatch();
            Intrinsics.checkNotNull(watch, "null cannot be cast to non-null type com.animaconnected.watch.DisplayWatch");
            return (DisplayWatch) watch;
        }
    });
    private final Lazy callStateProvider$delegate = LazyKt__LazyJVMKt.lazy(new Function0<CallStateReceiver>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$callStateProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final CallStateReceiver invoke() {
            return ProviderFactory.INSTANCE.getCallStateReceiver();
        }
    });
    private final MutableState<Pair<CallState, String>> callMutableState = Platform.mutableStateOf$default(new Pair(CallState.Idle, "unknown"));
    private final MutableState<Boolean> useCallManager = Platform.mutableStateOf$default(Boolean.FALSE);

    /* JADX INFO: Access modifiers changed from: private */
    public final void CallControl(final MutableState<Pair<CallState, String>> mutableState, final MutableState<Boolean> mutableState2, final MutableState<Boolean> mutableState3, final Function0<Unit> function0, Composer composer, final int r17) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(2117593814);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        CardKt.m162CardFjzlyU(null, null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -1936433069, new DebugCallNotificationsFragment$CallControl$1(mutableState.getValue(), mutableState, function0, mutableState2, mutableState3, this)), startRestartGroup, 1572864, 63);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$CallControl$2
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
                    DebugCallNotificationsFragment.this.CallControl(mutableState, mutableState2, mutableState3, function0, composer2, Strings.updateChangedFlags(r17 | 1));
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<CallState, String> ComposeContent$lambda$1(MutableState<Pair<CallState, String>> mutableState) {
        return mutableState.getValue();
    }

    private final CallStateReceiver getCallStateProvider() {
        return (CallStateReceiver) this.callStateProvider$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DisplayWatch getWatch() {
        return (DisplayWatch) this.watch$delegate.getValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$AllTextSwitch$1, kotlin.jvm.internal.Lambda] */
    @SuppressLint({"UnrememberedMutableState"})
    public final void AllTextSwitch(final ComposeThemeProvider previewProvider, Composer composer, final int r5) {
        Intrinsics.checkNotNullParameter(previewProvider, "previewProvider");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1133243388);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ThemeKt.BrandTheme(previewProvider, ComposableLambdaKt.composableLambda(startRestartGroup, 1402492148, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$AllTextSwitch$1
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
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    DebugCallNotificationsFragment.this.CallControl(Platform.mutableStateOf$default(new Pair(CallState.Idle, "unknown")), Platform.mutableStateOf$default(Boolean.FALSE), Platform.mutableStateOf$default(Boolean.TRUE), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$AllTextSwitch$1.1
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }, composer2, 35840);
                }
            }
        }), startRestartGroup, 56);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$AllTextSwitch$2
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
                    DebugCallNotificationsFragment.this.AllTextSwitch(previewProvider, composer2, Strings.updateChangedFlags(r5 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r10) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(828599547);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(1079245775);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = this.callMutableState;
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1079245829);
        if (m == composer$Companion$Empty$1) {
            m = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(m);
        }
        final MutableState<Boolean> mutableState2 = (MutableState) m;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 1079245885);
        if (m2 == composer$Companion$Empty$1) {
            m2 = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(m2);
        }
        final MutableState<Boolean> mutableState3 = (MutableState) m2;
        startRestartGroup.end(false);
        CallControl(this.callMutableState, mutableState2, mutableState3, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$ComposeContent$1

            /* compiled from: DebugCallNotificationsFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$ComposeContent$1$1", f = "DebugCallNotificationsFragment.kt", l = {67}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$ComposeContent$1$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableState<Pair<CallState, String>> $callInfo$delegate;
                final /* synthetic */ MutableState<Boolean> $canAnswer;
                final /* synthetic */ MutableState<Boolean> $canEnd;
                int label;
                final /* synthetic */ DebugCallNotificationsFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(DebugCallNotificationsFragment debugCallNotificationsFragment, MutableState<Boolean> mutableState, MutableState<Boolean> mutableState2, MutableState<Pair<CallState, String>> mutableState3, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = debugCallNotificationsFragment;
                    this.$canAnswer = mutableState;
                    this.$canEnd = mutableState2;
                    this.$callInfo$delegate = mutableState3;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, this.$canAnswer, this.$canEnd, this.$callInfo$delegate, continuation);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    DisplayWatch watch;
                    Pair ComposeContent$lambda$1;
                    Pair ComposeContent$lambda$12;
                    Pair ComposeContent$lambda$13;
                    Pair ComposeContent$lambda$14;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
                    int r2 = this.label;
                    try {
                        if (r2 != 0) {
                            if (r2 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        } else {
                            ResultKt.throwOnFailure(obj);
                            watch = this.this$0.getWatch();
                            ComposeContent$lambda$1 = DebugCallNotificationsFragment.ComposeContent$lambda$1(this.$callInfo$delegate);
                            CallState callState = (CallState) ComposeContent$lambda$1.first;
                            ComposeContent$lambda$12 = DebugCallNotificationsFragment.ComposeContent$lambda$1(this.$callInfo$delegate);
                            String str = (String) ComposeContent$lambda$12.second;
                            boolean booleanValue = this.$canAnswer.getValue().booleanValue();
                            boolean booleanValue2 = this.$canEnd.getValue().booleanValue();
                            this.label = 1;
                            if (DisplayWatchJvm.setCallStatus(watch, 0, callState, str, booleanValue, booleanValue2, this) == coroutineSingletons) {
                                return coroutineSingletons;
                            }
                        }
                        DebugCallNotificationsFragment debugCallNotificationsFragment = this.this$0;
                        StringBuilder sb = new StringBuilder("Sending call with state ");
                        ComposeContent$lambda$13 = DebugCallNotificationsFragment.ComposeContent$lambda$1(this.$callInfo$delegate);
                        sb.append(ComposeContent$lambda$13.first);
                        sb.append(" and caller ");
                        ComposeContent$lambda$14 = DebugCallNotificationsFragment.ComposeContent$lambda$1(this.$callInfo$delegate);
                        sb.append((String) ComposeContent$lambda$14.second);
                        sb.append(". canAnswer = ");
                        sb.append(this.$canAnswer.getValue().booleanValue());
                        sb.append(", canEnd = ");
                        sb.append(this.$canEnd.getValue().booleanValue());
                        ViewKt.toast$default((Fragment) debugCallNotificationsFragment, sb.toString(), false, 2, (Object) null);
                    } catch (Exception e) {
                        ViewKt.toast$default((Fragment) this.this$0, Model$$ExternalSyntheticOutline0.m("Error: ", e), false, 2, (Object) null);
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
                BuildersKt.launch$default(Hashing.getLifecycleScope(DebugCallNotificationsFragment.this), null, null, new AnonymousClass1(DebugCallNotificationsFragment.this, mutableState2, mutableState3, mutableState, null), 3);
            }
        }, startRestartGroup, 33200);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.debugsettings.DebugCallNotificationsFragment$ComposeContent$2
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
                    DebugCallNotificationsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r10 | 1));
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

    @Override // com.animaconnected.secondo.provider.CallStateListener
    public void onCallStateChanged(CallState state, String number) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(number, "number");
        if (this.useCallManager.getValue().booleanValue()) {
            this.callMutableState.setValue(new Pair<>(state, number));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getCallStateProvider().addListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getCallStateProvider().removeListener(this);
    }
}
