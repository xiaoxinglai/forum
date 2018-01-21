package com.nchu.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by user12 on 2018/1/4.
 */
@Component
@ServerEndpoint("/webSocket")
@Slf4j
class WebSocket {

    private Session session;

    //用这个set来存储session
    private static CopyOnWriteArraySet<WebSocket>  webSocketSet=new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(){
        this.session=session;
        webSocketSet.add(this);
        log.info("websocket消息,有新的连接，总数:{}",webSocketSet.size());

    }

//    @OnClose
//    public  void onClo

}
