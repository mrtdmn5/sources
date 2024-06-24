package com.amplifyframework.statemachine.codegen.data;

import androidx.compose.runtime.OpaqueKey$$ExternalSyntheticOutline0;
import androidx.room.util.TableInfo$ForeignKey$$ExternalSyntheticOutline0;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: OauthConfiguration.kt */
/* loaded from: classes.dex */
public final class OauthConfiguration {
    public static final Companion Companion = new Companion(null);
    private final String appClient;
    private final String appSecret;
    private final String domain;
    private final Set<String> scopes;
    private final String signInRedirectURI;
    private final String signOutRedirectURI;

    /* compiled from: OauthConfiguration.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OauthConfiguration fromJson(JSONObject jSONObject) {
            boolean z;
            String str;
            boolean z2;
            String str2;
            boolean z3;
            String str3;
            LinkedHashSet linkedHashSet;
            boolean z4;
            String str4;
            String str5;
            if (jSONObject != null) {
                String optString = jSONObject.optString("AppClientId");
                boolean z5 = false;
                if (optString != null && optString.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    str = optString;
                } else {
                    str = null;
                }
                String optString2 = jSONObject.optString("AppClientSecret", null);
                if (optString2 != null && optString2.length() != 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    str2 = optString2;
                } else {
                    str2 = null;
                }
                String optString3 = jSONObject.optString("WebDomain");
                if (optString3 != null && optString3.length() != 0) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (!z3) {
                    str3 = optString3;
                } else {
                    str3 = null;
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("Scopes");
                if (optJSONArray != null) {
                    LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                    int length = optJSONArray.length();
                    if (length >= 0) {
                        int r9 = 0;
                        while (true) {
                            String optString4 = optJSONArray.optString(r9);
                            if (optString4 != null) {
                                linkedHashSet2.add(optString4);
                            }
                            if (r9 == length) {
                                break;
                            }
                            r9++;
                        }
                    }
                    linkedHashSet = linkedHashSet2;
                } else {
                    linkedHashSet = null;
                }
                String optString5 = jSONObject.optString("SignInRedirectURI");
                if (optString5 != null && optString5.length() != 0) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (!z4) {
                    str4 = optString5;
                } else {
                    str4 = null;
                }
                String optString6 = jSONObject.optString("SignOutRedirectURI");
                if (optString6 == null || optString6.length() == 0) {
                    z5 = true;
                }
                if (!z5) {
                    str5 = optString6;
                } else {
                    str5 = null;
                }
                if (str != null && str3 != null && linkedHashSet != null && str4 != null && str5 != null) {
                    return new OauthConfiguration(str, str2, str3, linkedHashSet, str4, str5);
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    public OauthConfiguration(String appClient, String str, String domain, Set<String> scopes, String signInRedirectURI, String signOutRedirectURI) {
        Intrinsics.checkNotNullParameter(appClient, "appClient");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(signInRedirectURI, "signInRedirectURI");
        Intrinsics.checkNotNullParameter(signOutRedirectURI, "signOutRedirectURI");
        this.appClient = appClient;
        this.appSecret = str;
        this.domain = domain;
        this.scopes = scopes;
        this.signInRedirectURI = signInRedirectURI;
        this.signOutRedirectURI = signOutRedirectURI;
    }

    public static /* synthetic */ OauthConfiguration copy$default(OauthConfiguration oauthConfiguration, String str, String str2, String str3, Set set, String str4, String str5, int r11, Object obj) {
        if ((r11 & 1) != 0) {
            str = oauthConfiguration.appClient;
        }
        if ((r11 & 2) != 0) {
            str2 = oauthConfiguration.appSecret;
        }
        String str6 = str2;
        if ((r11 & 4) != 0) {
            str3 = oauthConfiguration.domain;
        }
        String str7 = str3;
        if ((r11 & 8) != 0) {
            set = oauthConfiguration.scopes;
        }
        Set set2 = set;
        if ((r11 & 16) != 0) {
            str4 = oauthConfiguration.signInRedirectURI;
        }
        String str8 = str4;
        if ((r11 & 32) != 0) {
            str5 = oauthConfiguration.signOutRedirectURI;
        }
        return oauthConfiguration.copy(str, str6, str7, set2, str8, str5);
    }

    public final String component1() {
        return this.appClient;
    }

    public final String component2() {
        return this.appSecret;
    }

    public final String component3() {
        return this.domain;
    }

    public final Set<String> component4() {
        return this.scopes;
    }

    public final String component5() {
        return this.signInRedirectURI;
    }

    public final String component6() {
        return this.signOutRedirectURI;
    }

    public final OauthConfiguration copy(String appClient, String str, String domain, Set<String> scopes, String signInRedirectURI, String signOutRedirectURI) {
        Intrinsics.checkNotNullParameter(appClient, "appClient");
        Intrinsics.checkNotNullParameter(domain, "domain");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(signInRedirectURI, "signInRedirectURI");
        Intrinsics.checkNotNullParameter(signOutRedirectURI, "signOutRedirectURI");
        return new OauthConfiguration(appClient, str, domain, scopes, signInRedirectURI, signOutRedirectURI);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OauthConfiguration)) {
            return false;
        }
        OauthConfiguration oauthConfiguration = (OauthConfiguration) obj;
        if (Intrinsics.areEqual(this.appClient, oauthConfiguration.appClient) && Intrinsics.areEqual(this.appSecret, oauthConfiguration.appSecret) && Intrinsics.areEqual(this.domain, oauthConfiguration.domain) && Intrinsics.areEqual(this.scopes, oauthConfiguration.scopes) && Intrinsics.areEqual(this.signInRedirectURI, oauthConfiguration.signInRedirectURI) && Intrinsics.areEqual(this.signOutRedirectURI, oauthConfiguration.signOutRedirectURI)) {
            return true;
        }
        return false;
    }

    public final String getAppClient() {
        return this.appClient;
    }

    public final String getAppSecret() {
        return this.appSecret;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final Set<String> getScopes() {
        return this.scopes;
    }

    public final String getSignInRedirectURI() {
        return this.signInRedirectURI;
    }

    public final String getSignOutRedirectURI() {
        return this.signOutRedirectURI;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.appClient.hashCode() * 31;
        String str = this.appSecret;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.signOutRedirectURI.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.signInRedirectURI, (this.scopes.hashCode() + TableInfo$ForeignKey$$ExternalSyntheticOutline0.m(this.domain, (hashCode2 + hashCode) * 31, 31)) * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("OauthConfiguration(appClient=");
        sb.append(this.appClient);
        sb.append(", appSecret=");
        sb.append(this.appSecret);
        sb.append(", domain=");
        sb.append(this.domain);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", signInRedirectURI=");
        sb.append(this.signInRedirectURI);
        sb.append(", signOutRedirectURI=");
        return OpaqueKey$$ExternalSyntheticOutline0.m(sb, this.signOutRedirectURI, ')');
    }
}
