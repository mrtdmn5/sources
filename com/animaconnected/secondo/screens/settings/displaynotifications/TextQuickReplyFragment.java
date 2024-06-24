package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.settings.displaynotifications.components.ResponseComponentsKt;
import com.animaconnected.secondo.widget.compose.ComponentsKt;
import com.kronaby.watch.app.R;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextQuickReplyFragment.kt */
/* loaded from: classes3.dex */
public final class TextQuickReplyFragment extends BaseFragment {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);
    private final String name = "TextQuickReplyFragment";

    /* compiled from: TextQuickReplyFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TextQuickReplyFragment newInstance() {
            return new TextQuickReplyFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> responses() {
        return CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{getString(R.string.filtered_notifications_text_reply_let_me_get_back_to_u), getString(R.string.filtered_notifications_text_reply_can_i_call_you_later), getString(R.string.filtered_notifications_text_reply_could_you_give_me_a_call)});
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.animaconnected.secondo.screens.settings.displaynotifications.TextQuickReplyFragment$onCreateView$1$1, kotlin.jvm.internal.Lambda] */
    @Override // androidx.fragment.app.Fragment
    public ComposeView onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        final ComposeView composeView = new ComposeView(requireContext, null, 6);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-956916431, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextQuickReplyFragment$onCreateView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r4v3, types: [com.animaconnected.secondo.screens.settings.displaynotifications.TextQuickReplyFragment$onCreateView$1$1$1, kotlin.jvm.internal.Lambda] */
            public final void invoke(Composer composer, int r4) {
                if ((r4 & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
                final TextQuickReplyFragment textQuickReplyFragment = TextQuickReplyFragment.this;
                final ComposeView composeView2 = composeView;
                ComponentsKt.BrandTheme(ComposableLambdaKt.composableLambda(composer, -669642622, new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextQuickReplyFragment$onCreateView$1$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int r14) {
                        List responses;
                        if ((r14 & 11) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        Modifier m73paddingVpY3zN4$default = PaddingKt.m73paddingVpY3zN4$default(Modifier.Companion.$$INSTANCE, 32, 0.0f, 2);
                        String string = TextQuickReplyFragment.this.getString(R.string.filtered_notifications_text_reply_title);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        composer2.startReplaceableGroup(367472740);
                        boolean changed = composer2.changed(TextQuickReplyFragment.this);
                        final TextQuickReplyFragment textQuickReplyFragment2 = TextQuickReplyFragment.this;
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.Companion.Empty) {
                            rememberedValue = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.TextQuickReplyFragment$onCreateView$1$1$1$1$1
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
                                    TextQuickReplyFragment.this.getMainController().goBack();
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        String string2 = composeView2.getContext().getString(R.string.filtered_notifications_text_reply_title);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        responses = TextQuickReplyFragment.this.responses();
                        String string3 = composeView2.getContext().getString(R.string.filtered_notifications_text_reply_about);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        ResponseComponentsKt.ResponseScreen(m73paddingVpY3zN4$default, string, (Function0) rememberedValue, string2, responses, string3, composer2, 32774, 0);
                    }
                }), composer, 6);
            }
        }, true));
        return composeView;
    }
}
