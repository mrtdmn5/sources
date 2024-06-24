package androidx.customview.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat$Api16Impl;
import androidx.customview.widget.FocusStrategy;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import java.util.ArrayList;
import java.util.WeakHashMap;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public abstract class ExploreByTouchHelper extends AccessibilityDelegateCompat {
    public static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final AnonymousClass1 NODE_ADAPTER = new AnonymousClass1();
    public static final AnonymousClass2 SPARSE_VALUES_ADAPTER = new AnonymousClass2();
    public final View mHost;
    public final AccessibilityManager mManager;
    public MyNodeProvider mNodeProvider;
    public final Rect mTempScreenRect = new Rect();
    public final Rect mTempParentRect = new Rect();
    public final Rect mTempVisibleRect = new Rect();
    public final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> {
    }

    /* renamed from: androidx.customview.widget.ExploreByTouchHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 {
    }

    /* loaded from: classes.dex */
    public class MyNodeProvider extends AccessibilityNodeProviderCompat {
        public MyNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int r2) {
            return new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(r2).mInfo));
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final AccessibilityNodeInfoCompat findFocus(int r3) {
            int r32;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            if (r3 == 2) {
                r32 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId;
            } else {
                r32 = exploreByTouchHelper.mKeyboardFocusedVirtualViewId;
            }
            if (r32 == Integer.MIN_VALUE) {
                return null;
            }
            return createAccessibilityNodeInfo(r32);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public final boolean performAction(int r7, int r8, Bundle bundle) {
            int r82;
            ExploreByTouchHelper exploreByTouchHelper = ExploreByTouchHelper.this;
            View view = exploreByTouchHelper.mHost;
            if (r7 != -1) {
                boolean z = true;
                if (r8 != 1) {
                    if (r8 != 2) {
                        boolean z2 = false;
                        if (r8 != 64) {
                            if (r8 != 128) {
                                Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) exploreByTouchHelper;
                                if (r8 == 16) {
                                    Chip chip = Chip.this;
                                    if (r7 == 0) {
                                        return chip.performClick();
                                    }
                                    if (r7 == 1) {
                                        chip.playSoundEffect(0);
                                        View.OnClickListener onClickListener = chip.onCloseIconClickListener;
                                        if (onClickListener != null) {
                                            onClickListener.onClick(chip);
                                            z2 = true;
                                        }
                                        if (chip.touchHelperEnabled) {
                                            chip.touchHelper.sendEventForVirtualView(1, 1);
                                        }
                                    }
                                }
                                return z2;
                            }
                            if (exploreByTouchHelper.mAccessibilityFocusedVirtualViewId == r7) {
                                exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                                view.invalidate();
                                exploreByTouchHelper.sendEventForVirtualView(r7, 65536);
                            }
                            z = false;
                        } else {
                            AccessibilityManager accessibilityManager = exploreByTouchHelper.mManager;
                            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled() && (r82 = exploreByTouchHelper.mAccessibilityFocusedVirtualViewId) != r7) {
                                if (r82 != Integer.MIN_VALUE) {
                                    exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
                                    exploreByTouchHelper.mHost.invalidate();
                                    exploreByTouchHelper.sendEventForVirtualView(r82, 65536);
                                }
                                exploreByTouchHelper.mAccessibilityFocusedVirtualViewId = r7;
                                view.invalidate();
                                exploreByTouchHelper.sendEventForVirtualView(r7, DfuBaseService.ERROR_CONNECTION_STATE_MASK);
                            }
                            z = false;
                        }
                        return z;
                    }
                    return exploreByTouchHelper.clearKeyboardFocusForVirtualView(r7);
                }
                return exploreByTouchHelper.requestKeyboardFocusForVirtualView(r7);
            }
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            return ViewCompat.Api16Impl.performAccessibilityAction(view, r8, bundle);
        }
    }

    public ExploreByTouchHelper(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api16Impl.getImportantForAccessibility(view) == 0) {
                ViewCompat.Api16Impl.setImportantForAccessibility(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public final boolean clearKeyboardFocusForVirtualView(int r4) {
        if (this.mKeyboardFocusedVirtualViewId != r4) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (r4 == 1) {
            Chip chip = Chip.this;
            chip.closeIconFocused = false;
            chip.refreshDrawableState();
        }
        sendEventForVirtualView(r4, 8);
        return true;
    }

    public final AccessibilityNodeInfoCompat createNodeForChild(int r12) {
        boolean z;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        accessibilityNodeInfoCompat.setClassName("android.view.View");
        Rect rect = INVALID_PARENT_BOUNDS;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        accessibilityNodeInfoCompat.mParentVirtualDescendantId = -1;
        View view = this.mHost;
        obtain.setParent(view);
        onPopulateNodeForVirtualView(r12, accessibilityNodeInfoCompat);
        if (accessibilityNodeInfoCompat.getText() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.mTempParentRect;
        accessibilityNodeInfoCompat.getBoundsInParent(rect2);
        if (!rect2.equals(rect)) {
            int actions = obtain.getActions();
            if ((actions & 64) == 0) {
                if ((actions & 128) == 0) {
                    obtain.setPackageName(view.getContext().getPackageName());
                    accessibilityNodeInfoCompat.mVirtualDescendantId = r12;
                    obtain.setSource(view, r12);
                    boolean z2 = false;
                    if (this.mAccessibilityFocusedVirtualViewId == r12) {
                        obtain.setAccessibilityFocused(true);
                        accessibilityNodeInfoCompat.addAction(128);
                    } else {
                        obtain.setAccessibilityFocused(false);
                        accessibilityNodeInfoCompat.addAction(64);
                    }
                    if (this.mKeyboardFocusedVirtualViewId == r12) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        accessibilityNodeInfoCompat.addAction(2);
                    } else if (obtain.isFocusable()) {
                        accessibilityNodeInfoCompat.addAction(1);
                    }
                    obtain.setFocused(z);
                    int[] r122 = this.mTempGlobalRect;
                    view.getLocationOnScreen(r122);
                    Rect rect3 = this.mTempScreenRect;
                    obtain.getBoundsInScreen(rect3);
                    if (rect3.equals(rect)) {
                        accessibilityNodeInfoCompat.getBoundsInParent(rect3);
                        if (accessibilityNodeInfoCompat.mParentVirtualDescendantId != -1) {
                            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = new AccessibilityNodeInfoCompat(AccessibilityNodeInfo.obtain());
                            for (int r0 = accessibilityNodeInfoCompat.mParentVirtualDescendantId; r0 != -1; r0 = accessibilityNodeInfoCompat2.mParentVirtualDescendantId) {
                                accessibilityNodeInfoCompat2.mParentVirtualDescendantId = -1;
                                AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat2.mInfo;
                                accessibilityNodeInfo.setParent(view, -1);
                                accessibilityNodeInfo.setBoundsInParent(rect);
                                onPopulateNodeForVirtualView(r0, accessibilityNodeInfoCompat2);
                                accessibilityNodeInfoCompat2.getBoundsInParent(rect2);
                                rect3.offset(rect2.left, rect2.top);
                            }
                        }
                        rect3.offset(r122[0] - view.getScrollX(), r122[1] - view.getScrollY());
                    }
                    Rect rect4 = this.mTempVisibleRect;
                    if (view.getLocalVisibleRect(rect4)) {
                        rect4.offset(r122[0] - view.getScrollX(), r122[1] - view.getScrollY());
                        if (rect3.intersect(rect4)) {
                            AccessibilityNodeInfo accessibilityNodeInfo2 = accessibilityNodeInfoCompat.mInfo;
                            accessibilityNodeInfo2.setBoundsInScreen(rect3);
                            if (!rect3.isEmpty() && view.getWindowVisibility() == 0) {
                                Object parent = view.getParent();
                                while (true) {
                                    if (parent instanceof View) {
                                        View view2 = (View) parent;
                                        if (view2.getAlpha() <= 0.0f || view2.getVisibility() != 0) {
                                            break;
                                        }
                                        parent = view2.getParent();
                                    } else if (parent != null) {
                                        z2 = true;
                                    }
                                }
                            }
                            if (z2) {
                                accessibilityNodeInfo2.setVisibleToUser(true);
                            }
                        }
                    }
                    return accessibilityNodeInfoCompat;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new MyNodeProvider();
        }
        return this.mNodeProvider;
    }

    public abstract void getVisibleVirtualViews(ArrayList arrayList);

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0147, code lost:            if (r14 < ((r15 * r15) + ((r13 * 13) * r13))) goto L68;     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0153 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean moveFocus(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ExploreByTouchHelper.moveFocus(int, android.graphics.Rect):boolean");
    }

    public final AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int r7) {
        if (r7 == -1) {
            View view = this.mHost;
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(view);
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(obtain);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            view.onInitializeAccessibilityNodeInfo(obtain);
            ArrayList arrayList = new ArrayList();
            getVisibleVirtualViews(arrayList);
            if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
                throw new RuntimeException("Views cannot have both real and virtual children");
            }
            int size = arrayList.size();
            for (int r3 = 0; r3 < size; r3++) {
                accessibilityNodeInfoCompat.mInfo.addChild(view, ((Integer) arrayList.get(r3)).intValue());
            }
            return accessibilityNodeInfoCompat;
        }
        return createNodeForChild(r7);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        boolean z;
        View.AccessibilityDelegate accessibilityDelegate = this.mOriginalDelegate;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        accessibilityDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = Chip.this;
        ChipDrawable chipDrawable = chip.chipDrawable;
        if (chipDrawable != null && chipDrawable.checkable) {
            z = true;
        } else {
            z = false;
        }
        accessibilityNodeInfo.setCheckable(z);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        accessibilityNodeInfoCompat.setClassName(chip.getAccessibilityClassName());
        accessibilityNodeInfoCompat.setText(chip.getText());
    }

    public abstract void onPopulateNodeForVirtualView(int r1, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat);

    public final boolean requestKeyboardFocusForVirtualView(int r4) {
        int r0;
        View view = this.mHost;
        if ((!view.isFocused() && !view.requestFocus()) || (r0 = this.mKeyboardFocusedVirtualViewId) == r4) {
            return false;
        }
        if (r0 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(r0);
        }
        if (r4 == Integer.MIN_VALUE) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = r4;
        Chip.ChipTouchHelper chipTouchHelper = (Chip.ChipTouchHelper) this;
        if (r4 == 1) {
            Chip chip = Chip.this;
            chip.closeIconFocused = true;
            chip.refreshDrawableState();
        }
        sendEventForVirtualView(r4, 8);
        return true;
    }

    public final void sendEventForVirtualView(int r6, int r7) {
        View view;
        ViewParent parent;
        AccessibilityEvent obtain;
        if (r6 == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = (view = this.mHost).getParent()) == null) {
            return;
        }
        if (r6 != -1) {
            obtain = AccessibilityEvent.obtain(r7);
            AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(r6);
            obtain.getText().add(obtainAccessibilityNodeInfo.getText());
            AccessibilityNodeInfo accessibilityNodeInfo = obtainAccessibilityNodeInfo.mInfo;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            AccessibilityRecordCompat$Api16Impl.setSource(obtain, view, r6);
            obtain.setPackageName(view.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(r7);
            view.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(view, obtain);
    }
}
