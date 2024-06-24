package com.animaconnected.secondo.screens;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.animaconnected.secondo.utils.CustomActivityResult;
import com.animaconnected.secondo.utils.NotificationUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseActivity.kt */
/* loaded from: classes3.dex */
public abstract class BaseActivity extends AppCompatActivity {
    public static final int $stable = 8;
    public CustomActivityResult<Intent, ActivityResult> activityLauncher;

    private final void checkPermissions() {
        List<String> list = EmptyList.INSTANCE;
        try {
            String[] strArr = getPackageManager().getPackageInfo(getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                list = ArraysKt___ArraysKt.toList(strArr);
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (ContextCompat.checkSelfPermission(this, str) != 0) {
                arrayList.add(str);
            }
        }
        NotificationUtils.INSTANCE.removeNotificationId(arrayList);
    }

    public final CustomActivityResult<Intent, ActivityResult> getActivityLauncher() {
        CustomActivityResult<Intent, ActivityResult> customActivityResult = this.activityLauncher;
        if (customActivityResult != null) {
            return customActivityResult;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activityLauncher");
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setActivityLauncher(CustomActivityResult.Companion.registerForActivityResult(this, new ActivityResultContracts$StartActivityForResult()));
        super.onCreate(bundle);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        checkPermissions();
    }

    public final void setActivityLauncher(CustomActivityResult<Intent, ActivityResult> customActivityResult) {
        Intrinsics.checkNotNullParameter(customActivityResult, "<set-?>");
        this.activityLauncher = customActivityResult;
    }
}
