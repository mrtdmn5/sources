package kotlin.text;

import kotlin.collections.AbstractList;

/* compiled from: Regex.kt */
/* loaded from: classes.dex */
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {
    public final /* synthetic */ MatcherMatchResult this$0;

    public MatcherMatchResult$groupValues$1(MatcherMatchResult matcherMatchResult) {
        this.this$0 = matcherMatchResult;
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return super.contains((String) obj);
    }

    @Override // java.util.List
    public final Object get(int r2) {
        String group = this.this$0.matcher.group(r2);
        if (group == null) {
            return "";
        }
        return group;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        return this.this$0.matcher.groupCount() + 1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return super.indexOf((String) obj);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof String)) {
            return -1;
        }
        return super.lastIndexOf((String) obj);
    }
}
