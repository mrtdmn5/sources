package androidx.work.impl.constraints.controllers;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTracker;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    public OnConstraintUpdatedCallback mCallback;
    public T mCurrentValue;
    public final ArrayList mMatchingWorkSpecIds = new ArrayList();
    public final ConstraintTracker<T> mTracker;

    /* loaded from: classes.dex */
    public interface OnConstraintUpdatedCallback {
    }

    public ConstraintController(ConstraintTracker<T> tracker) {
        this.mTracker = tracker;
    }

    public abstract boolean hasConstraint(WorkSpec workSpec);

    public abstract boolean isConstrained(T currentValue);

    @Override // androidx.work.impl.constraints.ConstraintListener
    public final void onConstraintChanged(T newValue) {
        this.mCurrentValue = newValue;
        updateCallback(this.mCallback, newValue);
    }

    public final void replace(Collection collection) {
        this.mMatchingWorkSpecIds.clear();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            WorkSpec workSpec = (WorkSpec) it.next();
            if (hasConstraint(workSpec)) {
                this.mMatchingWorkSpecIds.add(workSpec.id);
            }
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            ConstraintTracker<T> constraintTracker = this.mTracker;
            synchronized (constraintTracker.mLock) {
                if (constraintTracker.mListeners.remove(this) && constraintTracker.mListeners.isEmpty()) {
                    constraintTracker.stopTracking();
                }
            }
        } else {
            ConstraintTracker<T> constraintTracker2 = this.mTracker;
            synchronized (constraintTracker2.mLock) {
                if (constraintTracker2.mListeners.add(this)) {
                    if (constraintTracker2.mListeners.size() == 1) {
                        constraintTracker2.mCurrentState = constraintTracker2.getInitialState();
                        Logger.get().debug(ConstraintTracker.TAG, String.format("%s: initial state = %s", constraintTracker2.getClass().getSimpleName(), constraintTracker2.mCurrentState), new Throwable[0]);
                        constraintTracker2.startTracking();
                    }
                    onConstraintChanged(constraintTracker2.mCurrentState);
                }
            }
        }
        updateCallback(this.mCallback, this.mCurrentValue);
    }

    public final void updateCallback(OnConstraintUpdatedCallback callback, T currentValue) {
        if (!this.mMatchingWorkSpecIds.isEmpty() && callback != null) {
            if (currentValue != null && !isConstrained(currentValue)) {
                ArrayList arrayList = this.mMatchingWorkSpecIds;
                WorkConstraintsTracker workConstraintsTracker = (WorkConstraintsTracker) callback;
                synchronized (workConstraintsTracker.mLock) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (workConstraintsTracker.areAllConstraintsMet(str)) {
                            Logger.get().debug(WorkConstraintsTracker.TAG, String.format("Constraints met for %s", str), new Throwable[0]);
                            arrayList2.add(str);
                        }
                    }
                    WorkConstraintsCallback workConstraintsCallback = workConstraintsTracker.mCallback;
                    if (workConstraintsCallback != null) {
                        workConstraintsCallback.onAllConstraintsMet(arrayList2);
                    }
                }
                return;
            }
            ArrayList arrayList3 = this.mMatchingWorkSpecIds;
            WorkConstraintsTracker workConstraintsTracker2 = (WorkConstraintsTracker) callback;
            synchronized (workConstraintsTracker2.mLock) {
                WorkConstraintsCallback workConstraintsCallback2 = workConstraintsTracker2.mCallback;
                if (workConstraintsCallback2 != null) {
                    workConstraintsCallback2.onAllConstraintsNotMet(arrayList3);
                }
            }
        }
    }
}
