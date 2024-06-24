package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public class FragmentTransitionSupport extends FragmentTransitionImpl {

    /* renamed from: androidx.transition.FragmentTransitionSupport$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 extends Transition.EpicenterCallback {
    }

    /* renamed from: androidx.transition.FragmentTransitionSupport$6, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass6 extends Transition.EpicenterCallback {
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void addTarget(View view, Object obj) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void addTargets(Object obj, ArrayList<View> arrayList) {
        boolean z;
        Transition transition;
        Transition transition2 = (Transition) obj;
        if (transition2 == null) {
            return;
        }
        int r2 = 0;
        if (transition2 instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition2;
            int size = transitionSet.mTransitions.size();
            while (r2 < size) {
                if (r2 >= 0 && r2 < transitionSet.mTransitions.size()) {
                    transition = transitionSet.mTransitions.get(r2);
                } else {
                    transition = null;
                }
                addTargets(transition, arrayList);
                r2++;
            }
            return;
        }
        if (FragmentTransitionImpl.isNullOrEmpty(transition2.mTargetIds) && FragmentTransitionImpl.isNullOrEmpty(null) && FragmentTransitionImpl.isNullOrEmpty(null)) {
            z = false;
        } else {
            z = true;
        }
        if (!z && FragmentTransitionImpl.isNullOrEmpty(transition2.mTargets)) {
            int size2 = arrayList.size();
            while (r2 < size2) {
                transition2.addTarget(arrayList.get(r2));
                r2++;
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).mo613clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.addTransition(transition);
            transitionSet.addTransition(transition2);
            transitionSet.mPlayTogether = false;
            transition = transitionSet;
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.addTransition(transition);
            }
            transitionSet2.addTransition(transition3);
            return transitionSet2;
        }
        return transition;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public final void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        boolean z;
        int size;
        Transition transition;
        Transition transition2 = (Transition) obj;
        int r2 = 0;
        if (transition2 instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition2;
            int size2 = transitionSet.mTransitions.size();
            while (r2 < size2) {
                if (r2 >= 0 && r2 < transitionSet.mTransitions.size()) {
                    transition = transitionSet.mTransitions.get(r2);
                } else {
                    transition = null;
                }
                replaceTargets(transition, arrayList, arrayList2);
                r2++;
            }
            return;
        }
        if (FragmentTransitionImpl.isNullOrEmpty(transition2.mTargetIds) && FragmentTransitionImpl.isNullOrEmpty(null) && FragmentTransitionImpl.isNullOrEmpty(null)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            ArrayList<View> arrayList3 = transition2.mTargets;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (r2 < size) {
                    transition2.addTarget(arrayList2.get(r2));
                    r2++;
                }
                int size3 = arrayList.size();
                while (true) {
                    size3--;
                    if (size3 >= 0) {
                        transition2.removeTarget(arrayList.get(size3));
                    } else {
                        return;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void scheduleHideFragmentView(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.2
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                for (int r2 = 0; r2 < size; r2++) {
                    ((View) arrayList2.get(r2)).setVisibility(0);
                }
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionCancel() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionPause() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionResume() {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void scheduleRemoveTargets(Object obj, final Object obj2, final ArrayList<View> arrayList, final Object obj3, final ArrayList<View> arrayList2, final Object obj4, final ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new TransitionListenerAdapter() { // from class: androidx.transition.FragmentTransitionSupport.3
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                transition.removeListener(this);
            }

            @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition) {
                FragmentTransitionSupport fragmentTransitionSupport = FragmentTransitionSupport.this;
                Object obj5 = obj2;
                if (obj5 != null) {
                    fragmentTransitionSupport.replaceTargets(obj5, arrayList, null);
                }
                Object obj6 = obj3;
                if (obj6 != null) {
                    fragmentTransitionSupport.replaceTargets(obj6, arrayList2, null);
                }
                Object obj7 = obj4;
                if (obj7 != null) {
                    fragmentTransitionSupport.replaceTargets(obj7, arrayList3, null);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setEpicenter(View view, Object obj) {
        if (view != null) {
            FragmentTransitionImpl.getBoundsOnScreen(view, new Rect());
            ((Transition) obj).setEpicenterCallback(new AnonymousClass1());
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setListenerForTransitionEnd(Object obj, CancellationSignal cancellationSignal, final Runnable runnable) {
        final Transition transition = (Transition) obj;
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.transition.FragmentTransitionSupport.4
            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public final void onCancel() {
                Transition.this.cancel();
            }
        });
        transition.addListener(new Transition.TransitionListener() { // from class: androidx.transition.FragmentTransitionSupport.5
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition2) {
                runnable.run();
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionCancel() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionPause() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionResume() {
            }

            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionStart(Transition transition2) {
            }
        });
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        ArrayList<View> arrayList2 = transitionSet.mTargets;
        arrayList2.clear();
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            FragmentTransitionImpl.bfsAddViewChildren(arrayList.get(r2), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            ArrayList<View> arrayList3 = transitionSet.mTargets;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    @Override // androidx.fragment.app.FragmentTransitionImpl
    public final void setEpicenter(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new AnonymousClass6());
        }
    }
}
