package com.df4j.xcms.core.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

public class XcmsUsernamePasswordToken extends UsernamePasswordToken {

    public XcmsUsernamePasswordToken() {
    }

    public XcmsUsernamePasswordToken(String username, char[] password) {
        super(username, password);
    }

    public XcmsUsernamePasswordToken(String username, String password) {
        super(username, password);
    }

    public XcmsUsernamePasswordToken(String username, char[] password, String host) {
        super(username, password, host);
    }

    public XcmsUsernamePasswordToken(String username, String password, String host) {
        super(username, password, host);
    }

    public XcmsUsernamePasswordToken(String username, char[] password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public XcmsUsernamePasswordToken(String username, String password, boolean rememberMe) {
        super(username, password, rememberMe);
    }

    public XcmsUsernamePasswordToken(String username, char[] password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }

    public XcmsUsernamePasswordToken(String username, String password, boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
}
