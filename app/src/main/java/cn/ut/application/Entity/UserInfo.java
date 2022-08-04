/**
  * Copyright 2022 bejson.com 
  */
package cn.ut.application.Entity;
import java.util.List;
import java.util.Date;

/**
 * Auto-generated: 2022-08-04 18:37:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class UserInfo {

    private int id;
    private String username;
    private String nickname;
    private long phone;
    private String password;
    private List<Roles> roles;
    private boolean enable;
    private Date create_time;
    private Date update_time;
    private boolean enabled;
    private List<Authorities> authorities;
    private boolean accountNonLocked;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setUsername(String username) {
         this.username = username;
     }
     public String getUsername() {
         return username;
     }

    public void setNickname(String nickname) {
         this.nickname = nickname;
     }
     public String getNickname() {
         return nickname;
     }

    public void setPhone(long phone) {
         this.phone = phone;
     }
     public long getPhone() {
         return phone;
     }

    public void setPassword(String password) {
         this.password = password;
     }
     public String getPassword() {
         return password;
     }

    public void setRoles(List<Roles> roles) {
         this.roles = roles;
     }
     public List<Roles> getRoles() {
         return roles;
     }

    public void setEnable(boolean enable) {
         this.enable = enable;
     }
     public boolean getEnable() {
         return enable;
     }

    public void setCreate_time(Date create_time) {
         this.create_time = create_time;
     }
     public Date getCreate_time() {
         return create_time;
     }

    public void setUpdate_time(Date update_time) {
         this.update_time = update_time;
     }
     public Date getUpdate_time() {
         return update_time;
     }

    public void setEnabled(boolean enabled) {
         this.enabled = enabled;
     }
     public boolean getEnabled() {
         return enabled;
     }

    public void setAuthorities(List<Authorities> authorities) {
         this.authorities = authorities;
     }
     public List<Authorities> getAuthorities() {
         return authorities;
     }

    public void setAccountNonLocked(boolean accountNonLocked) {
         this.accountNonLocked = accountNonLocked;
     }
     public boolean getAccountNonLocked() {
         return accountNonLocked;
     }

    public void setAccountNonExpired(boolean accountNonExpired) {
         this.accountNonExpired = accountNonExpired;
     }
     public boolean getAccountNonExpired() {
         return accountNonExpired;
     }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
         this.credentialsNonExpired = credentialsNonExpired;
     }
     public boolean getCredentialsNonExpired() {
         return credentialsNonExpired;
     }

}