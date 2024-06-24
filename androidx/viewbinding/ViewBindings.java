package androidx.viewbinding;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class ViewBindings {
    public static View findChildViewById(int r4, View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int r2 = 0; r2 < childCount; r2++) {
            View findViewById = viewGroup.getChildAt(r2).findViewById(r4);
            if (findViewById != null) {
                return findViewById;
            }
        }
        return null;
    }
}
