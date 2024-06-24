package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.SpecialEffectsController;
import androidx.lifecycle.Lifecycle;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class FragmentStateManager {
    public final FragmentLifecycleCallbacksDispatcher mDispatcher;
    public final Fragment mFragment;
    public final FragmentStore mFragmentStore;
    public boolean mMovingToState = false;
    public int mFragmentManagerState = -1;

    /* renamed from: androidx.fragment.app.FragmentStateManager$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$State;

        static {
            int[] r0 = new int[Lifecycle.State.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$State = r0;
            try {
                r0[Lifecycle.State.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$State[Lifecycle.State.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
    }

    public final void activityCreated() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        this.mDispatcher.dispatchOnFragmentActivityCreated(false);
    }

    public final void addViewToContainer() {
        View view;
        View view2;
        FragmentStore fragmentStore = this.mFragmentStore;
        fragmentStore.getClass();
        Fragment fragment = this.mFragment;
        ViewGroup viewGroup = fragment.mContainer;
        int r3 = -1;
        if (viewGroup != null) {
            ArrayList<Fragment> arrayList = fragmentStore.mAdded;
            int indexOf = arrayList.indexOf(fragment);
            int r5 = indexOf - 1;
            while (true) {
                if (r5 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = arrayList.get(indexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            r3 = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = arrayList.get(r5);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        r3 = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    r5--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, r3);
    }

    public final void attach() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        FragmentStateManager fragmentStateManager = null;
        FragmentStore fragmentStore = this.mFragmentStore;
        if (fragment2 != null) {
            FragmentStateManager fragmentStateManager2 = fragmentStore.mActive.get(fragment2.mWho);
            if (fragmentStateManager2 != null) {
                fragment.mTargetWho = fragment.mTarget.mWho;
                fragment.mTarget = null;
                fragmentStateManager = fragmentStateManager2;
            } else {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (fragmentStateManager = fragmentStore.mActive.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (fragmentStateManager != null) {
            fragmentStateManager.moveToExpectedState();
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        fragment.mHost = fragmentManager.mHost;
        fragment.mParentFragment = fragmentManager.mParent;
        FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentPreAttached(false);
        fragment.performAttach();
        fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentAttached(false);
    }

    public final int computeExpectedState() {
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact;
        Fragment fragment = this.mFragment;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int r1 = this.mFragmentManagerState;
        int r2 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$State[fragment.mMaxState.ordinal()];
        if (r2 != 1) {
            if (r2 != 2) {
                if (r2 != 3) {
                    if (r2 != 4) {
                        r1 = Math.min(r1, -1);
                    } else {
                        r1 = Math.min(r1, 0);
                    }
                } else {
                    r1 = Math.min(r1, 1);
                }
            } else {
                r1 = Math.min(r1, 5);
            }
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                r1 = Math.max(this.mFragmentManagerState, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    r1 = Math.min(r1, 2);
                }
            } else {
                r1 = this.mFragmentManagerState < 4 ? Math.min(r1, fragment.mState) : Math.min(r1, 1);
            }
        }
        if (!fragment.mAdded) {
            r1 = Math.min(r1, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        SpecialEffectsController.Operation.LifecycleImpact lifecycleImpact2 = null;
        SpecialEffectsController.Operation operation = null;
        if (viewGroup != null) {
            SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
            orCreateController.getClass();
            SpecialEffectsController.Operation findPendingOperation = orCreateController.findPendingOperation(fragment);
            if (findPendingOperation != null) {
                lifecycleImpact = findPendingOperation.mLifecycleImpact;
            } else {
                lifecycleImpact = null;
            }
            Iterator<SpecialEffectsController.Operation> it = orCreateController.mRunningOperations.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpecialEffectsController.Operation next = it.next();
                if (next.mFragment.equals(fragment) && !next.mIsCanceled) {
                    operation = next;
                    break;
                }
            }
            if (operation != null && (lifecycleImpact == null || lifecycleImpact == SpecialEffectsController.Operation.LifecycleImpact.NONE)) {
                lifecycleImpact2 = operation.mLifecycleImpact;
            } else {
                lifecycleImpact2 = lifecycleImpact;
            }
        }
        if (lifecycleImpact2 == SpecialEffectsController.Operation.LifecycleImpact.ADDING) {
            r1 = Math.min(r1, 6);
        } else if (lifecycleImpact2 == SpecialEffectsController.Operation.LifecycleImpact.REMOVING) {
            r1 = Math.max(r1, 3);
        } else if (fragment.mRemoving) {
            if (fragment.isInBackStack()) {
                r1 = Math.min(r1, 1);
            } else {
                r1 = Math.min(r1, -1);
            }
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            r1 = Math.min(r1, 4);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + r1 + " for " + fragment);
        }
        return r1;
    }

    public final void create() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (!fragment.mIsCreated) {
            FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher = this.mDispatcher;
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentPreCreated(false);
            fragment.performCreate(fragment.mSavedFragmentState);
            fragmentLifecycleCallbacksDispatcher.dispatchOnFragmentCreated(false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        fragment.mState = 1;
    }

    public final void createView() {
        String str;
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout) {
            return;
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int r3 = fragment.mContainerId;
            if (r3 != 0) {
                if (r3 != -1) {
                    viewGroup = (ViewGroup) fragment.mFragmentManager.mContainer.onFindViewById(r3);
                    if (viewGroup == null && !fragment.mRestored) {
                        try {
                            str = fragment.getResources().getResourceName(fragment.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + str + ") for fragment " + fragment);
                    }
                } else {
                    throw new IllegalArgumentException(Fragment$$ExternalSyntheticOutline0.m("Cannot create fragment ", fragment, " for a container view with no id"));
                }
            } else {
                viewGroup = null;
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(performGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                addViewToContainer();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isAttachedToWindow(view2)) {
                ViewCompat.Api20Impl.requestApplyInsets(fragment.mView);
            } else {
                final View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.fragment.app.FragmentStateManager.1
                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewAttachedToWindow(View view4) {
                        View view5 = view3;
                        view5.removeOnAttachStateChangeListener(this);
                        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                        ViewCompat.Api20Impl.requestApplyInsets(view5);
                    }

                    @Override // android.view.View.OnAttachStateChangeListener
                    public final void onViewDetachedFromWindow(View view4) {
                    }
                });
            }
            fragment.performViewCreated();
            this.mDispatcher.dispatchOnFragmentViewCreated(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View findFocus = fragment.mView.findFocus();
                if (findFocus != null) {
                    fragment.setFocusedView(findFocus);
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void destroy() {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.destroy():void");
    }

    public final void destroyFragmentView() {
        View view;
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.mDispatcher.dispatchOnFragmentViewDestroyed(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void detach() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        boolean z = false;
        this.mDispatcher.dispatchOnFragmentDetached(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        boolean z2 = true;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (!z) {
            FragmentManagerViewModel fragmentManagerViewModel = this.mFragmentStore.mNonConfig;
            if (fragmentManagerViewModel.mRetainedFragments.containsKey(fragment.mWho) && fragmentManagerViewModel.mStateAutomaticallySaved) {
                z2 = fragmentManagerViewModel.mHasBeenCleared;
            }
            if (!z2) {
                return;
            }
        }
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void ensureInflatedView() {
        Fragment fragment = this.mFragment;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R.id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.mDispatcher.dispatchOnFragmentViewCreated(false);
                fragment.mState = 2;
            }
        }
    }

    public final void moveToExpectedState() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.mMovingToState;
        Fragment fragment = this.mFragment;
        if (z) {
            if (FragmentManager.isLoggingEnabled(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.mMovingToState = true;
            while (true) {
                int computeExpectedState = computeExpectedState();
                int r6 = fragment.mState;
                if (computeExpectedState != r6) {
                    if (computeExpectedState > r6) {
                        switch (r6 + 1) {
                            case 0:
                                attach();
                                break;
                            case 1:
                                create();
                                break;
                            case 2:
                                ensureInflatedView();
                                createView();
                                break;
                            case 3:
                                activityCreated();
                                break;
                            case 4:
                                if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                    SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup2, fragment.getParentFragmentManager());
                                    SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(fragment.mView.getVisibility());
                                    orCreateController.getClass();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                    }
                                    orCreateController.enqueue(from, SpecialEffectsController.Operation.LifecycleImpact.ADDING, this);
                                }
                                fragment.mState = 4;
                                break;
                            case 5:
                                start();
                                break;
                            case 6:
                                fragment.mState = 6;
                                break;
                            case 7:
                                resume();
                                break;
                        }
                    } else {
                        switch (r6 - 1) {
                            case -1:
                                detach();
                                break;
                            case 0:
                                destroy();
                                break;
                            case 1:
                                destroyFragmentView();
                                fragment.mState = 1;
                                break;
                            case 2:
                                fragment.mInLayout = false;
                                fragment.mState = 2;
                                break;
                            case 3:
                                if (FragmentManager.isLoggingEnabled(3)) {
                                    Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                                }
                                if (fragment.mView != null && fragment.mSavedViewState == null) {
                                    saveViewState();
                                }
                                if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                    SpecialEffectsController orCreateController2 = SpecialEffectsController.getOrCreateController(viewGroup3, fragment.getParentFragmentManager());
                                    orCreateController2.getClass();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                    }
                                    orCreateController2.enqueue(SpecialEffectsController.Operation.State.REMOVED, SpecialEffectsController.Operation.LifecycleImpact.REMOVING, this);
                                }
                                fragment.mState = 3;
                                break;
                            case 4:
                                stop();
                                break;
                            case 5:
                                fragment.mState = 5;
                                break;
                            case 6:
                                pause();
                                break;
                        }
                    }
                } else {
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            SpecialEffectsController orCreateController3 = SpecialEffectsController.getOrCreateController(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                orCreateController3.getClass();
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                orCreateController3.enqueue(SpecialEffectsController.Operation.State.GONE, SpecialEffectsController.Operation.LifecycleImpact.NONE, this);
                            } else {
                                orCreateController3.getClass();
                                if (FragmentManager.isLoggingEnabled(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                orCreateController3.enqueue(SpecialEffectsController.Operation.State.VISIBLE, SpecialEffectsController.Operation.LifecycleImpact.NONE, this);
                            }
                        }
                        FragmentManager fragmentManager = fragment.mFragmentManager;
                        if (fragmentManager != null && fragment.mAdded && FragmentManager.isMenuAvailable(fragment)) {
                            fragmentManager.mNeedMenuInvalidate = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                    }
                    return;
                }
            }
        } finally {
            this.mMovingToState = false;
        }
    }

    public final void pause() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.performPause();
        this.mDispatcher.dispatchOnFragmentPaused(false);
    }

    public final void restoreState(ClassLoader classLoader) {
        Fragment fragment = this.mFragment;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (!fragment.mUserVisibleHint) {
            fragment.mDeferStart = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void resume() {
        /*
            r7 = this;
            r0 = 3
            boolean r0 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r0)
            java.lang.String r1 = "FragmentManager"
            androidx.fragment.app.Fragment r2 = r7.mFragment
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            r3 = 0
            if (r0 == 0) goto L7e
            android.view.View r4 = r2.mView
            if (r0 != r4) goto L28
            goto L32
        L28:
            android.view.ViewParent r4 = r0.getParent()
        L2c:
            if (r4 == 0) goto L39
            android.view.View r5 = r2.mView
            if (r4 != r5) goto L34
        L32:
            r4 = 1
            goto L3a
        L34:
            android.view.ViewParent r4 = r4.getParent()
            goto L2c
        L39:
            r4 = r3
        L3a:
            if (r4 == 0) goto L7e
            boolean r4 = r0.requestFocus()
            r5 = 2
            boolean r5 = androidx.fragment.app.FragmentManager.isLoggingEnabled(r5)
            if (r5 == 0) goto L7e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "requestFocus: Restoring focused view "
            r5.<init>(r6)
            r5.append(r0)
            java.lang.String r0 = " "
            r5.append(r0)
            if (r4 == 0) goto L5c
            java.lang.String r0 = "succeeded"
            goto L5e
        L5c:
            java.lang.String r0 = "failed"
        L5e:
            r5.append(r0)
            java.lang.String r0 = " on Fragment "
            r5.append(r0)
            r5.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r5.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            android.util.Log.v(r1, r0)
        L7e:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            androidx.fragment.app.FragmentLifecycleCallbacksDispatcher r1 = r7.mDispatcher
            r1.dispatchOnFragmentResumed(r3)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentStateManager.resume():void");
    }

    public final void saveViewState() {
        Fragment fragment = this.mFragment;
        if (fragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.mSavedStateRegistryController.performSave(bundle);
        if (!bundle.isEmpty()) {
            fragment.mSavedViewRegistryState = bundle;
        }
    }

    public final void start() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.performStart();
        this.mDispatcher.dispatchOnFragmentStarted(false);
    }

    public final void stop() {
        boolean isLoggingEnabled = FragmentManager.isLoggingEnabled(3);
        Fragment fragment = this.mFragment;
        if (isLoggingEnabled) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        fragment.performStop();
        this.mDispatcher.dispatchOnFragmentStopped(false);
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, ClassLoader classLoader, FragmentFactory fragmentFactory, FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        Fragment instantiate = fragmentFactory.instantiate(fragmentState.mClassName);
        this.mFragment = instantiate;
        Bundle bundle = fragmentState.mArguments;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle);
        instantiate.mWho = fragmentState.mWho;
        instantiate.mFromLayout = fragmentState.mFromLayout;
        instantiate.mRestored = true;
        instantiate.mFragmentId = fragmentState.mFragmentId;
        instantiate.mContainerId = fragmentState.mContainerId;
        instantiate.mTag = fragmentState.mTag;
        instantiate.mRetainInstance = fragmentState.mRetainInstance;
        instantiate.mRemoving = fragmentState.mRemoving;
        instantiate.mDetached = fragmentState.mDetached;
        instantiate.mHidden = fragmentState.mHidden;
        instantiate.mMaxState = Lifecycle.State.values()[fragmentState.mMaxLifecycleState];
        Bundle bundle2 = fragmentState.mSavedFragmentState;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public FragmentStateManager(FragmentLifecycleCallbacksDispatcher fragmentLifecycleCallbacksDispatcher, FragmentStore fragmentStore, Fragment fragment, FragmentState fragmentState) {
        this.mDispatcher = fragmentLifecycleCallbacksDispatcher;
        this.mFragmentStore = fragmentStore;
        this.mFragment = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.mSavedFragmentState;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
