package amongthem.game;

import amongthem.rooms.RoomNames;

public class RouteTickPlanner {

        public static int TicksForMoving(RoomNames playerLocation){
            switch (playerLocation){
                case CAFETERIA: return 10;
                case ADMIN:
                case SECURITY:
                    return 4;
                case UPPER_ENGINE:
                case SHIELDS:
                case COMMUNICATION:
                case WEAPONS:
                case O2:
                case CAFETERIA_ADMIN_STORAGE_PATH:
                case SHIELDS_COMMUNICATION_STORAGE_PATH:
                    return 5;
                case REACTOR:
                case CAFETERIA_MEDBAY_UPPER_ENGINE_PATH:
                case NAVIGATION:
                case UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH:
                    return 6;
                case MEDBAY:
                case LOWER_ENGINE_ELECTRICAL_STORAGE_PATH:
                    return 8;
                case WEAPONS_O2_NAVIGATION_SHIELDS_PATH:return 11;
                case ELECTRICAL:
                case LOWER_ENGINE:
                    return 7;
                case STORAGE: return 9;
                case CAFETERIA_WEAPONS_PATH: return 3;
                default: return -1;
            }
    }

}
