package me.scrolllang.example;

import java.io.IOException;
import java.util.Optional;

import org.scrolllang.scroll.Scroll;
import org.scrolllang.scroll.ScrollAddon;
import org.scrolllang.scroll.ScrollRegistration;

import io.github.syst3ms.skriptparser.types.Type;
import io.github.syst3ms.skriptparser.types.TypeManager;
import io.github.syst3ms.skriptparser.types.comparisons.Comparator;
import io.github.syst3ms.skriptparser.types.comparisons.Comparators;
import io.github.syst3ms.skriptparser.types.comparisons.Relation;
import net.fabricmc.api.ModInitializer;

public class ExampleMain extends ScrollAddon implements ModInitializer {

	private static ScrollRegistration REGISTRATION;
	private static ExampleMain INSTANCE;
	private ScrollAddon ADDON_INSTANCE;

	public ExampleMain() {
		super("example");
		if (INSTANCE == null) {
			INSTANCE = this;
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void onInitialize() {
		
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void startRegistration(ScrollRegistration registration) {
		if (REGISTRATION != null || registration == null)
			throw new IllegalStateException();

		REGISTRATION = registration;
		loadClasses("me.scrolllang.example", "elements");
	}

	/**
	 * To only be used be scroll-reflect.
	 * 
	 * @return ScrollRegistration registered to scroll-reflect.
	 */
	public static ScrollRegistration getRegistration() {
		return REGISTRATION;
	}

	public static ExampleMain getInstance() {
		if (INSTANCE == null)
			throw new IllegalStateException();
		return INSTANCE;
	}

	public ScrollAddon getAddonInstance() {
		if (ADDON_INSTANCE == null)
			throw new IllegalStateException();
		return ADDON_INSTANCE;
	}

}
