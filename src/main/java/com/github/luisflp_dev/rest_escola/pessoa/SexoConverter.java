package com.github.luisflp_dev.rest_escola.pessoa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply= true)
public class SexoConverter implements AttributeConverter<Sexo, String> {

    @Override
    public String convertToDatabaseColumn(Sexo sexo){
        if (sexo == null){
            return null;
        }

        return sexo.name().toLowerCase();
    }

    @Override
    public Sexo convertToEntityAttribute(String dbData){
        if (dbData == null){
            return null;
        }

        return Sexo.valueOf(dbData.toUpperCase());

    }
    
}

