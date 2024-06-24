package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat$Api21Impl;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.google.android.gms.internal.fitness.zzav;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] LOGO_SCALE_TYPE_ARRAY = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Boolean logoAdjustViewBounds;
    public ImageView.ScaleType logoScaleType;
    public Integer navigationIconTint;
    public boolean subtitleCentered;
    public boolean titleCentered;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.logoScaleType;
    }

    public Integer getNavigationIconTint() {
        return this.navigationIconTint;
    }

    public final void layoutTitleCenteredHorizontally(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int r0 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int r1 = measuredWidth2 + r0;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - r0, 0), Math.max(r1 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            r0 += max;
            r1 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(r1 - r0, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(r0, textView.getTop(), r1, textView.getBottom());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            zzav.setParentAbsoluteElevation(this, (MaterialShapeDrawable) background);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int r8, int r9, int r10, int r11) {
        TextView textView;
        TextView textView2;
        super.onLayout(z, r8, r9, r10, r11);
        int r82 = 0;
        ImageView imageView = null;
        if (this.titleCentered || this.subtitleCentered) {
            ArrayList textViewsWithText = ToolbarUtils.getTextViewsWithText(this, getTitle());
            boolean isEmpty = textViewsWithText.isEmpty();
            ToolbarUtils.AnonymousClass1 anonymousClass1 = ToolbarUtils.VIEW_TOP_COMPARATOR;
            if (isEmpty) {
                textView = null;
            } else {
                textView = (TextView) Collections.min(textViewsWithText, anonymousClass1);
            }
            ArrayList textViewsWithText2 = ToolbarUtils.getTextViewsWithText(this, getSubtitle());
            if (textViewsWithText2.isEmpty()) {
                textView2 = null;
            } else {
                textView2 = (TextView) Collections.max(textViewsWithText2, anonymousClass1);
            }
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int r0 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int r2 = 0; r2 < getChildCount(); r2++) {
                    View childAt = getChildAt(r2);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < r0 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > r0 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.titleCentered && textView != null) {
                    layoutTitleCenteredHorizontally(textView, pair);
                }
                if (this.subtitleCentered && textView2 != null) {
                    layoutTitleCenteredHorizontally(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        while (true) {
            if (r82 >= getChildCount()) {
                break;
            }
            View childAt2 = getChildAt(r82);
            if (childAt2 instanceof ImageView) {
                ImageView imageView2 = (ImageView) childAt2;
                if (logo != null && imageView2.getDrawable().getConstantState().equals(logo.getConstantState())) {
                    imageView = imageView2;
                    break;
                }
            }
            r82++;
        }
        if (imageView != null) {
            Boolean bool = this.logoAdjustViewBounds;
            if (bool != null) {
                imageView.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.logoScaleType;
            if (scaleType != null) {
                imageView.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).setElevation(f);
        }
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.logoAdjustViewBounds;
        if (bool == null || bool.booleanValue() != z) {
            this.logoAdjustViewBounds = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.logoScaleType != scaleType) {
            this.logoScaleType = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.navigationIconTint != null) {
            drawable = drawable.mutate();
            DrawableCompat$Api21Impl.setTint(drawable, this.navigationIconTint.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    public void setNavigationIconTint(int r1) {
        this.navigationIconTint = Integer.valueOf(r1);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.subtitleCentered != z) {
            this.subtitleCentered = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.titleCentered != z) {
            this.titleCentered = z;
            requestLayout();
        }
    }

    public MaterialToolbar(Context context, AttributeSet attributeSet, int r10) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, R.attr.toolbarStyle, 2132083869), attributeSet, R.attr.toolbarStyle);
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R$styleable.MaterialToolbar, R.attr.toolbarStyle, 2132083869, new int[0]);
        if (obtainStyledAttributes.hasValue(2)) {
            setNavigationIconTint(obtainStyledAttributes.getColor(2, -1));
        }
        this.titleCentered = obtainStyledAttributes.getBoolean(4, false);
        this.subtitleCentered = obtainStyledAttributes.getBoolean(3, false);
        int r0 = obtainStyledAttributes.getInt(1, -1);
        if (r0 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = LOGO_SCALE_TYPE_ARRAY;
            if (r0 < scaleTypeArr.length) {
                this.logoScaleType = scaleTypeArr[r0];
            }
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.logoAdjustViewBounds = Boolean.valueOf(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            materialShapeDrawable.initializeElevationOverlay(context2);
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            materialShapeDrawable.setElevation(ViewCompat.Api21Impl.getElevation(this));
            ViewCompat.Api16Impl.setBackground(this, materialShapeDrawable);
        }
    }
}
