package com.amplifyframework.core.model;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.util.Empty;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class AuthRule {
    private static final String DEFAULT_GROUPS_FIELD = "groups";
    private static final String DEFAULT_GROUP_CLAIM = "cognito:groups";
    private static final String DEFAULT_IDENTITY_CLAIM = "username";
    private static final String DEFAULT_OWNER_FIELD = "owner";
    private final AuthStrategy.Provider authProvider;
    private final AuthStrategy authStrategy;
    private final String groupClaim;
    private final List<String> groups;
    private final String groupsField;
    private final String identityClaim;
    private final List<ModelOperation> operations;
    private final String ownerField;

    /* loaded from: classes.dex */
    public static final class Builder {
        private AuthStrategy.Provider authProvider;
        private AuthStrategy authStrategy;
        private String groupClaim;
        private List<String> groups;
        private String groupsField;
        private String identityClaim;
        private List<ModelOperation> operations = new ArrayList();
        private String ownerField;

        public Builder authProvider(AuthStrategy.Provider provider) {
            Objects.requireNonNull(provider);
            this.authProvider = provider;
            return this;
        }

        public Builder authStrategy(AuthStrategy authStrategy) {
            Objects.requireNonNull(authStrategy);
            this.authStrategy = authStrategy;
            return this;
        }

        public AuthRule build() {
            Objects.requireNonNull(this.authStrategy);
            return new AuthRule(this);
        }

        public Builder groupClaim(String str) {
            Objects.requireNonNull(str);
            this.groupClaim = str;
            return this;
        }

        public Builder groups(List<String> list) {
            Objects.requireNonNull(list);
            this.groups = list;
            return this;
        }

        public Builder groupsField(String str) {
            Objects.requireNonNull(str);
            this.groupsField = str;
            return this;
        }

        public Builder identityClaim(String str) {
            Objects.requireNonNull(str);
            this.identityClaim = str;
            return this;
        }

        public Builder operations(List<ModelOperation> list) {
            Objects.requireNonNull(list);
            this.operations = list;
            return this;
        }

        public Builder ownerField(String str) {
            Objects.requireNonNull(str);
            this.ownerField = str;
            return this;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuthRule.class != obj.getClass()) {
            return false;
        }
        AuthRule authRule = (AuthRule) obj;
        if (this.authStrategy == authRule.authStrategy && ObjectsCompat$Api19Impl.equals(this.ownerField, authRule.ownerField) && ObjectsCompat$Api19Impl.equals(this.identityClaim, authRule.identityClaim) && ObjectsCompat$Api19Impl.equals(this.groupsField, authRule.groupsField) && ObjectsCompat$Api19Impl.equals(this.groupClaim, authRule.groupClaim) && ObjectsCompat$Api19Impl.equals(this.groups, authRule.groups) && ObjectsCompat$Api19Impl.equals(this.operations, authRule.operations)) {
            return true;
        }
        return false;
    }

    public AuthStrategy.Provider getAuthProvider() {
        return this.authProvider;
    }

    public AuthStrategy getAuthStrategy() {
        return this.authStrategy;
    }

    public String getGroupClaimOrDefault() {
        if (Empty.check(this.groupClaim)) {
            return DEFAULT_GROUP_CLAIM;
        }
        return this.groupClaim;
    }

    public List<String> getGroups() {
        return Immutable.of(this.groups);
    }

    public String getGroupsFieldOrDefault() {
        if (Empty.check(this.groupsField)) {
            return DEFAULT_GROUPS_FIELD;
        }
        return this.groupsField;
    }

    public String getIdentityClaimOrDefault() {
        if (!Empty.check(this.identityClaim) && !"cognito:username".equals(this.identityClaim)) {
            return this.identityClaim;
        }
        return DEFAULT_IDENTITY_CLAIM;
    }

    public List<ModelOperation> getOperationsOrDefault() {
        List<ModelOperation> list;
        if (Empty.check(this.operations)) {
            list = Arrays.asList(ModelOperation.values());
        } else {
            list = this.operations;
        }
        return Immutable.of(list);
    }

    public String getOwnerFieldOrDefault() {
        if (Empty.check(this.ownerField)) {
            return DEFAULT_OWNER_FIELD;
        }
        return this.ownerField;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(this.authStrategy, this.ownerField, this.identityClaim, this.groupsField, this.groupClaim, this.groups, this.operations);
    }

    public String toString() {
        return "AuthRule{authStrategy=" + this.authStrategy + ", ownerField='" + this.ownerField + "', identityClaim='" + this.identityClaim + "', groupsField='" + this.groupsField + "', groupClaim='" + this.groupClaim + "', groups=" + this.groups + "', operations=" + this.operations + "'}";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AuthRule(com.amplifyframework.core.model.annotations.AuthRule r3) {
        /*
            r2 = this;
            com.amplifyframework.core.model.AuthRule$Builder r0 = builder()
            com.amplifyframework.core.model.AuthStrategy r1 = r3.allow()
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.authStrategy(r1)
            java.lang.String r1 = r3.provider()
            boolean r1 = com.amplifyframework.util.Empty.check(r1)
            if (r1 == 0) goto L1f
            com.amplifyframework.core.model.AuthStrategy r1 = r3.allow()
            com.amplifyframework.core.model.AuthStrategy$Provider r1 = r1.getDefaultAuthProvider()
            goto L27
        L1f:
            java.lang.String r1 = r3.provider()
            com.amplifyframework.core.model.AuthStrategy$Provider r1 = com.amplifyframework.core.model.AuthStrategy.Provider.from(r1)
        L27:
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.authProvider(r1)
            java.lang.String r1 = r3.ownerField()
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.ownerField(r1)
            java.lang.String r1 = r3.identityClaim()
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.identityClaim(r1)
            java.lang.String r1 = r3.groupClaim()
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.groupClaim(r1)
            java.lang.String[] r1 = r3.groups()
            java.util.List r1 = java.util.Arrays.asList(r1)
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.groups(r1)
            java.lang.String r1 = r3.groupsField()
            com.amplifyframework.core.model.AuthRule$Builder r0 = r0.groupsField(r1)
            com.amplifyframework.core.model.ModelOperation[] r3 = r3.operations()
            java.util.List r3 = java.util.Arrays.asList(r3)
            com.amplifyframework.core.model.AuthRule$Builder r3 = r0.operations(r3)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplifyframework.core.model.AuthRule.<init>(com.amplifyframework.core.model.annotations.AuthRule):void");
    }

    private AuthRule(Builder builder) {
        this.authStrategy = builder.authStrategy;
        this.authProvider = builder.authProvider;
        this.ownerField = builder.ownerField;
        this.identityClaim = builder.identityClaim;
        this.groupClaim = builder.groupClaim;
        this.groups = builder.groups;
        this.groupsField = builder.groupsField;
        this.operations = builder.operations;
    }
}
