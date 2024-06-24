package com.animaconnected.secondo.screens.settings.displaynotifications;

import android.content.Intent;
import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import androidx.activity.result.ActivityResult;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.AnimatedContentKt$$ExternalSyntheticOutline2;
import androidx.compose.animation.AnimatedVisibilityKt$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0;
import androidx.compose.material.SliderKt$$ExternalSyntheticOutline0;
import androidx.compose.material.Typography;
import androidx.compose.material.TypographyKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaImpl;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.BiasAlignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidBlendMode_androidKt;
import androidx.compose.ui.graphics.BlendModeColorFilterHelper;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode$Companion$Constructor$1;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.secondo.app.ImportantContactKt;
import com.animaconnected.secondo.screens.ComposeFragment;
import com.animaconnected.watch.filter.ImportantContact;
import com.animaconnected.widget.ScreenTitleKt;
import com.animaconnected.widget.TextKt;
import com.animaconnected.widget.TopbarKt;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import com.kronaby.watch.app.R;
import io.ktor.http.URLProtocolKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImportantContactFragment.kt */
/* loaded from: classes3.dex */
public final class ImportantContactFragment extends ComposeFragment {
    private final String name = "ImportantContactFragment";
    private final DisplayNotificationViewModel viewModel = new DisplayNotificationViewModel();
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ImportantContactFragment.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImportantContactFragment newInstance() {
            return new ImportantContactFragment();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void AddContactSection(Modifier modifier, final List<ImportantContact> list, Composer composer, final int r20, final int r21) {
        final Modifier modifier2;
        ComposerImpl startRestartGroup = composer.startRestartGroup(-1845815696);
        if ((r21 & 1) != 0) {
            modifier2 = Modifier.Companion.$$INSTANCE;
        } else {
            modifier2 = modifier;
        }
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        LazyDslKt.LazyColumn(null, null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                invoke2(lazyListScope);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r0v4, types: [com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$2, kotlin.jvm.internal.Lambda] */
            /* JADX WARN: Type inference failed for: r3v1, types: [com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$invoke$$inlined$items$default$4, kotlin.jvm.internal.Lambda] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LazyListScope LazyColumn) {
                Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                final List<ImportantContact> list2 = list;
                final ImportantContactFragment importantContactFragment = this;
                final Modifier modifier3 = modifier2;
                final ImportantContactFragment$AddContactSection$1$invoke$$inlined$items$default$1 importantContactFragment$AddContactSection$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$invoke$$inlined$items$default$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(ImportantContact importantContact) {
                        return null;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return invoke((ImportantContact) obj);
                    }
                };
                LazyColumn.items(list2.size(), null, new Function1<Integer, Object>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$invoke$$inlined$items$default$3
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
                }, ComposableLambdaKt.composableLambdaInstance(-632812321, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$invoke$$inlined$items$default$4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer2, Integer num2) {
                        invoke(lazyItemScope, num.intValue(), composer2, num2.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope items, int r9, Composer composer2, int r11) {
                        int r8;
                        Intrinsics.checkNotNullParameter(items, "$this$items");
                        if ((r11 & 14) == 0) {
                            r8 = (composer2.changed(items) ? 4 : 2) | r11;
                        } else {
                            r8 = r11;
                        }
                        if ((r11 & 112) == 0) {
                            r8 |= composer2.changed(r9) ? 32 : 16;
                        }
                        if ((r8 & 731) == 146 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        final ImportantContact importantContact = (ImportantContact) list2.get(r9);
                        ImportantContactFragment importantContactFragment2 = importantContactFragment;
                        Modifier modifier4 = modifier3;
                        String displayName = importantContact.getDisplayName();
                        final ImportantContactFragment importantContactFragment3 = importantContactFragment;
                        importantContactFragment2.ContactRow(modifier4, displayName, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1$1$1
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
                                DisplayNotificationViewModel displayNotificationViewModel;
                                displayNotificationViewModel = ImportantContactFragment.this.viewModel;
                                displayNotificationViewModel.removeImportantContact(importantContact.getPlatformSpecificIdentifier());
                            }
                        }, composer2, 4096, 0);
                    }
                }, true));
                final Modifier modifier4 = modifier2;
                final ImportantContactFragment importantContactFragment2 = this;
                LazyColumn.item(null, null, ComposableLambdaKt.composableLambdaInstance(1412951300, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer2, Integer num) {
                        invoke(lazyItemScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LazyItemScope item, Composer composer2, int r30) {
                        Modifier fillMaxWidth;
                        Intrinsics.checkNotNullParameter(item, "$this$item");
                        if ((r30 & 81) == 16 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$12 = ComposerKt.removeCurrentGroupInstance;
                        fillMaxWidth = SizeKt.fillMaxWidth(PaddingKt.m75paddingqDBjuR0$default(SizeKt.m83height3ABfNKs(Modifier.this, 56), 0.0f, 16, 0.0f, 0.0f, 13), 1.0f);
                        final ImportantContactFragment importantContactFragment3 = importantContactFragment2;
                        Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(fillMaxWidth, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment.AddContactSection.1.2.1
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
                                ImportantContactFragment.this.launchContactPicker();
                            }
                        });
                        BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
                        composer2.startReplaceableGroup(693286680);
                        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, composer2);
                        composer2.startReplaceableGroup(-1323940314);
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2);
                        PersistentCompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        ComposeUiNode.Companion.getClass();
                        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
                        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
                        if (composer2.getApplier() instanceof Applier) {
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(layoutNode$Companion$Constructor$1);
                            } else {
                                composer2.useNode();
                            }
                            Updater.m228setimpl(composer2, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                            Updater.m228setimpl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                            ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                            if (composer2.getInserting() || !Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, composer2, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                            }
                            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline1.m(0, modifierMaterializerOf, new SkippableUpdater(composer2), composer2, 2058660585);
                            TextKt.m1633CapsTextfLXpl1I(URLProtocolKt.stringResource(R.string.filtered_notifications_add_important_contact, composer2), null, ((Colors) composer2.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, ((Typography) composer2.consume(TypographyKt.LocalTypography)).button, composer2, 0, 0, 32762);
                            DrawerKt$ModalDrawer$1$$ExternalSyntheticOutline0.m(composer2);
                            return;
                        }
                        ComposablesKt.invalidApplier();
                        throw null;
                    }
                }, true));
            }
        }, startRestartGroup, 0, 255);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$AddContactSection$2
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
                    ImportantContactFragment.this.AddContactSection(modifier3, list, composer2, Strings.updateChangedFlags(r20 | 1), r21);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ContactRow(Modifier modifier, final String str, final Function0<Unit> function0, Composer composer, final int r38, final int r39) {
        final Modifier modifier2;
        int r3;
        int r32;
        int r6;
        int r62;
        boolean z;
        ColorFilter porterDuffColorFilter;
        ComposerImpl startRestartGroup = composer.startRestartGroup(361881855);
        int r1 = r39 & 1;
        if (r1 != 0) {
            r3 = r38 | 6;
            modifier2 = modifier;
        } else if ((r38 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r32 = 4;
            } else {
                r32 = 2;
            }
            r3 = r32 | r38;
        } else {
            modifier2 = modifier;
            r3 = r38;
        }
        if ((r39 & 2) != 0) {
            r3 |= 48;
        } else if ((r38 & 112) == 0) {
            if (startRestartGroup.changed(str)) {
                r6 = 32;
            } else {
                r6 = 16;
            }
            r3 |= r6;
        }
        if ((r39 & 4) != 0) {
            r3 |= 384;
        } else if ((r38 & 896) == 0) {
            if (startRestartGroup.changedInstance(function0)) {
                r62 = 256;
            } else {
                r62 = 128;
            }
            r3 |= r62;
        }
        if ((r3 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
            if (r1 != 0) {
                modifier2 = companion;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            Modifier m83height3ABfNKs = SizeKt.m83height3ABfNKs(modifier2, 48);
            startRestartGroup.startReplaceableGroup(-51055092);
            if ((r3 & 896) == 256) {
                z = true;
            } else {
                z = false;
            }
            Object nextSlot = startRestartGroup.nextSlot();
            if (z || nextSlot == Composer.Companion.Empty) {
                nextSlot = new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$ContactRow$1$1
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
                        function0.invoke();
                    }
                };
                startRestartGroup.updateValue(nextSlot);
            }
            startRestartGroup.end(false);
            Modifier m26clickableXHw0xAI$default = ClickableKt.m26clickableXHw0xAI$default(m83height3ABfNKs, (Function0) nextSlot);
            BiasAlignment.Vertical vertical = Alignment.Companion.CenterVertically;
            startRestartGroup.startReplaceableGroup(693286680);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.Start, vertical, startRestartGroup);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
            PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
            ComposeUiNode.Companion.getClass();
            LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
            ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m26clickableXHw0xAI$default);
            if (startRestartGroup.applier instanceof Applier) {
                startRestartGroup.startReusableNode();
                if (startRestartGroup.inserting) {
                    startRestartGroup.createNode(layoutNode$Companion$Constructor$1);
                } else {
                    startRestartGroup.useNode();
                }
                Updater.m228setimpl(startRestartGroup, rowMeasurePolicy, ComposeUiNode.Companion.SetMeasurePolicy);
                Updater.m228setimpl(startRestartGroup, currentCompositionLocalScope, ComposeUiNode.Companion.SetResolvedCompositionLocals);
                ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
                if (startRestartGroup.inserting || !Intrinsics.areEqual(startRestartGroup.nextSlot(), Integer.valueOf(currentCompositeKeyHash))) {
                    AnimatedContentKt$$ExternalSyntheticOutline0.m(currentCompositeKeyHash, startRestartGroup, currentCompositeKeyHash, composeUiNode$Companion$SetCompositeKeyHash$1);
                }
                AnimatedVisibilityKt$$ExternalSyntheticOutline0.m(0, modifierMaterializerOf, new SkippableUpdater(startRestartGroup), startRestartGroup, 2058660585);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_minus, startRestartGroup), "", null, null, null, 0.0f, null, startRestartGroup, 56, 124);
                Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.ic_person, startRestartGroup);
                StaticProvidableCompositionLocal staticProvidableCompositionLocal = ColorsKt.LocalColors;
                long m166getOnBackground0d7_KjU = ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU();
                if (Build.VERSION.SDK_INT >= 29) {
                    porterDuffColorFilter = BlendModeColorFilterHelper.INSTANCE.m309BlendModeColorFilterxETnrds(m166getOnBackground0d7_KjU, 5);
                } else {
                    porterDuffColorFilter = new PorterDuffColorFilter(ColorKt.m327toArgb8_81llA(m166getOnBackground0d7_KjU), AndroidBlendMode_androidKt.m281toPorterDuffModes9anfk8(5));
                }
                ImageKt.Image(painterResource, "", null, null, null, 0.0f, new androidx.compose.ui.graphics.ColorFilter(porterDuffColorFilter), startRestartGroup, 56, 60);
                androidx.compose.material.TextKt.m216Text4IGK_g(str, PaddingKt.m75paddingqDBjuR0$default(SizeKt.fillMaxWidth(companion, 1.0f), 16, 0.0f, 0.0f, 0.0f, 14), ((Colors) startRestartGroup.consume(staticProvidableCompositionLocal)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).h3, startRestartGroup, ((r3 >> 3) & 14) | 48, 0, 65528);
                AnimatedContentKt$$ExternalSyntheticOutline2.m(startRestartGroup, false, true, false, false);
            } else {
                ComposablesKt.invalidApplier();
                throw null;
            }
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$ContactRow$3
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
                    ImportantContactFragment.this.ContactRow(modifier2, str, function0, composer2, Strings.updateChangedFlags(r38 | 1), r39);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Description(Modifier modifier, Composer composer, final int r32, final int r33) {
        final Modifier modifier2;
        int r6;
        int r62;
        Modifier modifier3;
        Modifier fillMaxWidth;
        ComposerImpl startRestartGroup = composer.startRestartGroup(869016926);
        int r3 = r33 & 1;
        if (r3 != 0) {
            r6 = r32 | 6;
            modifier2 = modifier;
        } else if ((r32 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed(modifier2)) {
                r62 = 4;
            } else {
                r62 = 2;
            }
            r6 = r62 | r32;
        } else {
            modifier2 = modifier;
            r6 = r32;
        }
        if ((r6 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (r3 != 0) {
                modifier3 = Modifier.Companion.$$INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            String stringResource = URLProtocolKt.stringResource(R.string.filtered_notifications_important_contacts_header_text, startRestartGroup);
            fillMaxWidth = SizeKt.fillMaxWidth(modifier3, 1.0f);
            androidx.compose.material.TextKt.m216Text4IGK_g(stringResource, PaddingKt.m75paddingqDBjuR0$default(fillMaxWidth, 0.0f, 0.0f, 0.0f, 32, 7), ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m166getOnBackground0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ((Typography) startRestartGroup.consume(TypographyKt.LocalTypography)).body1, startRestartGroup, 0, 0, 65528);
            modifier2 = modifier3;
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$Description$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r5) {
                    ImportantContactFragment.this.Description(modifier2, composer2, Strings.updateChangedFlags(r32 | 1), r33);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ImportantContactScreen(Composer composer, final int r14) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(1698392989);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        Modifier m21backgroundbw27NRU = BackgroundKt.m21backgroundbw27NRU(companion, ((Colors) startRestartGroup.consume(ColorsKt.LocalColors)).m164getBackground0d7_KjU(), RectangleShapeKt.RectangleShape);
        startRestartGroup.startReplaceableGroup(-483455358);
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.Top, Alignment.Companion.Start, startRestartGroup);
        startRestartGroup.startReplaceableGroup(-1323940314);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup);
        PersistentCompositionLocalMap currentCompositionLocalScope = startRestartGroup.currentCompositionLocalScope();
        ComposeUiNode.Companion.getClass();
        LayoutNode$Companion$Constructor$1 layoutNode$Companion$Constructor$1 = ComposeUiNode.Companion.Constructor;
        ComposableLambdaImpl modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m21backgroundbw27NRU);
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
            MutableState collectAsState = Platform.collectAsState(this.viewModel.getImportantContacts(), EmptyList.INSTANCE, null, startRestartGroup, 2);
            TopbarKt.TopBar(null, R.drawable.ic_chevron_left, new Function0<Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$ImportantContactScreen$1$1
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
                    ImportantContactFragment.this.getMainController().goBack();
                }
            }, URLProtocolKt.stringResource(R.string.feature_path_settings, startRestartGroup), null, startRestartGroup, 48, 17);
            float f = 32;
            ScreenTitleKt.ScreenTitle(PaddingKt.m73paddingVpY3zN4$default(companion, 0.0f, f, 1), URLProtocolKt.stringResource(R.string.filtered_notifications_important_contacts, startRestartGroup), startRestartGroup, 6, 0);
            Description(PaddingKt.m73paddingVpY3zN4$default(companion, f, 0.0f, 2), startRestartGroup, 70, 0);
            AddContactSection(PaddingKt.m73paddingVpY3zN4$default(companion, f, 0.0f, 2), (List) collectAsState.getValue(), startRestartGroup, 582, 0);
            RecomposeScopeImpl m = SliderKt$$ExternalSyntheticOutline0.m(startRestartGroup, false, true, false, false);
            if (m != null) {
                m.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$ImportantContactScreen$2
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
                        ImportantContactFragment.this.ImportantContactScreen(composer2, Strings.updateChangedFlags(r14 | 1));
                    }
                };
                return;
            }
            return;
        }
        ComposablesKt.invalidApplier();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void contactPicked(Uri uri) {
        ImportantContact fromLookupUri;
        if (uri == null || (fromLookupUri = ImportantContactKt.fromLookupUri(ImportantContact.Companion, uri)) == null) {
            return;
        }
        this.viewModel.addImportantContact(fromLookupUri.getPlatformSpecificIdentifier(), fromLookupUri.getDisplayName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchContactPicker() {
        getActivityLauncher().launch(new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI), new Function1<ActivityResult, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$launchContactPicker$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ActivityResult activityResult) {
                invoke2(activityResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ActivityResult result) {
                Intent intent;
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.mResultCode != -1 || (intent = result.mData) == null) {
                    return;
                }
                ImportantContactFragment.this.contactPicked(intent.getData());
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.ComposeFragment
    public void ComposeContent(Composer composer, final int r3) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-581359968);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        ImportantContactScreen(startRestartGroup, 8);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: com.animaconnected.secondo.screens.settings.displaynotifications.ImportantContactFragment$ComposeContent$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int r32) {
                    ImportantContactFragment.this.ComposeContent(composer2, Strings.updateChangedFlags(r3 | 1));
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
}
