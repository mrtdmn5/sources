package androidx.core.util;

import android.os.Bundle;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;

/* loaded from: classes.dex */
public final class DebugUtils implements SuccessContinuation {
    public static final /* synthetic */ DebugUtils zza = new DebugUtils();

    public static void buildShortClassTag(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append(Constants.NULL_VERSION_ID);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        boolean z;
        Bundle bundle = (Bundle) obj;
        int r0 = Rpc.zza;
        if (bundle != null && bundle.containsKey("google.messenger")) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return Tasks.forResult(null);
        }
        return Tasks.forResult(bundle);
    }
}
