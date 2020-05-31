package com.snofty.java8;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StringTest {
    Logger logger = Logger.getLogger(StringTest.class.getSimpleName());

    @Test
    public void testLength(){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        logger.info("uuid bytes length"+ id.length());
        logger.info("base64 bytes length"+ Base64.getEncoder().encode(id.getBytes()).length);
    }

    @Test
    public void testUtil1(){
        String uuid_str = UUID.randomUUID().toString();
        String uuid_as_64 = StringUtil.uuidToBase64(uuid_str);
        logger.log(Level.INFO, "actual uuid: {0} and length: {1}",new Object[]{uuid_str, uuid_str.length()});
        info("as base64: {0} and length: {1}",uuid_as_64, uuid_as_64.length());
        info("as uuid: {0}",StringUtil.uuidFromBase64("q71IE71gTPSV4nnmG3NGVA"));
        Assert.assertEquals(uuid_str, StringUtil.uuidFromBase64(uuid_as_64));
    }

    private void info(String msg, Object... vars){
        logger.log(Level.INFO, msg, vars);
    }
}
