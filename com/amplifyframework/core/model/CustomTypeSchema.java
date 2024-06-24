package com.amplifyframework.core.model;

import android.annotation.SuppressLint;
import androidx.core.util.ObjectsCompat$Api19Impl;
import aws.sdk.kotlin.runtime.config.profile.AwsProfile$$ExternalSyntheticOutline0;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class CustomTypeSchema {
    private final Map<String, CustomTypeField> fields;
    private final String name;
    private final String pluralName;

    /* loaded from: classes.dex */
    public static final class Builder {
        private final Map<String, CustomTypeField> fields = new TreeMap();
        private String name;
        private String pluralName;

        @SuppressLint({"SyntheticAccessor"})
        public CustomTypeSchema build() {
            Objects.requireNonNull(this.name);
            return new CustomTypeSchema(this);
        }

        public Builder fields(Map<String, CustomTypeField> map) {
            Objects.requireNonNull(map);
            this.fields.clear();
            this.fields.putAll(map);
            return this;
        }

        public Builder name(String str) {
            Objects.requireNonNull(str);
            this.name = str;
            return this;
        }

        public Builder pluralName(String str) {
            this.pluralName = str;
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
        if (obj == null || CustomTypeSchema.class != obj.getClass()) {
            return false;
        }
        CustomTypeSchema customTypeSchema = (CustomTypeSchema) obj;
        if (ObjectsCompat$Api19Impl.equals(getName(), customTypeSchema.getName()) && ObjectsCompat$Api19Impl.equals(getPluralName(), customTypeSchema.getPluralName()) && ObjectsCompat$Api19Impl.equals(getFields(), customTypeSchema.getFields())) {
            return true;
        }
        return false;
    }

    public Map<String, CustomTypeField> getFields() {
        return this.fields;
    }

    public String getName() {
        return this.name;
    }

    public String getPluralName() {
        return this.pluralName;
    }

    public int hashCode() {
        return ObjectsCompat$Api19Impl.hash(getName(), getPluralName(), getFields());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomTypeSchema{name='");
        sb.append(this.name);
        sb.append("', pluralName='");
        sb.append(this.pluralName);
        sb.append("', fields=");
        return AwsProfile$$ExternalSyntheticOutline0.m(sb, this.fields, '}');
    }

    private CustomTypeSchema(Builder builder) {
        this.name = builder.name;
        this.pluralName = builder.pluralName;
        this.fields = builder.fields;
    }
}
