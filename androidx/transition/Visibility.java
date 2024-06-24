package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class Visibility extends Transition {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public int mMode = 3;

    /* loaded from: classes.dex */
    public static class VisibilityInfo {
        public ViewGroup mEndParent;
        public int mEndVisibility;
        public boolean mFadeIn;
        public ViewGroup mStartParent;
        public int mStartVisibility;
        public boolean mVisibilityChange;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static androidx.transition.Visibility.VisibilityInfo getVisibilityChangeInfo(androidx.transition.TransitionValues r8, androidx.transition.TransitionValues r9) {
        /*
            androidx.transition.Visibility$VisibilityInfo r0 = new androidx.transition.Visibility$VisibilityInfo
            r0.<init>()
            r1 = 0
            r0.mVisibilityChange = r1
            r0.mFadeIn = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L2f
            java.util.HashMap r6 = r8.values
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L2f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.mStartVisibility = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.mStartParent = r6
            goto L33
        L2f:
            r0.mStartVisibility = r4
            r0.mStartParent = r3
        L33:
            if (r9 == 0) goto L52
            java.util.HashMap r6 = r9.values
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L52
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.mEndVisibility = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.mEndParent = r2
            goto L56
        L52:
            r0.mEndVisibility = r4
            r0.mEndParent = r3
        L56:
            r2 = 1
            if (r8 == 0) goto L8a
            if (r9 == 0) goto L8a
            int r8 = r0.mStartVisibility
            int r9 = r0.mEndVisibility
            if (r8 != r9) goto L68
            android.view.ViewGroup r3 = r0.mStartParent
            android.view.ViewGroup r4 = r0.mEndParent
            if (r3 != r4) goto L68
            return r0
        L68:
            if (r8 == r9) goto L78
            if (r8 != 0) goto L71
            r0.mFadeIn = r1
            r0.mVisibilityChange = r2
            goto L9f
        L71:
            if (r9 != 0) goto L9f
            r0.mFadeIn = r2
            r0.mVisibilityChange = r2
            goto L9f
        L78:
            android.view.ViewGroup r8 = r0.mEndParent
            if (r8 != 0) goto L81
            r0.mFadeIn = r1
            r0.mVisibilityChange = r2
            goto L9f
        L81:
            android.view.ViewGroup r8 = r0.mStartParent
            if (r8 != 0) goto L9f
            r0.mFadeIn = r2
            r0.mVisibilityChange = r2
            goto L9f
        L8a:
            if (r8 != 0) goto L95
            int r8 = r0.mEndVisibility
            if (r8 != 0) goto L95
            r0.mFadeIn = r2
            r0.mVisibilityChange = r2
            goto L9f
        L95:
            if (r9 != 0) goto L9f
            int r8 = r0.mStartVisibility
            if (r8 != 0) goto L9f
            r0.mFadeIn = r1
            r0.mVisibilityChange = r2
        L9f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.getVisibilityChangeInfo(androidx.transition.TransitionValues, androidx.transition.TransitionValues):androidx.transition.Visibility$VisibilityInfo");
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int visibility = view.getVisibility();
        HashMap hashMap = transitionValues.values;
        hashMap.put("android:visibility:visibility", Integer.valueOf(visibility));
        hashMap.put("android:visibility:parent", view.getParent());
        int[] r1 = new int[2];
        view.getLocationOnScreen(r1);
        hashMap.put("android:visibility:screenLocation", r1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:            if (getVisibilityChangeInfo(getMatchedTransitionValues(r3, false), getTransitionValues(r3, false)).mVisibilityChange != false) goto L30;     */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01eb  */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.Animator createAnimator(final android.view.ViewGroup r22, androidx.transition.TransitionValues r23, androidx.transition.TransitionValues r24) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public final String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public final boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey("android:visibility:visibility") != transitionValues.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return false;
        }
        if (visibilityChangeInfo.mStartVisibility != 0 && visibilityChangeInfo.mEndVisibility != 0) {
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final int mFinalVisibility;
        public boolean mLayoutSuppressed;
        public final ViewGroup mParent;
        public final View mView;
        public boolean mCanceled = false;
        public final boolean mSuppressLayout = true;

        public DisappearListener(View view, int r3) {
            this.mView = view;
            this.mFinalVisibility = r3;
            this.mParent = (ViewGroup) view.getParent();
            suppressLayout(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mFinalVisibility, this.mView);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mFinalVisibility, this.mView);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public final void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(0, this.mView);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mFinalVisibility, this.mView);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionPause() {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionResume() {
            suppressLayout(true);
        }

        public final void suppressLayout(boolean z) {
            ViewGroup viewGroup;
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(viewGroup, z);
            }
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionCancel() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
        }
    }
}
