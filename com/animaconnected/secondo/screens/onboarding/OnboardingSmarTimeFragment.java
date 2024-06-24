package com.animaconnected.secondo.screens.onboarding;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Build;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.ColorKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.secondo.utils.ViewKt;
import com.animaconnected.widget.ButtonFilledKt;
import com.google.common.base.Strings;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingSmarTimeFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingSmarTimeFragment extends ComposeOnboardingFragment {
    public static final int $stable = 8;
    private boolean isBackAllowed;
    private final String lotusSmarTimeUrl = "http://app-download.festinagroup.com/lotus2";
    private final String name = "OnboardingSmarTime";

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSmarTimeApp() {
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.lotusSmarTimeUrl)));
        } catch (ActivityNotFoundException unused) {
            ViewKt.toast((Fragment) this, this.lotusSmarTimeUrl, true);
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r69) {
        ColorFilter porterDuffColorFilter;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1584616664);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        float f = 16;
        Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(companion, f);
        startRestartGroup.startReplaceableGroup(733328855);
        BiasAlignment biasAlignment = Alignment.Companion.TopStart;
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(biasAlignment, false, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs);
        Applier<?> applier = startRestartGroup.applier;
        if (applier instanceof Applier) {
            startRestartGroup.startReusableNode();
            if (startRestartGroup.inserting) {
                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
            } else {
                startRestartGroup.useNode();
            }
            ComposeUiNode$Companion$SetMeasurePolicy$1 composeUiNode$Companion$SetMeasurePolicy$1 = ComposeUiNode.Companion.SetMeasurePolicy;
            Updater.m228setimpl(startRestartGroup, rememberBoxMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
            ComposeUiNode$Companion$SetResolvedCompositionLocals$1 composeUiNode$Companion$SetResolvedCompositionLocals$1 = ComposeUiNode.Companion.SetResolvedCompositionLocals;
            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, composeUiNode$Companion$SetResolvedCompositionLocals$1);
            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
            }
            modifierMaterializerOf.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier align = boxScopeInstance.align(PaddingKt.m71padding3ABfNKs(ClickableKt.m26clickableXHw0xAI$default(companion, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingSmarTimeFragment$ComposeContent$1$1
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
                    OnboardingSmarTimeFragment.this.getOnboarding().cancelSmarTimeRedirect();
                }
            }), f), biasAlignment);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_chevron_left, startRestartGroup);
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
            long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
            if (Build.VERSION.SDK_INT >= 29) {
                porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m166getOnBackground0d7_KjU, 5);
            } else {
                porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m166getOnBackground0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
            }
            androidx.compose.ui.graphics.ColorFilter colorFilter = new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter);
            ContentScale$Companion$Inside$1 contentScale$Companion$Inside$1 = ContentScale.Companion.Inside;
            ImageKt.Image(painterResource, "Back button", align, null, contentScale$Companion$Inside$1, 0.0f, colorFilter, startRestartGroup, 24632, 40);
            Modifier align2 = boxScopeInstance.align(companion, Alignment.Companion.Center);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            startRestartGroup.startReplaceableGroup(-483455358);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
            ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(align2);
            if (applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, columnMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                modifierMaterializerOf2.invoke((Object) new SkippableUpdater(startRestartGroup), (Object) startRestartGroup, (Object) 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.lotus_smartime, startRestartGroup), "Lotus logo", null, null, contentScale$Companion$Inside$1, 0.0f, null, startRestartGroup, 24632, 108);
                float f2 = 56;
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f2), startRestartGroup, 6);
                String string = getString(R.string.onboarding_redirect_title);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                long m166getOnBackground0d7_KjU2 = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = TypographyKt.LocalTypography;
                TextKt.m216Text4IGK_g(string, null, m166getOnBackground0d7_KjU2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).h1, startRestartGroup, 0, 0, 65530);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f), startRestartGroup, 6);
                String string2 = getString(R.string.onboarding_redirect_description, getString(R.string.lotus_smartime_name));
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                TextKt.m216Text4IGK_g(string2, null, ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(staticProvidableCompositionLocal2)).body1, startRestartGroup, 0, 0, 65530);
                SpacerKt.Spacer(SizeKt.m83height3ABfNKs(companion, f2), startRestartGroup, 6);
                String string3 = getString(R.string.lotus_smartime_name);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                ButtonFilledKt.ButtonFilled(null, string3, false, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingSmarTimeFragment$ComposeContent$1$2$1
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
                        OnboardingSmarTimeFragment.this.showSmarTimeApp();
                    }
                }, startRestartGroup, 0, 5);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
                RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
                if (m != null) {
                    m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingSmarTimeFragment$ComposeContent$2
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
                            OnboardingSmarTimeFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r69 | 1));
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

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getEnterAnimRes(Onboarding.State fromState) {
        Intrinsics.checkNotNullParameter(fromState, "fromState");
        return R.anim.enter_from_right;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopEnterAnimRes() {
        return R.anim.enter_from_left;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getPopExitAnimRes() {
        return R.anim.exit_to_right;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean handlesState(Onboarding.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state == Onboarding.State.SMARTIME_FOUND) {
            return true;
        }
        return false;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public boolean isBackAllowed() {
        return this.isBackAllowed;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public void setBackAllowed(boolean z) {
        this.isBackAllowed = z;
    }
}
