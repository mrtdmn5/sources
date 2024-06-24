package androidx.cursoradapter.widget;

import android.content.Context;
import android.view.LayoutInflater;

/* loaded from: classes.dex */
public abstract class ResourceCursorAdapter extends CursorAdapter {
    public final int mDropDownLayout;
    public final LayoutInflater mInflater;
    public final int mLayout;

    @Deprecated
    public ResourceCursorAdapter(Context context, int r2) {
        super(context);
        this.mDropDownLayout = r2;
        this.mLayout = r2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }
}
