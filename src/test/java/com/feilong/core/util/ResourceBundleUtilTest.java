/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.core.util;

import static org.junit.Assert.assertEquals;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feilong.tools.jsonlib.JsonUtil;

/**
 * The Class ResourceBundleUtilTest.
 * 
 * @author feilong
 * @version 1.0.7 2014-6-25 15:21:15
 */
public class ResourceBundleUtilTest{

    /** The Constant LOGGER. */
    private static final Logger  LOGGER         = LoggerFactory.getLogger(ResourceBundleUtilTest.class);

    /** The base name. */
    private static final String  BASE_NAME      = "messages/feilong-core-test";

    /** The resource bundle. */
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);

    /**
     * Test get value.
     */
    @Test
    public void testGetValue(){
        assertEquals("5,8,7,6", ResourceBundleUtil.getValue(BASE_NAME, "config_test_array"));
    }

    /**
     * Test with space value.
     */
    @Test
    public void testWithSpaceValue(){
        assertEquals("a ", ResourceBundleUtil.getValue(BASE_NAME, "with_space_value"));
    }

    /**
     * Gets the value with arguments.
     * 
     */
    @Test
    public void testGetValueWithArguments(){
        assertEquals("今天 2", ResourceBundleUtil.getValueWithArguments(resourceBundle, "test", "2", "22"));
    }

    /**
     * Read properties as array.
     */
    @Test
    public void readPropertiesAsArray(){
        LOGGER.info(JsonUtil.format(ResourceBundleUtil.getArray(resourceBundle, "config_test_array", ",", String.class)));
        LOGGER.info(JsonUtil.format(ResourceBundleUtil.getArray(resourceBundle, "config_test_array", ",", Integer.class)));
    }

    /**
     * Read prefix as map.
     */
    @Test
    public void readPrefixAsMap(){
        Map<String, String> map = ResourceBundleUtil.readPrefixAsMap(BASE_NAME, "FileType", ".", Locale.CHINA);
        LOGGER.info(JsonUtil.format(map));
    }

    /**
     * Read all properties to map.
     */
    @Test
    public void readAllPropertiesToMap(){
        Map<String, String> map = ResourceBundleUtil.readAllPropertiesToMap(BASE_NAME, Locale.CHINA);
        LOGGER.info(JsonUtil.format(map));
    }

    /**
     * Read all properties to map.
     * 
     */
    @Test
    public void testGetValue1(){
        LOGGER.info(ResourceBundleUtil.getValue(BASE_NAME, "config_date_hour", Locale.ENGLISH));
    }
}
