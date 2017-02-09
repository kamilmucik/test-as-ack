package pl.estrix.model.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TestDto {

    private Long id;

    private String name = "";
}
