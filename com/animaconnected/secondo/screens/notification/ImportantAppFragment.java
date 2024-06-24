package com.animaconnected.secondo.screens.notification;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.notification.model.ImportantApp;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.provider.notification.NotificationProvider;
import com.animaconnected.secondo.screens.notification.picker.AppInfo;
import com.kronaby.watch.app.R;

/* loaded from: classes3.dex */
public class ImportantAppFragment extends NotificationDetailsFragment {
    private static final String TAG = "ImportantAppFragment";
    private Drawable mAppIcon;
    private String mAppName;
    private ImportantApp mImportantApp;
    private NotificationProvider mNotificationProvider;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateView$0(View view) {
        onRemoveButtonClicked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onRemoveButtonClicked$1(Void r1) {
        getMainController().goBack();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onRemoveButtonClicked$2(Throwable th) {
        Log.w(TAG, "onFail() called with t = [" + th + "]");
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment
    public String getName() {
        return "Important App";
    }

    @Override // com.animaconnected.secondo.screens.notification.NotificationDetailsFragment, com.animaconnected.secondo.screens.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ImportantApp importantApp = this.mImportantApp;
        if (importantApp != null) {
            this.mAppName = importantApp.getAppName();
            AppInfo appInfo = ProviderFactory.getImportantAppsProvider().getAppInfo(this.mImportantApp.getPackageName());
            if (appInfo != null) {
                this.mAppIcon = appInfo.getAppIcon();
            }
            this.mNotificationProvider = ProviderFactory.getNotificationProvider();
            return;
        }
        throw new RuntimeException("No Important App.");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_notification_important_app, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.title_text_view)).setText(this.mAppName);
        ((ImageView) inflate.findViewById(R.id.app_icon)).setImageDrawable(this.mAppIcon);
        ((Button) inflate.findViewById(R.id.remove)).setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.notification.ImportantAppFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ImportantAppFragment.this.lambda$onCreateView$0(view);
            }
        });
        initView(inflate);
        return inflate;
    }

    public void onRemoveButtonClicked() {
        this.mNotificationProvider.deleteImportantAppAndConfigurationItem(this.mImportantApp).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.notification.ImportantAppFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                ImportantAppFragment.this.lambda$onRemoveButtonClicked$1((Void) obj);
            }
        }).fail(new ImportantAppFragment$$ExternalSyntheticLambda1());
    }

    public void setImportantApp(ImportantApp importantApp) {
        this.mImportantApp = importantApp;
    }
}
