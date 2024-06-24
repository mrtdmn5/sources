package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    public static void bfsAddViewChildren(View view, List list) {
        boolean z;
        boolean z2;
        int size = list.size();
        int r2 = 0;
        while (true) {
            if (r2 < size) {
                if (list.get(r2) == view) {
                    z = true;
                    break;
                }
                r2++;
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            return;
        }
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api21Impl.getTransitionName(view) != null) {
            list.add(view);
        }
        for (int r9 = size; r9 < list.size(); r9++) {
            View view2 = (View) list.get(r9);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int r5 = 0; r5 < childCount; r5++) {
                    View childAt = viewGroup.getChildAt(r5);
                    int r7 = 0;
                    while (true) {
                        if (r7 < size) {
                            if (list.get(r7) == childAt) {
                                z2 = true;
                                break;
                            }
                            r7++;
                        } else {
                            z2 = false;
                            break;
                        }
                    }
                    if (!z2 && ViewCompat.Api21Impl.getTransitionName(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static void getBoundsOnScreen(View view, Rect rect) {
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (!ViewCompat.Api19Impl.isAttachedToWindow(view)) {
            return;
        }
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getMatrix().mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            view2.getMatrix().mapRect(rectF);
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
        view.getRootView().getLocationOnScreen(new int[2]);
        rectF.offset(r1[0], r1[1]);
        rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public static boolean isNullOrEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static ArrayList prepareSetNameOverridesReordered(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            View view = (View) arrayList.get(r2);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            arrayList2.add(ViewCompat.Api21Impl.getTransitionName(view));
            ViewCompat.Api21Impl.setTransitionName(view, null);
        }
        return arrayList2;
    }

    public static void setNameOverridesReordered(ViewGroup viewGroup, final ArrayList arrayList, final ArrayList arrayList2, final ArrayList arrayList3, ArrayMap arrayMap) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int r2 = 0; r2 < size; r2++) {
            View view = (View) arrayList.get(r2);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            String transitionName = ViewCompat.Api21Impl.getTransitionName(view);
            arrayList4.add(transitionName);
            if (transitionName != null) {
                ViewCompat.Api21Impl.setTransitionName(view, null);
                String str = (String) arrayMap.getOrDefault(transitionName, null);
                int r6 = 0;
                while (true) {
                    if (r6 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(r6))) {
                        ViewCompat.Api21Impl.setTransitionName((View) arrayList2.get(r6), transitionName);
                        break;
                    }
                    r6++;
                }
            }
        }
        OneShotPreDrawListener.add(viewGroup, new Runnable() { // from class: androidx.fragment.app.FragmentTransitionImpl.1
            @Override // java.lang.Runnable
            public final void run() {
                for (int r0 = 0; r0 < size; r0++) {
                    View view2 = (View) arrayList2.get(r0);
                    String str2 = (String) arrayList3.get(r0);
                    WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap2 = ViewCompat.sViewPropertyAnimatorMap;
                    ViewCompat.Api21Impl.setTransitionName(view2, str2);
                    ViewCompat.Api21Impl.setTransitionName((View) arrayList.get(r0), (String) arrayList4.get(r0));
                }
            }
        });
    }

    public abstract void addTarget(View view, Object obj);

    public abstract void addTargets(Object obj, ArrayList<View> arrayList);

    public abstract void beginDelayedTransition(ViewGroup viewGroup, Object obj);

    public abstract boolean canHandle(Object obj);

    public abstract Object cloneTransition(Object obj);

    public abstract Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3);

    public abstract Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3);

    public abstract void scheduleHideFragmentView(Object obj, View view, ArrayList<View> arrayList);

    public abstract void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void setEpicenter(View view, Object obj);

    public abstract void setEpicenter(Object obj, Rect rect);

    public void setListenerForTransitionEnd(Object obj, CancellationSignal cancellationSignal, Runnable runnable) {
        runnable.run();
    }

    public abstract void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList);

    public abstract void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object wrapTransitionInSet(Object obj);
}
