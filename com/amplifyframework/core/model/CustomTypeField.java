package com.amplifyframework.core.model;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;

/* loaded from: classes.dex */
public final class CustomTypeField {
    private final boolean isArray;
    private final boolean isCustomType;
    private final boolean isEnum;
    private final boolean isRequired;
    private final Class<?> javaClassForValue;
    private final String name;
    private final String targetType;

    /* loaded from: classes.dex */
    public static class CustomTypeFieldBuilder {
        private Class<?> javaClassForValue;
        private String name;
        private String targetType;
        private boolean isRequired = false;
        private boolean isArray = false;
        private boolean isEnum = false;
        private boolean isCustomType = false;

        public CustomTypeField build() {
            return new CustomTypeField(this);
        }

        public CustomTypeFieldBuilder isArray(boolean z) {
            this.isArray = z;
            return this;
        }

        public CustomTypeFieldBuilder isCustomType(boolean z) {
            this.isCustomType = z;
            return this;
        }

        public CustomTypeFieldBuilder isEnum(boolean z) {
            this.isEnum = z;
            return this;
        }

        public CustomTypeFieldBuilder isRequired(boolean z) {
            this.isRequired = z;
            return this;
        }

        public CustomTypeFieldBuilder javaClassForValue(Class<?> cls) {
            this.javaClassForValue = cls;
            return this;
        }

        public CustomTypeFieldBuilder name(String str) {
            this.name = str;
            return this;
        }

        public CustomTypeFieldBuilder targetType(String str) {
            this.targetType = str;
            return this;
        }
    }

    public static CustomTypeFieldBuilder builder() {
        return new CustomTypeFieldBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CustomTypeField.class != obj.getClass()) {
            return false;
        }
        CustomTypeField customTypeField = (CustomTypeField) obj;
        if (this.isRequired != customTypeField.isRequired || this.isArray != customTypeField.isArray || this.isEnum != customTypeField.isEnum || this.isCustomType != customTypeField.isCustomType || !ObjectsCompat$Api19Impl.equals(this.name, customTypeField.name) || !ObjectsCompat$Api19Impl.equals(this.javaClassForValue, customTypeField.javaClassForValue)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.targetType, customTypeField.targetType);
    }

    public Class<?> getJavaClassForValue() {
        return this.javaClassForValue;
    }

    public String getName() {
        return this.name;
    }

    public String getTargetType() {
        return this.targetType;
    }

    public int hashCode() {
        int r0;
        int r2;
        String str = this.name;
        int r1 = 0;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        Class<?> cls = this.javaClassForValue;
        if (cls != null) {
            r2 = cls.hashCode();
        } else {
            r2 = 0;
        }
        int r03 = (r02 + r2) * 31;
        String str2 = this.targetType;
        if (str2 != null) {
            r1 = str2.hashCode();
        }
        return ((((((((r03 + r1) * 31) + (this.isRequired ? 1 : 0)) * 31) + (this.isArray ? 1 : 0)) * 31) + (this.isEnum ? 1 : 0)) * 31) + (this.isCustomType ? 1 : 0);
    }

    public boolean isArray() {
        return this.isArray;
    }

    public boolean isCustomType() {
        return this.isCustomType;
    }

    public boolean isEnum() {
        return this.isEnum;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CustomTypeField{name='");
        sb.append(this.name);
        sb.append("', javaClassForValue='");
        sb.append(this.javaClassForValue);
        sb.append("', targetType='");
        sb.append(this.targetType);
        sb.append("', isRequired=");
        sb.append(this.isRequired);
        sb.append(", isArray=");
        sb.append(this.isArray);
        sb.append(", isEnum=");
        sb.append(this.isEnum);
        sb.append(", isCustomType=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isCustomType, '}');
    }

    private CustomTypeField(CustomTypeFieldBuilder customTypeFieldBuilder) {
        this.name = customTypeFieldBuilder.name;
        this.javaClassForValue = customTypeFieldBuilder.javaClassForValue;
        this.targetType = customTypeFieldBuilder.targetType;
        this.isRequired = customTypeFieldBuilder.isRequired;
        this.isArray = customTypeFieldBuilder.isArray;
        this.isEnum = customTypeFieldBuilder.isEnum;
        this.isCustomType = customTypeFieldBuilder.isCustomType;
    }
}
