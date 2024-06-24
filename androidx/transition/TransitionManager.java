package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class TransitionManager {
    public static final AutoTransition sDefaultTransition = new AutoTransition();
    public static final ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();
    public static final ArrayList<ViewGroup> sPendingTransitions = new ArrayList<>();

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        ArrayList<ViewGroup> arrayList = sPendingTransitions;
        if (!arrayList.contains(viewGroup)) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            if (ViewCompat.Api19Impl.isLaidOut(viewGroup)) {
                arrayList.add(viewGroup);
                if (transition == null) {
                    transition = sDefaultTransition;
                }
                Transition mo613clone = transition.mo613clone();
                ArrayList<Transition> orDefault = getRunningTransitions().getOrDefault(viewGroup, null);
                if (orDefault != null && orDefault.size() > 0) {
                    Iterator<Transition> it = orDefault.iterator();
                    while (it.hasNext()) {
                        it.next().pause(viewGroup);
                    }
                }
                if (mo613clone != null) {
                    mo613clone.captureValues(viewGroup, true);
                }
                if (((Scene) viewGroup.getTag(R.id.transition_current_scene)) == null) {
                    viewGroup.setTag(R.id.transition_current_scene, null);
                    if (mo613clone != null) {
                        MultiListener multiListener = new MultiListener(viewGroup, mo613clone);
                        viewGroup.addOnAttachStateChangeListener(multiListener);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
                        return;
                    }
                    return;
                }
                throw null;
            }
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> threadLocal = sRunningTransitions;
        WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>> weakReference = threadLocal.get();
        if (weakReference != null && (arrayMap = weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        threadLocal.set(new WeakReference<>(arrayMap2));
        return arrayMap2;
    }

    /* loaded from: classes.dex */
    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public final ViewGroup mSceneRoot;
        public final Transition mTransition;

        public MultiListener(ViewGroup viewGroup, Transition transition) {
            this.mTransition = transition;
            this.mSceneRoot = viewGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:125:0x01d7 A[EDGE_INSN: B:125:0x01d7->B:126:0x01d7 BREAK  A[LOOP:1: B:17:0x0083->B:29:0x01ce], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:129:0x01de  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:148:0x022b  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0088  */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onPreDraw() {
            /*
                Method dump skipped, instructions count: 687
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionManager.MultiListener.onPreDraw():boolean");
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup = this.mSceneRoot;
            viewGroup.getViewTreeObserver().removeOnPreDrawListener(this);
            viewGroup.removeOnAttachStateChangeListener(this);
            TransitionManager.sPendingTransitions.remove(viewGroup);
            ArrayList<Transition> orDefault = TransitionManager.getRunningTransitions().getOrDefault(viewGroup, null);
            if (orDefault != null && orDefault.size() > 0) {
                Iterator<Transition> it = orDefault.iterator();
                while (it.hasNext()) {
                    it.next().resume(viewGroup);
                }
            }
            this.mTransition.clearValues(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }
    }
}
