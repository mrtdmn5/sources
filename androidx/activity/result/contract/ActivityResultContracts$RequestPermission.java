package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class ActivityResultContracts$RequestPermission extends ActivityResultContract<String, Boolean> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Intent createIntent(ComponentActivity context, Object obj) {
        String input = (String) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", new String[]{input});
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
        return putExtra;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final ActivityResultContract.SynchronousResult getSynchronousResult(ComponentActivity context, Object obj) {
        boolean z;
        String input = (String) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        if (ContextCompat.checkSelfPermission(context, input) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new ActivityResultContract.SynchronousResult(Boolean.TRUE);
        }
        return null;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Object parseResult(Intent intent, int r6) {
        boolean z;
        boolean z2;
        if (intent != null && r6 == -1) {
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean z3 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int r1 = 0;
                while (true) {
                    if (r1 < length) {
                        if (intArrayExtra[r1] == 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            z = true;
                            break;
                        }
                        r1++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    z3 = true;
                }
            }
            return Boolean.valueOf(z3);
        }
        return Boolean.FALSE;
    }
}
