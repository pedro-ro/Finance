package com.finance.demo.domain.institution;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Builder
@Getter
public class Institution {

    private final String id = UUID.randomUUID().toString();
    private final String name;

}
