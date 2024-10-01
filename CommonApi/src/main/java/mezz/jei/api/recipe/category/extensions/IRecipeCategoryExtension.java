package mezz.jei.api.recipe.category.extensions;

import com.mojang.blaze3d.platform.InputConstants;
import mezz.jei.api.gui.builder.IRecipeSlotBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotRichTooltipCallback;
import mezz.jei.api.gui.inputs.IJeiInputHandler;
import mezz.jei.api.gui.inputs.IJeiUserInput;
import mezz.jei.api.gui.widgets.IRecipeExtrasBuilder;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;

import java.util.Collections;
import java.util.List;

/**
 * An extension to a recipe category with methods that allow JEI to make sense of it.
 * Plugins implement these for recipe categories that support it, for each type of recipe they have.
 */
public interface IRecipeCategoryExtension {

	/**
	 * Draw additional info about the recipe.
	 * Use the mouse position for things like button highlights.
	 * Tooltips are handled by {@link #getTooltipStrings(double, double)}
	 *
	 * @param mouseX the X position of the mouse, relative to the recipe.
	 * @param mouseY the Y position of the mouse, relative to the recipe.
	 * @see IDrawable for a simple class for drawing things.
	 * @see IGuiHelper for useful functions.
	 */
	default void drawInfo(int recipeWidth, int recipeHeight, GuiGraphics guiGraphics, double mouseX, double mouseY) {

	}

	/**
	 * Get the tooltip for whatever is under the mouse.
	 * ItemStack and fluid tooltips are already handled by JEI, this is for anything else.
	 *
	 * To add to ingredient tooltips, see {@link IRecipeSlotBuilder#addRichTooltipCallback(IRecipeSlotRichTooltipCallback)}
	 * To add tooltips for a recipe category, see {@link IRecipeCategory#getTooltip}
	 *
	 * @param mouseX the X position of the mouse, relative to the recipe.
	 * @param mouseY the Y position of the mouse, relative to the recipe.
	 * @since 15.8.4
	 */
	default void getTooltip(ITooltipBuilder tooltip, double mouseX, double mouseY) {
		tooltip.addAll(getTooltipStrings(mouseX, mouseY));
	}

	/**
	 * Get the tooltip for whatever is under the mouse.
	 * ItemStack and fluid tooltips are already handled by JEI, this is for anything else.
	 *
	 * To add to ingredient tooltips, see {@link IRecipeSlotBuilder#addRichTooltipCallback(IRecipeSlotRichTooltipCallback)}
	 * To add tooltips for a recipe category, see {@link IRecipeCategory#getTooltip}
	 *
	 * @param mouseX the X position of the mouse, relative to the recipe.
	 * @param mouseY the Y position of the mouse, relative to the recipe.
	 * @return tooltip strings. If there is no tooltip at this position, return an empty list.
	 */
	@Deprecated(since = "15.8.4", forRemoval = true)
	default List<Component> getTooltipStrings(double mouseX, double mouseY) {
		return Collections.emptyList();
	}

	/**
	 * Called when a player inputs while hovering over the recipe.
	 * Useful for implementing buttons, hyperlinks, and other interactions to your recipe.
	 *
	 * @param mouseX the X position of the mouse, relative to the recipe.
	 * @param mouseY the Y position of the mouse, relative to the recipe.
	 * @param input  the current input from the player.
	 * @return true if the input was handled, false otherwise
	 * @since 8.3.0
	 *
	 * @deprecated create a {@link IJeiInputHandler} to handle inputs using {@link IRecipeExtrasBuilder#addInputHandler}, then
	 * use {@link IJeiInputHandler#handleInput(double, double, IJeiUserInput)}
	 */
	@Deprecated(since = "15.9.0", forRemoval = true)
	default boolean handleInput(double mouseX, double mouseY, InputConstants.Key input) {
		return false;
	}
}
