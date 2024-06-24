package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResultRegistry$$ExternalSyntheticOutline0;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.NavBackStackEntry;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class NavController {
    public final Activity mActivity;
    public Parcelable[] mBackStackToRestore;
    public final Context mContext;
    public boolean mDeepLinkHandled;
    public NavGraph mGraph;
    public NavInflater mInflater;
    public LifecycleOwner mLifecycleOwner;
    public Bundle mNavigatorStateToRestore;
    public NavControllerViewModel mViewModel;
    public final ArrayDeque mBackStack = new ArrayDeque();
    public final NavigatorProvider mNavigatorProvider = new NavigatorProvider();
    public final CopyOnWriteArrayList<OnDestinationChangedListener> mOnDestinationChangedListeners = new CopyOnWriteArrayList<>();
    public final LifecycleObserver mLifecycleObserver = new LifecycleEventObserver() { // from class: androidx.navigation.NavController.1
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State state;
            NavController navController = NavController.this;
            if (navController.mGraph != null) {
                Iterator it = navController.mBackStack.iterator();
                while (it.hasNext()) {
                    NavBackStackEntry navBackStackEntry = (NavBackStackEntry) it.next();
                    navBackStackEntry.getClass();
                    switch (NavBackStackEntry.AnonymousClass1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()]) {
                        case 1:
                        case 2:
                            state = Lifecycle.State.CREATED;
                            break;
                        case 3:
                        case 4:
                            state = Lifecycle.State.STARTED;
                            break;
                        case 5:
                            state = Lifecycle.State.RESUMED;
                            break;
                        case 6:
                            state = Lifecycle.State.DESTROYED;
                            break;
                        default:
                            throw new IllegalArgumentException("Unexpected event value " + event);
                    }
                    navBackStackEntry.mHostLifecycle = state;
                    navBackStackEntry.updateState();
                }
            }
        }
    };
    public final AnonymousClass2 mOnBackPressedCallback = new OnBackPressedCallback() { // from class: androidx.navigation.NavController.2
        @Override // androidx.activity.OnBackPressedCallback
        public final void handleOnBackPressed() {
            NavController.this.popBackStack();
        }
    };
    public boolean mEnableOnBackPressedCallback = true;

    /* loaded from: classes.dex */
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.navigation.NavController$2] */
    public NavController(Context context) {
        this.mContext = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof Activity) {
                this.mActivity = (Activity) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        NavigatorProvider navigatorProvider = this.mNavigatorProvider;
        navigatorProvider.addNavigator(new NavGraphNavigator(navigatorProvider));
        this.mNavigatorProvider.addNavigator(new ActivityNavigator(this.mContext));
    }

    public final boolean dispatchOnDestinationChanged() {
        ArrayDeque arrayDeque;
        NavDestination navDestination;
        do {
            arrayDeque = this.mBackStack;
            if (arrayDeque.isEmpty() || !(((NavBackStackEntry) arrayDeque.peekLast()).mDestination instanceof NavGraph)) {
                break;
            }
        } while (popBackStackInternal(((NavBackStackEntry) arrayDeque.peekLast()).mDestination.mId, true));
        if (!arrayDeque.isEmpty()) {
            NavDestination navDestination2 = ((NavBackStackEntry) arrayDeque.peekLast()).mDestination;
            if (navDestination2 instanceof FloatingWindow) {
                Iterator descendingIterator = arrayDeque.descendingIterator();
                while (descendingIterator.hasNext()) {
                    navDestination = ((NavBackStackEntry) descendingIterator.next()).mDestination;
                    if (!(navDestination instanceof NavGraph) && !(navDestination instanceof FloatingWindow)) {
                        break;
                    }
                }
            }
            navDestination = null;
            HashMap hashMap = new HashMap();
            Iterator descendingIterator2 = arrayDeque.descendingIterator();
            while (descendingIterator2.hasNext()) {
                NavBackStackEntry navBackStackEntry = (NavBackStackEntry) descendingIterator2.next();
                Lifecycle.State state = navBackStackEntry.mMaxLifecycle;
                NavDestination navDestination3 = navBackStackEntry.mDestination;
                if (navDestination2 != null && navDestination3.mId == navDestination2.mId) {
                    Lifecycle.State state2 = Lifecycle.State.RESUMED;
                    if (state != state2) {
                        hashMap.put(navBackStackEntry, state2);
                    }
                    navDestination2 = navDestination2.mParent;
                } else if (navDestination != null && navDestination3.mId == navDestination.mId) {
                    if (state == Lifecycle.State.RESUMED) {
                        navBackStackEntry.mMaxLifecycle = Lifecycle.State.STARTED;
                        navBackStackEntry.updateState();
                    } else {
                        Lifecycle.State state3 = Lifecycle.State.STARTED;
                        if (state != state3) {
                            hashMap.put(navBackStackEntry, state3);
                        }
                    }
                    navDestination = navDestination.mParent;
                } else {
                    navBackStackEntry.mMaxLifecycle = Lifecycle.State.CREATED;
                    navBackStackEntry.updateState();
                }
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) it.next();
                Lifecycle.State state4 = (Lifecycle.State) hashMap.get(navBackStackEntry2);
                if (state4 != null) {
                    navBackStackEntry2.mMaxLifecycle = state4;
                    navBackStackEntry2.updateState();
                } else {
                    navBackStackEntry2.updateState();
                }
            }
            NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) arrayDeque.peekLast();
            Iterator<OnDestinationChangedListener> it2 = this.mOnDestinationChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().onDestinationChanged(this, navBackStackEntry3.mDestination, navBackStackEntry3.mArgs);
            }
            return true;
        }
        return false;
    }

    public final NavDestination findDestination(int r3) {
        NavDestination navDestination;
        NavGraph navGraph;
        NavGraph navGraph2 = this.mGraph;
        if (navGraph2 == null) {
            return null;
        }
        if (navGraph2.mId == r3) {
            return navGraph2;
        }
        ArrayDeque arrayDeque = this.mBackStack;
        if (arrayDeque.isEmpty()) {
            navDestination = this.mGraph;
        } else {
            navDestination = ((NavBackStackEntry) arrayDeque.getLast()).mDestination;
        }
        if (navDestination instanceof NavGraph) {
            navGraph = (NavGraph) navDestination;
        } else {
            navGraph = navDestination.mParent;
        }
        return navGraph.findNode(r3, true);
    }

    public final NavDestination getCurrentDestination() {
        NavBackStackEntry navBackStackEntry;
        ArrayDeque arrayDeque = this.mBackStack;
        if (arrayDeque.isEmpty()) {
            navBackStackEntry = null;
        } else {
            navBackStackEntry = (NavBackStackEntry) arrayDeque.getLast();
        }
        if (navBackStackEntry == null) {
            return null;
        }
        return navBackStackEntry.mDestination;
    }

    public final int getDestinationCountOnBackStack() {
        Iterator it = this.mBackStack.iterator();
        int r1 = 0;
        while (it.hasNext()) {
            if (!(((NavBackStackEntry) it.next()).mDestination instanceof NavGraph)) {
                r1++;
            }
        }
        return r1;
    }

    public final void navigate(int r9) {
        NavDestination navDestination;
        int r5;
        Bundle bundle;
        int r6;
        ArrayDeque arrayDeque = this.mBackStack;
        if (arrayDeque.isEmpty()) {
            navDestination = this.mGraph;
        } else {
            navDestination = ((NavBackStackEntry) arrayDeque.getLast()).mDestination;
        }
        if (navDestination != null) {
            NavAction action = navDestination.getAction(r9);
            NavOptions navOptions = null;
            Bundle bundle2 = null;
            if (action != null) {
                NavOptions navOptions2 = action.mNavOptions;
                Bundle bundle3 = action.mDefaultArguments;
                r5 = action.mDestinationId;
                if (bundle3 != null) {
                    bundle2 = new Bundle();
                    bundle2.putAll(bundle3);
                }
                bundle = bundle2;
                navOptions = navOptions2;
            } else {
                r5 = r9;
                bundle = null;
            }
            if (r5 == 0 && navOptions != null && (r6 = navOptions.mPopUpTo) != -1) {
                if (popBackStackInternal(r6, navOptions.mPopUpToInclusive)) {
                    dispatchOnDestinationChanged();
                    return;
                }
                return;
            }
            if (r5 != 0) {
                NavDestination findDestination = findDestination(r5);
                if (findDestination == null) {
                    Context context = this.mContext;
                    String displayName = NavDestination.getDisplayName(context, r5);
                    if (action != null) {
                        StringBuilder m = ActivityResultRegistry$$ExternalSyntheticOutline0.m("Navigation destination ", displayName, " referenced from action ");
                        m.append(NavDestination.getDisplayName(context, r9));
                        m.append(" cannot be found from the current destination ");
                        m.append(navDestination);
                        throw new IllegalArgumentException(m.toString());
                    }
                    throw new IllegalArgumentException("Navigation action/destination " + displayName + " cannot be found from the current destination " + navDestination);
                }
                navigate(findDestination, bundle, navOptions);
                return;
            }
            throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo");
        }
        throw new IllegalStateException("no current navigation node");
    }

    public final boolean popBackStack() {
        if (this.mBackStack.isEmpty() || !popBackStackInternal(getCurrentDestination().mId, true) || !dispatchOnDestinationChanged()) {
            return false;
        }
        return true;
    }

    public final boolean popBackStackInternal(int r9, boolean z) {
        boolean z2;
        ViewModelStore remove;
        ArrayDeque arrayDeque = this.mBackStack;
        boolean z3 = false;
        if (arrayDeque.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator descendingIterator = arrayDeque.descendingIterator();
        while (true) {
            if (descendingIterator.hasNext()) {
                NavDestination navDestination = ((NavBackStackEntry) descendingIterator.next()).mDestination;
                Navigator navigator = this.mNavigatorProvider.getNavigator(navDestination.mNavigatorName);
                if (z || navDestination.mId != r9) {
                    arrayList.add(navigator);
                }
                if (navDestination.mId == r9) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            Log.i("NavController", "Ignoring popBackStack to destination " + NavDestination.getDisplayName(this.mContext, r9) + " as it was not found on the current back stack");
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((Navigator) it.next()).popBackStack()) {
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) arrayDeque.removeLast();
            if (navBackStackEntry.mLifecycle.state.isAtLeast(Lifecycle.State.CREATED)) {
                navBackStackEntry.mMaxLifecycle = Lifecycle.State.DESTROYED;
                navBackStackEntry.updateState();
            }
            NavControllerViewModel navControllerViewModel = this.mViewModel;
            if (navControllerViewModel != null && (remove = navControllerViewModel.mViewModelStores.remove(navBackStackEntry.mId)) != null) {
                remove.clear();
            }
            z3 = true;
        }
        updateOnBackPressedCallbackEnabled();
        return z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0280  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void setGraph(int r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instructions count: 658
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.setGraph(int, android.os.Bundle):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:            if (getDestinationCountOnBackStack() > 1) goto L8;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateOnBackPressedCallbackEnabled() {
        /*
            r2 = this;
            boolean r0 = r2.mEnableOnBackPressedCallback
            if (r0 == 0) goto Lc
            int r0 = r2.getDestinationCountOnBackStack()
            r1 = 1
            if (r0 <= r1) goto Lc
            goto Ld
        Lc:
            r1 = 0
        Ld:
            androidx.navigation.NavController$2 r0 = r2.mOnBackPressedCallback
            r0.isEnabled = r1
            kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r0.enabledChangedCallback
            if (r0 == 0) goto L18
            r0.invoke()
        L18:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.updateOnBackPressedCallbackEnabled():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:            if (r3.isEmpty() != false) goto L75;     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:            if ((((androidx.navigation.NavBackStackEntry) r3.peekLast()).mDestination instanceof androidx.navigation.FloatingWindow) == false) goto L74;     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:            if (popBackStackInternal(((androidx.navigation.NavBackStackEntry) r3.peekLast()).mDestination.mId, true) == false) goto L73;     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:            r12 = new java.util.ArrayDeque();     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:            if ((r10 instanceof androidx.navigation.NavGraph) == false) goto L31;     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:            r5 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:            r5 = r5.mParent;     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0058, code lost:            if (r5 == null) goto L29;     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:            r12.addFirst(new androidx.navigation.NavBackStackEntry(r5, r11, r9.mLifecycleOwner, r9.mViewModel));     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:            if (r3.isEmpty() != false) goto L29;     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:            if (((androidx.navigation.NavBackStackEntry) r3.getLast()).mDestination != r5) goto L29;     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:            popBackStackInternal(r5.mId, true);     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:            if (r5 == null) goto L77;     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:            if (r5 != r10) goto L79;     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0083, code lost:            if (r12.isEmpty() == false) goto L34;     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0085, code lost:            r10 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008f, code lost:            if (r10 == null) goto L82;     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0097, code lost:            if (findDestination(r10.mId) != null) goto L80;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0099, code lost:            r10 = r10.mParent;     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009b, code lost:            if (r10 == null) goto L84;     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009d, code lost:            r12.addFirst(new androidx.navigation.NavBackStackEntry(r10, r11, r9.mLifecycleOwner, r9.mViewModel));     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ae, code lost:            if (r12.isEmpty() == false) goto L44;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b0, code lost:            r10 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00be, code lost:            if (r3.isEmpty() != false) goto L90;     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ca, code lost:            if ((((androidx.navigation.NavBackStackEntry) r3.getLast()).mDestination instanceof androidx.navigation.NavGraph) == false) goto L87;     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:            if (((androidx.navigation.NavGraph) ((androidx.navigation.NavBackStackEntry) r3.getLast()).mDestination).findNode(r10.mId, false) != null) goto L89;     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ec, code lost:            if (popBackStackInternal(((androidx.navigation.NavBackStackEntry) r3.getLast()).mDestination.mId, true) == false) goto L88;     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ef, code lost:            r3.addAll(r12);     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f6, code lost:            if (r3.isEmpty() != false) goto L58;     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0102, code lost:            if (((androidx.navigation.NavBackStackEntry) r3.getFirst()).mDestination == r9.mGraph) goto L59;     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0112, code lost:            r3.add(new androidx.navigation.NavBackStackEntry(r2, r2.addInDefaultArgs(r11), r9.mLifecycleOwner, r9.mViewModel));     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0104, code lost:            r3.addFirst(new androidx.navigation.NavBackStackEntry(r9.mGraph, r11, r9.mLifecycleOwner, r9.mViewModel));     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00b2, code lost:            r10 = ((androidx.navigation.NavBackStackEntry) r12.getLast()).mDestination;     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0087, code lost:            r10 = ((androidx.navigation.NavBackStackEntry) r12.getFirst()).mDestination;     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:            if ((r2 instanceof androidx.navigation.FloatingWindow) == false) goto L12;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void navigate(androidx.navigation.NavDestination r10, android.os.Bundle r11, androidx.navigation.NavOptions r12) {
        /*
            Method dump skipped, instructions count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.navigate(androidx.navigation.NavDestination, android.os.Bundle, androidx.navigation.NavOptions):void");
    }
}
