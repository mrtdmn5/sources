package androidx.customview.poolingcontainer;

import android.view.View;
import com.kronaby.watch.app.R;

/* compiled from: PoolingContainer.kt */
/* loaded from: classes.dex */
public final class PoolingContainer {
    public static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View view) {
        PoolingContainerListenerHolder poolingContainerListenerHolder = (PoolingContainerListenerHolder) view.getTag(R.id.pooling_container_listener_holder_tag);
        if (poolingContainerListenerHolder == null) {
            PoolingContainerListenerHolder poolingContainerListenerHolder2 = new PoolingContainerListenerHolder();
            view.setTag(R.id.pooling_container_listener_holder_tag, poolingContainerListenerHolder2);
            return poolingContainerListenerHolder2;
        }
        return poolingContainerListenerHolder;
    }
}
