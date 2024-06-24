package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultContracts.kt */
/* loaded from: classes.dex */
public final class ActivityResultContracts$StartActivityForResult extends ActivityResultContract<Intent, ActivityResult> {
    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Intent createIntent(ComponentActivity context, Object obj) {
        Intent input = (Intent) obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return input;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public final Object parseResult(Intent intent, int r3) {
        return new ActivityResult(intent, r3);
    }
}
