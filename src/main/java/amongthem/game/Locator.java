package amongthem.game;

import amongthem.rooms.RoomNames;

import java.util.Random;

public class Locator {

    static Random randomizer = new Random();
    static boolean randomizerboolean;

    public static RoomNames whereShallIGo(RoomNames playerLocation, RoomNames taskLocation){

        if(playerLocation == RoomNames.CAFETERIA){
            switch (taskLocation){
                case CAFETERIA: return RoomNames.CAFETERIA;
                case ADMIN:
                case COMMUNICATION:
                case ELECTRICAL:
                case STORAGE:
                    return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;

                case WEAPONS:
                case O2:
                case NAVIGATION:
                    return RoomNames.CAFETERIA_WEAPONS_PATH;

                case MEDBAY:
                case UPPER_ENGINE:
                case REACTOR:
                case SECURITY:
                    return RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;

                case LOWER_ENGINE:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;}
                    else{return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;}

                case SHIELDS:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA_WEAPONS_PATH;}
                    else{return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;}


            }
        }
        if(playerLocation == RoomNames.CAFETERIA_WEAPONS_PATH){
            switch (taskLocation){
                case CAFETERIA:
                case UPPER_ENGINE:
                case MEDBAY:
                case REACTOR:
                case SECURITY:
                case LOWER_ENGINE:
                case ELECTRICAL:
                case STORAGE:
                case ADMIN:
                    return RoomNames.CAFETERIA;


                case WEAPONS:
                case O2:
                case NAVIGATION:
                case SHIELDS:
                case COMMUNICATION:
                    return RoomNames.WEAPONS;


            }
        }
        if(playerLocation == RoomNames.WEAPONS){
            switch (taskLocation){
                case WEAPONS: return RoomNames.WEAPONS;
                case CAFETERIA:
                case ADMIN:
                case UPPER_ENGINE:
                case MEDBAY:
                case SECURITY:
                case REACTOR:
                case LOWER_ENGINE:
                case ELECTRICAL:
                    return RoomNames.CAFETERIA_WEAPONS_PATH;

                case O2:
                case NAVIGATION:
                case SHIELDS:
                case COMMUNICATION:
                    return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;

                case STORAGE:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA_WEAPONS_PATH;}
                    else{return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;}

            }
        }
        if(playerLocation == RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH){
            switch (taskLocation){
                case WEAPONS:
                case CAFETERIA:
                case UPPER_ENGINE:
                case MEDBAY:
                    return RoomNames.WEAPONS;

                case O2:
                    return RoomNames.O2;
                case NAVIGATION:
                    return RoomNames.NAVIGATION;
                case SHIELDS:
                case COMMUNICATION:
                case STORAGE:
                case LOWER_ENGINE:
                case ELECTRICAL:
                    return RoomNames.SHIELDS;

                case REACTOR:
                case SECURITY:
                case ADMIN:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.SHIELDS;}
                    else{return RoomNames.WEAPONS;}
            }
        }
        if(playerLocation == RoomNames.NAVIGATION){return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;}
        if(playerLocation == RoomNames.O2){return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;}
        if(playerLocation == RoomNames.SHIELDS){
            switch (taskLocation){
                case SHIELDS: return RoomNames.SHIELDS;
                case NAVIGATION:
                case O2:
                case WEAPONS:
                    return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;

                case COMMUNICATION:
                case STORAGE:
                case ADMIN:
                case LOWER_ENGINE:
                case SECURITY:
                case REACTOR:
                case ELECTRICAL:
                    return RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;

                case CAFETERIA:
                case MEDBAY:
                case UPPER_ENGINE:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.WEAPONS_O2_NAVIGATION_SHIELDS_PATH;}
                    else{return RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;}

            }
        }
        if(playerLocation == RoomNames.COMMUNICATION) {
            if(taskLocation == RoomNames.COMMUNICATION){return RoomNames.COMMUNICATION;}
            return RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;}
        if(playerLocation == RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH){
            switch (taskLocation){
                case COMMUNICATION: return RoomNames.COMMUNICATION;

                case SHIELDS:
                case NAVIGATION:
                case O2:
                case WEAPONS:
                    return RoomNames.SHIELDS;
                default:
                    return RoomNames.STORAGE;
            }
        }
        if(playerLocation == RoomNames.STORAGE){
            switch (taskLocation){
                case STORAGE: return RoomNames.STORAGE;
                case COMMUNICATION:
                case SHIELDS:
                case NAVIGATION:
                case O2:
                    return RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;

                case LOWER_ENGINE:
                case ELECTRICAL:
                case REACTOR:
                case SECURITY:
                    return RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;

                case ADMIN:
                case CAFETERIA:
                case MEDBAY:
                    return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;

                case WEAPONS:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;}
                    else{return RoomNames.SHIELDS_COMMUNICATION_STORAGE_PATH;}

                case UPPER_ENGINE:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;}
                    else{return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;}
            }
        }
        if(playerLocation == RoomNames.ADMIN){
            if(taskLocation == RoomNames.ADMIN){return RoomNames.ADMIN;}
            return RoomNames.CAFETERIA_ADMIN_STORAGE_PATH;
        }
        if(playerLocation == RoomNames.CAFETERIA_ADMIN_STORAGE_PATH){
            switch (taskLocation){
                case ADMIN: return RoomNames.ADMIN;

                case CAFETERIA:
                case WEAPONS:
                case MEDBAY:
                case UPPER_ENGINE:
                    return RoomNames.CAFETERIA;

                case REACTOR:
                case SECURITY:
                case O2:
                case NAVIGATION:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA;}
                    else{return RoomNames.STORAGE;}

                default: return RoomNames.STORAGE;
            }
        }
        if(playerLocation == RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH){
            switch (taskLocation){
                case MEDBAY: return RoomNames.MEDBAY;
                case CAFETERIA:
                case WEAPONS:
                case O2:
                case NAVIGATION:
                case SHIELDS:
                case COMMUNICATION:
                case STORAGE:
                case ADMIN:
                    return RoomNames.CAFETERIA;

                case ELECTRICAL:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.UPPER_ENGINE;}
                    else{return RoomNames.CAFETERIA;}

                default:
                    return RoomNames.UPPER_ENGINE;
            }
        }
        if(playerLocation == RoomNames.MEDBAY){
            if(taskLocation == RoomNames.MEDBAY){return RoomNames.MEDBAY;}
            return RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;}
        if(playerLocation == RoomNames.UPPER_ENGINE){
            switch (taskLocation){
                case UPPER_ENGINE: return RoomNames.UPPER_ENGINE;
                case REACTOR:
                case SECURITY:
                case LOWER_ENGINE:
                case ELECTRICAL:
                    return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;

                case CAFETERIA:
                case MEDBAY:
                case WEAPONS:
                case O2:
                case NAVIGATION:
                case ADMIN:
                    return RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;

                case STORAGE:
                case COMMUNICATION:
                case SHIELDS:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.CAFETERIA_MEDBAY_UPPER_ENGINE_PATH;}
                    else{return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;}


            }
        }
        if(playerLocation == RoomNames.REACTOR){
            if(taskLocation == RoomNames.REACTOR){return RoomNames.REACTOR;}
            return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;}
        if(playerLocation == RoomNames.SECURITY) {
            if(taskLocation == RoomNames.SECURITY){return RoomNames.SECURITY;}
            return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;}
        if(playerLocation == RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH){
            switch (taskLocation){
                case REACTOR: return RoomNames.REACTOR;
                case SECURITY: return RoomNames.SECURITY;

                case LOWER_ENGINE:
                case ELECTRICAL:
                case STORAGE:
                case COMMUNICATION:
                case SHIELDS:
                    return RoomNames.LOWER_ENGINE;

                case ADMIN:
                case O2:
                case NAVIGATION:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.LOWER_ENGINE;}
                    else{return RoomNames.UPPER_ENGINE;}

                default: return RoomNames.UPPER_ENGINE;

            }
        }
        if(playerLocation == RoomNames.LOWER_ENGINE){
            switch (taskLocation){
                case LOWER_ENGINE: return RoomNames.LOWER_ENGINE;
                case REACTOR:
                case SECURITY:
                case UPPER_ENGINE:
                case MEDBAY:

                    return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;

                case STORAGE:
                case ELECTRICAL:
                case COMMUNICATION:
                case SHIELDS:
                case ADMIN:
                case O2:
                case NAVIGATION:

                    return RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;

                case CAFETERIA:
                case WEAPONS:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.UPPER_ENGINE_SECURITY_REACTOR_LOWER_ENGINE_PATH;}
                    else{return RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;}


            }
        }
        if(playerLocation == RoomNames.ELECTRICAL){
            if(taskLocation == RoomNames.ELECTRICAL){return RoomNames.ELECTRICAL;}
            return RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH;}
        if(playerLocation == RoomNames.LOWER_ENGINE_ELECTRICAL_STORAGE_PATH){
            switch(taskLocation){
                case ELECTRICAL: return RoomNames.ELECTRICAL;

                case LOWER_ENGINE:
                case REACTOR:
                case SECURITY:
                case UPPER_ENGINE:
                    return RoomNames.LOWER_ENGINE;

                case MEDBAY:
                    randomizerboolean = randomizer.nextBoolean();
                    if(randomizerboolean){return RoomNames.LOWER_ENGINE;}
                    else{return RoomNames.STORAGE;}

                default: return RoomNames.STORAGE;

            }
        }

        return null;
    }
}
