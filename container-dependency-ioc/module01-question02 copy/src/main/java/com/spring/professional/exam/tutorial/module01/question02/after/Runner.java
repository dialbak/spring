package com.spring.professional.exam.tutorial.module01.question02.after;

import com.spring.professional.exam.tutorial.module01.question02.after.TextRenderer.TextRendererBuilder;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.RedColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.BoldFontWeightRenderer;

public class Runner {
    public static void main(String[] args) {

        // build() retourne le constructeur de TextRenderer avec les implémentations des interfaces qui herite de Renderer
        TextRenderer textRenderer = new TextRendererBuilder().build();
        textRenderer.render("Default Rendering");

        TextRenderer redRenderer = new TextRendererBuilder()
                .withFontColorRenderer(new RedColorRenderer())
                .build();
        redRenderer.render("Red Color Rendering");

        TextRenderer boldRenderer = new TextRendererBuilder()
                .withFontWeightRenderer(new BoldFontWeightRenderer())
                .build();
        boldRenderer.render("Bold Rendering");
    }
}
