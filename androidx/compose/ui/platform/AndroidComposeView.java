package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.activity.ComponentDialog$$ExternalSyntheticLambda1;
import androidx.compose.runtime.DerivedSnapshotState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.ReferentialEqualityPolicy;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.Snapshot$Companion$registerApplyObserver$2;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt$$ExternalSyntheticApiModelOutline0;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillApi23Helper;
import androidx.compose.ui.autofill.AutofillApi26Helper;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillNode;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusOwnerImpl;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$2;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DepthSortedSetsForDifferentPasses;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1;
import androidx.compose.ui.node.OnPositionedDispatcher;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.OwnerSnapshotObserver$clearInvalidObservations$1;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.semantics.EmptySemanticsElement;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.AndroidTextInputServicePlugin;
import androidx.compose.ui.text.input.PlatformTextInput;
import androidx.compose.ui.text.input.PlatformTextInputAdapter;
import androidx.compose.ui.text.input.PlatformTextInputPlugin;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.common.base.Strings;
import com.google.common.collect.Platform;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlinx.datetime.TimeZoneKt;

/* compiled from: AndroidComposeView.android.kt */
@SuppressLint({"ViewConstructor", "VisibleForTests"})
/* loaded from: classes.dex */
public final class AndroidComposeView extends ViewGroup implements Owner, RootForTest, PositionCalculator, DefaultLifecycleObserver {
    public static Method getBooleanMethod;
    public static Class<?> systemPropertiesClass;
    public AndroidViewsHandler _androidViewsHandler;
    public final AndroidAutofill _autofill;
    public final InputModeManagerImpl _inputModeManager;
    public final ParcelableSnapshotMutableState _viewTreeOwners$delegate;
    public final WindowInfoImpl _windowInfo;
    public final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    public final AndroidAccessibilityManager accessibilityManager;
    public final AutofillTree autofillTree;
    public final CanvasHolder canvasHolder;
    public final AndroidClipboardManager clipboardManager;
    public Function1<? super Configuration, Unit> configurationChangeObserver;
    public final CoroutineContext coroutineContext;
    public int currentFontWeightAdjustment;
    public DensityImpl density;
    public final ArrayList dirtyLayers;
    public final MutableVector<Function0<Unit>> endApplyChangesListeners;
    public final FocusOwnerImpl focusOwner;
    public final ParcelableSnapshotMutableState fontFamilyResolver$delegate;
    public final AndroidFontResourceLoader fontLoader;
    public boolean forceUseMatrixCache;
    public final AndroidComposeView$$ExternalSyntheticLambda1 globalLayoutListener;
    public long globalPosition;
    public final PlatformHapticFeedback hapticFeedBack;
    public boolean hoverExitReceived;
    public boolean isDrawingContent;
    public boolean isRenderNodeCompatible;
    public final Modifier keyInputModifier;
    public boolean keyboardModifiersRequireUpdate;
    public long lastDownPointerPosition;
    public long lastMatrixRecalculationAnimationTime;
    public final WeakCache<OwnedLayer> layerCache;
    public final ParcelableSnapshotMutableState layoutDirection$delegate;
    public final CalculateMatrixToWindow matrixToWindow;
    public final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    public final ModifierLocalManager modifierLocalManager;
    public final MotionEventAdapter motionEventAdapter;
    public boolean observationClearRequested;
    public Constraints onMeasureConstraints;
    public Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    public final PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry;
    public final AndroidComposeView$pointerIconService$1 pointerIconService;
    public final PointerInputEventProcessor pointerInputEventProcessor;
    public ArrayList postponedDirtyLayers;
    public MotionEvent previousMotionEvent;
    public long relayoutTime;
    public final AndroidComposeView$resendMotionEventOnLayout$1 resendMotionEventOnLayout;
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    public final LayoutNode root;
    public final AndroidComposeView rootForTest;
    public final Modifier rotaryInputModifier;
    public final AndroidComposeView$$ExternalSyntheticLambda2 scrollChangedListener;
    public final SemanticsOwner semanticsOwner;
    public final ComponentDialog$$ExternalSyntheticLambda1 sendHoverExitEvent;
    public final LayoutNodeDrawScope sharedDrawScope;
    public boolean showLayoutBounds;
    public final OwnerSnapshotObserver snapshotObserver;
    public final boolean superclassInitComplete;
    public final TextInputService textInputService;
    public final AndroidTextToolbar textToolbar;
    public final int[] tmpPositionArray;
    public final AndroidComposeView$$ExternalSyntheticLambda3 touchModeChangeListener;
    public final AndroidViewConfiguration viewConfiguration;
    public DrawChildContainer viewLayersContainer;
    public final float[] viewToWindowMatrix;
    public final DerivedSnapshotState viewTreeOwners$delegate;
    public boolean wasMeasuredWithMultipleConstraints;
    public long windowPosition;
    public final float[] windowToViewMatrix;

    /* compiled from: AndroidComposeView.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public static final boolean access$getIsShowingLayoutBounds() {
            Object obj;
            Class<?> cls = AndroidComposeView.systemPropertiesClass;
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    Class<?> cls2 = Class.forName("android.os.SystemProperties");
                    AndroidComposeView.systemPropertiesClass = cls2;
                    AndroidComposeView.getBooleanMethod = cls2.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Boolean bool = null;
                if (method != null) {
                    obj = method.invoke(null, "debug.layout", Boolean.FALSE);
                } else {
                    obj = null;
                }
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                }
                if (bool == null) {
                    return false;
                }
                return bool.booleanValue();
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* compiled from: AndroidComposeView.android.kt */
    /* loaded from: classes.dex */
    public static final class ViewTreeOwners {
        public final LifecycleOwner lifecycleOwner;
        public final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(LifecycleOwner lifecycleOwner, SavedStateRegistryOwner savedStateRegistryOwner) {
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }
    }

