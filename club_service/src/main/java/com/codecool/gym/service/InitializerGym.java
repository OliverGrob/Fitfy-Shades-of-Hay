package com.codecool.gym.service;

import com.codecool.gym.model.Gym;
import com.codecool.gym.repository.GymRepository;
import org.springframework.stereotype.Component;

@Component
public class InitializerGym {


    public InitializerGym(GymRepository repository) {
        repository.save(new Gym("Budapest", "1111", "Budafitness", "Bercsényi utca 12", "http://www.budafitness.hu" ));
        repository.save(new Gym("Budapest", "1223", "Hajos Alfred Tanuszoda", "Nagytétényi ??t 31", "http://www.hofeherfoka.hu" ));
        repository.save(new Gym("Budapest", "1188", "Ágnes Fitness", "Kisfaludy utca 56b", "http://www.agnesfitness.hu" ));
        repository.save(new Gym("Budapest", "1188", "Nemes Fitness", "Nemes utca 103", "http://www.nemes-fitness.hu" ));
        repository.save(new Gym("Budapest", "2230", "Gyomroi uszoda", "Gyömrő, Pál Mihály utca", "http://www.harmonia-k.hu/uszoda.html" ));
        repository.save(new Gym("Budapest", "1212", "Csepel Sport Club", "Béke tér 1", "http://csepelsca.hu"));
        repository.save(new Gym("Budapest", "1203", "Fitness 2000", "Serény utca 2", "http://www.fitness2000.hu" ));
        repository.save(new Gym("Maglód", "2234", "M38 Konditerem", "Mátyás király utca ", "http://www.m38konditerem.hu" ));
        repository.save(new Gym("Budapest", "1191", "Megafitness", "Vak Bottyán utca 75", "http://www.megafitness.hu" ));
        repository.save(new Gym("Budapest", "1117", "Gold Center", "Budafoki út 113", "http://www.goldcenter.hu" ));
        repository.save(new Gym("Budapest", "1103", "Príma Wellness", "Gyömrői út 99", "http://www.primawellness.hu" ));
        repository.save(new Gym("Budapest", "1108", "Adria Fitnesz Edzőterem", "Újhegyi sétány 10", "http://www.adriafitnesz.hu" ));
        repository.save(new Gym("Budapest", "1082", "Life1 Wellness", "Futó út 48", "http://www.life1wellness.hu" ));
        repository.save(new Gym("Budapest", "1065", "Bootcampclub Budapest", "Rákóczi út 70", "http://www.bootcampclubbudapest.com" ));
        repository.save(new Gym("Budapest", "1012", "POLGÁR GYM", " Attila út 107", "http://polgargym.5mp.eu" ));
        repository.save(new Gym("Budapest", "1065", "Multifit Fitness Stúdió", "Lázár utca 9", "http://www.multifitstudio.hu" ));
        repository.save(new Gym("Budapest", "1106", "Jump Fitness Kft.", "Fehér út 1", "http://jumpfitness.hu" ));

    }


}
