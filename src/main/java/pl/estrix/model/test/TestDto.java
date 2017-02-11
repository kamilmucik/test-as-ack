package pl.estrix.model.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
public class TestDto {

    @NonNull
    private String name;
}
