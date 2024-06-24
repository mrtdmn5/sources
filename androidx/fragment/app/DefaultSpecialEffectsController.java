package androidx.fragment.app;

import android.content.Context;
import android.transition.Transition;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.MapCollections;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat$Api21Impl;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] r0 = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = r0;
            try {
                r0[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        public FragmentAnim.AnimationOrAnimator mAnimation;
        public final boolean mIsPop;
        public boolean mLoadedAnim;

        public AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z;
        }

        public final FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            boolean z;
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            SpecialEffectsController.Operation operation = this.mOperation;
            Fragment fragment = operation.mFragment;
            if (operation.mFinalState == SpecialEffectsController.Operation.State.VISIBLE) {
                z = true;
            } else {
                z = false;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, fragment, z, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {
        public final SpecialEffectsController.Operation mOperation;
        public final CancellationSignal mSignal;

        public SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        public final void completeSpecialEffect() {
            SpecialEffectsController.Operation operation = this.mOperation;
            HashSet<CancellationSignal> hashSet = operation.mSpecialEffectsSignals;
            if (hashSet.remove(this.mSignal) && hashSet.isEmpty()) {
                operation.complete();
            }
        }

        public final boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation operation = this.mOperation;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation.mFragment.mView);
            SpecialEffectsController.Operation.State state2 = operation.mFinalState;
            if (from != state2 && (from == (state = SpecialEffectsController.Operation.State.VISIBLE) || state2 == state)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        public final boolean mOverlapAllowed;
        public final Object mSharedElementTransition;
        public final Object mTransition;

        public TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z, boolean z2) {
            super(operation, cancellationSignal);
            Object exitTransition;
            Object enterTransition;
            boolean allowEnterTransitionOverlap;
            SpecialEffectsController.Operation.State state = operation.mFinalState;
            SpecialEffectsController.Operation.State state2 = SpecialEffectsController.Operation.State.VISIBLE;
            Fragment fragment = operation.mFragment;
            if (state == state2) {
                if (z) {
                    enterTransition = fragment.getReenterTransition();
                } else {
                    enterTransition = fragment.getEnterTransition();
                }
                this.mTransition = enterTransition;
                if (z) {
                    allowEnterTransitionOverlap = fragment.getAllowReturnTransitionOverlap();
                } else {
                    allowEnterTransitionOverlap = fragment.getAllowEnterTransitionOverlap();
                }
                this.mOverlapAllowed = allowEnterTransitionOverlap;
            } else {
                if (z) {
                    exitTransition = fragment.getReturnTransition();
                } else {
                    exitTransition = fragment.getExitTransition();
                }
                this.mTransition = exitTransition;
                this.mOverlapAllowed = true;
            }
            if (z2) {
                if (z) {
                    this.mSharedElementTransition = fragment.getSharedElementReturnTransition();
                    return;
                } else {
                    this.mSharedElementTransition = fragment.getSharedElementEnterTransition();
                    return;
                }
            }
            this.mSharedElementTransition = null;
        }

        public final FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionCompat21 fragmentTransitionCompat21 = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionCompat21 != null && (obj instanceof Transition)) {
                return fragmentTransitionCompat21;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + this.mOperation.mFragment + " is not a valid framework Transition or AndroidX Transition");
        }
    }

    public static void captureTransitioningViews(ArrayList arrayList, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (ViewGroupCompat$Api21Impl.isTransitionGroup(viewGroup)) {
                if (!arrayList.contains(view)) {
                    arrayList.add(viewGroup);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int r1 = 0; r1 < childCount; r1++) {
                View childAt = viewGroup.getChildAt(r1);
                if (childAt.getVisibility() == 0) {
                    captureTransitioningViews(arrayList, childAt);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    public static void findNamedViews(ArrayMap arrayMap, View view) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
        if (transitionName != null) {
            arrayMap.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int r1 = 0; r1 < childCount; r1++) {
                View childAt = viewGroup.getChildAt(r1);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(arrayMap, childAt);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void retainMatchingViews(ArrayMap arrayMap, Collection collection) {
        Iterator it = ((MapCollections.EntrySet) arrayMap.entrySet()).iterator();
        while (true) {
            MapCollections.MapIterator mapIterator = (MapCollections.MapIterator) it;
            if (mapIterator.hasNext()) {
                mapIterator.next();
                View view = (View) mapIterator.getValue();
                WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                if (!collection.contains(ViewCompat.Api21Impl.getTransitionName(view))) {
                    mapIterator.remove();
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0597  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x062a A[LOOP:6: B:154:0x0624->B:156:0x062a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x04fa  */
    @Override // androidx.fragment.app.SpecialEffectsController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void executeOperations(java.util.ArrayList r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 1598
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.DefaultSpecialEffectsController.executeOperations(java.util.ArrayList, boolean):void");
    }
}
