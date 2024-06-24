package com.animaconnected.secondo.screens.activity;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.State;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: ActivityGoogleFitFragment.kt */
/* loaded from: classes3.dex */
public final class ActivityGoogleFitFragment extends ComposeFragment {
    private static final String HAS_DETAIL_STYLE_KEY_ID = "hasDetailStyleKeyId";
    private static final String PARENT_NAME_KEY_ID = "parentNameKeyId";
    private boolean hasDetailStyle;
    private String parentName;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final String name = "ActivityGoogleFitFragment";
    private final MutableStateFlow<Boolean> showLoading = StateFlowKt.MutableStateFlow(Boolean.FALSE);

    /* compiled from: ActivityGoogleFitFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment newInstance(boolean z, String str) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(ActivityGoogleFitFragment.HAS_DETAIL_STYLE_KEY_ID, z);
            bundle.putString(ActivityGoogleFitFragment.PARENT_NAME_KEY_ID, str);
            ActivityGoogleFitFragment activityGoogleFitFragment = new ActivityGoogleFitFragment();
            activityGoogleFitFragment.setArguments(bundle);
            return activityGoogleFitFragment;
        }

        private Companion() {
        }
    }

    private static final boolean ComposeContent$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectToGoogleFit() {
        Boolean value;
        MutableStateFlow<Boolean> mutableStateFlow = this.showLoading;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.TRUE));
        ActivityUtilKt.enableGoogleFitAndPresentErrors(this, ProviderFactory.INSTANCE.getGoogleFitProvider(), new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment$connectToGoogleFit$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                MutableStateFlow mutableStateFlow2;
                Object value2;
                mutableStateFlow2 = ActivityGoogleFitFragment.this.showLoading;
                do {
                    value2 = mutableStateFlow2.getValue();
                    ((Boolean) value2).booleanValue();
                } while (!mutableStateFlow2.compareAndSet(value2, Boolean.FALSE));
                if (z) {
                    ActivityGoogleFitFragment.this.gotoNextScreen();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoNextScreen() {
        ProviderFactory.getSettingProvider().setActivityOnboardingCompleted(true);
        getMainController().gotoNextFragment(ActivityFragment.Companion.newInstance(this.hasDetailStyle, this.parentName));
    }

    public static final BaseFragment newInstance(boolean z, String str) {
        return Companion.newInstance(z, str);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r10) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1801223984);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ActivityGoogleFitFragmentKt.GoogleFitSetupScreen(this.hasDetailStyle, ComposeContent$lambda$1(FlowExtKt.collectAsStateWithLifecycle(this.showLoading, startRestartGroup)), new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment$ComposeContent$1
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
                ActivityGoogleFitFragment.this.getMainController().goBack();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment$ComposeContent$2
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
                ActivityGoogleFitFragment.this.gotoNextScreen();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment$ComposeContent$3
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
                ActivityGoogleFitFragment.this.connectToGoogleFit();
            }
        }, startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivityGoogleFitFragment$ComposeContent$4
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
                    ActivityGoogleFitFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r10 | 1));
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

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hasDetailStyle = arguments.getBoolean(HAS_DETAIL_STYLE_KEY_ID);
            this.parentName = arguments.getString(PARENT_NAME_KEY_ID);
        }
    }
}
