package com.amplifyframework.core.model;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.Objects;

/* loaded from: classes.dex */
public final class ModelAssociation {
    private final String associatedName;
    private final String associatedType;
    private final String name;
    private final String targetName;
    private final String[] targetNames;

    /* loaded from: classes.dex */
    public static final class Builder {
        private String associatedName;
        private String associatedType;
        private String name;
        private String targetName;
        private String[] targetNames;

        public Builder associatedName(String str) {
            this.associatedName = str;
            return this;
        }

        public Builder associatedType(String str) {
            this.associatedType = str;
            return this;
        }

        public ModelAssociation build() {
            return new ModelAssociation(this);
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder targetName(String str) {
            this.targetName = str;
            return this;
        }

        public Builder targetNames(String[] strArr) {
            this.targetNames = strArr;
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
        if (obj == null || ModelAssociation.class != obj.getClass()) {
            return false;
        }
        ModelAssociation modelAssociation = (ModelAssociation) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.name, modelAssociation.name) || !ObjectsCompat$Api19Impl.equals(this.targetName, modelAssociation.targetName) || !ObjectsCompat$Api19Impl.equals(this.associatedName, modelAssociation.associatedName)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.associatedType, modelAssociation.associatedType);
    }

    public String getAssociatedName() {
        return this.associatedName;
    }

    public String getAssociatedType() {
        return this.associatedType;
    }

    public String getName() {
        return this.name;
    }

    public String getTargetName() {
        return this.targetName;
    }

    public String[] getTargetNames() {
        return this.targetNames;
    }

    public int hashCode() {
        int r1;
        int r12;
        int hashCode = this.name.hashCode() * 31;
        String str = this.targetName;
        int r2 = 0;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r0 = (hashCode + r1) * 31;
        String str2 = this.associatedName;
        if (str2 != null) {
            r12 = str2.hashCode();
        } else {
            r12 = 0;
        }
        int r02 = (r0 + r12) * 31;
        String str3 = this.associatedType;
        if (str3 != null) {
            r2 = str3.hashCode();
        }
        return r02 + r2;
    }

    public boolean isOwner() {
        return "BelongsTo".equals(getName());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelAssociation{name='");
        sb.append(this.name);
        sb.append("', targetName='");
        sb.append(this.targetName);
        sb.append("', associatedName='");
        sb.append(this.associatedName);
        sb.append("', associatedType='");
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, this.associatedType, "'}");
    }

    private ModelAssociation(Builder builder) {
        String str = builder.name;
        Objects.requireNonNull(str);
        this.name = str;
        this.targetName = builder.targetName;
        this.targetNames = builder.targetNames;
        this.associatedName = builder.associatedName;
        this.associatedType = builder.associatedType;
    }
}
