/*
 * Copyright (c) Romanov Alexey, 2024
 */
package ru.romanow.model.processing.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Accessors(chain = true)
public class ProductScenarioModel {
    private UUID id;
    private LocalDateTime actualDateFrom;
    private LocalDateTime actualDateTo;
    private String productTreeCode;
    private String productScenarioCode;
    private Long orderBy;
    private String measureName;
    private String measureValue;
    private String measureGroup;
    private Boolean weightParam;
    private String cfCode;
    private String segmentId;
    private String rateTypeId;
    private String ccy;
    private Integer measureStatus;
    private Integer measureParent;
}