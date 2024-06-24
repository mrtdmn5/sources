package com.google.firebase.installations.remote;

import com.google.firebase.installations.remote.TokenResult;

/* loaded from: classes3.dex */
public final class AutoValue_TokenResult extends TokenResult {
    public final TokenResult.ResponseCode responseCode;
    public final String token;
    public final long tokenExpirationTimestamp;

    public AutoValue_TokenResult(String str, long j, TokenResult.ResponseCode responseCode) {
        this.token = str;
        this.tokenExpirationTimestamp = j;
        this.responseCode = responseCode;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.token;
        if (str != null ? str.equals(tokenResult.getToken()) : tokenResult.getToken() == null) {
            if (this.tokenExpirationTimestamp == tokenResult.getTokenExpirationTimestamp()) {
                TokenResult.ResponseCode responseCode = this.responseCode;
                if (responseCode == null) {
                    if (tokenResult.getResponseCode() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.getResponseCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final TokenResult.ResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final String getToken() {
        return this.token;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    public final long getTokenExpirationTimestamp() {
        return this.tokenExpirationTimestamp;
    }

    public final int hashCode() {
        int hashCode;
        int r0 = 0;
        String str = this.token;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        long j = this.tokenExpirationTimestamp;
        int r1 = (((hashCode ^ 1000003) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003;
        TokenResult.ResponseCode responseCode = this.responseCode;
        if (responseCode != null) {
            r0 = responseCode.hashCode();
        }
        return r0 ^ r1;
    }

    public final String toString() {
        return "TokenResult{token=" + this.token + ", tokenExpirationTimestamp=" + this.tokenExpirationTimestamp + ", responseCode=" + this.responseCode + "}";
    }
}
