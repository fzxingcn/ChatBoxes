package com.chat.netty.handling.message;

import com.chat.entity.InformationOperateMap;
import com.chat.entity.MageBena;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.*;

/**
 * socket处理类
 */

public class SocketMessageHanding {


    private WebSocketServerHandshaker handshaker;

    private ChannelHandlerContext ctx;

    private String sessionId;
    private String table;
    private String name;
    /**
     * 处理Socket请求
     * @param ctx
     * @param frame
     * @throws Exception
     */
    public void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // 判断是否是关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否是Ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 当前只支持文本消息，不支持二进制消息
        if ((frame instanceof TextWebSocketFrame)) {
            //throw new UnsupportedOperationException("当前只支持文本消息，不支持二进制消息");
            //获取发来的消息
            String text =((TextWebSocketFrame)frame).text();
            System.out.println("mage : " + text);
            //消息转成Mage
            MageBena mage = MageBena.strJson2Mage(text);
            //判断是以存在用户信息
            if (InformationOperateMap.isNo(mage)) {
                //判断是否有这个聊天室
                if (InformationOperateMap.map.containsKey(mage.getTable())) {
                    //判断是否有其他用户
                    if (InformationOperateMap.map.get(mage.getTable()).size() > 0) {
                        InformationOperateMap.map.get(mage.getTable()).forEach((id, iom) -> {
                            try {
                                MageBena mag = iom.getMage();
                                mag.setMessage("30003");
                                //发送其他用户信息给要注册用户
                                this.sendWebSocket(mag.toJson());
                            } catch (Exception e) {
                                System.err.println(e);
                            }
                        });
                    }
                }
                //添加用户
                InformationOperateMap.add(ctx, mage);
                System.out.println("add : " + mage.toJson());
            }
            //将用户发送的消息发给所有在同一聊天室内的用户
            InformationOperateMap.map.get(mage.getTable()).forEach((id, iom) -> {
                try {
                    iom.sead(mage);
                } catch (Exception e) {
                    System.err.println(e);
                }
            });
            //记录id和table 当页面刷新或浏览器关闭时，注销掉此链路
            this.sessionId = mage.getUserId();
            this.table = mage.getTable();
            this.name = mage.getUserName();
        } else {
            System.err.println("------------------error--------------------------");
        }
    }

    /**
     * WebSocket返回
     */
    public void sendWebSocket(String msg) throws Exception {
        if (this.handshaker == null || this.ctx == null || this.ctx.isRemoved()) {
            throw new Exception("尚未握手成功，无法向客户端发送WebSocket消息");
        }
        //发送消息
        this.ctx.channel().write(new TextWebSocketFrame(msg));
        this.ctx.flush();
    }


}
