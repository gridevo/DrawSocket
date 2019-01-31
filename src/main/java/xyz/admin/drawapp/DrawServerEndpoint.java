/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.admin.drawapp;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Administratör
 */
@ServerEndpoint("/drawserver")
public class DrawServerEndpoint {

    static final String[] colors = new String[]{
        "#8e24aa",
        "#ad1457",
        "#283593",
        "#1b5e20"
    };
    
    static Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void open(Session user) {
        sessions.add(user);
    }

    @OnClose
    public void close(Session user) {
        sessions.remove(user);
    }

    @OnMessage
    public void onMessage(String message, Session user) throws IOException {
        Iterator<Session> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            iterator.next().getBasicRemote().sendText(buildJsonData(user, message));
        }
    }

    private String buildJsonData(Session user, String text) {
        Gson gson = new Gson();
        
        JsonObject obj = new JsonParser().parse(text).getAsJsonObject();
        
        String color = colors[(int)Math.floor(Math.random() * colors.length)];
        
        Message message = new Message(color, obj.get("posX").getAsInt(), obj.get("posY").getAsInt());
        return gson.toJson(message);
    }

}
