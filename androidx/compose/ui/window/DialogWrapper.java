package androidx.compose.ui.window;

import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ComponentDialog;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: AndroidDialog.android.kt */
/* loaded from: classes.dex */
public final class DialogWrapper extends ComponentDialog {
    public final View composeView;
    public final int defaultSoftInputMode;
    public final DialogLayout dialogLayout;
    public Function0<Unit> onDismissRequest;
    public DialogProperties properties;

    /* compiled from: AndroidDialog.android.kt */
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

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r6v6, types: [androidx.compose.ui.window.DialogWrapper$2] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public DialogWrapper(kotlin.jvm.functions.Function0<kotlin.Unit> r5, androidx.compose.ui.window.DialogProperties r6, android.view.View r7, androidx.compose.ui.unit.LayoutDirection r8, androidx.compose.ui.unit.Density r9, java.util.UUID r10) {
        /*
            r4 = this;
            java.lang.String r0 = "onDismissRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "properties"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "composeView"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "layoutDirection"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "density"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            android.view.ContextThemeWrapper r0 = new android.view.ContextThemeWrapper
            android.content.Context r1 = r7.getContext()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r2 >= r3) goto L2e
            boolean r3 = r6.decorFitsSystemWindows
            if (r3 == 0) goto L2a
            goto L2e
        L2a:
            r3 = 2132083017(0x7f150149, float:1.9806164E38)
            goto L31
        L2e:
            r3 = 2132083011(0x7f150143, float:1.9806152E38)
        L31:
            r0.<init>(r1, r3)
            r4.<init>(r0)
            r4.onDismissRequest = r5
            r4.properties = r6
            r4.composeView = r7
            r5 = 8
            float r5 = (float) r5
            android.view.Window r6 = r4.getWindow()
            if (r6 == 0) goto Le5
            android.view.WindowManager$LayoutParams r0 = r6.getAttributes()
            int r0 = r0.softInputMode
            r0 = r0 & 240(0xf0, float:3.36E-43)
            r4.defaultSoftInputMode = r0
            r0 = 1
            r6.requestFeature(r0)
            r1 = 17170445(0x106000d, float:2.461195E-38)
            r6.setBackgroundDrawableResource(r1)
            androidx.compose.ui.window.DialogProperties r1 = r4.properties
            boolean r1 = r1.decorFitsSystemWindows
            r3 = 30
            if (r2 < r3) goto L66
            androidx.core.view.WindowCompat$Api30Impl.setDecorFitsSystemWindows(r6, r1)
            goto L69
        L66:
            androidx.core.view.WindowCompat$Api16Impl.setDecorFitsSystemWindows(r6, r1)
        L69:
            androidx.compose.ui.window.DialogLayout r1 = new androidx.compose.ui.window.DialogLayout
            android.content.Context r2 = r4.getContext()
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r1.<init>(r2, r6)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Dialog:"
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r2 = 2131427566(0x7f0b00ee, float:1.8476752E38)
            r1.setTag(r2, r10)
            r10 = 0
            r1.setClipChildren(r10)
            float r5 = r9.mo49toPx0680j_4(r5)
            r1.setElevation(r5)
            androidx.compose.ui.window.DialogWrapper$1$2 r5 = new androidx.compose.ui.window.DialogWrapper$1$2
            r5.<init>()
            r1.setOutlineProvider(r5)
            r4.dialogLayout = r1
            android.view.View r5 = r6.getDecorView()
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto Lab
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto Lac
        Lab:
            r5 = 0
        Lac:
            if (r5 == 0) goto Lb1
            _init_$disableClipping(r5)
        Lb1:
            r4.setContentView(r1)
            androidx.lifecycle.LifecycleOwner r5 = androidx.lifecycle.ViewTreeLifecycleOwner.get(r7)
            androidx.lifecycle.ViewTreeLifecycleOwner.set(r1, r5)
            androidx.lifecycle.ViewModelStoreOwner r5 = androidx.lifecycle.ViewTreeViewModelStoreOwner.get(r7)
            androidx.lifecycle.ViewTreeViewModelStoreOwner.set(r1, r5)
            androidx.savedstate.SavedStateRegistryOwner r5 = androidx.savedstate.ViewTreeSavedStateRegistryOwner.get(r7)
            androidx.savedstate.ViewTreeSavedStateRegistryOwner.set(r1, r5)
            kotlin.jvm.functions.Function0<kotlin.Unit> r5 = r4.onDismissRequest
            androidx.compose.ui.window.DialogProperties r6 = r4.properties
            r4.updateParameters(r5, r6, r8)
            androidx.activity.OnBackPressedDispatcher r5 = r4.onBackPressedDispatcher
            androidx.compose.ui.window.DialogWrapper$2 r6 = new androidx.compose.ui.window.DialogWrapper$2
            r6.<init>()
            java.lang.String r7 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1 r7 = new androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1
            r7.<init>(r0)
            r5.addCallback(r4, r7)
            return
        Le5:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "Dialog has no window"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.DialogWrapper.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.window.DialogProperties, android.view.View, androidx.compose.ui.unit.LayoutDirection, androidx.compose.ui.unit.Density, java.util.UUID):void");
    }

    public static final void _init_$disableClipping(ViewGroup viewGroup) {
        ViewGroup viewGroup2;
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int r0 = 0; r0 < childCount; r0++) {
            View childAt = viewGroup.getChildAt(r0);
            if (childAt instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) childAt;
            } else {
                viewGroup2 = null;
            }
            if (viewGroup2 != null) {
                _init_$disableClipping(viewGroup2);
            }
        }
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = super.onTouchEvent(event);
        if (onTouchEvent && this.properties.dismissOnClickOutside) {
            this.onDismissRequest.invoke();
        }
        return onTouchEvent;
    }

    public final void updateParameters(Function0<Unit> onDismissRequest, DialogProperties properties, LayoutDirection layoutDirection) {
        int r3;
        Window window;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        boolean shouldApplySecureFlag = SecureFlagPolicy_androidKt.shouldApplySecureFlag(properties.securePolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        if (shouldApplySecureFlag) {
            r3 = 8192;
        } else {
            r3 = -8193;
        }
        window2.setFlags(r3, DfuBaseService.ERROR_REMOTE_MASK);
        int r32 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int r5 = 1;
        if (r32 != 1) {
            if (r32 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            r5 = 0;
        }
        DialogLayout dialogLayout = this.dialogLayout;
        dialogLayout.setLayoutDirection(r5);
        boolean z = properties.usePlatformDefaultWidth;
        if (z && !dialogLayout.usePlatformDefaultWidth && (window = getWindow()) != null) {
            window.setLayout(-2, -2);
        }
        dialogLayout.usePlatformDefaultWidth = z;
        if (Build.VERSION.SDK_INT < 31) {
            if (properties.decorFitsSystemWindows) {
                Window window3 = getWindow();
                if (window3 != null) {
                    window3.setSoftInputMode(this.defaultSoftInputMode);
                    return;
                }
                return;
            }
            Window window4 = getWindow();
            if (window4 != null) {
                window4.setSoftInputMode(16);
            }
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void cancel() {
    }
}
