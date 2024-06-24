package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    public final FragmentManager mFragmentManager;

    public FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        final FragmentStateManager createOrGetFragmentStateManager;
        boolean equals = FragmentContainerView.class.getName().equals(str);
        FragmentManager fragmentManager = this.mFragmentManager;
        if (equals) {
            return new FragmentContainerView(context, attributeSet, fragmentManager);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (attributeValue != null) {
            try {
                z = Fragment.class.isAssignableFrom(FragmentFactory.loadClass(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            if (z) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment findFragmentById = resourceId != -1 ? fragmentManager.findFragmentById(resourceId) : null;
                if (findFragmentById == null && string != null) {
                    findFragmentById = fragmentManager.findFragmentByTag(string);
                }
                if (findFragmentById == null && id != -1) {
                    findFragmentById = fragmentManager.findFragmentById(id);
                }
                if (findFragmentById == null) {
                    FragmentFactory fragmentFactory = fragmentManager.getFragmentFactory();
                    context.getClassLoader();
                    findFragmentById = fragmentFactory.instantiate(attributeValue);
                    findFragmentById.mFromLayout = true;
                    findFragmentById.mFragmentId = resourceId != 0 ? resourceId : id;
                    findFragmentById.mContainerId = id;
                    findFragmentById.mTag = string;
                    findFragmentById.mInLayout = true;
                    findFragmentById.mFragmentManager = fragmentManager;
                    FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
                    findFragmentById.mHost = fragmentHostCallback;
                    findFragmentById.onInflate(fragmentHostCallback.mContext, attributeSet, findFragmentById.mSavedFragmentState);
                    createOrGetFragmentStateManager = fragmentManager.addFragment(findFragmentById);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Fragment " + findFragmentById + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else if (!findFragmentById.mInLayout) {
                    findFragmentById.mInLayout = true;
                    findFragmentById.mFragmentManager = fragmentManager;
                    FragmentHostCallback<?> fragmentHostCallback2 = fragmentManager.mHost;
                    findFragmentById.mHost = fragmentHostCallback2;
                    findFragmentById.onInflate(fragmentHostCallback2.mContext, attributeSet, findFragmentById.mSavedFragmentState);
                    createOrGetFragmentStateManager = fragmentManager.createOrGetFragmentStateManager(findFragmentById);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Retained Fragment " + findFragmentById + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
                }
                findFragmentById.mContainer = (ViewGroup) view;
                createOrGetFragmentStateManager.moveToExpectedState();
                createOrGetFragmentStateManager.ensureInflatedView();
                View view2 = findFragmentById.mView;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (findFragmentById.mView.getTag() == null) {
                        findFragmentById.mView.setTag(string);
                    }
                    findFragmentById.mView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentLayoutInflaterFactory.1
                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewAttachedToWindow(View view3) {
                            FragmentStateManager fragmentStateManager = createOrGetFragmentStateManager;
                            Fragment fragment = fragmentStateManager.mFragment;
                            fragmentStateManager.moveToExpectedState();
                            SpecialEffectsController.getOrCreateController((ViewGroup) fragment.mView.getParent(), FragmentLayoutInflaterFactory.this.mFragmentManager).forceCompleteAllOperations();
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public final void onViewDetachedFromWindow(View view3) {
                        }
                    });
                    return findFragmentById.mView;
                }
                throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Fragment ", attributeValue, " did not create a view."));
            }
        }
        return null;
    }
}
