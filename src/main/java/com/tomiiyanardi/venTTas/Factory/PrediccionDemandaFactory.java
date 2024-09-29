package com.tomiiyanardi.venTTas.Factory;

import com.tomiiyanardi.venTTas.Enums.TipoPrediccion;
import com.tomiiyanardi.venTTas.Strategy.PrediccionDemandaStrategy;
import com.tomiiyanardi.venTTas.Strategy.PrediccionPromedioMovil;

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
