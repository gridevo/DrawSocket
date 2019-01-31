/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var url = "ws://localhost:8080/DrawApp/drawserver";
var ws = new WebSocket(url);

/*
 function sendMessage() {
 ws.send(messageText.value);
 messageText.value = "";
 };*/
window.onload = function () {
    var el = document.getElementById("drawingCanvas");
    console.log(el)
    el.onclick = function (ev) {
        console.log(ev)
        ws.send(JSON.stringify({posX: ev.clientX, posY: ev.clientY}));
    };
    ws.onmessage = function getMessage(message) {
        var msg = JSON.parse(message.data);
        var c = document.getElementById("drawingCanvas");
        var ctx = c.getContext("2d");
        ctx.fillStyle = msg.colorCode;
        ctx.fillRect(msg.posX, msg.posY, 100, 100);
        console.log(msg);
    };



};