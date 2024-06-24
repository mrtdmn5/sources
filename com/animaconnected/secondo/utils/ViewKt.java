package com.animaconnected.secondo.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: View.kt */
/* loaded from: classes3.dex */
public final class ViewKt {
    public static final void below(View view, View view2) {
        RelativeLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(view2, "view");
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.addRule(3, view2.getId());
        }
    }

    public static final void doAfterLayout(final View view, final Function0<Unit> f) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(f, "f");
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.animaconnected.secondo.utils.ViewKt$doAfterLayout$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                f.invoke();
            }
        });
    }

    public static final String getLoremIpsumText() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas ac ornare lacus, nec lacinia enim. Nam leo sapien, consequat non mi ac, ultrices tristique urna. Integer tincidunt nunc sem, vel ultricies tellus suscipit sit amet. Cras vel pretium augue. Nullam id tellus nisi. Mauris sem nisi, finibus non mi tincidunt, aliquet condimentum nisl. Morbi accumsan elit quis sapien accumsan ullamcorper. Quisque sem velit, posuere vitae ex non, tincidunt sollicitudin ante.";
    }

    public static final Rect getViewRectBounds(View view, ViewGroup parentViewGroup, int r3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(parentViewGroup, "parentViewGroup");
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        parentViewGroup.offsetDescendantRectToMyCoords(view, rect);
        if (r3 > 0) {
            rect.left += r3;
            rect.top += r3;
            rect.right -= r3;
            rect.bottom -= r3;
        }
        return rect;
    }

    public static /* synthetic */ Rect getViewRectBounds$default(View view, ViewGroup viewGroup, int r2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            r2 = 0;
        }
        return getViewRectBounds(view, viewGroup, r2);
    }

    public static final void gone(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(8);
    }

    public static final void invisible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(4);
    }

    public static final void setMargin(View view, int r3, int r4, int r5, int r6) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        if (r3 != -1) {
            marginLayoutParams.leftMargin = r3;
        }
        if (r4 != -1) {
            marginLayoutParams.topMargin = r4;
        }
        if (r5 != -1) {
            marginLayoutParams.rightMargin = r5;
        }
        if (r6 != -1) {
            marginLayoutParams.bottomMargin = r6;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    public static /* synthetic */ void setMargin$default(View view, int r2, int r3, int r4, int r5, int r6, Object obj) {
        if ((r6 & 1) != 0) {
            r2 = -1;
        }
        if ((r6 & 2) != 0) {
            r3 = -1;
        }
        if ((r6 & 4) != 0) {
            r4 = -1;
        }
        if ((r6 & 8) != 0) {
            r5 = -1;
        }
        setMargin(view, r2, r3, r4, r5);
    }

    public static final void toast(Context context, String text, boolean z) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Toast.makeText(context, text, z ? 1 : 0).show();
    }

    public static /* synthetic */ void toast$default(Context context, String str, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = false;
        }
        toast(context, str, z);
    }

    public static final void visible(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(0);
    }

    public static final void toast(Fragment fragment, String text, boolean z) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Context context = fragment.getContext();
        if (context == null) {
            return;
        }
        Toast.makeText(context, text, z ? 1 : 0).show();
    }

    public static /* synthetic */ void toast$default(Fragment fragment, String str, boolean z, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            z = false;
        }
        toast(fragment, str, z);
    }
}
