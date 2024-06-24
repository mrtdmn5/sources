package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class EncodedPayload {
    public final byte[] bytes;
    public final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding != null) {
            if (bArr != null) {
                this.encoding = encoding;
                this.bytes = bArr;
                return;
            }
            throw new NullPointerException("bytes is null");
        }
        throw new NullPointerException("encoding is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EncodedPayload)) {
            return false;
        }
        EncodedPayload encodedPayload = (EncodedPayload) obj;
        if (!this.encoding.equals(encodedPayload.encoding)) {
            return false;
        }
        return Arrays.equals(this.bytes, encodedPayload.bytes);
    }

    public final int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public final String toString() {
        return "EncodedPayload{encoding=" + this.encoding + ", bytes=[...]}";
    }
}
