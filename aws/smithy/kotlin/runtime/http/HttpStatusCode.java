package aws.smithy.kotlin.runtime.http;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.account.HttpUtilsKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes.dex */
public final class HttpStatusCode {
    public static final HttpStatusCode Forbidden;
    public static final HttpStatusCode NotFound;
    public static final HttpStatusCode OK;
    public static final HttpStatusCode Unauthorized;
    public static final Map<Integer, HttpStatusCode> byValue;
    public final String description;
    public final int value;

    /* compiled from: HttpStatusCode.kt */
    /* loaded from: classes.dex */
    public enum Category implements Comparable<Category>, ClosedRange<Integer> {
        INFORMATION(new IntRange(100, 199)),
        SUCCESS(new IntRange(200, 299)),
        REDIRECT(new IntRange(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 399)),
        CLIENT_ERROR(new IntRange(400, 499)),
        SERVER_ERROR(new IntRange(500, 599));

        public static final Companion Companion = new Companion();
        private final IntRange range;

        /* compiled from: HttpStatusCode.kt */
        /* loaded from: classes.dex */
        public static final class Companion {
        }

        Category(IntRange intRange) {
            this.range = intRange;
        }

        public boolean contains(int r2) {
            return this.range.contains(r2);
        }

        @Override // kotlin.ranges.ClosedRange
        public Integer getEndInclusive() {
            return this.range.getEndInclusive();
        }

        @Override // kotlin.ranges.ClosedRange
        public Integer getStart() {
            return this.range.getStart();
        }

        @Override // kotlin.ranges.ClosedRange
        public boolean isEmpty() {
            return this.range.isEmpty();
        }

        @Override // kotlin.ranges.ClosedRange
        public /* bridge */ /* synthetic */ boolean contains(Integer num) {
            return contains(num.intValue());
        }
    }

