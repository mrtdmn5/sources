package androidx.compose.ui.platform;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableString;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.contentcapture.ContentCaptureSession;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNode$isUnmergedLeafNode$1;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.animaconnected.secondo.provider.ImportantAppsProvider$$ExternalSyntheticLambda2;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.ChannelKt;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public final String EXTRA_DATA_TEST_TRAVERSALAFTER_VAL;
    public final String EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL;
    public int accessibilityCursorPosition;
    public final android.view.accessibility.AccessibilityManager accessibilityManager;
    public final SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    public final BufferedChannel boundsUpdateChannel;
    public final ArrayMap<Integer, ViewStructureCompat> bufferedContentCaptureAppearedNodes;
    public final ArraySet<Integer> bufferedContentCaptureDisappearedNodes;
    public boolean checkingForSemanticsChanges;
    public ContentCaptureSessionCompat contentCaptureSession;
    public Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    public boolean currentSemanticsNodesInvalidated;
    public List<AccessibilityServiceInfo> enabledServices;
    public final AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 enabledStateListener;
    public int focusedVirtualViewId;
    public final Handler handler;
    public int hoveredVirtualViewId;
    public final HashMap<Integer, Integer> idToAfterMap;
    public final HashMap<Integer, Integer> idToBeforeMap;
    public final SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    public final AccessibilityNodeProviderCompat nodeProvider;
    public final ArraySet<Integer> paneDisplayed;
    public PendingTextTraversedEvent pendingTextTraversedEvent;
    public final LinkedHashMap previousSemanticsNodes;
    public SemanticsNodeCopy previousSemanticsRoot;
    public Integer previousTraversedNode;
    public final ArrayList scrollObservationScopes;
    public final ImportantAppsProvider$$ExternalSyntheticLambda2 semanticsChangeChecker;
    public final AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1 sendScrollEventIfNeededLambda;
    public final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    public final AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1 touchExplorationStateListener;
    public final URLSpanCache urlSpanCache;
    public final AndroidComposeView view;

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$1 */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 implements View.OnAttachStateChangeListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            ContentCaptureSessionCompat contentCaptureSessionCompat;
            ContentCaptureSession contentCaptureSession;
            Intrinsics.checkNotNullParameter(view, "view");
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            androidComposeViewAccessibilityDelegateCompat.accessibilityManager.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
            androidComposeViewAccessibilityDelegateCompat.accessibilityManager.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            int r1 = Build.VERSION.SDK_INT;
            if (r1 >= 30) {
                ViewCompatShims.Api30Impl.setImportantForContentCapture(view, 1);
            }
            if (r1 >= 29 && (contentCaptureSession = ViewCompatShims.Api29Impl.getContentCaptureSession(view)) != null) {
                contentCaptureSessionCompat = new ContentCaptureSessionCompat(contentCaptureSession, view);
            } else {
                contentCaptureSessionCompat = null;
            }
            androidComposeViewAccessibilityDelegateCompat.contentCaptureSession = contentCaptureSessionCompat;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            androidComposeViewAccessibilityDelegateCompat.handler.removeCallbacks(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
            AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 androidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 = androidComposeViewAccessibilityDelegateCompat.enabledStateListener;
            android.view.accessibility.AccessibilityManager accessibilityManager = androidComposeViewAccessibilityDelegateCompat.accessibilityManager;
            accessibilityManager.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0);
            accessibilityManager.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
            androidComposeViewAccessibilityDelegateCompat.contentCaptureSession = null;
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public static final class Api24Impl {
        public static final void addSetProgressAction(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode)) {
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.unmergedConfig, SemanticsActions.SetProgress);
                if (accessibilityAction != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.label));
                }
            }
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public static final class Api28Impl {
        public static final void setScrollEventDelta(AccessibilityEvent event, int r2, int r3) {
            Intrinsics.checkNotNullParameter(event, "event");
            event.setScrollDeltaX(r2);
            event.setScrollDeltaY(r3);
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        public static final void addPageActions(AccessibilityNodeInfoCompat info, SemanticsNode semanticsNode) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode)) {
                SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> semanticsPropertyKey = SemanticsActions.PageUp;
                SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, semanticsPropertyKey);
                if (accessibilityAction != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, accessibilityAction.label));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.PageDown);
                if (accessibilityAction2 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, accessibilityAction2.label));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.PageLeft);
                if (accessibilityAction3 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, accessibilityAction3.label));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsActions.PageRight);
                if (accessibilityAction4 != null) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, accessibilityAction4.label));
                }
            }
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int r2, AccessibilityNodeInfo info, String extraDataKey, Bundle bundle) {
            Intrinsics.checkNotNullParameter(info, "info");
            Intrinsics.checkNotNullParameter(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(r2, info, extraDataKey, bundle);
        }

        /* JADX WARN: Code restructure failed: missing block: B:149:0x034e, code lost:            if (r9 != false) goto L665;     */
        /* JADX WARN: Code restructure failed: missing block: B:218:0x04d3, code lost:            if (r0 == false) goto L735;     */
        /* JADX WARN: Code restructure failed: missing block: B:284:0x0699, code lost:            if (r11 != 0) goto L849;     */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0163, code lost:            if (r7.isMergingSemanticsOfDescendants == false) goto L557;     */
        /* JADX WARN: Removed duplicated region for block: B:212:0x04da  */
        /* JADX WARN: Removed duplicated region for block: B:317:0x074f  */
        /* JADX WARN: Removed duplicated region for block: B:320:0x0764  */
        /* JADX WARN: Removed duplicated region for block: B:323:0x076e  */
        /* JADX WARN: Removed duplicated region for block: B:342:0x07b2  */
        /* JADX WARN: Removed duplicated region for block: B:345:0x07c7  */
        /* JADX WARN: Removed duplicated region for block: B:348:0x07d1  */
        /* JADX WARN: Removed duplicated region for block: B:356:0x07f7  */
        /* JADX WARN: Removed duplicated region for block: B:359:0x0806  */
        /* JADX WARN: Removed duplicated region for block: B:362:0x0819  */
        /* JADX WARN: Removed duplicated region for block: B:412:0x097f  */
        /* JADX WARN: Removed duplicated region for block: B:415:0x0995  */
        /* JADX WARN: Removed duplicated region for block: B:421:0x09cc  */
        /* JADX WARN: Removed duplicated region for block: B:428:0x09bc  */
        /* JADX WARN: Removed duplicated region for block: B:429:0x0983  */
        /* JADX WARN: Removed duplicated region for block: B:430:0x080a  */
        @Override // android.view.accessibility.AccessibilityNodeProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r20) {
            /*
                Method dump skipped, instructions count: 2552
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.MyNodeProvider.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
        }

        /* JADX WARN: Code restructure failed: missing block: B:395:0x0568, code lost:            if (r0 != 16) goto L880;     */
        /* JADX WARN: Removed duplicated region for block: B:102:0x00d5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:112:0x00f1  */
        /* JADX WARN: Removed duplicated region for block: B:124:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x016b  */
        /* JADX WARN: Removed duplicated region for block: B:140:0x0184  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x012f  */
        /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:401:0x0649  */
        /* JADX WARN: Removed duplicated region for block: B:425:0x069a  */
        /* JADX WARN: Removed duplicated region for block: B:427:0x069d  */
        /* JADX WARN: Removed duplicated region for block: B:435:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:120:0x00d2 -> B:74:0x00d3). Please report as a decompilation issue!!! */
        @Override // android.view.accessibility.AccessibilityNodeProvider
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean performAction(int r20, int r21, android.os.Bundle r22) {
            /*
                Method dump skipped, instructions count: 1858
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.MyNodeProvider.performAction(int, int, android.os.Bundle):boolean");
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public static final class PendingTextTraversedEvent {
        public final int action;
        public final int fromIndex;
        public final int granularity;
        public final SemanticsNode node;
        public final int toIndex;
        public final long traverseTime;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int r2, int r3, int r4, int r5, long j) {
            this.node = semanticsNode;
            this.action = r2;
            this.granularity = r3;
            this.fromIndex = r4;
            this.toIndex = r5;
            this.traverseTime = j;
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public static final class SemanticsNodeCopy {
        public final LinkedHashSet children;
        public final SemanticsNode semanticsNode;
        public final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(SemanticsNode semanticsNode, Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            Intrinsics.checkNotNullParameter(currentSemanticsNodes, "currentSemanticsNodes");
            this.semanticsNode = semanticsNode;
            this.unmergedConfig = semanticsNode.unmergedConfig;
            this.children = new LinkedHashSet();
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int r1 = 0; r1 < size; r1++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(r1);
                if (currentSemanticsNodes.containsKey(Integer.valueOf(semanticsNode2.id))) {
                    this.children.add(Integer.valueOf(semanticsNode2.id));
                }
            }
        }
    }

    /* compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[ToggleableState.values().length];
            try {
                r0[ToggleableState.On.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[ToggleableState.Off.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[ToggleableState.Indeterminate.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0] */
    /* JADX WARN: Type inference failed for: r2v3, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1] */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1] */
    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.hoveredVirtualViewId = Integer.MIN_VALUE;
        Object systemService = view.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.enabledStateListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z) {
                List<AccessibilityServiceInfo> list;
                AndroidComposeViewAccessibilityDelegateCompat this$0 = AndroidComposeViewAccessibilityDelegateCompat.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                if (z) {
                    list = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
                } else {
                    list = EmptyList.INSTANCE;
                }
                this$0.enabledServices = list;
            }
        };
        this.touchExplorationStateListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda1
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z) {
                AndroidComposeViewAccessibilityDelegateCompat this$0 = AndroidComposeViewAccessibilityDelegateCompat.this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.enabledServices = this$0.accessibilityManager.getEnabledAccessibilityServiceList(-1);
            }
        };
        this.enabledServices = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, null, 6);
        this.currentSemanticsNodesInvalidated = true;
        this.bufferedContentCaptureAppearedNodes = new ArrayMap<>();
        this.bufferedContentCaptureDisappearedNodes = new ArraySet<>();
        EmptyMap emptyMap = EmptyMap.INSTANCE;
        this.currentSemanticsNodes = emptyMap;
        this.paneDisplayed = new ArraySet<>();
        this.idToBeforeMap = new HashMap<>();
        this.idToAfterMap = new HashMap<>();
        this.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.urlSpanCache = new URLSpanCache();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(view.getSemanticsOwner().getUnmergedRootSemanticsNode(), emptyMap);
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            public AnonymousClass1() {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewAttachedToWindow(View view2) {
                ContentCaptureSessionCompat contentCaptureSessionCompat;
                ContentCaptureSession contentCaptureSession;
                Intrinsics.checkNotNullParameter(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                androidComposeViewAccessibilityDelegateCompat.accessibilityManager.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.enabledStateListener);
                androidComposeViewAccessibilityDelegateCompat.accessibilityManager.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
                int r1 = Build.VERSION.SDK_INT;
                if (r1 >= 30) {
                    ViewCompatShims.Api30Impl.setImportantForContentCapture(view2, 1);
                }
                if (r1 >= 29 && (contentCaptureSession = ViewCompatShims.Api29Impl.getContentCaptureSession(view2)) != null) {
                    contentCaptureSessionCompat = new ContentCaptureSessionCompat(contentCaptureSession, view2);
                } else {
                    contentCaptureSessionCompat = null;
                }
                androidComposeViewAccessibilityDelegateCompat.contentCaptureSession = contentCaptureSessionCompat;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public final void onViewDetachedFromWindow(View view2) {
                Intrinsics.checkNotNullParameter(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                androidComposeViewAccessibilityDelegateCompat.handler.removeCallbacks(androidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker);
                AndroidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 androidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0 = androidComposeViewAccessibilityDelegateCompat.enabledStateListener;
                android.view.accessibility.AccessibilityManager accessibilityManager2 = androidComposeViewAccessibilityDelegateCompat.accessibilityManager;
                accessibilityManager2.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat$$ExternalSyntheticLambda0);
                accessibilityManager2.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.touchExplorationStateListener);
                androidComposeViewAccessibilityDelegateCompat.contentCaptureSession = null;
            }
        });
        this.semanticsChangeChecker = new ImportantAppsProvider$$ExternalSyntheticLambda2(1, this);
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ScrollObservationScope scrollObservationScope) {
                ScrollObservationScope it = scrollObservationScope;
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                androidComposeViewAccessibilityDelegateCompat.getClass();
                if (it.isValidOwnerScope()) {
                    androidComposeViewAccessibilityDelegateCompat.view.getSnapshotObserver().observeReads$ui_release(it, androidComposeViewAccessibilityDelegateCompat.sendScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(androidComposeViewAccessibilityDelegateCompat, it));
                }
                return Unit.INSTANCE;
            }
        };
    }

    public static boolean getInfoIsCheckable(SemanticsNode semanticsNode) {
        boolean z;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.unmergedConfig, SemanticsProperties.ToggleableState);
        SemanticsPropertyKey<Role> semanticsPropertyKey = SemanticsProperties.Role;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, semanticsPropertyKey);
        boolean z2 = true;
        boolean z3 = false;
        if (toggleableState != null) {
            z = true;
        } else {
            z = false;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.Selected);
        if (bool != null) {
            bool.booleanValue();
            if (role != null && role.value == 4) {
                z3 = true;
            }
            if (z3) {
                z2 = z;
            }
            return z2;
        }
        return z;
    }

    public static String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (semanticsConfiguration.contains(semanticsPropertyKey)) {
            return TempListUtilsKt.fastJoinToString$default((List) semanticsConfiguration.get(semanticsPropertyKey), ",");
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            AnnotatedString textForTextField = getTextForTextField(semanticsConfiguration);
            if (textForTextField == null) {
                return null;
            }
            return textForTextField.text;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.Text);
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt___CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.text;
    }

    public static AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.EditableText);
    }

    public static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f) {
        Function0<Float> function0 = scrollAxisRange.value;
        if ((f < 0.0f && function0.invoke().floatValue() > 0.0f) || (f > 0.0f && function0.invoke().floatValue() < scrollAxisRange.maxValue.invoke().floatValue())) {
            return true;
        }
        return false;
    }

    public static final float performActionHelper$scrollDelta(float f, float f2) {
        boolean z;
        if (Math.signum(f) == Math.signum(f2)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (Math.abs(f) >= Math.abs(f2)) {
                return f2;
            }
            return f;
        }
        return 0.0f;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        Function0<Float> function0 = scrollAxisRange.value;
        float floatValue = function0.invoke().floatValue();
        boolean z = scrollAxisRange.reverseScrolling;
        if ((floatValue > 0.0f && !z) || (function0.invoke().floatValue() < scrollAxisRange.maxValue.invoke().floatValue() && z)) {
            return true;
        }
        return false;
    }

    public static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        Function0<Float> function0 = scrollAxisRange.value;
        float floatValue = function0.invoke().floatValue();
        float floatValue2 = scrollAxisRange.maxValue.invoke().floatValue();
        boolean z = scrollAxisRange.reverseScrolling;
        if ((floatValue < floatValue2 && !z) || (function0.invoke().floatValue() > 0.0f && z)) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ void sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int r2, int r3, Integer num, int r5) {
        if ((r5 & 4) != 0) {
            num = null;
        }
        androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(r2, r3, num, null);
    }

    public static final void subtreeSortedByGeometryGrouping$depthFirstSearch(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, ArrayList arrayList, LinkedHashMap linkedHashMap, boolean z, SemanticsNode semanticsNode) {
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsPropertyKey<Boolean> semanticsPropertyKey = SemanticsProperties.IsTraversalGroup;
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(config, semanticsPropertyKey);
        Boolean bool2 = Boolean.TRUE;
        boolean areEqual = Intrinsics.areEqual(bool, bool2);
        int r3 = semanticsNode.id;
        if ((areEqual || androidComposeViewAccessibilityDelegateCompat.isScreenReaderFocusable(semanticsNode)) && androidComposeViewAccessibilityDelegateCompat.getCurrentSemanticsNodes$ui_release().keySet().contains(Integer.valueOf(r3))) {
            arrayList.add(semanticsNode);
        }
        boolean areEqual2 = Intrinsics.areEqual((Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsPropertyKey), bool2);
        boolean z2 = semanticsNode.mergingEnabled;
        if (areEqual2) {
            linkedHashMap.put(Integer.valueOf(r3), androidComposeViewAccessibilityDelegateCompat.subtreeSortedByGeometryGrouping(CollectionsKt___CollectionsKt.toMutableList((Collection) semanticsNode.getChildren(!z2, false)), z));
            return;
        }
        List<SemanticsNode> children = semanticsNode.getChildren(!z2, false);
        int size = children.size();
        for (int r1 = 0; r1 < size; r1++) {
            subtreeSortedByGeometryGrouping$depthFirstSearch(androidComposeViewAccessibilityDelegateCompat, arrayList, linkedHashMap, z, children.get(r1));
        }
    }

    public static CharSequence trimToSize(CharSequence charSequence) {
        boolean z;
        if (charSequence != null && charSequence.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            int r2 = 100000;
            if (charSequence.length() > 100000) {
                if (Character.isHighSurrogate(charSequence.charAt(99999)) && Character.isLowSurrogate(charSequence.charAt(100000))) {
                    r2 = 99999;
                }
                CharSequence subSequence = charSequence.subSequence(0, r2);
                Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
                return subSequence;
            }
            return charSequence;
        }
        return charSequence;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int r17, android.view.accessibility.AccessibilityNodeInfo r18, java.lang.String r19, android.os.Bundle r20) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.addExtraDataToAccessibilityNodeInfoHelper(int, android.view.accessibility.AccessibilityNodeInfo, java.lang.String, android.os.Bundle):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0065 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072 A[Catch: all -> 0x00b8, TRY_LEAVE, TryCatch #1 {all -> 0x00b8, blocks: (B:12:0x002c, B:14:0x0057, B:19:0x006a, B:21:0x0072, B:24:0x0080, B:26:0x0085, B:28:0x0094, B:30:0x009b, B:31:0x00a4, B:40:0x0040), top: B:7:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    /* JADX WARN: Type inference failed for: r2v6, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Type inference failed for: r2v7, types: [kotlinx.coroutines.channels.ChannelIterator] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00b5 -> B:13:0x002f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object boundsUpdatesEventLoop(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:0: B:18:0x005d->B:48:?, LOOP_END, SYNTHETIC] */
    /* renamed from: canScroll-0AR0LA0$ui_release */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m489canScroll0AR0LA0$ui_release(int r10, long r11, boolean r13) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m489canScroll0AR0LA0$ui_release(int, long, boolean):boolean");
    }

    public final AccessibilityEvent createEvent$ui_release(int r3, int r4) {
        boolean contains;
        AccessibilityEvent obtain = AccessibilityEvent.obtain(r4);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(eventType)");
        obtain.setEnabled(true);
        obtain.setClassName("android.view.View");
        AndroidComposeView androidComposeView = this.view;
        obtain.setPackageName(androidComposeView.getContext().getPackageName());
        obtain.setSource(androidComposeView, r3);
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(Integer.valueOf(r3));
        if (semanticsNodeWithAdjustedBounds != null) {
            contains = semanticsNodeWithAdjustedBounds.semanticsNode.getConfig().contains(SemanticsProperties.Password);
            obtain.setPassword(contains);
        }
        return obtain;
    }

    public final AccessibilityEvent createTextSelectionChangedEvent(int r2, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(r2, DfuBaseService.ERROR_REMOTE_MASK);
        if (num != null) {
            createEvent$ui_release.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent$ui_release.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent$ui_release.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            createEvent$ui_release.getText().add(charSequence);
        }
        return createEvent$ui_release;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return this.nodeProvider;
    }

    public final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (!semanticsConfiguration.contains(semanticsPropertyKey)) {
            SemanticsPropertyKey<TextRange> semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration.contains(semanticsPropertyKey2)) {
                return TextRange.m523getEndimpl(((TextRange) semanticsConfiguration.get(semanticsPropertyKey2)).packedValue);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        if (!semanticsConfiguration.contains(semanticsPropertyKey)) {
            SemanticsPropertyKey<TextRange> semanticsPropertyKey2 = SemanticsProperties.TextSelectionRange;
            if (semanticsConfiguration.contains(semanticsPropertyKey2)) {
                return (int) (((TextRange) semanticsConfiguration.get(semanticsPropertyKey2)).packedValue >> 32);
            }
        }
        return this.accessibilityCursorPosition;
    }

    public final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes$ui_release() {
        SemanticsNode semanticsNode;
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodesInvalidated = false;
            SemanticsOwner semanticsOwner = this.view.getSemanticsOwner();
            Intrinsics.checkNotNullParameter(semanticsOwner, "<this>");
            SemanticsNode unmergedRootSemanticsNode = semanticsOwner.getUnmergedRootSemanticsNode();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LayoutNode layoutNode = unmergedRootSemanticsNode.layoutNode;
            if (layoutNode.isPlaced() && layoutNode.isAttached()) {
                Region region = new Region();
                Rect boundsInRoot = unmergedRootSemanticsNode.getBoundsInRoot();
                region.set(new android.graphics.Rect(MathKt__MathJVMKt.roundToInt(boundsInRoot.left), MathKt__MathJVMKt.roundToInt(boundsInRoot.top), MathKt__MathJVMKt.roundToInt(boundsInRoot.right), MathKt__MathJVMKt.roundToInt(boundsInRoot.bottom)));
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap$findAllSemanticNodesRecursive(region, unmergedRootSemanticsNode, linkedHashMap, unmergedRootSemanticsNode);
            }
            this.currentSemanticsNodes = linkedHashMap;
            HashMap<Integer, Integer> hashMap = this.idToBeforeMap;
            hashMap.clear();
            HashMap<Integer, Integer> hashMap2 = this.idToAfterMap;
            hashMap2.clear();
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes$ui_release().get(-1);
            if (semanticsNodeWithAdjustedBounds != null) {
                semanticsNode = semanticsNodeWithAdjustedBounds.semanticsNode;
            } else {
                semanticsNode = null;
            }
            Intrinsics.checkNotNull(semanticsNode);
            ArrayList subtreeSortedByGeometryGrouping = subtreeSortedByGeometryGrouping(CollectionsKt__CollectionsKt.mutableListOf(semanticsNode), AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$isRtl(semanticsNode));
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(subtreeSortedByGeometryGrouping);
            int r4 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    int r5 = ((SemanticsNode) subtreeSortedByGeometryGrouping.get(r4 - 1)).id;
                    int r6 = ((SemanticsNode) subtreeSortedByGeometryGrouping.get(r4)).id;
                    hashMap.put(Integer.valueOf(r5), Integer.valueOf(r6));
                    hashMap2.put(Integer.valueOf(r6), Integer.valueOf(r5));
                    if (r4 == lastIndex) {
                        break;
                    }
                    r4++;
                }
            }
        }
        return this.currentSemanticsNodes;
    }

    public final String getInfoStateDescriptionOrNull(SemanticsNode semanticsNode) {
        Object string;
        boolean z;
        float floatValue;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        Object orNull = SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.StateDescription);
        SemanticsPropertyKey<ToggleableState> semanticsPropertyKey2 = SemanticsProperties.ToggleableState;
        SemanticsConfiguration semanticsConfiguration2 = semanticsNode.unmergedConfig;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsConfiguration2, semanticsPropertyKey2);
        Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsConfiguration2, SemanticsProperties.Role);
        AndroidComposeView androidComposeView = this.view;
        int r5 = 0;
        if (toggleableState != null) {
            int r1 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (r1 != 1) {
                if (r1 != 2) {
                    if (r1 == 3 && orNull == null) {
                        orNull = androidComposeView.getContext().getResources().getString(R.string.indeterminate);
                    }
                } else {
                    if (role == null || role.value != 2) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (z5 && orNull == null) {
                        orNull = androidComposeView.getContext().getResources().getString(R.string.off);
                    }
                }
            } else {
                if (role == null || role.value != 2) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (z4 && orNull == null) {
                    orNull = androidComposeView.getContext().getResources().getString(R.string.on);
                }
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsConfiguration2, SemanticsProperties.Selected);
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null || role.value != 4) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3 && orNull == null) {
                if (booleanValue) {
                    orNull = androidComposeView.getContext().getResources().getString(R.string.selected);
                } else {
                    orNull = androidComposeView.getContext().getResources().getString(R.string.not_selected);
                }
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsConfiguration2, SemanticsProperties.ProgressBarRangeInfo);
        if (progressBarRangeInfo != null) {
            ProgressBarRangeInfo progressBarRangeInfo2 = ProgressBarRangeInfo.Indeterminate;
            if (progressBarRangeInfo != ProgressBarRangeInfo.Indeterminate) {
                if (orNull == null) {
                    ClosedFloatingPointRange<Float> closedFloatingPointRange = progressBarRangeInfo.range;
                    if (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue() == 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        floatValue = 0.0f;
                    } else {
                        floatValue = (progressBarRangeInfo.current - closedFloatingPointRange.getStart().floatValue()) / (closedFloatingPointRange.getEndInclusive().floatValue() - closedFloatingPointRange.getStart().floatValue());
                    }
                    float coerceIn = RangesKt___RangesKt.coerceIn(floatValue, 0.0f, 1.0f);
                    if (coerceIn == 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        if (coerceIn == 1.0f) {
                            r5 = 1;
                        }
                        if (r5 != 0) {
                            r5 = 100;
                        } else {
                            r5 = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(coerceIn * 100), 1, 99);
                        }
                    }
                    string = androidComposeView.getContext().getResources().getString(R.string.template_percent, Integer.valueOf(r5));
                    orNull = string;
                }
            } else if (orNull == null) {
                string = androidComposeView.getContext().getResources().getString(R.string.in_progress);
                orNull = string;
            }
        }
        return (String) orNull;
    }

    public final SpannableString getInfoText(SemanticsNode semanticsNode) {
        SpannableString spannableString;
        AnnotatedString annotatedString;
        AndroidComposeView androidComposeView = this.view;
        FontFamily.Resolver fontFamilyResolver = androidComposeView.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.unmergedConfig);
        URLSpanCache uRLSpanCache = this.urlSpanCache;
        SpannableString spannableString2 = null;
        if (textForTextField != null) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, androidComposeView.getDensity(), fontFamilyResolver, uRLSpanCache);
        } else {
            spannableString = null;
        }
        SpannableString spannableString3 = (SpannableString) trimToSize(spannableString);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.unmergedConfig, SemanticsProperties.Text);
        if (list != null && (annotatedString = (AnnotatedString) CollectionsKt___CollectionsKt.firstOrNull(list)) != null) {
            spannableString2 = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, androidComposeView.getDensity(), fontFamilyResolver, uRLSpanCache);
        }
        SpannableString spannableString4 = (SpannableString) trimToSize(spannableString2);
        if (spannableString3 == null) {
            return spannableString4;
        }
        return spannableString3;
    }

    public final boolean isEnabledForAccessibility() {
        if (this.accessibilityManager.isEnabled()) {
            List<AccessibilityServiceInfo> enabledServices = this.enabledServices;
            Intrinsics.checkNotNullExpressionValue(enabledServices, "enabledServices");
            if (!enabledServices.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isScreenReaderFocusable(SemanticsNode semanticsNode) {
        String str;
        boolean z;
        boolean z2;
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.unmergedConfig, SemanticsProperties.ContentDescription);
        if (list != null) {
            str = (String) CollectionsKt___CollectionsKt.firstOrNull(list);
        } else {
            str = null;
        }
        if (str == null && getInfoText(semanticsNode) == null && getInfoStateDescriptionOrNull(semanticsNode) == null && !getInfoIsCheckable(semanticsNode)) {
            z = false;
        } else {
            z = true;
        }
        if (semanticsNode.unmergedConfig.isMergingSemanticsOfDescendants) {
            return true;
        }
        if (!semanticsNode.isFake && semanticsNode.getReplacedChildren$ui_release().isEmpty() && SemanticsNodeKt.findClosestParentNode(semanticsNode.layoutNode, SemanticsNode$isUnmergedLeafNode$1.INSTANCE) == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && z) {
            return true;
        }
        return false;
    }

    public final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.mo1701trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0028, code lost:            if (r5 == null) goto L93;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void notifySubtreeAppeared(androidx.compose.ui.semantics.SemanticsNode r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.notifySubtreeAppeared(androidx.compose.ui.semantics.SemanticsNode):void");
    }

    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int r2) {
        if (r2 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().id) {
            return -1;
        }
        return r2;
    }

    public final void sendAccessibilitySemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        int r4 = 0;
        while (true) {
            LayoutNode layoutNode = semanticsNode.layoutNode;
            if (r4 < size) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(r4);
                if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(semanticsNode2.id))) {
                    LinkedHashSet linkedHashSet2 = semanticsNodeCopy.children;
                    int r6 = semanticsNode2.id;
                    if (!linkedHashSet2.contains(Integer.valueOf(r6))) {
                        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        return;
                    }
                    linkedHashSet.add(Integer.valueOf(r6));
                }
                r4++;
            } else {
                Iterator it = semanticsNodeCopy.children.iterator();
                while (it.hasNext()) {
                    if (!linkedHashSet.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                        notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
                        return;
                    }
                }
                List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
                int size2 = replacedChildren$ui_release2.size();
                for (int r3 = 0; r3 < size2; r3++) {
                    SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(r3);
                    if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(semanticsNode3.id))) {
                        Object obj = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.id));
                        Intrinsics.checkNotNull(obj);
                        sendAccessibilitySemanticsStructureChangeEvents(semanticsNode3, (SemanticsNodeCopy) obj);
                    }
                }
                return;
            }
        }
    }

    public final void sendContentCaptureSemanticsStructureChangeEvents$ui_release(SemanticsNode semanticsNode, SemanticsNodeCopy oldNode) {
        Intrinsics.checkNotNullParameter(oldNode, "oldNode");
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int r3 = 0; r3 < size; r3++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(r3);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(semanticsNode2.id)) && !oldNode.children.contains(Integer.valueOf(semanticsNode2.id))) {
                notifySubtreeAppeared(semanticsNode2);
            }
        }
        LinkedHashMap linkedHashMap = this.previousSemanticsNodes;
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!getCurrentSemanticsNodes$ui_release().containsKey(entry.getKey())) {
                int intValue = ((Number) entry.getKey()).intValue();
                Integer valueOf = Integer.valueOf(intValue);
                ArrayMap<Integer, ViewStructureCompat> arrayMap = this.bufferedContentCaptureAppearedNodes;
                if (arrayMap.containsKey(valueOf)) {
                    arrayMap.remove(Integer.valueOf(intValue));
                } else {
                    this.bufferedContentCaptureDisappearedNodes.add(Integer.valueOf(intValue));
                }
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int r2 = 0; r2 < size2; r2++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(r2);
            if (getCurrentSemanticsNodes$ui_release().containsKey(Integer.valueOf(semanticsNode3.id))) {
                int r32 = semanticsNode3.id;
                if (linkedHashMap.containsKey(Integer.valueOf(r32))) {
                    Object obj = linkedHashMap.get(Integer.valueOf(r32));
                    Intrinsics.checkNotNull(obj);
                    sendContentCaptureSemanticsStructureChangeEvents$ui_release(semanticsNode3, (SemanticsNodeCopy) obj);
                }
            }
        }
    }

    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isEnabledForAccessibility()) {
            return false;
        }
        View view = this.view;
        return view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
    }

    public final boolean sendEventForVirtualView(int r2, int r3, Integer num, List<String> list) {
        if (r2 != Integer.MIN_VALUE && isEnabledForAccessibility()) {
            AccessibilityEvent createEvent$ui_release = createEvent$ui_release(r2, r3);
            if (num != null) {
                createEvent$ui_release.setContentChangeTypes(num.intValue());
            }
            if (list != null) {
                createEvent$ui_release.setContentDescription(TempListUtilsKt.fastJoinToString$default(list, ","));
            }
            return sendEvent(createEvent$ui_release);
        }
        return false;
    }

    public final void sendPaneChangeEvents(int r2, int r3, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(r2), 32);
        createEvent$ui_release.setContentChangeTypes(r3);
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        sendEvent(createEvent$ui_release);
    }

    public final void sendPendingTextTraversedAtGranularityEvent(int r7) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            SemanticsNode semanticsNode = pendingTextTraversedEvent.node;
            if (r7 != semanticsNode.id) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.traverseTime <= 1000) {
                AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.id), 131072);
                createEvent$ui_release.setFromIndex(pendingTextTraversedEvent.fromIndex);
                createEvent$ui_release.setToIndex(pendingTextTraversedEvent.toIndex);
                createEvent$ui_release.setAction(pendingTextTraversedEvent.action);
                createEvent$ui_release.setMovementGranularity(pendingTextTraversedEvent.granularity);
                createEvent$ui_release.getText().add(getIterableTextForAccessibility(semanticsNode));
                sendEvent(createEvent$ui_release);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    public final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> arraySet) {
        SemanticsConfiguration collapsedSemantics$ui_release;
        LayoutNode findClosestParentNode;
        if (!layoutNode.isAttached() || this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            return;
        }
        if (!layoutNode.nodes.m460hasH91voCI$ui_release(8)) {
            layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(LayoutNode layoutNode2) {
                    LayoutNode it = layoutNode2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.nodes.m460hasH91voCI$ui_release(8));
                }
            });
        }
        if (layoutNode != null && (collapsedSemantics$ui_release = layoutNode.getCollapsedSemantics$ui_release()) != null) {
            if (!collapsedSemantics$ui_release.isMergingSemanticsOfDescendants && (findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:            if (r2.isMergingSemanticsOfDescendants == true) goto L8;     */
                @Override // kotlin.jvm.functions.Function1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                    /*
                        r1 = this;
                        androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
                        java.lang.String r0 = "it"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getCollapsedSemantics$ui_release()
                        if (r2 == 0) goto L13
                        boolean r2 = r2.isMergingSemanticsOfDescendants
                        r0 = 1
                        if (r2 != r0) goto L13
                        goto L14
                    L13:
                        r0 = 0
                    L14:
                        java.lang.Boolean r2 = java.lang.Boolean.valueOf(r0)
                        return r2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.invoke(java.lang.Object):java.lang.Object");
                }
            })) != null) {
                layoutNode = findClosestParentNode;
            }
            int r3 = layoutNode.semanticsId;
            if (!arraySet.add(Integer.valueOf(r3))) {
                return;
            }
            sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(r3), 2048, 1, 8);
        }
    }

    public final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int r12, int r13, boolean z) {
        String iterableTextForAccessibility;
        Integer num;
        Integer num2;
        SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> semanticsPropertyKey = SemanticsActions.SetSelection;
        SemanticsConfiguration semanticsConfiguration = semanticsNode.unmergedConfig;
        boolean z2 = false;
        if (semanticsConfiguration.contains(semanticsPropertyKey) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.access$enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsConfiguration.get(semanticsPropertyKey)).action;
            if (function3 == null) {
                return false;
            }
            return ((Boolean) function3.invoke(Integer.valueOf(r12), Integer.valueOf(r13), Boolean.valueOf(z))).booleanValue();
        }
        if ((r12 == r13 && r13 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        }
        if (r12 < 0 || r12 != r13 || r13 > iterableTextForAccessibility.length()) {
            r12 = -1;
        }
        this.accessibilityCursorPosition = r12;
        if (iterableTextForAccessibility.length() > 0) {
            z2 = true;
        }
        int r11 = semanticsNode.id;
        int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(r11);
        Integer num3 = null;
        if (z2) {
            num = Integer.valueOf(this.accessibilityCursorPosition);
        } else {
            num = null;
        }
        if (z2) {
            num2 = Integer.valueOf(this.accessibilityCursorPosition);
        } else {
            num2 = null;
        }
        if (z2) {
            num3 = Integer.valueOf(iterableTextForAccessibility.length());
        }
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, num, num2, num3, iterableTextForAccessibility));
        sendPendingTextTraversedAtGranularityEvent(r11);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00f5, code lost:            if (r3 != false) goto L112;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v4, types: [androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$semanticComparator$$inlined$thenBy$1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.ArrayList subtreeSortedByGeometryGrouping(java.util.ArrayList r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.subtreeSortedByGeometryGrouping(java.util.ArrayList, boolean):java.util.ArrayList");
    }

    public final void updateHoveredVirtualView(int r5) {
        int r0 = this.hoveredVirtualViewId;
        if (r0 == r5) {
            return;
        }
        this.hoveredVirtualViewId = r5;
        sendEventForVirtualView$default(this, r5, 128, null, 12);
        sendEventForVirtualView$default(this, r0, 256, null, 12);
    }
}
