package com.amplifyframework.devmenu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.Navigation;
import com.amplifyframework.core.R;

/* loaded from: classes.dex */
public final class DevMenuMainFragment extends Fragment {
    public static /* synthetic */ void lambda$onCreateView$0(View view) {
        Navigation.findNavController(view).navigate(R.id.show_env_info);
    }

    public static /* synthetic */ void lambda$onCreateView$1(View view) {
        Navigation.findNavController(view).navigate(R.id.show_device_info);
    }

    public static /* synthetic */ void lambda$onCreateView$2(View view) {
        Navigation.findNavController(view).navigate(R.id.show_logs);
    }

    public static /* synthetic */ void lambda$onCreateView$3(View view) {
        Navigation.findNavController(view).navigate(R.id.show_file_issue);
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dev_menu_fragment_main, viewGroup, false);
        inflate.findViewById(R.id.env_button).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda0(0));
        inflate.findViewById(R.id.device_button).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda1(0));
        inflate.findViewById(R.id.logs_button).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda2());
        inflate.findViewById(R.id.file_issue_button).setOnClickListener(new DevMenuMainFragment$$ExternalSyntheticLambda3());
        return inflate;
    }
}
