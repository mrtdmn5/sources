package io.ktor.http;

import com.amazonaws.services.s3.internal.Constants;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.account.HttpUtilsKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpStatusCode.kt */
/* loaded from: classes3.dex */
public final class HttpStatusCode implements Comparable<HttpStatusCode> {
    public static final HttpStatusCode BadRequest;
    public static final HttpStatusCode Found;
    public static final HttpStatusCode MovedPermanently;
    public static final HttpStatusCode PermanentRedirect;
    public static final HttpStatusCode SeeOther;
    public static final HttpStatusCode TemporaryRedirect;
    public static final HttpStatusCode TooManyRequests;
    public static final HttpStatusCode Unauthorized;
    public static final List<HttpStatusCode> allStatusCodes;
    public static final LinkedHashMap statusCodesMap;
    public final String description;
    public final int value;

    static {
        HttpStatusCode httpStatusCode = new HttpStatusCode(100, "Continue");
        HttpStatusCode httpStatusCode2 = new HttpStatusCode(101, "Switching Protocols");
        HttpStatusCode httpStatusCode3 = new HttpStatusCode(102, "Processing");
        HttpStatusCode httpStatusCode4 = new HttpStatusCode(200, "OK");
        HttpStatusCode httpStatusCode5 = new HttpStatusCode(201, "Created");
        HttpStatusCode httpStatusCode6 = new HttpStatusCode(202, "Accepted");
        HttpStatusCode httpStatusCode7 = new HttpStatusCode(203, "Non-Authoritative Information");
        HttpStatusCode httpStatusCode8 = new HttpStatusCode(204, "No Content");
        HttpStatusCode httpStatusCode9 = new HttpStatusCode(205, "Reset Content");
        HttpStatusCode httpStatusCode10 = new HttpStatusCode(206, "Partial Content");
        HttpStatusCode httpStatusCode11 = new HttpStatusCode(207, "Multi-Status");
        HttpStatusCode httpStatusCode12 = new HttpStatusCode(TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, "Multiple Choices");
        HttpStatusCode httpStatusCode13 = new HttpStatusCode(Constants.BUCKET_REDIRECT_STATUS_CODE, "Moved Permanently");
        MovedPermanently = httpStatusCode13;
        HttpStatusCode httpStatusCode14 = new HttpStatusCode(302, "Found");
        Found = httpStatusCode14;
        HttpStatusCode httpStatusCode15 = new HttpStatusCode(303, "See Other");
        SeeOther = httpStatusCode15;
        HttpStatusCode httpStatusCode16 = new HttpStatusCode(304, "Not Modified");
        HttpStatusCode httpStatusCode17 = new HttpStatusCode(305, "Use Proxy");
        HttpStatusCode httpStatusCode18 = new HttpStatusCode(306, "Switch Proxy");
        HttpStatusCode httpStatusCode19 = new HttpStatusCode(307, "Temporary Redirect");
        TemporaryRedirect = httpStatusCode19;
        HttpStatusCode httpStatusCode20 = new HttpStatusCode(308, "Permanent Redirect");
        PermanentRedirect = httpStatusCode20;
        HttpStatusCode httpStatusCode21 = new HttpStatusCode(400, "Bad Request");
        BadRequest = httpStatusCode21;
        HttpStatusCode httpStatusCode22 = new HttpStatusCode(HttpUtilsKt.UNAUTHORIZED_RESPONSE_CODE, "Unauthorized");
        Unauthorized = httpStatusCode22;
        HttpStatusCode httpStatusCode23 = new HttpStatusCode(402, "Payment Required");
        HttpStatusCode httpStatusCode24 = new HttpStatusCode(Constants.BUCKET_ACCESS_FORBIDDEN_STATUS_CODE, "Forbidden");
        HttpStatusCode httpStatusCode25 = new HttpStatusCode(Constants.NO_SUCH_BUCKET_STATUS_CODE, "Not Found");
        HttpStatusCode httpStatusCode26 = new HttpStatusCode(405, "Method Not Allowed");
        HttpStatusCode httpStatusCode27 = new HttpStatusCode(406, "Not Acceptable");
        HttpStatusCode httpStatusCode28 = new HttpStatusCode(407, "Proxy Authentication Required");
        HttpStatusCode httpStatusCode29 = new HttpStatusCode(408, "Request Timeout");
        HttpStatusCode httpStatusCode30 = new HttpStatusCode(409, "Conflict");
        HttpStatusCode httpStatusCode31 = new HttpStatusCode(410, "Gone");
        HttpStatusCode httpStatusCode32 = new HttpStatusCode(411, "Length Required");
        HttpStatusCode httpStatusCode33 = new HttpStatusCode(Constants.FAILED_PRECONDITION_STATUS_CODE, "Precondition Failed");
        HttpStatusCode httpStatusCode34 = new HttpStatusCode(413, "Payload Too Large");
        HttpStatusCode httpStatusCode35 = new HttpStatusCode(414, "Request-URI Too Long");
        HttpStatusCode httpStatusCode36 = new HttpStatusCode(415, "Unsupported Media Type");
        HttpStatusCode httpStatusCode37 = new HttpStatusCode(416, "Requested Range Not Satisfiable");
        HttpStatusCode httpStatusCode38 = new HttpStatusCode(417, "Expectation Failed");
        HttpStatusCode httpStatusCode39 = new HttpStatusCode(422, "Unprocessable Entity");
        HttpStatusCode httpStatusCode40 = new HttpStatusCode(423, "Locked");
        HttpStatusCode httpStatusCode41 = new HttpStatusCode(424, "Failed Dependency");
        HttpStatusCode httpStatusCode42 = new HttpStatusCode(425, "Too Early");
        HttpStatusCode httpStatusCode43 = new HttpStatusCode(426, "Upgrade Required");
        HttpStatusCode httpStatusCode44 = new HttpStatusCode(429, "Too Many Requests");
        TooManyRequests = httpStatusCode44;
        List<HttpStatusCode> listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new HttpStatusCode[]{httpStatusCode, httpStatusCode2, httpStatusCode3, httpStatusCode4, httpStatusCode5, httpStatusCode6, httpStatusCode7, httpStatusCode8, httpStatusCode9, httpStatusCode10, httpStatusCode11, httpStatusCode12, httpStatusCode13, httpStatusCode14, httpStatusCode15, httpStatusCode16, httpStatusCode17, httpStatusCode18, httpStatusCode19, httpStatusCode20, httpStatusCode21, httpStatusCode22, httpStatusCode23, httpStatusCode24, httpStatusCode25, httpStatusCode26, httpStatusCode27, httpStatusCode28, httpStatusCode29, httpStatusCode30, httpStatusCode31, httpStatusCode32, httpStatusCode33, httpStatusCode34, httpStatusCode35, httpStatusCode36, httpStatusCode37, httpStatusCode38, httpStatusCode39, httpStatusCode40, httpStatusCode41, httpStatusCode42, httpStatusCode43, httpStatusCode44, new HttpStatusCode(431, "Request Header Fields Too Large"), new HttpStatusCode(500, "Internal Server Error"), new HttpStatusCode(501, "Not Implemented"), new HttpStatusCode(502, "Bad Gateway"), new HttpStatusCode(503, "Service Unavailable"), new HttpStatusCode(504, "Gateway Timeout"), new HttpStatusCode(505, "HTTP Version Not Supported"), new HttpStatusCode(506, "Variant Also Negotiates"), new HttpStatusCode(507, "Insufficient Storage")});
        allStatusCodes = listOf;
        List<HttpStatusCode> list = listOf;
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Object obj : list) {
            linkedHashMap.put(Integer.valueOf(((HttpStatusCode) obj).value), obj);
        }
        statusCodesMap = linkedHashMap;
    }

    public HttpStatusCode(int r1, String str) {
        this.value = r1;
        this.description = str;
    }

    @Override // java.lang.Comparable
    public final int compareTo(HttpStatusCode httpStatusCode) {
        HttpStatusCode other = httpStatusCode;
        Intrinsics.checkNotNullParameter(other, "other");
        return this.value - other.value;
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
        return this.value + ' ' + this.description;
    }
}
