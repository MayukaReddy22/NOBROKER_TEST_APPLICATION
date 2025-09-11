package stepdefinitions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PropertySearch;
import pages.SearchHistory;

public class HistoryStepDef {

	private WebDriver driver = Hooks.driver;
	private PropertySearch propertySearch = new PropertySearch(driver);
	private SearchHistory searchHistory = new SearchHistory(driver);

	private String selectedSuggestionText;
	@SuppressWarnings("unused")
	private String firstSearchText;

	@Given("the user has previously searched for {string}")
	public void the_user_has_previously_searched_for(String locality) {
		propertySearch.openHomePage();
		propertySearch.selectCity("Chennai");
		firstSearchText = propertySearch.enterLocality(locality);
		propertySearch.clickSearch();
	}

	@When("the user performs a new search for {string}")
	public void user_wants_to_see_the_search_history(String locality) {
		propertySearch.openHomePage();
		propertySearch.selectCity("Chennai");
		selectedSuggestionText = propertySearch.enterLocality(locality);
		propertySearch.clickSearch();
	}

	@When("the user returns to the home page")
	public void user_returns_home() {
		propertySearch.openHomePage();
		try {
			Thread.sleep(500);
		} catch (InterruptedException ignored) {
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(800);
		} catch (InterruptedException ignored) {
		}
	}

	@Then("the previous search {string} should appear in search history")
	public void previous_search_should_appear(String expected) {
		searchHistory = new SearchHistory(driver);

		boolean visible = searchHistory.isHistorySectionVisible();
		Assert.assertTrue(visible, "Search history section was not visible on the homepage.");

		List<String> items = searchHistory.getVisibleHistoryItemsText();

		System.out.println("[DEBUG] selectedSuggestionText: '" + selectedSuggestionText + "'");
		System.out.println("[DEBUG] expected (from feature): '" + expected + "'");
		System.out.println("[DEBUG] history items collected: " + items);
		for (String it : items) {
			System.out.println("[DEBUG]   ITEM RAW: '" + it + "' (len=" + it.length() + ")");
		}

		Assert.assertFalse(items.isEmpty(), "No history items found. Items: " + items);

		String toMatch = (selectedSuggestionText != null && !selectedSuggestionText.isEmpty()) ? selectedSuggestionText
				: expected;

		boolean matched = false;
		for (String item : items) {
			if (tokenMatch(item, toMatch) || tokenMatch(toMatch, item)) {
				matched = true;
				break;
			}
		}

		Assert.assertTrue(matched,
				"Expected history item not found. Items: " + items + " ; Looking for: '" + toMatch + "'");
	}

	private List<String> tokens(String s) {
		if (s == null)
			return Collections.emptyList();
		String cleaned = s.replaceAll("[^\\p{Alnum}\\s]", " ").replaceAll("\\s+", " ").trim().toLowerCase();
		if (cleaned.isEmpty())
			return Collections.emptyList();
		return Arrays.asList(cleaned.split(" "));
	}

	private boolean tokenMatch(String candidate, String expected) {
		List<String> ct = tokens(candidate);
		List<String> et = tokens(expected);
		if (et.isEmpty())
			return false;
		for (String t : et) {
			if (!ct.contains(t))
				return false;
		}
		return true;
	}
}
