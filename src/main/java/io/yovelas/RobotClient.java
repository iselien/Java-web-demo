package io.yovelas;

import io.socket.client.IO;
import io.socket.client.Socket;

import java.lang.ref.WeakReference;
import java.util.logging.SocketHandler;

public class RobotClient {

    private Socket mSocket;
    private String url = "https://zhibo.jianzhengmx.com:9501";

    public RobotClient() {
    }

    public void init(){
        try {
            IO.Options option = new IO.Options();
            option.forceNew = true;
            //broadcastoption.transports = new String[] {"websocket"};
            option.reconnection = true;
            option.reconnectionDelay = 2000;
            mSocket = IO.socket(url, option);
            mSocket.connect();
//            SocketHandler mSocketHandler = new SocketHandler(listener);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void emit(String event, Object o){
        mSocket.emit(event, o);
    }

    public void disconnect(){
        mSocket.disconnect();
    }

//    private static class SocketHandler extends Handler {//收到服务器的消息,处理消息，可能别的观众的发言
//
//        private SocketMessageListener mListener;
//        private String mLiveUid;
//
//        public SocketHandler(SocketMessageListener listener) {
//            mListener = new WeakReference<>(listener).get();
//        }
//
//        public void setLiveUid(String liveUid) {
//            mLiveUid = liveUid;
//        }
//
//        @Override
//        public void handleMessage(Message msg) {
//            if (mListener == null) {
//                return;
//            }
//            switch (msg.what) {
//                case Constants.SOCKET_WHAT_CONN:
//                    mListener.onConnect((Boolean) msg.obj);
//                    break;
//                case Constants.SOCKET_WHAT_BROADCAST:
//                    processBroadcast((String) msg.obj);
//                    break;
//                case Constants.SOCKET_WHAT_DISCONN:
//                    mListener.onDisConnect();
//                    break;
//            }
//        }


}
