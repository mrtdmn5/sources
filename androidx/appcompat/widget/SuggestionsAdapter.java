package androidx.appcompat.widget;

import android.R;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cursoradapter.widget.ResourceCursorAdapter;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class SuggestionsAdapter extends ResourceCursorAdapter implements View.OnClickListener {
    public static final /* synthetic */ int $r8$clinit = 0;
    public final int mCommitIconResId;
    public int mFlagsCol;
    public int mIconName1Col;
    public int mIconName2Col;
    public final WeakHashMap<String, Drawable.ConstantState> mOutsideDrawablesCache;
    public final Context mProviderContext;
    public int mQueryRefinement;
    public final SearchView mSearchView;
    public final SearchableInfo mSearchable;
    public int mText1Col;
    public int mText2Col;
    public int mText2UrlCol;
    public ColorStateList mUrlColor;

    /* loaded from: classes.dex */
    public static final class ChildViewCache {
        public final ImageView mIcon1;
        public final ImageView mIcon2;
        public final ImageView mIconRefine;
        public final TextView mText1;
        public final TextView mText2;

        public ChildViewCache(View view) {
            this.mText1 = (TextView) view.findViewById(R.id.text1);
            this.mText2 = (TextView) view.findViewById(R.id.text2);
            this.mIcon1 = (ImageView) view.findViewById(R.id.icon1);
            this.mIcon2 = (ImageView) view.findViewById(R.id.icon2);
            this.mIconRefine = (ImageView) view.findViewById(com.kronaby.watch.app.R.id.edit_query);
        }
    }

    public SuggestionsAdapter(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.mQueryRefinement = 1;
        this.mText1Col = -1;
        this.mText2Col = -1;
        this.mText2UrlCol = -1;
        this.mIconName1Col = -1;
        this.mIconName2Col = -1;
        this.mFlagsCol = -1;
        this.mSearchView = searchView;
        this.mSearchable = searchableInfo;
        this.mCommitIconResId = searchView.getSuggestionCommitIconResId();
        this.mProviderContext = context;
        this.mOutsideDrawablesCache = weakHashMap;
    }

    public static String getStringOrNull(Cursor cursor, int r3) {
        if (r3 == -1) {
            return null;
        }
        try {
            return cursor.getString(r3);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013a  */
    @Override // androidx.cursoradapter.widget.CursorAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void bindView(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.bindView(android.view.View, android.database.Cursor):void");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final void changeCursor(Cursor cursor) {
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.mText1Col = cursor.getColumnIndex("suggest_text_1");
                this.mText2Col = cursor.getColumnIndex("suggest_text_2");
                this.mText2UrlCol = cursor.getColumnIndex("suggest_text_2_url");
                this.mIconName1Col = cursor.getColumnIndex("suggest_icon_1");
                this.mIconName2Col = cursor.getColumnIndex("suggest_icon_2");
                this.mFlagsCol = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final String convertToString(Cursor cursor) {
        String stringOrNull;
        String stringOrNull2;
        if (cursor == null) {
            return null;
        }
        String stringOrNull3 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (stringOrNull3 != null) {
            return stringOrNull3;
        }
        SearchableInfo searchableInfo = this.mSearchable;
        if (searchableInfo.shouldRewriteQueryFromData() && (stringOrNull2 = getStringOrNull(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return stringOrNull2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (stringOrNull = getStringOrNull(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return stringOrNull;
    }

    public final Drawable getDrawableFromResourceUri(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.mProviderContext.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        }
        throw new FileNotFoundException("No authority: " + uri);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.graphics.drawable.Drawable getDrawableFromResourceValue(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SuggestionsAdapter.getDrawableFromResourceValue(java.lang.String):android.graphics.drawable.Drawable");
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int r3, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(r3, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
            if (inflate != null) {
                ((ChildViewCache) inflate.getTag()).mText1.setText(e.toString());
            }
            return inflate;
        }
    }

    public final Cursor getSearchManagerSuggestions(SearchableInfo searchableInfo, String str) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        fragment.appendQueryParameter("limit", String.valueOf(50));
        return this.mProviderContext.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public final View getView(int r2, View view, ViewGroup viewGroup) {
        try {
            return super.getView(r2, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View newView = newView(viewGroup);
            ((ChildViewCache) newView.getTag()).mText1.setText(e.toString());
            return newView;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter
    public final View newView(ViewGroup viewGroup) {
        View inflate = this.mInflater.inflate(this.mLayout, viewGroup, false);
        inflate.setTag(new ChildViewCache(inflate));
        ((ImageView) inflate.findViewById(com.kronaby.watch.app.R.id.edit_query)).setImageResource(this.mCommitIconResId);
        return inflate;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        Bundle bundle;
        super.notifyDataSetChanged();
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        Bundle bundle;
        super.notifyDataSetInvalidated();
        Cursor cursor = this.mCursor;
        if (cursor != null) {
            bundle = cursor.getExtras();
        } else {
            bundle = null;
        }
        if (bundle != null) {
            bundle.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.mSearchView.onQueryRefine((CharSequence) tag);
        }
    }
}
