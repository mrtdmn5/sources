package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.R$styleable;
import com.amplifyframework.core.model.ModelIdentifier;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public View.OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    public ArrayList<View> mDisappearingFragmentChildren;
    public boolean mDrawDisappearingViewsFirst;
    public ArrayList<View> mTransitioningFragmentViews;

    public FragmentContainerView(Context context) {
        super(context);
        this.mDrawDisappearingViewsFirst = true;
    }

    public final void addDisappearingFragmentView(View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null && arrayList.contains(view)) {
            if (this.mDisappearingFragmentChildren == null) {
                this.mDisappearingFragmentChildren = new ArrayList<>();
            }
            this.mDisappearingFragmentChildren.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int r4, ViewGroup.LayoutParams layoutParams) {
        Fragment fragment;
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            fragment = (Fragment) tag;
        } else {
            fragment = null;
        }
        if (fragment != null) {
            super.addView(view, r4, layoutParams);
            return;
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup
    public final boolean addViewInLayout(View view, int r4, ViewGroup.LayoutParams layoutParams, boolean z) {
        Fragment fragment;
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            fragment = (Fragment) tag;
        } else {
            fragment = null;
        }
        if (fragment != null) {
            return super.addViewInLayout(view, r4, layoutParams, z);
        }
        throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        WindowInsetsCompat onApplyWindowInsets;
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsets = WindowInsetsCompat.toWindowInsetsCompat(null, onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets));
        } else {
            onApplyWindowInsets = ViewCompat.onApplyWindowInsets(this, windowInsetsCompat);
        }
        if (!onApplyWindowInsets.mImpl.isConsumed()) {
            int childCount = getChildCount();
            for (int r2 = 0; r2 < childCount; r2++) {
                ViewCompat.dispatchApplyWindowInsets(getChildAt(r2), onApplyWindowInsets);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
            for (int r0 = 0; r0 < this.mDisappearingFragmentChildren.size(); r0++) {
                super.drawChild(canvas, this.mDisappearingFragmentChildren.get(r0), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        ArrayList<View> arrayList;
        if (this.mDrawDisappearingViewsFirst && (arrayList = this.mDisappearingFragmentChildren) != null && arrayList.size() > 0 && this.mDisappearingFragmentChildren.contains(view)) {
            return false;
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        ArrayList<View> arrayList = this.mTransitioningFragmentViews;
        if (arrayList != null) {
            arrayList.remove(view);
            ArrayList<View> arrayList2 = this.mDisappearingFragmentChildren;
            if (arrayList2 != null && arrayList2.remove(view)) {
                this.mDrawDisappearingViewsFirst = true;
            }
        }
        super.endViewTransition(view);
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            addDisappearingFragmentView(getChildAt(childCount));
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        if (z) {
            addDisappearingFragmentView(view);
        }
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        addDisappearingFragmentView(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int r2) {
        addDisappearingFragmentView(getChildAt(r2));
        super.removeViewAt(r2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        addDisappearingFragmentView(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int r3, int r4) {
        for (int r0 = r3; r0 < r3 + r4; r0++) {
            addDisappearingFragmentView(getChildAt(r0));
        }
        super.removeViews(r3, r4);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int r3, int r4) {
        for (int r0 = r3; r0 < r3 + r4; r0++) {
            addDisappearingFragmentView(getChildAt(r0));
        }
        super.removeViewsInLayout(r3, r4);
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        this.mDrawDisappearingViewsFirst = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        this.mApplyWindowInsetsListener = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        if (view.getParent() == this) {
            if (this.mTransitioningFragmentViews == null) {
                this.mTransitioningFragmentViews = new ArrayList<>();
            }
            this.mTransitioningFragmentViews.add(view);
        }
        super.startViewTransition(view);
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        this.mDrawDisappearingViewsFirst = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
        }
    }

    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        View view;
        this.mDrawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id <= 0) {
                throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
            context.getClassLoader();
            Fragment instantiate = fragmentFactory.instantiate(classAttribute);
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
            backStackRecord.mReorderingAllowed = true;
            instantiate.mContainer = this;
            backStackRecord.doAddOp(getId(), instantiate, string, 1);
            if (!backStackRecord.mAddToBackStack) {
                backStackRecord.mAllowAddToBackStack = false;
                backStackRecord.mManager.execSingleAction(backStackRecord, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = fragmentManager.mFragmentStore.getActiveFragmentStateManagers().iterator();
        while (it.hasNext()) {
            FragmentStateManager fragmentStateManager = (FragmentStateManager) it.next();
            Fragment fragment = fragmentStateManager.mFragment;
            if (fragment.mContainerId == getId() && (view = fragment.mView) != null && view.getParent() == null) {
                fragment.mContainer = this;
                fragmentStateManager.addViewToContainer();
            }
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        return windowInsets;
    }
}
