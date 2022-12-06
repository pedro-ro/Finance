package com.finance.demo.domain.asset;

import com.finance.demo.domain.institution.Institution;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class Asset {

    private final String id = UUID.randomUUID().toString();
    private final String name;
    private final Long quantity;
    private Long goalPercentage;
    private final List<Institution> institutions = new ArrayList<>();

    public Asset(String name, Long quantity, Institution institution) {
        this(name, quantity);
        this.institutions.add(institution);
    }

    public Asset(String name, Long quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
