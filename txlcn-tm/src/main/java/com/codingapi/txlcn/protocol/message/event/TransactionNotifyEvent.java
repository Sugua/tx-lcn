package com.codingapi.txlcn.protocol.message.event;

import com.codingapi.txlcn.protocol.Protocoler;
import com.codingapi.txlcn.protocol.message.Connection;
import com.codingapi.txlcn.protocol.message.separate.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author lorne
 * @date 2020/7/1
 * @description
 */
@Slf4j
public class TransactionNotifyEvent extends TransactionMessage {

    private String result;

    /**
     * 业务执行结果
     */
    private boolean success;

    @Override
    public void handle(ApplicationContext springContext, Protocoler protocoler, Connection connection) throws Exception {
        super.handle(springContext, protocoler, connection);
        log.info("request msg =>{} tc-client =>{} execute result =>{}",groupId,applicationName,success);
        //记录tc请求通知 日志
        this.result = "ok";
        protocoler.sendMsg(connection.getUniqueKey(),this);
    }
}
