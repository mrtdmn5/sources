package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class FragmentDetailsDistressInvitationCodeLinkBinding implements ViewBinding {
    public final ImageView imageViewFinger;
    public final TextView invitationCodeText;
    public final TextView invitationLinkDescription;
    private final LinearLayout rootView;

    private FragmentDetailsDistressInvitationCodeLinkBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = linearLayout;
        this.imageViewFinger = imageView;
        this.invitationCodeText = textView;
        this.invitationLinkDescription = textView2;
    }

    public static FragmentDetailsDistressInvitationCodeLinkBinding bind(View view) {
        int r0 = R.id.image_view_finger;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(R.id.image_view_finger, view);
        if (imageView != null) {
            r0 = R.id.invitation_code_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(R.id.invitation_code_text, view);
            if (textView != null) {
                r0 = R.id.invitation_link_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(R.id.invitation_link_description, view);
                if (textView2 != null) {
                    return new FragmentDetailsDistressInvitationCodeLinkBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static FragmentDetailsDistressInvitationCodeLinkBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentDetailsDistressInvitationCodeLinkBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_details_distress_invitation_code_link, viewGroup, false);
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
