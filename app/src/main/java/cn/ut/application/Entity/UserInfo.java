/**
  * Copyright 2022 bejson.com 
  */
package cn.ut.application.Entity;

/**
 * Auto-generated: 2022-07-31 8:37:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class UserInfo {

    private long id;
    private String username;
    private long phone;
    private String password;
    private boolean enable;
    private String createTime;
    private String updateTime;
    private boolean enabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean accountNonExpired;
    private String authorities;
    public void setId(long id) {
         this.id = id;
     }
     public long getId() {
         return id;
     }

    public void setUsername(String username) {
         this.username = username;
     }
     public String getUsername() {
         return username;
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

    public void setEnable(boolean enable) {
         this.enable = enable;
     }
     public boolean getEnable() {
         return enable;
     }

    public void setCreateTime(String createTime) {
         this.createTime = createTime;
     }
     public String getCreateTime() {
         return createTime;
     }

    public void setUpdateTime(String updateTime) {
         this.updateTime = updateTime;
     }
     public String getUpdateTime() {
         return updateTime;
     }

    public void setEnabled(boolean enabled) {
         this.enabled = enabled;
     }
     public boolean getEnabled() {
         return enabled;
     }

    public void setAccountNonLocked(boolean accountNonLocked) {
         this.accountNonLocked = accountNonLocked;
     }
     public boolean getAccountNonLocked() {
         return accountNonLocked;
     }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
         this.credentialsNonExpired = credentialsNonExpired;
     }
     public boolean getCredentialsNonExpired() {
         return credentialsNonExpired;
     }

    public void setAccountNonExpired(boolean accountNonExpired) {
         this.accountNonExpired = accountNonExpired;
     }
     public boolean getAccountNonExpired() {
         return accountNonExpired;
     }

    public void setAuthorities(String authorities) {
         this.authorities = authorities;
     }
     public String getAuthorities() {
         return authorities;
     }

}