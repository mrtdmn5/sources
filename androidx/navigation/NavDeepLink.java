package androidx.navigation;

import android.net.Uri;
import com.google.android.gms.internal.measurement.zzav$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class NavDeepLink {
    public static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    public final String mAction;
    public final boolean mExactDeepLink;
    public final boolean mIsParameterizedQuery;
    public final String mMimeType;
    public final Pattern mMimeTypePattern;
    public final Pattern mPattern;
    public final ArrayList<String> mArguments = new ArrayList<>();
    public final HashMap mParamArgMap = new HashMap();

    /* loaded from: classes.dex */
    public static class ParamQuery {
        public final ArrayList<String> mArguments = new ArrayList<>();
        public String mParamRegex;
    }

    public NavDeepLink(String str, String str2, String str3) {
        boolean z;
        this.mPattern = null;
        int r1 = 0;
        this.mExactDeepLink = false;
        this.mIsParameterizedQuery = false;
        this.mMimeTypePattern = null;
        this.mAction = str2;
        this.mMimeType = str3;
        int r14 = 1;
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (parse.getQuery() != null) {
                z = true;
            } else {
                z = false;
            }
            this.mIsParameterizedQuery = z;
            StringBuilder sb = new StringBuilder("^");
            if (!SCHEME_PATTERN.matcher(str).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (z) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    buildPathRegex(str.substring(0, matcher.start()), sb, compile);
                }
                this.mExactDeepLink = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    while (matcher2.find()) {
                        paramQuery.mArguments.add(matcher2.group(r14));
                        sb2.append(Pattern.quote(queryParameter.substring(r1, matcher2.start())));
                        sb2.append("(.+?)?");
                        r1 = matcher2.end();
                        r14 = 1;
                    }
                    if (r1 < queryParameter.length()) {
                        sb2.append(Pattern.quote(queryParameter.substring(r1)));
                    }
                    paramQuery.mParamRegex = sb2.toString().replace(".*", "\\E.*\\Q");
                    this.mParamArgMap.put(str4, paramQuery);
                    r14 = 1;
                    r1 = 0;
                }
            } else {
                this.mExactDeepLink = buildPathRegex(str, sb, compile);
            }
            this.mPattern = Pattern.compile(sb.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                String[] split = str3.split("/", -1);
                this.mMimeTypePattern = Pattern.compile(("^(" + split[0] + "|[*]+)/(" + split[1] + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
                return;
            }
            throw new IllegalArgumentException(zzav$$ExternalSyntheticOutline0.m("The given mimeType ", str3, " does not match to required \"type/subtype\" format"));
        }
    }

    public final boolean buildPathRegex(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int r3 = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(r3, matcher.start())));
            sb.append("(.+?)");
            r3 = matcher.end();
            z = false;
        }
        if (r3 < str.length()) {
            sb.append(Pattern.quote(str.substring(r3)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }
}
