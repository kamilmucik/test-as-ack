package pl.estrix.model.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class TestDto {

    private Long id;

    @NonNull
    private String name = "";
}
