package androidx.compose.ui.semantics;

import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.ReflectionFactory;
import kotlin.reflect.KProperty;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsPropertiesKt {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;

    static {
        MutablePropertyReference1Impl mutablePropertyReference1Impl = new MutablePropertyReference1Impl(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1);
        ReflectionFactory reflectionFactory = Reflection.factory;
        reflectionFactory.getClass();
        $$delegatedProperties = new KProperty[]{mutablePropertyReference1Impl, SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "isContainer", "isContainer(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "isTraversalGroup", "isTraversalGroup(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "traversalIndex", "getTraversalIndex(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)F", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1, reflectionFactory), SemanticsPropertiesKt$$ExternalSyntheticOutline0.m(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1, reflectionFactory)};
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> semanticsPropertyKey2 = SemanticsActions.GetTextLayoutResult;
    }

    public static void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, Function0 function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.Dismiss, new AccessibilityAction(null, function0));
    }

    public static void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, Function1 function1) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.GetTextLayoutResult, new AccessibilityAction(null, function1));
    }

    public static final void onClick(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.OnClick, new AccessibilityAction(str, function0));
    }

    public static final void setContentDescription(SemanticsPropertyReceiver semanticsPropertyReceiver, String value) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        semanticsPropertyReceiver.set(SemanticsProperties.ContentDescription, CollectionsKt__CollectionsKt.listOf(value));
    }

    /* renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m506setRolekuIjeqM(SemanticsPropertyReceiver role, int r4) {
        Intrinsics.checkNotNullParameter(role, "$this$role");
        SemanticsPropertyKey<List<String>> semanticsPropertyKey = SemanticsProperties.ContentDescription;
        SemanticsProperties.Role.setValue(role, $$delegatedProperties[10], new Role(r4));
    }
}
