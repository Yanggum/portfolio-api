package com.tia.portfolio.api.common.util;

import org.apache.commons.collections4.map.ListOrderedMap;

public class TiMap extends ListOrderedMap {

    private String toProperCase(String s, boolean isCapital) {

        String rtnValue = "";

        if(isCapital){
            rtnValue = s.substring(0, 1).toUpperCase() +
                    s.substring(1).toLowerCase();
        }else{
            rtnValue = s.toLowerCase();
        }
        return rtnValue;
    }

    private String toCamelCase(String s){
        String[] parts = s.split("_");
        StringBuilder camelCaseString = new StringBuilder();

        for (int i = 0; i < parts.length ; i++) {
            String part = parts[i];
            camelCaseString.append(toProperCase(part, (i != 0 ? true : false))) ;
        }

        return camelCaseString.toString();
    }

    public Object put(Object key, Object value) {
        return super.put(this.toCamelCase(((String) key)), value);
    }
}
