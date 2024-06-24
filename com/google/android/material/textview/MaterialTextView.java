package com.google.android.material.textview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int readFirstAvailableDimension(Context context, TypedArray typedArray, int... r9) {
        int r3 = -1;
        for (int r2 = 0; r2 < r9.length && r3 < 0; r2++) {
            int r32 = r9[r2];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(r32, typedValue) && typedValue.type == 2) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
                r3 = dimensionPixelSize;
            } else {
                r3 = typedArray.getDimensionPixelSize(r32, -1);
            }
        }
        return r3;
    }

    public final void applyLineHeightFromViewAppearance(int r3, Resources.Theme theme) {
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(r3, R$styleable.MaterialTextAppearance);
        int readFirstAvailableDimension = readFirstAvailableDimension(getContext(), obtainStyledAttributes, 1, 2);
        obtainStyledAttributes.recycle();
        if (readFirstAvailableDimension >= 0) {
            setLineHeight(readFirstAvailableDimension);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void setTextAppearance(Context context, int r5) {
        boolean z;
        super.setTextAppearance(context, r5);
        TypedValue resolve = MaterialAttributes.resolve(context, R.attr.textAppearanceLineHeightEnabled);
        if (resolve != null && resolve.type == 18 && resolve.data == 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            applyLineHeightFromViewAppearance(r5, context.getTheme());
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int r9) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = getContext();
        TypedValue resolve = MaterialAttributes.resolve(context2, R.attr.textAppearanceLineHeightEnabled);
        if ((resolve != null && resolve.type == 18 && resolve.data == 0) ? false : true) {
            Resources.Theme theme = context2.getTheme();
            int[] r3 = R$styleable.MaterialTextView;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, r3, android.R.attr.textViewStyle, 0);
            int readFirstAvailableDimension = readFirstAvailableDimension(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (readFirstAvailableDimension != -1) {
                return;
            }
            TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, r3, android.R.attr.textViewStyle, 0);
            int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
            obtainStyledAttributes2.recycle();
            if (resourceId != -1) {
                applyLineHeightFromViewAppearance(resourceId, theme);
            }
        }
    }
}
