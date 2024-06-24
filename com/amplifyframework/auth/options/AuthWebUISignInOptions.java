package com.amplifyframework.auth.options;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class AuthWebUISignInOptions {
    private final List<String> scopes;

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        private List<String> scopes = new ArrayList();

        public AuthWebUISignInOptions build() {
            return new AuthWebUISignInOptions(Immutable.of(this.scopes));
        }

        public List<String> getScopes() {
            return this.scopes;
        }

        public abstract T getThis();

        public T scopes(List<String> list) {
            Objects.requireNonNull(list);
            this.scopes.clear();
            this.scopes.addAll(list);
            return getThis();
        }
    }

    /* loaded from: classes.dex */
    public static final class CoreBuilder extends Builder<CoreBuilder> {
        @Override // com.amplifyframework.auth.options.AuthWebUISignInOptions.Builder
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthWebUISignInOptions(List<String> list) {
        this.scopes = list;
    }

    public static Builder<?> builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getScopes(), ((AuthWebUISignInOptions) obj).getScopes());
        }
        return false;
    }

    public List<String> getScopes() {
        return this.scopes;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getScopes());
    }

    public String toString() {
        return "AuthWebUISignInOptions{scopes=" + getScopes() + '}';
    }
}
