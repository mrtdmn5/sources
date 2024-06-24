package com.animaconnected.secondo.screens.watchupdate;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.utils.customersupport.CustomerSupportMailUtils;
import com.animaconnected.watch.device.DeviceInfo;
import com.kronaby.watch.app.R;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class RemoveBondRestartFragment extends BaseFragment {
    private static final String NAME = "removeBondRestartPhone";
    private Button mContactSupportButton;
    private CustomerSupportMailUtils mCustomerSupport;
    private Map<DeviceInfo, String> mDeviceInfoMap = new ArrayMap();

    private String buildSupportBody() {
        Context context = getContext();
        return this.mCustomerSupport.getSupportMsgTechData(this.mDeviceInfoMap) + context.getString(R.string.dfu_error_support_msg_body_remove_bond_failed) + context.getString(R.string.support_msg_body_describe_support_needed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        onContactSupport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onResume$1(Map map) {
        this.mDeviceInfoMap = Collections.unmodifiableMap(map);
        this.mContactSupportButton.setEnabled(true);
    }

    public static RemoveBondRestartFragment newInstance() {
        return new RemoveBondRestartFragment();
    }

    private void onContactSupport() {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("mailto:" + this.mCustomerSupport.getSupportEmailAddress()));
        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.dfu_error_support_msg_subject));
        intent.putExtra("android.intent.extra.TEXT", buildSupportBody());
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getContext(), R.string.mail_client_not_found_error, 0).show();
        }
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public boolean accessEvenIfDisconnected() {
        return true;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getFeaturePathName() {
        return getString(R.string.feature_path_settings);
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return NAME;
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment
    public String getParentFragmentName() {
        return NAME;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mCustomerSupport = new CustomerSupportMailUtils(getContext());
        View inflate = layoutInflater.inflate(R.layout.fragment_remove_bond_restart, viewGroup, false);
        Button button = (Button) inflate.findViewById(R.id.dfu_error_contact_support_button);
        this.mContactSupportButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.watchupdate.RemoveBondRestartFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoveBondRestartFragment.this.lambda$onCreateView$0(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ProviderFactory.getWatch().getDeviceInformation().success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.watchupdate.RemoveBondRestartFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                RemoveBondRestartFragment.this.lambda$onResume$1((Map) obj);
            }
        });
    }

    @Override // com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        showToolbarUpIndicator(false);
    }
}
