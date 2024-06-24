package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class ChildrenAlphaProperty extends Property<ViewGroup, Float> {
    public static final ChildrenAlphaProperty CHILDREN_ALPHA = new ChildrenAlphaProperty();

    public ChildrenAlphaProperty() {
        super(Float.class, "childrenAlpha");
    }

    @Override // android.util.Property
    public final Float get(ViewGroup viewGroup) {
        Float f = (Float) viewGroup.getTag(R.id.mtrl_internal_children_alpha_tag);
        if (f == null) {
            return Float.valueOf(1.0f);
        }
        return f;
    }

    @Override // android.util.Property
    public final void set(ViewGroup viewGroup, Float f) {
        ViewGroup viewGroup2 = viewGroup;
        float floatValue = f.floatValue();
        viewGroup2.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup2.getChildCount();
        for (int r1 = 0; r1 < childCount; r1++) {
            viewGroup2.getChildAt(r1).setAlpha(floatValue);
        }
    }
}
