package androidx.compose.ui.window;

import android.annotation.SuppressLint;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.DynamicProvidableCompositionLocal;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.common.base.Strings;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: AndroidPopup.android.kt */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public final class PopupLayout extends AbstractComposeView {
    public final DerivedSnapshotState canCalculatePosition$delegate;
    public final View composeView;
    public final ParcelableSnapshotMutableState content$delegate;
    public final int[] locationOnScreen;
    public Function0<Unit> onDismissRequest;
    public final WindowManager.LayoutParams params;
    public IntRect parentBounds;
    public final ParcelableSnapshotMutableState parentLayoutCoordinates$delegate;
    public LayoutDirection parentLayoutDirection;
    public final ParcelableSnapshotMutableState popupContentSize$delegate;
    public final PopupLayoutHelper popupLayoutHelper;
    public PopupPositionProvider positionProvider;
    public final Rect previousWindowVisibleFrame;
    public PopupProperties properties;
    public boolean shouldCreateCompositionOnAttachedToWindow;
    public String testTag;
    public final WindowManager windowManager;

    /* compiled from: AndroidPopup.android.kt */
    /* renamed from: androidx.compose.ui.window.PopupLayout$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass2 extends ViewOutlineProvider {
        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View view, Outline result) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(result, "result");
            result.setRect(0, 0, view.getWidth(), view.getHeight());
            result.setAlpha(0.0f);
        }
    }

    /* compiled from: AndroidPopup.android.kt */
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

    public PopupLayout() {
        throw null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PopupLayout(kotlin.jvm.functions.Function0 r6, androidx.compose.ui.window.PopupProperties r7, java.lang.String r8, android.view.View r9, androidx.compose.ui.unit.Density r10, androidx.compose.ui.window.PopupPositionProvider r11, java.util.UUID r12) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.PopupLayout.<init>(kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, java.lang.String, android.view.View, androidx.compose.ui.unit.Density, androidx.compose.ui.window.PopupPositionProvider, java.util.UUID):void");
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content$delegate.getValue();
    }

    private final int getDisplayHeight() {
        return MathKt__MathJVMKt.roundToInt(getContext().getResources().getConfiguration().screenHeightDp * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayWidth() {
        return MathKt__MathJVMKt.roundToInt(getContext().getResources().getConfiguration().screenWidthDp * getContext().getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void setClippingEnabled(boolean z) {
        int r3;
        WindowManager.LayoutParams layoutParams = this.params;
        if (z) {
            r3 = layoutParams.flags & (-513);
        } else {
            r3 = layoutParams.flags | DfuBaseService.ERROR_REMOTE_TYPE_SECURE;
        }
        layoutParams.flags = r3;
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content$delegate.setValue(function2);
    }

    private final void setIsFocusable(boolean z) {
        int r3;
        WindowManager.LayoutParams layoutParams = this.params;
        if (!z) {
            r3 = layoutParams.flags | 8;
        } else {
            r3 = layoutParams.flags & (-9);
        }
        layoutParams.flags = r3;
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.parentLayoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    private final void setSecurePolicy(SecureFlagPolicy secureFlagPolicy) {
        int r3;
        boolean shouldApplySecureFlag = SecureFlagPolicy_androidKt.shouldApplySecureFlag(secureFlagPolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        WindowManager.LayoutParams layoutParams = this.params;
        if (shouldApplySecureFlag) {
            r3 = layoutParams.flags | DfuBaseService.ERROR_REMOTE_MASK;
        } else {
            r3 = layoutParams.flags & (-8193);
        }
        layoutParams.flags = r3;
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void Content(Composer composer, final int r4) {
        ComposerImpl startRestartGroup = composer.startRestartGroup(-857613600);
        ComposerKt$removeCurrentGroupInstance$1 composerKt$removeCurrentGroupInstance$1 = ComposerKt.removeCurrentGroupInstance;
        getContent().invoke(startRestartGroup, 0);
        RecomposeScopeImpl endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.block = new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.window.PopupLayout$Content$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Composer composer2, Integer num) {
                    num.intValue();
                    int updateChangedFlags = Strings.updateChangedFlags(r4 | 1);
                    PopupLayout.this.Content(composer2, updateChangedFlags);
                    return Unit.INSTANCE;
                }
            };
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent event) {
        KeyEvent.DispatcherState keyDispatcherState;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getKeyCode() == 4 && this.properties.dismissOnBackPress) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(event, this);
                }
                return true;
            }
            if (event.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                Function0<Unit> function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.params;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m609getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public /* bridge */ /* synthetic */ View getViewRoot() {
        return null;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnLayout$ui_release(boolean z, int r2, int r3, int r4, int r5) {
        View childAt;
        super.internalOnLayout$ui_release(z, r2, r3, r4, r5);
        if (this.properties.usePlatformDefaultWidth || (childAt = getChildAt(0)) == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.width = childAt.getMeasuredWidth();
        layoutParams.height = childAt.getMeasuredHeight();
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public final void internalOnMeasure$ui_release(int r2, int r3) {
        if (this.properties.usePlatformDefaultWidth) {
            super.internalOnMeasure$ui_release(r2, r3);
        } else {
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), Integer.MIN_VALUE));
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.properties.dismissOnClickOutside) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z2 = false;
        if (motionEvent != null && motionEvent.getAction() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && (motionEvent.getX() < 0.0f || motionEvent.getX() >= getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() >= getHeight())) {
            Function0<Unit> function0 = this.onDismissRequest;
            if (function0 != null) {
                function0.invoke();
            }
            return true;
        }
        if (motionEvent != null && motionEvent.getAction() == 4) {
            z2 = true;
        }
        if (z2) {
            Function0<Unit> function02 = this.onDismissRequest;
            if (function02 != null) {
                function02.invoke();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.parentLayoutDirection = layoutDirection;
    }

    /* renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m610setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        Intrinsics.checkNotNullParameter(popupPositionProvider, "<set-?>");
        this.positionProvider = popupPositionProvider;
    }

    public final void setTestTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.testTag = str;
    }

    public final void updateParameters(Function0<Unit> function0, PopupProperties properties, String testTag, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        this.onDismissRequest = function0;
        if (properties.usePlatformDefaultWidth && !this.properties.usePlatformDefaultWidth) {
            WindowManager.LayoutParams layoutParams = this.params;
            layoutParams.width = -2;
            layoutParams.height = -2;
            this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
        }
        this.properties = properties;
        this.testTag = testTag;
        setIsFocusable(properties.focusable);
        setSecurePolicy(properties.securePolicy);
        setClippingEnabled(properties.clippingEnabled);
        int r3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int r4 = 1;
        if (r3 != 1) {
            if (r3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            r4 = 0;
        }
        super.setLayoutDirection(r4);
    }

    public final void updateParentBounds$ui_release() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates == null) {
            return;
        }
        long mo423getSizeYbymL2g = parentLayoutCoordinates.mo423getSizeYbymL2g();
        long mo426localToWindowMKHz9U = parentLayoutCoordinates.mo426localToWindowMKHz9U(Offset.Zero);
        long IntOffset = IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt(Offset.m259getXimpl(mo426localToWindowMKHz9U)), MathKt__MathJVMKt.roundToInt(Offset.m260getYimpl(mo426localToWindowMKHz9U)));
        int r6 = (int) (IntOffset >> 32);
        IntRect intRect = new IntRect(r6, IntOffset.m590getYimpl(IntOffset), ((int) (mo423getSizeYbymL2g >> 32)) + r6, IntSize.m593getHeightimpl(mo423getSizeYbymL2g) + IntOffset.m590getYimpl(IntOffset));
        if (!Intrinsics.areEqual(intRect, this.parentBounds)) {
            this.parentBounds = intRect;
            updatePosition();
        }
    }

    public final void updateParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        setParentLayoutCoordinates(layoutCoordinates);
        updateParentBounds$ui_release();
    }

    public final void updatePosition() {
        IntSize m609getPopupContentSizebOM6tXw;
        IntRect intRect = this.parentBounds;
        if (intRect != null && (m609getPopupContentSizebOM6tXw = m609getPopupContentSizebOM6tXw()) != null) {
            long j = m609getPopupContentSizebOM6tXw.packedValue;
            PopupLayoutHelper popupLayoutHelper = this.popupLayoutHelper;
            View view = this.composeView;
            Rect rect = this.previousWindowVisibleFrame;
            popupLayoutHelper.getWindowVisibleDisplayFrame(view, rect);
            DynamicProvidableCompositionLocal dynamicProvidableCompositionLocal = AndroidPopup_androidKt.LocalPopupTestTag;
            long IntSize = IntSizeKt.IntSize(rect.right - rect.left, rect.bottom - rect.top);
            long mo133calculatePositionllwVHH4 = this.positionProvider.mo133calculatePositionllwVHH4(intRect, IntSize, this.parentLayoutDirection, j);
            WindowManager.LayoutParams layoutParams = this.params;
            int r3 = IntOffset.$r8$clinit;
            layoutParams.x = (int) (mo133calculatePositionllwVHH4 >> 32);
            layoutParams.y = IntOffset.m590getYimpl(mo133calculatePositionllwVHH4);
            if (this.properties.excludeFromSystemGesture) {
                popupLayoutHelper.setGestureExclusionRects(this, (int) (IntSize >> 32), IntSize.m593getHeightimpl(IntSize));
            }
            popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
        }
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        setParentCompositionContext(parent);
        setContent(function2);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int r1) {
    }
}
