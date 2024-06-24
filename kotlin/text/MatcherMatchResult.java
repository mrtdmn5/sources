package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Regex.kt */
/* loaded from: classes.dex */
public final class MatcherMatchResult implements MatchResult {
    public MatcherMatchResult$groupValues$1 groupValues_;
    public final MatcherMatchResult$groups$1 groups;
    public final CharSequence input;
    public final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    public final List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new MatcherMatchResult$groupValues$1(this);
        }
        MatcherMatchResult$groupValues$1 matcherMatchResult$groupValues$1 = this.groupValues_;
        Intrinsics.checkNotNull(matcherMatchResult$groupValues$1);
        return matcherMatchResult$groupValues$1;
    }

    public final IntRange getRange() {
        Matcher matcher = this.matcher;
        return RangesKt___RangesKt.until(matcher.start(), matcher.end());
    }

    @Override // kotlin.text.MatchResult
    public final String getValue() {
        String group = this.matcher.group();
        Intrinsics.checkNotNullExpressionValue(group, "group(...)");
        return group;
    }

    public final MatcherMatchResult next() {
        int r2;
        Matcher matcher = this.matcher;
        int end = matcher.end();
        if (matcher.end() == matcher.start()) {
            r2 = 1;
        } else {
            r2 = 0;
        }
        int r1 = end + r2;
        CharSequence charSequence = this.input;
        if (r1 > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        Intrinsics.checkNotNullExpressionValue(matcher2, "matcher(...)");
        if (!matcher2.find(r1)) {
            return null;
        }
        return new MatcherMatchResult(matcher2, charSequence);
    }
}
