package androidx.transition;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TransitionSet extends Transition {
    public int mCurrentListeners;
    public ArrayList<Transition> mTransitions = new ArrayList<>();
    public boolean mPlayTogether = true;
    public boolean mStarted = false;
    public int mChangeFlags = 0;

    /* renamed from: androidx.transition.TransitionSet$1 */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends TransitionListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            Transition.this.runAnimators();
            transition.removeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public static class TransitionSetListener extends TransitionListenerAdapter {
        public final TransitionSet mTransitionSet;

        public TransitionSetListener(TransitionSet transitionSet) {
            this.mTransitionSet = transitionSet;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public final void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            int r1 = transitionSet.mCurrentListeners - 1;
            transitionSet.mCurrentListeners = r1;
            if (r1 == 0) {
                transitionSet.mStarted = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public final void onTransitionStart(Transition transition) {
            TransitionSet transitionSet = this.mTransitionSet;
            if (!transitionSet.mStarted) {
                transitionSet.start();
                transitionSet.mStarted = true;
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void addListener(Transition.TransitionListener transitionListener) {
        super.addListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public final void addTarget(View view) {
        for (int r0 = 0; r0 < this.mTransitions.size(); r0++) {
            this.mTransitions.get(r0).addTarget(view);
        }
        this.mTargets.add(view);
    }

    public final void addTransition(Transition transition) {
        this.mTransitions.add(transition);
        transition.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.mChangeFlags & 1) != 0) {
            transition.setInterpolator(this.mInterpolator);
        }
        if ((this.mChangeFlags & 2) != 0) {
            transition.setPropagation();
        }
        if ((this.mChangeFlags & 4) != 0) {
            transition.setPathMotion(this.mPathMotion);
        }
        if ((this.mChangeFlags & 8) != 0) {
            transition.setEpicenterCallback(this.mEpicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public final void cancel() {
        super.cancel();
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public final void captureEndValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(view)) {
                    next.captureEndValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void capturePropagationValues(TransitionValues transitionValues) {
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).capturePropagationValues(transitionValues);
        }
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (isValidTarget(view)) {
            Iterator<Transition> it = this.mTransitions.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(view)) {
                    next.captureStartValues(transitionValues);
                    transitionValues.mTargetedTransitions.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        long j = this.mStartDelay;
        int size = this.mTransitions.size();
        for (int r4 = 0; r4 < size; r4++) {
            Transition transition = this.mTransitions.get(r4);
            if (j > 0 && (this.mPlayTogether || r4 == 0)) {
                long j2 = transition.mStartDelay;
                if (j2 > 0) {
                    transition.setStartDelay(j2 + j);
                } else {
                    transition.setStartDelay(j);
                }
            }
            transition.createAnimators(viewGroup, transitionValuesMaps, transitionValuesMaps2, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    public final void pause(View view) {
        super.pause(view);
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public final void removeListener(Transition.TransitionListener transitionListener) {
        super.removeListener(transitionListener);
    }

    @Override // androidx.transition.Transition
    public final void removeTarget(View view) {
        for (int r0 = 0; r0 < this.mTransitions.size(); r0++) {
            this.mTransitions.get(r0).removeTarget(view);
        }
        this.mTargets.remove(view);
    }

    @Override // androidx.transition.Transition
    public final void resume(ViewGroup viewGroup) {
        super.resume(viewGroup);
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).resume(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    public final void runAnimators() {
        if (this.mTransitions.isEmpty()) {
            start();
            end();
            return;
        }
        TransitionSetListener transitionSetListener = new TransitionSetListener(this);
        Iterator<Transition> it = this.mTransitions.iterator();
        while (it.hasNext()) {
            it.next().addListener(transitionSetListener);
        }
        this.mCurrentListeners = this.mTransitions.size();
        if (!this.mPlayTogether) {
            for (int r0 = 1; r0 < this.mTransitions.size(); r0++) {
                this.mTransitions.get(r0 - 1).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.TransitionSet.1
                    public AnonymousClass1() {
                    }

                    @Override // androidx.transition.Transition.TransitionListener
                    public final void onTransitionEnd(Transition transition) {
                        Transition.this.runAnimators();
                        transition.removeListener(this);
                    }
                });
            }
            Transition transition = this.mTransitions.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.mTransitions.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public final void setDuration(long j) {
        ArrayList<Transition> arrayList;
        this.mDuration = j;
        if (j >= 0 && (arrayList = this.mTransitions) != null) {
            int size = arrayList.size();
            for (int r1 = 0; r1 < size; r1++) {
                this.mTransitions.get(r1).setDuration(j);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void setEpicenterCallback(Transition.EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
        this.mChangeFlags |= 8;
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).setEpicenterCallback(epicenterCallback);
        }
    }

    @Override // androidx.transition.Transition
    public final void setInterpolator(TimeInterpolator timeInterpolator) {
        this.mChangeFlags |= 1;
        ArrayList<Transition> arrayList = this.mTransitions;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int r1 = 0; r1 < size; r1++) {
                this.mTransitions.get(r1).setInterpolator(timeInterpolator);
            }
        }
        this.mInterpolator = timeInterpolator;
    }

    @Override // androidx.transition.Transition
    public final void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.mChangeFlags |= 4;
        if (this.mTransitions != null) {
            for (int r0 = 0; r0 < this.mTransitions.size(); r0++) {
                this.mTransitions.get(r0).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public final void setPropagation() {
        this.mChangeFlags |= 2;
        int size = this.mTransitions.size();
        for (int r1 = 0; r1 < size; r1++) {
            this.mTransitions.get(r1).setPropagation();
        }
    }

    @Override // androidx.transition.Transition
    public final void setStartDelay(long j) {
        this.mStartDelay = j;
    }

    @Override // androidx.transition.Transition
    public final String toString(String str) {
        String transition = super.toString(str);
        for (int r1 = 0; r1 < this.mTransitions.size(); r1++) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(transition, "\n");
            m.append(this.mTransitions.get(r1).toString(str + "  "));
            transition = m.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public final Transition mo613clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo613clone();
        transitionSet.mTransitions = new ArrayList<>();
        int size = this.mTransitions.size();
        for (int r2 = 0; r2 < size; r2++) {
            Transition mo613clone = this.mTransitions.get(r2).mo613clone();
            transitionSet.mTransitions.add(mo613clone);
            mo613clone.mParent = transitionSet;
        }
        return transitionSet;
    }
}
