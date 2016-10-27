package com.example;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.mockito.Mockito;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.when;

public class BaseTest {

	@Before
	public void setup() {
		ProducerService producerService = Mockito.mock(ProducerService.class);
		when(producerService.canGetTheBeer(argThat(personIsOldEnough()))).thenReturn(true);
		when(producerService.canGetTheBeer(argThat(personIsTooYoung()))).thenReturn(false);

		RestAssuredMockMvc.standaloneSetup(new ProducerController(producerService));
	}

	private TypeSafeMatcher<PersonToCheck> personIsOldEnough() {
		return new TypeSafeMatcher<PersonToCheck>() {
			@Override public void describeTo(Description description) {

			}
			@Override
			protected boolean matchesSafely(PersonToCheck item) {
				return item.age >= 20;
			}
		};
	}
	private TypeSafeMatcher<PersonToCheck> personIsTooYoung() {
		return new TypeSafeMatcher<PersonToCheck>() {
			@Override public void describeTo(Description description) {

			}
			@Override
			protected boolean matchesSafely(PersonToCheck item) {
				return item.age < 20;
			}
		};
	}

}
