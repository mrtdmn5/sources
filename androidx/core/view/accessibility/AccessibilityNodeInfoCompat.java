package androidx.core.view.accessibility;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.amazonaws.services.s3.internal.Constants;
import j$.time.Duration;
import j$.time.TimeConversions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;

/* loaded from: classes.dex */
public final class AccessibilityNodeInfoCompat {
    public static int sClickableSpanId;
    public final AccessibilityNodeInfo mInfo;
    public int mParentVirtualDescendantId = -1;
    public int mVirtualDescendantId = -1;

    /* loaded from: classes.dex */
    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
        public static final AccessibilityActionCompat ACTION_CLICK;
        public static final AccessibilityActionCompat ACTION_COLLAPSE;
        public static final AccessibilityActionCompat ACTION_DISMISS;
        public static final AccessibilityActionCompat ACTION_EXPAND;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
        public static final AccessibilityActionCompat ACTION_SCROLL_UP;
        public final Object mAction;
        public final AccessibilityViewCommand mCommand;
        public final int mId;
        public final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22 = null;
            new AccessibilityActionCompat(1, (String) null);
            new AccessibilityActionCompat(2, (String) null);
            new AccessibilityActionCompat(4, (String) null);
            new AccessibilityActionCompat(8, (String) null);
            ACTION_CLICK = new AccessibilityActionCompat(16, (String) null);
            new AccessibilityActionCompat(32, (String) null);
            ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, (String) null);
            ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, (String) null);
            new AccessibilityActionCompat(256, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            new AccessibilityActionCompat(DfuBaseService.ERROR_REMOTE_TYPE_SECURE, AccessibilityViewCommand.MoveAtGranularityArguments.class);
            new AccessibilityActionCompat(1024, AccessibilityViewCommand.MoveHtmlArguments.class);
            new AccessibilityActionCompat(2048, AccessibilityViewCommand.MoveHtmlArguments.class);
            ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, (String) null);
            ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(DfuBaseService.ERROR_REMOTE_MASK, (String) null);
            new AccessibilityActionCompat(DfuBaseService.ERROR_CONNECTION_MASK, (String) null);
            new AccessibilityActionCompat(DfuBaseService.ERROR_CONNECTION_STATE_MASK, (String) null);
            new AccessibilityActionCompat(65536, (String) null);
            new AccessibilityActionCompat(131072, AccessibilityViewCommand.SetSelectionArguments.class);
            ACTION_EXPAND = new AccessibilityActionCompat(262144, (String) null);
            ACTION_COLLAPSE = new AccessibilityActionCompat(524288, (String) null);
            ACTION_DISMISS = new AccessibilityActionCompat(Constants.MB, (String) null);
            new AccessibilityActionCompat(2097152, AccessibilityViewCommand.SetTextArguments.class);
            int r0 = Build.VERSION.SDK_INT;
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, AccessibilityViewCommand.ScrollToPositionArguments.class);
            ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            if (r0 >= 29) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction = null;
            }
            new AccessibilityActionCompat(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
            if (r0 >= 29) {
                accessibilityAction21 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction2 = accessibilityAction21;
            } else {
                accessibilityAction2 = null;
            }
            new AccessibilityActionCompat(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
            if (r0 >= 29) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction3 = null;
            }
            new AccessibilityActionCompat(accessibilityAction3, R.id.accessibilityActionPageLeft, null, null, null);
            if (r0 >= 29) {
                accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction4 = accessibilityAction20;
            } else {
                accessibilityAction4 = null;
            }
            new AccessibilityActionCompat(accessibilityAction4, R.id.accessibilityActionPageRight, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, AccessibilityViewCommand.SetProgressArguments.class);
            if (r0 >= 26) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction5 = null;
            }
            new AccessibilityActionCompat(accessibilityAction5, R.id.accessibilityActionMoveWindow, null, null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (r0 >= 28) {
                accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction6 = accessibilityAction19;
            } else {
                accessibilityAction6 = null;
            }
            new AccessibilityActionCompat(accessibilityAction6, R.id.accessibilityActionShowTooltip, null, null, null);
            if (r0 >= 28) {
                accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction7 = accessibilityAction18;
            } else {
                accessibilityAction7 = null;
            }
            new AccessibilityActionCompat(accessibilityAction7, R.id.accessibilityActionHideTooltip, null, null, null);
            if (r0 >= 30) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction8 = null;
            }
            new AccessibilityActionCompat(accessibilityAction8, R.id.accessibilityActionPressAndHold, null, null, null);
            if (r0 >= 30) {
                accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                accessibilityAction9 = accessibilityAction17;
            } else {
                accessibilityAction9 = null;
            }
            new AccessibilityActionCompat(accessibilityAction9, R.id.accessibilityActionImeEnter, null, null, null);
            if (r0 >= 32) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction10 = null;
            }
            new AccessibilityActionCompat(accessibilityAction10, R.id.ALT, null, null, null);
            if (r0 >= 32) {
                accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
                accessibilityAction11 = accessibilityAction16;
            } else {
                accessibilityAction11 = null;
            }
            new AccessibilityActionCompat(accessibilityAction11, R.id.CTRL, null, null, null);
            if (r0 >= 32) {
                accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
                accessibilityAction12 = accessibilityAction15;
            } else {
                accessibilityAction12 = null;
            }
            new AccessibilityActionCompat(accessibilityAction12, R.id.FUNCTION, null, null, null);
            if (r0 >= 33) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
                accessibilityAction13 = accessibilityAction14;
            } else {
                accessibilityAction13 = null;
            }
            new AccessibilityActionCompat(accessibilityAction13, R.id.KEYCODE_0, null, null, null);
            if (r0 >= 34) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
            }
            new AccessibilityActionCompat(accessibilityAction22, R.id.KEYCODE_3D_MODE, null, null, null);
        }

        public AccessibilityActionCompat(int r7, String str) {
            this(null, r7, str, null, null);
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            Object obj2 = ((AccessibilityActionCompat) obj).mAction;
            Object obj3 = this.mAction;
            if (obj3 == null) {
                if (obj2 != null) {
                    return false;
                }
                return true;
            }
            if (!obj3.equals(obj2)) {
                return false;
            }
            return true;
        }

        public final int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.mAction).getId();
        }

        public final int hashCode() {
            Object obj = this.mAction;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("AccessibilityActionCompat: ");
            String actionSymbolicName = AccessibilityNodeInfoCompat.getActionSymbolicName(this.mId);
            if (actionSymbolicName.equals("ACTION_UNKNOWN")) {
                Object obj = this.mAction;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    actionSymbolicName = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(actionSymbolicName);
            return sb.toString();
        }

        public AccessibilityActionCompat(int r7, Class cls) {
            this(null, r7, null, null, cls);
        }

        public AccessibilityActionCompat(Object obj, int r2, String str, AccessibilityViewCommand accessibilityViewCommand, Class cls) {
            this.mId = r2;
            this.mCommand = accessibilityViewCommand;
            if (obj == null) {
                this.mAction = new AccessibilityNodeInfo.AccessibilityAction(r2, str);
            } else {
                this.mAction = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }
    }

    /* loaded from: classes.dex */
    public static class Api19Impl {
        public static CollectionItemInfoCompat createCollectionItemInfo(int r1, int r2, int r3, int r4, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r1, r2, r3, r4, z));
        }

        public static Object createRangeInfo(int r0, float f, float f2, float f3) {
            return AccessibilityNodeInfo.RangeInfo.obtain(r0, f, f2, f3);
        }

        public static Bundle getExtras(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtras();
        }
    }

    /* loaded from: classes.dex */
    public static class Api30Impl {
        public static Object createRangeInfo(int r1, float f, float f2, float f3) {
            return new AccessibilityNodeInfo.RangeInfo(r1, f, f2, f3);
        }

        public static CharSequence getStateDescription(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void setStateDescription(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static class Api33Impl {
        public static CollectionItemInfoCompat buildCollectionItemInfoCompat(boolean z, int r3, int r4, int r5, int r6, boolean z2, String str, String str2) {
            return new CollectionItemInfoCompat(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z).setColumnIndex(r3).setRowIndex(r4).setColumnSpan(r5).setRowSpan(r6).setSelected(z2).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static AccessibilityNodeInfoCompat getChild(AccessibilityNodeInfo accessibilityNodeInfo, int r1, int r2) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(r1, r2);
            if (child != null) {
                return new AccessibilityNodeInfoCompat(child, 0);
            }
            return null;
        }

        public static String getCollectionItemColumnTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String getCollectionItemRowTitle(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static AccessibilityNodeInfoCompat getParent(AccessibilityNodeInfo accessibilityNodeInfo, int r2) {
            AccessibilityNodeInfo parent = accessibilityNodeInfo.getParent(r2);
            if (parent != null) {
                return new AccessibilityNodeInfoCompat(parent, 0);
            }
            return null;
        }

        public static String getUniqueId(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setTextSelectable(z);
        }

        public static void setUniqueId(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

    /* loaded from: classes.dex */
    public static class Api34Impl {
        public static void getBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence getContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static long getMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo) {
            Duration convert;
            convert = TimeConversions.convert(accessibilityNodeInfo.getMinDurationBetweenContentChanges());
            return convert.toMillis();
        }

        public static boolean hasRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean isAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void setAccessibilityDataSensitive(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z);
        }

        public static void setBoundsInWindow(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void setContainerTitle(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void setMinDurationBetweenContentChangeMillis(AccessibilityNodeInfo accessibilityNodeInfo, long j) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(TimeConversions.convert(Duration.ofMillis(j)));
        }

        public static void setQueryFromAppProcessEnabled(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z);
        }

        public static void setRequestInitialAccessibilityFocus(AccessibilityNodeInfo accessibilityNodeInfo, boolean z) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z);
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionInfoCompat {
        public final Object mInfo;

        public CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo collectionInfo) {
            this.mInfo = collectionInfo;
        }

        public static CollectionInfoCompat obtain(int r1, int r2, int r3, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(r1, r2, z, r3));
        }
    }

    /* loaded from: classes.dex */
    public static class CollectionItemInfoCompat {
        public final Object mInfo;

        public CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo) {
            this.mInfo = collectionItemInfo;
        }

        public static CollectionItemInfoCompat obtain(int r7, int r8, int r9, int r10, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(r7, r8, r9, r10, false, z));
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo, int r2) {
        this.mInfo = accessibilityNodeInfo;
    }

    public static String getActionSymbolicName(int r1) {
        if (r1 != 1) {
            if (r1 != 2) {
                switch (r1) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case DfuBaseService.ERROR_REMOTE_TYPE_SECURE /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case DfuBaseService.ERROR_REMOTE_MASK /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case DfuBaseService.ERROR_CONNECTION_MASK /* 16384 */:
                        return "ACTION_COPY";
                    case DfuBaseService.ERROR_CONNECTION_STATE_MASK /* 32768 */:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case R.id.accessibilityActionMoveWindow:
                        return "ACTION_MOVE_WINDOW";
                    case R.id.KEYCODE_3D_MODE:
                        return "ACTION_SCROLL_IN_DIRECTION";
                    default:
                        switch (r1) {
                            case R.id.accessibilityActionShowOnScreen:
                                return "ACTION_SHOW_ON_SCREEN";
                            case R.id.accessibilityActionScrollToPosition:
                                return "ACTION_SCROLL_TO_POSITION";
                            case R.id.accessibilityActionScrollUp:
                                return "ACTION_SCROLL_UP";
                            case R.id.accessibilityActionScrollLeft:
                                return "ACTION_SCROLL_LEFT";
                            case R.id.accessibilityActionScrollDown:
                                return "ACTION_SCROLL_DOWN";
                            case R.id.accessibilityActionScrollRight:
                                return "ACTION_SCROLL_RIGHT";
                            case R.id.accessibilityActionContextClick:
                                return "ACTION_CONTEXT_CLICK";
                            case R.id.accessibilityActionSetProgress:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (r1) {
                                    case R.id.accessibilityActionShowTooltip:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case R.id.accessibilityActionHideTooltip:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case R.id.accessibilityActionPageUp:
                                        return "ACTION_PAGE_UP";
                                    case R.id.accessibilityActionPageDown:
                                        return "ACTION_PAGE_DOWN";
                                    case R.id.accessibilityActionPageLeft:
                                        return "ACTION_PAGE_LEFT";
                                    case R.id.accessibilityActionPageRight:
                                        return "ACTION_PAGE_RIGHT";
                                    case R.id.accessibilityActionPressAndHold:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (r1) {
                                            case R.id.accessibilityActionImeEnter:
                                                return "ACTION_IME_ENTER";
                                            case R.id.ALT:
                                                return "ACTION_DRAG_START";
                                            case R.id.CTRL:
                                                return "ACTION_DRAG_DROP";
                                            case R.id.FUNCTION:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public final void addAction(int r2) {
        this.mInfo.addAction(r2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = accessibilityNodeInfoCompat.mInfo;
        AccessibilityNodeInfo accessibilityNodeInfo2 = this.mInfo;
        if (accessibilityNodeInfo2 == null) {
            if (accessibilityNodeInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo2.equals(accessibilityNodeInfo)) {
            return false;
        }
        if (this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId) {
            return true;
        }
        return false;
    }

    public final ArrayList extrasIntList(String str) {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        ArrayList<Integer> integerArrayList = Api19Impl.getExtras(accessibilityNodeInfo).getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            Api19Impl.getExtras(accessibilityNodeInfo).putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public final boolean getBooleanProperty(int r4) {
        Bundle extras = Api19Impl.getExtras(this.mInfo);
        if (extras == null || (extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & r4) != r4) {
            return false;
        }
        return true;
    }

    @Deprecated
    public final void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public final CharSequence getText() {
        boolean z = !extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (z) {
            ArrayList extrasIntList = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            ArrayList extrasIntList2 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            ArrayList extrasIntList3 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            ArrayList extrasIntList4 = extrasIntList("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(accessibilityNodeInfo.getText(), 0, accessibilityNodeInfo.getText().length()));
            for (int r8 = 0; r8 < extrasIntList.size(); r8++) {
                spannableString.setSpan(new AccessibilityClickableSpanCompat(((Integer) extrasIntList4.get(r8)).intValue(), this, Api19Impl.getExtras(accessibilityNodeInfo).getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) extrasIntList.get(r8)).intValue(), ((Integer) extrasIntList2.get(r8)).intValue(), ((Integer) extrasIntList3.get(r8)).intValue());
            }
            return spannableString;
        }
        return accessibilityNodeInfo.getText();
    }

    public final int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final void setBooleanProperty(int r6, boolean z) {
        Bundle extras = Api19Impl.getExtras(this.mInfo);
        if (extras != null) {
            int r3 = extras.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~r6);
            if (!z) {
                r6 = 0;
            }
            extras.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", r6 | r3);
        }
    }

    public final void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public final void setCollectionInfo(CollectionInfoCompat collectionInfoCompat) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        if (collectionInfoCompat == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) collectionInfoCompat.mInfo;
        }
        this.mInfo.setCollectionInfo(collectionInfo);
    }

    public final void setCollectionItemInfo(CollectionItemInfoCompat collectionItemInfoCompat) {
        this.mInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) collectionItemInfoCompat.mInfo);
    }

    public final void setHintText(String str) {
        int r0 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (r0 >= 26) {
            accessibilityNodeInfo.setHintText(str);
        } else {
            Api19Impl.getExtras(accessibilityNodeInfo).putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", str);
        }
    }

    public final void setScrollable(boolean z) {
        this.mInfo.setScrollable(z);
    }

    public final void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.ArrayList] */
    public final String toString() {
        CharSequence charSequence;
        CharSequence charSequence2;
        String string;
        CharSequence charSequence3;
        boolean booleanProperty;
        boolean booleanProperty2;
        ?? emptyList;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        accessibilityNodeInfo.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        int r3 = Build.VERSION.SDK_INT;
        if (r3 >= 34) {
            Api34Impl.getBoundsInWindow(accessibilityNodeInfo, rect);
        } else {
            Rect rect2 = (Rect) Api19Impl.getExtras(accessibilityNodeInfo).getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
            if (rect2 != null) {
                rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
            }
        }
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(accessibilityNodeInfo.getPackageName());
        sb.append("; className: ");
        sb.append(accessibilityNodeInfo.getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; error: ");
        sb.append(accessibilityNodeInfo.getError());
        sb.append("; maxTextLength: ");
        sb.append(accessibilityNodeInfo.getMaxTextLength());
        sb.append("; stateDescription: ");
        if (r3 >= 30) {
            charSequence = Api30Impl.getStateDescription(accessibilityNodeInfo);
        } else {
            charSequence = Api19Impl.getExtras(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
        }
        sb.append(charSequence);
        sb.append("; contentDescription: ");
        sb.append(accessibilityNodeInfo.getContentDescription());
        sb.append("; tooltipText: ");
        if (r3 >= 28) {
            charSequence2 = accessibilityNodeInfo.getTooltipText();
        } else {
            charSequence2 = Api19Impl.getExtras(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
        }
        sb.append(charSequence2);
        sb.append("; viewIdResName: ");
        sb.append(accessibilityNodeInfo.getViewIdResourceName());
        sb.append("; uniqueId: ");
        if (r3 >= 33) {
            string = Api33Impl.getUniqueId(accessibilityNodeInfo);
        } else {
            string = Api19Impl.getExtras(accessibilityNodeInfo).getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
        }
        sb.append(string);
        sb.append("; checkable: ");
        sb.append(accessibilityNodeInfo.isCheckable());
        sb.append("; checked: ");
        sb.append(accessibilityNodeInfo.isChecked());
        sb.append("; focusable: ");
        sb.append(accessibilityNodeInfo.isFocusable());
        sb.append("; focused: ");
        sb.append(accessibilityNodeInfo.isFocused());
        sb.append("; selected: ");
        sb.append(accessibilityNodeInfo.isSelected());
        sb.append("; clickable: ");
        sb.append(accessibilityNodeInfo.isClickable());
        sb.append("; longClickable: ");
        sb.append(accessibilityNodeInfo.isLongClickable());
        sb.append("; contextClickable: ");
        sb.append(accessibilityNodeInfo.isContextClickable());
        sb.append("; enabled: ");
        sb.append(accessibilityNodeInfo.isEnabled());
        sb.append("; password: ");
        sb.append(accessibilityNodeInfo.isPassword());
        sb.append("; scrollable: " + accessibilityNodeInfo.isScrollable());
        sb.append("; containerTitle: ");
        if (r3 >= 34) {
            charSequence3 = Api34Impl.getContainerTitle(accessibilityNodeInfo);
        } else {
            charSequence3 = Api19Impl.getExtras(accessibilityNodeInfo).getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
        }
        sb.append(charSequence3);
        sb.append("; granularScrollingSupported: ");
        sb.append(getBooleanProperty(67108864));
        sb.append("; importantForAccessibility: ");
        sb.append(accessibilityNodeInfo.isImportantForAccessibility());
        sb.append("; visible: ");
        sb.append(accessibilityNodeInfo.isVisibleToUser());
        sb.append("; isTextSelectable: ");
        if (r3 >= 33) {
            booleanProperty = Api33Impl.isTextSelectable(accessibilityNodeInfo);
        } else {
            booleanProperty = getBooleanProperty(8388608);
        }
        sb.append(booleanProperty);
        sb.append("; accessibilityDataSensitive: ");
        if (r3 >= 34) {
            booleanProperty2 = Api34Impl.isAccessibilityDataSensitive(accessibilityNodeInfo);
        } else {
            booleanProperty2 = getBooleanProperty(64);
        }
        sb.append(booleanProperty2);
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = accessibilityNodeInfo.getActionList();
        if (actionList != null) {
            emptyList = new ArrayList();
            int size = actionList.size();
            for (int r5 = 0; r5 < size; r5++) {
                emptyList.add(new AccessibilityActionCompat(actionList.get(r5), 0, null, null, null));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        for (int r2 = 0; r2 < emptyList.size(); r2++) {
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) emptyList.get(r2);
            String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN")) {
                Object obj = accessibilityActionCompat.mAction;
                if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                    actionSymbolicName = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
                }
            }
            sb.append(actionSymbolicName);
            if (r2 != emptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.mAction);
    }

    public AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }
}
