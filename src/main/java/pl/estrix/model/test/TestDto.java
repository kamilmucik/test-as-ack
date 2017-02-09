package pl.estrix.model.test;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class TestDto {

    @NonNull
    private String name;
}
