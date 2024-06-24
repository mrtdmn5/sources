package androidx.navigation;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.collection.SparseArrayCompat;
import androidx.navigation.NavDestination;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class NavGraph extends NavDestination implements Iterable<NavDestination> {
    public final SparseArrayCompat<NavDestination> mNodes;
    public int mStartDestId;
    public String mStartDestIdName;

    /* renamed from: androidx.navigation.NavGraph$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Iterator<NavDestination> {
        public int mIndex = -1;
        public boolean mWentToNext = false;

        public AnonymousClass1() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.mIndex + 1 < NavGraph.this.mNodes.size()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final NavDestination next() {
            if (hasNext()) {
                this.mWentToNext = true;
                SparseArrayCompat<NavDestination> sparseArrayCompat = NavGraph.this.mNodes;
                int r2 = this.mIndex + 1;
                this.mIndex = r2;
                return sparseArrayCompat.valueAt(r2);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.mWentToNext) {
                NavGraph navGraph = NavGraph.this;
                navGraph.mNodes.valueAt(this.mIndex).mParent = null;
                SparseArrayCompat<NavDestination> sparseArrayCompat = navGraph.mNodes;
                int r1 = this.mIndex;
                Object[] objArr = sparseArrayCompat.mValues;
                Object obj = objArr[r1];
                Object obj2 = SparseArrayCompat.DELETED;
                if (obj != obj2) {
                    objArr[r1] = obj2;
                    sparseArrayCompat.mGarbage = true;
                }
                this.mIndex = r1 - 1;
                this.mWentToNext = false;
                return;
            }
            throw new IllegalStateException("You must call next() before you can remove an element");
        }
    }

    public NavGraph(Navigator<? extends NavGraph> navigator) {
        super(navigator);
        this.mNodes = new SparseArrayCompat<>();
    }

    public final void addDestination(NavDestination navDestination) {
        int r0 = navDestination.mId;
        if (r0 != 0) {
            if (r0 != this.mId) {
                SparseArrayCompat<NavDestination> sparseArrayCompat = this.mNodes;
                NavDestination navDestination2 = (NavDestination) sparseArrayCompat.get(r0, null);
                if (navDestination2 == navDestination) {
                    return;
                }
                if (navDestination.mParent == null) {
                    if (navDestination2 != null) {
                        navDestination2.mParent = null;
                    }
                    navDestination.mParent = this;
                    sparseArrayCompat.put(navDestination.mId, navDestination);
                    return;
                }
                throw new IllegalStateException("Destination already has a parent set. Call NavGraph.remove() to remove the previous parent.");
            }
            throw new IllegalArgumentException("Destination " + navDestination + " cannot have the same id as graph " + this);
        }
        throw new IllegalArgumentException("Destinations must have an id. Call setId() or include an android:id in your navigation XML.");
    }

    public final NavDestination findNode(int r3, boolean z) {
        NavGraph navGraph;
        NavDestination navDestination = (NavDestination) this.mNodes.get(r3, null);
        if (navDestination != null) {
            return navDestination;
        }
        if (!z || (navGraph = this.mParent) == null) {
            return null;
        }
        return navGraph.findNode(r3, true);
    }

    @Override // java.lang.Iterable
    public final Iterator<NavDestination> iterator() {
        return new AnonymousClass1();
    }

    @Override // androidx.navigation.NavDestination
    public final NavDestination.DeepLinkMatch matchDeepLink(NavDeepLinkRequest navDeepLinkRequest) {
        NavDestination.DeepLinkMatch matchDeepLink = super.matchDeepLink(navDeepLinkRequest);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        while (anonymousClass1.hasNext()) {
            NavDestination.DeepLinkMatch matchDeepLink2 = ((NavDestination) anonymousClass1.next()).matchDeepLink(navDeepLinkRequest);
            if (matchDeepLink2 != null && (matchDeepLink == null || matchDeepLink2.compareTo(matchDeepLink) > 0)) {
                matchDeepLink = matchDeepLink2;
            }
        }
        return matchDeepLink;
    }

    @Override // androidx.navigation.NavDestination
    public final void onInflate(Context context, AttributeSet attributeSet) {
        super.onInflate(context, attributeSet);
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavGraphNavigator);
        int resourceId = obtainAttributes.getResourceId(0, 0);
        if (resourceId != this.mId) {
            this.mStartDestId = resourceId;
            this.mStartDestIdName = null;
            this.mStartDestIdName = NavDestination.getDisplayName(context, resourceId);
            obtainAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("Start destination " + resourceId + " cannot use the same id as the graph " + this);
    }

    @Override // androidx.navigation.NavDestination
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" startDestination=");
        NavDestination findNode = findNode(this.mStartDestId, true);
        if (findNode == null) {
            String str = this.mStartDestIdName;
            if (str == null) {
                sb.append("0x");
                sb.append(Integer.toHexString(this.mStartDestId));
            } else {
                sb.append(str);
            }
        } else {
            sb.append("{");
            sb.append(findNode.toString());
            sb.append("}");
        }
        return sb.toString();
    }
}
