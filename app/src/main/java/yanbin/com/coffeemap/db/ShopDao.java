package yanbin.com.coffeemap.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOP".
*/
public class ShopDao extends AbstractDao<Shop, Void> {

    public static final String TABLENAME = "SHOP";

    /**
     * Properties of entity Shop.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, String.class, "id", false, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Address = new Property(2, String.class, "address", false, "ADDRESS");
        public final static Property Latitude = new Property(3, String.class, "latitude", false, "LATITUDE");
        public final static Property Longitude = new Property(4, String.class, "longitude", false, "LONGITUDE");
        public final static Property Url = new Property(5, String.class, "url", false, "URL");
        public final static Property Open_time = new Property(6, String.class, "open_time", false, "OPEN_TIME");
        public final static Property Limited_time = new Property(7, String.class, "limited_time", false, "LIMITED_TIME");
        public final static Property Socket = new Property(8, String.class, "socket", false, "SOCKET");
        public final static Property Standing_desk = new Property(9, String.class, "standing_desk", false, "STANDING_DESK");
        public final static Property Mrt = new Property(10, String.class, "mrt", false, "MRT");
        public final static Property Wifi = new Property(11, String.class, "wifi", false, "WIFI");
        public final static Property Seat = new Property(12, String.class, "seat", false, "SEAT");
        public final static Property Quit = new Property(13, String.class, "quit", false, "QUIT");
        public final static Property Tasty = new Property(14, String.class, "tasty", false, "TASTY");
        public final static Property Cheap = new Property(15, String.class, "cheap", false, "CHEAP");
        public final static Property Music = new Property(16, String.class, "music", false, "MUSIC");
        public final static Property Image_url = new Property(17, String.class, "image_url", false, "IMAGE_URL");
    }


    public ShopDao(DaoConfig config) {
        super(config);
    }
    
    public ShopDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOP\" (" + //
                "\"ID\" TEXT," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"ADDRESS\" TEXT," + // 2: address
                "\"LATITUDE\" TEXT," + // 3: latitude
                "\"LONGITUDE\" TEXT," + // 4: longitude
                "\"URL\" TEXT," + // 5: url
                "\"OPEN_TIME\" TEXT," + // 6: open_time
                "\"LIMITED_TIME\" TEXT," + // 7: limited_time
                "\"SOCKET\" TEXT," + // 8: socket
                "\"STANDING_DESK\" TEXT," + // 9: standing_desk
                "\"MRT\" TEXT," + // 10: mrt
                "\"WIFI\" TEXT," + // 11: wifi
                "\"SEAT\" TEXT," + // 12: seat
                "\"QUIT\" TEXT," + // 13: quit
                "\"TASTY\" TEXT," + // 14: tasty
                "\"CHEAP\" TEXT," + // 15: cheap
                "\"MUSIC\" TEXT," + // 16: music
                "\"IMAGE_URL\" TEXT);"); // 17: image_url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Shop entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(3, address);
        }
 
        String latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindString(4, latitude);
        }
 
        String longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindString(5, longitude);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
 
        String open_time = entity.getOpen_time();
        if (open_time != null) {
            stmt.bindString(7, open_time);
        }
 
        String limited_time = entity.getLimited_time();
        if (limited_time != null) {
            stmt.bindString(8, limited_time);
        }
 
        String socket = entity.getSocket();
        if (socket != null) {
            stmt.bindString(9, socket);
        }
 
        String standing_desk = entity.getStanding_desk();
        if (standing_desk != null) {
            stmt.bindString(10, standing_desk);
        }
 
        String mrt = entity.getMrt();
        if (mrt != null) {
            stmt.bindString(11, mrt);
        }
 
        String wifi = entity.getWifi();
        if (wifi != null) {
            stmt.bindString(12, wifi);
        }
 
        String seat = entity.getSeat();
        if (seat != null) {
            stmt.bindString(13, seat);
        }
 
        String quit = entity.getQuit();
        if (quit != null) {
            stmt.bindString(14, quit);
        }
 
        String tasty = entity.getTasty();
        if (tasty != null) {
            stmt.bindString(15, tasty);
        }
 
        String cheap = entity.getCheap();
        if (cheap != null) {
            stmt.bindString(16, cheap);
        }
 
        String music = entity.getMusic();
        if (music != null) {
            stmt.bindString(17, music);
        }
 
        String image_url = entity.getImage_url();
        if (image_url != null) {
            stmt.bindString(18, image_url);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Shop entity) {
        stmt.clearBindings();
 
        String id = entity.getId();
        if (id != null) {
            stmt.bindString(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String address = entity.getAddress();
        if (address != null) {
            stmt.bindString(3, address);
        }
 
        String latitude = entity.getLatitude();
        if (latitude != null) {
            stmt.bindString(4, latitude);
        }
 
        String longitude = entity.getLongitude();
        if (longitude != null) {
            stmt.bindString(5, longitude);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(6, url);
        }
 
        String open_time = entity.getOpen_time();
        if (open_time != null) {
            stmt.bindString(7, open_time);
        }
 
        String limited_time = entity.getLimited_time();
        if (limited_time != null) {
            stmt.bindString(8, limited_time);
        }
 
        String socket = entity.getSocket();
        if (socket != null) {
            stmt.bindString(9, socket);
        }
 
        String standing_desk = entity.getStanding_desk();
        if (standing_desk != null) {
            stmt.bindString(10, standing_desk);
        }
 
        String mrt = entity.getMrt();
        if (mrt != null) {
            stmt.bindString(11, mrt);
        }
 
        String wifi = entity.getWifi();
        if (wifi != null) {
            stmt.bindString(12, wifi);
        }
 
        String seat = entity.getSeat();
        if (seat != null) {
            stmt.bindString(13, seat);
        }
 
        String quit = entity.getQuit();
        if (quit != null) {
            stmt.bindString(14, quit);
        }
 
        String tasty = entity.getTasty();
        if (tasty != null) {
            stmt.bindString(15, tasty);
        }
 
        String cheap = entity.getCheap();
        if (cheap != null) {
            stmt.bindString(16, cheap);
        }
 
        String music = entity.getMusic();
        if (music != null) {
            stmt.bindString(17, music);
        }
 
        String image_url = entity.getImage_url();
        if (image_url != null) {
            stmt.bindString(18, image_url);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Shop readEntity(Cursor cursor, int offset) {
        Shop entity = new Shop( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // address
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // latitude
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // longitude
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // url
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // open_time
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // limited_time
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // socket
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // standing_desk
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // mrt
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // wifi
            cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12), // seat
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // quit
            cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14), // tasty
            cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15), // cheap
            cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16), // music
            cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17) // image_url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Shop entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAddress(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setLatitude(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setLongitude(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setUrl(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setOpen_time(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setLimited_time(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setSocket(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setStanding_desk(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setMrt(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setWifi(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setSeat(cursor.isNull(offset + 12) ? null : cursor.getString(offset + 12));
        entity.setQuit(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setTasty(cursor.isNull(offset + 14) ? null : cursor.getString(offset + 14));
        entity.setCheap(cursor.isNull(offset + 15) ? null : cursor.getString(offset + 15));
        entity.setMusic(cursor.isNull(offset + 16) ? null : cursor.getString(offset + 16));
        entity.setImage_url(cursor.isNull(offset + 17) ? null : cursor.getString(offset + 17));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Shop entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Shop entity) {
        return null;
    }

    @Override
    public boolean hasKey(Shop entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
