package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.ContainerHelpers;
import androidx.collection.LongSparseArray;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    public static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    public static final AnonymousClass1 STRAIGHT_PATH_MOTION = new AnonymousClass1();
    public static final ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal<>();
    public ArrayList<TransitionValues> mEndValuesList;
    public EpicenterCallback mEpicenterCallback;
    public ArrayList<TransitionValues> mStartValuesList;
    public final String mName = getClass().getName();
    public long mStartDelay = -1;
    public long mDuration = -1;
    public TimeInterpolator mInterpolator = null;
    public final ArrayList<Integer> mTargetIds = new ArrayList<>();
    public final ArrayList<View> mTargets = new ArrayList<>();
    public TransitionValuesMaps mStartValues = new TransitionValuesMaps();
    public TransitionValuesMaps mEndValues = new TransitionValuesMaps();
    public TransitionSet mParent = null;
    public final int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    public final ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    public int mNumInstances = 0;
    public boolean mPaused = false;
    public boolean mEnded = false;
    public ArrayList<TransitionListener> mListeners = null;
    public ArrayList<Animator> mAnimators = new ArrayList<>();
    public PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* renamed from: androidx.transition.Transition$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static class AnonymousClass1 extends PathMotion {
        @Override // androidx.transition.PathMotion
        public final Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* loaded from: classes.dex */
    public static class AnimationInfo {
        public final String mName;
        public final Transition mTransition;
        public final TransitionValues mValues;
        public final View mView;
        public final WindowIdImpl mWindowId;

        public AnimationInfo(View view, String str, Transition transition, WindowIdApi18 windowIdApi18, TransitionValues transitionValues) {
            this.mView = view;
            this.mName = str;
            this.mValues = transitionValues;
            this.mWindowId = windowIdApi18;
            this.mTransition = transition;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class EpicenterCallback {
    }

    /* loaded from: classes.dex */
    public interface TransitionListener {
        void onTransitionCancel();

        void onTransitionEnd(Transition transition);

        void onTransitionPause();

        void onTransitionResume();

        void onTransitionStart(Transition transition);
    }

    public static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues transitionValues) {
        transitionValuesMaps.mViewValues.put(view, transitionValues);
        int id = view.getId();
        if (id >= 0) {
            SparseArray<View> sparseArray = transitionValuesMaps.mIdValues;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
        if (transitionName != null) {
            ArrayMap<String, View> arrayMap = transitionValuesMaps.mNameValues;
            if (arrayMap.containsKey(transitionName)) {
                arrayMap.put(transitionName, null);
            } else {
                arrayMap.put(transitionName, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                LongSparseArray<View> longSparseArray = transitionValuesMaps.mItemIdValues;
                if (longSparseArray.mGarbage) {
                    longSparseArray.gc();
                }
                if (ContainerHelpers.binarySearch(longSparseArray.mKeys, longSparseArray.mSize, itemIdAtPosition) >= 0) {
                    View view2 = (View) longSparseArray.get(itemIdAtPosition, null);
                    if (view2 != null) {
                        ViewCompat.Api16Impl.setHasTransientState(view2, false);
                        longSparseArray.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                ViewCompat.Api16Impl.setHasTransientState(view, true);
                longSparseArray.put(itemIdAtPosition, view);
            }
        }
    }

    public static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ThreadLocal<ArrayMap<Animator, AnimationInfo>> threadLocal = sRunningAnimators;
        ArrayMap<Animator, AnimationInfo> arrayMap = threadLocal.get();
        if (arrayMap == null) {
            ArrayMap<Animator, AnimationInfo> arrayMap2 = new ArrayMap<>();
            threadLocal.set(arrayMap2);
            return arrayMap2;
        }
        return arrayMap;
    }

    public static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.values.get(str);
        Object obj2 = transitionValues2.values.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(transitionListener);
    }

    public void addTarget(View view) {
        this.mTargets.add(view);
    }

    public void cancel() {
        ArrayList<Animator> arrayList = this.mCurrentAnimators;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else {
                arrayList.get(size).cancel();
            }
        }
        ArrayList<TransitionListener> arrayList2 = this.mListeners;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList3.size();
            for (int r2 = 0; r2 < size2; r2++) {
                ((TransitionListener) arrayList3.get(r2)).onTransitionCancel();
            }
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public final void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        view.getId();
        if (view.getParent() instanceof ViewGroup) {
            TransitionValues transitionValues = new TransitionValues(view);
            if (z) {
                captureStartValues(transitionValues);
            } else {
                captureEndValues(transitionValues);
            }
            transitionValues.mTargetedTransitions.add(this);
            capturePropagationValues(transitionValues);
            if (z) {
                addViewValues(this.mStartValues, view, transitionValues);
            } else {
                addViewValues(this.mEndValues, view, transitionValues);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int r0 = 0; r0 < viewGroup.getChildCount(); r0++) {
                captureHierarchy(viewGroup.getChildAt(r0), z);
            }
        }
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    public final void captureValues(ViewGroup viewGroup, boolean z) {
        clearValues(z);
        ArrayList<Integer> arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.mTargets;
        if (size <= 0 && arrayList2.size() <= 0) {
            captureHierarchy(viewGroup, z);
            return;
        }
        for (int r3 = 0; r3 < arrayList.size(); r3++) {
            View findViewById = viewGroup.findViewById(arrayList.get(r3).intValue());
            if (findViewById != null) {
                TransitionValues transitionValues = new TransitionValues(findViewById);
                if (z) {
                    captureStartValues(transitionValues);
                } else {
                    captureEndValues(transitionValues);
                }
                transitionValues.mTargetedTransitions.add(this);
                capturePropagationValues(transitionValues);
                if (z) {
                    addViewValues(this.mStartValues, findViewById, transitionValues);
                } else {
                    addViewValues(this.mEndValues, findViewById, transitionValues);
                }
            }
        }
        for (int r1 = 0; r1 < arrayList2.size(); r1++) {
            View view = arrayList2.get(r1);
            TransitionValues transitionValues2 = new TransitionValues(view);
            if (z) {
                captureStartValues(transitionValues2);
            } else {
                captureEndValues(transitionValues2);
            }
            transitionValues2.mTargetedTransitions.add(this);
            capturePropagationValues(transitionValues2);
            if (z) {
                addViewValues(this.mStartValues, view, transitionValues2);
            } else {
                addViewValues(this.mEndValues, view, transitionValues2);
            }
        }
    }

    public final void clearValues(boolean z) {
        if (z) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
        } else {
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            this.mEndValues.mItemIdValues.clear();
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        boolean z;
        Animator createAnimator;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        Animator animator2;
        TransitionValues transitionValues2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int r12 = 0;
        while (r12 < size) {
            TransitionValues transitionValues3 = arrayList.get(r12);
            TransitionValues transitionValues4 = arrayList2.get(r12);
            if (transitionValues3 != null && !transitionValues3.mTargetedTransitions.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.mTargetedTransitions.contains(this)) {
                transitionValues4 = null;
            }
            if (transitionValues3 != null || transitionValues4 != null) {
                if (transitionValues3 != null && transitionValues4 != null && !isTransitionRequired(transitionValues3, transitionValues4)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && (createAnimator = createAnimator(viewGroup2, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        String[] transitionProperties = getTransitionProperties();
                        view = transitionValues4.view;
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            TransitionValues orDefault = transitionValuesMaps2.mViewValues.getOrDefault(view, null);
                            if (orDefault != null) {
                                int r11 = 0;
                                while (r11 < transitionProperties.length) {
                                    HashMap hashMap = transitionValues2.values;
                                    Animator animator3 = createAnimator;
                                    String str = transitionProperties[r11];
                                    hashMap.put(str, orDefault.values.get(str));
                                    r11++;
                                    createAnimator = animator3;
                                    transitionProperties = transitionProperties;
                                }
                            }
                            Animator animator4 = createAnimator;
                            int r0 = runningAnimators.mSize;
                            int r2 = 0;
                            while (true) {
                                if (r2 < r0) {
                                    AnimationInfo orDefault2 = runningAnimators.getOrDefault(runningAnimators.keyAt(r2), null);
                                    if (orDefault2.mValues != null && orDefault2.mView == view && orDefault2.mName.equals(this.mName) && orDefault2.mValues.equals(transitionValues2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    r2++;
                                } else {
                                    animator2 = animator4;
                                    break;
                                }
                            }
                        } else {
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        view = transitionValues3.view;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        String str2 = this.mName;
                        ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
                        runningAnimators.put(animator, new AnimationInfo(view, str2, this, new WindowIdApi18(viewGroup2), transitionValues));
                        this.mAnimators.add(animator);
                    }
                    r12++;
                    viewGroup2 = viewGroup;
                }
            }
            r12++;
            viewGroup2 = viewGroup;
        }
        if (sparseIntArray.size() != 0) {
            for (int r112 = 0; r112 < sparseIntArray.size(); r112++) {
                Animator animator5 = this.mAnimators.get(sparseIntArray.keyAt(r112));
                animator5.setStartDelay(animator5.getStartDelay() + (sparseIntArray.valueAt(r112) - Long.MAX_VALUE));
            }
        }
    }

    public final void end() {
        int r0 = this.mNumInstances - 1;
        this.mNumInstances = r0;
        if (r0 == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int r4 = 0; r4 < size; r4++) {
                    ((TransitionListener) arrayList2.get(r4)).onTransitionEnd(this);
                }
            }
            for (int r02 = 0; r02 < this.mStartValues.mItemIdValues.size(); r02++) {
                View valueAt = this.mStartValues.mItemIdValues.valueAt(r02);
                if (valueAt != null) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.setHasTransientState(valueAt, false);
                }
            }
            for (int r03 = 0; r03 < this.mEndValues.mItemIdValues.size(); r03++) {
                View valueAt2 = this.mEndValues.mItemIdValues.valueAt(r03);
                if (valueAt2 != null) {
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api16Impl.setHasTransientState(valueAt2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public final TransitionValues getMatchedTransitionValues(View view, boolean z) {
        ArrayList<TransitionValues> arrayList;
        ArrayList<TransitionValues> arrayList2;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        if (z) {
            arrayList = this.mStartValuesList;
        } else {
            arrayList = this.mEndValuesList;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                TransitionValues transitionValues = arrayList.get(r3);
                if (transitionValues == null) {
                    return null;
                }
                if (transitionValues.view == view) {
                    break;
                }
                r3++;
            } else {
                r3 = -1;
                break;
            }
        }
        if (r3 < 0) {
            return null;
        }
        if (z) {
            arrayList2 = this.mEndValuesList;
        } else {
            arrayList2 = this.mStartValuesList;
        }
        return arrayList2.get(r3);
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public final TransitionValues getTransitionValues(View view, boolean z) {
        TransitionValuesMaps transitionValuesMaps;
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        if (z) {
            transitionValuesMaps = this.mStartValues;
        } else {
            transitionValuesMaps = this.mEndValues;
        }
        return transitionValuesMaps.mViewValues.getOrDefault(view, null);
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(transitionValues, transitionValues2, str)) {
                }
            }
            return false;
        }
        Iterator it = transitionValues.values.keySet().iterator();
        while (it.hasNext()) {
            if (isValueChanged(transitionValues, transitionValues2, (String) it.next())) {
            }
        }
        return false;
        return true;
    }

    public final boolean isValidTarget(View view) {
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.mTargets;
        if ((size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view)) {
            return true;
        }
        return false;
    }

    public void pause(View view) {
        int r3;
        if (!this.mEnded) {
            ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            int r1 = runningAnimators.mSize;
            ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
            WindowId windowId = view.getWindowId();
            int r12 = r1 - 1;
            while (true) {
                r3 = 0;
                if (r12 < 0) {
                    break;
                }
                AnimationInfo valueAt = runningAnimators.valueAt(r12);
                if (valueAt.mView != null) {
                    WindowIdImpl windowIdImpl = valueAt.mWindowId;
                    if ((windowIdImpl instanceof WindowIdApi18) && ((WindowIdApi18) windowIdImpl).mWindowId.equals(windowId)) {
                        r3 = 1;
                    }
                    if (r3 != 0) {
                        runningAnimators.keyAt(r12).pause();
                    }
                }
                r12--;
            }
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                while (r3 < size) {
                    ((TransitionListener) arrayList2.get(r3)).onTransitionPause();
                    r3++;
                }
            }
            this.mPaused = true;
        }
    }

    public void removeListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
    }

    public void removeTarget(View view) {
        this.mTargets.remove(view);
    }

    public void resume(ViewGroup viewGroup) {
        boolean z;
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                int r2 = runningAnimators.mSize;
                ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
                WindowId windowId = viewGroup.getWindowId();
                for (int r22 = r2 - 1; r22 >= 0; r22--) {
                    AnimationInfo valueAt = runningAnimators.valueAt(r22);
                    if (valueAt.mView != null) {
                        WindowIdImpl windowIdImpl = valueAt.mWindowId;
                        if ((windowIdImpl instanceof WindowIdApi18) && ((WindowIdApi18) windowIdImpl).mWindowId.equals(windowId)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            runningAnimators.keyAt(r22).resume();
                        }
                    }
                }
                ArrayList<TransitionListener> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size = arrayList2.size();
                    for (int r23 = 0; r23 < size; r23++) {
                        ((TransitionListener) arrayList2.get(r23)).onTransitionResume();
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.2
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            runningAnimators.remove(animator);
                            Transition.this.mCurrentAnimators.remove(animator);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationStart(Animator animator) {
                            Transition.this.mCurrentAnimators.add(animator);
                        }
                    });
                    long j = this.mDuration;
                    if (j >= 0) {
                        next.setDuration(j);
                    }
                    long j2 = this.mStartDelay;
                    if (j2 >= 0) {
                        next.setStartDelay(next.getStartDelay() + j2);
                    }
                    TimeInterpolator timeInterpolator = this.mInterpolator;
                    if (timeInterpolator != null) {
                        next.setInterpolator(timeInterpolator);
                    }
                    next.addListener(new AnimatorListenerAdapter() { // from class: androidx.transition.Transition.3
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public final void onAnimationEnd(Animator animator) {
                            Transition.this.end();
                            animator.removeListener(this);
                        }
                    });
                    next.start();
                }
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    public final void start() {
        if (this.mNumInstances == 0) {
            ArrayList<TransitionListener> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int r3 = 0; r3 < size; r3++) {
                    ((TransitionListener) arrayList2.get(r3)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString(String str) {
        StringBuilder m = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(str);
        m.append(getClass().getSimpleName());
        m.append("@");
        m.append(Integer.toHexString(hashCode()));
        m.append(": ");
        String sb = m.toString();
        if (this.mDuration != -1) {
            StringBuilder m2 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(sb, "dur(");
            m2.append(this.mDuration);
            m2.append(") ");
            sb = m2.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder m3 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(sb, "dly(");
            m3.append(this.mStartDelay);
            m3.append(") ");
            sb = m3.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder m4 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(sb, "interp(");
            m4.append(this.mInterpolator);
            m4.append(") ");
            sb = m4.toString();
        }
        ArrayList<Integer> arrayList = this.mTargetIds;
        int size = arrayList.size();
        ArrayList<View> arrayList2 = this.mTargets;
        if (size <= 0 && arrayList2.size() <= 0) {
            return sb;
        }
        String m5 = ComposableInvoker$$ExternalSyntheticOutline0.m(sb, "tgts(");
        if (arrayList.size() > 0) {
            for (int r1 = 0; r1 < arrayList.size(); r1++) {
                if (r1 > 0) {
                    m5 = ComposableInvoker$$ExternalSyntheticOutline0.m(m5, ", ");
                }
                StringBuilder m6 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m5);
                m6.append(arrayList.get(r1));
                m5 = m6.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int r4 = 0; r4 < arrayList2.size(); r4++) {
                if (r4 > 0) {
                    m5 = ComposableInvoker$$ExternalSyntheticOutline0.m(m5, ", ");
                }
                StringBuilder m7 = FirebaseRemoteConfig$$ExternalSyntheticLambda0.m(m5);
                m7.append(arrayList2.get(r4));
                m5 = m7.toString();
            }
        }
        return ComposableInvoker$$ExternalSyntheticOutline0.m(m5, ")");
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo613clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new TransitionValuesMaps();
            transition.mEndValues = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public void setPropagation() {
    }

    public void capturePropagationValues(TransitionValues transitionValues) {
    }

    public final String toString() {
        return toString("");
    }
}
