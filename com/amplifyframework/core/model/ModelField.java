package com.amplifyframework.core.model;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ModelField {
    private final List<AuthRule> authRules;
    private final boolean isArray;
    private final boolean isCustomType;
    private final boolean isEnum;
    private final boolean isModel;
    private final boolean isReadOnly;
    private final boolean isRequired;
    private final Class<?> javaClassForValue;
    private final String name;
    private final String targetType;

    /* loaded from: classes.dex */
    public static class ModelFieldBuilder {
        private Class<?> javaClassForValue;
        private String name;
        private String targetType;
        private boolean isReadOnly = false;
        private boolean isRequired = false;
        private boolean isArray = false;
        private boolean isEnum = false;
        private boolean isModel = false;
        private boolean isCustomType = false;
        private List<AuthRule> authRules = new ArrayList();

        public ModelFieldBuilder authRules(List<AuthRule> list) {
            this.authRules = list;
            return this;
        }

        public ModelField build() {
            return new ModelField(this);
        }

        public ModelFieldBuilder isArray(boolean z) {
            this.isArray = z;
            return this;
        }

        public ModelFieldBuilder isCustomType(boolean z) {
            this.isCustomType = z;
            return this;
        }

        public ModelFieldBuilder isEnum(boolean z) {
            this.isEnum = z;
            return this;
        }

        public ModelFieldBuilder isModel(boolean z) {
            this.isModel = z;
            return this;
        }

        public ModelFieldBuilder isReadOnly(boolean z) {
            this.isReadOnly = z;
            return this;
        }

        public ModelFieldBuilder isRequired(boolean z) {
            this.isRequired = z;
            return this;
        }

        public ModelFieldBuilder javaClassForValue(Class<?> cls) {
            this.javaClassForValue = cls;
            return this;
        }

        public ModelFieldBuilder name(String str) {
            this.name = str;
            return this;
        }

        public ModelFieldBuilder targetType(String str) {
            this.targetType = str;
            return this;
        }
    }

    public static ModelFieldBuilder builder() {
        return new ModelFieldBuilder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ModelField.class != obj.getClass()) {
            return false;
        }
        ModelField modelField = (ModelField) obj;
        if (this.isReadOnly != modelField.isReadOnly || this.isRequired != modelField.isRequired || this.isArray != modelField.isArray || this.isEnum != modelField.isEnum || this.isModel != modelField.isModel || this.isCustomType != modelField.isCustomType || !ObjectsCompat$Api19Impl.equals(this.name, modelField.name) || !ObjectsCompat$Api19Impl.equals(this.javaClassForValue, modelField.javaClassForValue)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.targetType, modelField.targetType);
    }

    public List<AuthRule> getAuthRules() {
        return this.authRules;
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
        return ((((((((((((r03 + r1) * 31) + (this.isReadOnly ? 1 : 0)) * 31) + (this.isRequired ? 1 : 0)) * 31) + (this.isArray ? 1 : 0)) * 31) + (this.isEnum ? 1 : 0)) * 31) + (this.isModel ? 1 : 0)) * 31) + (this.isCustomType ? 1 : 0);
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

    public boolean isModel() {
        return this.isModel;
    }

    public boolean isReadOnly() {
        return this.isReadOnly;
    }

    public boolean isRequired() {
        return this.isRequired;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelField{name='");
        sb.append(this.name);
        sb.append("', javaClassForValue='");
        sb.append(this.javaClassForValue);
        sb.append("', targetType='");
        sb.append(this.targetType);
        sb.append("', isReadOnly=");
        sb.append(this.isReadOnly);
        sb.append(", isRequired=");
        sb.append(this.isRequired);
        sb.append(", isArray=");
        sb.append(this.isArray);
        sb.append(", isEnum=");
        sb.append(this.isEnum);
        sb.append(", isModel=");
        sb.append(this.isModel);
        sb.append(", isCustomType=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.isCustomType, '}');
    }

    private ModelField(ModelFieldBuilder modelFieldBuilder) {
        this.name = modelFieldBuilder.name;
        this.javaClassForValue = modelFieldBuilder.javaClassForValue;
        this.targetType = modelFieldBuilder.targetType;
        this.isReadOnly = modelFieldBuilder.isReadOnly;
        this.isRequired = modelFieldBuilder.isRequired;
        this.isArray = modelFieldBuilder.isArray;
        this.isEnum = modelFieldBuilder.isEnum;
        this.isModel = modelFieldBuilder.isModel;
        this.isCustomType = modelFieldBuilder.isCustomType;
        this.authRules = modelFieldBuilder.authRules;
    }
}
