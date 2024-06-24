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
public final class ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding implements ViewBinding {
    public final ImageView doubleCrownLine;
    public final RelativeLayout draganddropSourceGridViewPlaceHolder;
    public final FillLayout dropContainer1;
    public final FillLayout dropContainer2;
    public final FillLayout dropContainer3;
    public final FillLayout dropContainer4;
    public final RelativeLayout dropTargetLayer;
    public final FrameLayout dropTargetsContainerLayout;
    public final FrameLayout dropTargetsDoubleCrownContainerLayout;
    private final BehaviourDragAndDropTargetLayout rootView;
    public final ImageView watchPlaceholder;

    private ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding(BehaviourDragAndDropTargetLayout behaviourDragAndDropTargetLayout, ImageView imageView, RelativeLayout relativeLayout, FillLayout fillLayout, FillLayout fillLayout2, FillLayout fillLayout3, FillLayout fillLayout4, RelativeLayout relativeLayout2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView2) {
        this.rootView = behaviourDragAndDropTargetLayout;
        this.doubleCrownLine = imageView;
        this.draganddropSourceGridViewPlaceHolder = relativeLayout;
        this.dropContainer1 = fillLayout;
        this.dropContainer2 = fillLayout2;
        this.dropContainer3 = fillLayout3;
        this.dropContainer4 = fillLayout4;
        this.dropTargetLayer = relativeLayout2;
        this.dropTargetsContainerLayout = frameLayout;
        this.dropTargetsDoubleCrownContainerLayout = frameLayout2;
        this.watchPlaceholder = imageView2;
    }

    public static ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding bind(View view) {
        int r0 = R.id.double_crown_line;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.double_crown_line, view);
        if (imageView != null) {
            r0 = R.id.draganddrop_source_grid_view_place_holder;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(R.id.draganddrop_source_grid_view_place_holder, view);
            if (relativeLayout != null) {
                r0 = R.id.drop_container_1;
                FillLayout fillLayout = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_1, view);
                if (fillLayout != null) {
                    r0 = R.id.drop_container_2;
                    FillLayout fillLayout2 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_2, view);
                    if (fillLayout2 != null) {
                        r0 = R.id.drop_container_3;
                        FillLayout fillLayout3 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_3, view);
                        if (fillLayout3 != null) {
                            r0 = R.id.drop_container_4;
                            FillLayout fillLayout4 = (FillLayout) ViewBindings.findChildViewById(R.id.drop_container_4, view);
                            if (fillLayout4 != null) {
                                r0 = R.id.drop_target_layer;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(R.id.drop_target_layer, view);
                                if (relativeLayout2 != null) {
                                    r0 = R.id.drop_targets_container_layout;
                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(R.id.drop_targets_container_layout, view);
                                    if (frameLayout != null) {
                                        r0 = R.id.drop_targets_double_crown_container_layout;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(R.id.drop_targets_double_crown_container_layout, view);
                                        if (frameLayout2 != null) {
                                            r0 = R.id.watch_placeholder;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(R.id.watch_placeholder, view);
                                            if (imageView2 != null) {
                                                return new ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding((BehaviourDragAndDropTargetLayout) view, imageView, relativeLayout, fillLayout, fillLayout2, fillLayout3, fillLayout4, relativeLayout2, frameLayout, frameLayout2, imageView2);
                                            }
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

    public static ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ComplicationsDraganddropTargetLayoutTwoSubComplicationsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.complications_draganddrop_target_layout_two_sub_complications, viewGroup, false);
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
