package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogTicketErrorBinding implements ViewBinding {
    public final Button btnApprove;
    private final LinearLayout rootView;

    private DialogTicketErrorBinding(LinearLayout linearLayout, Button button) {
        this.rootView = linearLayout;
        this.btnApprove = button;
    }

    public static DialogTicketErrorBinding bind(View view) {
        Button button = (Button) ViewBindings.findChildViewById(R.id.btn_approve, view);
        if (button != null) {
            return new DialogTicketErrorBinding((LinearLayout) view, button);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.btn_approve)));
    }

    public static DialogTicketErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogTicketErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ticket_error, viewGroup, false);
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
