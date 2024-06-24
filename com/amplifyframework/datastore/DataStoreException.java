package com.amplifyframework.datastore;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.AmplifyException;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.util.Immutable;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class DataStoreException extends AmplifyException {
    private static final long serialVersionUID = 1;

    /* loaded from: classes.dex */
    public static final class GraphQLResponseException extends DataStoreException {
        private static final long serialVersionUID = 1;
        private final List<GraphQLResponse.Error> errors;

        public GraphQLResponseException(String str, List<GraphQLResponse.Error> list) {
            super(str, "See attached list of GraphQLResponse.Error objects.");
            Objects.requireNonNull(list);
            this.errors = list;
        }

        @Override // com.amplifyframework.AmplifyException
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || GraphQLResponseException.class != obj.getClass() || !super.equals(obj)) {
                return false;
            }
            return ObjectsCompat$Api19Impl.equals(this.errors, ((GraphQLResponseException) obj).errors);
        }

        public List<GraphQLResponse.Error> getErrors() {
            return Immutable.of(this.errors);
        }

        @Override // com.amplifyframework.AmplifyException
        public int hashCode() {
            return ObjectsCompat$Api19Impl.hash(Integer.valueOf(super.hashCode()), this.errors);
        }

        @Override // com.amplifyframework.AmplifyException, java.lang.Throwable
        public String toString() {
            return "GraphQLResponseException{message=" + getMessage() + ", errors=" + this.errors + ", recoverySuggestion=" + getRecoverySuggestion() + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class IrRecoverableException extends DataStoreException {
        private static final long serialVersionUID = 1;

        public IrRecoverableException(String str, String str2) {
            super(str, str2);
        }
    }

    public DataStoreException(String str, Throwable th, String str2) {
        super(str, th, str2);
    }

    public DataStoreException(String str, String str2) {
        super(str, str2);
    }
}
