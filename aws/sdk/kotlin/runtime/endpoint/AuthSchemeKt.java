package aws.sdk.kotlin.runtime.endpoint;

import aws.sdk.kotlin.runtime.endpoint.AuthScheme;
import aws.smithy.kotlin.runtime.client.endpoints.Endpoint;
import aws.smithy.kotlin.runtime.util.AttributeKey;
import java.util.Iterator;
import java.util.List;

/* compiled from: AuthScheme.kt */
/* loaded from: classes.dex */
public final class AuthSchemeKt {
    public static final AttributeKey<List<AuthScheme>> AuthSchemesAttributeKey = new AttributeKey<>("authSchemes");

    public static final AuthScheme.SigV4 getAuthScheme(Endpoint endpoint) {
        AuthScheme authScheme;
        Object obj;
        List list = (List) endpoint.attributes.getOrNull(AuthSchemesAttributeKey);
        if (list != null) {
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((AuthScheme) obj) instanceof AuthScheme.SigV4) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            authScheme = (AuthScheme) obj;
        } else {
            authScheme = null;
        }
        if (!(authScheme instanceof AuthScheme.SigV4)) {
            return null;
        }
        return (AuthScheme.SigV4) authScheme;
    }
}
