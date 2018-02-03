package com.nchu.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
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
public class WebSocket {


    private Session session;

    //用这个set来存储session
    /**
     * 存储session的容器
     */
    private static CopyOnWriteArraySet<WebSocket>  webSocketSet=new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        log.info("websocket消息,有新的连接，总数:{}",webSocketSet.size());

    }

    @OnClose
    public  void onClose(){
        webSocketSet.remove(this);
        log.info("连接断开，当前总数:{}",webSocketSet.size());
    }
    @OnMessage
    public void onMessage(String message){
        log.info("收到客户端发来的消息:{}",message);
    }

    public void sendMessage(String messgae){

     for (WebSocket webSocket:webSocketSet){
         log.info("websocket消息,广播消息:{}",messgae);
         try {
             webSocket.session.getBasicRemote().sendText(messgae);
         }catch (Exception e){
             log.info("异常:{}",e);
         }

     }
    }

}
