/*
 * Copyright (c) Romanov Alexey, 2024
 */
package ru.romanow.model.processing.model;

import lombok.experimental.UtilityClass;
import ru.romanow.model.processing.entity.ProductScenarioEntity;

@UtilityClass
public final class ModelBuilder {

    public static ProductScenarioModel toModel(ProductScenarioEntity entity) {
        return new ProductScenarioModel()
                .setId(entity.getId())
                .setActualDateFrom(entity.getActualDateFrom())
                .setActualDateTo(entity.getActualDateTo())
                .setProductTreeCode(entity.getProductTreeCode())
                .setProductScenarioCode(entity.getProductScenarioCode())
                .setOrderBy(entity.getOrderBy())
                .setMeasureName(entity.getMeasureName())
                .setMeasureValue(entity.getMeasureValue())
                .setMeasureGroup(entity.getMeasureGroup())
                .setWeightParam(entity.getWeightParam())
                .setCfCode(entity.getCfCode())
                .setSegmentId(entity.getSegmentId())
                .setRateTypeId(entity.getRateTypeId())
                .setCcy(entity.getCcy())
                .setMeasureStatus(entity.getMeasureStatus())
                .setMeasureParent(entity.getMeasureParent());
    }
}
