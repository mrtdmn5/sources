package androidx.activity.result.contract;

import android.content.Intent;
import androidx.activity.ComponentActivity;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityResultContract.kt */
/* loaded from: classes.dex */
public abstract class ActivityResultContract<I, O> {

    /* compiled from: ActivityResultContract.kt */
    /* loaded from: classes.dex */
    public static final class SynchronousResult<T> {
        public final T value;

        /* JADX WARN: Multi-variable type inference failed */
        public SynchronousResult(Serializable serializable) {
            this.value = serializable;
        }
    }

    public abstract Intent createIntent(ComponentActivity componentActivity, Object obj);

    public SynchronousResult getSynchronousResult(ComponentActivity context, Object obj) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    public abstract Object parseResult(Intent intent, int r2);
}
