package com.amplifyframework.auth.options;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class AuthSignUpOptions {
    private final List<AuthUserAttribute> userAttributes;

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        private AuthUserAttribute singleUserAttribute;
        private final List<AuthUserAttribute> userAttributes = new ArrayList();

        public AuthSignUpOptions build() {
            return new AuthSignUpOptions(Immutable.of(getUserAttributes()));
        }

        public abstract T getThis();

        public List<AuthUserAttribute> getUserAttributes() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.userAttributes);
            AuthUserAttribute authUserAttribute = this.singleUserAttribute;
            if (authUserAttribute != null && !arrayList.contains(authUserAttribute)) {
                arrayList.add(this.singleUserAttribute);
            }
            return arrayList;
        }

        public T userAttribute(AuthUserAttributeKey authUserAttributeKey, String str) {
            Objects.requireNonNull(authUserAttributeKey);
            Objects.requireNonNull(str);
            this.singleUserAttribute = new AuthUserAttribute(authUserAttributeKey, str);
            return getThis();
        }

        public T userAttributes(List<AuthUserAttribute> list) {
            Objects.requireNonNull(list);
            this.userAttributes.clear();
            this.userAttributes.addAll(list);
            return getThis();
        }
    }

    /* loaded from: classes.dex */
    public static final class CoreBuilder extends Builder<CoreBuilder> {
        @Override // com.amplifyframework.auth.options.AuthSignUpOptions.Builder
        public CoreBuilder getThis() {
            return this;
        }
    }

    public AuthSignUpOptions(List<AuthUserAttribute> list) {
        this.userAttributes = list;
    }

    public static Builder<?> builder() {
        return new CoreBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ObjectsCompat$Api19Impl.equals(getUserAttributes(), ((AuthSignUpOptions) obj).getUserAttributes());
        }
        return false;
    }

    public List<AuthUserAttribute> getUserAttributes() {
        return this.userAttributes;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getUserAttributes());
    }

    public String toString() {
        return LocaleList$$ExternalSyntheticOutline0.m(new StringBuilder("AuthSignUpOptions{userAttributes="), this.userAttributes, '}');
    }
}
