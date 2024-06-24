package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CreationExtras.kt */
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras() {
        this(CreationExtras.Empty.INSTANCE);
    }

    public MutableCreationExtras(CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        this.map.putAll(initialExtras.map);
    }
}
