package com.amazonaws.auth;

import com.amazonaws.ClientConfiguration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SessionCredentialsProviderFactory {
    private static final Map<Key, STSSessionCredentialsProvider> cache = new HashMap();

    /* loaded from: classes.dex */
    public static final class Key {
        private final String awsAccessKeyId;
        private final String serviceEndpoint;

        public Key(String str, String str2) {
            this.awsAccessKeyId = str;
            this.serviceEndpoint = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Key.class != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            String str = this.awsAccessKeyId;
            if (str == null) {
                if (key.awsAccessKeyId != null) {
                    return false;
                }
            } else if (!str.equals(key.awsAccessKeyId)) {
                return false;
            }
            String str2 = this.serviceEndpoint;
            if (str2 == null) {
                if (key.serviceEndpoint != null) {
                    return false;
                }
            } else if (!str2.equals(key.serviceEndpoint)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            String str = this.awsAccessKeyId;
            int r1 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int r0 = (hashCode + 31) * 31;
            String str2 = this.serviceEndpoint;
            if (str2 != null) {
                r1 = str2.hashCode();
            }
            return r0 + r1;
        }
    }

    public static synchronized STSSessionCredentialsProvider getSessionCredentialsProvider(AWSCredentials aWSCredentials, String str, ClientConfiguration clientConfiguration) {
        STSSessionCredentialsProvider sTSSessionCredentialsProvider;
        synchronized (SessionCredentialsProviderFactory.class) {
            Key key = new Key(aWSCredentials.getAWSAccessKeyId(), str);
            Map<Key, STSSessionCredentialsProvider> map = cache;
            if (!map.containsKey(key)) {
                map.put(key, new STSSessionCredentialsProvider(aWSCredentials, clientConfiguration));
            }
            sTSSessionCredentialsProvider = map.get(key);
        }
        return sTSSessionCredentialsProvider;
    }
}
