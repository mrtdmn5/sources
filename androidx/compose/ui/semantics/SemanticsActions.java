package androidx.compose.ui.semantics;

import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class SemanticsActions {
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText;
    public static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand;
    public static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;
    public static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PerformImeAction;
    public static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus;
    public static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy;
    public static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex;
    public static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress;
    public static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection;
    public static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText;

    static {
        SemanticsPropertiesKt$ActionPropertyKey$1 semanticsPropertiesKt$ActionPropertyKey$1 = new Function2<AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>, AccessibilityAction<Function<? extends Boolean>>>() { // from class: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1
            @Override // kotlin.jvm.functions.Function2
            public final AccessibilityAction<Function<? extends Boolean>> invoke(AccessibilityAction<Function<? extends Boolean>> accessibilityAction, AccessibilityAction<Function<? extends Boolean>> accessibilityAction2) {
                String str;
                Function<? extends Boolean> function;
                AccessibilityAction<Function<? extends Boolean>> accessibilityAction3 = accessibilityAction;
                AccessibilityAction<Function<? extends Boolean>> childValue = accessibilityAction2;
                Intrinsics.checkNotNullParameter(childValue, "childValue");
                if (accessibilityAction3 == null || (str = accessibilityAction3.label) == null) {
                    str = childValue.label;
                }
                if (accessibilityAction3 == null || (function = accessibilityAction3.action) == null) {
                    function = childValue.action;
                }
                return new AccessibilityAction<>(str, function);
            }
        };
        GetTextLayoutResult = new SemanticsPropertyKey<>("GetTextLayoutResult", semanticsPropertiesKt$ActionPropertyKey$1);
        OnClick = new SemanticsPropertyKey<>("OnClick", semanticsPropertiesKt$ActionPropertyKey$1);
        OnLongClick = new SemanticsPropertyKey<>("OnLongClick", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollBy = new SemanticsPropertyKey<>("ScrollBy", semanticsPropertiesKt$ActionPropertyKey$1);
        ScrollToIndex = new SemanticsPropertyKey<>("ScrollToIndex", semanticsPropertiesKt$ActionPropertyKey$1);
        SetProgress = new SemanticsPropertyKey<>("SetProgress", semanticsPropertiesKt$ActionPropertyKey$1);
        SetSelection = new SemanticsPropertyKey<>("SetSelection", semanticsPropertiesKt$ActionPropertyKey$1);
        SetText = new SemanticsPropertyKey<>("SetText", semanticsPropertiesKt$ActionPropertyKey$1);
        InsertTextAtCursor = new SemanticsPropertyKey<>("InsertTextAtCursor", semanticsPropertiesKt$ActionPropertyKey$1);
        PerformImeAction = new SemanticsPropertyKey<>("PerformImeAction", semanticsPropertiesKt$ActionPropertyKey$1);
        CopyText = new SemanticsPropertyKey<>("CopyText", semanticsPropertiesKt$ActionPropertyKey$1);
        CutText = new SemanticsPropertyKey<>("CutText", semanticsPropertiesKt$ActionPropertyKey$1);
        PasteText = new SemanticsPropertyKey<>("PasteText", semanticsPropertiesKt$ActionPropertyKey$1);
        Expand = new SemanticsPropertyKey<>("Expand", semanticsPropertiesKt$ActionPropertyKey$1);
        Collapse = new SemanticsPropertyKey<>("Collapse", semanticsPropertiesKt$ActionPropertyKey$1);
        Dismiss = new SemanticsPropertyKey<>("Dismiss", semanticsPropertiesKt$ActionPropertyKey$1);
        RequestFocus = new SemanticsPropertyKey<>("RequestFocus", semanticsPropertiesKt$ActionPropertyKey$1);
        CustomActions = new SemanticsPropertyKey<>("CustomActions", SemanticsPropertyKey.AnonymousClass1.INSTANCE);
        PageUp = new SemanticsPropertyKey<>("PageUp", semanticsPropertiesKt$ActionPropertyKey$1);
        PageLeft = new SemanticsPropertyKey<>("PageLeft", semanticsPropertiesKt$ActionPropertyKey$1);
        PageDown = new SemanticsPropertyKey<>("PageDown", semanticsPropertiesKt$ActionPropertyKey$1);
        PageRight = new SemanticsPropertyKey<>("PageRight", semanticsPropertiesKt$ActionPropertyKey$1);
    }
}
