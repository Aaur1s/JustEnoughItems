package mezz.jei.api;

import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.registration.IIngredientAliasRegistration;
import mezz.jei.api.registration.IModInfoRegistration;
import mezz.jei.api.registration.IRuntimeRegistration;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import net.minecraft.resources.ResourceLocation;

import mezz.jei.api.registration.IAdvancedRegistration;
import mezz.jei.api.registration.IExtraIngredientRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IModIngredientRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import mezz.jei.api.runtime.IJeiRuntime;

/**
 * The main class to implement to create a JEI plugin. Everything communicated between a mod and JEI is through this class.
 * IModPlugins must have the {@link JeiPlugin} annotation to get loaded by JEI.
 */
public interface IModPlugin {

	/**
	 * The unique ID for this mod plugin.
	 * The namespace should be your mod's modId.
	 */
	ResourceLocation getPluginUid();

	/**
	 * If your item has subtypes that depend on NBT or capabilities, use this to help JEI identify those subtypes correctly.
	 */
	default void registerItemSubtypes(ISubtypeRegistration registration) {

	}

	/**
	 * If your fluid has subtypes that depend on NBT or capabilities,
	 * use this to help JEI identify those subtypes correctly.
	 *
	 * @since 10.1.0
	 */
	default <T> void registerFluidSubtypes(ISubtypeRegistration registration, IPlatformFluidHelper<T> platformFluidHelper) {

	}

	/**
	 * Register special ingredients, beyond the basic ItemStack and FluidStack.
	 */
	default void registerIngredients(IModIngredientRegistration registration) {

	}

	/**
	 * Register extra ItemStacks that are not in the creative menu,
	 * or FluidStacks that are different from the default ones available via the fluid registry.
	 *
	 * @since 19.18.0
	 */
	default void registerExtraIngredients(IExtraIngredientRegistration registration) {

	}

	/**
	 * Register search aliases for ingredients.
	 *
	 * @implNote If the player has disabled search aliases in the config, this will not be called.
	 *
	 * @since 19.10.0
	 */
	default void registerIngredientAliases(IIngredientAliasRegistration registration) {

	}

	/**
	 * Register extra info about a mod, such as aliases for the mod that users can search for.
	 *
	 * @since 17.1.0
	 */
	default void registerModInfo(IModInfoRegistration modAliasRegistration) {

	}

	/**
	 * Register the categories handled by this plugin.
	 * These are registered before recipes so they can be checked for validity.
	 */
	default void registerCategories(IRecipeCategoryRegistration registration) {

	}

	/**
	 * Register modded extensions to the vanilla crafting recipe category.
	 * Custom crafting recipes for your mod should use this to tell JEI how they work.
	 */
	default void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {

	}

	/**
	 * Register modded recipes.
	 */
	default void registerRecipes(IRecipeRegistration registration) {

	}

	/**
	 * Register recipe transfer handlers (move ingredients from the inventory into crafting GUIs).
	 */
	default void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {

	}

	/**
	 * Register recipe catalysts.
	 * Recipe Catalysts are ingredients that are needed in order to craft other things.
	 * Vanilla examples of Recipe Catalysts are the Crafting Table and Furnace.
	 */
	default void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {

	}

	/**
	 * Register various GUI-related things for your mod.
	 * This includes adding clickable areas in your guis to open JEI,
	 * and adding areas on the screen that JEI should avoid drawing.
	 */
	default void registerGuiHandlers(IGuiHandlerRegistration registration) {

	}

	/**
	 * Register advanced features for your mod plugin.
	 */
	default void registerAdvanced(IAdvancedRegistration registration) {

	}

	/**
	 * Override the default JEI runtime.
	 */
	default void registerRuntime(IRuntimeRegistration registration) {

	}

	/**
	 * Called when JEI's runtime features are available, after all mods have registered.
	 */
	default void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

	}

	/**
	 * Called when JEI's runtime features are no longer available, after a user quits or logs out of a world.
	 * @since 11.5.0
	 */
	default void onRuntimeUnavailable() {

	}

	/**
	 * Called when JEI's configs are available.
	 * This is called early on, as soon as configs are available.
	 * @since 12.3.0
	 */
	default void onConfigManagerAvailable(IJeiConfigManager configManager) {

	}
}
