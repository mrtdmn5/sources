package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.animaconnected.secondo.screens.behaviourconfiguration.BehaviourDragAndDropTargetLayout;
import com.animaconnected.secondo.screens.notification.widget.FillLayout;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class PushersOnePusherDraganddropTargetLayoutBinding implements ViewBinding {
    public final RelativeLayout draganddropSourceGridViewPlaceHolder;
    public final FillLayout dropContainer1;
    public final RelativeLayout dropTargetLayer;
    public final FrameLayout dropTargetsContainerLayout;
    private final BehaviourDragAndDropTargetLayout rootView;
    public final ImageView watchPlaceholder;

    private PushersOnePusherDraganddropTargetLayoutBinding(BehaviourDragAndDropTargetLayout behaviourDragAndDropTargetLayout, RelativeLayout relativeLayout, FillLayout fillLayout, RelativeLayout relativeLayout2, FrameLayout frameLayout, ImageView imageView) {
        this.rootView = behaviourDragAndDropTargetLayout;
        this.draganddropSourceGridViewPlaceHolder = relativeLayout;
        this.dropContainer1 = fillLayout;
        this.dropTargetLayer = relativeLayout2;
        this.dropTargetsContainerLayout = frameLayout;
        this.watchPlaceholder = imageView;
    }

    public static PushersOnePusherDraganddropTargetLayoutBinding bind(View view) {
        int r0 = R.id.draganddrop_source_grid_view_place_holder;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.draganddrop_source_grid_view_place_holder, view);
        if (relativeLayout != null) {
            r0 = R.id.drop_container_1;
            FillLayout fillLayout = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_1, view);
            if (fillLayout != null) {
                r0 = R.id.drop_target_layer;
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(R.id.drop_target_layer, view);
                if (relativeLayout2 != null) {
                    r0 = R.id.drop_targets_container_layout;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.drop_targets_container_layout, view);
                    if (frameLayout != null) {
                        r0 = R.id.watch_placeholder;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.watch_placeholder, view);
                        if (imageView != null) {
                            return new PushersOnePusherDraganddropTargetLayoutBinding((BehaviourDragAndDropTargetLayout) view, relativeLayout, fillLayout, relativeLayout2, frameLayout, imageView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static PushersOnePusherDraganddropTargetLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PushersOnePusherDraganddropTargetLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.pushers_one_pusher_draganddrop_target_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    public BehaviourDragAndDropTargetLayout getRoot() {
        return this.rootView;
    }
}
