package androidx.core.provider;

import android.util.Base64;
import com.amplifyframework.core.model.ModelIdentifier;
import java.util.List;

/* loaded from: classes.dex */
public final class FontRequest {
    public final List<List<byte[]>> mCertificates;
    public final String mIdentifier;
    public final String mProviderAuthority;
    public final String mProviderPackage;
    public final String mQuery;

    public FontRequest(String str, String str2, String str3, List<List<byte[]>> list) {
        str.getClass();
        this.mProviderAuthority = str;
        str2.getClass();
        this.mProviderPackage = str2;
        this.mQuery = str3;
        list.getClass();
        this.mCertificates = list;
        this.mIdentifier = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r2 = 0;
        while (true) {
            List<List<byte[]>> list = this.mCertificates;
            if (r2 < list.size()) {
                sb.append(" [");
                List<byte[]> list2 = list.get(r2);
                for (int r4 = 0; r4 < list2.size(); r4++) {
                    sb.append(" \"");
                    sb.append(Base64.encodeToString(list2.get(r4), 0));
                    sb.append(ModelIdentifier.Helper.PRIMARY_KEY_ENCAPSULATE_CHAR);
                }
                sb.append(" ]");
                r2++;
            } else {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
        }
    }
}
