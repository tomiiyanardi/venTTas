package com.yarmovezzoli.gestioninv.Factory;

import com.yarmovezzoli.gestioninv.Enums.TipoPrediccion;
import com.yarmovezzoli.gestioninv.Strategy.PrediccionDemandaStrategy;
import com.yarmovezzoli.gestioninv.Strategy.PrediccionPromedioMovil;

public class PrediccionDemandaFactory {
    private static PrediccionDemandaFactory instance;

    public PrediccionDemandaFactory() {
    }

    public static synchronized PrediccionDemandaFactory getInstance(){
        if (instance == null){
            instance = new PrediccionDemandaFactory();
        }
        return instance;
    }

    public PrediccionDemandaStrategy getPrediccionDemandaStrategy(TipoPrediccion tipoPrediccion){
        if (tipoPrediccion.equals(TipoPrediccion.PROM_MOVIL)){
            return new PrediccionPromedioMovil();
        } else {
            throw new Error("No existe este tipo de predicción");
        }
    }

}
