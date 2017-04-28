package com.example.haruta.myapplication.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class AuthUtilTest {

    @Test
    public void 空のIDPASSは認証False() throws Exception {
        assertFalse(AuthUtil.isAuthorized("", ""));
    }

    @Test
    public void 認証True() throws Exception {
        assertTrue(AuthUtil.isAuthorized("hoge", "1234"));
    }
}