package com.animaconnected.secondo.screens.debugsettings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.future.AlwaysCallback;
import com.animaconnected.future.FailCallback;
import com.animaconnected.future.FlatMapCallback;
import com.animaconnected.future.Future;
import com.animaconnected.future.SuccessCallback;
import com.animaconnected.secondo.provider.ProviderFactory;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.watch.WatchProvider;
import com.animaconnected.watch.device.DeviceInfo;
import com.kronaby.watch.app.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressLint({"SetTextI18n"})
/* loaded from: classes3.dex */
public class DeviceInfoFragment extends BaseFragment {
    private static final long REFRESH_INTERVAL_MS = 5000;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private TextView mInfoText;
    private boolean mIsResumed;

    public static DeviceInfoFragment create() {
        return new DeviceInfoFragment();
    }

    private String createInfoText(Map<String, String> map, Map<String, String> map2, Map<DeviceInfo, String> map3, Map<String, String> map4) {
        String str = "Build info:\n";
        for (Map.Entry entry : sortMapEntries(map.entrySet())) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, "  ");
            m.append((String) entry.getKey());
            m.append(" = ");
            str = ComponentActivity$2$$ExternalSyntheticOutline0.m(m, (String) entry.getValue(), "\n");
        }
        String m2 = ComposableInvoker$$ExternalSyntheticOutline0.m(str, "\nBootloader info:\n");
        for (Map.Entry entry2 : sortMapEntries(map2.entrySet())) {
            StringBuilder m3 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(m2, "  ");
            m3.append((String) entry2.getKey());
            m3.append(" = ");
            m2 = ComponentActivity$2$$ExternalSyntheticOutline0.m(m3, (String) entry2.getValue(), "\n");
        }
        String m4 = ComposableInvoker$$ExternalSyntheticOutline0.m(m2, "\nDiagnostics:\n");
        for (Map.Entry entry3 : sortMapEntries(map4.entrySet())) {
            StringBuilder m5 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(m4, "  ");
            m5.append((String) entry3.getKey());
            m5.append(" = ");
            m4 = ComponentActivity$2$$ExternalSyntheticOutline0.m(m5, (String) entry3.getValue(), "\n");
        }
        String m6 = ComposableInvoker$$ExternalSyntheticOutline0.m(m4, "\nDevice info:\n");
        for (Map.Entry entry4 : sortMapEntries(map3.entrySet())) {
            StringBuilder m7 = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(m6, "  ");
            m7.append(entry4.getKey());
            m7.append(" = ");
            m6 = ComponentActivity$2$$ExternalSyntheticOutline0.m(m7, (String) entry4.getValue(), "\n");
        }
        return m6;
    }

    public /* synthetic */ void lambda$onCreateView$0(View view) {
        sendLog();
    }

    public static /* synthetic */ int lambda$sortMapEntries$8(Map.Entry entry, Map.Entry entry2) {
        return ((Comparable) entry.getKey()).compareTo((Comparable) entry2.getKey());
    }

    public /* synthetic */ void lambda$update$4(Future future, Future future2, Future future3, Future future4, Map map) {
        if (this.mIsResumed) {
            this.mInfoText.setText(createInfoText((Map) future.get(), (Map) future2.get(), (Map) future3.get(), (Map) future4.get()));
        }
    }

    public /* synthetic */ void lambda$update$5(Throwable th) {
        if (this.mIsResumed) {
            this.mInfoText.setText("Failed to get info");
        }
    }

    public /* synthetic */ void lambda$update$7() {
        this.mHandler.postDelayed(new DeviceInfoFragment$$ExternalSyntheticLambda7(0, this), 5000L);
    }

    private void sendLog() {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "Device Info");
        intent.putExtra("android.intent.extra.TEXT", this.mInfoText.getText());
        startActivity(Intent.createChooser(intent, "Send dump_uart log"));
    }

    private <T extends Comparable<T>, D> List<Map.Entry<T, D>> sortMapEntries(Set<Map.Entry<T, D>> set) {
        ArrayList arrayList = new ArrayList(set);
        Collections.sort(arrayList, new DeviceInfoFragment$$ExternalSyntheticLambda6());
        return arrayList;
    }

    /* renamed from: update */
    public void lambda$update$6() {
        if (!this.mIsResumed) {
            return;
        }
        WatchProvider watch = ProviderFactory.getWatch();
        final Future<Map<String, String>> readBuildInfo = watch.readBuildInfo();
        final Future<Map<String, String>> readBuildInfoBl = watch.readBuildInfoBl();
        final Future<Map<DeviceInfo, String>> deviceInformation = watch.getDeviceInformation();
        final Future<Map<String, String>> readDiagnostics = watch.readDiagnostics();
        readBuildInfo.flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda0
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$update$1;
                lambda$update$1 = DeviceInfoFragment.lambda$update$1(Future.this, (Map) obj);
                return lambda$update$1;
            }
        }).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda1
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$update$2;
                lambda$update$2 = DeviceInfoFragment.lambda$update$2(Future.this, (Map) obj);
                return lambda$update$2;
            }
        }).flatMap(new FlatMapCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda2
            @Override // com.animaconnected.future.FlatMapCallback
            public final Future onResult(Object obj) {
                Future lambda$update$3;
                lambda$update$3 = DeviceInfoFragment.lambda$update$3(Future.this, (Map) obj);
                return lambda$update$3;
            }
        }).success(new SuccessCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda3
            @Override // com.animaconnected.future.SuccessCallback
            public final void onSuccess(Object obj) {
                DeviceInfoFragment.this.lambda$update$4(readBuildInfo, readBuildInfoBl, deviceInformation, readDiagnostics, (Map) obj);
            }
        }).fail(new FailCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda4
            @Override // com.animaconnected.future.FailCallback
            public final void onFail(Throwable th) {
                DeviceInfoFragment.this.lambda$update$5(th);
            }
        }).always(new AlwaysCallback() { // from class: com.animaconnected.secondo.screens.debugsettings.DeviceInfoFragment$$ExternalSyntheticLambda5
            @Override // com.animaconnected.future.AlwaysCallback
            public final void onFinished() {
                DeviceInfoFragment.this.lambda$update$7();
            }
        });
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
        return "DeviceInfo";
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_deviceinfo, viewGroup, false);
        this.mInfoText = (TextView) inflate.findViewById(R.id.device_info_text);
        inflate.findViewById(R.id.btn_send).setOnClickListener(new DeviceInfoFragment$$ExternalSyntheticLambda8(this, 0));
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mIsResumed = false;
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsResumed = true;
        this.mInfoText.setText("Loading...");
        lambda$update$6();
    }

    public static /* synthetic */ Future lambda$update$1(Future future, Map map) throws Exception {
        return future;
    }

    public static /* synthetic */ Future lambda$update$2(Future future, Map map) throws Exception {
        return future;
    }

    public static /* synthetic */ Future lambda$update$3(Future future, Map map) throws Exception {
        return future;
    }
}
