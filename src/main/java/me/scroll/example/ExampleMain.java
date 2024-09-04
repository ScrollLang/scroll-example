package me.scroll.example;

import org.scrolllang.scroll.ScrollAddon;
import org.scrolllang.scroll.ScrollRegistration;

import net.fabricmc.api.ModInitializer;

public class ExampleMain extends ScrollAddon implements ModInitializer {

	private static ScrollRegistration REGISTRATION;
	private static ExampleMain INSTANCE;
	private ScrollAddon ADDON_INSTANCE;

	public ExampleMain() {
		super("Example");
		if (INSTANCE == null) {
			INSTANCE = this;
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void onInitialize() {
		
	}

	/*
	 * This method is called by the skript-parser if the addon
	 * was placed in the addons folder.
	 */
	public void initAddon() {
		onInitialize();
	}

	@Override
	protected void startRegistration(ScrollRegistration registration) {
		if (REGISTRATION != null || registration == null)
			throw new IllegalStateException();

		REGISTRATION = registration;
		loadClasses("me.scroll.example", "elements");
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
