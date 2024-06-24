package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode$Companion$SetCompositeKeyHash$1;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.LifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidView.android.kt */
/* loaded from: classes.dex */
public final class AndroidView_androidKt {
    public static final AndroidView_androidKt$NoOpUpdate$1 NoOpUpdate = AndroidView_androidKt$NoOpUpdate$1.INSTANCE;

    /* JADX WARN: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T extends android.view.View> void AndroidView(final kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r13, androidx.compose.ui.Modifier r14, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r15, androidx.compose.runtime.Composer r16, final int r17, final int r18) {
        /*
            r8 = r13
            r9 = r17
            java.lang.String r0 = "factory"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = -1783766393(0xffffffff95ade287, float:-7.023154E-26)
            r1 = r16
            androidx.compose.runtime.ComposerImpl r10 = r1.startRestartGroup(r0)
            r0 = r18 & 1
            if (r0 == 0) goto L18
            r0 = r9 | 6
            goto L28
        L18:
            r0 = r9 & 14
            if (r0 != 0) goto L27
            boolean r0 = r10.changedInstance(r13)
            if (r0 == 0) goto L24
            r0 = 4
            goto L25
        L24:
            r0 = 2
        L25:
            r0 = r0 | r9
            goto L28
        L27:
            r0 = r9
        L28:
            r1 = r18 & 2
            if (r1 == 0) goto L2f
            r0 = r0 | 48
            goto L41
        L2f:
            r2 = r9 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L41
            r2 = r14
            boolean r3 = r10.changed(r14)
            if (r3 == 0) goto L3d
            r3 = 32
            goto L3f
        L3d:
            r3 = 16
        L3f:
            r0 = r0 | r3
            goto L42
        L41:
            r2 = r14
        L42:
            r3 = r18 & 4
            if (r3 == 0) goto L49
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L5b
        L49:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L5b
            r4 = r15
            boolean r5 = r10.changedInstance(r15)
            if (r5 == 0) goto L57
            r5 = 256(0x100, float:3.59E-43)
            goto L59
        L57:
            r5 = 128(0x80, float:1.8E-43)
        L59:
            r0 = r0 | r5
            goto L5c
        L5b:
            r4 = r15
        L5c:
            r5 = r0 & 731(0x2db, float:1.024E-42)
            r6 = 146(0x92, float:2.05E-43)
            if (r5 != r6) goto L6e
            boolean r5 = r10.getSkipping()
            if (r5 != 0) goto L69
            goto L6e
        L69:
            r10.skipToGroupEnd()
            r3 = r4
            goto L99
        L6e:
            if (r1 == 0) goto L74
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion.$$INSTANCE
            r11 = r1
            goto L75
        L74:
            r11 = r2
        L75:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$NoOpUpdate$1 r5 = androidx.compose.ui.viewinterop.AndroidView_androidKt.NoOpUpdate
            if (r3 == 0) goto L7b
            r12 = r5
            goto L7c
        L7b:
            r12 = r4
        L7c:
            androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1 r1 = androidx.compose.runtime.ComposerKt.removeCurrentGroupInstance
            r2 = 0
            r1 = r0 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r3 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            int r0 = r0 << 6
            r0 = r0 & r3
            r6 = r1 | r0
            r7 = 4
            r0 = r13
            r1 = r11
            r3 = r5
            r4 = r12
            r5 = r10
            AndroidView(r0, r1, r2, r3, r4, r5, r6, r7)
            r2 = r11
            r3 = r12
        L99:
            androidx.compose.runtime.RecomposeScopeImpl r6 = r10.endRestartGroup()
            if (r6 != 0) goto La0
            goto Lad
        La0:
            androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1 r7 = new androidx.compose.ui.viewinterop.AndroidView_androidKt$AndroidView$1
            r0 = r7
            r1 = r13
            r4 = r17
            r5 = r18
            r0.<init>()
            r6.block = r7
        Lad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final ViewFactoryHolder access$requireViewFactoryHolder(LayoutNode layoutNode) {
        AndroidViewHolder androidViewHolder = layoutNode.interopViewFactoryHolder;
        if (androidViewHolder != null) {
            return (ViewFactoryHolder) androidViewHolder;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1] */
    public static final AndroidView_androidKt$createAndroidViewNodeFactory$1 createAndroidViewNodeFactory(final Function1 function1, Composer composer) {
        composer.startReplaceableGroup(2030558801);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        final int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer);
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        final CompositionContext rememberCompositionContext = ComposablesKt.rememberCompositionContext(composer);
        final SaveableStateRegistry saveableStateRegistry = (SaveableStateRegistry) composer.consume(SaveableStateRegistryKt.LocalSaveableStateRegistry);
        ?? r0 = new Function0<LayoutNode>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$createAndroidViewNodeFactory$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final LayoutNode invoke() {
                return new ViewFactoryHolder(context, function1, rememberCompositionContext, saveableStateRegistry, currentCompositeKeyHash).getLayoutNode();
            }
        };
        composer.endReplaceableGroup();
        return r0;
    }

    /* renamed from: updateViewHolderParams-6NefGtU */
    public static final <T extends View> void m608updateViewHolderParams6NefGtU(Composer composer, Modifier modifier, int r3, Density density, LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner, LayoutDirection layoutDirection, CompositionLocalMap compositionLocalMap) {
        ComposeUiNode.Companion.getClass();
        Updater.m228setimpl(composer, compositionLocalMap, ComposeUiNode.Companion.SetResolvedCompositionLocals);
        Updater.m228setimpl(composer, modifier, new Function2<LayoutNode, Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, Modifier modifier2) {
                LayoutNode set = layoutNode;
                Modifier it = modifier2;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidView_androidKt.access$requireViewFactoryHolder(set).setModifier(it);
                return Unit.INSTANCE;
            }
        });
        Updater.m228setimpl(composer, density, new Function2<LayoutNode, Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$2
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, Density density2) {
                LayoutNode set = layoutNode;
                Density it = density2;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidView_androidKt.access$requireViewFactoryHolder(set).setDensity(it);
                return Unit.INSTANCE;
            }
        });
        Updater.m228setimpl(composer, lifecycleOwner, new Function2<LayoutNode, LifecycleOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$3
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, LifecycleOwner lifecycleOwner2) {
                LayoutNode set = layoutNode;
                LifecycleOwner it = lifecycleOwner2;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidView_androidKt.access$requireViewFactoryHolder(set).setLifecycleOwner(it);
                return Unit.INSTANCE;
            }
        });
        Updater.m228setimpl(composer, savedStateRegistryOwner, new Function2<LayoutNode, SavedStateRegistryOwner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$4
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, SavedStateRegistryOwner savedStateRegistryOwner2) {
                LayoutNode set = layoutNode;
                SavedStateRegistryOwner it = savedStateRegistryOwner2;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidView_androidKt.access$requireViewFactoryHolder(set).setSavedStateRegistryOwner(it);
                return Unit.INSTANCE;
            }
        });
        Updater.m228setimpl(composer, layoutDirection, new Function2<LayoutNode, LayoutDirection, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidView_androidKt$updateViewHolderParams$5

            /* compiled from: AndroidView.android.kt */
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] r0 = new int[LayoutDirection.values().length];
                    try {
                        r0[LayoutDirection.Ltr.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        r0[LayoutDirection.Rtl.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = r0;
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(LayoutNode layoutNode, LayoutDirection layoutDirection2) {
                LayoutNode set = layoutNode;
                LayoutDirection it = layoutDirection2;
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                ViewFactoryHolder access$requireViewFactoryHolder = AndroidView_androidKt.access$requireViewFactoryHolder(set);
                int r4 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
                int r0 = 1;
                if (r4 != 1) {
                    if (r4 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    r0 = 0;
                }
                access$requireViewFactoryHolder.setLayoutDirection(r0);
                return Unit.INSTANCE;
            }
        });
        ComposeUiNode$Companion$SetCompositeKeyHash$1 composeUiNode$Companion$SetCompositeKeyHash$1 = ComposeUiNode.Companion.SetCompositeKeyHash;
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(r3))) {
            CrossfadeKt$Crossfade$5$1$$ExternalSyntheticOutline0.m(r3, composer, r3, composeUiNode$Companion$SetCompositeKeyHash$1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T extends android.view.View> void AndroidView(final kotlin.jvm.functions.Function1<? super android.content.Context, ? extends T> r16, androidx.compose.ui.Modifier r17, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r18, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r19, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
