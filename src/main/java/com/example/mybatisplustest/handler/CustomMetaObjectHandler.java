package com.example.mybatisplustest.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomMetaObjectHandler.class);

    /**
     * 插入时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        /*logger.info("start insert filling...");*/
        log.info("start insert filling...");
        try {
            this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
            this.strictInsertFill(metaObject, "updateTime", Date.class, new Date());
            this.strictInsertFill(metaObject,"visibility",Integer.class,0);
        }catch (Exception e){
            log.error("自动注入失败: ",e);
        }
    }

    /**
     * 更新时的填充策略
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        logger.info("start update filling...");
        try {
            this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
        }catch (Exception e){
            log.error("自动注入失败: ",e);
        }
    }
}
