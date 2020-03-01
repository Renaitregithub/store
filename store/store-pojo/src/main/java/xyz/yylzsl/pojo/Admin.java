package xyz.yylzsl.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Admin {

    private String id;
    private String username;
    private String password;
    private String email;
    private String telephone;
    private Date lasttime;
    private String lasttimeStr;
    private String img;

    public String getLasttimeStr() {
        return lasttimeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(lasttime);
    }

    /*public void setLasttimeStr(String lasttimeStr) throws ParseException {
        lasttimeStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(lasttimeStr);
        this.lasttimeStr = lasttimeStr;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", lasttime=" + lasttime +
                ", img='" + img + '\'' +
                '}';
    }
}
