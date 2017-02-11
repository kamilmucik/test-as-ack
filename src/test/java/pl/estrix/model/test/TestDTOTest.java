package pl.estrix.model.test;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class TestDTOTest {

	@Test
	public void shouldCreateObjectByBuilder(){
		TestDto dtoObject = TestDto
				.builder()
				.name("test")
				.build();

		assertThat(dtoObject.getName())
				.isEqualTo("test");

	}

	@Test
	public void shouldCreateObjectInTwoWays(){
		TestDto dtoObject1 = TestDto.builder().name("name").build();
		TestDto dtoObject2 = new TestDto("name");

		assertThat(dtoObject1.getName())
				.isEqualTo(dtoObject2.getName());

	}

	@Test
	public void shouldImplementToString() {
		assertThat(TestDto.builder().toString())
				.isEqualTo("TestDto.TestDtoBuilder(name=null)");
		assertThat(new TestDto("name").toString())
				.isEqualTo("TestDto(name=name)");

	}

	@Test(expected = NullPointerException.class)
	public void shouldReceiveNullFromObjectDTO() {
		TestDto dtoObject = TestDto.builder().build();

		assertThat(dtoObject).hasFieldOrProperty("name").isEqualTo(null);
	}
}
