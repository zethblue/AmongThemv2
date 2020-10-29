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
    <link rel="stylesheet" href="amongthem.css">
    <title>AmongThem</title>
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

<div class="container">
    <h2>Large Modal</h2>
    <!-- Trigger the modal with a button -->
    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Large Modal</button>

    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">×</button>
                    <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                    <p>This is a large modal.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div>
    <%
        StringBuilder betaOut = new StringBuilder();

        for(Player p : game.getGamePlayersAlive())
        {
            MemoryReadOutModule x = new MemoryReadOutModule(p);
            out.println(x.MemoryExtractor());
            out.println("<br>");
        }
    %>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
