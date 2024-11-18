package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import learningpath.activity.ResourceActivity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceActivityTest {
	private ResourceActivity resourceActivity;
	
	@BeforeEach
	void setUp() throws Exception {
		resourceActivity = new ResourceActivity("Resource 1", "Description", "Objective", 60, true, "https://example.com");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		resourceActivity = null;
	}
	
	@Test
	@DisplayName("Constructor con entrada nula (url)")
	void constructorConEntradasNulas() {
		ResourceActivity r1 = new ResourceActivity("Sample Resource", "Test Description", "Objective", 60, true, null);
        assertNull(r1.getUrl());
	}
	
	@Test
	@DisplayName("Cambiar url")
	void cambiarUrl() {
		resourceActivity.setUrl("https://example.com");
		assertEquals("https://example.com", resourceActivity.getUrl());
	}
}