    static {
        new Companion();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r11v13, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    /* JADX WARN: Type inference failed for: r11v17, types: [androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1] */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.compose.ui.platform.AndroidComposeView$focusOwner$1] */
    /* JADX WARN: Type inference failed for: r4v18, types: [androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r4v19, types: [androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2] */
    /* JADX WARN: Type inference failed for: r4v20, types: [androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3] */
    /* JADX WARN: Type inference failed for: r6v11, types: [androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1] */
    /* JADX WARN: Type inference failed for: r6v5, types: [androidx.compose.ui.platform.AndroidComposeView$platformTextInputPluginRegistry$1] */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.compose.ui.platform.AndroidComposeView$snapshotObserver$1] */
    public AndroidComposeView(Context context, CoroutineContext coroutineContext) {
        super(context);
        boolean z;
        AndroidAutofill androidAutofill;
        int r4;
        LayoutDirection layoutDirection;
        int r42;
        CalculateMatrixToWindow calculateMatrixToWindowApi21;
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lastDownPointerPosition = Offset.Unspecified;
        int r0 = 1;
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope();
        this.density = TimeZoneKt.Density(context);
        EmptySemanticsElement other = EmptySemanticsElement.INSTANCE;
        this.focusOwner = new FocusOwnerImpl(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$focusOwner$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function0<? extends Unit> function0) {
                Function0<? extends Unit> it = function0;
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeView.this.registerOnEndApplyChangesListener(it);
                return Unit.INSTANCE;
            }
        });
        this._windowInfo = new WindowInfoImpl();
        Modifier onKeyEvent = KeyInputModifierKt.onKeyEvent(Modifier.Companion.$$INSTANCE, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$keyInputModifier$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(KeyEvent keyEvent) {
                boolean m398equalsimpl0;
                boolean m398equalsimpl02;
                boolean m398equalsimpl03;
                FocusDirection focusDirection;
                int r1;
                android.view.KeyEvent it = keyEvent.nativeKeyEvent;
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeView androidComposeView = AndroidComposeView.this;
                androidComposeView.getClass();
                long m399getKeyZmokQxo = KeyEvent_androidKt.m399getKeyZmokQxo(it);
                boolean z2 = true;
                if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.Tab)) {
                    if (it.isShiftPressed()) {
                        r1 = 2;
                    } else {
                        r1 = 1;
                    }
                    focusDirection = new FocusDirection(r1);
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.DirectionRight)) {
                    focusDirection = new FocusDirection(4);
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.DirectionLeft)) {
                    focusDirection = new FocusDirection(3);
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.DirectionUp)) {
                    focusDirection = new FocusDirection(5);
                } else if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.DirectionDown)) {
                    focusDirection = new FocusDirection(6);
                } else {
                    if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.DirectionCenter)) {
                        m398equalsimpl0 = true;
                    } else {
                        m398equalsimpl0 = Key.m398equalsimpl0(m399getKeyZmokQxo, Key.Enter);
                    }
                    if (m398equalsimpl0) {
                        m398equalsimpl02 = true;
                    } else {
                        m398equalsimpl02 = Key.m398equalsimpl0(m399getKeyZmokQxo, Key.NumPadEnter);
                    }
                    if (m398equalsimpl02) {
                        focusDirection = new FocusDirection(7);
                    } else {
                        if (Key.m398equalsimpl0(m399getKeyZmokQxo, Key.Back)) {
                            m398equalsimpl03 = true;
                        } else {
                            m398equalsimpl03 = Key.m398equalsimpl0(m399getKeyZmokQxo, Key.Escape);
                        }
                        if (m398equalsimpl03) {
                            focusDirection = new FocusDirection(8);
                        } else {
                            focusDirection = null;
                        }
                    }
                }
                if (focusDirection != null) {
                    if (KeyEvent_androidKt.m400getTypeZmokQxo(it) != 2) {
                        z2 = false;
                    }
                    if (z2) {
                        return Boolean.valueOf(androidComposeView.getFocusOwner().mo238moveFocus3ESFkO8(focusDirection.value));
                    }
                }
                return Boolean.FALSE;
            }
        });
        this.keyInputModifier = onKeyEvent;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 3, 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        Intrinsics.checkNotNullParameter(other, "other");
        layoutNode.setModifier(other.then(onRotaryScrollEvent).then(getFocusOwner().getModifier()).then(onKeyEvent));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = new Function1<Configuration, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$configurationChangeObserver$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Configuration configuration) {
                Configuration it = configuration;
                Intrinsics.checkNotNullParameter(it, "it");
                return Unit.INSTANCE;
            }
        };
        int r2 = Build.VERSION.SDK_INT;
        if (r2 >= 26) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            androidAutofill = new AndroidAutofill(this, getAutofillTree());
        } else {
            androidAutofill = null;
        }
        this._autofill = androidAutofill;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$snapshotObserver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function0<? extends Unit> function0) {
                Looper looper;
                final Function0<? extends Unit> command = function0;
                Intrinsics.checkNotNullParameter(command, "command");
                AndroidComposeView androidComposeView = AndroidComposeView.this;
                Handler handler = androidComposeView.getHandler();
                if (handler != null) {
                    looper = handler.getLooper();
                } else {
                    looper = null;
                }
                if (looper == Looper.myLooper()) {
                    command.invoke();
                } else {
                    Handler handler2 = androidComposeView.getHandler();
                    if (handler2 != null) {
                        handler2.post(new Runnable() { // from class: androidx.activity.FullyDrawnReporter$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                Function0 tmp0 = (Function0) command;
                                Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                                tmp0.invoke();
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
        });
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m337constructorimpl$default();
        this.windowToViewMatrix = Matrix.m337constructorimpl$default();
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = Offset.Infinite;
        this.isRenderNodeCompatible = true;
        this._viewTreeOwners$delegate = Platform.mutableStateOf$default(null);
        this.viewTreeOwners$delegate = Platform.derivedStateOf(new Function0<ViewTreeOwners>() { // from class: androidx.compose.ui.platform.AndroidComposeView$viewTreeOwners$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AndroidComposeView.ViewTreeOwners invoke() {
                AndroidComposeView.ViewTreeOwners viewTreeOwners;
                viewTreeOwners = AndroidComposeView.this.get_viewTreeOwners();
                return viewTreeOwners;
            }
        });
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                Class<?> cls = AndroidComposeView.systemPropertiesClass;
                AndroidComposeView this$0 = AndroidComposeView.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.updatePositionCacheAndDispatch();
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda2
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                Class<?> cls = AndroidComposeView.systemPropertiesClass;
                AndroidComposeView this$0 = AndroidComposeView.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.updatePositionCacheAndDispatch();
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeView$$ExternalSyntheticLambda3
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z2) {
                int r3;
                Class<?> cls = AndroidComposeView.systemPropertiesClass;
                AndroidComposeView this$0 = AndroidComposeView.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (z2) {
                    r3 = 1;
                } else {
                    r3 = 2;
                }
                InputModeManagerImpl inputModeManagerImpl = this$0._inputModeManager;
                inputModeManagerImpl.getClass();
                inputModeManagerImpl.inputMode$delegate.setValue(new InputMode(r3));
            }
        };
        this.platformTextInputPluginRegistry = new PlatformTextInputPluginRegistryImpl(new Function2<PlatformTextInputPlugin<?>, PlatformTextInput, PlatformTextInputAdapter>() { // from class: androidx.compose.ui.platform.AndroidComposeView$platformTextInputPluginRegistry$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final PlatformTextInputAdapter invoke(PlatformTextInputPlugin<?> platformTextInputPlugin, PlatformTextInput platformTextInput) {
                PlatformTextInputPlugin<?> factory = platformTextInputPlugin;
                PlatformTextInput platformTextInput2 = platformTextInput;
                Intrinsics.checkNotNullParameter(factory, "factory");
                Intrinsics.checkNotNullParameter(platformTextInput2, "platformTextInput");
                return factory.createAdapter(AndroidComposeView.this, platformTextInput2);
            }
        });
        PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry = getPlatformTextInputPluginRegistry();
        AndroidTextInputServicePlugin androidTextInputServicePlugin = AndroidTextInputServicePlugin.INSTANCE;
        platformTextInputPluginRegistry.getClass();
        SnapshotStateMap<PlatformTextInputPlugin<?>, PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<?>> snapshotStateMap = platformTextInputPluginRegistry.adaptersByPlugin;
        final PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<?> adapterWithRefCount = snapshotStateMap.get(androidTextInputServicePlugin);
        if (adapterWithRefCount == null) {
            PlatformTextInputAdapter invoke = platformTextInputPluginRegistry.factory.invoke(androidTextInputServicePlugin, new PlatformTextInputPluginRegistryImpl.AdapterInput(platformTextInputPluginRegistry));
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type T of androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.instantiateAdapter");
            PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<?> adapterWithRefCount2 = new PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<>(invoke);
            snapshotStateMap.put(androidTextInputServicePlugin, adapterWithRefCount2);
            adapterWithRefCount = adapterWithRefCount2;
        }
        adapterWithRefCount.refCount$delegate.setIntValue(adapterWithRefCount.refCount$delegate.getIntValue() + 1);
        new Function0<Boolean>() { // from class: androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl$getOrCreateAdapter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z2;
                PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<Object> adapterWithRefCount3 = adapterWithRefCount;
                int intValue = adapterWithRefCount3.refCount$delegate.getIntValue() - 1;
                ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = adapterWithRefCount3.refCount$delegate;
                parcelableSnapshotMutableIntState.setIntValue(intValue);
                boolean z3 = true;
                if (parcelableSnapshotMutableIntState.getIntValue() >= 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    if (parcelableSnapshotMutableIntState.getIntValue() == 0) {
                        PlatformTextInputPluginRegistryImpl.this.getClass();
                    } else {
                        z3 = false;
                    }
                    return Boolean.valueOf(z3);
                }
                throw new IllegalStateException(("AdapterWithRefCount.decrementRefCount called too many times (refCount=" + parcelableSnapshotMutableIntState.getIntValue() + ')').toString());
            }
        };
        T adapter = adapterWithRefCount.adapter;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.textInputService = ((AndroidTextInputServicePlugin.Adapter) adapter).service;
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = Platform.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), ReferentialEqualityPolicy.INSTANCE);
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        if (r2 >= 31) {
            r4 = configuration.fontWeightAdjustment;
        } else {
            r4 = 0;
        }
        this.currentFontWeightAdjustment = r4;
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        int layoutDirection2 = configuration2.getLayoutDirection();
        if (layoutDirection2 != 0) {
            if (layoutDirection2 != 1) {
                layoutDirection = LayoutDirection.Ltr;
            } else {
                layoutDirection = LayoutDirection.Rtl;
            }
        } else {
            layoutDirection = LayoutDirection.Ltr;
        }
        this.layoutDirection$delegate = Platform.mutableStateOf$default(layoutDirection);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        if (isInTouchMode()) {
            r42 = 1;
        } else {
            r42 = 2;
        }
        this._inputModeManager = new InputModeManagerImpl(r42, new Function1<InputMode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$_inputModeManager$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(InputMode inputMode) {
                boolean z2;
                boolean z3;
                int r5 = inputMode.value;
                boolean z4 = false;
                if (r5 == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                AndroidComposeView androidComposeView = AndroidComposeView.this;
                if (z2) {
                    z4 = androidComposeView.isInTouchMode();
                } else {
                    if (r5 == 2) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        if (androidComposeView.isInTouchMode()) {
                            z4 = androidComposeView.requestFocusFromTouch();
                        } else {
                            z4 = true;
                        }
                    }
                }
                return Boolean.valueOf(z4);
            }
        });
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.coroutineContext = coroutineContext;
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16]);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                boolean z2;
                AndroidComposeView androidComposeView = AndroidComposeView.this;
                androidComposeView.removeCallbacks(this);
                MotionEvent motionEvent = androidComposeView.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z3 = false;
                    if (motionEvent.getToolType(0) == 3) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    int actionMasked = motionEvent.getActionMasked();
                    if (!z2 ? actionMasked != 1 : !(actionMasked == 10 || actionMasked == 1)) {
                        z3 = true;
                    }
                    if (z3) {
                        int r02 = 7;
                        if (actionMasked != 7 && actionMasked != 9) {
                            r02 = 2;
                        }
                        AndroidComposeView androidComposeView2 = AndroidComposeView.this;
                        androidComposeView2.sendSimulatedEvent(motionEvent, r02, androidComposeView2.relayoutTime, false);
                    }
                }
            }
        };
        this.sendHoverExitEvent = new ComponentDialog$$ExternalSyntheticLambda1(this, r0);
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        if (r2 >= 29) {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindowApi21 = new CalculateMatrixToWindowApi21();
        }
        this.matrixToWindow = calculateMatrixToWindowApi21;
        setWillNotDraw(false);
        setFocusable(true);
        if (r2 >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        getRoot().attach$ui_release(this);
        if (r2 >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            public PointerIcon currentIcon;

            {
                PointerIcon.Companion.getClass();
                this.currentIcon = Strings.pointerIconDefault;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public final void setIcon(PointerIcon pointerIcon) {
                if (pointerIcon == null) {
                    PointerIcon.Companion.getClass();
                    pointerIcon = Strings.pointerIconDefault;
                }
                this.currentIcon = pointerIcon;
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(AndroidComposeView.this, pointerIcon);
            }
        };
    }

    public static final void access$addExtraDataToAccessibilityNodeInfoHelper(AndroidComposeView androidComposeView, int r2, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        Integer num;
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = androidComposeView.accessibilityDelegate;
        if (Intrinsics.areEqual(str, androidComposeViewAccessibilityDelegateCompat.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL)) {
            Integer num2 = androidComposeViewAccessibilityDelegateCompat.idToBeforeMap.get(Integer.valueOf(r2));
            if (num2 != null) {
                accessibilityNodeInfo.getExtras().putInt(str, num2.intValue());
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, androidComposeViewAccessibilityDelegateCompat.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL) && (num = androidComposeViewAccessibilityDelegateCompat.idToAfterMap.get(Integer.valueOf(r2))) != null) {
            accessibilityNodeInfo.getExtras().putInt(str, num.intValue());
        }
    }

    public static void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            View childAt = viewGroup.getChildAt(r1);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    /* renamed from: convertMeasureSpec-I7RO_PI, reason: not valid java name */
    public static long m486convertMeasureSpecI7RO_PI(int r4) {
        long j;
        long j2;
        int mode = View.MeasureSpec.getMode(r4);
        int size = View.MeasureSpec.getSize(r4);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 0) {
                if (mode == 1073741824) {
                    j2 = size;
                    j = j2 << 32;
                    return j | j2;
                }
                throw new IllegalStateException();
            }
            j = 0 << 32;
            size = Integer.MAX_VALUE;
        } else {
            j = 0 << 32;
        }
        j2 = size;
        return j | j2;
    }

    public static View findViewByAccessibilityIdRootedAtCurrentView(int r4, View view) {
        if (Build.VERSION.SDK_INT < 29) {
            Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
            declaredMethod.setAccessible(true);
            if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), Integer.valueOf(r4))) {
                return view;
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int r0 = 0; r0 < childCount; r0++) {
                    View childAt = viewGroup.getChildAt(r0);
                    Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
                    View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(r4, childAt);
                    if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                        return findViewByAccessibilityIdRootedAtCurrentView;
                    }
                }
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ViewTreeOwners get_viewTreeOwners() {
        return (ViewTreeOwners) this._viewTreeOwners$delegate.getValue();
    }

    public static void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int r0 = mutableVector.size;
        if (r0 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int r1 = 0;
            do {
                invalidateLayers(layoutNodeArr[r1]);
                r1++;
            } while (r1 < r0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a6 A[LOOP:0: B:28:0x0061->B:49:0x00a6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a9 A[EDGE_INSN: B:50:0x00a9->B:56:0x00a9 BREAK  A[LOOP:0: B:28:0x0061->B:49:0x00a6], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isBadMotionEvent(android.view.MotionEvent r6) {
        /*
            float r0 = r6.getX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L14
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L14
            r0 = r3
            goto L15
        L14:
            r0 = r2
        L15:
            if (r0 == 0) goto L59
            float r0 = r6.getY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L29
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L29
            r0 = r3
            goto L2a
        L29:
            r0 = r2
        L2a:
            if (r0 == 0) goto L59
            float r0 = r6.getRawX()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L3e
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L3e
            r0 = r3
            goto L3f
        L3e:
            r0 = r2
        L3f:
            if (r0 == 0) goto L59
            float r0 = r6.getRawY()
            boolean r1 = java.lang.Float.isInfinite(r0)
            if (r1 != 0) goto L53
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L53
            r0 = r3
            goto L54
        L53:
            r0 = r2
        L54:
            if (r0 != 0) goto L57
            goto L59
        L57:
            r0 = r2
            goto L5a
        L59:
            r0 = r3
        L5a:
            if (r0 != 0) goto La9
            int r1 = r6.getPointerCount()
            r4 = r3
        L61:
            if (r4 >= r1) goto La9
            float r0 = r6.getX(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L75
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L75
            r0 = r3
            goto L76
        L75:
            r0 = r2
        L76:
            if (r0 == 0) goto La3
            float r0 = r6.getY(r4)
            boolean r5 = java.lang.Float.isInfinite(r0)
            if (r5 != 0) goto L8a
            boolean r0 = java.lang.Float.isNaN(r0)
            if (r0 != 0) goto L8a
            r0 = r3
            goto L8b
        L8a:
            r0 = r2
        L8b:
            if (r0 == 0) goto La3
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 29
            if (r0 < r5) goto L9d
            androidx.compose.ui.platform.MotionEventVerifierApi29 r0 = androidx.compose.ui.platform.MotionEventVerifierApi29.INSTANCE
            boolean r0 = r0.isValidMotionEvent(r6, r4)
            if (r0 != 0) goto L9d
            r0 = r3
            goto L9e
        L9d:
            r0 = r2
        L9e:
            if (r0 == 0) goto La1
            goto La3
        La1:
            r0 = r2
            goto La4
        La3:
            r0 = r3
        La4:
            if (r0 != 0) goto La9
            int r4 = r4 + 1
            goto L61
        La9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.isBadMotionEvent(android.view.MotionEvent):boolean");
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void set_viewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this._viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    @Override // android.view.View
    public final void autofill(SparseArray<AutofillValue> values) {
        boolean z;
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(values, "values");
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        } else {
            z = false;
        }
        if (z && (androidAutofill = this._autofill) != null) {
            int size = values.size();
            for (int r2 = 0; r2 < size; r2++) {
                int keyAt = values.keyAt(r2);
                AutofillValue value = AndroidAutofill_androidKt$$ExternalSyntheticApiModelOutline0.m(values.get(keyAt));
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(value, "value");
                if (autofillApi26Helper.isText(value)) {
                    String value2 = autofillApi26Helper.textValue(value).toString();
                    AutofillTree autofillTree = androidAutofill.autofillTree;
                    autofillTree.getClass();
                    Intrinsics.checkNotNullParameter(value2, "value");
                } else if (!autofillApi26Helper.isDate(value)) {
                    if (!autofillApi26Helper.isList(value)) {
                        if (autofillApi26Helper.isToggle(value)) {
                            throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                        }
                    } else {
                        throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                    }
                } else {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculateLocalPosition-MK-Hz9U */
    public final long mo482calculateLocalPositionMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m338mapMKHz9U(this.windowToViewMatrix, j);
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: calculatePositionInWindow-MK-Hz9U */
    public final long mo483calculatePositionInWindowMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m338mapMKHz9U(this.viewToWindowMatrix, j);
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r5) {
        return this.accessibilityDelegate.m489canScroll0AR0LA0$ui_release(r5, this.lastDownPointerPosition, false);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r5) {
        return this.accessibilityDelegate.m489canScroll0AR0LA0$ui_release(r5, this.lastDownPointerPosition, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.node.Owner
    public final OwnedLayer createLayer(Function1 drawBlock, NodeCoordinator$invalidateParentLayer$1 invalidateParentLayer) {
        WeakCache<OwnedLayer> weakCache;
        Reference<? extends OwnedLayer> poll;
        OwnedLayer ownedLayer;
        DrawChildContainer viewLayerContainer;
        Intrinsics.checkNotNullParameter(drawBlock, "drawBlock");
        Intrinsics.checkNotNullParameter(invalidateParentLayer, "invalidateParentLayer");
        do {
            weakCache = this.layerCache;
            poll = weakCache.referenceQueue.poll();
            if (poll != null) {
                weakCache.values.remove(poll);
            }
        } while (poll != null);
        while (true) {
            MutableVector<Reference<OwnedLayer>> mutableVector = weakCache.values;
            if (mutableVector.isNotEmpty()) {
                ownedLayer = mutableVector.removeAt(mutableVector.size - 1).get();
                if (ownedLayer != null) {
                    break;
                }
            } else {
                ownedLayer = null;
                break;
            }
        }
        OwnedLayer ownedLayer2 = ownedLayer;
        if (ownedLayer2 != null) {
            ownedLayer2.reuseLayer(drawBlock, invalidateParentLayer);
            return ownedLayer2;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            if (!ViewLayer.hasRetrievedMethod) {
                ViewLayer.Companion.updateDisplayList(new View(getContext()));
            }
            if (ViewLayer.shouldUseDispatchDraw) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                viewLayerContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                viewLayerContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        measureAndLayout(true);
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        AndroidCanvas androidCanvas = canvasHolder.androidCanvas;
        Canvas canvas2 = androidCanvas.internalCanvas;
        androidCanvas.internalCanvas = canvas;
        LayoutNode root = getRoot();
        AndroidCanvas androidCanvas2 = canvasHolder.androidCanvas;
        root.draw$ui_release(androidCanvas2);
        androidCanvas2.setInternalCanvas(canvas2);
        ArrayList arrayList = this.dirtyLayers;
        if (true ^ arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int r3 = 0; r3 < size; r3++) {
                ((OwnedLayer) arrayList.get(r3)).updateDisplayList();
            }
        }
        if (ViewLayer.shouldUseDispatchDraw) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        arrayList.clear();
        this.isDrawingContent = false;
        ArrayList arrayList2 = this.postponedDirtyLayers;
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
            arrayList2.clear();
        }
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent event) {
        float legacyScrollFactor;
        float legacyScrollFactor2;
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getActionMasked() == 8) {
            if (event.isFromSource(4194304)) {
                android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
                float f = -event.getAxisValue(26);
                Context context = getContext();
                int r5 = Build.VERSION.SDK_INT;
                if (r5 >= 26) {
                    Method method = ViewConfigurationCompat.sGetScaledScrollFactorMethod;
                    legacyScrollFactor = ViewConfigurationCompat.Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
                } else {
                    legacyScrollFactor = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
                }
                float f2 = legacyScrollFactor * f;
                Context context2 = getContext();
                if (r5 >= 26) {
                    legacyScrollFactor2 = ViewConfigurationCompat.Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
                } else {
                    legacyScrollFactor2 = ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context2);
                }
                return getFocusOwner().dispatchRotaryEvent(new RotaryScrollEvent(f2, legacyScrollFactor2 * f, event.getEventTime()));
            }
            if (!isBadMotionEvent(event) && isAttachedToWindow()) {
                if ((m487handleMotionEvent8iAsVTc(event) & 1) != 0) {
                    return true;
                }
                return false;
            }
            return super.dispatchGenericMotionEvent(event);
        }
        return super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchHoverEvent(MotionEvent event) {
        boolean z;
        LayoutNode layoutNode;
        boolean z2;
        boolean z3;
        boolean z4;
        NodeChain nodeChain;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z5 = this.hoverExitReceived;
        ComponentDialog$$ExternalSyntheticLambda1 componentDialog$$ExternalSyntheticLambda1 = this.sendHoverExitEvent;
        if (z5) {
            removeCallbacks(componentDialog$$ExternalSyntheticLambda1);
            componentDialog$$ExternalSyntheticLambda1.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.accessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.getClass();
        android.view.accessibility.AccessibilityManager accessibilityManager = androidComposeViewAccessibilityDelegateCompat.accessibilityManager;
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int action = event.getAction();
            AndroidComposeView androidComposeView = androidComposeViewAccessibilityDelegateCompat.view;
            int r10 = Integer.MIN_VALUE;
            if (action != 7 && action != 9) {
                if (action == 10) {
                    if (androidComposeViewAccessibilityDelegateCompat.hoveredVirtualViewId != Integer.MIN_VALUE) {
                        androidComposeViewAccessibilityDelegateCompat.updateHoveredVirtualView(Integer.MIN_VALUE);
                    } else {
                        androidComposeView.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                    }
                }
            } else {
                float x = event.getX();
                float y = event.getY();
                androidComposeView.measureAndLayout(true);
                HitTestResult hitTestResult = new HitTestResult();
                LayoutNode root = androidComposeView.getRoot();
                long Offset = OffsetKt.Offset(x, y);
                LayoutNode$Companion$ErrorMeasurePolicy$1 layoutNode$Companion$ErrorMeasurePolicy$1 = LayoutNode.ErrorMeasurePolicy;
                root.getClass();
                NodeChain nodeChain2 = root.nodes;
                nodeChain2.outerCoordinator.m469hitTestYqVAtuI(NodeCoordinator.SemanticsSource, nodeChain2.outerCoordinator.m464fromParentPositionMKHz9U(Offset), hitTestResult, true, true);
                Modifier.Node node = (Modifier.Node) CollectionsKt___CollectionsKt.lastOrNull(hitTestResult);
                if (node != null) {
                    layoutNode = DelegatableNodeKt.requireLayoutNode(node);
                } else {
                    layoutNode = null;
                }
                if (layoutNode != null && (nodeChain = layoutNode.nodes) != null && nodeChain.m460hasH91voCI$ui_release(8)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    SemanticsNode SemanticsNode = SemanticsNodeKt.SemanticsNode(layoutNode, false);
                    NodeCoordinator findCoordinatorToGetBounds$ui_release = SemanticsNode.findCoordinatorToGetBounds$ui_release();
                    if (findCoordinatorToGetBounds$ui_release != null) {
                        z3 = findCoordinatorToGetBounds$ui_release.isTransparent();
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        if (!SemanticsNode.unmergedConfig.contains(SemanticsProperties.InvisibleToUser)) {
                            z4 = true;
                            if (z4 && androidComposeView.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNode) == null) {
                                r10 = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.semanticsId);
                            }
                        }
                    }
                    z4 = false;
                    if (z4) {
                        r10 = androidComposeViewAccessibilityDelegateCompat.semanticsNodeIdToAccessibilityVirtualNodeId(layoutNode.semanticsId);
                    }
                }
                androidComposeView.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
                androidComposeViewAccessibilityDelegateCompat.updateHoveredVirtualView(r10);
            }
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) != 3) {
                    MotionEvent motionEvent = this.previousMotionEvent;
                    if (motionEvent != null) {
                        motionEvent.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                    this.hoverExitReceived = true;
                    post(componentDialog$$ExternalSyntheticLambda1);
                    return false;
                }
                if (event.getButtonState() != 0) {
                    return false;
                }
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        if ((m487handleMotionEvent8iAsVTc(event) & 1) == 0) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isFocused()) {
            int metaState = event.getMetaState();
            this._windowInfo.getClass();
            WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(metaState));
            if (!getFocusOwner().mo240dispatchKeyEventZmokQxo(event) && !super.dispatchKeyEvent(event)) {
                return false;
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEventPreIme(android.view.KeyEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if ((isFocused() && getFocusOwner().mo239dispatchInterceptedSoftKeyboardEventZmokQxo(event)) || super.dispatchKeyEventPreIme(event)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            ComponentDialog$$ExternalSyntheticLambda1 componentDialog$$ExternalSyntheticLambda1 = this.sendHoverExitEvent;
            removeCallbacks(componentDialog$$ExternalSyntheticLambda1);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() == 0) {
                if (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    this.hoverExitReceived = false;
                }
            }
            componentDialog$$ExternalSyntheticLambda1.run();
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int m487handleMotionEvent8iAsVTc = m487handleMotionEvent8iAsVTc(motionEvent);
        if ((m487handleMotionEvent8iAsVTc & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if ((m487handleMotionEvent8iAsVTc & 1) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:            r7 = null;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View findViewByAccessibilityIdTraversal(int r7) {
        /*
            r6 = this;
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.NoSuchMethodException -> L31
            r1 = 29
            if (r0 < r1) goto L2c
            java.lang.Class<android.view.View> r0 = android.view.View.class
            java.lang.String r1 = "findViewByAccessibilityIdTraversal"
            r2 = 1
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L31
            java.lang.Class r4 = java.lang.Integer.TYPE     // Catch: java.lang.NoSuchMethodException -> L31
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.NoSuchMethodException -> L31
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r3)     // Catch: java.lang.NoSuchMethodException -> L31
            r0.setAccessible(r2)     // Catch: java.lang.NoSuchMethodException -> L31
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch: java.lang.NoSuchMethodException -> L31
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.NoSuchMethodException -> L31
            r1[r5] = r7     // Catch: java.lang.NoSuchMethodException -> L31
            java.lang.Object r7 = r0.invoke(r6, r1)     // Catch: java.lang.NoSuchMethodException -> L31
            boolean r0 = r7 instanceof android.view.View     // Catch: java.lang.NoSuchMethodException -> L31
            if (r0 == 0) goto L31
            android.view.View r7 = (android.view.View) r7     // Catch: java.lang.NoSuchMethodException -> L31
            goto L32
        L2c:
            android.view.View r7 = findViewByAccessibilityIdRootedAtCurrentView(r7, r6)     // Catch: java.lang.NoSuchMethodException -> L31
            goto L32
        L31:
            r7 = 0
        L32:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.findViewByAccessibilityIdTraversal(int):android.view.View");
    }

    @Override // androidx.compose.ui.node.Owner
    public final void forceMeasureTheSubtree(LayoutNode layoutNode, boolean z) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode, z);
    }

    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.compose.ui.node.Owner
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.Owner
    public FocusOwner getFocusOwner() {
        return this.focusOwner;
    }

    @Override // android.view.View
    public final void getFocusedRect(Rect rect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(rect, "rect");
        androidx.compose.ui.geometry.Rect focusRect = getFocusOwner().getFocusRect();
        if (focusRect != null) {
            rect.left = MathKt__MathJVMKt.roundToInt(focusRect.left);
            rect.top = MathKt__MathJVMKt.roundToInt(focusRect.top);
            rect.right = MathKt__MathJVMKt.roundToInt(focusRect.right);
            rect.bottom = MathKt__MathJVMKt.roundToInt(focusRect.bottom);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Override // androidx.compose.ui.node.Owner
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        boolean z;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = this.measureAndLayoutDelegate.relayoutNodes;
        if (depthSortedSetsForDifferentPasses.set.set.isEmpty() && depthSortedSetsForDifferentPasses.lookaheadSet.set.isEmpty()) {
            z = true;
        } else {
            z = false;
        }
        return !z;
    }

    @Override // androidx.compose.ui.node.Owner
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public long getMeasureIteration() {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (measureAndLayoutDelegate.duringMeasureLayout) {
            return measureAndLayoutDelegate.measureIteration;
        }
        throw new IllegalArgumentException("measureIteration should be only used during the measure/layout pass".toString());
    }

    @Override // androidx.compose.ui.node.Owner
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    public LayoutNode getRoot() {
        return this.root;
    }

    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // androidx.compose.ui.node.Owner
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x007c A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x004b, B:7:0x0054, B:11:0x005f, B:13:0x0069, B:18:0x007c, B:23:0x0094, B:24:0x009a, B:27:0x00a4, B:28:0x0083, B:36:0x00b0, B:44:0x00c2, B:46:0x00c8, B:48:0x00d6, B:49:0x00d9), top: B:4:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0094 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x004b, B:7:0x0054, B:11:0x005f, B:13:0x0069, B:18:0x007c, B:23:0x0094, B:24:0x009a, B:27:0x00a4, B:28:0x0083, B:36:0x00b0, B:44:0x00c2, B:46:0x00c8, B:48:0x00d6, B:49:0x00d9), top: B:4:0x004b, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009a A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:5:0x004b, B:7:0x0054, B:11:0x005f, B:13:0x0069, B:18:0x007c, B:23:0x0094, B:24:0x009a, B:27:0x00a4, B:28:0x0083, B:36:0x00b0, B:44:0x00c2, B:46:0x00c8, B:48:0x00d6, B:49:0x00d9), top: B:4:0x004b, outer: #1 }] */
    /* renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m487handleMotionEvent8iAsVTc(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.m487handleMotionEvent8iAsVTc(android.view.MotionEvent):int");
    }

    public final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int r1 = 0;
        this.measureAndLayoutDelegate.requestRemeasure(layoutNode, false);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int r0 = mutableVector.size;
        if (r0 > 0) {
            LayoutNode[] layoutNodeArr = mutableVector.content;
            do {
                invalidateLayoutNodeMeasurement(layoutNodeArr[r1]);
                r1++;
            } while (r1 < r0);
        }
    }

    public final boolean isInBounds(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (0.0f <= x && x <= getWidth()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (0.0f <= y && y <= getHeight()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        boolean z;
        boolean z2;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.previousMotionEvent) == null || motionEvent2.getPointerCount() != motionEvent.getPointerCount()) {
            return true;
        }
        if (motionEvent.getRawX() == motionEvent2.getRawX()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return true;
        }
        if (motionEvent.getRawY() == motionEvent2.getRawY()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return true;
        }
        return false;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: localToScreen-MK-Hz9U */
    public final long mo418localToScreenMKHz9U(long j) {
        recalculateWindowPosition();
        long m338mapMKHz9U = Matrix.m338mapMKHz9U(this.viewToWindowMatrix, j);
        return OffsetKt.Offset(Offset.m259getXimpl(this.windowPosition) + Offset.m259getXimpl(m338mapMKHz9U), Offset.m260getYimpl(this.windowPosition) + Offset.m260getYimpl(m338mapMKHz9U));
    }

    @Override // androidx.compose.ui.node.Owner
    public final void measureAndLayout(boolean z) {
        boolean z2;
        AndroidComposeView$resendMotionEventOnLayout$1 androidComposeView$resendMotionEventOnLayout$1;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = measureAndLayoutDelegate.relayoutNodes;
        if (depthSortedSetsForDifferentPasses.set.set.isEmpty() && depthSortedSetsForDifferentPasses.lookaheadSet.set.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((!z2) || measureAndLayoutDelegate.onPositionedDispatcher.layoutNodes.isNotEmpty()) {
            Trace.beginSection("AndroidOwner:measureAndLayout");
            if (z) {
                try {
                    androidComposeView$resendMotionEventOnLayout$1 = this.resendMotionEventOnLayout;
                } finally {
                    Trace.endSection();
                }
            } else {
                androidComposeView$resendMotionEventOnLayout$1 = null;
            }
            if (measureAndLayoutDelegate.measureAndLayout(androidComposeView$resendMotionEventOnLayout$1)) {
                requestLayout();
            }
            measureAndLayoutDelegate.dispatchOnPositionedCallbacks(false);
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    /* renamed from: measureAndLayout-0kLqBqw */
    public final void mo484measureAndLayout0kLqBqw(LayoutNode layoutNode, long j) {
        boolean z;
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            measureAndLayoutDelegate.m458measureAndLayout0kLqBqw(layoutNode, j);
            DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = measureAndLayoutDelegate.relayoutNodes;
            if (depthSortedSetsForDifferentPasses.set.set.isEmpty() && depthSortedSetsForDifferentPasses.lookaheadSet.set.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!(!z)) {
                measureAndLayoutDelegate.dispatchOnPositionedCallbacks(false);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void notifyLayerIsDirty$ui_release(OwnedLayer layer, boolean z) {
        Intrinsics.checkNotNullParameter(layer, "layer");
        ArrayList arrayList = this.dirtyLayers;
        if (!z) {
            if (!this.isDrawingContent) {
                arrayList.remove(layer);
                ArrayList arrayList2 = this.postponedDirtyLayers;
                if (arrayList2 != null) {
                    arrayList2.remove(layer);
                    return;
                }
                return;
            }
            return;
        }
        if (!this.isDrawingContent) {
            arrayList.add(layer);
            return;
        }
        ArrayList arrayList3 = this.postponedDirtyLayers;
        if (arrayList3 == null) {
            arrayList3 = new ArrayList();
            this.postponedDirtyLayers = arrayList3;
        }
        arrayList3.add(layer);
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onAttach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        boolean z;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        LifecycleOwner lifecycleOwner2;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().observer.start();
        int r2 = 1;
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        } else {
            z = false;
        }
        if (z && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner3 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (lifecycleOwner3 != null && savedStateRegistryOwner != null && (lifecycleOwner3 != (lifecycleOwner2 = viewTreeOwners.lifecycleOwner) || savedStateRegistryOwner != lifecycleOwner2))) {
            z2 = true;
        }
        if (z2) {
            if (lifecycleOwner3 != null) {
                if (savedStateRegistryOwner != null) {
                    if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.lifecycleOwner) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                        lifecycle.removeObserver(this);
                    }
                    lifecycleOwner3.getLifecycle().addObserver(this);
                    ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner3, savedStateRegistryOwner);
                    set_viewTreeOwners(viewTreeOwners2);
                    Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                    if (function1 != null) {
                        function1.invoke(viewTreeOwners2);
                    }
                    this.onViewTreeOwnersAvailable = null;
                } else {
                    throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
                }
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
        }
        if (!isInTouchMode()) {
            r2 = 2;
        }
        InputModeManagerImpl inputModeManagerImpl = this._inputModeManager;
        inputModeManagerImpl.getClass();
        inputModeManagerImpl.inputMode$delegate.setValue(new InputMode(r2));
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.lifecycleOwner.getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public final boolean onCheckIsTextEditor() {
        Object obj;
        PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry = getPlatformTextInputPluginRegistry();
        PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<?> adapterWithRefCount = platformTextInputPluginRegistry.adaptersByPlugin.get(platformTextInputPluginRegistry.focusedPlugin);
        if (adapterWithRefCount != null) {
            obj = adapterWithRefCount.adapter;
        } else {
            obj = null;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration newConfig) {
        int r4;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = TimeZoneKt.Density(context);
        int r0 = Build.VERSION.SDK_INT;
        int r2 = 0;
        if (r0 >= 31) {
            r4 = newConfig.fontWeightAdjustment;
        } else {
            r4 = 0;
        }
        if (r4 != this.currentFontWeightAdjustment) {
            if (r0 >= 31) {
                r2 = newConfig.fontWeightAdjustment;
            }
            this.currentFontWeightAdjustment = r2;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        PlatformTextInputAdapter platformTextInputAdapter;
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistry = getPlatformTextInputPluginRegistry();
        PlatformTextInputPluginRegistryImpl.AdapterWithRefCount<?> adapterWithRefCount = platformTextInputPluginRegistry.adaptersByPlugin.get(platformTextInputPluginRegistry.focusedPlugin);
        if (adapterWithRefCount != null) {
            platformTextInputAdapter = adapterWithRefCount.adapter;
        } else {
            platformTextInputAdapter = null;
        }
        if (platformTextInputAdapter == null) {
            return null;
        }
        return platformTextInputAdapter.createInputConnection(outAttrs);
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onDetach(LayoutNode node) {
        Intrinsics.checkNotNullParameter(node, "node");
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        measureAndLayoutDelegate.getClass();
        DepthSortedSetsForDifferentPasses depthSortedSetsForDifferentPasses = measureAndLayoutDelegate.relayoutNodes;
        depthSortedSetsForDifferentPasses.getClass();
        depthSortedSetsForDifferentPasses.lookaheadSet.remove(node);
        depthSortedSetsForDifferentPasses.set.remove(node);
        this.observationClearRequested = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        boolean z;
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
        Snapshot$Companion$registerApplyObserver$2 snapshot$Companion$registerApplyObserver$2 = snapshotStateObserver.applyUnsubscribe;
        if (snapshot$Companion$registerApplyObserver$2 != null) {
            snapshot$Companion$registerApplyObserver$2.dispose();
        }
        snapshotStateObserver.clear();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.lifecycleOwner) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        } else {
            z = false;
        }
        if (z && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onEndApplyChanges() {
        if (this.observationClearRequested) {
            SnapshotStateObserver snapshotStateObserver = getSnapshotObserver().observer;
            OwnerSnapshotObserver$clearInvalidObservations$1 predicate = OwnerSnapshotObserver$clearInvalidObservations$1.INSTANCE;
            snapshotStateObserver.getClass();
            Intrinsics.checkNotNullParameter(predicate, "predicate");
            synchronized (snapshotStateObserver.observedScopeMaps) {
                MutableVector<SnapshotStateObserver.ObservedScopeMap> mutableVector = snapshotStateObserver.observedScopeMaps;
                int r4 = mutableVector.size;
                if (r4 > 0) {
                    SnapshotStateObserver.ObservedScopeMap[] observedScopeMapArr = mutableVector.content;
                    int r5 = 0;
                    do {
                        observedScopeMapArr[r5].removeScopeIf(predicate);
                        r5++;
                    } while (r5 < r4);
                }
                Unit unit = Unit.INSTANCE;
            }
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int r0 = this.endApplyChangesListeners.size;
            for (int r2 = 0; r2 < r0; r2++) {
                Function0<Unit>[] function0Arr = this.endApplyChangesListeners.content;
                Function0<Unit> function0 = function0Arr[r2];
                function0Arr[r2] = null;
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, r0);
        }
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int r2, Rect rect) {
        super.onFocusChanged(z, r2, rect);
        Log.d("Compose Focus", "Owner FocusChanged(" + z + ')');
        if (z) {
            getFocusOwner().takeFocus();
        } else {
            getFocusOwner().releaseFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r3, int r4, int r5, int r6) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, r5 - r3, r6 - r4);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onLayoutChange(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.accessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.getClass();
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        if (androidComposeViewAccessibilityDelegateCompat.isEnabledForAccessibility()) {
            androidComposeViewAccessibilityDelegateCompat.notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int r9, int r10) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            long m486convertMeasureSpecI7RO_PI = m486convertMeasureSpecI7RO_PI(r9);
            long m486convertMeasureSpecI7RO_PI2 = m486convertMeasureSpecI7RO_PI(r10);
            long Constraints = ConstraintsKt.Constraints((int) (m486convertMeasureSpecI7RO_PI >>> 32), (int) (m486convertMeasureSpecI7RO_PI & 4294967295L), (int) (m486convertMeasureSpecI7RO_PI2 >>> 32), (int) (4294967295L & m486convertMeasureSpecI7RO_PI2));
            Constraints constraints = this.onMeasureConstraints;
            if (constraints == null) {
                this.onMeasureConstraints = new Constraints(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else if (!Constraints.m559equalsimpl0(constraints.value, Constraints)) {
                this.wasMeasuredWithMultipleConstraints = true;
            }
            measureAndLayoutDelegate.m459updateRootConstraintsBRTryo0(Constraints);
            measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().layoutDelegate.measurePassDelegate.width, getRoot().layoutDelegate.measurePassDelegate.height);
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.width, 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().layoutDelegate.measurePassDelegate.height, 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int r12) {
        boolean z;
        AndroidAutofill androidAutofill;
        if (Build.VERSION.SDK_INT >= 26) {
            z = true;
        } else {
            z = false;
        }
        if (z && viewStructure != null && (androidAutofill = this._autofill) != null) {
            AutofillApi23Helper autofillApi23Helper = AutofillApi23Helper.INSTANCE;
            AutofillTree autofillTree = androidAutofill.autofillTree;
            int addChildCount = autofillApi23Helper.addChildCount(viewStructure, autofillTree.children.size());
            for (Map.Entry entry : autofillTree.children.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                AutofillNode autofillNode = (AutofillNode) entry.getValue();
                ViewStructure newChild = autofillApi23Helper.newChild(viewStructure, addChildCount);
                if (newChild == null) {
                    addChildCount++;
                } else {
                    AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                    AutofillId autofillId = autofillApi26Helper.getAutofillId(viewStructure);
                    Intrinsics.checkNotNull(autofillId);
                    autofillApi26Helper.setAutofillId(newChild, autofillId, intValue);
                    autofillApi23Helper.setId(newChild, intValue, androidAutofill.view.getContext().getPackageName(), null, null);
                    autofillApi26Helper.setAutofillType(newChild, 1);
                    autofillNode.getClass();
                    throw null;
                }
            }
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onRequestMeasure(LayoutNode layoutNode, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (z) {
            if (measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z2) && z3) {
                scheduleMeasureAndLayout(layoutNode);
                return;
            }
            return;
        }
        if (measureAndLayoutDelegate.requestRemeasure(layoutNode, z2) && z3) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onRequestRelayout(LayoutNode layoutNode, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        if (z) {
            if (measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z2)) {
                scheduleMeasureAndLayout(null);
            }
        } else if (measureAndLayoutDelegate.requestRelayout(layoutNode, z2)) {
            scheduleMeasureAndLayout(null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        setShowLayoutBounds(Companion.access$getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int r2) {
        LayoutDirection layoutDirection;
        if (this.superclassInitComplete) {
            if (r2 != 0) {
                if (r2 != 1) {
                    layoutDirection = LayoutDirection.Ltr;
                } else {
                    layoutDirection = LayoutDirection.Rtl;
                }
            } else {
                layoutDirection = LayoutDirection.Ltr;
            }
            setLayoutDirection(layoutDirection);
            getFocusOwner().setLayoutDirection(layoutDirection);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public final void onSemanticsChange() {
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this.accessibilityDelegate;
        androidComposeViewAccessibilityDelegateCompat.currentSemanticsNodesInvalidated = true;
        if (androidComposeViewAccessibilityDelegateCompat.isEnabledForAccessibility() && !androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges) {
            androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = true;
            androidComposeViewAccessibilityDelegateCompat.handler.post(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        boolean access$getIsShowingLayoutBounds;
        this._windowInfo._isWindowFocused.setValue(Boolean.valueOf(z));
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z);
        if (z && getShowLayoutBounds() != (access$getIsShowingLayoutBounds = Companion.access$getIsShowingLayoutBounds())) {
            setShowLayoutBounds(access$getIsShowingLayoutBounds);
            invalidateLayers(getRoot());
        }
    }

    public final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                CalculateMatrixToWindow calculateMatrixToWindow = this.matrixToWindow;
                float[] fArr = this.viewToWindowMatrix;
                calculateMatrixToWindow.mo493calculateMatrixToWindowEL8BTi8(this, fArr);
                InvertMatrixKt.m499invertToJiSxe2E(fArr, this.windowToViewMatrix);
                ViewParent parent = getParent();
                View view = this;
                while (parent instanceof ViewGroup) {
                    view = (View) parent;
                    parent = ((ViewGroup) view).getParent();
                }
                int[] r0 = this.tmpPositionArray;
                view.getLocationOnScreen(r0);
                float f = r0[0];
                float f2 = r0[1];
                view.getLocationInWindow(r0);
                this.windowPosition = OffsetKt.Offset(f - r0[0], f2 - r0[1]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void recycle$ui_release(OwnedLayer layer) {
        WeakCache<OwnedLayer> weakCache;
        Reference<? extends OwnedLayer> poll;
        Intrinsics.checkNotNullParameter(layer, "layer");
        if (this.viewLayersContainer != null) {
            ViewLayer$Companion$getMatrix$1 viewLayer$Companion$getMatrix$1 = ViewLayer.getMatrix;
        }
        do {
            weakCache = this.layerCache;
            poll = weakCache.referenceQueue.poll();
            if (poll != null) {
                weakCache.values.remove(poll);
            }
        } while (poll != null);
        weakCache.values.add(new WeakReference(layer, weakCache.referenceQueue));
    }

    @Override // androidx.compose.ui.node.Owner
    public final void registerOnEndApplyChangesListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MutableVector<Function0<Unit>> mutableVector = this.endApplyChangesListeners;
        if (!mutableVector.contains(listener)) {
            mutableVector.add(listener);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public final void registerOnLayoutCompletedListener(BackwardsCompatNode$initializeModifier$2 backwardsCompatNode$initializeModifier$2) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        measureAndLayoutDelegate.getClass();
        measureAndLayoutDelegate.onLayoutCompletedListeners.add(backwardsCompatNode$initializeModifier$2);
        scheduleMeasureAndLayout(null);
    }

    @Override // androidx.compose.ui.node.Owner
    public final void requestOnPositionedCallback(LayoutNode layoutNode) {
        MeasureAndLayoutDelegate measureAndLayoutDelegate = this.measureAndLayoutDelegate;
        measureAndLayoutDelegate.getClass();
        OnPositionedDispatcher onPositionedDispatcher = measureAndLayoutDelegate.onPositionedDispatcher;
        onPositionedDispatcher.getClass();
        onPositionedDispatcher.layoutNodes.add(layoutNode);
        layoutNode.needsOnPositionedDispatch = true;
        scheduleMeasureAndLayout(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void scheduleMeasureAndLayout(androidx.compose.ui.node.LayoutNode r6) {
        /*
            r5 = this;
            boolean r0 = r5.isLayoutRequested()
            if (r0 != 0) goto L69
            boolean r0 = r5.isAttachedToWindow()
            if (r0 == 0) goto L69
            if (r6 == 0) goto L55
        Le:
            if (r6 == 0) goto L4b
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r0 = r6.layoutDelegate
            androidx.compose.ui.node.LayoutNodeLayoutDelegate$MeasurePassDelegate r0 = r0.measurePassDelegate
            androidx.compose.ui.node.LayoutNode$UsageByParent r0 = r0.measuredByParent
            androidx.compose.ui.node.LayoutNode$UsageByParent r1 = androidx.compose.ui.node.LayoutNode.UsageByParent.InMeasureBlock
            if (r0 != r1) goto L4b
            boolean r0 = r5.wasMeasuredWithMultipleConstraints
            r1 = 1
            if (r0 != 0) goto L44
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            r2 = 0
            if (r0 == 0) goto L3f
            androidx.compose.ui.node.NodeChain r0 = r0.nodes
            androidx.compose.ui.node.InnerNodeCoordinator r0 = r0.innerCoordinator
            long r3 = r0.measurementConstraints
            boolean r0 = androidx.compose.ui.unit.Constraints.m563getHasFixedWidthimpl(r3)
            if (r0 == 0) goto L3a
            boolean r0 = androidx.compose.ui.unit.Constraints.m562getHasFixedHeightimpl(r3)
            if (r0 == 0) goto L3a
            r0 = r1
            goto L3b
        L3a:
            r0 = r2
        L3b:
            if (r0 != 0) goto L3f
            r0 = r1
            goto L40
        L3f:
            r0 = r2
        L40:
            if (r0 == 0) goto L43
            goto L44
        L43:
            r1 = r2
        L44:
            if (r1 == 0) goto L4b
            androidx.compose.ui.node.LayoutNode r6 = r6.getParent$ui_release()
            goto Le
        L4b:
            androidx.compose.ui.node.LayoutNode r0 = r5.getRoot()
            if (r6 != r0) goto L55
            r5.requestLayout()
            return
        L55:
            int r6 = r5.getWidth()
            if (r6 == 0) goto L66
            int r6 = r5.getHeight()
            if (r6 != 0) goto L62
            goto L66
        L62:
            r5.invalidate()
            goto L69
        L66:
            r5.requestLayout()
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView.scheduleMeasureAndLayout(androidx.compose.ui.node.LayoutNode):void");
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* renamed from: screenToLocal-MK-Hz9U */
    public final long mo419screenToLocalMKHz9U(long j) {
        recalculateWindowPosition();
        return Matrix.m338mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m259getXimpl(j) - Offset.m259getXimpl(this.windowPosition), Offset.m260getYimpl(j) - Offset.m260getYimpl(this.windowPosition)));
    }

    /* renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    public final int m488sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        boolean z = false;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            int metaState = motionEvent.getMetaState();
            this._windowInfo.getClass();
            WindowInfoImpl.GlobalKeyboardModifiers.setValue(new PointerKeyboardModifiers(metaState));
        }
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        PointerInputEvent convertToPointerInputEvent$ui_release = motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        PointerInputEventProcessor pointerInputEventProcessor = this.pointerInputEventProcessor;
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> list = convertToPointerInputEvent$ui_release.pointers;
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int r6 = size - 1;
                    pointerInputEventData = list.get(size);
                    if (pointerInputEventData.down) {
                        break;
                    }
                    if (r6 < 0) {
                        break;
                    }
                    size = r6;
                }
            }
            pointerInputEventData = null;
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.position;
            }
            int m415processBIzXfog = pointerInputEventProcessor.m415processBIzXfog(convertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0 || actionMasked == 5) {
                if ((m415processBIzXfog & 1) != 0) {
                    z = true;
                }
                if (!z) {
                    int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    motionEventAdapter.canHover.delete(pointerId);
                    motionEventAdapter.motionEventToComposePointerIdMap.delete(pointerId);
                }
            }
            return m415processBIzXfog;
        }
        pointerInputEventProcessor.processCancel();
        return 0;
    }

    public final void sendSimulatedEvent(MotionEvent motionEvent, int r20, long j, boolean z) {
        int r2;
        int r6;
        int buttonState;
        long downTime;
        int r9;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                r2 = motionEvent.getActionIndex();
            }
            r2 = -1;
        } else {
            if (r20 != 9 && r20 != 10) {
                r2 = 0;
            }
            r2 = -1;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (r2 >= 0) {
            r6 = 1;
        } else {
            r6 = 0;
        }
        int r62 = pointerCount - r6;
        if (r62 == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[r62];
        for (int r4 = 0; r4 < r62; r4++) {
            pointerPropertiesArr[r4] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[r62];
        for (int r42 = 0; r42 < r62; r42++) {
            pointerCoordsArr[r42] = new MotionEvent.PointerCoords();
        }
        for (int r43 = 0; r43 < r62; r43++) {
            if (r2 >= 0 && r43 >= r2) {
                r9 = 1;
            } else {
                r9 = 0;
            }
            int r92 = r9 + r43;
            motionEvent.getPointerProperties(r92, pointerPropertiesArr[r43]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[r43];
            motionEvent.getPointerCoords(r92, pointerCoords);
            long mo418localToScreenMKHz9U = mo418localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m259getXimpl(mo418localToScreenMKHz9U);
            pointerCoords.y = Offset.m260getYimpl(mo418localToScreenMKHz9U);
        }
        if (z) {
            buttonState = 0;
        } else {
            buttonState = motionEvent.getButtonState();
        }
        if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
            downTime = j;
        } else {
            downTime = motionEvent.getDownTime();
        }
        MotionEvent event = MotionEvent.obtain(downTime, j, r20, r62, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), buttonState, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        Intrinsics.checkNotNullExpressionValue(event, "event");
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(event, this);
        Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m415processBIzXfog(convertToPointerInputEvent$ui_release, this, true);
        event.recycle();
    }

    public final void setConfigurationChangeObserver(Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j) {
        this.lastMatrixRecalculationAnimationTime = j;
    }

    public final void setOnViewTreeOwnersAvailable(Function1<? super ViewTreeOwners, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = callback;
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z) {
        this.showLayoutBounds = z;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public final void updatePositionCacheAndDispatch() {
        int[] r0 = this.tmpPositionArray;
        getLocationOnScreen(r0);
        long j = this.globalPosition;
        int r3 = (int) (j >> 32);
        int m590getYimpl = IntOffset.m590getYimpl(j);
        boolean z = false;
        int r4 = r0[0];
        if (r3 != r4 || m590getYimpl != r0[1]) {
            this.globalPosition = IntOffsetKt.IntOffset(r4, r0[1]);
            if (r3 != Integer.MAX_VALUE && m590getYimpl != Integer.MAX_VALUE) {
                getRoot().layoutDelegate.measurePassDelegate.notifyChildrenUsingCoordinatesWhilePlacing();
                z = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z);
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    @Override // androidx.compose.ui.node.Owner
    public PlatformTextInputPluginRegistryImpl getPlatformTextInputPluginRegistry() {
        return this.platformTextInputPluginRegistry;
    }

    public static /* synthetic */ void getFontLoader$annotations() {
    }

    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public View getView() {
        return this;
    }
}
