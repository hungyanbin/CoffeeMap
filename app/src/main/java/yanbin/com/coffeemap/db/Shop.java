package yanbin.com.coffeemap.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Shop {

    private String id;
    private String name;
    private String address;
    private String latitude;
    private String longitude;
    private String url;
    private String open_time;
    private String limited_time;
    private String socket;
    private String standing_desk;
    private String mrt;
    private String wifi;
    private String seat;
    private String quit;
    private String tasty;
    private String cheap;
    private String music;

    @Generated(hash = 1953455839)
    public Shop(String id, String name, String address, String latitude,
            String longitude, String url, String open_time, String limited_time,
            String socket, String standing_desk, String mrt, String wifi,
            String seat, String quit, String tasty, String cheap, String music) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
        this.open_time = open_time;
        this.limited_time = limited_time;
        this.socket = socket;
        this.standing_desk = standing_desk;
        this.mrt = mrt;
        this.wifi = wifi;
        this.seat = seat;
        this.quit = quit;
        this.tasty = tasty;
        this.cheap = cheap;
        this.music = music;
    }
    @Generated(hash = 633476670)
    public Shop() {
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getLatitude() {
        return this.latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return this.longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getOpen_time() {
        return this.open_time;
    }
    public void setOpen_time(String open_time) {
        this.open_time = open_time;
    }
    public String getLimited_time() {
        return this.limited_time;
    }
    public void setLimited_time(String limited_time) {
        this.limited_time = limited_time;
    }
    public String getSocket() {
        return this.socket;
    }
    public void setSocket(String socket) {
        this.socket = socket;
    }
    public String getStanding_desk() {
        return this.standing_desk;
    }
    public void setStanding_desk(String standing_desk) {
        this.standing_desk = standing_desk;
    }
    public String getMrt() {
        return this.mrt;
    }
    public void setMrt(String mrt) {
        this.mrt = mrt;
    }
    public String getWifi() {
        return this.wifi;
    }
    public void setWifi(String wifi) {
        this.wifi = wifi;
    }
    public String getSeat() {
        return this.seat;
    }
    public void setSeat(String seat) {
        this.seat = seat;
    }
    public String getQuit() {
        return this.quit;
    }
    public void setQuit(String quit) {
        this.quit = quit;
    }
    public String getTasty() {
        return this.tasty;
    }
    public void setTasty(String tasty) {
        this.tasty = tasty;
    }
    public String getCheap() {
        return this.cheap;
    }
    public void setCheap(String cheap) {
        this.cheap = cheap;
    }
    public String getMusic() {
        return this.music;
    }
    public void setMusic(String music) {
        this.music = music;
    }


}
