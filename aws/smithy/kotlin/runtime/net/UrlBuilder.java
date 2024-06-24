package aws.smithy.kotlin.runtime.net;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.net.Host;
import aws.smithy.kotlin.runtime.util.CanDeepCopy;
import aws.smithy.kotlin.runtime.util.ValuesMapKt;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Url.kt */
/* loaded from: classes.dex */
public final class UrlBuilder implements CanDeepCopy<UrlBuilder> {
    public boolean forceQuery;
    public String fragment;
    public Host host;
    public QueryParametersBuilder parameters;
    public String path;
    public Integer port;
    public Scheme scheme;
    public UserInfo userInfo;

    public UrlBuilder() {
        Scheme scheme = Scheme.HTTPS;
        this.scheme = Scheme.HTTPS;
        this.host = new Host.Domain("");
        this.path = "";
        this.parameters = new QueryParametersBuilder();
    }

    public final Url build() {
        int r0;
        QueryParameters queryParametersImpl;
        Scheme scheme = this.scheme;
        Host host = this.host;
        Integer num = this.port;
        if (num != null) {
            r0 = num.intValue();
        } else {
            r0 = scheme.defaultPort;
        }
        int r3 = r0;
        String str = this.path;
        if (this.parameters.values.isEmpty()) {
            QueryParameters.Companion.getClass();
            queryParametersImpl = EmptyQueryParameters.INSTANCE;
        } else {
            queryParametersImpl = new QueryParametersImpl(this.parameters.values);
        }
        return new Url(scheme, host, r3, str, queryParametersImpl, this.fragment, this.userInfo, this.forceQuery, 256);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UrlBuilder(scheme=");
        sb.append(this.scheme);
        sb.append(", host='");
        sb.append(this.host);
        sb.append("', port=");
        sb.append(this.port);
        sb.append(", path='");
        sb.append(this.path);
        sb.append("', parameters=");
        sb.append(this.parameters);
        sb.append(", fragment=");
        sb.append(this.fragment);
        sb.append(", userInfo=");
        sb.append(this.userInfo);
        sb.append(", forceQuery=");
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.forceQuery, ')');
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // aws.smithy.kotlin.runtime.util.CanDeepCopy
    public final UrlBuilder deepCopy() {
        UserInfo userInfo;
        UrlBuilder urlBuilder = new UrlBuilder();
        urlBuilder.scheme = this.scheme;
        urlBuilder.host = this.host;
        urlBuilder.port = this.port;
        urlBuilder.path = this.path;
        LinkedHashMap deepCopy = ValuesMapKt.deepCopy(this.parameters.values);
        QueryParametersBuilder queryParametersBuilder = new QueryParametersBuilder();
        queryParametersBuilder.values.putAll(deepCopy);
        urlBuilder.parameters = queryParametersBuilder;
        urlBuilder.fragment = this.fragment;
        UserInfo userInfo2 = this.userInfo;
        if (userInfo2 != null) {
            String username = userInfo2.username;
            Intrinsics.checkNotNullParameter(username, "username");
            String password = userInfo2.password;
            Intrinsics.checkNotNullParameter(password, "password");
            userInfo = new UserInfo(username, password);
        } else {
            userInfo = null;
        }
        urlBuilder.userInfo = userInfo;
        urlBuilder.forceQuery = this.forceQuery;
        return urlBuilder;
    }
}
