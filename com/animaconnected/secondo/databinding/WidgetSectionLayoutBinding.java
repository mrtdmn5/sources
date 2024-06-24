package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class WidgetSectionLayoutBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final View sectionLayoutBottomLine;
    public final ImageView sectionLayoutChevron;
    public final TextView sectionLayoutDescription;
    public final ImageView sectionLayoutIcon;
    public final ProgressBar sectionLayoutProgressbar;
    public final SwitchCompat sectionLayoutSwitch;
    public final TextView sectionLayoutTitle;
    public final View sectionLayoutTopLine;
    public final LinearLayout sectionLayoutTouchArea;

    private WidgetSectionLayoutBinding(LinearLayout linearLayout, View view, ImageView imageView, TextView textView, ImageView imageView2, ProgressBar progressBar, SwitchCompat switchCompat, TextView textView2, View view2, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.sectionLayoutBottomLine = view;
        this.sectionLayoutChevron = imageView;
        this.sectionLayoutDescription = textView;
        this.sectionLayoutIcon = imageView2;
        this.sectionLayoutProgressbar = progressBar;
        this.sectionLayoutSwitch = switchCompat;
        this.sectionLayoutTitle = textView2;
        this.sectionLayoutTopLine = view2;
        this.sectionLayoutTouchArea = linearLayout2;
    }

    public static WidgetSectionLayoutBinding bind(View view) {
        int r0 = R.id.section_layout_bottom_line;
        View findChildViewById = ViewBindings.findChildViewById(R.id.section_layout_bottom_line, view);
        if (findChildViewById != null) {
            r0 = R.id.section_layout_chevron;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.section_layout_chevron, view);
            if (imageView != null) {
                r0 = R.id.section_layout_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.section_layout_description, view);
                if (textView != null) {
                    r0 = R.id.section_layout_icon;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.section_layout_icon, view);
                    if (imageView2 != null) {
                        r0 = R.id.section_layout_progressbar;
                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(R.id.section_layout_progressbar, view);
                        if (progressBar != null) {
                            r0 = R.id.section_layout_switch;
                            SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(R.id.section_layout_switch, view);
                            if (switchCompat != null) {
                                r0 = R.id.section_layout_title;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.section_layout_title, view);
                                if (textView2 != null) {
                                    r0 = R.id.section_layout_top_line;
                                    View findChildViewById2 = ViewBindings.findChildViewById(R.id.section_layout_top_line, view);
                                    if (findChildViewById2 != null) {
                                        r0 = R.id.section_layout_touch_area;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(R.id.section_layout_touch_area, view);
                                        if (linearLayout != null) {
                                            return new WidgetSectionLayoutBinding((LinearLayout) view, findChildViewById, imageView, textView, imageView2, progressBar, switchCompat, textView2, findChildViewById2, linearLayout);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static WidgetSectionLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WidgetSectionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.widget_section_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
