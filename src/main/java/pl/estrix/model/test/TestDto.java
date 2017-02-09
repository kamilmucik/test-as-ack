package pl.estrix.model.test;

import com.sun.istack.internal.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TestDto {

    private Long id;

    @Nullable
    private String name = "";
}
