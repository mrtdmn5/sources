package com.amplifyframework.auth.options;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthFetchSessionOptions.kt */
/* loaded from: classes.dex */
public class AuthFetchSessionOptions {
    public static final Companion Companion = new Companion(null);
    private final boolean forceRefresh;

    /* compiled from: AuthFetchSessionOptions.kt */
    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        private boolean forceRefresh;

        public AuthFetchSessionOptions build() {
            return new AuthFetchSessionOptions(this.forceRefresh);
        }

        public Builder<T> forceRefresh(boolean z) {
            this.forceRefresh = z;
            return this;
        }

        public final boolean getForceRefresh() {
            return this.forceRefresh;
        }

        public abstract T getThis();
    }

    /* compiled from: AuthFetchSessionOptions.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Builder<?> builder() {
            return new CoreBuilder();
        }

        public final AuthFetchSessionOptions defaults() {
            return new AuthFetchSessionOptions(false);
        }

        private Companion() {
        }
    }

    /* compiled from: AuthFetchSessionOptions.kt */
    /* loaded from: classes.dex */
    public static final class CoreBuilder extends Builder<CoreBuilder> {
        @Override // com.amplifyframework.auth.options.AuthFetchSessionOptions.Builder
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthFetchSessionOptions(boolean z) {
        this.forceRefresh = z;
    }

    public static final Builder<?> builder() {
        return Companion.builder();
    }

    public static final AuthFetchSessionOptions defaults() {
        return Companion.defaults();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Intrinsics.areEqual(getClass(), obj.getClass())) {
            return ObjectsCompat$Api19Impl.equals(Boolean.valueOf(this.forceRefresh), Boolean.valueOf(((AuthFetchSessionOptions) obj).forceRefresh));
        }
        return false;
    }

    public final boolean getForceRefresh() {
        return this.forceRefresh;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(Boolean.valueOf(this.forceRefresh));
    }

    public String toString() {
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(new StringBuilder("AuthFetchSessionOptions{forceRefresh="), this.forceRefresh, '}');
    }
}
