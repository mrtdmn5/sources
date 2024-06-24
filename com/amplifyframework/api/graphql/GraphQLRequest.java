package com.amplifyframework.api.graphql;

import android.text.TextUtils;
import androidx.core.util.ObjectsCompat$Api19Impl;
import com.amplifyframework.core.model.ModelIdentifier;
import com.amplifyframework.util.Wrap;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class GraphQLRequest<R> {
    private final Type responseType;
    private final VariablesSerializer variablesSerializer;

    /* loaded from: classes.dex */
    public interface VariablesSerializer {
        String serialize(Map<String, Object> map);
    }

    public GraphQLRequest(Type type, VariablesSerializer variablesSerializer) {
        this.responseType = type;
        this.variablesSerializer = variablesSerializer;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GraphQLRequest graphQLRequest = (GraphQLRequest) obj;
        if (ObjectsCompat$Api19Impl.equals(this.responseType, graphQLRequest.responseType) && ObjectsCompat$Api19Impl.equals(this.variablesSerializer, graphQLRequest.variablesSerializer)) {
            return true;
        }
        return false;
    }

    public String getContent() {
        String serialize;
        String replace = getQuery().replace(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR, "\\\"").replace("\n", "\\n");
        if (getVariables().isEmpty()) {
            serialize = null;
        } else {
            serialize = this.variablesSerializer.serialize(getVariables());
        }
        return Wrap.inBraces(TextUtils.join(", ", Arrays.asList(Wrap.inDoubleQuotes("query") + ": " + Wrap.inDoubleQuotes(replace), Wrap.inDoubleQuotes("variables") + ": " + serialize)));
    }

    public abstract String getQuery();

    public Type getResponseType() {
        return this.responseType;
    }

    public abstract Map<String, Object> getVariables();

    public VariablesSerializer getVariablesSerializer() {
        return this.variablesSerializer;
    }

    public int hashCode() {
        int r1;
        int hashCode = this.responseType.hashCode() * 31;
        VariablesSerializer variablesSerializer = this.variablesSerializer;
        if (variablesSerializer != null) {
            r1 = variablesSerializer.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }

    public String toString() {
        return "GraphQLRequest{, responseType='" + this.responseType + "', variablesSerializer='" + this.variablesSerializer + "'}";
    }
}
