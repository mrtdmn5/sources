package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.content.Context;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.pager.LazyLayoutPagerKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.BottomSheetScaffoldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.ModalBottomSheetKt;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.StateListIterator;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.notification.receiver.NotificationUtil;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.onboarding.OnboardingPermissionKt;
import com.animaconnected.secondo.screens.onboarding.PermissionState;
import com.animaconnected.secondo.screens.onboarding.permissions.SmsPermissionFragmentKt;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.CallsTextComponentsKt;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.Filter;
import com.animaconnected.watch.filter.FilterSettings;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import java.util.ListIterator;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: TextsFragment.kt */
/* loaded from: classes3.dex */
public final class TextsFragment extends ComposeFragment {
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "TextsFragment";
    private final DisplayNotificationViewModel viewModel = new DisplayNotificationViewModel();
    private final MutableStateFlow<PermissionState> permissionState = StateFlowKt.MutableStateFlow(PermissionState.Idle.INSTANCE);

    /* compiled from: TextsFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isBadgeVisible() {
            if (!OnboardingPermissionKt.arePermissionsGranted(SmsPermissionFragmentKt.getSmsPermissions()) && ProviderFactory.getWatch().getWatchManager().getFilterSettings().getTextsFilter() != FilterSettings.Allowed.None) {
                return true;
            }
            return false;
        }

        public final TextsFragment newInstance() {
            return new TextsFragment();
        }

        private Companion() {
        }
    }

    private static final SnapshotStateList<Filter> ComposeContent$lambda$10(State<SnapshotStateList<Filter>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ComposeContent$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ComposeContent$lambda$3(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PermissionState checkPermissions() {
        if (OnboardingPermissionKt.arePermissionsGranted(SmsPermissionFragmentKt.getSmsPermissions())) {
            return PermissionState.Granted.INSTANCE;
        }
        return PermissionState.Denied.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$4, kotlin.jvm.internal.Lambda] */
    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r19) {
        boolean z;
        Context context;
        ModalBottomSheetState modalBottomSheetState;
        boolean z2;
        Object obj;
        Filter filter;
        boolean z3;
        ComposerImpl startRestartGroup = composer.startRestartGroup(374029014);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Context context2 = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.LocalContext);
        ModalBottomSheetState rememberModalBottomSheetState = ModalBottomSheetKt.rememberModalBottomSheetState(ModalBottomSheetValue.Hidden, false, startRestartGroup, 14);
        startRestartGroup.startReplaceableGroup(-145140374);
        Object nextSlot = startRestartGroup.nextSlot();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (nextSlot == composer$Companion$Empty$1) {
            nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
            startRestartGroup.updateValue(nextSlot);
        }
        final MutableState mutableState = (MutableState) nextSlot;
        startRestartGroup.end(false);
        FilterSettings.Allowed allowed = (FilterSettings.Allowed) Platform.collectAsState(this.viewModel.getMessageFilter(), startRestartGroup).getValue();
        PermissionState permissionState = (PermissionState) Platform.collectAsState(this.permissionState, startRestartGroup).getValue();
        Object m = BottomSheetScaffoldKt$$ExternalSyntheticOutline0.m(startRestartGroup, 773894976, -492369756);
        if (m == composer$Companion$Empty$1) {
            m = LazyLayoutPagerKt$$ExternalSyntheticOutline0.m(EffectsKt.createCompositionCoroutineScope(startRestartGroup), startRestartGroup);
        }
        startRestartGroup.end(false);
        final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) m).coroutineScope;
        startRestartGroup.end(false);
        if (Intrinsics.areEqual(permissionState, PermissionState.Denied.INSTANCE) && allowed != FilterSettings.Allowed.None) {
            z = true;
        } else {
            z = false;
        }
        ComposeContent$lambda$3(mutableState, z);
        startRestartGroup.startReplaceableGroup(-145140016);
        Object nextSlot2 = startRestartGroup.nextSlot();
        if (nextSlot2 == composer$Companion$Empty$1) {
            String string = getString(R.string.filtered_notifications_preference_title_everyone);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String string2 = getString(R.string.filtered_notifications_preference_subtitle_texts_everyone);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            nextSlot2 = new Filter(string, string2, FilterSettings.Allowed.All, ComposeContent$lambda$2(mutableState));
            startRestartGroup.updateValue(nextSlot2);
        }
        final Filter filter2 = (Filter) nextSlot2;
        Object m2 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -145139640);
        if (m2 == composer$Companion$Empty$1) {
            String string3 = getString(R.string.filtered_notifications_preference_title_known_contacts);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = getString(R.string.filtered_notifications_preference_subtitle_texts_known_contacts);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            m2 = new Filter(string3, string4, FilterSettings.Allowed.Known, ComposeContent$lambda$2(mutableState));
            startRestartGroup.updateValue(m2);
        }
        final Filter filter3 = (Filter) m2;
        Object m3 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -145139246);
        if (m3 == composer$Companion$Empty$1) {
            String string5 = getString(R.string.filtered_notifications_preference_title_phone_favourites);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            String string6 = getString(R.string.filtered_notifications_preference_subtitle_texts_phone_favourites);
            Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
            m3 = new Filter(string5, string6, FilterSettings.Allowed.Favourites, ComposeContent$lambda$2(mutableState));
            startRestartGroup.updateValue(m3);
        }
        final Filter filter4 = (Filter) m3;
        Object m4 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -145138843);
        if (m4 == composer$Companion$Empty$1) {
            String string7 = getString(R.string.filtered_notifications_important_contacts);
            Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
            String string8 = getString(R.string.filtered_notifications_preference_subtitle_texts_important);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            context = context2;
            m4 = new Filter(string7, string8, FilterSettings.Allowed.Important, ComposeContent$lambda$2(mutableState));
            startRestartGroup.updateValue(m4);
        } else {
            context = context2;
        }
        final Filter filter5 = (Filter) m4;
        Object m5 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, -145138468);
        if (m5 == composer$Companion$Empty$1) {
            String string9 = getString(R.string.filtered_notifications_preference_title_none);
            Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
            String string10 = getString(R.string.filtered_notifications_preference_subtitle_texts_none);
            Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
            modalBottomSheetState = rememberModalBottomSheetState;
            z2 = false;
            m5 = new Filter(string9, string10, FilterSettings.Allowed.None, false);
            startRestartGroup.updateValue(m5);
        } else {
            modalBottomSheetState = rememberModalBottomSheetState;
            z2 = false;
        }
        final Filter filter6 = (Filter) m5;
        Object m6 = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, z2, -145138105);
        if (m6 == composer$Companion$Empty$1) {
            m6 = Platform.derivedStateOf(new Function0<SnapshotStateList<Filter>>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$filters$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final SnapshotStateList<Filter> invoke() {
                    boolean ComposeContent$lambda$2;
                    boolean ComposeContent$lambda$22;
                    boolean ComposeContent$lambda$23;
                    boolean ComposeContent$lambda$24;
                    Filter filter7 = Filter.this;
                    ComposeContent$lambda$2 = TextsFragment.ComposeContent$lambda$2(mutableState);
                    Filter copy$default = Filter.copy$default(filter7, null, null, null, ComposeContent$lambda$2, 7, null);
                    Filter filter8 = filter3;
                    ComposeContent$lambda$22 = TextsFragment.ComposeContent$lambda$2(mutableState);
                    Filter copy$default2 = Filter.copy$default(filter8, null, null, null, ComposeContent$lambda$22, 7, null);
                    Filter filter9 = filter4;
                    ComposeContent$lambda$23 = TextsFragment.ComposeContent$lambda$2(mutableState);
                    Filter copy$default3 = Filter.copy$default(filter9, null, null, null, ComposeContent$lambda$23, 7, null);
                    Filter filter10 = filter5;
                    ComposeContent$lambda$24 = TextsFragment.ComposeContent$lambda$2(mutableState);
                    return Platform.mutableStateListOf(copy$default, copy$default2, copy$default3, Filter.copy$default(filter10, null, null, null, ComposeContent$lambda$24, 7, null), filter6);
                }
            });
            startRestartGroup.updateValue(m6);
        }
        State state = (State) m6;
        startRestartGroup.end(false);
        SnapshotStateList<Filter> ComposeContent$lambda$10 = ComposeContent$lambda$10(state);
        ListIterator<Filter> listIterator = ComposeContent$lambda$10(state).listIterator();
        while (true) {
            StateListIterator stateListIterator = (StateListIterator) listIterator;
            if (stateListIterator.hasNext()) {
                obj = stateListIterator.next();
                if (((Filter) obj).getAllowed() == allowed) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        Filter filter7 = (Filter) obj;
        if (filter7 == null) {
            filter = filter6;
        } else {
            filter = filter7;
        }
        String string11 = getString(R.string.filtered_notifications_texts_title);
        Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
        final ModalBottomSheetState modalBottomSheetState2 = modalBottomSheetState;
        final Context context3 = context;
        CallsTextComponentsKt.CallsTextScreen(ComposeContent$lambda$10, filter, string11, R.drawable.ic_all_texts, modalBottomSheetState2, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$2
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
                TextsFragment.this.getMainController().goBack();
            }
        }, new Function1<Filter, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$3

            /* compiled from: TextsFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$3$1", f = "TextsFragment.kt", l = {116}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$3$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$sheetState = modalBottomSheetState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.show(this) == coroutineSingletons) {
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
            public /* bridge */ /* synthetic */ Unit invoke(Filter filter8) {
                invoke2(filter8);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Filter filter8) {
                DisplayNotificationViewModel displayNotificationViewModel;
                PermissionState checkPermissions;
                Intrinsics.checkNotNullParameter(filter8, "filter");
                displayNotificationViewModel = TextsFragment.this.viewModel;
                displayNotificationViewModel.setMessagesFilter(filter8.getAllowed());
                checkPermissions = TextsFragment.this.checkPermissions();
                boolean areEqual = Intrinsics.areEqual(checkPermissions, PermissionState.Denied.INSTANCE);
                boolean z4 = filter8.getAllowed() != FilterSettings.Allowed.None;
                if (areEqual && z4) {
                    BuildersKt.launch$default(coroutineScope, null, null, new AnonymousClass1(modalBottomSheetState2, null), 3);
                }
            }
        }, ComposableLambdaKt.composableLambda(startRestartGroup, -376799198, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$4

            /* compiled from: TextsFragment.kt */
            @DebugMetadata(c = "com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$4$1", f = "TextsFragment.kt", l = {122}, m = "invokeSuspend")
            /* renamed from: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$4$1, reason: invalid class name */
            /* loaded from: classes3.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
                final /* synthetic */ Context $context;
                final /* synthetic */ ModalBottomSheetState $sheetState;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Context context, Continuation<? super AnonymousClass1> continuation) {
                    super(1, continuation);
                    this.$sheetState = modalBottomSheetState;
                    this.$context = context;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Continuation<?> continuation) {
                    return new AnonymousClass1(this.$sheetState, this.$context, continuation);
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
                        ModalBottomSheetState modalBottomSheetState = this.$sheetState;
                        this.label = 1;
                        if (modalBottomSheetState.hide(this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                    NotificationUtil.INSTANCE.openNotificationAccess(this.$context);
                    return Unit.INSTANCE;
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer2, Integer num) {
                invoke(columnScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(ColumnScope CallsTextScreen, Composer composer2, int r6) {
                Intrinsics.checkNotNullParameter(CallsTextScreen, "$this$CallsTextScreen");
                if ((r6 & 81) == 16 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                } else {
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    CallsTextComponentsKt.FeatureIssueDialog(SmsPermissionFragmentKt.getSmsPermissions(), new AnonymousClass1(ModalBottomSheetState.this, context3, null), composer2, 72);
                }
            }
        }), startRestartGroup, 12618752, 0);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextsFragment$ComposeContent$5
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
                    TextsFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r19 | 1));
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

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        MutableStateFlow<PermissionState> mutableStateFlow = this.permissionState;
        do {
        } while (!mutableStateFlow.compareAndSet(mutableStateFlow.getValue(), checkPermissions()));
    }
}
