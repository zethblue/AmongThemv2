<%@ page import="amongthem.game.Game" %>
<%@ page import="amongthem.player.Player" %>
<%@ page import="amongthem.game.MemoryReadOutModule" %><%--
  Created by IntelliJ IDEA.
  User: Hope
  Date: 29.10.2020
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AmongThem</title>
    <link rel="stylesheet" href="amongthemcss.css">
</head>
<body>
<%Game game = new Game();
game.startGamegetPlayerList();
game.startGameCreateNewTaskListforAllPlayers(15);
game.startGameSetImposters();
game.setKillTimers();
game.startRoundMovePlayersToCafeteria();
game.startRoundSetPlayerMoveTimesAndRoute();
game.startRoundInitializeMemories();
while(!game.isFoundDeadBodyREPORT()){
    game.ticker();
}
%>

<h1 style="text-align: center">Among Them</h1>

<table style="width: 100%">
    <tr>
        <td style="width: 20%"><img id="PL1" src="images/<%=game.getPlayerNameforWebsite(1)%>.webp" alt="Player1"></td>
        <td style="width: 60%"></td>
        <td style="width: 20%"><div style="text-align: right"><img class="flippic" id="PL6" src="images/<%=game.getPlayerNameforWebsite(6)%>.webp" alt="Player6"></div></td>
    </tr>
    <tr>
        <td style="width: 20%"><img id="PL2" src="images/<%=game.getPlayerNameforWebsite(2)%>.webp" alt="Player2"></td>
        <td style="width: 60%" rowspan="3"><div style="text-align: center"><img id="AmongThemMAP" src="images/theMap.jpg" alt="Map"></div></td>
        <td style="width: 20%"><div style="text-align: right"><img class="flippic" id="PL7" src="images/<%=game.getPlayerNameforWebsite(7)%>.webp" alt="Player7"></div></td>
    </tr>
    <tr>
        <td style="width: 20%"><img id="PL3" src="images/<%=game.getPlayerNameforWebsite(3)%>.webp" alt="Player3"></td>
        <td style="width: 20%"><div style="text-align: right"><img class="flippic" id="PL8" src="images/<%=game.getPlayerNameforWebsite(8)%>.webp" alt="Player8"></div></td>
    </tr>
    <tr>
        <td style="width: 20%"><img id="PL4" src="images/<%=game.getPlayerNameforWebsite(4)%>.webp" alt="Player4"></td>
        <td style="width: 20%"><div style="text-align: right"><img class="flippic" id="PL9" src="images/<%=game.getPlayerNameforWebsite(9)%>.webp" alt="Player9"></div></td>
    </tr>
    <tr>
        <td style="width: 20%"><img id="PL5" src="images/<%=game.getPlayerNameforWebsite(5)%>.webp" alt="Player5"></td>
        <td style="width: 60%"></td>
        <td style="width: 20%"><div style="text-align: right"><img class="flippic" id="PL10" src="images/<%=game.getPlayerNameforWebsite(10)%>.webp" alt="Player10"></div></td>
    </tr>
</table>
<div id="VoteButtonId" style="text-align: center">
    <button id="VOTE"> VOTE </button>
</div>

<div>BETA - INFOS from each Players: </div>

<div>
    <%
        StringBuilder betaOut = new StringBuilder();

        for(Player p : game.getGamePlayersAlive())
        {
            MemoryReadOutModule x = new MemoryReadOutModule(p);
            betaOut.append(p.getName());
            betaOut.append("\n$$$$$\n");
            betaOut.append(x.myStatement1Getter());
            betaOut.append(x.myStatement2Getter());
        }
        String textOut = betaOut.toString();
    %>

    <div>BETA - INFOS from each Players:
        <br> <%= textOut %></div>

</div>

</body>
</html>
