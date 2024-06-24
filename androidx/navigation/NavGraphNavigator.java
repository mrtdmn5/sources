package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;

@Navigator.Name("navigation")
/* loaded from: classes.dex */
public final class NavGraphNavigator extends Navigator<NavGraph> {
    public final NavigatorProvider mNavigatorProvider;

    public NavGraphNavigator(NavigatorProvider navigatorProvider) {
        this.mNavigatorProvider = navigatorProvider;
    }

    @Override // androidx.navigation.Navigator
    public final NavGraph createDestination() {
        return new NavGraph(this);
    }

    @Override // androidx.navigation.Navigator
    public final NavDestination navigate(NavDestination navDestination, Bundle bundle, NavOptions navOptions) {
        String str;
        NavGraph navGraph = (NavGraph) navDestination;
        int r0 = navGraph.mStartDestId;
        if (r0 == 0) {
            StringBuilder sb = new StringBuilder("no start destination defined via app:startDestination for ");
            int r02 = navGraph.mId;
            if (r02 != 0) {
                if (navGraph.mIdName == null) {
                    navGraph.mIdName = Integer.toString(r02);
                }
                str = navGraph.mIdName;
            } else {
                str = "the root navigation";
            }
            sb.append(str);
            throw new IllegalStateException(sb.toString());
        }
        NavDestination findNode = navGraph.findNode(r0, false);
        if (findNode == null) {
            if (navGraph.mStartDestIdName == null) {
                navGraph.mStartDestIdName = Integer.toString(navGraph.mStartDestId);
            }
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("navigation destination ", navGraph.mStartDestIdName, " is not a direct child of this NavGraph"));
        }
        return this.mNavigatorProvider.getNavigator(findNode.mNavigatorName).navigate(findNode, findNode.addInDefaultArgs(bundle), navOptions);
    }

    @Override // androidx.navigation.Navigator
    public final boolean popBackStack() {
        return true;
    }
}
