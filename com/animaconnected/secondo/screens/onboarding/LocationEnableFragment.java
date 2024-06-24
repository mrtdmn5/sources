package com.animaconnected.secondo.screens.onboarding;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.activity.result.ActivityResult;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.widget.ButtonFilledKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocationEnableFragment.kt */
/* loaded from: classes3.dex */
public final class LocationEnableFragment extends ComposeOnboardingFragment {
    public static final int $stable = 8;
    private LocationEnableFragment$locationChangedBroadcastReceiver$1 locationChangedBroadcastReceiver = new BroadcastReceiver() { // from class: com.animaconnected.secondo.screens.onboarding.LocationEnableFragment$locationChangedBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            LocationEnableFragment.this.onLocationChanged();
        }
    };
    private final String name = "Location enabling fragment";

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLocationChanged() {
        if (getOnboarding().isLocationEnabled()) {
            getOnboarding().onLocationEnabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openSettings() {
        getActivityLauncher().launch(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.LocationEnableFragment$openSettings$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LocationEnableFragment.this.onLocationChanged();
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r82) {
        boolean z;
        ComposerImpl startRestartGroup = composer.startRestartGroup(409354894);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        float f = 56;
        float f2 = 32;
        Modifier m74paddingqDBjuR0 = PaddingKt.m74paddingqDBjuR0(companion, f2, f, f2, f);
        BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m74paddingqDBjuR0);
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
            String string = getString(R.string.onboarding_permission_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
            TextKt.m216Text4IGK_g(string, null, m166getOnBackground0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h1, startRestartGroup, 0, 0, 65530);
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.location_hint, startRestartGroup), "Location hint", PaddingKt.m71padding3ABfNKs(companion, 24), null, ContentScale.Companion.Inside, 0.0f, null, startRestartGroup, 25016, 104);
            String string2 = getString(R.string.onboarding_location_needed);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            TextKt.m216Text4IGK_g(string2, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 0, 0, 65530);
            SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, 16), startRestartGroup, 6);
            String string3 = getString(R.string.onboarding_location_needed_extra);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            TextKt.m216Text4IGK_g(string3, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 0, 0, 65530);
            if (1.0f > 0.0d) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                companion.then(layoutWeightElement);
                SpacerKt.Spacer(layoutWeightElement, startRestartGroup, 0);
                String string4 = getString(R.string.onboarding_location_link);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                ButtonFilledKt.ButtonFilled(null, string4, false, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.LocationEnableFragment$ComposeContent$1$1
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
                        LocationEnableFragment.this.openSettings();
                    }
                }, startRestartGroup, 0, 5);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.LocationEnableFragment$ComposeContent$2
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
                            LocationEnableFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r82 | 1));
                        }
                    };
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        if (z) {
            return R.anim.onboarding_instant;
        }
        return R.anim.onboarding_pause;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.LOCATION_ENABLING) {
            return true;
        }
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Context context = getContext();
        if (context != null) {
            context.unregisterReceiver(this.locationChangedBroadcastReceiver);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            context.registerReceiver(this.locationChangedBroadcastReceiver, new IntentFilter("android.location.MODE_CHANGED"));
        }
    }
}
