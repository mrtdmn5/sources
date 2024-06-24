package androidx.compose.ui.platform;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.StaticProvidableCompositionLocal;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistry;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.base.Strings;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompositionLocals.kt */
/* loaded from: classes.dex */
public final class CompositionLocalsKt {
    public static final StaticProvidableCompositionLocal LocalAccessibilityManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<AccessibilityManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAccessibilityManager$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ AccessibilityManager invoke() {
            return null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalAutofill = CompositionLocalKt.staticCompositionLocalOf(new Function0<Autofill>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofill$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Autofill invoke() {
            return null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalAutofillTree = CompositionLocalKt.staticCompositionLocalOf(new Function0<AutofillTree>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalAutofillTree$1
        @Override // kotlin.jvm.functions.Function0
        public final AutofillTree invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalAutofillTree");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalClipboardManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<ClipboardManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalClipboardManager$1
        @Override // kotlin.jvm.functions.Function0
        public final ClipboardManager invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalClipboardManager");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalDensity = CompositionLocalKt.staticCompositionLocalOf(new Function0<Density>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalDensity$1
        @Override // kotlin.jvm.functions.Function0
        public final Density invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalDensity");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalFocusManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<FocusManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFocusManager$1
        @Override // kotlin.jvm.functions.Function0
        public final FocusManager invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalFocusManager");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalFontLoader = CompositionLocalKt.staticCompositionLocalOf(new Function0<Font.ResourceLoader>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontLoader$1
        @Override // kotlin.jvm.functions.Function0
        public final Font.ResourceLoader invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalFontLoader");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalFontFamilyResolver = CompositionLocalKt.staticCompositionLocalOf(new Function0<FontFamily.Resolver>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalFontFamilyResolver$1
        @Override // kotlin.jvm.functions.Function0
        public final FontFamily.Resolver invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalFontFamilyResolver");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalHapticFeedback = CompositionLocalKt.staticCompositionLocalOf(new Function0<HapticFeedback>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalHapticFeedback$1
        @Override // kotlin.jvm.functions.Function0
        public final HapticFeedback invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalHapticFeedback");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalInputModeManager = CompositionLocalKt.staticCompositionLocalOf(new Function0<InputModeManager>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalInputModeManager$1
        @Override // kotlin.jvm.functions.Function0
        public final InputModeManager invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalInputManager");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalLayoutDirection = CompositionLocalKt.staticCompositionLocalOf(new Function0<LayoutDirection>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalLayoutDirection$1
        @Override // kotlin.jvm.functions.Function0
        public final LayoutDirection invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalLayoutDirection");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalTextInputService = CompositionLocalKt.staticCompositionLocalOf(new Function0<TextInputService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextInputService$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ TextInputService invoke() {
            return null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalPlatformTextInputPluginRegistry = CompositionLocalKt.staticCompositionLocalOf(new Function0<PlatformTextInputPluginRegistry>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalPlatformTextInputPluginRegistry$1
        @Override // kotlin.jvm.functions.Function0
        public final PlatformTextInputPluginRegistry invoke() {
            throw new IllegalStateException("No PlatformTextInputPluginRegistry provided".toString());
        }
    });
    public static final StaticProvidableCompositionLocal LocalTextToolbar = CompositionLocalKt.staticCompositionLocalOf(new Function0<TextToolbar>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalTextToolbar$1
        @Override // kotlin.jvm.functions.Function0
        public final TextToolbar invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalTextToolbar");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalUriHandler = CompositionLocalKt.staticCompositionLocalOf(new Function0<UriHandler>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalUriHandler$1
        @Override // kotlin.jvm.functions.Function0
        public final UriHandler invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalUriHandler");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalViewConfiguration = CompositionLocalKt.staticCompositionLocalOf(new Function0<ViewConfiguration>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalViewConfiguration$1
        @Override // kotlin.jvm.functions.Function0
        public final ViewConfiguration invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalViewConfiguration");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalWindowInfo = CompositionLocalKt.staticCompositionLocalOf(new Function0<WindowInfo>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalWindowInfo$1
        @Override // kotlin.jvm.functions.Function0
        public final WindowInfo invoke() {
            CompositionLocalsKt.access$noLocalProvidedFor("LocalWindowInfo");
            throw null;
        }
    });
    public static final StaticProvidableCompositionLocal LocalPointerIconService = CompositionLocalKt.staticCompositionLocalOf(new Function0<PointerIconService>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$LocalPointerIconService$1
        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ PointerIconService invoke() {
            return null;
        }
    });

    public static final void ProvideCommonCompositionLocals(final Owner owner, final UriHandler uriHandler, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int r30) {
        int r5;
        int r6;
        int r62;
        int r52;
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(uriHandler, "uriHandler");
        Intrinsics.checkNotNullParameter(content, "content");
        ComposerImpl startRestartGroup = composer.startRestartGroup(874662829);
        if ((r30 & 14) == 0) {
            if (startRestartGroup.changed(owner)) {
                r52 = 4;
            } else {
                r52 = 2;
            }
            r5 = r52 | r30;
        } else {
            r5 = r30;
        }
        if ((r30 & 112) == 0) {
            if (startRestartGroup.changed(uriHandler)) {
                r62 = 32;
            } else {
                r62 = 16;
            }
            r5 |= r62;
        }
        if ((r30 & 896) == 0) {
            if (startRestartGroup.changedInstance(content)) {
                r6 = 256;
            } else {
                r6 = 128;
            }
            r5 |= r6;
        }
        if ((r5 & 731) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
            ProvidedValue<T> provides = LocalAccessibilityManager.provides(owner.getAccessibilityManager());
            ProvidedValue<T> provides2 = LocalAutofill.provides(owner.getAutofill());
            ProvidedValue<T> provides3 = LocalAutofillTree.provides(owner.getAutofillTree());
            ProvidedValue<T> provides4 = LocalClipboardManager.provides(owner.getClipboardManager());
            ProvidedValue<T> provides5 = LocalDensity.provides(owner.getDensity());
            ProvidedValue<T> provides6 = LocalFocusManager.provides(owner.getFocusOwner());
            Font.ResourceLoader fontLoader = owner.getFontLoader();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal = LocalFontLoader;
            staticProvidableCompositionLocal.getClass();
            ProvidedValue providedValue = new ProvidedValue(staticProvidableCompositionLocal, fontLoader, false);
            FontFamily.Resolver fontFamilyResolver = owner.getFontFamilyResolver();
            StaticProvidableCompositionLocal staticProvidableCompositionLocal2 = LocalFontFamilyResolver;
            staticProvidableCompositionLocal2.getClass();
            CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{provides, provides2, provides3, provides4, provides5, provides6, providedValue, new ProvidedValue(staticProvidableCompositionLocal2, fontFamilyResolver, false), LocalHapticFeedback.provides(owner.getHapticFeedBack()), LocalInputModeManager.provides(owner.getInputModeManager()), LocalLayoutDirection.provides(owner.getLayoutDirection()), LocalTextInputService.provides(owner.getTextInputService()), LocalPlatformTextInputPluginRegistry.provides(owner.getPlatformTextInputPluginRegistry()), LocalTextToolbar.provides(owner.getTextToolbar()), LocalUriHandler.provides(uriHandler), LocalViewConfiguration.provides(owner.getViewConfiguration()), LocalWindowInfo.provides(owner.getWindowInfo()), LocalPointerIconService.provides(owner.getPointerIconService())}, content, startRestartGroup, ((r5 >> 3) & 112) | 8);
        }
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.CompositionLocalsKt$ProvideCommonCompositionLocals$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r30 | 1);
                    UriHandler uriHandler2 = uriHandler;
                    Function2<Composer, Integer, Unit> function2 = content;
                    CompositionLocalsKt.ProvideCommonCompositionLocals(Owner.this, uriHandler2, function2, composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    public static final void access$noLocalProvidedFor(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
