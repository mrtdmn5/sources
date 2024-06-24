package com.google.android.material.internal;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.Comparator;

/* loaded from: classes3.dex */
public final class ToolbarUtils {
    public static final AnonymousClass1 VIEW_TOP_COMPARATOR = new AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ToolbarUtils$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            return view.getTop() - view2.getTop();
        }
    }

    public static ArrayList getTextViewsWithText(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int r1 = 0; r1 < toolbar.getChildCount(); r1++) {
            View childAt = toolbar.getChildAt(r1);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }
}
