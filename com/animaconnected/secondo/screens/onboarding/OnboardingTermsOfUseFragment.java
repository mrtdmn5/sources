package com.animaconnected.secondo.screens.onboarding;

import android.content.Intent;
import android.net.Uri;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline1;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticOutline0;
import androidx.compose.material.CardKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetMeasurePolicy$1;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetResolvedCompositionLocals$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.amplifyframework.core.model.Model$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.onboarding.Onboarding;
import com.animaconnected.widget.ButtonBorderlessKt;
import com.animaconnected.widget.ButtonFilledKt;
import com.animaconnected.widget.CheckboxesKt;
import com.animaconnected.widget.TextConvertUtilsKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingTermsOfUseFragment.kt */
/* loaded from: classes3.dex */
public final class OnboardingTermsOfUseFragment extends ComposeOnboardingFragment {
    public static final int $stable = 0;
    private final String name = "OnboardingNoLoginFragment";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ComposeContent$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final boolean ComposeContent$lambda$4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ComposeContent$lambda$5(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onTermsAndPolicyAccepted() {
        ProviderFactory.getSettingProvider().setTermsAndPolicyAccepted(true);
        if (isAdded()) {
            getOnboardingViewController().clearBackStack();
        }
        getOnboarding().updateState();
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment
    public void ComposeContent(Composer composer, final int r41) {
        int r34;
        boolean z;
        final MutableState mutableState;
        ComposerImpl composerImpl;
        boolean z2;
        boolean z3;
        boolean z4;
        int r0;
        ComposerImpl startRestartGroup = composer.startRestartGroup(1035194934);
        if ((r41 & 14) == 0) {
            if (startRestartGroup.changed(this)) {
                r0 = 4;
            } else {
                r0 = 2;
            }
            r34 = r0 | r41;
        } else {
            r34 = r41;
        }
        if ((r34 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composerImpl = startRestartGroup;
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(764531777);
            Object nextSlot = startRestartGroup.nextSlot();
            Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
            if (nextSlot == composer$Companion$Empty$1) {
                nextSlot = Platform.mutableStateOf$default(Boolean.FALSE);
                startRestartGroup.updateValue(nextSlot);
            }
            MutableState mutableState2 = (MutableState) nextSlot;
            Object m = CoreTextFieldKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, 764531848);
            if (m == composer$Companion$Empty$1) {
                m = Platform.mutableStateOf$default(Boolean.FALSE);
                startRestartGroup.updateValue(m);
            }
            final MutableState mutableState3 = (MutableState) m;
            startRestartGroup.end(false);
            startRestartGroup.startReplaceableGroup(764531892);
            if (ComposeContent$lambda$4(mutableState3)) {
                startRestartGroup.startReplaceableGroup(764531985);
                Object nextSlot2 = startRestartGroup.nextSlot();
                if (nextSlot2 == composer$Companion$Empty$1) {
                    nextSlot2 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$1$1
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
                            OnboardingTermsOfUseFragment.ComposeContent$lambda$5(mutableState3, false);
                        }
                    };
                    startRestartGroup.updateValue(nextSlot2);
                }
                Function0<Unit> function0 = (Function0) nextSlot2;
                startRestartGroup.end(false);
                startRestartGroup.startReplaceableGroup(764532340);
                int r02 = r34 & 14;
                if (r02 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Object nextSlot3 = startRestartGroup.nextSlot();
                if (z3 || nextSlot3 == composer$Companion$Empty$1) {
                    nextSlot3 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$2$1
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
                            OnboardingTermsOfUseFragment.ComposeContent$lambda$5(mutableState3, false);
                            OnboardingTermsOfUseFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(OnboardingTermsOfUseFragment.this.getString(R.string.privacy_policy_link_uri))));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot3);
                }
                Function0<Unit> function02 = (Function0) nextSlot3;
                startRestartGroup.end(false);
                startRestartGroup.startReplaceableGroup(764532086);
                if (r02 == 4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Object nextSlot4 = startRestartGroup.nextSlot();
                if (z4 || nextSlot4 == composer$Companion$Empty$1) {
                    nextSlot4 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$3$1
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
                            OnboardingTermsOfUseFragment.ComposeContent$lambda$5(mutableState3, false);
                            OnboardingTermsOfUseFragment.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(OnboardingTermsOfUseFragment.this.getString(R.string.terms_of_use_link_uri))));
                        }
                    };
                    startRestartGroup.updateValue(nextSlot4);
                }
                startRestartGroup.end(false);
                SelectLinkDialog(function0, function02, (Function0) nextSlot4, startRestartGroup, ((r34 << 9) & 7168) | 6);
            }
            startRestartGroup.end(false);
            BiasAlignment.Horizontal horizontal = Alignment.Companion.CenterHorizontally;
            startRestartGroup.startReplaceableGroup(-483455358);
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, horizontal, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                if (1.0f > 0.0d) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    LayoutWeightElement layoutWeightElement = new LayoutWeightElement(1.0f, true);
                    companion.then(layoutWeightElement);
                    ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.app_logo, startRestartGroup), "Logo", PaddingKt.m75paddingqDBjuR0$default(layoutWeightElement, 0.0f, 0.0f, 0.0f, 64, 7), null, ContentScale.Companion.Inside, 0.0f, null, startRestartGroup, 24632, 104);
                    Modifier m75paddingqDBjuR0$default = PaddingKt.m75paddingqDBjuR0$default(IntrinsicKt.width(companion, IntrinsicSize.Min), 0.0f, 0.0f, 0.0f, 56, 7);
                    Arrangement.SpacedAligned m60spacedBy0680j_4 = Arrangement.m60spacedBy0680j_4(32);
                    startRestartGroup.startReplaceableGroup(-483455358);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(m60spacedBy0680j_4, Alignment.Companion.Start, startRestartGroup);
                    startRestartGroup.startReplaceableGroup(-1323940314);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                    PersistentCompositionLocalMap currentCompositionLocalScope2 = startRestartGroup.currentCompositionLocalScope();
                    ComposableLambdaImpl modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(m75paddingqDBjuR0$default);
                    if (applier instanceof Applier) {
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.inserting) {
                            startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                        } else {
                            startRestartGroup.useNode();
                        }
                        Updater.m228setimpl(startRestartGroup, columnMeasurePolicy2, composeUiNode$Companion$SetMeasurePolicy$1);
                        Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope2, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                        if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash2))) {
                            AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash2, startRestartGroup, currentCompositeKeyHash2, composeUiNode$Companion$SetCompositeKeyHash$1);
                        }
                        AnimatedContentKt$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf2, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585, 693286680);
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, Alignment.Companion.Top, startRestartGroup);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
                        PersistentCompositionLocalMap currentCompositionLocalScope3 = startRestartGroup.currentCompositionLocalScope();
                        ComposableLambdaImpl modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(companion);
                        if (applier instanceof Applier) {
                            startRestartGroup.startReusableNode();
                            if (startRestartGroup.inserting) {
                                startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                startRestartGroup.useNode();
                            }
                            Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, composeUiNode$Companion$SetMeasurePolicy$1);
                            Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope3, composeUiNode$Companion$SetResolvedCompositionLocals$1);
                            if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash3))) {
                                AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash3, startRestartGroup, currentCompositeKeyHash3, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf3, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                            boolean ComposeContent$lambda$1 = ComposeContent$lambda$1(mutableState2);
                            startRestartGroup.startReplaceableGroup(1388141598);
                            Object nextSlot5 = startRestartGroup.nextSlot();
                            if (nextSlot5 == composer$Companion$Empty$1) {
                                mutableState = mutableState2;
                                nextSlot5 = new Function1<Boolean, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$4$1$1$1$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                        invoke(bool.booleanValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(boolean z5) {
                                        boolean ComposeContent$lambda$12;
                                        MutableState<Boolean> mutableState4 = mutableState;
                                        ComposeContent$lambda$12 = OnboardingTermsOfUseFragment.ComposeContent$lambda$1(mutableState4);
                                        OnboardingTermsOfUseFragment.ComposeContent$lambda$2(mutableState4, !ComposeContent$lambda$12);
                                    }
                                };
                                startRestartGroup.updateValue(nextSlot5);
                            } else {
                                mutableState = mutableState2;
                            }
                            startRestartGroup.end(false);
                            CheckboxesKt.CheckBoxStyled(ComposeContent$lambda$1, (Function1) nextSlot5, null, false, startRestartGroup, 48, 12);
                            Modifier fillMaxWidth = SizeKt.fillMaxWidth(companion, 1.0f);
                            startRestartGroup.startReplaceableGroup(1388141819);
                            Object nextSlot6 = startRestartGroup.nextSlot();
                            if (nextSlot6 == composer$Companion$Empty$1) {
                                nextSlot6 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$4$1$1$2$1
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
                                        OnboardingTermsOfUseFragment.ComposeContent$lambda$5(mutableState3, true);
                                    }
                                };
                                startRestartGroup.updateValue(nextSlot6);
                            }
                            startRestartGroup.end(false);
                            Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(fillMaxWidth, (Function0) nextSlot6);
                            startRestartGroup.startReplaceableGroup(1388141883);
                            Object nextSlot7 = startRestartGroup.nextSlot();
                            if (nextSlot7 == composer$Companion$Empty$1) {
                                CharSequence text = getText(R.string.onboarding_register_terms_of_use);
                                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                                nextSlot7 = TextConvertUtilsKt.toAnnotatedText(text);
                                startRestartGroup.updateValue(nextSlot7);
                            }
                            AnnotatedString annotatedString = (AnnotatedString) nextSlot7;
                            startRestartGroup.end(false);
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                            composerImpl = startRestartGroup;
                            TextKt.m217TextIbK3jfQ(annotatedString, m26clickableXHw0xAI$default, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, composerImpl, 6, 0, 131064);
                            AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                            String stringResource = URLProtocolKt.stringResource(R.string.onboarding_continue, composerImpl);
                            boolean ComposeContent$lambda$12 = ComposeContent$lambda$1(mutableState);
                            composerImpl.startReplaceableGroup(-1741125700);
                            if ((r34 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            Object nextSlot8 = composerImpl.nextSlot();
                            if (z2 || nextSlot8 == composer$Companion$Empty$1) {
                                nextSlot8 = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$4$1$2$1
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
                                        OnboardingTermsOfUseFragment.this.onTermsAndPolicyAccepted();
                                    }
                                };
                                composerImpl.updateValue(nextSlot8);
                            }
                            composerImpl.end(false);
                            ButtonFilledKt.ButtonFilled(null, stringResource, ComposeContent$lambda$12, (Function0) nextSlot8, composerImpl, 0, 1);
                            AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                            AnimatedContentKt$$ExternalSyntheticOutline2.m(composerImpl, false, true, false, false);
                        } else {
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                    } else {
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                } else {
                    throw new IllegalArgumentException(Model$$ExternalSyntheticOutline0.m("invalid weight ", 1.0f, "; must be greater than zero").toString());
                }
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = composerImpl.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$ComposeContent$5
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
                    OnboardingTermsOfUseFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r41 | 1));
                }
            };
        }
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$2, kotlin.jvm.internal.Lambda] */
    public final void SelectLinkDialog(final Function0<Unit> onDismissRequest, final Function0<Unit> onPrivacyPolicy, final Function0<Unit> onTermsOfUse, Composer composer, final int r12) {
        int r0;
        boolean z;
        int r2;
        int r22;
        int r02;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(onPrivacyPolicy, "onPrivacyPolicy");
        Intrinsics.checkNotNullParameter(onTermsOfUse, "onTermsOfUse");
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1570890667);
        if ((r12 & 14) == 0) {
            if (startRestartGroup.changedInstance(onDismissRequest)) {
                r02 = 4;
            } else {
                r02 = 2;
            }
            r0 = r02 | r12;
        } else {
            r0 = r12;
        }
        if ((r12 & 112) == 0) {
            if (startRestartGroup.changedInstance(onPrivacyPolicy)) {
                r22 = 32;
            } else {
                r22 = 16;
            }
            r0 |= r22;
        }
        if ((r12 & 896) == 0) {
            if (startRestartGroup.changedInstance(onTermsOfUse)) {
                r2 = 256;
            } else {
                r2 = 128;
            }
            r0 |= r2;
        }
        if ((r0 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            startRestartGroup.startReplaceableGroup(503861635);
            if ((r0 & 14) == 4) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$1$1
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
                        onDismissRequest.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            AndroidDialog_androidKt.Dialog((Function0) nextSlot, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1578015380, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r10v5, types: [com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$2$1, kotlin.jvm.internal.Lambda] */
                public final void invoke(Composer composer2, int r10) {
                    if ((r10 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                    float f = 16;
                    Modifier m71padding3ABfNKs = PaddingKt.m71padding3ABfNKs(SizeKt.fillMaxWidth(Modifier.Companion.$$INSTANCE, 1.0f), f);
                    RoundedCornerShape m112RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m112RoundedCornerShape0680j_4(f);
                    final Function0<Unit> function0 = onTermsOfUse;
                    final Function0<Unit> function02 = onPrivacyPolicy;
                    final Function0<Unit> function03 = onDismissRequest;
                    CardKt.m162CardFjzlyU(m71padding3ABfNKs, m112RoundedCornerShape0680j_4, 0.0f, ComposableLambdaKt.composableLambda(composer2, -283870001, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int r23) {
                            if ((r23 & 11) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$13 = ComposerKt.removeCurrentGroupInstance;
                            Modifier m71padding3ABfNKs2 = PaddingKt.m71padding3ABfNKs(Modifier.Companion.$$INSTANCE, 16);
                            Function0<Unit> function04 = function0;
                            Function0<Unit> function05 = function02;
                            Function0<Unit> function06 = function03;
                            composer3.startReplaceableGroup(-483455358);
                            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, composer3);
                            composer3.startReplaceableGroup(-1323940314);
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3);
                            PersistentCompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                            ComposeUiNode.Companion.getClass();
                            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m71padding3ABfNKs2);
                            if (composer3.getApplier() instanceof Applier) {
                                composer3.startReusableNode();
                                if (composer3.getInserting()) {
                                    composer3.createNode(layoutNode$Companion$Constructor$1);
                                } else {
                                    composer3.useNode();
                                }
                                Updater.m228setimpl(composer3, columnMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                                Updater.m228setimpl(composer3, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                                if (composer3.getInserting() || !Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer3, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                                }
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer3), composer3, 2058660585);
                                ButtonBorderlessKt.ButtonBorderless(null, URLProtocolKt.stringResource(R.string.settings_legal_terms_of_use_button, composer3), false, false, function04, composer3, 0, 13);
                                ButtonBorderlessKt.ButtonBorderless(null, URLProtocolKt.stringResource(R.string.settings_legal_privacy_policy_button, composer3), false, false, function05, composer3, 0, 13);
                                ButtonBorderlessKt.ButtonBorderless(null, URLProtocolKt.stringResource(R.string.button_cancel, composer3), false, false, function06, composer3, 0, 13);
                                DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer3);
                                return;
                            }
                            ComposablesKt.invalidApplier();
                            throw null;
                        }
                    }), composer2, 1572870, 60);
                }
            }), startRestartGroup, 384, 2);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingTermsOfUseFragment$SelectLinkDialog$3
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
                    OnboardingTermsOfUseFragment.this.SelectLinkDialog(onDismissRequest, onPrivacyPolicy, onTermsOfUse, composer2, Strings.updateChangedFlags(r12 | 1));
                }
            };
        }
    }

    @Override // com.animaconnected.secondo.screens.onboarding.ComposeOnboardingFragment, com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.onboarding.BaseOnboardingFragment
    public int getExitAnimRes(Onboarding.State toState, boolean z) {
        Intrinsics.checkNotNullParameter(toState, "toState");
        return R.anim.exit_to_left;
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
        if (state == Onboarding.State.SIGNIN) {
            return true;
        }
        return false;
    }
}
