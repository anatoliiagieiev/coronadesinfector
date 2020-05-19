package com.github.romankh3.coronadesinfector;

import com.github.romankh3.coronadesinfector.infrastructure.InjectByType;

public class CoronaDesinfector {

    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию,все вон!");
        policeman.makePeopleLEaveRoom();
        desinfect(room);
        announcer.announce("Можете рискнуть и зайти обратно!");
    }

    private void desinfect(Room room) {
        System.out.println("Зачитывается молитва: 'корона изыди' - молитва прочитана, вирус низвергнут в ад");
    }

}
