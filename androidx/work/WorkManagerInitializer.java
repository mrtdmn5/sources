package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {
    public static final String TAG = Logger.tagWithPrefix("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public final WorkManager create(Context context) {
        Logger.get().debug(TAG, "Initializing WorkManager with default configuration.", new Throwable[0]);
        WorkManagerImpl.initialize(context, new Configuration(new Configuration.Builder()));
        return WorkManagerImpl.getInstance(context);
    }

    @Override // androidx.startup.Initializer
    public final List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
