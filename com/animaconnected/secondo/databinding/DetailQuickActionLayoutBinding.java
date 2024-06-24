package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DetailQuickActionLayoutBinding implements ViewBinding {
    public final Button assignToQuickActionBtn;
    public final RelativeLayout quickActionAssignContainer;
    public final TextView quickActionBtnDescription;
    public final ImageView quickActionHintImg;
    private final View rootView;
    public final Button unassignToQuickActionBtn;

    private DetailQuickActionLayoutBinding(View view, Button button, RelativeLayout relativeLayout, TextView textView, ImageView imageView, Button button2) {
        this.rootView = view;
        this.assignToQuickActionBtn = button;
        this.quickActionAssignContainer = relativeLayout;
        this.quickActionBtnDescription = textView;
        this.quickActionHintImg = imageView;
        this.unassignToQuickActionBtn = button2;
    }

    public static DetailQuickActionLayoutBinding bind(View view) {
        int r0 = R.id.assign_to_quick_action_btn;
        Button button = (Button) ViewBindings.findChildViewById(R.id.assign_to_quick_action_btn, view);
        if (button != null) {
            r0 = R.id.quick_action_assign_container;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.quick_action_assign_container, view);
            if (relativeLayout != null) {
                r0 = R.id.quick_action_btn_description;
                TextView textView = (TextView) ViewBindings.findChildViewById(R.id.quick_action_btn_description, view);
                if (textView != null) {
                    r0 = R.id.quick_action_hint_img;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.quick_action_hint_img, view);
                    if (imageView != null) {
                        r0 = R.id.unassign_to_quick_action_btn;
                        Button button2 = (Button) ViewBindings.findChildViewById(R.id.unassign_to_quick_action_btn, view);
                        if (button2 != null) {
                            return new DetailQuickActionLayoutBinding(view, button, relativeLayout, textView, imageView, button2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DetailQuickActionLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.detail_quick_action_layout, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }
}
