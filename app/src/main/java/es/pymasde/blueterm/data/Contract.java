package es.pymasde.blueterm.data;

import android.net.Uri;
import android.provider.BaseColumns;

public final class Contract {

    public static final String CONTENT_AUTHORITY = "es.pymasde.blueterm.data";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    private Contract() {
    }

    public static final class Entry implements BaseColumns {

        public static final Uri CONTENT_URI = BASE_CONTENT_URI;

        public final static String TABLE_NAME = "SOS_Database";
        public final static String _ID = BaseColumns._ID;
        public final static String NAME = "Name";
        public final static String NUMBER = "Number";
    }
}
