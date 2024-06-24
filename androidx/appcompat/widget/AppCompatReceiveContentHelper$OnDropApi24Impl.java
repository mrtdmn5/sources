package androidx.appcompat.widget;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public final class AppCompatReceiveContentHelper$OnDropApi24Impl {
    public static boolean onDropForTextView(DragEvent dragEvent, TextView textView, Activity activity) {
        ContentInfoCompat.BuilderCompat builderCompatImpl;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                builderCompatImpl = new ContentInfoCompat.BuilderCompat31Impl(clipData, 3);
            } else {
                builderCompatImpl = new ContentInfoCompat.BuilderCompatImpl(clipData, 3);
            }
            ViewCompat.performReceiveContent(textView, builderCompatImpl.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean onDropForView(DragEvent dragEvent, View view, Activity activity) {
        ContentInfoCompat.BuilderCompat builderCompatImpl;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            builderCompatImpl = new ContentInfoCompat.BuilderCompat31Impl(clipData, 3);
        } else {
            builderCompatImpl = new ContentInfoCompat.BuilderCompatImpl(clipData, 3);
        }
        ViewCompat.performReceiveContent(view, builderCompatImpl.build());
        return true;
    }
}
