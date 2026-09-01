package com.github.luisflp_dev.rest_escola.pessoa.professor;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EstadoCivilConverter implements AttributeConverter<EstadoCivil, String> {

    @Override
    public String convertToDatabaseColumn(EstadoCivil estadoCivil){
        if (estadoCivil == null){
            return null;
        }

        return estadoCivil.name().toLowerCase();
    }

    @Override
    public EstadoCivil convertToEntityAttribute(String dbData){
        if (dbData == null){
            return null;
        }

        return EstadoCivil.valueOf(dbData.toUpperCase());

    }
}
