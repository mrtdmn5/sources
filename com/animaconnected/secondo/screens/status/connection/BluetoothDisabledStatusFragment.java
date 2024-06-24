package com.animaconnected.secondo.screens.status.connection;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestMultiplePermissions;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.animaconnected.bluetooth.util.ConnectionFactory;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat;
import com.animaconnected.secondo.provider.status.BluetoothDisabledStatus;
import com.animaconnected.secondo.provider.status.StatusModel;
import com.animaconnected.secondo.screens.status.BaseStatusFragment;
import com.animaconnected.secondo.utils.ViewKt;
import com.kronaby.watch.app.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothDisabledStatusFragment.kt */
/* loaded from: classes3.dex */
public final class BluetoothDisabledStatusFragment extends BaseStatusFragment {
    public static final int $stable = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$3$lambda$2$lambda$1(List missingPermissions, PermissionCompat.PermissionWrapperFragment permissionHelper, final ActivityResultLauncher launcher, View view) {
        Intrinsics.checkNotNullParameter(missingPermissions, "$missingPermissions");
        Intrinsics.checkNotNullParameter(permissionHelper, "$permissionHelper");
        Intrinsics.checkNotNullParameter(launcher, "$launcher");
        List list = missingPermissions;
        if (!list.isEmpty()) {
            permissionHelper.requestPermissionOrGoToSettings((String[]) list.toArray(new String[0]), new Function1<String[], Unit>() { // from class: com.animaconnected.secondo.screens.status.connection.BluetoothDisabledStatusFragment$onCreateView$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
                    invoke2(strArr);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String[] allowedRequests) {
                    Intrinsics.checkNotNullParameter(allowedRequests, "allowedRequests");
                    launcher.launch(allowedRequests);
                }
            });
        } else {
            ConnectionFactory.getConnection().enable();
        }
    }

    @Override // com.animaconnected.secondo.screens.status.BaseStatusFragment, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        return CreationExtras.Empty.INSTANCE;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_status_bluetooth_disabled, viewGroup, false);
        StatusModel status = getStatus();
        Intrinsics.checkNotNull(status, "null cannot be cast to non-null type com.animaconnected.secondo.provider.status.BluetoothDisabledStatus");
        final List<String> missingPermissions = ((BluetoothDisabledStatus) status).getMissingPermissions();
        final PermissionCompat.PermissionWrapperFragment create = PermissionCompat.create(this);
        final Button button = (Button) inflate.findViewById(R.id.enable_bluetooth_button);
        final ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.animaconnected.secondo.screens.status.connection.BluetoothDisabledStatusFragment$onCreateView$lambda$3$$inlined$registerMultiplePermissions$default$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Map<String, Boolean> result) {
                Intrinsics.checkNotNullParameter(result, "result");
                Set<Map.Entry<String, Boolean>> entrySet = result.entrySet();
                boolean z = true;
                if (!(entrySet instanceof Collection) || !entrySet.isEmpty()) {
                    Iterator<T> it = entrySet.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                            z = false;
                            break;
                        }
                    }
                }
                if (z) {
                    if (Build.VERSION.SDK_INT >= 33) {
                        Intrinsics.checkNotNull(button);
                        ViewKt.gone(button);
                    } else {
                        if (ConnectionFactory.getConnection().isEnabled()) {
                            return;
                        }
                        ConnectionFactory.getConnection().enable();
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
        if (Build.VERSION.SDK_INT >= 33 && missingPermissions.isEmpty()) {
            Intrinsics.checkNotNull(button);
            ViewKt.gone(button);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.animaconnected.secondo.screens.status.connection.BluetoothDisabledStatusFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BluetoothDisabledStatusFragment.onCreateView$lambda$3$lambda$2$lambda$1(missingPermissions, create, registerForActivityResult, view);
            }
        });
        return inflate;
    }
}
