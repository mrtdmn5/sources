package androidx.compose.animation;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnimatedContent.kt */
/* loaded from: classes.dex */
public final class AnimatedContentScopeImpl implements AnimatedContentScope, AnimatedVisibilityScope {
    public final /* synthetic */ AnimatedVisibilityScope $$delegate_0;

    public AnimatedContentScopeImpl(AnimatedVisibilityScope animatedVisibilityScope) {
        Intrinsics.checkNotNullParameter(animatedVisibilityScope, "animatedVisibilityScope");
        this.$$delegate_0 = animatedVisibilityScope;
    }
}
