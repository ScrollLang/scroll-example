package me.scrolllang.example;

import org.scrolllang.scroll.ScrollAddon;
import org.scrolllang.scroll.ScrollRegistration;

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
	protected void startRegistration(ScrollRegistration registration) {
		if (REGISTRATION != null || registration == null)
			throw new IllegalStateException();

		REGISTRATION = registration;
		loadClasses("me.scrolllang.example", "elements");
	}

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
