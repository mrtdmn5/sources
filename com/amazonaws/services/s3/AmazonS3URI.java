package com.amazonaws.services.s3;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class AmazonS3URI {
    private static final Pattern ENDPOINT_PATTERN = Pattern.compile("^(.+\\.)?s3[.-]([a-z0-9-]+)\\.");
    private static final Pattern VERSION_ID_PATTERN = Pattern.compile("[&;]");
    private final String bucket;
    private final boolean isPathStyle;
    private final String key;
    private final String region;
    private final URI uri;
    private final String versionId;

    public AmazonS3URI(String str) {
        this(str, true);
    }

    private static void appendDecoded(StringBuilder sb, String str, int r3) {
        if (r3 <= str.length() - 3) {
            char charAt = str.charAt(r3 + 1);
            sb.append((char) (fromHex(str.charAt(r3 + 2)) | (fromHex(charAt) << 4)));
            return;
        }
        throw new IllegalStateException(zzav$$ExternalSyntheticOutline0.m("Invalid percent-encoded string:\"", str, "\"."));
    }

    private static String decode(String str) {
        if (str == null) {
            return null;
        }
        for (int r0 = 0; r0 < str.length(); r0++) {
            if (str.charAt(r0) == '%') {
                return decode(str, r0);
            }
        }
        return str;
    }

    private static int fromHex(char c) {
        if (c >= '0') {
            if (c <= '9') {
                return c - '0';
            }
            char c2 = 'A';
            if (c >= 'A') {
                if (c > 'F') {
                    c2 = 'a';
                    if (c >= 'a') {
                        if (c > 'f') {
                            throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
                        }
                    } else {
                        throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
                    }
                }
                return (c - c2) + 10;
            }
            throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
        }
        throw new IllegalStateException("Invalid percent-encoded string: bad character '" + c + "' in escape sequence.");
    }

    private static String parseVersionId(String str) {
        if (str != null) {
            for (String str2 : VERSION_ID_PATTERN.split(str)) {
                if (str2.startsWith("versionId=")) {
                    return decode(str2.substring(10));
                }
            }
            return null;
        }
        return null;
    }

    private static String preprocessUrlStr(String str, boolean z) {
        if (z) {
            try {
                return URLEncoder.encode(str, Constants.DEFAULT_ENCODING).replace("%3A", ":").replace("%2F", "/").replace("+", " ");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AmazonS3URI amazonS3URI = (AmazonS3URI) obj;
        if (this.isPathStyle != amazonS3URI.isPathStyle || !this.uri.equals(amazonS3URI.uri)) {
            return false;
        }
        String str = this.bucket;
        if (str == null ? amazonS3URI.bucket != null : !str.equals(amazonS3URI.bucket)) {
            return false;
        }
        String str2 = this.key;
        if (str2 == null ? amazonS3URI.key != null : !str2.equals(amazonS3URI.key)) {
            return false;
        }
        String str3 = this.versionId;
        if (str3 == null ? amazonS3URI.versionId != null : !str3.equals(amazonS3URI.versionId)) {
            return false;
        }
        String str4 = this.region;
        String str5 = amazonS3URI.region;
        if (str4 != null) {
            return str4.equals(str5);
        }
        if (str5 == null) {
            return true;
        }
        return false;
    }

    public String getBucket() {
        return this.bucket;
    }

    public String getKey() {
        return this.key;
    }

    public String getRegion() {
        return this.region;
    }

    public URI getURI() {
        return this.uri;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public int hashCode() {
        int r1;
        int r12;
        int r13;
        int hashCode = ((this.uri.hashCode() * 31) + (this.isPathStyle ? 1 : 0)) * 31;
        String str = this.bucket;
        int r2 = 0;
        if (str != null) {
            r1 = str.hashCode();
        } else {
            r1 = 0;
        }
        int r0 = (hashCode + r1) * 31;
        String str2 = this.key;
        if (str2 != null) {
            r12 = str2.hashCode();
        } else {
            r12 = 0;
        }
        int r02 = (r0 + r12) * 31;
        String str3 = this.versionId;
        if (str3 != null) {
            r13 = str3.hashCode();
        } else {
            r13 = 0;
        }
        int r03 = (r02 + r13) * 31;
        String str4 = this.region;
        if (str4 != null) {
            r2 = str4.hashCode();
        }
        return r03 + r2;
    }

    public boolean isPathStyle() {
        return this.isPathStyle;
    }

    public String toString() {
        return this.uri.toString();
    }

    public AmazonS3URI(String str, boolean z) {
        this(URI.create(preprocessUrlStr(str, z)), z);
    }

    public AmazonS3URI(URI r2) {
        this(r2, false);
    }

    private AmazonS3URI(URI r8, boolean z) {
        if (r8 != null) {
            this.uri = r8;
            if ("s3".equalsIgnoreCase(r8.getScheme())) {
                this.region = null;
                this.versionId = null;
                this.isPathStyle = false;
                String authority = r8.getAuthority();
                this.bucket = authority;
                if (authority != null) {
                    if (r8.getPath().length() <= 1) {
                        this.key = null;
                        return;
                    } else {
                        this.key = r8.getPath().substring(1);
                        return;
                    }
                }
                throw new IllegalArgumentException("Invalid S3 URI: no bucket: " + r8);
            }
            String host = r8.getHost();
            if (host != null) {
                Matcher matcher = ENDPOINT_PATTERN.matcher(host);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    if (group != null && !group.isEmpty()) {
                        this.isPathStyle = false;
                        this.bucket = group.substring(0, group.length() - 1);
                        String path = r8.getPath();
                        if (path != null && !path.isEmpty() && !"/".equals(r8.getPath())) {
                            this.key = r8.getPath().substring(1);
                        } else {
                            this.key = null;
                        }
                    } else {
                        this.isPathStyle = true;
                        String path2 = z ? r8.getPath() : r8.getRawPath();
                        if ("/".equals(path2)) {
                            this.bucket = null;
                            this.key = null;
                        } else {
                            int indexOf = path2.indexOf(47, 1);
                            if (indexOf == -1) {
                                this.bucket = decode(path2.substring(1));
                                this.key = null;
                            } else if (indexOf == path2.length() - 1) {
                                this.bucket = decode(path2.substring(1, indexOf));
                                this.key = null;
                            } else {
                                this.bucket = decode(path2.substring(1, indexOf));
                                this.key = decode(path2.substring(indexOf + 1));
                            }
                        }
                    }
                    this.versionId = parseVersionId(r8.getRawQuery());
                    if ("amazonaws".equals(matcher.group(2))) {
                        this.region = null;
                        return;
                    } else {
                        this.region = matcher.group(2);
                        return;
                    }
                }
                throw new IllegalArgumentException("Invalid S3 URI: hostname does not appear to be a valid S3 endpoint: " + r8);
            }
            throw new IllegalArgumentException("Invalid S3 URI: no hostname: " + r8);
        }
        throw new IllegalArgumentException("uri cannot be null");
    }

    private static String decode(String str, int r4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, r4));
        appendDecoded(sb, str, r4);
        int r42 = r4 + 3;
        while (r42 < str.length()) {
            if (str.charAt(r42) == '%') {
                appendDecoded(sb, str, r42);
                r42 += 2;
            } else {
                sb.append(str.charAt(r42));
            }
            r42++;
        }
        return sb.toString();
    }
}
