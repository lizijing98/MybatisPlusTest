package com.example.mybatisplustest.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class CustomMetaObjectHandler implements MetaObjectHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomMetaObjectHandler.class);

    /**
     * 插入时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        logger.info("start insert filling...");
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("update_time", new Date(), metaObject);
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("start update filling...");
        this.setFieldValByName("update_time", new Date(), metaObject);
    }
}
