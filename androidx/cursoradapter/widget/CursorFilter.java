package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import androidx.appcompat.widget.SuggestionsAdapter;

/* loaded from: classes.dex */
public final class CursorFilter extends Filter {
    public final CursorFilterClient mClient;

    /* loaded from: classes.dex */
    public interface CursorFilterClient {
    }

    public CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    @Override // android.widget.Filter
    public final CharSequence convertResultToString(Object obj) {
        return ((SuggestionsAdapter) this.mClient).convertToString((Cursor) obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    @Override // android.widget.Filter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.widget.Filter.FilterResults performFiltering(java.lang.CharSequence r5) {
        /*
            r4 = this;
            androidx.cursoradapter.widget.CursorFilter$CursorFilterClient r0 = r4.mClient
            androidx.appcompat.widget.SuggestionsAdapter r0 = (androidx.appcompat.widget.SuggestionsAdapter) r0
            if (r5 != 0) goto L9
            java.lang.String r5 = ""
            goto L10
        L9:
            r0.getClass()
            java.lang.String r5 = r5.toString()
        L10:
            androidx.appcompat.widget.SearchView r1 = r0.mSearchView
            int r2 = r1.getVisibility()
            r3 = 0
            if (r2 != 0) goto L34
            int r1 = r1.getWindowVisibility()
            if (r1 == 0) goto L20
            goto L34
        L20:
            android.app.SearchableInfo r1 = r0.mSearchable     // Catch: java.lang.RuntimeException -> L2c
            android.database.Cursor r5 = r0.getSearchManagerSuggestions(r1, r5)     // Catch: java.lang.RuntimeException -> L2c
            if (r5 == 0) goto L34
            r5.getCount()     // Catch: java.lang.RuntimeException -> L2c
            goto L35
        L2c:
            r5 = move-exception
            java.lang.String r0 = "SuggestionsAdapter"
            java.lang.String r1 = "Search suggestions query threw an exception."
            android.util.Log.w(r0, r1, r5)
        L34:
            r5 = r3
        L35:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            if (r5 == 0) goto L45
            int r1 = r5.getCount()
            r0.count = r1
            r0.values = r5
            goto L4a
        L45:
            r5 = 0
            r0.count = r5
            r0.values = r3
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.cursoradapter.widget.CursorFilter.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }

    @Override // android.widget.Filter
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        CursorFilterClient cursorFilterClient = this.mClient;
        Cursor cursor = ((CursorAdapter) cursorFilterClient).mCursor;
        Object obj = filterResults.values;
        if (obj != null && obj != cursor) {
            ((SuggestionsAdapter) cursorFilterClient).changeCursor((Cursor) obj);
        }
    }
}