    static {
        HttpStatusCode httpStatusCode = new HttpStatusCode(100, "Continue");
        HttpStatusCode httpStatusCode2 = new HttpStatusCode(101, "Switching Protocols");
        HttpStatusCode httpStatusCode3 = new HttpStatusCode(102, "Processing");
        HttpStatusCode httpStatusCode4 = new HttpStatusCode(200, "OK");
        OK = httpStatusCode4;
        HttpStatusCode httpStatusCode5 = new HttpStatusCode(201, "Created");
        HttpStatusCode httpStatusCode6 = new HttpStatusCode(202, "Accepted");
        HttpStatusCode httpStatusCode7 = new HttpStatusCode(203, "Non-Authoritative Information");
        HttpStatusCode httpStatusCode8 = new HttpStatusCode(204, "No Content");
        HttpStatusCode httpStatusCode9 = new HttpStatusCode(205, "Reset Content");
        HttpStatusCode httpStatusCode10 = new HttpStatusCode(206, "Partial Content");
        HttpStatusCode httpStatusCode11 = new HttpStatusCode(207, "Multi-Status");
        HttpStatusCode httpStatusCode12 = new HttpStatusCode(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, "Multiple Choices");
        HttpStatusCode httpStatusCode13 = new HttpStatusCode(Constants.BUCKET_REDIRECT_STATUS_CODE, "Moved Permanently");
        HttpStatusCode httpStatusCode14 = new HttpStatusCode(302, "Found");
        HttpStatusCode httpStatusCode15 = new HttpStatusCode(303, "See Other");
        HttpStatusCode httpStatusCode16 = new HttpStatusCode(304, "Not Modified");
        HttpStatusCode httpStatusCode17 = new HttpStatusCode(305, "Use Proxy");
        HttpStatusCode httpStatusCode18 = new HttpStatusCode(307, "Temporary Redirect");
        HttpStatusCode httpStatusCode19 = new HttpStatusCode(308, "Permanent Redirect");
        HttpStatusCode httpStatusCode20 = new HttpStatusCode(400, "Bad Request");
        HttpStatusCode httpStatusCode21 = new HttpStatusCode(HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE, "Unauthorized");
        Unauthorized = httpStatusCode21;
        HttpStatusCode httpStatusCode22 = new HttpStatusCode(402, "Payment Required");
        HttpStatusCode httpStatusCode23 = new HttpStatusCode(Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE, "Forbidden");
        Forbidden = httpStatusCode23;
        HttpStatusCode httpStatusCode24 = new HttpStatusCode(Constants.NO_SUCH_BUCKET_STATUS_CODE, "Not Found");
        NotFound = httpStatusCode24;
        byValue = MapsKt__MapsKt.mapOf(new Pair(100, httpStatusCode), new Pair(101, httpStatusCode2), new Pair(102, httpStatusCode3), new Pair(200, httpStatusCode4), new Pair(201, httpStatusCode5), new Pair(202, httpStatusCode6), new Pair(203, httpStatusCode7), new Pair(204, httpStatusCode8), new Pair(205, httpStatusCode9), new Pair(206, httpStatusCode10), new Pair(207, httpStatusCode11), new Pair(Integer.valueOf(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY), httpStatusCode12), new Pair(Integer.valueOf(Constants.BUCKET_REDIRECT_STATUS_CODE), httpStatusCode13), new Pair(302, httpStatusCode14), new Pair(303, httpStatusCode15), new Pair(304, httpStatusCode16), new Pair(305, httpStatusCode17), new Pair(307, httpStatusCode18), new Pair(308, httpStatusCode19), new Pair(400, httpStatusCode20), new Pair(Integer.valueOf(HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE), httpStatusCode21), new Pair(402, httpStatusCode22), new Pair(Integer.valueOf(Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE), httpStatusCode23), new Pair(Integer.valueOf(Constants.NO_SUCH_BUCKET_STATUS_CODE), httpStatusCode24), new Pair(405, new HttpStatusCode(405, "Method Not Allowed")), new Pair(406, new HttpStatusCode(406, "Not Acceptable")), new Pair(407, new HttpStatusCode(407, "Proxy Authentication Required")), new Pair(408, new HttpStatusCode(408, "Request Timeout")), new Pair(409, new HttpStatusCode(409, "Conflict")), new Pair(410, new HttpStatusCode(410, "Gone")), new Pair(411, new HttpStatusCode(411, "Length Required")), new Pair(Integer.valueOf(Constants.FAILED_PRECONDITION_STATUS_CODE), new HttpStatusCode(Constants.FAILED_PRECONDITION_STATUS_CODE, "Precondition Failed")), new Pair(413, new HttpStatusCode(413, "Payload Too Large")), new Pair(414, new HttpStatusCode(414, "Request-URI Too Long")), new Pair(415, new HttpStatusCode(415, "Unsupported Media Type")), new Pair(416, new HttpStatusCode(416, "Requested Range Not Satisfiable")), new Pair(417, new HttpStatusCode(417, "Expectation Failed")), new Pair(422, new HttpStatusCode(422, "Unprocessable Entity")), new Pair(423, new HttpStatusCode(423, "Locked")), new Pair(424, new HttpStatusCode(424, "Failed Dependency")), new Pair(425, new HttpStatusCode(425, "Too Early")), new Pair(426, new HttpStatusCode(426, "Upgrade Required")), new Pair(428, new HttpStatusCode(428, "Precondition Required")), new Pair(429, new HttpStatusCode(429, "Too Many Requests")), new Pair(431, new HttpStatusCode(431, "Request Header Fields Too Large")), new Pair(451, new HttpStatusCode(451, "Unavailable For Legal Reason")), new Pair(500, new HttpStatusCode(500, "Internal Server Error")), new Pair(501, new HttpStatusCode(501, "Not Implemented")), new Pair(502, new HttpStatusCode(502, "Bad Gateway")), new Pair(503, new HttpStatusCode(503, "Service Unavailable")), new Pair(504, new HttpStatusCode(504, "Gateway Timeout")), new Pair(505, new HttpStatusCode(505, "HTTP Version Not Supported")), new Pair(506, new HttpStatusCode(506, "Variant Also Negotiates")), new Pair(507, new HttpStatusCode(507, "Insufficient Storage")), new Pair(508, new HttpStatusCode(508, "Loop Detected")), new Pair(510, new HttpStatusCode(510, "Not Extended")), new Pair(511, new HttpStatusCode(511, "Network Authentication Required")));
    }

    public HttpStatusCode(int r1, String str) {
        this.value = r1;
        this.description = str;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof HttpStatusCode) && ((HttpStatusCode) obj).value == this.value) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.value);
    }

    public final String toString() {
        return this.value + ": " + this.description;
    }
}
