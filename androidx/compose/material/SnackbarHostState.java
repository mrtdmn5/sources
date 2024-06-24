package androidx.compose.material;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import com.google.common.collect.Platform;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: SnackbarHost.kt */
/* loaded from: classes.dex */
public final class SnackbarHostState {
    public final ParcelableSnapshotMutableState currentSnackbarData$delegate;

    public SnackbarHostState() {
        MutexKt.Mutex$default();
        this.currentSnackbarData$delegate = Platform.mutableStateOf$default(null);
    }
}
