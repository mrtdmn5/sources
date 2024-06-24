package androidx.navigation;

import android.view.View;
import com.kronaby.watch.app.R;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class Navigation {
    public static NavController findNavController(View view) {
        NavController findViewNavController = findViewNavController(view);
        if (findViewNavController != null) {
            return findViewNavController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static NavController findViewNavController(View view) {
        NavController navController;
        while (view != null) {
            Object tag = view.getTag(R.id.nav_controller_view_tag);
            if (tag instanceof WeakReference) {
                navController = (NavController) ((WeakReference) tag).get();
            } else if (tag instanceof NavController) {
                navController = (NavController) tag;
            } else {
                navController = null;
            }
            if (navController != null) {
                return navController;
            }
            Object parent = view.getParent();
            if (parent instanceof View) {
                view = (View) parent;
            } else {
                view = null;
            }
        }
        return null;
    }
}
