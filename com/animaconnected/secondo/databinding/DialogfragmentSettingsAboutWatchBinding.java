package com.animaconnected.secondo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public final class DialogfragmentSettingsAboutWatchBinding implements ViewBinding {
    public final TextView aboutWatchDescripton;
    public final Button aboutWatchOk;
    private final LinearLayout rootView;

    private DialogfragmentSettingsAboutWatchBinding(LinearLayout linearLayout, TextView textView, Button button) {
        this.rootView = linearLayout;
        this.aboutWatchDescripton = textView;
        this.aboutWatchOk = button;
    }

    public static DialogfragmentSettingsAboutWatchBinding bind(View view) {
        int r0 = R.id.about_watch_descripton;
        TextView textView = (TextView) ViewBindings.findChildViewById(R.id.about_watch_descripton, view);
        if (textView != null) {
            r0 = R.id.about_watch_ok;
            Button button = (Button) ViewBindings.findChildViewById(R.id.about_watch_ok, view);
            if (button != null) {
                return new DialogfragmentSettingsAboutWatchBinding((LinearLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(r0)));
    }

    public static DialogfragmentSettingsAboutWatchBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogfragmentSettingsAboutWatchBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_settings_about_watch, viewGroup, false);
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
