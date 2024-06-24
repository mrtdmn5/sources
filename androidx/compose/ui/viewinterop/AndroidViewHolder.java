package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.Snapshot$Companion$registerApplyObserver$2;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.AndroidCanvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollNode;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.input.pointer.RequestDisallowInterceptTouchEvent;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityImpl;
import androidx.compose.ui.unit.VelocityKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.kronaby.watch.app.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt;

/* compiled from: AndroidViewHolder.android.kt */
/* loaded from: classes.dex */
public class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3, ComposeNodeLifecycleCallback {
    public Density density;
    public final NestedScrollDispatcher dispatcher;
    public boolean hasUpdateBlock;
    public int lastHeightMeasureSpec;
    public int lastWidthMeasureSpec;
    public final LayoutNode layoutNode;
    public LifecycleOwner lifecycleOwner;
    public final int[] location;
    public Modifier modifier;
    public final NestedScrollingParentHelper nestedScrollingParentHelper;
    public final AndroidViewHolder$onCommitAffectingUpdate$1 onCommitAffectingUpdate;
    public Function1<? super Density, Unit> onDensityChanged;
    public Function1<? super Modifier, Unit> onModifierChanged;
    public Function1<? super Boolean, Unit> onRequestDisallowInterceptTouchEvent;
    public Function0<Unit> release;
    public Function0<Unit> reset;
    public final AndroidViewHolder$runUpdate$1 runUpdate;
    public SavedStateRegistryOwner savedStateRegistryOwner;
    public final SnapshotStateObserver snapshotObserver;
    public Function0<Unit> update;
    public final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(Context context, CompositionContext compositionContext, int r5, NestedScrollDispatcher dispatcher, View view) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(view, "view");
        this.dispatcher = dispatcher;
        this.view = view;
        if (compositionContext != null) {
            LinkedHashMap linkedHashMap = WindowRecomposer_androidKt.animationScale;
            setTag(R.id.androidx_compose_ui_view_composition_context, compositionContext);
        }
        setSaveFromParentEnabled(false);
        addView(view);
        this.update = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$update$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        this.reset = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$reset$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        this.release = new Function0<Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$release$1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        };
        Modifier.Companion companion = Modifier.Companion.$$INSTANCE;
        this.modifier = companion;
        this.density = new DensityImpl(1.0f, 1.0f);
        final ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) this;
        this.snapshotObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$snapshotObserver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Function0<? extends Unit> function0) {
                final Function0<? extends Unit> command = function0;
                Intrinsics.checkNotNullParameter(command, "command");
                AndroidViewHolder androidViewHolder = viewFactoryHolder;
                if (androidViewHolder.getHandler().getLooper() == Looper.myLooper()) {
                    command.invoke();
                } else {
                    androidViewHolder.getHandler().post(new Runnable() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$snapshotObserver$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            Function0 tmp0 = Function0.this;
                            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                            tmp0.invoke();
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        });
        this.onCommitAffectingUpdate = new Function1<AndroidViewHolder, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$onCommitAffectingUpdate$1
            public final /* synthetic */ AndroidViewHolder this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AndroidViewHolder$onCommitAffectingUpdate$1(final ViewFactoryHolder viewFactoryHolder2) {
                super(1);
                r1 = viewFactoryHolder2;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(AndroidViewHolder androidViewHolder) {
                AndroidViewHolder it = androidViewHolder;
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidViewHolder androidViewHolder2 = r1;
                Handler handler = androidViewHolder2.getHandler();
                final AndroidViewHolder$runUpdate$1 androidViewHolder$runUpdate$1 = androidViewHolder2.runUpdate;
                handler.post(new Runnable() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$onCommitAffectingUpdate$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        Function0 tmp0 = androidViewHolder$runUpdate$1;
                        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
                        tmp0.invoke();
                    }
                });
                return Unit.INSTANCE;
            }
        };
        this.runUpdate = new AndroidViewHolder$runUpdate$1(viewFactoryHolder2);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper();
        final LayoutNode layoutNode = new LayoutNode(false, 3, 0);
        layoutNode.interopViewFactoryHolder = this;
        Modifier semantics = SemanticsModifierKt.semantics(NestedScrollModifierKt.nestedScroll(companion, AndroidViewHolder_androidKt.NoOpScrollConnection, dispatcher), true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                SemanticsPropertyReceiver semantics2 = semanticsPropertyReceiver;
                Intrinsics.checkNotNullParameter(semantics2, "$this$semantics");
                return Unit.INSTANCE;
            }
        });
        Intrinsics.checkNotNullParameter(semantics, "<this>");
        PointerInteropFilter pointerInteropFilter = new PointerInteropFilter();
        pointerInteropFilter.onTouchEvent = new Function1<MotionEvent, Boolean>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt$pointerInteropFilter$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MotionEvent motionEvent) {
                boolean dispatchTouchEvent;
                MotionEvent motionEvent2 = motionEvent;
                Intrinsics.checkNotNullParameter(motionEvent2, "motionEvent");
                int actionMasked = motionEvent2.getActionMasked();
                AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                switch (actionMasked) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        dispatchTouchEvent = androidViewHolder.dispatchTouchEvent(motionEvent2);
                        break;
                    default:
                        dispatchTouchEvent = androidViewHolder.dispatchGenericMotionEvent(motionEvent2);
                        break;
                }
                return Boolean.valueOf(dispatchTouchEvent);
            }
        };
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent = new RequestDisallowInterceptTouchEvent();
        RequestDisallowInterceptTouchEvent requestDisallowInterceptTouchEvent2 = pointerInteropFilter.requestDisallowInterceptTouchEvent;
        if (requestDisallowInterceptTouchEvent2 != null) {
            requestDisallowInterceptTouchEvent2.pointerInteropFilter = null;
        }
        pointerInteropFilter.requestDisallowInterceptTouchEvent = requestDisallowInterceptTouchEvent;
        requestDisallowInterceptTouchEvent.pointerInteropFilter = pointerInteropFilter;
        setOnRequestDisallowInterceptTouchEvent$ui_release(requestDisallowInterceptTouchEvent);
        final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(semantics.then(pointerInteropFilter), new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(DrawScope drawScope) {
                AndroidComposeView androidComposeView;
                DrawScope drawBehind = drawScope;
                Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
                Canvas canvas = drawBehind.getDrawContext().getCanvas();
                Owner owner = LayoutNode.this.owner;
                if (owner instanceof AndroidComposeView) {
                    androidComposeView = (AndroidComposeView) owner;
                } else {
                    androidComposeView = null;
                }
                if (androidComposeView != null) {
                    android.graphics.Canvas canvas2 = AndroidCanvas_androidKt.EmptyCanvas;
                    Intrinsics.checkNotNullParameter(canvas, "<this>");
                    android.graphics.Canvas canvas3 = ((AndroidCanvas) canvas).internalCanvas;
                    AndroidViewHolder view2 = viewFactoryHolder2;
                    Intrinsics.checkNotNullParameter(view2, "view");
                    Intrinsics.checkNotNullParameter(canvas3, "canvas");
                    androidComposeView.getAndroidViewsHandler$ui_release().getClass();
                    view2.draw(canvas3);
                }
                return Unit.INSTANCE;
            }
        }), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$coreModifier$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(LayoutCoordinates layoutCoordinates) {
                LayoutCoordinates it = layoutCoordinates;
                Intrinsics.checkNotNullParameter(it, "it");
                AndroidViewHolder_androidKt.access$layoutAccordingTo(viewFactoryHolder2, layoutNode);
                return Unit.INSTANCE;
            }
        });
        layoutNode.setModifier(this.modifier.then(onGloballyPositioned));
        this.onModifierChanged = new Function1<Modifier, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Modifier modifier) {
                Modifier it = modifier;
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setModifier(it.then(onGloballyPositioned));
                return Unit.INSTANCE;
            }
        };
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new Function1<Density, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Density density) {
                Density it = density;
                Intrinsics.checkNotNullParameter(it, "it");
                LayoutNode.this.setDensity(it);
                return Unit.INSTANCE;
            }
        };
        layoutNode.onAttach = new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Owner owner) {
                final AndroidComposeView androidComposeView;
                Owner owner2 = owner;
                Intrinsics.checkNotNullParameter(owner2, "owner");
                if (owner2 instanceof AndroidComposeView) {
                    androidComposeView = (AndroidComposeView) owner2;
                } else {
                    androidComposeView = null;
                }
                AndroidViewHolder view2 = viewFactoryHolder2;
                if (androidComposeView != null) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    final LayoutNode layoutNode2 = layoutNode;
                    Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
                    androidComposeView.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view2, layoutNode2);
                    androidComposeView.getAndroidViewsHandler$ui_release().addView(view2);
                    androidComposeView.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode2, view2);
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.setImportantForAccessibility(view2, 1);
                    ViewCompat.setAccessibilityDelegate(view2, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1
                        /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:            if (r0.intValue() == r2.getSemanticsOwner().getUnmergedRootSemanticsNode().id) goto L10;     */
                        @Override // androidx.core.view.AccessibilityDelegateCompat
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final void onInitializeAccessibilityNodeInfo(android.view.View r8, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r9) {
                            /*
                                r7 = this;
                                java.lang.String r0 = "host"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                                android.view.View$AccessibilityDelegate r0 = r7.mOriginalDelegate
                                android.view.accessibility.AccessibilityNodeInfo r1 = r9.mInfo
                                r0.onInitializeAccessibilityNodeInfo(r8, r1)
                                androidx.compose.ui.node.LayoutNode r8 = androidx.compose.ui.node.LayoutNode.this
                                androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new kotlin.jvm.functions.Function1<androidx.compose.ui.node.LayoutNode, java.lang.Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                    static {
                                        /*
                                            androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1 r0 = new androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                            r0.<init>()
                                            
                                            // error: 0x0005: SPUT (r0 I:androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1) androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.INSTANCE androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<clinit>():void");
                                    }

                                    {
                                        /*
                                            r1 = this;
                                            r0 = 1
                                            r1.<init>(r0)
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.<init>():void");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r2) {
                                        /*
                                            r1 = this;
                                            androidx.compose.ui.node.LayoutNode r2 = (androidx.compose.ui.node.LayoutNode) r2
                                            java.lang.String r0 = "it"
                                            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                            androidx.compose.ui.node.NodeChain r2 = r2.nodes
                                            r0 = 8
                                            boolean r2 = r2.m460hasH91voCI$ui_release(r0)
                                            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
                                            return r2
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1$onInitializeAccessibilityNodeInfo$parentId$1.invoke(java.lang.Object):java.lang.Object");
                                    }
                                }
                                androidx.compose.ui.node.LayoutNode r0 = androidx.compose.ui.semantics.SemanticsNodeKt.findClosestParentNode(r8, r0)
                                if (r0 == 0) goto L1d
                                int r0 = r0.semanticsId
                                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                                goto L1e
                            L1d:
                                r0 = 0
                            L1e:
                                androidx.compose.ui.platform.AndroidComposeView r2 = r2
                                if (r0 == 0) goto L32
                                androidx.compose.ui.semantics.SemanticsOwner r3 = r2.getSemanticsOwner()
                                androidx.compose.ui.semantics.SemanticsNode r3 = r3.getUnmergedRootSemanticsNode()
                                int r4 = r0.intValue()
                                int r3 = r3.id
                                if (r4 != r3) goto L37
                            L32:
                                r0 = -1
                                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                            L37:
                                int r0 = r0.intValue()
                                r9.mParentVirtualDescendantId = r0
                                androidx.compose.ui.platform.AndroidComposeView r9 = r3
                                r1.setParent(r9, r0)
                                int r8 = r8.semanticsId
                                androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r0 = r2.accessibilityDelegate
                                java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r0.idToBeforeMap
                                java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
                                java.lang.Object r0 = r0.get(r3)
                                java.lang.Integer r0 = (java.lang.Integer) r0
                                androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r3 = r2.accessibilityDelegate
                                java.lang.String r4 = "info.unwrap()"
                                if (r0 == 0) goto L79
                                int r5 = r0.intValue()
                                androidx.compose.ui.platform.AndroidViewsHandler r6 = r2.getAndroidViewsHandler$ui_release()
                                int r0 = r0.intValue()
                                androidx.compose.ui.viewinterop.AndroidViewHolder r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(r6, r0)
                                if (r0 == 0) goto L6e
                                r1.setTraversalBefore(r0)
                                goto L71
                            L6e:
                                r1.setTraversalBefore(r9, r5)
                            L71:
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                                java.lang.String r0 = r3.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL
                                androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r2, r8, r1, r0)
                            L79:
                                java.util.HashMap<java.lang.Integer, java.lang.Integer> r0 = r3.idToAfterMap
                                java.lang.Integer r5 = java.lang.Integer.valueOf(r8)
                                java.lang.Object r0 = r0.get(r5)
                                java.lang.Integer r0 = (java.lang.Integer) r0
                                if (r0 == 0) goto La8
                                int r5 = r0.intValue()
                                androidx.compose.ui.platform.AndroidViewsHandler r6 = r2.getAndroidViewsHandler$ui_release()
                                int r0 = r0.intValue()
                                androidx.compose.ui.viewinterop.AndroidViewHolder r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.semanticsIdToView(r6, r0)
                                if (r0 == 0) goto L9d
                                r1.setTraversalAfter(r0)
                                goto La0
                            L9d:
                                r1.setTraversalAfter(r9, r5)
                            La0:
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
                                java.lang.String r9 = r3.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL
                                androidx.compose.ui.platform.AndroidComposeView.access$addExtraDataToAccessibilityNodeInfoHelper(r2, r8, r1, r9)
                            La8:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeView$addAndroidView$1.onInitializeAccessibilityNodeInfo(android.view.View, androidx.core.view.accessibility.AccessibilityNodeInfoCompat):void");
                        }
                    });
                }
                if (view2.getView().getParent() != view2) {
                    view2.addView(view2.getView());
                }
                return Unit.INSTANCE;
            }
        };
        layoutNode.onDetach = new Function1<Owner, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Owner owner) {
                final AndroidComposeView androidComposeView;
                Owner owner2 = owner;
                Intrinsics.checkNotNullParameter(owner2, "owner");
                if (owner2 instanceof AndroidComposeView) {
                    androidComposeView = (AndroidComposeView) owner2;
                } else {
                    androidComposeView = null;
                }
                final AndroidViewHolder view2 = viewFactoryHolder2;
                if (androidComposeView != null) {
                    Intrinsics.checkNotNullParameter(view2, "view");
                    androidComposeView.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeView$removeAndroidView$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            AndroidComposeView androidComposeView2 = AndroidComposeView.this;
                            AndroidViewsHandler androidViewsHandler$ui_release = androidComposeView2.getAndroidViewsHandler$ui_release();
                            AndroidViewHolder androidViewHolder = view2;
                            androidViewsHandler$ui_release.removeViewInLayout(androidViewHolder);
                            HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = androidComposeView2.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
                            TypeIntrinsics.asMutableMap(layoutNodeToHolder).remove(androidComposeView2.getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(androidViewHolder));
                            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                            ViewCompat.Api16Impl.setImportantForAccessibility(androidViewHolder, 0);
                            return Unit.INSTANCE;
                        }
                    });
                }
                view2.removeAllViewsInLayout();
                return Unit.INSTANCE;
            }
        };
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, 0, r4, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return androidViewHolder.getMeasuredHeight();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r52) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(makeMeasureSpec, AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, 0, r52, layoutParams.height));
                return androidViewHolder.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public final MeasureResult mo4measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long j) {
                Intrinsics.checkNotNullParameter(measure, "$this$measure");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                final AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                int childCount = androidViewHolder.getChildCount();
                EmptyMap emptyMap = EmptyMap.INSTANCE;
                if (childCount == 0) {
                    return measure.layout(Constraints.m567getMinWidthimpl(j), Constraints.m566getMinHeightimpl(j), emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Placeable.PlacementScope placementScope) {
                            Placeable.PlacementScope layout = placementScope;
                            Intrinsics.checkNotNullParameter(layout, "$this$layout");
                            return Unit.INSTANCE;
                        }
                    });
                }
                if (Constraints.m567getMinWidthimpl(j) != 0) {
                    androidViewHolder.getChildAt(0).setMinimumWidth(Constraints.m567getMinWidthimpl(j));
                }
                if (Constraints.m566getMinHeightimpl(j) != 0) {
                    androidViewHolder.getChildAt(0).setMinimumHeight(Constraints.m566getMinHeightimpl(j));
                }
                int m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
                int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                int access$obtainMeasureSpec = AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, m567getMinWidthimpl, m565getMaxWidthimpl, layoutParams.width);
                int m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
                int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
                ViewGroup.LayoutParams layoutParams2 = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2);
                androidViewHolder.measure(access$obtainMeasureSpec, AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, m566getMinHeightimpl, m564getMaxHeightimpl, layoutParams2.height));
                int measuredWidth = androidViewHolder.getMeasuredWidth();
                int measuredHeight = androidViewHolder.getMeasuredHeight();
                final LayoutNode layoutNode2 = layoutNode;
                return measure.layout(measuredWidth, measuredHeight, emptyMap, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5$measure$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Placeable.PlacementScope placementScope) {
                        Placeable.PlacementScope layout = placementScope;
                        Intrinsics.checkNotNullParameter(layout, "$this$layout");
                        AndroidViewHolder_androidKt.access$layoutAccordingTo(androidViewHolder, layoutNode2);
                        return Unit.INSTANCE;
                    }
                });
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r4) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, 0, r4, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return androidViewHolder.getMeasuredHeight();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public final int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int r52) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder = viewFactoryHolder2;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams);
                androidViewHolder.measure(makeMeasureSpec, AndroidViewHolder.access$obtainMeasureSpec(androidViewHolder, 0, r52, layoutParams.height));
                return androidViewHolder.getMeasuredWidth();
            }
        });
        this.layoutNode = layoutNode;
    }

    public static final int access$obtainMeasureSpec(AndroidViewHolder androidViewHolder, int r2, int r3, int r4) {
        androidViewHolder.getClass();
        if (r4 < 0 && r2 != r3) {
            if (r4 == -2 && r3 != Integer.MAX_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(r3, Integer.MIN_VALUE);
            }
            if (r4 == -1 && r3 != Integer.MAX_VALUE) {
                return View.MeasureSpec.makeMeasureSpec(r3, 1073741824);
            }
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        return View.MeasureSpec.makeMeasureSpec(RangesKt___RangesKt.coerceIn(r4, r2, r3), 1073741824);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean gatherTransparentRegion(Region region) {
        if (region == null) {
            return true;
        }
        int[] r1 = this.location;
        getLocationInWindow(r1);
        int r4 = r1[0];
        region.op(r4, r1[1], getWidth() + r4, getHeight() + r1[1], Region.Op.DIFFERENCE);
        return true;
    }

    public final Density getDensity() {
        return this.density;
    }

    public final View getInteropView() {
        return this.view;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams = this.view.getLayoutParams();
        if (layoutParams == null) {
            return new ViewGroup.LayoutParams(-1, -1);
        }
        return layoutParams;
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.nestedScrollingParentHelper;
        return nestedScrollingParentHelper.mNestedScrollAxesNonTouch | nestedScrollingParentHelper.mNestedScrollAxesTouch;
    }

    public final Function1<Density, Unit> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    public final Function1<Modifier, Unit> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    public final Function1<Boolean, Unit> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    public final Function0<Unit> getRelease() {
        return this.release;
    }

    public final Function0<Unit> getReset() {
        return this.reset;
    }

    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    public final Function0<Unit> getUpdate() {
        return this.update;
    }

    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final ViewParent invalidateChildInParent(int[] r1, Rect rect) {
        super.invalidateChildInParent(r1, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.view.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onDeactivate() {
        this.reset.invoke();
        removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onDescendantInvalidated(View child, View target) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onDescendantInvalidated(child, target);
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SnapshotStateObserver snapshotStateObserver = this.snapshotObserver;
        Snapshot$Companion$registerApplyObserver$2 snapshot$Companion$registerApplyObserver$2 = snapshotStateObserver.applyUnsubscribe;
        if (snapshot$Companion$registerApplyObserver$2 != null) {
            snapshot$Companion$registerApplyObserver$2.dispose();
        }
        snapshotStateObserver.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r2, int r3, int r4, int r5) {
        this.view.layout(0, 0, r4 - r2, r5 - r3);
    }

    @Override // android.view.View
    public final void onMeasure(int r3, int r4) {
        View view = this.view;
        if (view.getParent() != this) {
            setMeasuredDimension(View.MeasureSpec.getSize(r3), View.MeasureSpec.getSize(r4));
            return;
        }
        view.measure(r3, r4);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
        this.lastWidthMeasureSpec = r3;
        this.lastHeightMeasureSpec = r4;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View target, float f, float f2, boolean z) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedFling$1(z, this, VelocityKt.Velocity(f * (-1.0f), f2 * (-1.0f)), null), 3);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View target, float f, float f2) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        BuildersKt.launch$default(this.dispatcher.getCoroutineScope(), null, null, new AndroidViewHolder$onNestedPreFling$1(this, VelocityKt.Velocity(f * (-1.0f), f2 * (-1.0f)), null), 3);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View target, int r3, int r4, int[] r5, int r6) {
        int r62;
        long j;
        Intrinsics.checkNotNullParameter(target, "target");
        if (!isNestedScrollingEnabled()) {
            return;
        }
        float f = r3;
        float f2 = -1;
        long Offset = OffsetKt.Offset(f * f2, r4 * f2);
        if (r6 == 0) {
            r62 = 1;
        } else {
            r62 = 2;
        }
        NestedScrollNode parent$ui_release = this.dispatcher.getParent$ui_release();
        if (parent$ui_release != null) {
            j = parent$ui_release.mo53onPreScrollOzD1aCk(r62, Offset);
        } else {
            j = Offset.Zero;
        }
        r5[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m259getXimpl(j));
        r5[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m260getYimpl(j));
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View target, int r8, int r9, int r10, int r11, int r12, int[] r13) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            float f = r8;
            float f2 = -1;
            long m404dispatchPostScrollDzOQY0M = this.dispatcher.m404dispatchPostScrollDzOQY0M(r12 == 0 ? 1 : 2, OffsetKt.Offset(f * f2, r9 * f2), OffsetKt.Offset(r10 * f2, r11 * f2));
            r13[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m259getXimpl(m404dispatchPostScrollDzOQY0M));
            r13[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m260getYimpl(m404dispatchPostScrollDzOQY0M));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View child, View target, int r4, int r5) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        NestedScrollingParentHelper nestedScrollingParentHelper = this.nestedScrollingParentHelper;
        if (r5 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = r4;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = r4;
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onRelease() {
        this.release.invoke();
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public final void onReuse() {
        View view = this.view;
        if (view.getParent() != this) {
            addView(view);
        } else {
            this.reset.invoke();
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean onStartNestedScroll(View child, View target, int r3, int r4) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if ((r3 & 2) != 0 || (r3 & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onStopNestedScroll(View target, int r4) {
        Intrinsics.checkNotNullParameter(target, "target");
        NestedScrollingParentHelper nestedScrollingParentHelper = this.nestedScrollingParentHelper;
        if (r4 == 1) {
            nestedScrollingParentHelper.mNestedScrollAxesNonTouch = 0;
        } else {
            nestedScrollingParentHelper.mNestedScrollAxesTouch = 0;
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        Function1<? super Boolean, Unit> function1 = this.onRequestDisallowInterceptTouchEvent;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public final void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.density) {
            this.density = value;
            Function1<? super Density, Unit> function1 = this.onDensityChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final void setModifier(Modifier value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value != this.modifier) {
            this.modifier = value;
            Function1<? super Modifier, Unit> function1 = this.onModifierChanged;
            if (function1 != null) {
                function1.invoke(value);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(Function1<? super Density, Unit> function1) {
        this.onDensityChanged = function1;
    }

    public final void setOnModifierChanged$ui_release(Function1<? super Modifier, Unit> function1) {
        this.onModifierChanged = function1;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(Function1<? super Boolean, Unit> function1) {
        this.onRequestDisallowInterceptTouchEvent = function1;
    }

    public final void setRelease(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.release = function0;
    }

    public final void setReset(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.reset = function0;
    }

    public final void setSavedStateRegistryOwner(SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    public final void setUpdate(Function0<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void onNestedScroll(View target, int r8, int r9, int r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (isNestedScrollingEnabled()) {
            float f = r8;
            float f2 = -1;
            this.dispatcher.m404dispatchPostScrollDzOQY0M(r12 == 0 ? 1 : 2, OffsetKt.Offset(f * f2, r9 * f2), OffsetKt.Offset(r10 * f2, r11 * f2));
        }
    }
}
