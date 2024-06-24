package androidx.compose.ui.semantics;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsProperties {
    public static final SemanticsPropertyKey<CollectionInfo> CollectionInfo;
    public static final SemanticsPropertyKey<CollectionItemInfo> CollectionItemInfo;
    public static final SemanticsPropertyKey<List<String>> ContentDescription = new SemanticsPropertyKey<>("ContentDescription", new Function2<List<? extends String>, List<? extends String>, List<? extends String>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$ContentDescription$1
        @Override // kotlin.jvm.functions.Function2
        public final List<? extends String> invoke(List<? extends String> list, List<? extends String> list2) {
            List<? extends String> list3 = list;
            List<? extends String> childValue = list2;
            Intrinsics.checkNotNullParameter(childValue, "childValue");
            if (list3 != null) {
                ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
                mutableList.addAll(childValue);
                return mutableList;
            }
            return childValue;
        }
    });
    public static final SemanticsPropertyKey<Unit> Disabled;
    public static final SemanticsPropertyKey<AnnotatedString> EditableText;
    public static final SemanticsPropertyKey<String> Error;
    public static final SemanticsPropertyKey<Boolean> Focused;
    public static final SemanticsPropertyKey<Unit> Heading;
    public static final SemanticsPropertyKey<ScrollAxisRange> HorizontalScrollAxisRange;
    public static final SemanticsPropertyKey<ImeAction> ImeAction;
    public static final SemanticsPropertyKey<Function1<Object, Integer>> IndexForKey;
    public static final SemanticsPropertyKey<Unit> InvisibleToUser;
    public static final SemanticsPropertyKey<Unit> IsDialog;
    public static final SemanticsPropertyKey<Unit> IsPopup;
    public static final SemanticsPropertyKey<Boolean> IsTraversalGroup;
    public static final SemanticsPropertyKey<LiveRegionMode> LiveRegion;
    public static final SemanticsPropertyKey<String> PaneTitle;
    public static final SemanticsPropertyKey<Unit> Password;
    public static final SemanticsPropertyKey<ProgressBarRangeInfo> ProgressBarRangeInfo;
    public static final SemanticsPropertyKey<Role> Role;
    public static final SemanticsPropertyKey<Unit> SelectableGroup;
    public static final SemanticsPropertyKey<Boolean> Selected;
    public static final SemanticsPropertyKey<String> StateDescription;
    public static final SemanticsPropertyKey<String> TestTag;
    public static final SemanticsPropertyKey<List<AnnotatedString>> Text;
    public static final SemanticsPropertyKey<TextRange> TextSelectionRange;
    public static final SemanticsPropertyKey<ToggleableState> ToggleableState;
    public static final SemanticsPropertyKey<Float> TraversalIndex;
    public static final SemanticsPropertyKey<ScrollAxisRange> VerticalScrollAxisRange;

    static {
        SemanticsPropertyKey.AnonymousClass1 anonymousClass1 = SemanticsPropertyKey.AnonymousClass1.INSTANCE;
        StateDescription = new SemanticsPropertyKey<>("StateDescription", anonymousClass1);
        ProgressBarRangeInfo = new SemanticsPropertyKey<>("ProgressBarRangeInfo", anonymousClass1);
        PaneTitle = new SemanticsPropertyKey<>("PaneTitle", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$PaneTitle$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, String str2) {
                Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
            }
        });
        SelectableGroup = new SemanticsPropertyKey<>("SelectableGroup", anonymousClass1);
        CollectionInfo = new SemanticsPropertyKey<>("CollectionInfo", anonymousClass1);
        CollectionItemInfo = new SemanticsPropertyKey<>("CollectionItemInfo", anonymousClass1);
        Heading = new SemanticsPropertyKey<>("Heading", anonymousClass1);
        Disabled = new SemanticsPropertyKey<>(BucketLifecycleConfiguration.DISABLED, anonymousClass1);
        LiveRegion = new SemanticsPropertyKey<>("LiveRegion", anonymousClass1);
        Focused = new SemanticsPropertyKey<>("Focused", anonymousClass1);
        IsTraversalGroup = new SemanticsPropertyKey<>("IsTraversalGroup", anonymousClass1);
        InvisibleToUser = new SemanticsPropertyKey<>("InvisibleToUser", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$InvisibleToUser$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Unit unit, Unit unit2) {
                Unit unit3 = unit;
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                return unit3;
            }
        });
        TraversalIndex = new SemanticsPropertyKey<>("TraversalIndex", new Function2<Float, Float, Float>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TraversalIndex$1
            @Override // kotlin.jvm.functions.Function2
            public final Float invoke(Float f, Float f2) {
                Float f3 = f;
                f2.floatValue();
                return f3;
            }
        });
        HorizontalScrollAxisRange = new SemanticsPropertyKey<>("HorizontalScrollAxisRange", anonymousClass1);
        VerticalScrollAxisRange = new SemanticsPropertyKey<>("VerticalScrollAxisRange", anonymousClass1);
        IsPopup = new SemanticsPropertyKey<>("IsPopup", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsPopup$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Unit unit, Unit unit2) {
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                throw new IllegalStateException("merge function called on unmergeable property IsPopup. A popup should not be a child of a clickable/focusable node.");
            }
        });
        IsDialog = new SemanticsPropertyKey<>("IsDialog", new Function2<Unit, Unit, Unit>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$IsDialog$1
            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Unit unit, Unit unit2) {
                Intrinsics.checkNotNullParameter(unit2, "<anonymous parameter 1>");
                throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
            }
        });
        Role = new SemanticsPropertyKey<>("Role", new Function2<Role, Role, Role>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Role$1
            @Override // kotlin.jvm.functions.Function2
            public final Role invoke(Role role, Role role2) {
                Role role3 = role;
                int r2 = role2.value;
                return role3;
            }
        });
        TestTag = new SemanticsPropertyKey<>("TestTag", new Function2<String, String, String>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$TestTag$1
            @Override // kotlin.jvm.functions.Function2
            public final String invoke(String str, String str2) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                return str3;
            }
        });
        Text = new SemanticsPropertyKey<>("Text", new Function2<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>>() { // from class: androidx.compose.ui.semantics.SemanticsProperties$Text$1
            @Override // kotlin.jvm.functions.Function2
            public final List<? extends AnnotatedString> invoke(List<? extends AnnotatedString> list, List<? extends AnnotatedString> list2) {
                List<? extends AnnotatedString> list3 = list;
                List<? extends AnnotatedString> childValue = list2;
                Intrinsics.checkNotNullParameter(childValue, "childValue");
                if (list3 != null) {
                    ArrayList mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
                    mutableList.addAll(childValue);
                    return mutableList;
                }
                return childValue;
            }
        });
        EditableText = new SemanticsPropertyKey<>("EditableText", anonymousClass1);
        TextSelectionRange = new SemanticsPropertyKey<>("TextSelectionRange", anonymousClass1);
        ImeAction = new SemanticsPropertyKey<>("ImeAction", anonymousClass1);
        Selected = new SemanticsPropertyKey<>("Selected", anonymousClass1);
        ToggleableState = new SemanticsPropertyKey<>("ToggleableState", anonymousClass1);
        Password = new SemanticsPropertyKey<>("Password", anonymousClass1);
        Error = new SemanticsPropertyKey<>("Error", anonymousClass1);
        IndexForKey = new SemanticsPropertyKey<>("IndexForKey", anonymousClass1);
    }
}
