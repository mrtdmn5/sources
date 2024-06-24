package com.animaconnected.secondo.behaviour.time;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.AnimatedToolbar;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.details.BaseDetailsFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.animaconnected.watch.Slot;
import com.animaconnected.watch.WatchManager;
import com.animaconnected.watch.behaviour.worldtime.WorldTime;
import com.animaconnected.watch.behaviour.worldtime.WorldTimeViewModel;
import com.google.common.collect.Hashing;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;

/* compiled from: WorldTimeFragment.kt */
/* loaded from: classes3.dex */
public final class WorldTimeFragment extends BaseDetailsFragment {
    public static final int $stable = 8;
    private TextView tvEdit;
    public WorldTimeViewModel viewModel;
    private final WorldTime worldTime = new WorldTime();

    public WorldTimeFragment() {
        setSlot(Slot.Display);
        setType(WorldTime.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void invalidateEditView(boolean z, boolean z2) {
        String string;
        if (!z2) {
            TextView textView = this.tvEdit;
            if (textView != null) {
                ViewKt.gone(textView);
                return;
            }
            return;
        }
        TextView textView2 = this.tvEdit;
        if (textView2 != null) {
            ViewKt.visible(textView2);
        }
        TextView textView3 = this.tvEdit;
        if (textView3 != null) {
            if (z) {
                string = getString(R.string.remember_this_spot_saved_spots_done);
            } else {
                string = getString(R.string.remember_this_spot_saved_spots_edit);
            }
            textView3.setText(string);
        }
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    public final WorldTimeViewModel getViewModel() {
        WorldTimeViewModel worldTimeViewModel = this.viewModel;
        if (worldTimeViewModel != null) {
            return worldTimeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        throw null;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        setViewModel(new WorldTimeViewModel(this.worldTime));
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(requireContext, null, 6);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(2013190577, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r3) {
                if ((r3 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final WorldTimeFragment worldTimeFragment = WorldTimeFragment.this;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, 52998658, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(Composer composer2, int r14) {
                        if ((r14 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        composer2.startReplaceableGroup(870194183);
                        WorldTimeFragment worldTimeFragment2 = WorldTimeFragment.this;
                        Object rememberedValue = composer2.rememberedValue();
                        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
                        if (rememberedValue == composer$Companion$Empty$1) {
                            rememberedValue = worldTimeFragment2.getViewModel();
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        final WorldTimeViewModel worldTimeViewModel = (WorldTimeViewModel) rememberedValue;
                        composer2.endReplaceableGroup();
                        List list = (List) Platform.collectAsState(worldTimeViewModel.getTimeZones(), EmptyList.INSTANCE, null, composer2, 2).getValue();
                        composer2.startReplaceableGroup(773894976);
                        composer2.startReplaceableGroup(-492369756);
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == composer$Companion$Empty$1) {
                            CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue2 = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).coroutineScope;
                        composer2.endReplaceableGroup();
                        WorldTimeViewModel.EditState editState = (WorldTimeViewModel.EditState) Platform.collectAsState(worldTimeViewModel.getEditState(), new WorldTimeViewModel.EditState(false, false), null, composer2, 2).getValue();
                        Function2<String, String, Unit> function2 = new Function2<String, String, Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragment.onCreateView.1.1.1.1

                            /* compiled from: WorldTimeFragment.kt */
                            @DebugMetadata(c = "com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1$1$1$1", f = "WorldTimeFragment.kt", l = {75}, m = "invokeSuspend")
                            /* renamed from: com.animaconnected.secondo.behaviour.time.WorldTimeFragment$onCreateView$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* loaded from: classes3.dex */
                            public static final class C00391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                int label;

                                public C00391(Continuation<? super C00391> continuation) {
                                    super(2, continuation);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00391(continuation);
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
                                        WatchManager watchManager = ProviderFactory.getWatch().getWatchManager();
                                        this.label = 1;
                                        if (watchManager.sync(this) == coroutineSingletons) {
                                            return coroutineSingletons;
                                        }
                                    }
                                    return Unit.INSTANCE;
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                                invoke2(str, str2);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String zoneId, String cityKey) {
                                Intrinsics.checkNotNullParameter(zoneId, "zoneId");
                                Intrinsics.checkNotNullParameter(cityKey, "cityKey");
                                if (WorldTimeViewModel.this.removeTimeZone(zoneId, cityKey)) {
                                    BuildersKt.launch$default(coroutineScope, null, null, new C00391(null), 3);
                                }
                            }
                        };
                        final WorldTimeFragment worldTimeFragment3 = WorldTimeFragment.this;
                        WorldTimeFragmentKt.access$WorldTimeScreen(list, function2, new Function0<Unit>() { // from class: com.animaconnected.secondo.behaviour.time.WorldTimeFragment.onCreateView.1.1.1.2
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
                                MainController mainController;
                                mainController = WorldTimeFragment.this.getMainController();
                                mainController.gotoNextFragment(WorldTimeCitiesFragment.Companion.newInstance());
                            }
                        }, worldTimeViewModel.isAddEnabled(), editState.isEditing(), composer2, 8);
                    }
                }), composer, 6);
            }
        }, true));
        return composeView;
    }

    @Override // com.animaconnected.secondo.screens.details.BaseDetailsFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        View view2;
        AnimatedToolbar animatedToolbar;
        View view3;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        BaseFragment parentBaseFragment = getParentBaseFragment();
        if (parentBaseFragment != null && (view3 = parentBaseFragment.getView()) != null) {
            view2 = view3.findViewById(R.id.animated_toolbar);
        } else {
            view2 = null;
        }
        if (view2 instanceof AnimatedToolbar) {
            animatedToolbar = (AnimatedToolbar) view2;
        } else {
            animatedToolbar = null;
        }
        if (animatedToolbar == null) {
            return;
        }
        TextView enableActionText = animatedToolbar.enableActionText(true);
        enableActionText.setText(getString(R.string.remember_this_spot_saved_spots_edit));
        onClick(enableActionText, new WorldTimeFragment$onViewCreated$1$1(this, null));
        this.tvEdit = enableActionText;
        FlowKt.launchIn(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(new WorldTimeFragment$onViewCreated$2(this, null), getViewModel().getEditState()), Hashing.getLifecycleScope(this));
    }

    public final void setViewModel(WorldTimeViewModel worldTimeViewModel) {
        Intrinsics.checkNotNullParameter(worldTimeViewModel, "<set-?>");
        this.viewModel = worldTimeViewModel;
    }
}
