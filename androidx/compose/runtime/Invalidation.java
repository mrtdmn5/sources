package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
/* loaded from: classes.dex */
public final class Invalidation {
    public IdentityArraySet<Object> instances;
    public final int location;
    public final RecomposeScopeImpl scope;

    public Invalidation(RecomposeScopeImpl scope, int r3, IdentityArraySet<Object> identityArraySet) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.scope = scope;
        this.location = r3;
        this.instances = identityArraySet;
    }
}
