///*
//package com.hnu;
//
//import com.alibaba.fastjson.JSONObject;
//import io.netty.buffer.ByteBuf;
//import io.netty.buffer.Unpooled;
//import io.netty.channel.*;
//import io.netty.handler.codec.http.DefaultFullHttpResponse;
//import io.netty.handler.codec.http.FullHttpRequest;
//import io.netty.handler.codec.http.HttpResponseStatus;
//import io.netty.handler.codec.http.HttpVersion;
//import io.netty.handler.codec.http.websocketx.*;
//import io.netty.util.CharsetUtil;
//
//import static io.netty.handler.codec.http.HttpHeaderNames.HOST;
//import static io.netty.handler.codec.http.HttpUtil.isKeepAlive;
//
//*/
///**
// * @description:
// * @author: YUANHX
// * @create: 9:32 上午
// **//*
//
//public class MyWebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
//
//    private static final String WEBSOCKET_PATH = "";
//    private WebSocketServerHandshaker handshaker;
//
//    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        if (msg instanceof FullHttpRequest) {
//            //以http请求形式接入，但是走的是websocket
//            handleHttpRequest(ctx, (FullHttpRequest) msg);
//        } else if (msg instanceof WebSocketFrame) {
//            //处理websocket客户端的消息
//            handleWebSocketFrame(ctx, (WebSocketFrame) msg);
//        }
//    }
//
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
//    }
//
//    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req) throws Exception {
//        //要求Upgrade为websocket,过滤掉get/post
//        if (!req.decoderResult().isSuccess() || !"websocket".equals(req.headers().get("Upgrade"))) {
//            // 若不适websocket方式，则创建BAD_REQUEST的req,返回给客户端
//            sendHttpResponse(ctx, req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
//            return;
//        }
//
//        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://localhost:9502/websocket", null, false);
//        handshaker = wsFactory.newHandshaker(req);
//        if (handshaker == null) {
//            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
//        } else {
//            handshaker.handshake(ctx.channel(), req);
//        }
//    }
//
//    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) {
//        // check for closing frame
//        if (frame instanceof CloseWebSocketFrame) {
//            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
//            return;
//        }
//        if (frame instanceof PingWebSocketFrame) {
//            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
//            return;
//        }
//        if (!(frame instanceof TextWebSocketFrame)) {
//            System.out.println("数据桢类型不支持！");
//            throw new UnsupportedOperationException(String.format("%s frame types not supported", frame.getClass().getName()));
//        }
//        //Send the uppercase string back
//        String request = ((TextWebSocketFrame) frame).text();
//        System.out.println("Netty服务器接受到的信息：" + request);
//        if (request.equals(Const.HEARTBEAT)) {
//            ctx.channel().write(new TextWebSocketFrame(request));
//            return;
//        }
//
//        JSONObject jsonData = JSONObject.parseObject(request);
//        String eventType = jsonData.getString("event_type");
//        String apiToken = jsonData.getString("api_token");
//        if (Const.FRONT.equals(eventType)) {
//            Print.info("front event");
//            ChannelSupervise.updateChannel(apiToken, ctx.channel());
//        } else if (Const.BEHIND.equals(eventType)) {
//            Print.info("behind event");
//            Channel chan = ChannelSupervise.findChannel(apiToken);
//            if (null == chan) {
//                System.out.println("目标用户不存在");
//            } else {
//                JSONObject jsonMsg = new JSONObject();
//                jsonMsg.put("type", jsonData.get("type"));
//                jsonMsg.put("child_type", jsonData.get("child_type"));
//                jsonMsg.put("title", jsonData.get("title"));
//                jsonMsg.put("body", jsonData.get("body"));
//                ChannelSupervise.sendToSimple(apiToken, new TextWebSocketFrame(jsonMsg.toString()));
//                System.out.println("向目标用户发送成功");
//            }
//        } else {
//            System.out.println("event type error");
//        }
//    }
//
//    private static void sendHttpResponse(ChannelHandlerContext ctx,
//                                         FullHttpRequest req, DefaultFullHttpResponse res) {
//        // 返回应答给客户端
//        if (res.status().code() != 200) {
//            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
//            res.content().writeBytes(buf);
//            buf.release();
//        }
//
//        ChannelFuture f = ctx.channel().writeAndFlush(res);
//        // 如果是非Keep-Alive，关闭连接
//        if (!isKeepAlive(req) || res.status().code() != 200) {
//            f.addListener(ChannelFutureListener.CLOSE);
//        }
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        cause.printStackTrace();
//        ctx.close();
//    }
//
//    private static String getWebSocketLocation(FullHttpRequest req) {
//        return "ws://" + req.headers().get(HOST) + WEBSOCKET_PATH;
//    }
//
//    */
///**
//     * 接收客户端连接事件
//     *//*
//
//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("客户端与服务端连接开启：" + ctx.channel());
//        ChannelSupervise.addChannel(null, ctx.channel());
//    }
//
//    */
///**
//     * 接收客户端关闭事件
//     *//*
//
//    @Override
//    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("客户端与服务端连接关闭：" + ctx.channel());
//        ChannelSupervise.removeChannel(ctx.channel());
//    }
//
//}
//
//*/
