package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {
    public final ArrayList<Intent> mIntents = new ArrayList<>();
    public final Context mSourceContext;

    /* loaded from: classes.dex */
    public interface SupportParentable {
        Intent getSupportParentActivityIntent();
    }

    public TaskStackBuilder(Context context) {
        this.mSourceContext = context;
    }

    public final void addParentStack(ComponentName componentName) {
        Context context = this.mSourceContext;
        ArrayList<Intent> arrayList = this.mIntents;
        int size = arrayList.size();
        try {
            for (Intent parentActivityIntent = NavUtils.getParentActivityIntent(context, componentName); parentActivityIntent != null; parentActivityIntent = NavUtils.getParentActivityIntent(context, parentActivityIntent.getComponent())) {
                arrayList.add(size, parentActivityIntent);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public final Iterator<Intent> iterator() {
        return this.mIntents.iterator();
    }

    public final void startActivities() {
        ArrayList<Intent> arrayList = this.mIntents;
        if (!arrayList.isEmpty()) {
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Object obj = ContextCompat.sLock;
            ContextCompat.Api16Impl.startActivities(this.mSourceContext, intentArr, null);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
