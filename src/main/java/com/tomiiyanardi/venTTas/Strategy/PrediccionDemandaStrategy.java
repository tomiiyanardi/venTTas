package com.tomiiyanardi.venTTas.Strategy;

import java.util.Map;

public interface PrediccionDemandaStrategy {

    double predecirDemanda(Map<String, Object> parametros);

}
