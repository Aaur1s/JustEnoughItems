package mezz.jei.api.recipe.category.extensions.vanilla.smithing;

import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.gui.builder.IIngredientAcceptor;
import mezz.jei.api.recipe.category.extensions.IRecipeCategoryExtension;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import net.minecraft.world.item.crafting.SmithingRecipe;

/**
 * Implement this interface instead of just {@link IRecipeCategoryExtension}
 * to have your recipe extension work as part of {@link RecipeTypes#SMITHING} recipe.
 *
 * Register this extension by getting the extendable crafting category from:
 * {@link IVanillaCategoryExtensionRegistration#getSmithingCategory()}
 * and then registering it with {@link IExtendableSmithingRecipeCategory#addExtension(Class, ISmithingCategoryExtension)}.
 *
 * @since 15.12.0
 */
public interface ISmithingCategoryExtension<R extends SmithingRecipe> {
	/**
	 * Set the template ingredient for the recipe.
	 *
	 * For example, see
	 * {@link net.minecraft.world.item.crafting.SmithingTrimRecipe#template}
	 * {@link net.minecraft.world.item.crafting.SmithingTransformRecipe#template}
	 *
	 * @since 15.12.0
	 */
	<T extends IIngredientAcceptor<T>> void setTemplate(R recipe, T ingredientAcceptor);

	/**
	 * Set the base ingredient for the recipe.
	 *
	 * For example, see
	 * {@link net.minecraft.world.item.crafting.SmithingTrimRecipe#base}
	 * {@link net.minecraft.world.item.crafting.SmithingTransformRecipe#base}
	 *
	 * @since 15.12.0
	 */
	<T extends IIngredientAcceptor<T>> void setBase(R recipe, T ingredientAcceptor);

	/**
	 * Set the addition ingredient for the recipe.
	 *
	 * For example, see
	 * {@link net.minecraft.world.item.crafting.SmithingTrimRecipe#addition}
	 * {@link net.minecraft.world.item.crafting.SmithingTransformRecipe#addition}
	 *
	 * @since 15.12.0
	 */
	<T extends IIngredientAcceptor<T>> void setAddition(R recipe, T ingredientAcceptor);
}
