package com.amplifyframework.core.model;

import androidx.compose.ui.text.intl.LocaleList$$ExternalSyntheticOutline0;
import androidx.core.util.ObjectsCompat$Api19Impl;
import java.util.List;

/* loaded from: classes.dex */
public final class ModelIndex {
    private final List<String> indexFieldNames;
    private final String indexName;

    /* loaded from: classes.dex */
    public static final class Builder {
        private List<String> indexFieldNames;
        private String indexName;

        public ModelIndex build() {
            return new ModelIndex(this.indexName, this.indexFieldNames);
        }

        public Builder indexFieldNames(List<String> list) {
            this.indexFieldNames = list;
            return this;
        }

        public Builder indexName(String str) {
            this.indexName = str;
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
        if (obj == null || ModelIndex.class != obj.getClass()) {
            return false;
        }
        ModelIndex modelIndex = (ModelIndex) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.indexName, modelIndex.indexName)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.indexFieldNames, modelIndex.indexFieldNames);
    }

    public List<String> getIndexFieldNames() {
        return this.indexFieldNames;
    }

    public String getIndexName() {
        return this.indexName;
    }

    public int hashCode() {
        int r0;
        String str = this.indexName;
        int r1 = 0;
        if (str != null) {
            r0 = str.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        List<String> list = this.indexFieldNames;
        if (list != null) {
            r1 = list.hashCode();
        }
        return r02 + r1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelIndex{indexName='");
        sb.append(this.indexName);
        sb.append("', indexFieldNames=");
        return LocaleList$$ExternalSyntheticOutline0.m(sb, this.indexFieldNames, '}');
    }

    private ModelIndex(String str, List<String> list) {
        this.indexName = str;
        this.indexFieldNames = list;
    }
}
