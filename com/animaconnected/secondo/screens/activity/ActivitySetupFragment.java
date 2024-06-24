package com.animaconnected.secondo.screens.activity;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.res.Resources_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.secondo.screens.MainController;
import com.animaconnected.secondo.screens.activity.ActivityGoalFragment;
import com.animaconnected.secondo.screens.watch.HideWatchLayouter;
import com.animaconnected.secondo.screens.watch.WatchViewLayouter;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivitySetupFragment.kt */
/* loaded from: classes3.dex */
public final class ActivitySetupFragment extends ComposeFragment implements WatchViewLayouter {
    private static final String HAS_DETAIL_STYLE_KEY_ID = "hasDetailStyleKeyId";
    private static final String PARENT_NAME_KEY_ID = "parentNameKeyId";
    private boolean hasDetailStyle;
    private String parentFragmentName;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private final /* synthetic */ HideWatchLayouter $$delegate_0 = new HideWatchLayouter(1);
    private final String name = "ActivitySetupFragment";

    /* compiled from: ActivitySetupFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ActivitySetupFragment newInstance(boolean z, String str) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(ActivitySetupFragment.HAS_DETAIL_STYLE_KEY_ID, z);
            bundle.putString(ActivitySetupFragment.PARENT_NAME_KEY_ID, str);
            ActivitySetupFragment activitySetupFragment = new ActivitySetupFragment();
            activitySetupFragment.setArguments(bundle);
            return activitySetupFragment;
        }

        private Companion() {
        }
    }

    public static final ActivitySetupFragment newInstance(boolean z, String str) {
        return Companion.newInstance(z, str);
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r9) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1894916176);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        startRestartGroup.startReplaceableGroup(-2146689277);
        Object nextSlot = startRestartGroup.nextSlot();
        if (nextSlot == Composer.Companion.Empty) {
            nextSlot = new StepFormatHelper(Locale.getDefault());
            startRestartGroup.updateValue(nextSlot);
        }
        startRestartGroup.end(false);
        String hundredPercent = ((StepFormatHelper) nextSlot).getHundredPercent();
        Intrinsics.checkNotNullExpressionValue(hundredPercent, "getHundredPercent(...)");
        String string = Resources_androidKt.resources(startRestartGroup).getString(R.string.activity_activate_description, Arrays.copyOf(new Object[]{hundredPercent}, 1));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(id, *formatArgs)");
        ActivitySetupFragmentKt.access$ActivitySetupScreen(string, this.hasDetailStyle, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragment$ComposeContent$1
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
                ActivitySetupFragment.this.getMainController().goBack();
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragment$ComposeContent$2
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
                boolean z;
                MainController mainController = ActivitySetupFragment.this.getMainController();
                ActivityGoalFragment.Companion companion = ActivityGoalFragment.Companion;
                z = ActivitySetupFragment.this.hasDetailStyle;
                mainController.gotoNextFragment(companion.newInstance(z, ActivitySetupFragment.this.getParentFragmentName(), true));
            }
        }, startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.activity.ActivitySetupFragment$ComposeContent$3
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
                    ActivitySetupFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r9 | 1));
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

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getParentFragmentName() {
        return this.parentFragmentName;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r2, int r3, int r4, int r5) {
        return this.$$delegate_0.getWatchOffset(r2, r3, r4, r5);
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int hideWatch() {
        return this.$$delegate_0.hideWatch();
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.hasDetailStyle = arguments.getBoolean(HAS_DETAIL_STYLE_KEY_ID);
            setParentFragmentName(arguments.getString(PARENT_NAME_KEY_ID));
        }
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewLayouted() {
        this.$$delegate_0.onWatchViewLayouted();
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public void onWatchViewUpdated(int r2) {
        this.$$delegate_0.onWatchViewUpdated(r2);
    }

    public void setParentFragmentName(String str) {
        this.parentFragmentName = str;
    }

    @Override // com.animaconnected.secondo.screens.watch.WatchViewLayouter
    public int[] getWatchOffset(int r7, int r8, int r9, int r10, int r11) {
        return this.$$delegate_0.getWatchOffset(r7, r8, r9, r10, r11);
    }
}
