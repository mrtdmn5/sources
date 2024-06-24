package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.cursoradapter.widget.CursorFilter;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;

/* loaded from: classes.dex */
public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
    public CursorFilter mCursorFilter;
    public boolean mAutoRequery = true;
    public Cursor mCursor = null;
    public boolean mDataValid = false;
    public int mRowIDColumn = -1;
    public ChangeObserver mChangeObserver = new ChangeObserver();
    public MyDataSetObserver mDataSetObserver = new MyDataSetObserver();

    /* loaded from: classes.dex */
    public class ChangeObserver extends ContentObserver {
        public ChangeObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            Cursor cursor;
            CursorAdapter cursorAdapter = CursorAdapter.this;
            if (cursorAdapter.mAutoRequery && (cursor = cursorAdapter.mCursor) != null && !cursor.isClosed()) {
                cursorAdapter.mDataValid = cursorAdapter.mCursor.requery();
            }
        }
    }

    /* loaded from: classes.dex */
    public class MyDataSetObserver extends DataSetObserver {
        public MyDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = true;
            cursorAdapter.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            CursorAdapter cursorAdapter = CursorAdapter.this;
            cursorAdapter.mDataValid = false;
            cursorAdapter.notifyDataSetInvalidated();
        }
    }

    public CursorAdapter(Context context) {
    }

    public abstract void bindView(View view, Cursor cursor);

    public void changeCursor(Cursor cursor) {
        Cursor cursor2 = this.mCursor;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                ChangeObserver changeObserver = this.mChangeObserver;
                if (changeObserver != null) {
                    cursor2.unregisterContentObserver(changeObserver);
                }
                MyDataSetObserver myDataSetObserver = this.mDataSetObserver;
                if (myDataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(myDataSetObserver);
                }
            }
            this.mCursor = cursor;
            if (cursor != null) {
                ChangeObserver changeObserver2 = this.mChangeObserver;
                if (changeObserver2 != null) {
                    cursor.registerContentObserver(changeObserver2);
                }
                MyDataSetObserver myDataSetObserver2 = this.mDataSetObserver;
                if (myDataSetObserver2 != null) {
                    cursor.registerDataSetObserver(myDataSetObserver2);
                }
                this.mRowIDColumn = cursor.getColumnIndexOrThrow(TransferTable.COLUMN_ID);
                this.mDataValid = true;
                notifyDataSetChanged();
            } else {
                this.mRowIDColumn = -1;
                this.mDataValid = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String convertToString(Cursor cursor);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            return cursor.getCount();
        }
        return 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int r2, View view, ViewGroup viewGroup) {
        if (this.mDataValid) {
            this.mCursor.moveToPosition(r2);
            if (view == null) {
                ResourceCursorAdapter resourceCursorAdapter = (ResourceCursorAdapter) this;
                view = resourceCursorAdapter.mInflater.inflate(resourceCursorAdapter.mDropDownLayout, viewGroup, false);
            }
            bindView(view, this.mCursor);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.mCursorFilter == null) {
            this.mCursorFilter = new CursorFilter(this);
        }
        return this.mCursorFilter;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int r2) {
        Cursor cursor;
        if (this.mDataValid && (cursor = this.mCursor) != null) {
            cursor.moveToPosition(r2);
            return this.mCursor;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int r4) {
        Cursor cursor;
        if (!this.mDataValid || (cursor = this.mCursor) == null || !cursor.moveToPosition(r4)) {
            return 0L;
        }
        return this.mCursor.getLong(this.mRowIDColumn);
    }

    @Override // android.widget.Adapter
    public View getView(int r2, View view, ViewGroup viewGroup) {
        if (this.mDataValid) {
            if (this.mCursor.moveToPosition(r2)) {
                if (view == null) {
                    view = newView(viewGroup);
                }
                bindView(view, this.mCursor);
                return view;
            }
            throw new IllegalStateException(SubMenuBuilder$$ExternalSyntheticOutline0.m("couldn't move cursor to position ", r2));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }

    public abstract View newView(ViewGroup viewGroup);
}
