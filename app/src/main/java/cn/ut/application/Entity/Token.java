/**
  * Copyright 2022 bejson.com 
  */
package cn.ut.application.Entity;

/**
 * Auto-generated: 2022-07-30 23:42:10
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Token {



    private String tokenHead;
    private String token;
    public void setTokenHead(String tokenHead) {
         this.tokenHead = tokenHead;
     }
     public String getTokenHead() {
         return tokenHead;
     }

    public void setToken(String token) {
         this.token = token;
     }
     public String getToken() {
         return token;
     }

    @Override
    public String toString() {
        return "Token{" +
                "tokenHead='" + tokenHead + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}