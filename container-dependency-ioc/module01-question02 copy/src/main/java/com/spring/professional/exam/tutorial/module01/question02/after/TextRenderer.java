package com.spring.professional.exam.tutorial.module01.question02.after;

import com.spring.professional.exam.tutorial.module01.question02.common.renderer.Renderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.DefaultColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.color.FontColorRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.DefaultFontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.style.FontStyleRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.DefaultFontWeightRenderer;
import com.spring.professional.exam.tutorial.module01.question02.common.renderer.weight.FontWeightRenderer;

class TextRenderer {

    private final FontStyleRenderer fontStyleRenderer;
    private final FontColorRenderer fontColorRenderer;
    private final FontWeightRenderer fontWeightRenderer;

    TextRenderer(
            FontStyleRenderer fontStyleRenderer,
            FontColorRenderer fontColorRenderer,
            FontWeightRenderer fontWeightRenderer) {
        this.fontStyleRenderer = fontStyleRenderer;
        this.fontColorRenderer = fontColorRenderer;
        this.fontWeightRenderer = fontWeightRenderer;
    }

    void render(String text) {
        String renderedText = applyRendering(text, fontStyleRenderer, fontColorRenderer, fontWeightRenderer);
        System.out.println(renderedText);
    }

    private String applyRendering(String text, Renderer... renderers) {
        for (Renderer renderer : renderers) {
            // Les implémentations de render retourne une string
            text = renderer.render(text);
        }
        return text;
    }

    static class TextRendererBuilder {

        // Interfaces implementations
        private FontStyleRenderer fontStyleRenderer = new DefaultFontStyleRenderer();
        private FontColorRenderer fontColorRenderer = new DefaultColorRenderer();
        private FontWeightRenderer fontWeightRenderer = new DefaultFontWeightRenderer();

        public TextRendererBuilder withFontStyleRenderer(FontStyleRenderer fontStyleRenderer) {
            this.fontStyleRenderer = fontStyleRenderer;
            return this;
        }

        public TextRendererBuilder withFontColorRenderer(FontColorRenderer fontColorRenderer) {
            this.fontColorRenderer = fontColorRenderer;
            return this;
        }

        public TextRendererBuilder withFontWeightRenderer(FontWeightRenderer fontWeightRenderer) {
            this.fontWeightRenderer = fontWeightRenderer;
            return this;
        }

        public TextRenderer build() {
            return new TextRenderer(fontStyleRenderer, fontColorRenderer, fontWeightRenderer);
        }
    }
}
