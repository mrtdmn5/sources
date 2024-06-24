package com.amplifyframework.api.graphql;

import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.api.ApiException;
import com.amplifyframework.util.Immutable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
public final class GraphQLResponse<R> {
    private final R data;
    private final List<Error> errors;

    /* loaded from: classes.dex */
    public static final class Error {
        private final Map<String, Object> extensions;
        private final List<GraphQLLocation> locations;
        private final String message;
        private final List<GraphQLPathSegment> path;

        public Error(String str, List<GraphQLLocation> list, List<GraphQLPathSegment> list2, Map<String, Object> map) {
            Objects.requireNonNull(str);
            this.message = str;
            this.locations = list;
            this.path = list2;
            this.extensions = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Error.class != obj.getClass()) {
                return false;
            }
            Error error = (Error) obj;
            if (ObjectsCompat$Api19Impl.equals(this.message, error.message) && ObjectsCompat$Api19Impl.equals(this.locations, error.locations) && ObjectsCompat$Api19Impl.equals(this.path, error.path) && ObjectsCompat$Api19Impl.equals(this.extensions, error.extensions)) {
                return true;
            }
            return false;
        }

        public Map<String, Object> getExtensions() {
            return Immutable.of(this.extensions);
        }

        public List<GraphQLLocation> getLocations() {
            return Immutable.of(this.locations);
        }

        public String getMessage() {
            return this.message;
        }

        public List<GraphQLPathSegment> getPath() {
            return Immutable.of(this.path);
        }

        public int hashCode() {
            int r1;
            int r12;
            int hashCode = this.message.hashCode() * 31;
            List<GraphQLLocation> list = this.locations;
            int r2 = 0;
            if (list != null) {
                r1 = list.hashCode();
            } else {
                r1 = 0;
            }
            int r0 = (hashCode + r1) * 31;
            List<GraphQLPathSegment> list2 = this.path;
            if (list2 != null) {
                r12 = list2.hashCode();
            } else {
                r12 = 0;
            }
            int r02 = (r0 + r12) * 31;
            Map<String, Object> map = this.extensions;
            if (map != null) {
                r2 = map.hashCode();
            }
            return r02 + r2;
        }

        public String toString() {
            return "GraphQLResponse.Error{message='" + this.message + "', locations='" + this.locations + "', path='" + this.path + "', extensions='" + this.extensions + "'}";
        }
    }

    /* loaded from: classes.dex */
    public interface Factory {
        <R> GraphQLResponse<R> buildResponse(GraphQLRequest<R> graphQLRequest, String str) throws ApiException;
    }

    public GraphQLResponse(R r, List<Error> list) {
        this.data = r;
        ArrayList arrayList = new ArrayList();
        this.errors = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GraphQLResponse.class != obj.getClass()) {
            return false;
        }
        GraphQLResponse graphQLResponse = (GraphQLResponse) obj;
        if (!ObjectsCompat$Api19Impl.equals(this.data, graphQLResponse.data)) {
            return false;
        }
        return ObjectsCompat$Api19Impl.equals(this.errors, graphQLResponse.errors);
    }

    public R getData() {
        return this.data;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public boolean hasData() {
        if (this.data != null) {
            return true;
        }
        return false;
    }

    public boolean hasErrors() {
        if (this.errors.size() > 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int r0;
        R r = this.data;
        int r1 = 0;
        if (r != null) {
            r0 = r.hashCode();
        } else {
            r0 = 0;
        }
        int r02 = r0 * 31;
        List<Error> list = this.errors;
        if (list != null) {
            r1 = list.hashCode();
        }
        return r02 + r1;
    }

    public String toString() {
        return "GraphQLResponse{data='" + this.data + "', errors='" + this.errors + "'}";
    }
}
