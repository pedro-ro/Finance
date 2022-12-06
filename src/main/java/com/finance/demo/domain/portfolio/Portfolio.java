package com.finance.demo.domain.portfolio;

import com.finance.demo.domain.asset.Asset;
import com.finance.demo.domain.institution.Institution;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;


@AllArgsConstructor
@Builder
@Getter
public class Portfolio {

    private final String id = UUID.randomUUID().toString();
    private final String name;
    private final List<Asset> assets;
    private final List<Institution> institutions;
    private final Long totalGoalPercentage;

}
